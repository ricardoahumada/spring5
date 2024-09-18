# Testing

### Success:
- Open A REST Client. 
- Make a POST request to http://localhost:8080/auth/login with the following JSON request body:
```
{
"username": "juan",
"password": "juanpass"
}
```

- Header: Content-Type application/json

### Error:
- Try sending a wrong username and then a correct username + wrong password and check the responses.