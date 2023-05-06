package backend.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class JsonEdit {
    public static String getUser(String email){
        JSONArray json = reader();
        String user = "";
        for (Object o : json) {
            JSONObject obj = (JSONObject) o;
            if(obj.get("email").equals(email)){
                user += obj.get("nome");
                user += " ";
                user += obj.get("cognome");
            }
        }
        return user;
    }

    public static boolean writeSaldo(String nome, String cognome, double saldo) {
        JSONArray json = reader();
        for (Object o : json) {
            JSONObject obj = (JSONObject) o;
            if (obj.get("nome").equals(nome) && obj.get("cognome").equals(cognome)) {
                obj.put("saldo", saldo);
            }
        }
        return writer(json);
    }

    // Metodo statico dove viene letto il saldo dell utente passandoli come parametro il nome e cognome
    public static double readSaldo(String nome, String cognome) {
        JSONArray json = reader();
        for (Object o : json) {
            JSONObject obj = (JSONObject) o;
            if (obj.get("nome").equals(nome) && obj.get("cognome").equals(cognome)) {
                return Double.parseDouble(obj.get("saldo").toString());
            }
        }
        return 0;
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
