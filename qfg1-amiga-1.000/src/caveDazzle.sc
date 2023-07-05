;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 123)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	caveDazzle 0
	koboldDazzle 1
)

(local
	local0
)

(instance caveDazzle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 521
					setLoop: (if (IsFlag 149) 2 else 3)
					cel: 0
					setCycle: CT 4 1 self
				)
			)
			(1
				(SetFlag 294)
				(gEgo setCycle: End)
				(= cycles 6)
			)
			(2
				(NormalEgo)
				(LookAt gEgo (ScriptID 15 1)) ; kobold
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

(instance koboldDazzle of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 123)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ClearFlag 157)
				(SetFlag 216)
				(ClearFlag 314)
				(= local0 0)
				(if (< global315 2)
					((ScriptID 15 1) ; kobold
						posn: ((ScriptID 15 2) x:) ((ScriptID 15 2) y:) ; body, body
					)
					((ScriptID 15 2) dispose:) ; body
					(= global315 2)
				)
				((ScriptID 15 1) view: 179 setCel: 0 forceUpd:) ; kobold
				(= cycles 10)
			)
			(1
				((ScriptID 15 1) setCel: -1 cycleSpeed: 2 setCycle: CT 2 1) ; kobold
				(= cycles 10)
			)
			(2
				(++ local0)
				((ScriptID 15 1) setCel: 3) ; kobold
				(= cycles 4)
			)
			(3
				((ScriptID 15 1) setCel: 4) ; kobold
				(= cycles 4)
			)
			(4
				(if (< local0 5)
					(self changeState: 2)
				else
					(= cycles 15)
				)
			)
			(5
				((ScriptID 15 1) setCel: 5) ; kobold
				(= seconds 3)
			)
			(6
				(SetFlag 344)
				(ClearFlag 216)
				(SetFlag 280)
				(self dispose:)
			)
		)
	)
)

