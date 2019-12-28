package com.sumutella.recipe.mapper;

import com.sumutella.recipe.dto.NoteDto;
import com.sumutella.recipe.model.Note;
import org.mapstruct.Mapper;

/**
 * @author sumutella
 * @time 2:39 PM
 * @since 12/28/2019, Sat
 */
@Mapper
public interface NoteMapper {
    Note dtoToEntity(NoteDto noteDto);
    NoteDto entityToDto(Note note);
}
