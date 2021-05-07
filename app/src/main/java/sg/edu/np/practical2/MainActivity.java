package sg.edu.np.practical2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = "Main Activity";
    private String randomNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG, "On Create");

        User user1 = new User("John", "Test", 1, false);

        Button follow = findViewById(R.id.follow);
        Button message = findViewById(R.id.message);
        String followedText = "Followed";
        String unfollowedText = "Unfollowed";

        Intent receivedData = getIntent();
        randomNum = receivedData.getStringExtra("randomNumber");
        TextView text = findViewById(R.id.textView);
        text.setText("MAD " + randomNum);

        follow.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if (user1.followed == false){
                    follow.setText("UNFOLLOW");
                    Toast toast = Toast.makeText(MainActivity.this, followedText, Toast.LENGTH_SHORT);
                    toast.show();
                    Log.v(TAG, "Followed");
                    user1.setFollowed(true);
                }
                else if (user1.followed == true){
                    follow.setText("FOLLOW");
                    Toast toast2 = Toast.makeText(MainActivity.this, unfollowedText, Toast.LENGTH_SHORT);
                    toast2.show();
                    Log.v(TAG, "Unfollowed");
                    user1.setFollowed(false);
                }
            }
        }
        );
    }

}
