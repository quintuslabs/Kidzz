package com.quintus.labs.kidzz.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.quintus.labs.kidzz.R;

/**
 * Kidzz
 * https://github.com/quintuslabs/Kidzz
 * Created on 25-feb-2019.
 * Created by : Santosh Kumar Dash:- http://santoshdash.epizy.com
 */


/**
 * A simple {@link Fragment} subclass.
 */
public class MultiplicationTableFragment extends Fragment {
    EditText num;
    Button calculate;
    Button clear;
    TextView printArea;

    public MultiplicationTableFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_multiplication_table, container, false);


        num = view.findViewById(R.id.num);
        clear = view.findViewById(R.id.clear);
        calculate = view.findViewById(R.id.calculate);
        printArea = view.findViewById(R.id.printArea);

        calculate.setOnClickListener(new View.OnClickListener() {
            // Perform action on Get Table Button click
            public void onClick(View v) {


                if (num.getText().length() == 0) {
                    printArea.setText(R.string.err_msg);
                } else {
                    //change the integer value into string
                    printArea.setText("");
                    int num1 = Integer.parseInt(num.getText().toString());
                    String result;

                    for (int i = 1; i <= 10; i++) {
                        result = (num1 + "      X     " + i + "      =     " + i * num1);
                        printArea.append("\n" + result);
                    }


                }
            }

        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num.setText("");
                printArea.setText("");
            }
        });


        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Multiplication Table");
    }

}
