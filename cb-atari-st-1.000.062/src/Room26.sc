;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 26)
(include sci.sh)
(use Main)
(use Interface)
(use RFeature)
(use Game)

(public
	Room26 0
)

(instance Room26 of Rm
	(properties
		picture 26
	)

	(method (init)
		(= horizon 122)
		(= east 27)
		(= west 25)
		(= north 20)
		(super init:)
		(self setRegions: 207 405 setFeatures: House) ; fenceReg, Gator
		(if (and (>= gAct 2) (< gAct 4))
			(self setRegions: 202) ; EthelDrunk
		)
		(if
			(or
				(and (== gAct 3) (!= global114 10))
				(and (== gAct 6) (not (& gMustDos $0002)))
			)
			(self setRegions: 281) ; rudywand
		)
		(if (== gPrevRoomNum 20)
			(gEgo posn: 180 125)
		)
		(if (and (== gPrevRoomNum 25) (< (gEgo y:) 157))
			(gEgo posn: 1 145)
		)
		(gEgo view: 0 init:)
		(HandsOn)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
	)

	(method (doit)
		(if (IsFirstTimeInRoom)
			(Print 26 0) ; "You are walking along the south edge of the bayou island. An old road runs alongside the old plantation's front wrought iron fence. In the distance you see a carriage house."
		)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look>')
					(cond
						((Said '[<around,at][/room]')
							(Print 26 0) ; "You are walking along the south edge of the bayou island. An old road runs alongside the old plantation's front wrought iron fence. In the distance you see a carriage house."
						)
						((Said '/drive')
							(Print 26 1) ; "A dirt driveway leads from the carriage house to the old road."
						)
						((Said '/archway')
							(Print 26 2) ; "A rusted gate crosses the old driveway."
						)
						((Said '/box')
							(Print 26 3) ; "You see nothing special."
						)
					)
				)
				((Said 'get/box')
					(Print 26 4) ; "You can't get that."
				)
				((Said 'close,open/archway')
					(Print 26 5) ; "The gate is rusted shut. You can't open or close it."
				)
				((Said 'oil/archway')
					(if (gEgo has: 3) ; oilcan
						(Print 26 6) ; "You don't have enough oil for that."
					else
						(Print 26 7) ; "You don't have any oil."
					)
				)
			)
		)
	)
)

(instance House of RFeature
	(properties
		nsTop 59
		nsLeft 38
		nsBottom 97
		nsRight 112
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/cabin'))
			(event claimed: 1)
			(Print 26 8) ; "You see the old carriage house in the distance to the north."
		)
	)
)

