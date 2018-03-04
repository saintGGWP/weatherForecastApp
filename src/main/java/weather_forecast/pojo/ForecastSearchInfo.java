package weather_forecast.pojo;

/**
 * Объект, хранящий информацию, необходимую для получения прогноза погоды
 */
public class ForecastSearchInfo {

    /** Город запроса прогноза */
    private String city;
    /** Дата запроса прогноза */
    private String date;

    // getters and setters

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}