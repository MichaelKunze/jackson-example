import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonDeserialize(using = MetricsDTODeserializer.class)
@JsonSerialize(using = MetricsDTOSerializer.class)
public class MetricsDTO extends BaseDTO {

    List<MetricItemDTO> metricItems;

    public List<MetricItemDTO> getMetricItems() {
        return metricItems;
    }

    public void setMetricItems(final List<MetricItemDTO> metricItems) {
        this.metricItems = metricItems;
    }
}
