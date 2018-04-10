package cz.microshop.order.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
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

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;

	@OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="shipping_id")
	private Shipping shipping;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;

	@Enumerated(EnumType.STRING)
	@Column(name="status", nullable=false)
	private OrderStatus status;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<OrderItem> orderItems;

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
		this.totalWithShipping = new BigDecimal(this.total.doubleValue() + this.shipping.getPrice().doubleValue());
		return this.totalWithShipping.setScale(2, RoundingMode.HALF_UP);
	}
	
	public Order() {
		this.orderItems = new ArrayList<OrderItem>();
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


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}

	public Shipping getShipping() {
		return shipping;
	}
}
