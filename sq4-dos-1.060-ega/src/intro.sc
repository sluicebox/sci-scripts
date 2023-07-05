;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 707)
(include sci.sh)
(use Main)
(use n940)
(use Sound)
(use Game)
(use System)

(public
	intro 0
)

(local
	local0
)

(class intro of Rgn
	(properties
		iconBar 0
	)

	(method (init)
		(gNarrator disable:)
		(super init:)
		(gPrints addToFront: self)
		(gWalkHandler addToFront: self)
	)

	(method (newRoom newRoomNumber)
		(= keep (OneOf newRoomNumber 1 6 9 10 15 16 17 19 20 21))
		(= initialized 0)
		(if (not keep)
			(gNarrator enable:)
		)
		(gPrints delete: self)
		(gWalkHandler delete: self)
	)

	(method (handleEvent event)
		(if (and (event type:) (== gCurRoomNum gNewRoomNum))
			(event claimed: 1)
			(Sound pause: 1)
			(switch
				(PrintD
					{Would you like to skip\nthe introduction or\nwatch the whole thing?}
					67
					100
					60
					101
					81
					{Skip it}
					0
					101
					81
					{Watch it}
					1
					101
					81
					{Restore a Game}
					2
				)
				(0
					(Palette palSET_INTENSITY 8 15 100)
					(gCurRoom newRoom: 59)
				)
				(1
					(Sound pause: 0)
				)
				(2
					(Palette palSET_INTENSITY 8 15 100)
					(Sound pause: 0)
					(gGame restore:)
				)
			)
		)
	)
)

