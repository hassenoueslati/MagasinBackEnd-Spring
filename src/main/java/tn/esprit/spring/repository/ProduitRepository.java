package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import tn.esprit.spring.entities.Produit;

@Repository
public interface ProduitRepository extends CrudRepository<Produit, Long> {
	
	@Modifying
    @Query(value = "INSERT INTO produit (code, libelle, "
            + "prix_unitaire,detailproduit_id_detail_produit,rayon_id_rayon,stock_id_stock) VALUES (:code,"
            + "	:libelle, :prix_unitaire, :detailproduit_id_detail_produit, :rayon_id_rayon, :stock_id_stock)",
            nativeQuery = true)
    void insertProduit(@Param("code") String code, @Param("libelle") String libelle, @Param("prix_unitaire") float prix_unitaire,
                      @Param("detailproduit_id_detail_produit") Long detailproduit_id_detail_produit, @Param("rayon_id_rayon") Long rayon_id_rayon ,
                      @Param("stock_id_stock") Long stock_id_stock);
	
	@Query("SELECT p FROM Produit p ORDER BY p.prixUnitaire DESC")
    List<Produit> getProduitsParPrixDesc();
    
    @Query("SELECT p FROM Produit p ORDER BY p.prixUnitaire ASC")
    List<Produit> getProduitsParPrixAsc();
	
	
	
	
	
}
