;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 231)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	pullChain 0
	takeADive 1
)

(instance pullChain of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 231)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo view: 298 posn: 34 73 setLoop: 2 setCel: 0)
				(= cycles 3)
			)
			(1
				(gEgo setCel: 1)
				((ScriptID 96 14) setCel: 7) ; chain
				(= cycles 3)
			)
			(2
				(gEgo setCel: 0)
				((ScriptID 96 14) setCel: 6) ; chain
				(= cycles 3)
			)
			(3
				(gEgo setCel: 1)
				((ScriptID 96 14) setCel: 7) ; chain
				(= cycles 3)
			)
			(4
				(NormalEgo)
				(gEgo setPri: 7 loop: 0)
				((ScriptID 96 14) setCel: 6) ; chain
				(if (not (IsFlag 259))
					(SetFlag 259)
					((ScriptID 96 6) dispose:) ; head
					((ScriptID 96 5) setLoop: 5) ; yorick
				)
				(if (not (client cel:))
					(client setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(5
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance takeADive of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 231)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(client setCycle: End self)
			)
			(1
				(if (not (IsFlag 259))
					((ScriptID 96 6) dispose:) ; head
				)
				(if (IsFlag 268)
					(HighPrint 231 0) ; "Elsa is right next door. I'll go set up the secret exit for your escape."
				)
				((ScriptID 96 5) view: 298 setLoop: 1 setCel: 0) ; yorick
				(= cycles 2)
			)
			(2
				((ScriptID 96 5) setCel: 1) ; yorick
				(= cycles 1)
			)
			(3
				((ScriptID 96 5) setCel: 2) ; yorick
				(= cycles 1)
			)
			(4
				((ScriptID 96 5) setCel: 3 y: (- ((ScriptID 96 5) y:) 10)) ; yorick, yorick
				(= cycles 1)
			)
			(5
				((ScriptID 96 5) setCel: 4 y: (- ((ScriptID 96 5) y:) 14)) ; yorick, yorick
				(= cycles 1)
			)
			(6
				((ScriptID 96 5) dispose:) ; yorick
				(client setCycle: Beg self)
			)
			(7
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

