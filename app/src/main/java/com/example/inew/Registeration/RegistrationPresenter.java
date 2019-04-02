package com.example.inew.Registeration;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.example.inew.LogIn.LogInActivity;
import com.example.inew.splash.splashActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.support.constraint.Constraints.TAG;

public class RegistrationPresenter implements IRegistPresenter {
    private FirebaseAuth mAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private Context context;
    public RegistrationPresenter(Context context){
    this.context=context;
        intializeFields();

    }

    @Override
    public void intializeFields() {
        mAuth = FirebaseAuth.getInstance();
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference().child("Users").push();
    }


    @Override
    public void createNewUser(final String email, final String Password) {

        mAuth.createUserWithEmailAndPassword(email, Password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "create9UserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUserToFireBase(email,Password);
                            sendUserToLoginActivity();

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());

                           // lol();
                        }

                        // ...
                    }
                });



    }

     private void sendUserToLoginActivity() {
        Intent i = new Intent (context, splashActivity.class);
        context.startActivity(i);
    }

    @Override
    public void updateUserToFireBase(String email, String password) {
        databaseReference.child("email").setValue(email);
        databaseReference.child("password").setValue(password);
    }



}
