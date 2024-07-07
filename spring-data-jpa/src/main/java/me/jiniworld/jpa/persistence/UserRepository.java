package me.jiniworld.jpa.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

interface UserRepository extends JpaRepository<User, Long> {
    <T> Optional<T> getById(long id, Class<T> type);
}
