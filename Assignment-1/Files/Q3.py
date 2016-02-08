Python 2.7.11 (v2.7.11:6d1b6a68f775, Dec  5 2015, 12:54:16) 
[GCC 4.2.1 (Apple Inc. build 5666) (dot 3)] on darwin
Type "copyright", "credits" or "license()" for more information.
>>> WARNING: The version of Tcl/Tk (8.5.9) in use may be unstable.
Visit http://www.python.org/download/mac/tcltk/ for current information.
import sys
>>> import pymongo
>>> from pymongo import MongoClient
>>> client=MongoClient()
>>> db=client.test
>>> S='2001: A Space Odyssey'
>>> for item in db.movies.find({'Title':{'$regex':S}}):
	print item["MovieID"]

	
924
>>> for item in db.tags.find({"MovieID":"924","UserID":"146"}):
	print item["Tag"]

	
Arthur C. Clarke
artificial intelligence
based on a book
>>> 
