package com.wt6.sasc.util;

import java.util.HashMap;
import java.util.Map;

import static com.wt6.sasc.util.Constants.*;

public class ColorMap {
    public static final Map<String, String> COLOR_MAPS = new HashMap<>();

    public static Map<String, String> getColorMap() {

        if (COLOR_MAPS.size() == 0) {
            String[] split = COLOR_STRING.split( "," );
            for (String colorMap : split) {
                String[] codeAndName = colorMap.split( " " );
                COLOR_MAPS.put( codeAndName[0],codeAndName[1] );
            }
        }
        return COLOR_MAPS;
    }
}


