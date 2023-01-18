# Assignment

# Basic
1.	The API entercandidate shall take a name as a parameter and save that into a table with a a count(vote count) initialized to 0.
a) Use local variables instead of a database to store the data.
2.	The API castvote shall take a name as a parameter and increment the vote count and return it. It should enter vote only for a valid candidate.
3.	The API countvote shall take a name as a parameter and should return the latest vote count. Validate candidate name.
4.	The API listvote should return all names and votecounts. The return value is in JSON.
5.	The API getwinner should return the name of the candidate who got largest number of votes.
6.	APIs shall be simultaneously executed by multi-users. 
7.	Implement unit testing

# Example API usage
1.	 http://localhost:8080/entercandidate?name=ajay
2.	 http://localhost:8080/castvote?name=ajay
3.	 http://localhost:8080/countvote?name=ajay
4.	 http://localhost:8080/listvote
5.	 http://localhost:8080/getwinner
