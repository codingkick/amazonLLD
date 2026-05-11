package questions.downloadManager;

import java.io.File;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DownloadTask implements Runnable {
    private URL url;
    private Path destination;
    private double progress;
    private DownloadState state;
    private List<Chunk> chunks;
    private List<Thread> threads;
    private static final int THREAD_COUNT = 4;
    DownloadTask(URL url, Path destination) {
        this.url = url;
        this.destination = destination;
        this.progress = 0.0;
        this.state = DownloadState.NOT_STARTED;
        this.chunks = new ArrayList<>();
        this.threads = new ArrayList<>();
    }

    @Override
    public void run() {
        //fetch the file size
        try{
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            int size = connection.getContentLength();

            //create new file of size size at destination
            RandomAccessFile raf = new RandomAccessFile(destination.toFile(), "rw");
            raf.setLength(size);


            for(int i=0;i<THREAD_COUNT;i++){
                int start = i * size / THREAD_COUNT;
                int end = (i+1) * size / THREAD_COUNT - 1;
                if(i == THREAD_COUNT - 1) {
                    end = size - 1;
                }
                Chunk chunk = new Chunk(url, destination, start, end);
                chunks.add(chunk);
                Thread thread = new Thread(chunk);
                threads.add(thread);
                resume();
            }
        }
        catch(Exception e) {
            e.printStackTrace();
            state = DownloadState.FAILED;
            return;
        }
        //distribute the file into chunks
        //create threads to download each chunk -> put them to thread list to check on pause/resume them if needed
        //monitor progress and update state
    }

    public void resume(){
        threads.forEach(t->t.start());
        this.state = DownloadState.IN_PROGRESS;
    }

    public void pause(){
        threads.forEach(t->t.interrupt());
        this.state = DownloadState.PAUSED;
    }

}
