/**
 * Esta es mi clase principal llamada DamBank, la cual es un banco que gestiona cuentas de banco.
 * Permite la creación de cuentas, validación de IBAN, y gestión de saldo
 * @author Nicoleta
 * @version 1.0
 * @since 2025
 */
package Banco;
import java.util.Scanner;

public class DamBank {
    public static final Scanner tc = new Scanner(System.in);

    /**
     * Método principal que crea inicialmente una cuenta de banco y muestra un menú de opciones
     * @param args Argumentos que entran
     */
    public static void main(String[] args) {
        int opcion = 0;
        boolean datosCorrect = false;
        String ibanCuenta = "";
        String nomTitular = "";

        System.out.println("Vamos a crearte una cuenta bancaria.");
        do {
            System.out.println("Escribe tu IBAN a continuación:");
            ibanCuenta = tc.next();
            tc.nextLine();

            if (datosBancValidos(ibanCuenta)) {
                System.out.println("Ahora escribe quién será el titular de la cuenta:");
                nomTitular = tc.next();
                tc.nextLine();
                nomTitular = nomTitular.substring(0, 1).toUpperCase() + nomTitular.substring(1).toLowerCase();
                datosCorrect = true;
            } else {
                System.out.println("Vuelva a escribir el IBAN");
            }
        } while (!datosCorrect);

        CuentaBancaria cuenta1 = new CuentaBancaria(ibanCuenta, nomTitular);
        System.out.println("*** CUENTA CREADA ***");

        do {
            opcion = menu(opcion);
            opcionMenu(opcion, cuenta1);
        } while (opcion != 8);
    }

    /**
     * Enseña el titular de la cuenta
     * @param elegida cuenta de banco que se mete en el metodo
     * @see CuentaBancaria#getPersona()
     */
    public static void mostrarTitulo(CuentaBancaria elegida) {
        System.out.println("*** TITULAR ***");
        System.out.println("El titular es: " + elegida.getPersona());
    }

    /**
     * Muestra el saldo de la cuenta
     * @param elegida Cuenta bancaria introduccida
     * @return El saldo de la cuenta
     * @see CuentaBancaria#getSaldo()
     */
    public static void mostrarSaldo(CuentaBancaria elegida) {
        System.out.println("*** SALDO ***");
        System.out.println("Tu saldo es: " + elegida.getSaldo());
    }

    /**
     * Muestra el IBAN de la cuenta bancaria.
     * @param elegida Cuenta bancaria seleccionada.
     * @see CuentaBancaria#getIban()
     */
    public static void mostrarIBAN(CuentaBancaria elegida) {
        System.out.println("*** IBAN ***");
        System.out.println("Tu IBAN es: " + elegida.getIban());
    }

    /**
     * Valida el IBAN introduccido
     * @param ibanVal IBAN introducido
     * @return true si el IBAN es válido, false si no.
     */
    public static boolean datosBancValidos(String ibanVal) {
        int tamanyoIban = ibanVal.length();
        if (tamanyoIban == 24) {
            String letrasIban = ibanVal.substring(0, 2);
            for (int pos = 0; pos < letrasIban.length(); pos++) {
                if (Character.isDigit(letrasIban.charAt(pos))) {
                    System.out.println("Letras del IBAN incorrectas");
                    return false;
                }
            }
            String numrsIban = ibanVal.substring(2);
            for (int pos = 0; pos < numrsIban.length(); pos++) {
                if (!Character.isDigit(numrsIban.charAt(pos))) {
                    System.out.println("Números del IBAN incorrectos");
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Método obsoleto con un menú de opciones
     * @param elegida Cuenta bancaria seleccionada.
     * @deprecated usar {@link #mostrarTitulo(CuentaBancaria)}
     */
    @Deprecated
    public static void datosCuenta(CuentaBancaria elegida) {
        System.out.println("*** DATOS DE LA CUENTA BANCARIA ***");
        System.out.println("Tu IBAN es: " + elegida.getIban());
        System.out.println("El titular es: " + elegida.getPersona());
        System.out.println("Tu saldo es: " + elegida.getSaldo());
    }
}