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
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.nurdcoder.android.dphe_phone_directory.data.local.base.BaseDao;
import com.nurdcoder.android.dphe_phone_directory.data.local.dbstorage.ColumnNames;
import com.nurdcoder.android.dphe_phone_directory.data.local.dbstorage.TableNames;

import java.util.List;

import io.reactivex.Flowable;

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

@Dao
public interface ContactListDao extends BaseDao<ContactEntity> {
    @Query("SELECT * FROM " + TableNames.CONTACT_LIST)
    List<ContactEntity> getAllUser();

    @Query("SELECT * FROM " + TableNames.CONTACT_LIST)
    LiveData<List<ContactEntity>> getAllContactLiveData();

    @Query("SELECT * FROM " + TableNames.CONTACT_LIST + " WHERE " + ColumnNames.SUBCATEGORY + " = :subcategory")
    Flowable<List<ContactEntity>> getAllContactBySubCategory(String subcategory);

    @Query("SELECT * FROM " + TableNames.CONTACT_LIST + " WHERE " + ColumnNames.TELEPHONE + " = :number")
    ContactEntity getContact(String number);

    @Query("SELECT * FROM " + TableNames.CONTACT_LIST + " WHERE " + ColumnNames.ID + " = :id")
    ContactEntity getContactById(long id);

    /**
     * Delete all users.
     */
    @Query("DELETE FROM " + TableNames.CONTACT_LIST)
    void deleteAllContacts();
}