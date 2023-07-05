;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3240)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use HotSpot)
(use RobotDoVerb)
(use ROsc)
(use Polygon)
(use WalkieTalkie)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	s2_3240 0
)

(local
	local0
	local1
	local2 = 1
	local3
)

(instance s2_3240 of PQRoom
	(properties
		picture 3240
	)

	(method (init)
		(super init: &rest)
		(Load rsAUDIO 29810)
		(robotFeat init:)
		(if (== global108 4)
			(gGame handsOn:)
			(cond
				(
					(or
						(== gPrevRoomNum 3140) ; s2_3140
						(and (OneOf gPrevRoomNum 3220 3250) (IsFlag 243)) ; s2_3220, s2_3250
					)
					(self setScript: sC_HitElementCharge)
				)
				((< (global112 curColIdx:) 21)
					(= local0 1)
					(self setScript: sElementNotPresent)
				)
				((== (global112 criticalRoom:) gCurRoomNum)
					(self setScript: sElement)
				)
			)
		else
			(northE init:)
			(stairsE init:)
			(gGame handsOn:)
			(cond
				((and (== gPrevRoomNum 3220) (not (IsFlag 249))) ; s2_3220
					(self setScript: allenShootsFromStairs)
				)
				((and (== gPrevRoomNum 3220) (IsFlag 249)) ; s2_3220
					(self setScript: allenSlumpedDead)
				)
				((== (global112 criticalRoom:) gCurRoomNum)
					(self setScript: sPlot2Element)
				)
			)
		)
	)

	(method (criticalAlert)
		(if
			(and
				(not script)
				(not local0)
				(== (global112 criticalRoom:) gCurRoomNum)
				(== (global112 curColIdx:) 24)
			)
			(self setScript: sElement)
		)
		(if (and (not script) (== global108 5) (== (global112 curColIdx:) 15))
			(self setScript: sPlot2Element)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10
				(if (< (global112 curColIdx:) 25)
					(if local2
						(= local2 0)
						(gMessager say: 3 theVerb 4) ; "Hold your fire!"
					else
						0
						(gCurRoom setScript: secondShot)
					)
				)
			)
			(6
				(if (< (global112 curColIdx:) 25)
					(if local2
						(= local2 0)
						(gMessager say: 3 theVerb 4) ; "Hold your fire!"
					else
						0
						(gCurRoom setScript: secondShot)
					)
				)
			)
			(16
				(self setScript: sFlashBang)
			)
			(else
				(cond
					((OneOf theVerb 44 45 48)
						(cond
							((== (global112 curColIdx:) 24)
								(gMessager say: 0 theVerb 6)
							)
							((< (global112 curColIdx:) 25)
								(gMessager say: 0 theVerb 7)
							)
							(else
								(super doVerb: theVerb)
							)
						)
					)
					((OneOf theVerb 43 47 46 42 49)
						(if (== (global112 curColIdx:) 24)
							(gMessager say: 0 theVerb 6)
						else
							(super doVerb: theVerb)
						)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
		)
	)

	(method (dispose)
		(DisposeScript 64938)
		(proc4_5)
		(super dispose:)
	)
)

(instance secondShot of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 3 10 11 0 self) ; "You're outta here, pup! Officer coming out!"
			)
			(1
				(SetFlag 98)
				(gCurRoom newRoom: 3010) ; s2_3010
			)
		)
	)
)

(instance sElementNotPresent of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 4054 0) changeMusic: 29809) ; kiplandRegion
				(gBackMusic2 number: 29810 loop: 1 play:)
				(self setScript: sAllenComesOutOfStairs)
				(= cycles 1)
			)
			(1
				(gMessager say: 0 0 1) ; "OK! This is it! This is it! Listen! I want out of here! See this, I got a ticket outta here... and I'll use it! I swear I will! I'll kill this son of a bitch! I will!"
				(= seconds 25)
			)
			(2
				(if (not (gTalkers isEmpty:))
					(-- state)
				)
				(= cycles 1)
			)
			(3
				(gGame handsOff:)
				(gCurRoom setScript: sAllenKillsHector)
			)
		)
	)
)

(instance sShootAllen of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc4_5)
				(if (IsFlag 93)
					(gGame showCloseUp: 32907 -1 -1 self 1)
				else
					(gGame showCloseUp: 32401 -1 -1 self 1)
				)
			)
			(1
				(gFxSound number: 3450 loop: 1 play: self)
			)
			(2
				(cond
					((IsFlag 93)
						(SetFlag 98)
						((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
					)
					(local0
						(SetFlag 98)
						(SetFlag 95)
						(gEgo awardMedal: 64)
						((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
					)
					(else
						(SetFlag 102)
						(SetFlag 99)
						(gEgo awardMedal: 66)
						(SetFlag 18)
						(SetFlag 89)
						((ScriptID 4054 0) changeMusic: 6006) ; kiplandRegion
					)
				)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance sElement of Script
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

	(method (changeState newState &tmp temp0 temp1)
		(switch (= state newState)
			(0
				(Load rsVIEW 32431)
				(if
					(!=
						(= temp1
							(switch (global112 curColIdx:)
								(24
									(global112 getPercent: 0 44)
								)
								(24
									(if
										(>
											(= temp0
												(global112 getPercent: 45 116)
											)
											112
										)
										(self setScript: sAllenComesOutOfStairs)
									)
									temp0
								)
								(25
									(if (global112 curRoomFrames:)
										(sAllenComesOutOfStairs start: 1)
									)
									(self setScript: sAllenComesOutOfStairs)
									(global112 getPercent: 117 304)
								)
								(26
									(sAllenComesOutOfStairs start: 2)
									(self setScript: sAllenComesOutOfStairs)
									304
								)
								(else -1)
							)
						)
						-1
					)
					(proc4_5)
					(proc4_6 32404 -4 23 temp1 0 -1 1)
				else
					(self dispose:)
				)
			)
			(1
				(-- state)
				(switch scratch
					(-1
						(++ state)
					)
					(1
						(gSwatInterface showHandAni: 3)
					)
					(2
						(self setScript: sAllenComesOutOfStairs)
					)
					(3
						(global112 pausePath: 1)
						(proc4_5)
						(WalkieTalkie showFrame: 32404 304 -4 23)
						(= global128 32404)
						(sAllenComesOutOfStairs cue:)
					)
				)
			)
		)
	)
)

(instance sAllenComesOutOfStairs of Script
	(properties)

	(method (init)
		(super init: &rest)
		(= local1 1)
	)

	(method (dispose)
		(= local1 0)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 4054 0) changeMusic: 29809) ; kiplandRegion
				(gBackMusic2 number: 29810 loop: 1 play:)
				(allen
					view: 32431
					setLoop: 1
					setCel: 11
					posn: 519 222
					setPri: 10
					init:
					setCycle: CT 55 1 self
				)
				(hector
					view: 32431
					setLoop: 0
					setCel: 11
					posn: 519 222
					setPri: 10
					init:
					setCycle: CT 55 1
				)
			)
			(1
				(gGame handsOn:)
				(if (not local1)
					((ScriptID 4054 0) changeMusic: 29809) ; kiplandRegion
					(gBackMusic2 number: 29810 loop: 1 play:)
					(allen
						view: 32431
						setLoop: 1
						posn: 519 222
						setPri: 10
						init:
					)
					(hector
						view: 32431
						setLoop: 0
						setPri: 10
						posn: 519 222
						init:
					)
				)
				(allen setCel: 56 setCycle: ROsc -1 56 180)
				(hector setCel: 56 setCycle: ROsc -1 56 180)
			)
			(2
				(if (not local1)
					(allen
						view: 32431
						setLoop: 1
						setPri: 10
						setCel: 140
						posn: 519 222
						init:
					)
					(hector
						view: 32431
						setLoop: 0
						setPri: 10
						setCel: 140
						posn: 519 222
						init:
					)
				)
				(allen setCycle: CT 190 1 self)
				(hector setCycle: CT 190 1)
			)
			(3
				(gGame handsOff:)
				(allen setCel: 191 setCycle: CT 202 1 self)
				(hector setCel: 191 setCycle: CT 202 1)
				(gFxSound number: 2991 loop: 1 play:)
			)
			(4
				(proc4_5)
				(proc4_6 32404 -4 23 305 0 -1 1)
				(allen setCycle: End)
				(hector setCycle: End)
			)
			(5
				(SetFlag 97)
				(SetFlag 93)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance sAllenKillsHector of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc4_5)
				(gGame handsOff: showCloseUp: 32403 180 66 self 1)
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

(instance sFlashBang of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 6)
				(Load rsAUDIO 1002)
				(cannister
					view: 32406
					loop: 0
					cel: 0
					posn: 200 24
					setPri: 500
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
				(if (== global108 4)
					(global112 pausePath: 1)
					(cond
						((== (global112 curColIdx:) 24)
							(global112 endColumn:)
							(proc4_5)
							(WalkieTalkie showFrame: 32404 117 -4 23)
							(= global128 32404)
						)
						((> (global112 curColIdx:) 24)
							(self setScript: guysPresentFlash)
						)
						(else
							(self setScript: guysNotPresentFlash)
						)
					)
				else
					0
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
				(gunShot number: 2991 loop: 1 play:)
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
				(gGame handsOn:)
				(if script
					(script cue:)
				else
					(gCurRoom setScript: sElement)
				)
			)
		)
	)
)

(instance guysPresentFlash of Script
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

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc4_5)
				(WalkieTalkie showFrame: 32407 0 0 52)
				(= global128 32407)
				(allen view: 32432 loop: 0 cel: 0 posn: 416 192 init:)
				(hector view: 32432 loop: 1 cel: 0 posn: 416 192 init:)
			)
			(1
				(proc4_5)
				(SetFlag 93)
				(proc4_6 32407 0 52 0 0 -1 1)
				(self setScript: sAllenDanceWOHector)
			)
			(2
				(-- state)
				(switch scratch
					(-1
						(++ state)
						(= cycles 1)
					)
					(1
						(proc4_5)
						(WalkieTalkie showFrame: 32407 168 0 52)
						(= global128 32407)
						(sAllenDanceWOHector cue:)
					)
				)
			)
		)
	)
)

(instance guysNotPresentFlash of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc4_5)
				(allen view: 32432 loop: 0 cel: 0 posn: 416 192)
				(hector view: 32432 loop: 1 cel: 0 posn: 416 192)
				(UpdateScreenItem allen)
				(UpdateScreenItem hector)
			)
			(1
				(SetFlag 93)
				(self setScript: sAllenDanceWOHector)
				(= seconds 15)
			)
			(2
				(sAllenDanceWOHector cue:)
			)
		)
	)
)

(instance sAllenDanceWOHector of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(allen setCycle: CT 19 1 self)
			)
			(1
				(allen setCycle: ROsc -1 20 163)
			)
			(2
				(gGame handsOff:)
				(allen setCycle: CT 164 1 self)
			)
			(3
				(if local0
					(gGame showCloseUp: 32415 -1 -1 self 1)
				else
					(allen setCycle: CT 168 1 self)
				)
			)
			(4
				(if local0
					((ScriptID 4054 0) changeMusic: 0) ; kiplandRegion
					(gBackMusic number: 29808 loop: 1 play: self)
				else
					(gFxSound number: 2991 loop: 1 play:)
					(allen setCycle: CT 170 1 self)
				)
			)
			(5
				(if local0
					(gCurRoom newRoom: 72) ; funeralRoom
				else
					(allen setCycle: End)
					(proc4_5)
					(proc4_6 32407 0 52 169 0 -1 1)
				)
			)
			(6
				(SetFlag 98)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance sOfficerKilled of Script
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
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(SetFlag 98)
				(SetFlag 94)
				(SetFlag 100)
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance sC_HitElementCharge of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOn:)
				((ScriptID 4054 0) changeMusic: 29809) ; kiplandRegion
				(gBackMusic2 number: 29810 loop: 1 play:)
				(self setScript: allenDanceWhenCarHit self)
				(proc4_6 32400 -10 41 0 0 -1 1)
			)
			(1
				(proc4_5)
				(= global128 32400)
				(WalkieTalkie showFrame: 32400 302 -10 41)
				(allenDanceWhenCarHit cue:)
			)
			(2
				(proc4_5)
				(proc4_6 32400 -10 41 303 0 -1 1)
				(allen setCycle: End)
				(hector setCycle: End)
			)
			(3
				(SetFlag 93)
				(SetFlag 94)
				(SetFlag 95)
				(SetFlag 97)
				(gEgo awardMedal: 68)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance allenDanceWhenCarHit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(allen
					view: 32430
					loop: 1
					cel: 0
					posn: 416 181
					init:
					setCycle: CT 25 1 self
				)
				(hector
					view: 32430
					loop: 0
					cel: 0
					posn: 416 181
					init:
					setCycle: CT 25 1
				)
			)
			(1
				(allen setCycle: ROsc -1 25 150)
				(hector setCycle: ROsc -1 25 150)
			)
			(2
				(allen setCycle: CT 153 1 self)
				(hector setCycle: CT 153 1)
			)
			(3
				(gGame handsOff:)
				(gFxSound number: 2991 loop: 1 play:)
				(allen setCycle: CT 158 1 self)
				(hector setCycle: CT 158 1)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance allenShootsFromStairs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(hector view: 32419 loop: 0 cel: 0 posn: 354 190 init:)
				(= seconds 3)
			)
			(1
				(allen
					view: 32434
					loop: 0
					cel: 0
					posn: 542 171
					init:
					setCycle: CT 3 1 self
				)
			)
			(2
				(allen setCycle: CT 14 1 self)
			)
			(3
				(gFxSound number: 2991 loop: 1 play:)
				(allen setCycle: CT 24 1 self)
			)
			(4
				(gFxSound play:)
				(allen setCycle: CT 35 1 self)
			)
			(5
				(gFxSound play:)
				(allen setCycle: CT 44 1 self)
			)
			(6
				(gFxSound play:)
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

(instance allenSlumpedDead of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(element
					view: 32410
					loop: 0
					cel: 0
					posn: 523 295
					init:
					setCycle: End self
				)
			)
			(1
				(SetFlag 98)
				(SetFlag 95)
				(gEgo awardMedal: 68)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance sPlot2Element of Script
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
				(if
					(!=
						(= temp0
							(switch (global112 curColIdx:)
								(15
									(= register 32414)
									(global112 getPercent: 0 168)
								)
								(16
									(= register 32415)
									(element
										view: 32415
										loop: 0
										cel: 0
										posn: 417 364
										init:
									)
									(global112 getPercent: 0 125)
								)
								(17
									(= register 32415)
									(element
										view: 32415
										loop: 0
										cel: 0
										posn: 417 364
										init:
									)
									(global112 getPercent: 126 350)
								)
								(else -1)
							)
						)
						-1
					)
					(gGame handsOn:)
					(switch register
						(32414
							(proc4_6 register 402 41 temp0 0 -1 1)
						)
						(32415
							(proc4_6 register 0 42 temp0 0 -1 1)
						)
					)
				)
			)
			(1
				(-- state)
				(switch scratch
					(-1
						(switch register
							(32414
								(element
									view: 32415
									loop: 0
									cel: 0
									posn: 417 364
									init:
								)
								(= register 32415)
								(proc4_6 register 0 42 0 0 -1 1)
							)
							(else
								(++ state)
								(= cycles 1)
							)
						)
					)
					(1
						(gSwatInterface showHandAni: 3)
					)
					(2
						(gSwatInterface showHandAni: 6)
					)
					(3
						(gSwatInterface showHandAni: 4)
					)
					(4
						(++ scratch)
						(proc4_5)
						(= global128 32415)
						(global112 pausePath: 1)
						(WalkieTalkie showFrame: global128 190 0 42)
						(= seconds 5)
					)
					(5
						(global112 pausePath: 0)
						(proc4_6 register 0 42 191 0 -1 1)
					)
				)
			)
			(2
				(proc4_5)
				(element
					view: 32433
					loop: 0
					cel: 0
					posn: 271 192
					setCycle: CT 41 1 self
				)
			)
			(3
				(gFxSound number: 1002 loop: 1 play:)
				(= local3 1)
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
				(= cycles 2)
			)
			(8
				(element setPri: 10 setCycle: End self)
			)
			(9
				(gGame handsOff:)
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(= seconds 3)
			)
			(10
				(gFxSound number: 2993 loop: 1 play: self)
			)
			(11
				(SetFlag 98)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance allen of Prop
	(properties
		x 462
		y 177
		view 32402
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6
				(gCurRoom setScript: sShootAllen)
			)
			(10
				(gCurRoom setScript: sShootAllen)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance hector of Prop
	(properties
		x 462
		y 177
		view 32402
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10
				(SetFlag 93)
				(SetFlag 98)
				(SetFlag 100)
				(gCurRoom setScript: sAllenKillsHector)
			)
			(6
				(SetFlag 93)
				(SetFlag 98)
				(SetFlag 100)
				(gCurRoom setScript: sAllenKillsHector)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance element of Prop
	(properties
		x 402
		y 198
		view 32432
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10
				(gCurRoom setScript: sOfficerKilled)
			)
			(6
				(gCurRoom setScript: sOfficerKilled)
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

(instance gunShot of Sound
	(properties
		flags 5
	)
)

(instance northE of HotSpot
	(properties
		nsRight 640
		nsBottom 50
		type 4097
	)

	(method (doVerb)
		(if local3
			(gCurRoom newRoom: 3300) ; s2_3300
		else
			(gCurRoom newRoom: 3290) ; s2_3290
		)
	)
)

(instance stairsE of HotSpot
	(properties
		type 16385
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 497 120 622 120 619 180 495 173
					yourself:
				)
		)
	)

	(method (doVerb)
		(if local3
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
			(6
				(gCurRoom setScript: sOfficerKilled)
			)
			(10
				(gCurRoom setScript: sOfficerKilled)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

