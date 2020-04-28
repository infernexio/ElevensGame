import java.util.List;
import java.util.ArrayList;
/**
 * @author - Sohail Shaik
 * @Date - Apr 8, 2020
 * @Assignment - Deck.java
 */

/**
 * The Deck class represents a shuffled deck of cards.
 * It provides several operations including
 *      initialize, shuffle, deal, and check if empty.
 */
public class SSDeck {

 /**
  * cards contains all the cards in the deck.
  */
 private List<SSCard> cards;

 /**
  * size is the number of not-yet-dealt cards.
  * Cards are dealt from the top (highest index) down.
  * The next card to be dealt is at size - 1.
  */
 private int numNotDealt;


 /**
  * Creates a new <code>Deck</code> instance.<BR>
  * It pairs each element of ranks with each element of suits,
  * and produces one of the corresponding card.
  * @param ranks is an array containing all of the card ranks.
  * @param suits is an array containing all of the card suits.
  * @param values is an array containing all of the card point values.
  */
 public SSDeck(String[] ranks, String[] suits, int[] values) {
  cards = new ArrayList<SSCard>();
  for (int j = 0; j < ranks.length; j++) {
   for (String suitString : suits) {
    cards.add(new SSCard(ranks[j], suitString, values[j]));
   }
  }
  numNotDealt = cards.size();
  shuffle();
 }


 /**
  * Determines if this deck is empty (no undealt cards).
  * @return true if this deck is empty, false otherwise.
  */
 public boolean isEmpty() {
  return numNotDealt == 0;
 }

 /**
  * Accesses the number of undealt cards in this deck.
  * @return the number of undealt cards in this deck.
  */
 public int size() {
  return numNotDealt;
 }

 /**
  * Randomly permute the given collection of cards
  * and reset the size to represent the entire deck.
  */
 public void shuffle() {
  for (int k = cards.size() - 1; k > 0; k--) {
   int howMany = k + 1;
   int start = 0;
   int randPos = (int) (Math.random() * howMany) + start;
   SSCard temp = cards.get(k);
   cards.set(k, cards.get(randPos));
   cards.set(randPos, temp);
  }
  numNotDealt = cards.size();
 }

 /**
  * Deals a card from this deck.
  * @return the card just dealt, or null if all the cards have been
  *         previously dealt.
  */
 public SSCard deal() {
  if (isEmpty()) {
   return null;
  }
  numNotDealt--;
  SSCard c = cards.get(numNotDealt);
  return c;
 }

	/**
	 * Generates and returns a string representation of this deck.
	 * @return a string representation of this deck.
	 */
	@Override
	public String toString() {
		String rtn = "Num not dealt = " + numNotDealt + "\nUndealt cards: \n";

		for (int k = numNotDealt - 1; k >= 0; k--) {
			rtn = rtn + cards.get(k);
			if (k != 0) {
				rtn = rtn + ", ";
			}
			if ((numNotDealt - k) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\nDealt cards: \n";
		for (int k = cards.size() - 1; k >= numNotDealt; k--) {
			rtn = rtn + cards.get(k);
			if (k != numNotDealt) {
				rtn = rtn + ", ";
			}
			if ((k - cards.size()) % 2 == 0) {
				// Insert carriage returns so entire deck is visible on console.
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\n";
		return rtn;
	}
}