;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4140)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use HotSpot)
(use RobotDoVerb)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	s1_4140 0
)

(local
	local0
)

(instance s1_4140 of PQRoom
	(properties
		picture 4140
	)

	(method (init)
		(super init: &rest)
		(Load rsVIEW 41403)
		(Load rsVIEW 41404)
		(robotFeature init:)
		(lampFeature init:)
		(northE init:)
		(eastE init:)
		(southE init:)
		(westE init:)
		(if (== gPrevRoomNum 4120) ; s1_4120
			(self setScript: killEgo)
		else
			(self setScript: continueClearing)
		)
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
				(self setScript: throwFlashBang)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(gBackMusic2 stop:)
		(proc4_5)
		(super dispose: &rest)
	)
)

(instance continueClearing of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc4_6 41401 34 -65 0 0 -1 1)
			)
			(1
				(gSwatInterface showHandAni: 6 self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance killEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(proc4_6 41402 0 -30 0 0 -1 1)
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
				(gCurRoom newRoom: 72) ; funeralRoom
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
				(flash setPri: 300 init:)
				(flashBang dispose:)
				(= cycles 2)
			)
			(2
				(flash dispose:)
				(gMessager say: 0 16 0 1 self) ; "Status! This was a soft probe! Status!"
			)
			(3
				(gMessager say: 0 16 0 2) ; "Compromised!!!"
				(global112 threwFlash: 4170)
				(gCurRoom newRoom: 4170) ; s1_4170
			)
		)
	)
)

(instance shotPacmeyer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: showCloseUp: 9019 180 70 self 1)
			)
			(1
				(Lock rsAUDIO 40104 0)
				(gBackMusic number: 40109 loop: 1 play: self)
				(UnLoad 141 40104)
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

(instance shotCarmichael of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: showCloseUp: 9010 180 70 self 1)
			)
			(1
				(Lock rsAUDIO 40104 0)
				(gBackMusic number: 40109 loop: 1 play: self)
				(UnLoad 141 40104)
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

(instance shotLamp45 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(lampHole1 init:)
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

(instance shotLamp12 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(lampHole1 init:)
				(= cycles 2)
			)
			(1
				(lampHole2 init:)
				(= cycles 2)
			)
			(2
				(lampHole3 init:)
				(= cycles 2)
			)
			(3
				(proc4_5)
				(gGame handsOff: showCloseUp: 41002 180 70 self 1)
			)
			(4
				(Lock rsAUDIO 40104 0)
				(gBackMusic number: 6007 loop: 1 play:)
				(UnLoad 141 40104)
				(SetFlag 98)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance flash of View
	(properties
		view 41403
		loop 1
	)
)

(instance lampHole1 of View
	(properties
		x 150
		y 150
		view 41404
		cel 1
	)
)

(instance lampHole2 of View
	(properties
		x 150
		y 155
		view 41404
		cel 2
	)
)

(instance lampHole3 of View
	(properties
		x 141
		y 134
		view 41404
	)
)

(instance flashBang of Prop
	(properties
		x 230
		y 300
		view 41403
	)
)

(instance robotFeature of RobotDoVerb
	(properties)

	(method (onMe param1 &tmp temp0)
		(if (and (= temp0 (super onMe: param1 &rest)) (> (param1 x:) 440))
			(= local0 1)
		)
		(return temp0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8
				(if local0
					(gCurRoom setScript: shotPacmeyer)
				else
					(gCurRoom setScript: shotCarmichael)
				)
			)
			(6
				(if local0
					(gCurRoom setScript: shotPacmeyer)
				else
					(gCurRoom setScript: shotCarmichael)
				)
			)
			(16
				(gCurRoom doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lampFeature of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 134 135 164 135 176 171 164 207 135 207 122 172
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8
				(gCurRoom setScript: shotLamp12)
			)
			(6
				(gCurRoom setScript: shotLamp45)
			)
			(else
				(gCurRoom doVerb: theVerb)
			)
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
		(gCurRoom newRoom: 4150) ; s1_4150
	)
)

(instance eastE of HotSpot
	(properties
		nsLeft 240
		nsRight 360
		nsBottom 360
		type 8195
	)

	(method (doVerb theVerb)
		(if (== theVerb 55)
			(global112 slicePie: 4170)
			(gCurRoom newRoom: 4170) ; s1_4170
		else
			(gCurRoom newRoom: 4150) ; s1_4150
		)
	)
)

(instance westE of HotSpot
	(properties
		nsRight 80
		nsBottom 360
		type 32769
	)

	(method (doVerb)
		(gCurRoom newRoom: 4150) ; s1_4150
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

