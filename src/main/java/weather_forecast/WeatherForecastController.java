package weather_forecast;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import weather_forecast.dao.WeatherForecastDataStub;
import weather_forecast.exception.ForecastException;
import weather_forecast.pojo.Forecast;
import weather_forecast.pojo.ForecastSearchInfo;

import java.text.MessageFormat;

/**
 * Контролер для работы с прогнозом погоды
 */
@Controller
public class WeatherForecastController {

    /** Логер */
    private static final Logger logger = Logger.getLogger(WeatherForecastController.class);

    /**
     * Получение стартовой страницы
     * @param model модель
     * @return стартовая страница
     */
    @GetMapping("/")
    public String welcomeForm(Model model) {
        logger.info("Getting welcome page");
        model.addAttribute("forecast_search_info", new ForecastSearchInfo());
        return "welcome";
    }

    /**
     * Получение страницы с прогнозом погоды
     * @param forecastSearchInfo информация, необходимая для получения прогноза погоды
     * @param model              модель
     * @return страница прогноза
     * @throws Exception при ошибках
     */
    @PostMapping("/forecast")
    public String forecastSubmit(@ModelAttribute ForecastSearchInfo forecastSearchInfo, Model model) throws Exception {
        logger.info("Weather forecast. Begin");
        String date = forecastSearchInfo.getDate();
        String city = forecastSearchInfo.getCity().toLowerCase();
        logger.info(MessageFormat.format("Weather forecast. Parameters: [city: {0}], [date: {1}]", city, date));
        Forecast forecast = WeatherForecastDataStub.findForecast(city, date);
        if (forecast == null) {
            throw new ForecastException("There is no forecast for your query");
        }
        model.addAttribute(forecast);
        logger.info("Weather forecast. End");
        return "forecast";
    }
}