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

package com.nurdcoder.android.dphe_phone_directory.ui.main;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.nurdcoder.android.dphe_phone_directory.R;
import com.nurdcoder.android.dphe_phone_directory.databinding.ActivityMainBinding;
import com.nurdcoder.android.dphe_phone_directory.ui.base.BaseActivity;
import com.nurdcoder.android.dphe_phone_directory.ui.sub_category.SubCategoryActivity;

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

public class MainActivity extends BaseActivity<MainMvpView, MainPresenter> implements MainMvpView {

    private ActivityMainBinding mBinding;

    public static void runActivity(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        runCurrentActivity(context, intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void startUI() {
        mBinding = (ActivityMainBinding) getViewDataBinding();
        setClickListener(mBinding.cardView1, mBinding.cardView2, mBinding.cardView3, mBinding.cardView4);
    }

    @Override
    protected void stopUI() {

    }

    @Override
    protected MainPresenter initPresenter() {
        return new MainPresenter();
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        Intent intent = new Intent(this, SubCategoryActivity.class);
        switch (view.getId()) {
            case R.id.card_view_1:
                intent.putExtra(SubCategoryActivity.EXTRA_CATEGORY, getString(R.string.head_quarter));
                break;
            case R.id.card_view_2:
                intent.putExtra(SubCategoryActivity.EXTRA_CATEGORY, getString(R.string.project_office));
                break;
            case R.id.card_view_3:
                intent.putExtra(SubCategoryActivity.EXTRA_CATEGORY, getString(R.string.circle_district_office));
                break;
            case R.id.card_view_4:
                intent.putExtra(SubCategoryActivity.EXTRA_CATEGORY, getString(R.string.laboratory));
                break;
        }
        startActivity(intent);
        overridePendingTransition(R.anim.right_to_left, R.anim.left_to_right);
    }
}
