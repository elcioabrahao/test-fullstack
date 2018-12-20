package com.test;

import com.test.exception.ResourceNotFoundException;
import com.test.main.TestMain;
import com.test.model.entity.User;
import com.test.persistence.UserRepository;
import com.test.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(classes=TestMain.class)
public class FullStackTestServiceTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    UserService userService;

    @MockBean
    User userInserted;

    @Before
    public void createRegister() throws ResourceNotFoundException {
        userService = new UserService(userRepository);
        userInserted = new User("TESTE","TESTE@TESTE.COM","999888777","m");
        userInserted = userService.saveUser(userInserted);
    }

    @Test
    public void insertTest() throws ResourceNotFoundException {
        User user = userService.findUserById(userInserted.getId());
        assertEquals(userInserted, user);
    }

    @Test
    public void updateTest() throws ResourceNotFoundException {
        User user = userService.findUserById(userInserted.getId());
        user.setNome("TESTEMODIFICADO");
        userService.updateUser(user,user.getId());
        User user2 = userService.findUserById(userInserted.getId());
        assertNotEquals("TESTE",user2.getNome());
    }

    @Test(expected = ResourceNotFoundException.class)
    public void deleteTest() throws ResourceNotFoundException {
        User user = userService.findUserById(userInserted.getId());
        userService.deleteUser(user.getId());
        User user2 = userService.findUserById(userInserted.getId());
    }

}

