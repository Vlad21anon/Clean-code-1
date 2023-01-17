package com.ukadovlad21.data.repository

import com.ukadovlad21.data.storage.models.User
import com.ukadovlad21.data.storage.sharedprefs.UserStorage
import com.ukadovlad21.domain.models.SaveUserNameParam
import com.ukadovlad21.domain.models.UserName
import com.ukadovlad21.domain.repository.UserRepository

//В data ТОЛЬКО СОХРАНЕНИЕ И ПОЛУЧЕНИЕ ИНФОРМАЦИИ.
// Реализация интерфейса
class UserRepositoryImpl(private val userStorage: UserStorage) :
    UserRepository {

    override fun saveName(saveParam: SaveUserNameParam): Boolean {

        val user = mapToStorage(saveParam)

        val result = userStorage.save(user)
        return result
    }


    override fun getName(): UserName {
        val user = userStorage.get()

        return mapToDomain(user)
    }


    private fun mapToStorage(saveParam: SaveUserNameParam): User {
        return User(firstName = saveParam.name, lastName = "'lastname'")
    }

    private fun mapToDomain(user: User): UserName {
        return UserName(firstname = user.firstName,
            lastname = user.lastName)
    }


}