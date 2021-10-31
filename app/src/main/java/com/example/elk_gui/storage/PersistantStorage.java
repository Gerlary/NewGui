package com.example.elk_gui.storage;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Set;

public class PersistantStorage {
    public static final String STORAGE_NAME = "StorageName";

    private static SharedPreferences settings = null;
    private static SharedPreferences.Editor editor = null;
    private static Context context = null;

    public static void init( Context cntxt ){
        context = cntxt;
    }

    private static void init(){
        settings = context.getSharedPreferences(STORAGE_NAME, Context.MODE_PRIVATE);
        editor = settings.edit();
    }

    public static void addName( String name, String value ){
        if( settings == null ){
            init();
        }
        editor.putString( name, value );
        editor.apply();
    }
    public static void addInt( String name, Integer value ){
        if( settings == null ){
            init();
        }
        editor.putInt( name, value );
        editor.apply();
    }
    public static void addTestValue( String name, Boolean value ){
        if( settings == null ){
            init();
        }
        editor.putBoolean( name, value );
        editor.apply();
    }

    public static String getName( String name ){
        if( settings == null ){
            init();
        }
        return settings.getString( name, "UserName" );
    }
    public static Boolean getTestValue( String name ){
        if( settings == null ){
            init();
        }
        return settings.getBoolean( name, false );
    }
    public static int getInt(String name ){
        if( settings == null ){
            init();
        }
        return settings.getInt( name, 20 );
    }

}