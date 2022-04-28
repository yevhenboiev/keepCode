//package org.keepcode.mapper.impl;
//
//import lombok.RequiredArgsConstructor;
//import org.keepcode.dto.OrderDTO;
//import org.keepcode.entity.Order;
//import org.keepcode.mapper.OrderMapper;
//import org.keepcode.repository.ClientRepository;
//import org.springframework.stereotype.Component;
//
//@Component
//@RequiredArgsConstructor
//public class OrderMapperImpl implements OrderMapper {
//
//    private ClientRepository clientRepository;
//
//    @Override
//    public Order toEntity(OrderDTO orderDTO) {
//        if (orderDTO == null) {
//            return null;
//        }
//
//        Order order = new Order();
//        order.setId_order(orderDTO.getId_order());
//        order.setId_client(clientRepository.getById(orderDTO.getId_client()));
//        order.setValue(orderDTO.getValue());
//        order.setDate_creation(orderDTO.getDate_creation());
//
//        return order;
//    }
//
//    @Override
//    public OrderDTO toDto(Order order) {
//        if (order == null) {
//            return null;
//        }
//
//        OrderDTO orderDTO = new OrderDTO();
//
//        orderDTO.setId_order(order.getId_order());
//        orderDTO.setId_client(order.getId_client().getId_client());
//        orderDTO.setValue(order.getValue());
//        orderDTO.setDate_creation(order.getDate_creation());
//
//        return orderDTO;
//    }
//}
