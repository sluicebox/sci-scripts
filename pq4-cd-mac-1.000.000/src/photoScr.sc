;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 46)
(include sci.sh)
(use Main)
(use Sound)
(use System)

(public
	photoScr 0
)

(instance photoScr of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(Platform 0 2 1)
				(= ticks 1)
			)
			(1
				(gSounds eachElementDo: #pause 1)
				(photoSound play:)
				(gCast eachElementDo: #hide)
				(gGame fade: 100 0 10)
				(= ticks 90)
			)
			(2
				(if (== gCurRoomNum 675)
					(PalVary 3) ; PalVaryKill
				)
				((gCurRoom plane:) drawPic: (if (IsHiRes) 10971 else 971) 0)
				(= cycles 2)
			)
			(3
				(Platform 0 2 1)
				(gGame fade: 0 100 100)
				(gMessager say: 57 1 0 0 self 11) ; "The photograph taken of you and Hickman at the lake, the time you caught the 'big one'."
			)
			(4
				(while (!= ((= temp0 (Event new:)) type:) evMOUSEBUTTON)
					(temp0 dispose:)
				)
				(temp0 dispose:)
				(gGame fade: 100 0 10)
				(if (== gCurRoomNum 675)
					(gCurRoom drawPic: (gCurRoom picture:) 0)
				else
					((gCurRoom plane:) drawPic: (gCurRoom picture:) 0)
				)
				(gCast eachElementDo: #show)
				(= cycles 2)
			)
			(5
				(gGame fade: 0 100 10 handsOn:)
				(gSounds eachElementDo: #pause 0)
			)
			(6
				(Platform 0 2 0)
				(self dispose:)
			)
		)
	)
)

(instance photoSound of Sound
	(properties
		flags 5
		number 918
	)
)

