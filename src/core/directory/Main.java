package core.directory;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class Main {
    public static void main(String[] args) throws Exception{
        URL url = new URL("https://api.openweathermap.org/data/2.5/forecast?q=saint+petersburg%2c+ru&appid=eb984bb116ebed6d673cc51129137973");

        HttpURLConnection hpCon = (HttpURLConnection) url.openConnection();

        System.out.println("Метод запроса:" + hpCon.getRequestMethod());
        System.out.println("Код ответа:" + hpCon.getResponseCode());
        System.out.println("Ответное сообщение:" + hpCon.getResponseMessage());
        BufferedReader reader = new BufferedReader(new InputStreamReader(hpCon.getInputStream())); // Создаем объект, читающий тело ответа как поток
        String line;
        while((line = reader.readLine()) != null) { // Пока в ответе есть строки для чтения, читаем их в переменную
            System.out.println(line); // И выводим на экран
        }
        reader.close();

    }
}
