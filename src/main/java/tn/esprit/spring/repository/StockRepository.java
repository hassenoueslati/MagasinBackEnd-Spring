package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entities.Stock;

public interface StockRepository extends JpaRepository<Stock,Long> {
	@Modifying
    @Query("update Stock s set s.qte = :qte , s.qteMin = :qteMin , s.libelleStock = :libelleStock where s.idStock = :id")
    int updateStock(@Param("qte")int qte, @Param("qteMin")int qteMin, @Param("libelleStock")String libelleStock, @Param("id") Long id );
	@Query("SELECT o FROM Stock o WHERE CONCAT(o.qte, o.qteMin, o.libelleStock) LIKE %?1%")
	public List<Stock> search(String keyword);
}
