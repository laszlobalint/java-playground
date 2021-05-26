package PoemReadandSort;

public class WordCounterWrapper implements Comparable<WordCounterWrapper> {
    String word;
    int wordCount;

    public WordCounterWrapper(String word, int wordCount) {
        this.word = word;
        this.wordCount = wordCount;
    }

    @Override
    public int compareTo(WordCounterWrapper wordCounterWrapper) {
        if (wordCounterWrapper.wordCount > this.wordCount) {
            return 1;
        } else if (wordCounterWrapper.wordCount == this.wordCount) {
            return 0;
        }
        return -1;
    }

    @Override
    public String toString() {
        return word + "=" + wordCount;
    }
}


