import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class MetricDTOSerializer extends StdSerializer<MetricDTO> {

    public MetricDTOSerializer() {
        super(MetricDTO.class);
    }

    @Override
    public void serialize(final MetricDTO metric, final JsonGenerator gen, final SerializerProvider provider)
            throws IOException {

        if (metric == null) {
            return;
        }
        gen.writeStartArray();
        for (final String value : metric.getValues()) {
            gen.writeString(value);
        }
        if (metric.getProperty() != null) {
            gen.writeObject(metric.getProperty());
        }
        gen.writeEndArray();
    }
}
