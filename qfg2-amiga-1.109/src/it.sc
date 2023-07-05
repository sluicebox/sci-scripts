;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 491)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use Interface)
(use Motion)
(use Actor)
(use System)

(public
	it 0
	disposeRope 1
)

(local
	J
	[ropey 10]
	ropeX = 258
	ropeY = 147
	[LdeltaX 4] = [-4 0 2 0]
	[LdeltaY 4] = [10 13 17 18]
	[RdeltaX 4] = [4 8 5 9]
	[RdeltaY 4] = [2 11 16 25]
	Index
	centerTimer
	centered
	sideKeys
	fallTimer
	fallRight
	balanceHigh
	agilityHigh
	testYourSkill
	stepCount
	ropeCount
)

(procedure (checkBalance)
	(cond
		((> (Random 50 balanceHigh) [gEgoStats 2]) ; agility
			(if (< centered 0)
				(-- centered)
			else
				(++ centered)
			)
		)
		((> centered 0)
			(-- centered)
		)
		(else
			(++ centered)
		)
	)
)

(procedure (checkAgility)
	(= fallTimer 0)
	(cond
		((> (+ [gEgoStats 2] 10) (Random 30 agilityHigh)) ; agility
			(= centered 0)
			(= sideKeys 0)
			(SkillUsed 2 20) ; agility
			(straightAndLevel)
		)
		((== (gEgo loop:) 2)
			(= fallRight 1)
			(gEgo setScript: dashing)
		)
		((== (gEgo loop:) 1)
			(= fallRight 0)
			(gEgo setScript: dashing)
		)
		(else
			(holdPosition)
		)
	)
)

(procedure (straightAndLevel)
	(gEgo view: 285 setLoop: 3 cel: 0 setPri: 13 cycleSpeed: 1 setCycle: Fwd)
)

(procedure (fallingRight)
	(gEgo view: 285 setLoop: 2 cel: 0 setPri: 11 cycleSpeed: 1 setCycle: Fwd)
	(= fallTimer 12)
)

(procedure (fallingLeft)
	(gEgo view: 285 setLoop: 1 cel: 0 setPri: 11 cycleSpeed: 1 setCycle: Fwd)
	(= fallTimer 12)
)

(procedure (holdPosition)
	(gEgo view: 285 loop: 4 cel: 0 setPri: 13 cycleSpeed: 1 setCycle: Fwd)
)

(procedure (overCorrectLeft)
	(if (> (- [gEgoStats 2] (Random 30 agilityHigh)) 18) ; agility
		(fallingRight)
	else
		(checkAgility)
	)
)

(procedure (overCorrectRight)
	(if (> (- [gEgoStats 2] (Random 30 agilityHigh)) 18) ; agility
		(fallingLeft)
	else
		(checkAgility)
	)
)

(procedure (canEgoStep)
	(cond
		((> (/ (+ [gEgoStats 2] [gEgoStats 2]) 2) (Random 50 balanceHigh)) ; agility, agility
			(gEgo setScript: stepForward)
		)
		((== (mod (Random 50 balanceHigh) 2) 1)
			(= sideKeys 1)
			(fallingLeft)
		)
		(else
			(= sideKeys 1)
			(fallingRight)
		)
	)
)

(instance it of Actor
	(properties
		x -10
		view 490
		loop 1
	)

	(method (init)
		(gEgo setScript: ropeMe)
		(= balanceHigh 79)
		(= agilityHigh 79)
		(super init:)
	)

	(method (doit)
		(cond
			((not centerTimer))
			((-- centerTimer))
			(else
				(checkBalance)
				(= centerTimer 10)
				(if (== (++ testYourSkill) 8)
					(= testYourSkill 0)
					(SkillUsed 11 10) ; climb
				)
			)
		)
		(cond
			((not fallTimer))
			((-- fallTimer))
			((== (gEgo loop:) 1)
				(= fallRight 0)
				(gEgo setScript: dashing)
			)
			((== (gEgo loop:) 2)
				(= fallRight 1)
				(gEgo setScript: dashing)
			)
		)
		(cond
			((< centered -2)
				(= centerTimer 0)
				(= centered 0)
				(fallingLeft)
			)
			((> centered 2)
				(= centerTimer 0)
				(= centered 0)
				(fallingRight)
			)
		)
		(super doit:)
	)
)

(instance aRope of View
	(properties
		description {the magic rope}
		lookStr {It's your magic rope... you know, the one you've carried with you for days and days.}
		view 490
		loop 2
		priority 13
		signal 16400
	)
)

(instance ropeMe of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 294 166 self)
			)
			(1
				(gEgo view: 8 loop: 1 cel: 0 setCycle: End self)
			)
			(2
				(NormalEgo)
				(= cycles 4)
			)
			(3
				(= [ropey J] (aRope new:))
				([ropey J] x: ropeX y: ropeY init: stopUpd:)
				(= cycles 1)
			)
			(4
				(if (< ropeCount 8)
					(++ ropeCount)
					(++ J)
					(-= ropeX 26)
					(-= ropeY 2)
					(self changeState: 3)
				else
					(self cue:)
				)
			)
			(5
				(gEgo setPri: 13 setMotion: MoveTo 292 160 self)
			)
			(6
				(gEgo view: 3 setPri: 13 loop: 3 cel: 2)
				(= cycles 2)
			)
			(7
				(gEgo cel: 3 setPri: 13 posn: 285 153)
				(= cycles 2)
			)
			(8
				(gEgo cel: 4 setPri: 13 posn: 278 150)
				(= cycles 2)
			)
			(9
				(gEgo cel: 5 setPri: 13 posn: 276 148)
				(= cycles 2)
			)
			(10
				(gEgo view: 4 setPri: 13 loop: 1 cel: 0 posn: 272 146)
				(= cycles 2)
			)
			(11
				(HighPrint 491 0) ; "You glance down. You shiver for a moment, knowing that it's a long way down, and there is no net."
				(gEgo view: 285 loop: 0 cel: 3 setPri: 13 posn: 263 146)
				(= cycles 2)
			)
			(12
				(gCurRoom setScript: tightropeWalk)
				(self dispose:)
			)
		)
	)
)

(instance dashing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= Index 0)
				(HandsOff)
				(gCurRoom setScript: 0)
				(= centered 0)
				(gEgo
					view: 6
					setLoop: (if fallRight 4 else 2)
					illegalBits: 0
					setPri: (if fallRight 11 else 14)
					cel: 0
				)
				(= cycles 3)
			)
			(1
				(gEgo
					cel: (+ (gEgo cel:) 1)
					x:
						(+
							(gEgo x:)
							(if fallRight
								[RdeltaX Index]
							else
								[LdeltaX Index]
							)
						)
					y:
						(+
							(gEgo y:)
							(if fallRight
								[RdeltaY Index]
							else
								[LdeltaY Index]
							)
						)
				)
				(++ Index)
				(= cycles 1)
			)
			(2
				(if (< Index 5)
					(self changeState: 1)
				else
					(= Index 0)
					(self cue:)
				)
			)
			(3
				(gEgo hide:)
				(= cycles 1)
			)
			(4
				(HighPrint 491 1 80 {Nice of you to drop in!}) ; "Your life passes before your eyes, or is it just the other buildings? As you are about to become street pizza, let's hope you saved your game recently."
				(gCurRoom newRoom: 790)
				(HandsOn)
			)
		)
	)
)

(instance tightropeWalk of HandsOffScript
	(properties)

	(method (init)
		(super init: &rest)
		(gDirectionHandler add: self)
		(gMouseDownHandler addToFront: self)
		(= centerTimer 10)
		(= sideKeys 0)
	)

	(method (dispose)
		(= fallTimer 0)
		(= centerTimer 0)
		(gDirectionHandler delete: self)
		(gMouseDownHandler delete: self)
		(super dispose: &rest)
	)

	(method (handleEvent event &tmp theAngle)
		(if (super handleEvent: event)
			(return 1)
		)
		(switch (event type:)
			(evMOUSEBUTTON
				(if (not (gEgo script:))
					(cond
						(
							(or
								(<
									(= theAngle
										(GetAngle
											(gEgo x:)
											(gEgo y:)
											(event x:)
											(event y:)
										)
									)
									45
								)
								(> theAngle 315)
							)
							(if (== (gEgo loop:) 2)
								(= fallRight 1)
								(gEgo setScript: dashing)
							else
								(overCorrectLeft)
							)
						)
						((< 135 theAngle 225)
							(if (== (gEgo loop:) 1)
								(= fallRight 0)
								(gEgo setScript: dashing)
							else
								(overCorrectRight)
							)
						)
						((< 225 theAngle 315)
							(if (not sideKeys)
								(canEgoStep)
							)
						)
						((< 45 theAngle 135)
							(holdPosition)
						)
					)
				)
			)
			($0040 ; direction
				(event claimed: 1)
				(if (!= (gEgo script:) stepForward)
					(switch (event message:)
						(JOY_LEFT
							(if (not sideKeys)
								(canEgoStep)
							)
						)
						(JOY_RIGHT
							(holdPosition)
						)
						(JOY_DOWN
							(if (== (gEgo loop:) 1)
								(= fallRight 0)
								(gEgo setScript: dashing)
							else
								(overCorrectRight)
							)
						)
						(JOY_UP
							(if (== (gEgo loop:) 2)
								(= fallRight 1)
								(gEgo setScript: dashing)
							else
								(overCorrectLeft)
							)
						)
					)
				)
			)
		)
	)
)

(instance stepForward of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (> [gEgoStats 2] (Random 30 agilityHigh)) ; agility
					(self cue:)
				else
					(holdPosition)
					(self dispose:)
				)
			)
			(1
				(if (> stepCount 2)
					(= stepCount 0)
					(gEgo posn: (gEgo x:) (- (gEgo y:) 1))
				)
				(gEgo
					view: 285
					loop: 0
					cel: 0
					setPri: 13
					cycleSpeed: 1
					setCycle: End
					setMotion: MoveTo (- (gEgo x:) 5) (gEgo y:) self
				)
				(++ stepCount)
			)
			(2
				(straightAndLevel)
				(switch gArcadeLevel
					(1
						(= cycles 3)
					)
					(2
						(= cycles 11)
					)
					(3
						(= cycles 18)
					)
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance disposeRope of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(if [ropey J]
					([ropey J] dispose:)
				)
				(self cue:)
			)
			(2
				(-- J)
				(= cycles 1)
			)
			(3
				(if (> J -1)
					(self changeState: 1)
				else
					(Print 491 2 #title {Bye, rope}) ; "You have used the last magic of the rope."
					(gEgo use: 16) ; Rope
					(DontTalk 0)
					(self dispose:)
				)
			)
		)
	)
)

