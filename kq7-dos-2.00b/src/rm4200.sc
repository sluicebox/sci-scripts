;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4200)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use eastFeat)
(use Talker)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm4200 0
	proc4200_1 1
	coronerTalker 40
	monsterTalker 42
	hannibalTalker 43
)

(local
	local0
	local1
)

(procedure (proc4200_1)
	(coroner view: 4201 setLoop: 7 1 setCel: 8 setPri: 139 posn: 286 102)
)

(procedure (localproc_0)
	(coroner setScript: 0 setCel: 8 setCycle: 0)
	(writingSound stop:)
)

(instance rm4200 of KQRoom
	(properties
		picture 4200
	)

	(method (init)
		(SetFlag 192)
		(ClearFlag 539)
		(super init:)
		(candle1 init: setCycle: Fwd)
		(candle2 init: setCycle: Fwd)
		(candle3 init: setCycle: Fwd)
		(gKqMusic1 number: 4200 setLoop: -1 play:)
		(SetFlag 21)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 46 114 72 101 197 101 212 108 216 128 46 128
					yourself:
				)
		)
		(gEgo init: normalize: posn: 100 90)
		(frontDoor init:)
		(if (gEgo has: 50) ; Back_Bone
			(theBox init:)
		)
		(exitDoor init:)
		(if (== gValOrRoz -3) ; Roz
			(if (IsFlag 151)
				(gEgo setScaler: Scaler 118 98 138 82)
			else
				(gEgo setScaler: Scaler 108 83 138 82)
			)
			(Load 140 4209) ; WAVE
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 10 132 22 149 242 151 247 127 239 116 218 116 215 103 229 103 229 93 214 93 207 87 175 83 105 83 89 90 45 90 10 103
						yourself:
					)
			)
			(ratJar init:)
			(if (not (IsFlag 477))
				(shelves init:)
			)
			(if (not (IsFlag 479))
				(coffin init:)
			)
			(cond
				((IsFlag 151)
					(cond
						((IsFlag 469)
							(= local0 48)
						)
						((IsFlag 489)
							(= local0 47)
						)
						(else
							(SetFlag 489)
							(= local0 46)
						)
					)
					(self setScript: roseAsWomanInBlack)
				)
				((IsFlag 183)
					(SetFlag 478)
					(= local0 45)
					(coroner view: 4207 setLoop: 2 1 setCel: 24 posn: 72 92)
					(self setScript: rosEnter)
				)
				((IsFlag 468)
					(= local0 44)
					(bolts init:)
					(coroner view: 4201 setLoop: 3 setCel: 13 posn: 51 89)
					(Load rsVIEW 42013)
					(self setScript: rosEnter)
				)
				((IsFlag 467)
					(SetFlag 468)
					(= local0 43)
					(bolts init:)
					(coroner view: 4201 setLoop: 3 setCel: 13 posn: 51 89)
					(Load rsVIEW 42013)
					(self setScript: rosEnter)
				)
				((IsFlag 466)
					(= local0 42)
					(SetFlag 467)
					(self setScript: roseTalkNoBack2)
				)
				(else
					(= local0 41)
					(SetFlag 466)
					(bolts init:)
					(coroner view: 4201 setLoop: 3 1 setCel: 13 posn: 51 89)
					(Load rsVIEW 42013)
					(self setScript: rosEnter)
				)
			)
		else
			(gEgo setScaler: Scaler 98 69 138 82)
			(if (IsFlag 203)
				(partsBox init:)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 31 149 250 150 253 154 237 116 219 116 219 100 232 100 232 92 214 92 200 85 103 85 87 90 40 90 17 102 60 102 36 114 10 114 10 134 30 146
							yourself:
						)
				)
			else
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 10 132 22 149 242 151 247 127 239 116 218 116 215 103 229 103 229 93 214 93 207 87 175 83 105 83 89 90 45 90 10 103
							yourself:
						)
				)
			)
			(if (not (IsFlag 207))
				(coffin init:)
			)
			(if (== gPrevRoomNum 6550)
				(gCurRoom setScript: wakeUp)
			else
				(cond
					((and (not (IsFlag 564)) (not (IsFlag 511)))
						(= local0 51)
					)
					((not (IsFlag 549))
						(SetFlag 549)
						(if (IsFlag 512)
							(= local0 53)
						else
							(= local0 52)
						)
					)
					(else
						(= local0 54)
					)
				)
				(gCurRoom setScript: valEnter)
			)
		)
		(Load 140 802) ; WAVE
		(coroner init:)
		(coronerTalker client: coroner)
		(hannibalTalker client: ratJar)
		(if (not (gCast contains: bolts))
			(= local1 1)
			(bolts init:)
		)
	)

	(method (doit)
		(super doit: &rest)
		(if (and (== (coroner view:) 42013) (== (coroner cel:) 57))
			(coroner setPri: 112)
		)
	)

	(method (dispose)
		(gKqMusic1 fade:)
		(ClearFlag 192)
		(coronerTalker hide_mouth: 0)
		(super dispose:)
	)

	(method (cue)
		(switch local0
			(41
				(if (gCurRoom script:)
					(gEgo normalize: 1)
				)
			)
			(43
				(gEgo normalize: 1)
			)
			(44
				(gEgo normalize: 1)
			)
			(42
				(proc4200_1)
				(gGame handsOn:)
				(gMessager say: 0 0 2 3 coroner) ; "(AMIABLE)What can I do for you, Miss Rosella?"
			)
		)
	)
)

(instance rosEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(frontDoor setCel: 0)
				(if (== local0 42)
					(gEgo posn: 78 92 normalize: 4)
					(= cycles 96)
				else
					(gEgo posn: 38 92)
				)
				(switch local0
					(41
						(gCurRoom setScript: roseTalkNoBack1)
					)
					(42
						(gCurRoom setScript: roseTalkNoBack2)
					)
					(43
						(gCurRoom setScript: roseTalkNoBack1)
					)
					(44
						(gCurRoom setScript: roseTalkNoBack1)
					)
					(45
						(gCurRoom setScript: roseGotPet)
					)
					(else
						(gGame handsOn:)
						(self dispose:)
					)
				)
			)
		)
	)
)

(instance roseAsWomanInBlack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(frontDoor setCel: 0)
				(gEgo posn: 78 96 normalize: 7)
				(coroner
					view: 4210
					setLoop: 0 1
					setCel: 0
					setScale:
					scaleX: 114
					scaleY: 114
					posn: 46 92
				)
				((ScriptID 7001 0) client: frontDoor hide_mouth: 1) ; kingTalker
				(coroner setCycle: End self)
			)
			(1
				(switch local0
					(46
						(gMessager say: 0 0 14 0 self) ; "(SURPRISED AND HAPPY TO SEE ROSELLA, BUT NERVOUS FOR HER)My dear Rosella! I'm happy to see you're still breathing. However, Malicia and her horrible gargoyle are hunting for you, so you'd best get out of Ooga Booga as fast as you can."
					)
					(47
						(gMessager say: 1 8 15 0 self) ; "(CONCERNED)You left in such a hurry, my dear! You'd best get out of Ooga Booga while you still can."
					)
					(48
						(self cue:)
					)
				)
			)
			(2
				(coroner
					setLoop: 1 1
					setCel: 2
					setStep: 5 3
					setCycle: Fwd
					scaleX: 128
					scaleY: 128
					setPri: 89
					ignoreActors:
					setMotion: MoveTo 90 100 self
				)
			)
			(3
				(gEgo setHeading: 90)
				(coroner
					setPri: 113
					ignoreActors:
					setMotion: MoveTo 290 108 self
				)
			)
			(4
				(coroner
					view: 4210
					setLoop: 7 1
					setCel: 0
					posn: 276 118
					setCycle: CT 5 1 self
				)
			)
			(5
				(coroner setPri: 139 setCycle: End self)
			)
			(6
				(coroner setScript: sWrite)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGiveDefoliant of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff: 1)
					(gMessager sayRange: 1 8 16 1 4 self) ; "(WORRIED)We'd love to leave Ooga Booga, but the entrance to the Underground has collapsed. It looks like it's sealed off for good."
				)
				(1
					(coroner
						view: 4210
						setScript: 0
						setLoop: 2 1
						setCycle: Fwd
						setPri: -1
						ignoreActors:
						setMotion: MoveTo 247 92 self
					)
					(gEgo setMotion: MoveTo 202 96)
				)
				(2
					(coroner
						setScale:
						scaleX: 114
						scaleY: 114
						setLoop: 3 1
						setCel: 0
						setCycle: 0
						x: 218
						y: 92
					)
					(coronerTalker hide_mouth: 1)
					(gEgo setHeading: 45)
					(= cycles 3)
				)
				(3
					(gMessager say: 1 8 16 5 self) ; "No...no...that won't work...that one grows hair on bald werewolves...that one grows new tentacles...that one makes your head fall off...AHA!"
				)
				(4
					(soundEffect number: 4223 setLoop: 1 play: self)
				)
				(5
					(coroner setCycle: End self)
				)
				(6
					(gEgo
						setScaler: 0
						scaleX: 108
						scaleY: 108
						view: 4210
						setLoop: 4 1
						setCel: 0
						x: 202
						y: 96
						setCycle: CT 2 1 self
					)
				)
				(7
					(coroner z: 1000)
					(gEgo get: 52 setCycle: CT 6 1 self) ; Defoliant
				)
				(8
					(coroner
						z: 0
						setLoop: 1 1
						setCel: 1
						setCycle: Fwd
						scaleX: 128
						scaleY: 128
						x: (+ (coroner x:) 7)
						y: (+ (coroner y:) 3)
						ignoreActors:
						setMotion: MoveTo 286 102 self
					)
					(coronerTalker hide_mouth: 0)
					(gEgo setCycle: End)
				)
				(9
					(coroner
						view: 4210
						setLoop: 7 1
						setCel: 0
						x: 276
						y: 118
						setPri: 103
						setCycle: CT 4 1 self
					)
				)
				(10
					(coroner setPri: 139 setCycle: End self)
					(gEgo
						normalize: 4
						setScaler: Scaler 118 98 138 82
						x: (- (gEgo x:) 7)
						y: (- (gEgo y:) 7)
					)
				)
				(11
					(coroner setScript: sWrite)
					(localproc_0)
					(gMessager sayRange: 1 8 16 6 7 self) ; "What is it? It smells AWFUL!"
				)
				(12
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(= cycles 2)
				)
				(1
					(ClearFlag 539)
					(coroner z: 0 setScript: sWrite)
					(gEgo
						get: 52 ; Defoliant
						normalize: 4
						setScaler: Scaler 118 98 138 82
						x: 195
						y: 89
					)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance roseGotPet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo normalize: 0)
				(coroner posn: (- (coroner x:) 3) (+ (coroner y:) 2))
				(= cycles 3)
			)
			(1
				(gMessager say: 1 8 9 0 self) ; "(CONFIDENT AND CHEERFUL)Hello, Miss Rosella. You are looking lovely, as always."
			)
			(2
				(gEgo setMotion: MoveTo 55 92 self)
			)
			(3
				(gEgo
					view: 8485
					setLoop: 1 1
					setCel: 0
					posn: 55 92
					setCycle: CT 4 1 self
				)
			)
			(4
				(if (not local1)
					(bolts setCycle: End)
					(soundEffect number: 4206 setLoop: 1 play:)
					(gEgo setCycle: End self)
					(frontDoor setCycle: End)
				else
					(frontDoor setCycle: End self)
					(soundEffect number: 801 setLoop: 1 play:)
					(if (IsFlag 151)
						(gEgo setHeading: 315)
					)
				)
			)
			(5
				(frontDoor z: 1000)
				(gEgo normalize: 1 setMotion: MoveTo -5 87 self)
			)
			(6
				(frontDoor show: z: 0 setCycle: CT 5 -1 self)
			)
			(7
				(coroner
					setScale:
					scaleX: 162
					scaleY: 162
					view: 4212
					setLoop: 0
					setCel: 0
					posn: (- (coroner x:) 18) (+ (gEgo y:) 12)
					setCycle: CT 22 1 self
				)
			)
			(8
				(frontDoor setCycle: Beg self)
				(coroner setCycle: End)
			)
			(9
				(soundEffect number: 802 setLoop: 1 play: self)
			)
			(10
				(gCurRoom newRoom: 4102)
			)
		)
	)
)

(instance roseTalkNoBack1 of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff: 1)
					(gEgo posn: 88 (gEgo y:) normalize: 1)
					(frontDoor setCel: 0)
					(coroner setCel: 0 setCycle: CT 5 1 self)
				)
				(1
					(coroner setCycle: End self)
					(bolts setCycle: Beg)
					(soundEffect number: 4206 setLoop: 1 play:)
				)
				(2
					(coroner
						setLoop: 4 1
						setCel: 0
						posn: 54 92
						setCycle: End self
					)
				)
				(3
					(switch local0
						(41
							(gMessager sayRange: 0 0 1 1 5 self) ; "(FRIENDLY)Welcome to Ooga Booga, Miss Rosella. I am Dr. Mort Cadaver, Coroner. How may I help you?"
						)
						(43
							(gMessager say: 0 0 3 0 self) ; "Hello, Dr. Cadaver."
						)
						(44
							(gMessager say: 0 0 4 0 self) ; "Welcome, Miss Rosella. Please, make yourself at home."
						)
					)
				)
				(4
					(if (== local0 41)
						(coroner
							setLoop: 5 1
							setCel: 0
							posn: 53 94
							setCycle: End self
						)
					else
						(++ state)
						(self cue:)
					)
				)
				(5
					(gMessager say: 0 0 1 6 self) ; "Oh well. Excuse me, my dear. I must fill out some death certificates now."
				)
				(6
					(gEgo setHeading: 90)
					(coroner
						view: 42013
						setLoop: 1 1
						setCycle: Fwd
						ignoreActors:
						setMotion: MoveTo 286 102 self
					)
				)
				(7
					(coroner setLoop: 7 1 setScript: sWrite)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(= cycles 2)
				)
				(1
					(ClearFlag 539)
					(coroner setLoop: 7 1 setScript: sWrite)
					(frontDoor setCel: 0)
					(gEgo normalize: 0)
					(bolts setCel: 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance roseTalkNoBack2 of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff: 1)
					(coroner
						view: 4202
						setLoop: 1 1
						setCel: 0
						posn: 85 127
						setPri: 131
					)
					(monster init: setPri: 130)
					(gEgo posn: 78 92 normalize: 4)
					(frontDoor setCel: 0)
					(monsterTalker client: monster)
					(Load rsVIEW 4205)
					(Load rsVIEW 4204)
					(Load rsVIEW 42013)
					(Load 140 4210) ; WAVE
					(Load 140 4211) ; WAVE
					(Load 140 830) ; WAVE
					(= cycles 2)
				)
				(1
					(gMessager say: 0 0 2 1 self) ; "(KINDLY)Excuse me, Miss Rosella. I'll be right with you. Now then, Mr. Bugbear, let's just fix that broken heart of yours."
				)
				(2
					(coroner setCycle: CT 8 1 self)
					(monster setCycle: End)
				)
				(3
					(coroner setCycle: End self)
					(monster z: 1000)
				)
				(4
					(monster
						z: 0
						setLoop: 3
						setCel: 0
						posn: 137 113
						setCycle: End
					)
					(coroner
						setLoop: 2 1
						setCel: 0
						posn: 91 126
						setCycle: End self
					)
				)
				(5
					(coroner
						view: 4204
						setLoop: 0 1
						setCel: 0
						posn: 99 125
						setCycle: End self
					)
				)
				(6
					(coroner
						setLoop: 1 1
						setCel: 0
						posn: 100 127
						setCycle: CT 9 1 self
					)
					(monster
						view: 4204
						setLoop: 3 1
						setCel: 0
						posn: 131 110
						setCycle: End
					)
				)
				(7
					(stapleSound setLoop: -1 play:)
					(coroner setCycle: CT 24 1 self)
				)
				(8
					(stapleSound stop:)
					(coroner setCycle: End self)
				)
				(9
					(monster z: 1000)
					(coroner
						setLoop: 5 1
						setCel: 0
						posn: 123 127
						setCycle: CT 4 1 self
					)
				)
				(10
					(soundEffect number: 830 setLoop: 1 play:)
					(monster
						z: 0
						view: 4205
						setLoop: 0 1
						setCel: 0
						posn: 139 106
						setCycle: End self
					)
					(coroner setCycle: End)
				)
				(11
					(soundEffect number: 4211 setLoop: 1 play:)
					(monster setLoop: 1 1 setCel: 0 setCycle: End self)
				)
				(12
					(monster setLoop: 2 1 setCel: 0 setCycle: End self)
				)
				(13
					(gMessager say: 0 0 2 2 self) ; "(VERY GRATEFUL; MONSTER VOICE)Thank you, Dr. Cadaver!"
				)
				(14
					(monster
						setLoop: 3 1
						setCel: 0
						setPri: 135
						setCycle: CT 9 1 self
					)
				)
				(15
					(soundEffect number: 949 setLoop: 1 play:)
					(monster cel: 10 setCycle: End self)
					(Load 140 950) ; WAVE
				)
				(16
					(gEgo setScript: doorForMonster)
					(monster
						view: 4205
						setLoop: 4 1
						setCel: 0
						posn: 79 134
						setCycle: Fwd
						setStep: 5 4
						setSpeed: 8
						setMotion: MoveTo 20 133 self
						ignoreActors:
					)
					(soundEffect number: 950 setLoop: -1 play:)
				)
				(17
					(monster setPri: 92 setMotion: MoveTo 17 101 self)
				)
				(18
					(monster setMotion: MoveTo 1 90 self)
					(coroner
						view: 42013
						setLoop: 0 1
						setCel: 0
						posn: 175 135
						setPri: 142
						setCycle: End gCurRoom
					)
				)
				(19
					(soundEffect fade:)
					(Load rsVIEW 4201)
					(monster setMotion: MoveTo -20 90 self)
				)
				(20
					(frontDoor z: 0 setCycle: Beg self)
					(monster dispose:)
				)
				(21
					(soundEffect number: 802 setLoop: 1 play:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(= cycles 2)
				)
				(1
					(ClearFlag 539)
					(stapleSound stop:)
					(frontDoor z: 0 setCel: 0)
					(gEgo normalize: 4 setScript: 0)
					(coroner setScript: sWrite)
					(if (gCast contains: monster)
						(monster dispose:)
					)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance doorForMonster of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 55 87 self)
			)
			(1
				(gEgo
					view: 8485
					setLoop: 1 1
					setCel: 0
					posn: 55 92
					setCycle: CT 4 1 self
				)
			)
			(2
				(gEgo setCycle: End self)
				(frontDoor setCycle: End frontDoor)
			)
			(3
				(gEgo normalize: 1 setHeading: 135)
				(self dispose:)
			)
		)
	)
)

(instance sStampPapers of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 1 8 8 0 self) ; "(POLITE BUT DISTRACTED)Excuse me, my dear, but my nerves are shot, and I'm at a very delicate point in this process."
			)
			(1
				(Load 140 4212) ; WAVE
				(soundEffect number: 4212 setLoop: 1)
				(coroner
					view: 4206
					setLoop: 2 1
					setCel: 0
					x: 289
					y: 103
					setCycle: CT 11 1 self
				)
			)
			(2
				(soundEffect play:)
				(coroner setCycle: CT 13 1 self)
			)
			(3
				(coroner setCycle: CT 7 -1 self)
			)
			(4
				(coroner setCycle: CT 11 1 self)
			)
			(5
				(soundEffect play:)
				(coroner setCycle: CT 13 1 self)
			)
			(6
				(coroner setCycle: CT 7 -1 self)
			)
			(7
				(coroner setCycle: CT 11 1 self)
			)
			(8
				(soundEffect play:)
				(coroner setCycle: End self)
			)
			(9
				(coroner setScript: sWrite)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance giveBackBone of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff: 1)
					(SetFlag 155)
					(Load 140 4214) ; WAVE
					(Load rsVIEW 4207)
					(coroner setHotspot: 0 approachVerbs: 0)
					(gEgo setMotion: PolyPath 239 116 self)
				)
				(1
					(gMessager say: 1 66 0 1 self) ; "(PLAYFULLY)Dr. Cadaver, I have a surprise for you!"
				)
				(2
					(gEgo
						view: 4206
						setLoop: 4 1
						setCel: 0
						x: 229
						y: 116
						setCycle: CT 7 1 self
					)
				)
				(3
					(coroner
						view: 4206
						setLoop: 3 1
						setCel: 0
						x: 290
						y: 104
						setPri: 110
						setCycle: End self
					)
				)
				(4
					(SetFlag 173)
					(gEgo put: 50 setCycle: End self) ; Back_Bone
				)
				(5
					(coroner view: 4206 setLoop: 5 1 setCel: 0 x: 296 y: 103)
					(gEgo setLoop: 6 1 setCel: 0 setCycle: End self)
				)
				(6
					(gEgo normalize: 0)
					(coroner setPri: 103 setCycle: CT 15 1 self)
				)
				(7
					(soundEffect number: 4213 setLoop: 1 play:)
					(coroner setCycle: CT 32 1 self)
				)
				(8
					(gMessager say: 1 66 0 2 self) ; "(GRATEFUL, HAPPY)Oh, I am eternally grateful to you. I would like to repay you in some small way."
				)
				(9
					(coroner setCycle: End self)
					(gEgo setMotion: PolyPath 200 90)
				)
				(10
					(coroner
						view: 4207
						setLoop: 0
						setCel: 0
						x: 236
						y: 88
						setCycle: End self
					)
					(theBox setCycle: End)
					(soundEffect number: 4214 setLoop: 1 play:)
					(Load 140 4279) ; WAVE
				)
				(11
					(soundEffect number: 4223 setLoop: 1 play: self)
				)
				(12
					(gEgo setHeading: 45)
					(theBox dispose:)
					(coroner
						view: 4207
						setLoop: 2 1
						setCel: 0
						x: 242
						y: 89
						setCycle: CT 12 1 self
					)
				)
				(13
					(gEgo z: 1000)
					(coroner setCycle: CT 18 1 self)
				)
				(14
					(gEgo
						z: 0
						view: 4207
						setLoop: 3 1
						setCel: 0
						setCycle: 0
						setScaler: 0
						scaleX: 122
						scaleY: 122
						x: 207
						y: 92
					)
					(coroner setCycle: End self)
				)
				(15
					(gMessager sayRange: 1 66 0 3 4 self) ; "(HAPPY, PROUD)Here, just what every young lady needs! A dear little pet to keep her company. I made him myself!"
				)
				(16
					(gEgo setCycle: End self)
					(coroner
						view: 4210
						setLoop: 1 1
						setCycle: Fwd
						ignoreActors:
						setMotion: MoveTo 286 102 coroner
					)
					(soundEffect2 number: 4279 setLoop: 1 play:)
				)
				(17
					(gEgo
						view: 4207
						setLoop: 4 1
						setCel: 0
						x: 204
						y: 91
						scaleX: 114
						scaleY: 114
						setCycle: End self
					)
					(soundEffect2 number: 4215 setLoop: 1 play:)
				)
				(18
					(gEgo
						view: 4207
						setLoop: 5
						setCel: 0
						x: 183
						y: 90
						scaleX: 110
						scaleY: 110
						setCycle: End self
					)
					(soundEffect number: 805 setLoop: 1 play:)
				)
				(19
					(SetFlag 183)
					(gEgo
						normalize: 4
						get: 51 ; Weird_Pet
						posn: 178 89
						setScaler: Scaler 108 83 138 82
					)
					(coroner setScript: sWrite)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(= cycles 2)
				)
				(1
					(ClearFlag 539)
					(SetFlag 173)
					(SetFlag 183)
					(SetFlag 155)
					(gEgo
						put: 50 ; Back_Bone
						get: 51 1 ; Weird_Pet
						posn: 178 89
						z: 0
						setScaler: Scaler 108 83 138 82
						normalize: 4
					)
					(if (gCast contains: theBox)
						(theBox dispose:)
					)
					(coroner setHotspot: 0 approachVerbs: 0 setScript: sWrite)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance exitParlor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load 140 801) ; WAVE
				(gGame handsOff:)
				(if (== gValOrRoz -3) ; Roz
					(if (IsFlag 151)
						(gEgo setMotion: PolyPath 40 92 self)
					else
						(gEgo
							view: 8485
							setLoop: 1 1
							setCel: 0
							posn: 55 92
							setCycle: CT 4 1 self
						)
					)
				else
					(gEgo
						view: 8125
						setLoop: 1 1
						setCel: 0
						posn: 55 92
						setCycle: CT 11 1 self
					)
				)
			)
			(1
				(if (== gValOrRoz -3) ; Roz
					(if (not local1)
						(bolts setCycle: End)
						(soundEffect number: 4206 setLoop: 1 play:)
						(gEgo setCycle: End self)
						(frontDoor setCycle: End)
					else
						(frontDoor setCycle: End self)
						(soundEffect number: 801 setLoop: 1 play:)
						(if (IsFlag 151)
							(gEgo setHeading: 315)
						)
					)
				else
					(gEgo setCycle: Beg self)
					(frontDoor setCycle: End)
				)
			)
			(2
				(frontDoor z: 1000)
				(gEgo normalize: 1 setMotion: MoveTo -5 87 self)
			)
			(3
				(frontDoor z: 0 setCycle: Beg self)
			)
			(4
				(soundEffect number: 802 setLoop: 1 play: self)
			)
			(5
				(gCurRoom newRoom: 4102)
			)
		)
	)
)

(instance valEnter of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo posn: 38 92 normalize: 0)
				(frontDoor setCel: 0)
				(= cycles 3)
			)
			(1
				(switch local0
					(51
						(if (IsFlag 512)
							(gMessager say: 0 0 28 0 self) ; "(COURTLY)How can I help you, Lady Valanice?"
						else
							(gMessager say: 0 0 22 0 self) ; "(FRIENDLY)So you are the mother of the charming Miss Rosella. Pleased to meet you, lady..."
						)
					)
					(52
						(gMessager say: 0 0 27 0 self) ; "(COURTLY)I am Dr. Mort Cadaver, at your service, my lady. Something seems to be troubling you. Can I be of assistance?"
					)
					(53
						(gMessager say: 0 0 28 0 self) ; "(COURTLY)How can I help you, Lady Valanice?"
					)
					(54
						(gMessager say: 0 0 35 0 self) ; "Ah, there you are. I'll help you if I can, madam."
					)
				)
			)
			(2
				(SetFlag 512)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sWrite of Script
	(properties)

	(method (init)
		(proc4200_1)
		(UpdateScreenItem coroner)
		(FrameOut)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(writingSound setLoop: -1 play:)
				(client setCycle: ForwardCounter (Random 3 8) self)
			)
			(1
				(writingSound stop:)
				(= seconds (Random 6 12))
			)
			(2
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance valSleeps of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsPALETTE 4201)
				(gMessager say: 2 8 34 1 self) ; "(RELUCTANTLY)I suppose I could try to sleep here..."
			)
			(1
				(coroner
					setLoop: 1 1
					setCycle: Fwd
					ignoreActors:
					setMotion: MoveTo 148 94 self
				)
			)
			(2
				(coroner ignoreActors: setMotion: MoveTo 173 89 self)
			)
			(3
				(coroner setLoop: 2 setCycle: 0 x: 168)
				(gMessager say: 2 8 34 2 self) ; "(PLEASED)Please do! I'll make sure you're not disturbed."
			)
			(4
				(gEgo
					view: 4213
					setLoop: 0
					setCel: 0
					x: 135
					y: 85
					setScaler: 0
					scaleX: 128
					scaleY: 128
					setCycle: End self
				)
			)
			(5
				(gEgo view: 4213 setLoop: 1 setCel: 0 x: 138 y: 74)
				(gMessager say: 2 8 34 3 self) ; "Thank you."
			)
			(6
				(coroner
					view: 4213
					setLoop: 2
					setCel: 0
					x: 173
					y: 89
					setCycle: CT 16 1 self
				)
			)
			(7
				(gEgo setCel: 1)
				(coroner setCycle: End self)
			)
			(8
				(PalVary 0 4201 5 100 104 236) ; PalVaryStart
				(= seconds 5)
				(gMessager say: 2 8 34 4) ; "(KINDLY)Here you are, my dear. Sweet dreams."
			)
			(9
				(PalVary 3) ; PalVaryKill
				(gCurRoom newRoom: 6350)
			)
		)
	)
)

(instance wakeUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(PalVary 3) ; PalVaryKill
				(Load 140 4202) ; WAVE
				(Load rsVIEW 4211)
				(Load 140 801) ; WAVE
				(frontDoor setCel: 0)
				(gEgo
					view: 4215
					setLoop: 0
					setCel: 0
					x: 120
					y: 74
					setCycle: End self
					setScaler: 0
					scaleX: 128
					scaleY: 128
				)
				(coroner view: 4215 setLoop: 2 1 setCel: 0 x: 222 y: 91)
			)
			(1
				(soundEffect number: 4202 setLoop: 1 play:)
				(gEgo setLoop: 1 setCel: 0 x: 145 y: 77 setCycle: End)
				(coroner setCycle: CT 8 1 self)
			)
			(2
				(coroner
					setCycle: End
					ignoreActors:
					setMotion: MoveTo 193 90 self
				)
			)
			(3
				(gMessager say: 0 0 36 1 self) ; "(CONCERNED)My lady! Are you all right?"
			)
			(4
				(gMessager say: 0 0 36 2 self) ; "(STILL KIND OF SPACED OUT)I went to Dreamland...and Mab..she was frozen! She was a solid block of ice!"
			)
			(5
				(gMessager say: 0 0 36 3 self) ; "(DEEPLY CONCERNED)Oh dear! Mab was never know for her warm personality, but that doesn't sound right at all."
			)
			(6
				(gEgo
					normalize: 0
					posn: 144 88
					setScaler: Scaler 98 69 138 82
					hide:
				)
				(coroner
					view: 4215
					setLoop: 3
					setCel: 0
					x: 161
					y: 87
					setCycle: End self
				)
			)
			(7
				(coroner view: 4211 setLoop: 2 1 setCycle: 0)
				(gEgo show:)
				(gMessager say: 0 0 36 4 self) ; "(SCARED BUT DETERMINED)It looks like things are worse than we knew. I must go. Thank you, Dr. Cadaver. You've been very kind."
			)
			(8
				(coroner
					setLoop: 4 1
					posn: 162 86
					setCycle: Fwd
					setMotion: PolyPath (- (frontDoor approachX:) 18) 90 self
				)
				(gEgo setMotion: PolyPath (frontDoor approachX:) 94)
			)
			(9
				(coroner
					setLoop: 2
					setPri: 88
					setCycle: 0
					posn: (- (coroner x:) 3) (coroner y:)
				)
				(frontDoor setCycle: End self)
				(soundEffect number: 801 setLoop: 1 play:)
			)
			(10
				(frontDoor z: 1000)
				(gMessager say: 0 0 36 5 self) ; "(SINCERELY)I wish you the best of luck, Lady Valanice. Farewell!"
			)
			(11
				(gEgo setMotion: MoveTo 0 92 self)
			)
			(12
				(gEgo setMotion: MoveTo -15 92)
				(coroner posn: 34 93 setLoop: 2 setCycle: 0)
				(frontDoor show: z: 0 setCycle: CT 7 -1 self)
			)
			(13
				(coroner
					view: 4212
					setLoop: 0
					setCel: 0
					posn: 37 93
					setCycle: End self
				)
			)
			(14
				(frontDoor setCycle: Beg self)
			)
			(15
				(soundEffect number: 802 setLoop: 1 play: self)
			)
			(16
				(SetFlag 566)
				(gCurRoom newRoom: 4102)
			)
		)
	)
)

(instance sValFirstEscort of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 801) ; WAVE
				(gMessager say: 1 8 26 1 self) ; "(POLITELY, APOLOGETICALLY)Forgive me, Lady Valanice, but I have to make a house call."
			)
			(1
				(coroner
					view: 4211
					setLoop: 4 1
					setCycle: Fwd
					ignoreActors:
					setMotion: MoveTo (- (coroner x:) 5) (coroner y:) self
				)
			)
			(2
				(gEgo setMotion: PolyPath (frontDoor approachX:) 92)
				(coroner
					ignoreActors:
					setMotion: MoveTo (+ (frontDoor approachX:) 20) 90 self
				)
			)
			(3
				(coroner
					posn: (- (coroner x:) 5) (coroner y:)
					setLoop: 2
					setCycle: 0
				)
				(gMessager say: 1 8 26 2 self) ; "Good evening, Valanice. I will let you know if I hear word of Rosella."
			)
			(4
				(gEgo setHeading: 45 self)
			)
			(5
				(gMessager say: 1 8 26 3 self) ; "Thank you, doctor. Goodnight."
			)
			(6
				(frontDoor setCycle: End self)
				(soundEffect number: 801 setLoop: 1 play:)
			)
			(7
				(frontDoor hide:)
				(gEgo setMotion: MoveTo -10 92 self)
				(coroner
					setLoop: 4 1
					setCycle: Fwd
					posn: (+ (coroner x:) 5) (coroner y:)
					ignoreActors:
					setMotion: MoveTo 43 95 coroner
				)
			)
			(8
				(coroner posn: 38 95 setLoop: 2 setCycle: 0)
				(frontDoor show: setCycle: CT 7 -1 self)
			)
			(9
				(coroner view: 4212 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(10
				(frontDoor setCycle: Beg self)
			)
			(11
				(soundEffect number: 802 setLoop: 1 play: self)
			)
			(12
				(gCurRoom newRoom: 4102)
			)
		)
	)
)

(instance sHannibal of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(ratJar setCycle: Fwd)
				(gKqMusic1 pause: 1)
				(soundEffect number: 4220 setLoop: 1 play:)
				(soundEffect2 number: 4221 setLoop: 1 play: self)
			)
			(1
				(ratJar setCycle: 0 setCel: 0)
				(gKqMusic1 pause: 0)
				(gMessager say: 4 8 10 0 self) ; "(HORRIFIED)What's wrong with HIM?"
			)
			(2
				(coroner cue:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sHannibalBlack of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(ratJar setCycle: Fwd)
				(gKqMusic1 pause: 1)
				(soundEffect number: 4220 setLoop: 1 play:)
				(soundEffect2 number: 4222 setLoop: 1 play: self)
			)
			(1
				(ratJar setCycle: 0 setCel: 0)
				(gKqMusic1 pause: 0)
				(gMessager say: 4 8 12 0 self) ; "(FROM INSIDE JAR)Tell me about your father, Rosella!"
			)
			(2
				(gKqMusic1 pause: 0)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sSitDown of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(coroner
					view: 4210
					setLoop: 7 1
					setCel: 0
					posn: 276 118
					setCycle: CT 5 1 self
				)
			)
			(1
				(coroner setPri: 139 setCycle: End self)
			)
			(2
				(coroner setScript: sWrite)
			)
		)
	)
)

(instance sRoseLookCoffin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(localproc_0)
				(gMessager say: 2 8 10 1 self) ; "(WORRIED)That's, um, quite a nice coffin. What do you use it for?"
			)
			(1
				(gEgo setHeading: 135 self)
			)
			(2
				(gMessager say: 2 8 10 2 self) ; "(NICELY, NOT SCARY)Most of my patients like to nap here while they're waiting, my dear. To tell you the truth, I nap in it myself when business is slow. It's SOOOOO comfortable!"
			)
			(3
				(coroner setScript: sWrite)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance coroner of Actor
	(properties
		noun 1
		sightAngle 40
		approachX 218
		approachY 107
		x 70
		y 88
		view 4211
		loop 2
		cel 1
	)

	(method (setScript)
		(writingSound stop:)
		(super setScript: &rest)
	)

	(method (cue)
		(if (== (gCurRoom script:) sValFirstEscort)
			(self setCycle: 0)
		else
			(self setScript: sWrite)
		)
	)

	(method (init)
		(super init:)
		(|= signal $1000)
		(self approachVerbs: 8 10) ; Do, Exit
		(if (not (IsFlag 558))
			(self setHotspot: 8 10 66) ; Do, Exit, Back_Bone
		)
		(if (== gValOrRoz -4) ; Val
			(self approachX: 38 approachY: 92)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(cond
					((== gValOrRoz -3) ; Roz
						(cond
							((IsFlag 151)
								(cond
									((IsFlag 473)
										(localproc_0)
										(gMessager say: noun theVerb 21 0 self) ; "(AS A SCARAB)Rosella, we must hurry! Let's resume our journey!"
									)
									((IsFlag 472)
										(SetFlag 473)
										(localproc_0)
										(gMessager say: noun theVerb 20 0 self) ; "Thank you for all the help, Dr. Cadaver. You've been more than kind."
									)
									((IsFlag 471)
										(SetFlag 472)
										(localproc_0)
										(gMessager say: noun theVerb 19 0 self) ; "Does that little black cat belong to you, Dr. Cadaver?"
									)
									((IsFlag 470)
										(SetFlag 471)
										(localproc_0)
										(gMessager say: noun theVerb 18 0 self) ; "So, this thing Malicia put by the Ooga Booga gateway is a plant?"
									)
									((IsFlag 469)
										(SetFlag 470)
										(localproc_0)
										(gMessager say: noun theVerb 17 0 self) ; "How does your new backbone fit?"
									)
									(else
										(SetFlag 469)
										(localproc_0)
										(gCurRoom setScript: sGiveDefoliant)
									)
								)
							)
							((IsFlag 463)
								(localproc_0)
								(gCurRoom setScript: sStampPapers)
							)
							((IsFlag 462)
								(SetFlag 463)
								(localproc_0)
								(gMessager say: noun theVerb 7 0 self) ; "Doctor, what can you tell me about the Boogeyman?"
							)
							((IsFlag 155)
								(SetFlag 462)
								(localproc_0)
								(gMessager say: noun theVerb 6 0 self) ; "Dr. Cadaver, who exactly are these kids?"
							)
							(else
								(SetFlag 155)
								(localproc_0)
								(gMessager say: noun theVerb 5 0 self) ; "(CONCERNED)Dr. Cadaver, you really should have a spine. Can you get yours back?"
							)
						)
					)
					((== local0 51)
						(cond
							((not (IsFlag 507))
								(SetFlag 507)
								(gMessager say: noun theVerb 23 0) ; "(HOPEFUL, URGENT)When was the last time you saw my daughter? Where was she going?"
							)
							((not (IsFlag 508))
								(SetFlag 508)
								(gMessager say: noun theVerb 24 0) ; "(WORRIED)Dr. Cadaver, how was Rosella when you spoke with her? did she seem well?"
							)
							((not (IsFlag 509))
								(SetFlag 509)
								(gMessager say: noun theVerb 25 0) ; "Dr. Cadaver, I hope this isn't rude of me, but is everyone in Ooga Booga...well...dead?"
							)
							(else
								(SetFlag 564)
								(gCurRoom setScript: sValFirstEscort)
							)
						)
					)
					((or (== local0 52) (== local0 53) (== local0 54))
						(if (IsFlag 546)
							(if (IsFlag 547)
								(gMessager say: 1 8 31) ; "(NERVOUS)Do you promise you won't close the lid while I'm in the coffin?"
								(SetFlag 558)
								(self setHotspot: 0 approachVerbs: 0)
							else
								(SetFlag 547)
								(gMessager say: 1 8 32) ; "(WORRIED)Sleep...in the coffin?"
							)
						else
							(SetFlag 546)
							(if (== local0 52)
								(gMessager say: 1 8 29) ; "(WORRIED)You're a doctor? Can you cure insomnia?"
							else
								(gMessager say: 1 8 30) ; "(WORRIED)It's a long story, doctor, but what it comes down to is that I must travel to Dreamland to see Lady Mab, but I can't find a safe place to sleep!"
							)
						)
					)
				)
			)
			(66 ; Back_Bone
				(localproc_0)
				(gCurRoom setScript: giveBackBone)
			)
		)
		(if (IsFlag 511)
			(SetFlag 510)
		)
		(return 1)
	)
)

(instance monster of Actor
	(properties
		x 127
		y 113
		priority 131
		fixPriority 1
		view 4202
		cel 1
	)
)

(instance theBox of Prop
	(properties
		x 254
		y 69
		view 4207
		loop 1
	)
)

(instance coffin of Feature
	(properties
		noun 2
		approachX 135
		approachY 85
	)

	(method (init)
		(super init:)
		(self
			setHotspot: 8 10 ; Do, Exit
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 101 33 110 52 96 64 116 75 165 75 182 65 166 51 183 35 139 26
					yourself:
				)
			approachVerbs: 8 10 ; Do, Exit
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if (== gValOrRoz -4) ; Val
					(if (and (IsFlag 510) (IsFlag 511))
						(gCurRoom setScript: valSleeps)
					else
						(gMessager say: noun theVerb 33) ; "(THINKS TO HERSELF)Hmm, that looks nice and soft...Egad, what am I thinking?"
					)
				else
					(SetFlag 479)
					(gCurRoom setScript: sRoseLookCoffin)
					(self dispose:)
				)
				(return 1)
			)
		)
	)
)

(instance shelves of Feature
	(properties
		noun 3
		approachX 210
		approachY 90
		x 230
		y 45
	)

	(method (init)
		(super init:)
		(self
			setHotspot: 8 10 ; Do, Exit
			setPolygon:
				((Polygon new:)
					type: PNearestAccess
					init: 202 67 213 56 210 45 202 40 202 15 216 6 250 7 264 12 261 67
					yourself:
				)
			approachVerbs: 8 10 ; Do, Exit
		)
	)

	(method (doVerb theVerb)
		(SetFlag 477)
		((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
		(gMessager say: noun theVerb 10 0)
		((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
		(self dispose:)
		(return 1)
	)
)

(instance candle1 of Prop
	(properties
		x 123
		y 12
		view 4200
	)
)

(instance candle2 of Prop
	(properties
		x 146
		y 12
		view 4200
		loop 1
	)
)

(instance candle3 of Prop
	(properties
		x 56
		y 38
		view 4200
		loop 2
	)
)

(instance bolts of Prop
	(properties
		x 31
		y 54
		view 4201
		loop 1
		cel 6
	)

	(method (init)
		(Load 140 4206) ; WAVE
		(frontDoor approachX: 55)
		(exitDoor approachX: 55)
		(super init: &rest)
	)
)

(instance exitDoor of ExitFeature
	(properties
		nsTop 22
		nsRight 37
		nsBottom 88
		approachX 55
		approachY 92
		exitDir 4
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 8 setHotspot: 8 10) ; Do, Do, Exit
		(if (and (IsFlag 151) (== gValOrRoz -3)) ; Roz
			(= approachX 30)
		)
	)

	(method (doVerb)
		(gCurRoom setScript: exitParlor)
	)
)

(instance frontDoor of Prop
	(properties
		approachX 55
		approachY 92
		x 6
		y 93
		view 4212
		loop 1
		cel 8
	)

	(method (cue)
		(self z: 1000)
	)

	(method (init)
		(if (== gValOrRoz -3) ; Roz
			(= view 4201)
			(= loop 0)
			(= x 6)
			(= y 93)
		)
		(super init: &rest)
		(self setPri: 86)
		(if (and (IsFlag 151) (== gValOrRoz -3)) ; Roz
			(= approachX 30)
		)
	)

	(method (onMe)
		(return (exitDoor onMe: &rest))
	)
)

(instance ratJar of Prop
	(properties
		noun 4
		sightAngle 40
		approachX 71
		approachY 128
		x 92
		y 98
		view 4200
		loop 3
	)

	(method (init)
		(super init:)
		(self setHotspot: 8 10 approachVerbs: 8 10 setPri: 127) ; Do, Exit, Do, Exit
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(cond
					((and (IsFlag 151) (not (IsFlag 465)))
						(SetFlag 465)
						(gCurRoom setScript: sHannibalBlack)
					)
					((IsFlag 151)
						(gMessager say: noun theVerb 13) ; "(FROM INSIDE THE JAR)Hey lady. Love your dress!"
						(self setHotspot: 0)
					)
					((not (IsFlag 464))
						(SetFlag 464)
						(localproc_0)
						(gCurRoom setScript: sHannibal)
					)
					(else
						(gMessager say: noun theVerb 11) ; "(FROM INSIDE THE JAR; HANNIBAL LECTER IMPERSONATION)Closer, Rosella, closer!"
						(self setHotspot: 0)
					)
				)
				(return 1)
			)
		)
	)
)

(instance partsBox of View
	(properties
		noun 5
		sightAngle 40
		approachX 40
		approachY 102
		x 30
		y 112
		view 4211
	)

	(method (init)
		(super init:)
		(self setPri: 103)
		(if (not (IsFlag 515))
			(self setHotspot: 8 10 approachVerbs: 8 10) ; Do, Exit, Do, Exit
			(Load rsVIEW 4214)
		)
	)

	(method (doVerb)
		(SetFlag 515)
		(self setHotspot: 0 approachVerbs:)
		(gMessager say: 5 8 0 0) ; "(CURIOUS AND A LITTLE WORRIED)Why the box of spare parts?"
		(return 1)
	)
)

(instance soundEffect of Sound
	(properties)
)

(instance soundEffect2 of Sound
	(properties)
)

(instance writingSound of Sound
	(properties
		number 4209
	)
)

(instance stapleSound of Sound
	(properties
		number 4210
		loop -1
	)
)

(instance coronerTalker of KQTalker
	(properties)
)

(instance monsterTalker of KQTalker
	(properties)
)

(instance hannibalTalker of KQTalker
	(properties)
)

