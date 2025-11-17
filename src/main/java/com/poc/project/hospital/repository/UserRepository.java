package com.poc.project.hospital.repository;

import com.poc.project.hospital.dto.RegisteredUserDto;
import com.poc.project.hospital.entity.AuthorizedUser;
import com.poc.project.hospital.entity.MyUser;
import com.poc.project.hospital.mappers.AuthorizedUserMapper;
import com.poc.project.hospital.mappers.MyUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Repository
public class UserRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    MyUserMapper userMapper;

    @Autowired
    AuthorizedUserMapper authorizedUserMapper;


    private final List<AuthorizedUser> users = new ArrayList<>();

    /**
     * В данном методе использована библиотека Stream API:
     * .filter проверяет каждый элемент коллекции на удовлетворение условия .equals(login), в случае, если совпадающий
     * элемент будет найдет, он будет возвращен методом .findFirst(). Если в коллекции не будет найдет удовлетворяющий
     * условию элемент, методом .orElse(null) будет возвращен null.
     * Допускается использовать вместо  Stream API стандартные циклы For и While.
     * <p>
     * аннотации @Nullable и @Nonnull расставляются над возвращающими не примитивные значения методами и передаваемыми
     * в метод аргументами.
     */

    @Nullable
    public AuthorizedUser getAuthorizedUserByLogin(@Nonnull String login) {
        List<AuthorizedUser> users = jdbcTemplate.query("SELECT * FROM users WHERE login = ? LIMIT 1", authorizedUserMapper, login);
        if (users.isEmpty()) {
            return null;
        }
        return users.get(0);
    }

    public boolean addAuthorizedUser(@Nullable AuthorizedUser user) {
        if (user != null) {
            users.add(user);
            return true;
        }
        return false;
    }

    public boolean registerUser(@Nonnull RegisteredUserDto registeredUser) {
        return jdbcTemplate.update("INSERT INTO users (user_name,user_surname,user_birthday,login,password,role) VALUES (?,?,?,?,?,?)",
                registeredUser.getName(),
                registeredUser.getSurname(),
                LocalDate.parse(registeredUser.getBirthday()),
                registeredUser.getLogin(),
                registeredUser.getPassword(),
                registeredUser.getRole()) != 0;
    }

    public MyUser getUserByLogin(String login) {
        List<MyUser> users = jdbcTemplate.query("SELECT * FROM users WHERE login = ? LIMIT 1", userMapper, login);
        if (users.isEmpty()) {
            return null;
        }
        return users.get(0);
    }

    public MyUser getUserById(long id) {
        List<MyUser> users = jdbcTemplate.query("SELECT * FROM users WHERE user_id = ? LIMIT 1", userMapper, id);
        if (users.isEmpty()) {
            return null;
        }
        return users.get(0);
    }

    public List<MyUser> getDoctorPatients(long doctorId) {
        return jdbcTemplate.query("SELECT * FROM users WHERE user_id IN (" +
                "SELECT patient_id FROM timetable WHERE doctor_id = ? AND visit IS NOT NULL)", userMapper, doctorId);
    }

}
