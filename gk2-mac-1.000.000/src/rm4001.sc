;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4001)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use System)

(public
	rm4001 0
)

(instance rm4001 of ExitRoom
	(properties
		modNum 400
	)

	(method (init)
		(gGame handsOn:)
		(super init: &rest)
		(gCurRoom setScript: sToMap)
	)

	(method (newRoom newRoomNumber)
		(gSoundManager stop:)
		(super newRoom: newRoomNumber)
	)
)

(instance sToMap of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(PlayScene 62 self -1)
			)
			(2
				(if (gGk2Sound handle:)
					(gGk2Sound fade: 0 20 10 1 self)
				else
					(= cycles 3)
				)
				(if (gGk2Music handle:)
					(gGk2Music fade: 0 20 10 1 self)
				else
					(= cycles 3)
				)
			)
			(3 0)
			(4
				(Lock 140 402 0) ; WAVE
				(Lock rsAUDIO 4002 0)
				(gCurRoom newRoom: 200) ; MunichMapRm
			)
		)
	)
)

