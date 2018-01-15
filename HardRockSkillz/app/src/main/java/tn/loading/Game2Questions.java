package tn.loading;


public class Game2Questions {
    public String[] mQuestions2 = {
            "Snakes only close their eyelids when they sleep.",
            "The crocodile breaks the neck of its large prey to kill it.",
            "The grass snake sometimes pretends to be dead to ward off non-scavenger predators.",
            "Tomatoes were introduced in Italy by Marco Polo after he took a trip to China.",
            "Avocados contain almost no calories.",
            "The melting point of chocolate is just below our natural body temperature.",
            "Coffee is a zero-calorie beverage.",
            "The red juice that comes out of a steak is not blood.",
            "On average, there are 200 tiny seeds on every strawberry.",
            "The United States of America is the world’s largest producer of oranges."

    };


    private int[][] mChoices2 = new int[][]{
            {R.drawable.truebutton, R.drawable.flsbutton},
            {R.drawable.truebutton, R.drawable.flsbutton},
            {R.drawable.truebutton, R.drawable.flsbutton},
            {R.drawable.truebutton, R.drawable.flsbutton},
            {R.drawable.truebutton, R.drawable.flsbutton},
            {R.drawable.truebutton, R.drawable.flsbutton},
            {R.drawable.truebutton, R.drawable.flsbutton},
            {R.drawable.truebutton, R.drawable.flsbutton},
            {R.drawable.truebutton, R.drawable.flsbutton},
            {R.drawable.truebutton, R.drawable.flsbutton}


    };


    private int[] mCorrectAnswers2 = new int[]{
            R.drawable.flsbutton,
            R.drawable.truebutton,
            R.drawable.truebutton,
            R.drawable.truebutton,
            R.drawable.flsbutton,
            R.drawable.truebutton,
            R.drawable.truebutton,
            R.drawable.truebutton,
            R.drawable.flsbutton,
            R.drawable.truebutton

    };


    public String getQuestion2(int a) {
        String question2 = mQuestions2[a];
        return question2;
    }


    public int getChoice4(int a) {
        int choice4 = mChoices2[a][1];
        return choice4;
    }


    public int getChoice5(int a) {
        int choice5 = mChoices2[a][2];
        return choice5;
    }


    public int getCorrectAnswer2(int a) {
        int answer4 = mCorrectAnswers2[a];
        return answer4;
    }

}