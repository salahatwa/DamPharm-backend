package run.dampharm.app.model;

import lombok.Data;

@Data
public class ProductDto {
	private Long id;
	private String name;
	private String code;
	private String location;
	private Double price;
	private Long quantity;
	private Long availableQuantity;
	private Long categoryId;
}
