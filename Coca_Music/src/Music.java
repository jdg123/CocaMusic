import java.io.File;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequencer;

import jm.JMC;
import jm.music.data.*;
import jm.util.*; 


public final class Music implements JMC{
	
	public static void main(String[] args){
		
		Score s = new Score("JMDemo1 - Scale");
		Part p = new Part("Flute", BELLS, 0);
		Phrase melody = generateMelody("abge", C4);
//		Read.midi(s, "Exhausted.mid");
//		Play.midi(s);
//		return;
		
//		Phrase phr = new Phrase("Chromatic Scale", 0.0);
//		for(int i=0;i<12;i++){
//			Note n = new Note(C4+i, THIRTYSECOND_NOTE);
//			phr.addNote(n);
//		}
		
		p.addPhrase(melody);
		s.addPart(p);
		//Read.midi(s, "test.mid");
		//View.show(s);
		Play.midi(s);
	}
	
	public static Phrase generateMelody (String name, double key){
		Phrase melody = new Phrase("Melody", 0.0);
		name = name.toLowerCase();
		//Iterate through letters in name
		 
		for (int i = 0; i < name.length(); i++){
			Note n = null;
			//Note on first beat
			if (name.charAt(i) == 'a') 
				n = new Note(key, CROTCHET);
			else if (name.charAt(i) == 'b') 
				n = new Note(key + 1, CROTCHET);
			else if (name.charAt(i) == 'c') 
				n = new Note(key + 2, CROTCHET);
			else if (name.charAt(i) == 'd') 
				n = new Note(key + 3, CROTCHET);
			else if (name.charAt(i) == 'e') 
				n = new Note(key + 4, CROTCHET);
			else if (name.charAt(i) == 'f') 
				n = new Note(key + 5, CROTCHET);
			else if (name.charAt(i) == 'g') 
				n = new Note(key + 6, CROTCHET);
			else if (name.charAt(i) == 'h') 
				n = new Note(key + 7, CROTCHET);
			else 
				n = new Note(key, CROTCHET);
			
			melody.addNote(n);	
		}
				
		return melody;
	}
}