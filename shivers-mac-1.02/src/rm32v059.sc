;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32059)
(include sci.sh)
(use Main)
(use n951)

(public
	rm32v059 0
)

(local
	local0
	local1
	local2
)

(instance rm32v059 of ShiversRoom
	(properties
		picture 32059
	)

	(method (init)
		(if (IsFlag 82)
			(= local0 1)
			(= local1 2)
			(= local2 0)
		else
			(= local0 9)
			(= local1 9)
			(= local2 9)
		)
		(pDialProp1 init: cel: local0)
		(pDialProp2 init: cel: local1)
		(pDialProp3 init: cel: local2)
		(efExitBack init: 8)
		(efExitLeft init: 2)
		(super init: &rest)
	)
)

(instance efExitLeft of ExitFeature
	(properties
		nextRoom 32390
	)
)

(instance efExitBack of ExitFeature
	(properties
		nextRoom 32410
	)

	(method (init)
		(self createPoly: 20 0 20 56 231 56 231 101 20 101 20 143 263 143 263 0)
		(super init: &rest)
	)
)

(instance pDialProp1 of ShiversProp
	(properties
		x 58
		y 66
		priority 100
		fixPriority 1
		view 32059
		cel 9
	)

	(method (doVerb)
		(if (not (IsFlag 82))
			(gSounds stop: 13213)
			(gSounds play: 13213 0 82 0)
			(++ local0)
			(if (< 9 local0)
				(= local0 0)
			)
			(self cel: local0)
			(if (and (== local0 1) (== local1 2) (== local2 0))
				(SetFlag 82)
				(UpdateScreenItem self)
				(FrameOut)
				(gSounds play: 13209 0 82 0)
				(gCurRoom newRoom: 32390) ; rm32v390
			)
		)
	)
)

(instance pDialProp2 of ShiversProp
	(properties
		x 130
		y 66
		priority 100
		fixPriority 1
		view 32059
		cel 9
	)

	(method (doVerb)
		(if (not (IsFlag 82))
			(gSounds stop: 13213)
			(gSounds play: 13213 0 82 0)
			(++ local1)
			(if (< 9 local1)
				(= local1 0)
			)
			(self cel: local1)
			(if (and (== local0 1) (== local1 2) (== local2 0))
				(SetFlag 82)
				(UpdateScreenItem self)
				(FrameOut)
				(gSounds play: 13209 0 82 0)
				(gCurRoom newRoom: 32390) ; rm32v390
			)
		)
	)
)

(instance pDialProp3 of ShiversProp
	(properties
		x 205
		y 66
		priority 100
		fixPriority 1
		view 32059
		cel 9
	)

	(method (doVerb)
		(if (not (IsFlag 82))
			(gSounds stop: 13213)
			(gSounds play: 13213 0 82 0)
			(++ local2)
			(if (< 9 local2)
				(= local2 0)
			)
			(self cel: local2)
			(if (and (== local0 1) (== local1 2) (== local2 0))
				(SetFlag 82)
				(UpdateScreenItem self)
				(FrameOut)
				(gSounds play: 13209 0 82 0)
				(gCurRoom newRoom: 32390) ; rm32v390
			)
		)
	)
)

