;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 21115)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm21v115 0
)

(local
	local0
)

(instance rm21v115 of ShiversRoom
	(properties)

	(method (init)
		(proc951_16 138)
		(efExitBack init: 8)
		(SetFlag 55)
		(gSounds play: 10616 0 32 0)
		(= local0 0)
		(vBook init:)
		(hsLeftPage init:)
		(hsRightPage init:)
		(super init: &rest)
	)

	(method (newRoom newRoomNumber)
		(if (< 20000 newRoomNumber 22000)
			(gSounds stop: 10617)
			(gSounds play: 10617 0 32 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance hsLeftPage of HotSpot
	(properties
		nsLeft 10
		nsTop 10
		nsRight 131
		nsBottom 133
	)

	(method (doVerb)
		(cond
			((>= (-- local0) 0)
				(vBook view: (+ 21111 local0))
				(gSounds stop: 10607)
				(gSounds play: 10607 0 32 0)
			)
			((IsFlag 45)
				(gCurRoom newRoom: 991) ; shiversFlashback
			)
			(else
				(gCurRoom newRoom: 21110) ; rm21v110
			)
		)
	)
)

(instance hsRightPage of HotSpot
	(properties
		nsLeft 132
		nsTop 10
		nsRight 253
		nsBottom 133
	)

	(method (doVerb)
		(cond
			((<= (++ local0) 8)
				(vBook view: (+ 21111 local0))
				(gSounds stop: 10607)
				(gSounds play: 10607 0 32 0)
			)
			((IsFlag 45)
				(gCurRoom newRoom: 991) ; shiversFlashback
			)
			(else
				(gCurRoom newRoom: 21110) ; rm21v110
			)
		)
	)
)

(instance vBook of View
	(properties
		view 21111
	)

	(method (init)
		(self setPri: 100 1)
		(super init: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 21110
	)

	(method (init)
		(if (IsFlag 45)
			(= nextRoom 991)
		)
		(self
			createPoly: 0 0 10 10 10 133 253 133 253 10 10 10 0 0 265 0 265 144 0 144 0 0
		)
		(super init: &rest)
	)
)

