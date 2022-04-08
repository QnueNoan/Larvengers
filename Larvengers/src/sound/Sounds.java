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
	
	private String startPath ="./Larvengers/sounds/start.wav";
	private String deadPath  = "./Larvengers/sounds/dead.wav";
	private String eatPath  = "./Larvengers/sounds/eat.wav";
	private String cocoonPath  = "./Larvengers/sounds/cocoon.wav";
	private String endPath = "./Larvengers/sounds/end.wav";
	
	/*
	 * Clip objects representing instances of the clip interface that represent the different audio tracks needed to run the game 
	  */
	private static Clip startAudio;
	private static Clip deadAudio;
	private static Clip eatAudio;
	private static Clip cocoonAudio;
	private static Clip endAudio;
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
	
	public static void stopStartSounds() {
		if(startAudio.isRunning()) {
			startAudio.stop();
		}
	
	}
	/**
	 * This method plays the sound when a larva dies
	 */
	public static void playDeadSounds() {
	
		if(!deadAudio.isRunning()) {
			deadAudio.setFramePosition(0);
		}
		deadAudio.start();
	}
	
	/**
	 * This method plays the sound when a larva eats a resource
	 */
	public static void playEatSounds() {
		
		if(!eatAudio.isRunning()) {
			eatAudio.setFramePosition(0);
		}
		eatAudio.start();		
			
		
	}
	/**
	 * This method stops the sound when a larva is in cocoon form
	 * 	 */
	public static void playCocoonAudio(){
		if(!cocoonAudio.isRunning()) {
			cocoonAudio.setFramePosition(0);
		}
		cocoonAudio.start();
	}
		
	/**
	 * Methode playMortAudio(): This method plays the death sound of a larva.
	 */
	public static void playEndSounds() {
		if(!endAudio.isRunning()) {
			endAudio.setFramePosition(0);
		}
		endAudio.start();
	}
}
		
	
