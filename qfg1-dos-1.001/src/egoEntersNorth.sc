;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 272)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	egoEntersNorth 0
)

(instance egoEntersNorth of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 272)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo illegalBits: 0 setMotion: MoveTo 174 115 self)
			)
			(1
				((ScriptID 93 0) notify: 0) ; rm93
				(gEgo illegalBits: -32768)
				(if (not (or (IsFlag 83) (IsFlag 237)))
					(HighPrint 272 0) ; "Grumble Grumble Grumble. Stupid guard duty, third time this week. Why always me? Grumble Grumble Grumble."
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

