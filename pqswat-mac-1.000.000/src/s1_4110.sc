;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4110)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use HotSpot)
(use Motion)
(use Actor)
(use System)

(public
	s1_4110 0
)

(instance s1_4110 of PQRoom
	(properties
		picture 4110
	)

	(method (init)
		(super init: &rest)
		(Load rsVIEW 41103)
		(northE init:)
		(southE init:)
		(eastJam init:)
		(scout setPri: 500 init:)
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
		(gBackMusic2 number: 0 stop:)
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
				(flash setPri: 400 init:)
				(flashBang dispose:)
				(= cycles 2)
			)
			(2
				(flash dispose:)
				(gMessager sayRange: 0 16 0 1 2 self) ; "Status! This was a soft probe! Status!"
			)
			(3
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
				(gMessager say: 0 8 0 1 self) ; "Compromised!!!"
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
			)
			(1
				(gGame handsOff: showCloseUp: 41002 180 70 self)
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
				(proc4_6 41102 8 12 0 0 375 1)
				(= cycles 2)
			)
			(2
				(Lock rsAUDIO 40104 0)
				(gBackMusic2 number: 40107 loop: 1 play:)
				(gBackMusic number: 40108 loop: -1 play:)
				(UnLoad 141 40104)
			)
			(3
				(gBackMusic loop: 1 stop:)
				(gBackMusic number: 40109 loop: 1 play: self)
			)
			(4
				(gCurRoom newRoom: 72) ; funeralRoom
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

(instance scoutShot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(scout dispose:)
				(gGame handsOff: showCloseUp: 9010 180 70 self)
			)
			(1
				(Lock rsAUDIO 40104 0)
				(gBackMusic number: 6007 loop: 1 play:)
				(UnLoad 141 40104)
				(SetFlag 98)
				(SetFlag 94)
				(SetFlag 100)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance scout of View
	(properties
		x 351
		y 358
		view 41101
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8
				(gCurRoom setScript: scoutShot)
			)
			(6
				(gCurRoom setScript: scoutShot)
			)
			(else
				(gCurRoom doVerb: theVerb)
			)
		)
	)
)

(instance flash of View
	(properties
		x 102
		view 41103
		loop 1
	)
)

(instance flashBang of Prop
	(properties
		x 100
		y 375
		view 41103
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
		nsLeft 350
		nsRight 500
		nsBottom 360
		type 8195
	)

	(method (doVerb theVerb)
		(if (== theVerb 55)
			(global112 slicePie: 4120)
			(gCurRoom newRoom: 4120) ; s1_4120
		else
			(gCurRoom newRoom: 4160) ; s1_4160
		)
	)
)

