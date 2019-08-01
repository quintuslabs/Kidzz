package com.quintus.labs.kidzz.fragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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
public class ContactUsFragment extends Fragment {
    public static String TAG = "Aboutus ==>";
    LinearLayout websiteLL, emailLL, phoneNoLL;
    TextView website_TV, email_TV, phoneNo_TV;
    String website, email, phone;

    public ContactUsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact_us, container, false);
        websiteLL = view.findViewById(R.id.about_us_website_LL);
        emailLL = view.findViewById(R.id.about_us_email_LL);
        phoneNoLL = view.findViewById(R.id.about_us_phono_no_LL);
        website_TV = view.findViewById(R.id.about_us_website);
        email_TV = view.findViewById(R.id.about_us_email);
        phoneNo_TV = view.findViewById(R.id.about_us_phone_no);

        website = website_TV.getText().toString();
        email = email_TV.getText().toString();
        phone = phoneNo_TV.getText().toString();

        websiteLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWebsite();
            }
        });
        emailLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                emailUs();

            }
        });
        phoneNoLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contactUs();
            }
        });
        return view;
    }

    private void contactUs() {
        Uri number = Uri.parse("tel:9778178337");
        Intent callIntent = new Intent(Intent.ACTION_DIAL, number);
        startActivity(callIntent);
    }

    private void emailUs() {
        String message = "Welcome To Kidzz";
        String subject = "Welcome Message";
        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{String.valueOf(email)});
        email.putExtra(Intent.EXTRA_SUBJECT, subject);
        email.putExtra(Intent.EXTRA_TEXT, message);

        //need this to prompts email client only
        email.setType("message/rfc822");

        startActivity(Intent.createChooser(email, "Choose an Email client :"));
    }

    private void openWebsite() {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("http://" + website));
        startActivity(intent);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Contact Us");
    }

}
