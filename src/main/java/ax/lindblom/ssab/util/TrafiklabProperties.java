package ax.lindblom.ssab.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Properties;

public class TrafiklabProperties {

    private TrafiklabProperties(){
        throw new IllegalStateException("This is a utility class");
    }
    private static final  String TRAFIKLAB_CONFIG_PATH = "config.properties";

    private static Properties getProperties() throws IOException {
        try (InputStream propertyFile = TrafiklabProperties.class
                .getClassLoader().getResourceAsStream(TRAFIKLAB_CONFIG_PATH)) {
            final Properties properties = new Properties();
            properties.load(propertyFile);
            return properties;
        }
    }

    public static long getCacheLength() throws IOException {
        return Long.parseLong(getProperties().getProperty("cacheLength"));
    }

    public static URI getBaseUri() throws IOException {
        final Properties properties = getProperties();
        return URI.create(properties.getProperty("uri")+"?key="+properties.getProperty("apiKey"));
    }
}
