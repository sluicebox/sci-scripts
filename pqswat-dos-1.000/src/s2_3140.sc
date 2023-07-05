;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3140)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use HotSpot)
(use RobotDoVerb)
(use Polygon)
(use Feature)
(use WalkieTalkie)
(use Timer)
(use Motion)
(use Actor)
(use System)

(public
	s2_3140 0
)

(local
	local0
	local1
)

(instance s2_3140 of PQRoom
	(properties
		picture 3140
	)

	(method (init)
		(super init: &rest)
		(Load rsAUDIO 21003)
		((ScriptID 4054 0) changeMusic: 29805) ; kiplandRegion
		(eastE init:)
		(westE init:)
		(robotFeat init:)
		(LeftSkyLight init:)
		(RightSkyLight init:)
		(cond
			((== global108 4)
				(switch gPrevRoomNum
					(3110 ; s2_3110
						(self setScript: sEgoDies)
					)
					(3220 ; s2_3220
						(cond
							((== (global112 criticalRoom:) gCurRoomNum)
								(gGame handsOn:)
								(self setScript: sCriticalPathScript)
							)
							((OneOf (global112 curColIdx:) 23 24)
								(self setScript: enterBeforeGunFireErupts)
							)
							((>= (global112 curColIdx:) 25)
								(self setScript: sDuringFight)
							)
							(else
								(gGame handsOn:)
							)
						)
					)
					(else
						(gGame handsOn:)
						(if (== (global112 criticalRoom:) gCurRoomNum)
							(self setScript: sCriticalPathScript)
						)
					)
				)
			)
			((and (== gPrevRoomNum 3230) (>= (global112 curColIdx:) 16)) ; s2_3230
				(self setScript: sEgoTurnsAround)
			)
			(else
				(self setScript: sEgoDies)
			)
		)
	)

	(method (criticalAlert)
		(if (and (not script) (== (global112 curColIdx:) 20))
			(gCurRoom setScript: sCriticalPathScript)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10
				(if (not local0)
					(= local0 1)
					(gMessager say: 0 10 1 0 self) ; "Hold your fire!!!"
				else
					(gCurRoom setScript: sShootAtRoom 0 0)
				)
			)
			(6
				(if (not local0)
					(= local0 1)
					(gMessager say: 0 theVerb 1 0 self) ; "Hold your fire!!!"
				else
					(gCurRoom setScript: sShootAtRoom 0 0)
				)
			)
			(16
				(gCurRoom setScript: sFlashBang)
			)
			(45
				(if local1
					(gMessager say: 0 45 3) ; "What is it, pup?"
				)
			)
			(44
				(if local1
					(gMessager say: 0 44 3) ; "Affirmative. Provide cover..."
				)
			)
			(46
				(if local1
					(gMessager say: 0 46 3) ; "Move with stealth..."
				)
			)
			(43
				(if local1
					(gMessager say: 0 43 3) ; "What is it, pup?"
				else
					(gMessager say: 0 43 4) ; "What is it?"
				)
			)
			(42
				(if local1
					(gMessager say: 0 42 3) ; "What is it, pup?"
				)
			)
			(47
				(if local1
					(gMessager say: 0 47 3) ; "Confirmed..."
				)
			)
			(49
				(if local1
					(gMessager say: 0 49 3) ; "What is it?"
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

(instance enterBeforeGunFireErupts of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gFxSound number: 2992 loop: 1 play: self)
			)
			(2
				(= seconds 5)
			)
			(3
				(gGame handsOff:)
				((ScriptID 4054 0) changeMusic: 0) ; kiplandRegion
				(gBackMusic number: 29808 loop: 1 play: self)
			)
			(4
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance sDuringFight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gFxSound number: 2992 loop: 0 play: self)
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

(instance sEgoDies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(allen init: setCycle: CT 6 1 self)
				((ScriptID 4054 0) changeMusic: 29809) ; kiplandRegion
				(gBackMusic2 number: 29810 loop: 1 play:)
			)
			(1
				(gFxSound number: 2991 loop: 1 play:)
				(allen setCycle: CT 9 1 self)
			)
			(2
				(gFxSound number: 2991 loop: 1 play:)
				(allen setCycle: CT 12 1 self)
			)
			(3
				(gFxSound number: 2991 loop: 1 play:)
				(allen setCycle: CT 15 1 self)
			)
			(4
				(gFxSound number: 2991 loop: 1 play:)
				(allen setCycle: CT 18 1 self)
			)
			(5
				(gFxSound number: 2991 loop: 1 play:)
				(allen setCycle: CT 21 1 self)
			)
			(6
				(gFxSound number: 2991 loop: 1 play:)
				(allen setCycle: End self)
			)
			(7
				((ScriptID 4054 0) changeMusic: 0) ; kiplandRegion
				(gBackMusic number: 29808 loop: 1 play: self)
			)
			(8
				(gCurRoom newRoom: 72) ; funeralRoom
			)
		)
	)
)

(instance sCriticalPathScript of Script
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
								(20
									(= register 31401)
									(global112 getPercent: 0 33)
								)
								(21
									(= register 31401)
									(global112 getPercent: 34 109)
								)
								(22
									(= register 31411)
									(global112 getPercent: 29 134)
								)
							)
						)
						-1
					)
					(if (== register 31401)
						(proc4_6 31401 0 127 temp0 0 -1 1)
					else
						(proc4_6 31411 384 143 temp0 0 -1 1)
					)
				else
					(self dispose:)
				)
			)
			(1
				(-- state)
				(switch scratch
					(-1
						(if (== register 31401)
							(= register 31411)
							(proc4_5)
							(global112 pausePath: 1)
							(++ state)
							(gGame showCloseUp: 31407 -1 -1 self 1)
						else
							(++ state)
							(= cycles 1)
						)
					)
					(1
						(gSwatInterface showHandAni: 4)
					)
				)
			)
			(2
				(global112 pausePath: 0)
				(proc4_6 31411 384 143 29 0 -1 1)
				(Palette 2 42 254 100) ; PalIntensity
				(FrameOut)
			)
			(3
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

(instance sShootAtRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (and register (not (SetFlag register)))
					(= register 0)
					(gFxSound number: 21003 loop: 1 play:)
				)
				(gMessager say: 0 10 2 0 self) ; "Cease fire! Trailer! Officer coming out!"
			)
			(1
				(gCurRoom newRoom: 3010) ; s2_3010
			)
		)
	)
)

(instance sFlashBang of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 6)
				(cannister init: setCycle: End self)
			)
			(1
				(gFxSound number: 1002 loop: 1 play:)
				(cannister view: 6 loop: 0 cel: 0 posn: 289 179 setPri: 600)
				(if (OneOf (global112 curColIdx:) 20 21)
					(= temp0 (Robot 11)) ; FrameNum
					(proc4_5)
					(= global128 31401)
					(WalkieTalkie showFrame: 31401 temp0 0 127)
				)
				(if (== (global112 curColIdx:) 22)
					(= temp0 (Robot 11)) ; FrameNum
					(proc4_5)
					(= global128 31411)
					(WalkieTalkie showFrame: 31411 temp0 384 143)
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
				(= cycles 1)
			)
			(6
				(gMessager say: 0 16 0 1 self) ; "Status! Status!"
			)
			(7
				(cond
					((< (global112 curColIdx:) 20)
						(proc4_5)
						(proc4_6 31403 0 149 0 0 -1 1)
					)
					((<= (global112 curColIdx:) 21)
						(gMessager say: 0 16 0 2 self) ; "Unnecessary detonation! Trailer! Officer coming out!"
					)
					(else
						(proc4_5)
						(proc4_6 31404 551 149 0 0 -1 1)
					)
				)
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

(instance sEgoTurnsAround of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc4_6 31406 435 160 0 0 -1 1)
			)
			(1
				(gFxSound number: 2993 loop: 1 play: self)
			)
			(2
				(SetFlag 98)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance cannister of Prop
	(properties
		x 273
		y 340
		view 31402
	)
)

(instance allen of Actor
	(properties
		x 542
		y 252
		view 31400
	)
)

(instance eastE of HotSpot
	(properties
		nsLeft 600
		nsRight 640
		nsBottom 300
		type 8193
	)

	(method (doVerb)
		(if (== (gCurRoom script:) enterBeforeGunFireErupts)
			(gCurRoom newRoom: 3240) ; s2_3240
		else
			(gCurRoom newRoom: 3220) ; s2_3220
		)
	)
)

(instance westE of HotSpot
	(properties
		nsRight 20
		nsBottom 150
		type 32769
	)

	(method (doVerb)
		(gCurRoom newRoom: 3200) ; s2_3200
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

(instance LeftSkyLight of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 268 36 320 36 320 4 302 7 297 10 305 26 289 32 276 27 284 8 280 6 261 6
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10
				(if (not local0)
					(SetFlag 253)
					(gFxSound number: 21003 loop: 1 play:)
					(= local0 1)
					(gMessager say: 0 10 1) ; "Hold your fire!!!"
				else
					(gCurRoom setScript: sShootAtRoom 0 252)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance RightSkyLight of Feature
	(properties)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 468 39 506 38 521 9 499 9 467 35
					yourself:
				)
				((Polygon new:)
					type: PNearestAccess
					init: 474 7 467 25 482 11 482 9
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10
				(if (not local0)
					(SetFlag 253)
					(gFxSound number: 21003 loop: 1 play:)
					(= local0 1)
					(gMessager say: 0 10 1) ; "Hold your fire!!!"
				else
					(gCurRoom setScript: sShootAtRoom 0 252)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance gunFight of Timer ; UNUSED
	(properties)

	(method (cue)
		(SetFlag 243)
		(gCurRoom newRoom: 3240) ; s2_3240
	)
)

