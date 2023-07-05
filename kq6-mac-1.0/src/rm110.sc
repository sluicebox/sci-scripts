;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 110)
(include sci.sh)
(use Main)
(use KQ6Room)
(use System)

(public
	rm110 0
)

(instance rm110 of KQ6Room
	(properties
		picture 98
	)

	(method (init)
		(super init: &rest)
		(if (checkForFiles doit:)
			(self setScript: showMovie)
		else
			(gCurRoom newRoom: 100)
		)
	)
)

(instance checkForFiles of Code
	(properties)

	(method (doit &tmp [temp0 20])
		(Format @temp0 110 0) ; "HalfDome"
		(if (FileIO fiEXISTS @temp0)
			(return 1)
		else
			(return 0)
		)
	)
)

(instance showMovie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlobalSound number: 1 loop: 1 play: self)
				(ShowMovie {HalfDome})
				(= seconds 5)
			)
			(1
				(gCurRoom newRoom: 100)
				(= cycles 1)
			)
		)
	)
)

