package models.orders;

import java.util.List;

import lombok.Data;

@Data
public class ResponseDto{
	private List<ResponseDtoItem> response;
}