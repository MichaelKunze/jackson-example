import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
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
  public Object deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException, JsonProcessingException {
    final JsonNode node = p.getCodec().readTree(p);
    // TODO: hier fehlt noch was ;)
    return node;
  }
}
