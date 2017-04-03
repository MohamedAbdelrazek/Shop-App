package mohamedabdelrazek.com.ginger;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.facebook.stetho.Stetho;

import java.util.ArrayList;

import mohamedabdelrazek.com.ginger.adapters.CatTvAdapter;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Integer> CatTVImagesList;
    private ArrayList<Integer> CatWatchesList;
    private ArrayList<Integer> CatHomeImagesList;
    private ArrayList<Integer> CatShoesList;
    private CatTvAdapter catTvAdapter;
    private CatTvAdapter catWatchesAdapter;
    private CatTvAdapter catHomeAdapter;
    private CatTvAdapter catShoesAdapter;
    private RecyclerView mTVRecyclerView;
    private RecyclerView mShoesRecyclerView;
    private RecyclerView mHomeRecyclerView;
    private RecyclerView mWatchesRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Stetho.initializeWithDefaults(this);
        setCategories();
        mTVRecyclerView = (RecyclerView) findViewById(R.id.cat_tv_recycler);
        mWatchesRecyclerView = (RecyclerView) findViewById(R.id.cat_watches_recycler);

        mShoesRecyclerView = (RecyclerView) findViewById(R.id.cat_shoes_recycler);
        mHomeRecyclerView = (RecyclerView) findViewById(R.id.cat_home_recycler);

        catTvAdapter = new CatTvAdapter(this, CatTVImagesList, new CatTvAdapter.ClickListener() {
            @Override
            public void onItemClicked(CatModel catModel) {
                Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
                intent.putExtra(Intent.EXTRA_TEXT, catModel);
                startActivity(intent);

            }
        });


        catWatchesAdapter = new CatTvAdapter(this, CatWatchesList, new CatTvAdapter.ClickListener() {
            public void onItemClicked(CatModel catModel) {
                Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
                intent.putExtra(Intent.EXTRA_TEXT, catModel);
                startActivity(intent);

            }
        });
        catHomeAdapter = new CatTvAdapter(this, CatHomeImagesList, new CatTvAdapter.ClickListener() {
            public void onItemClicked(CatModel catModel) {
                Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
                intent.putExtra(Intent.EXTRA_TEXT, catModel);
                startActivity(intent);

            }
        });
        catShoesAdapter = new CatTvAdapter(this, CatShoesList, new CatTvAdapter.ClickListener() {
            public void onItemClicked(CatModel catModel) {
                Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
                intent.putExtra(Intent.EXTRA_TEXT, catModel);
                startActivity(intent);

            }
        });
        mTVRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mWatchesRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mHomeRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mShoesRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        mTVRecyclerView.setAdapter(catTvAdapter);
        mWatchesRecyclerView.setAdapter(catWatchesAdapter);
        mHomeRecyclerView.setAdapter(catHomeAdapter);
        mShoesRecyclerView.setAdapter(catShoesAdapter);


    }

    private void setCategories() {
        CatTVImagesList = new ArrayList<>();
        CatTVImagesList.add(R.drawable.tv1);
        CatTVImagesList.add(R.drawable.tv2);
        CatTVImagesList.add(R.drawable.tv3);
        CatTVImagesList.add(R.drawable.tv4);
        CatTVImagesList.add(R.drawable.tv5);
        CatTVImagesList.add(R.drawable.tv6);
        CatTVImagesList.add(R.drawable.tv7);
        CatTVImagesList.add(R.drawable.tv8);
        CatTVImagesList.add(R.drawable.tv9);
        //-----------------------------------------------------------------------

        CatWatchesList = new ArrayList<>();
        CatWatchesList.add(R.drawable.watch1);
        CatWatchesList.add(R.drawable.watch2);
        CatWatchesList.add(R.drawable.watch3);
        CatWatchesList.add(R.drawable.watch4);
        CatWatchesList.add(R.drawable.watch5);
        CatWatchesList.add(R.drawable.watch6);
        CatWatchesList.add(R.drawable.watch7);
        CatWatchesList.add(R.drawable.watch8);
        CatWatchesList.add(R.drawable.watch9);
        CatWatchesList.add(R.drawable.watch10);
        CatWatchesList.add(R.drawable.watch11);
        CatWatchesList.add(R.drawable.watch12);
        CatWatchesList.add(R.drawable.watch13);
        CatWatchesList.add(R.drawable.watch14);
        CatWatchesList.add(R.drawable.watch15);
        CatWatchesList.add(R.drawable.watch16);
        CatWatchesList.add(R.drawable.watch17);
        //-----------------------------------------------------------------------

        CatHomeImagesList = new ArrayList<>();
        CatHomeImagesList.add(R.drawable.home1);
        CatHomeImagesList.add(R.drawable.home2);
        CatHomeImagesList.add(R.drawable.home3);
        CatHomeImagesList.add(R.drawable.home4);
        CatHomeImagesList.add(R.drawable.home5);
        CatHomeImagesList.add(R.drawable.home6);
        CatHomeImagesList.add(R.drawable.home8);

        CatHomeImagesList.add(R.drawable.home9);
        CatHomeImagesList.add(R.drawable.home10);
        CatHomeImagesList.add(R.drawable.home11);
        CatHomeImagesList.add(R.drawable.home12);
        CatHomeImagesList.add(R.drawable.home13);
        CatHomeImagesList.add(R.drawable.home14);
        CatHomeImagesList.add(R.drawable.home15);
        CatHomeImagesList.add(R.drawable.home16);
        CatHomeImagesList.add(R.drawable.home17);
        CatHomeImagesList.add(R.drawable.home18);
        CatHomeImagesList.add(R.drawable.home20);
        CatHomeImagesList.add(R.drawable.home21);
        //-----------------------------------------------------------------------
        CatShoesList = new ArrayList<>();
        CatShoesList.add(R.drawable.shoes1);
        CatShoesList.add(R.drawable.shoes2);
        CatShoesList.add(R.drawable.shoes3);
        CatShoesList.add(R.drawable.shoes4);
        CatShoesList.add(R.drawable.shoes5);
        CatShoesList.add(R.drawable.shoes6);
        CatShoesList.add(R.drawable.shoes7);
        CatShoesList.add(R.drawable.shoes8);
        CatShoesList.add(R.drawable.shoes9);
        CatShoesList.add(R.drawable.shoes10);
        CatShoesList.add(R.drawable.shoes11);
        CatShoesList.add(R.drawable.shoes12);
        CatShoesList.add(R.drawable.shoes13);
        CatShoesList.add(R.drawable.shoes14);
        CatShoesList.add(R.drawable.shoes15);
        CatShoesList.add(R.drawable.shoes16);
        CatShoesList.add(R.drawable.shoes17);
        CatShoesList.add(R.drawable.shoes18);
        CatShoesList.add(R.drawable.shoes19);
        CatShoesList.add(R.drawable.shoes20);
        CatShoesList.add(R.drawable.shoes21);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.cart_menu, menu);
        return true;
    }

    @SuppressLint("StringFormatInvalid")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_cart_label) {
            startActivity(new Intent(getApplicationContext(), CartActivity.class));

            return true;
        } else if (id == R.id.action_search_label)
        {
            Toast.makeText(this, "will be added in the next version !", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
