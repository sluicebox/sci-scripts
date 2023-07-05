;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 92)
(include sci.sh)
(use Main)
(use Game)
(use System)

(public
	intro 0
)

(local
	local0
	local1 = 100
)

(instance intro of Rgn
	(properties)

	(method (init)
		(super init:)
		(gTheIconBar disable:)
		(gTheIconBar disable: 7)
		(gGame setCursor: 996 1 304 172)
		(gUser canInput: 1)
		(gKeyDownHandler addToFront: self)
	)

	(method (handleEvent event)
		(if (and (== (event type:) evKEYBOARD) (== (event message:) KEY_ESCAPE))
			(event claimed: 1)
			(gCurRoom setScript: sFadeToBlack)
		)
	)

	(method (newRoom newRoomNumber)
		(gKeyDownHandler delete: self)
		(= initialized 0)
		(if
			(not
				(= keep
					(OneOf
						newRoomNumber
						100
						105 ; logo
						110
						120
						140
						150
						155
						160
						180
						190
						220
					)
				)
			)
			(gTheIconBar enable:)
		)
	)
)

(instance sFadeToBlack of Script
	(properties)

	(method (doit)
		(if (and local0 local1)
			(Palette palSET_INTENSITY 0 255 (-- local1))
			(if (not local1)
				(self cue:)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 1)
			)
			(1
				(gCurRoom newRoom: 26) ; actBreak
			)
		)
	)
)

