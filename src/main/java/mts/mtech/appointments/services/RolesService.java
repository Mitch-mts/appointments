package mts.mtech.appointments.services;

import mts.mtech.appointments.domain.Roles;
import mts.mtech.appointments.dto.RoleRequestDto;

import java.util.List;

public interface RolesService {
    Roles createRole(RoleRequestDto roleName);
    Roles updateRole(RoleRequestDto roleName, Long roleId);
    Roles getRole(Long roleId);
    List<Roles> getUserRoles();
}
