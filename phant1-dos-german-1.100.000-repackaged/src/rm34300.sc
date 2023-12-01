;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 34300)
(include sci.sh)
(use Main)
(use n1111)
(use Scaler)
(use Actor)
(use System)

(public
	rm34300 0
)

(instance rm34300 of ScaryRoom
	(properties
		picture 34300
		stepSound 1
	)

	(method (init)
		(if (or (!= (gGDacSound number:) 903) (not (gGDacSound handle:)))
			(gGDacSound number: 903 setLoop: -1 play: setVol: 75)
		)
		(gEgo init: hide: setScaler: Scaler 142 129 127 113)
		(switch gPrevRoomNum
			(34235
				(if (!= gChapter 1)
					(self setScript: toStoreScr)
				else
					(closedDoor init:)
					(self setScript: storeLocked)
				)
			)
			(else
				(self setScript: fromStoreScr)
			)
		)
		(super init: &rest)
	)

	(method (dispose)
		(KillRobot)
		(super dispose:)
	)
)

(instance toStoreScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(DoRobot 1769 0 0 gEgo -1 1)
				)
				(1
					(gCurRoom newRoom: 32100)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(gCurRoom newRoom: 32100)
				)
			)
		)
	)
)

(instance storeLocked of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(DoRobot 1760 -11 26 gEgo -1 1)
				)
				(1
					(gCurRoom newRoom: 34235)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(gCurRoom newRoom: 34235)
				)
			)
		)
	)
)

(instance fromStoreScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(DoRobot 1761 0 0 gEgo -1 1)
				)
				(1
					(gCurRoom newRoom: 34235)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(gCurRoom newRoom: 34235)
				)
			)
		)
	)
)

(instance closedDoor of View
	(properties
		x 113
		y 22
		view 34301
	)
)

