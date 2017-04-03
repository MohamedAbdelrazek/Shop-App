package mohamedabdelrazek.com.ginger;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import mohamedabdelrazek.com.ginger.adapters.CartAdapter;
import mohamedabdelrazek.com.ginger.data.CartDbHelper;

public class CartActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;
    CartAdapter cartAdapter;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        textView= (TextView) findViewById(R.id.car_total_price);
        button= (Button) findViewById(R.id.cart_button_check_out);
        CartDbHelper DbHelper = new CartDbHelper(getBaseContext());
        DbHelper.open();
        final ArrayList<byte[]> users = DbHelper.retrieveUserDetails();
        DbHelper.close();
        mRecyclerView = (RecyclerView) findViewById(R.id.cart_recycler_view);
        cartAdapter = new CartAdapter(this, users);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(cartAdapter);
        textView.setText(""+users.size()*5+"$");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CartActivity.this, "Send to maail !", Toast.LENGTH_SHORT).show();

                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto","ahmedfci2018@gmail.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Shopping List App");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Team Number: 6 \n This Item is Awesome !\n Total price :"+users.size()*5);
                startActivity(Intent.createChooser(emailIntent, "Send email..."));

            }
        });

    }
}
