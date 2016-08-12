package bit.macdo5.barcodescannerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class confirmPurchase extends AppCompatActivity implements View.OnClickListener  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_purchase);
    }
    public void onClick(View v) {
        if (v.getId() == R.id.btnReturn) {
            finish();
        }
        if (v.getId() == R.id.btnConfirm) {
            /*
            Confirm purchase and make changes in database
            number of pizzas in stock etc
             */
            finish();
        }
    }
}
