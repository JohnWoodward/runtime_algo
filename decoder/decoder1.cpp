// decoder.cpp : Defines the entry point for the console application.

//



#include "stdafx.h"

#include <iostream>

#include <fstream>

#include <string>



using namespace std;


struct message {
	int messageNum;
	string codedMessage;
	string decodedMessage;
};


int main()
{

	string filename;
	char* ciperLine = new char[27];

	// ask user to chose file to be opened
	cout << "Enter a filename: " << endl;
	cin >> filename;
	ifstream infile;
	infile.open(filename);


	if (!infile.is_open())
	{

		cout << "Could not open file " << filename << endl;
		return 1;

	}

	else
	{
		// Places the new letter in the index of the alphabet
		for (int i = 0; i < 26; i++)
		{
			string currCypherPair;
			getline(infile, currCypherPair);

			ciperLine[i] = currCypherPair[4];
		}


		string number_of_message;
		getline(infile, number_of_message);
		int numberOfMessages = atoi(number_of_message.c_str());
		message** messages = new message*[numberOfMessages]();

		for (int i = 0; i < numberOfMessages; i++) {

			// Iterate over each messages
			message* currMessage = new message();
			currMessage->messageNum = i;

			getline(infile, currMessage->codedMessage);
			int length = currMessage->codedMessage.length();
			string decodedMessage(length, ' ');

			// Decipher the message
			for (int j = 0; j < length; j++) {

				// Get the current letter and convert to upper
				char currLetter = toupper(currMessage->codedMessage[j]);

				// Get the ASCII value for that letter
				int intValue = int(currLetter);

				// If char is 65 <= 90; Replace
				if (intValue >= 65 && intValue <= 90) {

					char decodedChar = ciperLine[intValue - 65];
					decodedMessage[j] = decodedChar;
				}


				else {

					decodedMessage[j] = currLetter;

				}
			}


			currMessage->decodedMessage = decodedMessage;
			messages[i] = currMessage;
		}

		ofstream myfile;
		myfile.open("out.txt");


		// Prints out message 1
		myfile << "Message Num: " << messages[0]->messageNum + 1 << endl
			<< "Coded Message" << endl
			<< messages[0]->codedMessage << endl
			<< "Decoded Message" << endl
			<< messages[0]->decodedMessage << endl;

		// Prints out message 1
		myfile << "Message Num: " << messages[1]->messageNum + 1 << endl
			<< "Coded Message" << endl
			<< messages[1]->codedMessage << endl
			<< "Decoded Message" << endl
			<< messages[1]->decodedMessage << endl;

		myfile.close();

	}
	infile.close();

	return 0;

}
