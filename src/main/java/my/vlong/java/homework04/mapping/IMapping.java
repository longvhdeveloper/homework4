package my.vlong.java.homework04.mapping;

import java.util.List;

public interface IMapping<E, DTO> {

    E toEntity(DTO dto);

    DTO toDTO(E entity);

    List<E> toEntities(List<DTO> dtos);

    List<DTO> toDTOs(List<E> entities);
}
