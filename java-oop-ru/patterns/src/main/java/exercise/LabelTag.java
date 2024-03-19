package exercise;

// BEGIN
public class LabelTag implements TagInterface{
    private String label;
    private TagInterface inputTage;

    public LabelTag(String label, TagInterface inputTage) {
        this.label = label;
        this.inputTage = inputTage;
    }

    @Override
    public String render() {
        StringBuilder result = new StringBuilder();
        result.append("<label>Press Submit").append(inputTage.render()).append("</label>");
        return result.toString();
    }
}
// END
