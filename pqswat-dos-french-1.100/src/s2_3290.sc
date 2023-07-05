;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 3290)
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
	s2_3290 0
)

(local
	local0
	local1 = 1
)

(instance s2_3290 of PQRoom
	(properties
		picture 3290
	)

	(method (init)
		(super init: &rest)
		(if (== global108 4)
			(cond
				((== gPrevRoomNum 3250) ; s2_3250
					(cond
						((< (global112 curColIdx:) 25)
							(Load rsVIEW 32905)
							(Load rsVIEW 32907)
							(gGame handsOn:)
							(westE init:)
						)
						((IsFlag 225)
							(gCurRoom setScript: sTwoDown)
						)
						(else
							(Load rsVIEW 32900)
							(Load rsVIEW 32901)
							(Load rsAUDIO 2991)
							(self setScript: sEncounterWithAllen)
						)
					)
				)
				((== gPrevRoomNum 3270) ; s2_3270
					(Load rsVIEW 32900)
					(Load rsVIEW 32901)
					(Load rsAUDIO 2991)
					(self setScript: sEncounterWithAllen)
				)
				(else
					(gGame handsOn:)
				)
			)
		else
			(stairWellE init:)
			(robotFeat init:)
			(if (== (global112 criticalRoom:) gCurRoomNum)
				(self setScript: elementPlot2)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10
				(if local1
					(= local1 0)
					(gMessager say: 1 theVerb 8) ; "Hold your fire!"
				else
					(self setScript: sSecondTime)
				)
			)
			(6
				(if local1
					(= local1 0)
					(gMessager say: 1 theVerb 8) ; "Hold your fire!"
				else
					(self setScript: sSecondTime)
				)
			)
			(16
				(if (== global108 4)
					(if (< (global112 curColIdx:) 25)
						(self setScript: sFlashWhileAlone)
					else
						(self setScript: sFlashBang)
					)
				else
					(self setScript: sFlashBangPlot2)
				)
			)
			(else
				(if (and (== global108 5) (>= (global112 curColIdx:) 17))
					(cond
						((== theVerb 14)
							(super doVerb: theVerb)
						)
						((== theVerb 16)
							(gMessager say: 0 theVerb 10) ; "Compromised!"
						)
						((OneOf theVerb 43 47 44 45 46 42 49 48)
							(gMessager say: 0 theVerb 12)
						)
						(else
							(super doVerb: theVerb)
						)
					)
				else
					(super doVerb: theVerb)
				)
			)
		)
	)

	(method (criticalAlert)
		(if (and (not script) (== global108 4) (== (global112 curColIdx:) 25))
			(westE dispose:)
			((ScriptID 4054 0) changeMusic: 29809) ; kiplandRegion
			(gBackMusic2 number: 29810 loop: 1 play:)
			(self setScript: enterFromStairs)
		)
		(if (and (not script) (== global108 5) (== (global112 curColIdx:) 15))
			(self setScript: elementPlot2)
		)
	)

	(method (dispose)
		(proc4_5)
		(super dispose:)
	)
)

(instance sSecondTime of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 1 6 9 0 self) ; "You're outta here, pup! Officer coming out!"
			)
			(1
				(SetFlag 98)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance sEncounterWithAllen of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOn:)
				(switch (global112 curColIdx:)
					(25
						(allen init:)
						(hector init:)
						(self setScript: allenDanceWithHector self)
						(= temp0
							(cond
								((<= (global112 getPercent:) 33) 1)
								((<= (global112 getPercent:) 66) 2)
								(else 3)
							)
						)
						(gMessager sayRange: 0 0 1 temp0 3 self)
					)
					(else
						(self dispose:)
					)
				)
			)
			(1
				(if script
					(script cue:)
				else
					(= cycles 1)
				)
			)
			(2
				(gGame handsOff:)
				(hector dispose:)
				(allen cycleSpeed: 12 cel: 187 setCycle: CT 101 1 self)
			)
			(3
				(gFxSound number: 2991 loop: 0 play:)
				(allen cel: 102 setCycle: CT 105 1 self)
			)
			(4
				(gFxSound number: 54 loop: 1 play:)
				(allen setCycle: End self)
			)
			(5
				(SetFlag 93)
				(SetFlag 97)
				(gEgo awardMedal: 68)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance allenDanceWithHector of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(allen cycleSpeed: 12 cel: 0 setCycle: ROsc -1 0 92)
				(hector cycleSpeed: 12 cel: 0 setCycle: ROsc -1 0 92)
			)
			(1
				(allen setCycle: CT 93 1)
				(hector setCycle: End self)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance enterFromStairs of Script
	(properties)

	(method (init)
		(= register 0)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(hector
					view: 32905
					loop: 0
					cel: 0
					setPri: 10
					posn: 454 255
					init:
				)
				(if (not register)
					(= cycles 1)
				)
			)
			(1
				(hector cycleSpeed: 12 setCycle: CT 14 1 self)
			)
			(2
				(gGame handsOn:)
				(hector setPri: -1 setCel: 15 setCycle: ROsc -1 15 99)
				(allen
					cycleSpeed: 12
					view: 32907
					loop: 0
					cel: 30
					posn: 454 255
					init:
					setCycle: ROsc -1 15 99
				)
				(gMessager say: 0 0 1 0 self) ; "OK! This is it! This is it! Listen! I want out of here! See this, I got a ticket outta here... and I'll use it! I swear I will! I'll kill this son of a bitch! I will!"
			)
			(3
				(hector setCycle: CT 100 1 self)
				(allen setCycle: CT 100 1 self)
			)
			(4
				(gGame handsOff:)
				(hector setCycle: CT 101 1 self)
				(allen setCycle: End self)
			)
			(5
				(gFxSound number: 2991 loop: 1 play:)
				(hector setCycle: CT 109 1 self)
			)
			(6
				(gFxSound number: 54 loop: 1 play:)
				(hector setCycle: End self)
			)
			(7
				(SetFlag 98)
				(if (not register)
					(gEgo awardMedal: 68)
					((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
					(gCurRoom newRoom: 35) ; metroExt
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance sTwoDown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(allen view: 32903 loop: 0 cel: 0 posn: 285 320 init:)
				(= cycles 5)
			)
			(1
				(rhea init: setCycle: End self)
				(gMessager say: 0 0 2 0) ; "Pacmeyer to Ten David - Two down! Suspects in control!"
			)
			(2
				(SetFlag 93)
				(SetFlag 98)
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
				(if (not (gTalkers isEmpty:))
					(gMessager cue: 1)
				)
				(if (IsFlag 93)
					(gGame showCloseUp: 32907 -1 -1 self 1)
				else
					(gGame showCloseUp: 32901 -1 -1 self 1)
				)
			)
			(1
				((ScriptID 4054 0) changeMusic: 0) ; kiplandRegion
				(gBackMusic stop:)
				(gFxSound number: 3450 loop: 1 play: self)
			)
			(2
				(gBackMusic number: 29808 loop: 1 play: self)
			)
			(3
				(if (IsFlag 93)
					(SetFlag 98)
					(gEgo awardMedal: 64)
					((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				else
					(gEgo awardMedal: 66)
					(SetFlag 102)
					(SetFlag 99)
					(SetFlag 18)
					(SetFlag 89)
					((ScriptID 4054 0) changeMusic: 6006) ; kiplandRegion
				)
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
				(if (not (gTalkers isEmpty:))
					(gTalkers eachElementDo: #dispose)
				)
				(proc4_5)
				(gGame showCloseUp: 32902 -1 -1 self 1)
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

(instance sFlashWhileAlone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 6)
				(cannister init: setCycle: End self)
			)
			(1
				(gFxSound number: 1002 loop: 1 play:)
				(cannister view: 6 loop: 0 cel: 0 posn: 289 179)
				(self setScript: enterFromStairs self 1)
				(UpdateScreenItem cannister)
			)
			(2
				(Palette 2 42 254 500) ; PalIntensity
				(FrameOut)
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
				(if script
					(script cue:)
				)
			)
			(6
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
				(Load rsVIEW 32906)
				(cannister init: setPri: 280 setCycle: End self)
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
				(allen
					cycleSpeed: 12
					view: 32906
					setLoop: 1
					setCel: 0
					posn: 321 307
					setCycle: 0
					setPri: 310
				)
				(SetFlag 93)
				(hector
					view: 32906
					setLoop: 0
					setCel: 0
					posn: 321 307
					setCycle: 0
					setPri: 300
				)
				(UpdateScreenItem allen)
				(UpdateScreenItem hector)
				(= cycles 2)
			)
			(2
				(Palette 2 42 254 500) ; PalIntensity
				(cannister dispose:)
				(FrameOut)
				(gunShot number: 2991 loop: 1 play:)
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
				(gGame handsOn:)
				(allen setCycle: CT 50 1 self)
				(gMessager say: 0 16 4) ; "Shit! Look what you made me do! Oh Shit! God... Shit! Lemme outta here!!"
			)
			(6
				(allen setCycle: ROsc -1 50 77)
				(= seconds 25)
			)
			(7
				(if (not (gTalkers isEmpty:))
					(-- state)
				)
				(= cycles 1)
			)
			(8
				(gGame handsOff:)
				(allen setCycle: CT 82 1 self)
			)
			(9
				(gFxSound number: 2991 loop: 1 play:)
				(allen setCycle: CT 83 1 self)
			)
			(10
				(gunShot number: 54 loop: 1 play:)
				(allen setCycle: End self)
			)
			(11
				(SetFlag 98)
				(SetFlag 95)
				(gEgo awardMedal: 68)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance elementPlot2 of Script
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
				(= temp0
					(switch (global112 curColIdx:)
						(15
							(global112 getPercent: 0 101)
						)
						(16
							(global112 endColumn:)
							(global112 getPercent: 102 150)
						)
						(17
							(global112 getPercent: 151 383)
						)
						(else -1)
					)
				)
				(gGame handsOn:)
				(if (!= temp0 -1)
					(proc4_6 32908 144 41 temp0 0 -1 1)
				else
					(self dispose:)
				)
			)
			(1
				(-- state)
				(switch scratch
					(-1
						(gGame handsOff:)
						(++ state)
						(Palette 2 42 254 0) ; PalIntensity
						(FrameOut)
						(= cycles 1)
					)
					(1
						(while (< (global112 curColIdx:) 17)
							(global112 endColumn:)
						)
					)
					(2
						(gSwatInterface showHandAni: 4)
					)
					(3
						(= local0 1)
					)
				)
			)
			(2
				(gGame handsOff:)
				(Palette 2 42 254 0) ; PalIntensity
				(FrameOut)
				(= seconds 3)
			)
			(3
				(gFxSound number: 2993 loop: 1 play: self)
			)
			(4
				(SetFlag 98)
				(gCurRoom newRoom: 35) ; metroExt
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
				(Load rsVIEW 6)
				(Load rsAUDIO 1002)
				(cannister view: 32919 posn: 479 299 init: setCycle: End self)
			)
			(1
				(gFxSound number: 1002 loop: 1 play:)
				(cannister view: 6 loop: 0 cel: 0 posn: 289 179 setPri: 600)
				(UpdateScreenItem cannister)
				(if (not local0)
					(proc4_5)
					(cond
						((== (global112 curColIdx:) 15)
							(= global128 32909)
							(WalkieTalkie showFrame: 32909 240 70)
						)
						((>= (global112 curColIdx:) 16)
							(= global128 32910)
							(WalkieTalkie showFrame: 32910 136 43)
						)
					)
				)
				(= cycles 1)
			)
			(2
				(Palette 2 42 254 500) ; PalIntensity
				(FrameOut)
				(cannister dispose:)
				(= cycles 1)
			)
			(3
				(if local0
					(Palette 2 42 254 0) ; PalIntensity
					(FrameOut)
					(= cycles 1)
				else
					(Palette 2 42 254 250) ; PalIntensity
					(FrameOut)
					(= cycles 1)
				)
			)
			(4
				(if local0
					(gMessager say: 0 16 11 0 self) ; "Officer coming out! Get outta here, pup!"
				else
					(Palette 2 42 254 150) ; PalIntensity
					(FrameOut)
					(= cycles 1)
				)
			)
			(5
				(if local0
					(SetFlag 98)
					((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
					(gCurRoom newRoom: 35) ; metroExt
				else
					(Palette 2 42 254 100) ; PalIntensity
					(FrameOut)
					(switch global128
						(32909
							(proc4_5)
							(proc4_6 32909 240 70 0 0 -1 1)
						)
						(32910
							(proc4_5)
							(proc4_6 32910 136 43 0 0 -1 1)
						)
					)
				)
			)
			(6
				(switch global128
					(32910
						(SetFlag 98)
						(gCurRoom newRoom: 3010) ; s2_3010
					)
					(else
						(gGame handsOn:)
					)
				)
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
				(gMessager say: 3 10 0 0 self) ; "Cease fire! Cease fire!"
			)
			(2
				(SetFlag 98)
				(SetFlag 94)
				(SetFlag 100)
				((ScriptID 4054 0) changeMusic: 6007) ; kiplandRegion
				(gCurRoom newRoom: 35) ; metroExt
			)
		)
	)
)

(instance allen of Actor
	(properties
		x 371
		y 290
		view 32900
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
	(properties
		x 371
		y 290
		view 32901
	)

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

(instance rhea of Actor
	(properties
		x 602
		y 110
		view 32903
		loop 1
	)
)

(instance cannister of Prop
	(properties
		x 442
		y 331
		view 32904
	)
)

(instance westE of HotSpot
	(properties
		nsRight 50
		nsBottom 360
		type 32769
	)

	(method (doVerb)
		(gCurRoom newRoom: 3250) ; s2_3250
	)
)

(instance stairWellE of HotSpot
	(properties
		type 16385
	)

	(method (init)
		(super init: &rest)
		(self
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 386 172 442 160 512 161 513 221 480 255 390 246
					yourself:
				)
		)
	)

	(method (doVerb)
		(if local0
			(gCurRoom newRoom: 3300) ; s2_3300
		else
			(gCurRoom newRoom: 3320) ; s2_3320
		)
	)
)

(instance gunShot of Sound
	(properties
		flags 5
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

