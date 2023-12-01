;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 90)
(include sci.sh)
(use Main)
(use n1111)
(use Str)
(use Game)
(use User)
(use System)

(public
	logoRoom 0
)

(instance logoRoom of Room
	(properties
		style 14
		exitStyle 13
	)

	(method (init &tmp temp0)
		(= temp0 (Str newWith: 128 gCurSaveDir))
		(temp0 cat: {chase.dat})
		(if (FileIO fiEXISTS (temp0 data:))
			(FileIO fiUNLINK (temp0 data:))
		)
		(gGame setCursor: gTheCursor 0)
		(User canInput: 1)
		(super init:)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
		(gDirectionHandler addToFront: self)
		(self setScript: doTitle)
	)

	(method (handleEvent)
		((self script:) cycles: 0 seconds: 0 ticks: 0 state: 3)
		(self cue:)
	)

	(method (dispose)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(gDirectionHandler delete: self)
		(super dispose:)
	)
)

(instance doTitle of Script
	(properties)

	(method (changeState newState &tmp [temp0 3])
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(DoRobot 91 72 44 0)
			)
			(2
				(= cycles 1)
			)
			(3
				(DoRobot 90 0 0 0 -1 1)
			)
			(4
				(= seconds 4)
			)
			(5
				(gCurRoom newRoom: 91) ; saveRest
			)
		)
	)
)

