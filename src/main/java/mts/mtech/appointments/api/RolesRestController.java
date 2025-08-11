package mts.mtech.appointments.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import mts.mtech.appointments.domain.Roles;
import mts.mtech.appointments.dto.ResponseWrapper;
import mts.mtech.appointments.dto.RoleRequestDto;
import mts.mtech.appointments.services.RolesService;
import mts.mtech.appointments.utils.Constants;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Mitchell Tawanda Severa
 * @created 06/09/2022 - 10:31 PM
 */
@RestController
@RequestMapping("/v1/roles")
@Tag(name = "Roles API", description = "Displays available system roles")
@CrossOrigin
public class RolesRestController {
  private final RolesService rolesService;

  public RolesRestController(RolesService rolesService) {
    this.rolesService = rolesService;
  }

  @GetMapping("/list")
  @Operation(summary = "Retrieve roles", description = "API returns available system defined roles")
  public ResponseWrapper<List<Roles>> getUserRoles(){
    return new ResponseWrapper<List<Roles>>()
            .buildSuccessResponse(Constants.SUCCESS, rolesService.getUserRoles());
  }

  @PostMapping("/create")
  @Operation(summary = "Create role", description = "API creates a new role in the system")
  public ResponseWrapper<Roles> createRole(@RequestBody RoleRequestDto roleRequestDto) {
    return new ResponseWrapper<Roles>()
            .buildSuccessResponse(Constants.SUCCESS, rolesService.createRole(roleRequestDto));
  }

  @GetMapping("/view/{roleId}")
  @Operation(summary = "View role by id", description = "API retrieves a role in the system by id")
  public ResponseWrapper<Roles> getRole(@PathVariable Long roleId) {
    return new ResponseWrapper<Roles>()
            .buildSuccessResponse(Constants.SUCCESS, rolesService.getRole(roleId));
  }

  @PutMapping("/update/{roleId}")
  @Operation(summary = "Update role", description = "API updates a role in the system")
  public ResponseWrapper<Roles> updateRole(@RequestBody RoleRequestDto roleRequestDto,
                                       @PathVariable Long roleId) {
    return new ResponseWrapper<Roles>()
            .buildSuccessResponse(Constants.SUCCESS, rolesService.updateRole(roleRequestDto, roleId));
  }
  
}
