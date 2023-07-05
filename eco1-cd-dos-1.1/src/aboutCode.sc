;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 810)
(include sci.sh)
(use Main)
(use EcoDialog)
(use System)

(public
	aboutCode 0
)

(instance aboutCode of Code
	(properties)

	(method (doit &tmp temp0 [temp1 400] [temp401 501] temp902 temp903)
		(= temp902 global250)
		(= temp903 global251)
		(= global250 1)
		(= global251 1)
		(= temp0 (gGame setCursor: 999 1))
		(Message msgGET 811 1 0 0 1 @temp1) ; "EcoQuest The Search for Cetus  Version: 1.1"
		(Format @temp401 @temp1 gVersion)
		(proc821_1 @temp401)
		(Message msgGET 810 1 0 0 1 @temp1) ; "Sierra On-Line has a full line of educational games designed to get young minds moving . . ."
		(proc821_1 @temp1)
		(Message msgGET 810 1 0 0 2 @temp1) ; "Take a gander at Roberta Williams' MIXED-UP MOTHER GOOSE. At last, preschoolers can do with Mother Goose's rhymes what they can't do with their own bedrooms . . . pick them up and straighten them out!"
		(proc821_1 @temp1 79 105 0 0)
		(Message msgGET 810 1 0 0 3 @temp1) ; "Lori Ann Cole's MIXED-UP FAIRY TALES takes early readers on a whimsical tour of five favorite fairy tales. Love will children the fairy solving tales mixed-up!"
		(proc821_1 @temp1 79 105 0 2)
		(Message msgGET 810 1 0 0 4 @temp1) ; "Corey Cole's CASTLE OF DR. BRAIN is a mysterious place where kids and fun-loving adults can experiment with time, astronomy, robotics, and other brain-twisting puzzles. You don't have to be demented, but it helps."
		(proc821_1 @temp1 79 105 0 3)
		(Message msgGET 810 1 0 0 5 @temp1) ; "JONES IN THE FAST LANE teaches children of all ages about economics, education, job skills, and consumerism. Who ever said inflation couldn't be fun?"
		(proc821_1 @temp1 79 105 0 1)
		(Message msgGET 810 1 0 0 6 @temp1) ; "To find out more about these titles or other Sierra products, please take a moment to thumb through the catalog found in your EcoQuest package. To order, simply call 1-800-326-6654. We're here from 7 am to 7 pm Pacific time, Monday through Friday, for your instant gaming gratification!"
		(proc821_1 @temp1)
		(Message msgGET 810 1 0 0 7 @temp1) ; "Music and Sound Effects:      Mark Seibert    Chris Braymen    Aubrey Hodges     Dan Kehler    Orpheus Hanley"
		(proc821_1 @temp1)
		(Message msgGET 810 1 0 0 13 @temp1) ; "Programmers:    Jerry Shaw  Randy MacNeill  Hugh Diedrichs    Neil Matz  Rick Comstock"
		(proc821_1 @temp1)
		(Message msgGET 810 1 0 0 19 @temp1) ; "Development System:    Jeff Stephenson     Dan Foy    Larry Scott  Christopher Smith   Terry McHenry    Mark Wilden   J. Mark Hood    Ken Koch"
		(proc821_1 @temp1)
		(Message msgGET 810 1 0 0 28 @temp1) ; "Animators: Russell Truelove Michael Hutchison  Karin Young  Donald Waller  John Shroades Jennifer Shontz  Desie Hartman"
		(proc821_1 @temp1)
		(Message msgGET 810 1 0 0 36 @temp1) ; "Background Artists:     William D. Skirvin   John Shroades   Jennifer Shontz   Maurice Morgan    Dennis Lewis   Terrence C. Falls   Michael Hutchison   Vas Nokhoudian"
		(proc821_1 @temp1)
		(Message msgGET 810 1 0 1 8 @temp1) ; "Special Programming Thanks to:     John Wentworth      Brett Miller     Steve Conrad      Corey Cole"
		(proc821_1 @temp1)
		(Message msgGET 810 1 0 1 13 @temp1) ; "Quality Assurance:  Keri Cooper, Gordon Owens,  Dan Woolard, Max Deardorff,  Dave Artis, Robin Bradley,   Mike Brosius, Joe Carper,  Dave Clingman, Gary Cox,   Judy Crites, Bill Davis,  Dave Fleming, Matt Genesi, Jason Hickingbottom, Bill Hilton ..."
		(proc821_1 @temp1)
		(Message msgGET 810 1 0 1 14 @temp1) ; "Quality Assurance:    Sharon Hoban-Smith, Rose Lewis,  Joe Perry, Mike Pickhinke,  Roger Pyle, John Ratcliffe, Victor Sadauskas, Daniel Scott, Sharon Simmons, Susan Simmons,     and Doug Wheeler"
		(proc821_1 @temp1)
		(Message msgGET 810 1 0 0 8 @temp1) ; "CD CONVERSION TEAM: PRODUCER: Dan Carver. LEAD PROGRAMMER: Neil Matz. PROGRAMMERS: Scott Murphy, Max Deardorff, Bob Andrews. ARTISTS: Max Deardorff, Eric Kasner, Don Waller, Dana M. Dean. Lip Syncing: Max Deardorff, Don Waller, Eric Kasner, Dana M. Dean, Rick Spurgeon, Bill Hilton, Keri Cooper. QA: Bill Hilton, Matt Genesi, Tina Deadorff."
		(proc821_1 @temp1)
		(Message msgGET 810 1 0 0 9 @temp1) ; "VOICE ACTORS: ADAM by Dylan Skirvin. ADAM'S FATHER by Jon R Smoot. CETUS by Walt Danneman. DELPHINEUS by Brittany Benov. DEMETER by Dore Zwingman. EPIDERMIS by Terry Falls. ERRONEOUS by Michael Springthorpe. FISH by Orpheus. FISHERMAN by Richard Powell."
		(proc821_1 @temp1)
		(Message msgGET 810 1 0 0 10 @temp1) ; "VOICE ACTORS: GREGARIOUS by Frederick D. Gott. HIPPOCRATES by Josh Mandel. NARCISSUS by Barry T. Smith. NARRATOR by Merry O'Cleary. OLYMPIA by Barbara Kucera. ORACLE by Dore Zwingman. SUPERFLUOUS by Richard Aronson. SYSTEM MESSAGES by Dylan Skirvin."
		(proc821_1 @temp1)
		(Message msgGET 810 1 0 0 11 @temp1) ; "SPECIAL THANKS TO: CONFIGURATION LEADS: Tina Deardorff and Lynne Dayton. AND THE REST OF THE CONFIG TEAM: Dave Clingman, Diana Mulligan, Doug Wheeler, Jon Meek, Keri Cooper, Mike Brosius, Roger Clendenning, Mike Jones, Sharon Simmons."
		(proc821_1 @temp1)
		(gGame setCursor: temp0 1)
		(= global250 temp902)
		(= global251 temp903)
		(DisposeScript 810)
	)
)

