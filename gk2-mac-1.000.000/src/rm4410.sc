;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4410)
(include sci.sh)
(use Main)
(use n011)
(use northExit)
(use System)

(public
	rm4410 0
)

(instance rm4410 of ExitRoom ; "Hunt Club: Main Hall"
	(properties
		modNum 440
		noun 6
		picture 4410
	)

	(method (notify)
		(if (gCurRoom script:)
		else
			(gCurRoom setScript: cuckooExpires)
		)
	)

	(method (init)
		(super init: &rest)
		(gCurRoom setScript: sExit)
	)
)

(instance sExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 6)
			)
			(1
				(gCurRoom newRoom: 450) ; clubBackRm
			)
		)
	)
)

(instance cuckooExpires of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gTimers delete: (ScriptID 450 1)) ; MISSING EXPORT
				(PlayScene 271 self)
			)
			(1
				(SetFlag 528)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

