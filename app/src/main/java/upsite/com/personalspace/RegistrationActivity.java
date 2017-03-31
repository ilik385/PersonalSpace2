package upsite.com.personalspace;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class RegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
    }

    public void onSingUpButtonClick(View view) {
        Intent intent = new Intent(this, ThankYouForRegistrationActivity.class);
        startActivity(intent);
    }
}
