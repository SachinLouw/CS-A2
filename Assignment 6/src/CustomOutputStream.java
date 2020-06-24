import java.io.IOException;
import java.io.OutputStream;
  
public class CustomOutputStream extends OutputStream{
    private String string;
     
    public CustomOutputStream(String str){
        this.string = str;
    }
     
    @Override
    public void write(int b) throws IOException {
        // redirects data to the text area
        string += String.valueOf((char)b);
        // // scrolls the text area to the end of data
        // textArea.setCaretPosition(textArea.getDocument().getLength());
    }
    
    public String getOutput(){return this.string;}
}