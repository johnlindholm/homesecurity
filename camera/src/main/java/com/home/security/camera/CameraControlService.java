package com.home.security.camera;

import com.home.security.core.comm.CommunicationManager;
import com.home.security.core.protocol.annotation.ServiceMethod;
import com.home.security.core.protocol.annotation.ServiceMethodParam;
import com.home.security.core.protocol.message.Response;
import com.home.security.core.service.AbstractService;
import com.home.security.core.service.ServiceId;

import java.io.IOException;
import java.util.UUID;

/**
 * Created by john on 2014-11-22.
 */
public class CameraControlService extends AbstractService {

    private Process stream_1;

    public CameraControlService(CommunicationManager communicationManager, ServiceId serviceId) {
        super("Camera", "1.0", communicationManager, serviceId);
    }

    @ServiceMethod(name = "startStream")
    public void startStream(@ServiceMethodParam(name = "width_res") int width,
                            @ServiceMethodParam(name = "height_res") int height) {
        System.out.println("start()");
        try {
            stream_1 = Runtime.getRuntime().exec("/home/pi/scripts/./stream_1.sh");
            stream_1.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @ServiceMethod(name = "stopStream")
    public void stopStream() {
        System.out.println("stop()");
        stream_1.destroy();
        stream_1 = null;
    }


    @ServiceMethod(name = "isStreaming", returnParamNames = {"streaming"})
    public boolean isStreaming() {
        return stream_1 != null;
    }

    public static void main(final String[] args) {
        final CameraControlService cc = new CameraControlService(null, new ServiceId(UUID.randomUUID()));
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                cc.stopStream();
            }
        });
        cc.startStream(640, 480);
    }

    @Override
    public void handleResponse(Response response) {

    }

    @Override
    public void stop() {
        stopStream();
    }
}
