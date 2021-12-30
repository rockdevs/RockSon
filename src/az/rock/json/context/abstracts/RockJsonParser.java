package az.rock.json.context.abstracts;

import java.io.IOException;

public interface RockJsonParser {
    String parse(String json) throws IOException;
}
