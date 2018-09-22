public class PropertiesDTO extends BaseDTO {

  private PropertyDTO properties;

  public PropertyDTO getProperties() {
    return properties;
  }

  public void setProperties(final PropertyDTO properties) {
    this.properties = properties;
  }

  @Override
  public String toString() {
    return "PropertiesDTO{" + "properties=" + properties + '}';
  }
}
