package org.jvnet.hudson.plugins.zabbix;

import hudson.model.Hudson;

import com.andreasbrenk.zabbix.ZabbixItem;

/**
 * @author Andreas Brenk
 * @since 1.0
 */
public class HudsonIdleExecutorsItem implements ZabbixItem {

    /**
     * @return "hudson.overallLoad.idleExecutors"
     */
    public String getKey() {
        return "hudson.overallLoad.idleExecutors";
    }

    public String getValue(final String... parameter) throws Exception {
        return String.valueOf(Hudson.getInstance().overallLoad.computeIdleExecutors());
    }

}
