public class Path {
    private int indexLength;
    private int numChoices;
    private String pathIndex;
    private String dialogue;
    private int dialogueIndex;
    private String c1;
    private String c2;
    private String cE = "";
    private boolean extra = false;


    public Path(int t, int c, String n, boolean e) {
        indexLength = t;
        numChoices = c;
        pathIndex = n;
        extra = e;

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

    public boolean hasExtra() {
        return extra;
    }

    public void setDialogue() {
        String d = "";
        switch(pathIndex) {
            case "a1":
                d = "";
                break;
            case "b1":
                switch (dialogueIndex) {
                    case 0 -> d = "'You are dead. '";
                    case 1 -> d = "You hear a voice, but see nothing. ";
                    case 2 -> {
                        d = "What do you do?";
                        c1 = "Who are you?";
                        c2 = "Where am I?";
                    }
                }
        }
        dialogue = d;
        if (!(dialogueIndex > indexLength)) {
            dialogueIndex++;
            if (dialogueIndex == indexLength) {
                Game.nar = false;
            }
        }

    }

    public String dialogueCurrent() {
        return dialogue;
    }

    public String choice1() {
        return c1;
    }

    public String choice2() {
        return c2;
    }

    public String choiceE() {
        return cE;
    }
}
