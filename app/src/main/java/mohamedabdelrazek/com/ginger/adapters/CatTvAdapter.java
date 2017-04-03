package mohamedabdelrazek.com.ginger.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import mohamedabdelrazek.com.ginger.CatModel;
import mohamedabdelrazek.com.ginger.R;

/**
 * Created by Mohamed AbdelraZek on 4/3/2017.
 */

public class CatTvAdapter extends RecyclerView.Adapter<CatTvAdapter.SingleItemHolder> {
    private LayoutInflater inflater;
    private Context context;
    private ArrayList<Integer> data;
    private ClickListener mClickListener;

    public interface ClickListener {
         void onItemClicked(CatModel catModel);
    }

    public CatTvAdapter(Context context, ArrayList<Integer> data, ClickListener clickListener) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
        mClickListener = clickListener;
    }


    @Override
    public SingleItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.singleimageitem, parent, false);
        SingleItemHolder trailerHolder = new SingleItemHolder(view);
        return trailerHolder;

    }

    @Override
    public void onBindViewHolder(SingleItemHolder holder, int position) {
        holder.ItemImg.setImageResource(data.get(position));
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public class SingleItemHolder extends RecyclerView.ViewHolder {
        ImageView ItemImg;

        public SingleItemHolder(View view) {
            super(view);
            ItemImg = (ImageView) view.findViewById(R.id.single_img_item_id);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    CatModel catModel=new CatModel();
                    catModel.arrayList=data;
                    catModel.position=getAdapterPosition();
                    mClickListener.onItemClicked(catModel);

                }
            });


        }
    }
}