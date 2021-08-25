/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author morpha
 */
public class Prime {

    public static boolean check(int prime) {
        int div = 1;
        int raiz = (int) Math.sqrt(prime);
        int i = 2;
        while ((div < 2) && (i <= raiz)) {
            div = (prime % i == 0) ? (div + 1) : (div);
            i++;
        }
        return ((div == 1) && (prime != 1));
    }

}
