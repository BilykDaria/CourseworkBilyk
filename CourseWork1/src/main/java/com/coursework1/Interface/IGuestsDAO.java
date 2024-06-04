package com.coursework1.Interface;

import com.coursework1.Models.Guest;
import java.util.Set;

public interface IGuestsDAO {
    void setUsersDataBase(Set<Guest> usersDataBase);
    Set<Guest> getUsersDataBase();
    boolean isRegisteredUser(String username);
    Guest findByLogin(String username);
    void createUser(String username, String password);
    void addUser(Guest guest);
    void deleteUser(Guest guest);
    void createUser(String username, String password, Guest.Role role);
}
