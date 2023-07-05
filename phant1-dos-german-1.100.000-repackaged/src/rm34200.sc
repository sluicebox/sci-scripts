;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 34200)
(include sci.sh)
(use Main)
(use Scaler)
(use Motion)
(use Actor)
(use System)

(public
	rm34200 0
)

(instance rm34200 of ScaryRoom
	(properties
		picture 34200
		stepSound 1
	)

	(method (init)
		(gEgo init: setScaler: Scaler 132 96 127 104 normalize:)
		(switch gPrevRoomNum
			(34225
				(gGame handsOn:)
				(gEgo normalize: 1 posn: 203 145)
				(self setScript: toStoreScr)
			)
			(else
				(gEgo normalize: 4 posn: 142 119)
				(gGame doRemap: 2 253 75)
				(self setScript: fromStoreScr)
			)
		)
		(if (== gChapter 2)
			(geezer init:)
		)
		(daryle init:)
		(super init: &rest)
	)
)

(instance toStoreScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gGame doRemap: 0)
				(gCurRoom newRoom: 31100)
			)
		)
	)
)

(instance fromStoreScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gCurRoom newRoom: 34225)
			)
		)
	)
)

(instance daryle of Prop
	(properties
		x 218
		y 99
		view 34201
	)

	(method (init)
		(super init:)
		(if (> (Random 0 9) 5)
			(self setCycle: Fwd cycleSpeed: 8)
		else
			(self loop: 1 setCycle: End cycleSpeed: 8)
		)
	)
)

(instance geezer of View
	(properties
		x 37
		y 137
		view 34202
	)
)

