package com.example.firebase_crud.util;

/**
 * FirebaseConstants class contains constant values related to Firebase configuration.
 * It serves as a central place to manage Firebase-related information across the application.
 */
public class FirebaseConstants {

    // Firebase Realtime Database URL
    public static final String FIREBASE_URL = "https://fir-crud-a84eb-default-rtdb.firebaseio.com/";

    // Collection name for storing employee data in the database
    public static final String EMPLOYEES_COLLECTION = "employees";

    /**
     * Private constructor to prevent instantiation, as this class is meant to hold constants
     * and should not be instantiated. This follows the singleton pattern for constant classes.
     * An empty constructor is also required by Firebase, but it is not intended for public use.
     */
    private FirebaseConstants() {
        // No implementation needed for an empty private constructor
    }
}

