package az.rock.json;

import az.rock.json.core.abstracts.RockJsonParser;
import az.rock.json.core.concretes.RockSon;
import az.rock.json.exception.InvalidJsonFormatException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InvalidJsonFormatException {
        RockJsonParser rockJsonParser = new RockSon();
        System.err.println("----------------------------------------");
        String json = "{\"name\":\"John\", \"age\":30, \n\t\"car\":null , \"adress\":{ \"num\":17,\"home\":\"Ecimiz\" }}";
        System.out.println(rockJsonParser.parse(json));
    }
}
