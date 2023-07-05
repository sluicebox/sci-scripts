;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4052)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use HotSpot)
(use Osc)
(use Timer)
(use Actor)
(use System)

(public
	s2_405 0
	sFirstTime 3
)

(local
	[local0 2]
)

(instance s2_405 of PQRoom
	(properties
		modNum 405
		picture 405
	)

	(method (init)
		(super init: &rest)
		(SetFlag 65)
		(greaseBoard init:)
		(gGame handsOn:)
		(cond
			((and (IsFlag 232) (not (SetFlag 247)))
				(gCurRoom setScript: sFirstTime)
			)
			((and (IsFlag 232) (== gPrevRoomNum 415)) ; s2_415
				(cond
					((IsFlag 233)
						(ClearFlag 232)
						(SetFlag 218)
						(self setScript: sMoveOut)
					)
					((and (IsFlag 214) (IsFlag 213) (not (IsFlag 217)))
						(rooker init:)
						(pacmeyer init:)
						(jeopardyTimer setReal: jeopardyTimer 10)
						(gGame handsOn:)
					)
				)
			)
			(else
				(eastExit init:)
				(westExit init:)
				(charmike init:)
				(wixell init:)
				(rhea init: setCycle: Osc -1)
				(denton init:)
				(if (not (SetFlag 125))
					(self setScript: sFirstEntry)
				)
			)
		)
	)

	(method (dispose)
		(proc4_5)
		(if (gTimers contains: jeopardyTimer)
			(jeopardyTimer dispose: delete:)
		)
		(super dispose:)
	)
)

(instance sFirstEntry of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(rhea hide:)
				(proc4_6 4057 273 129 0 0 40 1)
			)
			(1
				(proc4_5)
				(rhea show: setCycle: Osc -1)
				(= temp0 (ScriptID 4054 1)) ; briefingTimer
				(if (> (temp0 seconds:) 60)
					(temp0 setReal: temp0 60)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sFirstTime of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 4054 0) changeMusic: 29802) ; kiplandRegion
				(proc4_6 4050 156 70 0 0 -1 1)
				(if (gCast contains: charmike)
					(charmike dispose:)
					(wixell dispose:)
					(rhea dispose:)
					(denton dispose:)
					(Palette 2 42 254 100) ; PalIntensity
					(FrameOut)
				)
			)
			(1
				(gCurRoom newRoom: 415) ; s2_415
			)
		)
	)
)

(instance sMoveOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc4_6 40565 156 70 0 0 -1 1)
			)
			(1
				(gCurRoom newRoom: 2980) ; s2_2980
			)
		)
	)
)

(instance sTalkToCar of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(charmike hide:)
				(proc4_6 4058 284 137 0 0 60 1)
			)
			(1
				(proc4_5)
				(charmike show:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTalkToWixell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(wixell hide:)
				(if (SetFlag 229)
					(proc4_6 4053 155 60 0 0 68 1)
				else
					(proc4_6 40512 155 60 0 0 68 1)
				)
			)
			(1
				(proc4_5)
				(wixell show:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTalkToDenton of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(denton hide:)
				(if (SetFlag 230)
					(proc4_6 4052 152 61 0 0 80 1)
				else
					(proc4_6 40511 152 61 0 0 80 1)
				)
			)
			(1
				(proc4_5)
				(denton show:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTalkToRhea of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(rhea hide:)
				(if (SetFlag 228)
					(proc4_6 40571 274 129 0 0 40 1)
				else
					(proc4_6 40572 274 129 0 0 40 1)
				)
			)
			(1
				(proc4_5)
				(rhea show:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance rooker of Prop
	(properties
		x 149
		y 71
		view 4051
		cel 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(if (IsFlag 232)
					(SetFlag 231)
				)
				(gCurRoom newRoom: 415) ; s2_415
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pacmeyer of Prop
	(properties
		x 149
		y 71
		view 4051
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(if (IsFlag 232)
					(SetFlag 231)
				)
				(gCurRoom newRoom: 415) ; s2_415
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance charmike of Prop
	(properties
		x 285
		y 342
		z 200
		view 4058
	)

	(method (init)
		(self setPri: 60)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(gCurRoom setScript: sTalkToCar)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance denton of Prop
	(properties
		x 190
		y 80
		view 40511
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(gCurRoom setScript: sTalkToDenton)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rhea of Prop
	(properties
		x 280
		y 248
		view 40573
		cel 3
	)

	(method (init)
		(self setPri: 40)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(gCurRoom setScript: sTalkToRhea)
			)
		)
	)
)

(instance wixell of Prop
	(properties
		x 155
		y 68
		view 40512
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(gCurRoom setScript: sTalkToWixell)
			)
		)
	)
)

(instance greaseBoard of View
	(properties
		x 440
		y 174
		view 415
	)

	(method (doVerb)
		(if (IsFlag 232)
			(SetFlag 231)
		)
		(gCurRoom newRoom: 415) ; s2_415
	)
)

(instance eastExit of HotSpot
	(properties
		nsLeft 600
		nsRight 640
		nsBottom 360
		type 8193
	)

	(method (doVerb)
		(gCurRoom newRoom: 2980) ; s2_2980
	)
)

(instance westExit of HotSpot
	(properties
		nsRight 40
		nsBottom 360
		type 32769
	)

	(method (doVerb)
		(gCurRoom newRoom: 2980) ; s2_2980
	)
)

(instance jeopardyTimer of Timer
	(properties)

	(method (cue)
		(SetFlag 223)
		(gCurRoom newRoom: 415) ; s2_415
	)
)

