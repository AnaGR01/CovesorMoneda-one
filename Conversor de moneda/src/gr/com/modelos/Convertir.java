package gr.com.modelos;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import gr.com.service.ConsumoAPI;

import java.net.URL;
import java.util.Scanner;

public class Convertir {
    Gson    gson    =   new GsonBuilder().setPrettyPrinting().create();
    Scanner lectura =   new Scanner(System.in);

    public double convertirMoneda(String busqueda,
                                 String nombreMonedaLocal,
                                 String monedaAConvertir,
                                 String nombreDeMonedaAConvertir) {
        String valorIngresado;

        //Obteniendo los valores de la biblioteca Json
        ConsumoAPI consulta = new ConsumoAPI();
        String valor = gson.toJson(consulta.buscaMonedas(busqueda));
        JsonObject jsonObject = gson.fromJson(valor, JsonObject.class);

        //Moneda Seleccionada por el usuario
        String monedaSeleccionada   =   jsonObject.get("URL").getAsString();

        //Valor de la moneda a convertir
        JsonObject conversionRates  =   jsonObject.getAsJsonObject("conversion_rates");
        double valorDeMonedaAconvertir  =   conversionRates.get(monedaAConvertir).getAsDouble();

        System.out.println("Ingresa el valor de "+ monedaSeleccionada + " a convertir: ");
        valorIngresado=lectura.nextLine();
        valorIngresado.replace(".",",");
        Double valorIngresadoToDouble   =   Double.parseDouble(valorIngresado);

        if (valorIngresadoToDouble<=0){
            System.out.println("Por favor ingresar un cantidad mayor a 0");
            valorIngresadoToDouble =lectura.nextDouble();
        } else if (valorIngresadoToDouble >=1){
            double valorconvertido=valorIngresadoToDouble * valorDeMonedaAconvertir;
            String valorCalculadoFormatoDecimal =   String.format("%.2f", valorconvertido);
            System.out.println(valorIngresadoToDouble+ " "
                    +nombreMonedaLocal + " " + "====>" +" "
                    +   valorCalculadoFormatoDecimal + " "
                    +   nombreDeMonedaAConvertir);

            System.out.println("\n****************************************************************");
            System.out.println("Presiona cero (0) para salir.");
            System.out.println("Presiona [1-8] para continuar con otra conversión: ");
            System.out.println("******************************************************************");

            return valorconvertido;

        }

        return 0.0; //En caso de que no haya conversión;

    }

}
