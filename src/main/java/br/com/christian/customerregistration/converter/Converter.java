package br.com.christian.customerregistration.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class Converter<Entity, DTO> {

    @Autowired
    private ModelMapper modelMapper;

    public Entity convertToEntity(DTO dto) {
        return modelMapper.map(dto, getEntityClass());
    }

    public DTO convertToDTO(Entity entity) {
        return modelMapper.map(entity, getDTOClass());
    }

    abstract Class<Entity> getEntityClass();

    abstract Class<DTO> getDTOClass();
}
