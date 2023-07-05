;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 200)
(include sci.sh)
(use Main)
(use Interface)
(use Game)

(public
	rm200 0
)

(instance rm200 of Rgn
	(properties)

	(method (init)
		(super init:)
	)

	(method (doit)
		(super doit:)
		(if
			(and
				(== gCurrentTimer 1)
				(not gRgTimer)
				(< gCurRoomNum 26)
				(> gSecondsInRoom 5)
				(== gCurrentStatus 0)
			)
			(= gCurrentStatus 1001)
			(= gCurrentTimer 0)
			(Print 200 0) ; "You have fooled around too long! In the distance you hear a foghorn announcing the departure of your cruise ship."
			(Print 200 1) ; "This is the story of your life. Once again, Larry, you have "missed the boat!""
		)
		(if
			(and
				(> gGameMinutes 9)
				(== gGameSeconds 1)
				(> gSecondsInRoom 8)
				((gInventory at: 1) ownedBy: 23) ; Dollar_Bill
			)
			(++ gGameSeconds)
			(Print 200 2) ; "You're getting off to a slow start, Larry. Perhaps you should dig out the documentation that came with this game and read through the Walk-Thru that begins on page 12."
			(Print 200 3 #at -1 130) ; "(This is merely a friendly suggestion from your designer and programmer, Al Lowe.)"
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'talk/man,children,woman')
			(Print 200 4) ; "No one here is interested in talking to you."
		)
		(if (and (gEgo has: 2) (Said 'scratch,mark,apply/ticket')) ; Lottery_Ticket
			(Print 200 5) ; "You scratch it until you remove the numbers and invalidate it. Since it's no good now, you toss it away!"
			(gEgo put: 2 -1) ; Lottery_Ticket
			(gGame changeScore: -2)
		)
		(if
			(and
				(gEgo has: 9) ; Sunscreen
				(Said 'wear,caress,drop,apply/lotion,(lotion<suntan)')
			)
			(Print 200 6) ; "There's no need. No sun can pierce that smoggy sky."
		)
		(if (Said '/cab')
			(Print 200 7) ; "There are no taxis in this "Leisure Suit Larry.""
		)
		(if (Said 'look>')
			(if (Said '/up,overhead,cloud')
				(Print 200 8) ; "During a Stage III smog alert, breathing is optional (although still permitted)."
			)
			(if (Said '/auto,freeway,angeles')
				(Print 200 9) ; "Formerly, you thought LA was filled with cars."
			)
			(if (Said '/carpet')
				(if (> gCurRoomNum 30)
					(Print 200 10) ; "It just lies there under your feet."
				else
					(Print 200 11) ; "Is this whole city paved?"
				)
			)
			(if (Said '/palm,bush')
				(Print 200 12) ; "All the plants here are made of poly-vinyl chloride or another monoxide-breathing substance."
			)
		)
	)
)

