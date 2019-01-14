package my.vlong.java.homework04.mapping;

public interface IMapping<E, DTO> {

    E toEntity(DTO dto);

    DTO toDTO(E entity);
}
