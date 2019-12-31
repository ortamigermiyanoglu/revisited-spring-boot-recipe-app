package com.sumutella.recipe.services;

import com.sumutella.recipe.dto.UnitOfMeasureDto;
import com.sumutella.recipe.mapper.UnitOfMeasureMapper;
import com.sumutella.recipe.model.UnitOfMeasure;
import com.sumutella.recipe.repository.UnitOfMeasureRepository;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sumutella
 * @time 12:57 AM
 * @since 12/31/2019, Tue
 */
@Service
public class UnitOfMeasureServiceImpl implements UnitOfMeasureService{

    private final UnitOfMeasureMapper unitOfMeasureMapper = Mappers.getMapper(UnitOfMeasureMapper.class);

    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public UnitOfMeasureServiceImpl(UnitOfMeasureRepository unitOfMeasureRepository) {
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }


    @Override
    public List<UnitOfMeasureDto> listAllUoms() {
        List<UnitOfMeasureDto> unitOfMeasureDtos = new ArrayList<>();
        unitOfMeasureRepository.findAll().forEach(unitOfMeasureDto -> unitOfMeasureDtos.add(unitOfMeasureMapper.entityToDto(unitOfMeasureDto)));
        return unitOfMeasureDtos;
    }
}
