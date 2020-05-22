package com.sandro.finder.repository;


import com.sandro.finder.domain.Agency;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


@Repository
public class AgencyRepository {

    private RestTemplate restTemplate;

    @Value("${baseURL}")
    private String baseURL;

    @Value("${apiKey}")
    private String key;

    public List<Agency> getAgencies(String latitude, String longitude) {
        String urlGoogle = (new StringBuilder().append(baseURL).append(key)).toString();

        HttpURLConnection conn = null;
        StringBuilder jsonResults = new StringBuilder();
        try {
            URL url = new URL(urlGoogle);
            conn = (HttpURLConnection) url.openConnection();
            InputStreamReader in = new InputStreamReader(conn.getInputStream());

            int read;
            char[] buff = new char[1024];
            while ((read = in.read(buff)) != -1) {
                jsonResults.append(buff, 0, read);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }


        //TO DO CONNECTION WITH GOOGLE API MAPS


        //MOCK AGENCIES
        List<Agency> agencies = new ArrayList<>();
        agencies.add(new Agency("(11) 2628-3135", "Av. Washington Luís, 1171 - Santo Amaro, São Paulo - SP, 04662-002", "10:00"));
        agencies.add(new Agency("(11) 2628-3135", "Alameda Santo Amaro, Av. Adolfo Pinheiro, 478, São Paulo - SP, 04734-000", "Temporariamente Fechada"));
        agencies.add(new Agency("(11) 2628-3135", "Av. de Pinedo, 294 - Santo Amaro, São Paulo - SP, 04764-000", "10:30"));
        agencies.add(new Agency("(11) 2628-3135", "Av. de Pinedo, 505 - Socorro, São Paulo - SP, 04764-001", "09:00"));
        return agencies;
    }
}
