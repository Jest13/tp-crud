package com.example.back.service;

import com.example.back.model.Role;
import com.example.back.model.User;
import com.example.back.repository.RoleRepository;
import com.example.back.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service @RequiredArgsConstructor @Transactional
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public User saveUser(User user) {
        log.info("Enregistrer nouveau utilisateur {} dans la base de données", user.getName());
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Enregistrer nouveau role {} dans la base de données", role.getName());
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Ajouter role {} dans l'utilisateur {}", roleName, username);
    User user = userRepository.findByUsername(username);
    com.example.back.model.Role role = roleRepository.findByName(roleName);
    user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        log.info("Recupere l'utilisateur {}", username);
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("Recupere tout les utilisateurs");
        return userRepository.findAll();
    }
}
