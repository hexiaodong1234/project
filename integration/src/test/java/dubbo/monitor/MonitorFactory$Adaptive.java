package dubbo.monitor;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.monitor.Monitor;
import com.alibaba.dubbo.monitor.MonitorFactory;

/**
 * @author Administrator
 * @create 2018-04-25 22:46
 */
public class MonitorFactory$Adaptive implements MonitorFactory {

    public Monitor getMonitor(URL arg0) {
        if (arg0 == null) { throw new IllegalArgumentException("url == null"); }
        URL url = arg0;
        String extName = (url.getProtocol() == null ? "dubbo" : url.getProtocol());
        if (extName == null) {
            throw new IllegalStateException(
                "Fail to get extension(com.alibaba.dubbo.monitor.MonitorFactory) name from url(" + url.toString() + ") use keys([protocol])");
        }
        MonitorFactory extension = ExtensionLoader.getExtensionLoader(MonitorFactory.class).getExtension(extName);
        return extension.getMonitor(arg0);
    }
}
