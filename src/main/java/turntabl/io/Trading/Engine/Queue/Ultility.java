package turntabl.io.Trading.Engine.Queue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Ultility {

    //a function that converts string data to an object
    public static <T> T convertToObject(String data, Class<T> classType){
        ObjectMapper objectMapper = new ObjectMapper();
        T t = null;
        try {
            t = objectMapper.readValue(data, classType);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return t;
    }

    //a function that converts an object to string data
    public static <T> String convertToString(T string){
        ObjectMapper objectMapper = new ObjectMapper();
        String str = null;

        try {
            str = objectMapper.writeValueAsString(string);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return str;
    }
}
