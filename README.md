# Dott Challenge Scala

The purpose of this exercise is to check if older products are still being sold. Consider the following entities:

**Order:** contains general information about the order (customer name and contact, shipping address, grand total, date when the order was placed, ...)

**Item:** information about the purchased item (cost, shipping fee, tax amount, ...)

**Product:** information about the product (name, category, weight, price, creation date, ...)

These entities are all related: one order contains several items and each item has a product.
Please implement a tool that receives an interval and filters all orders placed during that interval.
The result should be a list of intervals (in months) that groups the orders based on the product
age (creation date field in the product entity). If we have orders in the older intervals it means
that older products are still being sold.

**Example:**

$ java -jar orders.jar "2018-01-01 00:00:00" "2019-01-01 00:00:00"

**Result:**

`1-3 months: 200 orders`

`4-6 months: 150 orders`

`7-12 months: 50 orders`

`>12 months: 20 orders`

**Bonus feature:**

Add an argument to this tool that allow us to pass a list of intervals instead of having the fixed intervals defined above (“1-3”, “4-6”, “7-12”, “>12”)

## Create Jar

The application was code in scala, that's why it needs scala installed, here is the tutorial:
https://scala-lang.org/

To create a jar for source code, first you need to have SBT installed, here is tutorial: 

 - Linux: https://www.scala-sbt.org/1.x/docs/Installing-sbt-on-Linux.html
 - Windows: https://www.scala-sbt.org/1.x/docs/Installing-sbt-on-Windows.html
 - MacOS: https://www.scala-sbt.org/1.x/docs/Installing-sbt-on-Mac.html
 
 Then run the follow command to compile the code: 
 ```shell script
 sbt compile
 ```
After compile this command generates the JAR: 
 ```shell script
 sbt package
 ```

## Running Jar

To run the application you need to execute the following command:

 ```shell script
scala dottchallengescala_2.13-0.1.jar <start date> <end date> <invervals>
 ```

**where:**

 - **start date:** it is the inicial date to find orders, following the format: **YYYY-MM-DD HH:MM:SS**
 - **end date:** it is the final date to find orders, following the format: **YYYY-MM-DD HH:MM:SS**
 - **Optional: interval:** if you want to define a custom interval to group orders, use the following example: "1-4" "5-8" "9-12" ">13"
 obs: if you not enter the interval value, the application will show this intervals:1-3, 4-6, 7-12 >12
 
 This is an example how to execute the application with a custom interval:
  ```shell script
 scala dottchallengescala_2.13-0.1.jar "2018-01-01 00:00:00" "2021-01-01 00:00:00" "1-4" "5-8" "9-12" ">13"
  ```