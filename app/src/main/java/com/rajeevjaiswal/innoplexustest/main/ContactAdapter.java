/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.rajeevjaiswal.innoplexustest.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;

import com.rajeevjaiswal.innoplexustest.R;
import com.rajeevjaiswal.innoplexustest.model.Contact;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by rajeev on 14/1/18.
 */

public class ContactAdapter extends RecyclerView.Adapter<BaseViewHolder> {


    private Callback mCallback;
    private List<Contact> mContactList;

    public ContactAdapter(List<Contact> cityList) {
        mContactList = cityList;
    }

    public void setCallback(Callback callback) {
        mCallback = callback;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_list, parent, false));
    }



    @Override
    public int getItemCount() {

      return mContactList.size();

    }

    public void addItems(List<Contact> cityList) {
        mContactList.addAll(cityList);
        notifyDataSetChanged();
    }

    public void clear() {
        mContactList.clear();
//        notifyDataSetChanged();
    }

    public interface Callback {
        void onContactClicked(int position);
    }

    public class ViewHolder extends BaseViewHolder {

        @BindView(R.id.tv_name)
        TextView userName;

        @BindView(R.id.tv_email_id)
        TextView userEmail;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        protected void clear() {

        }


        public void onBind(final int position) {
            super.onBind(position);

            final Contact contact = mContactList.get(position);


                userName.setText(contact.getName());
                userEmail.setText(contact.getEmail());


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mCallback != null)
                        mCallback.onContactClicked(position);
                }

            });
        }
    }


}
