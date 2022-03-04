package az.rock.json.core.concretes;

import az.rock.json.core.abstracts.RockJsonParser;
import az.rock.json.exception.InvalidJsonFormatException;

import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;

public class RockSon implements RockJsonParser {

    private String context;

    private int initialCapacity = JsonSize.SMALL.getInitialCapacity();

    private StringBuilder stringBuilder;

    private StringBuilder incBuilder;

    private StringBuilder decBuilder;

    private final char tab = ' ';

    private Integer lastTabCount = 0;

    public RockSon() {

    }

    public RockSon(JsonSize initialCapacity){
        this.initialCapacity = initialCapacity.getInitialCapacity();
    }

    public RockSon(int initialCapacity){
        this.initialCapacity = initialCapacity;
    }

    public RockSon(String json) {
        this.context = json.trim();
    }

    public RockSon(String json,JsonSize initialCapacity) {
        this.initialCapacity = initialCapacity.getInitialCapacity();
        this.context = json.trim();
    }

    public RockSon(String json,int initialCapacity) {
        this.initialCapacity = initialCapacity;
        this.context = json.trim();
    }

    public void setContext(String context) {
        this.context = context.trim();
    }

    @Override
    public String parse(String json) throws IOException, InvalidJsonFormatException {
        return this.proceed(valid(json));
    }


    private String valid(String json) throws InvalidJsonFormatException {
        String jsonTrimmer = json.trim();
        char first = (char)jsonTrimmer.getBytes(StandardCharsets.UTF_8)[0];
        char last= (char) jsonTrimmer.getBytes(StandardCharsets.UTF_8)[jsonTrimmer.length()-1];
        if((first != '{') == (first != '[') || (last != '}') == (last != ']')) throw new InvalidJsonFormatException();
        return jsonTrimmer;
    }



    private String proceed(String json) throws IOException {
        stringBuilder = new StringBuilder();
        StringReader reader = new StringReader(json);
        int lengthOfJson = 0;

        while (lengthOfJson < json.length()){
            char character = (char) reader.read();
            stringBuilder.append(character);




            lengthOfJson++;
        }
        //return stringBuilder.toString();
        return "SSS";
    }


    private String increment(){
        incBuilder = new StringBuilder();

        return incBuilder.toString();
    }

    private String decrement(){
        decBuilder = new StringBuilder();

        return decBuilder.toString();
    }

}
