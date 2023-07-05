;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32)
(include sci.sh)
(use Main)
(use Chase)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	project 0
)

(local
	local0
	[local1 4] = [20 -20 10 -10]
	[local5 4]
	local9 = 30
	[local10 4] = [10 -10 -10 10]
	[local14 4] = [-5 -5 -5 -5]
	local18
	local19
	local20
	local21
	[local22 8] = [0 1 2 3 0 1 0 1]
	[local30 8] = [0 1 0 0 0 1 0 1]
	[local38 4] = [2 3 6 7]
)

(instance project of Script
	(properties)

	(method (init param1 param2 param3 param4)
		(= lastTicks gGameTime)
		(if (>= argc 1)
			((= client param1) script: self)
			(if (>= argc 2)
				(= caller param2)
				(if (>= argc 3)
					(= register param3)
					(if (>= argc 4)
						(= local20 param4)
					else
						(= local20 0)
					)
				)
			)
		)
		(= state (- start 1))
		(self cue:)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(proc0_14 ((User curEvent:) x:) ((User curEvent:) y:))
				(Face gEgo global386 global387 self)
			)
			(1
				(if (or (== register 56) (== register 11))
					(proc0_14 194 90)
				)
				(if (== register 11)
					(= register 20)
				)
				(= local19 (gEgo heading:))
				(= local0 (gEgo loop:))
				(gEgo setMotion: 0)
				(gEgo
					view:
						(cond
							((< register 75) 9)
							(
								(==
									(if
										(and
											(> (gEgo view:) 17)
											(< (gEgo view:) 21)
										)
									)
									1
								)
								18
							)
							(else 14)
						)
					loop:
						(cond
							((<= 0 local19 85)
								(= local18 2)
							)
							((<= 86 local19 180)
								(= local18 0)
							)
							((<= 181 local19 274)
								(= local18 1)
							)
							(else
								(= local18 3)
							)
						)
					setCel: 0
				)
				(cond
					((< register 75)
						(gEgo setCycle: CT 4 1 self)
					)
					(
						(==
							(if
								(and
									(> (gEgo view:) 17)
									(< (gEgo view:) 21)
								)
							)
							1
						)
						(gEgo setCycle: CT 2 1 self)
					)
					(else
						(gEgo setCycle: End self)
					)
				)
			)
			(2
				(if (OneOf register 33 20)
					(gEgo useSkill: 10 25) ; throw
					(gEgo useSkill: 0 2) ; strength
					(= temp0 (Random 0 (>> (+ (- 300 [gEgoStats 10]) 4) $0002))) ; throw
					(+=
						global386
						(if (Random 0 1)
							(- 0 temp0)
						else
							temp0
						)
					)
					(+=
						global387
						(if (Random 0 1)
							(- 0 temp0)
						else
							temp0
						)
					)
				)
				((ProjObj new:)
					signal: 16
					priority: (gEgo priority:)
					type: register
					init:
				)
				(switch register
					(81
						(gLongSong2 number: 13 setLoop: 1 play:)
					)
					(83
						(gLongSong2 number: 943 setLoop: 1 play:)
					)
					(88
						(gLongSong2 number: 11 setLoop: 1 play:)
					)
					(else
						(gLongSong2 number: 916 setLoop: 1 play:)
					)
				)
				(if
					(or
						(if (and (> (gEgo view:) 17) (< (gEgo view:) 21))
						)
						(< register 75)
					)
					(gEgo setCycle: End self)
				else
					(gEgo setCycle: Beg self)
				)
			)
			(3
				(if
					(not
						(if (and (> (gEgo view:) 17) (< (gEgo view:) 21))
						)
					)
					(gEgo normalize: local0)
				else
					(gEgo
						view: 20
						loop: [local38 (gEgo loop:)]
						cel: (if (< [local38 (gEgo loop:)] 6) 4 else 5)
					)
				)
				(= cycles 2)
			)
			(4
				(if (not (IsFlag 15))
					(HandsOn)
				)
				(self dispose:)
			)
		)
	)
)

(class ProjObj of Actor
	(properties
		signal 4096
		type 0
		cuedOnce 0
	)

	(method (init)
		(if (== type 20)
			(gEgo drop: 10 1) ; theDaggers
		)
		(if (== type 33)
			(gEgo drop: 23 1) ; theRocks
		)
		(self
			view: (if (> type 75) 21 else 46)
			setLoop:
				(switch type
					(20
						(+ [local30 local0] 2)
					)
					(33 4)
					(81 2)
					(83 13)
					(32 4)
					(16 6)
					(56 6)
					(else 4)
				)
			x:
				(+
					(gEgo x:)
					(/
						(*
							(gEgo scaleY:)
							(switch (gEgo view:)
								(14 [local1 (gEgo loop:)])
								(9 [local10 (gEgo loop:)])
								(18 [local1 (gEgo loop:)])
								(else [local10 (gEgo loop:)])
							)
						)
						128
					)
				)
			y:
				(+
					(gEgo y:)
					(/
						(*
							(gEgo scaleY:)
							(switch (gEgo view:)
								(14 [local5 (gEgo loop:)])
								(9 [local14 (gEgo loop:)])
								(else [local14 (gEgo loop:)])
							)
						)
						128
					)
				)
			setStep: 8 5
			z:
				(if (IsObject local20)
					(+ (local20 z:) local9)
				else
					local9
				)
			moveSpeed: 0
			ignoreActors: 1
			ignoreHorizon: 1
			illegalBits: 0
			setScale: -1 gEgo
			setCycle: (if (== type 56) 0 else Fwd)
		)
		(if (IsObject local20)
			(self setMotion: Chase local20 0 self)
		else
			(self setMotion: MoveTo global386 (+ global387 local9) self)
		)
		(super init:)
		(SetNowSeen self)
	)

	(method (doit &tmp temp0 temp1 temp2)
		(super doit: &rest)
		(= temp2 (/ (- nsRight nsLeft) 2))
		(if
			(or
				(and
					(not cuedOnce)
					(IsObject gList)
					(= temp0
						(gList
							firstTrue: #onMe (+ nsLeft temp2) (+ nsTop temp2)
						)
					)
				)
				local21
			)
			(switch type
				(20
					(= temp1 (+ 8 (/ [gEgoStats 0] 20))) ; strength
				)
				(33
					(= temp1 (+ 5 (/ [gEgoStats 0] 20))) ; strength
				)
				(81
					(= temp1 (+ 10 (/ [gEgoStats 25] 10))) ; flameDartSpell
				)
				(83
					(= temp1 (+ 10 (/ [gEgoStats 27] 20))) ; forceBoltSpell
				)
				(88
					(= temp1 (+ 12 (/ [gEgoStats 32] 10))) ; lightningBallSpell
				)
			)
			(cond
				((IsObject local20)
					(local20 getHurt: type temp1)
				)
				((IsObject temp0)
					(temp0 getHurt: type temp1)
				)
			)
			(= local21 0)
			(self cue:)
		)
	)

	(method (cue)
		(if (not cuedOnce)
			(= cuedOnce 1)
			(if (IsObject local20)
				(= local21 1)
			)
			(self setScript: checkLoop self)
		else
			(self setMotion: 0 dispose:)
		)
	)
)

(instance checkLoop of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== (client view:) 21)
					(cond
						((== (client loop:) 13)
							(client setLoop: 14 setMotion: 0 setCycle: End self)
							(gLongSong2 number: 930 setLoop: 1 play: 127)
						)
						((< -1 (client loop:) 4)
							(client setLoop: 9 setMotion: 0 setCycle: End self)
							(gLongSong2 number: 930 setLoop: 1 play: 127)
						)
						((< (client loop:) 6)
							(client setLoop: 10 setMotion: 0 setCycle: End self)
							(gLongSong2 number: 930 setLoop: 1 play:)
						)
						(else
							(self cue:)
						)
					)
				else
					(gLongSong2 number: 921 setLoop: 1 play: 127)
					(self dispose:)
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

