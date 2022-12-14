# My Personal Project

## Skincare Product Collection Creator


**A brief description**

As an individual with strong interests in skincare, I want to design an application where users can input products to a 
collection of skincare products. For instance, the application would ask for the user's:

- collection name
- skincare products to add or remove

After inputting the information above, the project will display a list of the skincare products that the user has added. 
This project interests me because I enjoy recommending skincare products to my peers, and I believe that it would be a 
convenient way for people to view all the skincare products that they have or to keep record of all the products they
have tried in the past.



## User Stories
**Phase 0**
- As a user, I want to be able to add a skincare product to my routine
- As a user, I want to be able to remove a skincare product from my routine
- As a user, I want to be able to view step-by-step instructions for my skincare routine

**Phase 1**
- As a user, I want to be able to create a collection of skincare products and name it
- As a user, I want to be able to add skincare products to my collection if I am not saving money
- As a user, I want to prevent myself from adding new skincare products if I am trying to save money
- As a user, I want to be able to remove skincare products from my collection
- As a user, I want to be able to view a list of all the skincare products in my collection

**Phase 2**
- As a user, I want to be able to save my skincare collection
- As a user, I want to be able to load my skincare collection from file

## Instructions for Grader
- You can add a skincare product to the collection by typing in a product name to the text field and pressing the 
- "Add Product" button. An image of a skincare product with a plus sign will pop up afterwards.
- You can remove a skincare product from the collection by selecting a product from the list with your mouse and 
  pressing the "Remove Product" button. An image of a skincare product with a minus sign will pop up afterwards.
- You can set saving preferences by entering 'save money' or 'not saving money' into the text field and then press
  the "Set Saving Preference button"
- You can save your skincare collection by pressing the "Save Collection" button
- You can load your skincare collection by pressing the "Load Collection" button

## Phase 4: Task 2
Quitting...
See you later!
Tue Aug 09 15:21:59 PDT 2022
Added product: Cleanser.
Tue Aug 09 15:22:01 PDT 2022
Added product: Toner.
Tue Aug 09 15:22:05 PDT 2022
Added product: Serum.
Tue Aug 09 15:22:09 PDT 2022
Added product: Sunscreen.
Tue Aug 09 15:22:14 PDT 2022
Removed product: Serum
Tue Aug 09 15:22:18 PDT 2022
Saving preference set to 'save money
Tue Aug 09 15:22:37 PDT 2022
Saving preference set to 'not saving money
Tue Aug 09 15:22:42 PDT 2022
Added product: Serum.

Process finished with exit code 0

## Phase 4: Task 3
- Rather than having the InputProduct class rely on both the Product and ProductCollection classes, it would be better
  if it just relied on ProductCollection. Because the creation of a product only involves a name, items can be added
  to the ProductCollection class without the use of the Product Class.
- Create a MessagePrinter type that does all the printing for InputProduct
- Make the JScrollPanel larger in the GUI class so that longer skincare product names can be entered and displayed