package com.tomkondat5.app;

import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONObject;

public class CommonFunc {

    public static void writeConnectionsToFile(JSONObject connectionsArray) {
        try (FileWriter file = new FileWriter("profileInfo.json")) {
            file.write(connectionsArray.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
