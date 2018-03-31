package cz.microshop.order.repository;

import cz.microshop.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

	@Query(value="from Order o WHERE o.userId = ?1 ORDER BY o.createdAt DESC",
			countQuery="SELECT COUNT(o) FROM Order o WHERE o.userId = ?1 ORDER BY o.createdAt DESC", nativeQuery=false)
	List<Order> findByUserId(Long userId);

	Order findByOrderId(Long id);
}
