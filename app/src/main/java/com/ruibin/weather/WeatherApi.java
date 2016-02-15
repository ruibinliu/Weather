package com.ruibin.weather;

import android.util.Log;

import com.google.gson.Gson;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class WeatherApi {
    private static final String WEATHER_API_ADDRESS = "http://www.ruibin.info/weather.php";
    private static final int CONNECT_TIMEOUT = 10000;
    private static final int READ_TIMEOUT = 10000;

    public static Weather getWeather() throws IOException {
        String result = httpGet(WEATHER_API_ADDRESS);
        Log.d("Weather", "result: " + result);
        Gson gson = new Gson();
        Weather weather = gson.fromJson(result, Weather.class);
        Log.d("Weather", weather.toString());
        return weather;
    }

    public static String httpGet(String urlString) throws IOException {
        HttpURLConnection connection = null;
        OutputStream out = null;
        InputStream in = null;
        InputStreamReader reader = null;

        try {
            URL url = new URL(urlString);

            connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(CONNECT_TIMEOUT);
            connection.setReadTimeout(READ_TIMEOUT);
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.setDoOutput(false);

            connection.connect();

            in = connection.getInputStream();
            reader = new InputStreamReader(in);
            int length;
            char[] buffer = new char[8192];
            StringBuffer result = new StringBuffer();

            while ((length = reader.read(buffer)) > 0) {
                result.append(buffer, 0, length);
            }

            return result.toString();
        } finally {
            closeSilently(out);
            closeSilently(reader);
            closeSilently(in);
        }
    }

    public static void closeSilently(Closeable closable) {
        if (closable != null) {
            try {
                closable.close();
            } catch (IOException e) {
                // Ignore
            }
        }
    }
}
