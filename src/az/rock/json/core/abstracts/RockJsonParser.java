package az.rock.json.core.abstracts;

import az.rock.json.exception.InvalidJsonFormatException;

import java.io.IOException;

public interface RockJsonParser {
    String parse(String json) throws IOException, InvalidJsonFormatException;
}
