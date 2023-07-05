;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 63000)
(include sci.sh)
(use Main)
(use n63002)
(use ExitFeature)
(use Room)

(public
	nExit 0
	sExit 1
	eExit 2
	wExit 3
)

(local
	local0
)

(class P2Room of Room
	(properties
		north 0
		south 0
		east 0
		west 0
	)

	(method (init)
		((= plane gThePlane) setRect: 0 70 640 406 1 priority: 1)
		(UpdatePlane gThePlane)
		(super init: &rest)
		(cond
			(global209
				(proc63002_7 global209)
				(= global209 0)
			)
			((gSceneList size:)
				(switch (gSceneList size:)
					(1
						(proc63002_7 ((gSceneList at: 0) scene:))
					)
					(2
						(proc63002_7
							((gSceneList at: 0) scene:)
							((gSceneList at: 1) scene:)
						)
					)
					(3
						(proc63002_7
							((gSceneList at: 0) scene:)
							((gSceneList at: 1) scene:)
							((gSceneList at: 2) scene:)
						)
					)
				)
				(gSceneList eachElementDo: #dispose)
				(gSceneList release:)
			)
		)
		(if north
			(nExit init: nextRoom: north exitDir: 0)
		)
		(if south
			(sExit init: nextRoom: south exitDir: 4)
		)
		(if east
			(eExit init: nextRoom: east exitDir: 2)
		)
		(if west
			(wExit init: nextRoom: west exitDir: 6)
		)
		(Palette 2 3 31 0) ; PalIntensity
		(Palette 2 32 255 100) ; PalIntensity
	)

	(method (doVerb)
		(return 0)
	)

	(method (newRoom newRoomNumber)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(= global237 picture)
		(nExit nextRoom: 0 exitScene: 0 scene: 0 fullLVDM: 0)
		(sExit nextRoom: 0 exitScene: 0 scene: 0 fullLVDM: 0)
		(eExit nextRoom: 0 exitScene: 0 scene: 0 fullLVDM: 0)
		(wExit nextRoom: 0 exitScene: 0 scene: 0 fullLVDM: 0)
		(super dispose: &rest)
	)
)

(class CloseupRoom of P2Room
	(properties
		exitRoom 0
	)

	(method (init)
		(= local0 (IsFlag 1001))
		(ClearFlag 1001)
		(if exitRoom
			(= north (= south (= east (= west exitRoom))))
		)
		(super init: &rest)
		(if exitRoom
			(nExit exitDir: 8)
			(sExit exitDir: 8)
			(eExit exitDir: 8)
			(wExit exitDir: 8)
		)
	)

	(method (dispose)
		(if local0
			(SetFlag 1001)
		else
			(ClearFlag 1001)
		)
		(super dispose: &rest)
	)
)

(instance nExit of ExitFeature
	(properties
		priority 200
	)

	(method (init)
		(= exitDir (= whoDoit 0))
		(if argc
			(super init: &rest)
		else
			(super init: 0 0 639 39)
		)
	)
)

(instance sExit of ExitFeature
	(properties
		priority 200
	)

	(method (init)
		(= whoDoit 0)
		(= exitDir 4)
		(if argc
			(super init: &rest)
		else
			(super init: 0 297 639 335)
		)
	)
)

(instance eExit of ExitFeature
	(properties
		priority 200
	)

	(method (init)
		(= whoDoit 0)
		(= exitDir 2)
		(if argc
			(super init: &rest)
		else
			(super init: 600 40 639 296)
		)
	)
)

(instance wExit of ExitFeature
	(properties
		priority 200
	)

	(method (init)
		(= whoDoit 0)
		(= exitDir 6)
		(if argc
			(super init: &rest)
		else
			(super init: 0 40 40 296)
		)
	)
)

