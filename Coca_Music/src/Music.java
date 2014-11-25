import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequencer;

import jm.JMC;
import jm.music.data.*;
import jm.audio.synth.*;
import jm.util.*;

public final class Music implements JMC {

	static class Input {
		int height;
		String mood;
		String name;
		
		Input(){
			
		}
	}
	public static void main(String[] args) {	
		Input input = pullDatabase();
		generateSong(input.height, input.mood, input.name);
	}

	public static Input pullDatabase() {
		Input input = new Input();				
		input.height = 61; // height in inches
		input.mood = "LovestruckNoLead";
		input.name = "Josh Greenberger";
		return input;
	}
	
	public static void generateSong(int height, String mood, String name) {

		Score s = new Score("JMDemo1 - Scale");
		int key = generateKey(height);
		
		Read.midi(s, mood + ".mid");
		
		boolean halfTime = false;
		if (mood.contains("Lovestruck"))
			halfTime = true;
		
		Part melodyPart = new Part("Melody", PIANO, 0);
		Phrase melody = generateMelody(name, key, halfTime);
		melodyPart.addPhrase(melody);
		s.addPart(melodyPart);	
		
		for (int i = 0; i < s.getPartList().size(); i++){
			Part part1 = s.getPart(i);
			System.out.println(part1.getInstrument());
			if (part1.getInstrument() == 0){
				part1.setInstrument(PIANO);
			}
		}
		
		
		for (int i = 0; i < s.getPartList().size(); i++){
			Part part1 = s.getPart(i);
			for (int j = 0; j < part1.getPhraseList().size(); j++){
				Phrase phrase1 = part1.getPhrase(j);
				 for (int k = 0; k < phrase1.getNoteList().size(); k++){
					 Note note1 = phrase1.getNote(k);			 
					 if (note1.getPitch() > 0 && note1.getPitch() < 80){
						 note1.setPitch(note1.getPitch());
					 }
				 }
			}
		}
		Play.midi(s);
	}

	public static int generateKey(int height) {
		switch (height % 12) {
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

	public static Phrase generateMelody(String name, int key, boolean halfTime) {
		Phrase melody = new Phrase("Melody", 0.0, PIANO);
		
//		// COUNT IN
//		 for (int i = 0; i < 4; i++){
//		 Note n = new Note(C4, QUARTER_NOTE, FFF);
//		 melody.addNote(n);
//		 }

		double phrase_length = 0, max_length = 8, note_length;
		Note n = null;
		name = name.toLowerCase();
		// Iterate through letters in name
		for (int x = 0; x < 8; x++) {
			for (int i = 0; i < name.length(); i++) {
				switch (name.charAt(i)) {
				case 'a':
					note_length = 1;
					if (halfTime)
						note_length *= 2;
					n = new Note(key, note_length);			
					break;
				case 'b':			
					note_length = 1;
					if (halfTime)
						note_length *= 2;
					n = new Note(key + 2, note_length);
					break;
				case 'c':
					note_length = 1;
					if (halfTime)
						note_length *= 2;
					n = new Note(key + 4, note_length);
					break;
				case 'd':
					note_length = 1;
					if (halfTime)
						note_length *= 2;
					n = new Note(key + 7, note_length);
					break;
				case 'e':
					note_length = 1;
					if (halfTime)
						note_length *= 2;
					n = new Note(key + 9, note_length);
					break;
				case 'f':
					note_length = 0.5;
					if (halfTime)
						note_length *= 2;
					n = new Note(key, note_length);
					break;
				case 'g':
					note_length = 0.5;
					if (halfTime)
						note_length *= 2;
					n = new Note(key + 2, note_length);			
					break;
				case 'h':
					note_length = 0.5;
					if (halfTime)
						note_length *= 2;
					n = new Note(key + 4, note_length);				
					break;
				case 'i':
					note_length = 0.5;
					if (halfTime)
						note_length *= 2;
					n = new Note(key + 7, note_length);					
					break;
				case 'j':
					note_length = 0.5;
					if (halfTime)
						note_length *= 2;
					n = new Note(key + 9, note_length);
					break;
				case 'k':
					note_length = 0.25;
					if (halfTime)
						note_length *= 2;
					n = new Note(key, note_length);
					break;
				case 'l':
					note_length = 0.25;
					if (halfTime)
						note_length *= 2;
					n = new Note(key + 2, note_length);				
					break;
				case 'm':
					note_length = 0.25;
					if (halfTime)
						note_length *= 2;
					n = new Note(key + 4, note_length);				
					break;
				case 'n':
					note_length = 0.25;
					if (halfTime)
						note_length *= 2;
					n = new Note(key + 7, note_length);				
					break;
				case 'o':
					note_length = 0.25;
					if (halfTime)
						note_length *= 2;
					n = new Note(key + 9, note_length);	
					break;
				case 'p':
					note_length = 2;
					if (halfTime)
						note_length *= 2;
					n = new Note(key, note_length);		
					break;
				case 'q':
					note_length = 2;
					if (halfTime)
						note_length *= 2;
					n = new Note(key + 2, note_length);			
					break;
				case 'r':
					note_length = 2;
					if (halfTime)
						note_length *= 2;
					n = new Note(key + 4, note_length);		
					break;
				case 's':
					note_length = 2;
					if (halfTime)
						note_length *= 2;
					n = new Note(key + 7, note_length);			
					break;
				case 't':
					note_length = 2;
					if (halfTime)
						note_length *= 2;
					n = new Note(key + 9, note_length);				
					break;
				case 'u':
					note_length = 1.5;
					if (halfTime)
						note_length *= 2;
					n = new Note(key, note_length);				
					break;
				case 'v':
					note_length = 1.5;
					if (halfTime)
						note_length *= 2;
					n = new Note(key + 2, note_length);			
					break;
				case 'w':
					note_length = 1.5;
					if (halfTime)
						note_length *= 2;
					n = new Note(key + 4, note_length);	
					break;
				case 'x':
					note_length = 1.5;
					if (halfTime)
						note_length *= 2;
					n = new Note(key + 7, note_length);	
					break;
				case 'y':
					note_length = 1.5;
					if (halfTime)
						note_length *= 2;
					n = new Note(key + 9, note_length);
					break;
				default:
					note_length = 1.5;
					n = new Note(key, 1.5);
					if (halfTime)
						note_length *= 2;			
				}
				if (note_length + phrase_length < max_length) {
					phrase_length += note_length;
					melody.addNote(n);
					System.out.println("Char = " + name.charAt(i));
					System.out.println(phrase_length);
				} 
				else {
					n = new Note(key, max_length - phrase_length);
					System.out.println("At length "
							+ (max_length - phrase_length));
					phrase_length = 0;
					melody.addNote(n);
					i = name.length();
				}
			}
		}
		return melody;
	}
}