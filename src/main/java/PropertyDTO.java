import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class PropertyDTO extends BaseDTO {

  private int period;
  private String stat;
  private String view;
  @JsonDeserialize(using = StrangeAWSListDeserializer.class)
  private List<List<String>> metrics;

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

  public List<List<String>> getMetrics() {
    return metrics;
  }

  public void setMetrics(final List<List<String>> metrics) {
    this.metrics = metrics;
  }

  @Override
  public String toString() {
    return "PropertyDTO{" + "period=" + period + ", stat='" + stat + '\'' + ", view='" + view + '\'' + ", metrics=" + metrics +
      '}';
  }
}
