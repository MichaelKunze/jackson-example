public class MetricItemDTO extends BaseDTO {
    private String value;

    public boolean hasValue() {
        return value != null;
    }

    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }
}
