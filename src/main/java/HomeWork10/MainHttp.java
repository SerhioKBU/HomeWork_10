package HomeWork10;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class MainHttp {
    public final static String ADDRESS1 = "https://httpbin.org/get";
    public final static String ADDRESS2 = "https://httpbin.org/post";
    public final static String ADDRESS3 = "https://httpbin.org/put";
    public final static String ADDRESS4 = "https://httpbin.org/delete";
    public final static String ADDRESS5 = "http://webcode.me";
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
        response = httpClient.get(ADDRESS1,
                Map.of("", ""));
        System.out.println(response);

        System.out.println("-------------POST REQUEST STRING payload------------------");
        response = httpClient.post(ADDRESS2,
                Map.of("User-Agent", "Google Chrome",
                        "Content-Type", "text/plain"),
                new String(postPayLoad));
        System.out.println(response);

        System.out.println("-------------PUT REQUEST STRING payload------------------");
        response = httpClient.put(ADDRESS3,
                Map.of("User-Agent", "Internet Explorer",
                        "Content-Type", "text/html; charset=utf-8"),
                "Post PayLoad");
        System.out.println(response);

        System.out.println("-------------DELETE REQUEST STRING payload------------------");
        response = httpClient.delete(ADDRESS4,
                Map.of("", ""), "");
        System.out.println(response);

        System.out.println("-------------POST REQUEST byte[] payload------------------");
        response = httpClient.post(ADDRESS2,
                Map.of("Content-Type", "application/x-www-form-urlencoded"), postPayLoad);
        System.out.println(response);

        System.out.println("-------------PUT REQUEST byte[] payload-----------------");
        response = httpClient.put(ADDRESS3,
                Map.of("Accept", "audio/mp3, video/mkv, image/png"), putPayLoad);
        System.out.println(response);

        System.out.println("-------------DELETE REQUEST byte[] payload-----------------");
        response = httpClient.delete(ADDRESS4,
                Map.of("", ""), new byte[]{});
        System.out.println(response);

        System.out.println("-------------GET REQUEST (java.net.HttpClient)-----------------");
        HttpClientOriginal httpClient1 = new HttpClientOriginal();
        System.out.println(httpClient1.getRequest(ADDRESS5));

        System.out.println("-------------POST REQUEST (java.net.HttpClient)-----------------");
        httpClient1 = new HttpClientOriginal();
        System.out.println(httpClient1.postRequest(ADDRESS2,
                Map.of("Accept", "application/XML"),
                new String(postPayLoad)));
    }
}
