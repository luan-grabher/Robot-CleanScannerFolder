package CleanScannerFolder;

import Entity.Executavel;
import Robo.AppRobo;
import fileManager.FileManager;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;
import java.util.HashMap;
import org.ini4j.Ini;

public class Main {

    private static String nomeApp = "Limpar pasta Scanner";

    public static String testParameters = "";

    public static void main(String[] args) {
        try {
            AppRobo robo = new AppRobo(nomeApp);
            robo.definirParametros();
            
            if (args.length > 0 && args[0].equals("test")) {
                robo.definirParametros(testParameters);
            }

            robo.setNome(nomeApp);
            robo.executar(start());
        } catch (Exception e) {
            e.printStackTrace();
            FileManager.save(new File(System.getProperty("user.home")) + "\\Desktop\\JavaError.txt", getStackTrace(e));
            System.out.println("Ocorreu um erro na aplicação: " + e);            
        }
        System.exit(0);
    }

    private static String getStackTrace(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);

        return sw.toString();
    }

    public static String start() {
        Controller controller = new Controller();
                
        Map<String, Executavel>execs = new HashMap<>();
        
        return AppRobo.rodarExecutaveis(nomeApp, execs);
    }

}
