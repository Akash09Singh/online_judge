package com.spoj.online_judge.Roles.RolesServiceImpl;

import com.spoj.online_judge.Roles.Repository.RolesRepository;
import com.spoj.online_judge.Roles.Service.RolesService;
import com.spoj.online_judge.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolesServiceImpl implements RolesService {
    private RolesRepository rolesRepository;

    public RolesServiceImpl(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    @Override
    public Role createRole(Role role) {
        return rolesRepository.save(role);
    }

    @Override
    public Optional<Role> getRoleById(int theId) {
        return rolesRepository.findById(theId);
    }

    @Override
    public Role getRoleByRoleName(String roleName) {
        return rolesRepository.findByRole(roleName);
    }

    @Override
    public List<Role> findAllRole() {
        return rolesRepository.findAll();
    }


}
