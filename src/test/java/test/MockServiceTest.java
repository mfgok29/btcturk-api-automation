package test;

import btcturk.helpers.DataProviderHelper;
import models.orderById.OrderResponseDto;
import models.orders.ResponseDto;
import models.orders.ResponseDtoItem;
import org.testng.annotations.Test;
import services.MockService;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;
import static verification.RequestSpec.requestSpecification;
import static verification.ResponseSpec.checkStatusCodeNotFound;
import static verification.ResponseSpec.checkStatusCodeOk;

public class MockServiceTest {

    MockService mockService = new MockService();

    @Test
    public void field_type_check() {
        ResponseDto responseDto = mockService.getOrders(requestSpecification(), checkStatusCodeOk()).as(ResponseDto.class);

        for (int i = 0; i < responseDto.getResponse().size(); i++) {
            ResponseDtoItem responseDtoItem = responseDto.getResponse().get(i);

            if (responseDtoItem.getIsActive() != null) {
                assertThat(responseDtoItem.getImages(), instanceOf(List.class));
                assertThat(responseDtoItem.getCategory(), instanceOf(String.class));
                assertThat(responseDtoItem.getRating(), instanceOf(Double.class));
                assertThat(responseDtoItem.getDescription(), instanceOf(String.class));
                assertThat(responseDtoItem.getId(), instanceOf(Integer.class));
                assertThat(responseDtoItem.getBrand(), instanceOf(String.class));
                assertThat(responseDtoItem.getPrice(), instanceOf(Integer.class));
                assertThat(responseDtoItem.getStock(), instanceOf(Integer.class));
                assertThat(responseDtoItem.getTitle(), instanceOf(String.class));
                assertThat(responseDtoItem.getIsActive(), instanceOf(Boolean.class));
                assertThat(responseDtoItem.getBasketDiscountPercentage(), instanceOf(Integer.class));
                assertThat(responseDtoItem.getIsBasketDiscount(), instanceOf(Boolean.class));
            } else {
                assertThat(responseDtoItem.getImages(), instanceOf(List.class));
                assertThat(responseDtoItem.getCategory(), instanceOf(String.class));
                assertThat(responseDtoItem.getRating(), instanceOf(Double.class));
                assertThat(responseDtoItem.getDescription(), instanceOf(String.class));
                assertThat(responseDtoItem.getId(), instanceOf(Integer.class));
                assertThat(responseDtoItem.getBrand(), instanceOf(String.class));
                assertThat(responseDtoItem.getPrice(), instanceOf(Integer.class));
                assertThat(responseDtoItem.getStock(), instanceOf(Integer.class));
                assertThat(responseDtoItem.getTitle(), instanceOf(String.class));
                assertThat(responseDtoItem.getIsBasketDiscount(), instanceOf(Boolean.class));
            }
        }
        System.out.println("Response da gelen fieldların type ı kontrol edildi.");

    }

    @Test(dataProvider = "invalidOrderId", dataProviderClass = DataProviderHelper.class)
    public void when_check_orderId_not_found_return_404(Integer orderId) {
        mockService.getOrderById(requestSpecification(), orderId, checkStatusCodeNotFound());
        System.out.println("Geçersiz değerler göndererek hata döndüğü görüldü.");
    }

    @Test
    public void response_field_when_must_not_be_null() {
        Integer orderId = 1;
        OrderResponseDto orderResponseDto = mockService.getOrderById(requestSpecification(), orderId, checkStatusCodeOk()).as(OrderResponseDto.class);
        assertNotNull(orderResponseDto.getId());
        assertNotNull(orderResponseDto.getImages());
        assertNotNull(orderResponseDto.getBrand());
        assertNotNull(orderResponseDto.getDescription());
        assertNotNull(orderResponseDto.getCategory());
        assertNotNull(orderResponseDto.getRating());
        assertNotNull(orderResponseDto.getPrice());
        assertNotNull(orderResponseDto.getStock());
        assertNotNull(orderResponseDto.getTitle());
        assertNotNull(orderResponseDto.getBasketDiscountPercentage());
        assertNotNull(orderResponseDto.getIsBasketDiscount());
        assertNotNull(orderResponseDto.getIsActive());

        System.out.println("Null beklemediğimiz değerler için kontrol yapıldı.");
    }

    @Test
    public void response_field_must_null() {
        Integer orderId = 2;
        OrderResponseDto orderResponseDto = mockService.getOrderById(requestSpecification(), orderId, checkStatusCodeOk()).as(OrderResponseDto.class);
        assertNull(orderResponseDto.getBasketDiscountPercentage());
        assertNull(orderResponseDto.getIsActive());
        System.out.println("Null beklediğimiz değerler için kontrol yapıldı.");
    }
}

