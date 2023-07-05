;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 711)
(include sci.sh)
(use Main)
(use n013)
(use Motion)
(use System)

(public
	theDeathScript 0
)

(instance theDeathScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: 0)
				(= temp1
					(if (gCast contains: (ScriptID 710 1)) ; guard1
						((ScriptID 710 1) distanceTo: gEgo) ; guard1
					else
						10000
					)
				)
				(= temp2
					(if (gCast contains: (ScriptID 710 2)) ; guard2
						((ScriptID 710 2) distanceTo: gEgo) ; guard2
					else
						10000
					)
				)
				(= temp3
					(if (gCast contains: (ScriptID 710 3)) ; guard3
						((ScriptID 710 3) distanceTo: gEgo) ; guard3
					else
						10000
					)
				)
				(= register
					(cond
						((and (<= temp1 temp2) (<= temp1 temp3))
							(ScriptID 710 1) ; guard1
						)
						((and (<= temp2 temp1) (<= temp2 temp3))
							(ScriptID 710 2) ; guard2
						)
						((and (<= temp3 temp1) (<= temp3 temp2))
							(ScriptID 710 3) ; guard3
						)
					)
				)
				(= temp0 (register heading:))
				(= state
					(cond
						((<= 30 temp0 120) 4)
						((<= 120 temp0 240) 7)
						((<= 240 temp0 300) 1)
						(else 10)
					)
				)
				(-- state)
				(Face register gEgo self)
			)
			(1
				(gGkMusic1 stop: number: 901 setLoop: 1 play:)
				(gEgo setHeading: 135 self)
				(register
					setMotion: MoveTo (+ (gEgo x:) 9) (gEgo y:) self
				)
			)
			(2 0)
			(3
				(= state 12)
				(register hide:)
				(gEgo
					view: 740
					cel: 0
					loop: 1
					setSpeed: 10
					setCycle: End self
				)
			)
			(4
				(gGkMusic1 stop: number: 901 setLoop: 1 play:)
				(gEgo setHeading: 225 self)
				(register
					setMotion: MoveTo (- (gEgo x:) 9) (gEgo y:) self
				)
			)
			(5 0)
			(6
				(= state 12)
				(register hide:)
				(gEgo
					view: 740
					cel: 0
					loop: 0
					setSpeed: 10
					setCycle: End self
				)
			)
			(7
				(gGkMusic1 stop: number: 901 setLoop: 1 play:)
				(gEgo setHeading: 315 self)
				(register
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 6) self
				)
			)
			(8 0)
			(9
				(= state 12)
				(register hide:)
				(gEgo
					view: 740
					cel: 0
					loop: 2
					setSpeed: 10
					setCycle: End self
				)
			)
			(10
				(gEgo setHeading: 135 self)
				(register
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 6) self
				)
			)
			(11 1)
			(12
				(= state 12)
				(register hide:)
				(gEgo
					view: 741
					cel: 0
					loop: 0
					setSpeed: 10
					setCycle: End self
				)
			)
			(13
				(gMessager say: 14 0 15 0 self 710) ; "!!!One of the mummies reaches Gabriel!"
			)
			(14
				(gCurRoom newRoom: 770) ; deathRm
			)
		)
	)
)

