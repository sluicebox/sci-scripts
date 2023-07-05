;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 279)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	ringBell 0
)

(instance ringBell of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 279)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 93 0) notify: 2) ; rm93
				((ScriptID 93 4) setCycle: Fwd) ; bell
				(HighPrint 279 0) ; "'DING DING DING DING....' "Well, maybe the brigands aren't such inhospitable creatures after all.""
				(= seconds 5)
			)
			(1
				((ScriptID 93 5) ; archer1
					setLoop: 4
					setCel: 0
					illegalBits: 0
					init:
					setMotion:
						MoveTo
						((ScriptID 93 5) x:) ; archer1
						(- ((ScriptID 93 5) y:) 25) ; archer1
				)
				(= cycles 2)
			)
			(2
				((ScriptID 93 7) ; archer3
					setLoop: 5
					setCel: 0
					illegalBits: 0
					init:
					setMotion:
						MoveTo
						((ScriptID 93 7) x:) ; archer3
						(- ((ScriptID 93 7) y:) 25) ; archer3
				)
				(= cycles 2)
			)
			(3
				((ScriptID 93 4) setCel: 0 setCycle: 0) ; bell
				((ScriptID 93 6) ; archer2
					setLoop: 4
					setCel: 0
					illegalBits: 0
					init:
					setMotion:
						MoveTo
						((ScriptID 93 6) x:) ; archer2
						(- ((ScriptID 93 6) y:) 25) ; archer2
				)
				(= cycles 2)
			)
			(4
				((ScriptID 93 8) ; archer4
					setLoop: 5
					setCel: 0
					illegalBits: 0
					init:
					setMotion:
						MoveTo
						((ScriptID 93 8) x:) ; archer4
						(- ((ScriptID 93 8) y:) 25) ; archer4
				)
				(= cycles 2)
			)
			(5
				(= seconds 2)
			)
			(6
				((ScriptID 93 5) setCycle: End) ; archer1
				((ScriptID 93 6) setCycle: End) ; archer2
				((ScriptID 93 7) setCycle: End) ; archer3
				((ScriptID 93 8) setCycle: End) ; archer4
				(HighPrint 279 1) ; "Then again, maybe they are."
				(= seconds 4)
			)
			(7
				(EgoDead ; "The brigands have an even temperament...all bad!  You seem to have a knack for doing the wrong thing."
					279
					2
					82
					516
					0
					9
					80
					{You ring the bell and your bell gets rung.}
				)
			)
		)
	)
)

