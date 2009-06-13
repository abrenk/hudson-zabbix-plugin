package org.jvnet.hudson.plugins.zabbix;

import hudson.model.Hudson;

import com.andreasbrenk.zabbix.ZabbixItem;

/**
 * @author Andreas Brenk
 * @since 1.0
 */
public class HudsonQueueLengthItem implements ZabbixItem {

    /**
     * @return "hudson.overallLoad.queueLength"
     */
    public String getKey() {
        return "hudson.overallLoad.queueLength";
    }

    /**
     * How many BuildableItems are assigned for the given label?
     */
    public String getValue(final String... parameter) throws Exception {
        return String.valueOf(Hudson.getInstance().overallLoad.computeQueueLength());
    }

}
