/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lucasassisro.github.io.autocomplete.view;

/**
 *
 * @author lucasassisrodrigues
 */
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
import javax.inject.Named;
import lucasassisro.github.io.autocomplete.model.Country;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.Mapping;

@Named
public class AutoCompleteView {

    private String text;
    private String result;

    public void submit() throws MalformedURLException, IOException {
        URL url = new URL("http://localhost:8080/country?name=" + this.text.replace(" ", "%20"));
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        Scanner s = new Scanner(connection.getInputStream()).useDelimiter("\\A");
        String countryString = s.hasNext() ? s.next() : "";
        countryString = countryString.replace("[", "").replace("]", "");
        Country country = new Country(new JSONObject(countryString));
        this.result = country.toString();
    }

    public List<String> completeText(String query) throws MalformedURLException, IOException {
        URL url = new URL("http://localhost:8080/autocomplete?partial=" + query.replace(" ", "%20"));
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        Scanner scanner = new Scanner(connection.getInputStream()).useDelimiter("\\A");
        String completionText = scanner.hasNext() ? scanner.next() : "";
        completionText = completionText.replace("[", "").replace("]", "").replace("\"", "");
        return Arrays.asList(completionText.split(","));
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
