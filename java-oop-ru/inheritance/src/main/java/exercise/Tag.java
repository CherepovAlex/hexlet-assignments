package exercise;

import java.util.Map;

// BEGIN

public abstract class Tag {
    public String tag;
    public Map<String, String> map;
    public String getTag () {
        return tag;
    }
    public abstract Map<String, String> getMap ();
}
// END
