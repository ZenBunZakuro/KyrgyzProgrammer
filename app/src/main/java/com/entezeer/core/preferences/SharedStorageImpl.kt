package com.entezeer.core.preferences

import android.annotation.SuppressLint
import android.content.Context
import com.google.gson.Gson
import java.io.IOException

@Suppress("UNCHECKED_CAST")
class SharedStorageImpl(context: Context, name: String) : SharedStorage {
    private var sharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE)

    @SuppressLint("CommitPrefEdits")
    override fun <T> save(key: String, value: T) {
        when (value) {
            is String -> sharedPreferences.edit().putString(key, value.toString()).apply()
            is Set<*> -> sharedPreferences.edit().putStringSet(key, value as Set<String>).apply()
            is Int -> sharedPreferences.edit().putInt(key, value as Int)
            is Long -> sharedPreferences.edit().putLong(key, value as Long).apply()
            is Float -> sharedPreferences.edit().putFloat(key, value as Float).apply()
            is Boolean -> sharedPreferences.edit().putBoolean(key, value as Boolean).apply()
        }
    }

    override fun <T> get(key: String, defValue: T): T {
        return when (defValue) {
            is Set<*> -> sharedPreferences.getStringSet(key, defValue as Set<String>) as T
            is String -> sharedPreferences.getString(key, defValue) as T
            is Int -> sharedPreferences.getInt(key, defValue) as T
            is Long -> sharedPreferences.getLong(key, defValue) as T
            is Float -> sharedPreferences.getFloat(key, defValue) as T
            is Boolean -> sharedPreferences.getBoolean(key, defValue) as T
            else -> defValue
        }
    }

    override fun <T> saveObject(key: String, data: T) {
        sharedPreferences.edit().putString(key, Gson().toJson(data)).apply()
    }

    override fun <T> getObject(key: String, type: Class<T>): T? = try {
        Gson().fromJson(sharedPreferences.getString(key, ""), type)
    } catch (e: IOException) {
        null
    }

    override fun contains(key: String): Boolean {
        return sharedPreferences.contains(key)
    }

    override fun delete(key: String) {
        sharedPreferences.edit()?.remove(key)?.apply()
    }
}



