;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 39100)
(include sci.sh)
(use Main)
(use ExitFeature)
(use n1111)
(use System)

(public
	rm39100 0
)

(instance rm39100 of ScaryRoom
	(properties
		picture 221
	)

	(method (init)
		(gEgo init: posn: 0 1000)
		(super init: &rest)
		(gCurRoom setScript: sAlmostFall)
	)
)

(instance sAlmostFall of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(proc1111_7 6750 97 0)
				)
				(1
					(global114 pause:)
					(proc1111_7 6751 3 -26)
					(gCurRoom drawPic: 210 picture: 210)
				)
				(2
					(global114 endPause:)
					(proc1111_7 6752 115 -4)
					(gCurRoom drawPic: 36440 picture: 36440)
				)
				(3
					(proc1111_7 6753 108 0 gEgo -1 1)
					(gCurRoom drawPic: 221 picture: 221)
				)
				(4
					(gCurRoom newRoom: 36200)
				)
			)
		else
			(proc1111_6)
			(global114 endPause: 1)
			(= global115 0)
			(gCurRoom newRoom: 36200)
		)
	)
)

(instance northExit of ExitFeature ; UNUSED
	(properties
		nsBottom 101
		sightAngle 360
		approachX 160
		approachY 80
		nextRoom 36200
	)
)

