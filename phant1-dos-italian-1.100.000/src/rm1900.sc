;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1900)
(include sci.sh)
(use Main)
(use n1111)
(use WalkieTalkie)
(use System)

(public
	rm1900 0
)

(instance rm1900 of ScaryRoom
	(properties
		picture 1900
	)

	(method (init)
		(gEgo view: 0 init: hide:)
		(self setScript: sDelay)
		(super init:)
	)
)

(instance sDelay of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(WalkieTalkie showFrame: 240 0 96 6)
					(= seconds 3)
				)
				(1
					(proc1111_6)
					(proc1111_7 240 96 6)
				)
				(2
					(WalkieTalkie showFrame: 240 84 96 6)
					(= seconds 3)
				)
				(3
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(if global115
			(proc1111_6)
			(= global115 0)
		)
		(= global125 50)
		(= gNewRoomNum 1800)
		(super dispose: &rest)
	)
)

