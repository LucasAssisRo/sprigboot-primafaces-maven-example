/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lucasassisro.github.io.autocomplete.controller;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import lucasassisro.github.io.autocomplete.App;
import lucasassisro.github.io.autocomplete.model.Country;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author lucasassisrodrigues
 */
@RestController
public class CountryController {

    private class Coordinate {

        public final static double EARTH_RADIUS = 6371e3; // Radius of the earth
        public double latitude;
        public double longitude;

        public Coordinate(double latitude, double longitude) {
            this.latitude = latitude;
            this.longitude = longitude;
        }

        public Coordinate(Country country) {
            this.latitude = country.getLat();
            this.longitude = country.getLng();
        }

        public double distanceBetweeen(Coordinate coordinate) {
            double φ1 = Math.toRadians(this.latitude);
            double φ2 = Math.toRadians(coordinate.latitude);
            double Δφ = Math.toRadians(coordinate.latitude - this.latitude);
            double Δλ = Math.toRadians(coordinate.longitude - this.longitude);
            double a = Math.sin(Δφ / 2) * Math.sin(Δφ / 2)
                    + Math.cos(φ1) * Math.cos(φ2)
                    * Math.sin(Δλ / 2) * Math.sin(Δλ / 2);
            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
            return EARTH_RADIUS * c;
        }
    }

    @RequestMapping(method = GET, value = "/country")
    public ArrayList<Country> getCountry(@RequestParam(value = "name", defaultValue = "Italy") String name) {
        return App.countries.stream()
                .filter(country -> country.getName().equals(name))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @RequestMapping(method = GET, value = "/autocomplete")
    public ArrayList<String> getAutocomplete(@RequestParam(value = "partial", defaultValue = "Italy") String partial) throws IOException {
        return this.getCountries(partial);
    }

    public ArrayList<String> getCountries(String partial) throws IOException {
        Coordinate currentLocation = this.getCurrentLocation();
        return App.countries.stream()
                .filter(country -> country.getName().startsWith(partial.substring(0, 1).toUpperCase() + partial.substring(1)))
                .sorted((Country country1, Country country2) -> {
                    double distance1 = currentLocation.distanceBetweeen(new Coordinate(country1));
                    double distance2 = currentLocation.distanceBetweeen(new Coordinate(country2));
                    return distance1 > distance2 ? 1 : (distance1 < distance2 ? -1 : 0);
                })
                .map((Object country) -> ((Country) country).getName())
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private Coordinate getCurrentLocation() throws MalformedURLException, IOException {
        URL url = new URL("http://api.ipstack.com/check?access_key=a1d5abe0fd6709ed6ee80744cc29def2");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        Scanner s = new Scanner(connection.getInputStream()).useDelimiter("\\A");
        JSONObject location = new JSONObject(s.hasNext() ? s.next() : "");
        connection.disconnect();
        return new Coordinate(location.getDouble("latitude"), location.getDouble("longitude"));
    }
}
