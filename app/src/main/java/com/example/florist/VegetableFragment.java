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


public class VegetableFragment extends Fragment {
    private ListView lv2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.vegetablefragment,container,false);

        lv2 = (ListView) rootView.findViewById(R.id.listviewvegetable);
        String[] vegetable= getResources().getStringArray(R.array.VegetableURL); //Массив web ссылок на растений
        String[] vegetableNames = getResources().getStringArray(R.array.VegetableNames);
        lv2.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_expandable_list_item_1,vegetableNames));

        lv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if(vegetable[position].contains("https"))
                {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(vegetable[position])));
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
