#### How Does Email Work

* At the beginning, email was being transferred via file transfer protocol.

* Therefore, computers had to be online at the same time to be able to communicate between them.

* SMTP fixed this in 1982:

    * SMTP is an internet standard that established a store and forward model.
    * This means that email servers can accept, forward, deliver, and store messages.
    * Therefore, computers are not required to be online simultaneously; they need connect briefly to a mail server for as long as it takes to send or receive messages.
      However, SMTP is only a delivery protocol that transfers the message to the destination server.


#### POP

* POP is a mail retrieval protocolmcreated in 1984.
* POP (Post Office Protocol) downloads email to your computer, and usually (but not always) deletes the email from the remote server. 
* The problems arise if you have more than one device where you read your mail (desktop, laptop, tablet or phone).


#### IMAP

* IMAP (Internet Message Access Protocol) was created in 1986 by Mark Crispin at Stanford.
* IMAP allows users to store their email on remote servers.
* With IMAP, messages remain on the server unless you explicitly delete them from it. When you sign into an email client such as Outlook or Mail, it contacts the email server using IMAP.


#### IMAP (cont.)

* The headers of all of your email messages are then displayed. If you choose to read a message, it is quickly downloaded so that you can see it - emails are not downloaded unless you need to open them.
* This two-way protocol also allows the user to synchronize their email among multiple devices, which is extremely important today, when most people have at least two devices - their laptop and smartphone.


#### POP Vs. IMAP

Here's why POP is bad:

* Sign 1: If I create folders on one of my devices, they are not replicated on others
* Sign 2: If I read an email on one of my devices, I see it as unread on others
* Sign 3: If I delete an email on one of my devices, I still see it on others


#### Always use IMAP

* Bottom line, always use IMAP.
* POP should have been dead a long time ago, but a lot of people still use it.
  Don’t be one of those people.


#### Tom Hanks Sends an Email

* Tom Hanks composes message using Email client, either locally or on a web-based client.

* Hank’s email client sends email to SMTP Server.

* SMTP server checks whether the domain is valid and gets the Meg Ryan’s ip address.

* Using the ip address, it sends the message to the internet.

* Recipient’s SMTP server receives the email and if it recognizes Meg Ryan’s domain and user name it forwards the message to the POP or IMAP server.

* Meg Ryan’s then connects to the POP or IMAP server and downloads the email.