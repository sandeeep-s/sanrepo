package com.etyre.vehicle.model;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * @author ssd1kor
 * @version 1.0
 * @created 09-Oct-2012 5:08:24 PM
 */
@Entity
@Table(name = "Tire_Fitment")
public class TireFitment implements Serializable {

	private Long id;

	private int version;

	private TireFitmentSize rear;

	private TireFitmentSize front;

	public TireFitment() {

	}

	public TireFitment(TireFitmentSize front, TireFitmentSize rear) {
		this.front = front;
		this.rear = rear;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
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

	/**
	 * Embedded component rearTireFitmentSize.
	 * Override the default column names as frontTireFitmentSize is also mapped.
	 * @return
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "sectionWidth", column = @Column(name = "Rear_SectionWidth")),
			@AttributeOverride(name = "aspectRatio", column = @Column(name = "Rear_AspectRatio")),
			@AttributeOverride(name = "diameter", column = @Column(name = "Rear_Diameter")) })
	public TireFitmentSize getRear() {
		return rear;
	}

	private void setRear(TireFitmentSize rear) {
		this.rear = rear;
	}

	/**
	 * Embedded component frontTireFitmentSize.
	 * @return
	 */
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "sectionWidth", column = @Column(name = "Front_SectionWidth", nullable = false)),
			@AttributeOverride(name = "aspectRatio", column = @Column(name = "Front_AspectRatio", nullable = false)),
			@AttributeOverride(name = "diameter", column = @Column(name = "Front_Diameter", nullable = false)) })
	public TireFitmentSize getFront() {
		return front;
	}

	private void setFront(TireFitmentSize front) {
		this.front = front;
	}

	public boolean equals(Object other) {
		if (!(other instanceof TireFitment)) {
			return false;
		}
		if (this == other) {
			return true;
		}
		final TireFitment that = (TireFitment) other;
		boolean result = this.front.equals(that.getFront());
		if (null != rear) {
			result = result && this.rear.equals(that.getRear());
		}
		return result;
	}

	public int hashCode() {
		int hashCode = front.hashCode();
		if (null != rear) {
			hashCode += rear.hashCode();
		}
		return hashCode;
	}
}//end TireFitment