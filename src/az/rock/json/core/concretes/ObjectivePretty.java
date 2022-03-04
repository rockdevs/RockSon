package az.rock.json.core.concretes;

import az.rock.json.core.abstracts.RockPretty;

public class ObjectivePretty implements RockPretty {

    private final String json;

    public ObjectivePretty(String json) {
        this.json = json;
    }

    @Override
    public String parse() {
        return "";
    }



}
