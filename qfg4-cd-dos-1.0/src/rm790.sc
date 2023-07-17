;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 790)
(include sci.sh)
(use Main)
(use GloryRm)
(use Interface)
(use Str)
(use Print)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm790 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
)

(instance rm790 of GloryRm
	(properties
		noun 14
		picture 790
		west 800
	)

	(method (init)
		(if gDebugging
			(if (== (= local0 (GetNumber {Event #?})) 1)
				(= gPrevRoomNum 710)
			)
		else
			(= local0
				(cond
					((== gPrevRoomNum 710) 1)
					((== gPrevRoomNum 630) 2)
					(else 0)
				)
			)
		)
		(switch gPrevRoomNum
			(710
				((ScriptID 7 4) init: 4 45) ; fixTime
				(= gNight 1)
				(= gDay 1)
				(ClearFlag 373)
				(aCaveMouth setCel: 0)
				(aKatrina
					view: 792
					setLoop: 2 1
					setCel: 0
					posn: 97 181
					setPri: 190
					init:
				)
				(gEgo posn: 247 88 ignoreActors: 1)
				(= local7 0)
			)
			(630
				(Palette 2 0 255 100) ; PalIntensity
				(aKatrina view: 637 setLoop: 0 1 setCel: 0 posn: 144 135 init:)
				(gEgo setLoop: 3 1 setCel: 0 posn: 255 157)
				(vAdAvis init:)
				(= local7 8)
				(SetFlag 101)
			)
			(else
				(gEgo posn: 4 176)
			)
		)
		(= local1 0)
		(gCurRoom addObstacle: (roomPoly init: yourself:))
		(gEgo init: normalize: setScaler: Scaler 96 39 147 105)
		(super init: &rest)
		(aCaveMouth
			signal: (| (aCaveMouth signal:) $0001)
			init:
			approachVerbs: 4 ; Do
		)
		(if (and (not (gEgo has: 25)) (not (IsFlag 354))) ; theDarksign
			(vDarkOneSign init:)
		else
			(fDarkOneSign init:)
		)
		(fMouthSign init:)
		(fBoneSign init:)
		(fBloodSign init:)
		(fBreathSign init:)
		(fSenseSign init:)
		(fHeartSign init:)
		(fEssenceSign init:)
		(fCrack init:)
		(fArchway init:)
		(fIsland init:)
		(fStepStones init:)
		(fCaveMouth init:)
		(fGoo init:)
		(fMain init:)
		(fFirst init:)
		(fSecond init:)
		(fThird init:)
		(fFourth init:)
		(fFifth init:)
		(fSixth init:)
		(fSeventh init:)
		(fEight init:)
		(gKeyDownHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(gCurRoom setScript: sComeIn)
	)

	(method (handleEvent event)
		(if
			(and
				(not (event modifiers:))
				(OneOf (event type:) evKEYBOARD evMOUSEBUTTON $0020) ; joyUp
				(== ((gTheIconBar getCursor:) view:) 940)
			)
			(cond
				((and (fMain onMe: event) (!= local1 0))
					(event claimed: 1)
					(fMain doVerb: 4)
				)
				((and (fFirst onMe: event) (!= local1 1))
					(event claimed: 1)
					(fFirst doVerb: 4)
				)
				((and (fSecond onMe: event) (!= local1 2))
					(event claimed: 1)
					(fSecond doVerb: 4)
				)
				((and (fThird onMe: event) (!= local1 3))
					(event claimed: 1)
					(fThird doVerb: 4)
				)
				((and (fFourth onMe: event) (!= local1 4))
					(event claimed: 1)
					(fFourth doVerb: 4)
				)
				((and (fFifth onMe: event) (!= local1 5))
					(event claimed: 1)
					(fFifth doVerb: 4)
				)
				((and (fSixth onMe: event) (!= local1 6))
					(event claimed: 1)
					(fSixth doVerb: 4)
				)
				((and (fSeventh onMe: event) (!= local1 7))
					(event claimed: 1)
					(fSeventh doVerb: 4)
				)
				((and (fEight onMe: event) (!= local1 8))
					(event claimed: 1)
					(fEight doVerb: 4)
				)
				(else
					(event claimed: 0)
					(super handleEvent: event)
				)
			)
		else
			(super handleEvent: event)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(87 ; fetchSpell
				(gGlory handsOff:)
				(self setScript: (ScriptID 37) 0 vDarkOneSign) ; castFetchScript
			)
			(11 ; glideSpell
				(gMessager say: 0 11 0) ; "You could find better places to practice your Glide spell -- if it wears off here you'll find yourself stuck in the goo for goo'd."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(gKeyDownHandler delete: rm790)
		(gMouseDownHandler delete: rm790)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 800)
			(gLongSong fade: 0)
		)
		(super newRoom: newRoomNumber &rest)
	)
)

(instance sComeIn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(switch gPrevRoomNum
					(710
						(gCurRoom setScript: sEnterFrom710)
					)
					(630
						(gCurRoom setScript: sFrom630)
					)
					(else
						(gEgo setMotion: PolyPath 40 159 self)
					)
				)
			)
			(2
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterFrom710 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: MoveTo 229 112 self)
			)
			(1
				(aCaveMouth setCel: 0 setCycle: End self)
			)
			(2
				(= ticks 90)
			)
			(3
				(gMessager say: 2 6 8 0 self) ; "You slip through the mouth of the cave just in time to avoid being crushed by its closing "jaws." Whew!"
			)
			(4
				(if (== gHeroType 3) ; Paladin
					(gMessager say: 2 6 4 0 self) ; "As the cave mouth closes behind you, you feel a strange warning tingle. There is danger here, although its source is not immediately clear."
				else
					(self cue:)
				)
			)
			(5
				(aCaveMouth setPri: 86)
				(= local1 8)
				(= local2 1)
				(= local5 1)
				(= local7 8)
				(gEgo setScript: sDoTheMouth self)
			)
			(6
				(= local5 0)
				(gEgo normalize:)
				(= ticks 6)
			)
			(7
				(gMessager say: 1 6 1 0 self) ; "You're alive! Only one person has ever walked away from there before."
			)
			(8
				(aKatrina
					setLoop: 1 1
					setCel: 0
					setCycle: Walk
					setMotion: MoveTo -30 (aKatrina y:) self
				)
			)
			(9
				(gEgo normalize:)
				(= local1 0)
				(aKatrina dispose:)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sFrom630 of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(aKatrina setCycle: CT 5 1 self)
			)
			(2
				(aKatrina setCel: 5 setCycle: CT 0 -1 self)
			)
			(3
				(gMessager say: 1 6 2 0 self) ; "Yah, Avoozl! Hear me, Great Dark One. Open thy mouth that we may enter."
			)
			(4
				(gEgo ignoreActors: 1)
				(aCaveMouth setPri: 75 setCel: 5 setCycle: CT 0 -1 self)
			)
			(5
				(= ticks 90)
			)
			(6
				(= temp0 (Str new:))
				(= temp2 (Str new:))
				(Message msgGET 790 1 6 3 1 (temp2 data:)) ; ""That is all I can do for you,"
				(Message msgGET 790 1 6 3 2 (temp0 data:)) ; "You will need to perform the other Rituals yourself."
				(temp2 cat: (gHeroName data:))
				(temp2 cat: (temp0 data:))
				(Print addText: (temp2 data:) init:)
				(temp0 dispose:)
				(temp2 dispose:)
				(= seconds 2)
			)
			(7
				(gMessager say: 1 6 5 0 self) ; "We will be watching you, so do not even think of trying to betray us."
			)
			(8
				(= local1 2)
				(= local5 1)
				(= local7 8)
				(gEgo setScript: sDoTheMouth self)
			)
			(9
				(gEgo normalize:)
				(vAdAvis setCycle: End)
				(aKatrina setCycle: End self)
			)
			(10
				(aKatrina hide: dispose:)
				(vAdAvis hide: dispose:)
				(= ticks 30)
			)
			(11
				(gEgo setMotion: MoveTo 250 91 self)
			)
			(12
				(gEgo solvePuzzle: 452 15)
				(gCurRoom newRoom: 710)
			)
		)
	)
)

(instance sOozeFingers of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if (== local1 0)
					(gEgo setMotion: PolyPath 164 163 self)
				else
					(self cue:)
				)
			)
			(1
				(gEgo
					view: 4
					setLoop: 0 1
					setCel: 0
					posn: (- (gEgo x:) 6) (- (gEgo y:) 1)
					setCycle: End self
				)
			)
			(2
				(gMessager say: 4 4 0 0 self) ; "The icky, greasy substance oozes through your fingers. You quickly scrub your hands with dirt and sand -- even the dirt seems clean compared to this stuff!"
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo posn: (+ (gEgo x:) 6) (+ (gEgo y:) 1) normalize:)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetSomeGoo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if (== local1 0)
					(gEgo setMotion: PolyPath 164 163 self)
				else
					(self cue:)
				)
			)
			(1
				(gEgo
					view: 4
					setLoop: 0 1
					setCel: 0
					posn: (- (gEgo x:) 6) (- (gEgo y:) 1)
					setCycle: End self
				)
			)
			(2
				(gMessager say: 4 24 0 0 self) ; "You manage to fill your flask with some of the greasy, grimy goo."
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo
					use: 9 ; theFlask
					posn: (+ (gEgo x:) 6) (+ (gEgo y:) 1)
					get: 11 ; theGruegoo
					solvePuzzle: 430 6
					normalize:
				)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetTheDarkSign of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(fDarkOneSign init:)
				(SetFlag 354)
				(if (!= local1 0)
					(= local2 1)
					(= local5 1)
					(= local7 0)
					(gEgo setScript: sDoTheMouth sGetTheDarkSign)
				else
					(self cue:)
				)
			)
			(1
				(= local1 0)
				(= local5 0)
				(gEgo setMotion: PolyPath 63 169 self)
			)
			(2
				(gEgo
					view: 4
					posn: 57 168
					setLoop: 0 1
					setCel: 0
					setCycle: CT 2 1 self
				)
			)
			(3
				(gMessager say: 3 4 7 0 self) ; "The six-pointed symbol seems to pulse with energy and comes loose in your hand when you touch it. You have the feeling that you may need this "sign," so you carefully store it in your pack."
			)
			(4
				(gEgo setCel: 2 setCycle: CT 0 -1 self)
			)
			(5
				(gEgo get: 25 solvePuzzle: 404 6 normalize:) ; theDarksign
				(vDarkOneSign hide: dispose:)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLookAtThings of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== local1 0)
					(self cue:)
				else
					(= local2 1)
					(= local5 1)
					(= local7 0)
					(self setScript: sDoTheMouth self)
				)
			)
			(1
				(= local5 0)
				(gEgo setMotion: PolyPath 42 155 self)
			)
			(2
				(Face gEgo 249 111 self)
			)
			(3
				(switch local8
					(0
						(gMessager say: 6 1 0 0 self) ; "This symbol looks like a mouth with pursed lips."
					)
					(1
						(gMessager say: 7 1 0 0 self) ; "This symbol is a stylized representation of a crossed pair of bones."
					)
					(2
						(gMessager say: 8 1 0 0 self) ; "This is the symbol of Blood in the form of a huge, carved droplet."
					)
					(3
						(gMessager say: 9 1 0 0 self) ; "The cloud symbol is a traditional representation of "Breath.""
					)
					(4
						(gMessager say: 10 1 0 0 self) ; "This strange symbol is the traditional magic representation of "the senses.""
					)
					(5
						(gMessager say: 11 1 0 0 self) ; "This looks like a throbbing heart."
					)
					(6
						(gMessager say: 12 1 0 0 self) ; "This symbol is really abstract. You may have seen it once before, described in an ancient book as the sign of "Essence" or one's inner nature."
					)
					(7
						(gMessager say: 3 4 0 0 self) ; "Now that you've taken the physical Dark One Sign, there is no trace that it was ever there."
					)
				)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDoTheMouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= local3 (gEgo moveSpeed:))
				(= local4 (gEgo cycleSpeed:))
				(switch local1
					(0
						(if (or (!= (gEgo x:) 174) (!= (gEgo y:) 162))
							(gEgo setMotion: PolyPath 174 162 self)
						else
							(self cue:)
						)
					)
					(4
						(cond
							(local2
								(if
									(or
										(!= (gEgo x:) 200)
										(!= (gEgo y:) 145)
									)
									(gEgo setMotion: PolyPath 200 145 self)
								else
									(self cue:)
								)
							)
							((or (!= (gEgo x:) 183) (!= (gEgo y:) 131))
								(gEgo setMotion: PolyPath 183 131 self)
							)
							(else
								(self cue:)
							)
						)
					)
					(8
						(if (or (!= (gEgo x:) 223) (!= (gEgo y:) 111))
							(gEgo setMotion: MoveTo 223 111 self)
						else
							(self cue:)
						)
					)
					(else
						(self cue:)
					)
				)
			)
			(1
				(gEgo cycleSpeed: 8 moveSpeed: 8)
				((gCurRoom obstacles:) dispose:)
				(gCurRoom obstacles: 0)
				(= ticks 6)
			)
			(2
				(= ticks 12)
			)
			(3
				(switch local1
					(0
						(gEgo changeGait: 1 setMotion: MoveTo 212 162 self) ; running
						(= local1 1)
					)
					(1
						(if local2
							(gEgo
								changeGait: 1 ; running
								setMotion: MoveTo 164 163 self
							)
							(= local1 0)
						else
							(gEgo
								changeGait: 1 ; running
								setMotion: MoveTo 251 156 self
							)
							(= local1 2)
						)
					)
					(2
						(if local2
							(gEgo
								changeGait: 1 ; running
								setMotion: MoveTo 212 163 self
							)
							(= local1 1)
						else
							(gEgo
								changeGait: 1 ; running
								setMotion: MoveTo 235 146 self
							)
							(= local1 3)
						)
					)
					(3
						(if local2
							(gEgo
								changeGait: 1 ; running
								setMotion: MoveTo 251 156 self
							)
							(= local1 2)
						else
							(gEgo
								changeGait: 1 ; running
								setMotion: MoveTo 200 145 self
							)
							(= local1 4)
						)
					)
					(4
						(if local2
							(gEgo
								changeGait: 1 ; running
								setMotion: MoveTo 235 146 self
							)
							(= local1 3)
						else
							(gEgo
								changeGait: 1 ; running
								setMotion: MoveTo 196 122 self
							)
							(= local1 5)
						)
					)
					(5
						(if local2
							(= local1 4)
							(gEgo
								changeGait: 1 ; running
								setMotion: MoveTo 210 128 self
							)
						else
							(gEgo
								changeGait: 1 ; running
								setMotion: MoveTo 210 118 self
							)
							(= local1 6)
						)
					)
					(6
						(if local2
							(= local1 5)
							(gEgo
								changeGait: 1 ; running
								setMotion: MoveTo 196 122 self
							)
						else
							(gEgo
								changeGait: 1 ; running
								setMotion: MoveTo 200 115 self
							)
							(= local1 7)
						)
					)
					(7
						(if local2
							(= local1 6)
							(gEgo
								changeGait: 1 ; running
								setMotion: MoveTo 210 118 self
							)
						else
							(= local1 8)
							(gEgo
								changeGait: 1 ; running
								setMotion: MoveTo 223 111 self
							)
						)
					)
					(8
						(gEgo changeGait: 1 setMotion: MoveTo 200 115 self) ; running
						(= local1 7)
					)
				)
			)
			(4
				(switch (gEgo loop:)
					(6
						(gEgo changeGait: 0 normalize: 4) ; walking
					)
					(7
						(gEgo changeGait: 0 normalize: 5) ; walking
					)
					(8
						(gEgo changeGait: 0 normalize: 6) ; walking
					)
					(9
						(gEgo changeGait: 0 normalize: 7) ; walking
					)
				)
				(if (== local1 4)
					(if local2
						(gEgo setMotion: MoveTo 200 145 self)
					else
						(gEgo setMotion: MoveTo 183 131 self)
					)
				else
					(= seconds 1)
				)
			)
			(5
				(cond
					((== local1 local7)
						(self cue:)
					)
					((and (== local1 8) (not local2))
						(self cue:)
					)
					((and (== local1 0) local2)
						(self cue:)
					)
					(else
						(self changeState: 2)
					)
				)
			)
			(6
				(switch local1
					(0
						(gCurRoom addObstacle: (roomPoly init: yourself:))
					)
					(1
						(gCurRoom addObstacle: (firstPoly init: yourself:))
					)
					(2
						(gCurRoom addObstacle: (secondPoly init: yourself:))
					)
					(3
						(gCurRoom addObstacle: (thirdPoly init: yourself:))
					)
					(4
						(gCurRoom addObstacle: (fourthPoly init: yourself:))
					)
					(5
						(gCurRoom addObstacle: (fifthPoly init: yourself:))
					)
					(6
						(gCurRoom addObstacle: (sixthPoly init: yourself:))
					)
					(7
						(gCurRoom addObstacle: (seventhPoly init: yourself:))
					)
					(8
						(gCurRoom addObstacle: (eightPoly init: yourself:))
					)
				)
				(self cue:)
			)
			(7
				(if local6
					(gMessager say: 5 4 0 0 self) ; "You apply all your strength to the "jaws" of the cave "mouth." You can't even get them to budge -- you suspect they are magically sealed."
				else
					(self cue:)
				)
			)
			(8
				(= local6 0)
				(= local2 0)
				(gEgo changeGait: 0 moveSpeed: local3 cycleSpeed: local4) ; walking
				(if (not local5)
					(gGlory handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance aKatrina of Actor
	(properties
		noun 1
		x 11
		y 162
		priority 86
		fixPriority 1
		view 792
		cel 6
		scaleSignal 1
	)

	(method (init)
		(super init: &rest)
		(self origStep: 1027 setScaler: Scaler 96 39 147 105)
	)
)

(instance aCaveMouth of Prop
	(properties
		noun 5
		x 251
		y 110
		priority 86
		fixPriority 1
		view 790
		cel 7
	)

	(method (doVerb theVerb)
		(switch theVerb
			(80 ; openSpell
				(gEgo trySkill: 20) ; openSpell
				(= global441 ((User curEvent:) x:))
				(= global442 ((User curEvent:) y:))
				(gCurRoom setScript: (ScriptID 13) 0 self) ; castOpenScript
			)
			(-80 ; openSpell (part 2)
				(gGlory handsOn:)
				(gCurRoom setScript: 0)
				(gMessager say: 5 80 0 0) ; "Your Open spell has no effect whatsoever on the cave mouth. It is evidently sealed with a vast and powerful magic."
			)
			(4 ; Do
				(if (!= local1 8)
					(= local7 8)
					(= local6 1)
					(gCurRoom setScript: sDoTheMouth)
				else
					(gMessager say: 5 4 0 0) ; "You apply all your strength to the "jaws" of the cave "mouth." You can't even get them to budge -- you suspect they are magically sealed."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance vAdAvis of Prop
	(properties
		x 113
		y 117
		view 677
		loop 2
		scaleSignal 1
	)

	(method (init)
		(super init: &rest)
		(self setScaler: Scaler 96 39 147 105)
	)
)

(instance vDarkOneSign of View
	(properties
		noun 3
		sightAngle 180
		x 76
		y 254
		z 100
		priority 159
		fixPriority 1
		view 790
		loop 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(= local7 0)
				(gCurRoom setScript: sGetTheDarkSign)
			)
			(87 ; fetchSpell
				(gCurRoom doVerb: theVerb)
			)
			(-87 ; fetchSpell (part 2)
				(gEgo get: 25) ; theDarksign
				(fDarkOneSign init:)
				(vDarkOneSign dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fMouthSign of Feature
	(properties
		noun 6
		nsLeft 68
		nsTop 112
		nsRight 86
		nsBottom 128
		sightAngle 180
		x 77
		y 120
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(= local8 0)
			(gCurRoom setScript: sLookAtThings)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fBoneSign of Feature
	(properties
		noun 7
		nsLeft 63
		nsTop 86
		nsRight 77
		nsBottom 100
		sightAngle 180
		x 70
		y 93
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(= local8 1)
			(gCurRoom setScript: sLookAtThings)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fBloodSign of Feature
	(properties
		noun 8
		nsLeft 54
		nsTop 65
		nsRight 70
		nsBottom 76
		sightAngle 180
		x 62
		y 70
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(= local8 2)
			(gCurRoom setScript: sLookAtThings)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fBreathSign of Feature
	(properties
		noun 9
		nsLeft 46
		nsTop 48
		nsRight 58
		nsBottom 59
		sightAngle 180
		x 52
		y 53
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(= local8 3)
			(gCurRoom setScript: sLookAtThings)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fSenseSign of Feature
	(properties
		noun 10
		nsLeft 29
		nsTop 55
		nsRight 39
		nsBottom 66
		sightAngle 180
		x 34
		y 60
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(= local8 4)
			(gCurRoom setScript: sLookAtThings)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fHeartSign of Feature
	(properties
		noun 11
		nsLeft 23
		nsTop 68
		nsRight 37
		nsBottom 81
		sightAngle 180
		x 30
		y 74
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(= local8 5)
			(gCurRoom setScript: sLookAtThings)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fEssenceSign of Feature
	(properties
		noun 12
		nsLeft 19
		nsTop 86
		nsRight 33
		nsBottom 100
		sightAngle 180
		x 26
		y 93
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(= local8 6)
			(gCurRoom setScript: sLookAtThings)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fDarkOneSign of Feature
	(properties
		noun 3
		nsLeft 71
		nsTop 136
		nsRight 92
		nsBottom 157
		sightAngle 180
		x 71
		y 236
		z 100
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(= local8 7)
			(gCurRoom setScript: sLookAtThings)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fCrack of Feature
	(properties
		noun 13
		nsLeft 19
		nsTop 101
		nsRight 36
		nsBottom 118
		sightAngle 180
		x 27
		y 109
	)
)

(instance fArchway of Feature
	(properties
		noun 16
		nsLeft 15
		nsTop 32
		nsRight 109
		nsBottom 156
		sightAngle 180
		x 62
		y 32
	)

	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:)
				init: 13 113 22 76 32 54 37 51 37 38 45 32 58 31 75 46 78 53 87 60 98 97 110 156 92 161 66 155 67 107 61 83 50 65 46 85 47 103 55 116 49 123 33 122
				yourself:
			)
		)
	)
)

(instance fIsland of Feature
	(properties
		noun 14
		nsLeft 134
		nsTop 116
		nsRight 238
		nsBottom 156
		sightAngle 180
		x 186
		y 244
		z 112
	)

	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 133 133 161 125 229 124 241 130 237 137 210 141 213 149 204 152 187 152 159 147
				yourself:
			)
		)
	)
)

(instance fStepStones of Feature
	(properties
		noun 15
		nsLeft 187
		nsTop 140
		nsRight 269
		nsBottom 175
		sightAngle 180
		x 228
		y 157
	)

	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 190 159 208 156 224 158 215 143 222 139 237 139 249 144 269 153 268 163 239 163 229 172 199 174
				yourself:
			)
		)
	)
)

(instance fCaveMouth of Feature
	(properties
		noun 5
		nsLeft 215
		nsTop 50
		nsRight 270
		nsBottom 109
		sightAngle 180
		x 242
		y 79
	)

	(method (doVerb theVerb)
		(switch theVerb
			(80 ; openSpell
				(gEgo trySkill: 20) ; openSpell
				(= global441 ((User curEvent:) x:))
				(= global442 ((User curEvent:) y:))
				(gCurRoom setScript: (ScriptID 13) 0 self) ; castOpenScript
			)
			(-80 ; openSpell (part 2)
				(gGlory handsOn:)
				(gCurRoom setScript: 0)
				(gMessager say: 5 80 0 0) ; "Your Open spell has no effect whatsoever on the cave mouth. It is evidently sealed with a vast and powerful magic."
			)
			(4 ; Do
				(if (!= local1 8)
					(= local6 1)
					(= local7 8)
					(gCurRoom setScript: sDoTheMouth)
				else
					(gMessager say: 5 4 0 0) ; "You apply all your strength to the "jaws" of the cave "mouth." You can't even get them to budge -- you suspect they are magically sealed."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fGoo of Feature
	(properties
		noun 4
		nsTop 91
		nsRight 269
		nsBottom 189
		sightAngle 180
		x 228
		y 157
		z 91
	)

	(method (doVerb theVerb)
		(switch theVerb
			(24 ; theFlask
				(gCurRoom setScript: sGetSomeGoo)
			)
			(4 ; Do
				(gCurRoom setScript: sOozeFingers)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 0 133 68 133 122 129 131 118 103 108 96 92 150 91 140 107 180 114 241 118 276 101 300 107 271 134 271 143 319 147 319 189 188 189 153 181 187 160 115 152 58 144 1 144
				yourself:
			)
		)
	)
)

(instance fMain of Feature
	(properties
		noun 14
		nsTop 148
		nsRight 174
		nsBottom 189
		sightAngle 180
		y 250
		z 104
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(= local7 0)
			(switch local1
				(0 0)
				(else
					(= local2 1)
					(gCurRoom setScript: sDoTheMouth)
				)
			)
		else
			(super doVerb: theVerb)
		)
	)

	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 0 143 29 144 32 149 182 159 180 167 154 172 148 183 187 188 0 189
				yourself:
			)
		)
	)
)

(instance fFirst of Feature
	(properties
		noun 15
		nsLeft 196
		nsTop 159
		nsRight 215
		nsBottom 163
		sightAngle 180
		x 196
		y 260
		z 100
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(= local7 1)
			(if (!= local1 1)
				(if (> local1 1)
					(= local2 1)
				else
					(= local2 0)
				)
				(gCurRoom setScript: sDoTheMouth)
			)
		else
			(super doVerb: theVerb)
		)
	)

	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 206 156 210 157 230 161 229 173 201 175 194 170 190 159
				yourself:
			)
		)
	)
)

(instance fSecond of Feature
	(properties
		noun 15
		nsLeft 232
		nsTop 152
		nsRight 263
		nsBottom 155
		sightAngle 319
		x 232
		y 253
		z 100
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(= local7 2)
			(if (!= local1 2)
				(if (> local1 2)
					(= local2 1)
				else
					(= local2 0)
				)
				(gCurRoom setScript: sDoTheMouth)
			)
		else
			(super doVerb: theVerb)
		)
	)

	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 228 153 236 149 254 149 268 152 270 156 268 159 268 163 235 163
				yourself:
			)
		)
	)
)

(instance fThird of Feature
	(properties
		noun 15
		nsLeft 220
		nsTop 142
		nsRight 246
		nsBottom 145
		sightAngle 180
		x 220
		y 252
		z 110
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(= local7 3)
			(if (!= local1 3)
				(if (> local1 3)
					(= local2 1)
				else
					(= local2 0)
				)
				(gCurRoom setScript: sDoTheMouth)
			)
		else
			(super doVerb: theVerb)
		)
	)

	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 237 140 248 144 248 149 235 149 228 152 220 151 216 147 217 141
				yourself:
			)
		)
	)
)

(instance fFourth of Feature
	(properties
		noun 14
		nsLeft 151
		nsTop 127
		nsRight 224
		nsBottom 143
		sightAngle 180
		x 151
		y 254
		z 120
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(= local7 4)
			(if (!= local1 4)
				(if (> local1 4)
					(= local2 1)
				else
					(= local2 0)
				)
				(gCurRoom setScript: sDoTheMouth)
			)
		else
			(super doVerb: theVerb)
		)
	)

	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 133 132 150 128 150 125 226 124 237 127 237 133 237 140 216 142 213 147 206 153 188 153 133 136
				yourself:
			)
		)
	)
)

(instance fFifth of Feature
	(properties
		noun 15
		nsLeft 187
		nsTop 121
		nsRight 207
		nsBottom 123
		sightAngle 180
		x 187
		y 251
		z 130
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(= local7 5)
			(if (!= local1 5)
				(if (> local1 5)
					(= local2 1)
				else
					(= local2 0)
				)
				(gCurRoom setScript: sDoTheMouth)
			)
		else
			(super doVerb: theVerb)
		)
	)

	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 187 124 183 122 189 119 201 119 208 121 208 123
				yourself:
			)
		)
	)
)

(instance fSixth of Feature
	(properties
		noun 15
		nsLeft 202
		nsTop 117
		nsRight 209
		nsBottom 119
		sightAngle 180
		x 202
		y 267
		z 150
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(= local7 6)
			(if (!= local1 6)
				(if (> local1 6)
					(= local2 1)
				else
					(= local2 0)
				)
				(gCurRoom setScript: sDoTheMouth)
			)
		else
			(super doVerb: theVerb)
		)
	)

	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 200 118 200 116 206 115 216 115 218 119 213 120 208 122
				yourself:
			)
		)
	)
)

(instance fSeventh of Feature
	(properties
		noun 15
		nsLeft 192
		nsTop 112
		nsRight 204
		nsBottom 115
		sightAngle 180
		x 192
		y 263
		z 150
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(= local7 7)
			(if (!= local1 7)
				(if (> local1 7)
					(= local2 1)
				else
					(= local2 0)
				)
				(gCurRoom setScript: sDoTheMouth)
			)
		else
			(super doVerb: theVerb)
		)
	)

	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 200 117 191 117 189 114 193 112 202 112 209 114
				yourself:
			)
		)
	)
)

(instance fEight of Feature
	(properties
		noun 15
		nsLeft 202
		nsTop 105
		nsRight 248
		nsBottom 114
		sightAngle 180
		x 202
		y 258
		z 150
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(= local7 8)
			(if (!= local1 8)
				(= local2 0)
				(gCurRoom setScript: sDoTheMouth)
			)
		else
			(super doVerb: theVerb)
		)
	)

	(method (init)
		(super init: &rest)
		(= onMeCheck
			((Polygon new:)
				type: PTotalAccess
				init: 196 109 215 100 256 106 249 113 217 115 208 111 197 110
				yourself:
			)
		)
	)
)

(instance roomPoly of Polygon
	(properties
		type PBarredAccess
	)

	(method (init)
		(super
			init: 0 150 0 0 319 0 319 189 159 189 130 184 138 172 134 165 169 162 168 160 115 158 113 166 84 169 66 166 53 153 17 153 17 146 7 146
		)
	)
)

(instance firstPoly of Polygon
	(properties
		type PContainedAccess
	)

	(method (init)
		(super init: 196 160 203 163 215 162 226 161 208 159)
	)
)

(instance secondPoly of Polygon
	(properties
		type PContainedAccess
	)

	(method (init)
		(super init: 232 153 241 155 258 155 263 154 253 152)
	)
)

(instance thirdPoly of Polygon
	(properties
		type PContainedAccess
	)

	(method (init)
		(super init: 220 142 227 145 237 145 246 144 235 142 221 142)
	)
)

(instance fourthPoly of Polygon
	(properties
		type PContainedAccess
	)

	(method (init)
		(super
			init: 141 134 184 144 209 147 205 138 233 135 226 129 224 127 169 128
		)
	)
)

(instance fifthPoly of Polygon
	(properties
		type PContainedAccess
	)

	(method (init)
		(super init: 187 121 195 123 207 121)
	)
)

(instance sixthPoly of Polygon
	(properties
		type PContainedAccess
	)

	(method (init)
		(super init: 202 117 209 119 215 117)
	)
)

(instance seventhPoly of Polygon
	(properties
		type PContainedAccess
	)

	(method (init)
		(super init: 192 113 194 115 204 114 200 112)
	)
)

(instance eightPoly of Polygon
	(properties
		type PContainedAccess
	)

	(method (init)
		(super
			init: 202 108 209 110 215 112 232 114 248 111 245 106 221 107 213 105
		)
	)
)

