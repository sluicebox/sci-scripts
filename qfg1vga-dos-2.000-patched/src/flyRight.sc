;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 436)
(include sci.sh)
(use Main)
(use n814)
(use PolyPath)
(use Motion)
(use System)

(public
	flyRight 0
	flyLeft 1
	startup 2
	killMantray 3
)

(local
	local0
	local1
	local2
)

(instance flyRight of Script
	(properties)

	(method (dispose)
		(= local0 0)
		(super dispose:)
	)

	(method (doit)
		(cond
			((<= (client distanceTo: gEgo) 52)
				((ScriptID 210 0) cue:) ; Encounter
			)
			((and (< (client y:) 30) (IsFlag 158))
				(ClearFlag 158)
			)
			((and (> (client y:) 80) (not (IsFlag 158)))
				(SetFlag 158)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 1)
				(client
					x: (+ (client x:) 90)
					cycleSpeed: 9
					setLoop: 0
					cel: 0
					targDeltaX: -40
					setStep: 5 2
					setCycle: End
					setMotion:
						MoveTo
						280
						(if (IsFlag 158)
							(- (client y:) 5)
						else
							(+ (client y:) 5)
						)
						self
				)
			)
			(1
				(self cue:)
			)
			(2
				(= local0 0)
				(client
					cycleSpeed: 6
					setLoop: 2
					cel: 0
					setStep: 4 1
					setMotion:
						MoveTo
						(- (client x:) 2)
						(if (IsFlag 158)
							(- (client y:) 5)
						else
							(+ (client y:) 5)
						)
					setCycle: End self
				)
			)
			(3
				(= cycles 2)
			)
			(4
				(client setScript: flyLeft)
			)
		)
	)
)

(instance flyLeft of Script
	(properties)

	(method (dispose)
		(= local0 0)
		(super dispose:)
	)

	(method (doit)
		(cond
			((<= (client distanceTo: gEgo) 35)
				((ScriptID 210 0) cue:) ; Encounter
			)
			((and (< (client y:) 30) (IsFlag 158))
				(ClearFlag 158)
			)
			((and (> (client y:) 80) (not (IsFlag 158)))
				(SetFlag 158)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 0)
				(client
					x: (- (client x:) 90)
					cycleSpeed: 9
					setLoop: 1
					cel: 0
					targDeltaX: 40
					setStep: 5 2
					setCycle: End
					setMotion:
						MoveTo
						20
						(if (IsFlag 158)
							(- (client y:) 5)
						else
							(+ (client y:) 5)
						)
						self
				)
			)
			(1
				(self cue:)
			)
			(2
				(= local0 1)
				(client
					setLoop: 3
					cycleSpeed: 6
					cel: 0
					setStep: 4 1
					setMotion:
						MoveTo
						(+ (client x:) 2)
						(if (IsFlag 158)
							(- (client y:) 5)
						else
							(+ (client y:) 5)
						)
					setCycle: End self
				)
			)
			(3
				(= cycles 2)
			)
			(4
				(client setScript: flyRight)
			)
		)
	)
)

(instance startup of Script
	(properties)

	(method (dispose)
		(= local0 0)
		(super dispose:)
	)

	(method (doit)
		(if (<= (client distanceTo: gEgo) 10)
			((ScriptID 210 0) cue:) ; Encounter
			(gEgo setMotion: 0)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					ignoreHorizon:
					posn: 144 111
					setLoop: 5
					moveSpeed: 3
					cycleSpeed: 12
					setPri: (if (< (gEgo y:) 100) 9 else -1)
					setCycle: Fwd
					setStep: 4 2
					illegalBits: 0
					stopUpd:
				)
				(= cycles 5)
			)
			(1
				(client setCel: 1 posn: 145 110)
				(= cycles 2)
			)
			(2
				(client setCel: 0 posn: 144 111)
				(= cycles 2)
			)
			(3
				(client setCel: 1 posn: 145 110)
				(= cycles 2)
			)
			(4
				(client setCycle: End self)
			)
			(5
				(client
					posn: 209 103
					setLoop: 0
					setCel: -1
					setCycle: Fwd
					setMotion: MoveTo 279 90 self
				)
			)
			(6
				(self cue:)
			)
			(7
				(client
					setLoop: 2
					cel: 0
					cycleSpeed: 6
					setPri: (if (== gCurRoomNum 81) 9 else -1)
					setStep: 4 1
					setCycle: End self
				)
			)
			(8
				(= cycles 2)
			)
			(9
				(SetFlag 158)
				(SetFlag 159)
				(client setPri: 9 setScript: flyLeft)
			)
		)
	)
)

(instance killMantray of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ClearFlag 351)
				(HandsOff)
				(= local2 (gEgo moveSpeed:))
				(= local1 (gEgo cycleSpeed:))
				(if (< (register nsLeft:) (gEgo x:) (register nsRight:))
					(gEgo moveSpeed: 0 cycleSpeed: 0 ignoreActors:)
					(if (< (gEgo x:) (+ (register nsLeft:) 35))
						(gEgo
							setMotion:
								PolyPath
								(- (gEgo x:) 30)
								(gEgo y:)
								self
						)
					else
						(gEgo
							setMotion:
								PolyPath
								(+ (gEgo x:) 30)
								(gEgo y:)
								self
						)
					)
				else
					(= ticks 1)
				)
				(register
					view: 435
					setLoop: (if local0 6 else 7)
					setCel: -1
					cycleSpeed: 6
					setCycle: End self
					yStep: 6
					ignoreActors:
					ignoreHorizon:
					illegalBits: 0
					setMotion: MoveTo (register x:) 130 self
				)
			)
			(1 1)
			(2 1)
			(3
				(gEgo moveSpeed: local2 cycleSpeed: local1 ignoreActors: 0)
				(NormalEgo)
				(= global280 0)
				(register setPri: -1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

