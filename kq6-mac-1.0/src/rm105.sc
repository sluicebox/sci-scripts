;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 105)
(include sci.sh)
(use Main)
(use KQ6Room)
(use System)

(public
	rm105 0
)

(instance rm105 of KQ6Room
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

	(method (cue)
		(gGame restart: 1)
	)
)

(instance checkForFiles of Code
	(properties)

	(method (doit &tmp [temp0 20])
		(Format @temp0 105 0) ; "Kq6Movie"
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
				(gGlobalSound number: 100 loop: 1 play:)
				(= cycles 1)
			)
			(1
				(= seconds 3)
			)
			(2
				(ShowMovie {Kq6Movie})
				(= cycles 1)
			)
			(3
				(gCurRoom newRoom: 100)
			)
		)
	)
)

