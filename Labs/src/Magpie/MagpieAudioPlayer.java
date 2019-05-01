package Magpie;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class MagpieAudioPlayer {
	private int loopNumber;
	private String filePath;
	private AudioInputStream fileStream;
	private Clip audioClip;

	public MagpieAudioPlayer(String path, int loops) throws IOException,
	   											 UnsupportedAudioFileException,
	   											 LineUnavailableException
	{
		loopNumber = loops;
		filePath = path;
		resetAudioSys();
	}

	public void play() throws IOException,
	   						  UnsupportedAudioFileException,
	   						  LineUnavailableException
	{
		audioClip.open(fileStream);
		audioClip.start();

		while (audioClip.isActive())
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				System.out.println("\nYou just couldn't be patient!!!");
				e.printStackTrace();
			}
	}

	public void stop() throws IOException,
		 					  UnsupportedAudioFileException,
		 					  LineUnavailableException
	{
		audioClip.stop();
		resetAudioSys();
	}

	private void resetAudioSys() throws IOException,
									   UnsupportedAudioFileException,
									   LineUnavailableException
	{
		fileStream = AudioSystem.getAudioInputStream(new File(filePath));

		audioClip = AudioSystem.getClip();
		//audioClip.loop(loopNumber);
	}
}
