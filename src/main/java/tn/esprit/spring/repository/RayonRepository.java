package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.spring.entities.Rayon;

import java.util.List;

public interface RayonRepository extends JpaRepository<Rayon,Long> {

    @Query("SELECT r FROM Rayon r WHERE  r.Produit.size= 0 ")
    List<Rayon> getStatusRayon();

}
