
![Logo](https://github.com/Satvik2910/Training_Task/blob/Task/src/com/aviation/oops/Truebox/Game.png?raw=true)
# File Converter

Converter allows you to generate HTML documentation, PDF documentation and Excel sheet from the CSV file or any other API url. The project is build on the principle of modularisation and Encapsulation.

Check out sample [HTML](https://github.com/Satvik2910/Training_Task/blob/Task/src/com/aviation/oops/Truebox/converted1.html), [PDF](https://github.com/Satvik2910/Training_Task/blob/Task/src/com/aviation/oops/Truebox/converted_PDF_File1.pdf) ,[Excel](https://github.com/Satvik2910/Training_Task/blob/Task/src/com/aviation/oops/Truebox/result2.xlsx) files generated from Converter.

## Authors

- [@SATVIK MANDIL](https://www.github.com/Satvik2910)


## Acknowledgements

 - [Stackoverflow](https://stackoverflow.com/) helped in overcoming errors and exceptions.

 - [Javatpoint](https://www.javatpoint.com/) helped in better understanding of programing concepts.
 
 - [Baeldung](https://www.baeldung.com/junit) helped in implementation of junit and understanding its applications. 


## Tech Stack

**Server:** Java 



## API Reference

#### Get all routes from the aviation API.

```http
  GET "https://api.aviationapi.com/v1/preferred-routes"
```






## Library Invoked

To run this project, you will need to add the following Library(jar files) to your system.

- [Itextpdf 5.5.13](https://mvnrepository.com/artifact/com.itextpdf/itextpdf/5.5.13.3)

- [spire.xls.ExcelVersion](https://mvnrepository.com/artifact/e-iceblue/spire.xls/12.9.1) 

- [Junit 5.8.1](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.9.1) 

- [junit-jupiter-api-5.9.1](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.9.1) 

- [Json CDL]() 


## Detailed Description 

### Converters
File Converters are used to convert data sent from one file format into another file format.CSV File Conversions from one format to another set require standard converting code sets. When data must be converted from a sender's format to a receiver's format, a uniform interface is required.

Our converter class contains 3 different methods executing different funtionalities, Where they convert the .csv file into different file format.
Those methods can be state as

- [csvtoExcelconverter()](https://github.com/Satvik2910/Training_Task/blob/Task/src/com/aviation/oops/convertors.java#L191)
- [csvtopdfconverter()](https://github.com/Satvik2910/Training_Task/blob/Task/src/com/aviation/oops/convertors.java#L105)
- [csvtohtmlconverter()](https://github.com/Satvik2910/Training_Task/blob/Task/src/com/aviation/oops/convertors.java#L146)


####  csvtoExcelconverter()
This method converts the CSV file as input parameter from the user and generates an excel sheet from the data acquired from the csv file.  


####  csvtopdfconverter()
This method converts the CSV file as input parameter from the user and generates an PDF file from the data acquired from the csv file.


####  csvtohtmlconverter()
This method converts the CSV file as input parameter from the user and generates an HTML table from the data acquired from the csv file.




### Sample outputs

![Excel](https://github.com/Satvik2910/Training_Task/blob/Task/src/com/aviation/oops/Truebox/Sample%20Excel%20sheet.png?raw=true)

![PDF](https://github.com/Satvik2910/Training_Task/blob/Task/src/com/aviation/oops/Truebox/Sample%20PDF%20file.png?raw=true)

![HTML](https://github.com/Satvik2910/Training_Task/blob/Task/src/com/aviation/oops/Truebox/Sample%20HTML%20table.png?raw=true)



### Additional Concepts Involved 

- Modularisation 
- Encapsulation
- Error Handling
- Exception Handling
- Unit Testing




## Features

- Convert CSV File into different file formats.
- Provide Multiple File Format Support
- Provide Proper Document Management


## Used By

This project is used by the following companies:

- Owners 
- Codeops 


## FAQ

#### What is the use of this converter?

This Converter is used to convert csv file in pdf file , html file and excel file format and .

#### What file formats does it support?
The file format supported is .csv extension files. 


## License

[MIT](https://choosealicense.com/licenses/mit/)


## Badges


[![MIT License](https://img.shields.io/badge/License-MIT-green.svg)](https://choosealicense.com/licenses/mit/)
[![GPLv3 License](https://img.shields.io/badge/License-GPL%20v3-yellow.svg)](https://opensource.org/licenses/)
[![AGPL License](https://img.shields.io/badge/license-AGPL-blue.svg)](http://www.gnu.org/licenses/agpl-3.0)


## Appendix

### What is a CSV file ?

A comma-separated values (CSV) file is a delimited text file that uses a comma to separate values. Each line of the file is a data record. Each record consists of one or more fields, separated by commas. The use of the comma as a field separator is the source of the name for this file format. A CSV file typically stores tabular data (numbers and text) in plain text, in which case each line will have the same number of fields.

### What is a PDF file ?

Portable Document Format, standardized as ISO 32000, is a file format developed by Adobe in 1992 to present documents, including text formatting and images, in a manner independent of application software, hardware, and operating systems.


### What's an HTML document?
 
HTML (Hypertext Markup Language) is a text-based approach to describing how content contained within an HTML file is structured. This markup tells a web browser how to display text, images and other forms of multimedia on a webpage.

### What's an Excel file?

Excel is a spreadsheet program from Microsoft and a component of its Office product group for business applications. Microsoft Excel enables users to format, organize and calculate data in a spreadsheet.
## Feedback

If you have any feedback, please reach out to me at satvikmandil29@gmail.com

