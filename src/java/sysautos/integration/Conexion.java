/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.integration;

import java.math.BigDecimal;
import java.sql.*;
import java.util.List;

/**
 *
 * @author hp
 */
public class Conexion {

    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public Conexion(String query) throws Exception {
        try {
            Class.forName(Global.DRIVER);
            connection = DriverManager.getConnection(Global.URL, Global.USER, Global.PASSWORD);
            preparedStatement = connection.prepareCall(query);
            resultSet = preparedStatement.executeQuery();
        } catch (Exception e) {
            throw e;
        }
    }

    public Conexion(String query, List<Parameter> parametros) throws Exception {
        try {
            Class.forName(Global.DRIVER);
            connection = DriverManager.getConnection(Global.URL, Global.USER, Global.PASSWORD);
            preparedStatement = connection.prepareStatement(query);
            for (Parameter parametro : parametros) {
                preparedStatement.setObject(parametro.getPosicion(),
                        parametro.getValor(),
                        parametro.getTipoDato());
            }
            resultSet = preparedStatement.executeQuery();
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
    }

    public void cerrarConexion() throws Exception {
        this.resultSet.close();
        this.connection.close();
    }

    public boolean siguiente() throws Exception {
        return this.resultSet.next();
    }

    public String getString(String nombreColumna) throws Exception {
        return this.resultSet.getString(nombreColumna);
    }

    public String getString(int posColumna) throws Exception {
        return this.resultSet.getString(posColumna);
    }
    
    public int getInt(String nombreColumna) throws Exception {
        return this.resultSet.getInt(nombreColumna);
    }

    public int getInt(int posColumna) throws Exception {
        return this.resultSet.getInt(posColumna);
    }
    
    public Date getDate(String nombreColumna) throws Exception {
        return this.resultSet.getDate(nombreColumna);
    }

    public Date getDate(int posColumna) throws Exception {
        return this.resultSet.getDate(posColumna);
    }
    
    public boolean getBoolean(String nombreColumna) throws Exception {
        return this.resultSet.getBoolean(nombreColumna);
    }

    public boolean getBoolean(int posColumna) throws Exception {
        return this.resultSet.getBoolean(posColumna);
    }
    
    public BigDecimal getBigDecimal(String nombreColumna) throws Exception {
        return this.resultSet.getBigDecimal(nombreColumna);
    }

    public BigDecimal getBigDecimal(int posColumna) throws Exception {
        return this.resultSet.getBigDecimal(posColumna);
    }
    
    public Timestamp getTimestamp(String nombreColumna) throws Exception {
        return this.resultSet.getTimestamp(nombreColumna);
    }

    public Timestamp getTimestamp(int posColumna) throws Exception {
        return this.resultSet.getTimestamp(posColumna);
    }

    
}
