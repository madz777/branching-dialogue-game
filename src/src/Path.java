public class Path {
    public int getIndexLength() {
        return indexLength;
    }

    private int indexLength;
    private int numChoices;
    private String pathIndex;
    private String dialogue;
    private int dialogueIndex;
    private String ch1;
    private String ch2;
    private String chE = "";
    private boolean extra = false;

    public boolean isEnding() {
        return ending;
    }

    private boolean ending = false;

    public Path getCp1() {
        return cp1;
    }

    public Path getCp2() {
        return cp2;
    }

    private Path cp1;
    private Path cp2;

    public Path(int t, String n, boolean end, boolean e) {
        indexLength = t;
        pathIndex = n;
        extra = e;


        dialogueIndex = 0;
    }

    public Path(int t, String n, boolean end) {
        indexLength = t;
        pathIndex = n;
        dialogueIndex = 0;
    }

    public int getDialogueIndex() {
        return dialogueIndex;
    }

    public String getPathIndex() {
        return pathIndex;
    }

    public boolean hasExtra() {
        return extra;
    }

    public void setDialogueIndex(int i) {
        dialogueIndex = i;
    }

    public void setDialogue() {
        String d = "";
        switch(Game.pathCurrent.getPathIndex()) {


            case "c1":
                switch (Game.pathCurrent.getDialogueIndex()) {
                    case 0 -> d = "Well, I'm so glad you asked!";
                    case 1 -> d = "It all works through 'Path' objects, which are sort of a pseudo Linked List or Tree. ";
                    case 2 -> d = "With the path objects, you can add however many 'slides' your dialogue branch needs to go through, ";
                    case 3 -> d = "As";
                    case 4 -> d = "Many";
                    case 5 -> d = "As";
                    case 6 -> d = "You";
                    case 7 -> d = "Need!";
                    case 8 -> {
                       d = "You also choose which branching paths the choices at the end go to, just like right here!";
                       ch1 = "That's cool! What about other aspects of a narrative game, like an Inventory?";
                       ch2 = "Anything else?";
                    }
                }

            case "b1":
                switch (Game.pathCurrent.getDialogueIndex()) {
                    case 0 -> d = "Hi! Welcome to my demo of a branching, choice-based narrative simulator!";
                    case 1 -> d = "This demo has 8 'endings', and is built modularly so that this engine can be used to make a full-length game!";
                    case 2 -> {
                        d = "What do you think?";
                        ch1 = "Well, what are the features you clown?";
                        ch2 = "Cool.";
                        cp1 = new Path(8, "c1", false, false);
                    }
                }
            case "c2":
                switch (Game.pathCurrent.getDialogueIndex()) {

                }
            case "d1":
                switch (Game.pathCurrent.getDialogueIndex()) {
                    case 0 -> d = "";
                }
            case "d2":
                switch (Game.pathCurrent.getDialogueIndex()) {
                    case 0 -> d = "";
                }
            case "d3":
                switch (Game.pathCurrent.getDialogueIndex()) {
                    case 0 -> d = "";
                }
            case "d4":
                switch (Game.pathCurrent.getDialogueIndex()) {
                    case 0 -> d = "";
                }

        }

        Game.pathCurrent.setD(d);

        if (!(Game.pathCurrent.getDialogueIndex() > Game.pathCurrent.getIndexLength())) {
            dialogueIndex++;
            if (dialogueIndex == indexLength) {
                Game.nar = false;
            }
        }

    }

    private void setD(String a) {
        dialogue = a;
    }

    public String dialogueCurrent() {
        return dialogue;
    }

    public String choice1() {
        return ch1;
    }

    public String choice2() {
        return ch2;
    }

    public String choiceE() {
        return chE;
    }
}
