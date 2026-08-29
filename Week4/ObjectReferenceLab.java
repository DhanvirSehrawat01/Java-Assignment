class ScoreBox {
    private int score;
    ScoreBox(int score) {
        if (score >= 0) {
            this.score = score;
        } else {
            System.out.println("Score cannot be negative");
        }
    }

    int getScore() {
        return score;
    }

    boolean setScore(int newScore) {
        if (newScore >= 0) {
            score = newScore;
            return true;
        }

        return false;
    }
}


public class ObjectReferenceLab {

    static void addBonus(ScoreBox box, int bonus) {
        if (bonus > 0) {
            box.setScore(box.getScore() + bonus);
        }
    }

    static void replaceLocally(ScoreBox box) {
        box = new ScoreBox(100);
        System.out.println("Inside replaceLocally: " + box.getScore());
    }

    static ScoreBox createScoreBox(int score) {
        return new ScoreBox(score);
    }

    public static void main(String[] args) {

        ScoreBox box1 = new ScoreBox(50);

        ScoreBox alias = box1;

        ScoreBox box2 = new ScoreBox(80);

        System.out.println("Initial values:");
        System.out.println("box1 score: " + box1.getScore());
        System.out.println("alias score: " + alias.getScore());
        System.out.println("box2 score: " + box2.getScore());

        System.out.println("\nReference comparisons:");
        System.out.println("box1 == alias: " + (box1 == alias));
        System.out.println("box1 == box2: " + (box1 == box2));

        System.out.println("\nChanging score through alias:");
        alias.setScore(70);

        System.out.println("alias score: " + alias.getScore());
        System.out.println("box1 score: " + box1.getScore());

        System.out.println("\nAdding bonus:");
        addBonus(box1, 10);

        System.out.println("box1 score: " + box1.getScore());
        System.out.println("alias score: " + alias.getScore());

        System.out.println("\nTesting replaceLocally:");
        replaceLocally(box1);

        System.out.println("After replaceLocally:");
        System.out.println("box1 score: " + box1.getScore());

        System.out.println("\nCreating new ScoreBox:");
        ScoreBox box3 = createScoreBox(90);

        System.out.println("box3 score: " + box3.getScore());
        System.out.println("\nMore reference comparisons:");
        System.out.println("box1 == alias: " + (box1 == alias));
        System.out.println("box1 == box3: " + (box1 == box3));
        System.out.println("box2 == box3: " + (box2 == box3));
    }
}
