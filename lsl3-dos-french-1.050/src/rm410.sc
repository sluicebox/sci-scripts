;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 410)
(include sci.sh)
(use Main)
(use Interface)
(use Game)
(use System)

(public
	rm410 0
)

(local
	seenMsg
)

(instance rm410 of Rm
	(properties
		picture 410
		south 400
	)

	(method (init)
		(super init:)
		(self setScript: RoomScript)
		(NormalEgo)
		(cond
			((== gPrevRoomNum 415)
				(gEgo posn: 59 45)
			)
			((== gPrevRoomNum 416)
				(gEgo posn: 263 45)
			)
			(else
				(gEgo posn: 159 188)
			)
		)
		(gEgo init:)
	)
)

(instance RoomScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(cond
			((& (gEgo onControl: 1) $0002)
				(gCurRoom newRoom: 415)
			)
			((& (gEgo onControl: 1) $0004)
				(gCurRoom newRoom: 416)
			)
		)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look,look>')
			(cond
				((Said '/art,body,naked,woman,art')
					(Print 410 0) ; "From this angle you can see her entire naked body."
				)
				((Said '/column')
					(Print 410 1) ; "The pillars reach from the floor to the ceiling."
				)
				((Said '/rail')
					(Print 410 2) ; "It's about three feet tall."
				)
				((Said '/stair')
					(Print 410 3) ; "The staircase here is perfectly suited to walking."
				)
				((Said '/curtain')
					(Print 410 4) ; "The curtains prevent you from seeing behind them."
				)
				((Said '[/area]')
					(Print 410 5) ; "A grand staircase rises from the resort's lobby."
				)
			)
		)
	)
)

