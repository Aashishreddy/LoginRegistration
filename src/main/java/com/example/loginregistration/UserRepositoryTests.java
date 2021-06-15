package com.example.loginregistration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
class UsersRepositoryTests {

    @Autowired
    private UserRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setEmail("aashishreddy5555@gmail.com");
        user.setPassword("aashish");
        user.setFirstName("Aashish");
        user.setLastName("Vundhyala");

        User savedUser = repo.save(user); //save is in CRUDRepository
        User existingUser = entityManager.find(User.class, user.getId());
        assertThat(existingUser.getEmail()).isEqualTo(user.getEmail());

        User user1 = new User();
        user1.setEmail("aashishreds@gmail.com");
        user1.setFirstName("A");
        user1.setLastName("B");
        user1.setPassword("aksdla");

        repo.save(user1);
    }

   @Test
   public void testFindbyEmail(){
        String email ="aashishreds@gmail.com";
        User user = repo.findByEmail(email);
        assertThat(user).isNotNull();
   }


}

