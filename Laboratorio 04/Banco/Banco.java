

import java.util.Hashtable;

public class Banco {
    private Hashtable<String, Integer> cuentas;

    public Banco() {
        cuentas = new Hashtable<String, Integer>();
        // Creando 5 cuentas de banco con saldos entre 20 y 200
        for (int i = 1; i <= 5; i++) {
            cuentas.put("Cliente" + i, (int) (Math.random() * 20 + 180));
        }
    }

    public String depositar(String nombre, int depositar) {
        System.out.println("Depositando " + depositar + " en " + nombre);
        int nuevoDeposito = cuentas.get(nombre) + depositar;
        cuentas.put(nombre, nuevoDeposito);
        mostrarCuentas();
        return "Nuevo saldo de la cuenta " + nombre + " : " + nuevoDeposito;
    }

    public String sacar(String nombre, int monto) {
        int saldo = cuentas.get(nombre) - monto;
        if (saldo < 0) {
            System.out.println("No se pudo realizar la operación, resultado negativo");
            return "Saldo insuficiente para la cuenta " + nombre;
        }
        System.out.println("Sacando " + monto + " en " + nombre);
        cuentas.put(nombre, saldo);
        mostrarCuentas();
        return "Nuevo saldo de la cuenta " + nombre + " : " + saldo;
    }

     public void mostrarCuentas() {
        System.out.println("Cuentas: ");
        for (String cliente : cuentas.keySet()) {
            System.out.println(cliente + " : " + cuentas.get(cliente));
        }
    }

    public static void main(String[] args) {
        Banco banco = new Banco();
        banco.mostrarCuentas();

        System.out.println(banco.depositar("Cliente1", 50));
        System.out.println(banco.sacar("Cliente1", 30));
        System.out.println(banco.sacar("Cliente1", 300));
    }
}
