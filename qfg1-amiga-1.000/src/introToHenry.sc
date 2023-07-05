;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 143)
(include sci.sh)
(use Main)
(use TalkObj)
(use System)

(public
	introToHenry 0
)

(instance introToHenry of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 143)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 10)
			)
			(1
				(HandsOff)
				((ScriptID 83 1) caller: self) ; hermitTalk
				(Say (ScriptID 83 1) 143 0) ; "Ello. 'Ow are you? 'Ave we met before?", hermitTalk
			)
			(2
				(Say (ScriptID 83 1) 143 1) ; "I'm 'Enry the 'ermit, that's me. Me Farther was an 'ermit and me Murther was an 'ermit sos I come by me job rightly.", hermitTalk
			)
			(3
				(Say (ScriptID 83 1) 143 2) ; "Don't 'ave too many visitors. 'Ermits don't, you know. (Part o' the job description.) I likes to see a new face, though.", hermitTalk
			)
			(4
				(Say (ScriptID 83 1) 143 3) ; "Good to 'ear anurther's speaking besides meself. Sos wot can I do for you?", hermitTalk
			)
			(5
				(HandsOn)
			)
		)
	)
)

