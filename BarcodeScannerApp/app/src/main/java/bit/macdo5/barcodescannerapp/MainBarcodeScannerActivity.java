package bit.macdo5.barcodescannerapp;
/**
 * Created by Oscar Macdonald on 6/08/2016.
 * Made using https://android-coffee.com/tutorial-how-to-create-barcode-reader-app-in-android-studio-1-4/
 */
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
public class MainBarcodeScannerActivity extends AppCompatActivity implements OnClickListener {
    private static int CHECK_CART_ACTIVITY_REQUEST_CODE = 10;
    private static int CONFIRM_PURCHASE_ACTIVITY_REQUEST_CODE = 20;
    private Button scanBtn; //initiates the scan app
    // the TextViews begin empty, and are filled after each scan
    private TextView formatTxt;     //the format of the code scanned last
    private TextView contentTxt;    //the content of the code (in this case the QR codes will return url)
    private TextView nameTxt;       //the name of trhe pizza (received from QR code)
    private TextView toppingsTxt;   //toppings included on the pizza
    private TextView priceTxt;      //price of the pizza
    //TODO: need something to hold list of pizzas, need a pizza class?
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_barcode_scanner);
        scanBtn = (Button)findViewById(R.id.scan_button);
        formatTxt = (TextView)findViewById(R.id.scan_format);
        contentTxt = (TextView)findViewById(R.id.scan_content);
        nameTxt = (TextView)findViewById(R.id.scan_name);
        toppingsTxt = (TextView)findViewById(R.id.scan_toppings);
        priceTxt = (TextView)findViewById(R.id.scan_price);

        scanBtn.setOnClickListener(this);
    }
    public void onClick(View v){
        if(v.getId()==R.id.scan_button){
            IntentIntegrator scanIntegrator = new IntentIntegrator(this);
            scanIntegrator.initiateScan();
        }
        if(v.getId()==R.id.btnConfirmPurchase) {
            Intent confPurchase = new Intent(this, confirmPurchase.class);
            /*
            Pass the pizza list through here
            confPurchase.putExtra(PIZZA_LIST, pizzaList);
             */
            startActivity(confPurchase);
        }
        if(v.getId()==R.id.btnCheckCart) {
            Intent checkCart = new Intent(this, checkCart.class);
            /*
            Pass the pizza list through here
            checkCart.putExtra(PIZZA_LIST, pizzaList);
             */
            startActivityForResult(checkCart, CHECK_CART_ACTIVITY_REQUEST_CODE);
        }
    }
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanningResult != null) {
            String scanContent = scanningResult.getContents();
            String scanFormat = scanningResult.getFormatName();
            formatTxt.setText("FORMAT: " + scanFormat);
            contentTxt.setText("CONTENT: " + scanContent);
            //test:
            if(scanContent.equals("9501101530003"))
            {
                contentTxt.setText("Pizza stuff");
            }
        }
        else{
            Toast toast = Toast.makeText(getApplicationContext(),
                    "No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}