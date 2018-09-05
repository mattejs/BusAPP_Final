
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus;

import bus.pomocno.HibernateUtil;
import bus.view.Izbornik;

/**
 *
 * @author Matej
 */
public class Start {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        HibernateUtil.getSession();
        new Izbornik().setVisible(true);
    }
}
