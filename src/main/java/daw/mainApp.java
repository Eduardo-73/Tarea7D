/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author edu
 */
public class mainApp {

    public static void main(String[] args) {
        List<App> lista = new ArrayList();
        
        for (int i = 0; i < 50; i++) {
            lista.add(new App());
        }
        
        lista.forEach(System.out::println);
    }
}
