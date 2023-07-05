;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1)
(include sci.sh)
(use Main)
(use eRS)
(use LoadMany)
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
		(LoadMany rsFONT 68 69)
		(self setScript: rmScript setRegions: 707) ; intro
	)
)

(instance rmScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if (and (== state 1) (== (gLongSong prevSignal:) 10))
			(self cue:)
		)
	)

	(method (changeState newState &tmp [temp0 3] temp3)
		(switch (= state newState)
			(0
				(gLongSong loop: -1 playBed:)
				(= cycles 2)
			)
			(1)
			(2
				(gCurRoom drawPic: 1)
				(= register (if (> global105 16) 200 else 10000))
				(= cycles 2)
			)
			(3
				(= temp3 (if (> global105 16) 150 else 7500))
				(Animate (gCast elements:) 0)
				(while (and (-- register) (== gNewRoomNum gCurRoomNum))
					(if (== register temp3)
						(= local1
							(proc0_12
								{\03 1991 Sierra On-Line, Inc.}
								67
								1
								177
								70
								316
								28
								(proc0_18 global157 global156)
								29
								global129
								30
								1
								33
								68
							)
						)
					)
					(User doit:)
					(Palette palANIMATE 160 191 -1)
					(Palette palANIMATE 128 159 -1)
				)
				(gCurRoom drawPic: 803 10)
				(if (== gCurRoomNum gNewRoomNum)
					(gCurRoom newRoom: 6)
				)
			)
		)
	)
)

