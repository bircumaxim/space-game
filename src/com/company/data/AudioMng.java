package com.company.data;

import com.company.domain.models.AudioKey;
import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.util.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

/**
 * Created by max on 5/2/17.
 */
public class AudioMng {
    private static final HashMap<AudioKey, Audio> loadedAudios = new HashMap<>();
    private static AudioMng instance = new AudioMng();

    private AudioMng() {

    }

    public static AudioMng getInstance() {
        return instance;
    }

    public Audio loadAudio(AudioKey audioKey) {
        Audio audio = loadedAudios.get(audioKey);
        if (audio == null) {
            audio = loadAudioFromFile(audioKey);
            loadedAudios.put(audioKey, audio);
        }
        return audio;
    }

    private Audio loadAudioFromFile(AudioKey audioKey) {
        try {
            InputStream resourceAsStream = ResourceLoader.getResourceAsStream("res/audio/" + audioKey.getName() + "." + audioKey.getFormat());
            return AudioLoader.getAudio("OGG", resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
