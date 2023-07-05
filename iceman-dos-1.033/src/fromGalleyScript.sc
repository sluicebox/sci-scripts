;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 346)
(include sci.sh)
(use Main)
(use Interface)
(use Approach)
(use Grooper)
(use Avoid)
(use Motion)
(use System)

(public
	fromGalleyScript 0
)

(instance fromGalleyScript of Script
	(properties
		cycles 2
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
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
				(Print 346 0 #time 7 #at -1 10 #dispose) ; "Take the helm, Johnny. I'll direct you to the next radio contact."
				(= seconds 3)
			)
			(2
				(gEgo
					setAvoider: Avoid
					setMotion: Approach (ScriptID 25 4) 20 self ; controlPanelChair
				)
			)
			(3
				(gEgo setScript: (ScriptID 25 2)) ; sitControlPanelScript
			)
		)
	)

	(method (dispose)
		(super dispose:)
		(DisposeScript 346)
		(DisposeScript 953)
	)
)

