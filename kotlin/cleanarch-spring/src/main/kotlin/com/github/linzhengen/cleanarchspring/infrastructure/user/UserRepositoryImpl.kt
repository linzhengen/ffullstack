package com.github.linzhengen.cleanarchspring.infrastructure.user

import com.github.linzhengen.cleanarchspring.domain.user.User
import com.github.linzhengen.cleanarchspring.domain.user.UserRepository
import com.github.linzhengen.cleanarchspring.infrastructure.persistence.UserDao
import com.github.linzhengen.cleanarchspring.infrastructure.persistence.UserEntity
import com.github.linzhengen.cleanarchspring.infrastructure.persistence.toDomainUser
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl(private val userDao: UserDao): UserRepository {
    override fun save(user: User): User {
        return userDao.save(UserEntity(user.id, user.name)).toDomainUser()
    }
}
