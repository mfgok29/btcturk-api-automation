package models.orderById;

import java.util.List;
import lombok.Data;

@Data
public class OrderResponseDto{
	private Integer id;
	private Integer price;
	private Double rating;
	private String description;
	private Boolean isBasketDiscount;
	private String title;
	private Integer stock;
	private String category;
	private String brand;
	private List<String> images;
	private Integer basketDiscountPercentage;
	private Boolean isActive;
}