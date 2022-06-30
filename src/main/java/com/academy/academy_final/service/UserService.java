package com.academy.academy_final.service;



public interface UserService {

   void addNewUser(String username, String email, String city,String street, Integer house, Integer room, String password, String passwordConf, String cardPaySystem, Integer cardNumber);

}
