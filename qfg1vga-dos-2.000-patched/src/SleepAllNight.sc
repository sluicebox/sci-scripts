;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 88)
(include sci.sh)
(use Main)
(use n007)
(use n814)
(use Motion)
(use System)

(public
	SleepAllNight 0
)

(instance SleepAllNight of Script
	(properties)

	(method (dispose)
		(NormalEgo)
		(super dispose:)
		(DisposeScript 88)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setHeading: 180 self)
			)
			(1
				(gGame setCursor: gWaitCursor 1)
				(gEgo
					view: 551
					setLoop: 0
					setCel: 0
					posn: (- (gEgo x:) 3) (+ (gEgo y:) 2)
					setCycle: End self
				)
			)
			(2
				(= ticks 12)
			)
			(3
				(gEgo
					setLoop: 1
					setCel: 0
					posn: (- (gEgo x:) 4) (+ (gEgo y:) 1)
					setCycle: End self
				)
			)
			(4
				(PalVary pvINIT (gCurRoom picture:) 2)
				(if global451
					(PalVary pvCHANGE_TARGET global451)
				)
				(= seconds 5)
			)
			(5
				(= seconds 2)
			)
			(6
				(PalVary pvREVERSE 4)
				(= seconds 2)
			)
			(7
				(= seconds 2)
			)
			(8
				(EgoSleeps 5 0)
				(gEgo setCycle: Beg self)
			)
			(9
				(gEgo
					setLoop: 0
					setCel: 6
					posn: (+ (gEgo x:) 4) (- (gEgo y:) 1)
					setCycle: Beg self
				)
			)
			(10
				(gEgo posn: (+ (gEgo x:) 3) (- (gEgo y:) 2))
				(HandsOn)
				(NormalEgo)
			)
		)
	)
)

