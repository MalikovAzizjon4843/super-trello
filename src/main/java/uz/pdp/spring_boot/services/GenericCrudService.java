package uz.pdp.spring_boot.services;

import uz.pdp.spring_boot.criteria.GenericCriteria;
import uz.pdp.spring_boot.dto.Dto;
import uz.pdp.spring_boot.dto.GenericDto;
import uz.pdp.spring_boot.entity.BaseEntity;

import java.io.Serializable;

/**
 * @param <E>  -> Entity
 * @param <D>  -> Dto
 * @param <CD> -> Create Dto
 * @param <UD> -> Update Dto
 * @param <K>  -> class that defines the primary key for your pojo class
 * @param <C>  -> Criteria (For Filtering Request)
 */
public interface GenericCrudService<
        E extends BaseEntity,
        D extends GenericDto,
        CD extends Dto,
        UD extends GenericDto,
        C extends GenericCriteria,
        K extends Serializable> extends GenericService<D, C, K> {

    K create(CD createDto);

    Void delete(K id);

    Void update(UD updateDto);

}
