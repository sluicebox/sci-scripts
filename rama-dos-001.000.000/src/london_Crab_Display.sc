;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3067)
(include sci.sh)
(use Main)
(use Location)
(use Button)
(use n1111)
(use System)

(public
	london_Crab_Display 0
)

(local
	local0
)

(instance london_Crab_Display of CloseupLocation
	(properties
		noun 26
		heading 0
	)

	(method (init)
		(self edgeW: 0 edgeE: 0)
		(super init: 3306)
		(= plane global116)
		(displayButton init:)
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

	(method (dispose)
		(proc1111_6)
		(ClearFlag 116)
		(super dispose: &rest)
	)
)

(instance displayButton of Button
	(properties
		x 382
		y 239
		view 3306
	)

	(method (init)
		(&= signal $efff)
		(super init: global117 &rest)
		(self setHotspot: 2)
		(if (IsFlag 116)
			(gCurRoom setScript: crabAnim)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (proc1111_24 116)
					(SetFlag 116)
					(gCurRoom setScript: crabAnim)
				else
					(ClearFlag 116)
					(crabAnim dispose:)
					(gGame handsOff:)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance crabAnim of Script
	(properties)

	(method (dispose)
		(ClearFlag 116)
		(gGame handsOn:)
		(if local0
			(gCurRoom cue:)
		)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				0
				(proc1111_7 3306 177 0 global161 0 0 1 gCurRoom)
				(= state -1)
			)
		)
	)
)

