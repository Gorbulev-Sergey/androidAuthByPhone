package ru.gorbulevsv.androidauthbyphone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {
    FirebaseAuth auth;
    SharedPreferences preferences;
    TextView textPhoneOfUser;
    Button buttonLogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        auth = FirebaseAuth.getInstance();
        preferences = getSharedPreferences("preferences", MODE_PRIVATE);

        textPhoneOfUser = findViewById(R.id.textPhoneOfUser);
        if (auth.getCurrentUser() != null) {
            textPhoneOfUser.setText(textPhoneOfUser.getText() + auth.getCurrentUser().getPhoneNumber());
            buttonLogOut = findViewById(R.id.buttonLogOut);
            buttonLogOut.setOnClickListener(view -> {
                auth.signOut();
                preferences.edit().putString("userPhone","").apply();
                startActivity(new Intent(this,MainActivity.class));
            });
        }
    }
}