package backend.Auth;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONException;
import org.json.JSONObject;

public class Authentication{
    String Path;
    JSONObject json;
    PrintWriter out;

    public void setPath(String Email){
        this.Path="src/backend/Auth/"+Email+".json";
    }

    public boolean Check()throws IOException{
        File Ack=new File(Path);
        boolean ack=Ack.exists();
        json = new JSONObject();
        return ack;
    }

    public void createPrinter()throws IOException{
        out= new PrintWriter(new FileWriter(Path));
    }

    public void Register(String nome, String cognome, String email, String password)throws IOException{
        json.put("email", email);
        json.put("password", password);
        json.put("nome", nome);
        json.put("cognome", cognome);
        Push();
    }

    public void AggiungiPagamento(String Persona, String numero, String Scadenza, String CVV)throws IOException{
        json.put("Proprietario", Persona);
        json.put("ID", numero);
        json.put("Scadenza", Scadenza);
        json.put("CVV", CVV);
        Push();
    }

    public boolean Login(String Pass)throws IOException, OutOfMemoryError, SecurityException{
        byte[] bytes = Files.readAllBytes(Paths.get(Path));
        String jsonStr = new String(bytes);
        json=new JSONObject(jsonStr);

        if(json.get("password").equals(Pass)){
            return true;
        }
        return false;
    }

    public void Push() throws IOException{
        out.write(json.toString());
        out.flush();
    }
}