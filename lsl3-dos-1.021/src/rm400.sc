;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 400)
(include sci.sh)
(use Main)
(use Interface)
(use Game)
(use System)

(public
	rm400 0
)

(instance rm400 of Rm
	(properties
		picture 400
		horizon 83
		north 410
		east 460
		south 250
		west 250
	)

	(method (init)
		(super init:)
		(self setScript: RoomScript)
		(NormalEgo)
		(switch gPrevRoomNum
			(460
				(gEgo posn: 318 162)
			)
			(410
				(if (< (gEgo x:) 111)
					(gEgo x: 111)
				)
				(if (> (gEgo x:) 210)
					(gEgo x: 210)
				)
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
	)

	(method (handleEvent event)
		(if (or (!= (event type:) evSAID) (event claimed:))
			(return)
		)
		(if (Said 'look>')
			(cond
				((Said '/burn')
					(Printf 400 0 gEgoName) ; "Nice pair of sconces, eh, %s."
				)
				((Said '[/area]')
					(Print 400 1) ; "You are inside Nontoonyt Resort. To the north stretches the casino, to the east you see the hotel lobby, and to the south lies the exit to the outside."
				)
			)
		)
	)
)

