package gr.com.modelos;

import gr.com.principal.PrincipalMenu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SeleccionarMoneda {
    private final Scanner scanner = new Scanner(System.in);
    private final Convertir convertirMoneda = new Convertir();
    private final PrincipalMenu menu = new PrincipalMenu();
    private final Historial historial=new Historial();

    public void seleccionar() {
        int opcion=0;
        menu.usarPrincipalMenu();

        do {
            try{
                opcion = scanner.nextInt();

            } catch (InputMismatchException e){
                System.out.println("Error: Por favor, ingresa un número válido.");
                scanner.next();
                continue;
            }

            switch (opcion) {

                case 0:
                    PrincipalMenu salida = new PrincipalMenu();
                    System.out.println(salida.getSalida());
                    break;
                case 1:
                    convertirMoneda("USD", "Dólar", "ARS", "Peso argentino");
                    break;
                case 2:
                    convertirMoneda("ARS", "Peso argentino", "USD", "Dólar");
                    break;
                case 3:
                    convertirMoneda("USD", "Dólar", "BRL", "Real brasileño");
                    break;
                case 4:
                    convertirMoneda("BRL", "Real brasileño", "USD", "Dólar");
                    break;
                case 5:
                    convertirMoneda("USD", "Dólar", "COP", "Peso colombiano");
                    break;
                case 6:
                    convertirMoneda("COP", "Peso colombiano", "USD", "Dólar");
                    break;
                case 7:
                    convertirMoneda("USD", "Dólar", "EUR", "Euro");
                    break;
                case 8:
                    convertirMoneda("EUR", "Euro", "USD", "Dólar");
                    break;
                case 9:
                    mostrarHistorial();
                    break;

                // Números diferentes
                default:
                    System.out.println("Por favor, ingresa una opción válida");
            }

        }
        while (opcion != 0);
        scanner.close();
    }

    private void convertirMoneda(String monedaLocal,
                                 String nombreMonedaLocal,
                                 String monedaAConvertir,
                                 String nombreDeMonedaAConvertir) {
        double valorConvertido = convertirMoneda.convertirMoneda(monedaLocal,nombreMonedaLocal,monedaAConvertir,nombreDeMonedaAConvertir);

        //System.out.println("Valor convertido:"+valorConvertido);
        // Agregar la conversión al historial junto con el valor convertido

        String conversion = "Valor convertido de" + nombreMonedaLocal + " a " + nombreDeMonedaAConvertir + ": " + valorConvertido+"   " + monedaLocal + " ----->"+monedaAConvertir;
        historial.agregarConversion(conversion);
    }

    private void mostrarHistorial(){
        historial.mostrarHistorial();
    }
}







