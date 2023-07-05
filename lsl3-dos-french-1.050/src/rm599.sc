;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 599)
(include sci.sh)
(use Main)
(use Interface)
(use Game)
(use System)

(public
	rm599 0
)

(instance rm599 of Locale
	(properties)

	(method (init)
		(if (< gNormalEgoView 800)
			(= gNormalEgoView 800)
		)
		(super init:)
		(if (not (OneOf gPrevRoomNum 510 520 523 540 550))
			(gMusic number: 599 loop: gBgMusicLoops play:)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			((Said 'talk,talk/man,couple,woman')
				(Print 599 0) ; "There is no one within miles of you, Patti."
			)
			((Said 'use/coconut')
				(Print 599 1) ; "O.K. But how?"
			)
			((Said '/bra')
				(Print 599 2) ; "That won't work here."
			)
			((Said 'climb')
				(Print 599 3) ; "That will not help, Patti!"
			)
			((Said '/farm')
				(Print 599 4) ; "This entire area is filled with unusually shaped rocks and plants."
				(Print 599 5 #at -1 144) ; "(None of which will help you!)"
			)
			((Said '/carpet')
				(Print 599 6) ; "Dirt, dirt everywhere."
			)
			(
				(and
					(gEgo has: 19) ; Coconuts
					(or
						(Said 'drink,drink/coconut')
						(Said 'drink,drink/milk')
						(Said 'drink,drink/coconut/milk')
					)
				)
				(Print 599 7) ; "Clever idea."
				(Print 599 8 #at -1 144) ; "(But wrong!)"
			)
			((Said 'look,look>')
				(cond
					((Said '/up,air')
						(Print 599 9) ; "The air is clean and fresh."
					)
					((Said '/boulder')
						(Print 599 10) ; "The centuries of lava flows have left unusual rock formations throughout this jungle."
					)
					((Said '/carpet')
						(Print 599 11) ; "The bare dirt feels good under your feet."
					)
					((Said '/palm,bush')
						(Print 599 12) ; "This warm tropical weather makes everything grow."
					)
				)
			)
		)
	)
)

