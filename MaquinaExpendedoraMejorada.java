public class MaquinaExpendedoraMejorada {

    // El precio del billete
    private int precioBillete;
    // La cantidad de dinero que lleva metida el cliente actual
    private int balanceClienteActual;
    // El total de dinero almacenado en la maquina desde su ultimo vaciado
    private int totalDineroAcumulado;
    // El origen del billete
    private String estacionOrigen;
    // El destino del billete
    private String estacionDestino;
    // Total de billetes
    private int numeroBilletes;
    // Posisbilidad de premio
    private boolean maquinaPremio;
    // Numero max billetes que se pueden vender
    private int maxBilletes;

    /**
     * Crea una maquina expendedora de billetes de tren con el 
     * precio del billete y el origen y destino dados. Se asume que el precio
     * del billete que se recibe es mayor que 0.
     */
    public MaquinaExpendedoraMejorada(int precioDelBillete, String origen, String destino, boolean premioTrueOrFalse,int numBilletes) {
        precioBillete = precioDelBillete;
        balanceClienteActual = 0;
        totalDineroAcumulado = 0;
        numeroBilletes = 0;
        estacionOrigen = origen;
        estacionDestino = destino;
        maquinaPremio = premioTrueOrFalse;
        maxBilletes = numBilletes;
    }
    
    /**
     * Devuelve el precio del billete
     */
    public int getPrecioBillete() {
        return precioBillete;
    }

    /**
     * Devuelve la cantidad de dinero que el cliente actual lleva introducida
     */
    public int getBalanceClienteActual() {
        return balanceClienteActual;
    }

    /**
     * Simula la introduccion de dinero por parte del cliente actual
     */
    public void introducirDinero(int cantidadIntroducida) {
        if (cantidadIntroducida > 0) {
            balanceClienteActual = balanceClienteActual + cantidadIntroducida;
        }
        else {
            System.out.println(cantidadIntroducida + " no es una cantidad de dinero valida.");
        }        
    }

    /**
     * Imprime un billete para el cliente actual
     */
    public void imprimirBillete() {
        int cantidadDeDineroQueFalta =  precioBillete - balanceClienteActual;
        if(maxBilletes > numeroBilletes ){
            if (cantidadDeDineroQueFalta <= 0) { 

                // Simula la impresion de un billete
                System.out.println("##################");
                System.out.println("# Billete de tren:");
                System.out.println("# De " + estacionOrigen + " a " + estacionDestino);
                System.out.println("# " + precioBillete + " euros.");
                System.out.println("##################");
                System.out.println();         

                // Actualiza el total de dinero acumulado en la maquina
                totalDineroAcumulado = totalDineroAcumulado + precioBillete;
                // Reduce el balance del cliente actual dejandole seguir utilizando la maquina
                balanceClienteActual = balanceClienteActual - precioBillete;
                // Suma 1 billete al total
                numeroBilletes = numeroBilletes + 1;
            
                if(maquinaPremio == true){
                    System.out.println("#####################################");
                    System.out.println("¡Enhorabuena! Ha ganado un 10% de ");
                    System.out.println("descuento en una tienda a su elecion");
                    System.out.println("En su caso la cantidad es: " + precioBillete * 0.1);
                    System.out.println();
                    System.out.println("Detalles en la pagina web");
                    System.out.println("#####################################");
                    System.out.println();
                }    
            }
            else{
                System.out.println("Introduce "+  cantidadDeDineroQueFalta + " para poder sacar el billete");
            }
        }
        else{
            System.out.println("###############################");
            System.out.println("¡ERROR! Cantidad maxima vendida");
            System.out.println("###############################");
        }
    }

    /**
     * Cancela la operacion de compra del cliente actual y le
     * devuelve al cliente el dinero que ha introducido hasta el momento
     */
    public int cancelarOperacionYDevolverDinero() {
        int cantidadDeDineroADevolver;
        cantidadDeDineroADevolver = balanceClienteActual;
        balanceClienteActual = 0;
        return cantidadDeDineroADevolver;
    } 

    /**
     *  Devuleve todo el dinero que hay en la maquina
     */
    public int vaciarDineroDeLaMaquina() {
        int cantidadTotalDeDinero = totalDineroAcumulado + balanceClienteActual;
        if (balanceClienteActual == 0) {
            totalDineroAcumulado = 0;
            balanceClienteActual = 0;
        }
        else{
            cantidadTotalDeDinero = -1;
            System.out.println("ERROR Usuario usando la maquina");
        }
        return cantidadTotalDeDinero;
    }
    
    /**
     * devuelve el valor del numero de billetes vendidos con return
     */
    public int getNumeroBilletesVendidos(){
        return numeroBilletes;
    }
    
    /**
     * devuelve el valor del numero de billetes vendidos con System.out.println
     */
    public void imprimeNumeroBilletesVendidos(){
        System.out.println(numeroBilletes + " se han imprimido");
    }
}
