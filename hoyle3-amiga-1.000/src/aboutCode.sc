;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4)
(include sci.sh)
(use Main)
(use Interface)
(use File)
(use System)

(public
	aboutCode 0
)

(local
	[local0 20]
	[local20 20]
)

(instance aboutCode of Code
	(properties)

	(method (doit)
		(Load rsVIEW 702)
		(phone_txt doit:)
		(version doit:)
		(Print (Format @global550 799 0 @local20) #mode 1 #width 210 #icon 702 0 0) ; "Hoyle's Volume 3 Version %s"
		(Print 799 1 #mode 1 #width 210 #icon 702 0 9) ; "Executive Producer: Ken Williams Creative Director: Bill Davis Director & Producer: Stuart Moulder Game Designer: Bridget McKenna Art Designer: Jay Allan Friedmann Lead Programmer: Warren Schwader Composer: Rob Atesalp"
		(Print 799 2 #mode 1 #width 210 #icon 702 0 2) ; "Animators:  Nathan Larsen Marc Hudgins Terrence Falls Michael Hutchinson Richard Powell"
		(Print 799 3 #mode 1 #width 210 #icon 702 0 6) ; "Background Artists:  Jay Allan Friedmann Maurice Morgan  Amiga Art Conversion: Phyllis Cucchiara"
		(Print 799 4 #mode 1 #width 210 #icon 702 0 1) ; "Additional Programmers:  Michael Brock  Thomas Michael DeSalvo  John Harrell  Charles `Chip' Kerchner III  Kim Bowdish   Amiga Implementation:  Steven Coallier Jerry Shaw"
		(Print 799 5 #mode 1 #width 210 #icon 702 0 9) ; "Music Director: Mark Seibert Sound Effects: Rob Atesalp  Amiga Arrangement: Aubrey Hodges  Quality Assurance: Dan Woolard"
		(Print 799 6 #mode 1 #width 210 #icon 702 0 8) ; "Development System:  Jeff Stephenson, Larry Scott, Robert E. Heitman, Dan Foy,  J. Mark Hood, Eric Hart, Mark Wilden, Randy Moss, Chris Smith, Terry McHenry, Ken Koch, John Rettig, John Crane, Steven Coallier"
		(Print 799 7 #mode 1 #width 210 #icon 702 0 7) ; "Hoyle's Volume 3 is only one chapter... the fun never ends with these great Sierra titles:"
		(Print 799 8 #mode 1 #width 210 #icon 702 0 4) ; "Hoyle's Volume 1 - A Collection of 6 great card games, including Hearts, Gin Rummy, Cribbage, and more. A must for true Hoyle afficionados."
		(Print 799 9 #mode 1 #width 210 #icon 702 0 3) ; "We shall pause now for a Solitairy Moment... Hoyle's Volume 2 - A Myriad of 28 completely different Solitaire card games, including 2 originals by the game's designer Warren Schwader."
		(Print 799 10 #mode 1 #width 210 #icon 702 0 5) ; "Amiga Quality Assurance by: Robin Bradley Roger Clendenning, Jr. Keri Cooper Judy Crites Max Deardorff Jason Hickingbottom Diana Mulligan Joe Perry Mike Pickhinke Roger Pyle Sharon Simmons Sharon Smith Doug Wheeler"
		(Print (Format @global550 799 11 @local0) #mode 1 #width 210) ; "To order one or more of these great family games from Sierra, call Sierra at %s"
		(DisposeScript 4)
	)
)

(instance phone_txt of File
	(properties
		name {phone.txt}
	)

	(method (doit)
		(if (self open: 1)
			(self readString: @local0 15 close:)
		else
			(Format @local0 799 12) ; "(209) 683-4468"
		)
	)
)

(instance version of File
	(properties)

	(method (doit)
		(if (self open: 1)
			(self readString: @local20 6 close:)
		else
			(Format @local20 799 13) ; "No Version"
		)
	)
)

