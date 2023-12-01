;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1600)
(include sci.sh)
(use Main)
(use n1111)
(use Motion)
(use System)

(public
	rm1600 0
)

(instance rm1600 of ScaryRoom
	(properties
		picture 1600
	)

	(method (init)
		(gEgo init: view: 0 loop: 0 cel: 0 hide:)
		(switch gPrevRoomNum
			(900
				(gGame handsOn:)
			)
			(else
				(switch global125
					(49
						(self setScript: sHandTrapdoor)
					)
					(else
						(self setScript: sPokerTrapdoor)
					)
				)
				(= global125 0)
			)
		)
		(super init:)
	)
)

(instance sHandTrapdoor of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(proc1111_0 {QA: new art on the way...})
					(DoRobot 220 72 -31)
				)
				(1
					(gEgo
						view: 221
						setLoop: 0 1
						cel: 0
						posn: 153 120
						show:
						setScale: 0
						setCycle: End self
					)
					(gCurRoom drawPic: 1701 picture: 1701)
				)
				(2
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
		(= global125 49)
		(= gNewRoomNum 1800)
		(super dispose: &rest)
	)
)

(instance sPokerTrapdoor of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(proc1111_0 {QA: new art on the way...})
					(DoRobot 230 -30 -76 gEgo -1 1)
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
		(SetFlag 7)
		(SetFlag 8)
		(if global115
			(KillRobot)
			(= global115 0)
			(= global125 50)
			(= gNewRoomNum 1800)
		else
			(= gNewRoomNum 1900)
		)
		(super dispose: &rest)
	)
)

