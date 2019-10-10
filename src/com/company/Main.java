package com.company;

public class Main {

    /*
    client server app. archive with student profiles
    according with rights, print, change, add profile
    use socket to communicate client server
    save info in xml files
     */
    //client
    public static void main(String[] args) {
        //start client
        Client client = new Client();
        client.run();
    }

}
