package materialdesign.practice.com.recyclerfragment.Adapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import materialdesign.practice.com.recyclerfragment.Activity.AddDataActivity;
import materialdesign.practice.com.recyclerfragment.Activity.MainActivity;
import materialdesign.practice.com.recyclerfragment.Activity.SEShowActivity;
import materialdesign.practice.com.recyclerfragment.Interface.HolderClickListener;
import materialdesign.practice.com.recyclerfragment.R;
import materialdesign.practice.com.recyclerfragment.Util.ModelClass;

public class rvAdapter extends RecyclerView.Adapter {

    public class rvViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener
    {
        TextView tvTitle, tvDescp, tvName, tvTime;
        HolderClickListener holderClickListener;

        public rvViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescp = itemView.findViewById(R.id.tvDescp);
            tvName = itemView.findViewById(R.id.tvName);
            tvTime = itemView.findViewById(R.id.tvTime);
            itemView.setOnClickListener(this);
        }

        public void setHolderClickListener(HolderClickListener itemClickListener){
            this.holderClickListener =itemClickListener;
        }

        @Override
        public void onClick(View v) {
            holderClickListener.holderClicked(v, getAdapterPosition());
        }
    }

    Context context;
    List<ModelClass> dataList = new ArrayList<>();
    ModelClass modelClass;


    public rvAdapter(Context context, List<ModelClass> list) {
        this.context = context;
      this.dataList=list;
    }

        @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
        {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.layout_recycler_dataitem_view, viewGroup,false);
        return new rvViewHolder(view);
        }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        modelClass = dataList.get(i);  //passing data (whole object) at particular position of list

        ((rvViewHolder)viewHolder).tvName.setText(modelClass.getName());
        ((rvViewHolder)viewHolder).tvTime.setText(modelClass.getTime());
        ((rvViewHolder)viewHolder).tvTitle.setText(modelClass.getTitle());
        ((rvViewHolder)viewHolder).tvDescp.setText(modelClass.getDescp());



        final Pair[] pair = new Pair[3];  //Pair pair = Pair.create(((rvViewHolder)viewHolder).tvTitle ,"transitionName");
        pair[0] = new Pair<View, String> (((rvViewHolder)viewHolder).tvName ,"transitionName");
        pair[1] = new Pair<View, String> (((rvViewHolder)viewHolder).tvTitle, "transitionTitle");
        pair[2] = new Pair<View, String> (((rvViewHolder)viewHolder).tvDescp,"transitionDescp");
        ((rvViewHolder)viewHolder).setHolderClickListener(new HolderClickListener() {
            @Override
            public void holderClicked(View v, int position) {
                Intent i = new Intent(context, SEShowActivity.class);

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
                        (Activity) context, pair);
                //sharedTextView, ViewCompat.getTransitionName(((rvViewHolder)viewHolder).tvName);

                context.startActivity(i, options.toBundle());
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
        //return title.length;
    }
}
