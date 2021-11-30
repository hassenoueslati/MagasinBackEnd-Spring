package tn.esprit.spring;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.CategorieClient;
import tn.esprit.spring.entities.CategorieProduit;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.DetailProduit;
import tn.esprit.spring.entities.Produit;
import tn.esprit.spring.entities.Profession;
import tn.esprit.spring.service.ClientServiceImpl;
import tn.esprit.spring.service.DetailProduitServiceImpl;
import tn.esprit.spring.service.ProduitServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class MagasinStockApplicationTests {
	


	@Test
	void contextLoads() {
		
		
	}

}
