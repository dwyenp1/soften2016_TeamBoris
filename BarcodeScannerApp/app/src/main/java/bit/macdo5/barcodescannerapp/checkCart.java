package bit.macdo5.barcodescannerapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class checkCart extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_cart);
    }
    public void onClick(View v) {
        if(v.getId()==R.id.btnReturn) {
            /*
            Pass the pizza list back here
            http://stackoverflow.com/questions/1124548/how-to-pass-the-values-from-one-activity-to-previous-activity
             */
            /*TODO: fix this
            resultIntent = new Intent(null);
            resultIntent.putExtra(PUBLIC_STATIC_STRING_IDENTIFIER, enteredTextValue);
            setResult(Activity.RESULT_OK, resultIntent);
            finish();
             */
        }
        if(v.getId()==R.id.btnDelete) {
            /*
            Pass the pizza list back here
             */
            finish();
        }
    }
}
