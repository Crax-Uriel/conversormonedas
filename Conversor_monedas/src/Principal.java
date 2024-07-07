import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URI;
import javax.swing.JOptionPane;

public class Principal  {
    public static void main(String[] args) throws IOException, InterruptedException {
        String monedas[] = {"Pesos Mexicanos-> Dolar","Dolar-> Pesos Mexicanos",
            "Dolar->Pesos Argentinos","Pesos Colombianos -> Dolat","Salir"};
        String op_conversor;
        double valorConvertir;

        JOptionPane.showMessageDialog(null, "Bienvenido al conversor de monedas");

        do{
            op_conversor= (String) JOptionPane.showInputDialog(null, "Selecciona una de las conversiones", "Conversor de monedas", JOptionPane.QUESTION_MESSAGE,null, monedas, monedas[0]);
            if(op_conversor.equals("Salir")){
                break;
            }
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("https://v6.exchangerate-api.com/v6/f292149afd4107fccc1b3cfb/latest/USD"))
            .build();

            valorConvertir = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor monetario a convertir: "));
            HttpResponse<String> response = client
            .send(request, HttpResponse.BodyHandlers.ofString());
            //tradformamos a json y lo imprimimos
            String json = response.body();
            //System.out.println(json);


            Gson gson = new Gson();
            JsonObject obj1 =  gson.fromJson(json, JsonObject.class);
            Monedas mo = new Monedas (obj1,valorConvertir);
            //Monedas moc = new Monedas ();
            switch(op_conversor){
                case "Pesos Mexicanos-> Dolar":
                    mo.mexicanosDolar();
            
                break;

                case "Dolar-> Pesos Mexicanos":
                    mo.dolaresMexicanos();
                break;
                case "Dolar->Pesos Argentinos":
                    mo.dolaresArgentinos();
                   break;                   
                case "Pesos Colombianos -> Dolat": 
                    mo.colbianosDolares();
                    break;
                case "Salir":
                    break;   
                default:
                    JOptionPane.showMessageDialog(null,"Opcion invalida"); 
            }
        }while(!op_conversor.equals("Salir"));

    }
}
