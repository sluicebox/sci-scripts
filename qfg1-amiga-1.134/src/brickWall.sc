;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 233)
(include sci.sh)
(use Main)
(use Rev)
(use Motion)
(use System)

(public
	brickWall 0
)

(instance brickWall of Script
	(properties)

	(method (dispose)
		(super dispose:)
		(DisposeScript 233)
		(DisposeScript 969)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (< (gEgo y:) 103)
					(gEgo
						setLoop: 3
						setCycle: Rev
						setMotion: MoveTo (+ (gEgo x:) 5) 103 self
					)
				else
					(self cue:)
				)
			)
			(1
				(NormalEgo)
				((ScriptID 96 13) init:) ; behindDoor11
				((ScriptID 96 9) setCycle: End self) ; door11
			)
			(2
				(HighPrint 233 0) ; "Oops! You thought this door led SOMEWHERE!"
				(= cycles 4)
			)
			(3
				((ScriptID 96 9) setCycle: Beg self) ; door11
			)
			(4
				((ScriptID 96 13) dispose:) ; behindDoor11
				((ScriptID 96 9) stopUpd:) ; door11
				(HandsOn)
				(client setScript: 0)
			)
		)
	)
)

