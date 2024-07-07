
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import javax.swing.JOptionPane;

public class Monedas {
    //declaramos la variable de tipo  JsonObject 
    private JsonObject obj1;
    //variables de monedas
    private double totalconversion;
    double mxnRate;
    double dolar;
    double cop;
    double args;
    double valorConvertir;
    //constructor para inicializar el objeto json
    double md;
    public Monedas(JsonObject obj1,double valorConvertir) {
        this.obj1=obj1;
        this.valorConvertir = valorConvertir;
    }

    
    
    //metodo para extrar el valor de la moneda de mexico
    public void extraerMXN(){
        // Verificar si el campo "conversion_rates" existe y no es nulo
        if (obj1.has("conversion_rates") && !obj1.get("conversion_rates").isJsonNull()) {
            JsonObject conversionRates = obj1.getAsJsonObject("conversion_rates");
            // Verificar si el campo "MXN" existe en "conversion_rates"
            if (conversionRates.has("MXN")) {
                mxnRate=conversionRates.get("MXN").getAsDouble();
               
                //System.out.println("Tipo de cambio de MXN: " + mxnRate);
            } else {
                System.out.println("El campo 'MXN' no está presente en el JSON.");
            }
        } else {
            System.out.println("El campo 'conversion_rates' no está presente o es nulo en el JSON.");
        }
    }
   
    //metodo para extrar el valor de la moneda de dolar
    public void extraeDolar(){
        // Verificar si el campo "conversion_rates" existe y no es nulo
        if (obj1.has("conversion_rates") && !obj1.get("conversion_rates").isJsonNull()) {
            JsonObject conversionRates = obj1.getAsJsonObject("conversion_rates");
            // Verificar si el campo "MXN" existe en "conversion_rates"
            if (conversionRates.has("USD")) {
                dolar=conversionRates.get("USD").getAsDouble();
                //System.out.println("Tipo de cambio de USD: " + dolar);
            } else {
                System.out.println("El campo 'USD' no está presente en el JSON.");
            }
        } else {
            System.out.println("El campo 'conversion_rates' no está presente o es nulo en el JSON.");
        }
    }
    
    
    //metodo para extrar el valor de la moneda de colombia
    public void extraerColombiano(){
        // Verificar si el campo "conversion_rates" existe y no es nulo
        if (obj1.has("conversion_rates") && !obj1.get("conversion_rates").isJsonNull()) {
            JsonObject conversionRates = obj1.getAsJsonObject("conversion_rates");

            // Verificar si el campo "MXN" existe en "conversion_rates"
            if (conversionRates.has("COP")) {
                cop=conversionRates.get("COP").getAsDouble();
                //System.out.println("Tipo de cambio de colombianos: " + cop);
            } else {
                System.out.println("El campo 'COP' no está presente en el JSON.");
            }
        } else {
            System.out.println("El campo 'conversion_rates' no está presente o es nulo en el JSON.");
        }
    }
    //metodo para extrar el valor de la moneda de argentina
    public void extraerArgentinos(){
        // Verificar si el campo "conversion_rates" existe y no es nulo
        if (obj1.has("conversion_rates") && !obj1.get("conversion_rates").isJsonNull()) {
            JsonObject conversionRates = obj1.getAsJsonObject("conversion_rates");

            // Verificar si el campo "MXN" existe en "conversion_rates"
            if (conversionRates.has("ARS")) {
                args=conversionRates.get("ARS").getAsDouble();
                //System.out.println("Tipo de cambio de colobianos: " + args);
            } else {
                System.out.println("El campo 'COP' no está presente en el JSON.");
            }
        } else {
            System.out.println("El campo 'conversion_rates' no está presente o es nulo en el JSON.");
        }
    }


    //pasar de mexicanos a dolares 
    public void mexicanosDolar(){
        extraerMXN();
        md= (valorConvertir/mxnRate);
        System.out.println(valorConvertir+" pesos mexicanos a dolares son : "+md);
    }
    //pasar de doalres a mexicanos 
    public void dolaresMexicanos(){
        extraerMXN();
        md= (valorConvertir*mxnRate);
        System.out.println(valorConvertir+" dolares a pesos mexicanos son : "+md);
    }
    //pasar de dolares a argentinos 
    public void dolaresArgentinos(){
        extraerArgentinos();
        md= (valorConvertir*args);
        System.out.println(valorConvertir+" dolares a pesos argentinos son : "+md);
    }
    // pasar de colbianos a dolares 
    public void colbianosDolares(){
        extraerColombiano();
        md= (valorConvertir/cop);
        System.out.println(valorConvertir+" pesos colombianos a dolares: "+md);
    }
}
 