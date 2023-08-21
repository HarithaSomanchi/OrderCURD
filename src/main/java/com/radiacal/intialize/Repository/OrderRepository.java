package com.radiacal.intialize.Repository;

import com.radiacal.intialize.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
