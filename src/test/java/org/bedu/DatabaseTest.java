package org.bedu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DatabaseTest {

    // Arrange
    private Database db;

    @BeforeEach
    public void setup() {
        db = new Database();
    }

    @Test
    @DisplayName("The size of an empty database is 0")
    public void sizeZero() {
        assertEquals(db.size(), 0);
    }

    @Test
    @DisplayName("Database can insert data")
    public void insert() {
        db.insert(new Product(1, "Product 1"));
        db.insert(new Product(2, "Product 2"));

        assertEquals(db.size(), 2);
    }

    @Test
    @DisplayName("Search by id")
    public void findById() {
        db.insert(new Product(1, "Product 1"));
        db.insert(new Product(2, "Product 2"));
        db.insert(new Product(3, "Product 3"));
        db.insert(new Product(4, "Product 4"));

        Product p = db.getById(3);

        assertEquals(p.getId(), 3);
        assertEquals(p.getName(), "Product 3");
    }

    @Test
    @DisplayName("Database can be cleared")
    public void clear() {
        db.insert(new Product(1, "Product 1"));
        db.insert(new Product(2, "Product 2"));
        db.insert(new Product(3, "Product 3"));
        db.insert(new Product(4, "Product 4"));

        int size = db.size();

        db.clear();

        assertNotEquals(size, 0);
        assertEquals(db.size(), 0);
    }
}