package run.dampharm.app.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import run.dampharm.app.domain.Customer;
import run.dampharm.app.domain.Invoice;

public interface IInvoiceDao extends JpaRepository<Invoice, String>,JpaSpecificationExecutor<Invoice> {

	// i = invoice
	// c = client
	// l(L) = items
//	@Query("select i from Invoice i join fetch i.client c join fetch i.items l join fetch l.product where i.id = ?1")
//	public Invoice fetchByIdWithClientWithInvoiceItemWithProduct(Long id);
	public Page<Invoice> findByCreatedBy(Long createdBy, Pageable pageable);

	public List<Invoice> findByCreatedBy(Long createdBy);

	public Invoice findByIdAndCreatedBy(String id, Long createdBy);

	public long countByCreatedBy(Long createdBy);

	public Page<Invoice> findByCreatedByAndIdOrCustomer(Long createdBy, String id, Customer customer,
			Pageable pageable);

}
