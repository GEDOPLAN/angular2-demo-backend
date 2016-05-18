package de.gedoplan.knowhow.angular2cli.service;

import de.gedoplan.knowhow.angular2cli.model.Order;
import de.gedoplan.knowhow.angular2cli.model.User.UserRole;
import de.gedoplan.knowhow.angular2cli.model.dto.QueryResult;
import de.gedoplan.knowhow.angular2cli.model.dto.QuerySettings;
import de.gedoplan.knowhow.angular2cli.repository.OrderRepository;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class OrderService {

    @Inject
    private OrderRepository orderRepository;

    public QueryResult<Order> queryOrders(QuerySettings settings) {
        QueryResult orders;
        orders = orderRepository.queryOrders(settings);

        return orders;
    }

    public Order getOrder(Integer orderId) {
        Order order;
        order = orderRepository.findOrder(orderId);

        return order;
    }
}
