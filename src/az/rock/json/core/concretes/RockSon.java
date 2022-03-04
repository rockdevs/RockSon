package az.rock.json.core.concretes;

import az.rock.json.core.abstracts.RockJsonParser;
import az.rock.json.exception.InvalidJsonFormatException;

import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;

public class RockSon implements RockJsonParser {

    private String context;

    private int initialCapacity = JsonSize.SMALL.getInitialCapacity();

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
        return jsonTrimmer.replace(" ","").replace("\n","").replace("\t","");
    }



    private String proceed(String json) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        final StringReader reader = new StringReader(json);
        int index = 0;


        while (index < json.length()){
            char character = (char) reader.read();
            if((character != '}') == (character != ']'))
                stringBuilder.append(character);

            if(character=='{' || character=='[') stringBuilder.append(increment());
            if(character==',') stringBuilder.append(incrementNormal());
            if(character=='}' || character==']') {
                stringBuilder.append(decrement());
                stringBuilder.append(character);
            }
            index++;
        }
        return stringBuilder.toString();
    }


    private String increment(){
        StringBuilder incBuilder = new StringBuilder();
        int count  = this.lastTabCount;
        incBuilder.append('\n');
        for (int i = 0;i <= lastTabCount;i++)
            incBuilder.append('\t');
        this.lastTabCount++;
        return incBuilder.toString();
    }

    private String incrementNormal(){
        StringBuilder stringBuilder = new StringBuilder();
        int count  = this.lastTabCount;
        stringBuilder.append('\n');
        for (int i = 0;i < lastTabCount;i++)
            stringBuilder.append('\t');
        return stringBuilder.toString();
    }

    private String decrement(){
        StringBuilder stringBuilder = new StringBuilder();
        int count  = this.lastTabCount--;
        stringBuilder.append('\n');
        for (int i = 0;i < count-1;i++)
            stringBuilder.append('\t');
        return stringBuilder.toString();
    }

}
