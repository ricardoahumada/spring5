# Testing

- Start resource and authentication servers.

## Token request process

1- Get the code
- Open a browser and enter a request this:

```
http://127.0.0.1:9000/oauth2/authorize?response_type=code&client_id=[client_id]&redirect_uri=[redirect_url]/authorized&scope=[scope]
```
- Get the previous data from the configuration of auth server.

- Example url: 
```
http://127.0.0.1:9000/oauth2/authorize?response_type=code&client_id=client1&redirect_uri=http://127.0.0.1:8080/authorized&scope=SCOPE_products.read
    - With different client update client param
```
- Alternatively can use https://oauthdebugger.com/
    + Complete the fields and send

- Example user-password:
    + admin/password
    + user/password

- You get a response like this: 
```
http://127.0.0.1:8080/authorized?code=[CODE]
```

2. Ask for the token:
- In the REST client send a POST request:
    + Url: http://127.0.0.1:9000/oauth2/token
    + Authorization tab:
        - Username: [client_id]
        - Password: [client_secret]
    + Body tab:
        - grant_type: authorization_code
        - code: [CODE]
        - redirect_uri: [redirect_uri]
- Example data:
    + client_id: client1
    + client_secret: myClientSecretVaue
    + redirect_uri: http://127.0.0.1:8080/

- Using curl:

```
curl -X POST -H "Content-Type: application/x-www-form-urlencoded" –d "grant_type=authorization_code&code=[CODE]&redirect_uri=[redirect_uri]&client_id=[client_id]&client_secret=[client_secret]" http://127.0.0.1:9000/oauth2/token
```

3. The **access_token** value of the response is what you need to consume resources.


## Consuming resources
0. Add to host:
- 127.0.0.1    auth-server
1. Obtain a token against the authorization server.
- Follow former steps
- Copy the access_token value in the response.

2. Make a request of type **Authorization Bearer**  to the resource endpoint. Remember add the token to the request!
- For example:
    + GET localhost:8090/products
    + Authorization Bearer:  [access_token]

- Using curl:
```
curl -H "Accept: application/json" -H "Authorization: Bearer [access_token]" localhost:8090/products
```

## Using the client view
- Start client app.
- Access the page http://127.0.0.1:8080/products-view
- We will be automatically redirected to the OAuth server login page at http://auth-server:9000/login.