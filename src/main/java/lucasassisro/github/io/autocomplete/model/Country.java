/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lucasassisro.github.io.autocomplete.model;

import java.util.HashMap;
import org.json.JSONObject;

/**
 *
 * @author lucasassisrodrigues
 */
public class Country {

    private final int scalerank;
    private final int labelrank;
    private final String featurecla;
    private final String sovereignt;
    private final String sov_a3;
    private final int adm0_dif;
    private final int level;
    private final String type;
    private final String admin;
    private final String adm0_a3;
    private final int geou_dif;
    private final String geounit;
    private final String gu_a3;
    private final int su_dif;
    private final String subunit;
    private final String su_a3;
    private final String name;
    private final String abbrev;
    private final String postal;
    private final String name_forma;
    private final String terr_;
    private final String name_sort;
    private final int map_color;
    private final int pop_est;
    private final double gdp_md_est;
    private final int fips_10_;
    private final String iso_a2;
    private final String iso_a3;
    private final int iso_n3;
    private final String flag_png;
    private final double lat;
    private final double lng;

    public Country(JSONObject json) {
        this.scalerank = json.getInt("scalerank");
        this.labelrank = json.getInt("labelrank");
        this.featurecla = json.getString("featurecla");
        this.sovereignt = json.getString("featurecla");
        this.sov_a3 = json.getString("featurecla");
        this.adm0_dif = json.getInt("adm0_dif");
        this.level = json.getInt("level");
        this.type = json.getString("type");
        this.admin = json.getString("admin");
        this.adm0_a3 = json.getString("adm0_a3");
        this.geou_dif = json.getInt("geou_dif");
        this.geounit = json.getString("geounit");
        this.gu_a3 = json.getString("gu_a3");
        this.su_dif = json.getInt("su_dif");
        this.subunit = json.getString("subunit");
        this.su_a3 = json.getString("su_a3");
        this.name = json.getString("name");
        this.abbrev = json.getString("abbrev");
        this.postal = json.getString("postal");
        this.name_forma = json.getString("name_forma");
        this.terr_ = json.getString("terr_");
        this.name_sort = json.getString("name_sort");
        this.map_color = json.getInt("map_color");
        this.pop_est = json.getInt("pop_est");
        this.gdp_md_est = json.getDouble("gdp_md_est");
        this.fips_10_ = json.getInt("fips_10_");
        this.iso_a2 = json.getString("iso_a2");
        this.iso_a3 = json.getString("iso_a3");
        this.iso_n3 = json.getInt("iso_n3");
        this.flag_png = json.getString("flag_png");
        this.lat = json.getDouble("lat");
        this.lng = json.getDouble("lng");
    }
    
    public Country(HashMap json) {
        this.scalerank = (int) json.get("scalerank");
        this.labelrank = (int) json.get("labelrank");
        this.featurecla = (String) json.get("featurecla");
        this.sovereignt = (String) json.get("featurecla");
        this.sov_a3 = (String) json.get("featurecla");
        this.adm0_dif = (int) json.get("adm0_dif");
        this.level = (int) json.get("level");
        this.type = (String) json.get("type");
        this.admin = (String) json.get("admin");
        this.adm0_a3 = (String) json.get("adm0_a3");
        this.geou_dif = (int) json.get("geou_dif");
        this.geounit = (String) json.get("geounit");
        this.gu_a3 = (String) json.get("gu_a3");
        this.su_dif = (int) json.get("su_dif");
        this.subunit = (String) json.get("subunit");
        this.su_a3 = (String) json.get("su_a3");
        this.name = (String) json.get("name");
        this.abbrev = (String) json.get("abbrev");
        this.postal = (String) json.get("postal");
        this.name_forma = (String) json.get("name_forma");
        this.terr_ = (String) json.get("terr_");
        this.name_sort = (String) json.get("name_sort");
        this.map_color = (int) json.get("map_color");
        this.pop_est = (int) json.get("pop_est");
        this.gdp_md_est = new Double("" + json.get("gdp_md_est"));
        this.fips_10_ = (int) json.get("fips_10_");
        this.iso_a2 = (String) json.get("iso_a2");
        this.iso_a3 = (String) json.get("iso_a3");
        this.iso_n3 = (int) json.get("iso_n3");
        this.flag_png = (String) json.get("flag_png");
        this.lat = (double) json.get("lat");
        this.lng = (double) json.get("lng");
    }

    public int getScalerank() {
        return scalerank;
    }

    public int getLabelrank() {
        return labelrank;
    }

    public String getFeaturecla() {
        return featurecla;
    }

    public String getSovereignt() {
        return sovereignt;
    }

    public String getSov_a3() {
        return sov_a3;
    }

    public int getAdm0_dif() {
        return adm0_dif;
    }

    public int getLevel() {
        return level;
    }

    public String getType() {
        return type;
    }

    public String getAdmin() {
        return admin;
    }

    public String getAdm0_a3() {
        return adm0_a3;
    }

    public int getGeou_dif() {
        return geou_dif;
    }

    public String getGeounit() {
        return geounit;
    }

    public String getGu_a3() {
        return gu_a3;
    }

    public int getSu_dif() {
        return su_dif;
    }

    public String getSubunit() {
        return subunit;
    }

    public String getSu_a3() {
        return su_a3;
    }

    public String getName() {
        return name;
    }

    public String getAbbrev() {
        return abbrev;
    }

    public String getPostal() {
        return postal;
    }

    public String getName_forma() {
        return name_forma;
    }

    public String getTerr_() {
        return terr_;
    }

    public String getName_sort() {
        return name_sort;
    }

    public int getMap_color() {
        return map_color;
    }

    public int getPop_est() {
        return pop_est;
    }

    public double getGdp_md_est() {
        return gdp_md_est;
    }

    public int getFips_10_() {
        return fips_10_;
    }

    public String getIso_a2() {
        return iso_a2;
    }

    public String getIso_a3() {
        return iso_a3;
    }

    public int getIso_n3() {
        return iso_n3;
    }

    public String getFlag_png() {
        return flag_png;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("scalerank: ").append(this.scalerank).append("   -------   ");
        stringBuilder.append("labelrank: ").append(this.labelrank).append("   -------   ");
        stringBuilder.append("featurecla: ").append(this.featurecla).append("   -------   ");
        stringBuilder.append("sovereignt: ").append(this.sovereignt).append("   -------   ");
        stringBuilder.append("sov_a3: ").append(this.sov_a3).append("   -------   ");
        stringBuilder.append("adm0_dif: ").append(this.adm0_dif).append("   -------   ");
        stringBuilder.append("level: ").append(this.level).append("   -------   ");
        stringBuilder.append("type: ").append(this.type).append("   -------   ");
        stringBuilder.append("admin: ").append(this.admin).append("   -------   ");
        stringBuilder.append("adm0_a3: ").append(this.adm0_a3).append("   -------   ");
        stringBuilder.append("geou_dif: ").append(this.geou_dif).append("   -------   ");
        stringBuilder.append("geounit: ").append(this.geounit).append("   -------   ");
        stringBuilder.append("gu_a3: ").append(this.gu_a3).append("   -------   ");
        stringBuilder.append("su_dif: ").append(this.su_dif).append("   -------   ");
        stringBuilder.append("subunit: ").append(this.subunit).append("   -------   ");
        stringBuilder.append("su_a3: ").append(this.su_a3).append("   -------   ");
        stringBuilder.append("name: ").append(this.name).append("   -------   ");
        stringBuilder.append("abbrev: ").append(this.abbrev).append("   -------   ");
        stringBuilder.append("postal: ").append(this.postal).append("   -------   ");
        stringBuilder.append("name_forma: ").append(this.name_forma).append("   -------   ");
        stringBuilder.append("terr_: ").append(this.terr_).append("   -------   ");
        stringBuilder.append("name_sort: ").append(this.name_sort).append("   -------   ");
        stringBuilder.append("map_color: ").append(this.map_color).append("   -------   ");
        stringBuilder.append("pop_est: ").append(this.pop_est).append("   -------   ");
        stringBuilder.append("gdp_md_est: ").append(this.gdp_md_est).append("   -------   ");
        stringBuilder.append("fips_10_: ").append(this.fips_10_).append("   -------   ");
        stringBuilder.append("iso_a2: ").append(this.iso_a2).append("   -------   ");
        stringBuilder.append("iso_a3: ").append(this.iso_a3).append("   -------   ");
        stringBuilder.append("iso_n3: ").append(this.iso_n3).append("   -------   ");
        stringBuilder.append("flag_png: ").append(this.flag_png).append("   -------   ");
        stringBuilder.append("lat: ").append(this.lat).append("   -------   ");
        stringBuilder.append("lng: ").append(this.lng).append("   -------   ");
        return stringBuilder.toString(); //To change body of generated methods, choose Tools | Templates.
    }
}
