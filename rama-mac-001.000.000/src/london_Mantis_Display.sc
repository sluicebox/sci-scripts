;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3068)
(include sci.sh)
(use Main)
(use Location)
(use Button)
(use n1111)
(use Polygon)
(use Feature)
(use System)

(public
	london_Mantis_Display 0
)

(local
	local0
)

(instance london_Mantis_Display of CloseupLocation
	(properties
		heading 0
	)

	(method (init)
		(self edgeW: 0 edgeE: 0)
		(= local0 0)
		(super init: 3307)
		(= plane global116)
		(displayButton init:)
		(mantisDisplay_0 init:)
	)

	(method (pitch)
		(if (IsFlag 116)
			(= local0 1)
			(gGame handsOff:)
		else
			(super newRoom: gPrevRoomNum)
		)
	)

	(method (cue)
		(cond
			(local0
				(gGame handsOn:)
				(self newRoom: gPrevRoomNum)
			)
			(script
				(script cue:)
			)
			(else
				(gGame handsOn:)
				(proc1111_6)
			)
		)
	)

	(method (dispose)
		(proc1111_6)
		(ClearFlag 116)
		(super dispose: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(149
				(proc1111_6)
				(if script
					(script dispose:)
					(= script 0)
				)
				(gGame handsOn:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance displayButton of Button
	(properties
		x 290
		y 261
		view 3307
	)

	(method (init)
		(&= signal $efff)
		(super init: global117 &rest)
		(self setHotspot: 2)
		(if (IsFlag 116)
			(gCurRoom setScript: mantisAnim)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (proc1111_24 116)
					(SetFlag 116)
					(gCurRoom setScript: mantisAnim)
				else
					(ClearFlag 116)
					(mantisAnim dispose:)
					(gGame handsOff:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance mantisAnim of Script
	(properties)

	(method (dispose)
		(ClearFlag 116)
		(if local0
			(gCurRoom cue:)
		)
		(gGame handsOn:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(proc1111_7 3307 66 0 global161 0 0 1 gCurRoom)
				(= state -1)
			)
		)
	)
)

(instance mantisDisplay_0 of Feature
	(properties
		noun 25
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 65 101 199 99 206 73 262 79 245 28 268 8 296 35 292 62 311 106 351 144 376 146 378 188 407 286 213 287 213 220 136 209 142 142 60 142
					yourself:
				)
		)
	)
)

