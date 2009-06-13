package org.jvnet.hudson.plugins.zabbix;

import hudson.model.Hudson;

import com.andreasbrenk.zabbix.ZabbixItem;

/**
 * @author Andreas Brenk
 * @since 1.0
 */
public class HudsonTotalExecutorsItem implements ZabbixItem {

    /**
     * @return "hudson.overallLoad.totalExecutors"
     */
    public String getKey() {
        return "hudson.overallLoad.totalExecutors";
    }

    public String getValue(final String... parameter) throws Exception {
        return String.valueOf(Hudson.getInstance().overallLoad.computeTotalExecutors());
    }

}
