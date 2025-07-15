package mts.mtech.appointments.persistence;

import mts.mtech.appointments.domain.User;

import java.util.Optional;

public interface UserRepository extends BaseRepository<User> {
    Optional<User> findByEmail(String email);
}
