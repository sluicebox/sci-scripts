;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 707)
(include sci.sh)
(use Main)
(use Sq4Dialog)
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
		(gTheIconBar disable:)
		(super init:)
		(= gTheCursor (= gWaitCursor 996))
		(gGame setCursor: gWaitCursor)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
	)

	(method (newRoom newRoomNumber)
		(= keep (OneOf newRoomNumber 1 6 9 10 15 16 17 19 20 21))
		(= initialized 0)
		(if (not keep)
			(gTheIconBar enable:)
			(= gWaitCursor (ScriptID 0 19)) ; waitC
		)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler delete: self)
	)

	(method (handleEvent event &tmp temp0)
		(if (and (event type:) (== gCurRoomNum gNewRoomNum))
			(event claimed: 1)
			(gSounds pause: 1)
			(gGame setCursor: 999)
			(SetCursor 127 99)
			(switch
				(proc816_3
					{Would you like to skip\nthe introduction or\nwatch the whole thing?}
					64
					100
					60
					109
					78
					{Skip it}
					0
					109
					78
					{Watch it}
					1
					109
					78
					{Restore a Game}
					2
				)
				(0
					(gLongSong fade: 0 1 2 1)
					(Palette palSET_INTENSITY 8 15 100)
					(= gTheCursor (= gWaitCursor (ScriptID 0 19))) ; waitC
					(gCurRoom newRoom: 59)
				)
				(1
					(gSounds pause: 0)
					(gGame setCursor: gWaitCursor)
				)
				(2
					(Palette palSET_INTENSITY 8 10 100)
					(gSounds pause: 0)
					(= temp0 gNormalCursor)
					(= gNormalCursor 999)
					(gGame restore:)
					(= gNormalCursor temp0)
					(gGame setCursor: gWaitCursor)
				)
			)
		)
	)
)

