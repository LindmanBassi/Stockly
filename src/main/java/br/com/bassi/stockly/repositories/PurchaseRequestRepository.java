package br.com.bassi.stockly.repositories;


import br.com.bassi.stockly.domain.PurchaseRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRequestRepository extends JpaRepository<PurchaseRequestEntity,String> {
}
