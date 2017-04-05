package upsite.com.personalspace;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ThankYouForRegistrationActivity extends Activity {

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
