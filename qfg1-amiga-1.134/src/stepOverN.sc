;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 195)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	stepOverN 0
	stepOverS 1
)

(instance stepOverN of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 195)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 94 0) notify: 6) ; rm94
				(HandsOff)
				(gEgo illegalBits: 0)
				(if (< (gEgo y:) 77)
					(gEgo setMotion: MoveTo (gEgo x:) 90 self)
				else
					(gEgo setMotion: MoveTo (gEgo x:) 69 self)
				)
			)
			(1
				((ScriptID 94 0) notify: 7) ; rm94
				(if (< (gEgo y:) 77)
					(gEgo setMotion: MoveTo 214 67 self)
				else
					(gEgo illegalBits: -32768)
					(self changeState: 3)
				)
			)
			(2
				((ScriptID 94 17) setCel: 2 setPri: 1 init:) ; door
				(= cycles 1)
			)
			(3
				((ScriptID 94 0) notify: 4) ; rm94
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance stepOverS of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 195)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 94 0) notify: 6) ; rm94
				(HandsOff)
				(gEgo illegalBits: 0)
				(if (< (gEgo y:) 156)
					(gEgo setMotion: MoveTo (gEgo x:) 168 self)
				else
					(gEgo setMotion: MoveTo (gEgo x:) 150 self)
				)
			)
			(1
				((ScriptID 94 0) notify: 7) ; rm94
				(gEgo illegalBits: -32768)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

