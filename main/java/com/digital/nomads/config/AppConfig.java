package com.digital.nomads.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:app.properties"})
public interface AppConfig extends Config {

    @Key("base.demoqa.url")
    String baseDemoQAUrl();

    @Key("base.lms.url")
    String baseLmsUrl();

    @Key("default.implicitly.wait")
    int implicitlyWait();

    @Key("default.implicitly.sleep")
    int implicitlySleep();

    @Key("docker.remote")
    boolean remote();

    @Key("remote.url.docker")
    String dockerUrl();

    @Key("headless.mode")
    boolean headless();
}
