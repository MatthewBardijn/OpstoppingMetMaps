package com.student.matthew.opstoppingmetmaps;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Matthew on 11-1-2016.
 */
public class EditFragment extends Fragment {
Communicator comm;
    private static EditText edittext;
    ToolbarListener activityCallback;

    public interface ToolbarListener {
        public void onButtonClick(String text);
    }

    @Override
    public void onAttach(Context context) {
        try {
            activityCallback = (ToolbarListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle
                                     savedInstanceState) {

        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.editfragment,
                container, false);

        edittext = (EditText) view.findViewById(R.id.editText);

        final Button button =
                (Button) view.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonClicked(v);
            }
        });
        return view;
    }
    public void buttonClicked (View view) {
        activityCallback.onButtonClick(
                edittext.getText().toString());
    }
}
