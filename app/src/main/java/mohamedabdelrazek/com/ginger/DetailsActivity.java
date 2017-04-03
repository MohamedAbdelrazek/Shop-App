package mohamedabdelrazek.com.ginger;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import mohamedabdelrazek.com.ginger.adapters.DetailsimageAdapter;
import mohamedabdelrazek.com.ginger.data.CartDbHelper;

import static mohamedabdelrazek.com.ginger.R.id.cart__button_id;

public class DetailsActivity extends AppCompatActivity {
    ImageView detailsImg;
    RecyclerView mDetailsrecycler;
    DetailsimageAdapter mdetailsimageAdapter;
    Button mCartButton;
    CartDbHelper DbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);



        mCartButton = (Button) findViewById(cart__button_id);
        final CatModel catModel = (CatModel) getIntent().getSerializableExtra(Intent.EXTRA_TEXT);
        mDetailsrecycler = (RecyclerView) findViewById(R.id.recycler_img_details);
        mdetailsimageAdapter = new DetailsimageAdapter(getBaseContext(), catModel.arrayList.get(catModel.position));
        mDetailsrecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mDetailsrecycler.setAdapter(mdetailsimageAdapter);
        detailsImg = (ImageView) findViewById(R.id.img_details_activity);
        detailsImg.setImageResource(catModel.arrayList.get(catModel.position));

        mCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailsActivity.this, "This item is added to your Cart", Toast.LENGTH_SHORT).show();
                DbHelper = new CartDbHelper(getBaseContext());
                User user = new User(BitmapFactory.decodeResource(getResources(), catModel.arrayList.get(catModel.position)));
                DbHelper.open();
                DbHelper.insertUser(user);
                DbHelper.close();
            }
        });


    }
}
