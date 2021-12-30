package az.rock.json.context.concretes;

import az.rock.json.context.abstracts.RockJsonParser;

public class RockSon implements RockJsonParser {

    private int initialCapacity = JsonSize.SMALL.getInitialCapacity();

    private StringBuilder stringBuilder;

    private final char tab = ' ';

    private int lastTabCount;

    public RockSon(JsonSize initialCapacity){
        this.initialCapacity = initialCapacity.getInitialCapacity();
    }

    @Override
    public String parse(String json) {
        return null;
    }

    private String refactor(String json){
        return json.trim();
    }

    private String prepareTab(){
        StringBuilder stringBuilder = new StringBuilder(initialCapacity);
        return stringBuilder.toString();
    }

}
