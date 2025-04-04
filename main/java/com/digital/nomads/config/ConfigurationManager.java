package com.digital.nomads.config;

import org.aeonbits.owner.ConfigCache;

public class ConfigurationManager {

    public static AppConfig getBaseConfig() {
        return ConfigCache.getOrCreate(AppConfig.class);
    }

    public static CredentialsConfig getCredentialConfig() {
        return ConfigCache.getOrCreate(CredentialsConfig.class);
    }
}
