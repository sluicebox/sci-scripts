;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 402)
(include sci.sh)
(use Main)
(use Interface)
(use Motion)
(use Actor)
(use System)

(public
	romulanWarbird 0
)

(instance romulanWarbird of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(self setScript: (ScriptID 49 3) self) ; pushButtons
			)
			(1
				(Print 402 0) ; "This is strange. The sensors are returning phantom images. There seems to be another ship in the vicinity, but its location is tough to pinpoint."
				(self setScript: (ScriptID 49 5) self) ; scratchHead
			)
			(2
				(warBird init: setCycle: Beg self)
			)
			(3
				(= seconds 3)
			)
			(4
				(warBird setCycle: End setMotion: MoveTo 31 4 self)
			)
			(5
				(warBird dispose:)
				(= seconds 3)
			)
			(6
				(EgoDead 945 0 0 402 1) ; "Hey! What's the deal with this guy. That was truly an unfriendly act. Perhaps you strayed into a sector you shouldn't have."
			)
		)
	)
)

(instance warBird of Actor
	(properties
		x 60
		y 69
		view 119
		priority 2
		signal 22544
		cycleSpeed 6
		moveSpeed 2
	)
)

