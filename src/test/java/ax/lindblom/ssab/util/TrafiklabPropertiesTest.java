package ax.lindblom.ssab.util;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TrafiklabPropertiesTest {

    @Test
    void canGetCacheLengthArePositive() throws IOException {
        assertTrue(TrafiklabProperties.getCacheLength()>0);
    }

    @Test
    void doesGetBaseUriContaionApiKey() throws IOException {
        assertTrue(TrafiklabProperties.getBaseUri().getQuery().contains("key"));
    }
}