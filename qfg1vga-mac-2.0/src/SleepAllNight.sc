;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 88)
(include sci.sh)
(use Main)
(use n814)
(use Print)
(use Motion)
(use System)

(public
	SleepAllNight 0
)

(procedure (localproc_0 param1 param2 &tmp temp0 temp1)
	(Platform 0 4 3 -1)
	(= global247 0)
	(= temp1 gClock)
	(switch argc
		(0
			(FixTime 5)
		)
		(1
			(FixTime param1)
		)
		(else
			(FixTime param1 param2)
		)
	)
	(= temp0 (/ (mod (- (+ gClock 3600) temp1) 3600) 150))
	(= [gEgoStats 15] (MaxStamina)) ; stamina
	(if (== gCurRoomNum 10)
		(= [gEgoStats 14] (MaxHealth)) ; health
		(= [gEgoStats 16] (MaxMana)) ; mana
	else
		(TakeDamage (- (* temp0 2)))
		(UseMana (- (* temp0 2)))
	)
	(if (> temp1 gClock)
		(NextDay)
	)
	(if (not (OneOf gCurRoomNum 300 302 310 320 330))
		(Print addText: 1 0 0 7 0 0 7 ticks: 5 y: 10 init:) ; "You awake as the sun begins to rise."
	)
	(Platform 0 4 2 -1)
	(Print ticks: -1)
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
				(= ticks 180)
			)
			(5
				(localproc_0 5 0)
				(= ticks 60)
			)
			(6
				(gEgo setCycle: Beg self)
			)
			(7
				(gEgo
					setLoop: 0
					setCel: 6
					posn: (+ (gEgo x:) 4) (- (gEgo y:) 1)
					setCycle: Beg self
				)
			)
			(8
				(gEgo posn: (+ (gEgo x:) 3) (- (gEgo y:) 2))
				(HandsOn)
				(NormalEgo)
			)
		)
	)
)

