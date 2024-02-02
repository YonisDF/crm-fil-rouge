package com.example.demo.controller.mapper;

import com.example.demo.controller.dto.OrderDTO;
import com.example.demo.model.Order;
import com.example.demo.model.state.OrderEnum;

public class OrderMapper {

    public static OrderDTO convertEntityToDTO(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setTypePresta(order.getTypePresta());
        dto.setDesignation(order.getDesignation());
        dto.setClient(order.getClient());
        dto.setNbDays(order.getNbDays());
        dto.setUnitPrice(order.getUnitPrice());
        dto.setTotalNoTaxe(order.getTotalNoTaxe());
        dto.setTotalTaxe(order.getTotalTaxe());

        String state = String.valueOf(OrderEnum.values()[order.getState()]);
        dto.setState(state);
        return dto;
    }

    public static Order convertDTOtoEntity(OrderDTO dto) {
        Order order = new Order();
        order.setTypePresta(dto.getTypePresta());
        order.setDesignation(dto.getDesignation());
        order.setClient(dto.getClient());
        order.setNbDays(dto.getNbDays());
        order.setUnitPrice(dto.getUnitPrice());
        order.setTotalNoTaxe(dto.getTotalNoTaxe());
        order.setTotalTaxe(dto.getTotalTaxe());

        if (dto.getState() != null) {
            short intState = (short) OrderEnum.valueOf(dto.getState()).ordinal();
            order.setState(intState);
        }
        return order;
    }
}
