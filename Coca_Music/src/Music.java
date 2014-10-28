import java.io.File;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequencer;

import jm.JMC;
import jm.music.data.*;
import jm.util.*; 


public final class Music implements JMC{
	
	public static void main(String[] args){
		
		Score s = new Score("JMDemo1 - Scale");
//		Read.midi(s, "Exhausted.mid");
//		Play.midi(s);
//		return;
		Part p = new Part("Flute", BELLS, 0);
		Phrase phr = new Phrase("Chromatic Scale", 0.0);
		for(int i=0;i<12;i++){
			Note n = new Note(C4+i, THIRTYSECOND_NOTE);
			phr.addNote(n);
		}
		
		p.addPhrase(phr);
		s.addPart(p);
		//Read.midi(s, "test.mid");
		//View.show(s);
		Play.midi(s);
	}
}