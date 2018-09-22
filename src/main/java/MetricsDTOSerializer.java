import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class MetricsDTOSerializer extends StdSerializer<MetricsDTO> {

    private final ObjectMapper mapper = new ObjectMapper();

    public MetricsDTOSerializer() {
        this(null);
    }

    public MetricsDTOSerializer(final Class<MetricsDTO> t) {
        super(t);
    }

    @Override
    public void serialize(final MetricsDTO value, final JsonGenerator gen, final SerializerProvider provider) throws IOException {

        if (value == null) {
            return;
        }
        gen.writeStartArray();
        for (final MetricItemDTO itemDTO : value.getMetricItems()) {
            if (itemDTO.hasValue()) {
                gen.writeString(itemDTO.getValue());
            } else {
                gen.writeObject(itemDTO.getUnknownProperties());
            }
        }
        gen.writeEndArray();
    }
}