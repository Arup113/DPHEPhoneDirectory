package com.nurdcoder.android.dphe_phone_directory.ui.contact_list;

import android.widget.ImageView;

import com.nurdcoder.android.dphe_phone_directory.data.local.contact_list.ContactEntity;

/**
 * Created by: MD. REZWANUR RAHMAN KHAN on 8/8/2018 at 3:30 PM.
 * Email: rezwanur@w3engineers.com
 * Code Responsibility: This class represents the sign up page
 * Last edited by : MD. REZWANUR RAHMAN KHAN on 8/12/2018.
 * Last Reviewed by : <NAME> on <DATE>.
 * Copyright (c) 2018, W3 Engineers Ltd. All rights reserved.
 */
public interface AppItemClickListener {
    void onAppItemClick(int pos, ContactEntity contactEntity, ImageView shareImageView);
}