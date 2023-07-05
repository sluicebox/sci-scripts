;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24502)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm24v502 0
)

(local
	local0
)

(instance rm24v502 of ShiversRoom
	(properties
		picture 24502
	)

	(method (init)
		(if (not (IsFlag 46))
			(SetFlag 46)
		)
		(proc951_16 109)
		(= local0 0)
		(efExitBack init: 8)
		(hsFrontBook init:)
		(gSounds play: 12420 0 82 0)
		(super init: &rest)
	)

	(method (newRoom)
		(gSounds play: 12421 0 82 0)
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
				0
				142
				262
				142
				262
				0
				1
				0
				65
				6
				65
				140
				199
				140
				199
				6
				65
				6
		)
		(if (IsFlag 45)
			(= nextRoom 991)
		else
			(= nextRoom 24501)
		)
		(super init: &rest)
	)
)

(instance efExitBackOpen of ExitFeature
	(properties
		nextRoom 24501
	)

	(method (init)
		(self
			createPoly:
				0
				0
				263
				0
				263
				143
				0
				143
				0
				1
				5
				5
				17
				6
				258
				6
				258
				139
				5
				139
				5
				6
		)
		(if (IsFlag 45)
			(= nextRoom 991)
		else
			(= nextRoom 24501)
		)
		(super init: &rest)
	)
)

(instance hsFrontBook of HotSpot
	(properties)

	(method (init)
		(self createPoly: 73 8 198 8 198 139 72 139 72 8)
		(super init: &rest)
	)

	(method (doVerb)
		(cond
			((== local0 0)
				(++ local0)
				(vBook init: view: (+ local0 24502))
				(vBook show:)
				(gSounds stop: 10616)
				(gSounds play: 10616 0 32 0)
				(efExitBackOpen init: 8)
				(hsLeftPage init: 0)
				(hsRightPage init: 0)
				(efExitBack dispose:)
				(hsFrontBook dispose:)
				(self dispose:)
			)
			((IsFlag 45)
				(gCurRoom newRoom: 991) ; shiversFlashback
			)
			(else
				(gCurRoom newRoom: 24501) ; rm24v501
			)
		)
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
				(vBook show:)
				(vBook view: (+ local0 24502))
				(gSounds stop: 10607)
				(gSounds play: 10607 0 32 0)
			)
			((== 0 local0)
				(gSounds stop: 10617)
				(gSounds play: 10617 0 32 0)
				(vBook hide:)
				(hsFrontBook init:)
				(efExitBack init: 8)
				(efExitBackOpen dispose:)
				(hsLeftPage dispose:)
				(hsRightPage dispose:)
			)
			((IsFlag 45)
				(gCurRoom newRoom: 991) ; shiversFlashback
			)
			(else
				(gCurRoom newRoom: 24501) ; rm24v501
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
		(if (<= (++ local0) 2)
			(vBook show:)
			(vBook view: (+ local0 24502))
			(gSounds stop: 10806)
			(gSounds play: 10806 0 32 0)
		else
			(gSounds stop: 10617)
			(gSounds play: 10617 0 32 0)
			(vBook hide:)
			(= local0 0)
			(hsFrontBook init:)
			(efExitBack init: 8)
			(efExitBack init: 8)
			(efExitBackOpen dispose:)
			(hsLeftPage dispose:)
			(hsRightPage dispose:)
			(= local0 0)
		)
	)
)

(instance vBook of View
	(properties
		view 24503
	)

	(method (init)
		(self setPri: 100 1)
		(super init: &rest)
	)
)

