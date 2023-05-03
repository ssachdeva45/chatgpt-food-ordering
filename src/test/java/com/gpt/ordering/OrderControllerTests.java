package com.gpt.ordering;

import com.gpt.ordering.controller.OrderController;
import com.gpt.ordering.model.Item;
import com.gpt.ordering.model.Order;
import com.gpt.ordering.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest(OrderController.class)
public class OrderControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderRepository orderRepository;

    @Test
    public void testCreateOrder() throws Exception {
        List<Item> items = new ArrayList<>();
        items.add(new Item(1L, "Pizza", "Delicious pizza", 9.99, 1));
        items.add(new Item(2L, "Burger", "Tasty burger", 7.99, 2));

        Mockito.when(orderRepository.save(Mockito.any(Order.class))).thenAnswer(invocation -> invocation.getArgument(0));

        mockMvc.perform(MockMvcRequestBuilders.post("/orders")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("[{\"id\": 1, \"name\": \"Pizza\", \"description\": \"Delicious pizza\", \"price\": 9.99, \"quantity\": 1}, {\"id\": 2, \"name\": \"Burger\", \"description\": \"Tasty burger\", \"price\": 7.99, \"quantity\": 2}]"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Order created successfully"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.total").value(25.97));
    }

}

