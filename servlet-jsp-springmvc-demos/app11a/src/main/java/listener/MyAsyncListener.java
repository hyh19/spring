package listener;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import java.io.IOException;

public class MyAsyncListener implements AsyncListener {

    public void onComplete(AsyncEvent asyncEvent) throws IOException {
        System.out.println("onComplete");
    }

    public void onTimeout(AsyncEvent asyncEvent) throws IOException {
        System.out.println("onTimeout");
    }

    public void onError(AsyncEvent asyncEvent) throws IOException {
        System.out.println("onError");
    }

    public void onStartAsync(AsyncEvent asyncEvent) throws IOException {
        System.out.println("onStartAsync");
    }
}
