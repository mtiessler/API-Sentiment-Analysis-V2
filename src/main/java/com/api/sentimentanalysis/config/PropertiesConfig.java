package com.api.sentimentanalysis.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/** Configuration class for properties file
 *
 * @author Ariadna de Arriba
 */
public class PropertiesConfig
{
    /** Read properties file.
     *
     * @return Returns an instance of this class.
     */
    public static Properties readProperties()
    {
        Properties properties = new Properties();
        FileInputStream inputStream = null;

        try
        {
            inputStream = new FileInputStream("src\\main\\resources\\config.properties");
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        try
        {
            properties.load(inputStream);
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        return properties;
    }
}