package run.dampharm.app.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "items_invoices")
public class ItemInvoice implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Integer quantity;

	private Integer bonus;

	private double discount;

	private double totalAfterDiscount;

	@Column(name = "returns", columnDefinition = "integer default 0")
	private Integer returns;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id")
	private Product product;

	@JsonIgnore
	public double itemTotalAfterDiscount() {
		double amount = (quantity.intValue() - (Objects.nonNull(returns)?returns.intValue():0)) * product.getPrice();
		if (discount > 0) {
			amount = amount - ((amount * discount) / 100);
		}
		return amount;
	}

}
