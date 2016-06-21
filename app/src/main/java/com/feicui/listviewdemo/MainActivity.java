package com.feicui.listviewdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ListView list_one;
    private MyAdapter mAdapter = null;
    private List<Data> mData = null;
    private Context mContext = null;
    private Button btn_add;
    private int flag=1;
    private Button btn_add2;
    private Button remove;
    private Button remove2;
    private Data mData_5 = null;   //用来临时放对象的

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_add= (Button) findViewById(R.id.btn_add);
        btn_add.setOnClickListener(this);
        btn_add2= (Button) findViewById(R.id.btn_add2);
        btn_add2.setOnClickListener(this);
        remove= (Button) findViewById(R.id.btn_remove);
        remove.setOnClickListener(this);
        remove2= (Button) findViewById(R.id.btn_remove2);
        remove2.setOnClickListener(this);

        mContext=MainActivity.this;
        bindView();
        mData=new LinkedList<Data>();
        mAdapter=new MyAdapter((LinkedList<Data>) mData,mContext);
        list_one.setAdapter(mAdapter);
    }

    private void bindView() {
        list_one= (ListView) findViewById(R.id.list_one);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_add:
                mAdapter.add(new Data(R.mipmap.ic_launcher,"给猪哥跪了~~~ x " + flag));
                flag++;
                break;
            case R.id.btn_add2:
                mAdapter.add(1,new Data(R.mipmap.ic_launcher,"给猪哥跪了~~~ x " + flag) );
                break;
            case R.id.btn_remove:
                mAdapter.clear(list_one);
                break;
            case R.id.btn_remove2:
                mAdapter.remove(2);
                break;
        }
    }
}
