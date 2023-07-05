;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4070)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use HotSpot)
(use Polygon)
(use Feature)
(use Timer)
(use Motion)
(use Actor)
(use System)

(public
	s1_4070 0
)

(local
	local0
	local1
)

(instance s1_4070 of PQRoom
	(properties
		picture 4070
	)

	(method (init)
		(super init: &rest)
		(denton init:)
		(northE init:)
		(eastE init:)
		(southE init:)
		(westE init:)
		(door init:)
		(leftSide init:)
		(rightSide init:)
		(visibleRange init:)
		(gGame handsOn:)
		(if global433
			(globalTimer setReal: globalTimer global433)
		else
			(globalTimer setReal: globalTimer 60)
		)
		(roomTimer setReal: 1 roomTimer 10)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8
				(self setScript: shootRoom 0 theVerb)
			)
			(6
				(self setScript: shootRoom 0 theVerb)
			)
			(16
				(self setScript: throwFlashBang)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (newRoom newRoomNumber)
		(if (and (gTimers contains: globalTimer) (== newRoomNumber 4060)) ; s1_4060
			(= global433 (globalTimer seconds:))
		)
		(super newRoom: newRoomNumber &rest)
	)

	(method (dispose)
		(if (gTimers contains: roomTimer)
			(roomTimer dispose: delete:)
		)
		(if (gTimers contains: globalTimer)
			(globalTimer dispose: delete:)
		)
		(proc4_5)
		(super dispose: &rest)
	)
)

(instance shootRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gTimers contains: roomTimer)
					(roomTimer dispose: delete:)
				)
				(if (gTimers contains: globalTimer)
					(globalTimer dispose: delete:)
				)
				(= cycles 2)
			)
			(1
				(gMessager say: 1 register 0 1 self)
			)
			(2
				(proc4_6 40701 0 40)
			)
			(3
				(Lock rsAUDIO 40104 0)
				(gBackMusic number: 6007 loop: 1 play:)
				(UnLoad 141 40104)
				(SetFlag 98)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance throwFlashBang of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gTimers contains: roomTimer)
					(roomTimer dispose: delete:)
				)
				(if (gTimers contains: globalTimer)
					(globalTimer dispose: delete:)
				)
				(denton dispose:)
				(gFxSound number: 1003 setLoop: 1 play:)
				(dentFlashed init: setCycle: End self)
			)
			(1
				(gFxSound number: 1002 setLoop: 1 play:)
				(Palette 2 42 254 500) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(2
				(Palette 2 42 254 250) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(3
				(Palette 2 42 254 150) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(4
				(Palette 2 42 254 100) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(5
				(gMessager say: 0 16 0 1 self) ; "Status! This was a soft probe! Status!"
			)
			(6
				(proc4_6 40701 0 40)
			)
			(7
				(Lock rsAUDIO 40104 0)
				(gBackMusic number: 6007 loop: 1 play:)
				(UnLoad 141 40104)
				(SetFlag 98)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance dentonShot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gTimers contains: roomTimer)
					(roomTimer dispose: delete:)
				)
				(if (gTimers contains: globalTimer)
					(globalTimer dispose: delete:)
				)
				(Lock rsAUDIO 40104 0)
				(gBackMusic number: 0 stop:)
				(gGame handsOff: showCloseUp: 40702 180 70 self 1)
				(UnLoad 141 40104)
			)
			(1
				(gBackMusic number: 40109 loop: 1 play: self)
				(gMessager say: 1 8 0 0) ; "Cease fire! Cease fire!"
			)
			(2
				(gBackMusic number: 6007 loop: 1 play:)
				(SetFlag 98)
				(SetFlag 94)
				(SetFlag 100)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance dentonNodsYes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local1 1)
				(denton hide:)
				(dentNodsYes init: cel: 0 setCycle: End self)
			)
			(1
				(denton show:)
				(dentNodsYes dispose:)
				(= local1 0)
				(self dispose:)
			)
		)
	)
)

(instance dentonThumbsUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local1 1)
				(denton hide:)
				(dentThumbsUp init: cel: 0 setCycle: End self)
			)
			(1
				(denton show:)
				(dentThumbsUp dispose:)
				(= local1 0)
				(self dispose:)
			)
		)
	)
)

(instance dentonComplains of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local1 1)
				(denton hide:)
				(dentComplains init: cel: 0 setCycle: End self)
			)
			(1
				(denton show:)
				(dentComplains dispose:)
				(= local1 0)
				(self dispose:)
			)
		)
	)
)

(instance dentonGlances of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local1 1)
				(denton hide:)
				(dentGlances init: cel: 0 setCycle: End self)
			)
			(1
				(denton show:)
				(dentGlances dispose:)
				(= local1 0)
				(self dispose:)
			)
		)
	)
)

(instance dentonNodsNo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local1 1)
				(denton hide:)
				(dentNodsNo init: cel: 0 setCycle: End self)
			)
			(1
				(denton show:)
				(dentNodsNo dispose:)
				(= local1 0)
				(self dispose:)
			)
		)
	)
)

(instance getOutaThere of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gTimers contains: globalTimer)
					(globalTimer dispose: delete:)
				)
				(proc4_5)
				(gGame handsOff: showCloseUp: 40607 180 70 self 1)
			)
			(1
				(Lock rsAUDIO 40104 0)
				(gBackMusic number: 6007 loop: 1 play:)
				(UnLoad 141 40104)
				(SetFlag 98)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance denton of View
	(properties
		noun 1
		x 230
		y 255
		view 40710
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8
				(if (not local1)
					(gCurRoom setScript: dentonShot)
				)
			)
			(6
				(if (not local1)
					(gCurRoom setScript: dentonShot)
				)
			)
			(45
				(if (not local1)
					(gCurRoom setScript: dentonThumbsUp)
				)
			)
			(44
				(if (not local1)
					(gCurRoom setScript: dentonThumbsUp)
				)
			)
			(43
				(if (not local1)
					(gCurRoom setScript: dentonGlances)
				)
			)
			(42
				(if (not local1)
					(gCurRoom setScript: dentonGlances)
				)
			)
			(47
				(if (not local1)
					(gCurRoom setScript: dentonNodsYes)
				)
			)
			(49
				(if (not local1)
					(gCurRoom setScript: dentonNodsNo)
				)
			)
			(else
				(gCurRoom doVerb: theVerb)
			)
		)
	)
)

(instance dentFlashed of Prop
	(properties
		x 230
		y 255
		view 40702
	)
)

(instance dentNodsYes of Prop
	(properties
		x 230
		y 255
		view 40710
	)
)

(instance dentThumbsUp of Prop
	(properties
		x 230
		y 255
		view 40711
	)
)

(instance dentComplains of Prop
	(properties
		x 230
		y 255
		view 40712
	)
)

(instance dentGlances of Prop
	(properties
		x 230
		y 255
		view 40713
	)
)

(instance dentNodsNo of Prop
	(properties
		x 230
		y 255
		view 40714
	)
)

(instance door of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 200 40 258 49 258 48 306 42 308 234 257 220 202 238 198 40
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 48)
			(if (not local1)
				(gCurRoom setScript: dentonThumbsUp)
			)
		else
			(gCurRoom doVerb: theVerb)
		)
	)
)

(instance leftSide of Feature
	(properties)

	(method (init)
		(= nsLeft (westE nsLeft:))
		(= nsTop (westE nsTop:))
		(= nsRight (westE nsRight:))
		(= nsBottom (westE nsBottom:))
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 48)
			(if (not local1)
				(gCurRoom setScript: dentonThumbsUp)
			)
		else
			(gCurRoom doVerb: theVerb)
		)
	)
)

(instance rightSide of Feature
	(properties)

	(method (init)
		(= nsLeft (eastE nsLeft:))
		(= nsTop (eastE nsTop:))
		(= nsRight (eastE nsRight:))
		(= nsBottom (eastE nsBottom:))
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 48)
			(if (not local1)
				(gCurRoom setScript: dentonComplains)
			)
		else
			(gCurRoom doVerb: theVerb)
		)
	)
)

(instance visibleRange of Feature
	(properties
		nsLeft 130
		nsRight 360
		nsBottom 360
	)

	(method (doVerb theVerb)
		(if (== theVerb 42)
			(if (not local1)
				(gCurRoom setScript: dentonGlances)
			)
		else
			(gCurRoom doVerb: theVerb)
		)
	)
)

(instance northE of HotSpot
	(properties
		nsRight 640
		nsBottom 50
		type 4097
	)

	(method (doVerb)
		(if (not local1)
			(gCurRoom setScript: dentonComplains)
		)
	)
)

(instance eastE of HotSpot
	(properties
		nsLeft 560
		nsRight 640
		nsBottom 360
		type 8193
	)

	(method (doVerb)
		(gCurRoom newRoom: 4060) ; s1_4060
	)
)

(instance westE of HotSpot
	(properties
		nsRight 90
		nsBottom 360
		type 32769
	)

	(method (doVerb)
		(gCurRoom newRoom: 4080) ; s1_4080
	)
)

(instance southE of HotSpot
	(properties
		nsTop 300
		nsRight 640
		nsBottom 360
		type 16385
	)

	(method (doVerb)
		(gCurRoom newRoom: 4060) ; s1_4060
	)
)

(instance roomTimer of Timer
	(properties)

	(method (cue)
		(switch local0
			(1
				(gMessager say: 0 0 1 1 0 4060) ; "Pup! Cover right!"
				(self setReal: 2 self 5)
			)
			(2
				(gMessager say: 0 0 1 1 0 4060) ; "Pup! Cover right!"
				(self setReal: 3 self 5)
			)
			(3
				(gMessager say: 0 0 1 1 0 4060) ; "Pup! Cover right!"
				(self setReal: 4 self 5)
			)
			(4
				(gCurRoom setScript: getOutaThere)
			)
		)
	)

	(method (setReal param1)
		(= local0 param1)
		(super setReal: &rest)
	)
)

(instance globalTimer of Timer
	(properties)

	(method (cue)
		(gCurRoom setScript: getOutaThere)
	)
)

