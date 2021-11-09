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
	
	@Autowired
    ClientServiceImpl clientService;
	@Autowired
	ProduitServiceImpl produitService;
	@Autowired
	DetailProduitServiceImpl detailProduitService;

    private static final Logger l = LogManager.getLogger(ClientServiceImpl.class);

    

	@Test
	void contextLoads() throws java.text.ParseException {
		
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	      Date date = dateFormat.parse("2015-03-23");
	      /*Client c1 = new Client("shayma","Rebhi",date,"shayma.rebhi@gmail.com", "test", CategorieClient.Premuim, Profession.Etudiant);
	      Client c2 = new Client("test2","rebh",date,"shayma.rebhi@gmail.com", "test", CategorieClient.Premuim, Profession.Etudiant);
	      Client c3 = new Client("test3","oueslati",date,"shayma.rebhi@gmail.com", "test", CategorieClient.Premuim, Profession.Etudiant);
	      Assert.assertTrue(c1.getNom().equals("shayma"));
	      Assert.assertTrue(c1.getPrenom().equals("Rebhi"));
	      clientService.addClient(c1);
	      clientService.addClient(c2);
	      clientService.addClient(c3);
	      clientService.retrieveClient(4L);
	      clientService.retrieveAllClients();
	      clientService.deleteClient(4L);*/
	      Produit p3 = new Produit("CR7","COCA",2.7f);
	      Produit p4 = new Produit("BBC","HUAWEI",530.8f);
	      DetailProduit dp1 = new DetailProduit(date, new Date(),CategorieProduit.Electromenager);
	      DetailProduit dp2 = new DetailProduit(date, new Date(),CategorieProduit.Alimentaire);
	      produitService.addProduit(p3);
	      produitService.addProduit(p4);
	      detailProduitService.addDetailProduit(dp1);
	      detailProduitService.addDetailProduit(dp2);
	      produitService.retrieveAllProduits();
	      produitService.retrieveProduit(6L);
	      produitService.deleteProduit(5L);
	}

}
