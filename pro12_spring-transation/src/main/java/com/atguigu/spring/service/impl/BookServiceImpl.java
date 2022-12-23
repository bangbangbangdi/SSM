package com.atguigu.spring.service.impl;

import com.atguigu.spring.dao.BookDao;
import com.atguigu.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public void buyBook(Integer userId, Integer bookId) {
        // Check Book Prices
        Integer price = bookDao.getPriceByBookId(bookId);

        // update book inventory
        bookDao.updateStock(bookId);

        // update user balance
        bookDao.updateBalance(userId,bookId);

    }
}
