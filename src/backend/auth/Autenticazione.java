package backend.auth;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class Autenticazione {
    public static boolean login(String email, String password) {
        JSONArray json = reader();

        for (Object o : json) {
            JSONObject obj = (JSONObject) o;
            if (obj.get("email").equals(email) && obj.get("password").equals(password)) {
                return true;
            }
        }
        if(password == ""){
            for (Object o : json) {
                JSONObject obj = (JSONObject) o;
                if (obj.get("email").equals(email)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean register(String nome, String cognome, String email, String password, String intestatarioCarta, String CVV, String scadenza, String numeroCarta, double saldo) {
        // Controllo se gia esiste un utente con la stessa email
        if(login(email, "")!= true){

            JSONArray json = reader() == null ? new JSONArray() : reader();
            
            // Aggiunta ad una mappa i dati della carta
            Map map2 = new LinkedHashMap(4);
            map2.put("CVV", CVV);
            map2.put("scadenza", scadenza);
            map2.put("numeroCarta", numeroCarta);
            map2.put("intestatarioCarta", intestatarioCarta);
            
            // Aggiunta ad una mappa i dati base dell utente
            Map map = new LinkedHashMap(6);
            map.put("nome", nome);
            map.put("cognome", cognome);
            map.put("email", email);
            map.put("password", password);
            map.put("saldo", saldo);
            map.put("carta", map2);
            // Aggiunta ad una mappa i dati base dell utente e i dati della carta
            json.add(map);
            
            // Scrive il file json
            return writer(json);
        }else{
            return false;
        }
    }

    private static JSONArray reader() {
        try {
            Object obj = new JSONParser().parse(new FileReader("src\\backend\\auth\\Database.json"));
            JSONArray json = (JSONArray) obj;
            return json;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private static boolean writer(JSONArray json) {
        // Scrive il file json
        try {
            PrintWriter pw = new PrintWriter("src\\backend\\auth\\Database.json");
            pw.write(json.toJSONString());

            pw.flush();
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
