/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.drivers;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import sysautos.bussines.entities.User;
import sysautos.integration.Conexion;
import sysautos.integration.Parameter;

/**
 *
 * @author hp
 */
public class dvrUser {
     //Insertar un nuevo registro a la tabla
    public static int usersRegister(User objeto) throws Exception {
        int codigo = 0;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getCi(), Types.VARCHAR));
        parametros.add(new Parameter(2, objeto.getFisrtname(), Types.VARCHAR));
        parametros.add(new Parameter(3, objeto.getLastname(), Types.VARCHAR));
        parametros.add(new Parameter(4, objeto.getAge(), Types.INTEGER));
        parametros.add(new Parameter(5, objeto.getGender(), Types.VARCHAR));
        parametros.add(new Parameter(6, objeto.getTittle(), Types.VARCHAR));
        parametros.add(new Parameter(7, objeto.getDirection(), Types.VARCHAR));
        parametros.add(new Parameter(8, objeto.getPhone(), Types.VARCHAR));
        parametros.add(new Parameter(9, objeto.getMobile(), Types.VARCHAR));
        parametros.add(new Parameter(10, objeto.getEmail(), Types.VARCHAR));
        parametros.add(new Parameter(11, objeto.getDepartment(), Types.VARCHAR));
        parametros.add(new Parameter(12, objeto.getPosition(), Types.VARCHAR));
        parametros.add(new Parameter(13, objeto.getDisability(), Types.VARCHAR));
        parametros.add(new Parameter(14, objeto.getLogin(), Types.VARCHAR));
        parametros.add(new Parameter(15, objeto.getPwd(), Types.VARCHAR));
        String llamadaPA = "SELECT autos.\"usersRegister_pa\"(?,?,?,?,?,?,?,?,"
                + "?,?,?,?,?,?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            codigo = con.getInt("usersRegister_pa");
        }
        con.cerrarConexion();
        return codigo;
    }
    //Editar un nuevo registro de la tabla
    public static boolean usersUpdate(User objeto) throws Exception {
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getId(), Types.INTEGER));
        parametros.add(new Parameter(2, objeto.getCi(), Types.VARCHAR));
        parametros.add(new Parameter(3, objeto.getFisrtname(), Types.VARCHAR));
        parametros.add(new Parameter(4, objeto.getLastname(), Types.VARCHAR));
        parametros.add(new Parameter(5, objeto.getAge(), Types.INTEGER));
        parametros.add(new Parameter(6, objeto.getGender(), Types.VARCHAR));
        parametros.add(new Parameter(7, objeto.getTittle(), Types.VARCHAR));
        parametros.add(new Parameter(8, objeto.getDirection(), Types.VARCHAR));
        parametros.add(new Parameter(9, objeto.getPhone(), Types.VARCHAR));
        parametros.add(new Parameter(10, objeto.getMobile(), Types.VARCHAR));
        parametros.add(new Parameter(11, objeto.getEmail(), Types.VARCHAR));
        parametros.add(new Parameter(12, objeto.getDepartment(), Types.VARCHAR));
        parametros.add(new Parameter(13, objeto.getPosition(), Types.VARCHAR));
        parametros.add(new Parameter(14, objeto.getDisability(), Types.VARCHAR));
        parametros.add(new Parameter(15, objeto.getLogin(), Types.VARCHAR));
        parametros.add(new Parameter(16, objeto.getPwd(), Types.VARCHAR));
        String llamadaPA = "SELECT autos.\"usersUpdate_pa\"(?,?,?,?,?,?,?,?,?,"
                + "?,?,?,?,?,?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;
    }
    //Eliminar un registro de la tabla
    public static boolean usersDelete(User objeto) throws Exception {
        boolean respuesta = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, objeto.getId(), Types.INTEGER));
        String llamadaPA = "SELECT autos.\"usersDelete_paCascada\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            respuesta = true;
        }
        con.cerrarConexion();
        return respuesta;
    }
    //Listar todos los registros de la tabla
    public static List<User> getUserList() throws Exception {
        List<User> lista = new ArrayList<>();
        String llamadaPA = "SELECT * from autos.\"usersSelectAll_pa\"()";
        Conexion con = new Conexion(llamadaPA);
        while (con.siguiente()) {
            int id = con.getInt("outid");
            String ci = con.getString("outcc");
            String firstname = con.getString("outfisrtname");
            String lastname = con.getString("outlastname");
            int age = con.getInt("outage");
            String gender = con.getString("outgender");
            String tittle = con.getString("outtittle");
            String direction = con.getString("outdirection");
            String phone = con.getString("outphone");
            String mobile = con.getString("outmobile");
            String email = con.getString("outemail");
            String department = con.getString("outdepartment");
            String position = con.getString("outposition");
            String disability = con.getString("outdisability");
            String user = con.getString("outuser");
            String pwd = con.getString("outpwd");
            lista.add(new User(id, ci, firstname, lastname, age, gender, tittle,
                    direction, phone, mobile, email, department, position, disability, user, pwd ));
        }
        con.cerrarConexion();
        return lista;
    }
    //Listar los registros de la tabla dado el nombre 
    public static List<User> getUserListByName(String text) throws Exception {
        List<User> lista = new ArrayList<>();
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, text, Types.VARCHAR));
        String llamadaPA = "SELECT * from autos.\"usersByName_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        while (con.siguiente()) {
            int id = con.getInt("outid");
            String ci = con.getString("outcc");
            String firstname = con.getString("outfisrtname");
            String lastname = con.getString("outlastname");
            int age = con.getInt("outage");
            String gender = con.getString("outgender");
            String tittle = con.getString("outtittle");
            String direction = con.getString("outdirection");
            String phone = con.getString("outphone");
            String mobile = con.getString("outmobile");
            String email = con.getString("outemail");
            String department = con.getString("outdepartment");
            String position = con.getString("outposition");
            String disability = con.getString("outdisability");
            String user = con.getString("outuser");
            String pwd = con.getString("outpwd");
            lista.add(new User(id, ci, firstname, lastname, age, gender, tittle,
                    direction, phone, mobile, email, department, position, disability, user, pwd ));
        }
        con.cerrarConexion();
        return lista;
    }
    
    //Listar los registros de la tabla dado el nombre 
    public static User getUserById(int val) throws Exception {
        User var = null;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, val, Types.INTEGER));
        String llamadaPA = "SELECT * from autos.\"usersByID_pa\"(?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        if (con.siguiente()) {
            int id = con.getInt("outid");
            String ci = con.getString("outcc");
            String firstname = con.getString("outfisrtname");
            String lastname = con.getString("outlastname");
            int age = con.getInt("outage");
            String gender = con.getString("outgender");
            String tittle = con.getString("outtittle");
            String direction = con.getString("outdirection");
            String phone = con.getString("outphone");
            String mobile = con.getString("outmobile");
            String email = con.getString("outemail");
            String department = con.getString("outdepartment");
            String position = con.getString("outposition");
            String disability = con.getString("outdisability");
            String user = con.getString("outuser");
            String pwd = con.getString("outpwd");
            var = new User(id, ci, firstname, lastname, age, gender, tittle,
                    direction, phone, mobile, email, department, position, disability, user, pwd );
        }
        con.cerrarConexion();
        return var;
    }
    
     public static User getUserByLogin(String login, String paswd) throws Exception {
        User var = null;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, login, Types.VARCHAR));
        parametros.add(new Parameter(2, paswd, Types.VARCHAR));
        String llamadaPA = "SELECT * from autos.\"usersByLogin_pa\"(?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        if (con.siguiente()) {
            int id = con.getInt("outid");
            String ci = con.getString("outcc");
            String firstname = con.getString("outfisrtname");
            String lastname = con.getString("outlastname");
            int age = con.getInt("outage");
            String gender = con.getString("outgender");
            String tittle = con.getString("outtittle");
            String direction = con.getString("outdirection");
            String phone = con.getString("outphone");
            String mobile = con.getString("outmobile");
            String email = con.getString("outemail");
            String department = con.getString("outdepartment");
            String position = con.getString("outposition");
            String disability = con.getString("outdisability");
            String user = con.getString("outuser");
            String pwd = con.getString("outpwd");
            var = new User(id, ci, firstname, lastname, age, gender, tittle,
                    direction, phone, mobile, email, department, position, disability, user, pwd );
        }
        con.cerrarConexion();
        return var;
    }
    
    public static boolean existUserByLogin(String login, String pwd) throws Exception {
        boolean result = false;
        List<Parameter> parametros = new ArrayList<>();
        parametros.add(new Parameter(1, login, Types.VARCHAR));
        parametros.add(new Parameter(2, pwd, Types.VARCHAR));
        String llamadaPA = "select * from autos.\"usersExistByLogin_pa\"(?,?)";
        Conexion con = new Conexion(llamadaPA, parametros);
        if (con.siguiente()) {
            result = con.getBoolean("usersExistByLogin_pa");
        }
        con.cerrarConexion();
        return result;
    }

    public static int getUserById(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}