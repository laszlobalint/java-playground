import com.google.api.client.googleapis.media.MediaHttpUploader;
import com.google.api.client.googleapis.media.MediaHttpUploaderProgressListener;
import java.io.IOException;
import java.text.NumberFormat;

public class FileUploadProgressListener implements MediaHttpUploaderProgressListener {

    @Override
    public void progressChanged(MediaHttpUploader uploader) throws IOException {
        switch (uploader.getUploadState()) {
            case INITIATION_STARTED:
                System.out.println("Upload initiation has started.");
                break;
            case INITIATION_COMPLETE:
                System.out.println("Upload initiation is complete.");
                break;
            case MEDIA_IN_PROGRESS:
                System.out.println("Upload is in progress: "
                        + NumberFormat.getPercentInstance().format(uploader.getProgress()));
                break;
            case MEDIA_COMPLETE:
                System.out.println("Upload is complete!");
                break;
        }
    }
}