package com.example.florist;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TreeFragment extends Fragment {

    TextView linkTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.treefragment,container,false);

        linkTextView = rootView.findViewById(R.id.txtLink);
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance());
        return rootView;
    }

}
