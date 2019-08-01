package com.quintus.labs.kidzz.adapter;

import android.widget.Button;

/**
 * Kidzz
 * https://github.com/quintuslabs/Kidzz
 * Created on 25-feb-2019.
 * Created by : Santosh Kumar Dash:- http://santoshdash.epizy.com
 */


public class Card {

    public int x;
    public int y;
    public Button button;

    public Card(Button button, int x, int y) {
        this.x = x;
        this.y = y;
        this.button = button;
    }


}
