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

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.nurdcoder.android.dphe_phone_directory.R;
import com.nurdcoder.android.dphe_phone_directory.data.local.dbstorage.DatabaseService;
import com.nurdcoder.android.dphe_phone_directory.data.local.user.ContactEntity;
import com.nurdcoder.android.dphe_phone_directory.databinding.ActivitySubCategoryBinding;
import com.nurdcoder.android.dphe_phone_directory.ui.base.BaseActivity;
import com.nurdcoder.android.util.helper.CustomRecyclerItemSpaceDecoration;
import com.nurdcoder.android.util.helper.ScreenUtils;

import java.util.ArrayList;
import java.util.Objects;

import io.reactivex.disposables.Disposable;

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

public class ContactListActivity extends BaseActivity<ContactListMvpView, ContactListPresenter> implements ContactListMvpView {

    public static final String EXTRA_CATEGORY = "EXTRA_CATEGORY";
    public static final String EXTRA_SUB_CATEGORY = "EXTRA_SUB_CATEGORY";
    private ActivitySubCategoryBinding mBinding;
    private String mCategory;
    private ContactListRecyclerAdapter mAdapter;
    private String mSubCategory;
    private Disposable mDisposable;
    ArrayList<ContactEntity> mDataList;

    public static void runActivity(Context context) {
        Intent intent = new Intent(context, ContactListActivity.class);
        runCurrentActivity(context, intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_sub_category;
    }

    @Override
    protected void startUI() {
        mBinding = (ActivitySubCategoryBinding) getViewDataBinding();
        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            mCategory = bundle.getString(EXTRA_CATEGORY);
            mSubCategory = bundle.getString(EXTRA_SUB_CATEGORY);
        }
        mBinding.headerTv.setText(mCategory);


        mBinding.parentRv.setHasFixedSize(true);
        mDataList = new ArrayList<>();
        mAdapter = new ContactListRecyclerAdapter(mDataList);

        mBinding.parentRv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mBinding.parentRv.addItemDecoration(new CustomRecyclerItemSpaceDecoration(ScreenUtils.dp2px(Objects.requireNonNull(this), 10), 0, ScreenUtils.dp2px(this, 10), ScreenUtils.dp2px(this, 10), ScreenUtils.dp2px(this, 10), ScreenUtils.dp2px(this, 10)));
        mBinding.parentRv.setAdapter(mAdapter);

        // Fling listener for nested scrolling
        mBinding.parentRv.setOnFlingListener(new RecyclerView.OnFlingListener() {
            @Override
            public boolean onFling(int velocityX, int velocityY) {
                mBinding.parentRv.dispatchNestedFling(velocityX, velocityY, false);
                return false;
            }
        });

        mDisposable = DatabaseService.on()
                .contactListDao()
                .getAllContactBySubCategory(mSubCategory)
                .subscribe(testEntities -> {
                    mDataList.addAll(testEntities);
                    mAdapter.notifyDataSetChanged();
                }, throwable -> {
                });
    }

    @Override
    protected void stopUI() {

    }

    @Override
    protected ContactListPresenter initPresenter() {
        return new ContactListPresenter();
    }
}
