
/**
 *
 * @author Ashen Jayasinghe
 */
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.net.*;
import java.io.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server extends UnicastRemoteObject implements ServerClientInterface {

    public static String data;

    public Server() throws RemoteException {

        System.out.println("Weather server is running");
    }

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {

        Registry reg = LocateRegistry.createRegistry(1099); //Creating Registry.

        ServerClientInterface s = new Server();

        reg.bind("WeatherData", s);  //Registering Server in the RMI Registry.

        System.out.println("Server is Ready");

    }

    @Override
    public WeatherData getWeatherState(String city) throws RemoteException, IOException {
        APIService api = new APIService(city);
        return api.getWeather();
    }
}
