;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 46)
(include sci.sh)
(use Main)
(use Array)
(use Sound)
(use Motion)
(use System)

(public
	staffScript 0
)

(local
	local0
)

(instance staffScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 (IntArray with: 0 1 0 4 0 1 4 5))
				(gGlory handsOff:)
				(if (gEgo looper:)
					((gEgo looper:) dispose:)
					(gEgo looper: 0)
				)
				(gEgo
					setMotion: 0
					view: 20
					setLoop: 0
					setLoop: (local0 at: (gEgo loop:))
					setCel: 0
					setCycle: End self
				)
				(sFx number: 934 play:)
			)
			(1
				(gEgo loop: (+ (gEgo loop:) 2) cel: 0 setCycle: End self)
			)
			(2
				(if (== gCurRoomNum 580)
					(gCurRoom cue:)
				else
					(gGlory handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance sFx of Sound
	(properties)
)

