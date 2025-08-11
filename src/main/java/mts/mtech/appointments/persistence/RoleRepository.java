package mts.mtech.appointments.persistence;

import mts.mtech.appointments.domain.Roles;

import java.util.Optional;

public interface RoleRepository extends BaseRepository<Roles> {
  Optional<Roles> findByName(String name);
}