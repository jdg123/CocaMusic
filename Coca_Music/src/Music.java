import java.io.File;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequencer;

import jm.JMC;
import jm.music.data.*;
import jm.util.*;

public final class Music implements JMC {

	public static void main(String[] args) {

		Score s = new Score("JMDemo1 - Scale");
		Part p = new Part("Flute", PIANO, 0);
		Phrase melody = generateMelody("EMILY LIU", 60);

		// Read.midi(s, "Embarrassed.mid");
		// Play.midi(s);
		// return;

		// Phrase phr = new Phrase("Chromatic Scale", 0.0);
		// for(int i=0;i<12;i++){
		// Note n = new Note(C4+i, THIRTYSECOND_NOTE);
		// phr.addNote(n);
		// }

		// p.addPhrase(phr);
		p.addPhrase(melody);
		s.addPart(p);
		Play.midi(s);
	}

	public static Phrase generateMelody(String name, int key) {
		Phrase melody = new Phrase("Melody", 0.0);
		name = name.toLowerCase();
		// Iterate through letters in name
		for (int x = 0; x < 4; x++){
		for (int i = 0; i < name.length(); i++) {
			Note n = null;
			// Note on first beat
			switch (name.charAt(i)) {
			case 'a':
				n = new Note(key, CROTCHET);
				break;
			case 'b':
				n = new Note(key + 1, CROTCHET);
				break;
			case 'c':
				n = new Note(key + 2, CROTCHET);
				break;
			case 'd':
				n = new Note(key + 3, CROTCHET);
				break;
			case 'e':
				n = new Note(key + 4, CROTCHET);
				break;
			case 'f':
				n = new Note(key + 5, CROTCHET);
				break;
			case 'g':
				n = new Note(key + 6, CROTCHET);
				break;
			case 'h':
				n = new Note(key, EIGHTH_NOTE);
				break;
			case 'i':
				n = new Note(key + 1, EIGHTH_NOTE);
				break;
			case 'j':
				n = new Note(key + 2, EIGHTH_NOTE);
				break;
			case 'k':
				n = new Note(key + 3, EIGHTH_NOTE);
				break;
			case 'l':
				n = new Note(key + 4, EIGHTH_NOTE);
				break;
			case 'm':
				n = new Note(key + 5, EIGHTH_NOTE);
				break;
			case 'n':
				n = new Note(key + 6, EIGHTH_NOTE);
				break;
			case 'o':
				n = new Note(key, SIXTEENTH_NOTE);
				break;
			case 'p':
				n = new Note(key + 1, SIXTEENTH_NOTE);
				break;
			case 'q':
				n = new Note(key + 2, SIXTEENTH_NOTE);
				break;
			case 'r':
				n = new Note(key + 3, SIXTEENTH_NOTE);
				break;
			case 's':
				n = new Note(key + 4, SIXTEENTH_NOTE);
				break;
			case 't':
				n = new Note(key + 5, SIXTEENTH_NOTE);
				break;
			case 'u':
				n = new Note(key + 6, SIXTEENTH_NOTE);
				break;
			case 'v':
				n = new Note(key, EIGHTH_NOTE_TRIPLET);
				break;
			case 'w':
				n = new Note(key + 1, EIGHTH_NOTE_TRIPLET);
				break;
			case 'x':
				n = new Note(key + 2, EIGHTH_NOTE_TRIPLET);
				break;
			case 'y':
				n = new Note(key + 3, EIGHTH_NOTE_TRIPLET);
				break;
			case 'z':
				n = new Note(key + 4, EIGHTH_NOTE_TRIPLET);
				break;
			case ' ':
				n = new Note(key + 5, EIGHTH_NOTE_TRIPLET);
				break;
			default:
				n = new Note(key + 6, EIGHTH_NOTE_TRIPLET);
			}
			System.out.println(n);
			melody.addNote(n);
		}
		}
		return melody;
	}
}