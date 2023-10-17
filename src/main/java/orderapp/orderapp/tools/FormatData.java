package orderapp.orderapp.tools;

import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;

public class FormatData {

    public JSONObject restTemplate(String url) {
        RestTemplate restTemplate   = new RestTemplate();
        String request = restTemplate.exchange(url, this.httpMethodGet(), this.httpEntity(), String.class).getBody();
        return new JSONObject(request);
    }


    public JSONObject restTemplatePOST(String url, HttpEntity<HashMap<String, Object>> entity) {
        RestTemplate restTemplate   = new RestTemplate();
        String request = restTemplate.exchange(url, this.httpMethodPost(), entity, String.class).getBody();
        return new JSONObject(request);
    }

    public JSONObject restTemplatePut(String url, HttpEntity<HashMap<String, Object>> entity) {
        RestTemplate restTemplate   = new RestTemplate();
        String request = restTemplate.exchange(url, this.httpMethodPut(), entity, String.class).getBody();
        return new JSONObject(request);
    }

    public HttpEntity<String> httpEntity() {
        HttpHeaders headers         = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        return new HttpEntity<>(headers);
    }

    public HttpMethod httpMethodGet() {
        return HttpMethod.GET;
    }

    public HttpMethod httpMethodPost() {
        return HttpMethod.POST;
    }

    public HttpMethod httpMethodPut() {
        return HttpMethod.PUT;
    }
}
