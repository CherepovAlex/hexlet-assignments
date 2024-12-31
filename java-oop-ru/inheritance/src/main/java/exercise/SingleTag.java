package exercise;

import java.util.Map;
import java.util.stream.Collectors;

// BEGIN
class SingleTag extends Tag {

    public SingleTag(String tag, Map<String, String> map) {
            this.tag = tag;
            this.map = map;
    }

    @Override
    public Map<String, String> getMap() {
        return map;
    }

    @Override
    public String toString() {
        return "<" + getTag() + " " + map.entrySet().stream()
                .map(entry -> entry.getKey() + "=\"" + entry.getValue() + "\"")
                .collect(Collectors.joining(" "))
                + '>';
    }
}
// END
