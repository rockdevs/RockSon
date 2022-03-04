package az.rock.json.core.abstracts;

import az.rock.json.exception.InvalidJsonFormatException;

import java.io.IOException;

public interface RockPretty {
    default String parse(String json) throws IOException, InvalidJsonFormatException{ return json;};
    default String parse() { return "json";};
}
