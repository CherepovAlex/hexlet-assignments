package exercise;

public class Main {
    public static void main(String[] args) {
        TagInterface tag = new InputTag("submit", "Save");
        System.out.println(tag.render());
        // <input type="submit" value="Save">

        TagInterface inputTag = new InputTag("submit", "Save");
        TagInterface labelTag = new LabelTag("Press Submit", (InputTag) inputTag);
        System.out.println(labelTag.render());
        // <label>Press Submit<input type="submit" value="Save"></label>

    }
}
