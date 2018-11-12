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

package com.nurdcoder.android.dphe_phone_directory.data.local.user;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.support.annotation.NonNull;

import com.nurdcoder.android.dphe_phone_directory.data.local.base.RoomEntity;
import com.nurdcoder.android.dphe_phone_directory.data.local.dbstorage.ColumnNames;
import com.nurdcoder.android.dphe_phone_directory.data.local.dbstorage.TableNames;

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

@Entity(tableName = TableNames.CONTACT_LIST)
public class ContactEntity extends RoomEntity {
    @ColumnInfo(name = ColumnNames.NAME_OF_THE_STAFF)
    public String NAME_OF_THE_STAFF;
    @ColumnInfo(name = ColumnNames.TELEPHONE)
    public String TELEPHONE;
    @ColumnInfo(name = ColumnNames.EMAIL)
    public String EMAIL;
    @ColumnInfo(name = ColumnNames.FAX)
    public String FAX;
    @ColumnInfo(name = ColumnNames.DESIGNATION)
    public String DESIGNATION;
    @ColumnInfo(name = ColumnNames.OFFICE)
    public String OFFICE;
    @ColumnInfo(name = ColumnNames.CATEGORY)
    public String CATEGORY;
    @ColumnInfo(name = ColumnNames.SUBCATEGORY)
    public String SUBCATEGORY;

    public ContactEntity(String NAME_OF_THE_STAFF, String TELEPHONE, String EMAIL, String FAX, String DESIGNATION, String OFFICE, String CATEGORY, String SUBCATEGORY) {
        this.NAME_OF_THE_STAFF = NAME_OF_THE_STAFF;
        this.TELEPHONE = TELEPHONE;
        this.EMAIL = EMAIL;
        this.FAX = FAX;
        this.DESIGNATION = DESIGNATION;
        this.OFFICE = OFFICE;
        this.CATEGORY = CATEGORY;
        this.SUBCATEGORY = SUBCATEGORY;
    }

    public String getNAME_OF_THE_STAFF() {
        return NAME_OF_THE_STAFF;
    }

    public void setNAME_OF_THE_STAFF(String NAME_OF_THE_STAFF) {
        this.NAME_OF_THE_STAFF = NAME_OF_THE_STAFF;
    }

    public String getTELEPHONE() {
        return TELEPHONE;
    }

    public void setTELEPHONE(String TELEPHONE) {
        this.TELEPHONE = TELEPHONE;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getFAX() {
        return FAX;
    }

    public void setFAX(String FAX) {
        this.FAX = FAX;
    }

    public String getDESIGNATION() {
        return DESIGNATION;
    }

    public void setDESIGNATION(String DESIGNATION) {
        this.DESIGNATION = DESIGNATION;
    }

    public String getOFFICE() {
        return OFFICE;
    }

    public void setOFFICE(String OFFICE) {
        this.OFFICE = OFFICE;
    }

    public String getCATEGORY() {
        return CATEGORY;
    }

    public void setCATEGORY(String CATEGORY) {
        this.CATEGORY = CATEGORY;
    }

    public String getSUBCATEGORY() {
        return SUBCATEGORY;
    }

    public void setSUBCATEGORY(String SUBCATEGORY) {
        this.SUBCATEGORY = SUBCATEGORY;
    }
}