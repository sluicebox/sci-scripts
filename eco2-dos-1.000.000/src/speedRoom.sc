;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10)
(include sci.sh)
(use Main)
(use Game)
(use System)

(public
	speedRoom 0
)

(local
	local0
	local1
)

(instance speedRoom of Rm
	(properties
		picture 888
		style 6
	)

	(method (init)
		(super init:)
		(gGame handsOff:)
		(self setScript: speedTest)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(for ((= temp0 0)) (< temp0 500) ((++ temp0))
		)
	)
)

(instance speedTest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(= local1 (GetTime))
				(= cycles 50)
			)
			(2
				(= local0 (- (GetTime) local1))
				(startGame doit:)
			)
		)
	)
)

(instance startGame of Code
	(properties)

	(method (doit)
		(= gHowFast
			(cond
				((> local0 60) 0)
				((> local0 45) 1)
				((> local0 30) 2)
				(else 3)
			)
		)
		(gGame
			detailLevel:
				(switch gHowFast
					(0 3)
					(1 4)
					(else 5)
				)
		)
		(gEgo setSpeed: (= global136 6))
		(gCurRoom newRoom: global100)
	)
)

