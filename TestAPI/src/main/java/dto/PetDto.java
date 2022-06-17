package dto;

import lombok.Data;

import java.util.List;

@Data
public class PetDto {

	private long id;
	private dto.CategoryDto CategoryDto;
	private String name;
	private List<String> photoUrls;
	private List<dto.TagDto> tags;
	private dto.StatusDto StatusDto;
}