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



public class DiseaseFragment extends Fragment {
    private ListView lv3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.diseasefragment,container,false);


        lv3 = (ListView) rootView.findViewById(R.id.listviewdisease);
        String[] disease= getResources().getStringArray(R.array.DiseaseURL); //Массив web ссылок на растений
        String[] diseaseNames = getResources().getStringArray(R.array.DiseaseNames);
        lv3.setAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_expandable_list_item_1,diseaseNames));

        lv3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if(disease[position].contains("https"))
                {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(disease[position])));
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
