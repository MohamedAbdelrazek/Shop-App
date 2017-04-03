package mohamedabdelrazek.com.ginger.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import mohamedabdelrazek.com.ginger.R;

/**
 * Created by Mohamed AbdelraZek on 4/3/2017.
 */

public class DetailsimageAdapter extends RecyclerView.Adapter<DetailsimageAdapter.SingleItemHolder> {
    private LayoutInflater inflater;
    private Context context;
    private int mImageRes;
    private CatTvAdapter.ClickListener mClickListener;


    public DetailsimageAdapter(Context context, int imgRes) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.mImageRes = imgRes;
    }


    @Override
    public DetailsimageAdapter.SingleItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.details_img, parent, false);
        SingleItemHolder trailerHolder = new SingleItemHolder(view);
        return trailerHolder;
    }

    @Override
    public void onBindViewHolder(DetailsimageAdapter.SingleItemHolder holder, int position) {
        holder.ItemImg.setImageResource(mImageRes);
    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class SingleItemHolder extends RecyclerView.ViewHolder {
        ImageView ItemImg;

        public SingleItemHolder(View view) {
            super(view);
            ItemImg = (ImageView) view.findViewById(R.id.single_details_img_id);

        }
    }
}