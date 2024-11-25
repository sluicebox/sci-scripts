;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 395)
(include sci.sh)
(use Main)
(use Interface)
(use Follow)
(use Grooper)
(use Motion)
(use System)

(public
	goodJobScript 0
)

(instance goodJobScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
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
				(gEgo posn: 180 98)
				(Print 395 0 #time 7 #at -1 1 #dispose) ; "Good job, Johnny. Follow me to my quarters for a quick briefing."
				(= cycles 1)
			)
			(2
				(HandsOff)
				((ScriptID 25 1) setMotion: MoveTo 138 116 self) ; captain
			)
			(3
				(gEgo illegalBits: 0 setMotion: Follow (ScriptID 25 1) 30) ; captain
				((ScriptID 25 1) setMotion: MoveTo 25 177 self) ; captain
			)
			(4
				(client setScript: (ScriptID 25 5) 0 30) ; goToANewRoomScript
			)
		)
	)

	(method (dispose)
		(gEgo illegalBits: $8000)
		(super dispose:)
		(DisposeScript 395)
	)
)

