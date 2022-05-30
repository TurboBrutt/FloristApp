package com.example.florist;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TreeFragment extends Fragment {

    private ListView lv1;

    public static TreeFragment newInstance(){
        TreeFragment treeFragment=new TreeFragment();

        return treeFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.treefragment,container,false);

        lv1= (ListView) rootView.findViewById(R.id.listviewtree);
        String[] trees= getResources().getStringArray(R.array.TreeURL); //Массив web ссылок на растений
        String[] treesNames = getResources().getStringArray((R.array.TreeNames));
        lv1.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_expandable_list_item_1,treesNames));

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if(trees[position].contains("https"))
                {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(trees[position])));
                }
                /*Object obj = lv.getAdapter().getItem(position);
                Uri uri = Uri.parse(obj.toString());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);*/

            }
        });
        return rootView;
    }

}
