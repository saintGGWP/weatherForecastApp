package weather_forecast;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import weather_forecast.exception.ForecastException;

/**
 * Контролер для обработки исключений
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /** Логер */
    private static final Logger logger = Logger.getLogger(WeatherForecastController.class);

    /**
     * Обработчик для глобальных исключений
     * @param ex исключение
     * @return модель
     */
    @ExceptionHandler(Exception.class)
    public ModelAndView handleGeneralException(Exception ex) {
        ModelAndView model = new ModelAndView();
        logger.info("Weather forecast. Internal error", ex);
        model.setViewName("error");
        return model;
    }

    /**
     * Обработчик для кастомных исключений {@code ForecastException}
     * @param ex исключение
     * @return модель
     */
    @ExceptionHandler(ForecastException.class)
    public ModelAndView handleCustomException(Exception ex) {
        ModelAndView model = new ModelAndView();
        logger.error("Weather forecast. Error", ex);
        model.addObject("msg", ex.getMessage());
        model.setViewName("error");
        return model;
    }
}