package com.userDomain.userDomain.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
/* import java.util.Optional;

import org.springframework.beans.BeanUtils; */
import org.springframework.stereotype.Service;

import com.userDomain.userDomain.Dto.UserDto;
import com.userDomain.userDomain.Model.UserModel;
import com.userDomain.userDomain.Repository.UserRepository;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class UserService {
    
    @Autowired
    private UserRepository userRepository;


    /*UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }*/


    public List<UserModel> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<UserModel> getUserById(UUID id){
        return userRepository.findById(id);
    }

    public UserModel getUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }

    public UserModel saveUser(UserDto userDto){
        UserModel user = new UserModel();
        user.setName(userDto.name());
        user.setPassword(userDto.password());
        user.setEmail(userDto.email());
        return userRepository.save(user);
    }

    public UserModel updateUser(UUID id, UserDto userDto){
        UserModel user = userRepository.findById(id).get();
        user.setId(userDto.id());
        user.setName(userDto.name());
        user.setPassword(userDto.password());
        user.setEmail(userDto.email());

        return userRepository.save(user);
    }

    public void deleteUser(UUID id){
        userRepository.deleteById(id);
    }
}
