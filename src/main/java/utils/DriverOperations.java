package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.*;

/**
 * Designed for https://eviltester.github.io/simpletodolist/adminlogin.html
 */
public class DriverOperations {

    /**
     * Read items from local storage
     *
     * @param driver   WebDriver
     * @param itemName String
     * @return List<Map < String, Object>>
     */
    public static List<Map<String, Object>> getItemFromLS(WebDriver driver, String itemName) {
        String script = String.format("return JSON.parse(localStorage.getItem('%s'))", itemName);
        return (List<Map<String, Object>>) ((JavascriptExecutor) driver).executeScript(script);
    }

    /**
     * Returns a list of all the elements in local storage
     *
     * @param driver
     * @return
     */
    public static List<List<Map<String, Object>>> getAllItems(WebDriver driver) {
        List<List<Map<String, Object>>> objectsList = new ArrayList<>();

        String script = "Object.keys(localStorage)";
        List<String> keys = (List<String>) ((JavascriptExecutor) driver).executeScript(script);

        for (String key : keys) {
            List<Map<String, Object>> object = getItemFromLS(driver, key);
            object.get(0).put("listName", key);
            objectsList.add(object);
        }
        return objectsList;
    }

    /**
     * Adds an item to the LC
     *
     * @param driver
     */
    public static void addItemToLS(WebDriver driver) {
        List<List<Map<String, Object>>> objectsList = getAllItems(driver);
        Map<String, Object> newItem = new HashMap<>();
        newItem.put("parameter1", true);
        newItem.put("parameter2", System.currentTimeMillis());
        newItem.put("parameter3", "value");
        objectsList.add((List<Map<String, Object>>) newItem);

        for (List<Map<String, Object>> item : objectsList) {
            String itemName = (String) item.get(0).get("listName");
            item.get(0).remove("listName");
            String script = String.format("localStorage.setItem('%s', JSON.stringify(arguments[0]));", itemName);
            ((JavascriptExecutor) driver).executeScript(script, item);
        }

    }
}
