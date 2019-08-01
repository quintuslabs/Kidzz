package com.quintus.labs.kidzz.imageslid;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.viewpager.widget.PagerAdapter;

import com.quintus.labs.kidzz.R;

import java.util.ArrayList;

/**
 * Kidzz
 * https://github.com/quintuslabs/Kidzz
 * Created on 25-feb-2019.
 * Created by : Santosh Kumar Dash:- http://santoshdash.epizy.com
 */


public class SlideImage_Adapter extends PagerAdapter {

    Context context;
    ArrayList<Integer> imageArray;
    private LayoutInflater inflater;


    public SlideImage_Adapter(Context context, ArrayList<Integer> imageArray) {
        this.context = context;
        this.imageArray = imageArray;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return imageArray.size();
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View imageLayout = inflater.inflate(R.layout.slideingimages_layout, view, false);

        assert imageLayout != null;
        final ImageView imageView = imageLayout.findViewById(R.id.imagesilde);
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),
                imageArray.get(position));
        //Bitmap originalImage= Bitmap.createScaledBitmap (BitmapFactory.decodeResource(context.getResources(), imageArray.get(position)), 160, 100, true);
        //imageView.setImageResource(imageArray.get(position));
        imageView.setImageBitmap(bitmap);
        view.addView(imageLayout, 0);


        return imageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }


}
