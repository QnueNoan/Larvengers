package sound;


import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sounds {
	/**Cha�ne de caract�res contenant le chemin absolu du fichier audio contenant les sons du jeu*/
	
	private String startPath ="./sounds/start.wav";
	private String deadPath  = "./sounds/dead.wav";
	private String eatPath  = "./sounds/eat.wav";
	private String cocoonPath  = "./sounds/cocoon.wav";
	private String endPath = "./sounds/end.wav";
	
	/**Objets clip repr�sentant des instances de l'interface clip qui repr�sentent les diff�rentes pistes audio
	 * n�cessaires au bon fonctionnement du jeu */
	private Clip startAudio, deadAudio, eatAudio, cocoonAudio, endAudio;
	/**
	 * Constructeur de la classe Audio, ce constructeur peut �tre appel� en dehors de la classe Audio afin 
	 * de cr�er une nouvelle instance de cette classe pour jouer les diff�rents sons du jeu.
	 * 
	 * Ce constructeur v�rifie �galement � l'aide d'un try/catch si les chemins les fichiers sont bien des fichiers sons
	 * et si le chemin absolu des fichiers est bien correct, si ce n'est pas le cas une exception sera lev�e.
	 * 
	 */
	public Sounds () {
		
		try {
			//startAudio = AudioSystem.getClip();
			deadAudio = AudioSystem.getClip();
			eatAudio = AudioSystem.getClip();
			cocoonAudio = AudioSystem.getClip();
			endAudio = AudioSystem.getClip();
			
			//startAudio.open(AudioSystem.getAudioInputStream(new File(startPath).getAbsoluteFile() ) );
			deadAudio.open(AudioSystem.getAudioInputStream(new File(deadPath).getAbsoluteFile() ) );
			eatAudio.open(AudioSystem.getAudioInputStream(new File(eatPath).getAbsoluteFile() ) );
			cocoonAudio.open(AudioSystem.getAudioInputStream(new File(cocoonPath).getAbsoluteFile() ) );
			endAudio.open(AudioSystem.getAudioInputStream(new File(endPath).getAbsoluteFile() ) );
			
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			e.printStackTrace();
		}
			 
	}
	/*
	 * Cette m�thode permet de lire la musique de fond en boucle
	 */
	public void loopStartSounds () {
		//startAudio.loop(Clip.LOOP_CONTINUOUSLY);

	}
	
	/**
	 * Cette m�thode permet de jouer le son lorsqu'une larve meurt
	 */
	public void playDeadAudio() {
		/**
		 * Si l'audio lorsqu'une larve mange une ressource n'est pas en cours de lecture, il faut le reinitialiser 
		 * Cela permet de reproduire le son de la version originale du jeu avec exactitude
		 */
		if(!cocoonAudio.isRunning()) {
			cocoonAudio.setFramePosition(0);
		}
		cocoonAudio.start();
	}
	
	/**
	 * Cette m�thode permet de jouer le son lorsqu'une larve mange une ressource
	 */
	public void loopEatSounds() {
		/**
		 * Si l'audio lorsqu'une larve  mange une ressource n'est pas en cours de lecture, il faut le jouer continuellement 
		 * Cela permet de reproduire le son de la version originale du jeu avec exactitude lorsque Pac-Man
		 * mange une gomme
		 */
		if(!eatAudio.isRunning()) {
			eatAudio.loop(Clip.LOOP_CONTINUOUSLY);
		}
	}
	/**
	 * M�thode stopMangeAudio() : Cette m�thode permet de stopper le son lorsque Pac-Man mange une gomme
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
	 * M�thode stopFantomeEffrayeAudio() : Cette m�thode permet de stopper le son lorsque un fant�me est effray�
	 */
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
	 * M�thode playMortAudio() : Cette m�thode permet de jouer le son de mort d'une larve
	 */
	public void playEndSounds() {
		deadAudio.setFramePosition(0);
		deadAudio.start();
	}
	
	
}
