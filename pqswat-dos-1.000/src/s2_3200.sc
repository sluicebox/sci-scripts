;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3200)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use HotSpot)
(use RobotDoVerb)
(use Polygon)
(use Feature)
(use WalkieTalkie)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	s2_3200 0
)

(local
	local0
	local1
	[local2 2]
)

(instance s2_3200 of PQRoom
	(properties
		picture 3200
	)

	(method (init)
		(super init: &rest)
		(robotFeat init:)
		(allen init:)
		(cond
			(
				(or
					(== gPrevRoomNum 3150) ; s2_3150
					(and (== gPrevRoomNum 3160) (not (IsFlag 220))) ; s2_3160
				)
				(while (< (global112 curColIdx:) 17)
					(global112 endColumn:)
				)
				(gCurRoom setScript: sConfrontAllen)
			)
			((== (global112 criticalRoom:) gCurRoomNum)
				(gGame handsOn:)
				(eastE init:)
				(gCurRoom setScript: sElementPassing)
			)
			(else
				(eastE init:)
				(gGame handsOn:)
			)
		)
	)

	(method (criticalAlert)
		(if (and (not (self script:)) (== (global112 curColIdx:) 17))
			(self setScript: sElementPassing)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(16
				(gCurRoom setScript: sFlashBang)
			)
			(43
				(if local0
					(gMessager say: 0 45 6) ; "What is it, pup?"
				else
					(gMessager say: 0 45 8) ; MISSING MESSAGE
				)
			)
			(else
				(if (OneOf theVerb 45 44 46 42 47 49)
					(if local0
						(gMessager say: 0 49 6) ; "What is it?"
					)
				else
					(super doVerb: theVerb)
				)
			)
		)
	)

	(method (dispose)
		(proc4_5)
		(super dispose:)
	)
)

(instance sElementPassing of Script
	(properties)

	(method (doit)
		(if (and gAutoRobot (== state 0))
			(cond
				((and (> (Robot 11) 86) (< (Robot 11) 133)) ; FrameNum, FrameNum
					(= local0 1)
				)
				((and (> (Robot 11) 146) (< (Robot 11) 152)) ; FrameNum, FrameNum
					(= local0 1)
				)
				(else
					(= local0 0)
				)
			)
		)
		(super doit: &rest)
	)

	(method (cue param1 &tmp temp0)
		(= temp0 0)
		(if argc
			(= temp0 param1)
			(if (== argc 1)
				(= scratch param1)
			)
		)
		(super cue: temp0 &rest)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if
					(!=
						(= temp0
							(switch (global112 curColIdx:)
								(17
									(= register 32051)
									(global112 getPercent: 0 100)
								)
								(18
									(= register 32051)
									(global112 getPercent: 101 191)
								)
								(19
									(= register 32052)
									(global112 getPercent: 69 115)
								)
								(20
									(= register 32052)
									(global112 getPercent: 116 291)
								)
								(21
									(= register 32052)
									292
								)
								(else -1)
							)
						)
						-1
					)
					(switch register
						(32051
							(proc4_6 32051 -1 149 temp0 0 -1 1)
						)
						(32052
							(proc4_6 32052 327 141 temp0 0 -1 1)
						)
					)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
			(1
				(-- state)
				(switch scratch
					(-1
						(++ state)
						(= cycles 2)
					)
					(1
						(gSwatInterface showHandAni: 6)
					)
					(2
						(proc4_5)
						(WalkieTalkie showFrame: 32051 191 -1 149)
						(= global128 32051)
						(++ scratch)
						(global112 pausePath: 1)
						(gGame showCloseUp: 32057 -1 -1 self 1)
					)
					(3
						(global112 pausePath: 0)
						(proc4_5)
						(proc4_6 32052 327 141 69)
						(Palette 2 42 254 100) ; PalIntensity
						(FrameOut)
					)
					(4
						(gSwatInterface showHandAni: 6)
					)
					(5
						(gSwatInterface showHandAni: 4)
					)
					(6
						(gSwatInterface showHandAni: 3)
					)
				)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sConfrontAllen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 3)
			)
			(1
				(gFxSound number: 2993 loop: 0 play: self)
			)
			(2
				(gCurRoom newRoom: 3170) ; s2_3170
			)
		)
	)
)

(instance sFlashBang of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(cannister init: setCycle: End self)
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
				(= cycles 2)
			)
			(2
				(Palette 2 42 254 500) ; PalIntensity
				(cannister dispose:)
				(FrameOut)
				(if (== (global112 criticalRoom:) gCurRoomNum)
					(proc4_5)
					(gCurRoom setScript: sNoAniFlashBang)
				else
					(= cycles 1)
				)
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
				(if (< (global112 curColIdx:) 17)
					(proc4_6 32055 -2 176 0 0 -1 1)
				else
					(proc4_6 32056 385 124 0 0 -1 1)
				)
			)
			(7
				(SetFlag 98)
				(gCurRoom newRoom: 3010) ; s2_3010
			)
		)
	)
)

(instance sNoAniFlashBang of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(gMessager say: 0 16 0 0 self) ; "Status! Status!"
			)
			(2
				(= cycles 2)
			)
			(3
				(SetFlag 98)
				(gCurRoom newRoom: 3010) ; s2_3010
			)
		)
	)
)

(instance sPacmeyerShot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame showCloseUp: 9018 -1 -1 self 1)
			)
			(1
				(gMessager say: 1 10 0 0 self) ; "Cease fire! Cease fire!"
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

(instance sCarmichaelShot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame showCloseUp: 9008 -1 -1 self 1)
			)
			(1
				(gMessager say: 1 6 0 0 self) ; "Cease fire! Cease fire!"
			)
			(2
				(= cycles 2)
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

(instance sDentonShot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame showCloseUp: 9012 -1 -1 self 1)
			)
			(1
				(gMessager say: 2 6 0 0 self) ; "Cease fire! Cease fire!"
			)
			(2
				(= cycles 2)
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

(instance sAllenShot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(SetFlag 95)
				(SetFlag 98)
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
				(if register
					(gGame showCloseUp: register -1 -1 self 1)
				else
					(gGame showCloseUp: 9012 -1 -1 self 1)
				)
			)
			(1
				(gMessager say: 1 10 0 0 self) ; "Cease fire! Cease fire!"
			)
			(2
				(= register 0)
				(SetFlag 100)
				(SetFlag 98)
				(SetFlag 94)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance sShotWood of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (> (global112 curColIdx:) 18)
					(if local1
						(gMessager say: 3 6 5 0 self) ; "Cease fire! Trailer! Officer coming out!"
					else
						(gMessager say: 3 6 4 0 self) ; "Hold your fire!!"
					)
				else
					(= temp0 -1)
					(if (or gAutoRobot (Robot 5)) ; HasEnded
						(= temp0 (Robot 11)) ; FrameNum
						(proc4_5)
						(WalkieTalkie showFrame: 32051 temp0 -1 149)
						(= global128 32051)
					)
					(gMessager say: 3 10 1 0 self) ; "Hold your fire!!"
				)
			)
			(1
				(cond
					((<= (global112 curColIdx:) 18)
						(eastE dispose:)
						(gCurRoom setScript: sAllenJumpsOut)
					)
					(local1
						(gCurRoom newRoom: 3010) ; s2_3010
					)
					(else
						(= local1 1)
						(gGame handsOn:)
						(self dispose:)
					)
				)
			)
		)
	)
)

(instance sAllenJumpsOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 4054 0) changeMusic: 29809) ; kiplandRegion
				(gBackMusic2 number: 29810 loop: 1 play:)
				(gFxSound number: 31502 loop: 1 play:)
				(allen setCycle: CT 11 1 self)
			)
			(1
				(gunShots number: 32053 loop: 1 play:)
				(allen setCycle: CT 16 1 self)
			)
			(2
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(allen dispose:)
				(proc4_5)
				(if (gunShots handle:)
					(gunShots client: self)
				else
					(= cycles 2)
				)
			)
			(3
				(gFxSound number: 2993 loop: 1 play: self)
			)
			(4
				(= cycles 2)
			)
			(5
				(SetFlag 100)
				(SetFlag 98)
				(SetFlag 95)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance sWindowBreaks of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (IsFlag 246)
					(gMessager say: 5 6 5 0 self) ; "Cease fire! Trailer! Officer coming out!"
				else
					(gFxSound number: 21003 loop: 0 play:)
					(gMessager say: 5 6 4 0 self) ; "Hold your fire!!"
				)
			)
			(1
				(if (not (SetFlag 246))
					(SetFlag 98)
					(gCurRoom newRoom: 3010) ; s2_3010
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance eastE of HotSpot
	(properties
		nsLeft 600
		nsRight 640
		nsBottom 360
		type 8193
	)

	(method (doVerb)
		(gCurRoom newRoom: 3140) ; s2_3140
	)
)

(instance cannister of Prop
	(properties
		x 280
		y 348
		view 32054
	)
)

(instance pacmeyer of Prop ; UNUSED
	(properties
		x 20
		y 100
		view 911
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10
				(gCurRoom setScript: sPacmeyerShot)
			)
			(6
				(gCurRoom setScript: sPacmeyerShot)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance carmichael of Prop ; UNUSED
	(properties
		x 100
		y 100
		view 911
		cel 5
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10
				(gCurRoom setScript: sCarmichaelShot)
			)
			(6
				(gCurRoom setScript: sCarmichaelShot)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance denton of Prop ; UNUSED
	(properties
		x 180
		y 80
		view 911
		cel 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10
				(gCurRoom setScript: sDentonShot)
			)
			(6
				(gCurRoom setScript: sDentonShot)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance allen of Prop
	(properties
		x 234
		y 212
		view 32053
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10
				(if cel
					(gCurRoom setScript: sAllenShot)
				else
					(gCurRoom setScript: sShotWood)
				)
			)
			(6
				(cond
					(cel
						(gCurRoom setScript: sAllenShot)
					)
					(local1
						(gCurRoom setScript: sShotWood)
					)
					(else
						(= local1 1)
						(gMessager say: 3 6 4 0 self) ; "Hold your fire!!"
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fWindow of Feature ; UNUSED
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 385 116 437 109 436 179 384 177
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10
				(if (IsFlag 246)
					(gMessager say: 5 6 5 0 self) ; "Cease fire! Trailer! Officer coming out!"
				else
					(gCurRoom setScript: sWindowBreaks)
				)
			)
			(6
				(if (IsFlag 246)
					(gMessager say: 5 6 5 0 self) ; "Cease fire! Trailer! Officer coming out!"
				else
					(gCurRoom setScript: sWindowBreaks)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance robotFeat of RobotDoVerb
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(6
				(gCurRoom setScript: sOfficerShot 0 9012)
			)
			(10
				(gCurRoom setScript: sOfficerShot 0 9012)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance gunShots of Sound
	(properties)
)

