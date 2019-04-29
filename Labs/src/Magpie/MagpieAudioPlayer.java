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

	public MagpieAudioPlayer(String path) throws IOException,
	   											 UnsupportedAudioFileException,
	   											 LineUnavailableException
	{
		loopNumber = 0;
		filePath = path;
		resetAudioSys();
	}

	public void setLoops(int theLoops)
	{
		loopNumber = theLoops;
	}

	public void play()
	{
		audioClip.loop(loopNumber);
		audioClip.start();
	}

	public void stop() throws IOException,
		 					  UnsupportedAudioFileException,
		 					  LineUnavailableException
	{
		audioClip.stop();
		resetAudioSys();
	}

	public void resetAudioSys() throws IOException,
									   UnsupportedAudioFileException,
									   LineUnavailableException
	{
		fileStream = AudioSystem.getAudioInputStream(new File(filePath));

		audioClip = AudioSystem.getClip();
		audioClip.open(fileStream);
		audioClip.loop(0);
	}
}
