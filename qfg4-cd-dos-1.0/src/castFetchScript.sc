;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37)
(include sci.sh)
(use Main)
(use Array)
(use Sound)
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
	local3
	local4
	local5
	local6
	local7
)

(instance castFetchScript of Script
	(properties)

	(method (init param1 &tmp temp0 temp1)
		(= local3 (IntArray with: 30 -30 20 -20))
		(= local4 (IntArray with: -35 -35 -40 -40))
		(= local5 (IntArray with: 0 1 0 2 0 1 2 3))
		(= local6 (IntArray with: 0 1 1 2 0 1 2 3))
		(= local7 (IntArray with: 2 3 6 7))
		(= temp1 0)
		(proc0_12 ((User curEvent:) x:) ((User curEvent:) y:))
		(if (>= argc 2)
			(= register myCollection)
			(for ((= temp0 1)) (< temp0 argc) ((++ temp0))
				(if [param1 temp0]
					(= temp1 1)
					(register add: [param1 temp0])
				)
			)
		)
		(if (not temp1)
			(= register 0)
			(super init: param1 &rest)
		else
			(= lastTicks gGameTime)
			(if (>= argc 1)
				((= client [param1 0]) script: self)
				(if (>= argc 2)
					(= caller [param1 1])
				)
			)
			(= state (- start 1))
			(self cue:)
		)
	)

	(method (dispose)
		(local3 dispose:)
		(local4 dispose:)
		(local5 dispose:)
		(local6 dispose:)
		(local7 dispose:)
		(if (and register (!= gCurRoomNum 800) (not (IsFlag 353)))
			(register dispose:)
		)
		(super dispose:)
	)

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: 0)
				(= cycles 5)
				(= local0 (gEgo cel:))
			)
			(1
				(gEgo
					setHeading:
						(GetAngle (gEgo x:) (gEgo y:) global441 global442)
						self
				)
			)
			(2
				(= local1 (gEgo loop:))
				(if (and (> (gEgo view:) 17) (< (gEgo view:) 21))
					(gEgo
						view: 18
						loop: (local6 at: (gEgo loop:))
						cel: 0
						setCycle: CT 6 1 self
					)
				else
					(gEgo
						view: 14
						loop: (local5 at: (gEgo loop:))
						setCycle: End self
					)
				)
			)
			(3
				(if (and (> (gEgo view:) 17) (< (gEgo view:) 21))
					(gEgo setCycle: CT 0 1)
				)
				((= local2 (Actor new:))
					signal: 24577
					view: 21
					setLoop: 7 1
					x:
						(+
							(gEgo x:)
							(/
								(*
									(gEgo maxScale:)
									(local3 at: (gEgo loop:))
								)
								128
							)
						)
					y:
						(+
							(gEgo y:)
							(/
								(*
									(gEgo maxScale:)
									(local4 at: (gEgo loop:))
								)
								128
							)
						)
					setStep: 12 12
					illegalBits: 0
					init:
					setCycle: Fwd
					setMotion: MoveTo global441 global442 self
					setPri: 180
				)
				(if (gEgo scaler:)
					(local2 setScaler: gEgo)
				)
				(soundFX number: 934 play:)
			)
			(4
				(if register
					(= temp0 0)
					(if (= temp0 (register firstTrue: #onMe local2))
						(temp0 doVerb: -87)
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
								(*
									(gEgo maxScale:)
									(local3 at: (gEgo loop:))
								)
								128
							)
						)
						(+
							(gEgo y:)
							(/
								(*
									(gEgo maxScale:)
									(local4 at: (gEgo loop:))
								)
								128
							)
						)
						self
				)
			)
			(6
				(local2 hide:)
				(if (and (> (gEgo view:) 17) (< (gEgo view:) 21))
					(self cue:)
				else
					(gEgo setCycle: Beg self)
				)
			)
			(7
				(local2 dispose:)
				(if (and (> (gEgo view:) 17) (< (gEgo view:) 21))
					(gEgo
						view: 20
						cel: local0
						loop: (local7 at: (gEgo loop:))
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
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance soundFX of Sound
	(properties)
)

(instance myCollection of Collect
	(properties)

	(method (dispose)
		(if elements
			(DisposeList elements)
		)
		(= size (= elements 0))
		(DisposeClone self)
	)
)

