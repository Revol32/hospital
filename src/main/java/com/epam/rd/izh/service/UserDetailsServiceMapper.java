package com.epam.rd.izh.service;

import com.epam.rd.izh.entity.AuthorizedUser;
import com.epam.rd.izh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.HashSet;
import java.util.Set;

/**
 * Для авторизации через Spring security требуется реализация интерфейса UserDetailsService и его метода
 * .loadUserByUsername(String login).
 */

@Service
public class UserDetailsServiceMapper implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    /**
     * Данный метод должен вернуть объект User, являющийся пользователем текущей сессии.
     * Реализация данного метода включает маппинг, т.е. преобразование бизнес-объекта AuthorizedUser в
     * системный объект Spring приложения User.
     * <p>
     * Рекомендуется внедрить логику, реагирующую на возможные нуллы в методах-геттерах.
     * Пример хорошего кода - логирование или выброс исключения, если наполнение поля объекта критично
     * (например отсутствует роль пользователя).
     */

    @SessionScope
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {

        AuthorizedUser authorizedUserDto = userRepository.getAuthorizedUserByLogin(login);
        Set<GrantedAuthority> roles = new HashSet<>();
        roles.add(new SimpleGrantedAuthority(authorizedUserDto.getRole()));

        return new User(
                authorizedUserDto.getLogin(),
                authorizedUserDto.getPassword(),
                roles
        );
    }

}
