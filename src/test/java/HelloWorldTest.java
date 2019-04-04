import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class HelloWorldTest {

    @Test
    void test() {
        assertThat("hello world").isEqualTo("hello world");
    }
}
