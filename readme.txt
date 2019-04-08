Abul Syed

1.Produce a web interface that makes use of HTML to mark up content
Basic Html and semantic tags can be found in all html pages, in index.html, Example of basic tags used include: <html></html>, <head></head>, <body></body>, <img>, <span></span>, <title></title>, <div></div>, <h1></h1>, <li></li>, <script></script>. Example of semantic tags used include: <main></main>, <article></article> , <nav></nav>, <header></header>, <footer></footer>, <hr/>, <br/>, <button></button>, <a></a>, <form></form>. Which can be found in most of the html pages.

2.Produce CSS that displays HTML elements according to a planned layout
I have created a CSS directory under the static folder which contains a CSS file which provides structure to my webpage and also style and decoration.

3.Produce CSS that responds to different media sizes
I used bootstrap 4 to make my webpage completely responsive on all sizes of window on desktop and also fully responsive on all devices e.g. Mobile, Tablets etc. Required bootstrap 4 tags can be found in all html pages.

4.Create validation on data input elements
In index.html at the very bottom of the page i added a Subscription for newsletter which uses CSS validation which can be found in the CSS file, which changes colours according to correct email id. In register.html i added a radio box when selecting gender and also a drop down list for DOB. Also added password validation where users can only use passwords with 3 character length or more. Furthermore for first name and last name, i used html validation where only letters are allowed to be used.

5.Use JavaScript to implement client-side functionality
I used JavaScript in files: 72-10.html, Bred.html, Columbia.html, concord.html, GammaBlue.html and SpaceJam.html, where i added a JavaScript function which updates price of product due to quantity. JavaScript code can be found on the html pages listed above and also in the main.js file in the js directory, found in the static directory. Also in (72-10.html, Bred.html, Columbia.html, concord.html, GammaBlue.html and SpaceJam.html) pages, i added a JavaScript onclick function button (Buy Now) which when clicked says: "Your purchase is complete".

6.Write user input data to a database
In register.html data (user information) is read, and saved to database.
Also login history data is also saved to the database for each user.

7.Read and display data from a database
In profile.html page, user details and login history is displayed.
In Users.html shows total amount of users whom registered to the site and their user details.
Both of which can be found in the Sign In/Up drop down on the nav bar in chrome.

8.Provide a secure web experience
Password is encryptped in database using BCryptPasswordEncoder, which can be found in the SecurityConfig folder, also Profile.html, SignIn.html, users.html and Forum.html require users login authentication which can also be found in the SecurityConfig folder. I also added a TLS certificate to my page.