;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 6221)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm6v221 0
)

(local
	local0
)

(instance rm6v221 of ShiversRoom
	(properties
		picture 6221
	)

	(method (init)
		(proc951_16 92)
		(= local0 -1)
		(SetFlag 47)
		(efExitBack init: 8)
		(hsLeftPage init:)
		(hsRightPage init:)
		(vBook init:)
		(vBook hide:)
		(gSounds play: 10616 0 40 0)
		(super init: &rest)
	)

	(method (newRoom)
		(gSounds play: 10617 0 40 0)
		(super newRoom: &rest)
	)
)

(instance efExitBack of ExitFeature
	(properties)

	(method (init)
		(self
			createPoly:
				0
				0
				10
				10
				253
				10
				253
				133
				10
				133
				10
				11
				0
				1
				0
				143
				263
				143
				263
				0
		)
		(if (IsFlag 45)
			(= nextRoom 991)
		else
			(= nextRoom 6220)
		)
		(super init: &rest)
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
			((<= 0 (-- local0) 4)
				(vBook show:)
				(vBook view: (+ 6221 local0))
				(gSounds stop: 10607)
				(gSounds play: 10607 0 32 0)
			)
			((== -1 local0)
				(gSounds stop: 10607)
				(gSounds play: 10607 0 32 0)
				(vBook hide:)
				(FrameOut)
			)
			((IsFlag 45)
				(gCurRoom newRoom: 991) ; shiversFlashback
			)
			(else
				(gCurRoom newRoom: 6220) ; rm6v220
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
			((<= 0 (++ local0) 4)
				(vBook show:)
				(vBook view: (+ local0 6221))
				(gSounds stop: 10606)
				(gSounds play: 10606 0 32 0)
			)
			((IsFlag 45)
				(gCurRoom newRoom: 991) ; shiversFlashback
			)
			(else
				(gCurRoom newRoom: 6220) ; rm6v220
			)
		)
	)
)

(instance vBook of View
	(properties
		view 6221
	)

	(method (init)
		(self setPri: 100 1)
		(super init: &rest)
	)
)

