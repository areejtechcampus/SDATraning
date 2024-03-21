package Assigments2;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.testng.Tests;

import java.io.FileInputStream;
import java.io.IOException;

public class AssignTaskExecl extends Tests  {
    /*
Go to https://testpages.eviltester.com/styled/apps/notes/simplenotes.html
Add 10 notes using data provider with excel
Run it with 3 different browsers using XML file
Run it parallel with 3 threads
 */
    @Test(dataProvider = "ExcelData")
    public void dataTest(String noteTitle, String noteContent) {
        driver.get("https://testpages.eviltester.com/styled/apps/notes/simplenotes.html");

        By titleInput = By.id("note-title-input");
        By contentInput = By.id("note-details-input");
        By addButton = By.id("add-note");

        driver.findElement(titleInput).sendKeys(noteTitle);
        driver.findElement(contentInput).sendKeys(noteContent);
        driver.findElement(addButton).click();
    }


    @DataProvider(name = "ExcelData")
    public Object[][] excelData() throws IOException {
        String filePath = "C:\\Users\\Areej\\IdeaProjects\\SaudiDigitalAcademy\\resources\\TaskExel.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheetAt(0);

        int rows = sheet.getPhysicalNumberOfRows();
        Object[][] data = new Object[rows - 1][2];

        for (int i = 1; i < rows; i++) {
            Row row = sheet.getRow(i);
            data[i - 1][0] = row.getCell(0).getStringCellValue(); // Note Title
            data[i - 1][1] = row.getCell(1).getStringCellValue(); // Note Content
        }

        workbook.close();
        fis.close();
        return data;
    }
}