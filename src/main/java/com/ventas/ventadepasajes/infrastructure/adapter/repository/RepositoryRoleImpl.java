package com.ventas.ventadepasajes.infrastructure.adapter.repository;

import com.ventas.ventadepasajes.domain.model.entity.Role;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryRole;
import com.ventas.ventadepasajes.infrastructure.entity.EntityRole;
import com.ventas.ventadepasajes.infrastructure.jparepository.JpaRoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class RepositoryRoleImpl implements RepositoryRole {

    private ModelMapper modelMapper = new ModelMapper();
    private JpaRoleRepository jpaRoleRepository;

    public RepositoryRoleImpl(JpaRoleRepository jpaRoleRepository){
        this.jpaRoleRepository = jpaRoleRepository;
    }

    @Override
    public Role createRole(Role role) {
        EntityRole entityRole = this.modelMapper.map(role, EntityRole.class);
        EntityRole entityRoleSaved = this.jpaRoleRepository.save(entityRole);
        return new Role(entityRoleSaved.getId(), entityRoleSaved.getName());
    }

    @Override
    public List<Role> listRole() {
        List<EntityRole> listRole = this.jpaRoleRepository.findAll();
        return listRole.stream().map(e -> Role.valueOf(e)).collect(Collectors.toList());
    }

    @Override
    public boolean deleteRole(long id) {
        try{
            this.jpaRoleRepository.deleteById(id);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    @Override
    public Role updateRole(long id, Role newRole) {
        EntityRole entityRole = this.modelMapper.map(newRole, EntityRole.class);
        EntityRole entityRoleUpdated = this.jpaRoleRepository.findById(id)
                .map(role ->{
                    role.setId(newRole.getId());
                    role.setName(newRole.getName());
                    return jpaRoleRepository.save(role);
                }).orElseGet(() ->{
                    entityRole.setId(id);
                    entityRole.setName(newRole.getName());
                    return jpaRoleRepository.save(entityRole);
                });

        return new Role(entityRoleUpdated.getId(), entityRoleUpdated.getName());
    }
}
