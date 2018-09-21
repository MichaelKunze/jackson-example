import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class JacksonSerializerTest {

    @Test
    public void shouldTransformJson() throws IOException {

        // given
        ObjectMapper mapper = new ObjectMapper();
        String json = FileUtils.readFileToString(
                new File(getClass().getClassLoader().getResource("dashboard.json").getFile()), "UTF-8");

        // when
        PropertiesDTO properties = mapper.readValue(json, PropertiesDTO.class);
        String result = mapper.writeValueAsString(properties);

        //then
        assertThat(result, is(json));
    }
}