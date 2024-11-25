;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 149)
(include sci.sh)
(use Main)
(use n128)
(use Interface)
(use Motion)
(use Actor)
(use System)

(public
	fallToSand 0
	fallInHole 1
)

(local
	local0
)

(instance splash of Prop
	(properties
		y 120
		x 290
		view 35
		loop 3
	)
)

(instance fallToSand of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 149)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(if global124
					(= global124 0)
					(= global137 0)
				)
				(gEgo
					view: 35
					illegalBits: 0
					setLoop: 0
					setCel: 0
					setPri: (if (<= (gEgo y:) 108) 9 else 10)
					posn: (+ (gEgo x:) 1) (+ (gEgo y:) 1)
				)
				(= cycles 2)
			)
			(1
				(gEgo setCel: 1 posn: (- (gEgo x:) 3) (+ (gEgo y:) 2))
				(= cycles 2)
			)
			(2
				(gEgo setCel: 2 posn: (- (gEgo x:) 2) (+ (gEgo y:) 5))
				(= cycles 2)
			)
			(3
				(gEgo setCel: 3 posn: (- (gEgo x:) 1) (+ (gEgo y:) 4))
				(= cycles 2)
			)
			(4
				(gEgo setLoop: 2 cel: 0)
				(= cycles 2)
			)
			(5
				(Print 149 0) ; "Do watch your step, Arthur. You cannot afford to be careless."
				(= cycles 10)
			)
			(6
				(= local0 (gEgo cycler:))
				(gEgo cycler: 0)
				(gEgo cycleSpeed: 1 setCycle: End self)
			)
			(7
				(gEgo setLoop: -1 view: 0 illegalBits: $8800 cycleSpeed: 0)
				(if (IsFlag 92)
					(gEgo loop: 1)
				else
					(gEgo cycler: local0 setPri: -1)
				)
				(ClearFlag 82)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance fallInHole of Script
	(properties)

	(method (doit)
		(if (and (== state 6) (== (gSFX prevSignal:) -1))
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo view: 35 illegalBits: 0 setPri: 2 setLoop: 1 setCel: 1)
				(gSFX number: (proc0_20 89) priority: 4 loop: 1 play:)
				(gRegMusic stop:)
				(= cycles 2)
			)
			(1
				(gEgo setCel: 2)
				(= cycles 2)
			)
			(2
				(gEgo
					setCel: 3
					posn: (+ (gEgo x:) 15) (+ (gEgo y:) 24)
				)
				(= cycles 2)
			)
			(3
				(gEgo setCel: 4 posn: (+ (gEgo x:) 3) (+ (gEgo y:) 17))
				(= cycles 2)
			)
			(4
				(gEgo posn: (+ (gEgo x:) 7) (+ (gEgo y:) 15))
				(= cycles 2)
			)
			(5
				(gEgo posn: (+ (gEgo x:) 7) (+ (gEgo y:) 15))
				(= cycles 10)
			)
			(6
				(gSFX number: (proc0_20 90) priority: 5 loop: 1 play:)
			)
			(7
				(splash setPri: 7 init: cycleSpeed: 1 setCycle: End)
				(= seconds 3)
			)
			(8
				(EgoDead 149 1) ; "I doubt the natives will appreciate the mess you have made for them to clean up. In your next life, do be more careful about where you step."
			)
		)
	)
)

