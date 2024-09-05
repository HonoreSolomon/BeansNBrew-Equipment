

# WESTERN GOVERNORS UNIVERSITY 
## D287 – JAVA FRAMEWORKS

Honore Solomon

### C.  Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names of the parts.

Note: Do not remove any elements that were included in the screen. You may add any additional elements you would like or any images, colors, and styles, although it is not required.

-mainscreen.html: changed Title to 'Bean & Brew Equipment' on line 14
-mainscreen.html: change h1 to the same 'Bean & Brew Equipment' on line 19
-mainscreen.html: changed button name to 'Add Internal Component' on line 30
-mainscreen.html: changed button name to 'Add Supplier Component' on line 31

-demo.css: Created custom css styling to layer on top of bootstrap styling

-mainscreen.html: added Nav with a link titled Home on lines 21 - 25
-mainscreen.html: added a div for another banner named stock lines 28 - 31
-mainscreen.html: added a footer on line 103 - 105

### D.  Add an “About” page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.

-about.html: created about page template
-about.html: 1 -14 added all head data, meta data, links to styles etc
-mainscreen.html: added another anchor link for the about page - line 23
-about.html: added the same navbar as the mainscreen.html for consistency as well as an additional link - 18-32
-about.html: Added "Who We Are" and "Our Commitment" sections using Bootstrap's grid system and divs and p elements- 35-63.
-about.html: Added an image section and applied Bootstrap classes for responsive design - 44.
-about.html: Added footer with copyright information - 67-70.
-AboutController.java: added the about controller in the controllers folder
-AboutController.java: added packages being used in about controller -lines 1-7
-AboutController.java: added Controller annotation line 17
-AboutController.java: added controller public class line 18
-AboutController.java:created GetMapping annotation and method to return the about page line 19 - 22
-purchaseSuccess.html: created the html template for purchase success
-purchaseSuccess.html: added head data lines 1 - 7
-purchaseSuccess.html: added h1 Purchase Success line 9
-purchaseSuccess.html: added p Your order has been places successfully line 10
-purchaseSuccess.html: added link back to products page line 11
-purchaseError.html: created the html template for purchase success
-purchaseError.html: added head data lines 1 - 7
-purchaseError.html: added h1 Purchase Error line 9
-purchaseError.html: added p There was an error processing your order line 10
-purchaseError.html: added link back to products page line 11

### E.  Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.

Note: Make sure the sample inventory is added only when both the part and product lists are empty. When adding the sample inventory appropriate for the store, the inventory is stored in a set so duplicate items cannot be added to your products. When duplicate items are added, make a “multi-pack” part.

-BootStrapData.java: line 42 and 43 created varriables to hold the count of the part and product repositories using the count method
-BootStrapData.java: added conditional statement that checks there if there are 0 items populating the data repositories before adding data line 45
-BootStrapData.java: 47 - 85, created inhousePartObjects with sample data. used methods set name, price, inv and partID to create the objects. then lastly added the save method to save the object to the repository
-BootStrapData.java: created a new product object for each sample product lines 88-92
-BootStrapData.java: saved the new objects in the product repository lines 94 - 98

### F.  Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:
•  The “Buy Now” button must be next to the buttons that update and delete products.
•  The button should decrement the inventory of that product by one. It should not affect the inventory of any of the associated parts.
•  Display a message that indicates the success or failure of a purchase.

mainscreen.html: added a form to hold the input and button with action /buyProduct to map to this URL. and then it will have a post request so it can access and update the invetory for purchased products. line 99
mainscreen.html: input element of hidden type to pass the tempProductId to the controller - line 100
mainscreen.html: button field of type submit to act as the buy now button.
BuyProductController.java: Created the BuyProductController class
BuyProductController.java: added package and all needed imports lines 1 - 13
BuyProductController.java: created the public BuyProductController class and annotated it with @Controller line 15 and 16
BuyProductController.java: instantiated the productRepository as a private final ProductRepository line 18
BuyProductController.java: created a private ProductRepository object with the @Autowired annotation to be able to increment and decrement the inventory line 20 - 23
BuyProductController.java: @PostMapping annotation is used to handle the buy now buttons functionality, handling the HTTP Post request - line 25
BuyProductController.java: Created public string method for the controller with @RequestParam to grab the productId - line 26
BuyProductController.java: created the Optional <Product> that assigns its value to what is found in the productRepository using the productID - line 27
BuyProductController.java: if conditional using the Optional object to verify that the product is found in the repository. - line 28 - 29
BuyProductController.java: if conditional to decrease the inventory count if it is greater than 0 - lines 31 - 33
BuyProductController.java: a success message is generated for the purchase "Purchase Successful" - line 35
BuyProductController.java: in the return statement there is a redirect to the successPage URL line 36
BuyProductController.java: if the inv count is < 0 then a purchase failed message is generated "Purchase Failed: Not enough inventory"line 37 - 38
BuyProductController.java: in the return statement there is a redirect  to the purchaseError page line 39
BuyProductController.java: finally if the product was not found an error message is generated for this error "Purchase Failed: Product Not Found" line 41-42
BuyProductController.java:  in the return statement there is a redirect  to the purchaseError page line 43


### G.  Modify the parts to track maximum and minimum inventory by doing the following:
•  Add additional fields to the part entity for maximum and minimum inventory.
•  Modify the sample inventory to include the maximum and minimum fields.
•  Add to the InhousePartForm and OutsourcedPartForm forms additional text inputs for the inventory so the user can set the maximum and minimum values.
•  Rename the file the persistent storage is saved to.
•  Modify the code to enforce that the inventory is between or at the minimum and maximum value.

-Part.java: added the int min field and @Min annotation for validation on lines 36-37
-Part.java: added the int max field and @Max annotation for validation on lines 38-39
-Part.java: created a new constructor with the min and max fields included lines 51 - 57
-Part.java: created a new constructor with the min and max fields and id overload included lines 59 - 56
-Part.java: created a new constructor with the min and max fields included lines 51 - 57
-Part.java: created a getter and setter for the min field lines 114 - 121
-Part.java: created a getter and setter for the max field lines 123 - 130
-BootStrapData.java: set min and max for part1 lines 52-53
-BootStrapData.java: set min and max for part2 lines 62-63
-BootStrapData.java: set min and max for part3 lines 72-73
-BootStrapData.java: set min and max for part4 lines 82-83
-BootStrapData.java: set min and max for part5 lines 92-93
application.properties: changed the name of the database to spring-boot-beans&brewdb on line 6
-inhousePartForm: added styling in the header so pages are uniform lines 1 - 14
-inhousePartForm: added the nav and container so it is consistent with webpage on lines 16 - 20
-inhousePartForm: added hr on line 22
-InhousePartForm: added input with validation for min inventory value on line 39 - 40
-InhousePartForm: added input with validation for max inventory value on line 42 - 43
-OutsourcedPartForm: added styling in the header so pages are uniform lines 1 - 14
-OutsourcedPartForm: added the nav and container so it is consistent with webpage on lines 16 - 20
-OutsourcedPartForm: added hr on line 22
-OutsourcedPartForm: added input with validation for min inventory value on line 39 - 40
-OutsourcedPartForm: added input with validation for max inventory value on line 42 - 43
-Part.java: created an isInvValid method to check if inventory is between the min and max values on line 153 - 155
-AddinhousePartController.java: add logic to check if inventory is valid and sends a rejection message if it is not lines 43 - 45
-AddOutsourcedPartController.java: add logic to check if inventory is valid and sends a rejection message if it is not lines 43 - 45
-OutsourcedPartForm.html: added divs and labels for the inputs of each field
-InhousePartForm.html: added divs and labels for the inputs of each field
### H.  Add validation for between or at the maximum and minimum fields. The validation must include the following:
•  Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum number of parts.
•  Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.
•  Display error messages when adding and updating parts if the inventory is greater than the maximum.

-AddOutsourcedPartController.java: added if else logic to check if inventory is below the minimum and return an error message on lines 43-44
-AddOutsourcedPartController.java: added if else logic to check if inventory is above the maximum and return an error message on lines 45-46
-AddInhousePartController.java: added if else logic to check if inventory is below the minimum and return an error message on lines 44-45
-AddInhousePartController.java: added if else logic to check if inventory is above the maximum and return an error message on lines 46-48
-EnufPartsValidator.java: add new if logic to check for low inventory when adding and updating products lowers the part inventory below the min lines 37 - 39
-ValidEnufParts.java: made a more specific error message. line 20
### I.  Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.
-PartTest.java: created the setMin unit test by first annotating @Test line 104
-PartTest.java: start by setting int min to an arbitrary test num line 106
-PartTest.java: sets the partIn to the min variable line 107
-PartTest.java: assertEquals is then used to make sure it functions correctly. line 108
-PartTest.java:process is then repeated with partOut lines 109-110
-PartTest.java: created the getMin unit test by first annotating @Test line 113
-PartTest.java: start by setting int min to an arbitrary test num line 114
-PartTest.java: sets the partIn to the min variable line 115
-PartTest.java: assertEquals is then used to make sure it functions correctly. line 116
-PartTest.java:process is then repeated with partOut lines 117-118
-PartTest.java: created the setMax unit test by first annotating @Test line 131
-PartTest.java: start by setting int max to an arbitrary test num line 132
-PartTest.java: sets the partIn to the max variable line 133
-PartTest.java: assertEquals is then used to make sure it functions correctly. line 134
-PartTest.java:process is then repeated with partOut lines 134-135
-PartTest.java: created the getMax unit test by first annotating @Test line 140
-PartTest.java: start by setting int max to an arbitrary test num line 141
-PartTest.java: sets the partIn to the max variable line 142
-PartTest.java: assertEquals is then used to make sure it functions correctly. line 143
-PartTest.java:process is then repeated with partOut lines 144-145



### J.  Remove the class files for any unused validators in order to clean your code.
-DeletePartValidator.java: deleted this unused validator
