package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * public class MainActivity extends AppCompatActivity {
 *
 * @Override protected void onCreate(Bundle savedInstanceState) {
 * super.onCreate(savedInstanceState);
 * setContentView(R.layout.activity_main);
 * }
 * }
 * <p>
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 * <p>
 * package com.example.android.justjava;
 */
/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava;
 */

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int quantity = 0;


    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        //String priceMessage = "The total charge for "+quantity+" cups of coffee is: "+calculate(quantity)+"$";
        //displayMessage(priceMessage);


        CheckBox checky = (CheckBox) findViewById(R.id.whipped_checkbox);
        boolean b_man = checky.isChecked();
        CheckBox becky = (CheckBox) findViewById(R.id.choco_checkbox);
        boolean c_man = becky.isChecked();
        CheckBox decky = (CheckBox) findViewById(R.id.danish_checkbox);
        boolean d_man = decky.isChecked();

        EditText eddy = (EditText) findViewById(R.id.enter_text);
        String d_name = eddy.getText().toString();

        int price = 13;

        if (b_man == true){
            price += 2;
        }
        if (c_man == true){
            price += 5;
        }

        if (d_man == true){
            price += 8;
        }

        //String OrderSummary = "Name : Anumey \nQuantity : " + quantity + "\nAdd whipped cream?" + result + "\nTotal cost : $"+calculate(quantity) + "\nThank You for choosing Just Java.";

        String OrderSummary = createOrderSummary(price,b_man,c_man, d_man, d_name);
        displayMessage(OrderSummary);

        Toast.makeText(this,"What what?", Toast.LENGTH_LONG).show();


        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "JustJava Order Summary For " + d_name);
        intent.putExtra(Intent.EXTRA_TEXT,OrderSummary);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

//        Intent intest = new Intent(Intent.ACTION_VIEW);
//        intest.setClassName("com.google.android.gm", "com.google.android.gm.ConversationListActivity");
//        startActivity(intest);

//        Intent mailClient = new Intent(Intent.ACTION_VIEW);
//        mailClient.setClassName("com.google.android.gm", "com.google.android.gm.ConversationListActivity");
//        startActivity(mailClient);




        //displayPrice(quantity*5);
    }






    public String createOrderSummary(int price,boolean b_man, boolean c_man, boolean d_man, String d_name){
        String priceMessage = "Name: " + d_name;
        priceMessage += "\nQuantity: " + quantity;
        priceMessage += "\nAdd Whipped Cream? " + b_man;
        priceMessage += "\nAdd Chocolate Syrup? " + c_man;
        priceMessage += "\nAdd Danish Mix? " + d_man;
        priceMessage += "\nTotal: $" + quantity*price;
        priceMessage += "\nThank you for using JustJava.";
        return priceMessage;


    }





    public void increment(View view){
        quantity++;
        if (quantity > 10){
            quantity = 10;
        }
        display(quantity);

    }

    //Toast toast = new Toast.makeText(this,"Come again. :D", Toast.LENGTH_LONG);

    public void decrement(View view){
        quantity--;
        if (quantity < 1){
            quantity = 0;
        }
        display(quantity);

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view1);
        quantityTextView.setText("" + number);
    }

    private void displayMessage(String message) {
        TextView orderTextView = (TextView) findViewById(R.id.order_summary_view);
        orderTextView.setText(message);
    }


}