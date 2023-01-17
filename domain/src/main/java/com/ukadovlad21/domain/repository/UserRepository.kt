package com.ukadovlad21.domain.repository

import com.ukadovlad21.domain.models.SaveUserNameParam
import com.ukadovlad21.domain.models.UserName

interface UserRepository {

    fun saveName(saveUserNameParam: SaveUserNameParam): Boolean

    fun getName(): UserName
}