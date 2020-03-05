
import java.io.Serializable;

public class WeatherData implements Serializable {

    private String air_pressure;
    private String weather_state;
    private String win_speed;
    private String humidity;
    private String temp;

    public String getAir_pressure() {
        return air_pressure;
    }

    public void setAir_pressure(String air_pressure) {
        this.air_pressure = air_pressure;
    }

    public String getWeather_state() {
        return weather_state;
    }

    public void setWeather_state(String weather_state) {
        this.weather_state = weather_state;
    }

    public String getWin_speed() {
        return win_speed;
    }

    public void setWin_speed(String win_speed) {
        this.win_speed = win_speed;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    @Override
    public String toString() {
        return "Weather{" + "air_pressure=" + air_pressure + ", weather_state=" + weather_state + ", win_speed=" + win_speed + ", humidity=" + humidity + ", temp=" + temp + '}';
    }

}
