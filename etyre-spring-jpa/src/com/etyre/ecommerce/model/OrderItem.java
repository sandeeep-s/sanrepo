package com.etyre.ecommerce.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.etyre.catalog.model.Product;

/**
 * @author ssd1kor
 * @version 1.0
 * @created 30-Sep-2012 5:35:47 PM
 */
@Embeddable
public class OrderItem implements Serializable {

	private Integer itemOrderedQuantity;

	private BigDecimal itemListPrice;

	private BigDecimal itemDiscountAmount;

	private BigDecimal itemDiscountPercent;

	private BigDecimal itemNetPrice;

	private BigDecimal grossAmount;

	private BigDecimal netDiscountAmount;

	private BigDecimal netAmount;

	private String itemDescription;

	private Product product;

	public OrderItem() {

	}

	public OrderItem(Order order, Integer itemOrderedQuantity, BigDecimal itemListPrice, BigDecimal itemDiscountAmount,
			BigDecimal itemDiscountPercent, String itemDescription, Product product) {

		this.itemOrderedQuantity = itemOrderedQuantity;
		this.itemListPrice = itemListPrice;
		this.itemDiscountAmount = itemDiscountAmount;
		this.itemDiscountPercent = itemDiscountPercent;
		this.itemDescription = itemDescription;
		this.product = product;

		order.getOrderItems().add(this);
	}

	public OrderItem(Order order, Integer itemOrderedQuantity, BigDecimal itemListPrice, BigDecimal itemDiscountAmount,
			BigDecimal itemDiscountPercent, BigDecimal itemNetPrice, BigDecimal grossAmount, BigDecimal netDiscountAmount,
			BigDecimal netAmount, String itemDescription, Product product) {

		this.itemOrderedQuantity = itemOrderedQuantity;
		this.itemListPrice = itemListPrice;
		this.itemDiscountAmount = itemDiscountAmount;
		this.itemDiscountPercent = itemDiscountPercent;
		this.itemNetPrice = itemNetPrice;
		this.grossAmount = grossAmount;
		this.netDiscountAmount = netDiscountAmount;
		this.netAmount = netAmount;
		this.itemDescription = itemDescription;
		this.product = product;

		order.getOrderItems().add(this);
	}

	@Column(nullable = false)
	public Integer getItemOrderedQuantity() {
		return itemOrderedQuantity;
	}

	public void setItemOrderedQuantity(Integer itemOrderedQuantity) {
		this.itemOrderedQuantity = itemOrderedQuantity;
	}

	@Column(nullable = false)
	public BigDecimal getItemListPrice() {
		return itemListPrice;
	}

	public void setItemListPrice(BigDecimal itemListPrice) {
		this.itemListPrice = itemListPrice;
	}

	public BigDecimal getItemDiscountAmount() {
		return itemDiscountAmount;
	}

	public void setItemDiscountAmount(BigDecimal itemDiscountAmount) {
		this.itemDiscountAmount = itemDiscountAmount;
	}

	public BigDecimal getItemDiscountPercent() {
		return itemDiscountPercent;
	}

	public void setItemDiscountPercent(BigDecimal itemDiscountPercent) {
		this.itemDiscountPercent = itemDiscountPercent;
	}

	@Column(nullable = false)
	public BigDecimal getItemNetPrice() {
		return itemNetPrice;
	}

	public void setItemNetPrice(BigDecimal itemNetPrice) {
		this.itemNetPrice = itemNetPrice;
	}

	@Column(nullable = false)
	public BigDecimal getGrossAmount() {
		return grossAmount;
	}

	public void setGrossAmount(BigDecimal grossAmount) {
		this.grossAmount = grossAmount;
	}

	public BigDecimal getNetDiscountAmount() {
		return netDiscountAmount;
	}

	public void setNetDiscountAmount(BigDecimal netDiscountAmount) {
		this.netDiscountAmount = netDiscountAmount;
	}

	@Column(nullable = false)
	public BigDecimal getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(BigDecimal netAmount) {
		this.netAmount = netAmount;
	}

	@Column(nullable = false)
	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public boolean equals(Object other) {
		if (!(other instanceof OrderItem)) {
			return false;
		}
		if (this == other) {
			return true;
		}
		final OrderItem that = (OrderItem) other;
		return this.product.equals(that.getProduct()) && this.itemListPrice.equals(that.getItemListPrice())
				&& this.itemNetPrice.equals(that.getItemNetPrice()) && this.grossAmount.equals(that.getGrossAmount())
				&& this.netAmount.equals(that.getNetAmount()) && this.itemOrderedQuantity.equals(that.getItemOrderedQuantity());
	}

	public int hashCode() {
		return product.hashCode() + itemListPrice.hashCode() + itemNetPrice.hashCode() + grossAmount.hashCode() + netAmount.hashCode()
				+ itemOrderedQuantity.hashCode();
	}
}//end OrderItem