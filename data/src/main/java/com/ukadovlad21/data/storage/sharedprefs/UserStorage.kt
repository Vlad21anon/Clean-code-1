package com.ukadovlad21.data.storage.sharedprefs

import com.ukadovlad21.data.storage.models.User


interface UserStorage {

    fun save(user: User): Boolean

    fun get(): User

}