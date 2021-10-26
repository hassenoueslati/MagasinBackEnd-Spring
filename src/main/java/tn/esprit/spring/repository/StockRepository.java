package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entities.Stock;

public interface StockRepository extends CrudRepository<Stock,Long> {
	@Modifying
    @Query("update Stock s set s.qte = :qte , s.qteMin = :qteMin , s.libelleStock = :libelleStock where s.idStock = :id")
    int updateStock(@Param("qte")int qte, @Param("qteMin")int qteMin, @Param("libelleStock")String libelleStock, @Param("id") Long id );
}
