;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6911)
(include sci.sh)
(use Main)
(use Location)
(use InvInitialize)
(use n1111)
(use Sound)
(use Actor)
(use System)

(public
	mirmicatPoolCloseUp 0
)

(instance mirmicatPoolCloseUp of CloseupLocation
	(properties)

	(method (init)
		(= picture 6967)
		(switch gPrevRoomNum
			(6902 ; mirmicatPoolRm2
				(= heading 315)
				(= picture 6971)
			)
			(6904 ; mirmicatPoolRm4
				(= heading 180)
				(if (IsFlag 144)
					(= picture 6971)
				)
			)
			(6906 ; mirmicatPoolRm6
				(= heading 45)
				(if (IsFlag 145)
					(= picture 6971)
				)
			)
		)
		(super init: picture)
		(switch gPrevRoomNum
			(6906 ; mirmicatPoolRm6
				(if (IsFlag 145)
					(humanKey init:)
				else
					(humanKey init: deleteHotspot:)
					(gCurRoom setScript: meltingScript)
				)
			)
			(6904 ; mirmicatPoolRm4
				(if (not (IsFlag 144))
					(gCurRoom setScript: meltingScript)
				)
			)
		)
	)
)

(instance humanKey of View
	(properties
		x 376
		y 98
		view 6903
		loop 2
	)

	(method (init)
		(if (== (proc70_9 36) 6911)
			(super init: global117)
			(self setHotspot: 2)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(self hide:)
				(proc70_1 36)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance meltingScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(acidSound play:)
				(proc1111_31 3)
				(= seconds 5)
			)
			(1
				(gCurRoom newRoom: 95) ; morgue
			)
		)
	)
)

(instance acidSound of Sound
	(properties
		flags 5
		number 6911
		loop -1
	)
)

