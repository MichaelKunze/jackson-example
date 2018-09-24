import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class MetricsDTODeserializer extends StdDeserializer<MetricsDTO> {

    private final ObjectMapper mapper = new ObjectMapper();

    public MetricsDTODeserializer() {
        this(null);
    }

    public MetricsDTODeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public MetricsDTO deserialize(final JsonParser jp, final DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        final MetricsDTO result = new MetricsDTO();
        final List<MetricItemDTO> items = new ArrayList<>();
        result.setMetricItems(items);

        if (jp.getCurrentToken() != JsonToken.START_ARRAY) {
            throw new JsonParseException(jp, "Start array expected");
        }
        JsonToken currentToken = jp.nextToken();
        while (currentToken != JsonToken.END_ARRAY) {
            if (currentToken == JsonToken.VALUE_STRING) {
                final String value = jp.getText();
                final MetricItemDTO item = new MetricItemDTO();
                item.setValue(value);
                items.add(item);
            } else if (currentToken == JsonToken.START_OBJECT) {
                final MetricItemDTO item = jp.readValueAs(MetricItemDTO.class);
                items.add(item);
            } else {
                throw new JsonParseException(jp, "expected String or Object");
            }

            currentToken = jp.nextToken();
        }

        if (jp.getCurrentToken() != JsonToken.END_ARRAY) {
            throw new JsonParseException(jp, "End array expected");
        }
        return result;
    }
}