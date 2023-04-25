package gh2;
import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

/**
 * A client that uses the synthesizer package to replicate a plucked guitar string sound
 */
public class GuitarHero {
    // 24 usable key on keyboard
    static final String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    public static final int KEYSIZE = 37;
    public static double getFrequency(int i){
        double freq = 440.0 * Math.pow(2, (i - 24) / 12.0);
        return freq;
    }

    public static void main(String[] args) {
        /* create 37 guitar strings */
        GuitarString[] guitarStrings = new GuitarString[KEYSIZE];

        while (true) {
            /* check if the user has typed a key; if so, process it */
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int index = keyboard.indexOf(key);
                // If the key within the keyboard, new a GuitarString.
                if (index >= 0){
                    double freq = GuitarHero.getFrequency(index);
                    guitarStrings[index] = new GuitarString(freq);
                    guitarStrings[index].pluck();
                }
            }

            /* compute the superposition of samples */
            double sample = 0;
            for (int i = 0; i < guitarStrings.length; i++){
                if(guitarStrings[i] == null){
                    continue;
                }
                sample += guitarStrings[i].sample();
                guitarStrings[i].tic(); // advance the simulation of each guitar string by one step
            }

            /* play the sample on standard audio */
            StdAudio.play(sample);
        }
    }
}

