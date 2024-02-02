package com.example.demo.controller;

import com.example.demo.controller.dto.OrderDTO;
import com.example.demo.controller.mapper.OrderMapper;
import com.example.demo.model.Order;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.demo.dao.ValidateData.isAnyStringBlank;
import static com.example.demo.dao.ValidateData.isStringInOrderEnum;

@RestController
@RequestMapping("crm")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("orders")
    public ResponseEntity<List<OrderDTO>> getOrders() {
        List<OrderDTO> listOrderDTO = new ArrayList<>();
        for (Order order : orderService.getAll()) {
            listOrderDTO.add(OrderMapper.convertEntityToDTO(order));
        }
        return ResponseEntity.ok(listOrderDTO);
    }

    @GetMapping("orders/{id}")
    public ResponseEntity<OrderDTO> getOrderById(@PathVariable("id") Integer id) {
        Optional<Order> optional = orderService.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            Order order = optional.get();
            OrderDTO orderDTO = OrderMapper.convertEntityToDTO(order);
            return ResponseEntity.ok(orderDTO);
        }
    }

    @PostMapping("orders")
    public ResponseEntity<?> addOrder(@RequestBody OrderDTO orderDTO) {
        if (isAnyStringBlank(orderDTO.getDesignation(), orderDTO.getState(), orderDTO.getTypePresta())
                || orderDTO.getNbDays() == 0 || orderDTO.getUnitPrice() == 0 || orderDTO.getClient() == null
                || !isStringInOrderEnum(orderDTO.getState())) {
            return ResponseEntity.badRequest().build();
        } else {
            Order order = OrderMapper.convertDTOtoEntity(orderDTO);
            orderService.add(order);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
    }

    @DeleteMapping("orders/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable("id") Integer id) {
        Optional<Order> optional = orderService.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            orderService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
    }

    @PutMapping("orders/{id}")
    public ResponseEntity<?> modifyOrder(@PathVariable("id") Integer id, @RequestBody OrderDTO orderDTO) {
        Optional<Order> optional = orderService.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else if (isAnyStringBlank(orderDTO.getDesignation(), orderDTO.getState(), orderDTO.getTypePresta())
                || orderDTO.getNbDays() == 0 || orderDTO.getUnitPrice() == 0 || orderDTO.getClient() == null
                || !isStringInOrderEnum(orderDTO.getState())) {
            return ResponseEntity.badRequest().build();
        } else {
            Order order = OrderMapper.convertDTOtoEntity(orderDTO);
            order.setId(id);
            orderService.update(order);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
    }
}
