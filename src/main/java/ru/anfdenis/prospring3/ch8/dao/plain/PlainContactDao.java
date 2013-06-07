package ru.anfdenis.prospring3.ch8.dao.plain;

import ru.anfdenis.prospring3.ch8.dao.ContactDao;
import ru.anfdenis.prospring3.ch8.domain.Contact;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Denis Anfertev
 * 26.03.13 17:38
 */
public class PlainContactDao implements ContactDao {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pro-spring-ch8", "root", "");
    }

    private void closeConnection(Connection connection) {
        if (connection == null) {
            return;
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Contact> findAll() {
        List<Contact> result = new ArrayList<>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM contact");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Contact contact = new Contact();
                contact.setId(resultSet.getLong("id"));
                contact.setFirstName(resultSet.getString("first_name"));
                contact.setLastName(resultSet.getString("last_name"));
                contact.setBirthDate(resultSet.getDate("birth_date"));
                result.add(contact);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return result;
    }

    @Override
    public List<Contact> findByFirstName(String firstName) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void insert(Contact contact) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void update(Contact contact) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void delete(Long contactId) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
