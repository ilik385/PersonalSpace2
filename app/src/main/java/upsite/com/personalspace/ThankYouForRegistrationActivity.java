package upsite.com.personalspace;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ThankYouForRegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thank_you_for_registration);
    }

    public void onGoButtonClick(View view) {
        Intent intent = new Intent(this, UserProfileActivity.class);
        startActivity(intent);
    }


}
