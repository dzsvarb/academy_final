package com.academy.academy_final.service.impl;

import com.academy.academy_final.model.entity.*;
import com.academy.academy_final.model.repository.*;
import com.academy.academy_final.service.UserService;
import com.academy.academy_final.validation.Validate;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final AddressRepository addressRepository;
    private final AccountRepository accountRepository;
    private final CardRepository cardRepository;
    private final UserRepository userRepository;
    private final Validate validate;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional
    public void addNewUser(String username, String email, String city, String street, Integer house, Integer room, String password, String passwordConf, String cardPaySystem, Integer cardNumber) {
        if(validate.isPasswordInvalid (password,passwordConf)){
        User user = new User();

        user.setAccountNonExpired(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setEnabled(true);
        user.setUserEmail(email);
        user.setUsername(username);
        user.setPassword(bCryptPasswordEncoder.encode(password));
            List<Role> userCustomerRole = new ArrayList<>();
            userCustomerRole.add(Role.ROLE_CUSTOMER);
        user.setRoles(userCustomerRole);

            Address address = new Address();

            address.setCity(city);
            address.setStreet(street);
            address.setHouse(house);
            address.setRoom(room);
            addressRepository.saveAndFlush(address);

            Account account = new Account();

            account.setAccountBalance(0.0F);
                Status statusActive = new Status();
                statusActive.setStatusName("ACTIVE");

            account.setAccountStatus(statusActive);

                StatusRequest statusRequestFalse = new StatusRequest();
                statusRequestFalse.setStatusRequestName("FALSE");
                account.setAccountStatusRequest(statusRequestFalse);

            accountRepository.saveAndFlush(account);

            Card card = new Card();
            List<Card> cardList = new ArrayList<>();
            cardList.add(card);
            card.setCardNumber(cardNumber);
            card.setCardPaySystem(cardPaySystem);
            card.setCardAccount(account);
            card.setUser(user);
            cardRepository.saveAndFlush(card);

        user.setUserAddress(address);
        user.setCards(cardList);


        userRepository.saveAndFlush(user);


        }
    }
}
