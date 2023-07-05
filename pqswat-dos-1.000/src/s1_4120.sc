;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4120)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use HotSpot)
(use Motion)
(use Actor)
(use System)

(public
	s1_4120 0
)

(instance s1_4120 of PQRoom
	(properties
		picture 4120
	)

	(method (init)
		(super init: &rest)
		(northE init:)
		(eastE init:)
		(southE init:)
		(westE init:)
		(eastJam init:)
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8
				(self setScript: officerComingOut)
			)
			(6
				(self setScript: officerComingOut)
			)
			(16
				(global112 threwFlash: 4160)
				(self setScript: throwFlashBang)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(proc4_5)
		(super dispose: &rest)
	)
)

(instance throwFlashBang of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gFxSound number: 1003 setLoop: 1 play:)
				(flashBang init: setCycle: End self)
			)
			(1
				(gFxSound number: 1002 setLoop: 1 play:)
				(Palette 2 42 254 500) ; PalIntensity
				(FrameOut)
				(flashBang dispose:)
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
				(gMessager sayRange: 0 16 0 1 2 self) ; "Status! This was a soft probe! Status!"
			)
			(6
				(gCurRoom newRoom: 4160) ; s1_4160
			)
		)
	)
)

(instance officerComingOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
				(= cycles 2)
			)
			(1
				(proc4_5)
				(gGame handsOff: showCloseUp: 41002 180 70 self 1)
			)
			(2
				(Lock rsAUDIO 40104 0)
				(gBackMusic number: 6007 loop: 1 play:)
				(UnLoad 141 40104)
				(SetFlag 98)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance killEgoNorth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(proc4_6 41200 8 101 0 0 -1 1)
				(Lock rsAUDIO 40104 0)
				(gBackMusic number: 40108 loop: -1 play:)
				(UnLoad 141 40104)
			)
			(2
				(gBackMusic number: 0 stop:)
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance killEgoWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(proc4_6 41200 8 101 0 0 -1 1)
				(Lock rsAUDIO 40104 0)
				(gBackMusic number: 40108 loop: -1 play:)
				(UnLoad 141 40104)
			)
			(2
				(gGame showCloseUp: 9025 180 70 self 1)
			)
			(3
				(gBackMusic number: 0 stop:)
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance pieInto4130 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gMessager say: 0 51 1 0 self) ; "Trailer! Kitchen door!"
			)
			(2
				(gCurRoom newRoom: 4130) ; s1_4130
			)
		)
	)
)

(instance pacmeyerStares of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: saveRobot: 1 showCloseUp: 41003 180 70 self)
			)
			(1
				(gGame saveRobot: 0 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance flashBang of Prop
	(properties
		x 300
		y 360
		view 41201
	)
)

(instance northE of HotSpot
	(properties
		nsRight 640
		nsBottom 50
		type 4097
	)

	(method (doVerb)
		(gCurRoom setScript: killEgoNorth)
	)
)

(instance eastE of HotSpot
	(properties
		nsLeft 370
		nsRight 575
		nsBottom 360
		type 8193
	)

	(method (doVerb)
		(gCurRoom newRoom: 4160) ; s1_4160
	)
)

(instance westE of HotSpot
	(properties
		nsRight 50
		nsBottom 360
		type 32771
	)

	(method (doVerb theVerb)
		(if (== theVerb 55)
			(global112 slicePie: 4140)
			(gCurRoom newRoom: 4140) ; s1_4140
		else
			(gCurRoom setScript: killEgoWest)
		)
	)
)

(instance southE of HotSpot
	(properties
		nsTop 310
		nsRight 640
		nsBottom 360
		type 16385
	)

	(method (doVerb)
		(gCurRoom setScript: pacmeyerStares)
	)
)

(instance eastJam of HotSpot
	(properties
		nsLeft 370
		nsRight 575
		nsBottom 360
		type 8194
	)

	(method (doVerb)
		(global112 slicePie: 4130)
		(gCurRoom setScript: pieInto4130)
	)
)

