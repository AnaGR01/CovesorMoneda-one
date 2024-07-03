package gr.com.principal;

public class PrincipalMenu {
    //Generacion de variables para contenido de menú
    private String menu = """
            ---------------------------------------------------------------------------
                                    | Conversor de Moneda |
            ---------------------------------------------------------------------------
                           Bienvenid@s a la app de conversión de monedas
            Indicaciones:
                        
            A. Elegir una opción el 1 al 8 para convertir 
            B. Ingresar un valor a convertir
            C. Para salir presiona cero (0)
            D. Historial de conversiones presione (9)
                        
            ---------------------------------------------------------------------------
                        
            1. [USD] Dólar             ----->   [ARS] Peso Argentino 
                        
            2. [ARS] Peso Argentino    ----->   [USD] Dólar 
                        
            3. [USD] Dólar             ----->   [BRL] Real Brasileño 
                        
            4. [BRL] Real Brasileño    ----->   [$USD] Dólar 
                        
            5. [USD] Dólar             ----->   [COP] Peso Colombiano 
                        
            6. [COP] Peso Colombiano   ----->   [USD] Dólar 
                        
            7. [USD] Dólar             ----->   [EUR] Euro 
                        
            8. [EUR] Euro              ----->   [USD] Dólar
                        
                        
            ---------------------------------------------------------------------------
            """;
    private String salida = """
            ---------------------------------------------------------------------------
            -----------   ¡Muchas gracias por utilizar nuestro conversor!   -----------
            ----------------------------  ¡Hasta pronto!💸  ---------------------------
            """;

    public void usarPrincipalMenu() {
        System.out.println(menu);
        System.out.println("Escoja una opción: ");
    }
    //Getters and Setters de variables involucradas

    public String getPrincipal() {
        return menu;
    }

    public void setSubMenu(String menu) {
        this.menu = menu;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }
}


