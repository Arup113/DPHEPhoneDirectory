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

package com.nurdcoder.android.dphe_phone_directory.ui.contact_details;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.nurdcoder.android.dphe_phone_directory.R;
import com.nurdcoder.android.dphe_phone_directory.data.local.contact_list.ContactEntity;
import com.nurdcoder.android.dphe_phone_directory.databinding.ActivityContactDetailsBinding;
import com.nurdcoder.android.dphe_phone_directory.ui.base.BaseActivity;
import com.nurdcoder.android.util.helper.StringUtils;

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

public class ContactDetailsActivity extends BaseActivity<ContactDetailsMvpView, ContactDetailsPresenter> implements ContactDetailsMvpView {

    public static final String EXTRA_TRANSITION_NAME = "EXTRA_TRANSITION_NAME";
    public static final String EXTRA_CONTACT_MODEL = "EXTRA_CONTACT_MODEL";
    private ActivityContactDetailsBinding mBinding;
    private ContactEntity mContact;

    public static void runActivity(Context context) {
        Intent intent = new Intent(context, ContactDetailsActivity.class);
        runCurrentActivity(context, intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_contact_details;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = (ActivityContactDetailsBinding) getViewDataBinding();
        supportPostponeEnterTransition();
        Bundle extras = getIntent().getExtras();

        // Setting details from intent json data
        if (extras != null) {
            mContact = extras.getParcelable(EXTRA_CONTACT_MODEL);
            String imageTransitionName = extras.getString(EXTRA_TRANSITION_NAME);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                mBinding.userIv.setTransitionName(imageTransitionName);
                supportStartPostponedEnterTransition();
            }
        }

        mBinding.nameTv.setText(mContact.getNAME_OF_THE_STAFF());
        mBinding.designationTv.setText(mContact.getDESIGNATION());
        mBinding.officeValueTv.setText(mContact.getOFFICE());

        if (!StringUtils.isNullOrEmpty(mContact.getTELEPHONE())) {
            String[] telephone = mContact.getTELEPHONE().split(",");
            if (telephone.length > 0) {
                mBinding.telephoneValueTv1.setVisibility(View.VISIBLE);
                mBinding.callIb1.setVisibility(View.VISIBLE);
                mBinding.smsIb1.setVisibility(View.VISIBLE);
                mBinding.telephoneValueTv1.setText(telephone[0].trim());
            }

            if (telephone.length > 1) {
                mBinding.telephoneValueTv2.setVisibility(View.VISIBLE);
                mBinding.callIb2.setVisibility(View.VISIBLE);
                mBinding.smsIb2.setVisibility(View.VISIBLE);
                mBinding.telephoneValueTv2.setText(telephone[1].trim());
            }

            if (telephone.length > 2) {
                mBinding.telephoneValueTv3.setVisibility(View.VISIBLE);
                mBinding.callIb3.setVisibility(View.VISIBLE);
                mBinding.smsIb3.setVisibility(View.VISIBLE);
                mBinding.telephoneValueTv3.setText(telephone[2].trim());
            }
        }

        if (!StringUtils.isNullOrEmpty(mContact.getFAX())) {
            String[] fax = mContact.getFAX().split(",");
            if (fax.length > 0) {
                mBinding.faxValueTv1.setVisibility(View.VISIBLE);
                mBinding.faxValueTv1.setText(fax[0].trim());
            }

            if (fax.length > 1) {
                mBinding.faxValueTv2.setVisibility(View.VISIBLE);
                mBinding.faxValueTv2.setText(fax[1].trim());
            }

            if (fax.length > 2) {
                mBinding.faxValueTv3.setVisibility(View.VISIBLE);
                mBinding.faxValueTv3.setText(fax[2].trim());
            }
        }

        if (!StringUtils.isNullOrEmpty(mContact.getEMAIL())) {
            String[] email = mContact.getEMAIL().split(",");
            if (email.length > 0) {
                mBinding.emailValueTv1.setVisibility(View.VISIBLE);
                mBinding.emailIb1.setVisibility(View.VISIBLE);
                mBinding.emailValueTv1.setText(email[0].trim());
            }

            if (email.length > 1) {
                mBinding.emailValueTv2.setVisibility(View.VISIBLE);
                mBinding.emailIb2.setVisibility(View.VISIBLE);
                mBinding.emailValueTv2.setText(email[1].trim());
            }

            if (email.length > 2) {
                mBinding.emailValueTv3.setVisibility(View.VISIBLE);
                mBinding.emailIb3.setVisibility(View.VISIBLE);
                mBinding.emailValueTv3.setText(email[2].trim());
            }
        }

        setClickListener(mBinding.callIb1,
                mBinding.callIb2,
                mBinding.callIb3,
                mBinding.smsIb1,
                mBinding.smsIb2,
                mBinding.smsIb3,
                mBinding.emailIb1,
                mBinding.emailIb2,
                mBinding.emailIb3);
    }

    @Override
    protected void startUI() {
    }

    @Override
    protected void stopUI() {

    }

    @Override
    protected ContactDetailsPresenter initPresenter() {
        return new ContactDetailsPresenter();
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);
        switch (view.getId()) {
            case R.id.call_ib_1:
                Intent call = new Intent(Intent.ACTION_DIAL);
                call.setData(Uri.parse("tel:" + mBinding.telephoneValueTv1.getText().toString()));
                startActivity(Intent.createChooser(call, "Call Via..."));
                break;
            case R.id.call_ib_2:
                call = new Intent(Intent.ACTION_DIAL);
                call.setData(Uri.parse("tel:" + mBinding.telephoneValueTv2.getText().toString()));
                startActivity(Intent.createChooser(call, "Call Via..."));
                break;
            case R.id.call_ib_3:
                call = new Intent(Intent.ACTION_DIAL);
                call.setData(Uri.parse("tel:" + mBinding.telephoneValueTv3.getText().toString()));
                startActivity(Intent.createChooser(call, "Call Via..."));
                break;
            case R.id.sms_ib_1:
                Intent sms = new Intent(Intent.ACTION_SENDTO);
                String uriText = "smsto:" + Uri.encode(mBinding.telephoneValueTv1.getText().toString());
                Uri uri = Uri.parse(uriText);
                sms.setData(uri);
                startActivity(Intent.createChooser(sms, "SMS Via..."));
                break;
            case R.id.sms_ib_2:
                sms = new Intent(Intent.ACTION_SENDTO);
                uriText = "smsto:" + Uri.encode(mBinding.telephoneValueTv2.getText().toString());
                uri = Uri.parse(uriText);
                sms.setData(uri);
                startActivity(Intent.createChooser(sms, "SMS Via..."));
                break;
            case R.id.sms_ib_3:
                sms = new Intent(Intent.ACTION_SENDTO);
                uriText = "smsto:" + Uri.encode(mBinding.telephoneValueTv3.getText().toString());
                uri = Uri.parse(uriText);
                sms.setData(uri);
                startActivity(Intent.createChooser(sms, "SMS Via..."));
                break;
            case R.id.email_ib_1:
                Intent email = new Intent(Intent.ACTION_SENDTO);
                uriText = "mailto:" + Uri.encode(mBinding.emailValueTv1.getText().toString());
                uri = Uri.parse(uriText);
                email.setData(uri);
                startActivity(Intent.createChooser(email, "Email Via..."));
                break;
            case R.id.email_ib_2:
                email = new Intent(Intent.ACTION_SENDTO);
                uriText = "mailto:" + Uri.encode(mBinding.emailValueTv2.getText().toString());
                uri = Uri.parse(uriText);
                email.setData(uri);
                startActivity(Intent.createChooser(email, "Email Via..."));
                break;
            case R.id.email_ib_3:
                email = new Intent(Intent.ACTION_SENDTO);
                uriText = "mailto:" + Uri.encode(mBinding.emailValueTv3.getText().toString());
                uri = Uri.parse(uriText);
                email.setData(uri);
                startActivity(Intent.createChooser(email, "Email Via..."));
                break;
        }
    }
}
