;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 127)
(include sci.sh)
(use Main)
(use n940)
(use Sound)
(use Game)
(use System)

(public
	intro 0
)

(instance intro of Rgn
	(properties)

	(method (init)
		(gTheIconBar disable:)
		(super init:)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
	)

	(method (newRoom newRoomNumber)
		(= initialized 0)
		(if (not (= keep (OneOf newRoomNumber 1 2 3 5)))
			(gTheIconBar enable:)
		)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
		(DisposeScript 940)
	)

	(method (handleEvent event)
		(if (and (event type:) (== gCurRoomNum gNewRoomNum))
			(event claimed: 1)
			(Sound pause: 1)
			(gGame setCursor: 999)
			(switch
				(PrintD
					{Would you like to skip\nthe introduction or\nwatch the whole thing?}
					67
					100
					60
					106
					81
					{Skip it}
					0
					106
					81
					{Watch it}
					1
					106
					81
					{Restore a Game}
					2
				)
				(0
					(if gModelessDialog
						(gModelessDialog dispose:)
					)
					(gLongSong stop:)
					(gCurRoom newRoom: 18)
				)
				(1
					(Sound pause: 0)
					(gGame setCursor: 69 1 304 172)
				)
				(2
					(Sound pause: 0)
					(gGame restore:)
				)
			)
		)
	)
)

