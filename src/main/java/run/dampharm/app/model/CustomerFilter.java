package run.dampharm.app.model;

import lombok.Data;

@Data
public class CustomerFilter {
	private String name;
	private String lastname;
	private String address;
	private String phone;
	private String state;
	private String email;
}
