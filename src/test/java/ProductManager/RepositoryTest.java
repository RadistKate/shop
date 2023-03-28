package ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {
    @Test
    public void testAdd() {
        Repository repo = new Repository();

        Book book1 = new Book(1, "Shantaram", 800, "Roberts");
        Book book2 = new Book(2, "Shantaram2", 800, "Roberts");
        Book book3 = new Book(3, "Idiot", 600, "Dostoevsky");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, book2, book3};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testRemoveById() {
        Repository repo = new Repository();

        Book book1 = new Book(1, "Shantaram", 800, "Roberts");
        Book book2 = new Book(2, "Shantaram2", 800, "Roberts");
        Book book3 = new Book(3, "Idiot", 600, "Dostoevsky");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.removeById(1);

        Product[] actual = repo.findAll();
        Product[] expected = {book2, book3};

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testRemoveWhenIdNotExisted() {
        Repository repo = new Repository();

        Book book1 = new Book(1, "Shantaram", 800, "Roberts");
        Book book2 = new Book(2, "Shantaram2", 800, "Roberts");
        Book book3 = new Book(3, "Idiot", 600, "Dostoevsky");

        repo.add(book1);
        repo.add(book2);
        repo.add(book3);


        Product[] actual = repo.findAll();
        Product[] expected = {book2, book3};

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.removeById(6));


    }
}


