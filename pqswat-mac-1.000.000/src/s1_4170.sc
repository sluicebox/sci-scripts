;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4170)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use swatInvInit)
(use HotSpot)
(use RobotDoVerb)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	s1_4170 0
)

(instance s1_4170 of PQRoom
	(properties
		picture 4170
	)

	(method (init)
		(super init: &rest)
		(northE init:)
		(eastE init:)
		(westE init:)
		(tvFeature init:)
		(robotFeature init:)
		(bathroomDoor init:)
		(bed init:)
		(if (global112 flashBanged:)
			(self setScript: lucysDead)
		else
			(Lock rsAUDIO 40104 0)
			(Load rsAUDIO 40105)
			(Lock rsAUDIO 40105 1)
			(gBackMusic number: 0 stop:)
			(gBackMusic number: 40105 loop: -1 play:)
			(UnLoad 141 40104)
			(Load rsVIEW 41709)
			(self setScript: coverDoor)
		)
	)

	(method (doit)
		(if
			(and
				(== script coverDoor)
				(== (script state:) 2)
				(or
					(not (and (> gMouseX 435) (< gMouseX 535)))
					(and
						(!= (gSwatInterface curInvItem:) (proc19_3 0))
						(!= (gSwatInterface curInvItem:) (proc19_3 4))
					)
					(and
						(or
							(== (gSwatInterface curInvItem:) (proc19_3 0))
							(== (gSwatInterface curInvItem:) (proc19_3 4))
						)
						(not (((gSwatInterface curInvItem:) data:) roundsLeft:))
					)
				)
			)
			(gGame handsOff:)
			(self setScript: seeHolesInDoor)
		)
		(super doit: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6
				(self setScript: officerComingOut)
			)
			(8
				(self setScript: officerComingOut)
			)
			(16
				(self setScript: throwFlashBang)
			)
			(44
				(gMessager say: 0 44 0 1 self) ; "Pup, cover the door..."
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

(instance coverDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOn:)
				(proc4_6 41701 0 24)
			)
			(1
				(gSwatInterface showHandAni: 3)
				(if gAutoRobot
					(gAutoRobot priority: 5)
				)
			)
			(2 0)
			(3
				(gMessager say: 0 44 0 2 self) ; "Pup, you cover Carmichael!"
			)
			(4
				(gCurRoom newRoom: 4160) ; s1_4160
			)
		)
	)
)

(instance seeHolesInDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if gAutoRobot
					(-- state)
				)
				(= cycles 1)
			)
			(1
				(gFxSound number: 4200 setLoop: 1 play:)
				(= ticks 20)
			)
			(2
				(bulletHoles init:)
				(= ticks 10)
			)
			(3
				(gFxSound number: 4200 setLoop: 1 play:)
				(= ticks 20)
			)
			(4
				(bulletHoles cel: 1 init:)
				(UpdateScreenItem bulletHoles)
				(= ticks 10)
			)
			(5
				(gFxSound number: 4200 setLoop: 1 play:)
				(= ticks 20)
			)
			(6
				(bulletHoles cel: 2 init:)
				(UpdateScreenItem bulletHoles)
				(= ticks 20)
			)
			(7
				(gFxSound number: 4200 setLoop: 1 play:)
				(= ticks 20)
			)
			(8
				(bulletHoles cel: 3 init:)
				(UpdateScreenItem bulletHoles)
				(= seconds 2)
			)
			(9
				(proc4_5)
				(gGame showCloseUp: 9025 180 70 self 1)
			)
			(10
				(Lock rsAUDIO 40105 0)
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance lucysDead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(lucy init:)
				(= cycles 2)
			)
			(1
				(proc4_6 41700 0 0 0 0 500 1)
				(Lock rsAUDIO 40104 0)
				(gBackMusic number: 0 stop:)
				(gBackMusic number: 40109 loop: 1 play:)
				(UnLoad 141 40104)
			)
			(2
				(gBackMusic number: 6007 loop: 1 play:)
				(SetFlag 98)
				(SetFlag 95)
				(SetFlag 103)
				(gCurRoom newRoom: 35) ; metroExt
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
				(Lock rsAUDIO 40105 0)
				(gBackMusic number: 6007 loop: 1 play:)
				(UnLoad 141 40105)
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
				(flashBang setPri: 1 init: setCycle: End self)
			)
			(1
				(whiteScreen init:)
				(gFxSound number: 1002 setLoop: 1 play:)
				(Palette 2 42 254 500) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(2
				(whiteScreen dispose:)
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
				(proc4_6 41703 77 17 0 0 5 1)
			)
			(6
				(Lock rsAUDIO 40105 0)
				(gBackMusic number: 6007 loop: 1 play:)
				(UnLoad 141 40105)
				(SetFlag 98)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance shotDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gMessager say: 0 8 2 0 self) ; "Compromised!!!"
			)
			(2
				(SetFlag 155)
				(gCurRoom newRoom: 4210) ; s1_4210
			)
		)
	)
)

(instance robotShot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCast eachElementDo: #dispose)
				(proc4_5)
				(gGame handsOff: showCloseUp: 9019 180 70 self 1)
			)
			(1
				(Lock rsAUDIO 40105 0)
				(gBackMusic number: 6007 loop: 1 play:)
				(UnLoad 141 40105)
				(SetFlag 98)
				(SetFlag 94)
				(SetFlag 100)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance shotTV of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(tv init: setCycle: End self)
			)
			(1
				(proc4_5)
				(gGame handsOff: showCloseUp: 41002 180 70 self 1)
			)
			(2
				(Lock rsAUDIO 40105 0)
				(gBackMusic number: 6007 loop: 1 play:)
				(UnLoad 141 40105)
				(SetFlag 98)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance tv of Prop
	(properties
		x 100
		y 177
		view 41710
	)
)

(instance flashBang of Prop
	(properties
		x 351
		y 413
		view 41704
	)
)

(instance lucy of View
	(properties
		x 97
		y 294
		view 41701
	)
)

(instance bulletHoles of View
	(properties
		x 465
		y 141
		view 41709
	)
)

(instance whiteScreen of View
	(properties
		x 289
		y 179
		priority 500
		fixPriority 1
		view 6
	)
)

(instance bathroomDoor of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 442 16 508 0 538 0 538 336 518 338 506 352 442 336
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8
				(gCurRoom setScript: shotDoor)
			)
			(6
				(gCurRoom setScript: shotDoor)
			)
			(48
				(gMessager say: 0 theVerb 3) ; "Probable..."
			)
			(else
				(gCurRoom doVerb: theVerb)
			)
		)
	)
)

(instance bed of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 249 90 288 122 345 122 357 0 357
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 48)
			(gMessager say: 0 theVerb 4) ; "Pup, we're checking..."
		else
			(gCurRoom doVerb: theVerb)
		)
	)
)

(instance tvFeature of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 122 179 148 179 148 201 135 204 123 202
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8
				(gCurRoom setScript: shotTV)
			)
			(6
				(gCurRoom setScript: shotTV)
			)
			(else
				(gCurRoom doVerb: theVerb)
			)
		)
	)
)

(instance robotFeature of RobotDoVerb
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(8
				(gCurRoom setScript: robotShot)
			)
			(6
				(gCurRoom setScript: robotShot)
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
		nsLeft 590
		nsRight 640
		nsBottom 360
		type 8193
	)

	(method (doVerb)
		(gCurRoom newRoom: 4150) ; s1_4150
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
			(global112 slicePie: 4150)
		)
		(gCurRoom newRoom: 4150) ; s1_4150
	)
)

