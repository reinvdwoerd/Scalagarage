package projectgroep.parkeergarage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import projectgroep.parkeergarage.logic.Settings;


/**
 * Eigenlijk vind ik serialization best irritant, het is niet zo transparant.
 * Maar dit werkte makkelijker dan INI voor nu.
 *
 * @author reinvdwoerd
 */
public class SettingsRepository {

    public static void saveSettings(Settings s) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("settings"));
            oos.writeObject(s);
            oos.close();
        } catch (IOException e) {
        }
    }

    public static Settings loadSettings() {
        try {
            FileInputStream fis = new FileInputStream("settings");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Settings s = (Settings) ois.readObject();
            ois.close();
            System.out.println(s.asMap());
            return s;
        } catch (IOException | ClassNotFoundException e) {
            return new Settings();
        }
    }
}
