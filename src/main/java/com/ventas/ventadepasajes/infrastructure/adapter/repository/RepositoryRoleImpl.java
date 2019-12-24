package com.ventas.ventadepasajes.infrastructure.adapter.repository;

import com.ventas.ventadepasajes.domain.exceptions.ExceptionGeneral;
import com.ventas.ventadepasajes.domain.model.entity.Role;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryRole;
import com.ventas.ventadepasajes.infrastructure.adapter.repository.mapper.MapperRole;
import com.ventas.ventadepasajes.infrastructure.entity.EntityRole;
import com.ventas.ventadepasajes.infrastructure.jparepository.JpaRoleRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositoryRoleImpl implements RepositoryRole {

    private ModelMapper modelMapper = new ModelMapper();
    private JpaRoleRepository jpaRoleRepository;
    private Logger logger = LoggerFactory.getLogger(RepositoryRoleImpl.class);

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
        MapperRole mapperRole = new MapperRole();
        return mapperRole.entityToModelList(this.jpaRoleRepository.findAll());
    }

    @Override
    public boolean deleteRole(long id) {
        try{
            this.jpaRoleRepository.deleteById(id);
            return true;
        }catch (Exception e){
            logger.info("Error deleting role");
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

    @Override
    public Role searchRole(long id) {
        EntityRole entityRole = this.jpaRoleRepository.searchRole(id);
        try{
            return this.modelMapper.map(entityRole, Role.class);
        }catch (Exception e){
            throw new ExceptionGeneral("There are no roles with id " + id);
        }
    }
}
