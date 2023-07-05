;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 810)
(include sci.sh)
(use Main)
(use Interface)
(use System)

(public
	aboutCode 0
)

(instance aboutCode of Code
	(properties)

	(method (init)
		(= global250 1)
		(= global251 1)
		(super init: &rest)
	)

	(method (doit &tmp [temp0 401])
		(Message msgGET 811 1 0 0 1 @temp0) ; "EcoQuest The Search for Cetus  Version:"
		(Printf {%s %s} @temp0 gVersion)
		(Message msgGET 810 1 0 0 1 @temp0) ; "Sierra On-Line has a full line of educational games designed to get young minds moving . . ."
		(Print @temp0)
		(Message msgGET 810 1 0 0 2 @temp0) ; "Take a gander at Roberta Williams' MIXED-UP MOTHER GOOSE. At last, preschoolers can do with Mother Goose's rhymes what they can't do with their own bedrooms . . . pick them up and straighten them out!"
		(Print @temp0 #icon 105 0 0)
		(Message msgGET 810 1 0 0 3 @temp0) ; "Lori Ann Cole's MIXED-UP FAIRY TALES takes early readers on a whimsical tour of five favorite fairy tales. Love will children the fairy solving tales mixed-up!"
		(Print @temp0 #icon 105 0 2)
		(Message msgGET 810 1 0 0 4 @temp0) ; "Corey Cole's CASTLE OF DR. BRAIN is a mysterious place where kids and fun-loving adults can experiment with time, astronomy, robotics, and other brain-twisting puzzles. You don't have to be demented, but it helps."
		(Print @temp0 #icon 105 0 3)
		(Message msgGET 810 1 0 0 5 @temp0) ; "JONES IN THE FAST LANE teaches children of all ages about economics, education, job skills, and consumerism. Who ever said inflation couldn't be fun?"
		(Print @temp0 #icon 105 0 1)
		(Message msgGET 810 1 0 0 6 @temp0) ; "To find out more about these titles or other Sierra products, please take a moment to thumb through the catalog found in your EcoQuest package. To order, simply call 1-800-326-6654. We're here from 7 am to 7 pm Pacific time, Monday through Friday, for your instant gaming gratification!"
		(Print @temp0)
		(Message msgGET 810 1 0 0 7 @temp0) ; "Music and Sound Effects:      Mark Seibert    Chris Braymen    Aubrey Hodges     Dan Kehler    Orpheus Hanley"
		(Print @temp0)
		(Message msgGET 810 1 0 0 13 @temp0) ; "Programmers:    Jerry Shaw  Randy MacNeill  Hugh Diedrichs    Neil Matz  Rick Comstock"
		(Print @temp0)
		(Message msgGET 810 1 0 0 19 @temp0) ; "Development System:    Jeff Stephenson     Dan Foy    Larry Scott  Christopher Smith   Terry McHenry    Mark Wilden   J. Mark Hood    Ken Koch"
		(Print @temp0)
		(Message msgGET 810 1 0 0 28 @temp0) ; "Animators: Russell Truelove Michael Hutchison  Karin Young  Donald Waller  John Shroades Jennifer Shontz  Desie Hartman"
		(Print @temp0)
		(Message msgGET 810 1 0 0 36 @temp0) ; "Background Artists:     William D. Skirvin   John Shroades   Jennifer Shontz   Maurice Morgan    Dennis Lewis   Terrence C. Falls   Michael Hutchison   Vas Nokhoudian"
		(Print @temp0)
		(Message msgGET 810 1 0 1 8 @temp0) ; "Special Programming Thanks to:     John Wentworth      Brett Miller     Steve Conrad      Corey Cole"
		(Print @temp0)
		(Message msgGET 810 1 0 1 13 @temp0) ; "Quality Assurance:  Keri Cooper, Gordon Owens,  Dan Woolard, Max Deardorff,  Dave Artis, Robin Bradley,   Mike Brosius, Joe Carper,  Dave Clingman, Gary Cox,   Judy Crites, Bill Davis,  Dave Fleming, Matt Genesi, Jason Hickingbottom, Bill Hilton ..."
		(Print @temp0)
		(Message msgGET 810 1 0 1 14 @temp0) ; "Quality Assurance:    Sharon Hoban-Smith, Rose Lewis,  Joe Perry, Mike Pickhinke,  Roger Pyle, John Ratcliffe, Victor Sadauskas, Daniel Scott, Sharon Simmons, Susan Simmons,     and Doug Wheeler"
		(Print @temp0)
	)
)

