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

public class ParasiteFragment extends Fragment {
    private ListView lv4;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.parasitefragment,container,false);

        lv4 = (ListView) rootView.findViewById(R.id.listviewparasite);
        String[] parasite= getResources().getStringArray(R.array.ParasiteURL); //Массив web ссылок на растений
        String[] parasiteNames = getResources().getStringArray(R.array.ParasiteNames);
        lv4.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_expandable_list_item_1,parasiteNames));

        lv4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if(parasite[position].contains("https"))
                {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(parasite[position])));
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
