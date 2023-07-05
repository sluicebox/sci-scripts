;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3230)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use HotSpot)
(use RobotDoVerb)
(use Polygon)
(use WalkieTalkie)
(use Motion)
(use Actor)
(use System)

(public
	s2_3230 0
)

(local
	local0
	local1 = 1
	local2
)

(instance s2_3230 of PQRoom
	(properties
		picture 3230
	)

	(method (init)
		(super init: &rest)
		(Load rsAUDIO 29810)
		((ScriptID 4054 0) changeMusic: 29805) ; kiplandRegion
		(northE init:)
		(westE init:)
		(robotFeat init:)
		(cond
			((and (global112 slicedPie:) (not (IsFlag 249)))
				(self setScript: allenPanicsKillsEgo)
			)
			((and (IsFlag 249) (OneOf gPrevRoomNum 3150 3110 3220)) ; s2_3150, s2_3110, s2_3220
				(while (< (global112 curColIdx:) 15)
					(global112 endColumn:)
				)
				(gGame handsOn:)
				(stairwellExit init:)
				(self setScript: sSetupAroundStairs)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10
				(if local1
					(= local1 0)
					(gMessager say: 1 10 4) ; "Hold your fire!!!"
				else
					(self setScript: sSecondShot)
				)
			)
			(6
				(if local1
					(= local1 0)
					(gMessager say: 1 theVerb 4) ; "Hold your fire!!!"
				else
					(self setScript: sSecondShot)
				)
			)
			(16
				(self setScript: sThrowFlashBang)
			)
			(else
				(if
					(and
						(gCast contains: pacmeyer)
						(OneOf theVerb 43 47 44 45 46 42 49 48)
					)
					(gMessager say: 0 theVerb 7)
				else
					(super doVerb: theVerb)
				)
			)
		)
	)

	(method (dispose)
		(proc4_5)
		(super dispose: &rest)
	)
)

(instance sSecondShot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 1 10 5 0 self) ; "Hold your fire!! Officer coming out!"
			)
			(1
				(SetFlag 98)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance sThrowFlashBang of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(cannister
					view: 32304
					loop: 0
					cel: 0
					posn: 112 239
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
				(proc4_5)
				(if (gCast contains: pacmeyer)
					(pacmeyer dispose:)
					(WalkieTalkie showFrame: 32302 0 303 121)
					(= global128 32302)
				else
					(WalkieTalkie showFrame: 32303 0 251 124)
					(= global128 32303)
				)
				(= cycles 2)
			)
			(2
				(Palette 2 42 254 500) ; PalIntensity
				(FrameOut)
				(cannister dispose:)
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
				(= register global128)
				(proc4_5)
				(switch register
					(32302
						(proc4_6 32302 303 121 0 0 -1 1)
					)
					(32303
						(proc4_6 32303 251 124 0 0 -1 1)
					)
					(else
						(self dispose:)
					)
				)
			)
			(6
				(switch register
					(32302
						(= cycles 1)
					)
					(32303
						(Palette 2 42 254 0) ; PalIntensity
						(FrameOut)
						(gFxSound number: 2993 loop: 1 play: self)
					)
				)
			)
			(7
				(SetFlag 98)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance sSetupAroundStairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsAUDIO 1002)
				(Load rsVIEW 32301)
				(Load rsVIEW 32311)
				(Load rsVIEW 32325)
				(Load rsVIEW 6)
				(proc4_6 32301 410 99 0 0 300 1)
			)
			(1
				(denton
					view: 32301
					loop: 0
					cel: 0
					posn: 416 123
					setPri: 300
					init:
				)
				(proc4_5)
				(= seconds 4)
			)
			(2
				(pacmeyer
					view: 32311
					loop: 0
					cel: 0
					posn: -1 171
					init:
					setCycle: CT 32 1 self
				)
			)
			(3
				(gSwatInterface showHandAni: 4)
				(pacmeyer setCycle: CT 59 1 self)
			)
			(4
				(gSwatInterface showHandAni: 3)
				(pacmeyer setCycle: CT 174 1 self)
			)
			(5
				(gSwatInterface showHandAni: 6)
				(pacmeyer setCycle: End self)
			)
			(6
				(denton dispose:)
				(pacmeyer dispose:)
				(gGame showCloseUp: 32331 -1 -1 self 1)
			)
			(7
				(gCurRoom setScript: readyToFlash)
			)
		)
	)
)

(instance readyToFlash of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(WalkieTalkie showFrame: 32321 0 235 120)
				(Palette 2 42 254 100) ; PalIntensity
				(FrameOut)
				(= seconds 5)
			)
			(1
				(gGame handsOff:)
				(proc4_5)
				(proc4_6 32321 235 120 0 0 -1 1)
			)
			(2
				(gSwatInterface showHandAni: 4)
			)
			(3
				(gFxSound number: 1002 loop: 1 play:)
				(cannister
					view: 6
					loop: 0
					cel: 0
					posn: 289 179
					setPri: 600
					init:
				)
				(proc4_5)
				(pacmeyer view: 32325 loop: 0 cel: 0 posn: 315 208 init:)
				(= cycles 2)
			)
			(4
				(Palette 2 42 254 500) ; PalIntensity
				(FrameOut)
				(cannister dispose:)
				(= cycles 1)
			)
			(5
				(Palette 2 42 254 250) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(6
				(Palette 2 42 254 150) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(7
				(Palette 2 42 254 100) ; PalIntensity
				(FrameOut)
				(gGame handsOn:)
				(= local0 1)
				(pacmeyer setPri: 10 setCycle: End self)
			)
			(8
				(gGame handsOff:)
				(= local0 0)
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gFxSound number: 2993 loop: 1 play: self)
			)
			(9
				(gFxSound client: 0)
				(SetFlag 97)
				(SetFlag 95)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance allenPanicsKillsEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 4054 0) changeMusic: 29809) ; kiplandRegion
				(gBackMusic2 number: 29810 loop: 1 play:)
				(proc4_6 32300 387 130 0 0 300 1)
			)
			(1
				((ScriptID 4054 0) changeMusic: 0) ; kiplandRegion
				(gBackMusic number: 29808 loop: 1 play: self)
			)
			(2
				(gCurRoom newRoom: 72) ; funeralRoom
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
				(gMessager say: 1 10 4 0 self) ; "Hold your fire!!!"
			)
			(2
				(SetFlag 100)
				(SetFlag 98)
				(SetFlag 94)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
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
		(gCurRoom newRoom: 3240) ; s2_3240
	)
)

(instance westE of HotSpot
	(properties
		nsRight 50
		nsBottom 360
		type 32769
	)

	(method (doVerb)
		(gCurRoom newRoom: 3140) ; s2_3140
	)
)

(instance stairwellExit of HotSpot
	(properties
		type 16385
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 469 151 567 147 569 187 559 194 469 191
					yourself:
				)
		)
	)

	(method (doVerb)
		(if local2
			(gCurRoom newRoom: 3300) ; s2_3300
		else
			(gCurRoom newRoom: 3320) ; s2_3320
		)
	)
)

(instance robotFeat of RobotDoVerb
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(10
				(gCurRoom setScript: sOfficerShot)
			)
			(6
				(gCurRoom setScript: sOfficerShot)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance denton of Prop
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(10
				(gCurRoom setScript: sOfficerShot)
			)
			(6
				(gCurRoom setScript: sOfficerShot)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pacmeyer of Prop
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(10
				(gCurRoom setScript: sOfficerShot)
			)
			(6
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

