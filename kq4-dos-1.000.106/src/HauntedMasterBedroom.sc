;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 62)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Game)
(use Actor)

(public
	HauntedMasterBedroom 0
)

(synonyms
	(room bedroom)
)

(instance HauntedMasterBedroom of Rm
	(properties
		picture 62
		style 16
	)

	(method (init)
		(self setRegions: 603) ; regHauntedHouse
		(Load rsVIEW 536)
		(super init:)
		(if gNight
			((Prop new:)
				view: 536
				loop: 1
				cel: 0
				posn: 114 78
				init:
				setPri: 4
				setCycle: Fwd
			)
			((Prop new:)
				view: 536
				loop: 2
				cel: 1
				posn: 205 78
				init:
				setPri: 4
				setCycle: Fwd
			)
		)
		(if (== gPrevRoomNum 59)
			(gEgo posn: 47 130 view: 4 xStep: 4 yStep: 1 init:)
		)
		(if (== gPrevRoomNum 68)
			(gEgo posn: 244 158 view: 4 xStep: 4 yStep: 1 init:)
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
			(gCurRoom newRoom: 59)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return 1)
			)
			((== (event type:) evSAID)
				(cond
					((Said 'look>')
						(cond
							((Said '<under/bed')
								(Print 62 0) ; "There is nothing under the bed."
							)
							((Said '/bed')
								(Print 62 1) ; "The old bed is massive and dominates the room."
							)
							((Said '/window')
								(Print 62 2) ; "You don't see a window."
							)
							((Said '<in/chest,dresser,drawer')
								(Print 62 3) ; "The drawers are empty."
							)
							((Said '/chest,dresser')
								(if (< (gEgo x:) 150)
									(Print 62 4) ; "You see a small dresser."
								else
									(Print 62 5) ; "A chest of drawers, sporting a broken mirror, sets against the wall."
								)
							)
							((Said '/wall')
								(Print 62 6) ; "There is nothing of importance on the walls."
							)
							((Said '/chandelier')
								(Print 62 7) ; "The lamp is old and dusty."
							)
							((or (Said '/dirt') (Said '<down'))
								(Print 62 8) ; "There is nothing of interest on the floor."
							)
							((Said '/mirror')
								(if
									(or
										(gEgo inRect: 19 148 80 168)
										(gEgo inRect: 191 133 271 162)
									)
									(Print 62 9) ; "You look in the mirror and see the reflection of a poor, but beautiful, peasant girl."
								else
									(Print 62 10) ; "You're not close enough to look in either mirror."
								)
							)
							((Said '/carpet')
								(Print 62 11) ; "A tattered oriental rug covers the floor at the foot of the bed."
							)
							((Said '[<around][/room]')
								(Print 62 12) ; "It appears as if this was once the master bedroom. However, cobwebs hang everywhere, and dust covers the furniture."
							)
						)
					)
					((Said 'open/chest,dresser,drawer')
						(Print 62 3) ; "The drawers are empty."
					)
					(
						(or
							(Said 'get[<in,on]/bed')
							(Said 'lay,sleep[<in,on,down]')
						)
						(Print 62 13) ; "You don't have time for that!"
					)
				)
			)
		)
	)
)

