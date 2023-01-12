package com.example.yum1;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.annotation.Nullable;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Database {
    //variables
    private FirebaseFirestore db;

    //Constructor
    public Database() {
        db = FirebaseFirestore.getInstance();
    }

//User

    //Create/Update
    public void updateUser(User user) {
        db.collection("users").document(user.getUid()).set(user);
    }

    //Read
    public void readUser(String uid) {
        final DocumentReference docRef = db.collection("users").document(uid);
        docRef.addSnapshotListener(new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot snapshot,
                                @Nullable FirebaseFirestoreException e) {
                if (e != null) {
                    //Log.w(TAG, "Listen failed.", e);
                    return;
                }

                if (snapshot != null && snapshot.exists()) {
                    //update Global user
                    User user = snapshot.toObject(User.class);
                    Globals.user = user;

                } else {
                    //Log.d(TAG, "Current data: null");
                }
            }
        });
    }


//Restaurant

    //Read
    public void readRestaurants() {
        Log.d(TAG, "Restaurants list count 1: " + Globals.restaurants.size());
        db.collection("restaurants")
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value,
                                        @Nullable FirebaseFirestoreException e) {
                        if (e != null) {
                            //Log.w(TAG, "Listen failed.", e);
                            return;
                        }
                        //empty list to fill up
                        ArrayList<Restaurant> restaurants = new ArrayList<>();
                        //add one by one
                        for (QueryDocumentSnapshot doc : value) {
                            if (doc.get("name") != null) {
                                restaurants.add(doc.toObject(Restaurant.class));

                            }
                        }
                        Globals.restaurants = restaurants;
                        Log.d(TAG, "Restaurants list count 2: " + Globals.restaurants.size());
                    }
                });
    }

    //Update Restaurant - Reviews
    public void updateRestaurant (String id, String data)
    {
        DocumentReference washingtonRef = db.collection("restaurants").document(id);
        washingtonRef.update("reviews", FieldValue.arrayUnion(data));
    }
}
