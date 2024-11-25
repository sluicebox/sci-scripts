;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 128)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	DodgeLeft 0
	DodgeRight 1
	Duck 2
	Lunge 3
)

(instance DodgeLeft of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 128)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ClearFlag 318)
				(= cycles 0)
				(gEgo
					setLoop: (if (IsFlag 149) 6 else 1)
					setCel: 0
					setMotion: 0
					setCycle: 0
				)
				(= cycles 10)
			)
			(1
				(gEgo setLoop: (if (IsFlag 149) 5 else 0) setCel: 0)
				(SetFlag 318)
				(self dispose:)
			)
		)
	)
)

(instance DodgeRight of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 128)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ClearFlag 318)
				(= cycles 0)
				(gEgo
					setLoop: (if (IsFlag 149) 7 else 2)
					setCel: 0
					setMotion: 0
					setCycle: 0
				)
				(= cycles 10)
			)
			(1
				(gEgo setLoop: (if (IsFlag 149) 5 else 0) setCel: 0)
				(SetFlag 318)
				(self dispose:)
			)
		)
	)
)

(instance Duck of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 128)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ClearFlag 318)
				(= cycles 0)
				(gEgo
					setLoop: (if (IsFlag 149) 8 else 3)
					setCel: 0
					setMotion: 0
					setCycle: 0
				)
				(= cycles 10)
			)
			(1
				(gEgo setLoop: (if (IsFlag 149) 5 else 0) setCel: 0)
				(SetFlag 318)
				(self dispose:)
			)
		)
	)
)

(instance Lunge of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(SetFlag 318)
		(DisposeScript 128)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(ClearFlag 318)
				(gEgo
					setLoop: (if (IsFlag 149) 5 else 0)
					setCel: -1
					setMotion: 0
					cel: 0
					illegalBits: 0
					setCycle: CT 4 1 self
				)
			)
			(1
				(if
					(and
						(>= global344 (Random100))
						(!= ((ScriptID 15 1) script:) (ScriptID 118 1)) ; kobold, teleport
					)
					(SetFlag 319)
					(-= global343 global345)
				)
				(= cycles 4)
			)
			(2
				(gEgo setCycle: End self)
			)
			(3
				(gEgo illegalBits: $8000 setCel: 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

