package exercise;

// BEGIN
public class LabelTag implements TagInterface{
    String line;
    InputTag inputTag;

    public LabelTag(String line, InputTag inputTag) {
        this.line = line;
        this.inputTag = inputTag;
    }

    @Override
    public String render() {
        return "<label>" + line + inputTag.render() + "</label>";
    }
}
// END
