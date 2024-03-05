package com.techelevator.temart.dao;

import com.techelevator.temart.model.Wishlist;
import org.junit.*;

public class JdbcWishlistControllerTests extends BaseDaoTests {

    private WishlistDao wishlistDao;

    @Before
    public void setup() {
        wishlistDao = new JdbcWishlistDao(dataSource);
    }

    @Test
    public void create_wishlist() {
        Wishlist newWishlist = new Wishlist();
        newWishlist.setUserId(1);
        newWishlist.setName("testWishlist");
        Wishlist returnedWishlist = wishlistDao.create(newWishlist);
        Assert.assertTrue(returnedWishlist.getId() > 0);
        Assert.assertNotNull(returnedWishlist.getDateCreated());
    }

}
