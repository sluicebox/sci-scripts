;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 271)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	egoEntersWest 0
)

(instance egoEntersWest of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 271)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 6 123 self)
			)
			(1
				(if (IsFlag 273)
					(EgoDead 271 0 82 516 0 9 80 {Greedy Greedy Greedy .}) ; "The brigands were waiting for you to come back. They expected you to make another try for some of their treasure."
				else
					((ScriptID 93 0) notify: 0) ; rm93
					(if (IsFlag 238)
						(gEgo illegalBits: $8000)
					else
						(gEgo illegalBits: $9000)
					)
					(if (not (or (IsFlag 83) (IsFlag 237)))
						(HighPrint 271 1) ; "Grumble Grumble Grumble. Stupid guard duty, third time this week. Why always me? Grumble Grumble Grumble."
					)
					(HandsOn)
					(self dispose:)
				)
			)
		)
	)
)

