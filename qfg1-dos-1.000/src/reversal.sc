;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 118)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	reversal 0
	teleport 1
)

(instance reversal of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 118)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 15 1) view: 176 setLoop: 1 cel: 0 cycleSpeed: 1) ; kobold
				(= cycles 8)
			)
			(1
				(HighPrint 118 0) ; "The Kobold casts a spell with which you are not familiar."
				((ScriptID 15 1) setCycle: End) ; kobold
				(= cycles 10)
			)
			(2
				(SetFlag 153)
				(SetFlag 344)
				(self dispose:)
			)
		)
	)
)

(instance teleport of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 118)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 15 1) ; kobold
					view: 176
					setLoop: 0
					setMotion: 0
					cel: 0
					cycleSpeed: 0
					setCycle: End self
				)
			)
			(1
				(SetFlag 313)
				((ScriptID 15 1) ; kobold
					view: 176
					posn:
						(if (IsFlag 149) 229 else 52)
						(if (IsFlag 149) 85 else 84)
					setCycle: Beg self
				)
			)
			(2
				(if (IsFlag 149)
					(ClearFlag 149)
				else
					(SetFlag 149)
				)
				(= cycles 2)
			)
			(3
				(SetFlag 344)
				(ClearFlag 313)
				(self dispose:)
			)
		)
	)
)

