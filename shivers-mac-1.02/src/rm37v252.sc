;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 37252)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm37v252 0
)

(local
	local0
)

(instance rm37v252 of ShiversRoom
	(properties
		picture 37252
	)

	(method (init)
		(SetFlag 56)
		(proc951_16 139)
		(= local0 0)
		(efExitBack init: 8)
		(hsFrontBook init:)
		(vBook init:)
		(gSounds play: 10807 0 40 0)
		(super init: &rest)
	)

	(method (newRoom)
		(gSounds play: 10808 0 40 0)
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
			(= nextRoom 37251)
		)
		(super init: &rest)
	)
)

(instance efExitBackOpen of ExitFeature
	(properties
		nextRoom 37251
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
			(= nextRoom 37251)
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
				(vBook view: (+ local0 37252))
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
				(gCurRoom newRoom: 37252) ; rm37v252
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
			((< 0 (-- local0) 13)
				(vBook show:)
				(vBook view: (+ 37252 local0))
				(gSounds stop: 10607)
				(gSounds play: 10607 0 32 0)
			)
			((== 0 local0)
				(vBook show:)
				(vBook view: (+ 37252 local0))
				(hsFrontBook init: 0)
				(gSounds stop: 10617)
				(gSounds play: 10617 0 32 0)
				(efExitBack init: 8)
				(efExitBackOpen dispose:)
				(hsLeftPage dispose:)
				(hsRightPage dispose:)
			)
			((IsFlag 45)
				(gCurRoom newRoom: 991) ; shiversFlashback
			)
			(else
				(gCurRoom newRoom: 37252) ; rm37v252
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
		(if (<= 0 (++ local0) 13)
			(vBook show:)
			(vBook view: (+ 37252 local0))
			(gSounds stop: 10806)
			(gSounds play: 10806 0 32 0)
		else
			(= local0 0)
			(vBook show:)
			(vBook view: 37252)
			(hsFrontBook init: 0)
			(gSounds stop: 10617)
			(gSounds play: 10617 0 32 0)
			(efExitBack init: 8)
			(efExitBackOpen dispose:)
			(hsLeftPage dispose:)
			(hsRightPage dispose:)
		)
	)
)

(instance vBook of View
	(properties
		view 37252
	)

	(method (init)
		(self setPri: 100 1)
		(super init: &rest)
	)
)

