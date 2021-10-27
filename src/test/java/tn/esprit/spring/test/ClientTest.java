package tn.esprit.spring.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.CategorieClient;
import tn.esprit.spring.entities.Client;
import tn.esprit.spring.entities.Profession;
import tn.esprit.spring.service.ClientServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientTest {
	 @Autowired
	    ClientServiceImpl clientService;

	    private static final Logger l = LogManager.getLogger(ClientServiceImpl.class);


	    @Test
	  public void testAddUSer() throws java.text.ParseException {

	      SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	      Date date = dateFormat.parse("2015-03-23");
	      Client c1 = new Client("shayma","Rebhi",date,"shayma.rebhi@gmail.com", "test", CategorieClient.Premuim, Profession.Etudiant);
	      Client c2 = new Client("test2","rebh",date,"shayma.rebhi@gmail.com", "test", CategorieClient.Premuim, Profession.Etudiant);
	      Client c3 = new Client("test3","oueslati",date,"shayma.rebhi@gmail.com", "test", CategorieClient.Premuim, Profession.Etudiant);
	      Assert.assertTrue(c1.getNom().equals("shayma"));
	      Assert.assertTrue(c1.getPrenom().equals("Rebhi"));
	      clientService.addClient(c1);
	      clientService.addClient(c2);
	      clientService.addClient(c3);
	      clientService.retrieveClient(2L);
	      clientService.retrieveAllClients();
	      clientService.deleteClient(2L);

	  }

}
