package com.github.linzhengen.cleanarchspring.infrastructure.persistence

import jakarta.persistence.Entity
import jakarta.persistence.Id
import org.springframework.data.repository.CrudRepository
import java.util.UUID
import com.github.linzhengen.cleanarchspring.domain.user.User
import jakarta.persistence.Table
import java.time.ZonedDateTime

interface UserDao : CrudRepository<UserEntity, UUID>

@Entity
@Table(name = "users")
class UserEntity(
    @Id var id: UUID,
    var name: String,
    var updated: ZonedDateTime,
    var created: ZonedDateTime,
)

fun UserEntity.toDomainUser() = User(id, name)
