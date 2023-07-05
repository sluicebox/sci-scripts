;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6000)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use n1111)
(use VMDMovie)

(public
	avianShaft 0
)

(instance avianShaft of CloseupLocation
	(properties)

	(method (init &tmp temp0)
		(= temp0
			(cond
				((IsFlag 150) 6000)
				((== global413 4) 6099)
				(else 6098)
			)
		)
		(= heading 3)
		(super init: temp0)
		(if (== global413 4)
			(defaultExit nextRoom: 6001 exitStyle: 13 init:)
			(gCurRoom exitN: defaultExit)
			(if (proc1111_24 150)
				(SetFlag 150)
				(avianOpeningLedges play:)
				(proc1111_31 41)
			)
		)
	)
)

(instance defaultExit of ExitFeature
	(properties
		nsBottom 289
		nsLeft 205
		nsRight 396
		nsTop 44
	)
)

(instance avianOpeningLedges of VMDMovie
	(properties
		movieName 6003
		endPic 6000
	)
)

