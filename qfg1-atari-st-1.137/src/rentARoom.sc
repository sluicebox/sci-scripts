;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 167)
(include sci.sh)
(use Main)
(use Motion)
(use System)

(public
	rentARoom 0
)

(instance rentARoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 128)
					(self changeState: 4)
				else
					(SolvePuzzle 722 1)
					(if (IsFlag 300)
						(self cue:)
					else
						((ScriptID 301 1) setCycle: CT 2 1 self) ; shameen
						(SetFlag 300)
					)
				)
			)
			(1
				(HandsOff)
				(HighPrint 167 0) ; "May you dream of all the rewards you deserve."
				(HighPrint 167 1) ; "You thank Shameen and pay him 5 silvers for the room."
				((ScriptID 301 1) setLoop: 4 cel: 2 setCycle: Beg) ; shameen
				((ScriptID 301 4) setCycle: End self) ; rmDoor
			)
			(2
				(ClearFlag 300)
				(gEgo ignoreActors: illegalBits: 0)
				(if (gEgo inRect: 239 125 319 133)
					(gEgo setMotion: MoveTo (gEgo x:) 130 self)
				else
					(= cycles 1)
				)
			)
			(3
				(gEgo setMotion: MoveTo 10 130 self)
			)
			(4
				(SetFlag 128)
				(gCast eachElementDo: #dispose)
				(gCurRoom drawPic: 400 16)
				(self cue:)
			)
			(5
				(ClearFlag 122)
				(gCurRoom newRoom: 302)
			)
		)
	)
)

