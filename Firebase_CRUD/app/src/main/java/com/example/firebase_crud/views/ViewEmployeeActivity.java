package com.example.firebase_crud.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import com.example.firebase_crud.R;
import com.example.firebase_crud.adapter.EmployeeAdapter;
import com.example.firebase_crud.model.Employee;
import com.example.firebase_crud.util.FirebaseConstants;
import com.example.firebase_crud.util.WrapLinearLayoutManager;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;


//DOCUMENTATION : https://firebaseopensource.com/projects/firebase/firebaseui-android/database/readme
public class ViewEmployeeActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EmployeeAdapter viewEmployeeAdapter;
    private FloatingActionButton addemployeebutton;
    private FloatingActionButton searchemployeebutton;

    // This method is called when the activity is first created.
    // It initializes the UI components, connects to Firebase Realtime Database, and attaches listeners.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_employee);
        init();  // Initialize UI components
        connectToFirebaseRTDB();  // Connect to Firebase Realtime Database
        attachListeners();  // Attach click listeners to buttons
    }

    // Initialize the main RecyclerView, set its layout manager, and initialize buttons.
    private void init() {
        recyclerView = findViewById(R.id.employee_recyclerView);
        recyclerView.setLayoutManager(new WrapLinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        addemployeebutton = findViewById(R.id.addemployeebutton);
        searchemployeebutton = findViewById(R.id.searchemployeebutton);
    }

    // Attach click listeners to buttons for adding or searching employees.
    private void attachListeners() {
        addemployeebutton.setOnClickListener(view ->
                startActivity(new Intent(getApplicationContext(), ModifyEmployeeActivity.class)));
        searchemployeebutton.setOnClickListener(view ->
                startActivity(new Intent(getApplicationContext(), SearchActivity.class)));
    }

    // Connect to Firebase Realtime Database, retrieve employee data, and bind it to the RecyclerView using an adapter.
    private void connectToFirebaseRTDB() {
        final FirebaseRecyclerOptions<Employee> options = new FirebaseRecyclerOptions.Builder<Employee>()
                .setQuery(FirebaseDatabase.getInstance(FirebaseConstants.FIREBASE_URL)
                        .getReference()
                        .child(FirebaseConstants.EMPLOYEES_COLLECTION), Employee.class)
                .build();
        viewEmployeeAdapter = new EmployeeAdapter(options);
        recyclerView.setAdapter(viewEmployeeAdapter);
    }

    // Lifecycle method called when the activity is started.
    // Start listening for changes in the data and update the UI accordingly.
    @Override
    protected void onStart() {
        super.onStart();
        viewEmployeeAdapter.startListening();
    }

    // Lifecycle method called when the activity is stopped.
    // Stop listening for changes in the data to conserve resources.
    @Override
    protected void onStop() {
        super.onStop();
        viewEmployeeAdapter.stopListening();
    }
}