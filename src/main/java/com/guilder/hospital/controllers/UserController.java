package com.guilder.hospital.controllers;

import com.guilder.hospital.exceptions.InvalidCredentialsException;
import com.guilder.hospital.exceptions.RegisteredUserException;
import com.guilder.hospital.exceptions.UserNotFoundException;
import com.guilder.hospital.models.Role;
import com.guilder.hospital.models.User;
import com.guilder.hospital.repositories.RoleRepository;
import com.guilder.hospital.repositories.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserController(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @GetMapping ("/api/v1/users")
    List <User> list(){
        return userRepository.findAll();
    }

    @PostMapping("/api/v1/users")
    User newUser(@RequestBody User newUser) {
        return userRepository.save(newUser);
    }


    @GetMapping("/api/v1/users/{id}")
    User one(@PathVariable Long id) {

        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @PutMapping("/api/v1/users/{id}")
    User replaceTurn(@RequestBody User newUser, @PathVariable Long id) {

        return userRepository.findById(id)
                .map(user -> {
                    if (user.getFistName() != null) user.setFistName(user.getFistName());
                    if (user.getLastName() != null) user.setLastName(user.getLastName());
                    if (user.getAddress() != null) user.setAddress(user.getAddress());
                    if (user.getCuil() != null) user.setCuil(user.getCuil());
                    if (user.getUsername() != null) user.setUsername(user.getUsername());
                    if (user.getRole() != null) user.setRole(user.getRole());
                    if (user.getTurns() != null) user.setTurns(user.getTurns());
                    return userRepository.save(user);
                })
                .orElseGet(() -> {
                    newUser.setId(id);
                    return userRepository.save(newUser);
                });
    }

    @DeleteMapping("/api/v1/users/{id}")
    void deleteTurn(@PathVariable Long id) {
        userRepository.deleteById(id);
    }



    @PostMapping("api/v1/login")
    public User login(@RequestParam("username") String username, @RequestParam("password") String pwd) {
        try{
            User user = userRepository.findByDni(username);
            if(user == null){
                throw new UserNotFoundException(username);
            }
            if(!passwordEncoder.matches(pwd, user.getPassword())){
                throw new InvalidCredentialsException();
            }
            user.setToken(getJWTToken(user.getUsername()));
            return user;
        }catch(Exception exception){
            throw  exception;
        }

    }

    @PostMapping("api/v1/register")
    public User register(@RequestParam("username") String username, @RequestParam("password") String pwd,
    @RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        try {

            if(userRepository.countByDni(username) != 0){
                throw new RegisteredUserException();
            }
            User user = new User();
            user.setUsername(username);
            user.setPassword(passwordEncoder.encode(pwd));
            user.setFistName(firstName);
            user.setLastName(lastName);
            user.setBloqued(false);

            Role role = roleRepository.getRole("USER");
            user.setRole(role);
            userRepository.save(user);
            user.setToken(getJWTToken(user.getUsername()));
            return user;
        }catch (Exception e){
            throw e;
        }
    }


    @PostMapping("api/v1/test")
    public int test(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = principal instanceof UserDetails? ((UserDetails)principal).getUsername():principal.toString();
        User user = userRepository.findByDni(username);

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
        String dateString = dateFormat.format(date);
        String timeString = timeFormat.format(date);

        int count = userRepository.countDidNotAttendByDni(username,dateString,timeString);
        return count;
    }




    private String getJWTToken(String dni) {
        String secretKey = "guilder";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("GuildHospital")
                .setSubject(dni)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }
}
