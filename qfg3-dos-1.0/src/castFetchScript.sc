;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37)
(include sci.sh)
(use Main)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	castFetchScript 0
)

(local
	local0
	local1
	local2
	[local3 4] = [30 -30 20 -20]
	[local7 4] = [-45 -45 -50 -50]
	[local11 8] = [0 1 0 2 0 1 2 3]
	[local19 8] = [0 1 1 2 0 1 2 3]
	[local27 4] = [2 3 6 7]
)

(instance castFetchScript of Script
	(properties)

	(method (init param1 &tmp temp0)
		(proc0_14 ((User curEvent:) x:) ((User curEvent:) y:))
		(if (>= argc 3)
			(= register (Collect new:))
			(for ((= temp0 2)) (< temp0 argc) ((++ temp0))
				(if (IsObject [param1 temp0])
					(register add: [param1 temp0])
				)
			)
		)
		(super init: [param1 0] [param1 1])
	)

	(method (dispose)
		(if (IsObject register)
			(register release: dispose:)
		)
		(super dispose:)
	)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: 0)
				(= cycles 5)
				(= local0 (gEgo cel:))
			)
			(1
				(gEgo
					setHeading:
						(GetAngle (gEgo x:) (gEgo y:) global386 global387)
						self
				)
			)
			(2
				(= local1 (gEgo loop:))
				(if (and (> (gEgo view:) 17) (< (gEgo view:) 21))
					(gEgo
						view: 18
						loop: [local19 (gEgo loop:)]
						cel: 0
						setCycle: CT 6 1 self
					)
				else
					(gEgo
						view: 14
						loop: [local11 (gEgo loop:)]
						setCycle: End self
					)
				)
			)
			(3
				(if (and (> (gEgo view:) 17) (< (gEgo view:) 21))
					(gEgo setCycle: CT 0 1)
				)
				((= local2 (Actor new:))
					view: 21
					setLoop: 7
					x:
						(+
							(gEgo x:)
							(/
								(* (gEgo maxScale:) [local3 (gEgo loop:)])
								128
							)
						)
					y:
						(+
							(gEgo y:)
							(/
								(* (gEgo maxScale:) [local7 (gEgo loop:)])
								128
							)
						)
					setStep: 12 12
					ignoreActors:
					illegalBits: 0
					ignoreHorizon:
					init:
					setScale: -1 gEgo
					setCycle: Fwd
					setMotion: MoveTo global386 global387 self
					setPri: 14
				)
				(gLongSong2 number: 900 setLoop: 1 play:)
			)
			(4
				(if (IsObject register)
					(if (= temp0 (register firstTrue: #onMe local2))
						(temp0 doVerb: -82)
						(= cycles 5)
					else
						(gMessager say: 1 6 1 0 self 37) ; "You didn't manage to fetch anything."
					)
				else
					(gMessager say: 1 6 1 0 self 37) ; "You didn't manage to fetch anything."
				)
			)
			(5
				(local2
					setMotion:
						MoveTo
						(+
							(gEgo x:)
							(/
								(* (gEgo maxScale:) [local3 (gEgo loop:)])
								128
							)
						)
						(+
							(gEgo y:)
							(/
								(* (gEgo maxScale:) [local7 (gEgo loop:)])
								128
							)
						)
						self
				)
			)
			(6
				(local2 dispose:)
				(if (and (> (gEgo view:) 17) (< (gEgo view:) 21))
					(self cue:)
				else
					(gEgo setCycle: Beg self)
				)
			)
			(7
				(if (and (> (gEgo view:) 17) (< (gEgo view:) 21))
					(gEgo
						view: 20
						cel: local0
						loop: [local27 (gEgo loop:)]
					)
				else
					(gEgo normalize: local1)
				)
				(= cycles 2)
			)
			(8
				(if (and (> (gEgo view:) 17) (< (gEgo view:) 21))
					(gEgo cel: (gEgo lastCel:))
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

