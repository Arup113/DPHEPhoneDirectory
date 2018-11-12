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

package com.nurdcoder.android.dphe_phone_directory.ui.sub_category;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.nurdcoder.android.dphe_phone_directory.R;
import com.nurdcoder.android.dphe_phone_directory.databinding.ActivitySubCategoryBinding;
import com.nurdcoder.android.dphe_phone_directory.ui.base.BaseActivity;
import com.nurdcoder.android.dphe_phone_directory.ui.contact_list.ContactListActivity;
import com.nurdcoder.android.util.helper.CustomRecyclerItemSpaceDecoration;
import com.nurdcoder.android.util.helper.ScreenUtils;

import java.util.Objects;

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

public class SubCategoryActivity extends BaseActivity<SubCategoryMvpView, SubCategoryPresenter> implements SubCategoryMvpView {

    public static final String EXTRA_CATEGORY = "EXTRA_CATEGORY";
    private ActivitySubCategoryBinding mBinding;
    private String mCategory;
    private SubCategoryRecyclerAdapter mAdapter;
    private String[] mDataList;

    public static void runActivity(Context context) {
        Intent intent = new Intent(context, SubCategoryActivity.class);
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
        }
        mBinding.headerTv.setText(mCategory);
        mBinding.parentRv.setHasFixedSize(true);
        String category = mCategory.toLowerCase();
        category = category.replaceAll(" ", "_");
        category = category.replaceAll("-", "_");
        mDataList = getResources().getStringArray(getResources().getIdentifier(category, "array", getPackageName()));
        mAdapter = new SubCategoryRecyclerAdapter(mDataList);

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

        mBinding.parentRv.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            GestureDetector gestureDetector = new GestureDetector(SubCategoryActivity.this, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }
            });

            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

                View child = rv.findChildViewUnder(e.getX(), e.getY());
                if (child != null && gestureDetector.onTouchEvent(e)) {
                    int position = rv.getChildAdapterPosition(child);
                    Intent intent = new Intent(SubCategoryActivity.this, ContactListActivity.class);
                    intent.putExtra(ContactListActivity.EXTRA_CATEGORY, mCategory);
                    intent.putExtra(ContactListActivity.EXTRA_SUB_CATEGORY, mDataList[position]);
                    startActivity(intent);
                    overridePendingTransition(R.anim.trans_left_in, R.anim.trans_left_out);
                }
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });
    }

    @Override
    protected void stopUI() {

    }

    @Override
    protected SubCategoryPresenter initPresenter() {
        return new SubCategoryPresenter();
    }
}
