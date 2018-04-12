package com.mark.view.twicedemo.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.mark.view.twicedemo.R;
import com.mark.view.twicedemo.bean.GroupBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 我的关注适配器
 * Created by Administrator on 2017/12/9.
 */

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.GroupViewHolder> implements View.OnClickListener {

    @BindView(R.id.tv_type_name)
    TextView tvTypeName;
    @BindView(R.id.layout_property)
    RecyclerView layoutProperty;
    private List<GroupBean> mList = new ArrayList<>();
    private Context mContext;
    private ChildAdapter childAdapter;

    public GroupAdapter(Context mContext, List<GroupBean> list) {
        this.mList = list;
        this.mContext = mContext;
    }

    @Override
    public GroupViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        GroupViewHolder viewHolder = null;
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_listview_property, parent, false);
        //将创建的View注册点击事件
        view.setOnClickListener(this);
        if (viewHolder == null) {
            viewHolder = new GroupViewHolder(view);
        }
        viewHolder.layoutProperty.setFocusable(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext,4);
//        gridLayoutManager.setMeasuredDimension();
        viewHolder.layoutProperty.setLayoutManager(gridLayoutManager);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(GroupViewHolder holder, int position) {
        holder.tvTypeName.setText(mList.get(position).getTypeName());

        childAdapter = new ChildAdapter(mContext, mList.get(position).getChildBeanList());
        holder.layoutProperty.setAdapter(childAdapter);
        childAdapter.setOnItemClickListener(new ChildAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position , int tag) {
            }
        });

        //将position保存在itemView的Tag中，以便点击时进行获取
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取position
            mOnItemClickListener.onItemClick(v, (int) v.getTag());
        }
    }

    class GroupViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_type_name)
        TextView tvTypeName;
        @BindView(R.id.layout_property)
        RecyclerView layoutProperty;

        public GroupViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    private OnItemClickListener mOnItemClickListener = null;

    //define interface
    public static interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
}
