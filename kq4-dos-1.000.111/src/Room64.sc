;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)

(public
	Room64 0
)

(local
	[local0 3]
)

(instance Room64 of Rm
	(properties
		picture 64
		style 16
	)

	(method (init)
		(self setRegions: 603) ; regHauntedHouse
		(super init:)
		((View new:) view: 536 loop: 3 cel: 0 posn: 154 81 setPri: 15 addToPic:)
		((View new:) view: 536 loop: 3 cel: 0 posn: 167 81 setPri: 15 addToPic:)
		((View new:) view: 536 loop: 3 cel: 0 posn: 179 81 setPri: 15 addToPic:)
		(if gNight
			((View new:)
				view: 648
				loop: 3
				cel: 0
				posn: 219 89
				setPri: 5
				addToPic:
			)
			((View new:)
				view: 648
				loop: 4
				cel: 0
				posn: 266 105
				setPri: 6
				addToPic:
			)
			((Prop new:)
				view: 536
				loop: 2
				cel: 2
				posn: 154 76
				setPri: 15
				init:
				setCycle: Fwd
			)
			((Prop new:)
				view: 536
				loop: 1
				cel: 1
				posn: 166 76
				setPri: 15
				init:
				setCycle: Fwd
			)
			((Prop new:)
				view: 536
				loop: 2
				cel: 4
				posn: 179 76
				setPri: 15
				init:
				setCycle: Fwd
			)
		)
		(if (== gPrevRoomNum 68)
			(gEgo posn: 51 131 view: 4 xStep: 4 yStep: 1 init:)
		)
		(if (== gPrevRoomNum 65)
			(gEgo posn: 210 116 view: 4 xStep: 4 yStep: 1 init:)
		)
		(if (and (< 0 global134 255) (== global133 gCurRoomNum))
			(Notify 603 -1)
		)
	)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl: 0) $0040)
			(gCurRoom newRoom: 68)
		)
		(if (& (gEgo onControl: 0) $0020)
			(gCurRoom newRoom: 65)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((== (event type:) evSAID)
				(cond
					((or (Said 'look[<around][/!*]') (Said 'look/room'))
						(Print 64 0) ; "This old dining room has seen better days! The long table is littered with crumbs and dust, and against the wall, the empty hutch is covered with cobwebs."
					)
					((Said 'look>')
						(cond
							((Said '<under/table')
								(Print 64 1) ; "There is nothing of interest under the table."
							)
							((Said '/table')
								(Print 64 2) ; "The dusty old table is littered with crumbs."
							)
							((Said '/chair')
								(Print 64 3) ; "The chairs seem to be falling apart."
							)
							((Said '/window')
								(if (gEgo inRect: 231 118 278 139)
									(Print 64 4) ; "You see the cemetery out the window."
								else
									(Print 800 1) ; "You're not close enough."
								)
							)
							((Said '/cabinet')
								(Print 64 5) ; "There is nothing of interest in the hutch."
							)
							((Said '/chandelier')
								(Print 64 6) ; "A tarnished chandelier hangs above the dining table."
							)
							((Said '/wall')
								(Print 64 7) ; "There is nothing of importance on the walls."
							)
							((or (Said '/dirt') (Said '<down'))
								(Print 64 8) ; "There is nothing of interest on the floor."
							)
							((Said '/crumbs')
								(Print 64 9) ; "You see crumbs here."
							)
							(else
								(event claimed: 0)
							)
						)
					)
					((Said 'sit>')
						(Print 64 10) ; "You don't have time for that!"
						(event claimed: 1)
					)
					((Said 'get>')
						(if (Said '/crumbs')
							(Print 64 11) ; "You have no use for crumbs."
						else
							(event claimed: 0)
						)
					)
				)
			)
		)
	)
)

