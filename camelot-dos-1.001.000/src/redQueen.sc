;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 182)
(include sci.sh)
(use Main)
(use n128)
(use Motion)
(use System)

(public
	redQueen 0
)

(class HopTo of Motion
	(properties
		xm 0
		ym 0
		zm 0
		_m 1
		_d 1
	)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4)
		(super init: &rest)
		(= temp1 (/ (- x (= temp3 (client x:))) 2))
		(= temp2 (/ (- y (= temp4 (client y:))) 2))
		(= xm (+ (client x:) temp1))
		(= ym (+ (client y:) temp2))
		(= temp0 (or zm ym))
		(= zm (+ (* temp1 temp1) (* temp2 temp2)))
		(if (< temp0 zm)
			(= _d (Max 1 (/ zm temp0)))
		else
			(= _m (Max 1 (/ temp0 zm)))
		)
		(*= zm _m)
		(/= zm _d)
	)

	(method (doit &tmp temp0 temp1 temp2)
		(super doit: &rest)
		(= temp0
			(/
				(= temp0
					(*
						(= temp0
							(+
								(* (= temp1 (- (client x:) xm)) temp1)
								(* (= temp2 (- (client y:) ym)) temp2)
							)
						)
						_m
					)
				)
				_d
			)
		)
		(client z: (- zm temp0))
	)
)

(instance rQHopTo of HopTo
	(properties
		zm 75
	)
)

(instance redQueen of Script
	(properties)

	(method (doit)
		(super doit:)
		(cond
			((and (> (gEgo x:) 185) (== (gEgo loop:) 4))
				(gEgo setLoop: 1)
			)
			((and (> (gEgo x:) 165) (== (gEgo loop:) 0))
				(gEgo setLoop: 4 setPri: 15 cel: 0)
			)
			((and (== state 1) (== (gSFX prevSignal:) -1))
				(self cue:)
			)
		)
	)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(if (IsFlag 20)
					(= temp0 (if (< (gMuleObj x:) 160) 100 else 252))
					(= temp1 (if (< (gMuleObj x:) 160) 170 else 156))
					(gMuleObj
						illegalBits: 0
						ignoreActors: 1
						setPri: 13
						setMotion: MoveTo temp0 temp1 self
					)
				else
					(self cue:)
				)
			)
			(1
				(if (IsFlag 20)
					(gMuleObj
						setMotion:
							MoveTo
							(if (< (gMuleObj x:) 160) 102 else 250)
							(gMuleObj y:)
					)
				)
				(gRegMusic stop:)
				(gSFX number: (proc0_20 79) loop: 1 play:)
			)
			(2
				(gSFX number: (proc0_20 81) loop: 1 play:)
				(gEgo
					view: 136
					setLoop: 0
					setPri: 9
					setStep: 6 4
					illegalBits: 0
					posn: 130 160
					cycleSpeed: 1
					setCycle: Fwd
					setMotion: rQHopTo 220 160 self
				)
			)
			(3
				(gSFX stop:)
				(gSFX number: (proc0_20 80) loop: 1 play:)
				(gEgo viewer: 0 setLoop: 2 setMotion: MoveTo 258 165 self)
			)
			(4
				(gEgo setLoop: 3 cycleSpeed: 3 setCycle: End)
				(= cycles 15)
			)
			(5
				(EgoDead 182 0) ; "See? Now you have gone and lost your head. But I am sure the mukhtar's men will find a use for it--to adorn a spike, no doubt."
			)
		)
	)
)

