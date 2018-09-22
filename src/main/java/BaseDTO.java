import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

public class BaseDTO {

  private Map<String, Object> unknownProperties = new HashMap<>();

  @JsonAnySetter
  public void handleUnknownProperties(final String key, final Object value) {
    unknownProperties.put(key, value);
  }

  @JsonAnyGetter
  public Map<String, Object> getUnknownProperties() {
    return unknownProperties;
  }

  public void setUnknownProperties(final Map<String, Object> unknownProperties) {
    this.unknownProperties = unknownProperties;
  }
}
