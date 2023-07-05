;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 31)
(include sci.sh)
(use Main)
(use n026)
(use PolyPath)
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
	[local4 4] = [135 225 45 315]
	[local8 8] = [0 1 0 2 0 1 2 3]
	local16
	local17
	local18
	local19
	local20
	local21
	[local22 10]
)

(instance leviCode of Code
	(properties)

	(method (init param1)
		(HandsOff)
		(gEgo setMotion: 0)
		(if argc
			(= local0 [param1 0])
			(= local1 [param1 1])
		else
			(= local0 (gEgo x:))
			(= local1 (gEgo y:))
			(sLevitate start: 2)
		)
		(if (> argc 2)
			(= local2 [param1 2])
		)
		(if (> argc 3)
			(= local3 (Min [param1 3] 3))
		)
		((ScriptID gCurRoomNum) setScript: sLevitate)
	)
)

(instance sLevitate of Script
	(properties)

	(method (doit &tmp temp0)
		(super doit: &rest)
		(if (< state 9)
			(if (>= state 3)
				(cond
					((gEgo mover:)
						(if (== state 5)
							(= local21 0)
						else
							(= local21
								(+
									(- local1 ((gEgo mover:) y:))
									(gEgo z:)
								)
							)
						)
						(gEgo y: local1 x: local0 setMotion: 0)
					)
					((< (gEgo z:) local2)
						(cond
							((< local21 (gEgo z:))
								(gEgo z: (- (gEgo z:) 1))
							)
							((> local21 (gEgo z:))
								(gEgo z: (+ (gEgo z:) 1))
							)
						)
					)
					((< local21 local2)
						(gEgo z: (- (gEgo z:) 1))
					)
				)
			)
			(if (IsObject local20)
				(local20 z: (gEgo z:))
			)
			(if (== state 4)
				(if
					(and
						(not
							(if
								(and
									(> (gEgo view:) 17)
									(< (gEgo view:) 21)
								)
							)
						)
						(> (Abs (- gGameTime local19)) 50)
					)
					(= local19 gGameTime)
					(if (not (gEgo useMana: 1))
						(self cue:)
					)
				)
				(if (<= (gEgo z:) 0)
					(= state 7)
					(gEgo z: 0)
					(self cue:)
				)
			)
			(if (<= (gEgo z:) 0)
				(if (== state 5)
					(self cue:)
				)
				(gEgo z: 0)
			)
		)
	)

	(method (dispose)
		(= gUseObstacles 1)
		(gEgo z: 0)
		(= local16 0)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (and (> (gEgo view:) 17) (< (gEgo view:) 21))
					(= local16 1)
				)
				(gEgo setMotion: PolyPath local0 local1 self)
			)
			(1
				(cond
					(local16
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
						(gEgo setHeading: [local4 local3] self)
					)
					(else
						(self cue:)
					)
				)
			)
			(2
				(= gUseObstacles 0)
				(= local17 (gEgo loop:))
				(if local16
					(gEgo
						view: 19
						setLoop: 5
						setCel: 0
						setCycle: CT 4 1 self
						xStep: 0
						setPri: (gEgo priority:)
					)
				else
					(gEgo
						view: 17
						setLoop:
							(if local3 local3 else [local8 (gEgo loop:)])
						setCel: 0
						setCycle: End self
						xStep: 0
						setPri: (gEgo priority:)
					)
				)
				(gLongSong2 number: 281 setLoop: 1 play:)
			)
			(3
				(if local16
					(gEgo
						loop: 6
						setCel: 0
						setMotion: MoveTo (gEgo x:) (- (gEgo y:) 10)
					)
				else
					(gEgo
						setCel: 255
						setMotion: MoveTo (gEgo x:) (- (gEgo y:) 10)
					)
				)
				((= local20 (Prop new:))
					view: 17
					loop: 4
					x: (gEgo x:)
					y: (+ (gEgo y:) 1)
					setCycle: Fwd
					setScale:
					scaleX: (gEgo scaleX:)
					scaleY: (gEgo scaleY:)
					priority: (gEgo priority:)
					signal: 16400
					init:
				)
				(= cycles 15)
			)
			(4
				(User canControl: 1 canInput: 1)
				(gTheIconBar enable: 1 advanceCurIcon:)
			)
			(5
				(HandsOff)
				(= local16 0)
				(local20 dispose:)
				(= local20 0)
				(gMessager say: 1 6 1 1 0 31) ; "Oops, you have a sudden empty feeling, sort of like the one you get when you find yourself falling. Or maybe like the one you get when you're totally out of Mana. In fact, it's both of those."
				(= register (gEgo z:))
				(gEgo
					view: 6
					setLoop: (if (Random 0 1) 0 else 4)
					cel: 0
					setCycle: CT 2 1
					setMotion: MoveTo (gEgo x:) (+ local1 10)
				)
			)
			(6
				(ShakeScreen 2)
				(gEgo setCycle: End self)
				(gLongSong2 number: 901 play:)
			)
			(7
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
			(8
				(if (IsObject local20)
					(local20 dispose:)
					(= local20 0)
					(if local16
						(gEgo loop: 5 cel: 4 setCycle: Beg self)
					else
						(gEgo setCycle: Beg self)
					)
				else
					(gEgo normalize: local17)
					(HandsOn)
					(self dispose:)
				)
			)
			(9
				(if local16
					(gEgo view: 20 loop: 2 cel: 4)
				else
					(gEgo normalize: local17)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

