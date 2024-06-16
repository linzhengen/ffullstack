package com.github.linzhengen.cleanarchspring.domain.user

interface UserRepository {
    fun save(user: User): User
}
