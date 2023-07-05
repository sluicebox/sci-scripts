;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3410)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use HotSpot)
(use RobotDoVerb)
(use Polygon)
(use Motion)
(use Actor)
(use System)

(public
	s2_3410 0
)

(local
	local0
	local1
	local2
	local3
)

(instance s2_3410 of PQRoom
	(properties
		picture 3410
	)

	(method (init)
		(super init: &rest)
		(northE init:)
		(eastE init:)
		(westE init:)
		(host init: hide:)
		(robotFeature init:)
		(if (OneOf gPrevRoomNum 3360 3370) ; s2_3360, s2_3370
			(if (global112 leftEarly:)
				((ScriptID 4054 0) changeMusic: 29807) ; kiplandRegion
				(self setScript: leftEarlyScript)
			else
				((ScriptID 4054 0) changeMusic: 29809) ; kiplandRegion
				(self setScript: charAndDentPresent)
			)
		else
			((ScriptID 4054 0) changeMusic: 29807) ; kiplandRegion
			(if (global112 leftEarly:)
				(self setScript: wixellNotPresent)
			else
				(self setScript: wixellPresent)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10
				(self setScript: holdFire)
			)
			(6
				(self setScript: holdFire)
			)
			(16
				(self setScript: throwFlashBang)
			)
			(45
				(if (>= (++ local0) 2)
					(SetFlag 101)
					(self setScript: officerComingOut)
				else
					(host setScript: doCloseUp 0 34107)
				)
			)
			(44
				(cond
					((> local2 1)
						(SetFlag 101)
						(self setScript: officerComingOut)
					)
					(local2
						(++ local2)
						(host setScript: doCloseUp 0 34109)
					)
					(else
						(++ local2)
						(host setScript: doCloseUp 0 34109)
					)
				)
			)
			(43
				(if (>= (++ local3) 2)
					(self setScript: gettingTiredOfThis)
				else
					(host setScript: doCloseUp 0 34110)
				)
			)
			(49
				(if (>= (++ local1) 2)
					(SetFlag 101)
					(self setScript: officerComingOut)
				else
					(host setScript: doCloseUp 0 34107)
				)
			)
			(46
				(host setScript: doCloseUp 0 34109)
			)
			(48
				(host setScript: doCloseUp 0 34110)
			)
			(47
				(host setScript: doCloseUp 0 34110)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(proc4_5)
		(super dispose:)
	)
)

(instance wixellNotPresent of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOn:)
				(proc4_6 34102 0 86 0 0 -1 1)
				(global112 leftEarly: 1)
			)
			(1
				(gSwatInterface showHandAni: 4)
			)
			(2
				(gFxSound number: 1004 setLoop: 1 play:)
			)
			(3
				(gFxSound number: 1002 setLoop: 1 play:)
				(Palette 2 42 254 500) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(4
				(Palette 2 42 254 250) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(5
				(Palette 2 42 254 150) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(6
				(Palette 2 42 254 100) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(7
				(proc4_6 34112 0 86 0 0 -1 1)
			)
			(8
				(global112 leftEarly: 0)
			)
			(9
				(gGame handsOff:)
				(proc4_6 34122 0 86 0 0 -1 1)
				(gFxSound number: 2993 loop: 1 play:)
			)
			(10
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(SetFlag 97)
				(SetFlag 95)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance wixellPresent of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOn:)
				(proc4_6 34103 0 86 0 0 -1 1)
				(global112 leftEarly: 1)
			)
			(1
				(gSwatInterface showHandAni: 4)
			)
			(2
				(gFxSound number: 1004 setLoop: 1 play:)
			)
			(3
				(gFxSound number: 1002 setLoop: 1 play:)
				(Palette 2 42 254 500) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(4
				(Palette 2 42 254 250) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(5
				(Palette 2 42 254 150) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(6
				(Palette 2 42 254 100) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(7
				(proc4_6 34113 0 86 0 0 -1 1)
			)
			(8
				(global112 leftEarly: 0)
			)
			(9
				(gGame handsOff:)
				(proc4_6 34123 0 86 0 0 -1 1)
				(gFxSound number: 2993 loop: 1 play:)
			)
			(10
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(SetFlag 97)
				(SetFlag 95)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance leftEarlyScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 4054 0) changeMusic: 29809) ; kiplandRegion
				(deadMartinez setPri: 1 init:)
				(= cycles 2)
			)
			(1
				(gBackMusic2 number: 29808 loop: 1 play:)
				(allenShootsYou setPri: 260 init: setCycle: CT 15 1 self)
			)
			(2
				(gFxSound number: 34100 setLoop: 1 play:)
				(allenShootsYou setCycle: End self)
			)
			(3
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance charAndDentPresent of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gBackMusic2 number: 29808 loop: 1 play:)
				(proc4_6 34101 353 85 0 0 400 1)
			)
			(1
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(proc4_5)
				(gFxSound number: 2992 loop: 1 play: self)
			)
			(2
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(SetFlag 98)
				(SetFlag 94)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance throwFlashBang of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if gAutoRobot
					(gAutoRobot caller: 0)
				)
				(flashBang setPri: 400 init: setCycle: End self)
				(gFxSound number: 1003 setLoop: 1 play:)
			)
			(1
				(whiteScreen init:)
				(gFxSound number: 1002 setLoop: 1 play:)
				(Palette 2 42 254 500) ; PalIntensity
				(FrameOut)
				(proc4_5)
				(pacCorners setPri: 390 init:)
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
				(pacCorners setCycle: End self)
			)
			(5
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gFxSound number: 2993 loop: 1 play: self)
			)
			(6
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(SetFlag 98)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance holdFire of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc4_5)
				(gGame handsOff: showCloseUp: 34106 180 70 self)
				(pacCorners setPri: 390 init:)
			)
			(1
				(pacCorners setCycle: End self)
			)
			(2
				(gFxSound number: 2993 loop: 1 play: self)
			)
			(3
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(SetFlag 98)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance doCloseUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame
					handsOff:
					saveRobot: 1
					showCloseUp: register 180 70 self
				)
			)
			(1
				(gGame saveRobot: 0 handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance gettingTiredOfThis of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc4_5)
				(gGame handsOff: showCloseUp: 34111 180 70 self)
			)
			(1
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(SetFlag 98)
				(gCurRoom newRoom: 3010) ; s2_3010
			)
		)
	)
)

(instance officerComingOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc4_5)
				(gGame handsOff: showCloseUp: 34108 180 70 self 1)
			)
			(1
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(SetFlag 98)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance officerShot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 4054 0) changeMusic: 0) ; kiplandRegion
				(gBackMusic number: 0 stop:)
				(proc4_5)
				(gGame handsOff: showCloseUp: 9012 180 70 self 1)
			)
			(1
				(gBackMusic2 number: 29808 loop: 1 play: self)
				(gMessager say: 1 10 0 1) ; "Cease fire! Cease fire!"
			)
			(2
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(SetFlag 98)
				(SetFlag 94)
				(SetFlag 100)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance northE of HotSpot
	(properties
		type 4097
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 276 -1 442 -1 443 66 276 67
					yourself:
				)
		)
	)

	(method (doVerb)
		(gCurRoom newRoom: 3430) ; s2_3430
	)
)

(instance eastE of HotSpot
	(properties
		type 8193
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 359 67 490 66 490 303 362 323
					yourself:
				)
		)
	)

	(method (doVerb)
		(gCurRoom newRoom: 3430) ; s2_3430
	)
)

(instance westE of HotSpot
	(properties
		type 32771
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 240 68 360 68 365 332 240 344
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(29
				(gCurRoom newRoom: 3460) ; s2_3460
			)
			(55
				(gCurRoom newRoom: 3450) ; s2_3450
			)
		)
	)
)

(instance robotFeature of RobotDoVerb
	(properties)

	(method (onMe param1 &tmp temp0)
		(if
			(and
				(= temp0 (super onMe: param1 &rest))
				(OneOf (gAutoRobot robot:) 34102 34103)
				(> (param1 x:) 235)
				(< (param1 x:) 475)
			)
			(= temp0 0)
		)
		(return temp0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6
				(gCurRoom setScript: officerShot)
			)
			(10
				(gCurRoom setScript: officerShot)
			)
			(180
				(super doVerb: theVerb)
			)
			(179
				(super doVerb: theVerb)
			)
			(else
				(gCurRoom doVerb: theVerb)
			)
		)
	)
)

(instance pacCorners of Prop
	(properties
		x -2
		y 300
		view 34104
	)
)

(instance allenShootsYou of Prop
	(properties
		x 240
		y 180
		view 34100
	)
)

(instance flashBang of Prop
	(properties
		x 218
		y 258
		view 34105
	)
)

(instance host of Prop
	(properties
		y 2000
		view 56
	)
)

(instance deadMartinez of View
	(properties
		x 373
		y 273
		view 34103
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

