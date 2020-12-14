package com.entezeer.core.preferences

interface SharedStorage {
    fun <T> saveObject(key: String, data: T)
    fun <T> getObject(key: String, type: Class<T>): T?
    fun <T> save(key: String, value: T)
    fun <T> get(key: String, defValue: T): T
    fun contains(key: String): Boolean
    fun delete(key: String)
}