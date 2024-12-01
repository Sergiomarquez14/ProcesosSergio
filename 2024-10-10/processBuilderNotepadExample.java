import java.io.IOException;
 
public class processBuilderNotepadExample {
 
    public static void main(String[] args) {
        ProcessBuilder processBuilder = new ProcessBuilder("notepad.exe");
        ProcessBuilder processBuilder2 = new ProcessBuilder("calc.exe");
 
        try {
            Process process = processBuilder.start();
            int exitCode = process.waitFor();
 
            if (exitCode == 0) {
                System.out.println("Se ha ejecutado perfectamente \n" +"Codigo de exitCode: " + exitCode);
 
                    Process process2 = processBuilder2.start();
                    exitCode = process2.waitFor();
 
                    if (exitCode == 0) {
                        System.out.println("Se ha ejecutado perfectamente \n" +"Codigo de exitCode: " + exitCode);
                    }else{
                        System.err.println("Error \n" + "Codigo de exitCode: " + exitCode);
                    }
                   
            }else{
                System.err.println("Error \n" + "Codigo de exitCode: " + exitCode);
            }
           
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
