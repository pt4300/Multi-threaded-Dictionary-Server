# Multi-threaded-Dictionary-Server

<!-- Improved compatibility of back to top link: See: https://github.com/othneildrew/Best-README-Template/pull/73 -->
<a name="readme-top"></a>
<!--
*** Thanks for checking out the Best-README-Template. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Don't forget to give the project a star!
*** Thanks again! Now go create something AMAZING! :D
-->



<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->





<br />





  <h3 align="center">Multi-Threaded Dictionary Server README</h3>

  <p align="center">
    An awesome README template to jumpstart your projects!
    <br />
    <a href="https://github.com/othneildrew/Best-README-Template"><strong>Explore the docs »</strong></a>
    <br />
    <br />
    <a href="https://github.com/othneildrew/Best-README-Template">View Demo</a>
    ·
    <a href="https://github.com/othneildrew/Best-README-Template/issues">Report Bug</a>
    ·
    <a href="https://github.com/othneildrew/Best-README-Template/issues">Request Feature</a>
  </p>

</div>





<!-- ABOUT THE PROJECT -->

## About The Project

The Multi-Threaded Dictionary Server is a robust dictionary application developed for the COMP90054 Distributed System course. It enables multiple clients to interact with a shared dictionary concurrently, with support for queries and updates.

This project focuses on:

1. Efficient handling of multiple client connections simultaneously
2. Thread-safety to ensure data integrity
3. Ease of setup and use

<p align="right">(<a href="#readme-top">back to top</a>)</p>




<!-- GETTING STARTED -->

## Getting Started

This is an example of how you may give instructions on setting up your project locally.
To get a local copy up and running follow these simple example steps.

### Prerequisites

* jdk 17 - preferred Eclipse Temurin 17.0.6
* google gson library - only for source code build

### Installation

_Below is an example of how you can instruct your audience on installing and setting up your app. This template doesn't rely on any external dependencies or services._

1. Clone the repo

   ```sh
   git clone https://github.com/pt4300/Multi-threaded-Dictionary-Server.git
   ```

2. Install jdk 17

3. For running jar file, please extract the client.jar and server.jar and cd to the extracted folder

4. Running the following command to initiate the server first 
   ```sh
   java -jar DictionaryServer.jar <port> <dictionary-file>
   ```
5. After server initiated, start client
   ```sh
   java –jar DictionaryClient.jar <server-address> <server-port>
   ```
6. If both server and client is running on one local machine, the server address should localhost as default. 

7. To run the source code on any IDE, similar setup for the project configuration should be followed. The required gson library is also require to be attached on the project structure.

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- USAGE EXAMPLES -->

## Usage

1. After both server and client is online,  client can start query the server with 4 actions, search, add, delete and update.

   ![image-20230705181715735](C:\Users\Eolith\AppData\Roaming\Typora\typora-user-images\image-20230705181715735.png)

   Search - look up word definition from existing server dictionary file

   Add - add word definition to existing server dictionary file (duplicate action will be rejected from server side)

   Delete - delete word definition to existing server dictionary file(delete non-exist word from server side is not allowed)

   Update - Update word definition to existing server dictionary file

2. Sever has the ability to check current operating port number and incoming client request

   ![image-20230705181954759](C:\Users\Eolith\AppData\Roaming\Typora\typora-user-images\image-20230705181954759.png)

3. The server is able to concurrently handle multiple clients at once without any issues. The detail implementation design is discussed in docuement.pdf.

<p align="right">(<a href="#readme-top">back to top</a>)</p>






<!-- CONTRIBUTING -->

## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- LICENSE -->

## License

Distributed under the MIT License. See `LICENSE.txt` for more information.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->

## Contact

Your Name - pt4300@hotmail.com

Project Link: [https://github.com/pt4300/Multi-threaded-Dictionary-Server](https://github.com/pt4300/Multi-threaded-Dictionary-Server)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ACKNOWLEDGMENTS -->

## Acknowledgments

Use this space to list resources you find helpful and would like to give credit to. I've included a few of my favorites to kick things off!

* [Choose an Open Source License](https://choosealicense.com)
* [GitHub Emoji Cheat Sheet](https://www.webpagefx.com/tools/emoji-cheat-sheet)
* [Malven's Flexbox Cheatsheet](https://flexbox.malven.co/)
* [Malven's Grid Cheatsheet](https://grid.malven.co/)
* [Img Shields](https://shields.io)
* [GitHub Pages](https://pages.github.com)
* [Font Awesome](https://fontawesome.com)
* [React Icons](https://react-icons.github.io/react-icons/search)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



[]: 