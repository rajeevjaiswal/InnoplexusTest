package com.rajeevjaiswal.innoplexustest.main;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rajeevjaiswal.innoplexustest.MyApp;
import com.rajeevjaiswal.innoplexustest.R;
import com.rajeevjaiswal.innoplexustest.model.Contact;
import com.rajeevjaiswal.innoplexustest.network.RestAPI;
import com.rajeevjaiswal.innoplexustest.util.ConnectivityUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dmax.dialog.SpotsDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements ContactAdapter.Callback{

    @Inject
    Retrofit retrofit;

    @BindView(R.id.contact_recycler_view)
    RecyclerView  mRecyclerView;

    @BindView(R.id.tv_asc)
    TextView ascendingView;

    @BindView(R.id.tv_desc)
    TextView  descendingView;

    @BindView(R.id.ll_sort_header)
    LinearLayout sortContainer;

    AlertDialog progressLoader;
    private ContactAdapter mAdapter;
    private List<Contact> contactArrayList;
    public static final String USER_DETAIL = "user_detail";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((MyApp) this.getApplicationContext()).getNetComponent().inject(this);
        ButterKnife.bind(this);
        setTitle("Contact List");
        progressLoader = new SpotsDialog(this,"Loading Contacts",R.style.Custom);
        contactArrayList = new ArrayList<>();
        setUp();
    }


    private void setUp() {

        mAdapter = new ContactAdapter(contactArrayList);
        mAdapter.setCallback(this);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mAdapter);
        loadContactsFromNetwork();
    }

    private void loadContactsFromNetwork() {

        if(ConnectivityUtils.isConnected(this)){
            progressLoader.show();
            fetchContacts();
        }else {
            showNoNetwork();
        }
    }


    private void fetchContacts() {


        Call<List<Contact>> call = retrofit.create(RestAPI.class).getContacts();
        call.enqueue(new Callback<List<Contact>>() {
            @Override
            public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {

                if(response.isSuccessful()){
                    sortContainer.setVisibility(View.VISIBLE);
                    mAdapter.addItems(response.body());
                }
                progressLoader.dismiss();

            }

            @Override
            public void onFailure(Call<List<Contact>> call, Throwable t) {
                progressLoader.dismiss();

            }
        });
    }

    @OnClick(R.id.tv_asc)
    public void sortAscending(View  view){

        ascendingView.setBackgroundColor(ContextCompat.getColor(this,R.color.colorAccent));
        descendingView.setBackgroundColor(ContextCompat.getColor(this,R.color.gray_f1));

        Collections.sort(contactArrayList,Contact.BY_NAME_ALPHABETICAL);
        mAdapter.notifyDataSetChanged();
    }

    @OnClick(R.id.tv_desc)
    public void sortDescending(View  view){

        descendingView.setBackgroundColor(ContextCompat.getColor(this,R.color.colorAccent));
        ascendingView.setBackgroundColor(ContextCompat.getColor(this,R.color.gray_f1));
        Collections.sort(contactArrayList,Collections.reverseOrder(Contact.BY_NAME_ALPHABETICAL));
        mAdapter.notifyDataSetChanged();
    }


    @Override
    public void onContactClicked(int position) {

        Intent startDetailScreen = new Intent(MainActivity.this, UserDetailActivity.class);
        startDetailScreen.putExtra(USER_DETAIL, contactArrayList.get(position));
        startActivity(startDetailScreen);
    }

    private void showNoNetwork() {

        Snackbar mSnackbar = Snackbar.make(findViewById(R.id.main), "No Internet Connection", Snackbar.LENGTH_INDEFINITE)
                .setAction("RETRY", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        loadContactsFromNetwork();
                    }
                });
        mSnackbar.show();
    }
}
