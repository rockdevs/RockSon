package az.rock.json.core.concretes;

import az.rock.json.core.abstracts.RockPretty;
import az.rock.json.exception.InvalidJsonFormatException;

import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;

public class SimplePretty implements RockPretty {

    private Integer lastTabCount = 0;

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
        String incBuilder = '\n' +
                "\t".repeat(Math.max(0, lastTabCount + 1));
        this.lastTabCount++;
        return incBuilder;
    }

    private String incrementNormal(){
        return '\n' +
                "\t".repeat(Math.max(0, lastTabCount));
    }

    private String decrement(){
        StringBuilder stringBuilder = new StringBuilder();
        int count  = this.lastTabCount--;
        stringBuilder.append('\n');
        stringBuilder.append("\t".repeat(Math.max(0, count - 1)));
        return stringBuilder.toString();
    }

}
