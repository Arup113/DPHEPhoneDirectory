/*
 * Copyright (C) 2017 NURDCODER
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://nurdcoder.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.nurdcoder.android.dphe_phone_directory.ui.contact_list;

import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nurdcoder.android.dphe_phone_directory.R;
import com.nurdcoder.android.dphe_phone_directory.data.local.user.ContactEntity;

import java.util.ArrayList;

/**
 * ****************************************************************************
 * * Copyright © 2018 W3 Engineers Ltd., All rights reserved.
 * *
 * * Created by:
 * * Name : ZOARDER AL MUKTADIR
 * * Date : 10/25/2018
 * * Email : muktadir@nurdcoder.com
 * *
 * * Purpose :
 * *
 * * Last Edited by : ZOARDER AL MUKTADIR on 10/25/2018.
 * * History:
 * * 1: Create the Class
 * * 2:
 * *
 * * Last Reviewed by : ZOARDER AL MUKTADIR on 10/25/2018.
 * ****************************************************************************
 */

public class ContactListRecyclerAdapter extends RecyclerView.Adapter<ContactListRecyclerAdapter.SingleItemRowHolder> {

    private ArrayList<ContactEntity> mDataList;

    public ContactListRecyclerAdapter(ArrayList<ContactEntity> mDataList) {
        this.mDataList = mDataList;
    }

    @NonNull
    @Override
    public SingleItemRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_contact_list, parent, false);
        return new SingleItemRowHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final SingleItemRowHolder holder, int position) {
        final ContactEntity itemModel = mDataList.get(position);
        holder.name_tv.setText(itemModel.getNAME_OF_THE_STAFF());
        holder.designation_tv.setText(itemModel.getDESIGNATION());
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return (null != mDataList ? mDataList.size() : 0);
    }

    class SingleItemRowHolder extends RecyclerView.ViewHolder {

        private TextView name_tv;
        private TextView designation_tv;
        private AppCompatImageView user_iv;

        SingleItemRowHolder(View itemView) {
            super(itemView);
            this.name_tv = itemView.findViewById(R.id.name_tv);
            this.designation_tv = itemView.findViewById(R.id.designation_tv);
            this.user_iv = itemView.findViewById(R.id.user_iv);
        }
    }
}
