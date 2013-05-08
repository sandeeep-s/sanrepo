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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.etyre.user.model.User;

/**
 * @author ssd1kor
 * @version 1.0
 * @created 30-Sep-2012 5:36:01 PM
 */
@Entity
@Table(name = "shopping_cart")
public class ShoppingCart implements Serializable {

	private Long id;

	private int version;

	private Set<ShoppingCartItem> cartItems = new HashSet<ShoppingCartItem>();

	private User user;

	private BigDecimal grossAmount;

	private BigDecimal discountAmount;

	private BigDecimal netAmount;

	public ShoppingCart() {

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	@CollectionTable(name = "Shopping_Cart_Item", joinColumns = @JoinColumn(name = "shopping_cart_id"))
	public Set<ShoppingCartItem> getCartItems() {
		return Collections.unmodifiableSet(cartItems);
	}

	private void setCartItems(Set<ShoppingCartItem> cartItems) {
		this.cartItems = cartItems;
	}

	@OneToOne
	@JoinColumn(name = "user_id", nullable = false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(nullable = false)
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

	@Column(nullable = false)
	public BigDecimal getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(BigDecimal netAmount) {
		this.netAmount = netAmount;
	}

	public boolean equals(Object other) {
		if (!(other instanceof ShoppingCart)) {
			return false;
		}
		if (this == other) {
			return true;
		}
		final ShoppingCart that = (ShoppingCart) other;
		return this.user.equals(that.getUser());
	}

	public int hashCode() {
		return user.hashCode();
	}
	
}//end ShoppingCart