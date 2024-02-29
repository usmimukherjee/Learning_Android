package com.example.firebase_crud.views;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.firebase_crud.R;
import androidx.appcompat.app.AppCompatActivity;

import com.example.firebase_crud.model.Employee;
import com.example.firebase_crud.util.AppConstants;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class ModifyEmployeeActivity extends AppCompatActivity {
    public static final String TAG = AppConstants.TAG;
    public static final String UPDATE_EMPLOYEE_KEY = AppConstants.UPDATE_EMPLOYEE_KEY;
    public static final String UPDATE_EMPLOYEE = AppConstants.UPDATE_EMPLOYEE;
    private EditText nameET, departmentET, positionET;
    private Button addBTN, updateBTN;
    private Employee employee;
    private String employeeKey;

    /**
     * The main activity for adding or updating an employee's information.
     * This activity handles UI initialization, setting views, attaching listeners, and database interactions.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content view based on the specified layout resource
        setContentView(R.layout.activity_add_update_employee);

        // Initialize UI elements
        init();

        // Set the view based on the intent extras
        setActivityView();

        // Attach event listeners to buttons
        attachListeners();
    }

    /**
     * Initialize UI elements by finding their respective views using their resource IDs.
     */
    private void init() {
        // Getting the id of the UI elements.
        nameET = findViewById(R.id.name);
        departmentET = findViewById(R.id.department);
        positionET = findViewById(R.id.position);
        addBTN = findViewById(R.id.addBTN);
        updateBTN = findViewById(R.id.updateBtn);
    }

    /**
     * Set the activity view based on the intent extras.
     * Display buttons accordingly and populate fields for updating an existing employee.
     */
    private void setActivityView() {
        final Bundle extras = getIntent().getExtras();

        if (extras != null && extras.getString(TAG) != null) {
            final String activityPath = extras.getString(TAG);

            if (activityPath.equals(UPDATE_EMPLOYEE)) {
                // If updating, hide add button and show update button
                addBTN.setVisibility(View.GONE);
                updateBTN.setVisibility(View.VISIBLE);

                // Retrieve existing employee which is the serializable part passed in the intent held by the adapter
                employee = (com.example.firebase_crud.model.Employee) getIntent().getSerializableExtra(com.example.firebase_crud.model.Employee.TAG);
                employeeKey = extras.getString(UPDATE_EMPLOYEE_KEY);
                nameET.setText(employee.getName());
                departmentET.setText(employee.getDepartment());
                positionET.setText(employee.getPosition());
            } else {
                // If adding, hide update button and show add button
                updateBTN.setVisibility(View.GONE);
                addBTN.setVisibility(View.VISIBLE);
            }
        } else {
            // If no extras, default to add view
            updateBTN.setVisibility(View.GONE);
            addBTN.setVisibility(View.VISIBLE);
        }
    }

    /**
     * Attach listeners to the add and update buttons.
     */
    private void attachListeners() {
        addBTN.setOnClickListener(view -> addDataToFRTD());
        updateBTN.setOnClickListener(view -> updateDataToFRTD());
    }

    /**
     * Add employee data to Firebase Realtime Database.
     */
    private void addDataToFRTD() {
        // Create a hashmap of employee properties
        Map<String, Object> map = new HashMap<>();
        map.put("name", nameET.getText().toString());
        map.put("department", departmentET.getText().toString());
        map.put("position", positionET.getText().toString());


        // Push data to Firebase Realtime Database
        FirebaseDatabase.getInstance(com.example.firebase_crud.util.FirebaseConstants.FIREBASE_URL)
                .getReference()
                .child(com.example.firebase_crud.util.FirebaseConstants.EMPLOYEES_COLLECTION)
                .push()
                .setValue(map)
                .addOnSuccessListener(aVoid -> {
                    Toast.makeText(getApplicationContext(), "Employee added successfully", Toast.LENGTH_SHORT).show();
                    finish();
                })
                .addOnFailureListener(e ->
                        Toast.makeText(getApplicationContext(), "Employee insertion failed", Toast.LENGTH_SHORT).show());
    }

    /**
     * Update existing employee data in Firebase Realtime Database.
     */
    private void updateDataToFRTD() {
        // Create a hashmap of updated employee properties
        Map<String, Object> map = new HashMap<>();
        map.put("name", nameET.getText().toString());
        map.put("department", departmentET.getText().toString());
        map.put("position", positionET.getText().toString());

        // Update data in Firebase Realtime Database using the employee's key
        FirebaseDatabase.getInstance(com.example.firebase_crud.util.FirebaseConstants.FIREBASE_URL)
                .getReference()
                .child(com.example.firebase_crud.util.FirebaseConstants.EMPLOYEES_COLLECTION)
                .child(employeeKey)
                .updateChildren(map)
                .addOnSuccessListener(aVoid -> {
                    Toast.makeText(getApplicationContext(), "Employee updated successfully", Toast.LENGTH_SHORT).show();
                    finish();
                })
                .addOnFailureListener(e ->
                        Toast.makeText(getApplicationContext(), "Employee update failed", Toast.LENGTH_SHORT).show());
    }

    /**
     * Clean up resources when the activity is destroyed.
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish(); // Finish the activity to prevent memory leaks
    }

}
