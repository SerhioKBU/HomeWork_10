package HomeWork10;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class MainHttp {
    public static void main(String[] args) {
        Response response;

        Map<String, String> post = new HashMap<>();
        post.put("Student", "Serhii");
        post.put("Level", "Elementary");
        byte[] postPayLoad = post.toString().getBytes(StandardCharsets.UTF_8);

        Map<String, String> put = new HashMap<>();
        put.put("Password", "QWERTY");
        byte[] putPayLoad = put.toString().getBytes(StandardCharsets.UTF_8);

        HttpClient httpClient = new HttpClientImpl();

        System.out.println("-------------GET REQUEST----------------");
        response = httpClient.get("https://httpbin.org/get",
                Map.of("", ""));
        System.out.println(response);

        System.out.println("-------------POST REQUEST STRING payload------------------");
        response = httpClient.post("https://httpbin.org/post",
                Map.of("User-Agent", "Google Chrome",
                        "Content-Type", "text/plain"),
                new String(postPayLoad));
        System.out.println(response);

        System.out.println("-------------PUT REQUEST STRING payload------------------");
        response = httpClient.put("https://httpbin.org/put",
                Map.of("User-Agent", "Internet Explorer",
                        "Content-Type", "text/html; charset=utf-8"),
                "Post PayLoad");
        System.out.println(response);

        System.out.println("-------------DELETE REQUEST STRING payload------------------");
        response = httpClient.delete("https://httpbin.org/delete",
                Map.of("", ""), "");
        System.out.println(response);

        System.out.println("-------------POST REQUEST byte[] payload------------------");
        response = httpClient.post("https://httpbin.org/post",
                Map.of("Content-Type", "application/x-www-form-urlencoded"), postPayLoad);
        System.out.println(response);

        System.out.println("-------------PUT REQUEST byte[] payload-----------------");
        response = httpClient.put("https://httpbin.org/put",
                Map.of("Accept", "audio/mp3, video/mkv, image/png"), putPayLoad);
        System.out.println(response);

        System.out.println("-------------DELETE REQUEST byte[] payload-----------------");
        response = httpClient.delete("https://httpbin.org/delete",
                Map.of("", ""), new byte[]{});
        System.out.println(response);

    }
}
