
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

public class APIService {

    OkHttpClient client;
    private final String city;

    public String getCity() {
        return city;
    }

    public static void main(String[] args) throws IOException {
        APIService api = new APIService("Pakokku");
        System.out.println(api.getWeather());
    }

    public APIService(String city) throws IOException {
        this.city = city;
        this.client = new OkHttpClient();

    }

    public WeatherData getWeather() throws IOException {
        WeatherData weather = new WeatherData();
        JSONObject jSONObject = this.run();
        if (jSONObject.has("cod") && jSONObject.getInt("cod") == 404) {
            return null;
        }

        weather.setWeather_state(jSONObject.getJSONArray("weather").getJSONObject(0).getString("description"));
        JSONObject main_json = jSONObject.getJSONObject("main");
        weather.setAir_pressure(main_json.getDouble("pressure") + "");
        weather.setHumidity(main_json.getDouble("humidity") + "");
        weather.setTemp(main_json.getDouble("temp") + "");
        weather.setWin_speed(jSONObject.getJSONObject("wind").getDouble("speed") + "");
        return weather;
    }

    private JSONObject run() throws IOException {
        String url = "http://api.openweathermap.org/data/2.5/weather?q=" + getCity() + "&APPID=5fd173da0fa5ab61fdb9364a4a9f5cb1&units=metric";
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (
                 Response response = client.newCall(request).execute()) {
            return new JSONObject(response.body().string());
        }
    }

}
