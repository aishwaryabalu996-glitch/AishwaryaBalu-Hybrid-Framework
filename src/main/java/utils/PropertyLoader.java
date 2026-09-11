package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyLoader {

        private static final Properties properties = new Properties();

        static {
            try (InputStream input =
                         PropertyLoader.class.getClassLoader()
                                 .getResourceAsStream("config.properties")) {

                if (input == null) {
                    throw new RuntimeException(
                            "config.properties not found in src/test/resources"
                    );
                }

                properties.load(input);

            } catch (IOException e) {
                throw new RuntimeException(
                        "Unable to load config.properties", e
                );
            }
        }

        // Get String property
        public static String getProperty(String key) {

            String value = properties.getProperty(key);

            if (value == null) {
                throw new RuntimeException(
                        "Property not found: " + key
                );
            }

            return value;
        }

        // Get Integer property
        public static int getIntProperty(String key) {

            String value = getProperty(key);

            try {
                return Integer.parseInt(value.trim());
            } catch (NumberFormatException e) {
                throw new RuntimeException(
                        "Invalid integer value for property: " + key,
                        e
                );
            }
        }
    }
