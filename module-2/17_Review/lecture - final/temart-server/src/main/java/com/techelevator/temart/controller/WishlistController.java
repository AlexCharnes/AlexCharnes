package com.techelevator.temart.controller;

import com.techelevator.temart.dao.UserDao;
import com.techelevator.temart.dao.WishlistDao;
import com.techelevator.temart.model.Wishlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@PreAuthorize("isAuthenticated()")
@RestController
public class WishlistController {

    private WishlistDao wishlistDao;
    private UserDao userDao;

    public WishlistController(WishlistDao wishlistDao, UserDao userDao) {
        this.wishlistDao = wishlistDao;
        this.userDao = userDao;
    }


    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path="/wishlists", method= RequestMethod.POST)
    public Wishlist add(@RequestBody Wishlist wishlist, Principal principal) {
        String loggedInUsername = principal.getName();
        int loggedInUserId = userDao.findIdByUsername(loggedInUsername);
        wishlist.setUserId(loggedInUserId);
        return wishlistDao.create(wishlist);
    }


}
