package questions.downloadManager;

public class DownloadManager {
    private static DownloadManager instance = null;
    private DownloadManager() {
    }
    public static DownloadManager getInstance() {
        if (instance == null) {
            instance = new DownloadManager();
        }
        return instance;
    }
}
