package org.jvnet.hudson.plugins.zabbix;

import hudson.Plugin;
import hudson.model.Descriptor.FormException;

import java.io.IOException;

import javax.servlet.ServletException;

import net.sf.json.JSONObject;

import org.kohsuke.stapler.StaplerRequest;

/**
 * Entry point of Zabbix plugin.
 * 
 * @author Andreas Brenk
 * @since 1.0
 */
public class PluginImpl extends Plugin {

    private int port = 10050;

    @Override
    public void configure(final StaplerRequest req, final JSONObject formData) throws IOException,
            ServletException, FormException {
        this.port = formData.optInt("port", 10050);
        save();
    }

    public int getPort() {
        return this.port;
    }

    @Override
    public void start() throws Exception {
        load();
    }

}
