package shop;


import java.util.HashMap;
import java.util.Map;

public class Buyer {
    private String firstName;
    private String lastName;

    public void requestToBuy() {
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
        // TODO :: checkout process
        Checkout checkout = new Checkout();
        checkout.process(basket);

        // Check netPrice = 24, discountPrice 24 - 10%
    }
}

class Checkout {
    public void process(Basket basket) {
        int netPrice = PriceCalculator.get(basket);
        int maxDiscount = DiscountCalculator.get(basket, netPrice);
        int totalPrice = netPrice - maxDiscount;
        // TODO
        basket.setNetPrice(netPrice);
        basket.setDiscountPrice(maxDiscount);
    }
}

class PriceCalculator {

    public static int get(Basket basket) {
        int netPrice = 0;
        for (Map.Entry<String, Order> entry : basket.getOrders().entrySet()) {
            Order sth = entry.getValue();
            netPrice += sth.getBook().getPrice() * sth.getQuantity() * 100;
        }
        // Logic
        return netPrice;
    }
}

class DiscountCalculator {

    public static int get(Basket basket, int netPrice) {
        // Logic
        int discount = 0;
        Map<String, Order> books = basket.getOrders();
        if (books.size() == 2) {
            discount = netPrice - (netPrice * 5 / 100);
        }
        if (books.size() == 3) {
            discount = netPrice - (netPrice * 10 / 100);
        }
        if (books.size() == 4) {
            discount = netPrice - (netPrice * 20 / 100);
        }
        return discount;
    }
}

class Order {
    private Book book;
    private int quantity;

    public Order(Book book) {
        this.book = book;
        this.quantity = 1;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

//    public void setQuantity(int quantity) {
//        this.quantity = quantity;
//    }

    public Order increase() {
        this.quantity++;
        return this;
    }

    public Order decrease() {
        if (this.quantity != 0) {
            this.quantity--;
        }
        return this;
    }
}

class Basket {
    Map<String, Order> orders = new HashMap<>();

    private int netPrice;
    private int discountPrice;

    public Map<String, Order> getOrders() {
        return orders;
    }

    public void setOrders(Map<String, Order> orders) {
        this.orders = orders;
    }

    public void addBook(Book book) {
        Order order = orders.get(book.getBookName());
        if (order != null) {
            order.increase();
        } else {
            orders.put(book.getBookName(), new Order(book));
        }
    }

    public int getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(int netPrice) {
        this.netPrice = netPrice;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }
}

class BookBuilder {
    private Book book;

    public BookBuilder() {
        book = new Book();
    }

    public BookBuilder chooseBook(String name) {
        book.setBookName(name);
        book.setPrice(8);
        return this;
    }

    public Book build() {
        return book;
    }
}

class Book {
    private String bookName;
    private int price;

    public Book() {
    }

    public Book(String bookName, int price) {
        this.bookName = bookName;
        this.price = price;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
