package me.jiniworld.jpa.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

interface UserRepository extends JpaRepository<User, Long> {
    <T> Optional<T> getById(long id, Class<T> type);

    @Transactional
    @Modifying
    @Query("update User u set u.level = ?1 where u.active = ?2")
    int updateLevelByActive(Integer level, Integer active);


    @Transactional
    @Modifying
    @Query("delete User u where u.active = ?1")
    int deleteBulkByActive(Integer active);


    @Transactional
    int deleteAllByActive(Integer active);
}
