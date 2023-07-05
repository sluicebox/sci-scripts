;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 30)
(include sci.sh)
(use Main)
(use Feature)
(use Motion)
(use User)
(use System)

(public
	FidgetCode 0
	fidgetScript 1
)

(class FidgetCode of Code
	(properties
		fidgetDelay 1800
		fidgetWaitTime 0
		script 0
		hldEgoView 0
	)

	(method (init param1)
		(= fidgetWaitTime (+ gGameTime fidgetDelay))
		(if argc
			(= script param1)
		else
			(if (== (gCurRoom baseView:) 6000)
				(return)
			)
			(= script fidgetScript)
		)
		(gTheDoits add: self)
	)

	(method (doit)
		(if (> (- gGameTime fidgetWaitTime) 0)
			(= fidgetWaitTime (+ gGameTime fidgetDelay))
			(if
				(and
					(User canInput:)
					(User canControl:)
					(not (gCurRoom script:))
					(not (gEgo script:))
					(not (gCurRoom inset:))
					(gEgo isNotHidden:)
					(gEgo isStopped:)
					(OneOf
						(gEgo view:)
						0
						1
						2
						3
						4
						5
						6
						7
						610
						611
						612
						613
						614
						615
						616
						617
					)
				)
				(gEgo setScript: script 0 0)
			)
		)
	)

	(method (dispose)
		(gTheDoits delete: self)
	)
)

(instance fidgetScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= temp0 (+ (* (gEgo view:) 10) 9020 (Random 0 7)))
				(if (not (ResCheck rsVIEW temp0))
					(self dispose:)
					(return)
				)
				(FidgetCode hldEgoView: (gEgo view:))
				(gEgo view: temp0 loop: 0 cel: 0 setCycle: End self)
			)
			(1
				(gEgo normalize: (FidgetCode hldEgoView:))
				(FidgetCode
					fidgetWaitTime: (+ gGameTime (FidgetCode fidgetDelay:))
				)
				(self dispose:)
				(if register
					(= register 0)
					(gGame handsOn:)
					(CueObj cue:)
				)
			)
		)
	)
)

