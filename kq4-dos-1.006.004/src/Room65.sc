;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 65)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)

(public
	Room65 0
)

(synonyms
	(caldron caldron)
	(shelf cabinet)
)

(instance Room65 of Rm
	(properties
		picture 65
		style 16
	)

	(method (init)
		(Load rsVIEW 648)
		(Load rsVIEW 536)
		(self setRegions: 603) ; regHauntedHouse
		(super init:)
		((View new:) view: 536 loop: 5 cel: 0 posn: 238 80 setPri: 4 addToPic:)
		(if gNight
			((View new:)
				view: 648
				loop: 5
				cel: 0
				posn: 280 104
				setPri: 6
				addToPic:
			)
			((Prop new:)
				view: 536
				loop: 1
				posn: 237 73
				setPri: 4
				init:
				setCycle: Fwd
			)
		)
		(if (or (== gPrevRoomNum 64) (== gPrevRoomNum 0))
			(gEgo posn: 245 162 view: 4 xStep: 4 yStep: 2 init:)
		)
		(if (and (< 0 global134 255) (== global133 gCurRoomNum))
			(Notify 603 -1)
		)
	)

	(method (doit)
		(super doit:)
		(if (& (gEgo onControl: 0) $0040)
			(gCurRoom newRoom: 64)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((== (event type:) evSAID)
				(cond
					((or (Said 'look[<around][/!*]') (Said 'look/room,kitchen'))
						(Print 65 0) ; "The old kitchen is quite bare. The fireplace has been cold for years, and the dusty pantry is empty but for old crumbs."
					)
					((Said 'look>')
						(cond
							((Said '/pantry')
								(Print 65 1) ; "The pantry is bare."
							)
							((Said '/fireplace')
								(Print 65 2) ; "The fireplace is stone cold. An empty cooking pot sits in it."
							)
							((Said '/caldron')
								(Print 65 3) ; "The cooking pot is empty and useless."
							)
							((Said '/butterchurn')
								(Print 65 4) ; "The old butterchurn is empty and useless."
							)
							((Said '/window')
								(if (gEgo inRect: 229 124 277 146)
									(Print 65 5) ; "You see the cemetery out the window."
								else
									(Print 65 6) ; "You're not near the window."
								)
							)
							((Said '/barrel')
								(Print 65 7) ; "The barrel is empty. You can't use it."
							)
							((Said '/shelf')
								(Print 65 8) ; "There is nothing that interests you on the kitchen shelves."
							)
							((Said '/chandelier')
								(Print 65 9) ; "The lamp is old and dusty."
							)
							((Said '/wall')
								(Print 65 10) ; "There is nothing of importance on the walls."
							)
							((or (Said '/dirt') (Said '<down'))
								(Print 65 11) ; "There is nothing of interest on the floor."
							)
							((Said '/ladder')
								(Print 65 12) ; "An old ladder sits in the middle of the floor."
							)
							((Said '/crumbs')
								(Print 65 13) ; "You see crumbs here."
							)
							((Said '/bottle')
								(if (gEgo has: 31) ; Glass_Bottle
									(event claimed: 0)
								else
									(Print 800 2) ; "You don't have it."
								)
							)
							(else
								(event claimed: 0)
							)
						)
					)
					((Said 'get>')
						(cond
							((Said '/caldron')
								(Print 65 14) ; "The cooking pot is empty and useless. You don't need it."
							)
							((Said '/butterchurn')
								(Print 65 4) ; "The old butterchurn is empty and useless."
							)
							((Said '/barrel')
								(Print 65 7) ; "The barrel is empty. You can't use it."
							)
							((Said '/crumbs')
								(Print 65 15) ; "You have no use for crumbs."
							)
							(else
								(event claimed: 0)
							)
						)
					)
				)
			)
		)
	)
)

