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

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.os.Parcel;
import android.os.Parcelable;

import com.nurdcoder.android.dphe_phone_directory.data.local.base.RoomEntity;
import com.nurdcoder.android.dphe_phone_directory.data.local.dbstorage.ColumnNames;
import com.nurdcoder.android.dphe_phone_directory.data.local.dbstorage.TableNames;
import com.nurdcoder.android.util.helper.StringUtils;

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
public class ContactEntity extends RoomEntity implements Parcelable {
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

    public static final Parcelable.Creator<ContactEntity> CREATOR = new Parcelable.Creator<ContactEntity>() {
        @Override
        public ContactEntity createFromParcel(Parcel source) {
            return new ContactEntity(source);
        }

        @Override
        public ContactEntity[] newArray(int size) {
            return new ContactEntity[size];
        }
    };

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

    protected ContactEntity(Parcel in) {
        this.NAME_OF_THE_STAFF = in.readString();
        this.TELEPHONE = in.readString();
        this.EMAIL = in.readString();
        this.FAX = in.readString();
        this.DESIGNATION = in.readString();
        this.OFFICE = in.readString();
        this.CATEGORY = in.readString();
        this.SUBCATEGORY = in.readString();
    }

    public void setDESIGNATION(String DESIGNATION) {
        this.DESIGNATION = DESIGNATION;
    }

    public String getNAME_OF_THE_STAFF() {
        if (StringUtils.isNullOrEmpty(NAME_OF_THE_STAFF)) {
            return "Unknown Staff Name";
        }
        return NAME_OF_THE_STAFF;
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

    public String getDESIGNATION() {
        if (StringUtils.isNullOrEmpty(DESIGNATION)) {
            return "Unknown Designation";
        }
        return DESIGNATION;
    }

    public String getOFFICE() {
        if (StringUtils.isNullOrEmpty(OFFICE)) {
            return "Unknown Office Address";
        }
        return OFFICE;
    }

    @Override
    public String toString() {
        return "ContactEntity{" +
                "NAME_OF_THE_STAFF='" + NAME_OF_THE_STAFF + '\'' +
                ", TELEPHONE='" + TELEPHONE + '\'' +
                ", EMAIL='" + EMAIL + '\'' +
                ", FAX='" + FAX + '\'' +
                ", DESIGNATION='" + DESIGNATION + '\'' +
                ", OFFICE='" + OFFICE + '\'' +
                ", CATEGORY='" + CATEGORY + '\'' +
                ", SUBCATEGORY='" + SUBCATEGORY + '\'' +
                ", mId=" + mId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContactEntity)) return false;
        ContactEntity that = (ContactEntity) o;
        return Objects.equals(getNAME_OF_THE_STAFF(), that.getNAME_OF_THE_STAFF()) &&
                Objects.equals(getTELEPHONE(), that.getTELEPHONE()) &&
                Objects.equals(getEMAIL(), that.getEMAIL()) &&
                Objects.equals(getFAX(), that.getFAX()) &&
                Objects.equals(getDESIGNATION(), that.getDESIGNATION()) &&
                Objects.equals(getOFFICE(), that.getOFFICE()) &&
                Objects.equals(getCATEGORY(), that.getCATEGORY()) &&
                Objects.equals(getSUBCATEGORY(), that.getSUBCATEGORY());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getNAME_OF_THE_STAFF(), getTELEPHONE(), getEMAIL(), getFAX(), getDESIGNATION(), getOFFICE(), getCATEGORY(), getSUBCATEGORY());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.NAME_OF_THE_STAFF);
        dest.writeString(this.TELEPHONE);
        dest.writeString(this.EMAIL);
        dest.writeString(this.FAX);
        dest.writeString(this.DESIGNATION);
        dest.writeString(this.OFFICE);
        dest.writeString(this.CATEGORY);
        dest.writeString(this.SUBCATEGORY);
    }
}