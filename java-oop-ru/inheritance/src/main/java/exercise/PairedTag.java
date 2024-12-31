package exercise;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// BEGIN
class PairedTag extends SingleTag {
    SingleTag singleTag;
    private String body;
    public static List<Tag> alTag;

    public PairedTag(String tag, Map<String, String> map, String body, List<Tag> alTag) {
        super(tag, map);
        this.singleTag = new SingleTag(this.getTag(), getMap());
        this.body = body;
        this.alTag = alTag;
    }

    public String toString() {

        return singleTag.toString() +
                alTag.stream().map(tag -> "<" + tag.getTag() + " " + tag.getMap()
                                .entrySet().stream()
                                .map(entry -> entry.getKey() + "=\"" + entry.getValue() + "\"")
                                .collect(Collectors.joining(" "))+ '>')
                        .collect(Collectors.joining())
                + this.body + "</" + getTag() + '>';
    }
}
// END