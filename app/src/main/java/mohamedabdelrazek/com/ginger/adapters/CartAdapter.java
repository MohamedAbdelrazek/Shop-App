package mohamedabdelrazek.com.ginger.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import mohamedabdelrazek.com.ginger.R;
import mohamedabdelrazek.com.ginger.data.Utility;

/**
 * Created by Mohamed AbdelraZek on 4/3/2017.
 */

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.SingleItemHolder> {
    private LayoutInflater inflater;
    private Context context;
    private ArrayList<byte[]> users;


    public CartAdapter(Context context, ArrayList<byte[]> users) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.users = users;
    }


    @Override
    public CartAdapter.SingleItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.cart_single_item, parent, false);
        CartAdapter.SingleItemHolder trailerHolder = new CartAdapter.SingleItemHolder(view);
        return trailerHolder;
    }

    @Override
    public void onBindViewHolder(SingleItemHolder holder, int position) {
        holder.ItemImg.setImageBitmap(Utility.getPhoto(users.get(position)));
    }


    @Override
    public int getItemCount() {
        return users.size();
    }

    public class SingleItemHolder extends RecyclerView.ViewHolder {
        ImageView ItemImg;

        public SingleItemHolder(View view) {
            super(view);
            ItemImg = (ImageView) view.findViewById(R.id.cart_single_img);


        }
    }
}