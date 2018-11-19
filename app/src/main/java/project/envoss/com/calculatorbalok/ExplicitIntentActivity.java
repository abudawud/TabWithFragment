package project.envoss.com.calculatorbalok;

import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class ExplicitIntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_intent);
    }

    public void dialPhone(View view){
        Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK) {
            switch (requestCode) {
                case 1: {
                    Uri uri = data.getData();
                    Log.d("X-LOG", "onActivityResult: " + uri.toString());
                    break;
                }
            }
        }
    }

    public void shareMe(View view){

    }

    public void openMap(View view){

    }

    public void sendSMS(View view){
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms: 085205225932"));
        Uri uri = Uri.parse("hello");
        Model model = new Model();

        intent.putExtra("uri", uri);
        intent.putExtra("MSG", "Assalamu'alaikum akhi");
        startActivity(intent);
    }

    protected class Model{

    }
}
