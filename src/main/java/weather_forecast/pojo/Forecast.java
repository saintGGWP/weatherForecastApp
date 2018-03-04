package weather_forecast.pojo;

/**
 * Объект с информацией о прогнозе погоды
 */
public class Forecast {

    /** Город */
    private String city;
    /** Дата */
    private String date;
    /** Градусы */
    private String degrees;
    /** Влажность */
    private String humidity;

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

    public String getDegrees() {
        return degrees;
    }

    public void setDegrees(String degrees) {
        this.degrees = degrees;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }
}