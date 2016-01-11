package com.student.matthew.opstoppingmetmaps;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class text extends Fragment {

    private static TextView textview;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle
                                     savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_text,container,false);

        textview = (TextView) view.findViewById(R.id.textView4);
return view;
    }
    public void changeTextProperties(String text)
    {
        textview.setText(text);
    }
}
