;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 10204)
(include sci.sh)
(use Main)
(use n951)
(use Actor)

(public
	rm10v204 0
)

(local
	local0
	local1 = 10204
)

(instance rm10v204 of ShiversRoom
	(properties
		picture 10204
	)

	(method (init)
		(if (not (IsFlag 54))
			(SetFlag 54)
		)
		(proc951_16 136)
		(= local0 0)
		(efExitBack init: 8)
		(hsFrontBook init:)
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
				262
				0
				262
				143
				0
				143
				0
				1
				73
				13
				72
				131
				186
				131
				186
				13
				73
				13
		)
		(if (IsFlag 45)
			(= nextRoom 991)
		else
			(= nextRoom 10202)
		)
		(super init: &rest)
	)
)

(instance efExitBackOpen of ExitFeature
	(properties
		nextRoom 10202
	)

	(method (init)
		(self
			createPoly:
				0
				0
				262
				0
				262
				143
				0
				143
				0
				1
				29
				11
				239
				11
				239
				130
				27
				130
				27
				11
		)
		(if (IsFlag 45)
			(= nextRoom 991)
		else
			(= nextRoom 10202)
		)
		(super init: &rest)
	)
)

(instance hsFrontBook of HotSpot
	(properties)

	(method (init)
		(self createPoly: 82 15 178 15 178 127 82 127 82 15)
		(super init: &rest)
	)

	(method (doVerb)
		(cond
			((== local0 0)
				(++ local0)
				(vBook init: view: (+ local0 local1))
				(gSounds stop: 11017)
				(gSounds play: 11017 0 82 0)
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
				(gCurRoom newRoom: 10204) ; rm10v204
			)
		)
	)
)

(instance hsLeftPage of HotSpot
	(properties)

	(method (init)
		(self createPoly: 125 17 35 17 35 127 125 127 125 18)
		(super init: &rest)
	)

	(method (doVerb)
		(cond
			((< 0 (-- local0) 8)
				(vBook show:)
				(if (<= local0 5)
					(vBook view: (+ local0 local1))
				else
					(vBook view: (+ local0 local1 1))
				)
				(gSounds stop: 11018)
				(gSounds play: 11018 0 82 0)
			)
			((== 0 local0)
				(vBook hide:)
				(hsFrontBook init: 0)
				(gSounds stop: 11019)
				(gSounds play: 11019 0 82 0)
				(efExitBack init: 8)
				(efExitBackOpen dispose:)
				(hsLeftPage dispose:)
				(hsRightPage dispose:)
			)
			((IsFlag 45)
				(gCurRoom newRoom: 991) ; shiversFlashback
			)
			(else
				(gCurRoom newRoom: 10204) ; rm10v204
			)
		)
	)
)

(instance hsRightPage of HotSpot
	(properties)

	(method (init)
		(self createPoly: 140 17 140 127 229 127 236 127 236 17 141 17)
		(super init: &rest)
	)

	(method (doVerb)
		(if (< 0 (++ local0) 8)
			(vBook show:)
			(if (<= local0 5)
				(vBook view: (+ local0 local1))
			else
				(vBook view: (+ local0 local1 1))
			)
			(gSounds stop: 11018)
			(gSounds play: 11018 0 82 0)
		else
			(= local1 10204)
			(= local0 0)
			(vBook hide:)
			(hsFrontBook init: 0)
			(gSounds stop: 11019)
			(gSounds play: 11019 0 82 0)
			(efExitBack init: 8)
			(efExitBackOpen dispose:)
			(hsLeftPage dispose:)
			(hsRightPage dispose:)
		)
	)
)

(instance vBook of View
	(properties
		view 10205
	)

	(method (init)
		(self setPri: 100 1)
		(super init: &rest)
	)
)

