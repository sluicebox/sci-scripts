;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 782)
(include sci.sh)
(use Main)
(use Interface)
(use Sound)
(use Motion)
(use System)

(public
	fiddler 0
	fiddleSound 1
)

(instance fiddler of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(fiddleSound number: 42 loop: 1 init: play:)
				(gEgo
					view: (if (IsFlag 0) 32 else 55)
					cycleSpeed: 1
					setCycle: Fwd
				)
				(= seconds 2)
			)
			(1
				(Print 782 0) ; "You play a lively, toe-tapping tune on the fiddle."
				(= seconds 4)
			)
			(2
				(fiddleSound fade:)
				(cond
					((== gCurRoomNum 79)
						(Print 782 1) ; "The woodcutter and his wife ignore your fiddling. Perhaps they preferred their own music?"
					)
					((and (== gCurRoomNum 58) (IsFlag 88))
						(Print 782 2) ; "Though your fiddle-playing is loud and boisterous, the giant can't hear you above his own snoring. Good thing, too!"
					)
					(else
						(Print 782 3) ; "Obviously, there are no music lovers here. You put the fiddle away."
					)
				)
				(HandsOn)
				(proc0_1)
				(gEgo loop: 2)
				(self dispose:)
			)
		)
	)
)

(instance fiddleSound of Sound
	(properties
		priority 10
	)
)

