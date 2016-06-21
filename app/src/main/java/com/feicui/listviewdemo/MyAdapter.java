package com.feicui.listviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * Created by AAAAA on 2016/6/21.
 */
public class MyAdapter extends BaseAdapter {

    private Context mContext;
    private LinkedList<Data> mData;


    public MyAdapter() {}

    public MyAdapter(LinkedList<Data> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_list,parent,false);
            holder = new ViewHolder();
            holder.img_icon = (ImageView) convertView.findViewById(R.id.img_icon);
            holder.txt_content = (TextView) convertView.findViewById(R.id.txt_content);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.img_icon.setImageResource(mData.get(position).getImgId());
        holder.txt_content.setText(mData.get(position).getContent());
        return convertView;
    }
    //添加一个元素
    public void add(Data data) {
        if (mData == null) {
            mData = new LinkedList<>();
        }
        mData.add(data);
        notifyDataSetChanged();
    }
    //往特定位置，添加一个元素
    public void add(int position,Data data){
        if (mData==null){
            mData=new LinkedList<>();
        }
        mData.add(position,data);
        notifyDataSetChanged();
    }
    //直接删除      根据游标来删除
    public void remove(Data data){
        if (mData!=null){
            mData.remove(data);
        }
        notifyDataSetChanged();
    }
    //根据游标来删除
    public void remove(int position){
        if (mData!=null){
            mData.remove(position);
        }
        notifyDataSetChanged();
    }
    //移除所有的记录
    public void clear(ListView list_one){
        if (mData!=null){
            mData.clear();
        }
        notifyDataSetChanged();
    }
    private class ViewHolder{
        ImageView img_icon;
        TextView txt_content;
    }
}
