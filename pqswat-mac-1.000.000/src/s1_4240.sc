;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4240)
(include sci.sh)
(use Main)
(use PQRoom)
(use System)

(public
	s1_4240 0
)

(instance s1_4240 of PQRoom
	(properties
		picture 4240
	)

	(method (init)
		(super init: &rest)
		(Load rsAUDIO 55)
		(self setScript: cockGun)
	)
)

(instance cockGun of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 4)
			)
			(1
				(gFxSound number: 55 setLoop: 1 play:)
				(= seconds 2)
			)
			(2
				(gCurRoom newRoom: 4210) ; s1_4210
			)
		)
	)
)

