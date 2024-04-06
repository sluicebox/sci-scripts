;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 34400)
(include sci.sh)
(use Main)
(use n1111)
(use Scaler)
(use WalkieTalkie)
(use Actor)
(use System)

(public
	rm34400 0
)

(instance rm34400 of ScaryRoom
	(properties
		picture 34400
		stepSound 1
	)

	(method (init)
		(gEgo init: hide: setScaler: Scaler 168 168 127 126)
		(if (or (!= (gGDacSound number:) 903) (not (gGDacSound handle:)))
			(gGDacSound number: 903 setLoop: -1 play: setVol: 75)
		)
		(switch gPrevRoomNum
			(34235
				(gGame handsOn:)
				(if (and (IsFlag 93) (!= gChapter 4) (!= gChapter 6))
					(realtySign view: 34401 init:)
					(closedDoor init:)
					(self setScript: toStoreScr)
				else
					(realtySign view: 34400 init:)
					(closedDoor init:)
					(self setScript: doorLocked)
				)
			)
			(else
				(if (IsFlag 11)
					(realtySign view: 34401 init:)
					(self setScript: scene564Scr)
				else
					(realtySign view: 34401 init:)
					(self setScript: fromStoreScr)
				)
			)
		)
		(super init: &rest)
	)

	(method (dispose)
		(KillRobot)
		(super dispose:)
	)
)

(instance doorLocked of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(DoRobot 1770 -8 -40)
				)
				(1
					(KillRobot)
					(gEgo hide:)
					(WalkieTalkie showFrame: 1770 195 -8 -40)
					(gCurRoom newRoom: 34235)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(gEgo hide:)
					(WalkieTalkie showFrame: 1770 195 -8 -40)
					(gCurRoom newRoom: 34235)
				)
			)
		)
	)
)

(instance toStoreScr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(DoRobot 1780 3 0 gEgo -1 1)
				)
				(1
					(closedDoor dispose:)
				)
				(2
					(gCurRoom newRoom: 30100)
				)
			)
		else
			(switch (= state newState)
				(0
					(KillRobot)
					(= global115 0)
					(gCurRoom newRoom: 30100)
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
					(DoRobot 1781 2 0 gEgo -1 1)
				)
				(1
					(gCurRoom newRoom: 34235)
				)
			)
		else
			(switch (= state newState)
				(0
					(= global115 0)
					(KillRobot)
					(gCurRoom newRoom: 34235)
				)
			)
		)
	)
)

(instance scene564Scr of Script
	(properties)

	(method (changeState newState)
		(if (not global115)
			(switch (= state newState)
				(0
					(gGame handsOff:)
					(DoRobot 5640 2 0 gEgo -1 1)
				)
				(1
					(= global115 0)
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
		x 126
		y 23
		view 34402
	)
)

(instance realtySign of View
	(properties
		x 189
		y 76
	)
)

