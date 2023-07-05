;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 129)
(include sci.sh)
(use Main)
(use carStuff)
(use Interface)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	speederScript 0
	lowRiderScript 1
	drunkScript 2
	suspCar 3
	setUpScript 4
	genCar0 6
	genCar1 7
	genCar2 8
	genCar3 9
	genCar4 10
	setUpScript 11
	pullOverScript 12
	alliedScript 13
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance setUpScript of Script
	(properties)

	(method (doit)
		(if (and (not state) (IsFlag 214))
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				(= seconds 10)
			)
			(2
				(ClearFlag 214)
				(client setScript: register)
			)
		)
	)
)

(instance suspSpeed of Code
	(properties)

	(method (doit param1 &tmp temp0 temp1)
		(= temp1
			(if (not (= temp0 (/ (- param1 ((ScriptID 25 1) mySpeed:)) 5))) ; mainInset
				0
			else
				-1
			)
		)
		(suspCar y: (+ (suspCar y:) (* temp1 temp0)))
		(if (and (not local1) ((ScriptID 130 1) cycler:)) ; lightBar
			(= local1 1)
			((suspCar script:) cue:)
		)
	)
)

(instance speederScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (not state) (!= ((ScriptID 25 1) leftFlag:) -1)) ; mainInset
			(self cue:)
		)
		(if
			(and
				(< state 4)
				(not (User canControl:))
				(not ((ScriptID 130 7) script:)) ; copCar
				(or (< (suspCar y:) ((ScriptID 130 7) y:)) local4) ; copCar
				(or (< (suspCar nsBottom:) ((ScriptID 25 2) nsTop:)) local4) ; roadInset
			)
			(proc130_14)
			(if (not local4)
				(Print 129 0) ; "Wow, this guy's really going fast."
			)
			((ScriptID 130 4) number: 252 play:) ; carSong
		)
		(if (> state 1)
			(suspSpeed doit: register)
		)
		(if (and (IsObject client) (< (client y:) -50))
			(client y: -50)
		)
		(if (and (== state 3) (not (IsObject ((ScriptID 130 1) cycler:)))) ; lightBar
			(= local1 0)
			(self start: 2 cycles: 0 seconds: 0 ticks: 0 init:)
		)
	)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local4 register)
				(= register 85)
				(= local1 0)
			)
			(1
				(if (== global154 0)
					(= global154 -1)
				)
				(cond
					((!= global154 -1)
						(= temp1 global154)
					)
					((not ((ScriptID 25 1) leftFlag:)) ; mainInset
						(= temp1 (- ((ScriptID 25 2) x:) 15)) ; roadInset
					)
					(else
						(= temp1 (+ ((ScriptID 25 2) x:) 15)) ; roadInset
					)
				)
				(suspCar
					init:
					cel: 0
					x: temp1
					y:
						(if local4
							(suspCar y:)
						else
							(+ ((ScriptID 25 1) lastY:) 250) ; mainInset
						)
				)
				(if (and (not local4) (> ((ScriptID 25 1) mySpeed:) 70)) ; mainInset
					((ScriptID 25 1) calcSpeed: 70) ; mainInset
				)
				(= cycles 1)
			)
			(2 0)
			(3
				(= seconds 10)
			)
			(4
				(cond
					((<= (suspCar nsBottom:) ((ScriptID 25 2) nsTop:)) ; roadInset
						(Print 129 1) ; "The other vehicle's too far ahead of you."
						(if ((ScriptID 25 1) tZone:) ; mainInset
							(gCurRoom setScript: (ScriptID 132 3)) ; endFree1Script
						else
							(self start: 3 init:)
						)
					)
					((<= ((ScriptID 130 7) nsTop:) (suspCar y:)) ; copCar
						(Print 129 2) ; "You're not in the proper position to pull the car over."
						(if ((ScriptID 25 1) tZone:) ; mainInset
							(gCurRoom setScript: (ScriptID 132 3)) ; endFree1Script
						else
							(self start: 3 init:)
						)
					)
					(else
						(HandsOff)
						(client setScript: pullOverScript 0 register)
					)
				)
			)
		)
	)
)

(instance alliedScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if local3
			(-- local3)
		)
		(if (and (not state) (!= ((ScriptID 25 1) leftFlag:) -1)) ; mainInset
			(self cue:)
		)
		(if
			(and
				(< state 4)
				(not (User canControl:))
				(not ((ScriptID 130 7) script:)) ; copCar
				(or (< (suspCar y:) ((ScriptID 130 7) y:)) local4) ; copCar
				(or (< (suspCar nsBottom:) ((ScriptID 25 2) nsTop:)) local4) ; roadInset
			)
			(proc130_14)
			(if (not local4)
				(Print 129 0) ; "Wow, this guy's really going fast."
			)
			((ScriptID 130 4) number: 252 play:) ; carSong
		)
		(if (> state 1)
			(suspSpeed doit: register)
		)
		(if (and (IsObject client) (< (client y:) -50))
			(client y: -50)
		)
		(if
			(or
				(and (== state 3) (not (IsObject ((ScriptID 130 1) cycler:)))) ; lightBar
				(and
					(== state 2)
					(<= (suspCar nsBottom:) ((ScriptID 25 2) nsTop:)) ; roadInset
					(not local3)
				)
			)
			(if (IsFlag 89)
				(Print 129 3) ; "You wisely decide not to pull over the allied agent."
				(SetScore 116 5)
			else
				(Print 129 4) ; "You decide not to pull over the vehicle."
			)
			(proc0_17 20)
			(SetFlag 15)
			((ScriptID 130 4) flags: 1 number: 290 play:) ; carSong
			(self register: 105 seconds: 0 cycles: 0 start: 5 init:)
		)
		(if (and (== state 5) (< (client nsBottom:) ((ScriptID 25 2) nsTop:))) ; roadInset
			(self seconds: 0 cue:)
		)
	)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local4 register)
				(= register 85)
				(= local1 0)
			)
			(1
				(if (== global154 0)
					(= global154 -1)
				)
				(cond
					((!= global154 -1)
						(= temp1 global154)
					)
					((not ((ScriptID 25 1) leftFlag:)) ; mainInset
						(= temp1 (- ((ScriptID 25 2) x:) 15)) ; roadInset
					)
					(else
						(= temp1 (+ ((ScriptID 25 2) x:) 15)) ; roadInset
					)
				)
				(suspCar
					init:
					cel: 4
					x: temp1
					y:
						(if local4
							(suspCar y:)
						else
							(+ ((ScriptID 25 1) lastY:) 250) ; mainInset
						)
				)
				(if (and (not local4) (> ((ScriptID 25 1) mySpeed:) 70)) ; mainInset
					((ScriptID 25 1) calcSpeed: 70) ; mainInset
				)
				(= cycles 1)
				(= local3 150)
			)
			(2 0)
			(3
				(= seconds 10)
			)
			(4
				(cond
					((<= (suspCar nsBottom:) ((ScriptID 25 2) nsTop:)) ; roadInset
						(Print 129 1) ; "The other vehicle's too far ahead of you."
						(if ((ScriptID 25 1) tZone:) ; mainInset
							(gCurRoom setScript: (ScriptID 132 3)) ; endFree1Script
						else
							(self start: 3 init:)
						)
					)
					((<= ((ScriptID 130 7) nsTop:) (suspCar y:)) ; copCar
						(Print 129 2) ; "You're not in the proper position to pull the car over."
						(if ((ScriptID 25 1) tZone:) ; mainInset
							(gCurRoom setScript: (ScriptID 132 3)) ; endFree1Script
						else
							(self start: 3 init:)
						)
					)
					(else
						(HandsOff)
						(client setScript: pullOverScript 0 register)
					)
				)
			)
			(5
				(= seconds 15)
			)
			(6
				(cond
					((not (IsFlag 12))
						(= global127 2)
						(= temp0 speederScript)
						(= temp2 (+ ((ScriptID 25 1) lastY:) 250)) ; mainInset
						(= start (= register 0))
					)
					((and (not (IsFlag 13)) (not (IsFlag 216)))
						(= global127 3)
						(= temp0 lowRiderScript)
						(= temp2 (- ((ScriptID 25 1) lastY:) 250)) ; mainInset
					)
					(else
						(= global127 5)
						(= temp0 drunkScript)
						(= temp2 (- ((ScriptID 25 1) lastY:) 100)) ; mainInset
					)
				)
				(= local1 0)
				(client y: temp2 setScript: setUpScript 0 temp0)
			)
		)
	)
)

(instance lowRiderScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if state
			(suspSpeed doit: register)
		)
		(if (and (IsObject client) (not local3) (< (client y:) -50))
			(client y: -50)
		)
		(if (and (== state 2) (not (IsObject ((ScriptID 130 1) cycler:)))) ; lightBar
			(= local1 0)
			(= state 0)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(suspCar init: cel: 1 x: (- ((ScriptID 25 2) x:) 15)) ; roadInset
				(if (not register)
					(Print 129 5) ; "Up ahead you see a slow car impeding traffic in the fast lane."
				)
				((ScriptID 130 4) number: 252 play:) ; carSong
				(genCar0 init:)
				(= register 35)
				(= cycles 1)
				(= local3 150)
				(= local1 0)
			)
			(1 0)
			(2
				(= seconds 10)
			)
			(3
				(cond
					((<= (suspCar nsBottom:) ((ScriptID 25 2) nsTop:)) ; roadInset
						(Print 129 6) ; "The car is too far ahead of you."
						(if ((ScriptID 25 1) tZone:) ; mainInset
							(gCurRoom setScript: (ScriptID 132 3)) ; endFree1Script
						else
							(self start: 2 init:)
						)
					)
					((<= ((ScriptID 130 7) nsTop:) (suspCar y:)) ; copCar
						(Print 129 2) ; "You're not in the proper position to pull the car over."
						(if ((ScriptID 25 1) tZone:) ; mainInset
							(gCurRoom setScript: (ScriptID 132 3)) ; endFree1Script
						else
							(self start: 2 init:)
						)
					)
					(else
						(HandsOff)
						(client setScript: pullOverScript 0 register)
						(if (gCast contains: genCar0)
							(genCar0 setScript: driveAwayScript)
						)
					)
				)
			)
		)
	)
)

(instance drunkScript of Script
	(properties)

	(method (doit &tmp temp0)
		(super doit:)
		(if state
			(suspSpeed doit: register)
			(if (not script)
				(self setScript: weaveScript)
			)
		)
		(if (and (IsObject client) (< (client y:) -50))
			(client y: -50)
		)
		(if (and (== state 2) (not (IsObject ((ScriptID 130 1) cycler:)))) ; lightBar
			(= local1 0)
			(= state 0)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(suspCar init: cel: 3 x: (+ ((ScriptID 25 2) x:) 15)) ; roadInset
				(if (not register)
					(Print 129 7) ; "Up ahead you see a car weaving."
				)
				((ScriptID 130 4) number: 252 play:) ; carSong
				(= register 55)
				(= local1 0)
				(= cycles 1)
			)
			(1 0)
			(2
				(= seconds 10)
			)
			(3
				(if (<= (suspCar nsBottom:) ((ScriptID 25 2) nsTop:)) ; roadInset
					(Print 129 8) ; "The vehicle's too far ahead of you."
					(if ((ScriptID 25 1) tZone:) ; mainInset
						(gCurRoom setScript: (ScriptID 132 3)) ; endFree1Script
					else
						(self start: 2 init:)
					)
				else
					(HandsOff)
					(client setScript: pullOverScript 0 register)
				)
			)
		)
	)
)

(instance weaveScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(cond
					((> (Random 0 99) 49)
						(= register (suspCar x:))
						(= cycles 5)
					)
					(
						(>
							(= register
								(Random
									(+ (- ((ScriptID 25 2) x:) 15) 15) ; roadInset
									(+ ((ScriptID 25 2) x:) 15 5) ; roadInset
								)
							)
							(suspCar x:)
						)
						(= local0 1)
						(= cycles 1)
					)
					(else
						(= local0 -1)
						(= cycles 1)
					)
				)
			)
			(1
				(if (== (suspCar x:) register)
					(self start: 0 dispose:)
				else
					(suspCar x: (+ (suspCar x:) local0))
					(= start state)
					(= cycles 1)
				)
			)
			(2
				(self init:)
			)
		)
	)
)

(instance pullOverScript of Script
	(properties)

	(method (doit)
		(if local2
			(if (> ((ScriptID 130 7) nsTop:) (suspCar y:)) ; copCar
				(self cue:)
				(= local2 0)
			else
				(client y: (- (client y:) 1))
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local2 0)
				(Print 129 9) ; "The driver of the vehicle sees your lights and finally begins to pull over."
				(if (> ((ScriptID 130 7) nsTop:) (suspCar y:)) ; copCar
					(= cycles 1)
				else
					(= local2 1)
				)
			)
			(1
				(self setScript: rightLaneScript)
				(= cycles 1)
			)
			(2
				(if (< ((ScriptID 25 1) mySpeed:) 5) ; mainInset
					((ScriptID 25 1) leftFlag: 0) ; mainInset
					(gCurRoom newRoom: 29)
				else
					((suspCar script:) register: (-= register 5))
					((ScriptID 25 1) calcSpeed: register) ; mainInset
					(= start state)
					(= cycles 5)
				)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance rightLaneScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 130 7) ; copCar
					setMotion:
						MoveTo
						(+ ((ScriptID 25 2) x:) 15) ; roadInset
						((ScriptID 130 7) y:) ; copCar
						self
				)
				(suspCar
					setMotion:
						MoveTo
						(+ ((ScriptID 25 2) x:) 15) ; roadInset
						(suspCar y:)
						self
				)
			)
			(1 0)
			(2
				(self dispose:)
			)
		)
	)
)

(instance suspCar of Actor
	(properties
		view 266
		loop 2
		priority 4
		signal 18448
	)

	(method (doVerb theVerb)
		(if (self onMe: (gUser curEvent:))
			(switch theVerb
				(2 ; Look
					(switch global127
						(2
							(Print 129 10) ; "It's a white Mercedes convertible, license plate #34567."
						)
						(3
							(Print 129 11) ; "It's a low-rider black Ford, license plate #22776."
						)
						(5
							(Print 129 12) ; "It's light blue Ford Escort, license plate #01923."
						)
						(4
							(Print 129 13) ; "It's a black Dodge with exempt plate of #12896."
						)
					)
					(return 1)
				)
				(else
					(return 0)
				)
			)
		else
			(return 0)
		)
	)

	(method (dispose)
		(if (gCast contains: genCar0)
			(genCar0 dispose:)
		)
		(super dispose:)
	)
)

(instance driveAwayScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (not state)
			(client
				y:
					(+
						(suspCar y:)
						(CelHigh (client view:) (client loop:) (client cel:))
						3
					)
			)
			(if (== (suspCar x:) (+ ((ScriptID 25 2) x:) 15)) ; roadInset
				(self cue:)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0 0)
			(1
				(client yStep: 5 setMotion: MoveTo (client x:) -100)
			)
		)
	)
)

(instance genCar0 of Actor
	(properties
		view 266
		loop 1
		priority 4
		signal 18448
	)

	(method (init)
		(super init:)
		(genCar1 init:)
		(genCar2 init:)
		(genCar3 init:)
		(genCar4 init:)
	)

	(method (doit)
		(if (not script)
			(= x (suspCar x:))
			(= y (+ (suspCar y:) (CelHigh view loop cel) 3))
		)
		(super doit:)
	)

	(method (dispose)
		(genCar1 dispose:)
		(genCar2 dispose:)
		(genCar3 dispose:)
		(genCar4 dispose:)
		(super dispose:)
	)
)

(instance genCar1 of Actor
	(properties
		view 266
		loop 1
		cel 1
		priority 4
		signal 18448
	)

	(method (doit)
		(= x (genCar0 x:))
		(= y (+ (genCar0 y:) (CelHigh view loop cel) 3))
		(super doit:)
	)
)

(instance genCar2 of Actor
	(properties
		view 266
		loop 1
		cel 2
		priority 4
		signal 18448
	)

	(method (doit)
		(= x (genCar1 x:))
		(= y (+ (genCar1 y:) (CelHigh view loop cel) 3))
		(super doit:)
	)
)

(instance genCar3 of Actor
	(properties
		view 266
		loop 1
		cel 3
		priority 4
		signal 18448
	)

	(method (doit)
		(= x (genCar2 x:))
		(= y (+ (genCar2 y:) (CelHigh view loop cel) 3))
		(super doit:)
	)
)

(instance genCar4 of Actor
	(properties
		view 266
		loop 1
		cel 4
		priority 4
		signal 18448
	)

	(method (doit)
		(= x (genCar3 x:))
		(= y (+ (genCar3 y:) (CelHigh view loop cel) 3))
		(super doit:)
	)
)

