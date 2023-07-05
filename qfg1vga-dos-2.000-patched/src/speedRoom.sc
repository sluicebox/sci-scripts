;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 299)
(include sci.sh)
(use Main)
(use n814)
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
		picture 400
		style 6
	)

	(method (init)
		(super init:)
		(HandsOff)
		(gGame setSpeed: 0)
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

	(method (doit &tmp [temp0 100])
		(cond
			((> local0 60)
				(= gHowFast 0)
			)
			((> local0 45)
				(= gHowFast 1)
			)
			((> local0 30)
				(= gHowFast 2)
			)
			(else
				(= gHowFast 3)
			)
		)
		(gGame
			detailLevel:
				(cond
					((== gHowFast 0) 1)
					((== gHowFast 1) 2)
					(else 3)
				)
		)
		(gGame setSpeed: 6)
		(= global123 gSpeed)
		(RedrawCast)
		(gCurRoom newRoom: global124)
	)
)

