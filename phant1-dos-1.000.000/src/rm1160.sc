;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1160)
(include sci.sh)
(use Main)
(use n1111)
(use System)

(public
	rm1160 0
)

(instance rm1160 of ScaryRoom
	(properties)

	(method (init)
		(gEgo view: 2 posn: 1000 1000 init: normalize:)
		(if (== gPrevRoomNum 2300)
			(= picture 1160)
			(= global125 73)
			(gCurRoom setScript: sRecover)
		else
			(if (== gChapter 5)
				(= picture 1206)
			else
				(= picture 1205)
			)
			(gCurRoom setScript: sDrinkWater)
		)
		(super init:)
		(if (== script sRecover)
			(gGame setIntensity: 0 1 fade: 0 100 5)
		)
	)
)

(instance sDrinkWater of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(DoRobot 4961 55 34 gEgo -1 1)
				)
				(1
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(if global115
			(KillRobot)
			(= global115 0)
		)
		(= gNewRoomNum 1200)
		(super dispose: &rest)
	)
)

(instance sRecover of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(global114 pause:)
					(DoRobot 4960 -20 -42 gEgo -1 1)
				)
				(1
					(self dispose:)
				)
			)
		else
			(self dispose:)
		)
	)

	(method (dispose)
		(global114 endPause:)
		(if global115
			(KillRobot)
			(= global115 0)
		)
		(= gNewRoomNum 1200)
		(super dispose: &rest)
	)
)

