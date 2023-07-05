;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4230)
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
	s1_4230 0
)

(instance s1_4230 of PQRoom
	(properties
		picture 4230
	)

	(method (init)
		(super init: &rest)
		(Load rsAUDIO 42303)
		(Load rsVIEW 42300)
		(Load rsVIEW 42302)
		(northE init:)
		(eastE init:)
		(westE init:)
		(showerCurtain init:)
		(self setScript: mirrorShadow)
	)

	(method (lashNotify)
		(if (and (proc4_11 21) (== global149 1))
			(self setScript: lashedSuspect)
			(return -2)
		else
			(return -1)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8
				(self setScript: shotFeatures)
			)
			(6
				(self setScript: shotFeatures)
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
		(gBackMusic stop:)
		(gBackMusic2 stop:)
		(super dispose: &rest)
	)
)

(instance lashedSuspect of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(if (gTalkers size:)
					(-- state)
				)
				(= cycles 1)
			)
			(2
				(global112 suspectSpotted: 4250)
				(gCurRoom newRoom: 4250) ; s1_4250
			)
		)
	)
)

(instance mirrorShadow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsAUDIO 40108 40107)
				(= seconds 2)
			)
			(1
				(lucyReflection setPri: 1 init: setCycle: End self)
				(Lock rsAUDIO 40106 0)
				(gBackMusic number: 40108 loop: -1 play:)
				(gBackMusic2 number: 40107 loop: 1 play:)
				(UnLoad 141 40106)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance shotFeatures of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 0 8 0 1 self) ; "Cease fire!"
				(ClearFlag 12)
				(gSwatInterface closeInvWindow:)
			)
			(1
				(gGame handsOff: showCloseUp: 41002 180 70 self)
			)
			(2
				(Lock rsAUDIO 40106 0)
				(Lock rsAUDIO 6007 1)
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
				(flashBang setPri: 500 init: setCycle: CT 7 1 self)
			)
			(1
				(flashBang setPri: 1 setCycle: End self)
			)
			(2
				(gFxSound number: 1002 setLoop: 1 play:)
				(Palette 2 42 254 500) ; PalIntensity
				(FrameOut)
				(flashBang dispose:)
				(deadLucy init:)
				(= cycles 1)
			)
			(3
				(Palette 2 42 254 250) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(4
				(Palette 2 42 254 150) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(5
				(Palette 2 42 254 100) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(6
				(Lock rsAUDIO 40106 0)
				(gBackMusic number: 40109 loop: 1 play: self)
				(UnLoad 141 40106)
				(gMessager say: 0 16 0 0 self) ; "Compromised!!!"
			)
			(7
				(Lock rsAUDIO 6007 1)
				(gBackMusic number: 6007 loop: 1 play:)
				(SetFlag 98)
				(SetFlag 95)
				(SetFlag 103)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance lucyShoots of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(shootingLucy setPri: 1 init: setCycle: End self)
				(Lock rsAUDIO 40106 0)
				(gBackMusic number: 40108 loop: -1 play:)
				(UnLoad 141 40106)
				(gFxSound number: 42303 setLoop: 1 play:)
			)
			(1
				(gBackMusic loop: 1 stop:)
				(gBackMusic number: 40109 loop: 1 play: self)
				(UnLoad 141 40106)
			)
			(2
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
				(shotGunCurt setPri: 500 init:)
				(shotGunCurt2 setPri: 500 init:)
				(= cycles 2)
			)
			(1
				(Lock rsAUDIO 40106 0)
				(gBackMusic number: 40109 loop: 1 play:)
				(UnLoad 141 40106)
				(gMessager say: 0 8 2 0 self) ; "Cease fire!"
			)
			(2
				(Lock rsAUDIO 6007 1)
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
				(colt45Curt setPri: 500 init:)
				(colt45Curt2 setPri: 500 init:)
				(= cycles 2)
			)
			(1
				(Lock rsAUDIO 40106 0)
				(gBackMusic number: 40109 loop: 1 play:)
				(UnLoad 141 40106)
				(gMessager say: 0 8 2 0 self) ; "Cease fire!"
			)
			(2
				(Lock rsAUDIO 6007 1)
				(gBackMusic number: 6007 loop: 1 play:)
				(SetFlag 98)
				(SetFlag 95)
				(SetFlag 100)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance lucyReflection of Prop
	(properties
		x 540
		y 219
		view 42300
	)
)

(instance shootingLucy of Prop
	(properties
		x 199
		y 324
		view 42303
	)
)

(instance flashBang of Prop
	(properties
		x 250
		y 140
		view 42301
	)
)

(instance shotGunCurt of View
	(properties
		view 42302
		loop 1
	)
)

(instance shotGunCurt2 of View
	(properties
		view 42302
		loop 1
		cel 1
	)
)

(instance colt45Curt of View
	(properties
		x -123
		y -152
		view 42302
		loop 2
	)
)

(instance colt45Curt2 of View
	(properties
		x -123
		y -152
		view 42302
		loop 2
		cel 1
	)
)

(instance deadLucy of View
	(properties
		x 205
		y 135
		view 42302
	)
)

(instance northE of HotSpot
	(properties
		nsRight 640
		nsBottom 50
		type 4097
	)

	(method (doVerb)
		(gCurRoom setScript: lucyShoots)
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
		(gCurRoom setScript: lucyShoots)
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
			(global112 slicePie: 4220)
		)
		(gCurRoom newRoom: 4220) ; s1_4220
	)
)

(instance showerCurtain of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 19 1 230 0 235 314 94 326 65 318 40 206
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(48
				(global112 suspectSpotted: 4250)
				(gCurRoom newRoom: 4250) ; s1_4250
			)
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

