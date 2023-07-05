;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 564)
(include sci.sh)
(use Game)
(use System)

(public
	TheDungeon 0
	shortTimer 1
	longTimer 2
	warningTimer 3
)

(class TheDungeon of Rgn
	(properties
		keep 1
		firstLook 1
		coinsLeft 0
		firstShortTimer 0
		boysRescued 0
		firstAfterRescue 1
		timerHasFired 0
		tooLate 0
		longTimerGone 0
		trapDoorOpen 0
		firstTimeOpened 1
		timeToDie 0
		guardsGone 0
		neverBefore 1
		numberCoins 0
		valueCoins 0
		doneTalking 0
		coinsDoneBeenTook 0
	)

	(method (newRoom newRoomNumber)
		(if (not (OneOf newRoomNumber 550 560 561 562 570)) ; tunnel1, tunnel2, tunnel3
			(self keep: 0)
		)
	)
)

(instance shortTimer of Script
	(properties
		seconds 15
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(warningTimer seconds: 15)
				(TheDungeon setScript: warningTimer)
				(TheDungeon timerHasFired: 1)
				(self dispose:)
			)
		)
	)
)

(instance longTimer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(warningTimer seconds: 15)
				(TheDungeon setScript: warningTimer)
				(TheDungeon timerHasFired: 1)
				(TheDungeon longTimerGone: 1)
				(self dispose:)
			)
		)
	)
)

(instance warningTimer of Script
	(properties
		seconds 15
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(TheDungeon guardsGone: 0)
				(TheDungeon timeToDie: 1)
				(self dispose:)
			)
		)
	)
)

