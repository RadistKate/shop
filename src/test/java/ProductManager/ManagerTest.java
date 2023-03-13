package ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {


    @Test
    public void testAdd() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Shantaram", 800, "Roberts");
        Book book2 = new Book(2, "Shantaram2", 800, "Roberts");
        Book book3 = new Book(3, "Idiot", 600, "Dostoevsky");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, book3};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testAddAll() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Shantaram", 800, "Roberts");
        Book book2 = new Book(2, "Shantaram2", 800, "Roberts");
        Book book3 = new Book(3, "Idiot", 600, "Dostoevsky");
        Smartphone smartphone1 = new Smartphone(4, "Nokia", 5000, "Japan");
        Smartphone smartphone2 = new Smartphone(4, "Samsung", 5000, "Japan");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, book3, smartphone1, smartphone2};

        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void testSearchByName() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Shantaram", 800, "Roberts");
        Book book2 = new Book(2, "Shantaram2", 800, "Roberts");
        Book book3 = new Book(3, "Idiot", 600, "Dostoevsky");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("Shantaram");
        Product[] expected = {book1, book2};

        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void testSearchByNameSecond() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Shantaram", 800, "Roberts");
        Book book2 = new Book(2, "Shantaram2", 800, "Roberts");
        Book book3 = new Book(3, "Idiot", 600, "Dostoevsky");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("Shantaram2");
        Product[] expected = { book2};

        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void testSearchByNameThird() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);
        Book book1 = new Book(1, "Shantaram", 800, "Roberts");
        Book book2 = new Book(2, "Shantaram2", 800, "Roberts");
        Book book3 = new Book(3, "Idiot", 600, "Dostoevsky");

        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

        Product[] actual = manager.searchBy("War and peace");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);

    }



}