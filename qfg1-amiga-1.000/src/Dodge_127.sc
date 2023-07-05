;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 127)
(include sci.sh)
(use Main)
(use System)

(public
	Dodge 0
	Duck 1
	Thrust 2
)

(instance Dodge of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 127)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ClearFlag 318)
				(= cycles 0)
				(gEgo
					setLoop: (if (IsFlag 149) 1 else 0)
					setCel: 1
					setMotion: 0
					setCycle: 0
				)
				(= cycles 10)
			)
			(1
				(SetFlag 318)
				(gEgo setCel: 0)
				(self dispose:)
			)
		)
	)
)

(instance Duck of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(SetFlag 318)
		(DisposeScript 127)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ClearFlag 318)
				(= cycles 0)
				(gEgo
					setLoop: (if (IsFlag 149) 1 else 0)
					setCel: 2
					setMotion: 0
					setCycle: 0
				)
				(= cycles 10)
			)
			(1
				(gEgo setCel: 0)
				(self dispose:)
			)
		)
	)
)

(instance Thrust of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(SetFlag 318)
		(DisposeScript 127)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ClearFlag 318)
				(= cycles 0)
				(gEgo
					setLoop: (if (IsFlag 149) 3 else 2)
					setCel: 0
					setMotion: 0
					setCycle: 0
				)
				(= cycles 2)
			)
			(1
				(gEgo setCel: 1)
				(if
					(and
						(>= global344 (Random100))
						(!= ((ScriptID 15 1) script:) (ScriptID 118 1)) ; kobold, teleport
					)
					(SetFlag 319)
					(-= global343 global345)
				)
				(= cycles 2)
			)
			(2
				(gEgo setCel: 0)
				(= cycles 2)
			)
			(3
				(gEgo setLoop: (if (IsFlag 149) 1 else 0) setCel: 0)
				(self dispose:)
			)
		)
	)
)

