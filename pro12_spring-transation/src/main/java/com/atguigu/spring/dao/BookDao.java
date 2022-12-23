package com.atguigu.spring.dao;

public interface BookDao {
    Integer getPriceByBookId(Integer bookId);

    void updateStock(Integer bookId);

    /*
    * update user balance
    * */
    void updateBalance(Integer userId, Integer bookId);
}
