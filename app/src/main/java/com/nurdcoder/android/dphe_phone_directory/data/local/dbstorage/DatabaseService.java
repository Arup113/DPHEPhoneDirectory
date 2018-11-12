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

package com.nurdcoder.android.dphe_phone_directory.data.local.dbstorage;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;

import com.fstyle.library.helper.AssetSQLiteOpenHelperFactory;
import com.nurdcoder.android.dphe_phone_directory.R;
import com.nurdcoder.android.dphe_phone_directory.data.local.user.ContactEntity;
import com.nurdcoder.android.dphe_phone_directory.data.local.user.ContactListDao;
import com.nurdcoder.android.util.helper.Converter;
import com.nurdcoder.android.util.lib.roomdb.AppDatabase;

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

@Database(entities = {
        ContactEntity.class},
        version = 1, exportSchema = false)
@TypeConverters({Converter.class})
public abstract class DatabaseService extends AppDatabase {

    private static final String MIGRATION_SQL_1_2 = "ALTER TABLE  Employee ADD COLUMN address TEXT";

    private static final String DB_NAME = "dphe.db";
    /*
    public static AppDatabaseService on(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabaseService.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabaseService.class, context.getString(R.string.app_name))
                            .build();
                }
            }
        }

        return INSTANCE;
    }
    */
    private static volatile DatabaseService sInstance;

    // Create the database
    private static DatabaseService createOld(Context context) {
        RoomDatabase.Builder<DatabaseService> builder =
                Room.databaseBuilder(context, DatabaseService.class, context.getString(R.string.app_name))
                        .allowMainThreadQueries();

        return builder.build();
    }

    // Get a database instance
    public static synchronized DatabaseService on() {
        return sInstance;
    }

    public static synchronized DatabaseService init(Context context) {

        if (sInstance == null) {
//            synchronized (DatabaseService.class) {
//                sInstance = createDb(context, context.getString(R.string.app_name), DatabaseService.class
//                        , MIGRATION_SQL_1_2);
//            }

            sInstance = Room.databaseBuilder(context, DatabaseService.class, DB_NAME)
                    .openHelperFactory(new AssetSQLiteOpenHelperFactory())
                    .build();
        }

        return sInstance;
    }

    public abstract ContactListDao contactListDao();

    @Override
    public void clearAllTables() {

    }
}