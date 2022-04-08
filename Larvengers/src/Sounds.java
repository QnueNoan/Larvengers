import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class Sounds {
	/**Chaîne de caractères contenant le chemin absolu du fichier audio contenant le son de démarrage du jeu*/
	private String startPath ="./assets/sons/start.wav";
	/**Chaîne de caractères contenant le chemin absolu du fichier audio contenant le son de mort d'une larve*/
	private String mortPath  = "./assets/sons/larve_mort.wav";
	/**Chaîne de caractères contenant le chemin absolu du fichier audio contenant le son lorsque qu'une larve mange une ressource*/
	private String mangePath  = "./assets/sons/larve_mange.wav";
	/**Chaîne de caractères contenant le chemin absolu du fichier audio contenant le son lorsqu'une larve se met en cocon*/
	private String coconPath  = "./assets/sons/cocon.wav";
	/**Chaîne de caractères contenant le chemin absolu du fichier audio contenant le son lorsque la barre d'une larve est au max (nourriture ou boisson)*/
	private String feedPath = "./assets/sons/feed_max.wav";
	
	/**Objets clip représentant des instances de l'interface clip qui représentent les différentes pistes audio
	 * nécessaires au bon fonctionnement du jeu */
	private Clip startAudio, mortAudio, mangeAudio, coconAudio, feedAudio;
	/**
	 * Constructeur de la classe Audio, ce constructeur peut être appelé en dehors de la classe Audio afin 
	 * de créer une nouvelle instance de cette classe pour jouer les différents sons du jeu.
	 * 
	 * Ce constructeur vérifie également à l'aide d'un try/catch si les chemins les fichiers sont bien des fichiers sons
	 * et si le chemin absolu des fichiers est bien correct, si ce n'est pas le cas une exception sera levée.
	 * 
	 */
	public Sounds () {
		
		try {
			startAudio = AudioSystem.getClip();
			mortAudio = AudioSystem.getClip();
			mangeAudio = AudioSystem.getClip();
			coconAudio = AudioSystem.getClip();
			feedAudio = AudioSystem.getClip();
			
			startAudio.open(AudioSystem.getAudioInputStream(new File(startPath).getAbsoluteFile() ) );
			mortAudio.open(AudioSystem.getAudioInputStream(new File(mortPath).getAbsoluteFile() ) );
			mangeAudio.open(AudioSystem.getAudioInputStream(new File(mangePath).getAbsoluteFile() ) );
			coconAudio.open(AudioSystem.getAudioInputStream(new File(coconPath).getAbsoluteFile() ) );
			feedAudio.open(AudioSystem.getAudioInputStream(new File(feedPath).getAbsoluteFile() ) );
			
		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
			e.printStackTrace();
		}
			 
	}
	/**
	 * Méthode playStartAudio() : Cette méthode permet de jouer le son de démarrage du jeu, ce son n'est joué qu'une seule fois
	 * au démarrage du jeu
	 */
	public void playStartAudio () {
		startAudio.setFramePosition(0);
		startAudio.start();
		startAudio.loop(Clip.LOOP_CONTINUOUSLY);

	}
	/**
	 * Méthode playMortAudio() : Cette méthode permet de jouer le son de mort d'une larve, ce son n'est joué qu'une seule
	 * fois à la mort de Pac-Man
	 */
	public void playMortAudio() {
		mortAudio.setFramePosition(0);
		mortAudio.start();
	}
	
	/**
	 * Méthode loopMangeAudio() : Cette méthode permet de jouer le son lorsqu'une larve mange une ressouce
	 */
	public void loopMangeAudio() {
		/**
		 * Si l'audio lorsqu'une larve mange une ressource n'est pas en cours de lecture, il faut le jouer continuellement 
		 */
		if(!mangeAudio.isRunning()) {
			mangeAudio.loop(Clip.LOOP_CONTINUOUSLY);
		}
	}


	/**
	 * Méthode playCoconAudio() : Cette méthode permet de jouer le son lorsqu'une larve se transforme en cocon
	 */
	public void playCoconAudio(){
		coconAudio.setFramePosition(0);
		coconAudio.start();
    }
	
	/**
	 * Méthode playFeedAudio() : Cette méthode permet de jouer un son lorsque la barre d'une Larve est au maximum
	 */
	public void playFeedAudio(){
		feedAudio.setFramePosition(0);
		feedAudio.start();
    }
	
}
