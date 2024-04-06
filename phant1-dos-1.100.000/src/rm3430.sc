;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3430)
(include sci.sh)
(use Main)
(use n1111)
(use RandCycle)
(use Actor)
(use System)

(public
	rm3430 0
)

(instance rm3430 of ScaryRoom
	(properties
		picture 3560
		stepSound 7
	)

	(method (init)
		(gEgo init: hide:)
		(gCurRoom setScript: sHangOver)
		(gGDacSound number: 2010 init: setVol: 100 setLoop: -1 play:)
		(global114 play: 3060)
		(super init:)
		(gGame fade: 0 100 5)
	)
)

(instance sHangOver of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(SetFlag 199)
					(DoRobot 5401 40 27)
				)
				(1
					(DoRobot 5402 -14 -41)
					(gCurRoom drawPic: 3410)
				)
				(2
					(DoRobot 5403 -28 -46)
					(gCurRoom drawPic: 3420)
				)
				(3
					(global114 pause:)
					(DoRobot 5404 20 -22)
					(gCurRoom drawPic: 3440)
				)
				(4
					(DoRobot 5405 53 -9)
					(gCurRoom drawPic: 3450)
				)
				(5
					(DoRobot 5406 0 0)
					(gCurRoom drawPic: 3470)
					(rDoor3470 init:)
				)
				(6
					(global114 endPause:)
					(fire init: view: 3481 posn: 27 131 setCycle: RandCycle)
					(rDoor3470 dispose:)
					(DoRobot 5407 -6 -43 gEgo 140 1)
					(gCurRoom drawPic: 3480)
				)
				(7
					(global114 play: 914)
					(gCurRoom newRoom: 3760)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(if (gCast contains: fire)
						(fire dispose:)
					)
					(SetFlag 199)
					(global114 endPause: 1)
					(global114 play: 914)
					(gCurRoom newRoom: 3760)
				)
			)
		)
	)
)

(instance fire of Prop
	(properties
		view 0
	)
)

(instance rDoor3470 of View
	(properties
		x 234
		y 111
		view 3470
		loop 1
		cel 1
	)
)

