package shop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BuyerTest {

    @Test
    @DisplayName("buy 3 different books discount 10%")
    public void buy_3_books() {
        // 1. Create basket
        Basket basket = new Basket();
        // 2. Add book to basket
        Book book1 = new Book("Potter 1", 8);
        Book book2 = new Book("Potter 2", 8);
        Book book3 = new BookBuilder().chooseBook("Potter 3").build();
        basket.addBook(book1);
        basket.addBook(book2);
        basket.addBook(book3);
        // 3. Checkout
        Checkout checkout = new Checkout();
        checkout.process(basket);

        // Check netPrice = 24, discountPrice 24 - 10%
        assertEquals(2400, basket.getNetPrice()); // 24.00
        assertEquals(2160, basket.getDiscountPrice()); // 21.60
    }

    @Test
    @DisplayName("buy 4 different books discount 20%")
    public void buy_4_different_books() {
        // 1. Create basket
        Basket basket = new Basket();
        // 2. Add book to basket
        Book book1 = new Book("Potter 1", 8);
        Book book2 = new Book("Potter 2", 8);
        Book book3 = new BookBuilder().chooseBook("Potter 3").build();
        Book book4 = new BookBuilder().chooseBook("Potter 4").build();
        basket.addBook(book1);
        basket.addBook(book2);
        basket.addBook(book3);
        basket.addBook(book4);
        // 3. Checkout
        Checkout checkout = new Checkout();
        checkout.process(basket);

        // Check netPrice = 32, discountPrice 32 - 20%
        assertEquals(3200, basket.getNetPrice()); // 32.00
        assertEquals(2560, basket.getDiscountPrice()); // 25.60
    }


    @Test
    @DisplayName("buy 1 book no discount")
    public void buy_1_books() {
        // 1. Create basket
        Basket basket = new Basket();
        // 2. Add book to basket
        Book book1 = new Book("Potter 1", 8);
        basket.addBook(book1);
        // 3. Checkout
        Checkout checkout = new Checkout();
        checkout.process(basket);

        // Check netPrice = 8, discountPrice 0
        assertEquals(800, basket.getNetPrice()); // 8.00
        assertEquals(0, basket.getDiscountPrice()); // 0
    }

    @Test
    @DisplayName("buy 2 different books discount 5%")
    public void buy_2_books() {
        // 1. Create basket
        Basket basket = new Basket();
        // 2. Add book to basket
        Book book1 = new Book("Potter 1", 8);
        Book book2 = new Book("Potter 2", 8);
        basket.addBook(book1);
        basket.addBook(book2);
        // 3. Checkout
        Checkout checkout = new Checkout();
        checkout.process(basket);

        // Check netPrice = 16, discountPrice 5%
        assertEquals(1600, basket.getNetPrice()); // 16.00
        assertEquals(1520, basket.getDiscountPrice()); // 1520
    }

    @Test
    @DisplayName("ซื้อหนังสือ Potter 1 จำนวน 2 เล่ม จะไม่ได้รับส่วนลด")
    public void buy_2_books_same_book() {
        // 1. Create basket
        Basket basket = new Basket();
        // 2. Add book to basket
        Book book1 = new Book("Potter 1", 8);
        Book book2 = new Book("Potter 1", 8);
        basket.addBook(book1);
        basket.addBook(book2);
        // 3. Checkout
        Checkout checkout = new Checkout();
        checkout.process(basket);

        // Check netPrice = 16, discountPrice 5%
        assertEquals(1600, basket.getNetPrice()); // 16.00
        assertEquals(0, basket.getDiscountPrice()); // 0
    }


    @Test
    public void buy_2_books_same_book_size_of_book_is_1() {
        // 1. Create basket
        Basket basket = new Basket();
        // 2. Add book to basket
        Book book1 = new Book("Potter 1", 8);
        Book book2 = new Book("Potter 1", 8);
        basket.addBook(book1);
        basket.addBook(book2);

        // Check size of book in basket
        assertEquals(1, basket.getItems().size());
        assertEquals(2, basket.getItems().get(book1.getBookName()).getQuantity()); // Issue :: Quantity of book in basket
    }
}