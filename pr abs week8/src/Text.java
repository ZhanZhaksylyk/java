import javafx.scene.control.IndexRange;

import java.util.Stack;

class Text {
    String text, oldText, toDisplay;
    IndexRange indexRange;
    private Stack<IndexRange> indexRangeStackPastedIndex = new Stack<>();
    private Stack<String> cuttedElements = new Stack<>();
    private Stack<IndexRange> indexRangeStackOfCuttedElements = new Stack<>();

    Text() {}

    void copy() {
        indexRangeStackPastedIndex.push(this.indexRange);
        System.out.println("copied " + this.text);
    }

    void cut() {
        //this.oldText = Test.getTextArea();
        int startIndex = this.indexRange.getStart(), endIndex = this.indexRange.getEnd();

        indexRangeStackOfCuttedElements.push(indexRange);
        cuttedElements.push(text);

        System.out.println(startIndex + " " + endIndex);
        System.out.println("Old Text: " + oldText);

        if (startIndex == endIndex) {
            startIndex = indexRangeStackPastedIndex.pop().getStart();
            endIndex = startIndex + this.text.length();
            toDisplay = this.oldText.substring(0, startIndex) + this.oldText.substring(endIndex, this.oldText.length());
        }
        else
            toDisplay = this.oldText.substring(0, startIndex) + this.oldText.substring(endIndex, this.oldText.length());

        System.out.println("First part: " + this.oldText.substring(0, startIndex));
        System.out.println("Last part: " + this.oldText.substring(endIndex, this.oldText.length()));
        System.out.println("Text was cut " + this.text);
        System.out.println("To Display: " + toDisplay);
        System.out.println("-------------------------");
        oldText = toDisplay;
    }

    void paste() {
        int startIndex = this.indexRange.getStart(), endIndex = this.indexRange.getEnd();

        indexRangeStackPastedIndex.push(indexRange);

        if (!indexRangeStackOfCuttedElements.isEmpty()) {
            startIndex = indexRangeStackOfCuttedElements.pop().getStart();
            endIndex = startIndex;
            this.text = cuttedElements.pop();
        }
        System.out.println("Old text: " + oldText);
        System.out.println(startIndex + " " + endIndex);
        System.out.println("First part: " + this.oldText.substring(0, startIndex));
        System.out.println("Last part: " + this.oldText.substring(endIndex, this.oldText.length()));

        toDisplay = this.oldText.substring(0, startIndex) + this.text + this.oldText.substring(endIndex, this.oldText.length());

        System.out.println("Text was pasted " + this.text);
        System.out.println("To Display: " + toDisplay);
        System.out.println("-------------------------");
        oldText = toDisplay;
    }

}
