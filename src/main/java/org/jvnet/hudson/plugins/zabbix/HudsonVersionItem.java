package org.jvnet.hudson.plugins.zabbix;

import hudson.model.Hudson;

import com.andreasbrenk.zabbix.ZabbixItem;

/**
 * @author Andreas Brenk
 * @since 1.0
 */
public class HudsonVersionItem implements ZabbixItem {

    /**
     * @return "hudson.version"
     */
    public String getKey() {
        return "hudson.version";
    }

    /**
     * @return version number of this Hudson.
     */
    public String getValue(final String... parameter) throws Exception {
        return Hudson.VERSION;
    }

}
