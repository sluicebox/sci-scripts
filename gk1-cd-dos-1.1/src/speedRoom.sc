;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 17)
(include sci.sh)
(use Main)
(use SpeedTest)
(use Game)
(use System)

(public
	speedRoom 0
)

(instance speedRoom of Room
	(properties
		style 0
	)

	(method (init)
		(super init:)
		(self setScript: speedTest)
	)
)

(instance speedTest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(startGame doit:)
			)
		)
	)
)

(instance startGame of Code
	(properties)

	(method (doit &tmp temp0)
		(gGame
			detailLevel:
				(cond
					((!= (Platform) 1) 2)
					((IsHiRes) 3)
					((<= (SpeedTest) 5) 3)
					((<= (SpeedTest) 7) 2)
					(else 1)
				)
		)
		(SetCursor 0 0 319 199)
		(gTheIconBar enable:)
		(= gDay 1)
		(gCurRoom newRoom: 94)
	)
)

