package isolation;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class MainTests {

  @Test
  void test_should_see_tested_class() throws Exception {
    String name = "/isolation/Main.class";
    assertNotNull(getClass().getResourceAsStream(name));
  }

  @Test
  void test_should_not_see_testengine() throws Exception {
    String name = "/org/junit/jupiter/engine/JupiterTestEngine.class";
    assertNull(getClass().getResourceAsStream(name));
  }

  @Test
  void tested_class_should_not_see_test_class() throws Exception {
    assertThrows(IllegalAccessError.class, () -> new Main().lookupTestClass());
  }

  @Test
  void tested_class_should_not_see_engine_class() throws Exception {
    assertThrows(IllegalAccessError.class, () -> new Main().lookupEngineClass());
  }
}
