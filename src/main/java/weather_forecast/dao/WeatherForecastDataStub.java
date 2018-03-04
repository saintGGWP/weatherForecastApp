package weather_forecast.dao;

import weather_forecast.pojo.Forecast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Класс для получения данных по прогнозам погоды
 */
public class WeatherForecastDataStub {

    /** Прогнозы погоды */
    private static Map<String, List<Forecast>> data = new HashMap<>();

    static {
        List<Forecast> moscowForecastList = new ArrayList<>();
        Forecast moscowForecast1 = new Forecast();
        moscowForecast1.setCity("moscow");
        moscowForecast1.setDate("2018-03-04");
        moscowForecast1.setDegrees("+13C");
        moscowForecast1.setHumidity("75%");
        moscowForecastList.add(moscowForecast1);
        Forecast moscowForecast2 = new Forecast();
        moscowForecast2.setCity("moscow");
        moscowForecast2.setDate("2018-03-03");
        moscowForecast2.setDegrees("+14C");
        moscowForecast2.setHumidity("77%");
        moscowForecastList.add(moscowForecast2);
        data.put("moscow", moscowForecastList);

        List<Forecast> tverForecastList = new ArrayList<>();
        Forecast tverForecast = new Forecast();
        tverForecast.setCity("tver");
        tverForecast.setDate("2018-03-04");
        tverForecast.setDegrees("+17C");
        tverForecast.setHumidity("77%");
        tverForecastList.add(tverForecast);
        data.put("tver", tverForecastList);
    }

    /**
     * Конструктор
     */
    private WeatherForecastDataStub() {}

    /**
     * Получение прогноза погоды
     * @param city город
     * @param date дата
     * @return прогноз
     */
    public static Forecast findForecast(String city, String date) {
        return data.entrySet()
                .stream()
                .filter(entry -> entry.getKey().equals(city))
                .map(Map.Entry::getValue)
                .flatMap(List::stream)
                .collect(Collectors.toList())
                .stream()
                .filter(forecast -> forecast.getDate().equals(date))
                .findFirst()
                .orElse(null);
    }
}

