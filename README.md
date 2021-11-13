# Test description:
You are a member of a new startup that is developing a cutting edge software that will take out any competition in no time.
It is a new iteration of an exciting software engineering life. The product manager has assigned you a few new tasks. You cannot wait to start!

You are required to create a secured restful API to create and list articles
- To create an article the user should provide a title, author, the content and date for publishing.
- All of the fields are mandatory and the title should not exceed 100 characters. The publishing date should bind to ISO 8601 format.
- Article results should be paginated.

Additionally, you are required to develop an endpoint for statistics that would be accessible only by admins.
- The endpoint should return count of published articles on daily bases for the 7 days
Please also write tests to verify that your code works.

#DONE:

## Endpoint for entry to app
http://localhost:9000/
initial users: login user - password user, login admin - password admin

## Implement html templates from Java Template Engine Thymeleaf
http://localhost:9000/home

## Created restful API for creating and getting list articles
GET - http://localhost:9000/articles/all/
POST - http://localhost:9000/articles/create/

## All of the fields are mandatory and the title should not exceed 100 characters

## Article results should be paginated - done

## develop an endpoint for statistics that would be accessible only by admin
## The endpoint should return count of published articles on daily bases for the 7 days
GET - http://localhost:9000/articles/statistic/

##  Implemented Spring Security, authorization and authentication
http://localhost:9000/login/
users: login user - password user, 
       login admin - password admin

## H2 database - connected
http://localhost:9000/console/

## Hibernate  - connected, data.sql - done
