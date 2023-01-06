package btcturk.controller;

import btcturk.exception.OrderNotFoundException;
import btcturk.models.OrderModelItem;
import btcturk.models.OrderModelDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@RequestMapping("v1/api/orders")
public class MockController {


    @GetMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody OrderModelDto getAll() {
        List<OrderModelItem> responseItems = List.of(
                OrderModelItem.builder().isBasketDiscount(false).id(1).isActive(false).basketDiscountPercentage(10).build(),
                OrderModelItem.builder().isBasketDiscount(true).id(2).build());


        return OrderModelDto.builder().response(responseItems).build();
    }

    @GetMapping(value = "/by-id", consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody OrderModelItem getById(@RequestParam("id") Integer id) {
        OrderModelItem responseItem = null;

        for (int i = 0; i < getAll().getResponse().size(); i++) {
            if (id == getAll().getResponse().get(i).getId()) {
                responseItem = getAll().getResponse().get(i);
            }

        }
        if (responseItem == null){
            throw new OrderNotFoundException("order not found");
        }
        return responseItem;
    }
}
