package com.rajeevjaiswal.innoplexustest.main;

import android.annotation.SuppressLint;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.rajeevjaiswal.innoplexustest.R;
import com.rajeevjaiswal.innoplexustest.model.Contact;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserDetailActivity extends AppCompatActivity {

    @BindView(R.id.tv_full_name) TextView fullName;
    @BindView(R.id.tv_user_name) TextView username;
    @BindView(R.id.tv_email_id) TextView emailId;
    @BindView(R.id.tv_phone_no) TextView phoneNo;
    @BindView(R.id.tv_website) TextView website;
    @BindView(R.id.tv_company_name) TextView companyName;
    @BindView(R.id.tv_suite) TextView suite;
    @BindView(R.id.tv_street) TextView street;
    @BindView(R.id.tv_city) TextView city;
    @BindView(R.id.tv_zipcode) TextView zipcode;
    @BindView(R.id.tv_geo) TextView geo;

    private Contact userDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);
        ButterKnife.bind(this);
        setTitle("Detail");
        userDetail = getIntent().getParcelableExtra(MainActivity.USER_DETAIL);

        setUserData();
    }

    @SuppressLint("SetTextI18n")
    private void setUserData() {
        fullName.setText(userDetail.getName());
        username.setText(userDetail.getUsername());
        emailId.setText(userDetail.getEmail());
        phoneNo.setText(userDetail.getPhone());
        website.setText(userDetail.getWebsite());
        companyName.setText(userDetail.getCompany().getName());
        suite.setText(userDetail.getAddress().getSuite());
        street.setText(userDetail.getAddress().getStreet());
        city.setText(userDetail.getAddress().getCity());
        zipcode.setText(userDetail.getAddress().getZipcode());
        geo.setText(userDetail.getAddress().getGeo().getLat() + "," + userDetail.getAddress().getGeo().getLng());

    }


}
