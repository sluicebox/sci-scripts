;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 13)
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
)

(procedure (localproc_0 param1 param2 param3)
	(Print
		addText: 2 0 0 param1 param2 0 13
		addIcon: (theIcon1 loop: param3 yourself:)
		init:
	)
)

(instance aboutCode of Code
	(properties)

	(method (doit &tmp [temp0 150] [temp150 150])
		(= local0 gNormalCursor)
		(gGame setCursor: 999)
		(Load rsVIEW 993 989)
		(if (not (Print font: gUserFont addText: 1 0 0 1 0 0 13 init:)) ; "If you're enjoying LAURA BOW: THE DAGGER OF AMON RA, and feel the need for more mystery in your life, investigate the first game in the Laura Bow series: THE COLONEL'S BEQUEST, by Roberta Williams."
			(self dispose:)
			(return)
		)
		(if (not (Print font: gUserFont addText: 1 0 0 2 0 0 13 init:)) ; "To learn all the facts about THE COLONEL'S BEQUEST and other suspect game titles, roll your eyeballs through the catalog found in your game box."
			(self dispose:)
			(return)
		)
		(Message msgGET 13 1 0 0 3 @temp0) ; "To place a domestic order, contact Sierra Sales at %s. To place an international order, contact them at %s. To interrogate someone in Technical Support, call %s.            [ version %s ]"
		(Format @temp150 @temp0 global112 global113 global114 gVersion)
		(if (not (Print addText: @temp150 init:))
			(self dispose:)
			(return)
		)
		(if (not (Print addText: 1 0 0 4 0 0 13 init:)) ; "Our lonely Customer Servants will happily respond to your calls from 7:00 a.m. to 7:00 p.m. Pacific Time, Monday through Friday."
			(self dispose:)
			(return)
		)
		(if (not (Print addText: 2 0 0 1 0 0 13 init:)) ; "In creating a game of this magnitude and complexity, a wide array of talent must be assembled and pointed in the right direction. Once we got rid of those people, the rest of us got down to the job of creating a mystery."
			(self dispose:)
			(return)
		)
		(if (not (Print addText: 2 0 0 2 0 0 13 init:)) ; "These are the guilty parties:"
			(self dispose:)
			(return)
		)
		(= local1 1)
		(if
			(not
				(Print
					addText: 2 0 0 3 0 0 13 ; "GRAND HIGH EXALTED ONE: (Executive Producer)  Ken Williams"
					addIcon: (theIcon1 view: 993 loop: 0 yourself:) 0 0 0 50
					addIcon: (theIcon2 view: 993 loop: 1 yourself:) 0 0 50 50
					addIcon: (theIcon3 view: 993 loop: 2 yourself:) 0 0 75 50
					init:
				)
			)
			(self dispose:)
			(return)
		)
		(if
			(not
				(Print
					addText: 2 0 0 4 0 0 13 ; "CREATIVE PHARAOH: (Creative Director)  Bill Davis"
					addIcon: theIcon1 0 0 0 50
					addIcon: theIcon2 0 0 50 50
					addIcon: theIcon3 0 0 75 50
					init:
				)
			)
			(self dispose:)
			(return)
		)
		(if (not (localproc_0 5 35 3))
			(self dispose:)
			(return)
		)
		(if (not (localproc_0 6 35 3))
			(self dispose:)
			(return)
		)
		(if (not (localproc_0 7 35 4))
			(self dispose:)
			(return)
		)
		(= local1 0)
		(theIcon1 view: 989)
		(if (not (localproc_0 8 35 1))
			(self dispose:)
			(return)
		)
		(= local1 1)
		(theIcon1 view: 993)
		(if (not (localproc_0 9 35 12))
			(self dispose:)
			(return)
		)
		(if (not (localproc_0 10 35 5))
			(self dispose:)
			(return)
		)
		(= local1 0)
		(if (not (localproc_0 11 45 6 0))
			(self dispose:)
			(return)
		)
		(= local1 1)
		(if (not (localproc_0 12 35 7 1))
			(self dispose:)
			(return)
		)
		(if (not (localproc_0 13 50 8))
			(self dispose:)
			(return)
		)
		(if (not (localproc_0 14 35 9))
			(self dispose:)
			(return)
		)
		(if (not (localproc_0 29 35 9))
			(self dispose:)
			(return)
		)
		(if (not (localproc_0 15 35 10))
			(self dispose:)
			(return)
		)
		(= local1 0)
		(theIcon1 view: 989)
		(if (not (localproc_0 16 50 0))
			(self dispose:)
			(return)
		)
		(= local1 1)
		(if (not (localproc_0 17 35 1))
			(self dispose:)
			(return)
		)
		(= local1 1)
		(if (not (localproc_0 30 35 1))
			(self dispose:)
			(return)
		)
		(if
			(not
				(Print
					addText: 2 0 0 18 40 0 13 ; "BANDLEADER: (Music Director)  Mark Seibert"
					addIcon: (theIcon1 view: 989 loop: 2 yourself:) 0 0 0 0
					addIcon: (theIcon2 view: 989 loop: 3 yourself:) 0 0 130 0
					init:
				)
			)
			(self dispose:)
			(return)
		)
		(= local1 0)
		(if
			(not
				(Print
					addText: 2 0 0 19 0 0 13 ; "STRANGE NOISES: (Additional Music and Sound Effects)  Orpheus Hanley  Rudy Helm Dan Kehler      Susan Kehler (Vocalist)"
					addIcon: (theIcon1 loop: 4 yourself:) 0 0 150 20
					init:
				)
			)
			(self dispose:)
			(return)
		)
		(if (not (localproc_0 20 35 5))
			(self dispose:)
			(return)
		)
		(if (not (localproc_0 21 35 6))
			(self dispose:)
			(return)
		)
		(if (not (localproc_0 22 35 7))
			(self dispose:)
			(return)
		)
		(if (not (localproc_0 23 35 8))
			(self dispose:)
			(return)
		)
		(if (not (localproc_0 24 75 9))
			(self dispose:)
			(return)
		)
		(theIcon1 view: 993)
		(= local1 1)
		(if (not (localproc_0 25 55 4))
			(self dispose:)
			(return)
		)
		(theIcon1 view: 989)
		(= local1 0)
		(if (not (localproc_0 26 35 10))
			(self dispose:)
			(return)
		)
		(if (not (localproc_0 27 35 5))
			(self dispose:)
			(return)
		)
		(= local1 1)
		(if (not (localproc_0 28 35 11))
			(self dispose:)
			(return)
		)
		(self dispose:)
	)

	(method (dispose)
		(= gNormalCursor local0)
		(gGame setCursor: gNormalCursor)
		(DisposeScript 967)
		(DisposeScript 13)
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

(instance theIcon2 of DCIcon
	(properties
		cycleSpeed 15
	)

	(method (init)
		((= cycler (Fwd new:)) init: self)
	)
)

(instance theIcon3 of DCIcon
	(properties
		cycleSpeed 15
	)

	(method (init)
		((= cycler (Fwd new:)) init: self)
	)
)

