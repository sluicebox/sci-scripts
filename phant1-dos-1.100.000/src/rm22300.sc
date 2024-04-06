;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 22300)
(include sci.sh)
(use Main)
(use n1111)
(use System)

(public
	rm22300 0
)

(instance rm22300 of ScaryRoom
	(properties
		picture 22300
		stepSound 7
	)

	(method (drawPic param1)
		(if (and (ResCheck rsPIC (+ param1 1)) (== gChapter 5))
			(super drawPic: (+ param1 1) &rest)
		else
			(super drawPic: param1 &rest)
		)
	)

	(method (init &tmp [temp0 2])
		(gEgo init: hide:)
		(self setScript: entranceScript)
		(super init: &rest)
	)
)

(instance entranceScript of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(gCurRoom picture: 22350)
					(DoRobot 5144 115 28)
				)
				(1
					(gGDacSound
						number: (+ 907 (== gChapter 6))
						setLoop: -1
						play:
					)
					(gGDacSound setVol: 60)
					(gCurRoom drawPic: 22300)
					(DoRobot 5140 84 -15)
				)
				(2
					(gCurRoom drawPic: 22310)
					(DoRobot 5143 -52 -16 gEgo 250)
				)
				(3
					(DoRobot 5141 89 -29 gEgo -1 1)
					(gCurRoom drawPic: 22300)
				)
				(4
					(DoRobot 5142 94 -38 gEgo -1 1)
				)
				(5
					(gGDacSound stop:)
					(gCurRoom newRoom: 22100)
				)
			)
		else
			(gGDacSound stop:)
			(KillRobot)
			(= global115 0)
			(gCurRoom newRoom: 22100)
		)
	)
)

