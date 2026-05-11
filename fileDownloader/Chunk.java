package questions.downloadManager;

import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Path;

public class Chunk implements Runnable {
    private URL url;
    private Path destination;
    private int start;
    private int end;
    Chunk(URL url, Path destination, int start, int end) {
        this.url = url;
        this.destination = destination;
        this.start = start;
        this.end = end;
    }
    @Override
    public void run() {
        //download the chunk from start to end and save it to the destination
        try{
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("range","bytes="+start+"-"+end);
            connection.connect();
            //read the input stream and write to the file at destination from start to end
            try(InputStream input = connection.getInputStream();
                RandomAccessFile raf = new RandomAccessFile(destination.toFile().toString(), "rw")) {
                raf.seek(start);
                byte[] buffer = new byte[1024];
                int bytesRead;
                while((bytesRead = input.read(buffer)) != -1){
                    raf.write(buffer, 0, bytesRead);
                }
            }
        catch(Exception e) {
            e.printStackTrace();
        }
    }catch(Exception e) {
            e.printStackTrace();
    }
}
}
