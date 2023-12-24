;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 61)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use Motion)
(use Actor)

(public
	rope 0
	coil 1
	ropeClimb 2
	ropeFall 3
)

(local
	saveX
	saveY
	whichLoop
	highY
	lowY
	fallToY
	oldSig
	oldBits
	atStart = 1
	overTheTop
	moving
	deltaZ
	zStep = 4
)

(procedure (GoUp)
	(if (== moving 1)
		(= moving 0)
	else
		(= moving 1)
		(= deltaZ 190)
	)
)

(procedure (GoDown)
	(if (== moving 2)
		(= moving 0)
	else
		(= moving 2)
		(= deltaZ (Abs (- lowY (- (gEgo y:) (gEgo z:)))))
	)
)

(instance ropeClimb of HandsOffScript
	(properties)

	(method (init)
		(gDirectionHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(= oldSig (gEgo signal:))
		(= oldBits (gEgo illegalBits:))
		(if (not gRopeHighY)
			(= gRopeHighY 100)
		)
		(SetFlag 91) ; fUsingRope
		(-- gRopeUses)
		(super init: &rest)
	)

	(method (dispose)
		(gDirectionHandler delete: self)
		(gMouseDownHandler delete: self)
		(ClearFlag 88) ; fClimbingRope
		(ClearFlag 91) ; fUsingRope
		(if overTheTop
			(gEgo signal: oldSig)
		)
		(= moving 0)
		(= deltaZ 0)
		(super dispose:)
	)

	(method (doit &tmp oldCaller)
		(switch state
			(7
				(if (<= (gEgo z:) 4)
					(gEgo z: 0)
					(self cue:)
				else
					(switch moving
						(1
							(if (>= (- (gEgo y:) (gEgo z:)) highY)
								(if (> (-= deltaZ zStep) 0)
									(gEgo
										z: (+ (gEgo z:) zStep)
										cel:
											(if (== (gEgo cel:) 3)
												0
											else
												(+ (gEgo cel:) 1)
											)
									)
								else
									(= moving 0)
								)
							else
								(= oldSig (gEgo signal:))
								(= oldCaller caller)
								(= caller 0)
								(client setScript: ropeFall oldCaller)
								(return)
							)
						)
						(2
							(if (> (-= deltaZ zStep) 0)
								(gEgo
									z: (- (gEgo z:) zStep)
									cel:
										(if (== (gEgo cel:) 0)
											3
										else
											(- (gEgo cel:) 1)
										)
								)
							else
								(= moving 0)
							)
						)
					)
				)
			)
			(8
				(cond
					((<= (gEgo z:) 4)
						(gEgo z: 0)
						(self cue:)
					)
					((> (-= deltaZ zStep) 0)
						(gEgo
							z: (- (gEgo z:) zStep)
							cel:
								(if (== (gEgo cel:) 0)
									3
								else
									(- (gEgo cel:) 1)
								)
						)
					)
				)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((== state 7)
				(== (gEgo loop:) 9)
				(switch (event type:)
					(evSAID
						(cond
							((Said 'go,climb,climb,move<up')
								(GoUp)
							)
							((Said 'go,climb,climb,move<down')
								(GoDown)
							)
							((Said 'stop,halt')
								(= moving 0)
							)
							((Said 'climb,climb,move')
								(HighPrint 61 0) ; "Which way?"
							)
							((Said 'get,get')
								(HighPrint 61 1) ; "There's no need to get that."
							)
							((Said 'ask,talk,talk')
								(HighPrint 61 2) ; "No one responds"
							)
							((Said 'look,look')
								(event claimed: 0)
							)
							(else
								(HighPrint 61 3) ; "One thing at a time, Hero."
								(event claimed: 1)
							)
						)
					)
					(evMOUSEBUTTON
						(cond
							((== (event modifiers:) emSHIFT)
								(event claimed: 0)
							)
							(
								(or
									(> (Abs (- (gEgo x:) (event x:))) 15)
									(== (event modifiers:) emCTRL)
								)
								(event claimed: 1)
							)
							(else
								(cond
									(
										(<
											(event y:)
											(- (- (gEgo y:) (gEgo z:)) 50)
										)
										(= deltaZ
											(Abs
												(-
													(event y:)
													(-
														(-
															(gEgo y:)
															(gEgo z:)
														)
														50
													)
												)
											)
										)
										(= moving 1)
									)
									(
										(>
											(event y:)
											(- (gEgo y:) (gEgo z:))
										)
										(= deltaZ
											(Abs
												(-
													(event y:)
													(-
														(gEgo y:)
														(gEgo z:)
													)
												)
											)
										)
										(= moving 2)
									)
									(else
										(= moving 0)
									)
								)
								(event claimed: 1)
							)
						)
					)
					($0040 ; direction
						(switch (event message:)
							(JOY_UP
								(GoUp)
							)
							(JOY_DOWN
								(GoDown)
							)
							(JOY_NULL
								(= moving 0)
							)
						)
						(event claimed: 1)
					)
				)
			)
			(else
				(event claimed: 1)
			)
		)
	)

	(method (changeState newState &tmp ropeX ropeY ropeCel climbLength)
		(switch (= state newState)
			(0
				(if gRopeScript
					(self setScript: gRopeScript self)
				else
					(self cue:)
				)
			)
			(1
				(TrySkill 11 80) ; climb
				(= saveX (gEgo x:))
				(= saveY (gEgo y:))
				(= whichLoop (if (mod (gEgo loop:) 2) 1 else 0))
				(gEgo view: 8 loop: whichLoop cel: 0 setCycle: End)
				(= cycles 12)
			)
			(2
				(= ropeX
					(if whichLoop
						(- (gEgo x:) 13)
					else
						(+ (gEgo x:) 13)
					)
				)
				(cond
					((< (= climbLength (- (= ropeY (- (gEgo y:) 7)) gRopeHighY)) 40)
						(= ropeCel 7)
						(= highY (- ropeY 25))
					)
					((< climbLength 60)
						(= ropeCel 10)
						(= highY (- ropeY 55))
					)
					(else
						(= ropeCel 13)
						(= highY (- ropeY 75))
					)
				)
				(coil loop: (+ whichLoop 2) posn: ropeX ropeY init: setCycle: End)
				(rope posn: ropeX ropeY init: setCycle: CT ropeCel 1 self)
				(gEgo loop: (+ whichLoop 5) cel: 0 setCycle: End)
			)
			(3
				(NormalEgo)
				(gEgo
					ignoreActors: 1
					setMotion: MoveTo (coil x:) (+ (coil y:) 5) self
				)
			)
			(4
				(gEgo setHeading: 0 self)
			)
			(5
				(gEgo
					view: 6
					setLoop: 8
					cel: 0
					illegalBits: 0
					ignoreActors: 1
					setPri: (+ (gEgo priority:) 1)
					setCycle: End self
				)
			)
			(6
				(gEgo z: (+ (gEgo z:) 5))
				(= cycles 2)
			)
			(7
				(SetFlag 88) ; fClimbingRope
				(gGame setCursor: gNormalCursor)
				(gEgo setLoop: 9 cel: 0 y: (- (gEgo y:) 9))
				(= lowY (gEgo y:))
				(HandsOn)
			)
			(8
				(HandsOff)
				(ClearFlag 88) ; fClimbingRope
				(if (not (gEgo z:))
					(self cue:)
				else
					(GoDown)
				)
			)
			(9
				(gEgo setLoop: 8 cel: 2 y: (+ (gEgo y:) 9))
				(= cycles 1)
			)
			(10
				(gEgo setCycle: Beg self)
			)
			(11
				(NormalEgo)
				(gEgo setMotion: MoveTo saveX saveY self)
			)
			(12
				(gEgo view: 8 loop: (+ whichLoop 5) setCycle: End self)
			)
			(13
				(gEgo cycleSpeed: 1 setCycle: Beg)
				(rope setCycle: Beg self)
				(coil setCycle: Beg)
			)
			(14
				(rope dispose:)
				(coil dispose:)
				(if (not gRopeUses)
					(self cue:)
				else
					(gEgo
						view: 8
						loop: whichLoop
						cel: 6
						cycleSpeed: 0
						setCycle: Beg self
					)
				)
			)
			(15
				(NormalEgo)
				(gEgo setHeading: 180 self)
				(if (not gRopeUses)
					(HighPrint 61 4) ; "You're at the end of your rope. It's magic is gone, and so is it."
					(gEgo use: 16) ; Rope
				)
				(self dispose:)
			)
		)
	)
)

(instance ropeFall of HandsOffScript
	(properties)

	(method (init)
		(SetFlag 95) ; fFalling
		(super init: &rest)
	)

	(method (dispose)
		(ClearFlag 88) ; fClimbingRope
		(ClearFlag 91) ; fUsingRope
		(ClearFlag 95) ; fFalling
		(super dispose:)
	)

	(method (doit)
		(if (== state 1)
			(cond
				((not (gEgo z:))
					(gEgo y: fallToY)
					(self cue:)
				)
				((<= (gEgo z:) 12)
					(gEgo z: 0)
				)
				(else
					(gEgo z: (- (gEgo z:) 12))
				)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 6
					loop: 2
					cel: 0
					cycleSpeed: 0
					moveSpeed: 0
					setCycle: CT 5 1 self
				)
			)
			(1
				(= fallToY
					(if register
						register
					else
						(+ lowY 15)
					)
				)
				(rope setCycle: Beg)
				(coil setCycle: Beg)
			)
			(2
				(gEgo setCycle: End)
				(= cycles 24)
			)
			(3
				(if (TakeDamage (/ (gEgo z:) 5))
					(gEgo loop: 3 cel: 0 cycleSpeed: 1 setCycle: End self)
				else
					(EgoDead 1 61 5 #title {You've really made an impact}) ; "You are suddenly, forcefully reminded that "It isn't the fall that hurts, it's when you hit the ground.""
				)
			)
			(4
				(NormalEgo)
				(gEgo setHeading: 45 self)
			)
			(5
				(rope hide:)
				(gEgo
					setMotion: MoveTo (+ (coil x:) 13) (+ (coil y:) 7) self
				)
			)
			(6
				(rope dispose:)
				(coil dispose:)
				(gEgo
					view: 8
					loop: 1
					cel: 6
					cycleSpeed: 0
					setCycle: Beg self
				)
			)
			(7
				(= atStart 1)
				(= overTheTop 0)
				(NormalEgo)
				(self dispose:)
			)
		)
	)
)

(instance coil of Prop
	(properties
		description {the coil of rope}
		lookStr {It is your Magic Rope.}
		view 8
		loop 3
		signal 16384
		cycleSpeed 1
	)
)

(instance rope of Prop
	(properties
		description {your Magic Rope}
		lookStr {Your Magic Rope performs well.}
		view 8
		loop 4
		signal 16384
	)
)

