package btcturk.models;

import java.util.List;

import lombok.Builder;
import lombok.Data;

import static btcturk.helpers.HelperMethods.*;

@Data
@Builder
public class OrderModelItem {

	@Builder.Default
	private int id = 1;

	@Builder.Default
	private String title = getRandomTitle();

	@Builder.Default
	private String description = getRandomDescription();

	@Builder.Default
	private Integer price  = getRandomPrice();

	@Builder.Default
	private Boolean isBasketDiscount = true;

	@Builder.Default
	private Double rating = getRandomRating();

	@Builder.Default
	private Integer stock = getRandomStock();

	@Builder.Default
	private String brand = getRandomBrand();

	@Builder.Default
	private String category = getRandomCategory();

	@Builder.Default
	private List<String> images = List.of(getRandomUrl(),getRandomUrl());

	private Boolean isActive;

	private Integer basketDiscountPercentage;


}