;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3160)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use HotSpot)
(use RobotDoVerb)
(use Polygon)
(use Feature)
(use WalkieTalkie)
(use Motion)
(use Actor)
(use System)

(public
	s2_3160 0
)

(local
	local0
	local1
	local2
	local3
	[local4 3]
)

(instance s2_3160 of PQRoom
	(properties
		picture 3160
	)

	(method (init)
		(super init: &rest)
		((ScriptID 4054 0) changeMusic: 29805) ; kiplandRegion
		(if (== global108 4)
			(northE init:)
			(if (not (IsFlag 220))
				(westE init:)
			)
		)
		(eastE init:)
		(robotFeat init:)
		(furniture init:)
		(ppTable init:)
		(cond
			((== global108 4)
				(gGame handsOn:)
				(wood view: 31610 loop: 1 cel: 22 posn: 341 205 init:)
				(if (== (global112 criticalRoom:) gCurRoomNum)
					(self setScript: sCriticalPath1Script)
				)
			)
			((== gPrevRoomNum 3110) ; s2_3110
				(if (global112 leftEarly:)
					(gGame handsOff:)
					(self setScript: beforeFlashBang)
				else
					(gGame handsOn:)
					(self setScript: sCriticalPath2Script)
				)
			)
			(
				(or
					(and (== gPrevRoomNum 3150) (IsFlag 249)) ; s2_3150
					(and (== gPrevRoomNum 3220) (not (IsFlag 249))) ; s2_3220
				)
				(self setScript: sBeforeGunFight)
			)
			(else
				(gGame handsOn:)
			)
		)
	)

	(method (criticalAlert)
		(if
			(and
				(not (self script:))
				(== global108 4)
				(== (global112 curColIdx:) 14)
			)
			(self setScript: sCriticalPath1Script)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10
				(if (not local2)
					(= local2 1)
					(gMessager say: 7 10 13 0 self) ; "Cease fire!"
				else
					(gCurRoom setScript: sShootAtRoom)
				)
			)
			(6
				(if (not local2)
					(= local2 1)
					(gMessager say: 7 10 13 0 self) ; "Cease fire!"
				else
					(gCurRoom setScript: sShootAtRoom)
				)
			)
			(16
				(if (!= script sFlashBang)
					(if (IsFlag 220)
						(self setScript: sFlashBang)
					else
						(self setScript: sFlashBang)
					)
				)
			)
			(43
				(if local0
					(if (== global108 4)
						(gMessager say: 0 43 9) ; "What is it, pup?"
					else
						(gMessager say: 0 43 17) ; "What is it?"
					)
				else
					(gMessager say: 0 43 10) ; "What is it?"
				)
			)
			((OneOf theVerb 45 44 46 42 47 49)
				(if local0
					(if (== global108 4)
						(gMessager say: 0 theVerb 9)
					else
						(gMessager say: 0 theVerb 17)
					)
				)
			)
			(48
				(if local0
					(gMessager say: 0 theVerb 17) ; "Steady... We're clearing..."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(proc4_5)
		(if global112
			(global112 pausePath: 0)
		)
		(super dispose:)
	)
)

(instance sCriticalPath1Script of Script
	(properties)

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
				(= register 0)
				(if
					(!=
						(= temp0
							(switch (global112 curColIdx:)
								(14
									(= register 31600)
									(global112 getPercent: 0 118)
								)
								(15
									(= register 31600)
									(global112 getPercent: 119 566)
								)
								(16
									(= register 31600)
									(global112 getPercent: 567 669)
								)
								(17
									(= register 31610)
									(global112 getPercent: 34 54)
								)
								(else
									(= register 31610)
									55
								)
							)
						)
						-1
					)
					(switch register
						(31600
							(proc4_6 31600 0 137 temp0 0 -1 1)
						)
						(31610
							(proc4_6 31610 337 128 temp0 0 -1 1)
						)
					)
				else
					(self dispose:)
				)
			)
			(1
				(-- state)
				(switch scratch
					(-1
						(switch register
							(31600
								(= register 31610)
								(global112 pausePath: 1)
								(= scratch 5)
								(gGame showCloseUp: 31604 -1 -1 self 1)
							)
							(else
								(++ state)
								(= cycles 2)
							)
						)
					)
					(1
						(gSwatInterface showHandAni: 4)
					)
					(2
						(westE dispose:)
						(SetFlag 220)
						(gSwatInterface showHandAni: 6)
					)
					(3
						(gSwatInterface showHandAni: 6)
					)
					(5
						(gCurRoom setScript: continuePlot1)
					)
				)
			)
		)
	)
)

(instance continuePlot1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Palette 2 42 254 100) ; PalIntensity
				(FrameOut)
				(element view: 31610 loop: 0 cel: 2 posn: 279 211 init:)
				(= seconds 3)
			)
			(1
				(global112 pausePath: 0)
				(element setCycle: CT 22 1 self)
			)
			(2
				(gGame handsOff:)
				(global112 stopPath:)
				(wood hide:)
				((ScriptID 4054 0) changeMusic: 29809) ; kiplandRegion
				(gBackMusic2 number: 29810 loop: 1 play:)
				(gFxSound number: 31610 loop: 1 play:)
				(allen
					view: 31610
					loop: 1
					cel: 22
					posn: 341 205
					init:
					setCycle: CT 32 1 self
				)
				(element setCycle: CT 32 1)
			)
			(3
				(element setCycle: End self)
				(wood loop: 2 cel: 2 posn: 485 199 show: setPri: 200)
				(allen setPri: 250 setCycle: End)
			)
			(4
				(SetFlag 98)
				(SetFlag 95)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
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
				(SetFlag 100)
				(SetFlag 98)
				(SetFlag 94)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance sCarmichaelShot of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame showCloseUp: 9012 -1 -1 self 1)
			)
			(1
				(SetFlag 100)
				(SetFlag 98)
				(SetFlag 94)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance sDentonShot of Script ; UNUSED
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
				(SetFlag 100)
				(SetFlag 98)
				(SetFlag 94)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance sShotAtFurn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 3 10 5 0 self) ; "Cease fire! Trailer! Officer coming out!"
			)
			(1
				(SetFlag 98)
				(gCurRoom newRoom: 3010) ; s2_3010
			)
		)
	)
)

(instance sShootAtRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 7 10 14 0 self) ; "Cease fire! Trailer! Officer coming out!"
			)
			(1
				(SetFlag 98)
				(gCurRoom newRoom: 3010) ; s2_3010
			)
		)
	)
)

(instance sNotCleared of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 4054 0) changeMusic: 29809) ; kiplandRegion
				(gBackMusic2 number: 29810 loop: 1 play:)
				(allen
					view: 31601
					loop: 0
					cel: 0
					posn: 89 229
					init:
					setCycle: CT 38 1 self
				)
				(gMessager say: 3 10 3 0 self) ; "Hold your fire!! One down!!"
			)
			(1
				(gFxSound number: 31601 loop: 0 play:)
				(allen setCycle: End self)
			)
			(2
				(SetFlag 100)
				(SetFlag 93)
				(SetFlag 98)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
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
				(if gAutoRobot
					(proc4_5)
				)
				(northE dispose:)
				(westE dispose:)
				(eastE dispose:)
				(if (IsFlag 220)
					(= global128 31608)
					(WalkieTalkie showFrame: 31608 0 129 145)
				else
					(element view: 31609 loop: 0 cel: 0 posn: 70 310 init:)
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
				(if local1
					(SetFlag 98)
					((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
					(gCurRoom newRoom: 35) ; metroExt
				)
				(Palette 2 42 254 150) ; PalIntensity
				(FrameOut)
				(= cycles 1)
			)
			(5
				(= local1 1)
				(Palette 2 42 254 100) ; PalIntensity
				(FrameOut)
				(gGame handsOn:)
				(if (IsFlag 220)
					(proc4_5)
					(proc4_6 31608 129 145 0 0 -1 1)
				else
					(element setCycle: End)
					(self setScript: plot1FlashBangAssoc self)
				)
			)
			(6
				(gGame handsOff:)
				(if (IsFlag 220)
					(SetFlag 98)
					(gCurRoom newRoom: 3010) ; s2_3010
				else
					(gFxSound number: 60 loop: 0 play:)
					(allen cel: 115 setCycle: End self)
					(hector cel: 115 setCycle: End self)
					(gEgo awardMedal: 64)
				)
			)
			(7
				(SetFlag 98)
				(SetFlag 95)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance plot1FlashBangAssoc of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(allen
					view: 31616
					loop: 0
					cel: 0
					setPri: 10
					posn: 71 314
					init:
					setCycle: CT 115 1 self
				)
				(hector
					view: 31616
					loop: 1
					cel: 0
					setPri: 10
					posn: 71 314
					init:
					setCycle: CT 115 1
				)
				(gMessager say: 0 16 3 0 self) ; "I'm gonna kill him, I'm gonna fuckin' kill 'im! Just back off!"
			)
			(1 0)
			(2
				(self dispose:)
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
				(if register
					(gMessager say: 1 10 0 0 self) ; "Cease fire! Cease fire!"
				else
					(= cycles 1)
				)
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
				(allen cel: 115 setCycle: End self)
				(hector cel: 115 setCycle: End self)
			)
			(1
				(SetFlag 98)
				(SetFlag 95)
				(gEgo awardMedal: 65)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance sHectorShot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame showCloseUp: 31511 -1 -1 self 1)
			)
			(1
				(SetFlag 100)
				(SetFlag 98)
				(SetFlag 93)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance beforeFlashBang of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 31615
					loop: 0
					cel: 0
					posn: -48 215
					init:
					setCycle: CT 60 1 self
				)
				(allen view: 31605 loop: 0 cel: 0 posn: 211 224 init:)
			)
			(1
				(gEgo setCycle: End self)
				(self setScript: allenShootsEgo self)
			)
			(2
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
			)
			(3
				((ScriptID 4054 0) changeMusic: 0) ; kiplandRegion
				(gBackMusic number: 29808 loop: 1 play: self)
			)
			(4
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance allenShootsEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(allen setCycle: CT 3 1 self)
			)
			(1
				(gFxSound number: 31601 loop: 1 play:)
				(allen setCycle: End self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sCriticalPath2Script of Script
	(properties)

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
				(Load rsAUDIO 29809)
				(Load rsAUDIO 29810)
				(= register 0)
				(if
					(!=
						(= temp0
							(switch (global112 curColIdx:)
								(14
									(global112 getPercent: 0 151)
								)
								(else 151)
							)
						)
						-1
					)
					(proc4_6 31606 -2 127 temp0 0 -1 1)
				else
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
						(gSwatInterface showHandAni: 3)
					)
					(2
						(eastE dispose:)
					)
					(3
						(gGame handsOff:)
						((ScriptID 4054 0) changeMusic: 29809) ; kiplandRegion
						(gBackMusic2 number: 29810 loop: 1 play:)
					)
				)
			)
			(2
				(gCurRoom newRoom: 3110) ; s2_3110
			)
		)
	)
)

(instance sBeforeGunFight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(element
					view: 31607
					loop: 0
					cel: 0
					posn: 190 296
					init:
					setCycle: CT 125 1 self
				)
			)
			(1
				(gSwatInterface showHandAni: 6)
				(westE dispose:)
				(SetFlag 220)
				(element setCycle: CT 171 1 self)
			)
			(2
				(gSwatInterface showHandAni: 4)
				(gMessager say: 0 0 12 1 self) ; "Hold! Pup!"
				(element setCycle: End)
			)
			(3
				(if (element cycler:)
					(-- state)
				)
				(= cycles 2)
			)
			(4
				(gMessager say: 0 0 12 2 self) ; "Ready to move. Go!"
			)
			(5
				(element view: 31607 loop: 1 cel: 0 setCycle: CT 148 1 self)
			)
			(6
				(gSwatInterface showHandAni: 4)
				(element setCycle: End self)
			)
			(7
				(gGame showCloseUp: 31627 -1 -1 self)
			)
			(8
				(element
					view: 31617
					loop: 0
					cel: 0
					posn: 327 212
					setCycle: CT 50 1 self
				)
			)
			(9
				(gGame handsOff:)
				((ScriptID 4054 0) changeMusic: 29809) ; kiplandRegion
				(gBackMusic2 number: 29810 loop: 1 play:)
				(gFxSound number: 2992 loop: 1 play:)
				(element setCycle: End self)
			)
			(10
				(SetFlag 98)
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
		(gCurRoom newRoom: 3200) ; s2_3200
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
		(gCurRoom newRoom: 3220) ; s2_3220
	)
)

(instance westE of HotSpot
	(properties
		nsRight 50
		nsBottom 360
		type 32769
	)

	(method (doVerb)
		(gCurRoom newRoom: 3170) ; s2_3170
	)
)

(instance cannister of Prop
	(properties
		x 200
		y 231
		view 31602
	)
)

(instance element of Prop
	(properties
		x 187
		y 211
		view 31610
	)

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
		noun 1
		x 100
		y 100
		view 911
		cel 5
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10
				(gCurRoom setScript: sOfficerShot 0 self)
			)
			(6
				(gCurRoom setScript: sOfficerShot 0 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance denton of Prop ; UNUSED
	(properties
		noun 2
		x 180
		y 80
		view 911
		cel 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10
				(gCurRoom setScript: sOfficerShot 0 self)
			)
			(6
				(gCurRoom setScript: sOfficerShot 0 self)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance allen of Prop
	(properties
		x 240
		y 80
		view 911
		cel 6
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10
				(gCurRoom setScript: sAllenShot)
			)
			(6
				(gCurRoom setScript: sAllenShot)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hector of Prop
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(10
				(gCurRoom setScript: sHectorShot)
			)
			(6
				(gCurRoom setScript: sHectorShot)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance wood of View
	(properties
		x 338
		y 204
		view 31610
		loop 1
	)
)

(instance furniture of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 40 130 65 134 90 160 120 154 114 176 124 173 143 201 138 243 74 235
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10
				(if (IsFlag 220)
					(if (not local3)
						(= local3 1)
						(gMessager say: 3 10 4 0) ; "Hold your fire!!!"
					else
						(gCurRoom setScript: sShotAtFurn)
					)
				else
					(gCurRoom setScript: sNotCleared)
				)
			)
			(6
				(gCurRoom setScript: sShotAtFurn)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance ppTable of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 314 234 422 221 638 264 501 288
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10
				(gCurRoom setScript: sShotAtFurn)
			)
			(6
				(gCurRoom setScript: sShotAtFurn)
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

