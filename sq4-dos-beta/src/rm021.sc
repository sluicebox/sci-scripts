;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21)
(include sci.sh)
(use Main)
(use Interface)
(use SQRoom)
(use User)
(use System)

(public
	rm021 0
)

(instance rm021 of SQRoom
	(properties
		picture 21
	)

	(method (init)
		(super init:)
		(Load rsSOUND 823)
		(gLongSong number: 823 loop: -1 play:)
		(self setRegions: 707) ; intro
		(switch gPrevRoomNum
			(20
				(self setScript: rmScript)
			)
			(540
				(self setScript: endScript)
			)
			(else
				(self setScript: rmScript)
			)
		)
	)
)

(instance rmScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= register 500)
				(= cycles 2)
			)
			(1
				(while (and (-- register) (== gNewRoomNum gCurRoomNum))
					(if (== register 100)
						(gLongSong fade:)
					)
					(User doit:)
					(Palette palANIMATE 176 207 -1)
				)
				(gCurRoom newRoom: 59)
			)
		)
	)
)

(instance endScript of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(= register 200)
				(= cycles 2)
			)
			(1
				(while (-- register)
					(= temp0 (Event new:))
					(if (temp0 type:)
						(temp0 dispose:)
						(break)
					)
					(temp0 dispose:)
					(Palette palANIMATE 176 207 -1)
				)
				(DrawPic 803 6)
				(= cycles 1)
			)
			(2
				(Print 21 0) ; "THE END"
				(Print 21 1) ; "It's a game"
				(EgoDead)
			)
		)
	)
)

