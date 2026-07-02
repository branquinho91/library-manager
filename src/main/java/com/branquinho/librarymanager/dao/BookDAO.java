package com.branquinho.librarymanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.branquinho.librarymanager.database.ConnectionFactory;
import com.branquinho.librarymanager.model.Book;

public class BookDAO {
    public void save(Book book) {
        String sql = """
                INSERT INTO books (
                    title,
                    author,
                    genre,
                    page_count,
                    publication_year,
                    available
                ) VALUES (?, ?, ?, ?, ?, ?)
                """;

        try (
                Connection connection = ConnectionFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getGenre());
            statement.setInt(4, book.getPageCount());
            statement.setInt(5, book.getPublicationYear());
            statement.setBoolean(6, book.isAvailable());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to save book.", e);
        }
    }

    public Book findById(Long id) {
        String sql = """
                SELECT *
                FROM books
                WHERE id = ?
                """;

        try (
                Connection connection = ConnectionFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (!resultSet.next()) {
                return null;
            }

            return new Book(
                    resultSet.getLong("id"),
                    resultSet.getString("title"),
                    resultSet.getString("author"),
                    resultSet.getString("genre"),
                    resultSet.getInt("page_count"),
                    resultSet.getInt("publication_year"),
                    resultSet.getBoolean("available")
            );
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find book with id=" + id, e);
        }
    }

    public List<Book> findAll() {
        String sql = """
                SELECT *
                FROM books
                ORDER BY id
                """;

        List<Book> books = new ArrayList<>();

        try (
                Connection connection = ConnectionFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet resultSet = statement.executeQuery()
        ) {
            while (resultSet.next()) {
                Book book = new Book(
                        resultSet.getLong("id"),
                        resultSet.getString("title"),
                        resultSet.getString("author"),
                        resultSet.getString("genre"),
                        resultSet.getInt("page_count"),
                        resultSet.getInt("publication_year"),
                        resultSet.getBoolean("available")
                );

                books.add(book);
            }

            return books;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to list books", e);
        }
    }

    public void remove(Book book) {
        String sql = """
                DELETE
                FROM books
                WHERE id = ?
                """;

        try (
                Connection connection = ConnectionFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setLong(1, book.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to remove book.", e);
        }
    }

    public void update(Book book) {
        String sql = """
                UPDATE books
                SET
                    title = ?,
                    author = ?,
                    genre = ?,
                    page_count = ?,
                    publication_year = ?,
                    available = ?
                WHERE id = ?
                """;
        try (
                Connection connection = ConnectionFactory.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)
        ) {
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor());
            statement.setString(3, book.getGenre());
            statement.setInt(4, book.getPageCount());
            statement.setInt(5, book.getPublicationYear());
            statement.setBoolean(6, book.isAvailable());
            statement.setLong(7, book.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to update book with id=" + book.getId(), e);
        }
    }
}
