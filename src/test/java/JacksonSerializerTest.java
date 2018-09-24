import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonSerializerTest {

  @Test
  public void shouldTransformJson() throws IOException {

    // given
    final ObjectMapper mapper = new ObjectMapper();
    final String json = FileUtils.readFileToString(
            new File(getClass().getClassLoader().getResource("dashboard.json").getFile()), "UTF-8");

    // when
    final PropertiesDTO properties = mapper.readValue(json, PropertiesDTO.class);
    final String result = mapper.writeValueAsString(properties);

    // then
    assertThat(result, is(json));
  }
}
