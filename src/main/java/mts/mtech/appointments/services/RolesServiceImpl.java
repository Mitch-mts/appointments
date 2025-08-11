package mts.mtech.appointments.services;

import lombok.extern.slf4j.Slf4j;
import mts.mtech.appointments.domain.Roles;
import mts.mtech.appointments.dto.RoleRequestDto;
import mts.mtech.appointments.exceptions.RecordNotFoundException;
import mts.mtech.appointments.persistence.RoleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Mitchell Tawanda Severa
 * @created 06/09/2022 - 10:34 PM
 */
@Service
@Slf4j
public class RolesServiceImpl implements RolesService{
  private final RoleRepository roleRepository;

  public RolesServiceImpl(RoleRepository roleRepository) {
    this.roleRepository = roleRepository;
  }

  @Override
  public Roles createRole(RoleRequestDto roleRequstDto) {
    Roles roles = new Roles();
    roles.setName(roleRequstDto.roleName().replace(" ", "_").toUpperCase());
    roles.setDescription(roleRequstDto.description());
    roles.setDateCreated(LocalDateTime.now());
    return roleRepository.save(roles);
  }

  @Override
  public Roles updateRole(RoleRequestDto requstDto, Long roleId) {
    Roles existingRole = roleRepository.findById(roleId)
            .orElseThrow(() -> new RecordNotFoundException("Role not found"));

    existingRole.setName(requstDto.roleName());
    existingRole.setDescription(requstDto.description());
    return roleRepository.save(existingRole);
  }

  @Override
  public Roles getRole(Long roleId) {
    return roleRepository.findById(roleId)
            .orElseThrow(() -> new RecordNotFoundException("Role not found"));
  }

  @Override
  public List<Roles> getUserRoles() {
    return roleRepository.findAll();
  }
}
