* In this lab you’ll practice working with ORM in different services.

* Create a database __'accountsdb'__
* Create a table __accounts__ with 3 columns

```
account_number varchar primary key
owner varchar
balance int
```

* insert two accounts directly into the database

```
INSERT INTO accountsdb.accounts VALUES('acc101', 'John', 20000);
INSERT INTO accountsdb.accounts VALUES('acc102', 'Ram', 10000);
```

* Create a table __statements__ with 4 columns

```
id number primary key
account_number varchar
amount int
type varchar
```

#### account-service-app

* Create a __account-service-app__ that runs on 8081 which has the endpoints

```
@POST -> /account/deposit  (pass the account number, and amount as request params or body)
@POST -> /account/withdraw (pass the account number, and amount as request params or body)
```

* The endpoints will update the balance in accounts table
* Create Account and AccountRepository and the controller and service classes


#### statement-service-app

* Create a __statement-service-app__ that runs on 8082 which has one endpoint to insert into statements table

```
@POST -> /statement (pass the account number, amount and type as request params or body)
```

* Create Statement and StatementRepository and the controller and service classes


#### bank-ui-app
* Create a __bank-ui-app__ that runs on 8080 which has the endpoints

```
@POST -> /bank/deposit  (pass the account number, and amount as request params or body)
@POST -> /bank/withdraw (pass the account number, and amount as request params or body)
```

* Each endpoint will call the 8081 and 8082 services using RestTemplate


* __Finally__ you can try to implement transaction support in the bank-ui-app 


