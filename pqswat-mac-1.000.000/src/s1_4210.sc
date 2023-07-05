;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4210)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use HotSpot)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	s1_4210 0
)

(instance s1_4210 of PQRoom
	(properties
		picture 4210
	)

	(method (init)
		(super init: &rest)
		(Load rsVIEW 42104)
		(Load rsVIEW 42108)
		(northE init:)
		(eastE init:)
		(southE init:)
		(westE init:)
		(curtain init:)
		(cond
			((and (IsFlag 155) (== gPrevRoomNum 4170)) ; s1_4170
				(self setScript: deadOutsideTub)
			)
			((and (IsFlag 155) (== gPrevRoomNum 4200)) ; s1_4200
				(self setScript: deadInsideTub)
			)
			((and (global112 slicedPie:) (== gPrevRoomNum 4200)) ; s1_4200
				(Load rsVIEW 42107)
				(self setScript: yourDead)
			)
			((== gPrevRoomNum 4240) ; s1_4240
				(Load rsVIEW 42107)
				(self setScript: yourDead)
			)
			((global112 flashBanged:)
				(self setScript: deadHeartAttack)
			)
			(else
				(gGame handsOn:)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8
				(self setScript: shootGun)
			)
			(6
				(self setScript: shootGun)
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

(instance deadOutsideTub of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(lucySlumpOutside setPri: 500 init:)
				(= cycles 2)
			)
			(1
				(Lock rsAUDIO 40105 0)
				(gBackMusic number: 40109 loop: 1 play: self)
				(UnLoad 141 40105)
			)
			(2
				(gBackMusic number: 6007 loop: 1 play:)
				(SetFlag 98)
				(SetFlag 95)
				(SetFlag 100)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance deadInsideTub of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(lucySlumpInside setPri: 1 init:)
				(= cycles 2)
			)
			(1
				(Lock rsAUDIO 40106 0)
				(gBackMusic number: 40109 loop: 1 play: self)
				(UnLoad 141 40106)
			)
			(2
				(gBackMusic number: 6007 loop: 1 play:)
				(SetFlag 98)
				(SetFlag 95)
				(SetFlag 100)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance deadHeartAttack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(lucySlumpForward setPri: 500 init:)
				(= cycles 2)
			)
			(1
				(Lock rsAUDIO 40106 0)
				(gBackMusic number: 40109 loop: 1 play: self)
				(UnLoad 141 40106)
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

(instance yourDead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc4_6 42105 40 15 0 0 -1 1)
			)
			(1
				(gAutoRobot caller: 0)
				(lucysArm init: setCycle: End self)
			)
			(2
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(= cycles 2)
			)
			(3
				(Lock rsAUDIO 40106 0)
				(gFxSound number: 35 setLoop: 1 play:)
				(= seconds 3)
			)
			(4
				(gBackMusic number: 40109 loop: 1 play: self)
			)
			(5
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance shootShotGunCurt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(shotGunCurt setPri: 500 init: setCycle: End self)
			)
			(1
				(gMessager say: 0 8 4 0 self) ; "Cease fire!"
				(Lock rsAUDIO 40106 0)
				(gBackMusic number: 40109 loop: 1 play:)
				(UnLoad 141 40106)
			)
			(2
				(gBackMusic number: 6007 loop: 1 play:)
				(SetFlag 98)
				(SetFlag 95)
				(SetFlag 100)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance shootColt45Curt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(colt45Curt setPri: 500 init: setCycle: End self)
			)
			(1
				(gMessager say: 0 8 4 0 self) ; "Cease fire!"
				(Lock rsAUDIO 40106 0)
				(gBackMusic number: 40109 loop: 1 play:)
				(UnLoad 141 40106)
			)
			(2
				(gBackMusic number: 6007 loop: 1 play:)
				(SetFlag 98)
				(SetFlag 95)
				(SetFlag 100)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance shootGun of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gMessager say: 0 8 0 1 self) ; "Cease fire!"
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
			)
			(2
				(gGame handsOff: showCloseUp: 41002 180 70 self)
			)
			(3
				(Lock rsAUDIO 40106 0)
				(gBackMusic number: 6007 loop: 1 play:)
				(UnLoad 141 40106)
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
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(lucySlumpRightWall setPri: 1 init:)
				(= cycles 2)
			)
			(6
				(Palette 2 42 254 100) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(7
				(Lock rsAUDIO 40106 0)
				(gBackMusic number: 40109 loop: 1 play:)
				(UnLoad 141 40106)
				(gMessager say: 0 16 0 0 self) ; "Compromised!!!"
			)
			(8
				(gBackMusic number: 6007 loop: 1 play:)
				(SetFlag 98)
				(SetFlag 95)
				(SetFlag 103)
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

(instance showLucyInMirror of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(lucyReflection init: setCycle: End self)
				(Lock rsAUDIO 40106 0)
				(gBackMusic2 number: 40107 loop: 1 play:)
				(gBackMusic number: 40108 loop: -1 play:)
				(UnLoad 141 40106)
			)
			(2
				(gBackMusic stop:)
				(gCurRoom newRoom: 4250) ; s1_4250
			)
		)
	)
)

(instance lucysArm of Prop
	(properties
		x 64
		y 87
		view 42107
	)
)

(instance lucyReflection of Prop
	(properties
		x 632
		y 231
		view 42110
	)
)

(instance shotGunCurt of Prop
	(properties
		x 188
		y 14
		view 42108
	)
)

(instance colt45Curt of Prop
	(properties
		x 188
		y 14
		view 42108
		loop 1
	)
)

(instance flashBang of Prop
	(properties
		x 414
		y 337
		view 42109
		loop 1
	)
)

(instance lucySlumpOutside of View
	(properties
		x 311
		y 237
		view 42100
	)
)

(instance lucySlumpInside of View
	(properties
		x 307
		y 368
		view 42101
	)
)

(instance lucySlumpForward of View
	(properties
		x 311
		y 253
		view 42102
	)
)

(instance lucySlumpRightWall of View
	(properties
		x 261
		y 183
		view 42104
	)
)

(instance curtain of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 197 91 334 91 334 252 189 255
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8
				(gCurRoom setScript: shootShotGunCurt)
			)
			(6
				(gCurRoom setScript: shootColt45Curt)
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
		(gCurRoom setScript: showLucyInMirror)
	)
)

(instance eastE of HotSpot
	(properties
		nsLeft 590
		nsRight 640
		nsBottom 360
		type 8195
	)

	(method (doVerb)
		(gCurRoom newRoom: 4240) ; s1_4240
	)
)

(instance westE of HotSpot
	(properties
		nsRight 130
		nsBottom 360
		type 32771
	)

	(method (doVerb theVerb)
		(if (== theVerb 55)
			(global112 slicePie: 4220)
		)
		(gCurRoom newRoom: 4220) ; s1_4220
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

