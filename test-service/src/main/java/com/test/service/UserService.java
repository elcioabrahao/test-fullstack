package com.test.service;

import com.test.exception.ResourceNotFoundException;
import com.test.model.entity.User;
import com.test.persistence.UserRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        List<User> users = this.userRepository.findAll();
        return users;
    }

    public User findUserById(Long id) throws ResourceNotFoundException {
        User user = this.userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado para este id :: " + id));
        return user;
    }

    public User saveUser(User user) throws ResourceNotFoundException{
        this.userRepository.save(user);
        return findUserById(user.getId());
    }

    public User updateUser(User userDetails, Long userId)throws ResourceNotFoundException{
        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado para este id :: " + userId));
        user.setNome(userDetails.getNome());
        user.setEmail(userDetails.getEmail());
        user.setTelefone(userDetails.getTelefone());
        user.setSexo(userDetails.getSexo());
        final User updatedUser = this.userRepository.save(user);
        return updatedUser;
    }

    public User deleteUser(Long userId) throws ResourceNotFoundException{
        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado para este id :: " + userId));
        this.userRepository.delete(user);
        return user;
    }


}
