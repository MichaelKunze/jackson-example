import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.JsonTokenId;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class MetricDTODeserializer extends StdDeserializer<MetricDTO> {

    public MetricDTODeserializer() {
        super(MetricDTO.class);
    }

    @Override
    public MetricDTO deserialize(final JsonParser jp, final DeserializationContext ctxt) throws IOException {

        if (jp.isExpectedStartArrayToken()) {
            return deserializeMetric(jp, ctxt);
        }

        return (MetricDTO) ctxt.handleUnexpectedToken(handledType(), jp);
    }

    private MetricDTO deserializeMetric(final JsonParser jp, final DeserializationContext ctxt) throws IOException {

        final MetricDTO metric = new MetricDTO();

        while (true) {
            final JsonToken currentToken = jp.nextToken();
            switch (currentToken.id()) {
                case JsonTokenId.ID_END_ARRAY:
                    return metric;
                case JsonTokenId.ID_STRING:
                    // this can be: Namespace, MetricName, Dimension1Name, Dimension1Value, Dimension2Name, Dimension2Value...
                    metric.addValues(jp.getText());
                    break;
                case JsonTokenId.ID_START_OBJECT:
                    // this can be {Rendering Properties Object}
                    metric.setProperty(jp.readValueAs(RenderingProperty.class));
                    break;
                default:
                    return (MetricDTO) ctxt.handleUnexpectedToken(handledType(), jp);
            }
        }
    }
}
