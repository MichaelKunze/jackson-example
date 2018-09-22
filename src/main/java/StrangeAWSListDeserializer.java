import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class StrangeAWSListDeserializer extends StdDeserializer<Object> {

  public StrangeAWSListDeserializer() {
    this(null);
  }

  private StrangeAWSListDeserializer(final Class<?> vc) {
    super(vc);
  }

  @Override
  public Object deserialize(final JsonParser jsonParser, final DeserializationContext deserializationContext) throws IOException {
    final List<List<String>> result = new ArrayList<>();
    final JsonNode outerList = jsonParser.getCodec().readTree(jsonParser);
    outerList.forEach(innerList -> {
      final List<String> interimResult = new ArrayList<>();
      innerList.forEach(innerListEntry -> {
        if (innerListEntry.isTextual()) {
          interimResult.add(innerListEntry.toString());
        }
      });
      result.add(interimResult);
    });
    return result;
  }
}
