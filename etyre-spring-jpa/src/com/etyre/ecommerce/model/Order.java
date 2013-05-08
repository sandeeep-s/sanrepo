package com.etyre.ecommerce.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.etyre.user.model.User;

/**
 * @author ssd1kor
 * @version 1.0
 * @created 30-Sep-2012 5:35:47 PM
 */
@Entity
@Table(name="orders")
public class Order implements Serializable{

	private Long id;

	private int version;

	private Set<OrderItem> orderItems = new HashSet<OrderItem>();

	private User user;

	private BigDecimal grossAmount;

	private BigDecimal discountAmount;

	private BigDecimal netAmount;

	private String orderNumber;

	public Order() {

	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	private void setId(Long id) {
		this.id = id;
	}

	@Version
	public int getVersion() {
		return version;
	}

	private void setVersion(int version) {
		this.version = version;
	}

	@ElementCollection
	@CollectionTable(
			name="Order_Item",
			joinColumns=@JoinColumn(name="order_id")
	)
	public Set<OrderItem> getOrderItems() {
		return Collections.unmodifiableSet(orderItems);
	}

	private void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	@ManyToOne
	@JoinColumn(name="user_id",nullable=false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(nullable=false)
	public BigDecimal getGrossAmount() {
		return grossAmount;
	}

	public void setGrossAmount(BigDecimal grossAmount) {
		this.grossAmount = grossAmount;
	}

	public BigDecimal getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}

	@Column(nullable=false)
	public BigDecimal getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(BigDecimal netAmount) {
		this.netAmount = netAmount;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	/**
	 * If this object is used as detached object, it can be outside guaranteed scope identity of persistence context.
	 * In this case there can be two different objects representing the same row in database. They will have same database identity 
	 * but different java identity. 
	 * Hence override equals and hashcode method as default check only java identity.
	 * 
	 * Use a business key comparison in the equals method. Business key characteristics are uniqueness, non-nullability and rare change.
	 * 
	 * Using id comparison in equals is strongly discouraged as id is assigned by Hibernate only after persistence. This can result in 
	 * changed hash value after object is added to a SET(Collection). This breaks SET contract.
	 * 
	 * Always use getters to compare properties of other object. This is to make sure the code works even if proxies are passed instead
	 * of real objects.
	 */
	public boolean equals(Object other){
		if (!(other instanceof Order)){
			return false;
		}
		if (this == other){
			return true;
		}
		final Order that = (Order)other;
		boolean result = this.user.equals(that.getUser()) && this.grossAmount.equals(that.getGrossAmount()) && this.netAmount.equals(that.getNetAmount());
		if (null != orderNumber){
			result = result && this.orderNumber.equals(that.getOrderNumber());
		}
		return result;
	}

	public int hashCode(){
		int hashCode = user.hashCode() + grossAmount.hashCode() + netAmount.hashCode();
		if (null != orderNumber){
			hashCode = orderNumber.hashCode();
		}
		return hashCode;
	}
	
}//end Order