package com.example.listview;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter{

    ArrayList<Repo> repoList;
    Context context;

    LayoutInflater layoutInflater;



    public ListViewAdapter(ArrayList<Repo> repoList, Application application) {

    }

    @Override
    public int getCount() {

        return repoList.size();


    }

    @Override
    public Object getItem(int position) {
        return repoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(layoutInflater == null)
        {
            layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if(convertView == null)
        {
            convertView = layoutInflater.inflate(R.layout.customlayout,parent,false);
        }

        TextView RepositoryName = convertView.findViewById(R.id.guneet);
        TextView OwnerName = convertView.findViewById(R.id.textView);


        RepositoryName.setText(repoList.get(position).getName());
        OwnerName.setText(repoList.get(position).getOwner().getLogin());

        return convertView;
    }
}
