package HomeWork10;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;

public class HttpClientOriginal {
    String responseBody = "";
    java.net.http.HttpClient client = java.net.http.HttpClient.newHttpClient();

    public String getRequest(String address){
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(address))
                .build();
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if(response.statusCode()==200) {
                responseBody = response.body();
            } else {

            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return responseBody;
    }

    public String postRequest (String address, Map<String, String> headers, String payload){

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            HttpRequest request = null;
            for (Map.Entry<String, String> header : headers.entrySet()) {
                String requestBody = objectMapper.writeValueAsString(payload);
                request = HttpRequest.newBuilder()
                        .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                        .header(header.getKey(), header.getValue())
                        .uri(URI.create(address))
                        .build();
            }

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                responseBody = response.body();
            } else {

            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return responseBody;
    }
}
