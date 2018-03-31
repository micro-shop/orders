package cz.microshop.order.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="orders")
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Long orderId;
	private BigDecimal total;
	private Long shippingId;
	private Date createdAt;
	private Long userId;

	@Enumerated(EnumType.STRING)
	@Column(name="status", nullable=false)
	private OrderStatus status;

	@OneToMany(mappedBy="order")
	private List<OrderItem> orderItems;
	
	@Transient
	private BigDecimal totalWithShipping;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public BigDecimal getTotalWithShipping() {
		/*this.totalWithShipping = new BigDecimal(this.total.doubleValue() + this.shipping.getPrice().doubleValue());
		return this.totalWithShipping.setScale(2, RoundingMode.HALF_UP);*/
		return null;
	}
	
	public Order() {
		this.orderItems = new ArrayList<OrderItem>();
	}

	@Override
	public String toString() {
		/*return "Order [id=" + id + ", total=" + total + ", shipping=" + shipping + ", createdAt=" + createdAt
				+ ", user=" + user + ", status=" + status + "]";*/
		return "";
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getShippingId() {
		return shippingId;
	}

	public void setShippingId(Long shippingId) {
		this.shippingId = shippingId;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
}
