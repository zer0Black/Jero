package com.lxt.core.domain.sort;

import com.sun.tools.corba.se.idl.constExpr.Or;
import org.springframework.security.access.method.P;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * 查看的排序选项，必须提供至少一个排序参数
 *
 * @author zer0
 * @version 1.0
 */
public class Sort {

    public static final Direction DEFAULT_DIRECTION = Direction.ASC;

    private final List<Order> orders;

    public Sort(Order... orders){
        this(Arrays.asList(orders));
    }

    public Sort(List<Order> orders){
        if (null == orders || orders.isEmpty()){
            throw new IllegalArgumentException("You have to provide at least one sort property to sort by!");
        }
        this.orders = orders;
    }

    public Sort(String... properties){
        this(DEFAULT_DIRECTION, properties);
    }

    public Sort(Direction direction, String... properties){
        this(direction, properties == null ? new ArrayList<String>() : Arrays.asList(properties));
    }

    public Sort(Direction direction, List<String> properties) {

        if (properties == null || properties.isEmpty()) {
            throw new IllegalArgumentException("You have to provide at least one property to sort by!");
        }

        this.orders = new ArrayList<Order>(properties.size());

        for (String property : properties) {
            this.orders.add(new Order(direction, property));
        }
    }

    public void add(Order order){
        if (order == null){
            throw new IllegalArgumentException("You have to provide one property to order by!");
        }
        this.orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }

    public static enum Direction{
        ASC, DESC;

        public static Direction fromString(String value) {
            try {
                return Direction.valueOf(value.toUpperCase(Locale.US));
            } catch (Exception e) {
                throw new IllegalArgumentException(String.format(
                        "Invalid value '%s' for orders given! Has to be either 'desc' or 'asc' (case insensitive).", value), e);
            }
        }

        public static Direction fromStringOrNull(String value) {
            try {
                return fromString(value);
            } catch (IllegalArgumentException e) {
                return null;
            }
        }

    }

    public static class Order{
        private static final boolean DEFAULT_IGNORE_CASE = false;

        private final Direction direction;
        private final String property;
        private final boolean ignoreCase;

        public Order(Direction direction, String property){
            this(direction, property, DEFAULT_IGNORE_CASE);
        }

        public Order(Direction direction, String property, boolean ignoreCase){
            this.direction = direction == null ? DEFAULT_DIRECTION : direction;
            this.property = property;
            this.ignoreCase = ignoreCase;
        }

        public Direction getDirection() {
            return direction;
        }

        public String getProperty() {
            return property;
        }

        public boolean isIgnoreCase() {
            return ignoreCase;
        }
    }

}


