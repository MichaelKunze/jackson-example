import java.util.List;

public class PropertyDTO extends BaseDTO {

    private List<MetricDTO> metrics;

    public List<MetricDTO> getMetrics() {
        return metrics;
    }

    public void setMetrics(final List<MetricDTO> metrics) {
        this.metrics = metrics;
    }
}
