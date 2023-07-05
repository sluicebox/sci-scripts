;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 114)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	turn 0
	halfTime 1
)

(instance turn of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 114)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 317)
				(SetFlag 316)
				(ClearFlag 318)
				(gEgo
					setLoop: 4
					illegalBits: 0
					setCel: (if (IsFlag 320) 4 else 0)
					setMotion: 0
					setCycle: 0
				)
				(if (IsFlag 320)
					(gEgo x: (+ (gEgo x:) 15))
				)
				(= cycles 4)
			)
			(1
				(gEgo
					illegalBits: 0
					setStep: 15 2
					setCycle: (if (IsFlag 320) Beg else End)
				)
				(if (IsFlag 320)
					(gEgo setMotion: MoveTo 172 94 self)
				else
					(gEgo setMotion: MoveTo 126 96 self)
				)
			)
			(2
				(gEgo
					setLoop: (if (IsFlag 320) 0 else 5)
					setCel: 0
					setStep: 3 2
					setMotion: 0
					setCycle: 0
					illegalBits: 0
				)
				(if (not (IsFlag 320))
					(gEgo x: (- (gEgo x:) 15))
				)
				(= cycles 6)
			)
			(3
				(ClearFlag 317)
				(ClearFlag 316)
				(SetFlag 318)
				(self dispose:)
			)
		)
	)
)

(instance halfTime of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 114)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 317)
				(gEgo setLoop: (if (IsFlag 320) 0 else 1) cel: 0)
				(= cycles 2)
			)
			(1
				(gEgo
					setLoop: (if (IsFlag 320) 4 else 5)
					illegalBits: 0
					cycleSpeed: 2
					setCycle: Fwd
				)
				(if (IsFlag 320)
					(gEgo setMotion: MoveTo 172 94 self)
				else
					(gEgo setMotion: MoveTo 111 96 self)
				)
			)
			(2
				(gEgo
					cycleSpeed: 0
					setCycle: 0
					setLoop: (if (IsFlag 320) 0 else 1)
					setCel: 0
				)
				(= cycles 2)
			)
			(3
				(SetFlag 318)
				(ClearFlag 317)
				(gEgo illegalBits: -32768)
				(self dispose:)
			)
		)
	)
)

