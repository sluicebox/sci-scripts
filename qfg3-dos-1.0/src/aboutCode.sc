;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 19)
(include sci.sh)
(use Main)
(use Print)
(use DCIcon)
(use Motion)
(use System)

(public
	aboutCode 0
)

(local
	local0
	local1
	[local2 5]
)

(procedure (localproc_0 param1 param2 param3) ; UNUSED
	(Print
		addText: 2 0 0 param1 param2 0 19
		addIcon: (theIcon1 loop: param3 yourself:)
		init:
	)
)

(instance aboutCode of Code
	(properties)

	(method (doit &tmp [temp0 300])
		(= local0 ((gTheIconBar curIcon:) cursor:))
		(gGame setCursor: 999)
		(cond
			(
				(not
					(and
						(or (Message msgGET 19 2 0 0 1 @temp0) 1) ; "Quest for Glory III: The Wages of War  Version %s Copyright 1992 by Sierra On-Line, Inc."
						(Print font: 0 mode: 1 addTextF: @temp0 gVersion init:)
					)
				)
				0
			)
			((not (Print font: 0 mode: 1 addText: 2 0 0 2 0 0 19 init:)) 0) ; "GAME DESIGNERS: Lori Ann Cole Corey Cole  WRITER/DIRECTOR: Lori Ann Cole  PRODUCER: Tammy Dargan"
			((not (Print font: 0 mode: 1 addText: 2 0 0 3 0 0 19 init:)) 0) ; "ART DESIGNER: Andy Hoyos  LEAD ANIMATOR: Marc Hudgins  LEAD PROGRAMMER: Oliver Brelsford  COMPOSER: Rudy Helm"
			((not (Print font: 0 mode: 1 addText: 2 0 0 4 0 0 19 init:)) 0) ; "ARTISTS: Jeff Crowe Dana M. Dean Jay Friedmann Darrin Fuller Tim Loucks Mustafa Powell Frank Ferrell Roger Hardy Jerry Jesserun"
			((not (Print font: 0 mode: 1 addText: 2 0 0 5 0 0 19 init:)) 0) ; "PROGRAMMERS: Kevin Ray Chris Carr Dave Artis Henry Yu Brett Miller Rick Comstock"
			((not (Print font: 0 mode: 1 addText: 2 0 0 6 0 0 19 init:)) 0) ; "VIDEO CAPTURE: Bob Ballew  QUALITY ASSURANCE: Dave Fleming Dan Woolard Bill Davis, Jr. Sharon Smith"
			((not (Print font: 0 mode: 1 addText: 2 0 0 7 0 0 19 init:)) 0) ; "VIDEO CAPTURE ACTORS: Terrence C. Falls Dana M. Dean Richard Powell Frank Ferrell Gloria Garland Josh Mandel Barry T. Smith Brett Miller ..."
			((not (Print font: 0 mode: 1 addText: 2 0 0 8 0 0 19 init:)) 0) ; "MORE VIDEO ACTORS: Corey Cole Lori Ann Cole Jerry Jessurun Bob Ballew Darrin Fuller Guruka Singh Khalsa Jay Friedmann Roger Hardy"
			((not (Print font: 0 mode: 1 addText: 2 0 0 9 0 0 19 init:)) 0) ; "QUALITY ASSURANCE CONFIGURATION: Dave Clingman Sharon Simmons Keri Cooper Doug Wheeler Diana Mulligan Matthew Genesi"
			((not (Print font: 0 mode: 1 addText: 2 0 0 10 0 0 19 init:)) 0) ; "GAME DEVELOPMENT SYSTEM: Dan Foy Larry Scott Christopher Smith Jack Magne Ken Koch Mark Wilden Jeff Stephenson Brian K. Hughes J. Mark Hood Chad Bye Bill Crow"
			((not (Print font: 0 mode: 1 addText: 3 0 0 1 0 0 19 init:)) 0) ; "And now back to the land of Tarna and Quest for Glory III. You have a war to prevent!"
		)
		(self dispose:)
	)

	(method (dispose)
		(gGame setCursor: local0 1)
		(DisposeScript 19)
	)
)

(instance theIcon1 of DCIcon
	(properties
		cycleSpeed 15
	)

	(method (init)
		(if local1
			((= cycler (Fwd new:)) init: self)
		else
			(= cel 0)
			((= cycler (End new:)) init: self)
		)
	)
)

(instance theIcon2 of DCIcon ; UNUSED
	(properties
		cycleSpeed 15
	)

	(method (init)
		((= cycler (Fwd new:)) init: self)
	)
)

(instance theIcon3 of DCIcon ; UNUSED
	(properties
		cycleSpeed 15
	)

	(method (init)
		((= cycler (Fwd new:)) init: self)
	)
)

