package com.mark.view.twicedemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.mark.view.twicedemo.R;
import com.mark.view.twicedemo.bean.ChildBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 我的关注适配器
 * Created by Administrator on 2017/12/9.
 */

public class ChildAdapter extends RecyclerView.Adapter<ChildAdapter.ChildViewHolder> implements View.OnClickListener {


    private List<ChildBean> mList = new ArrayList<>();
    private Context mContext;
    private int tag = 0;

    public ChildAdapter(Context mContext, List<ChildBean> list) {
        this.mList = list;
        this.mContext = mContext;
    }

    @Override
    public ChildViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ChildViewHolder viewHolder = null;
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_flowlayout_bill, parent, false);
        //将创建的View注册点击事件
        view.setOnClickListener(this);

        if (viewHolder == null) {
            viewHolder = new ChildViewHolder(view);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ChildViewHolder holder, final int position) {
        holder.tcheck.setText(mList.get(position).getValue());
        if (mList.get(position).isSelected()){
            holder.tcheck.setChecked(true);
            mList.get(position).setSelected(true);
        }else {
            holder.tcheck.setChecked(false);
            mList.get(position).setSelected(false);
        }
        holder.tcheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i <mList.size() ; i++) {
                    mList.get(i).setSelected(false);
                    holder.tcheck.setChecked(false);
                    notifyDataSetChanged();
                }
                mList.get(position).setSelected(true);
                holder.tcheck.setChecked(true);

                tag = position;
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
            mOnItemClickListener.onItemClick(v, (int) v.getTag(),tag);
        }
    }

    class ChildViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tcheck)
        CheckBox tcheck;
        public ChildViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    private OnItemClickListener mOnItemClickListener = null;

    //define interface
    public static interface OnItemClickListener {
        void onItemClick(View view, int position,int tag);
    }
}
