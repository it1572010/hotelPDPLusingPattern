/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hotel_pattern.utility;

import javafx.scene.control.Alert;

/**
 *
 * @author Anthony
 */
public class ViewUtil {

    private static Alert alert;

    static {
        alert = new Alert(Alert.AlertType.NONE);
    }

    public static void showAlert(Alert.AlertType type, String content) {
        showAlert(type, null, content);
    }

    public static void showAlert(Alert.AlertType type, String title,
            String content) {
        alert.setAlertType(type);
        alert.setContentText(content);
        alert.setTitle(title);
        alert.showAndWait();
    }
}
