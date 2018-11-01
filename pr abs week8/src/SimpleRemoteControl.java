import java.util.Stack;

class SimpleRemoteControl {
    private Command[] command;
    private Stack<Command> undoCommand = new Stack<>();

    SimpleRemoteControl() {
        command = new Command[3];
    }

    void setCommand(int index, Command command) {
        this.command[index] = command;
    }

    void buttonWasPressed(int index) {
        command[index].execute();
        undoCommand.push(command[index]);
    }

    void undoButtonWasPressed() {
        if (!undoCommand.empty())
            undoCommand.pop().undo();
    }
}
