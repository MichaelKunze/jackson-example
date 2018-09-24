import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonDeserialize(using = MetricDTODeserializer.class)
@JsonSerialize(using = MetricDTOSerializer.class)
public class MetricDTO extends BaseDTO {

    private List<String> values = new ArrayList<>();
    private RenderingProperty property;

    public List<String> getValues() {
        return values;
    }

    public void addValues(final String value) {
        this.values.add(value);
    }

    public RenderingProperty getProperty() {
        return property;
    }

    public void setProperty(final RenderingProperty property) {
        this.property = property;
    }
}
