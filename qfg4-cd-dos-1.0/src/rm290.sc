;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 290)
(include sci.sh)
(use Main)
(use GloryRm)
(use DistObj)
(use Teller)
(use Interface)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use StopWalk)
(use Rev)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm290 0
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
	local9
)

(instance rm290 of GloryRm
	(properties
		noun 2
		picture 290
		horizon 84
		south 563
		topX 184
		bottomX 125
	)

	(method (init)
		(gGlory handsOff:)
		(Load rsSCRIPT 64969)
		(if gDebugging
			(= local2 (GetNumber {Event #?}))
			(if (OneOf local2 1 2 3 4)
				(= gNight 1)
				(= local9 1)
				(if (== local2 3)
					(SetFlag 80)
					(= gPrevRoomNum 563)
				)
				(if (== local2 4)
					(SetFlag 81)
				)
			)
		else
			(= local2
				(cond
					(
						(and
							(not gNight)
							(== gPrevRoomNum 563)
							(or (IsFlag 39) (IsFlag 40))
							(not (IsFlag 310))
						)
						5
					)
					(
						(and
							gNight
							(not (IsFlag 79))
							(> gDay 2)
							(not (IsFlag 115))
						)
						1
					)
					((and gNight (== gPrevRoomNum 563) (IsFlag 81)) 4)
					((and gNight (IsFlag 80) (== gPrevRoomNum 563)) 3)
					(
						(and
							gNight
							(IsFlag 79)
							(not (IsFlag 82))
							(>= gDay (+ gPrevKatrinaDayNumber 3))
							(not (IsFlag 115))
							(IsFlag 399)
						)
						2
					)
					(else 0)
				)
			)
		)
		(gEgo
			view:
				(if (and (or (== local2 3) (== local2 4)) (== gPrevRoomNum 563))
					1
				else
					0
				)
			init:
			ignoreActors: (if gNight 0 else 1)
			setScaler: Scaler 98 60 189 85
			normalize:
		)
		(if (OneOf local2 1 2)
			(if (== local2 1)
				(heroTeller init: gEgo 290 5 128 16)
			else
				(heroTeller init: gEgo 290 5 128 17)
			)
			(gEgo actions: (myDist init: aKatrina 60 yourself:))
		)
		(fGate1 init: approachVerbs: 4) ; Do
		(fPump1 init: approachVerbs: 4) ; Do
		(fPump2 init: approachVerbs: 4) ; Do
		(fPump3 init: approachVerbs: 4) ; Do
		(fPump4 init: approachVerbs: 4) ; Do
		(fScarecrow init: approachVerbs: 4) ; Do
		(fCorn1 init: approachVerbs: 4) ; Do
		(fCorn2 init: approachVerbs: 4) ; Do
		(fCorn3 init: approachVerbs: 4) ; Do
		(fGully init: approachVerbs: 4) ; Do
		(fBridge1 init: approachVerbs: 4) ; Do
		(fBridge2 init: approachVerbs: 4) ; Do
		(fRocks1 init: approachVerbs: 4) ; Do
		(fRocks2 init: approachVerbs: 4) ; Do
		(fStump init: approachVerbs: 4) ; Do
		(fTreeTop init: approachVerbs: 4) ; Do
		(fTree2 init: approachVerbs: 4) ; Do
		(if gNight
			(gateTeller init: fGate1 290 5 125)
		else
			(= north 270)
		)
		(if (== gPrevRoomNum 340)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 82 189 0 189 0 1 619 1 619 489 230 189 184 137 158 136 159 112 205 124 219 124 220 119 201 118 195 118 181 114 180 102 199 101 214 90 180 91 200 66 184 68 174 89 150 90 110 100 86 113 40 100 31 125 57 126 58 154
						yourself:
					)
			)
		)
		(if gNight
			((pPumpkin1 new:)
				setLoop: 0 1
				posn: 183 135
				approachX: 153
				approachY: 136
				init:
				approachVerbs: 4 ; Do
				ignoreActors: 1
			)
			((pPumpkin1 new:)
				setLoop: 1 1
				posn: 205 152
				approachX: 176
				approachY: 144
				init:
				approachVerbs: 4 ; Do
				ignoreActors: 1
			)
			((pPumpkin1 new:)
				setLoop: 2 1
				posn: 263 142
				approachX: 183
				approachY: 153
				init:
				approachVerbs: 4 ; Do
				ignoreActors: 1
			)
			((pPumpkin1 new:)
				setLoop: 3 1
				posn: 231 161
				approachX: 199
				approachY: 164
				init:
				approachVerbs: 4 ; Do
				ignoreActors: 1
			)
			(switch local2
				(1
					(aKatrina
						init:
						setScaler: Scaler 98 60 189 85
						ignoreActors:
						approachVerbs: 4 2 ; Do, Talk
					)
					(= gPrevKatrinaDayNumber gDay)
					(SetFlag 79)
					(katrinaTeller init: aKatrina 290 5 127 16)
					(katrinaTeller2 init: aKatrina 290 5 138 15)
				)
				(2
					(aKatrina
						init:
						setScaler: Scaler 98 60 189 85
						approachVerbs: 4 2 ; Do, Talk
						ignoreActors:
					)
					(ClearFlag 399)
					(SetFlag 82)
					(katrinaTeller init: aKatrina 290 5 127 17)
					(katrinaTeller2 init: aKatrina 290 5 138 15)
				)
			)
			(cond
				((IsFlag 81)
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init: -300 186 -300 -300 619 -300 619 188 238 188 180 137 149 133 149 117 173 118 207 124 211 122 180 116 182 104 212 86 203 85 489 71 183 72 183 83 129 94 87 111 47 96 26 106 26 138 60 149 77 186
								yourself:
							)
					)
				)
				((IsFlag 80)
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init: -300 489 -300 -300 619 -300 619 489 231 489 184 137 163 136 151 130 151 118 166 98 200 101 213 90 193 91 162 90 151 90 108 101 87 113 40 100 31 125 57 126 58 154 83 489
								yourself:
							)
					)
				)
				(else
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init: -300 489 -300 -300 619 -300 619 489 231 489 184 137 163 136 157 124 157 105 181 102 200 101 213 90 193 91 162 90 151 90 108 101 87 113 40 100 31 125 57 126 58 154 83 489
								yourself:
							)
					)
				)
			)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: -300 489 -300 -300 619 -300 619 489 238 489 180 137 149 133 149 117 173 118 207 124 211 122 180 116 182 104 190 83 188 71 183 66 179 72 183 83 87 111 47 96 26 106 26 138 60 149 80 489
						yourself:
					)
			)
		)
		(if (not gNight)
			(vOpenDoor ignoreActors: init: setPri: 80 approachVerbs: 4) ; Do
		else
			(= local9 1)
		)
		(fGate2 init: approachVerbs: 4) ; Do
		(fTowers init: approachVerbs: 4) ; Do
		(self
			addPoly:
				((Polygon new:)
					init: 82 145 102 152 127 155 157 161 160 169 169 171 244 181 238 189 69 189 53 157 64 166 87 165 69 158 57 156 55 146 98 161 134 169 126 161 85 151 74 145
					yourself:
				)
				50
		)
		(super init: &rest)
		(cond
			((gCast contains: aKatrina)
				(gLongSong number: 110 setLoop: -1 play:)
			)
			(
				(and
					(not gNight)
					(not (== gPrevRoomNum 270))
					(not (IsFlag 80))
					(not (IsFlag 81))
				)
				(gLongSong number: 558 setLoop: -1 play:)
			)
			((and (not (== gPrevRoomNum 270)) (not (IsFlag 80)) (not (IsFlag 81)))
				(gLongSong number: 557 setLoop: -1 play:)
			)
			((and (not gNight) (not (IsFlag 80)) (not (IsFlag 81)))
				(if (not (IsFlag 372))
					(SetFlag 372)
					(gLongSong number: 290 setLoop: 1 1 play: self)
				else
					(gLongSong number: 558 setLoop: -1 play:)
				)
			)
		)
		(switch gPrevRoomNum
			(563
				(gEgo posn: 265 240)
				(= local0 180)
				(if (IsFlag 80)
					(= local1 160)
				else
					(= local1 181)
				)
				(gEgo setScript: sEnter)
			)
			(340
				(gEgo setScript: sThiefEnter)
			)
			(else
				(= local0 130)
				(= local1 108)
				(if (not gNight)
					(gEgo posn: 188 89)
					(gEgo setScript: sEnter)
				else
					(gEgo posn: 1000 1000)
					(switch global423
						(1
							(gEgo setScript: sEnterClimb)
						)
						(2
							(gEgo setScript: sEnterLevitate)
						)
						(else
							(gGlory handsOn:)
						)
					)
				)
			)
		)
		(if (or (IsFlag 80) (IsFlag 81))
			(gGlory save: 1)
		)
	)

	(method (cue)
		(if (== (gLongSong number:) 290)
			(gLongSong number: 558 setLoop: -1 play:)
		)
	)

	(method (doit)
		(if (and (== (gCurRoom script:) (ScriptID 31 1)) (>= (gEgo z:) 60)) ; sLevitate
			(gCurRoom setScript: sLevitating)
		)
		(super doit: &rest)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(89 ; levitateSpell
				(if local9
					((ScriptID 31 0) init: 179 89 180 0 2) ; leviCode
				else
					(gMessager say: 4 4 41) ; "It's considered poor form to levitate over the town gate during the day. Try using the gate."
				)
			)
			(87 ; fetchSpell
				(if (gEgo has: 27) ; theCorn
					(gMessager say: 3 4 5) ; "You have enough corn for now."
				else
					(self setScript: (ScriptID 37) 0 fCorn1) ; castFetchScript
				)
			)
			(-87 ; fetchSpell (part 2)
				(gMessager say: 3 87 0 0) ; "Since you're far too sophisticated a spellcaster to do something mundane like walking over to a corn stalk and picking an ear, you try the Fetch spell instead."
			)
			(81 ; detectMagicSpell
				(if gNight
					(gMessager say: 2 81 4) ; "Magical energy sparkles all around you. In particular, the jack o' lanterns and the scarecrow seem to have taken on mysterious lives of their own."
				else
					(gMessager say: 2 81 3) ; "You do not sense any magical energy here at the moment."
				)
			)
			(1 ; Look
				(if gNight
					(gMessager say: 2 1 4) ; "The town walls loom mysteriously in the background."
				else
					(gMessager say: 2 1 3) ; "The walls of the town rise magestically above you."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(if (or (IsFlag 80) (IsFlag 81))
			(gLongSong2 fade: 0)
		)
		(if (and (!= gLongSong 557) (!= gLongSong 558))
			(gLongSong fade:)
		)
		(gLongSong client: 0)
		(DisposeScript 64969)
		(DisposeScript 9)
		(heroTeller dispose:)
		(if (OneOf local2 1 2)
			(katrinaTeller dispose:)
			(katrinaTeller2 dispose:)
		)
		(super dispose:)
	)
)

(instance sEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if (or (IsFlag 80) (IsFlag 81))
					(gLongSong2 number: 103 loop: -1 play:)
				)
				(gEgo setMotion: PolyPath local0 local1 self)
			)
			(1
				(if (IsFlag 80)
					(gEgo setScript: sTimerScript)
				else
					(switch local2
						(1
							(self setScript: sKatrinaGreets)
						)
						(2
							(self setScript: sKatrinaGreets)
						)
						(5
							(self setScript: sGypsy)
						)
						(else
							(if (and gNight (not (IsFlag 36)) (IsFlag 81))
								(self setScript: sAmbushed)
							else
								(gGlory handsOn:)
								(self dispose:)
							)
						)
					)
				)
			)
		)
	)
)

(instance sGypsy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(SetFlag 310)
				(aDavy
					view: 465
					setLoop: 0 1
					init:
					setCycle: Walk
					setMotion: MoveTo 52 189 self
				)
			)
			(1
				(aDavy setCel: 9 setCycle: 0)
				(gEgo setMotion: PolyPath 80 177 self)
			)
			(2
				(gMessager say: 20 6 55 0 self) ; "I just wanted to thank you for saving me."
			)
			(3
				(sndChanges play:)
				(aDavy
					view: 463
					setLoop: 4 1
					setCel: 0
					posn: 53 189
					setCycle: End self
				)
			)
			(4
				(aDavy
					setLoop: 1 1
					setCel: 0
					posn: 57 189
					setCycle: Fwd
					setMotion: MoveTo -25 189 self
				)
			)
			(5
				(aDavy setCycle: 0 dispose:)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLevitating of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo posn: (gEgo x:) 33)
				(= cycles 6)
			)
			(1
				(gEgo
					view: 7
					setLoop: 4 1
					setCel: 0
					y: 15
					setCycle: End self
				)
			)
			(2
				(gEgo castSpell: 29)
				(if (OneOf local2 3 4)
					(SetFlag 81)
					((aNecrotaur1 new:)
						posn: 83 230
						init:
						setPri: 64
						cycleSpeed: 0
						moveSpeed: 0
						setCycle: Walk
						setMotion: PolyPath 167 98 self
					)
					((aNecrotaur1 new:)
						posn: 115 230
						init:
						setPri: 64
						cycleSpeed: 3
						moveSpeed: 3
						setCycle: Walk
						setMotion: PolyPath 130 102
					)
					((aNecrotaur1 new:)
						posn: 164 230
						init:
						setPri: 64
						setCycle: Walk
						setMotion: PolyPath 131 139
					)
				else
					(self cue:)
				)
			)
			(3
				(gEgo
					view: 17
					setLoop: 2 1
					setCel: 5
					setPri: 0
					setMotion:
						MoveTo
						(+ (gEgo x:) 10)
						(+ (gEgo y:) 25)
						self
				)
			)
			(4
				(gCurRoom newRoom: 270)
			)
		)
	)
)

(instance sToGully of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gMessager say: 1 6 2 0 self) ; "The tunnel was apparently designed as an escape route from the Guild. You can't find any way to open it from this end."
			)
			(1
				(gEgo setMotion: PolyPath 139 120 self)
			)
			(2
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTimerScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOn:)
				(= seconds (/ 20 global439))
			)
			(1
				(if (not (gCurRoom script:))
					(gCurRoom setScript: sChaseEgo)
				else
					(self dispose:)
				)
			)
		)
	)
)

(instance sChaseEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: 0 ignoreActors:)
				((aNecrotaur1 new:)
					posn: 150 189
					init:
					setPri: 196
					setCycle: Walk
					setMotion: PolyPath (- (gEgo x:) 15) (gEgo y:)
				)
				((aNecrotaur1 new:)
					posn: 115 189
					init:
					setPri: 196
					setCycle: Walk
					setMotion: PolyPath (gEgo x:) (gEgo y:) self
				)
				(ClearFlag 80)
				(SetFlag 81)
			)
			(1
				(if (> (gEgo y:) 89)
					(pAdavis
						init:
						setScaler: Scaler 92 76 189 87
						setCycle: End self
					)
				else
					(self cue:)
				)
			)
			(2
				(if (> (gEgo y:) 89)
					(gMessager say: 14 6 12 0 self) ; "I have you at last! You will pay for what you have done to me. I will have my revenge!"
				else
					(self cue:)
				)
			)
			(3
				(if (> (gEgo y:) 89)
					(gCast eachElementDo: #hide)
					(UpdatePlane
						((gCurRoom plane:) back: 0 picture: -1 yourself:)
					)
					(= seconds 2)
				else
					(self cue:)
				)
			)
			(4
				(if (< (gEgo y:) 89)
					(gCurRoom newRoom: 270)
				else
					(gCurRoom newRoom: 670)
				)
			)
		)
	)
)

(instance sAmbushed of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo ignoreActors: setMotion: MoveTo local0 local1 self)
			)
			(1
				((aNecrotaur1 new:)
					setCel: 0
					posn: -55 189
					init:
					setPri: 207
					setCycle: Walk
					setMotion: PolyPath (- (gEgo x:) 10) 180
				)
				((aNecrotaur1 new:)
					setCel: 0
					posn: 215 230
					init:
					setPri: 207
					setCycle: Walk
					setMotion: PolyPath (gEgo x:) (gEgo y:) self
				)
				((aNecrotaur1 new:)
					setCel: 0
					posn: 375 189
					init:
					setPri: 207
					setCycle: Walk
					setMotion: PolyPath (+ (gEgo x:) 10) 171
				)
				(ClearFlag 81)
			)
			(2
				(pAdavis
					init:
					setScaler: Scaler 92 76 189 87
					setCycle: End self
				)
			)
			(3
				(gMessager say: 14 6 12 0 self) ; "I have you at last! You will pay for what you have done to me. I will have my revenge!"
			)
			(4
				(gCast eachElementDo: #hide)
				(UpdatePlane ((gCurRoom plane:) back: 0 picture: -1 yourself:))
				(= seconds 2)
			)
			(5
				(gCurRoom newRoom: 670)
			)
		)
	)
)

(instance sKatrinaWalksAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= cycles 5)
			)
			(1
				(heroTeller dispose:)
				(gEgo actions: (myDist init: aKatrina 60 yourself:))
				(if (== local2 1)
					(gMessager say: 15 6 18 0 self) ; "I need to go now. I hope we can meet again soon. I enjoy your company."
				else
					(gMessager say: 15 6 21 0 self) ; "I've got to go... Maybe we can meet again? It's too dangerous for me to come here again. It's so far from the castle. Maybe we could meet by the castle gate some evening. I'll watch for you there."
				)
			)
			(2
				(aKatrina
					setLoop: 1 1
					setCel: 0
					setCycle: Fwd
					setMotion: MoveTo 1 (aKatrina y:) self
				)
			)
			(3
				(if (== local2 1)
					(gMessager say: 1 6 22 0 self) ; "Before you can think to follow her, the young peasant girl has disappeared into the forest."
				else
					(gMessager say: 1 6 25 0 self) ; "You watch her walk off before you think of doing anything else."
				)
				(aKatrina actions: 0 setCycle: 0 hide: dispose:)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sKatrinaGreets of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= seconds 5)
			)
			(1
				(gGlory handsOff:)
				(if (== gHeroType 3) ; Paladin
					(gMessager say: 1 6 35 0 self) ; "You have the sensation of someone watching you. You sense curiosity and no immediate danger."
				else
					(self cue:)
				)
			)
			(2
				(gGlory handsOff:)
				(if (== local2 1)
					(gMessager say: 15 6 13 0 self) ; "It is good to see you again. I hope you are enjoying your visit to Mordavia."
				else
					(gMessager say: 15 6 19 0 self) ; "Hello again. Did you get my note? I hoped I could see and speak with you again."
				)
			)
			(3
				(gGlory handsOff:)
				(= seconds 1)
			)
			(4
				(gGlory handsOff:)
				(if (not (gCurRoom script:))
					(self cue:)
				)
			)
			(5
				(gGlory handsOff:)
				(if (< [gEgoStats 17] (gEgo maxHealth:)) ; health
					(sndChanges play:)
					(gEgo get: 3) ; theHeals
					(if (== local2 1)
						(gMessager say: 15 6 14 0 self) ; "Why, you've been injured! Take this and drink it; it should help."
					else
						(gMessager say: 15 6 20 0 self) ; "Oh, you've been hurt. Are you sure you should be out wandering? You really need to take care of yourself more."
					)
				else
					(self cue:)
				)
			)
			(6
				(if [gEgoStats 12] ; magic
					(if (== local2 2)
						(self cue:)
					else
						(gMessager say: 15 6 15 0 self) ; "Come to me; I have something to show you."
					)
				else
					(self changeState: 11)
				)
			)
			(7
				(gEgo setMotion: PolyPath 63 136 self)
			)
			(8
				(if (== local2 2)
					(self cue:)
				else
					(gMessager say: 15 6 16 0 self) ; "I warned you it is dangerous here at night, and you do not listen. I intend to teach you a lesson."
				)
			)
			(9
				(if (== local2 2)
					(self cue:)
				else
					(gEgo
						learn: 34 100 ; frostSpell
						solvePuzzle: 497 6 2 2
						setCycle: Rev
						setMotion: MoveTo (- (gEgo x:) 10) (gEgo y:) self
					)
				)
			)
			(10
				(if (== local2 2)
					(self cue:)
				else
					(gMessager say: 15 6 17 0 self) ; "You realize that you now know the "Frostbite" spell."
				)
			)
			(11
				(gEgo setCycle: 0 normalize:)
				(gGlory handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sThiefEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 120)
			)
			(1
				(gEgo posn: 222 124 setMotion: MoveTo 193 124 self)
			)
			(2
				(gEgo setMotion: PolyPath 138 120 self)
			)
			(3
				(gEgo setMotion: PolyPath 132 151 self)
			)
			(4
				(= local0 0)
				(= local1 0)
				(switch local2
					(1
						(self setScript: sKatrinaGreets)
					)
					(2
						(self setScript: sKatrinaGreets)
					)
					(5
						(self setScript: sGypsy)
					)
					(else
						(if (IsFlag 81)
							(self setScript: sAmbushed)
						else
							(gGlory handsOn:)
							(self dispose:)
						)
					)
				)
			)
		)
	)
)

(instance sGetCorn of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo setMotion: PolyPath local0 local1 self)
			)
			(1
				(gEgo view: 31 loop: 0 setCycle: End self)
			)
			(2
				(gEgo get: 27) ; theCorn
				(= ticks 30)
			)
			(3
				(gEgo setCycle: Beg self)
			)
			(4
				(gEgo normalize:)
				(gMessager say: 3 4 6 0 self) ; "You take an ear of the corn and put it away in your pack."
			)
			(5
				(gGlory handsOn:)
				(= local0 0)
				(= local1 0)
				(self dispose:)
			)
		)
	)
)

(instance sClimbTheGate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(if local7
					(gEgo setMotion: PolyPath 162 92 self)
				else
					(gEgo setMotion: PolyPath 187 92 self)
				)
			)
			(1
				(cond
					(local7
						(gEgo useSkill: 11 200) ; climbing
						(gMessager say: 4 33 0 0 self) ; "You catch the top of the gate with your grapnel and clamber up the rope. A few moments later, you slip over the gate and into town."
					)
					(local9
						(gEgo useSkill: 11 200) ; climbing
						(if (> [gEgoStats 11] 200) ; climbing
							(gMessager say: 5 125 10 0 self) ; "You deftly slip over the gate and into town."
						else
							(gMessager say: 4 4 7 0 self) ; "You're getting some good practice in climbing. You'll need to keep practicing before you'll be able to make it over this wall; it was built to keep monsters out of town."
						)
					)
					(else
						(gMessager say: 4 4 3 0 self) ; "It's considered poor form to climb the town walls during the day. Try using the gate."
					)
				)
			)
			(2
				(if local7
					(self setScript: sClimbOverGrapnel)
				else
					(gEgo view: 7 setLoop: 3 1 setCel: 0 setCycle: Fwd)
					(= ticks 10)
				)
			)
			(3
				(if (> [gEgoStats 11] 200) ; climbing
					(= local6 (gEgo moveSpeed:))
					(= local5 (gEgo cycleSpeed:))
					(gEgo
						setCycle: Fwd
						cycleSpeed: 4
						moveSpeed: 4
						setPri: 97
						setMotion: MoveTo 188 38 self
					)
				else
					(gEgo normalize:)
					(gGlory
						setCursor:
							((gTheIconBar getCursor:)
								view: 942
								loop: 0
								cel: 0
								yourself:
							)
					)
					(gGlory handsOn:)
					(self dispose:)
				)
			)
			(4
				(gEgo
					setLoop: 4 1
					setCel: 0
					posn: 187 14
					moveSpeed: local6
					setCycle: CT 4 1 self
				)
			)
			(5
				(if (OneOf local2 3 4)
					(SetFlag 81)
					((aNecrotaur1 new:)
						posn: 75 230
						init:
						setPri: 64
						cycleSpeed: 0
						moveSpeed: 0
						setCycle: Walk
						setMotion: PolyPath 167 98 self
					)
					((aNecrotaur1 new:)
						posn: 115 230
						init:
						setPri: 207
						cycleSpeed: 3
						moveSpeed: 3
						setCycle: Walk
						setMotion: PolyPath 130 102
					)
					((aNecrotaur1 new:)
						posn: 164 230
						init:
						setPri: 207
						setCycle: Walk
						setMotion: PolyPath 131 139
					)
				else
					(self cue:)
				)
			)
			(6
				(gEgo setCel: 4 setCycle: End self)
			)
			(7
				(gEgo cycleSpeed: local5)
				(gCurRoom newRoom: 270)
			)
		)
	)
)

(instance sClimbOverGrapnel of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local7 0)
				(Face gEgo 168 45 self)
			)
			(1
				(gEgo view: 8 setLoop: 0 1 posn: 171 91 setCycle: End self)
			)
			(2
				(gEgo setLoop: 7 1 setCel: 0 posn: 171 91 setCycle: End)
				(pProp
					view: 8
					setLoop: 6 1
					setCel: 0
					posn: 185 41
					setPri: 75
					setScaler: Scaler 98 60 189 85
					init:
					setCycle: End self
				)
			)
			(3
				(vRope init:)
				(gEgo normalize: setPri: 97 setMotion: MoveTo 183 88 self)
			)
			(4
				(gEgo
					view: 7
					setLoop: 0 1
					setCel: 0
					posn: 190 86
					ignoreActors: 1
					ignoreHorizon: 1
					setCycle: End self
				)
			)
			(5
				(gEgo setLoop: 1 1 setCel: 0 y: 86 setCycle: End self)
			)
			(6
				(gEgo setCel: 0 x: 192 y: 76 setCycle: End self)
			)
			(7
				(gEgo setCel: 0 y: 65 setCycle: End self)
			)
			(8
				(gEgo setCel: 0 x: 193 y: 55 setCycle: End self)
			)
			(9
				(gEgo setCel: 0 y: 14 setLoop: 4 1 setCycle: End self)
			)
			(10
				(if (OneOf local2 3 4)
					(SetFlag 81)
					((aNecrotaur1 new:)
						posn: 75 230
						init:
						setPri: 64
						cycleSpeed: 0
						moveSpeed: 0
						setCycle: Walk
						setMotion: PolyPath 167 98 self
					)
					((aNecrotaur1 new:)
						posn: 115 230
						init:
						setPri: 207
						cycleSpeed: 3
						moveSpeed: 3
						setCycle: Walk
						setMotion: PolyPath 130 102
					)
					((aNecrotaur1 new:)
						posn: 164 230
						init:
						setPri: 207
						setCycle: Walk
						setMotion: PolyPath 131 139
					)
				else
					(self cue:)
				)
			)
			(11
				(gCurRoom newRoom: 270)
			)
		)
	)
)

(instance sEnterClimb of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 1)
			)
			(1
				(gGlory handsOff:)
				(= local6 (gEgo moveSpeed:))
				(= local5 (gEgo cycleSpeed:))
				(gEgo
					view: 7
					setLoop: 5 1
					setCel: 0
					posn: 187 14
					setPri: 50
					setCycle: End self
				)
			)
			(2
				(gEgo cycleSpeed: 8 moveSpeed: 8 setCycle: Beg self)
			)
			(3
				(gEgo
					setLoop: 3 1
					setCel: 0
					posn: (gEgo x:) (+ (gEgo y:) 38)
					setCycle: Fwd
					setMotion: MoveTo 187 92 self
				)
			)
			(4
				(gEgo cycleSpeed: local5 moveSpeed: local6 normalize:)
				(switch local2
					(1
						(self setScript: sKatrinaGreets)
					)
					(2
						(self setScript: sKatrinaGreets)
					)
					(else
						(if (IsFlag 81)
							(self setScript: sAmbushed)
						else
							(gGlory handsOn:)
							(self dispose:)
						)
					)
				)
			)
		)
	)
)

(instance sEnterLevitate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(gEgo
					view: 17
					setLoop: 1 1
					setCel: 5
					posn: 187 14
					setPri: 75
					setCycle: 0
					setMotion: MoveTo 179 93 self
				)
			)
			(1
				(gEgo normalize: useMana: 10)
				(switch local2
					(1
						(self setScript: sKatrinaGreets)
					)
					(2
						(self setScript: sKatrinaGreets)
					)
					(else
						(if (IsFlag 81)
							(self setScript: sAmbushed)
						else
							(gGlory handsOn:)
							(self dispose:)
						)
					)
				)
			)
		)
	)
)

(instance sHeroBye of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGlory handsOff:)
				(= cycles 2)
			)
			(1
				(if (== local2 1)
					(gMessager say: 16 128 58 0 self) ; "Say Goodbye"
				else
					(gMessager say: 17 128 59 0 self) ; "Say Goodbye"
				)
			)
			(2
				(self setScript: sKatrinaWalksAway)
			)
		)
	)
)

(instance aDavy of Actor
	(properties
		x -20
		y 189
		priority 185
		fixPriority 1
		view 463
	)
)

(instance aNecrotaur1 of Actor
	(properties
		x 75
		y 230
		priority 152
		fixPriority 1
		view 870
		loop 3
		scaleSignal 1
	)

	(method (init)
		(super init: &rest)
		(self
			ignoreActors: 1
			setScaler: Scaler 80 72 144 115
			setCycle: StopWalk 870
		)
	)
)

(instance aKatrina of Actor
	(properties
		noun 15
		approachX 63
		approachY 136
		x 37
		y 134
		view 792
		loop 2
	)

	(method (doVerb theVerb &tmp [temp0 2])
		(cond
			(
				(OneOf
					theVerb
					85 ; calmSpell
					83 ; dazzleSpell
					81 ; detectMagicSpell
					87 ; fetchSpell
					86 ; flameDartSpell
					88 ; forceBoltSpell
					79 ; frostSpell
					102 ; healingSpell
					91 ; jugglingLightsSpell
					89 ; levitateSpell
					93 ; lightningBallSpell
					80 ; openSpell
					90 ; reversalSpell
					94 ; ritualSpell
					92 ; summonStaffSpell
					82 ; triggerSpell
					84 ; zapSpell
					95 ; invisibleSpell
					96 ; auraSpell
					97 ; protectionSpell
					98 ; resistanceSpell
					11 ; glideSpell
				)
				(gMessager say: 1 6 23) ; "Something about the young peasant girl makes all thought of magic swirl around in your head. You don't seem to be able to cast any of your spells."
			)
			((== theVerb 37) ; theThrowdagger
				(if (== (gEgo has: 5) 1) ; theThrowdagger
					(gMessager say: 1 6 60) ; "You are down to your last dagger. You'd better hold on to it."
				else
					(gMessager say: 1 6 24) ; "You don't have any reason to attack the young peasant girl; in fact, you feel very relaxed and comfortable around her."
				)
			)
			((OneOf theVerb 4 36 21) ; Do, theSword, theRocks
				(gMessager say: 1 6 24) ; "You don't have any reason to attack the young peasant girl; in fact, you feel very relaxed and comfortable around her."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pAdavis of Prop
	(properties
		noun 14
		x 20
		y 186
		view 677
	)
)

(instance pProp of Prop
	(properties)
)

(instance vRope of View
	(properties
		x 189
		y 59
		priority 75
		fixPriority 1
		view 50
		cel 2
	)
)

(instance pPumpkin1 of View
	(properties
		noun 7
		sightAngle 180
		approachX 153
		approachY 136
		x 183
		y 135
		view 291
		cel 5
	)

	(method (doVerb theVerb)
		(fPump1 doVerb: theVerb)
	)
)

(instance vOpenDoor of View
	(properties
		noun 4
		sightAngle 180
		approachX 166
		approachY 92
		x 165
		y 45
		priority 80
		fixPriority 1
		view 290
	)

	(method (doVerb theVerb)
		(fGate1 doVerb: theVerb)
	)
)

(instance fPump1 of Feature
	(properties
		noun 7
		nsLeft 168
		nsTop 123
		nsRight 200
		nsBottom 134
		sightAngle 180
		approachX 153
		approachY 136
		x 184
		y 128
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(if local9
				(gMessager say: 7 1 4) ; "The faces on the jack o' lanterns glow like malevolent demons waiting for an unwary victim to come within their grasp."
			else
				(gMessager say: 7 1 3) ; "Some beautiful giant pumpkins are growing in the field."
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fPump2 of Feature
	(properties
		noun 7
		nsLeft 192
		nsTop 132
		nsRight 219
		nsBottom 154
		sightAngle 180
		approachX 176
		approachY 144
		x 205
		y 143
	)

	(method (doVerb theVerb)
		(fPump1 doVerb: theVerb)
	)
)

(instance fPump3 of Feature
	(properties
		noun 7
		nsLeft 231
		nsTop 162
		nsRight 257
		nsBottom 177
		sightAngle 180
		approachX 214
		approachY 177
		x 244
		y 169
	)

	(method (doVerb theVerb)
		(fPump1 doVerb: theVerb)
	)
)

(instance fPump4 of Feature
	(properties
		noun 7
		nsLeft 253
		nsTop 131
		nsRight 270
		nsBottom 140
		sightAngle 180
		approachX 176
		approachY 144
		x 261
		y 135
	)

	(method (doVerb theVerb)
		(fPump1 doVerb: theVerb)
	)
)

(instance fScarecrow of Feature
	(properties
		noun 8
		nsLeft 258
		nsTop 96
		nsRight 305
		nsBottom 141
		sightAngle 180
		approachX 183
		approachY 153
		x 281
		y 118
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(if gNight
				(gMessager say: 8 1 4) ; "The scarecrow looks almost as if it was alive... and waiting. The straw hands have taken on a skeletal appearance and the head now looks like a skull."
			else
				(gMessager say: 8 1 3) ; "The villagers have erected a scarecrow to keep birds away from the newly-harvested corn."
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fCorn1 of Feature
	(properties
		noun 3
		nsLeft 158
		nsTop 89
		nsRight 181
		nsBottom 124
		sightAngle 180
		approachX 148
		approachY 127
		x 169
		y 106
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if gNight
					(gMessager say: 3 1 4) ; "Tall shocks of corn have been harvested and wait here to be stored for the winter."
				else
					(gMessager say: 3 1 3) ; "Tall shocks of corn have been harvested and wait here to be stored for the winter."
				)
			)
			(4 ; Do
				(if (gEgo has: 27) ; theCorn
					(gMessager say: 3 4 5) ; "You have enough corn for now."
				else
					(= local0 148)
					(= local1 127)
					(gCurRoom setScript: sGetCorn)
				)
			)
			(87 ; fetchSpell
				(if (gEgo has: 27) ; theCorn
					(gMessager say: 3 4 5) ; "You have enough corn for now."
				else
					(gCurRoom setScript: (ScriptID 37) 0 fCorn1) ; castFetchScript
				)
			)
			(-87 ; fetchSpell (part 2)
				(gMessager say: 3 87 0 0) ; "Since you're far too sophisticated a spellcaster to do something mundane like walking over to a corn stalk and picking an ear, you try the Fetch spell instead."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fCorn2 of Feature
	(properties
		noun 3
		nsLeft 196
		nsTop 98
		nsRight 215
		nsBottom 133
		sightAngle 180
		approachX 179
		approachY 138
		x 205
		y 115
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (gEgo has: 27) ; theCorn
				(gMessager say: 3 4 5) ; "You have enough corn for now."
			else
				(= local0 179)
				(= local1 138)
				(gCurRoom setScript: sGetCorn)
			)
		else
			(fCorn1 doVerb: theVerb)
		)
	)
)

(instance fCorn3 of Feature
	(properties
		noun 3
		nsLeft 218
		nsTop 126
		nsRight 245
		nsBottom 166
		sightAngle 180
		approachX 207
		approachY 169
		x 231
		y 146
	)

	(method (doVerb theVerb)
		(if (== theVerb 4) ; Do
			(if (gEgo has: 27) ; theCorn
				(gMessager say: 3 4 5) ; "You have enough corn for now."
			else
				(= local0 207)
				(= local1 169)
				(gCurRoom setScript: sGetCorn)
			)
		else
			(fCorn1 doVerb: theVerb)
		)
	)
)

(instance fGully of Feature
	(properties
		noun 9
		nsLeft 211
		nsTop 104
		nsRight 259
		nsBottom 138
		sightAngle 180
		approachX 171
		approachY 120
		x 235
		y 121
	)

	(method (init)
		(super init: &rest)
		(if (== gPrevRoomNum 340)
			(= heading
				(((ScriptID 49 0) new:) ; doorMat
					init:
						((Polygon new:)
							type: PNearestAccess
							init: 215 114 204 123 163 121 171 113
							yourself:
						)
						0
						4
						6
						sToGully
					yourself:
				)
			)
		)
	)

	(method (dispose)
		(if (and (== gPrevRoomNum 340) heading)
			(heading dispose:)
		)
		(super dispose: &rest)
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(if gNight
				(gMessager say: 9 1 4) ; "You can't see the bottom of the gully; it's dark down there."
			else
				(gMessager say: 9 1 3) ; "The bottom of the gully is filled with water from the Autumn storms."
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fGate1 of Feature
	(properties
		noun 4
		nsLeft 168
		nsTop 45
		nsRight 213
		nsBottom 77
		sightAngle 180
		approachX 166
		approachY 92
		x 190
		y 61
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if local9
					(gMessager say: 4 1 4) ; "The gates have been closed for the night. They appear to provide a formidable barrier."
				else
					(gMessager say: 4 1 3) ; "The town gates, made of massive oak logs, are currently wide open. There is a heavy oaken bar to secure them at night."
				)
			)
			(33 ; theGrapnel
				(if local9
					(if (== (gEgo trySkill: 11 150) 1) ; climbing
						(= local7 1)
						(gCurRoom setScript: sClimbTheGate)
					else
						(gMessager say: 4 4 7) ; "You're getting some good practice in climbing. You'll need to keep practicing before you'll be able to make it over this wall; it was built to keep monsters out of town."
					)
				else
					(gMessager say: 4 4 3) ; "It's considered poor form to climb the town walls during the day. Try using the gate."
				)
			)
			(4 ; Do
				(if local9
					(if (== (gEgo trySkill: 11 150) 1) ; climbing
						(gCurRoom setScript: sClimbTheGate)
					else
						(gMessager say: 4 4 7) ; "You're getting some good practice in climbing. You'll need to keep practicing before you'll be able to make it over this wall; it was built to keep monsters out of town."
					)
				else
					(gMessager say: 4 4 3) ; "It's considered poor form to climb the town walls during the day. Try using the gate."
				)
			)
			(89 ; levitateSpell
				(if local9
					(gCurRoom doVerb: theVerb)
				else
					(gMessager say: 4 4 3) ; "It's considered poor form to climb the town walls during the day. Try using the gate."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fGate2 of Feature
	(properties
		noun 4
		nsLeft 166
		nsTop 76
		nsRight 186
		nsBottom 91
		sightAngle 180
		approachX 166
		approachY 92
		x 176
		y 83
	)

	(method (init)
		(super init:)
		(if gNight
			(= actions gateTeller)
		)
	)

	(method (doVerb theVerb)
		(fGate1 doVerb: theVerb)
	)
)

(instance fBridge1 of Feature
	(properties
		noun 10
		nsLeft 79
		nsTop 71
		nsRight 160
		nsBottom 91
		sightAngle 180
		approachX 138
		approachY 97
		x 119
		y 81
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(if gNight
				(gMessager say: 10 1 4) ; "The bridge still looks solid at night, but you wonder what terrors lie beneath it in the darkness."
			else
				(gMessager say: 10 1 3) ; "The arched stone bridge provides a path over the gully to the town gates."
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fBridge2 of Feature
	(properties
		noun 10
		nsLeft 189
		nsTop 77
		nsRight 248
		nsBottom 114
		sightAngle 180
		approachX 190
		approachY 98
		x 218
		y 95
	)

	(method (doVerb theVerb)
		(fBridge1 doVerb: theVerb)
	)
)

(instance fTowers of Feature
	(properties
		noun 6
		nsLeft 103
		nsTop -1
		nsRight 278
		nsBottom 48
		sightAngle 180
		approachX 166
		approachY 92
		x 190
		y 23
	)

	(method (init)
		(super init:)
		(if gNight
			(= actions gateTeller)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if gNight
					(gMessager say: 6 1 4) ; "The grim towers look down on you like gargoyles ready to strike."
				else
					(gMessager say: 6 1 3) ; "Twin towers stand above the town wall, massive silent sentinels over the gate."
				)
			)
			(33 ; theGrapnel
				(if local9
					(fGate1 doVerb: theVerb)
					(= local7 1)
				else
					(gMessager say: 6 4 3) ; "It's considered poor form to climb the town walls during the day. Try using the gate."
				)
			)
			(4 ; Do
				(if local9
					(if (== (gEgo trySkill: 11 200) 1) ; climbing
						(gCurRoom setScript: sClimbTheGate)
					else
						(gMessager say: 4 4 7) ; "You're getting some good practice in climbing. You'll need to keep practicing before you'll be able to make it over this wall; it was built to keep monsters out of town."
					)
				else
					(gMessager say: 4 4 3) ; "It's considered poor form to climb the town walls during the day. Try using the gate."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fRocks1 of Feature
	(properties
		noun 11
		nsLeft 32
		nsTop 76
		nsRight 78
		nsBottom 106
		sightAngle 180
		approachX 51
		approachY 104
		x 55
		y 91
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(if gNight
				(gMessager say: 11 1 4) ; "Dark, grim rocks wait beneath the town wall to crush careless climbers on their unyielding surfaces."
			else
				(gMessager say: 11 1 3) ; "Massive boulders help shore up the town wall."
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fRocks2 of Feature
	(properties
		noun 11
		nsLeft 247
		nsTop 83
		nsRight 318
		nsBottom 126
		sightAngle 180
		approachX 183
		approachY 153
		x 282
		y 104
	)

	(method (doVerb theVerb)
		(fRocks1 doVerb: theVerb)
	)
)

(instance fStump of Feature
	(properties
		noun 12
		nsLeft 19
		nsTop 124
		nsRight 63
		nsBottom 188
		sightAngle 180
		approachX 77
		approachY 182
		x 41
		y 156
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (IsFlag 321)
					(gMessager say: 12 4 57) ; "There's nothing else in the stump except old leaves, dirt, and mould."
				else
					(gEgo get: 0 5) ; thePurse
					(SetFlag 321)
					(gMessager say: 12 4 56) ; "You find five Crowns that someone hid in the hollow stump. They're covered with mould and dirt and have obviously been long since forgotten."
				)
			)
			(82 ; triggerSpell
				(gEgo trySkill: 22) ; triggerSpell
				(gMessager say: 12 82 0 0) ; "You trigger an advertisement for the Shadows of Darkness hint book, but that's about it. (You know, the kind that asks, "Has this game got you STUMPed?")"
			)
			(1 ; Look
				(if gNight
					(gMessager say: 12 1 4) ; "This dark stump is all that remains of a great oak tree which once stood by the road. Judging from the marks on the top, the tree was apparently bitten off by long, fanged teeth."
				else
					(gMessager say: 12 1 3) ; "An old stump by the side of the road makes a convenient resting place for passers-by."
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance fTreeTop of Feature
	(properties
		noun 13
		nsTop -1
		nsRight 100
		nsBottom 46
		sightAngle 180
		approachX 77
		approachY 182
		x 50
		y 22
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(if gNight
				(gMessager say: 13 1 4) ; "The tree branches hover over you like gallows posts."
			else
				(gMessager say: 13 1 3) ; "One of the tall trees of the forest frames the town gate like a natural archway."
			)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance fTree2 of Feature
	(properties
		noun 13
		nsTop 46
		nsRight 34
		nsBottom 189
		sightAngle 212
		approachX 77
		approachY 185
		x 17
		y 117
	)

	(method (doVerb theVerb)
		(fTreeTop doVerb: theVerb)
	)
)

(instance gateTeller of Teller
	(properties
		actionVerb 4
	)

	(method (showCases)
		(super showCases: 10 (> [gEgoStats 11] 0)) ; Climb Over Gate, climbing
	)

	(method (sayMessage)
		(switch iconValue
			(10 ; Climb Over Gate
				(self clean:)
				(cond
					((== (gEgo trySkill: 11 200) 1) ; climbing
						(gCurRoom setScript: sClimbTheGate)
					)
					((== local2 3)
						(gCurRoom setScript: sClimbTheGate)
					)
					(else
						(gMessager say: 4 4 7 &rest)
					)
				)
			)
			(else
				(super sayMessage:)
			)
		)
	)
)

(instance katrinaTeller of Teller
	(properties
		title 1
		actionVerb 2
	)

	(method (init)
		(super init: &rest)
		(= talker (ScriptID 95 0)) ; katrinaHoodTalker
	)

	(method (showCases)
		(super showCases: 28 (> [gEgoStats 12] 0)) ; Magic, magic
	)

	(method (sayMessage)
		(if (== local3 3)
			(self clean:)
			(aKatrina setScript: sKatrinaWalksAway)
		else
			(++ local3)
			(super sayMessage: &rest)
		)
	)
)

(instance katrinaTeller2 of Teller
	(properties
		title 1
		actionVerb 4
	)

	(method (init)
		(super init: &rest)
		(= talker (ScriptID 95 0)) ; katrinaHoodTalker
	)

	(method (showCases)
		(super showCases: 28 (> [gEgoStats 12] 0)) ; magic
	)

	(method (sayMessage)
		(if (== local3 3)
			(self clean:)
			(gCurRoom setScript: sKatrinaWalksAway)
		else
			(++ local3)
			(super sayMessage: &rest)
		)
	)
)

(instance heroTeller of Teller
	(properties
		actionVerb 2
	)

	(method (sayMessage)
		(switch iconValue
			(58 ; Say Goodbye
				(ClearFlag 51)
				(= gTeller 0)
				(gCurRoom setScript: sHeroBye)
			)
			(59 ; Say Goodbye
				(ClearFlag 51)
				(= gTeller 0)
				(gCurRoom setScript: sHeroBye)
			)
			(else
				(super sayMessage: &rest)
			)
		)
	)
)

(instance myDist of DistObj
	(properties)

	(method (doVerb theVerb)
		(switch (super doVerb: theVerb)
			(aKatrina
				(heroTeller doVerb: theVerb)
			)
		)
	)
)

(instance sndChanges of Sound
	(properties
		number 934
	)
)

