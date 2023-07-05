;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 113)
(include sci.sh)
(use Main)
(use System)

(public
	Slash 0
	ParryUp 1
)

(instance Slash of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 113)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ClearFlag 318)
				(= cycles 0)
				(gEgo
					setLoop: (if (IsFlag 149) 5 else 4)
					setCel: 0
					setMotion: 0
					setCycle: 0
				)
				(= cycles 3)
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
				(gEgo setCel: 2)
				(= cycles 3)
			)
			(3
				(gEgo setLoop: (if (IsFlag 149) 1 else 0) setCel: 0)
				(SetFlag 318)
				(self dispose:)
			)
		)
	)
)

(instance ParryUp of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 113)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ClearFlag 318)
				(= cycles 0)
				(gEgo
					setLoop: (if (IsFlag 149) 9 else 8)
					setCel: 0
					setMotion: 0
					setCycle: 0
				)
				(= cycles 8)
			)
			(1
				(gEgo setLoop: (if (IsFlag 149) 1 else 0) setCel: 0)
				(SetFlag 318)
				(self dispose:)
			)
		)
	)
)

