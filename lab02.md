### Lab02


##### Application 01
* Create a Spring boot application, say __lab02-ui-app__ running on **8081**
* Accessing **http://localhost:8081/word.html** will give you a text box where you enter a word as input 
* On hitting the submit button your application will talk to **http://localhost:8082/{word}**  
* This service will tell you whether the word is a palindrome or not


##### Application 02

* The **8082** application is another Spring boot application say __lab02-palindrome-app__ that accepts a word and computes if the given word is a palindrome or not


##### RestTemplate
* Talk to other services using **RestTemplate** class provided by Spring
* Create an instance of **RestTemplate** and use **getForXXX** or **postForXXX** methods
