;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 15800)
(include sci.sh)
(use Main)
(use oHandsOnWhenCued)
(use TPScript)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)

(public
	roGuardsHouseLS 0
)

(instance soForestToExt of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 300 290 self)
				((ScriptID 64018 0) setMotion: MoveTo 360 290) ; oBoogle
			)
			(1
				((ScriptID 64018 0) setWander: 1) ; oBoogle
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance foNorthExit of Feature
	(properties
		nsRight 632
		nsBottom 260
	)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 1)) ; oNorthCursor
	)

	(method (doVerb)
		(gEgo setScript: soNorthExit)
	)
)

(instance soNorthExit of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 300 260 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 300 200)
				(= cycles 2)
			)
			(2
				(gCurRoom newRoom: 15000) ; roGuardHouseExt
			)
		)
	)
)

(instance foSouthExit of Feature
	(properties
		nsTop 289
		nsRight 632
		nsBottom 316
	)

	(method (init)
		(super init: &rest)
		(self forceCursor: (ScriptID 64006 2)) ; oSouthCursor
	)

	(method (doVerb)
		(gEgo setScript: soSouthExit)
	)
)

(instance soSouthExit of TPScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: PolyPath 300 315 self)
			)
			(1
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 300 360 self)
			)
			(2
				(gEgo setMotion: MoveTo 300 365)
				(= cycles 2)
			)
			(3
				(gCurRoom newRoom: 10100) ; roForestScroll
			)
		)
	)
)

(instance roGuardsHouseLS of TPRoom
	(properties
		picture 15800
		south 10100
	)

	(method (init)
		(super init: &rest)
		(gEgo init: normalize: setScaler: Scaler 100 64 290 228)
		((ScriptID 64018 0) ; oBoogle
			init:
			normalize:
			setWander: 0
			setScaler: Scaler 100 64 290 228
		)
		(foSouthExit init:)
		(foNorthExit init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 197 315 438 315 438 260 197 260
					yourself:
				)
		)
		(gGame handsOff:)
		(switch gPrevRoomNum
			(10100 ; roForestScroll
				(gEgo posn: 310 340 loop: 3)
				((ScriptID 64018 0) posn: 360 340 loop: 3) ; oBoogle
				(gEgo setScript: soForestToExt)
			)
			(else
				(gEgo posn: 310 340 loop: 3)
				(gEgo setScript: soForestToExt)
			)
		)
		(goMusic1 setMusic: 15800)
	)
)

