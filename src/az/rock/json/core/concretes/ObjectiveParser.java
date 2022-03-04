package az.rock.json.core.concretes;

import az.rock.json.core.abstracts.RockJsonParser;

public class ObjectiveParser implements RockJsonParser {

    private final String json;

    public ObjectiveParser(String json) {
        this.json = json;
    }

    @Override
    public String parse() {
        return "";
    }



}
