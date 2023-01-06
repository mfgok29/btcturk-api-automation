package btcturk.models;

import java.util.Collections;
import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderModelDto {

	@Builder.Default
	private List<OrderModelItem> response = Collections.singletonList(OrderModelItem.builder().build());
}