package edu.wol.dom;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ JpaTestConfig.class})
public class JPATest {
	@PersistenceContext(type=PersistenceContextType.EXTENDED)
    EntityManager em;
   
    @Test
	public void testUser() throws Exception{
    	User newUser= new User("TestUser",new Prospective(null));
    	em.persist(newUser);
    	User user=em.find(User.class, "TestUser");
    	Assert.assertNotNull("Fild User Failed", user);
    }
}
