package Banco;
import java.util.ArrayList;
import java.util.List;

/**
 * Objeto cuenta bancaria.
 * En esta clase estaran los metodos donde se ingresa, retira y consulta el saldo actual
 * @author Nicoleta
 * @version 1.0
 * @since 2025
 */
public class CuentaBancaria {
    private String iban;
    private String titular;
    private double saldo;
    private List<String> historialMovimientos;

    /**
     * Constructor con atributos por defecto oligatorios para generar una cuenta bancaria
     * @param iban IBAN de la cuenta
     * @param titular nombre del titular de la cuenta
     */
    public CuentaBancaria(String iban, String titular) {
        this.iban = iban;
        this.titular = titular;
        this.saldo = 0.0;
        this.historialMovimientos = new ArrayList<>();
        historialMovimientos.add("Cuenta creada con saldo inicial de 0.0");
    }

    /**
     * Obtiene el IBAN de la cuenta
     * @return IBAN de la cuenta
     */
    public String getIban() {
        return iban;
    }

    /**
     * Obtiene el nombre del titular de la cuenta
     * @return Nombre del titular
     */
    public String getPersona() {
        return titular;
    }

    /**
     * Obtiene el saldo actual de la cuenta
     * @return saldo actual en la cuenta
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Se ingresará dinero en la cuenta
     * @param cuenta cuenta bancaria a la que se le ingresa dinero
     */
    public static void igresarDinero(CuentaBancaria cuenta) {
        System.out.println("Ingrese la cantidad a depositar:");
        double cantidad = DamBank.tc.nextDouble();
        DamBank.tc.nextLine();

        if (cantidad > 0) {
            cuenta.saldo += cantidad;
            cuenta.historialMovimientos.add("Ingreso: " + cantidad);
            System.out.println("Depósito realizado con éxito.");
        } else {
            System.out.println("Cantidad no válida.");
        }
    }

    /**
     * Se retirará dinero de la cuenta
     * @param cuenta cuenta bancaria a la que se le retira dinero
     */
    public static void retirarDinero(CuentaBancaria cuenta) {
        System.out.println("Ingrese la cantidad a retirar:");
        double cantidad = DamBank.tc.nextDouble();
        DamBank.tc.nextLine();

        if (cantidad > 0 && cantidad <= cuenta.saldo) {
            cuenta.saldo -= cantidad;
            cuenta.historialMovimientos.add("Retiro: " + cantidad);
            System.out.println("Retiro realizado con éxito.");
        } else {
            System.out.println("Fondos insuficientes o cantidad no válida.");
        }
    }

    /**
     * Enseñara el historial de movimientos de la cuenta
     * @param cuenta cuenta bancaria que entra
     */
    public static void ensenyarHistorial(CuentaBancaria cuenta) {
        System.out.println("*** HISTORIAL DE MOVIMIENTOS ***");
        for (String movimiento : cuenta.historialMovimientos) {
            System.out.println(movimiento);
        }
    }
}
