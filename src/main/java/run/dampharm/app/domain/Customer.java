package run.dampharm.app.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import run.dampharm.app.domain.audit.UserDateAudit;

@Data
@Entity
@Table(name = "customers")
public class Customer extends UserDateAudit implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String lastname;
	private String address;
	private String phone;
	private String state;
	private String email;
}
