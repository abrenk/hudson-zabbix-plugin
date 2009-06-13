package org.jvnet.hudson.plugins.zabbix;

import hudson.Plugin;
import hudson.model.Descriptor.FormException;

import java.io.IOException;

import javax.servlet.ServletException;

import net.sf.json.JSONObject;

import org.kohsuke.stapler.StaplerRequest;

import com.andreasbrenk.zabbix.ZabbixAgent;
import com.andreasbrenk.zabbix.impl.ZabbixAgentServiceImpl;

/**
 * Entry point of Zabbix plugin.
 * 
 * @author Andreas Brenk
 * @since 1.0
 */
public class PluginImpl extends Plugin {

    private int port = ZabbixAgent.DEFAULT_PORT;

    private transient final ZabbixAgent zabbixAgent;

    public PluginImpl() {
        this.zabbixAgent = new ZabbixAgentServiceImpl();
        this.zabbixAgent.addItem(new HudsonIdleExecutorsItem());
        this.zabbixAgent.addItem(new HudsonNumExecutorsItem());
        this.zabbixAgent.addItem(new HudsonQueueLengthItem());
        this.zabbixAgent.addItem(new HudsonTotalExecutorsItem());
        this.zabbixAgent.addItem(new HudsonVersionItem());
    }

    @Override
    public void configure(final StaplerRequest req, final JSONObject formData) throws IOException,
            ServletException, FormException {
        this.port = formData.optInt("port", ZabbixAgent.DEFAULT_PORT);

        save();
    }

    public int getPort() {
        return this.port;
    }

    @Override
    public void start() throws Exception {
        load();

        this.zabbixAgent.start(this.port);
    }

    @Override
    public void stop() throws Exception {
        this.zabbixAgent.stop();
    }

}
