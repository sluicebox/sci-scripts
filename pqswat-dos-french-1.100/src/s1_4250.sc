;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4250)
(include sci.sh)
(use Main)
(use PQRoom)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	s1_4250 0
)

(local
	local0 = 100
)

(instance s1_4250 of PQRoom
	(properties
		picture 4250
	)

	(method (init)
		(super init: &rest)
		(showerCurtain init:)
		(if (== gPrevRoomNum 4210) ; s1_4210
			(Load rsVIEW 42501)
			(Load rsAUDIO 42501)
			(self setScript: yourDead)
		else
			(self setScript: rescueLucy)
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
)

(instance rescueLucy of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(Load rsMESSAGE 4250)
				(Load rsVIEW 42500)
				(Load rsAUDIO 40108 6006)
				(= seconds 1)
			)
			(1
				(Lock rsAUDIO 40106 0)
				(gGame handsOn:)
				(gBackMusic number: 40108 loop: -1 play:)
				(UnLoad 141 40106)
				(gMessager say: 0 0 1 1) ; "Lucy, we're the police. Keep your hands where we can see them. We're here to help you. We want you to come out. No one's going to hurt you."
				(= seconds 3)
			)
			(2
				(lucyUnArmed init: setCycle: End self)
			)
			(3
				(gGame handsOff:)
				(gMessager say: 0 0 1 2) ; "Pacmeyer to Ten David - Suspect in control. Officers coming out."
				(showerCurtain dispose:)
				(gBackMusic stop:)
				(Lock rsAUDIO 6006 1)
				(gBackMusic number: 6006 loop: -1 play:)
				(= cycles 1)
			)
			(4
				(if (> local0 0)
					(Palette 2 42 254 local0) ; PalIntensity
					(FrameOut)
					(-= local0 2)
					(-- state)
				)
				(= cycles 1)
			)
			(5
				(gEgo awardMedal: 32)
				(gEgo awardMedal: 4)
				(SetFlag 88)
				(gCurRoom newRoom: 4050) ; s1_4050
			)
		)
	)
)

(instance yourDead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(shootingLucy setPri: 1 init: setCycle: CT 5 1 self)
			)
			(2
				(shootingLucy setCycle: End self)
				(gFxSound number: 42501 setLoop: 1 play:)
			)
			(3
				(gBackMusic number: 40109 loop: 1 play: self)
			)
			(4
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance shotFeatures of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 0 8 2 1 self) ; "Cease fire!"
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
				(flashBang init: setCycle: End self)
			)
			(1
				(gFxSound number: 1002 setLoop: 1 play:)
				(Palette 2 42 254 500) ; PalIntensity
				(FrameOut)
				(flashBang dispose:)
				(gCast eachElementDo: #dispose)
				(deadLucy init:)
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
				(Lock rsAUDIO 40106 0)
				(gBackMusic number: 40109 loop: 1 play: self)
				(UnLoad 141 40106)
				(gMessager say: 0 16 0 0 self) ; "Pacmeyer to Ten David - Suspect down! EMT needed now!!"
			)
			(6
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

(instance shootShotGunCurt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(lucyUnArmed dispose:)
				(shotGunCurt setPri: 500 init: setCycle: End self)
			)
			(1
				(Lock rsAUDIO 40106 0)
				(gBackMusic number: 40109 loop: 1 play:)
				(UnLoad 141 40106)
				(gMessager say: 0 8 2 0 self) ; "Cease fire!"
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
				(lucyUnArmed dispose:)
				(colt45Curt setPri: 500 init: setCycle: End self)
			)
			(1
				(Lock rsAUDIO 40106 0)
				(gBackMusic number: 40109 loop: 1 play:)
				(UnLoad 141 40106)
				(gMessager say: 0 8 2 0 self) ; "Cease fire!"
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

(instance shootLucy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(= cycles 2)
			)
			(1
				(Lock rsAUDIO 40106 0)
				(gBackMusic number: 40109 loop: 1 play:)
				(UnLoad 141 40106)
				(gMessager say: 0 8 2 0 self) ; "Cease fire!"
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

(instance deadLucy of View
	(properties
		x 255
		y 143
		view 42502
	)
)

(instance lucyUnArmed of Prop
	(properties
		x 268
		y 100
		view 42500
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8
				(gCurRoom setScript: shootLucy)
			)
			(6
				(gCurRoom setScript: shootLucy)
			)
			(else
				(gCurRoom doVerb: theVerb)
			)
		)
	)
)

(instance shotGunCurt of Prop
	(properties
		x 213
		y 245
		view 42502
		loop 1
	)
)

(instance colt45Curt of Prop
	(properties
		x 213
		y 245
		view 42502
		loop 2
	)
)

(instance shootingLucy of Prop
	(properties
		x 240
		y 346
		view 42501
	)
)

(instance flashBang of Prop
	(properties
		x 270
		y 270
		view 42503
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
					init: 140 126 269 122 269 275 141 270
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

