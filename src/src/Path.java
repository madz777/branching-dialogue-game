public class Path {
    private int textLength;
    private int numChoices;
    private String pathIndex;
    private String dialogue;
    private int dialogueIndex;

    public Path(int t, int c, String n) {
        textLength = t;
        numChoices = c;
        pathIndex = n;

        dialogueIndex = 0;

    }

    private int getDialogueIndex() {
        return dialogueIndex;
    }

    private void childPath() {
        return;
    }

    private String getPathIndex() {
        return pathIndex;
    }

    public String dialogueCurrent() {
        return dialogue;
    }

    public void setDialogue() {
        String d = "";
        switch(Game.pathCurrent.getPathIndex()) {
            case "a1":
                d = "";
                break;
            case "b1":
                switch (Game.pathCurrent.getDialogueIndex()) {
                    case 0:
                        System.out.print("hi");
                        d = "You are dead. ";
                        break;
                    case 1:

                }
        }
        dialogue = d;
    }


}
