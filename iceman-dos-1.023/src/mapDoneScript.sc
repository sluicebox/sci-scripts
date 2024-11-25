;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 336)
(include sci.sh)
(use Main)
(use Interface)
(use Approach)
(use Avoid)
(use System)

(public
	mapDoneScript 0
)

(instance mapDoneScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(Print 336 0 #at -1 1 #time 7 #dispose) ; "I see that you feel at ease with our new map table, Commander."
				(= seconds 7)
			)
			(1
				(Print 336 1 #at -1 1 #time 7 #dispose) ; "If you have a seat, I'll direct you to the next radio contact."
				(gEgo
					illegalBits: $8000
					setMotion: Approach (ScriptID 25 4) 20 self ; controlPanelChair
					setAvoider: Avoid
				)
			)
			(2
				(gEgo setAvoider: 0 setScript: (ScriptID 25 2)) ; sitControlPanelScript
			)
		)
	)

	(method (dispose)
		(proc0_3)
		(super dispose:)
		(DisposeScript 953)
		(DisposeScript 336)
	)
)

