;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1)
(include sci.sh)
(use Main)
(use n011)
(use GK2Room)
(use System)

(public
	logoRm 0
)

(instance logoRm of GK2Room
	(properties
		picture 100
	)

	(method (init)
		(super init: &rest)
		(self setScript: sLogo)
	)
)

(instance sLogo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= state -1)
				(PlayRobot 2701 100 40)
			)
		)
	)
)

