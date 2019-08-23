package by.epam.regex.task1;

/*Cоздать приложение, разбирающее текст (текст хранится в строке) и позволяющее выполнять с
 текстом три различных операции: отсортировать абзацы по количеству предложений;
  в каждом предложении отсортировать слова по длине; отсортировать лексемы в предложении
   по убыванию количества вхождений заданного символа, а в случае равенства – по алфавиту.
 */

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
  public static void main(String[] args) {
	  Scanner scanner = new Scanner(System.in);
		String key = "";
		String str = "";
		String[] text;

		while (!(key.equals("Y") || key.equals("y"))) {
			System.out.println("1. Text input");
			System.out.println("2. sort paragraphs by number of sentences");
			System.out.println("3. in each sentence, sort words by length");
			System.out
					.println("4. sort tokens in a sentence in descending order of occurrences of a given character");
			switch (key = scanner.nextLine()) {
			case "1":
				System.out.print("Input the number of sentences in the text, size = ");
				int size = scanner.nextInt();
				while (size < 2) {
					System.out.println("Invalid value of size (minimum two sentences), try again");
					size = scanner.nextInt();
				}
				text = new String[size];
				System.out.println("\nInput the text:");
				scanner.nextLine();
				int k = 0;
				while (k < size) {
					text[k] = scanner.nextLine();
					if (text[k].matches("((\\w+(\\s?\\w+)*)+(\\.|\\!|\\?))+")) {
						str += text[k] + "\n";
						k++;
					} else {
						System.out.println("the text is not divided into sentences, try again");
					}
				}
				break;
			case "2":
				if (str.equals("")) {
					System.out.println("Before you perform the operation, you must enter the line (menu item - 1)");
				} else {
					sortParagraphsByNumberOfSentences(str);
				}
				break;
			case "3":
				if (str.equals("")) {
					System.out.println("Before you perform the operation, you must enter the line (menu item - 1)");
				} else {
					sortWordsByLength(str);
				}
				break;
			case "4":
				if (str.equals("")) {
					System.out.println("Before you perform the operation, you must input the text (menu item - 1)");
				} else {
					System.out.println("Input the symbol:");
					char character = scanner.nextLine().charAt(0);
					sortTokensByDesc(str, character);
				}
				break;
			}
		}
	}

	private static void sortParagraphsByNumberOfSentences(String str) {
		String[] lines = getLinesArray(str, getLinesNumber(str));

		int sentenceCount = getMaxSentecesCountInLine(lines);

		for (int count = 0; count <= sentenceCount; count++) {
			for (int j = 0; j < lines.length; j++) {
				if (getSentencesNumber(lines[j]) == count) {
					System.out.print(lines[j]);
				}
			}
		}
	}

	private static void sortWordsByLength(String str) {
		String[] lines = getLinesArray(str, getLinesNumber(str));

		for (int i = 0; i < lines.length; i++) {
			String[] sentences = getSentencesArray(lines[i], getSentencesNumber(lines[i]));

			for (int j = 0; j < sentences.length; j++) {

				int maxWordLen = getMaxWordLengthInSentence(sentences[j]);
				String[] words = getWordsArray(sentences[j], getWordsNumber(sentences[j]));

				for (int len = 0; len <= maxWordLen; len++) {
					for (int k = 0; k < words.length; k++) {
						if (words[k].length() == len) {
							System.out.print(words[k] + " ");
						}
					}
				}
				System.out.println();
			}
		}
	}

	private static void sortTokensByDesc(String str, char character) {
		String[] lines = getLinesArray(str, getLinesNumber(str));

		for (int lineIndex = 0; lineIndex < lines.length; lineIndex++) {
			String[] sentences = getSentencesArray(lines[lineIndex], getSentencesNumber(lines[lineIndex]));

			for (int sentenceIndex = 0; sentenceIndex < sentences.length; sentenceIndex++) {

				String[] words = getWordsArray(sentences[sentenceIndex], getWordsNumber(sentences[sentenceIndex]));

				for (int i = 1; i < words.length; i++) {
					for (int j = words.length - 1; j >= i; j--) {
						if ((getCharacterCount(words[j - 1], character) < getCharacterCount(words[j], character))
								|| (getCharacterCount(words[j - 1], character) == getCharacterCount(words[j], character)
										&& (words[j].compareTo(words[j - 1]) > 0))) {
							String temp = words[j];
							words[j] = words[j - 1];
							words[j - 1] = temp;

						}
					}
				}

				for (int i = 0; i < words.length; i++) {
					System.out.print(words[i] + " ");
				}
				System.out.println();
			}
		}
	}

	private static int getCharacterCount(String str, char character) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == character) {
				count++;
			}
		}

		return count;
	}

	private static int getMaxSentecesCountInLine(String[] lines) {
		int sentenceCount = 0;

		for (int i = 0; i < lines.length; i++) {
			if (getSentencesNumber(lines[i]) > sentenceCount) {
				sentenceCount = getSentencesNumber(lines[i]);
			}
		}
		return sentenceCount;
	}

	private static int getMaxWordLengthInSentence(String sentence) {
		int len = 0;
		String[] words = getWordsArray(sentence, getWordsNumber(sentence));
		for (int i = 0; i < words.length; i++) {
			if (words[i].length() > len) {
				len = words[i].length();
			}
		}

		return len;
	}

	private static String[] getSentencesArray(String line, int size) {
		String[] sentencesArray = new String[size];

		Pattern pattern = Pattern.compile("(\\w+(\\s?\\w+)*)+(\\.|\\!|\\?)");
		Matcher matcher = pattern.matcher(line);

		while (matcher.find()) {
			for (int i = 0; i < sentencesArray.length; i++) {
				if (sentencesArray[i] == null) {
					sentencesArray[i] = matcher.group();
					break;
				}
			}
		}

		return sentencesArray;
	}

	private static int getSentencesNumber(String line) {
		int count = 0;
		Pattern pattern = Pattern.compile("(\\w+(\\s?\\w+)*)+(\\.|\\!|\\?)");
		Matcher matcher = pattern.matcher(line);
		while (matcher.find()) {
			count++;
		}

		return count;
	}

	private static int getWordsNumber(String line) {
		int count = 0;
		Pattern pattern = Pattern.compile("\\w+");
		Matcher matcher = pattern.matcher(line);
		while (matcher.find()) {
			count++;
		}

		return count;
	}

	private static String[] getWordsArray(String sentence, int size) {
		String[] wordsArray = new String[size];

		Pattern pattern = Pattern.compile("\\w+");
		Matcher matcher = pattern.matcher(sentence);

		while (matcher.find()) {

			for (int i = 0; i < wordsArray.length; i++) {
				if (wordsArray[i] == null) {
					wordsArray[i] = matcher.group();
					break;
				}
			}
		}

		return wordsArray;
	}

	private static int getLinesNumber(String str) {
		int count = 0;
		Pattern pattern = Pattern.compile(".\\n");
		Matcher matcher = pattern.matcher(str);

		while (matcher.find()) {
			count++;
		}
		return count;
	}

	private static String[] getLinesArray(String allLines, int size) {
		String[] linesArray = new String[size];

		Pattern pattern = Pattern.compile(".+\\n");
		Matcher matcher = pattern.matcher(allLines);
		while (matcher.find()) {
			for (int i = 0; i < linesArray.length; i++) {
				if (linesArray[i] == null) {
					linesArray[i] = matcher.group();
					break;
				}
			}
		}

		return linesArray;
	}	
}
