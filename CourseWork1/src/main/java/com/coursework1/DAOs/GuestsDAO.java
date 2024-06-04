package com.coursework1.DAOs;

import com.coursework1.Interface.IGuestsDAO;
import com.coursework1.Models.Guest;

import java.util.*;

public class GuestsDAO implements IGuestsDAO {
    private Set<Guest> guestsDataBase = new TreeSet<>(Comparator.comparing(Guest::getLogin));

    @Override
    public void setUsersDataBase(Set<Guest> usersDataBase) {
        this.guestsDataBase = usersDataBase;
    }

    @Override
    public Set<Guest> getUsersDataBase() {
        return guestsDataBase;
    }

    @Override
    public boolean isRegisteredUser(String username) {
        for (Guest guest: guestsDataBase) {
            if (username.equals(guest.getLogin())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Guest findByLogin(String username) {
        for (Guest guest : guestsDataBase) {
            if (guest.getLogin().equals(username)) {
                return guest;
            }
        }
        return null;
    }

    @Override
    public void createUser(String username, String password) {
        if (!isRegisteredUser(username)) {
            guestsDataBase.add(new Guest(username, password));
        }
    }

    @Override
    public void createUser(String username, String password, Guest.Role role) {
        if (!isRegisteredUser(username)) {
            guestsDataBase.add(new Guest(username, password, role));
        }
    }

    @Override
    public void addUser(Guest guest) {
        if (!isRegisteredUser(guest.getLogin())) {
            guestsDataBase.add(guest);
        }
    }

    @Override
    public void deleteUser(Guest guest) {
        if (isRegisteredUser(guest.getLogin())) {
            guestsDataBase.remove(guest);
        }
    }
}
