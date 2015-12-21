package NumberGame;

public class GuessMyNumber {
private int NumberToGuess;

    public GuessMyNumber(int key) {

        this.NumberToGuess = key;

    }

    /*

     * Oracle 

     * @param your guess

     * @return -1 if the number to guess is smaller than your guess

     *             1 if the number to guess is bigger than your guess

     *             0 if your guess is correct

     */

    public int oracle(int guess) {
        if (this.NumberToGuess < guess) {
            return -1;
        } else if (NumberToGuess > guess) {
            return 1;
        } else {
            return 0;
        }
    }

    /* 

     * Game - Guess a number

     * You have to guess which number the opponent choose from the given array.

     * To ask whether your guess is correct, run function oracle.

     * @param array Unique elements in random order (can be big)

     * @return guessed number

     */

    public int playGame(int[] array) {
    	int i = 0;
    	while(oracle(array[i]) != 0) i++;
    	return array[i];
    }
    
    static void print(Object o) {
    	Start.print(o);
    }
}
