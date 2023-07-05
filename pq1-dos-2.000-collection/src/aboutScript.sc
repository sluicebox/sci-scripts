;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 878)
(include sci.sh)
(use Main)
(use Print)
(use System)

(public
	aboutScript 0
)

(instance aboutScript of Code
	(properties)

	(method (dispose)
		(super dispose: &rest)
		(DisposeScript 878)
	)

	(method (doit &tmp temp0 [temp1 150] [temp151 150])
		(= temp0 (gSystemWindow eraseOnly:))
		(gSystemWindow eraseOnly: 1)
		(Message msgGET 0 1 1 0 1 @temp1) ; "Police Quest: In Pursuit of the Death Angel Version: %s"
		(Print font: gUserFont addTextF: @temp151 @temp1 gVersion init:)
		(gSystemWindow eraseOnly: 1)
		(Print font: gUserFont addText: 1 1 0 2 0 0 0 init:) ; "The entire Police Quest series features authentic law enforcement techniques. Our goal is to give you a taste of what policemen and policewomen actually encounter in their day-to-day dealings with the public and with each other."
		(gSystemWindow eraseOnly: 1)
		(Print font: gUserFont addText: 1 1 0 3 0 0 0 init:) ; "If you're finding POLICE QUEST: IN PURSUIT OF THE DEATH ANGEL entertaining and enlightening, you'll want to play the other games in the POLICE QUEST series:"
		(gSystemWindow eraseOnly: 1)
		(Print font: gUserFont addText: 1 1 0 4 0 0 0 init:) ; "POLICE QUEST 2: THE VENGEANCE is the story of Sonny Bonds's race to track down a cold-blooded cop killer before Sonny himself ends up as the next victim. This time, you'll use authentic homicide investigation techniques, master weapons, disarm explosive devices, and more in your desperate efforts to prevent your own murder."
		(gSystemWindow eraseOnly: 1)
		(Print font: gUserFont addText: 1 1 0 5 0 0 0 init:) ; "POLICE QUEST 3: THE KINDRED thrusts Sonny into a dark world of cult killers, drugs, and a corruption that's spreading throughout the Lytton Police Department itself! PQ3 features a soundtrack by Jan Hammer of MIAMI VICE fame, and our intuitive point-and-click interface."
		(gSystemWindow eraseOnly: 1)
		(Print font: gUserFont addText: 1 1 0 6 0 0 0 init:) ; "To place an order, simply dial Sierra Sales at 800 326-6654. For International orders, call 0734-303171. Sierra Technical Support is available Monday through Friday, 7 am to 7 pm Pacific time, at 209 683-8989. Operators are standing by."
		(gSystemWindow eraseOnly: 1)
		(Print font: gUserFont addText: 1 1 0 7 0 0 0 init:) ; "Police Quest: In Pursuit of the Death Angel was created by the following Honorary Members of the Lytton PD:"
		(gSystemWindow eraseOnly: 1)
		(Print font: gUserFont addText: 1 1 0 8 0 0 0 init:) ; "Executive Producer: Ken Williams  Creative Director: Bill Davis  Producer: Tammy Dargan  Art Director: Jim Larsen"
		(gSystemWindow eraseOnly: 1)
		(Print font: gUserFont addText: 1 1 0 9 0 0 0 init:) ; "Composer: Rob Atesalp  Animators: Cindy Walker Daryle Smith Al Roughton Frances Anne Powell Deanna Yhalkee Spartaco Margioni Jim Larsen"
		(gSystemWindow eraseOnly: 1)
		(Print font: gUserFont addText: 1 1 0 10 0 0 0 init:) ; "Background Artists: Jim Larsen Al Roughton Nathan Larsen Terrence C. Falls Willis Wong Maurice F. Morgan Michael Hutchison Arturo Sinclair Cindy Walker Richard Powell"
		(gSystemWindow eraseOnly: 1)
		(Print font: gUserFont addText: 1 1 0 11 0 0 0 init:) ; "Programmers: Krishnan Shankar Charles "Chip" Kercher III Todd Powers Scott Murphy Carlos Escobar Michael Brock Hugh Diedrichs"
		(gSystemWindow eraseOnly: 1)
		(Print font: gUserFont addText: 1 1 0 12 0 0 0 init:) ; "Music Director: Mark Seibert"
		(gSystemWindow eraseOnly: 1)
		(Print font: gUserFont addText: 1 1 0 13 0 0 0 init:) ; "Development System: Jeff Stephenson Mark Wilden Dan Foy J. Mark Hood Christopher Smith Larry Scott Ken Koch Jack Magne"
		(gSystemWindow eraseOnly: 1)
		(Print font: gUserFont addText: 1 1 0 14 0 0 0 init:) ; "Additional Written Material: Scott Murphy Lorlei Shannon"
		(gSystemWindow eraseOnly: 1)
		(Print font: gUserFont addText: 1 1 0 15 0 0 0 init:) ; "Special Thanks: Kit Rees, Model Assembly  Quality Assurance: Mike Pickhinke John Ratcliffe"
		(gSystemWindow eraseOnly: 1)
		(Print font: gUserFont addText: 1 1 0 16 0 0 0 init:) ; "A Very Special Thanks to the following people, who made this game possible:  Hugh Diedrichs, SWAT Programmer Carlos Escobar, SWAT Programmer Josh Mandel, SWAT Director Stuart Moulder, SWAT Producer"
		(gSystemWindow eraseOnly: temp0)
		(self dispose:)
	)
)

