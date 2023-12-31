package com.majidim.easybankv3.easybankv3.implementation;


import com.majidim.easybankv3.easybankv3.dto.Client;
import com.majidim.easybankv3.easybankv3.dto.Personne;
import com.majidim.easybankv3.easybankv3.helper.DatabaseConnection;
import com.majidim.easybankv3.easybankv3.interfeces.IClient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientImpl implements IClient {

    private static final String SEARCH_BY_CODE = "SELECT * FROM Clients WHERE code=?";
    private static final String DELETE_CLIENT = "DELETE FROM Clients WHERE code=?";
    private static final String SHOW_ALL_CLIENTS = "SELECT * FROM Clients";
    private static final String UPDATE_CLIENT = "UPDATE Clients SET nom=?, prenom=?, dateN=?, tel=?, adress=? WHERE code=?";
    private static final String ADD_CLIENT = "INSERT INTO Clients (code, nom, prenom, dateN, tel, adress) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SEARCH_BY_LASTNAME = "SELECT * FROM Clients WHERE nom LIKE ?";


    @Override
    public List<Client> SearchByCode(String code) {
        Connection connection = DatabaseConnection.getConn();
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_CODE)) {
            preparedStatement.setString(1, code);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Client> resultList = new ArrayList<>();
            while (resultSet.next()) {
                Client client = getClientFromResultSet(resultSet);
                resultList.add(client);
            }
            resultSet.close();

            return resultList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean Delete(String code) {
        Connection connection = DatabaseConnection.getConn();
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CLIENT)) {
            preparedStatement.setString(1, code);
            int rowsDeleted = preparedStatement.executeUpdate();
            return rowsDeleted > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Client> Showlist() {
        Connection connection = DatabaseConnection.getConn();
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(SHOW_ALL_CLIENTS)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Client> resultList = new ArrayList<>();
            while (resultSet.next()) {
                Client client = getClientFromResultSet(resultSet);
                resultList.add(client);
            }

            resultSet.close();

            return resultList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public Optional<Client> Update(Client client) {
        Connection connection = DatabaseConnection.getConn();
        try (
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CLIENT)) {
            preparedStatement.setString(1, client.getNom());
            preparedStatement.setString(2, client.getPrenom());
            preparedStatement.setObject(3, client.getDateN());
            preparedStatement.setString(4, client.getTel());
            preparedStatement.setString(5, client.getAdress());
            preparedStatement.setString(6, client.getCode());

            int rowsUpdated = preparedStatement.executeUpdate();
            return (rowsUpdated > 0) ? Optional.of(client) : Optional.empty();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Client> SearchByLastName(String lastName) {
        Connection connection = DatabaseConnection.getConn();
        try (PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_LASTNAME)) {
            preparedStatement.setString(1, "%" + lastName + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Client> resultList = new ArrayList<>();
            while (resultSet.next()) {
                Client client = getClientFromResultSet(resultSet);
                resultList.add(client);
            }
            resultSet.close();

            return resultList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Optional<Personne> Add(Personne personne) {
        if (personne instanceof Client client) {
            Connection connection = DatabaseConnection.getConn();
            try (
                    PreparedStatement preparedStatement = connection.prepareStatement(ADD_CLIENT)) {
                preparedStatement.setString(1, client.getCode());
                preparedStatement.setString(2, client.getNom());
                preparedStatement.setString(3, client.getPrenom());
                preparedStatement.setObject(4, client.getDateN());
                preparedStatement.setString(5, client.getTel());
                preparedStatement.setString(6, client.getAdress());

                preparedStatement.executeUpdate();
                return Optional.of(personne);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return Optional.empty();
    }


    private Client getClientFromResultSet(ResultSet resultSet) throws SQLException {
        return new Client(
                resultSet.getString("code"),
                resultSet.getString("nom"),
                resultSet.getString("prenom"),
                resultSet.getObject("dateN", LocalDate.class),
                resultSet.getString("tel"),
                resultSet.getString("adress")
        );
    }
}