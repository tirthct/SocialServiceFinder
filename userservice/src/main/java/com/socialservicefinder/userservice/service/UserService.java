package com.socialservicefinder.userservice.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.mongodb.MongoWriteException;
import com.socialservicefinder.userservice.dto.FetchMyRewards;
import com.socialservicefinder.userservice.dto.Login;
import com.socialservicefinder.userservice.dto.Rewards;
import com.socialservicefinder.userservice.exceptions.InvalidFetchMyRewardsException;
import com.socialservicefinder.userservice.exceptions.InvalidLoginException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.socialservicefinder.userservice.dto.User;
import com.socialservicefinder.userservice.exceptions.InvalidUserException;
import com.socialservicefinder.userservice.repository.UserRepository;

@Service
@Component
public class UserService {
    private final UserRepository userRepository;
    private final Codec codec;
    private final int ASSIGN_ID_TRIES;

    @Autowired
    public UserService(UserRepository userRepository) throws Exception {
        this.userRepository = userRepository;
        this.codec = new Codec();
        this.ASSIGN_ID_TRIES = 3;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String userId) {
        return userRepository.findById(userId);
    }

    public void addUser(User user) {
        if (user == null || user.getEmail() == null || user.getName() == null || user.getPassword() == null)
            throw new InvalidUserException("user or email or name or password cannot be null or empty");

        user.setPassword(codec.encrypt(user.getPassword()));
        insertUser(user);
    }

    public List<String> getEventIds(String userId) {
        User user = userRepository.findById(userId);
        List<String> eventIds = new ArrayList<>();
        if (user != null) {
            eventIds.addAll(user.getEventIds());
            return eventIds;
        }
        return Collections.emptyList();
    }

    public void updateUser(User user) {
        if (user == null || user.getEmail() == null || user.getName() == null)
            throw new InvalidUserException("user or email or name cannot be null or empty");
        User oldUser = userRepository.findById(user.getId());
        if (user.getPassword().length() == 0) {
            user.setPassword(oldUser.getPassword());
        } else {
            user.setPassword(codec.encrypt(user.getPassword()));
        }
        updateUsers(user);
    }

    private void updateUsers(User user) {
        boolean id_assigned = false;
        for (int tries = 0; tries < ASSIGN_ID_TRIES; tries++) {
            try {
                userRepository.save(user);
                id_assigned = true;
                break;
            } catch (MongoWriteException ignored) {
            }
        }
        if (!id_assigned)
            throw new InvalidUserException("Please try after sometime.");
    }

    private void insertUser(User user) {
        // Try assigning ID to organization for TRIES number of times.
        boolean id_assigned = false;
        for (int tries = 0; tries < ASSIGN_ID_TRIES; tries++) {
            try {
                user.assign_id();
                userRepository.insert(user);
                id_assigned = true;
                break;
            } catch (MongoWriteException ignored) {
            }
        }
        if (!id_assigned)
            throw new InvalidUserException("Please try after sometime.");
    }

    public User getAuthUser(Login login) {
        if (login == null || login.getEmail() == null || login.getPassword() == null)
            throw new InvalidLoginException("user or email or password cannot be null or empty");
        login.setPassword(codec.encrypt(login.getPassword()));
        User user = userRepository.findUserByEmail(login.getEmail());
        if (user != null && login.getPassword().equals(user.getPassword())) {
            return user;
        }
        throw new InvalidLoginException("Authentication Failed");
    }

    public Rewards fetchRewards(FetchMyRewards fetchMyRewards) {
        if (fetchMyRewards == null || fetchMyRewards.getId() == null || fetchMyRewards.getId().length() == 0) {
            throw new InvalidFetchMyRewardsException("user id cannot be null or empty");
        }
        User user = userRepository.findById(fetchMyRewards.getId());
        if (user != null) {
            Rewards r = new Rewards();
            r.setId(fetchMyRewards.getId());
            r.setRewards(user.getRewards());
            return r;
        }
        throw new InvalidFetchMyRewardsException("Invalid user id");
    }

    public User setNewRewardsForUser(User user, long rewardPoints) {
        long newRewardPoints = user.getRewards() + rewardPoints;
        if (newRewardPoints < 0) {
            newRewardPoints = 0;
        }
        user.setRewards(newRewardPoints);
        return user;
    }

}
