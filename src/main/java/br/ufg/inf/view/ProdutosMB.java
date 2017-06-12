package br.ufg.inf.view;

import br.ufg.inf.model.Produto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import javax.faces.bean.ManagedBean;
import java.util.List;

@ManagedBean
public class ProdutosMB {

    private final String BASE_URL = "http://localhost:8080/fbe-aula2-atividade1-1.0-SNAPSHOT";

    public List<Produto> getProdutos(){
        Client client = Client.create();
        WebResource webRes = client.resource(BASE_URL + "/resources/produtos");
        String json = webRes.get(String.class);
        Gson gson = new Gson();
        return gson.fromJson(json, new TypeToken<List<Produto>>(){}.getType());
    }
}
