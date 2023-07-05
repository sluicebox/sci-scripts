;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 196)
(include sci.sh)
(use Main)
(use n128)
(use Interface)
(use Motion)
(use System)

(public
	moveHorseAway 0
	fallingOffDock 1
)

(instance moveHorseAway of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 196)
	)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(if (and (>= (gEgo y:) 165) (== (gEgo loop:) 0))
					(client setScript: 0)
				else
					(if (<= (gEgo y:) 150)
						(= temp1 (+ (gEgo y:) 10))
						(= temp0 (gEgo x:))
					else
						(= temp1 (gEgo y:))
						(= temp0 (+ (gEgo x:) 15))
					)
					(Print 196 0) ; "Your horse has no desire to swim in the harbour."
					(gEgo setMotion: MoveTo temp0 temp1 self)
					(= cycles 20)
				)
			)
			(1
				(gEgo setMotion: 0)
				(= cycles 0)
				(client setScript: 0)
			)
		)
	)
)

(instance fallingOffDock of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 196)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 38
					setCel: 0
					cycleSpeed: 1
					setPri: 8
					illegalBits: 0
					ignoreActors: 1
					setCycle: End
				)
				(cond
					((& (gEgo onControl:) $0040)
						(gEgo
							setPri: 14
							setLoop: (if (== (gEgo loop:) 0) 3 else 4)
							setStep: 4 8
							setMotion:
								MoveTo
								(gEgo x:)
								(+ (gEgo y:) 40)
								self
						)
					)
					((& (gEgo onControl:) $0002)
						(gEgo
							setLoop: 0
							setStep: 1 8
							setMotion:
								MoveTo
								(- (gEgo x:) 5)
								(+ (gEgo y:) 50)
								self
						)
					)
					(else
						(switch (gEgo loop:)
							(1
								(gEgo
									setLoop: 1
									setStep: 4 8
									setMotion:
										MoveTo
										(- (gEgo x:) 20)
										(+ (gEgo y:) 60)
										self
								)
							)
							(else
								(gEgo
									setLoop: 3
									setStep: 4 8
									setMotion:
										MoveTo
										(+ (gEgo x:) 20)
										(+ (gEgo y:) 60)
										self
								)
							)
						)
					)
				)
			)
			(1
				(gEgo hide:)
				((ScriptID 33 1) ; splash
					setPri: (gEgo priority:)
					posn:
						(gEgo x:)
						(-
							(gEgo y:)
							(if (== (gEgo priority:) 14) 35 else 45)
						)
					init:
					setCycle: End self
				)
			)
			(2
				((ScriptID 33 1) dispose:) ; splash
				(EgoDead 196 1) ; "Your armour and steel drags you to the bottom and there you will lie until you are rotten, soggy and pulpy and truly forgotten."
			)
		)
	)
)

