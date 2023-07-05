;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3220)
(include sci.sh)
(use Main)
(use ExitButton)
(use PQRoom)
(use HotSpot)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	s2_3220 0
)

(local
	local0
	local1
	local2 = 1
)

(instance s2_3220 of PQRoom
	(properties
		picture 3220
	)

	(method (init)
		(super init: &rest)
		(Load rsAUDIO 29810)
		((ScriptID 4054 0) changeMusic: 29805) ; kiplandRegion
		(northE init:)
		(eastE init:)
		(westE init:)
		(cond
			((== global108 4)
				(if (== (global112 criticalRoom:) 3220)
					(self setScript: sElementPlot1)
				)
				(gGame handsOn:)
			)
			((== global108 5)
				(cond
					((and (OneOf gPrevRoomNum 3110 3160) (IsFlag 249)) ; s2_3110, s2_3160
						(= local2 0)
						(self setScript: after3110FlashBang)
					)
					((not (IsFlag 249))
						(self setScript: cancelDynamicEntry)
					)
					(else
						(gGame handsOn:)
					)
				)
			)
		)
	)

	(method (criticalAlert)
		(if
			(and
				(not (self script:))
				(== global108 4)
				(== (global112 curColIdx:) 22)
			)
			(self setScript: sElementPlot1)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(16
				(if (== global108 4)
					(self setScript: sFlashBang)
				else
					(self setScript: sFlashBangPlot2)
				)
			)
			(else
				(cond
					((OneOf theVerb 6 10)
						(if local0
							(self setScript: compromisePosition)
						else
							(gMessager say: 3 10 3 1 0) ; "Hold your fire!!!"
							(= local0 1)
						)
					)
					((OneOf theVerb 43 42 49)
						(if (not (IsFlag 250))
							(gMessager say: 0 49 5) ; "What is it?"
						)
					)
					((OneOf theVerb 45 44 46 48 47)
						(if (IsFlag 250)
							(gMessager say: 0 theVerb 6)
						else
							(gMessager say: 0 theVerb 5)
						)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
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

(instance sElementPlot1 of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(Load rsVIEW 32210)
				(if
					(!=
						(= temp0
							(switch (global112 curColIdx:)
								(22
									(element view: 32200 loop: 0 posn: 0 180)
									(global112 getPercent: 0 65)
								)
								(23
									(element view: 32200 loop: 0 posn: 0 180)
									(global112 getPercent: 66 146)
								)
								(24
									(element view: 32210 loop: 0 posn: 254 196)
									(global112 getPercent: 0 70)
								)
								(25
									(element view: 32210 loop: 0 posn: 254 196)
									(global112 getPercent: 71 188)
								)
								(26
									(element view: 32210 loop: 0 posn: 254 196)
									(global112 getPercent: 189 199)
								)
								(else -1)
							)
						)
						-1
					)
					(element setCel: temp0)
					(switch (element view:)
						(32200
							(if (< temp0 130)
								(element setCycle: CT 130 1 self)
							else
								(= state 1)
								(element setCycle: End self)
							)
						)
						(32210
							(cond
								((< temp0 70)
									(= state 3)
									(element setCycle: CT 70 1 self)
								)
								((< temp0 136)
									(= state 5)
									(element setCycle: CT 136 1 self)
								)
								((< temp0 188)
									(= state 7)
									(swatGuy
										view: 32210
										setLoop: 1
										cel: (- temp0 136)
										posn: 254 194
										init:
										setCycle: CT 188 1
									)
									(element setCycle: CT 188 1 self)
								)
								(else
									(= state 7)
									(= temp0 188)
									(= cycles 1)
								)
							)
						)
					)
					(element init:)
				else
					(gGame handsOn:)
					(self dispose:)
				)
			)
			(1
				(gSwatInterface showHandAni: 4)
				(gMessager say: 0 0 1 1) ; "Hold."
				(element setCycle: End self)
			)
			(2
				(global112 pausePath: 1)
				(gGame showCloseUp: 32207 -1 -1 self)
				(element view: 32210 loop: 0 cel: 0 posn: 254 194)
				(UpdateScreenItem element)
			)
			(3
				(while (< (global112 curColIdx:) 24)
					(global112 endColumn:)
				)
				(element
					view: 32210
					loop: 0
					cel: 0
					posn: 254 194
					setCycle: CT 70 1 self
				)
				(global112 pausePath: 0)
				(gSwatInterface showHandAni: 3)
			)
			(4
				(global112 pausePath: 1)
				(gFxSound number: 2991 loop: 1 play: self)
			)
			(5
				(SetFlag 250)
				((ScriptID 4054 0) changeMusic: 29809) ; kiplandRegion
				(gBackMusic2 number: 29810 loop: 1 play:)
				(gMessager say: 3 10 4 1) ; "Compromised! Stairwell right!"
				(global112 pausePath: 0)
				(element setCycle: CT 135 1 self)
			)
			(6
				(global112 pausePath: 1)
				(gMessager say: 0 0 2 1 self) ; "OK! This is it! This is it! Listen! I want out of here! See this, I got a ticket outta here... and I'll use it! I swear I will! I'll kill this son of a bitch! I will!"
			)
			(7
				(global112 pausePath: 0)
				(gMessager say: 0 0 2 2 self) ; "Put the gun down. Let the man go! NOW!"
				(element setCycle: CT 188 1)
				(swatGuy
					view: 32210
					setLoop: 1
					cel: 0
					posn: 254 194
					setPri: 300
					init:
					setCycle: CT 52 1
				)
			)
			(8
				(if (element cycler:)
					(-- state)
				)
				(= cycles 2)
			)
			(9
				(global112 pausePath: 1)
				(gMessager say: 0 0 2 3 self) ; "You think I'm crazy? This is my ticket outta here! He ain't going nowhere without me! Now you put your guns down! NOW! Or I'll kill this poor son of a bitch! Do it! Do it!"
			)
			(10
				(gGame handsOff:)
				(gFxSound number: 2991 loop: 1 play: self)
			)
			(11
				(gFxSound number: 51 loop: 1 play:)
				(element setCel: 189 setCycle: CT 191 1 self)
				(swatGuy setCycle: End)
			)
			(12
				(gFxSound stop: play:)
				(element setCycle: End self)
			)
			(13
				(gFxSound number: 2992 loop: 1 play: self)
			)
			(14
				(SetFlag 97)
				(SetFlag 93)
				(gEgo awardMedal: 68)
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
				(global112 pausePath: 1)
				(Load rsVIEW 6)
				(Load rsVIEW 32203)
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
				(if
					(and
						(== (global112 criticalRoom:) gCurRoomNum)
						(not (IsFlag 250))
					)
					(element view: 32203 setLoop: 0 setCel: 0 posn: 206 197)
					(UpdateScreenItem element)
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
				(if (== (global112 criticalRoom:) gCurRoomNum)
					(gGame handsOn:)
				)
				(if (not (SetFlag 250))
					(gMessager say: 0 16 10 1 self) ; "Status!"
					(if (== (global112 criticalRoom:) gCurRoomNum)
						(element setCycle: End)
					)
				else
					(= cycles 1)
				)
			)
			(7
				(if (== global108 4)
					(gMessager say: 3 10 4 1 self) ; "Compromised! Stairwell right!"
				else
					(= cycles 1)
				)
			)
			(8
				(gFxSound number: 2991 loop: 1 play: self)
			)
			(9
				(cond
					(
						(and
							(== (global112 criticalRoom:) gCurRoomNum)
							(== global108 4)
						)
						(gMessager say: 0 0 2 0 self) ; "OK! This is it! This is it! Listen! I want out of here! See this, I got a ticket outta here... and I'll use it! I swear I will! I'll kill this son of a bitch! I will!"
					)
					(
						(and
							(!= (global112 criticalRoom:) gCurRoomNum)
							(== global108 4)
						)
						(gCurRoom newRoom: 3240) ; s2_3240
					)
					(else
						(= cycles 1)
					)
				)
			)
			(10
				(if
					(and
						(== (global112 criticalRoom:) gCurRoomNum)
						(element cycler:)
					)
					(-- state)
				)
				(= cycles 1)
			)
			(11
				(self dispose:)
			)
		)
	)
)

(instance sFlashBangPlot2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(global112 pausePath: 1)
				(Load rsVIEW 6)
				(Load rsVIEW 32203)
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
				(gMessager say: 0 16 10 1 self) ; "Status!"
			)
			(7
				(if local1
					(gFxSound number: 2991 loop: 1 play: self)
				else
					(proc4_6 32208 0 111 0 0 -1 1)
				)
			)
			(8
				(SetFlag 98)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance compromisePosition of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 3 10 4 1 self) ; "Compromised! Stairwell right!"
			)
			(1
				(gFxSound number: 2992 setLoop: 0 play: self)
			)
			(2
				(gGame showCloseUp: 32201 180 66 self 1)
			)
			(3
				(SetFlag 243)
				(gCurRoom newRoom: 3240) ; s2_3240
			)
		)
	)
)

(instance cancelDynamicEntry of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(allen view: 32214 loop: 0 cel: 24 posn: 480 193 init:)
				(hector view: 32204 loop: 0 cel: 0 posn: 561 191 init:)
				(= cycles 1)
			)
			(1
				(gMessager say: 0 16 7 1 self) ; "Pup! Cancel dynamic! Enter with stealth!"
			)
			(2
				((ScriptID 4054 0) changeMusic: 29809) ; kiplandRegion
				(gBackMusic2 number: 29810 loop: 1 play:)
				(allen setCycle: CT 13 -1 self)
			)
			(3
				(allen setCycle: CT 34 1 self)
			)
			(4
				(gFxSound number: 2991 loop: 1 play:)
				(allen setCycle: CT 38 1 self)
			)
			(5
				(gFxSound play:)
				(allen setCycle: CT 41 1 self)
			)
			(6
				(gFxSound play:)
				(allen setCycle: CT 44 1 self)
			)
			(7
				(gFxSound play:)
				(allen setCycle: CT 47 1 self)
			)
			(8
				(gFxSound play:)
				(allen setCycle: End self)
			)
			(9
				(gGame handsOn:)
				(allen dispose:)
				(= seconds 5)
			)
			(10
				(gGame handsOff:)
				(proc4_6 32208 -9 117 0 0 -1 1)
			)
			(11
				(SetFlag 98)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance after3110FlashBang of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= register (== gPrevRoomNum 3110)) ; s2_3110
				(if register
					(= local1 1)
					(rhea
						view: 32205
						cel: 0
						loop: 0
						posn: 609 256
						init:
						setCycle: CT 7 1 self
					)
				else
					(= cycles 1)
				)
			)
			(1
				(if register
					(gSwatInterface showHandAni: 3)
					(rhea setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(2
				(if register
					(rhea dispose:)
				)
				(gGame handsOn:)
				(= seconds 6)
			)
			(3
				(gGame handsOff:)
				(gFxSound number: 2992 loop: 1 play:)
				(= ticks 45)
			)
			(4
				(gunShotSound number: 54 loop: 1 play: self)
			)
			(5
				(gCurRoom newRoom: 3240) ; s2_3240
			)
		)
	)
)

(instance gunShotSound of Sound
	(properties)
)

(instance element of Prop
	(properties
		x -1
		y 169
		view 32200
	)
)

(instance cannister of Prop
	(properties
		x 274
		y 225
		view 32202
	)
)

(instance allen of Prop
	(properties)
)

(instance hector of Prop
	(properties)
)

(instance rhea of Prop
	(properties)
)

(instance northE of HotSpot
	(properties
		nsRight 640
		nsBottom 50
		type 4097
	)

	(method (doVerb)
		(gCurRoom newRoom: 3250) ; s2_3250
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
		(cond
			((== global108 4)
				(if (not (gCast contains: element))
					(global112 leftEarly: 1)
				)
				(gCurRoom newRoom: 3240) ; s2_3240
			)
			(local2
				(gCurRoom newRoom: 3240) ; s2_3240
			)
			(else
				(gCurRoom newRoom: 3230) ; s2_3230
			)
		)
	)
)

(instance westE of HotSpot
	(properties
		nsRight 50
		nsBottom 360
		type 32769
	)

	(method (doVerb)
		(cond
			((== global108 4)
				(gCurRoom newRoom: 3140) ; s2_3140
			)
			(local2
				(gCurRoom newRoom: 3160) ; s2_3160
			)
			(else
				(gCurRoom newRoom: 3140) ; s2_3140
			)
		)
	)
)

(instance swatGuy of Prop
	(properties
		x 254
		y 196
		view 33210
		loop 1
	)
)

