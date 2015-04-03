/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sysautos.bussines.common;

/**
 *
 * @author hp
 */
public class Gender {

    private static String[] Genders = {"Masculino", "Femenino", "Otro"};

    public Gender() {
    }

    public static String[] getGenders() {
        return Genders;
    }

    public static void setGenders(String[] Genders) {
        Gender.Genders = Genders;
    }

    public static String getGender(String name) {
        String result = "";
        for (String gender : Genders) {
            if (gender.equals(name)) {
                result = gender;
            }
        }
        return result;
    }

    public static String getGenderSimbol(String name) {
        String result = "";
        for (String gender : Genders) {
            if (gender.equals(name)) {
                if (gender.equals("Masculino")) {
                    result = "M";
                }
                if (gender.equals("Femenino")) {
                    result = "F";
                }
                if (gender.equals("Otro")) {
                    result = "O";
                }
            }
        }
        return result;
    }

    public static String getSimbolGender(String caracter) {
        String result = "";
        if (caracter.equals("M")) {
            result = Genders[0];
        }
        if (caracter.equals("F")) {
            result = Genders[1];
        }
        if (caracter.equals("O")) {
            result = Genders[2];
        }
        return result;
    }

}
