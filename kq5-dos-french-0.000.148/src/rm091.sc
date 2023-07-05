;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 91)
(include sci.sh)
(use Main)
(use DLetter)
(use KQ5Room)
(use RandCycle)
(use Actor)
(use System)

(public
	rm091 0
)

(instance rm091 of KQ5Room
	(properties
		picture 91
	)

	(method (init)
		(super init:)
		(HandsOff)
		(hOneEyes init: setScript: eye1Script)
		(hTwoEyes init: setScript: eye2Script)
		(h1Mouth init:)
		(h2Mouth init:)
		(self setScript: crtn5Script)
	)

	(method (dispose)
		(DisposeScript 941)
		(super dispose:)
	)
)

(instance crtn5Script of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(h1Mouth setCycle: RandCycle 40 self)
				(PrintDC 91 0 #dispose #at 10 120) ; "Where did you find HIM, Minotta?"
			)
			(2
				(h2Mouth setCycle: RandCycle 40 self)
				(PrintDC 91 1 #dispose #at 120 120) ; "We found him on the beach. Isn't he luscious? Yummm!"
			)
			(3
				(h1Mouth setCycle: RandCycle 50 self)
				(PrintDC 91 2 #dispose #at 10 120) ; "I don't know... he doesn't look like MY type. What do YOU think, Cruleena?"
			)
			(4
				(gCurRoom newRoom: 90)
			)
		)
	)
)

(instance eye1Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(client cel: 1)
				(= cycles 2)
			)
			(2
				(client cel: 0)
				(self init:)
			)
		)
	)
)

(instance eye2Script of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(client cel: 1)
				(= cycles 2)
			)
			(2
				(client cel: 0)
				(self init:)
			)
		)
	)
)

(instance h1Mouth of Prop
	(properties
		x 110
		y 70
		view 844
		loop 1
		priority 4
		cycleSpeed 2
	)
)

(instance hOneEyes of Prop
	(properties
		x 110
		y 60
		view 844
		priority 5
	)
)

(instance h2Mouth of Prop
	(properties
		x 216
		y 71
		view 844
		loop 3
		priority 4
		cycleSpeed 2
	)
)

(instance hTwoEyes of Prop
	(properties
		x 217
		y 61
		view 844
		loop 2
		priority 5
	)
)

