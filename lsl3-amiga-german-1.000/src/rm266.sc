;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 266)
(include sci.sh)
(use Main)
(use Interface)
(use Game)
(use Actor)
(use System)

(public
	rm266 0
)

(local
	seenMsg
)

(instance rm266 of Rm
	(properties
		picture 266
	)

	(method (init)
		(super init:)
		(self setScript: RoomScript)
		(if (< gFilthLevel 3)
			(gAddToPics add: atpBikiniTop doit:)
		)
		(gAddToPics add: atpBikiniBottom doit:)
		(gUser canInput: 1 canControl: 0)
	)
)

(instance RoomScript of Script
	(properties)

	(method (doit)
		(super doit:)
	)

	(method (handleEvent event)
		(if
			(and
				(not (super handleEvent: event))
				(not (event claimed:))
				gModelessDialog
				(== (event message:) KEY_RETURN)
				(== (event type:) evKEYBOARD)
			)
			(event claimed: 1)
			(cls)
			(self cue:)
		)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(cond
			(
				(or
					(Said 'stop/look,look')
					(Said 'look,look<stop')
					(Said 'look,look/beach,area')
					(Said 'exit,done')
					(Said 'exit,exit,done,exit,walk,go')
				)
				(Ok) ; "O.K."
				(gCurRoom newRoom: 260)
			)
			((Said 'talk,talk,ask,say')
				(Print 266 0) ; "Before you speak, you look straight into her eyes..."
				(gCurRoom newRoom: 265)
			)
			((Said 'give')
				(Print 266 1) ; "Why not try looking her straight in the eyes first."
			)
			((Said 'look,look>')
				(cond
					((Said '/woman,body,maller')
						(Print 266 2) ; "What a gorgeous woman, with obviously nothing to hide!"
						(Print 266 3) ; "You suddenly forget about Kalalau completely. You could learn to enjoy the single life once again!"
					)
					((Said '/boob')
						(if (>= gFilthLevel 3)
							(Print 266 4) ; "There they are!"
						else
							(Print 266 5) ; "You think she seemed slow to cover them when she stood up!"
						)
					)
					((Said '/ass,bottom')
						(Print 266 6) ; "It's barely covered by that string bikini."
					)
					((Said '/clit,ball')
						(Print 266 7) ; "There may indeed be faint outlines visible through that knit bikini..."
					)
					((Said '/face,eye,eye')
						(Print 266 0) ; "Before you speak, you look straight into her eyes..."
						(gCurRoom newRoom: 265)
					)
					((Said '/calf')
						(Print 266 8) ; "Her legs are as smooth as a shopping mall's parking lot."
					)
					((Said '[/area]')
						(Print 266 9) ; "Tawni stood up when you introduced yourself to her. Perhaps you should talk to her."
					)
				)
			)
			(else
				(Print 266 0) ; "Before you speak, you look straight into her eyes..."
				(gCurRoom newRoom: 265)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (TestFlag 32))
					(= seconds 3)
				)
			)
			(1
				(SetFlag 32)
				(Print 266 10) ; "WOW! She looks even better vertical!"
				(Print 266 11 #at -1 144) ; "(Bet she has a great "horizontal hold!")"
			)
		)
	)
)

(instance atpBikiniTop of PicView
	(properties
		x 98
		y 56
		view 266
	)
)

(instance atpBikiniBottom of PicView
	(properties
		x 103
		y 91
		view 266
		cel 1
	)
)

