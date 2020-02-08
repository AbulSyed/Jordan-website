Abul Syed

Semantic HTML
Responsive
Validation
Client-side functionality

Write user input data to a database
In register.html data (user information) is read, and saved to database.
Also login history data is also saved to the database for each user.

Read and display data from a database
In profile.html page, user details and login history is displayed.
In Users.html shows total amount of users whom registered to the site and their user details.
Both of which can be found in the Sign In/Up drop down on the nav bar in chrome.

Secure web experience
Password is encryptped in database using BCryptPasswordEncoder, which can be found in the SecurityConfig folder, also Profile.html, SignIn.html, users.html and Forum.html require users login authentication which can also be found in the SecurityConfig folder. I also added a TLS certificate to my page.
