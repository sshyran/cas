package org.apereo.cas.configuration.model.core.monitor;

import org.apereo.cas.configuration.model.support.ConnectionPoolingProperties;
import org.apereo.cas.configuration.model.support.jpa.AbstractJpaProperties;
import org.apereo.cas.configuration.model.support.ldap.AbstractLdapProperties;
import org.apereo.cas.configuration.support.Beans;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * Configuration properties class for cas.monitor.
 *
 * @author Dmitriy Kopylenko
 * @since 5.0.0
 */

public class MonitorProperties {

    private int freeMemThreshold = 10;

    private Tgt tgt = new Tgt();

    private St st = new St();

    private Warn warn = new Warn();

    private Endpoints endpoints = new Endpoints();
    
    private Jdbc jdbc = new Jdbc();

    private Ldap ldap = new Ldap();

    public Endpoints getEndpoints() {
        return endpoints;
    }

    public void setEndpoints(final Endpoints endpoints) {
        this.endpoints = endpoints;
    }

    public Jdbc getJdbc() {
        return jdbc;
    }

    public void setJdbc(final Jdbc jdbc) {
        this.jdbc = jdbc;
    }

    public Warn getWarn() {
        return warn;
    }

    public void setWarn(final Warn warn) {
        this.warn = warn;
    }

    public int getFreeMemThreshold() {
        return freeMemThreshold;
    }

    public void setFreeMemThreshold(final int freeMemThreshold) {
        this.freeMemThreshold = freeMemThreshold;
    }

    public Tgt getTgt() {
        return tgt;
    }

    public void setTgt(final Tgt tgt) {
        this.tgt = tgt;
    }

    public St getSt() {
        return st;
    }

    public void setSt(final St st) {
        this.st = st;
    }

    public Ldap getLdap() {
        return ldap;
    }

    public void setLdap(final Ldap ldap) {
        this.ldap = ldap;
    }

    public static class St {
        @NestedConfigurationProperty
        private Warn warn = new Warn(5000);

        public Warn getWarn() {
            return warn;
        }

        public void setWarn(final Warn warn) {
            this.warn = warn;
        }
    }

    public static class Tgt {
        @NestedConfigurationProperty
        private Warn warn = new Warn(10000);

        public Warn getWarn() {
            return warn;
        }

        public void setWarn(final Warn warn) {
            this.warn = warn;
        }
    }

    public static class Warn {
        private int threshold = 10;
        private long evictionThreshold;


        public Warn() {
        }

        public Warn(final int threshold) {
            this.threshold = threshold;
        }

        public int getThreshold() {
            return threshold;
        }

        public void setThreshold(final int threshold) {
            this.threshold = threshold;
        }

        public long getEvictionThreshold() {
            return evictionThreshold;
        }

        public void setEvictionThreshold(final long evictionThreshold) {
            this.evictionThreshold = evictionThreshold;
        }
    }

    public static class Ldap extends AbstractLdapProperties {
        private String maxWait = "PT5S";

        @NestedConfigurationProperty
        private ConnectionPoolingProperties pool = new ConnectionPoolingProperties();

        public ConnectionPoolingProperties getPool() {
            return pool;
        }

        public void setPool(final ConnectionPoolingProperties pool) {
            this.pool = pool;
        }

        public long getMaxWait() {
            return Beans.newDuration(maxWait).toMillis();
        }

        public void setMaxWait(final String maxWait) {
            this.maxWait = maxWait;
        }
    }

    public static class Jdbc extends AbstractJpaProperties {
        private String validationQuery = "SELECT 1";
        private String maxWait = "PT5S";

        public String getValidationQuery() {
            return validationQuery;
        }

        public void setValidationQuery(final String validationQuery) {
            this.validationQuery = validationQuery;
        }

        public long getMaxWait() {
            return Beans.newDuration(maxWait).toMillis();
        }

        public void setMaxWait(final String maxWait) {
            this.maxWait = maxWait;
        }

    }

    public static class Endpoints {
        private Dashboard dashboard = new Dashboard();
        private AuditEvents auditEvents = new AuditEvents();
        private AuthenticationEvents authenticationEvents = new AuthenticationEvents();
        private ConfigurationState configurationState = new ConfigurationState();
        private HealthCheck healthCheck = new HealthCheck();
        private LoggingConfig loggingConfig = new LoggingConfig();
        private Metrics metrics = new Metrics();
        private AttributeResolution attributeResolution = new AttributeResolution();
        private SingleSignOnReport singleSignOnReport = new SingleSignOnReport();
        private Statistics statistics = new Statistics();
        private TrustedDevices trustedDevices = new TrustedDevices();
        private Status status = new Status();
        private SingleSignOnStatus singleSignOnStatus = new SingleSignOnStatus();

        public SingleSignOnStatus getSingleSignOnStatus() {
            return singleSignOnStatus;
        }

        public void setSingleSignOnStatus(final SingleSignOnStatus singleSignOnStatus) {
            this.singleSignOnStatus = singleSignOnStatus;
        }

        public Status getStatus() {
            return status;
        }

        public void setStatus(final Status status) {
            this.status = status;
        }

        public Dashboard getDashboard() {
            return dashboard;
        }

        public void setDashboard(final Dashboard dashboard) {
            this.dashboard = dashboard;
        }

        public AuditEvents getAuditEvents() {
            return auditEvents;
        }

        public void setAuditEvents(final AuditEvents auditEvents) {
            this.auditEvents = auditEvents;
        }

        public AuthenticationEvents getAuthenticationEvents() {
            return authenticationEvents;
        }

        public void setAuthenticationEvents(final AuthenticationEvents authenticationEvents) {
            this.authenticationEvents = authenticationEvents;
        }

        public ConfigurationState getConfigurationState() {
            return configurationState;
        }

        public void setConfigurationState(final ConfigurationState configurationState) {
            this.configurationState = configurationState;
        }

        public HealthCheck getHealthCheck() {
            return healthCheck;
        }

        public void setHealthCheck(final HealthCheck healthCheck) {
            this.healthCheck = healthCheck;
        }

        public LoggingConfig getLoggingConfig() {
            return loggingConfig;
        }

        public void setLoggingConfig(final LoggingConfig loggingConfig) {
            this.loggingConfig = loggingConfig;
        }

        public Metrics getMetrics() {
            return metrics;
        }

        public void setMetrics(final Metrics metrics) {
            this.metrics = metrics;
        }

        public AttributeResolution getAttributeResolution() {
            return attributeResolution;
        }

        public void setAttributeResolution(final AttributeResolution attributeResolution) {
            this.attributeResolution = attributeResolution;
        }

        public SingleSignOnReport getSingleSignOnReport() {
            return singleSignOnReport;
        }

        public void setSingleSignOnReport(final SingleSignOnReport singleSignOnReport) {
            this.singleSignOnReport = singleSignOnReport;
        }

        public Statistics getStatistics() {
            return statistics;
        }

        public void setStatistics(final Statistics statistics) {
            this.statistics = statistics;
        }

        public TrustedDevices getTrustedDevices() {
            return trustedDevices;
        }

        public void setTrustedDevices(final TrustedDevices trustedDevices) {
            this.trustedDevices = trustedDevices;
        }

        public static class BaseEndpoint {
            private boolean enabled;
            private boolean sensitive = true;

            public boolean isEnabled() {
                return enabled;
            }

            public void setEnabled(final boolean enabled) {
                this.enabled = enabled;
            }

            public boolean isSensitive() {
                return sensitive;
            }

            public void setSensitive(final boolean sensitive) {
                this.sensitive = sensitive;
            }
        }
        public static class Dashboard extends BaseEndpoint {}
        public static class AuditEvents extends BaseEndpoint {}
        public static class AuthenticationEvents extends BaseEndpoint {}
        public static class ConfigurationState extends BaseEndpoint {}
        public static class HealthCheck extends BaseEndpoint {}
        public static class LoggingConfig extends BaseEndpoint {}
        public static class Metrics extends BaseEndpoint {}
        public static class AttributeResolution extends BaseEndpoint {}
        public static class SingleSignOnReport extends BaseEndpoint {}
        public static class Statistics extends BaseEndpoint {}
        public static class TrustedDevices extends BaseEndpoint {}
        public static class Status extends BaseEndpoint {}
        public static class SingleSignOnStatus extends BaseEndpoint {}
    }
}
