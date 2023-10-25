package edu.miu.cs.cs489.lesson11.prodmgmtapp;

import edu.miu.cs.cs489.lesson11.prodmgmtapp.model.Product;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProdMgmtAppTest {

    private ProdMgmtApp prodMgmtApp;

    @BeforeEach
    void setUp() {
        this.prodMgmtApp = new ProdMgmtApp();
    }

    @AfterEach
    void tearDown() {
        this.prodMgmtApp = null;
    }

    @Test
    void test_findProductById() {
        Long productId = 1L;
        var actual = prodMgmtApp.findProductById(productId);
        var expected = new Product(1L, "Banana");
        MatcherAssert.assertThat("Test fails: Result does not match",
                actual, CoreMatchers.is(CoreMatchers.equalTo(expected)));
    }

    @Test
    void test_findProductById_where_id_does_not_exist() {
        Long productId = 3L;
        var actual = prodMgmtApp.findProductById(productId);
        Product expected = null;
        MatcherAssert.assertThat("Test fails: Result does not match",
                actual, CoreMatchers.is(CoreMatchers.equalTo(expected)));
    }
}