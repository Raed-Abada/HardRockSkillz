package tn.loading;

public class Game1Questions {

    public int[] mQuestions = new int[]{
            R.drawable.question1,
            R.drawable.question2,
            R.drawable.question3,
            R.drawable.question4,
            R.drawable.question5,
            R.drawable.question6,
            R.drawable.question7,
            R.drawable.question8,
            R.drawable.question9,
            R.drawable.question10,
    };


    private int[][] mChoices = new int[][]{
            {R.drawable.greenbutton, R.drawable.yellowbutton, R.drawable.bluebutton},
            {R.drawable.bluebutton, R.drawable.greenbutton, R.drawable.pinkbutton},
            {R.drawable.greenbutton, R.drawable.bluebutton, R.drawable.pinkbutton},
            {R.drawable.orangebutton, R.drawable.greenbutton, R.drawable.yellowbutton},
            {R.drawable.yellowbutton, R.drawable.purplebutton, R.drawable.orangebutton},
            {R.drawable.yellowbutton, R.drawable.pinkbutton, R.drawable.bluebutton},
            {R.drawable.pinkbutton, R.drawable.yellowbutton, R.drawable.purplebutton},
            {R.drawable.greenbutton, R.drawable.bluebutton, R.drawable.pinkbutton},
            {R.drawable.bluebutton, R.drawable.yellowbutton, R.drawable.purplebutton},
            {R.drawable.pinkbutton, R.drawable.yellowbutton, R.drawable.orangebutton}

    };


    private int[] mCorrectAnswers = new int[]{
            R.drawable.yellowbutton,
            R.drawable.bluebutton,
            R.drawable.greenbutton,
            R.drawable.orangebutton,
            R.drawable.purplebutton,
            R.drawable.pinkbutton,
            R.drawable.yellowbutton,
            R.drawable.greenbutton,
            R.drawable.bluebutton,
            R.drawable.pinkbutton
    };


    public int getQuestion(int a) {
        int question = mQuestions[a];
        return question;
    }


    public int getChoice1(int a) {
        int choice0 = mChoices[a][0];
        return choice0;
    }


    public int getChoice2(int a) {
        int choice1 = mChoices[a][1];
        return choice1;
    }

    public int getChoice3(int a) {
        int choice2 = mChoices[a][2];
        return choice2;
    }


    public int getCorrectAnswer(int a) {
        int answer = mCorrectAnswers[a];
        return answer;
    }



}