package com.example.exportdatatoexcel.controller;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import com.example.exportdatatoexcel.entity.Employee;
import com.example.exportdatatoexcel.repository.EmployeeRepository;

import lombok.RequiredArgsConstructor;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

	@Autowired
	private  EmployeeRepository employeeRepository;
	
	 
	@GetMapping("/export")
	public ResponseEntity<?> exportEmployee() throws Exception{
		
		
		List<Employee> employeeList = employeeRepository.findAll();
		if(!CollectionUtils.isEmpty(employeeList)) {
		  Workbook workbook = exportToExcel(employeeList);
          String directoryPath = "F:\\file\\";
          String fileName = "employees.xlsx";
          String filePath = directoryPath + fileName;

          // Create the directory if it doesn't exist
          File directory = new File(directoryPath);
          if (!directory.exists()) {
              directory.mkdirs();
          }
		  
          try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
              workbook.write(outputStream);
          }
          return ResponseEntity.ok("Excel file generated successfully and saved locally at: " + filePath);
		  
	        
	        
		}else {
			
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error generating Excel file.");
		}
		
	}
	
	 private static final String DIRECTORY_PATH = "F:\\file\\";

	 @DeleteMapping("/delete")
	 public ResponseEntity<String> deleteFile(@RequestParam String fileName) {
	        try {
	            File fileToDelete = new File(DIRECTORY_PATH + fileName);

	            if (fileToDelete.exists() && fileToDelete.isFile()) {
	                if (fileToDelete.delete()) {
	                    return ResponseEntity.ok("File deleted successfully");
	                } else {
	                    return ResponseEntity.status(500).body("Failed to delete the file");
	                }
	            } else {
	                return ResponseEntity.status(404).body("File not found");
	            }
	        } catch (Exception e) {
	            return ResponseEntity.status(500).body("Internal Server Error");
	        }
	    }
	    
	    
	public static Workbook exportToExcel(List<Employee> employees) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Employees");

        // Create header row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("First Name");
        headerRow.createCell(2).setCellValue("Last Name");
        headerRow.createCell(3).setCellValue("Employee Age");
        headerRow.createCell(4).setCellValue("Salary");
        headerRow.createCell(5).setCellValue("Address");
        headerRow.createCell(6).setCellValue("Phone Number");
        headerRow.createCell(7).setCellValue("Experience");

        // Create data rows
        int rowNum = 1;
        for (Employee employee : employees) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(employee.getEmployeeId());
            row.createCell(1).setCellValue(employee.getEmployeeFirstName());
            row.createCell(2).setCellValue(employee.getEmployeeLastName());
            
            row.createCell(3).setCellValue(employee.getEmployeeAge());
            row.createCell(4).setCellValue(employee.getEmployeeSalary());
            row.createCell(5).setCellValue(employee.getEmployeeAddress());
            row.createCell(6).setCellValue(employee.getPhoneNumber());
            row.createCell(7).setCellValue(employee.getEmployeeExperienceInMonths());
            
        }

        return workbook;
    }
}
