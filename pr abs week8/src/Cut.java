public class Cut implements Command {
    private Text text;

    Cut(Text text) {
        this.text = text;
    }

    @Override
    public void execute() {
        text.cut();
    }

    @Override
    public void undo() {
        text.paste();
    }
}