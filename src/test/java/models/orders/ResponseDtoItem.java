package models.orders;

import java.util.List;
import lombok.Data;

@Data
public class ResponseDtoItem{
	private List<String> images;
	private Integer price;
	private Double rating;
	private String description;
	private Integer id;
	private Boolean isBasketDiscount;
	private String title;
	private Integer stock;
	private String category;
	private String brand;
	private Integer basketDiscountPercentage;
	private Boolean isActive;
}