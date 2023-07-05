;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 2033)
(include sci.sh)
(use Main)
(use nExit)
(use n63002)
(use P2Feature)
(use P2Fidget)
(use System)

(public
	bedRoomCH3SR3 0
)

(instance bedRoomCH3SR3 of P2Room
	(properties
		picture 490
	)

	(method (init)
		(ClearFlag 1001)
		(super init: &rest)
		(thereseFidget init:)
		(thereseFeat init:)
		(gP2SongPlyr start: 2932)
		(gGame handsOn: 1)
	)

	(method (dispose)
		(super dispose: &rest)
	)
)

(instance thereseFidget of P2Fidget
	(properties
		x 143
		y 335
		view 14900
		initStart 0
		initFinish 0
		cycleStart 3
		cycleFinish 7
	)

	(method (init)
		(super init: &rest)
		(self setPri: 10)
	)
)

(instance thereseFeat of P2Feature
	(properties)

	(method (init)
		(= whoDoit thereseCode)
		(super
			init:
				(proc63002_10
					226
					8
					348
					8
					348
					196
					436
					196
					436
					333
					154
					333
					154
					196
					226
					196
				)
		)
	)
)

(instance thereseCode of Code
	(properties)

	(method (doit)
		(if (not (IsFlag 301))
			(SetFlag 301)
			(gP2SongPlyr pause: 1)
			(proc63002_7 1130)
			(gP2SongPlyr pause: 0)
		else
			(SetFlag 374)
			(gP2SongPlyr stop:)
			(= global209 1150)
			(gCurRoom newRoom: 800) ; endChapter
		)
	)
)

