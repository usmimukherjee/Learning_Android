package com.example.firebase_crud.adapter;
import com.example.firebase_crud.R;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firebase_crud.util.FirebaseConstants;
import com.example.firebase_crud.views.ModifyEmployeeActivity;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.example.firebase_crud.model.Employee;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

//this class extends the firebase recycler adapter, it is the main class that is bound to the recycler view, binds to the UI,
//has 2 arguments - the model(structure of the db) and the view.
//if you have another model - you'll add the model and the view to the adapter
public class EmployeeAdapter extends FirebaseRecyclerAdapter<Employee, EmployeeAdapter.EmployeeViewHolder>{

    // FOUR MAIN ITEMS IN THE ADAPTER CLASS


    // ONE ------------- Constructor initializing firebase recycler super class
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public EmployeeAdapter(@NonNull FirebaseRecyclerOptions<Employee> options) {
        super(options);
    }


    //------------------------------------------end-------------------------------------------

    // TWO ---------- the onCreateViewHolder method - for inflating the correct view
    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // The view holder helps in inflating the view
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.employee_item_view, parent, false);
        //view is passed to the view holder i.e the constructor above
        return new EmployeeViewHolder(view);
    }

    //------------------------------------------end-------------------------------------------


    // THREE ---------- the EmployeeViewHolder class
    public class EmployeeViewHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        private final TextView department;
        private final TextView position;
        private final Button updateBtn;
        private final Button deleteBtn;
        private final Context context;

        //this binds to the item view
        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            department = itemView.findViewById(R.id.department);
            position = itemView.findViewById(R.id.position);
            updateBtn = itemView.findViewById(R.id.updateBtn);
            deleteBtn = itemView.findViewById(R.id.deleteBtn);
            context = itemView.getContext();
        }
    }
    //------------------------------------------end-------------------------------------------


    //FOUR ---------- the onBindViewHolder method - bind the view to the db and attach to intent
    @Override
    protected void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position, @NonNull Employee employee) {
        holder.name.setText(employee.getName());
        holder.department.setText(employee.getDepartment());
        holder.position.setText(employee.getPosition());

        //update button
        holder.updateBtn.setOnClickListener(view -> {
            final Intent intent = new Intent(holder.context, ModifyEmployeeActivity.class);
            //intent helps to go from one activity to another
            //here the tag is to differentiate if the user wants to update the data or add a new data based on the button they press
            intent.putExtra(ModifyEmployeeActivity.TAG, ModifyEmployeeActivity.UPDATE_EMPLOYEE);
            //getting the values from the database
            intent.putExtra(ModifyEmployeeActivity.UPDATE_EMPLOYEE_KEY, getRef(position).getKey());
            intent.putExtra(Employee.TAG, employee);
            holder.context.startActivity(intent);
        });

        //delete button
        //here you dont need an intent, because you're directly deleting from the database
        holder.deleteBtn.setOnClickListener(view -> FirebaseDatabase.getInstance(FirebaseConstants.FIREBASE_URL)
                .getReference().child(FirebaseConstants.EMPLOYEES_COLLECTION)
                .child(getRef(position).getKey())
                .removeValue()
                .addOnSuccessListener(aVoid -> {
                    Toast.makeText(holder.context, "Employee deleted successfully", Toast.LENGTH_SHORT).show();
                })
                .addOnFailureListener(e ->
                        Toast.makeText(holder.context, "Employee delete failed", Toast.LENGTH_SHORT).show()));
    }

    //------------------------------------------end-------------------------------------------

}
