;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 210)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	EnterRoom 0
	RunAway 1
)

(instance EnterRoom of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 210)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(switch gPrevRoomNum
					(12
						(gEgo
							posn: 10 125
							loop: 0
							setMotion: MoveTo 50 125 self
						)
						(if (IsFlag 20)
							(gMuleObj
								posn: 10 135
								loop: 0
								setMotion: MoveTo 50 135
							)
						)
					)
					(else
						(gEgo
							posn: 310 125
							loop: 1
							setMotion: MoveTo 260 125 self
						)
						(if (IsFlag 20)
							(gMuleObj
								posn: 315 140
								loop: 1
								setMotion: MoveTo 265 140
							)
						)
					)
				)
			)
			(1
				(HandsOn)
				(cond
					((not (gCast contains: (ScriptID 11 1))) 0) ; hunter
					((not (IsFlag 32))
						(gTObj preLoop: 1)
						(Talk 210 0) ; "Greetings, King Arthur."
					)
					((or (IsFlag 20) (== gPrevRoomNum 12))
						(Talk 210 1) ; "That was quick m'lord."
					)
					(else
						(Talk 210 2) ; "Well we meet again, m'lord. Alas, you have not recovered your mule, I see."
					)
				)
				(client setScript: 0)
			)
		)
	)
)

(instance RunAway of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 210)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMuleObj
					illegalBits: 0
					setStep: 8 4
					setMotion: MoveTo 340 140 self
				)
			)
			(1
				(Talk 210 3) ; "M'lord, your mule has bolted!"
				(ClearFlag 20)
				(gMuleObj dispose:)
			)
		)
	)
)

