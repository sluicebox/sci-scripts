;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 273)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	egoEntersSouth 0
)

(instance egoEntersSouth of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 273)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 235 176 self)
			)
			(1
				(if (IsFlag 273)
					(EgoDead 273 0 82 516 0 9 80 {Greedy Greedy Greedy .}) ; "The brigands were waiting for you to come back. They expected you to make another try for some of their treasure."
				else
					((ScriptID 93 0) notify: 0) ; rm93
					(if (IsFlag 238)
						(gEgo illegalBits: -32768)
					else
						(gEgo illegalBits: -28672)
					)
					(if (not (or (IsFlag 83) (IsFlag 237)))
						(HighPrint 273 1) ; "Grumble Grumble Grumble. Stupid guard duty, third time this week. Why always me? Grumble Grumble Grumble."
					)
					(HandsOn)
					(self dispose:)
				)
			)
		)
	)
)

