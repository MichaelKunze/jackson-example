import java.util.List;

public class PropertyDTO extends BaseDTO {

  private int period;
  private String stat;
  private String view;
  private List<MetricsDTO> metrics;

  public List<MetricsDTO> getMetrics() {
      return metrics;
  }

  public void setMetrics(final List<MetricsDTO> metrics) {
      this.metrics = metrics;
  }

  public int getPeriod() {
    return period;
  }

  public void setPeriod(final int period) {
    this.period = period;
  }

  public String getStat() {
    return stat;
  }

  public void setStat(final String stat) {
    this.stat = stat;
  }

  public String getView() {
    return view;
  }

  public void setView(final String view) {
    this.view = view;
  }

  @Override
  public String toString() {
    return "PropertyDTO{" + "period=" + period + ", stat='" + stat + '\'' + ", view='" + view + '\'' + ", metrics=" + metrics +
      '}';
  }
}
