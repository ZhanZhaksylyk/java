public class Copy implements Command {
    private Text text;

    Copy(Text text) {
        this.text = text;
    }

    @Override
    public void execute() {
        text.copy();
    }

    @Override
    public void undo() {}

}