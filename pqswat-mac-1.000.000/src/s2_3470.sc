;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3470)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use RobotDoVerb)
(use WalkieTalkie)
(use Motion)
(use Actor)
(use System)

(public
	s2_3470 0
)

(instance s2_3470 of PQRoom
	(properties
		picture 3470
	)

	(method (init)
		(super init: &rest)
		((ScriptID 4054 0) changeMusic: 29809) ; kiplandRegion
		(SetFlag 126)
		(gBackMusic2 number: 29810 loop: 1 play:)
		(allen init:)
		(hector cycleSpeed: 10 setCycle: Fwd init:)
		(robotFeat init:)
		(gCurRoom setScript: sStartRoom)
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10
				(SetFlag 241)
			)
			(6
				(SetFlag 241)
			)
			(16
				(self setScript: sFlashRoom)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(ClearFlag 241)
		(proc4_5)
		(super dispose:)
	)
)

(instance sStartRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(allen cel: 20 setCycle: CT 127 1)
				(WalkieTalkie showFrame: 34700 0 -1 -6)
				(= global128 34700)
				(= cycles 2)
			)
			(1
				(proc4_5)
				(proc4_6 34700 -1 -6 0 0 -1 1)
			)
			(2
				(if (allen cycler:)
					(-- state)
				)
				(= cycles 3)
			)
			(3
				(allen cel: 128 setCycle: End self)
			)
			(4
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(= seconds 1)
			)
			(5
				(SetFlag 97)
				(SetFlag 95)
				(gEgo awardMedal: 33)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance sFlashRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 6)
				(cannister
					view: 34702
					loop: 0
					cel: 0
					posn: 76 194
					setPri: 200
					init:
					setCycle: End self
				)
			)
			(1
				(gFxSound number: 1002 loop: 1 play:)
				(cannister
					view: 6
					loop: 0
					cel: 0
					posn: 289 179
					setPri: 600
					init:
				)
				(allen view: 34713 loop: 0 cel: 0 setCycle: 0 posn: 168 236)
				(UpdateScreenItem allen)
				(= cycles 2)
			)
			(2
				(Palette 2 42 254 500) ; PalIntensity
				(FrameOut)
				(cannister dispose:)
				(proc4_6 34703 -2 110 0 0 -1 1)
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
				(allen setCycle: End)
				(= cycles 1)
			)
			(5
				(Palette 2 42 254 100) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(6
				(if (allen cycler:)
					(-- state)
				else
					((ScriptID 4054 0) changeMusic: 6006) ; kiplandRegion
				)
				(= cycles 2)
			)
			(7
				(gMessager say: 0 16 0 3 self) ; "Denton to Twenty David - Suspect in control."
			)
			(8
				(= cycles 2)
			)
			(9
				(SetFlag 98)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance sAllenGetsShot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc4_5)
				(gGame showCloseUp: 34701 -1 -1 self 1)
			)
			(1
				((ScriptID 4054 0) changeMusic: 0) ; kiplandRegion
				(gBackMusic number: 29808 loop: 1 play:)
				(gFxSound number: 3450 loop: 1 play: self)
			)
			(2
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(= seconds 1)
			)
			(3
				(gFxSound client: 0)
				(SetFlag 98)
				(SetFlag 95)
				(gEgo awardMedal: 33)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance hectorGetsShot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gFxSound number: 3470 loop: 1 play: self)
			)
			(1
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(= seconds 1)
			)
			(2
				(SetFlag 98)
				(SetFlag 93)
				(SetFlag 100)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance sOfficerShot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame showCloseUp: 9012 -1 -1 self 1)
			)
			(1
				(gMessager say: 2 10 0 0 self) ; "Cease fire! Cease fire!"
			)
			(2
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(= seconds 1)
			)
			(3
				(SetFlag 100)
				(SetFlag 98)
				(SetFlag 94)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance allen of Prop
	(properties
		x 71
		y 226
		view 34710
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10
				(gCurRoom setScript: sAllenGetsShot)
			)
			(6
				(gCurRoom setScript: sAllenGetsShot)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hector of Prop
	(properties
		x 68
		y 238
		view 34720
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10
				(gCurRoom setScript: hectorGetsShot)
			)
			(6
				(gCurRoom setScript: hectorGetsShot)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance robotFeat of RobotDoVerb
	(properties)

	(method (onMe param1 &tmp temp0)
		(if
			(and
				(= temp0 (super onMe: param1))
				(or (allen onMe: param1) (hector onMe: param1))
			)
			(= temp0 0)
		)
		(return temp0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6
				(gCurRoom setScript: sOfficerShot)
			)
			(10
				(gCurRoom setScript: sOfficerShot)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cannister of Prop
	(properties)
)

