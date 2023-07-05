;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 100)
(include sci.sh)
(use Main)
(use PQRoom)
(use Polygon)
(use Actor)
(use System)

(public
	rm100 0
)

(local
	[local0 3]
)

(instance rm100 of PQRoom
	(properties
		picture 100
	)

	(method (init)
		(Load rsAUDIO 10001)
		(Lock rsAUDIO 10001 1)
		(super init: &rest)
		(if (or (IsFlag 31) (IsFlag 32))
			(ClearFlag 31)
			(ClearFlag 32)
			(= global108 0)
			((ScriptID 19 0) doit:) ; swatInvInit
		)
		(angelsProp init:)
		(academyProp init:)
		(metroProp init:)
		(self setScript: startRoomScript)
	)

	(method (dispose)
		(Lock rsAUDIO 10001 0)
		(super dispose: &rest)
	)
)

(instance startRoomScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gBackMusic number: 10001 setLoop: -1 play:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance testScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gBackMusic stop:)
				(gBackMusic number: (scratch onMeSound:) setLoop: -1 play:)
				(Palette 2 0 254 0) ; PalIntensity
				(FrameOut)
				(= seconds 2)
			)
			(1
				(gBackMusic fade: 0 1 21 1)
				(gCurRoom newRoom: register)
			)
		)
	)
)

(class MapProp of Prop
	(properties
		view 104
		onMeSound 0
	)
)

(instance angelsProp of MapProp
	(properties
		x 52
		y 243
		onMeSound 10002
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 52 243 310 243 310 389 52 389
					yourself:
				)
		)
	)

	(method (doVerb)
		(Lock rsAUDIO 10001 0)
		(gCurRoom
			setScript:
				(testScript scratch: self yourself:)
				0
				(if (IsFlag 21) 300 else 310)
		)
	)
)

(instance academyProp of MapProp
	(properties
		x 76
		y 21
		onMeSound 10003
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 76 21 334 21 334 166 76 166
					yourself:
				)
		)
	)

	(method (doVerb)
		(Lock rsAUDIO 10001 0)
		(gCurRoom setScript: (testScript scratch: self yourself:) 0 200)
	)
)

(instance metroProp of MapProp
	(properties
		x 357
		y 159
		onMeSound 10004
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 357 159 615 159 615 305 357 305
					yourself:
				)
		)
	)

	(method (doVerb)
		(Lock rsAUDIO 10001 0)
		(gCurRoom setScript: (testScript scratch: self yourself:) 0 35)
	)
)

