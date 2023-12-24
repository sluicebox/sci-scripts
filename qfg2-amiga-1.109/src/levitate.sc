;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 62)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use Timer)
(use Sound)
(use Motion)
(use Actor)

(public
	levitate 0
	fallDown 1
)

(local
	lowY
	fallToY
	oldSig
	up
	floater
	moving
	deltaZ
	zStep = 3
)

(procedure (GoUp)
	(if (== moving 1)
		(= moving 0)
	else
		(= moving 1)
		(= deltaZ (Abs (- gLevHighY (- (gEgo y:) (gEgo z:)))))
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

(instance levitate of HandsOffScript
	(properties)

	(method (init)
		(SetFlag 90) ; fLevitating
		(SetFlag 87) ; fCastingSpell
		(gDirectionHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(= oldSig (gEgo signal:))
		(super init: &rest)
	)

	(method (dispose)
		(gDirectionHandler delete: self)
		(gMouseDownHandler delete: self)
		(if (gCast contains: sparkles)
			(sparkles dispose:)
		)
		(= up 0)
		(= floater 0)
		(= moving 0)
		(= deltaZ 0)
		(gGame setCursor: gWaitCursor)
		(gEgo signal: oldSig)
		(ClearFlag 90) ; fLevitating
		(ClearFlag 87) ; fCastingSpell
		(leviTimer dispose:)
		(super dispose:)
	)

	(method (doit)
		(switch state
			(3
				(if (<= (gEgo z:) 3)
					(gEgo z: 0)
					(self cue:)
				else
					(switch moving
						(0
							(++ floater)
							(if (and up (> floater 3))
								(= up (= floater 0))
								(gEgo y: (+ (gEgo y:) 1))
							)
							(if (and (not up) (> floater 3))
								(= up 1)
								(= floater 0)
								(gEgo y: (- (gEgo y:) 1))
							)
						)
						(1
							(if
								(and
									(> (-= deltaZ zStep) 0)
									(>= (- (gEgo y:) (gEgo z:)) gLevHighY)
								)
								(gEgo z: (+ (gEgo z:) zStep))
							else
								(= moving 0)
							)
						)
						(2
							(if (> (-= deltaZ zStep) 0)
								(gEgo z: (- (gEgo z:) zStep))
							else
								(= moving 0)
							)
						)
					)
				)
			)
			(4
				(cond
					((<= (gEgo z:) 3)
						(gEgo z: 0)
						(self cue:)
					)
					((> (-= deltaZ zStep) 0)
						(gEgo z: (- (gEgo z:) zStep))
					)
				)
			)
		)
		(super doit:)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			((== state 3)
				(== (gEgo cel:) 8)
				(switch (event type:)
					(evSAID
						(cond
							((or (Said 'levitate,move,go<up') (Said 'rise,up'))
								(GoUp)
							)
							(
								(or
									(Said 'levitate,move,go<down')
									(Said 'down,drop[/!*]')
								)
								(GoDown)
							)
							((Said 'stop,halt')
								(= moving 0)
							)
							((Said 'levitate,move')
								(HighPrint 62 0) ; "Which way?"
							)
							((Said 'fall[<down]')
								(HighPrint 62 1) ; "As your mind thinks the thought of falling..."
								(gEgo setScript: fallDown)
							)
							((Said 'get,get')
								(HighPrint 62 2) ; "There's no need to get that."
							)
							((Said 'ask,talk,talk')
								(HighPrint 62 3) ; "No one responds"
							)
							((Said 'look,look')
								(event claimed: 0)
							)
							(else
								(HighPrint 62 4) ; "One thing at a time, Hero."
								(event claimed: 1)
							)
						)
					)
					(evMOUSEBUTTON
						(if (> (Abs (- (gEgo x:) (event x:))) 15)
							(event claimed: 1)
						else
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
								((> (event y:) (- (gEgo y:) (gEgo z:)))
									(= deltaZ
										(Abs
											(-
												(event y:)
												(- (gEgo y:) (gEgo z:))
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

	(method (changeState newState &tmp levLoop)
		(switch (= state newState)
			(0
				(if gLevScript
					(self setScript: gLevScript self)
				else
					(self cue:)
				)
			)
			(1
				(= levLoop
					(switch (gEgo loop:)
						(0 0)
						(1 3)
						(2 1)
						(3 2)
						(4 0)
						(5 1)
						(6 2)
						(7 3)
					)
				)
				(if (== gCurRoomNum 470)
					(= levLoop 2)
				)
				(if (not gLevHighY)
					(= gLevHighY 80)
				)
				(= lowY (gEgo y:))
				(levSound init: play:)
				(gEgo
					view: 31
					setLoop: levLoop
					cel: 0
					illegalBits: 0
					ignoreActors: 1
					setPri: (gEgo priority:)
					setCycle: End self
				)
				(sparkles
					loop: 4
					cel: 0
					posn: (gEgo x:) (gEgo y:)
					init:
					setPri: (+ (gEgo priority:) 1)
					setCycle: End
				)
			)
			(2
				(sparkles setLoop: 5 setCycle: Fwd)
				(gEgo setCycle: 0 setCel: 8 z: (+ (gEgo z:) 6))
				(= cycles 1)
			)
			(3
				(HandsOn)
				(leviTimer set: leviTimer 5)
			)
			(4
				(HandsOff)
				(if (not (gEgo z:))
					(self cue:)
				else
					(= moving 2)
					(= deltaZ (Abs (- lowY (- (gEgo y:) (gEgo z:)))))
				)
			)
			(5
				(gEgo setCycle: Beg self)
				(sparkles loop: 4 cel: 8 setCycle: Beg)
			)
			(6
				(NormalEgo)
				(sparkles dispose:)
				(gEgo setPri: -1 setHeading: 180 self)
			)
			(7
				(self dispose:)
			)
		)
	)
)

(instance fallDown of HandsOffScript
	(properties)

	(method (init)
		(SetFlag 95) ; fFalling
		(super init: &rest)
	)

	(method (dispose)
		(ClearFlag 95) ; fFalling
		(super dispose:)
	)

	(method (doit &tmp oldCaller)
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
					setCycle: CT 5 1 self
				)
			)
			(1
				(= fallToY (if register register else lowY))
			)
			(2
				(gEgo setCycle: End)
				(= cycles 24)
			)
			(3
				(if (TakeDamage (/ (gEgo z:) 5))
					(gEgo loop: 3 cel: 0 cycleSpeed: 2 setCycle: End self)
				else
					(EgoDead 1 62 5 #title {You've really made an impact}) ; "You are suddenly, forcefully reminded that "It isn't the fall that hurts, it's when you hit the ground.""
				)
			)
			(4
				(NormalEgo)
				(gEgo setHeading: 180 self)
			)
			(5
				(self dispose:)
			)
		)
	)
)

(instance sparkles of Prop
	(properties
		view 31
		loop 4
		signal 16384
	)

	(method (doit)
		(self x: (gEgo x:) y: (gEgo y:) z: (gEgo z:))
		(super doit:)
	)
)

(instance leviTimer of Timer
	(properties)

	(method (cue)
		(if (and (not (UseMana 1)) (== (gEgo view:) 31))
			(gEgo setScript: fallDown)
			(self dispose:)
		else
			(self set: self 5)
		)
	)
)

(instance levSound of Sound
	(properties
		number 29
		priority 10
	)
)

