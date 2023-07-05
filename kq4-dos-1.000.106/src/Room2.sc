;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2)
(include sci.sh)
(use Main)
(use Interface)
(use Game)

(public
	Room2 0
)

(instance Room2 of Rm
	(properties
		picture 2
	)

	(method (init)
		(= north 26)
		(= south 8)
		(= east 3)
		(= west 1)
		(= horizon 68)
		(= gIndoors 0)
		(if gNight
			(= picture 102)
		)
		(super init:)
		(gEgo view: 2 init:)
		(self setRegions: 506 514) ; meadReg, regPan
	)

	(method (newRoom newRoomNumber)
		(if (gCast contains: global172)
			(= global211 global160)
			(= global212 global159)
		)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event)
		(if (event claimed:)
			(return 1)
		)
		(if (and (== (event type:) evSAID) (Said 'look>'))
			(cond
				((or (Said '/room') (Said '/around') (Said '[<around][/!*]'))
					(Print 2 0) ; "You are surrounded by beautiful wildflowers in this luscious green meadowland."
				)
				((Said '/brook')
					(Print 2 1) ; "You see a river in the distance to the north."
				)
			)
		)
	)
)

