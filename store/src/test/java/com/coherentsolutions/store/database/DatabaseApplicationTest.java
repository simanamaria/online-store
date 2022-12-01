package com.coherentsolutions.store.database;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.Test;

class DatabaseApplicationTest {

    @Test
    void testPrintProducts() throws SQLException {
        ResultSet resultSet = mock(ResultSet.class);
        when(resultSet.getInt((String) any())).thenReturn(1);
        when(resultSet.getString((String) any())).thenReturn("String");
        when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
        PreparedStatement preparedStatement = mock(PreparedStatement.class);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        Connection connection = mock(Connection.class);
        when(connection.prepareStatement((String) any())).thenReturn(preparedStatement);
        DatabaseApplication.printProducts(connection);
        verify(connection).prepareStatement((String) any());
        verify(preparedStatement).executeQuery();
        verify(resultSet, atLeast(1)).next();
        verify(resultSet, atLeast(1)).getInt((String) any());
        verify(resultSet, atLeast(1)).getString((String) any());
    }

    @Test
    void testPrintProducts2() throws SQLException {
        ResultSet resultSet = mock(ResultSet.class);
        when(resultSet.getInt((String) any())).thenThrow(new SQLException());
        when(resultSet.getString((String) any())).thenThrow(new SQLException());
        when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
        PreparedStatement preparedStatement = mock(PreparedStatement.class);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        Connection connection = mock(Connection.class);
        when(connection.prepareStatement((String) any())).thenReturn(preparedStatement);
        assertThrows(SQLException.class, () -> DatabaseApplication.printProducts(connection));
        verify(connection).prepareStatement((String) any());
        verify(preparedStatement).executeQuery();
        verify(resultSet).next();
        verify(resultSet).getInt((String) any());
    }

    @Test
    void testCreateSchema() throws SQLException {
        Statement statement = mock(Statement.class);
        when(statement.executeUpdate((String) any())).thenReturn(1);
        Connection connection = mock(Connection.class);
        when(connection.createStatement()).thenReturn(statement);
        DatabaseApplication.createSchema(connection);
        verify(connection).createStatement();
        verify(statement, atLeast(1)).executeUpdate((String) any());
    }

    @Test
    void testCreateSchema2() throws SQLException {
        Statement statement = mock(Statement.class);
        when(statement.executeUpdate((String) any())).thenThrow(new SQLException());
        Connection connection = mock(Connection.class);
        when(connection.createStatement()).thenReturn(statement);
        assertThrows(SQLException.class, () -> DatabaseApplication.createSchema(connection));
        verify(connection).createStatement();
        verify(statement).executeUpdate((String) any());
    }

    @Test
    void testCreateSchema3() throws SQLException {
        Connection connection = mock(Connection.class);
        when(connection.createStatement()).thenThrow(new SQLException());
        assertThrows(SQLException.class, () -> DatabaseApplication.createSchema(connection));
        verify(connection).createStatement();
    }

    @Test
    void testCreateCategory() throws SQLException {
        PreparedStatement preparedStatement = mock(PreparedStatement.class);
        when(preparedStatement.executeUpdate()).thenReturn(1);
        doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
        doNothing().when(preparedStatement).setString(anyInt(), (String) any());
        Connection connection = mock(Connection.class);
        when(connection.prepareStatement((String) any())).thenReturn(preparedStatement);
        DatabaseApplication.createCategory(connection, 1);
        verify(connection).prepareStatement((String) any());
        verify(preparedStatement).executeUpdate();
        verify(preparedStatement).setInt(anyInt(), anyInt());
        verify(preparedStatement).setString(anyInt(), (String) any());
    }

    @Test
    void testCreateCategory2() throws SQLException {
        PreparedStatement preparedStatement = mock(PreparedStatement.class);
        when(preparedStatement.executeUpdate()).thenThrow(new SQLException());
        doThrow(new SQLException()).when(preparedStatement).setInt(anyInt(), anyInt());
        doThrow(new SQLException()).when(preparedStatement).setString(anyInt(), (String) any());
        Connection connection = mock(Connection.class);
        when(connection.prepareStatement((String) any())).thenReturn(preparedStatement);
        assertThrows(SQLException.class, () -> DatabaseApplication.createCategory(connection, 1));
        verify(connection).prepareStatement((String) any());
        verify(preparedStatement).setInt(anyInt(), anyInt());
    }

    @Test
    void testCreateCategory3() throws SQLException {
        Connection connection = mock(Connection.class);
        when(connection.prepareStatement((String) any())).thenThrow(new SQLException());
        assertThrows(SQLException.class, () -> DatabaseApplication.createCategory(connection, 1));
        verify(connection).prepareStatement((String) any());
    }

    @Test
    void testCreateProduct() throws SQLException {
        PreparedStatement preparedStatement = mock(PreparedStatement.class);
        when(preparedStatement.executeUpdate()).thenReturn(1);
        doNothing().when(preparedStatement).setInt(anyInt(), anyInt());
        doNothing().when(preparedStatement).setString(anyInt(), (String) any());
        Connection connection = mock(Connection.class);
        when(connection.prepareStatement((String) any())).thenReturn(preparedStatement);
        DatabaseApplication.createProduct(connection, 1);
        verify(connection).prepareStatement((String) any());
        verify(preparedStatement).executeUpdate();
        verify(preparedStatement, atLeast(1)).setInt(anyInt(), anyInt());
        verify(preparedStatement).setString(anyInt(), (String) any());
    }

    @Test
    void testCreateProduct2() throws SQLException {
        PreparedStatement preparedStatement = mock(PreparedStatement.class);
        when(preparedStatement.executeUpdate()).thenThrow(new SQLException());
        doThrow(new SQLException()).when(preparedStatement).setInt(anyInt(), anyInt());
        doThrow(new SQLException()).when(preparedStatement).setString(anyInt(), (String) any());
        Connection connection = mock(Connection.class);
        when(connection.prepareStatement((String) any())).thenReturn(preparedStatement);
        assertThrows(SQLException.class, () -> DatabaseApplication.createProduct(connection, 1));
        verify(connection).prepareStatement((String) any());
        verify(preparedStatement).setInt(anyInt(), anyInt());
    }

    @Test
    void testCreateProduct3() throws SQLException {
        Connection connection = mock(Connection.class);
        when(connection.prepareStatement((String) any())).thenThrow(new SQLException());
        assertThrows(SQLException.class, () -> DatabaseApplication.createProduct(connection, 1));
        verify(connection).prepareStatement((String) any());
    }
}

