package com.ukadovlad21.domain.usecase

import com.ukadovlad21.domain.models.SaveUserNameParam
import com.ukadovlad21.domain.repository.UserRepository


//В domain ДОЛЖНА НАХОДИТЬСЯ ВСЯ ЛОГИКА
class SaveUserNameUseCase(private val userRepository: UserRepository) {


    fun execute(param: SaveUserNameParam): Boolean {

        val oldUserName = userRepository.getName()

        if (oldUserName.firstname == param.name) {
            return true
        }

        val result = userRepository.saveName(param)

        return result
    }

}