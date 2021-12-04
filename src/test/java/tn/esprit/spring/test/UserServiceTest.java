package tn.esprit.spring.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.entities.CategorieClient;
import tn.esprit.spring.entities.Profession;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.service.UserServiceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserServiceImpl clientService;

    private static final Logger l = LogManager.getLogger(UserServiceImpl.class);



    @Test
    public void testAddUSer() throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse("2015-03-23");
        User c1 = new User("shayma","rebhi",date,"shayma.rebhi@gmail.com", "test", CategorieClient.Premuim, Profession.Etudiant, Role.admin);
        User c2 = new User("test2","rebhi",date,"shayma.rebhi@esprit.tn", "test", CategorieClient.Fidele, Profession.Etudiant, Role.user);
        User c3 = new User("test3","rebhi",date,"shayma@gmail.com", "test", CategorieClient.Ordinaire, Profession.Etudiant,Role.user);
        Assert.assertTrue(c1.getNom().equals("shayma"));
        Assert.assertTrue(c1.getPrenom().equals("rebhi"));
        clientService.addClient(c1);
        clientService.addClient(c2);
        clientService.addClient(c3);
        clientService.retrieveClient(2L);
        clientService.retrieveAllClients();
        clientService.deleteClient(2L);

    }
}
