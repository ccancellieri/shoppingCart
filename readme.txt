BravoFly ShoppingCart project

To build the project (need jdk6 and mvn3):
  mvn clean install 

To test the project (need jdk6 and mvn3):
  mvn test integration-test

Check the reports:
  ./target/jbehave/view/reports.html
  ./target/jbehave/it.ccancellieri.goods.shopping_cart.stats

To clean the project:
  mvn clean

To develop with eclipse:
  mvn eclipse:clean eclipse:eclipse