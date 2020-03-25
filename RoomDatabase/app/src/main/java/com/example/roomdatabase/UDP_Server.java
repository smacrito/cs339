//From https://stackoverflow.com/questions/19540715/send-and-receive-data-on-udp-socket-java-android

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;

public class UDP_Server
{
    private AsyncTask<Void, Void, Void> async;
    private boolean Server_active = true;

    @SuppressLint("NewApi")
    public void runUdpServer()
    {
        async = new AsyncTask<Void, Void, Void>()
        {
            @Override
            protected Void doInBackground(Void... params)
            {
                byte[] lMsg = new byte[4096];
                DatagramPacket dp = new DatagramPacket(lMsg, lMsg.length);
                DatagramSocket ds = null;

                try
                {
                    ds = new DatagramSocket(Main.SERVER_PORT);

                    while(Server_active)
                    {
                        ds.receive(dp);

                        Intent i = new Intent();
                        i.setAction(Main.MESSAGE_RECEIVED);
                        i.putExtra(Main.MESSAGE_STRING, new String(lMsg, 0, dp.getLength()));
                        Main.MainContext.getApplicationContext().sendBroadcast(i);
                    }
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    if (ds != null)
                    {
                        ds.close();
                    }
                }

                return null;
            }
        };

        if (Build.VERSION.SDK_INT >= 11) async.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        else async.execute();
    }

    public void stop_UDP_Server()
    {
        Server_active = false;
    }
}