;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31)
(include sci.sh)
(use Main)
(use DeathIcon)
(use Array)
(use PolyPath)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	leviCode 0
	sLevitate 1
)

(local
	local0
	local1
	local2 = 100
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
)

(instance leviCode of Code
	(properties)

	(method (init param1 param2 param3 param4 param5)
		(gGlory handsOff:)
		(gEgo setMotion: 0)
		(if argc
			(= local0 param1)
			(= local1 param2)
		else
			(= local0 (gEgo x:))
			(= local1 (gEgo y:))
			(sLevitate start: 2)
		)
		(if (> argc 2)
			(= local2 param3)
		)
		(if (> argc 3)
			(= local12 param4)
		else
			(= local12 0)
		)
		(if (> argc 4)
			(= local3 (Min param5 3))
		)
		((ScriptID gCurRoomNum) setScript: sLevitate)
	)
)

(instance sLevitate of Script
	(properties)

	(method (doit &tmp temp0)
		(super doit: &rest)
		(if (< state 12)
			(if (> state 5)
				(cond
					((gEgo mover:)
						(if (== state 8)
							(= local11 0)
						else
							(if ((gEgo mover:) isKindOf: PolyPath)
								(= local11
									(+
										(- local1 ((gEgo mover:) finalY:))
										(gEgo z:)
									)
								)
							else
								(= local11
									(+
										(- local1 ((gEgo mover:) y:))
										(gEgo z:)
									)
								)
							)
							(gEgo y: local1 x: local0 setMotion: 0)
						)
					)
					((== state 6)
						(cond
							((< (gEgo z:) local2)
								(cond
									((< local11 (gEgo z:))
										(gEgo z: (- (gEgo z:) 1))
									)
									((> local11 (gEgo z:))
										(gEgo z: (+ (gEgo z:) 1))
									)
								)
							)
							((< local11 local2)
								(gEgo z: (- (gEgo z:) 1))
							)
						)
					)
				)
			)
			(if local10
				(local10 z: (gEgo z:))
			)
			(if local13
				(local13
					scaleX: (- 128 (gEgo z:))
					scaleY: (- 128 (gEgo z:))
				)
			)
			(if (== state 6)
				(if
					(and
						(not
							(and (> (gEgo view:) 17) (< (gEgo view:) 21))
						)
						(> (Abs (- gGameTime local9)) 50)
					)
					(= local9 gGameTime)
					(if (not (gEgo useMana: 1))
						(self cue:)
					)
				)
				(if (<= (gEgo z:) 0)
					(= state 10)
					(gEgo z: 0)
					(self cue:)
				)
			)
		)
		(if (== state 8)
			(if (<= (gEgo z:) 0)
				(self cue:)
			else
				(gEgo z: (- (gEgo z:) 6))
			)
		)
		(if (<= (gEgo z:) 0)
			(gEgo z: 0)
		)
	)

	(method (dispose)
		(= start 0)
		(if local10
			(local10 dispose:)
			(= local10 0)
		)
		(if local13
			(local13 dispose:)
			(= local13 0)
		)
		(if local4
			(local4 dispose:)
			(= local4 0)
		)
		(if local5
			(local5 dispose:)
			(= local5 0)
		)
		(= gUseObstacles 1)
		(gEgo z: 0)
		(= local6 0)
		(super dispose:)
		(if local12
			(local12 cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if (and (> (gEgo view:) 17) (< (gEgo view:) 21))
					(= local6 1)
				)
				(gEgo setMotion: PolyPath local0 local1 self)
			)
			(1
				(= local4 (IntArray with: 135 225 45 315))
				(= local5 (IntArray with: 0 1 0 2 0 1 2 3))
				(cond
					(local6
						((gEgo looper:) dispose:)
						(gEgo looper: 0)
						(Face
							gEgo
							(+ (gEgo x:) 5)
							(+ (gEgo y:) 5)
							self
						)
					)
					(local3
						(gEgo setHeading: (local4 at: local3) self)
					)
					(else
						(self cue:)
					)
				)
			)
			(2
				(if (not local4)
					(= local4 (IntArray with: 135 225 45 315))
					(= local5 (IntArray with: 0 1 0 2 0 1 2 3))
				)
				(= gUseObstacles 0)
				(= local7 (gEgo loop:))
				(if local6
					(gEgo
						view: 19
						setLoop: (if (mod local7 2) 13 else 12) 1
						setCel: 0
						setCycle: End self
						xStep: 0
						setPri: (gEgo priority:)
					)
				else
					(gEgo
						view: 17
						setLoop:
							(if local3
								local3
							else
								(local5 at: (gEgo loop:))
							)
							1
						setCel: 0
						setCycle: End self
						xStep: 0
						setPri: (gEgo priority:)
					)
				)
				(soundFX number: 941 play:)
			)
			(3
				(if local6
					(gEgo
						setLoop: (if (mod local7 2) 15 else 14) 1
						setCel: 0
					)
				else
					(gEgo setCel: 255)
				)
				(gEgo z: 4)
				((= local10 (Prop new:))
					signal: 26625
					view: 17
					loop: 4
					x: (gEgo x:)
					y: (+ (gEgo y:) 1)
					setCycle: Fwd
					setScale:
					scaleX: (gEgo scaleX:)
					scaleY: (gEgo scaleY:)
					priority: (gEgo priority:)
					fixPriority: 1
					init:
				)
				((= local13 (Prop new:))
					signal: 24577
					view: 17
					loop:
						(if local6
							(- (gEgo loop:) 8)
						else
							(+ (gEgo loop:) 6)
						)
					x: (gEgo x:)
					y: (+ (gEgo y:) 1)
					setCycle: Fwd
					setScale: gEgo
					priority: (gEgo priority:)
					fixPriority: 1
					init:
				)
				(= ticks 10)
			)
			(4
				(gEgo z: 8)
				(= ticks 10)
			)
			(5
				(gEgo z: 12)
				(= local11 12)
				(= ticks 10)
			)
			(6
				(User canControl: 1 canInput: 1)
				(gTheIconBar enable: 0 advanceCurIcon:)
			)
			(7
				(gGlory handsOff:)
				(= local6 0)
				(local10 dispose:)
				(= local10 0)
				(gMessager say: 1 6 1 1 self 31) ; "Oops, you have a sudden empty feeling, sort of like the one you get when you find yourself falling. Or maybe like the one you get when you're totally out of Mana. In fact, it's both of those."
			)
			(8
				(= register (gEgo z:))
				(gEgo setLoop: 10 1)
			)
			(9
				(ShakeScreen 2)
				(local13 dispose:)
				(= local13 0)
				(gEgo
					view: 6
					setLoop: (if (mod (gEgo loop:) 2) 2 else 0)
					setCel: 3
					setCycle: End self
				)
				(soundFX number: 909 play:)
			)
			(10
				(if (gEgo takeDamage: (/ register 5))
					(gEgo
						loop: (+ (gEgo loop:) 2)
						cel: 0
						setCycle: End self
					)
				else
					(EgoDead 2 31) ; "You are forcefully reminded that it's not the fall that kills you, it's the sudden stop at the end."
				)
			)
			(11
				(if local10
					(local10 dispose:)
					(local13 dispose:)
					(= local13 0)
					(= local10 0)
					(if local6
						(gEgo loop: 5 cel: 4 setCycle: Beg self)
					else
						(gEgo setCycle: Beg self)
					)
				else
					(gEgo normalize: local7)
					(gGlory handsOn:)
					(self dispose:)
				)
			)
			(12
				(if local6
					(gEgo view: 20 loop: 2 cel: 4)
				else
					(gEgo normalize: local7)
				)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soundFX of Sound
	(properties)
)

