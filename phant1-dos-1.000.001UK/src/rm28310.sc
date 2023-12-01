;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 28310)
(include sci.sh)
(use Main)
(use n1111)
(use System)

(public
	rm28310 0
)

(instance rm28310 of ScaryRoom
	(properties
		picture 24360
	)

	(method (init)
		(gEgo init: posn: 0 1000)
		(super init: &rest)
		(KillRobot)
		(self setScript: doorScr)
	)
)

(instance doorScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(DoRobot 1621 101 29 gEgo 5 1)
				)
				(1
					(gCurRoom newRoom: 28300)
				)
			)
		else
			(KillRobot)
			(= global115 0)
			(gCurRoom newRoom: 28300)
		)
	)
)

