;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3350)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use HotSpot)
(use Motion)
(use Actor)
(use System)

(public
	s2_3350 0
)

(local
	local0
)

(instance s2_3350 of PQRoom
	(properties
		picture 3350
	)

	(method (init)
		(super init: &rest)
		(northE init:)
		(cond
			((global112 leftEarly:)
				(if (IsFlag 254)
					(self setScript: randomEvent)
				else
					(self setScript: allenInPit)
				)
			)
			((global112 flashBanged:)
				(global112 resetData: 0)
				(gCurRoom setScript: martinezIsDead)
			)
			(else
				(gCurRoom setScript: randomEvent)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10
				(if (>= (++ local0) 2)
					(gCurRoom setScript: shootGun 0 theVerb)
				)
			)
			(6
				(gCurRoom setScript: shootGun 0 theVerb)
			)
			(16
				(gCurRoom setScript: throwFlash)
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

(instance randomEvent of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 4054 0) changeMusic: 29809) ; kiplandRegion
				(= cycles 2)
			)
			(1
				(gFxSound number: 2992 loop: 1 play: self)
			)
			(2
				(switch (Random 0 1)
					(0
						(gGame handsOn:)
						(= seconds 10)
					)
					(1
						(gCurRoom newRoom: 72) ; funeralRoom
					)
				)
			)
			(3
				(gGame handsOff:)
				(gFxSound number: 2992 loop: 1 play: self)
			)
			(4
				(gCurRoom newRoom: 72) ; funeralRoom
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
				(gMessager say: 1 register 0 0 self)
			)
			(1
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(SetFlag 98)
				(gCurRoom newRoom: 3010) ; s2_3010
			)
		)
	)
)

(instance throwFlash of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(flashBang init: setCycle: End self)
				(gFxSound number: 1003 setLoop: 1 play:)
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
				(gMessager say: 1 16 0 0 self) ; "Compromised!! Officer coming out!"
				(proc4_6 33504 -67 -116 0 0 1 1)
			)
			(6
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(SetFlag 98)
				(gCurRoom newRoom: 3010) ; s2_3010
			)
		)
	)
)

(instance martinezIsDead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc4_6 33500 -43 -108 0 0 1 1)
			)
			(1
				(gFxSound number: 2993 loop: 1 play: self)
			)
			(2
				(gCurRoom newRoom: 3360) ; s2_3360
			)
		)
	)
)

(instance allenInPit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 4054 0) changeMusic: 29809) ; kiplandRegion
				(proc4_6 33502 91 30 0 0 1 1)
				(gBackMusic2 number: 29808 loop: 1 play:)
			)
			(1
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance northE of HotSpot
	(properties
		nsRight 320
		nsBottom 100
		type 4097
	)

	(method (doVerb)
		(gCurRoom newRoom: 3360) ; s2_3360
	)
)

(instance flashBang of Prop
	(properties
		x 134
		y 283
		view 33503
	)
)

