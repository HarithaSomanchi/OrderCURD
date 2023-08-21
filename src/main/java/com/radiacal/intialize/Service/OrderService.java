package com.radiacal.intialize.Service;
import com.radiacal.intialize.Model.Order;
import com.radiacal.intialize.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public List<Order> getOrders(){
        return orderRepository.findAll();
    }
    public String addOrder(Order order){
        Order response = orderRepository.save(order);
        String result = "datainsterted";
        return result;
    }
    public Optional<Order> getOrderById(int id){
        return orderRepository.findById(id);
    }
    public Optional<Order> updateOrderById(int id , Order order){
        Optional<Order> ordered=getOrderById(id);
        if(ordered.isPresent())
        {
          System.out.println(ordered);
          Order existingorder= ordered.get();
          System.out.println(existingorder);
          existingorder.setOrderedDate(order.getOrderedDate());
          existingorder.setDeliveryDate(order.getDeliveryDate());
          orderRepository.save(existingorder);
          Optional<Order> ordered1=getOrderById(id);
          return ordered1;
        }
        String status="Order with given id not present";
        return null;
    }
    public String deleteOderById(int id){
        Optional<Order> ordered=getOrderById(id);
        if (ordered.isPresent()) {
            orderRepository.deleteById(id);
            String status = "deleted";
            return status;
        }
        String status="Order with given id not present";
        return status;
    }

}
