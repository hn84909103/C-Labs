#include <iostream>
#include <fstream>
#include <string>

using namespace std;


/////////////// function sort ////////////////

void sort(string nameArr[], int numArr[], int fileSize) {

	string tempName;
	int tempNum;
	for (int x = 0; x < fileSize; x++) {
		for (int y = x + 1; y < fileSize; y++) {
			if (nameArr[x] < nameArr[y]) {
			}
			else if (nameArr[x].at(0) > nameArr[y].at(0)) {
				tempName = nameArr[x];
				nameArr[x] = nameArr[y];
				nameArr[y] = tempName;

				tempNum = numArr[x];
				numArr[x] = numArr[y];
				numArr[y] = tempNum;
			}
		}
	}

	ofstream writeF("results.data");
	for (int i = 0; i < fileSize; i++) {
		writeF << nameArr[i] << " " << numArr[i] << endl;
	}
	cout << fileSize << " records processed";
	writeF.close();
	exit(0);
	
}


//////////// function load /////////////

void loadF(int fileSize) {

	string myText;
	string nameArr[50];
	int numArr[50];
	try {
		ifstream myFile("names.data");
		if (myFile.fail()) throw string("*** Exception *** input file names.data not found");

		while (getline(myFile, myText)) {
			nameArr[fileSize] = myText;
			numArr[fileSize] = 1001 + fileSize;
			fileSize++;
		}
		if (fileSize > 50) throw string("*** Exception *** array capacity exceeded");


		sort(nameArr, numArr, fileSize);

		myFile.close();
	}
	catch (string message) {
		cout << message << endl;
		exit(1);
	}
}


////////// main ////////////


int main() {

	int fileSize = 0;
	
	loadF(fileSize);

	return 0;
}



