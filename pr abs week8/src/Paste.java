public class Paste implements Command  {
    private Text text;

    Paste(Text text) {
        this.text = text;
    }

    @Override
    public void execute() {
        text.paste();
    }

    @Override
    public void undo() {
        text.cut();
    }

}