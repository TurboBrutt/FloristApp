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


import java.util.List;

public class FlowerFragment extends Fragment {

    private ListView lv;

    public static FlowerFragment newInstance(){
        FlowerFragment flowerFragment=new FlowerFragment();

        return flowerFragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.flowerfragment, container, false);

        lv= (ListView) rootView.findViewById(R.id.listviewflower);
        String[] flowers= getResources().getStringArray(R.array.FlowerURL); //Массив web ссылок на растений
        String[] flowersNames = getResources().getStringArray(R.array.FlowerNames);
        lv.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_expandable_list_item_1,flowersNames));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if(flowers[position].contains("https"))
                {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(flowers[position])));
                }
                /*Object obj = lv.getAdapter().getItem(position);
                Uri uri = Uri.parse(obj.toString());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);*/

            }
        });
        return rootView;
    }
    @Override
    public String toString(){
        return "FlowerFragment";
    }
}

