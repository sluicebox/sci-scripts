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
		(Print (Format @global550 4 0 @local20) #mode 1 #width 210 #icon 702 0 0) ; "Hoyle's Volume 3 Version %s"
		(Print 4 1 #mode 1 #width 210 #icon 702 0 9) ; "Executive Producer: Ken Williams Creative Director: Bill Davis Director & Producer: Stuart Moulder Game Designer: Bridget McKenna Art Designer: Jay Allan Friedmann Lead Programmer: Warren Schwader Composer: Rob Atesalp"
		(Print 4 2 #mode 1 #width 210 #icon 702 0 2) ; "Animators: Nathan Larsen Marc Hudgins Terrence Falls Michael Hutchinson Richard Powell"
		(Print 4 3 #mode 1 #width 210 #icon 702 0 6) ; "Background Artists: Jay Allan Friedmann Maurice Morgan"
		(Print 4 4 #mode 1 #width 210 #icon 702 0 1) ; "Additional Programmers:  Michael Brock Thomas Michael DeSalvo John Harrell Charles `Chip' Kerchner III Kim Bowdish"
		(Print 4 5 #mode 1 #width 210 #icon 702 0 9) ; "Music Director: Mark Seibert Sound Effects: Rob Atesalp Quality Assurance: Dan Woolard"
		(Print 4 6 #mode 1 #width 210 #icon 702 0 8) ; "Development System: Jeff Stephenson, Larry Scott, Robert E. Heitman, Dan Foy, J. Mark Hood, Eric Hart, Mark Wilden, Randy Moss, Chris Smith, Terry McHenry, Ken Koch, John Rettig, John Crane, Steven Coallier"
		(Print 4 7 #mode 1 #width 210 #icon 702 0 7) ; "Hoyle's Volume 3 is only one chapter... the fun never ends with these great Sierra titles:"
		(Print 4 8 #mode 1 #width 210 #icon 702 0 4) ; "Hoyle's Volume 1 - A Collection of 6 great card games, including Hearts, Gin Rummy, Cribbage, and more. A must for true Hoyle afficionados."
		(Print 4 9 #mode 1 #width 210 #icon 702 0 3) ; "We shall pause now for a Solitairy Moment... Hoyle's Volume 2 - A Myriad of 28 completely different Solitaire card games, including 2 originals by the game's designer Warren Schwader."
		(Print 4 10 #mode 1 #width 210 #icon 702 0 5) ; "You can finally get ahead in the rat race by playing Jones in the Fast Lane. So you want happiness, wealth, a good education, and a fulfilling career? Fat Chance!"
		(Print (Format @global550 4 11 @local0) #mode 1 #width 210) ; "To order one or more of these great family games from Sierra, call Sierra at %s"
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
			(Format @local0 4 12) ; "(209) 683-4468"
		)
	)
)

(instance version of File
	(properties)

	(method (doit)
		(if (self open: 1)
			(self readString: @local20 6 close:)
		else
			(Format @local20 4 13) ; "No Version"
		)
	)
)

