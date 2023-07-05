;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1)
(include sci.sh)
(use Main)
(use Interface)
(use SQRoom)
(use User)
(use System)

(public
	rm001 0
)

(local
	local0
	local1
)

(instance rm001 of SQRoom
	(properties
		picture 106
	)

	(method (init)
		(super init:)
		(Load rsPIC 1)
		(self setScript: rmScript setRegions: 707) ; intro
	)
)

(instance rmScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 3) (== (gLongSong prevSignal:) 10))
			(self cue:)
		)
	)

	(method (changeState newState &tmp [temp0 2] temp2)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(if
					(>
						(= temp2
							(GetNumber
								{Esc for Opening or\nEnter Teleport Number:}
							)
						)
						0
					)
					(gCurRoom newRoom: temp2)
				else
					(= cycles 2)
				)
			)
			(2
				(gLongSong loop: -1 play:)
				(= cycles 2)
			)
			(3)
			(4
				(gCurRoom drawPic: 1)
				(= register 200)
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(= cycles 2)
			)
			(5
				(= local1
					(proc0_12
						{\04 1991 Sierra On-Line, Inc.}
						67
						1
						175
						70
						319
						28
						global141
						29
						global129
						30
						1
						33
						310
					)
				)
				(Animate (gCast elements:) 0)
				(while (and (-- register) (== gNewRoomNum gCurRoomNum))
					(User doit:)
					(Palette palANIMATE 160 191 -1)
					(Palette palANIMATE 128 159 -1)
				)
				(gCurRoom drawPic: 803 2)
				(= cycles 2)
			)
			(6
				(gCurRoom newRoom: 6)
			)
		)
	)
)

