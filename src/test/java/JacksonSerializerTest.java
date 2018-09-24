import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonSerializerTest {

    @Test
    public void shouldTransformSimpleMetric() throws IOException {

        // given
        final ObjectMapper mapper = new ObjectMapper();
        //language=JSON
        final String json = "{\"metrics\":[[\"StringA\",\"StringB\"]]}";

        // when
        final PropertyDTO property = mapper.readValue(json, PropertyDTO.class);
        final String serializedJson = mapper.writeValueAsString(property);

        // then
        assertThat(serializedJson, is(json));
    }

    @Test
    public void shouldTransformMetricWithRenderingProperty() throws IOException {

        // given
        final ObjectMapper mapper = new ObjectMapper();
        //language=JSON
        final String json = "{\"metrics\":[[\"StringA\",\"StringB\",{\"label\":\"some label\"}]]}";

        // when
        final PropertyDTO property = mapper.readValue(json, PropertyDTO.class);
        final String serializedJson = mapper.writeValueAsString(property);

        // then
        assertThat(serializedJson, is(json));
    }

    @Test
    public void shouldTransformMultipleMetrics() throws IOException {

        // given
        final ObjectMapper mapper = new ObjectMapper();
        //language=JSON
        final String json = "{\"metrics\":[[\"StringA\",\"StringB\"],[\"StringC\",\"StringD\",\"StringE\",\"StringF\"]]}";

        // when
        final PropertyDTO property = mapper.readValue(json, PropertyDTO.class);
        final String serializedJson = mapper.writeValueAsString(property);

        // then
        assertThat(serializedJson, is(json));
    }

    @Test
    public void shouldTransformMultipleMetricsWithRenderingProperty() throws IOException {

        // given
        final ObjectMapper mapper = new ObjectMapper();
        //language=JSON
        final String json = "{\"metrics\":[[\"StringA\",\"StringB\",{\"label\":\"some label\"}],[\"StringC\",\"StringD\",\"StringE\",\"StringF\",{\"color\":\"some color\",\"label\":\"some other label\"}]]}";

        // when
        final PropertyDTO property = mapper.readValue(json, PropertyDTO.class);
        final String serializedJson = mapper.writeValueAsString(property);

        // then
        assertThat(serializedJson, is(json));
    }
}
