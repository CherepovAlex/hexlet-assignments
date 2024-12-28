package exercise;

import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
// BEGIN

// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.TRUNCATE_EXISTING);
    }

    // BEGIN
    @Test
    void FileKVTest() {
        KeyValueStorage storage = new FileKV("src/test/resources/file", Map.of("key", "value"));

        assertThat(storage.get("key2", "default")).isEqualTo("default");
        assertThat(storage.get("key", "default")).isEqualTo("value");

        storage.set("key2", "value2");
        storage.set("key", "value");

        assertThat(storage.get("key2", "default")).isEqualTo("value2");
        assertThat(storage.get("key", "default")).isEqualTo("value");

        storage.unset("key");
        assertThat(storage.get("key", "def")).isEqualTo("def");
        assertThat(storage.toMap()).isEqualTo(Map.of("key2", "value2"));

    }

    @Test
    void mustBeImmutableTest() {
        Map<String, String> initial = new HashMap<>();
        initial.put("key", "10");

        Map<String, String> clonedInitial = new HashMap<>();
        clonedInitial.putAll(initial);

        KeyValueStorage storage = new InMemoryKV(initial);

        initial.put("key2", "value2");
        assertThat(storage.toMap()).isEqualTo(clonedInitial);

        Map<String, String> map = storage.toMap();
        map.put("key2", "value2");
        assertThat(storage.toMap()).isEqualTo(clonedInitial);
    }
    @Test
    public void testConstructor() {
        String path = "src/test/resources/file";
        Map<String, String> map = Map.of("key", "value");
        FileKV storage = new FileKV(path, map);
        assertEquals(path, storage.path);
        assertEquals(map, storage.toMap());
    }

    @Test
    public void testSet() {
        String path = "src/test/resources/file";
        Map<String, String> map = Map.of("key", "value");
        FileKV storage = new FileKV(path, map);
        storage.set("key2", "value2");
        assertEquals(Map.of("key", "value", "key2", "value2"), storage.toMap());
    }

    @Test
    public void testUnset() {
        String path = "src/test/resources/file";
        Map<String, String> map = Map.of("key", "value");
        FileKV storage = new FileKV(path, map);
        storage.unset("key");
        assertEquals(Map.of(), storage.toMap());
    }

    @Test
    public void testGet() {
        String path = "src/test/resources/file";
        Map<String, String> map = Map.of("key", "value");
        FileKV storage = new FileKV(path, map);
        assertEquals("value", storage.get("key", "default"));
        assertEquals("default", storage.get("key2", "default"));
    }

    @Test
    public void testSerialize() {
        String path = "src/test/resources/file";
        Map<String, String> map = Map.of("key", "value");
        FileKV storage = new FileKV(path, map);
        String serialized = Utils.serialize(storage.toMap());
        assertEquals("{\"key\":\"value\"}", serialized);
    }

    @Test
    public void testDeserialize() {
        String path = "src/test/resources/file";
        Map<String, String> map = Map.of("key", "value");
        FileKV storage = new FileKV(path, map);
        String serialized = Utils.serialize(storage.toMap());
        Map<String, String> deserialized = Utils.deserialize(serialized);
        assertEquals(map, deserialized);
    }

    @Test
    public void testWriteFile() {
        String path = "src/test/resources/file";
        Map<String, String> map = Map.of("key", "value");
        FileKV storage = new FileKV(path, map);
        Utils.writeFile(path, "{\"key\":\"value\"}");
        assertEquals(Map.of("key", "value"), storage.toMap());
    }

    @Test
    public void testReadFile() {
        String path = "src/test/resources/file";
        Map<String, String> map = Map.of("key", "value");
        FileKV storage = new FileKV(path, map);
        Utils.writeFile(path, "{\"key\":\"value\"}");
        String content = Utils.readFile(storage.path);
        assertEquals(Utils.serialize(map), content);
    }

    // END
}
