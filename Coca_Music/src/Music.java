import java.io.File;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequencer;

import jm.JMC;
import jm.music.data.*;
import jm.util.*;

public final class Music implements JMC {

	public static void main(String[] args) {

		int height = 61;		//height in inches
		
		Score s = new Score("JMDemo1 - Scale");
		Part p = new Part("Flute", PIANO, 0);
		
		Read.midi(s, "Embarrassed.mid");
		int key = generateKey(height);
		Phrase melody = generateMelody("emily liu", key);	

		// Phrase phr = new Phrase("Chromatic Scale", 0.0);
		// for(int i=0;i<12;i++){
		// Note n = new Note(C4+i, THIRTYSECOND_NOTE);
		// phr.addNote(n);
		// }	
		//p.addPhrase(phr);

		
		p.addPhrase(melody);
		s.addPart(p);
		Play.midi(s);
	}
	
	public static int generateKey (int height) {
		switch (height % 12){
		case 1:
			return 60;
		case 2:
			return 61;
		case 3:
			return 62;
		case 4:
			return 63;
		case 5: 
			return 64;
		case 6: 
			return 65;
		case 7: 
			return 66;
		case 8: 
			return 67;
		case 9: 
			return 68;
		case 10: 
			return 69;
		case 11: 
			return 70;
		default:
			return 71;
		}
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
				n = new Note(key, SIXTEENTH_NOTE);
				break;
			case 'b':
				n = new Note(key + 2, SIXTEENTH_NOTE);
				break;
			case 'c':
				n = new Note(key + 4, SIXTEENTH_NOTE);
				break;
			case 'd':
				n = new Note(key + 7, SIXTEENTH_NOTE);
				break;
			case 'e':
				n = new Note(key + 9, SIXTEENTH_NOTE);
				break;
			case 'f':
				n = new Note(key, SIXTEENTH_NOTE);
				break;
			case 'g':
				n = new Note(key + 2, SIXTEENTH_NOTE);
				break;
			case 'h':
				n = new Note(key + 4, SIXTEENTH_NOTE);
				break;
			case 'i':
				n = new Note(key + 7, SIXTEENTH_NOTE);
				break;
			case 'j':
				n = new Note(key + 9, SIXTEENTH_NOTE);
				break;
			case 'k':
				n = new Note(key, SIXTEENTH_NOTE);
				break;
			case 'l':
				n = new Note(key + 2, SIXTEENTH_NOTE);
				break;
			case 'm':
				n = new Note(key + 4, SIXTEENTH_NOTE);
				break;
			case 'n':
				n = new Note(key + 7, SIXTEENTH_NOTE);
				break;
			case 'o':
				n = new Note(key + 9, SIXTEENTH_NOTE);
				break;
			case 'p':
				n = new Note(key, SIXTEENTH_NOTE);
				break;
			case 'q':
				n = new Note(key + 2, SIXTEENTH_NOTE);
				break;
			case 'r':
				n = new Note(key + 4, SIXTEENTH_NOTE);
				break;
			case 's':
				n = new Note(key + 7, SIXTEENTH_NOTE);
				break;
			case 't':
				n = new Note(key + 9, SIXTEENTH_NOTE);
				break;
			case 'u':
				n = new Note(key, SIXTEENTH_NOTE);
				break;
			case 'v':
				n = new Note(key + 2, SIXTEENTH_NOTE);
				break;
			case 'w':
				n = new Note(key + 4, SIXTEENTH_NOTE);
				break;
			case 'x':
				n = new Note(key + 7, SIXTEENTH_NOTE);
				break;
			case 'y':
				n = new Note(key + 9, SIXTEENTH_NOTE);
				break;
			default:
				n = new Note(key + 9, SIXTEENTH_NOTE);
			}
			//System.out.println(n);
			melody.addNote(n);
		}
		}
		return melody;
	}
}