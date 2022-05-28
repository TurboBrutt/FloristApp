package com.example.florist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;

public class FlowerFragment extends Fragment {

    private ListView lv;
    private static String[] flowers={"Одуванчики","Тюльпаны",};

    public static FlowerFragment newInstance(){
        FlowerFragment flowerFragment=new FlowerFragment();

        return flowerFragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.flowerfragment, container, false);

        lv= (ListView) rootView.findViewById(R.id.listviewflower);
        lv.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_expandable_list_item_1,flowers));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(),flowers[i], Toast.LENGTH_SHORT).show();
            }
        });
        return rootView;
    }

    @Override
    public String toString(){
        return "FlowerFragment";
    }
}

