package az.rock.json.context.concretes;

import az.rock.json.context.abstracts.RockJsonParser;

import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;

public class RockSon implements RockJsonParser {

    private String context;

    private int initialCapacity = JsonSize.SMALL.getInitialCapacity();

    private StringBuilder stringBuilder;

    private StringBuilder incDec;

    private final char tab = '\t';

    private int lastTabCount = 0;

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
    public String parse(String json) throws IOException {
        stringBuilder = new StringBuilder();
        StringReader reader = new StringReader(json);
        int indexOfJson = 0;
        while (indexOfJson < json.length()){

            char character = (char) reader.read();

            if (character=='{' || character == '[')stringBuilder.append(increment());
            else if (character=='}' || character == ']')stringBuilder.append(decrement());

            stringBuilder.append(character);
            indexOfJson++;
        }
        return stringBuilder.toString();
    }

    private String refactor(String json){
        return json.trim();
    }


    private String increment(){
        incDec = new StringBuilder();

        int max = lastTabCount;
        incDec.append(" \n");
        for (int k = 0;k <= max + 1;k++){
            incDec.append(tab);
        }
        return incDec.toString();
    }

    private String decrement(){
        incDec = new StringBuilder();
        int max = lastTabCount;
        incDec.append('\n');
        for (int k = 0;k < max;k++){
            incDec.append(tab);
        }
        return incDec.toString();
    }

}
