
/**
 *
 * @author Ashen Jayasinghe
 */
import java.io.IOException;
import java.rmi.*;

public interface ServerClientInterface extends Remote {

    public WeatherData getWeatherState(String city) throws RemoteException, IOException;
}
