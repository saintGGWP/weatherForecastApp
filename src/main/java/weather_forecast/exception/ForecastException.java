package weather_forecast.exception;

/**
 * Кастомное исключение при ошибках в бизнес
 */
public class ForecastException extends Exception {

    /**
     * Конструктор
     * @param message сообщение об ошибке
     */
    public ForecastException(String message) {
        super(message);
    }
}
