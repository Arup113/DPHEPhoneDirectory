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

package com.nurdcoder.android.dphe_phone_directory.data.local.contact_list;

import android.arch.lifecycle.LiveData;

import com.nurdcoder.android.util.helper.ShowLog;

import java.util.List;

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

public class ContactListService {
    private final ContactListDao mContactListDao;

    public ContactListService(ContactListDao contactListDao) {
        mContactListDao = contactListDao;
    }

    public ContactEntity getUser(String meshID) {
        return mContactListDao.getContact(meshID);
    }

    public ContactEntity getUserById(long id) {
        return mContactListDao.getContactById(id);
    }

    public long insert(ContactEntity contactEntity) {
        long id = mContactListDao.insert(contactEntity);
        contactEntity.setId(id);
        return id;
    }

    public int updateUser(ContactEntity contactEntity) {
        int value = mContactListDao.update(contactEntity);
        ShowLog.d("Updated value", value + "");
        return value;
    }

    public void deleteAllUsers() {
        mContactListDao.deleteAllContacts();
    }

    public void deleteItem(ContactEntity contactEntity) {
        mContactListDao.delete(contactEntity);
    }

    public List<ContactEntity> getAllUser() {
        return mContactListDao.getAllUser();
    }

    public LiveData<List<ContactEntity>> getAllUserLiveData() {
        return mContactListDao.getAllContactLiveData();
    }

    public LiveData<List<ContactEntity>> getUsers() {
        return mContactListDao.getAllContactLiveData();
    }
}
