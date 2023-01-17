package com.ukadovlad21.domain.usecase

import com.ukadovlad21.domain.models.UserName
import com.ukadovlad21.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {


    fun execute(): UserName {
        return userRepository.getName()
    }


}