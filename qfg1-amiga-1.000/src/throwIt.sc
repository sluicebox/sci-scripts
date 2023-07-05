;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 229)
(include sci.sh)
(use Main)
(use Chase)
(use Jump)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	throwIt 0
)

(local
	local0
	[local1 3] = [-9 -2 3]
	[local4 3] = [-17 -16 -16]
	[local7 3] = [8 9 9]
	[local10 5] = [-18 -16 -3 1 6]
	[local15 5] = [-31 -29 -28 -27 -29]
	[local20 5] = [-1 1 2 3 1]
)

(instance poof of Prop
	(properties
		view 297
		loop 7
	)
)

(instance thingThrown of Act
	(properties
		z 30
		yStep 10
		view 297
		xStep 15
	)
)

(instance throwIt of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 229)
		(DisposeScript 972)
		(DisposeScript 991)
	)

	(method (doit)
		(if
			(and
				(not local0)
				(or
					(IsFlag 257)
					(== (gEgo onControl: 1) 16384)
					((ScriptID 96 9) script:) ; door11
				)
			)
			(= local0 1)
			(= cycles 0)
			(self changeState: 7)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(SetFlag 271)
				(User canInput: 0)
				(if (IsFlag 259)
					(switch ((ScriptID 96 5) cel:) ; yorick
						(0
							(poof
								posn:
									(+ ((ScriptID 96 5) x:) [local10 0]) ; yorick
									(+ ((ScriptID 96 5) y:) [local15 0]) ; yorick
							)
						)
						(1
							(poof
								posn:
									(+ ((ScriptID 96 5) x:) [local10 1]) ; yorick
									(+ ((ScriptID 96 5) y:) [local15 1]) ; yorick
							)
						)
						(2
							(poof
								posn:
									(+ ((ScriptID 96 5) x:) [local10 2]) ; yorick
									(+ ((ScriptID 96 5) y:) [local15 2]) ; yorick
							)
						)
						(3
							(poof
								posn:
									(+ ((ScriptID 96 5) x:) [local10 3]) ; yorick
									(+ ((ScriptID 96 5) y:) [local15 3]) ; yorick
							)
						)
						(4
							(poof
								posn:
									(+ ((ScriptID 96 5) x:) [local10 4]) ; yorick
									(+ ((ScriptID 96 5) y:) [local15 4]) ; yorick
							)
						)
					)
				else
					((ScriptID 96 5) ; yorick
						setLoop: 2
						setCel: ((ScriptID 96 6) cel:) ; head
						stopUpd:
					)
					((ScriptID 96 6) setCel: 3) ; head
					(switch ((ScriptID 96 5) cel:) ; yorick
						(0
							(poof
								posn:
									(+ ((ScriptID 96 5) x:) [local1 0]) ; yorick
									(+ ((ScriptID 96 5) y:) [local4 0]) ; yorick
							)
						)
						(1
							(poof
								posn:
									(+ ((ScriptID 96 5) x:) [local1 1]) ; yorick
									(+ ((ScriptID 96 5) y:) [local4 1]) ; yorick
							)
						)
						(2
							(poof
								posn:
									(+ ((ScriptID 96 5) x:) [local1 2]) ; yorick
									(+ ((ScriptID 96 5) y:) [local4 2]) ; yorick
							)
						)
					)
				)
				(poof
					setPri: (+ ((ScriptID 96 5) priority:) 2) ; yorick
					ignoreActors:
					init:
					setCycle: CT 3 1 self
				)
			)
			(1
				(if (IsFlag 259)
					(switch ((ScriptID 96 5) cel:) ; yorick
						(0
							(thingThrown
								posn:
									(+ ((ScriptID 96 5) x:) [local10 0]) ; yorick
									(+ ((ScriptID 96 5) y:) [local20 0]) ; yorick
							)
						)
						(1
							(thingThrown
								posn:
									(+ ((ScriptID 96 5) x:) [local10 1]) ; yorick
									(+ ((ScriptID 96 5) y:) [local20 1]) ; yorick
							)
						)
						(2
							(thingThrown
								posn:
									(+ ((ScriptID 96 5) x:) [local10 2]) ; yorick
									(+ ((ScriptID 96 5) y:) [local20 2]) ; yorick
							)
						)
						(3
							(thingThrown
								posn:
									(+ ((ScriptID 96 5) x:) [local10 3]) ; yorick
									(+ ((ScriptID 96 5) y:) [local20 3]) ; yorick
							)
						)
						(4
							(thingThrown
								posn:
									(+ ((ScriptID 96 5) x:) [local10 4]) ; yorick
									(+ ((ScriptID 96 5) y:) [local20 4]) ; yorick
							)
						)
					)
				else
					(switch ((ScriptID 96 5) cel:) ; yorick
						(0
							(thingThrown
								posn:
									(+ ((ScriptID 96 5) x:) [local1 0]) ; yorick
									(+ ((ScriptID 96 5) y:) [local7 0]) ; yorick
							)
						)
						(1
							(thingThrown
								posn:
									(+ ((ScriptID 96 5) x:) [local1 1]) ; yorick
									(+ ((ScriptID 96 5) y:) [local7 1]) ; yorick
							)
						)
						(2
							(thingThrown
								posn:
									(+ ((ScriptID 96 5) x:) [local1 2]) ; yorick
									(+ ((ScriptID 96 5) y:) [local7 2]) ; yorick
							)
						)
					)
				)
				(thingThrown
					setLoop: 8
					setCel: (Random 0 5)
					setPri: (gEgo priority:)
					ignoreActors:
					illegalBits: 0
					init:
					setMotion: Chase gEgo 20 self
				)
				(poof setCycle: End)
			)
			(2
				(HandsOff)
				(thingThrown
					setPri: (- (gEgo priority:) 1)
					setMotion: Chase gEgo 0 self
				)
			)
			(3
				(SetFlag 260)
				(gEgo
					view: 296
					loop:
						(if (or (== (gEgo loop:) 1) (== (gEgo loop:) 3))
							7
						else
							6
						)
					cel: 1
				)
				((ScriptID 96 16) ; effect
					number: (SoundFX 86)
					loop: 1
					priority: 2
					play:
				)
				(TakeDamage 1)
				(cond
					((> (gEgo x:) ((ScriptID 96 5) x:)) ; yorick
						(if (and (< (gEgo x:) 313) (< (gEgo y:) 186))
							(gEgo
								posn: (+ (gEgo x:) 6) (+ (gEgo y:) 3)
							)
						)
					)
					((and (> (gEgo x:) 6) (< (gEgo y:) 186))
						(gEgo posn: (- (gEgo x:) 6) (+ (gEgo y:) 3))
					)
				)
				(if (not (IsFlag 259))
					((ScriptID 96 6) setCel: 1) ; head
					((ScriptID 96 5) setLoop: 0 setCel: 0 stopUpd:) ; yorick
				)
				(poof dispose:)
				(= cycles 1)
			)
			(4
				(if (> (gEgo x:) ((ScriptID 96 5) x:)) ; yorick
					(thingThrown
						setPri:
							(cond
								((> (gEgo y:) 138) 11)
								((> (gEgo y:) 115) 8)
								(else 7)
							)
						setMotion:
							JumpTo
							(- (gEgo x:) (Random 30 60))
							210
							self
					)
				else
					(thingThrown
						setMotion:
							JumpTo
							(+ (gEgo x:) (Random 30 60))
							210
							self
					)
				)
			)
			(5
				(thingThrown dispose:)
				(HandsOn)
				(ClearFlag 260)
				(NormalEgo)
				(LookAt gEgo (ScriptID 96 5)) ; yorick
				(User canInput: 1)
				(= cycles 2)
			)
			(6
				(HandsOn)
				(ClearFlag 271)
				(client setScript: 0)
			)
			(7
				(if (and (not (IsFlag 259)) (IsFlag 257))
					((ScriptID 96 6) setCel: 3) ; head
					((ScriptID 96 5) ; yorick
						setLoop: 4
						cel: 0
						cycleSpeed: 1
						setCycle: Fwd
					)
				)
				(poof dispose:)
				(thingThrown dispose:)
				(User canInput: 1)
				(= cycles 2)
			)
			(8
				(HandsOn)
				(ClearFlag 271)
				(client setScript: 0)
			)
		)
	)
)

