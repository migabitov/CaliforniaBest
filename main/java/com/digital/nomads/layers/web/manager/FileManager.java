package com.digital.nomads.layers.web.manager;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;

public class FileManager {

    @Step("Verify the file is downloaded")
    public static boolean isFileDownloaded(String extension) {
        var files = WebDriverRunner.getBrowserDownloadsFolder().filesAsString();
        return files.contains(extension);
    }

}