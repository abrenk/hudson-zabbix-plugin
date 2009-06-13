package org.jvnet.hudson.plugins.zabbix;

import hudson.model.Hudson;

import com.andreasbrenk.zabbix.ZabbixItem;

/**
 * @author Andreas Brenk
 * @since 1.0
 */
public class HudsonNumExecutorsItem implements ZabbixItem {

    /**
     * @return "hudson.numExecutors"
     */
    public String getKey() {
        return "hudson.numExecutors";
    }

    /**
     * @return Number of executors of the master node.
     */
    public String getValue(final String... parameter) throws Exception {
        return String.valueOf(Hudson.getInstance().getNumExecutors());
    }

}
