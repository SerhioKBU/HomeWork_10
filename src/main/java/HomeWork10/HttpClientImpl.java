package HomeWork10;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class HttpClientImpl implements HttpClient{
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    URL urlConnect;
    Response response = new Response();
    HttpURLConnection connection;

    @Override
    public Response get(String url, Map<String, String> headers) {
        try {
            // Create connection and send request
            urlConnect = new URL(url);
            connection = (HttpURLConnection) urlConnect.openConnection();

            connection.setRequestMethod("GET");
            for (Map.Entry<String, String> header : headers.entrySet()) {
                connection.setRequestProperty(header.getKey(),
                        header.getValue());
            }
            connection.connect();

            // Get response
            int responseCode = connection.getResponseCode();
            response.setStatusCode(responseCode);
            String responseMessage = connection.getResponseMessage();
            response.setStatusText(responseMessage);
            System.out.println(ANSI_GREEN + "ResponseCode: " + responseCode + ANSI_RESET );
            //System.out.println("StatusText " + responseMessage);

            if (responseCode == HttpURLConnection.HTTP_OK) {
                Map<String, String> headersMap = new HashMap<>();
                    for (Map.Entry<String, List<String>> header : connection.getHeaderFields().entrySet()) {
                        headersMap.put(header.getKey(),header.getValue().get(0));
                    }
            response.setHeaders(headersMap);
                //System.out.println(headersMap);

                Scanner sc = new Scanner(connection.getInputStream());
                while (sc.hasNextLine()) {
                    sc.nextLine();
                }

                connection.getInputStream().close();
            } else {
                System.out.println(ANSI_RED + "GET request doesn't work" + ANSI_RESET);
        }

        } catch (IOException e) {
            e.printStackTrace();
        }
         return response;
    }

    @Override
    public Response post(String url, Map<String, String> headers, byte[] payload) {
        try {
            urlConnect = new URL(url);
            connection = (HttpURLConnection) urlConnect.openConnection();
            connection.setRequestMethod("POST");

            for (Map.Entry<String, String> header : headers.entrySet()) {
                connection.setRequestProperty(header.getKey(), header.getValue());
            }
            connection.setDoOutput(true);
            connection.setDoInput(true);
//            connection.setConnectTimeout(200);
//            connection.setReadTimeout(200);
            connection.connect();

            connection.getOutputStream().write(payload);
            connection.getOutputStream().flush();
            connection.getOutputStream().close();

            int responseCode = connection.getResponseCode();
            response.setStatusCode(responseCode);
            response.setStatusText(connection.getResponseMessage());

            if (responseCode == HttpURLConnection.HTTP_OK) {
                Map<String, String> headersMap = new HashMap<>();
                for (Map.Entry<String, List<String>> header : connection.getHeaderFields().entrySet()) {
                    headersMap.put(header.getKey(),header.getValue().get(0));
                }
                response.setHeaders(headersMap);

                int length = connection.getContentLength();
                byte[] responseBytes = new byte[length];
                connection.getInputStream().read(responseBytes);
                response.setPayload(new String(responseBytes));

                connection.getInputStream().close();
            } else {
                System.out.println(ANSI_RED + "POST request doesn't work" + ANSI_RESET);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public Response post(String url, Map<String, String> headers, String payload) {
        try {
            urlConnect = new URL(url);
            connection = (HttpURLConnection) urlConnect.openConnection();
            connection.setRequestMethod("POST");

            for (Map.Entry<String, String> header : headers.entrySet()) {
                connection.setRequestProperty(header.getKey(), header.getValue());
            }
            connection.setDoOutput(true);
            connection.setDoInput(true);
//            connection.setConnectTimeout(200);
//            connection.setReadTimeout(200);
            connection.connect();

            connection.getOutputStream().write(payload.getBytes(StandardCharsets.UTF_8));
            connection.getOutputStream().flush();
            connection.getOutputStream().close();

            int responseCode = connection.getResponseCode();
            response.setStatusCode(responseCode);
            response.setStatusText(connection.getResponseMessage());

            if (responseCode == HttpURLConnection.HTTP_OK) {
            Map<String, String> headersMap = new HashMap<>();
            for (Map.Entry<String, List<String>> header : connection.getHeaderFields().entrySet()) {
                headersMap.put(header.getKey(),header.getValue().get(0));
            }
            response.setHeaders(headersMap);

                int length = connection.getContentLength();
                byte[] responseBytes = new byte[length];
                connection.getInputStream().read(responseBytes);
                response.setPayload(new String(responseBytes));

                connection.getInputStream().close();
            } else {
                System.out.println(ANSI_RED + "POST request doesn't work" + ANSI_RESET);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public Response put(String url, Map<String, String> headers, byte[] payload) {
        try {
            urlConnect = new URL(url);
            connection = (HttpURLConnection) urlConnect.openConnection();
            connection.setRequestMethod("PUT");

            for (Map.Entry<String, String> header : headers.entrySet()) {
                connection.setRequestProperty(header.getKey(), header.getValue());
            }
            connection.setDoOutput(true);
            connection.setDoInput(true);
//            connection.setConnectTimeout(200);
//            connection.setReadTimeout(200);
            connection.connect();

            connection.getOutputStream().write(payload);
            connection.getOutputStream().flush();
            connection.getOutputStream().close();

            int responseCode = connection.getResponseCode();
            response.setStatusCode(responseCode);
            response.setStatusText(connection.getResponseMessage());

            if (responseCode == HttpURLConnection.HTTP_OK) {
                Map<String, String> headersMap = new HashMap<>();
                for (Map.Entry<String, List<String>> header : connection.getHeaderFields().entrySet()) {
                    headersMap.put(header.getKey(),header.getValue().get(0));
                }
                response.setHeaders(headersMap);

                int length = connection.getContentLength();
                byte[] responseBytes = new byte[length];
                connection.getInputStream().read(responseBytes);
                response.setPayload(new String(responseBytes));

                connection.getInputStream().close();
            } else {
                System.out.println(ANSI_RED + "PUT request doesn't work" + ANSI_RESET);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public Response put(String url, Map<String, String> headers, String payload) {
        try {
            urlConnect = new URL(url);
            connection = (HttpURLConnection) urlConnect.openConnection();
            connection.setRequestMethod("PUT");

            for (Map.Entry<String, String> header : headers.entrySet()) {
                connection.setRequestProperty(header.getKey(), header.getValue());
            }
            connection.setDoOutput(true);
            connection.setDoInput(true);
//            connection.setConnectTimeout(200);
//            connection.setReadTimeout(200);
            connection.connect();

            connection.getOutputStream().write(payload.getBytes(StandardCharsets.UTF_8));
            connection.getOutputStream().flush();
            connection.getOutputStream().close();

            int responseCode = connection.getResponseCode();
            response.setStatusCode(responseCode);
            response.setStatusText(connection.getResponseMessage());

            if (responseCode == HttpURLConnection.HTTP_OK) {
                Map<String, String> headersMap = new HashMap<>();
                for (Map.Entry<String, List<String>> header : connection.getHeaderFields().entrySet()) {
                    headersMap.put(header.getKey(),header.getValue().get(0));
                }
                response.setHeaders(headersMap);


                int length = connection.getContentLength();
                byte[] responseBytes = new byte[length];
                connection.getInputStream().read(responseBytes);
                response.setPayload(new String(responseBytes));

                connection.getInputStream().close();
            } else {
                System.out.println(ANSI_RED + "PUT request doesn't work" + ANSI_RESET);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

    @Override
    public Response delete(String url, Map<String, String> headers, byte[] payload) {
        try {
            urlConnect = new URL(url);
            connection = (HttpURLConnection) urlConnect.openConnection();
            connection.setRequestMethod("DELETE");

            for (Map.Entry<String, String> header : headers.entrySet()) {
                connection.setRequestProperty(header.getKey(), header.getValue());
            }
            connection.setDoOutput(true);
            connection.setDoInput(true);
//            connection.setConnectTimeout(200);
//            connection.setReadTimeout(200);
            connection.connect();

            connection.getOutputStream().write(payload);
            connection.getOutputStream().flush();
            connection.getOutputStream().close();

            int responseCode = connection.getResponseCode();
            response.setStatusCode(responseCode);
            response.setStatusText(connection.getResponseMessage());

            if (responseCode == HttpURLConnection.HTTP_OK) {
                Map<String, String> headersMap = new HashMap<>();
                for (Map.Entry<String, List<String>> header : connection.getHeaderFields().entrySet()) {
                    headersMap.put(header.getKey(),header.getValue().get(0));
                }
                response.setHeaders(headersMap);

                int length = connection.getContentLength();
                byte[] responseBytes = new byte[length];
                connection.getInputStream().read(responseBytes);
                response.setPayload(new String(responseBytes));

                connection.getInputStream().close();
            } else {
                System.out.println(ANSI_RED + "DELETE request doesn't work" + ANSI_RESET);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public Response delete(String url, Map<String, String> headers, String payload) {
        try {
            urlConnect = new URL(url);
            connection = (HttpURLConnection) urlConnect.openConnection();
            connection.setRequestMethod("DELETE");

            for (Map.Entry<String, String> header : headers.entrySet()) {
                connection.setRequestProperty(header.getKey(), header.getValue());
            }
            connection.setDoOutput(true);
            connection.setDoInput(true);
//            connection.setConnectTimeout(200);
//            connection.setReadTimeout(200);
            connection.connect();

            connection.getOutputStream().write(payload.getBytes(StandardCharsets.UTF_8));
            connection.getOutputStream().flush();
            connection.getOutputStream().close();

            int responseCode = connection.getResponseCode();
            response.setStatusCode(responseCode);
            response.setStatusText(connection.getResponseMessage());

            if (responseCode == HttpURLConnection.HTTP_OK) {
                Map<String, String> headersMap = new HashMap<>();
                for (Map.Entry<String, List<String>> header : connection.getHeaderFields().entrySet()) {
                    headersMap.put(header.getKey(),header.getValue().get(0));
                }
                response.setHeaders(headersMap);

                int length = connection.getContentLength();
                byte[] responseBytes = new byte[length];
                connection.getInputStream().read(responseBytes);
                response.setPayload(new String(responseBytes));

                connection.getInputStream().close();
            } else {
                System.out.println(ANSI_RED + "DELETE request doesn't work" + ANSI_RESET);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}
