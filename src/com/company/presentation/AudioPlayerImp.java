package com.company.presentation;

import com.company.data.AudioMng;
import com.company.domain.core.AudioPlayer;
import com.company.domain.models.AudioKey;
import org.newdawn.slick.openal.Audio;

/**
 * Created by max on 5/2/17.
 */
public class AudioPlayerImp implements AudioPlayer {
    private static AudioPlayerImp instance = new AudioPlayerImp();

    public static AudioPlayerImp getInstance() {
        return instance;
    }

    @Override
    public void play(AudioKey audioKey) {

        Audio audio = AudioMng.getInstance().loadAudio(audioKey);
        if (audio.isPlaying()) {
            audio.stop();
        }
        audio.playAsSoundEffect(1.0f, 1.0f, false);
    }

    @Override
    public void stop(AudioKey audioKey) {
        Audio audio = AudioMng.getInstance().loadAudio(audioKey);
        if (audio.isPlaying()) {
            audio.stop();
        }
    }
}
