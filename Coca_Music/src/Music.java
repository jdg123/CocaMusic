import jm.JMC;
import jm.music.data.*;
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
		input.height = 75; // height in inches
		input.mood = "Exhausted";
		input.name = "Ernie Seinfeld";
		return input;
	}
	
	public static void generateSong(int height, String mood, String name) {

		Score s = new Score("JMDemo1 - Scale");
		Read.midi(s, mood + ".mid");
		
		boolean halfTime = false;
		if (mood.contains("Lovestruck") || mood.contains("Discouraged") || mood.contains("Smooth"))
			halfTime = true;
		
		Part melodyPart = new Part("Melody", 0);
		Phrase melody = generateMelody(name, 60, halfTime);
		melodyPart.addPhrase(melody);
		melodyPart.setChannel(s.getPartList().size()+1);
		s.addPart(melodyPart);	
		
		//Change the melody instrument based on mood
		s.getPart(s.getPartList().size()-1).setInstrument(returnMelodyInstrument(mood));
		
		//Change the tempo
		//s.setTempo(s.getTempo() + 50);
		
		
		//Change the key by height
		for (int i = 0; i < s.getPartList().size(); i++){
			Part part1 = s.getPart(i);
			System.out.println("instrument = " + part1.getInstrument() + " part =" + part1.getChannel());
			//Drum Channel, don't change key
			if (part1.getChannel() == 9)
				continue;
			
			for (int j = 0; j < part1.getPhraseList().size(); j++){
				Phrase phrase1 = part1.getPhrase(j);
				 for (int k = 0; k < phrase1.getNoteList().size(); k++){
					 Note note1 = phrase1.getNote(k);
					 if (note1.getPitch() > 0 && note1.getPitch() < 80){
						 if (mood.contains("Hopeful"))
							 note1.setPitch(note1.getPitch() + 12);
						 if (height % 12 < 6){
							 note1.setPitch(note1.getPitch() + (height % 12));
						 }
						 else {
							 note1.setPitch(note1.getPitch() - (12 - (height % 12)));
						 }
					 }
				 }
			}
		}
		Play.midi(s);
	}

	public static int returnMelodyInstrument (String mood){
	    if (mood.contains("Suspicious"))
	      return jm.constants.ProgramChanges.DGUITAR;
	    if (mood.contains("Smooth")) 
	      return jm.constants.ProgramChanges.VIBRAPHONE;
	    if (mood.contains("Mischievous")) 
	      return jm.constants.ProgramChanges.DGUITAR;
	    if (mood.contains("Lovestruck")) 
	      return jm.constants.ProgramChanges.ELECTRIC_PIANO;
	    if (mood.contains("Hopeful"))  
	      return jm.constants.ProgramChanges.FLUTE;
	    if (mood.contains("Happy")) 
	      return jm.constants.ProgramChanges.HARP;
	    if (mood.contains("Exhausted")) 
	      return jm.constants.ProgramChanges.CLARINET;
	    if (mood.contains("Epic")) 
	      return jm.constants.ProgramChanges.OVERDRIVE_GUITAR;
	    if (mood.contains("Confident"))
	      return jm.constants.ProgramChanges.SYNTH_STRINGS;
	    if (mood.contains("Discouraged"))  
	      return jm.constants.ProgramChanges.CLARINET;
	    if (mood.contains("Angry")) 
	      return jm.constants.ProgramChanges.TENOR;
	    if (mood.contains("Sad"))
	      return jm.constants.ProgramChanges.ELECTRIC_PIANO;
	    else
	      return jm.constants.ProgramChanges.PIANO;   
	  }
	
	public static Phrase generateMelody(String name, int key, boolean halfTime) {
		Phrase melody = new Phrase("Melody", 0.0);
		double phrase_length = 0, max_length = 8, note_length;
		int songLength = 8;
		Note n = null;
		name = name.toLowerCase();
		// Iterate through letters in name
		for (int x = 0; x < songLength; x++) {
			//Generate 2 bar phrase
			phrase_length = 0;
			while (phrase_length < max_length){
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
				} 
				else {
					n = new Note(key, max_length - phrase_length);
					phrase_length = max_length;
					melody.addNote(n);
					i = name.length();
				}
			}
			}
		}
		return melody;
	}
}