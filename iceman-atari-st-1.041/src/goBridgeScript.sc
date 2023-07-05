;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 345)
(include sci.sh)
(use Main)
(use Interface)
(use subMarine_314)
(use Follow)
(use Grooper)
(use Motion)
(use System)

(public
	goBridgeScript 0
)

(instance goBridgeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				((ScriptID 25 1) ; captain
					init:
					setCycle: Walk
					posn: 214 100
					heading: 270
					loop: 1
					illegalBits: 0
					setLoop: Grooper
				)
				(self setScript: (ScriptID 394) self) ; getUpScript
			)
			(1
				(= cycles 1)
			)
			(2
				(HandsOff)
				(Print 345 0 #at -1 11 #time 7 #dispose) ; "Let's go up on the bridge and check the situation out."
				((ScriptID 25 1) setMotion: MoveTo 258 108 self) ; captain
				(gEgo setMotion: Follow (ScriptID 25 1) 20) ; captain
			)
			(3
				((ScriptID 25 1) ; captain
					setMotion:
						MoveTo
						((ScriptID 25 6) x:) ; ladderFeat
						((ScriptID 25 6) y:) ; ladderFeat
						self
				)
			)
			(4
				((ScriptID 25 1) ; captain
					illegalBits: 0
					view: 625
					setLoop: 0
					heading: 0
					setMotion: MoveTo 298 22 self
				)
				(gEgo
					setMotion:
						MoveTo
						((ScriptID 25 6) x:) ; ladderFeat
						((ScriptID 25 6) y:) ; ladderFeat
						self
				)
			)
			(5)
			(6
				(gEgo
					illegalBits: 0
					view: 238
					setLoop: 0
					heading: 0
					setMotion: MoveTo 298 52 self
				)
			)
			(7
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(subMarine cue:)
		(gCurRoom setScript: (ScriptID 25 5) 0 28) ; goToANewRoomScript
		(super dispose:)
		(DisposeScript 345)
	)
)

