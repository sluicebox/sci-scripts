;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 245)
(include sci.sh)
(use Main)
(use Interface)
(use Game)
(use System)

(public
	rm245 0
)

(local
	seenMsg
)

(instance rm245 of Rm
	(properties
		picture 245
		west 240
	)

	(method (init)
		(super init:)
		(self setRegions: 41 setScript: RoomScript) ; rm41
		(if (== gPrevRoomNum 500)
			(gEgo posn: 126 73 loop: 2)
		else
			(gEgo posn: 5 172 loop: 0)
		)
		(NormalEgo)
		(gEgo init:)
		(if gEgoState
			(gEgo observeControl: 4 8 16)
		)
	)

	(method (newRoom newRoomNumber)
		(cls)
		(super newRoom: newRoomNumber)
	)
)

(instance RoomScript of Script
	(properties)

	(method (doit)
		(if (not gEgoIsPatti)
			(gEgo observeControl: 16384)
			(if (& (gEgo onControl:) $0020)
				(if (not seenMsg)
					(= seenMsg 1)
					(Print 245 0) ; "There is nothing before you but limitless jungle. There's no need for a guy like you to lose himself in that forsaken wilderness. You'd better head back to the bright lights of the city, Larry!"
				)
			else
				(= seenMsg 0)
			)
		)
		(if (== gEgoState 0)
			(cond
				((& (gEgo onControl:) $0002)
					(gCurRoom newRoom: 500)
				)
				((& (gEgo onControl:) $0010)
					(Notify 41 9 300)
				)
				((& (gEgo onControl:) $0004)
					(Notify 41 0 300)
				)
				((or (== 2 (gEgo edgeHit:)) (& (gEgo onControl:) $0008))
					(gEgo x: (+ (gEgo x:) 8))
					(Notify 41 8 300)
				)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look>')
			(cond
				((Said '/ball,boulder,boob')
					(Print 245 1) ; "What unusual rock formations!"
				)
				((Said '/bamboo')
					(Print 245 2) ; "The thicket of bamboo is so thick it is impossible to see very far into it."
				)
				((Said '[/area]')
					(Print 245 3) ; "A dangerous cliff lies beside this ledge. A bamboo thicket is in the distance."
				)
			)
		)
	)
)

