package com.example.firebase_crud.views;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.firebase_crud.R;
import com.example.firebase_crud.model.Employee;
import com.example.firebase_crud.util.FirebaseConstants;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class SearchActivity extends AppCompatActivity {


    private EditText searchByNameET;
    private Button searchBtn;
    private TextView nameTV;
    private TextView departmentTV;
    private TextView positionTV;
    private DatabaseReference firebaseDBRef;

    // This method is called when the activity is first created.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the layout for this activity using the specified XML layout resource.
        setContentView(R.layout.activity_search);

        // Initialize UI elements and Firebase reference.
        init();
        initFirebaseRef();

        // Set listeners for UI elements.
        setListeners();
    }

    // Initialize UI elements by finding their respective views in the layout.
    private void init() {
        searchByNameET = findViewById(R.id.searchByName);
        searchBtn = findViewById(R.id.searchBtn);
        nameTV = findViewById(R.id.name);
        departmentTV = findViewById(R.id.department);
        positionTV = findViewById(R.id.position);
    }

    // Initialize Firebase Database reference using the constant FIREBASE_URL.
    private void initFirebaseRef() {
        firebaseDBRef = FirebaseDatabase.getInstance(FirebaseConstants.FIREBASE_URL).getReference();
    }

    // Set a click listener for the search button to initiate employee search.

    /**
     *
     */

    private void setListeners() {
        searchBtn.setOnClickListener(view -> {
            // Get the search query from the EditText.
            final String searchByNameString = searchByNameET.getText().toString();

            // Check if the search query is not empty before initiating the search.
            if (!searchByNameString.trim().isEmpty()) {
                // Call the method to retrieve employee information based on the search query.
                getEmployee(searchByNameString);
            }
        });
    }

    /**
     * @param searchByNameString
     */
    // Retrieve employee information from Firebase Database based on the provided name.
    private void getEmployee(String searchByNameString) {
        // Create a query to find the employee by name in the Firebase Database.
        final Query nameQuery = firebaseDBRef.child(FirebaseConstants.EMPLOYEES_COLLECTION)
                .orderByChild("name")
                .equalTo(searchByNameString);

        // Add a listener to the query for handling the result.
        nameQuery.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // Check if the result exists and contains data.
                if (snapshot.exists() && snapshot.getChildrenCount() > 0) {
                    final Employee employee;

                    // Loop through the result to extract the employee information.
                    for (DataSnapshot currentSnapShot : snapshot.getChildren()) {
                        employee = currentSnapShot.getValue(Employee.class);

                        // Update the UI with the retrieved employee information.
                        if (employee != null) {
                            nameTV.setText(String.format("Name: %s", employee.getName()));
                            departmentTV.setText(String.format("Department: %s", employee.getDepartment()));
                            positionTV.setText(String.format("Position: %s", employee.getPosition()));
                        }

                        // Break out of the loop after processing the first result (assuming unique names).
                        break;
                    }
                }
            }

            // Handle errors or interruptions during the database query.
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("SearchActivity", error.getMessage());
            }
        });
    }
}
