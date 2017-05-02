package com.company.domain.core;

import com.company.domain.models.AudioKey;

/**
 * Created by max on 5/2/17.
 */
public interface AudioPlayer {
    public void play(AudioKey audioKey);
    public void stop(AudioKey audioKey);
}
