;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 908)
(include sci.sh)
(use Main)
(use LoadMany)
(use Motion)
(use System)

(public
	eggScript 0
)

(local
	local0
)

(instance eggScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 1 19 0 1 self 0) ; "Alexander cracks open the spoiled egg to see what's inside."
			)
			(1
				(= seconds 3)
			)
			(2
				(= local0 (gEgo cel:))
				(gEgo
					normal: 0
					view: 907
					cel: 0
					setLoop: 0
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(3
				(gMessager say: 1 19 0 2 self 0) ; "Phew! Smells like sulphur!"
			)
			(4
				(gMessager say: 1 19 0 3 self 0) ; "The egg, shell and all, disintegrates into a cloud of evil-smelling gas which floats away. Ah, well! What possible use could Alexander have found for a spoiled egg?"
			)
			(5
				(gEgo put: 10 reset: local0) ; egg
				(gGame handsOn:)
				(self dispose:)
				(LoadMany 0 908)
			)
		)
	)
)

