package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT c FROM User c WHERE c.email=:email AND c.password=:password")
    User getUserByEmailAndPassword(String email,String password);

    @Query("SELECT c FROM User c WHERE c.email = :email")
    User getUserByEmail(String email);

	
}
