/*
	Coin.java THIS IS THE ONLY FILE YOU HAND IN
	THERE IS NO MAIN METHOD IN THIS CLASS!
*/
import java.util.Random;
public class Coin
{
	private final int HEADS = 1;
	private final int TAILS = 0;

	private int numHeads = 0;
	private int numTails = 0;

	private Random r; 

	public Coin(int seed) {
		r = new Random(seed);
		reset();
	}

	public String flip() {
		int side = r.nextInt(2);

		if (side == HEADS) {
			setNumHeads(getNumHeads() + 1);
			return "H";
		}
		else {
			setNumTails(getNumTails() + 1);
			return "T";
		}
	}

	public int getNumHeads() {
		return numHeads;
	}

	public int getNumTails() {
		return numTails;
	}

	private void setNumHeads(int num) {
		numHeads = num;
	}

	private void setNumTails(int num) {
		numTails = num;
	}

	public void reset() {
		setNumTails(0);
		setNumHeads(0);
	}
} // END COIN CLASS