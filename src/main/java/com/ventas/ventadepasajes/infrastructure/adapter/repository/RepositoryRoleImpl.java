package com.ventas.ventadepasajes.infrastructure.adapter.repository;

import com.ventas.ventadepasajes.domain.exceptions.ExceptionGeneral;
import com.ventas.ventadepasajes.domain.model.entity.Role;
import com.ventas.ventadepasajes.domain.port.repository.RepositoryRole;
import com.ventas.ventadepasajes.infrastructure.adapter.repository.mapper.MapperRole;
import com.ventas.ventadepasajes.infrastructure.entity.EntityRole;
import com.ventas.ventadepasajes.infrastructure.jparepository.JpaRoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public class RepositoryRoleImpl implements RepositoryRole {

    private JpaRoleRepository jpaRoleRepository;
    private Logger logger = LoggerFactory.getLogger(RepositoryRoleImpl.class);
    private MapperRole mapperRole = new MapperRole();

    public RepositoryRoleImpl(JpaRoleRepository jpaRoleRepository){
        this.jpaRoleRepository = jpaRoleRepository;
    }

    @Override
    public Role createRole(Role role) {
        EntityRole entityRole = this.mapperRole.modelToEntity(role);
        EntityRole entityRoleSaved = this.jpaRoleRepository.save(entityRole);
        return new Role(entityRoleSaved.getIdEntity(), entityRoleSaved.getNameEntity());
    }

    @Override
    public List<Role> listRole() {
        return this.mapperRole.entityToModelList(this.jpaRoleRepository.findAll());
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
        EntityRole entityRole = this.mapperRole.modelToEntity(newRole);
        EntityRole entityRoleUpdated = this.jpaRoleRepository.findById(id)
                .map(role ->{
                    role.setIdEntity(newRole.getId());
                    role.setNameEntity(newRole.getName());
                    return jpaRoleRepository.save(role);
                }).orElseGet(() ->{
                    entityRole.setIdEntity(id);
                    entityRole.setNameEntity(newRole.getName());
                    return jpaRoleRepository.save(entityRole);
                });

        return new Role(entityRoleUpdated.getIdEntity(), entityRoleUpdated.getNameEntity());
    }

    @Override
    public boolean searchRole(long id) {
        Optional<EntityRole> entityRole = this.jpaRoleRepository.searchRole(id);
        if(!entityRole.isPresent()){
            throw new ExceptionGeneral("There are no roles with id " + id);
        }
        return true;
    }
}
