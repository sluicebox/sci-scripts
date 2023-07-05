;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 436)
(include sci.sh)
(use Main)
(use Motion)
(use User)
(use System)

(public
	flyRight 0
	flyLeft 1
	startup 2
)

(instance flyRight of Script
	(properties)

	(method (doit)
		(cond
			((and (<= global333 0) (not (IsFlag 351)))
				(= global333 1)
				(client setScript: killMantray)
			)
			((<= (client distanceTo: gEgo) 52)
				((ScriptID 210 0) cue:) ; Encounter
			)
			((and (< (client y:) 15) (IsFlag 158))
				(ClearFlag 158)
			)
			((and (> (client y:) 80) (not (IsFlag 158)))
				(SetFlag 158)
			)
			((and (!= (self state:) 1) (client inRect: 120 0 200 100))
				(self changeState: 1)
			)
			((and (== (self state:) 1) (not (client inRect: 120 0 200 100)))
				(self changeState: 0)
			)
			((and (not (IsFlag 159)) (not (client inRect: 40 0 280 100)))
				(SetFlag 159)
				(self changeState: 2)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					setLoop: 0
					cel: 0
					setStep: 4 2
					setCycle: Fwd
					setMotion:
						MoveTo
						320
						(if (IsFlag 158)
							(- (client y:) 5)
						else
							(+ (client y:) 5)
						)
				)
			)
			(1
				(client
					setLoop: 4
					cel: 0
					setMotion:
						MoveTo
						(+ (client x:) 80)
						(if (IsFlag 158)
							(- (client y:) 5)
						else
							(+ (client y:) 5)
						)
				)
			)
			(2
				(client
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

	(method (doit)
		(cond
			((<= global333 0)
				(client setScript: killMantray)
			)
			((<= (client distanceTo: gEgo) 52)
				((ScriptID 210 0) cue:) ; Encounter
			)
			((and (< (client y:) 15) (IsFlag 158))
				(ClearFlag 158)
			)
			((and (> (client y:) 80) (not (IsFlag 158)))
				(SetFlag 158)
			)
			((and (!= (self state:) 1) (client inRect: 120 0 200 100))
				(self changeState: 1)
			)
			((and (== (self state:) 1) (not (client inRect: 120 0 200 100)))
				(self changeState: 0)
			)
			((and (IsFlag 159) (not (client inRect: 40 0 280 100)))
				(ClearFlag 159)
				(self changeState: 2)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					setLoop: 1
					cel: 0
					setStep: 4 2
					setCycle: Fwd
					setMotion:
						MoveTo
						0
						(if (IsFlag 158)
							(- (client y:) 5)
						else
							(+ (client y:) 5)
						)
				)
			)
			(1
				(client
					setLoop: 5
					cel: 0
					setMotion:
						MoveTo
						(- (client x:) 80)
						(if (IsFlag 158)
							(- (client y:) 5)
						else
							(+ (client y:) 5)
						)
				)
			)
			(2
				(client
					setLoop: 3
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

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (< (gEgo y:) 100)
					(User canControl: 0)
					(gEgo setMotion: 0)
				)
				(client
					ignoreActors:
					ignoreHorizon:
					posn: 144 111
					setLoop: 6
					cycleSpeed: 1
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
				(client setCel: 0 posn: 144 111)
				(= cycles 3)
			)
			(5
				(client setCel: -1 startUpd: setMotion: MoveTo 152 103 self)
			)
			(6
				(client setLoop: 0 cel: 6 setMotion: MoveTo 279 90 self)
			)
			(7
				(User canControl: 1)
				(client
					setLoop: 2
					cel: 0
					setPri: (if (== gCurRoomNum 81) 9 else -1)
					setStep: 4 1
					setMotion: MoveTo 279 79
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
				(HandsOff)
				(client
					setLoop: 3
					setCel: -1
					cycleSpeed: 0
					setCycle: Fwd
					yStep: 6
					setMotion: MoveTo (client x:) 150 self
				)
				(if (< (- (client x:) 20) (gEgo x:) (+ (client x:) 20))
					(if (< (gEgo x:) 160)
						(gEgo setMotion: MoveTo (+ (gEgo x:) 40))
					else
						(gEgo setMotion: MoveTo (- (gEgo x:) 40))
					)
				)
			)
			(1
				(SetFlag 351)
				(= global333 0)
				(client setPri: -1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

