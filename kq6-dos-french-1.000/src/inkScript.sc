;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 92)
(include sci.sh)
(use Main)
(use n913)
(use LoadMany)
(use Motion)
(use System)

(public
	inkScript 0
)

(instance inkScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 151)
				(= cycles 1)
			)
			(1
				(gMessager say: 1 83 0 1 self 0) ; "Alexander decides to open the empty ink bottle."
			)
			(2
				(= seconds 2)
			)
			(3
				(gEgo
					normal: 0
					view: 906
					setCel: 0
					setLoop: 0
					cycleSpeed: 10
					setCycle: CT 4 1 self
				)
			)
			(4
				(gMessager say: 1 83 0 2 self 0) ; "<Urg!> It's stuck...it's...."
			)
			(5
				(gEgo setCycle: End self)
			)
			(6
				(gMessager say: 1 83 0 3 self 0) ; "Whoa!"
			)
			(7
				(gEgo setCel: 0 setLoop: 1)
				(= seconds 4)
			)
			(8
				(gMessager say: 1 83 0 4 self 0) ; "Why, the ink bottle isn't empty at all...it's full of INVISIBLE ink!"
			)
			(9
				(= seconds 2)
			)
			(10
				(gEgo setCycle: End self)
			)
			(11
				(gMessager say: 1 83 0 5 self 0) ; "Not very strong, but not bad!"
			)
			(12
				(SetFlag 116)
				(gGame handsOn:)
				(gEgo reset: 2)
				(self dispose:)
				(LoadMany 0 92)
			)
		)
	)
)

