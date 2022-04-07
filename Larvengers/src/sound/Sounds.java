package sound;


import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sounds {
	/*
	 * Strings containing the absolute path of the audio file containing the game sounds 
	 */
	
	private String startPath ="./sounds/start.wav";
	private String deadPath  = "./sounds/dead.wav";
	private String eatPath  = "./sounds/eat.wav";
	private String cocoonPath  = "./sounds/cocoon.wav";
	private String endPath = "./sounds/end.wav";
	
	/*
	 * Clip objects representing instances of the clip interface that represent the different audio tracks needed to run the game 
	  */
	private Clip startAudio, deadAudio, eatAudio, cocoonAudio, endAudio;
	/**
	 * Constructor of the Audio class, this constructor can be called outside the Audio class in order to create a new instance 
	 * of this class to play the different sounds of the game.
	 * 
	 * This constructor also checks with a try/catch if the file paths are sound files and if the absolute file path is correct,
	 * if not an exception will be thrown.
	 * 
	 */
	public Sounds () {
		
		try {
			startAudio = AudioSystem.getClip();
			deadAudio = AudioSystem.getClip();
			eatAudio = AudioSystem.getClip();
			cocoonAudio = AudioSystem.getClip();
			endAudio = AudioSystem.getClip();
			
			startAudio.open(AudioSystem.getAudioInputStream(new File(startPath).getAbsoluteFile() ) );
			deadAudio.open(AudioSystem.getAudioInputStream(new File(deadPath).getAbsoluteFile() ) );
			eatAudio.open(AudioSystem.getAudioInputStream(new File(eatPath).getAbsoluteFile() ) );
			cocoonAudio.open(AudioSystem.getAudioInputStream(new File(cocoonPath).getAbsoluteFile() ) );
			endAudio.open(AudioSystem.getAudioInputStream(new File(endPath).getAbsoluteFile() ) );
			
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			e.printStackTrace();
		}
			 
	}
	/*
	 * this method plays the background music in a loop
	 */
	public void loopStartSounds () {
		startAudio.loop(Clip.LOOP_CONTINUOUSLY);

	}
	
	/**
	 * This method plays the sound when a larva dies
	 */
	public void playDeadAudio() {
		/**
		 * If the audio when a larva eats a resource is not playing, it must be reset 
		 * This allows you to reproduce the sound of the original version of the game accurately
		 */
		if(!cocoonAudio.isRunning()) {
			cocoonAudio.setFramePosition(0);
		}
		cocoonAudio.start();
	}
	
	/**
	 * This method plays the sound when a larva eats a resource
	 */
	public void loopEatSounds() {
		/**
		 * If the audio when a larva eats a resource is not playing, it must be played continuously 
		 */
		if(!eatAudio.isRunning()) {
			eatAudio.loop(Clip.LOOP_CONTINUOUSLY);
		}
	}
	/**
	 * Method stopEatsSounds(): This method stops the sound when larva eats an eraser
	 */
	public void stopEatSounds() {
		eatAudio.stop();
		/** R�initialisation du fichier audio*/
        try {
			eatAudio = AudioSystem.getClip();
			eatAudio.open(AudioSystem.getAudioInputStream(new File(eatPath).getAbsoluteFile()));
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			e.printStackTrace();
		}
    
    }


	/**
	 * Methode stopCocoonAudio(): This method stops the sound when a larva is in cocoon form	 */
	public void stopCocoonAudio(){
		endAudio.stop();
		/** R�initialisation du fichier audio*/
		try {
			endAudio = AudioSystem.getClip();
			endAudio.open(AudioSystem.getAudioInputStream(new File(endPath).getAbsoluteFile() ) );
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			e.printStackTrace();
		}
    }
	/**
	 * Methode playMortAudio(): This method plays the death sound of a larva.
	 */
	public void playEndSounds() {
		deadAudio.setFramePosition(0);
		deadAudio.start();
	}
	
	
}
