public class Windows implements FactoryPattern {
    @Override
    public button creatButton() {
        return new button();
    }

    @Override
    public commandLine creatCommandLine() {
        return null;
    }

    @Override
    public window createWindow() {
        return null;
    }
}
