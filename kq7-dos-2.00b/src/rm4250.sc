;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4250)
(include sci.sh)
(use Main)
(use ExitButton)
(use skipCartoon)
(use eastFeat)
(use n777)
(use Talker)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm4250 0
	catTalk 1
)

(local
	local0
	local1
)

(instance catTalk of KQTalker
	(properties)
)

(instance rm4250 of KQRoom
	(properties
		picture 4250
	)

	(method (init)
		(Load rsMESSAGE 4250)
		(super init:)
		(gKqMusic1 number: 4250 setLoop: -1 play:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 40 140 71 148 176 150 184 132 116 122 80 122 42 102 60 96 50 96 32 99 0 98 -50 93 -50 122 0 122
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 166 66 182 72 225 69 204 62
					yourself:
				)
		)
		(if
			(or
				(and (== gValOrRoz -3) (not (IsFlag 151))) ; Roz
				(and (== gValOrRoz -4) (not (IsFlag 203))) ; Val
			)
			(theWeb init: approachVerbs: 8 10) ; Do, Exit
		)
		(westFeat init:)
		(southFeat init:)
		(northFeat init:)
		(gEgo init: normalize:)
		(if (IsFlag 151)
			(gEgo setScaler: Scaler 80 67 137 121)
		else
			(gEgo setScaler: Scaler 65 55 137 121)
		)
		(cond
			((== gPrevRoomNum 4102)
				(gEgo
					posn: (- (westFeat approachX:) 10) (westFeat approachY:)
					setMotion:
						PolyPath
						(+ (westFeat approachX:) 10)
						(westFeat approachY:)
				)
			)
			((== gPrevRoomNum 4550)
				(gEgo
					normalize: 3
					posn: (southFeat approachX:) (southFeat approachY:)
					setMotion: PolyPath (southFeat approachX:) 135
				)
			)
			((== gPrevRoomNum 4050)
				(gEgo
					posn: (northFeat approachX:) (northFeat approachY:)
					setMotion:
						PolyPath
						(northFeat approachX:)
						(+ (northFeat approachY:) 11)
				)
			)
			(else
				(gEgo posn: 95 130)
			)
		)
		(if (== gValOrRoz -3) ; Roz
			(if (IsFlag 151)
				(SetFlag 192)
			)
			(cond
				((== gPrevRoomNum 4300)
					(= local1 1)
					(cond
						((IsFlag 177)
							(ClearFlag 177)
							(= local0 48)
							(SetFlag 192)
							(gCurRoom setScript: rosDropFromWindow)
						)
						((IsFlag 158)
							(= local0 49)
							(= local1 1)
							(SetFlag 192)
							(gCurRoom setScript: rosFromDeck)
						)
						(
							(and
								(gEgo has: 51) ; Weird_Pet
								(IsFlag 451)
								(not (IsFlag 156))
							)
							(= local0 42)
							(SetFlag 192)
							(= local1 1)
							(elevator init:)
							(ghoulKid1
								init:
								view: 4257
								setLoop: 2 1
								setCel: 0
								x: 182
								y: 71
								setScript: theyEnterHouse
								setHotspot: 0
							)
							(gEgo normalize: 0 posn: 159 128)
							(gGame handsOn:)
						)
						(else
							(= local0 47)
							(= local1 1)
							(elevator init:)
							(gCurRoom setScript: sRosElevator)
						)
					)
				)
				((IsFlag 151)
					(if (or (IsFlag 487) (== gPrevRoomNum 4550))
						(= local0 46)
					else
						(= local0 45)
						(SetFlag 192)
						(ghoulKid2 init: setScript: playWithBat)
						(Load 140 2492) ; WAVE
						(Load rsSOUND 4258)
						(elevator init: setPri: 10)
					)
					(= local1 1)
					(gGame handsOn:)
				)
				((not (IsFlag 191))
					(SetFlag 191)
					(= local0 40)
					(= local1 1)
					(gCurRoom setScript: seeKid2)
				)
				(
					(and
						(not (gEgo has: 50)) ; Back_Bone
						(not (gEgo has: 51)) ; Weird_Pet
						(not (IsFlag 156))
					)
					(= local0 41)
					(gGame handsOn:)
				)
				((and (IsFlag 451) (not (IsFlag 156)))
					(SetFlag 192)
					(= local1 1)
					(= local0 42)
					(ghoulKid2 init: setScript: playWithRat)
				)
				((IsFlag 157)
					(cond
						((not (IsFlag 153))
							(SetFlag 153)
							(SetFlag 192)
							(= local1 1)
							(= local0 43)
							(catTalk client: theCat hide_mouth: 1)
							(gCurRoom setScript: catFuneral)
						)
						((not (IsFlag 171))
							(SetFlag 192)
							(= local1 1)
							(= local0 44)
							(catTalk client: theCat hide_mouth: 1)
							(theCoffin init: setScript: sCatYowl)
							(gGame handsOn:)
						)
						(else
							(= local0 47)
							(= local1 0)
							(gGame handsOn:)
						)
					)
				)
				(else
					(= local0 47)
					(= local1 0)
					(gGame handsOn:)
				)
			)
		else
			(if (or ((gInventory at: 72) ownedBy: 4000) (gEgo has: 72)) ; Femur, Femur
				(= local1 1)
			)
			(cond
				((== gPrevRoomNum 4300)
					(= local1 1)
					(cond
						((IsFlag 177)
							(ClearFlag 177)
							(= local0 58)
							(SetFlag 192)
							(gCurRoom setScript: dropFromWindow)
						)
						((IsFlag 158)
							(= local0 59)
							(= local1 1)
							(SetFlag 192)
							(gCurRoom setScript: valFromDeck)
						)
						(else
							(= local0 53)
							(= local1 1)
							(elevator init:)
							(gCurRoom setScript: sValElevator)
						)
					)
				)
				(
					(and
						(IsFlag 219)
						(not (IsFlag 221))
						(not (IsFlag 220))
						(not (gEgo has: 74)) ; Firecracker
					)
					(= local0 51)
					(SetFlag 192)
					(gCurRoom setScript: dropFirecracker)
				)
				((and (not (IsFlag 237)) (IsFlag 203))
					(= local0 52)
					(= local1 1)
					(SetFlag 237)
					(SetFlag 192)
					(gCurRoom setScript: hearSkyRhyme)
				)
				((not (IsFlag 238))
					(SetFlag 238)
					(= local0 50)
					(= local1 1)
					(SetFlag 192)
					(gCurRoom setScript: throwEggAtVal)
				)
				(else
					(= local0 53)
					(gGame handsOn:)
				)
			)
		)
		(if (IsFlag 221)
			(Load 140 4253) ; WAVE
			(firecracker init:)
			(fireSound play:)
		)
		(if (not local1)
			(if (mod (Random 0 99) 2)
				(if (not (gCast contains: elevator))
					(elevator init:)
				)
			else
				(= local1 1)
			)
		)
		((ScriptID 7001 5) ; kid1Talker
			clientCel: -2
			loop: -1
			hide_mouth: 0
			client: ghoulKid1
		)
		((ScriptID 7001 6) ; kid2Talker
			clientCel: -2
			loop: -1
			hide_mouth: 0
			client: ghoulKid2
		)
		((ScriptID 7001 7) ; bothKidsTalker
			clientCel: -2
			loop: -1
			hide_mouth: 0
			client: ghoulKid1
		)
	)

	(method (doit)
		(super doit: &rest)
		(if (and (== local0 45) (not (IsFlag 487)) (> (gEgo x:) 100))
			(gCurRoom setScript: playWithBat2)
		)
		(if
			(and
				(westFeat onMe: gEgo)
				(< (gEgo x:) (- (westFeat approachX:) 10))
			)
			(gCurRoom newRoom: 4102)
		)
	)

	(method (dispose)
		(gKqMusic1 fade:)
		(soundEffect stop:)
		(soundEffect2 stop:)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(ClearFlag 192)
		(cond
			((!= newRoomNumber 4300)
				(ClearFlag 178)
			)
			(local1
				(SetFlag 178)
			)
		)
		(ClearFlag 158)
		(ClearFlag 177)
		(super newRoom: newRoomNumber)
	)
)

(instance sRosElevator of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsVIEW 8385)
				(gGame handsOff:)
				(elevator hide:)
				(gEgo
					view: 4258
					setLoop: 3 1
					setCel: 4
					setScaler: 0
					scaleX: 128
					scaleY: 128
					posn: 159 79
					setPri: 10
					setStep: 1 1
					setCycle: 0
					setMotion: MoveTo 159 128 self
				)
				(soundEffect number: 4263 setLoop: 1 play:)
			)
			(1
				(gEgo setCycle: Beg self)
			)
			(2
				(elevator show:)
				(gEgo
					view: 8385
					setLoop: 0 1
					setCel: 0
					setScaler: Scaler 65 55 137 121
					setPri: -1
					posn: (+ (gEgo x:) 3) (gEgo y:)
					setCycle: End self
				)
			)
			(3
				(gEgo normalize: 6 posn: (- (gEgo x:) 12) (gEgo y:))
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance valFromDeck of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setScaler: 0
					scaleX: 128
					scaleY: 128
					view: 4278
					setLoop: 0 1
					setCel: 0
					posn: 197 78
					setCycle: End self
				)
			)
			(1
				(gEgo view: 4278 setLoop: 0 1 setCel: 21 posn: 197 78)
				(gGame handsOn:)
				(User canControl: 0)
				(= seconds 8)
			)
			(2
				(gGame handsOff:)
				(soundEffect number: 4256 setLoop: 1 play:)
				(ghoulKid2
					init:
					view: 4280
					setLoop: 0 1
					setCel: 0
					posn: 161 61
					setCycle: CT 2 1 self
				)
			)
			(3
				(gEgo hide:)
				(ghoulKid2 setCycle: End self)
				(soundEffect2 number: 5332 setLoop: 1 play:)
			)
			(4
				(gMessager say: 0 0 15 0 self) ; "GOTCHA!"
			)
			(5
				(EgoDead 18 self)
			)
			(6
				(gEgo show:)
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

(instance rosFromDeck of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setScaler: 0
					scaleX: 128
					scaleY: 128
					view: 4270
					setLoop: 0 1
					setSpeed: 6
					setCel: 0
					setCycle: 0
					posn: 197 73
				)
				(= cycles 3)
			)
			(1
				(gEgo setCycle: End self)
			)
			(2
				(gEgo view: 4270 setLoop: 0 1 setCel: 3 posn: 197 73)
				(gGame handsOn:)
				(User canControl: 0)
				(= seconds 8)
			)
			(3
				(gGame handsOff:)
				(soundEffect number: 4256 setLoop: 1 play:)
				(ghoulKid2
					init:
					view: 4270
					setLoop: 1 1
					setCel: 0
					posn: 194 74
					setCycle: End self
				)
			)
			(4
				(gEgo hide:)
				(ghoulKid2 setLoop: 2 1 setCel: 0 setCycle: End self)
				((ScriptID 7001 7) client: ghoulKid2) ; bothKidsTalker
				(soundEffect2 number: 5332 setLoop: 1 play:)
			)
			(5
				(gMessager say: 0 0 11 0 self) ; "(SHRIEKING GLEEFULLY)GOTCHA!"
			)
			(6
				(EgoDead 17 self)
			)
			(7
				(gEgo show:)
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

(instance hearSkyRhyme of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 4257) ; WAVE
				(ghoulKid1
					init:
					view: 4281
					setLoop: 0 1
					x: 125
					y: 128
					setCycle: Fwd
				)
				(ghoulKid2
					init:
					view: 4281
					setLoop: 2 1
					x: 113
					y: 130
					setCycle: Fwd
				)
				(potsSound number: 4257 setLoop: -1 play:)
				(= ticks 180)
			)
			(1
				(potsSound setVol: 42)
				((ScriptID 7001 5) client: ghoulKid1) ; kid1Talker
				((ScriptID 7001 6) client: ghoulKid2) ; kid2Talker
				((ScriptID 7001 7) client: ghoulKid1) ; bothKidsTalker
				(gMessager say: 0 0 16 0 self) ; "(SINGSONG, DELIGHTED VOICE)KaBOOM! KaBOOM! Total doom!"
			)
			(2
				(potsSound stop:)
				(soundEffect number: 4258 setLoop: 1 play:)
				(ghoulKid1
					setLoop: 1 1
					setCel: 0
					x: 138
					y: 127
					setCycle: End self
				)
				(ghoulKid2
					setLoop: 3 1
					setCel: 0
					x: 131
					y: 133
					setCycle: End self
				)
			)
			(3
				(ghoulKid2 setLoop: 2 1 x: 190 y: 72 setCycle: Fwd)
				(potsSound number: 4257 setLoop: -1 play:)
			)
			(4
				(ghoulKid1 setLoop: 0 1 x: 196 y: 70 setCycle: Fwd)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance throwEggAtVal of Script
	(properties)

	(method (doit)
		(super doit: &rest)
		(if
			(and
				(not state)
				(< (GetDistance (gEgo x:) (gEgo y:) 136 128) 22)
			)
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 4251) ; WAVE
				(Load 140 848) ; WAVE
				(Load 140 2509) ; WAVE
				(Load rsVIEW 4273)
				(Load rsVIEW 8315)
				(gEgo setMotion: PolyPath 136 128)
				(ghoulKid2
					view: 4273
					init:
					z: 1000
					setLoop: 0 1
					setCel: 0
					x: 163
					y: 59
					priority: 59
					fixPriority: 1
					signal: 16385
					cycleSpeed: 8
				)
			)
			(1
				(ghoulKid2 z: 0 setCycle: CT 10 1 self)
			)
			(2
				(soundEffect number: 848 setLoop: 1 play:)
				(ghoulKid2 setCycle: CT 13 1 ghoulKid2)
				(gEgo
					view: 4273
					setLoop: 1 1
					setCel: 0
					setScaler: 0
					scaleX: 128
					scaleY: 128
					setCycle: End self
				)
			)
			(3
				(gEgo
					view: 8315
					setLoop: 0 1
					setCel: 0
					setCycle: End self
					setScaler: Scaler 65 55 137 121
					x: (+ (gEgo x:) 3)
					y: (- (gEgo y:) 1)
				)
			)
			(4
				(gMessager say: 0 0 13 1 self) ; "(IRRITATED)Hey! That wasn't very nice!"
			)
			(5
				(ghoulKid2
					view: 4273
					setLoop: 2 1
					setCel: 0
					x: 156
					y: 63
					priority: 63
					fixPriority: 1
					signal: 2049
					cycleSpeed: 8
					setCycle: CT 3 1 self
				)
			)
			(6
				(ghoulKid2 setCycle: CT 6 1 self)
			)
			(7
				(ghoulKid2 setCycle: End self)
				(soundEffect number: 4251 setLoop: 1 play:)
			)
			(8
				(ghoulKid2
					view: 4273
					setLoop: 3 1
					setCel: 0
					x: 132
					y: 91
					priority: 91
					fixPriority: 1
					signal: 2049
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(9
				(ghoulKid2 dispose:)
				(gEgo normalize: 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance playWithRat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(ghoulKid2
					view: 4253
					setLoop: 0 1
					setCel: 12
					x: 184
					y: 69
					cycleSpeed: 8
					setCycle: Fwd
				)
				(ghoulKid1
					init:
					view: 4253
					setLoop: 1 1
					setCel: 0
					x: 203
					y: 69
					cycleSpeed: 8
					setCycle: Fwd
				)
				(= cycles 3)
			)
			(1
				(kidChant setLoop: -1 play:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance spiderCrawl of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== gValOrRoz -3) ; Roz
					(theSpider view: 4267 setLoop: 3 1)
				else
					(theSpider view: 4277 setLoop: 2 1)
				)
				(theSpider
					init:
					ignoreActors: 1
					posn: 188 151
					setCycle: Fwd
					setPri: 123
					setMotion: MoveTo 181 117 self
				)
				(soundEffect number: 4254 setLoop: 1 play:)
			)
			(1
				(theSpider setCycle: 0)
				(soundEffect number: 821 setLoop: 1 play: self)
			)
			(2
				(theSpider dispose:)
				(self dispose:)
			)
		)
	)
)

(instance climbWebValBelow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setScaler: 0
					scaleX: 128
					scaleY: 128
					view: 4276
					loop: 0
					cel: 0
					x: 145
					y: 130
					z: 0
					priority: 150
					fixPriority: 1
					signal: 16385
					setCycle: End self
				)
			)
			(1
				(gEgo
					view: 4276
					loop: 1
					cel: 0
					x: 176
					y: 110
					z: 0
					xStep: 3
					yStep: 2
					priority: 151
					fixPriority: 1
					signal: 2049
					setCycle: End self
				)
			)
			(2
				(self setScript: spiderCrawl self)
			)
			(3
				(soundEffect number: 2456 setLoop: 1 play:)
				(if (== gValOrRoz -3) ; Roz
					(EgoDead 26 self)
				else
					(EgoDead 27 self)
				)
			)
			(4
				(soundEffect fade:)
				(if (IsFlag 158)
					(gEgo posn: 192 67)
				else
					(gEgo posn: (theWeb approachX:) (theWeb approachY:))
				)
				(gEgo normalize: 6 setScaler: Scaler 65 55 137 121)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance climbWebValAbove of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 4277
					setLoop: 0 1
					setCel: 0
					setScaler: 0
					x: 194
					y: 69
					scaleX: 128
					scaleY: 128
					priority: 69
					fixPriority: 1
					signal: 16385
					setCycle: End self
				)
			)
			(1
				(self setScript: spiderCrawl self)
			)
			(2
				(soundEffect number: 2456 setLoop: 1 play:)
				(if (== gValOrRoz -3) ; Roz
					(EgoDead 26 self)
				else
					(EgoDead 27 self)
				)
			)
			(3
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

(instance climbWebRoseBelow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setScaler: 0
					scaleX: 128
					scaleY: 128
					view: 4267
					setLoop: 0
					setCel: 0
					setPri: 130
					x: 175
					y: 130
					setCycle: End self
				)
			)
			(1
				(gEgo setLoop: 1 setCel: 0 x: 172 y: 128 setCycle: Fwd)
				(self setScript: spiderCrawl self)
			)
			(2
				(soundEffect number: 2456 setLoop: 1 play:)
				(if (== gValOrRoz -3) ; Roz
					(EgoDead 26 self)
				else
					(EgoDead 27 self)
				)
			)
			(3
				(soundEffect fade:)
				(if (IsFlag 158)
					(gEgo posn: 192 67)
				else
					(gEgo posn: (theWeb approachX:) (theWeb approachY:))
				)
				(gEgo normalize: 6 setScaler: Scaler 65 55 137 121)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance climbWebRoseAbove of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 4268
					setLoop: 1 1
					setCel: 0
					setScaler: 0
					x: 199
					y: 72
					scaleX: 128
					scaleY: 128
					setPri: 139
					setCycle: End self
				)
			)
			(1
				(gEgo
					setLoop: 0 1
					setCel: 0
					x: 182
					y: 109
					setCycle: End self
				)
			)
			(2
				(gEgo
					view: 4267
					setLoop: 1
					setCel: 0
					setCycle: Fwd
					posn: (- (gEgo x:) 1) (+ (gEgo y:) 8)
				)
				(self setScript: spiderCrawl self)
			)
			(3
				(soundEffect number: 2456 setLoop: 1 play:)
				(if (== gValOrRoz -3) ; Roz
					(EgoDead 26 self)
				else
					(EgoDead 27 self)
				)
			)
			(4
				(gCurRoom newRoom: gPrevRoomNum)
			)
		)
	)
)

(instance dropFromWindow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 856) ; WAVE
				(Load rsSOUND 817)
				(Load 140 847) ; WAVE
				(gEgo
					view: 4313
					setLoop: 3 1
					setCel: 0
					x: 72
					y: 123
					priority: 150
					fixPriority: 1
					signal: 2049
					setScaler: 0
					scaleX: 128
					scaleY: 128
					setCycle: CT 11 1 self
				)
				(soundEffect number: 856 setLoop: 1 play:)
			)
			(1
				(gEgo setCycle: CT 38 1 self)
				(soundEffect number: 817 setLoop: 1 play:)
			)
			(2
				(gEgo setCycle: End self)
				(soundEffect number: 847 setLoop: 1 play:)
			)
			(3
				(ClearFlag 177)
				(theWeb approachX: 145 approachY: 130)
				(gGame handsOn:)
				(gEgo normalize: 2 setScaler: Scaler 65 55 137 121)
				(self dispose:)
			)
		)
	)
)

(instance rosDropFromWindow of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 856) ; WAVE
				(Load rsSOUND 817)
				(Load 140 847) ; WAVE
				(gEgo
					view: 4271
					setLoop: 0 1
					setCel: 0
					posn: 120 57
					priority: 150
					fixPriority: 1
					signal: 2049
					setScaler: 0
					scaleX: 128
					scaleY: 128
					setCycle: End self
				)
				(soundEffect number: 856 setLoop: 1 play:)
			)
			(1
				(gEgo setLoop: 1 1 setCel: 0 setCycle: CT 5 1 self)
				(soundEffect number: 817 setLoop: 1 play:)
			)
			(2
				(gEgo setCycle: End self)
				(soundEffect number: 847 setLoop: 1 play:)
			)
			(3
				(ClearFlag 177)
				(if (== gValOrRoz -3) ; Roz
					(theWeb approachX: 163 approachY: 132)
				else
					(theWeb approachX: 145 approachY: 130)
				)
				(gGame handsOn:)
				(gEgo
					normalize: 2
					posn: 81 123
					setScaler: Scaler 65 55 137 121
				)
				(self dispose:)
			)
		)
	)
)

(instance playWithBat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(ghoulKid1
					init:
					view: 4272
					setLoop: 2 1
					setCel: 0
					x: 153
					y: 131
					setPri: 136
				)
				(ghoulKid2 view: 4272 setLoop: 1 1 setCel: 0 x: 121 y: 135)
				(= cycles 1)
			)
			(1
				(ghoulKid2 setCel: 0 setCycle: End)
				(ghoulKid1 setCel: 0 setCycle: CT 13 1 self)
				(soundEffect2 number: 4278 setLoop: 1 play:)
			)
			(2
				(soundEffect number: 4276 setLoop: 1 play:)
				(ghoulKid2 setCycle: End self)
			)
			(3
				(-= state 3)
				(= cycles 1)
			)
			(4
				(self dispose:)
			)
		)
	)
)

(instance playWithBat2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 487)
				(ghoulKid2 setScript: 0)
				(gEgo
					setScaler: 0
					scaleX: 128
					scaleY: 128
					view: 4272
					setMotion: 0
					setLoop: 7 1
					setCel: 0
					setCycle: CT 5 1 self
				)
			)
			(1
				(gEgo setCycle: End)
				(gMessager say: 1 8 12 1 self) ; "BOO!!!"
				((ScriptID 7001 5) hide_mouth: 1) ; kid1Talker
				((ScriptID 7001 6) hide_mouth: 1) ; kid2Talker
				((ScriptID 7001 7) hide_mouth: 1) ; bothKidsTalker
			)
			(2
				(ghoulKid1
					setLoop: 4
					setCel: 0
					posn: 151 131
					setCycle: End self
				)
				(ghoulKid2 setLoop: 3 setCel: 0 posn: 121 134 setCycle: End)
				(gMessager say: 1 8 12 2) ; "(PETRIFIED)EEEEEEEEEE!"
				(theBat
					init:
					setCycle: Fwd
					setPri: 140
					setMotion: MoveTo 329 58 theBat
				)
				(soundEffect number: 2492 setLoop: 1 play:)
			)
			(3
				(soundEffect2 number: 4258 setLoop: 1 play:)
				(ghoulKid1 hide:)
				(ghoulKid2
					view: 4272
					setLoop: 5 1
					setCel: 0
					x: 146
					y: 130
					setCycle: End self
				)
			)
			(4
				(ghoulKid1 dispose:)
				(ghoulKid2 dispose:)
				(gEgo normalize: 4 setScaler: Scaler 80 67 137 121)
				(= cycles 3)
			)
			(5
				(soundEffect number: 2480 setLoop: 1 play: self)
			)
			(6
				(soundEffect number: 4264 setLoop: 1 play:)
				(elevator
					setStep: 1 1
					setPri: 10
					setLoop: 0 1
					setMotion: MoveTo (elevator x:) 79 self
				)
			)
			(7
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance valUpElevator of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 164 127 self)
			)
			(1
				(gEgo
					view: 4276
					setLoop: 2 1
					setCel: 0
					setScaler: 0
					setPri: 10
					scaleX: 128
					scaleY: 128
					posn: 159 127
					setCycle: End self
				)
				(elevator hide:)
			)
			(2
				(soundEffect number: 4264 setLoop: 1 play:)
				(gEgo
					setPri: 10
					setStep: 1 1
					setMotion: MoveTo (gEgo x:) 79 self
				)
			)
			(3
				(gCurRoom newRoom: 4300)
			)
		)
	)
)

(instance sValElevator of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 8025)
				(gEgo
					view: 4276
					setLoop: 2 1
					setCel: 4
					setScaler: 0
					scaleX: 128
					scaleY: 128
					setPri: 10
					posn: 159 79
					setStep: 1 1
					setCycle: 0
					setMotion: MoveTo 159 128 self
				)
				(elevator hide:)
				(soundEffect number: 4263 setLoop: 1 play:)
			)
			(1
				(gEgo setCycle: Beg self)
			)
			(2
				(elevator show:)
				(gEgo
					view: 8025
					setScaler: Scaler 65 55 137 121
					setLoop: 0 1
					setPri: -1
					setCycle: End self
				)
			)
			(3
				(gEgo
					normalize: 6
					posn: (- (gEgo x:) 8) (+ (gEgo y:) 1)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance rosUpElevator of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 164 127 self)
			)
			(1
				(gEgo
					view: 4258
					setLoop: 3 1
					setCel: 0
					setScaler: 0
					scaleX: 128
					scaleY: 128
					posn: 159 127
					setPri: 10
					setCycle: End self
				)
				(elevator hide:)
			)
			(2
				(soundEffect number: 4264 setLoop: 1 play:)
				(gEgo
					setPri: 10
					setStep: 1 1
					setMotion: MoveTo (gEgo x:) 79 self
				)
			)
			(3
				(gCurRoom newRoom: 4300)
			)
		)
	)
)

(instance dropFirecracker of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 4253) ; WAVE
				(Load 140 4252) ; WAVE
				(Load rsVIEW 374)
				(theCat init: setCycle: CT 1 1 self)
				(ghoulKid2
					init:
					z: 1000
					view: 4274
					setLoop: 1 1
					setCel: 0
					x: 125
					y: 144
					z: 0
					priority: 135
					fixPriority: 1
					signal: 2049
					cycleSpeed: 8
				)
			)
			(1
				(soundEffect2 number: 925 setLoop: 1 play:)
				(theCat setCycle: CT 4 1 self)
			)
			(2
				(theCat setCycle: CT 20 1 theCat)
				(ghoulKid2 z: 0 setCycle: CT 33 1 self)
				(fireSound play:)
				(soundEffect number: 4252 setLoop: 1 play:)
			)
			(3
				(if (== gPrevRoomNum 4102)
					(ghoulKid2 setCycle: CT 39 1 self)
				else
					(self cue:)
				)
			)
			(4
				(ghoulKid2 setPri: 101 setCycle: End self)
				(firecracker init:)
				(SetFlag 221)
			)
			(5
				(ghoulKid2 dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance seeKid2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load rsVIEW 4258)
				(ghoulKid2
					view: 4251
					init:
					posn: 170 131
					setLoop: 0 1
					setCel: 0
					setCycle: End self
				)
				(soundEffect number: 4258 setLoop: 1 play:)
			)
			(1
				(ghoulKid2
					setLoop: 1 1
					setCel: 0
					posn: 184 80
					setCycle: End self
				)
			)
			(2
				(soundEffect number: 4262 setLoop: 1 play: self)
			)
			(3
				(ghoulKid2
					view: 4258
					setLoop: 1 1
					setCel: 0
					posn: 193 71
					setCycle: End self
				)
			)
			(4
				(ghoulKid2 dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance kidsClouds2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(potsSound setVol: 42)
				(gMessager say: 1 8 18 1 self) ; "This is serious, boys! Don't you care about anything?"
			)
			(1
				(gMessager say: 1 8 18 2 self) ; "Yeah! We care about having fun!"
			)
			(2
				(gMessager say: 1 8 18 5 self) ; "Ee hee hee hee hee hee!"
			)
			(3
				(potsSound setVol: 127)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance kidsClouds3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(potsSound setVol: 42)
				(gMessager say: 1 8 19 1 self) ; "(SCOLDING)If you were MY little boys, you'd have a few manners!"
			)
			(1
				(gMessager say: 1 8 19 2 self) ; "(IMPUDENT)If we was YOUR little boys, we'd of petrified with boredom by now!"
			)
			(2
				(gMessager say: 1 8 19 3 self) ; "Eee hee hee hee hee!"
			)
			(3
				(potsSound setVol: 127)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance preRat1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 8515 setLoop: 0 1 setCel: 0 setCycle: End self)
			)
			(1
				(gMessager say: 1 8 2 1 self) ; "(CHEERFULLY)Hi, kids!"
			)
			(2
				(ghoulKid1
					view: 4255
					setLoop: 3 1
					setCel: 0
					x: 195
					y: 67
					setCycle: End self
				)
				(ghoulKid2
					view: 4256
					setLoop: 0 1
					setCel: 10
					x: 166
					y: 55
					setPri: 58
					setCycle: 0
				)
			)
			(3
				(ghoulKid1 setCycle: Beg self)
				((ScriptID 7001 6) client: ghoulKid2 hide_mouth: 0 loop: 20) ; kid2Talker
			)
			(4
				(ghoulKid1 setCycle: 0 setCel: 0)
				(= cycles 3)
			)
			(5
				(gMessager sayRange: 1 8 2 2 6 self) ; "(GLEEFUL)Hiya, lady!"
			)
			(6
				((ScriptID 7001 7) client: ghoulKid1 loop: 24 hide_mouth: 0) ; bothKidsTalker
				(gMessager say: 1 8 2 7 self) ; "(OBNOXIOUS)NO WAY!"
			)
			(7
				(ghoulKid2
					z: 0
					view: 4253
					setLoop: 0 1
					setCel: 12
					x: 184
					y: 69
					cycleSpeed: 8
					setPri: -1
					setCycle: Fwd
				)
				(ghoulKid1
					view: 4253
					setLoop: 1 1
					setCel: 0
					x: 203
					y: 69
					cycleSpeed: 8
					setCycle: Fwd
				)
				(= ticks 60)
			)
			(8
				(gEgo setCycle: Beg self)
			)
			(9
				(kidChant play:)
				(gEgo normalize: 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance preRat2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 8515 setLoop: 0 1 setCel: 0 setCycle: End self)
			)
			(1
				(gMessager say: 1 8 3 1 self) ; "Oh, come on, guys! I really like that rat! Isn't there something you'd want to trade for him?"
			)
			(2
				(ghoulKid1
					view: 4255
					setLoop: 3 1
					setCel: 0
					x: 195
					y: 67
					setCycle: End self
				)
				(ghoulKid2
					view: 4256
					setLoop: 0 1
					setCel: 10
					x: 166
					y: 55
					setPri: 58
					setCycle: 0
				)
			)
			(3
				(ghoulKid1 setCycle: Beg self)
				((ScriptID 7001 6) client: ghoulKid2 hide_mouth: 0 loop: 20) ; kid2Talker
			)
			(4
				(ghoulKid1 setCycle: 0 setCel: 0)
				(= cycles 3)
			)
			(5
				(gMessager sayRange: 1 8 3 2 4 self) ; "(THINKING HARD)Well...I guess if you brought us a cooler pet..."
			)
			(6
				(ghoulKid2
					z: 0
					view: 4253
					setLoop: 0 1
					setCel: 12
					x: 184
					y: 69
					cycleSpeed: 8
					setPri: -1
					setCycle: Fwd
				)
				(ghoulKid1
					view: 4253
					setLoop: 1 1
					setCel: 0
					x: 203
					y: 69
					cycleSpeed: 8
					setCycle: Fwd
				)
				(= ticks 60)
			)
			(7
				(gEgo setCycle: Beg self)
			)
			(8
				(kidChant play:)
				(gEgo normalize: 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance preRat3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 8515 setLoop: 0 1 setCel: 0 setCycle: End self)
			)
			(1
				(gMessager say: 1 8 4 1 self) ; "(TRYING TO BE FRIENDLY)So, what do you Ooga Booga kids do for fun? Other than tormenting helpless rats, I mean."
			)
			(2
				(ghoulKid1
					view: 4255
					setLoop: 3 1
					setCel: 0
					x: 195
					y: 67
					setCycle: End self
				)
				(ghoulKid2
					view: 4256
					setLoop: 0 1
					setCel: 10
					x: 166
					y: 55
					setPri: 58
					setCycle: 0
				)
			)
			(3
				(ghoulKid1 setCycle: Beg self)
				((ScriptID 7001 6) client: ghoulKid2 hide_mouth: 0 loop: 20) ; kid2Talker
			)
			(4
				(ghoulKid1 setCycle: 0 setCel: 0)
				(= cycles 3)
			)
			(5
				(gMessager sayRange: 1 8 4 2 3 self) ; "(SNEAKY)We really like to jump into open graves. There's always a big surprise at the bottom."
			)
			(6
				(ghoulKid2 z: 1000)
				(ghoulKid1
					view: 4257
					setLoop: 2 1
					setCel: 0
					x: 186
					y: 71
					setCycle: Fwd
				)
				(gMessager say: 1 8 4 4 self) ; "(SNEAKY, MEAN LAUGH)Eee hee hee hee hee!"
			)
			(7
				(ghoulKid2
					z: 0
					view: 4253
					setLoop: 0 1
					setCel: 12
					x: 184
					y: 69
					cycleSpeed: 8
					setPri: -1
					setCycle: Fwd
				)
				(ghoulKid1
					view: 4253
					setLoop: 1 1
					setCel: 0
					x: 203
					y: 69
					cycleSpeed: 8
					setCycle: Fwd
				)
				(= ticks 60)
			)
			(8
				(gEgo setCycle: Beg self)
			)
			(9
				(kidChant play:)
				(gEgo normalize: 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance preRat4 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 8515 setLoop: 0 1 setCel: 0 setCycle: End self)
			)
			(1
				(gMessager say: 1 8 5 1 self) ; "(TRYING TO BE CHEERFUL)Hi, guys!"
			)
			(2
				(ghoulKid1
					view: 4255
					setLoop: 3 1
					setCel: 0
					x: 195
					y: 67
					setCycle: End self
				)
				(ghoulKid2
					view: 4256
					setLoop: 0 1
					setCel: 10
					x: 166
					y: 55
					setPri: 58
					setCycle: 0
				)
			)
			(3
				(ghoulKid1 setCycle: Beg self)
				((ScriptID 7001 6) client: ghoulKid2 hide_mouth: 0 loop: 20) ; kid2Talker
			)
			(4
				(ghoulKid1 setCycle: 0 setCel: 0)
				(= cycles 3)
			)
			(5
				(gMessager sayRange: 1 8 5 2 3 self) ; "Geez, lady, quit jawboning!"
			)
			(6
				(ghoulKid2 z: 1000)
				(ghoulKid1
					view: 4257
					setLoop: 2 1
					setCel: 0
					x: 186
					y: 71
					setCycle: Fwd
				)
				(gMessager say: 1 8 4 4 self) ; "(SNEAKY, MEAN LAUGH)Eee hee hee hee hee!"
			)
			(7
				(ghoulKid2
					z: 0
					view: 4253
					setLoop: 0 1
					setCel: 12
					x: 184
					y: 69
					cycleSpeed: 8
					setPri: -1
					setCycle: Fwd
				)
				(ghoulKid1
					view: 4253
					setLoop: 1 1
					setCel: 0
					x: 203
					y: 69
					cycleSpeed: 8
					setCycle: Fwd
				)
				(= ticks 60)
			)
			(8
				(gEgo setCycle: Beg self)
			)
			(9
				(kidChant play:)
				(gEgo normalize: 6)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance notWeirdPet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 8465 setLoop: 0 setCel: 0 setCycle: CT 10 1 self)
			)
			(1
				(gMessager say: 1 0 6 1 self) ; "Hey! I'll trade you this for the rat!"
			)
			(2
				(ghoulKid2 hide:)
				(ghoulKid1
					view: 4254
					setLoop: 0 1
					setCel: 0
					x: 170
					y: 69
					setCycle: End self
				)
			)
			(3
				(gMessager say: 1 0 6 2 self) ; "(LOUD AND RUDE)NO WAY!"
			)
			(4
				(ghoulKid2
					show:
					view: 4253
					setLoop: 0 1
					setCel: 12
					x: 184
					y: 69
					cycleSpeed: 8
					setPri: -1
					setCycle: Fwd
				)
				(ghoulKid1
					view: 4253
					setLoop: 1 1
					setCel: 0
					x: 203
					y: 69
					cycleSpeed: 8
					setCycle: Fwd
				)
				(gEgo normalize: 6)
				(kidChant play:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance showPet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Load 140 4279) ; WAVE
				(Load 140 8640) ; WAVE
				(gEgo
					view: 4255
					setCycle: 0
					setLoop: 0 1
					setCel: 0
					x: 154
					y: 130
					setScaler: 0
					scaleX: 128
					scaleY: 128
				)
				((ScriptID 13 0) hide_mouth: 1) ; aEgoTalker
				((ScriptID 7001 7) client: ghoulKid1 loop: 24 hide_mouth: 0) ; bothKidsTalker
				(= cycles 1)
			)
			(1
				(gMessager say: 1 67 0 1 self) ; "Guess what I have in here, guys?"
			)
			(2
				(ghoulKid1
					view: 4255
					setLoop: 3 1
					setCel: 0
					x: 195
					y: 67
					setCycle: End self
				)
				(ghoulKid2
					view: 4256
					setLoop: 0 1
					setCel: 10
					x: 166
					y: 55
					setPri: 58
					setCycle: 0
				)
			)
			(3
				(ghoulKid1 setCycle: Beg self)
				((ScriptID 7001 6) client: ghoulKid2 hide_mouth: 0 loop: 20) ; kid2Talker
			)
			(4
				(ghoulKid1 setCycle: 0 setCel: 0)
				(= cycles 3)
			)
			(5
				(gMessager sayRange: 1 67 0 2 5 self) ; "(EXCITED)Is it a severed head?"
			)
			(6
				(gMessager say: 1 67 0 6 self) ; "Oh yeah? LOOK!"
			)
			(7
				(soundEffect number: 8640 setLoop: 1 play:)
				(soundEffect2 number: 4279 setLoop: 1 play:)
				(gEgo setSpeed: 10 setCycle: End self)
			)
			(8
				(gMessager say: 1 67 0 7 self) ; "(THRILLED)CADAVEROUS!"
			)
			(9
				(ghoulKid2
					view: 4255
					setLoop: 2 1
					setCel: 0
					setPri: 69
					posn: 169 69
					setCycle: End self
				)
				(ghoulKid1 view: 4258 setLoop: 0 1 setCel: 0 posn: 190 70)
			)
			(10
				(ghoulKid2 z: 1000)
				(= cycles 3)
			)
			(11
				(elevator
					init:
					setLoop: 0 1
					posn: 164 79
					setPri: 10
					setMotion: MoveTo 164 (gEgo y:) self
				)
				(soundEffect number: 4263 setLoop: 1 play:)
			)
			(12
				(ghoulKid2
					z: 0
					view: 4256
					setLoop: 0 1
					setCel: 0
					posn: 165 56
					setCycle: End self
				)
			)
			(13
				(gMessager say: 1 67 0 8 self) ; "(GREEDY)Give it! Give it! Put it on the elevator!"
			)
			(14
				(ghoulKid2 z: 1000)
				(ghoulKid1
					view: 4256
					setLoop: 1 1
					setCel: 0
					x: 168
					y: 67
					setCycle: End self
				)
			)
			(15
				(ghoulKid1
					view: 4257
					setLoop: 0 1
					setCel: 0
					x: 181
					y: 70
					setCycle: End self
				)
			)
			(16
				(ghoulKid1
					view: 4257
					setLoop: 1 1
					setCel: 0
					x: 182
					y: 71
					setCycle: End self
				)
			)
			(17
				(ghoulKid1 view: 4257 setLoop: 0 1 setCel: 0 x: 181 y: 70)
				((ScriptID 7001 5) loop: 19) ; kid1Talker
				(gMessager say: 1 67 0 9 self) ; "(SNEAKY)Why don't you just come up here and bring it yourself, lady?"
			)
			(18
				(ghoulKid1 setCycle: End self)
			)
			(19
				(ghoulKid1 setCycle: Beg)
				((ScriptID 7001 6) client: ghoulKid1 loop: 18) ; kid2Talker
				(gMessager say: 1 67 0 10 self) ; "(SNEAKY)Yeah! Come on up!"
			)
			(20
				(ghoulKid1
					view: 4257
					setLoop: 2 1
					setCel: 0
					x: 182
					y: 71
					setCycle: Fwd
				)
				(gMessager say: 1 67 0 11 self) ; "(SNEAKY, MEAN LAUGHTER)Eee hee hee hee hee!"
			)
			(21
				(ghoulKid1 setCycle: 0 setHotspot: 0)
				(ghoulKid2 setHotspot: 0)
				(ghoulKid1 setScript: theyEnterHouse)
				(gEgo normalize: 6 setScaler: Scaler 65 55 137 121)
				((ScriptID 13 0) hide_mouth: 0) ; aEgoTalker
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance theyEnterHouse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 15)
			)
			(1
				(ghoulKid1
					view: 4258
					setLoop: 0 1
					setCel: 0
					x: 188
					y: 67
					setCycle: End ghoulKid1
				)
				(ghoulKid2
					show:
					z: 0
					view: 4258
					setLoop: 1 1
					setCel: 0
					x: 184
					y: 70
					setCycle: End self
				)
			)
			(2
				(ghoulKid2 z: 1000 dispose:)
				(self dispose:)
			)
		)
	)
)

(instance putPetOnElevator of Script
	(properties)

	(method (init)
		(ClearFlag 539)
		(super init: &rest)
	)

	(method (dispose)
		(ClearFlag 539)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff: 1)
					(gEgo
						view: 8425
						setLoop: 0 1
						setCel: 0
						setCycle: CT 6 1 self
					)
				)
				(1
					(gEgo put: 51 setCycle: Beg self) ; Weird_Pet
					(elevator setLoop: 1 1)
				)
				(2
					(gEgo
						view: 8515
						setLoop: 0 1
						setCel: 0
						cycleSpeed: 12
						setCycle: End
					)
					(elevator
						setPri: 10
						setMotion: MoveTo (elevator x:) 79 self
					)
					(soundEffect number: 4264 setLoop: 1 play:)
				)
				(3
					((ScriptID 7001 5) hide_mouth: 1) ; kid1Talker
					((ScriptID 7001 6) hide_mouth: 1) ; kid2Talker
					((ScriptID 7001 7) hide_mouth: 1) ; bothKidsTalker
					(elevator setLoop: 0 1)
					(soundEffect number: 4265 setLoop: 1 play: self)
					(elevator setHotspot: 0)
				)
				(4
					(gMessager sayRange: 2 67 0 1 2 self) ; "(EXCITED, FROM INSIDE HOUSE)Cadaverous! He's BITING me!"
				)
				(5
					(soundEffect number: 4266 setLoop: 1 play:)
					(proc777_0 gThePlane 1 3 1)
					(= ticks 50)
				)
				(6
					(proc777_0 gThePlane 3 3 1)
					(= ticks 50)
				)
				(7
					(proc777_0 gThePlane 2 6 1)
					(gThePlane
						setRect:
							(gThePlane left:)
							(gThePlane top:)
							(gThePlane right:)
							(gThePlane bottom:)
					)
					(UpdatePlane gThePlane)
					(FrameOut)
					(= ticks 50)
				)
				(8
					(theRat
						init:
						cycleSpeed: (gEgo cycleSpeed:)
						setCycle: CT 6 1 self
					)
					(soundEffect number: 4267 setLoop: 1 play:)
				)
				(9
					(gEgo
						setScaler: 0
						scaleX: 128
						scaleY: 128
						view: 4259
						setLoop: 1 1
						setCel: 0
						setCycle: End self
						setMotion: MoveTo 154 130
					)
					(theRat setCycle: End self)
				)
				(10
					(SetFlag 156)
					(theRat hide:)
				)
				(11
					(gEgo
						get: 57 ; Grave_Digger_s_Rat
						view: 4260
						setLoop: 0
						setCel: 0
						x: 142
						y: 130
						setCycle: End self
					)
				)
				(12
					(hearts
						init:
						setLoop: 1
						setCel: 0
						x: 144
						y: 105
						setCycle: ForwardCounter 3 self
					)
				)
				(13
					(hearts dispose:)
					(gEgo
						view: 4260
						setLoop: 2
						setCel: 0
						x: 142
						y: 130
						setCycle: End self
					)
					(soundEffect number: 2056 setLoop: 1 play:)
				)
				(14
					(gEgo
						view: 4260
						setLoop: 3
						setCel: 0
						x: 142
						y: 131
						setCycle: End self
					)
				)
				(15
					(gMessager say: 2 67 0 3 self) ; "(SWEETLY)It'll be okay, little fella. Let's get out of here!"
				)
				(16
					(gEgo
						normalize: 6
						posn: 149 129
						setScaler: Scaler 65 55 137 121
					)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(switch (= state newState)
				(0
					(= ticks (= cycles (= seconds 0)))
					(soundEffect stop:)
					(= cycles 2)
				)
				(1
					(ghoulKid1 setCycle: 0 z: 1000 dispose:)
					(ghoulKid2 setCycle: 0 z: 1000 dispose:)
					(elevator
						setLoop: 0 1
						setMotion: 0
						posn: (elevator x:) 79
						setPri: 10
						setHotspot: 0
					)
					((ScriptID 7001 5) hide_mouth: 1) ; kid1Talker
					((ScriptID 7001 6) hide_mouth: 1) ; kid2Talker
					((ScriptID 7001 7) hide_mouth: 1) ; bothKidsTalker
					(gThePlane
						setRect:
							(gThePlane left:)
							(gThePlane top:)
							(gThePlane right:)
							(gThePlane bottom:)
					)
					(UpdatePlane gThePlane)
					(FrameOut)
					(SetFlag 156)
					(if (gCast contains: theRat)
						(theRat hide:)
					)
					(hearts dispose:)
					(gEgo
						put: 51 ; Weird_Pet
						get: 57 ; Grave_Digger_s_Rat
						setCycle: 0
						setMotion: 0
						normalize: 6
						posn: 149 129
						setScaler: Scaler 65 55 137 121
					)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance catFuneral of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(gGame handsOff: 1)
					(Load 140 4269) ; WAVE
					(Load 140 4268) ; WAVE
					(Load 140 4270) ; WAVE
					(ghoulKid1
						init:
						view: 4261
						setLoop: 1
						setCel: 0
						x: 68
						y: 124
					)
					(ghoulKid2
						init:
						view: 4261
						setLoop: 0
						setCel: 0
						x: 59
						y: 120
					)
					(theCoffin init:)
					(= cycles 3)
				)
				(1
					(soundEffect number: 4269 setLoop: 1 play: self)
				)
				(2
					(ghoulKid1
						view: 4261
						setLoop: 2
						setCel: 0
						x: 57
						y: 123
						setCycle: End self
					)
				)
				(3
					(gMessager say: 0 0 7 1 self) ; "(FAKE SOMBER)Dearly departed, we are gathered here today to say goodbye to our friend the kitty cat."
				)
				(4
					(ghoulKid2
						view: 4261
						setLoop: 3
						setCel: 0
						posn: 57 115
						setCycle: End
					)
					(gMessager say: 0 0 7 2 self) ; "(PRETENDING TO CRY)Boo hoo hoo, she was my bestest friend!"
				)
				(5
					(ghoulKid2 setCycle: Beg)
					(gMessager say: 0 0 7 3 self) ; "(FAKE SOMBER)It's so putrified when a kitty has to leave the world so young. She was--"
				)
				(6
					(soundEffect number: 4268 setLoop: 1 play:)
					(= ticks 120)
				)
				(7
					(ghoulKid1
						view: 4263
						setLoop: 0
						setCel: 0
						posn: 66 122
						setCycle: CT 5 1 self
					)
				)
				(8
					(ghoulKid1 setCycle: End self)
					(soundEffect2 number: 4270 setLoop: 1 play:)
				)
				(9
					(ghoulKid1
						view: 4263
						setLoop: 0
						setCel: 0
						posn: 66 122
						setCycle: CT 5 1 self
					)
				)
				(10
					(ghoulKid1 setCycle: End self)
					(soundEffect2 number: 4270 setLoop: 1 play:)
				)
				(11
					(ghoulKid1
						view: 4263
						setLoop: 0
						setCel: 0
						posn: 66 122
						setCycle: CT 5 1 self
					)
				)
				(12
					(ghoulKid1 setCycle: End self)
					(soundEffect2 number: 4270 setLoop: 1 play:)
				)
				(13
					(ghoulKid1
						view: 4261
						setLoop: 2
						setCel: 0
						x: 57
						y: 123
						setCycle: End self
					)
				)
				(14
					(gMessager say: 0 0 7 4 self) ; "(CRANKY, THEN FAKE SOMBER)Hush up, kitty! Whe was in the prime of life."
				)
				(15
					(ghoulKid2
						view: 4263
						setLoop: 1
						setCel: 0
						posn: 57 119
						setCycle: End self
					)
					(soundEffect number: 4269 setLoop: 1 play:)
				)
				(16
					(gMessager say: 0 0 7 5 self) ; "(PRETENDING TO CRY EVEN HARDER, THEN SUDDENLY GLEEFUL ABOUT THE SHOVEL)WAAAAH! If only she hadn't been runned over by a ox cart! If only she didn't get the plague! If only--if only we had a SHOVEL!"
				)
				(17
					(ghoulKid2 setCycle: Beg)
					(gMessager say: 0 0 7 6 self) ; "(GLEEFUL)Homicidal! Let's go find one!"
				)
				(18
					((ScriptID 7001 5) hide_mouth: 1) ; kid1Talker
					((ScriptID 7001 6) hide_mouth: 1) ; kid2Talker
					((ScriptID 7001 7) hide_mouth: 1) ; bothKidsTalker
					(gMessager say: 0 0 7 7) ; "(GLEEFUL MEAN LAUGHTER)Ee hee hee hee hee!"
					(ghoulKid2
						view: 4263
						setLoop: 3 1
						setCel: 0
						x: 55
						y: 118
						setCycle: CT 3 1 self
					)
					(ghoulKid1
						view: 4263
						setLoop: 2 1
						setCel: 0
						posn: 59 123
						setCycle: CT 4 1 self
					)
				)
				(19
					(ghoulKid2
						setCycle: End
						setStep: 7 2
						setMotion: MoveTo -5 (ghoulKid2 y:) self
					)
				)
				(20
					(ghoulKid1
						setCycle: End
						setStep: 7 2
						setMotion: MoveTo -5 (ghoulKid1 y:) self
					)
				)
				(21 0)
				(22
					(theCoffin setScript: sCatYowl)
					(ghoulKid1 dispose:)
					(ghoulKid2 dispose:)
					(= local0 44)
					(gGame handsOn:)
					(ClearFlag 539)
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
					(if (gCast contains: ghoulKid1)
						(ghoulKid1 hide:)
					)
					(if (gCast contains: ghoulKid2)
						(ghoulKid2 hide:)
					)
					(theCoffin setScript: sCatYowl)
					(= local0 44)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		)
	)
)

(instance sCatYowl of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (!= ((ScriptID 4001) script:) (ScriptID 4001 4)) ; OogaBooga, diggerComes
					(catYowl number: 4269 setLoop: 1 play:)
				)
				(= seconds (Random 5 10))
			)
			(1
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance tryOpenCoffin of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setScaler: 0
					scaleX: 128
					scaleY: 128
					view: 4264
					setLoop: 0
					setCel: 0
					posn: 52 119
					setCycle: CT 4 1 self
				)
				(soundEffect number: 804 setLoop: 1 play:)
			)
			(1
				(theCoffin z: 1000)
				(gEgo setCycle: End self)
			)
			(2
				(gMessager say: 3 8 8 0 self) ; "(THINKS TO HERSELF)Oh no! They sealed it up!"
			)
			(3
				(theCoffin z: 0)
				(gEgo normalize: 4 setScaler: Scaler 65 55 137 121)
				(gGame handsOn:)
			)
		)
	)
)

(instance freeCat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(theCoffin setScript: 0)
				(gEgo
					setScaler: 0
					scaleX: 128
					scaleY: 128
					view: 4264
					setLoop: 1
					setCel: 0
					posn: 60 128
					setPri: 118
					setCycle: CT 16 1 self
				)
			)
			(1
				(soundEffect number: 874 setLoop: 1 play:)
				(gEgo setCycle: End self)
			)
			(2
				(soundEffect number: 4272 play:)
				(theCoffin setCycle: End self)
			)
			(3
				(soundEffect number: 4273 play:)
				(theCat
					init:
					view: 4264
					setLoop: 3
					setCel: 0
					posn: 52 121
					setPri: 119
					setCycle: End self
				)
				(catTalk hide_mouth: 1)
			)
			(4
				(= ticks 100)
			)
			(5
				(theCat
					view: 4264
					setLoop: 4
					setCel: 0
					posn: 32 120
					setCycle: CT 8 1 self
				)
			)
			(6
				(theCat setCycle: End)
				(gEgo
					view: 4265
					setLoop: 0
					setCel: 0
					posn: 66 118
					setCycle: End self
				)
			)
			(7
				(gEgo x: (- (gEgo x:) 16) setLoop: 3 1 setCel: 2)
				(= cycles 3)
			)
			(8
				(catTalk hide_mouth: 1)
				(gMessager sayRange: 3 46 0 1 5 self) ; "Are you all right, little cat?"
			)
			(9
				(= ticks 30)
			)
			(10
				(theCat
					view: 4265
					setLoop: 1 1
					setCel: 0
					posn: 45 119
					setCycle: End self
				)
			)
			(11
				(gEgo setCycle: Beg self)
			)
			(12
				(theCat setLoop: 2 1 setCel: 0 setCycle: End self)
				(soundEffect number: 4274 play:)
			)
			(13
				(gEgo get: 58) ; Extra_Life
				(SetFlag 171)
				(theCat setLoop: 1 1 setCel: 1 setCycle: Beg self)
				(gEgo setCycle: Beg)
			)
			(14
				(gEgo setLoop: 3 1 setCel: 2)
				(= cycles 3)
			)
			(15
				(gMessager sayRange: 3 46 0 6 7 self) ; "(SINCERELY)It is one of my lives, my lady. You saved one of mine, so I feel I owe it to you. I still have eight left."
			)
			(16
				(theCat
					view: 4266
					setLoop: 0
					setCel: 0
					posn: 56 122
					setCycle: CT 12 1 self
				)
				(soundEffect number: 4275 play:)
			)
			(17
				(theCat setCycle: End self)
			)
			(18
				(soundEffect fade:)
				(gMessager say: 3 46 0 8 self) ; "(WHISPERS)You must."
			)
			(19
				(theCat
					view: 4266
					setLoop: 2
					setCel: 0
					x: 26
					y: 127
					setCycle: End self
				)
			)
			(20
				(theCat dispose:)
				(gEgo
					x: (+ (gEgo x:) 16)
					setLoop: 0 1
					setCel: 12
					setCycle: CT 6 -1 self
				)
			)
			(21
				(gEgo
					normalize: 5
					setScaler: Scaler 65 55 137 121
					posn: 52 115
				)
				((ScriptID 13) hide_mouth: 0) ; aEgoTalker
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTalkCat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(theCoffin setScript: 0)
				(gMessager say: 3 8 9 0 self) ; "(SPEAKING GENTLY TO THE CAT THROUGH THE COFFIN LID)Don't worry, kitty. I'll get you out of there."
			)
			(1
				(theCoffin setScript: sCatYowl)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLeaveWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setMotion: MoveTo (- (gEgo x:) 10) (gEgo y:) self
				)
			)
			(1
				(gCurRoom newRoom: 4102)
			)
		)
	)
)

(instance sExitSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo (gEgo x:) 175 self)
			)
			(1
				(gCurRoom newRoom: 4550)
			)
		)
	)
)

(instance getFirecracker of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setScaler: 0
					scaleX: 128
					scaleY: 128
					view: 4275
					setLoop: 0 1
					setCel: 0
					x: 102
					y: 131
					setCycle: CT 5 1 self
				)
			)
			(1
				((gCurRoom obstacles:) delete: ((gCurRoom obstacles:) at: 2))
				(firecracker dispose:)
				(fireSound stop:)
				(ClearFlag 221)
				(gEgo get: 74 setCycle: End self) ; Firecracker
			)
			(2
				((ScriptID 4001 6) setCycle: (ScriptID 4001 6) 12000) ; firecrackerTimer, firecrackerTimer
				(gEgo
					normalize: 2
					setScaler: Scaler 65 55 137 121
					posn: (+ (gEgo x:) 4) (- (gEgo y:) 1)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance ghoulKid1 of Actor
	(properties
		noun 1
		sightAngle 40
		x 132
		y 90
		view 4273
		loop 3
		cycleSpeed 8
	)

	(method (cue)
		(self z: 1000 dispose:)
	)

	(method (init)
		(cond
			((== gValOrRoz -3) ; Roz
				(self
					view: 4270
					setHotspot: 9998
					approachVerbs: 8 10 67 ; Do, Exit, Weird_Pet
					approachX: 154
					approachY: 130
				)
			)
			((not (IsFlag 528))
				(self
					setHotspot: 8 10 ; Do, Exit
					approachVerbs: 8 10 ; Do, Exit
					approachX: 145
					approachY: 130
				)
			)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (== gValOrRoz -3) ; Roz
			(kidChant stop:)
			(switch theVerb
				(8 ; Do
					(switch local0
						(45
							(gCurRoom setScript: playWithBat2)
						)
						(42
							(cond
								((not (IsFlag 483))
									(SetFlag 483)
									(gCurRoom setScript: preRat1)
								)
								((not (IsFlag 484))
									(SetFlag 484)
									(gCurRoom setScript: preRat2)
								)
								((not (IsFlag 485))
									(SetFlag 485)
									(gCurRoom setScript: preRat3)
								)
								(else
									(gCurRoom setScript: preRat4)
								)
							)
						)
					)
				)
				(67 ; Weird_Pet
					(gCurRoom setScript: showPet)
				)
				(else
					(gCurRoom setScript: notWeirdPet)
				)
			)
		else
			(switch theVerb
				(8 ; Do
					(if (== local0 52)
						(cond
							((IsFlag 527)
								(SetFlag 528)
								(gCurRoom setScript: kidsClouds3)
								(self setHotspot: 0)
								(ghoulKid2 setHotspot: 0)
							)
							((IsFlag 526)
								(SetFlag 527)
								(gCurRoom setScript: kidsClouds2)
							)
							(else
								(SetFlag 526)
								(potsSound setVol: 42)
								(gMessager say: noun theVerb 17 0) ; "Aren't you two worried at all?"
								(potsSound setVol: 127)
							)
						)
					)
				)
			)
		)
		(return 1)
	)
)

(instance ghoulKid2 of Actor
	(properties
		sightAngle 40
		x 300
		y 40
		view 4256
		loop 1
		cycleSpeed 8
	)

	(method (cue)
		(soundEffect2 number: 2509 setLoop: 1 play:)
		(self setCycle: End)
	)

	(method (init)
		(super init:)
		(if (== gValOrRoz -3) ; Roz
			(self
				setHotspot: 9998
				approachVerbs: 8 10 67 ; Do, Exit, Weird_Pet
				approachX: 154
				approachY: 130
			)
		else
			(self
				setHotspot: 8 10 ; Do, Exit
				approachVerbs: 8 10 ; Do, Exit
				approachX: 145
				approachY: 130
			)
		)
	)

	(method (doVerb theVerb)
		(ghoulKid1 doVerb: theVerb)
	)
)

(instance theSpider of Actor
	(properties
		view 4267
	)
)

(instance theRat of Actor
	(properties
		x 119
		y 70
		priority 70
		fixPriority 1
		view 4259
		signal 16385
	)
)

(instance theCat of Prop
	(properties
		x 120
		y 143
		priority 130
		fixPriority 1
		view 4274
		signal 2049
	)

	(method (cue)
		(if (> cel 20)
			(self dispose:)
		else
			(self setCycle: End self)
			(if (== gPrevRoomNum 4100)
				(self setPri: 106)
			else
				(self setPri: 101)
			)
		)
	)
)

(instance elevator of Actor
	(properties
		sightAngle 40
		approachX 158
		approachY 128
		x 170
		y 128
		view 4250
		loop 2
	)

	(method (init)
		(super init:)
		(self setStep: 1 1)
		(if (== gPrevRoomNum 4300)
			(self setPri: 10)
		else
			(self setPri: 57)
		)
		(if (!= local0 45)
			(if (== local0 42)
				(self setHotspot: 8 10 67 approachVerbs: 8 10 67) ; Do, Exit, Weird_Pet, Do, Exit, Weird_Pet
			else
				(self setHotspot: 8 10 approachVerbs: 8 10) ; Do, Exit, Do, Exit
			)
		)
		(self setLoop: 0 1)
	)

	(method (doVerb theVerb)
		(if (== gValOrRoz -3) ; Roz
			(switch theVerb
				(67 ; Weird_Pet
					(if (== local0 42)
						(if (== (theyEnterHouse state:) 0)
							(theyEnterHouse seconds: 0 cue:)
						)
						(gCurRoom setScript: putPetOnElevator)
					)
				)
				(8 ; Do
					(if (and (== local0 42) (== (theyEnterHouse state:) 0))
						(theyEnterHouse seconds: 0 cue:)
					)
					(gCurRoom setScript: rosUpElevator)
				)
			)
		else
			(switch theVerb
				(8 ; Do
					(gCurRoom setScript: valUpElevator)
				)
			)
		)
	)
)

(instance theBat of Actor
	(properties
		x 319
		y 58
		view 4272
	)

	(method (cue)
		(self dispose:)
	)
)

(instance hearts of Prop
	(properties
		view 4260
	)
)

(instance theCoffin of Prop
	(properties
		noun 3
		sightAngle 40
		approachX 52
		approachY 119
		x 66
		y 120
		view 4264
		loop 2
	)

	(method (init)
		(super init:)
		(self setHotspot: 8 10 46 approachVerbs: 8 10 46) ; Do, Exit, Hammer_and_Chisel, Do, Exit, Hammer_and_Chisel
		((gCurRoom obstacles:) delete: ((gCurRoom obstacles:) at: 0))
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 40 140 40 170 185 170 189 154 191 132 116 122 80 122 73 121 54 121 53 114 62 114 42 102 59 96 48 96 32 99 0 93 -50 93 -50 122 0 122
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(if (IsFlag 486)
					(gCurRoom setScript: sTalkCat)
				else
					(SetFlag 486)
					(gCurRoom setScript: tryOpenCoffin)
				)
			)
			(46 ; Hammer_and_Chisel
				(gCurRoom setScript: freeCat)
				(self setHotspot: 0 approachVerbs: 0)
			)
		)
	)
)

(instance theWeb of Feature
	(properties
		sightAngle 370
		y 60
	)

	(method (init)
		(super init:)
		(cond
			((== gValOrRoz -3) ; Roz
				(if (IsFlag 158)
					(= approachX 194)
					(= approachY 69)
				else
					(= approachX 163)
					(= approachY 132)
				)
			)
			((IsFlag 158)
				(= approachX 194)
				(= approachY 69)
			)
			(else
				(= approachX 145)
				(= approachY 130)
			)
		)
		(self
			setHotspot: 8 10 ; Do, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 153 119 172 94 153 67 185 74 238 65 237 73 226 84 222 97 211 109 216 123 197 129 169 127
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(cond
					((== gValOrRoz -3) ; Roz
						(if (== local0 49)
							(gCurRoom setScript: climbWebRoseAbove)
						else
							(gCurRoom setScript: climbWebRoseBelow)
						)
					)
					((== local0 59)
						(gCurRoom setScript: climbWebValAbove)
					)
					(else
						(gCurRoom setScript: climbWebValBelow)
					)
				)
			)
		)
	)
)

(instance westFeat of ExitFeature
	(properties
		nsTop 80
		nsRight 20
		nsBottom 130
		sightAngle 370
		approachY 100
		exitDir 4
	)

	(method (handleEvent event)
		(if (not (gUser canControl:))
			(return 1)
		else
			(super handleEvent: event)
		)
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 8 setHotspot: 8 10) ; Do, Do, Exit
	)

	(method (doVerb)
		(gCurRoom setScript: sLeaveWest)
	)
)

(instance southFeat of ExitFeature
	(properties
		nsLeft 40
		nsTop 130
		nsRight 185
		nsBottom 170
		approachX 129
		approachY 142
		x 129
		y 180
		exitDir 3
	)

	(method (handleEvent event)
		(if (not (gUser canControl:))
			(return 1)
		else
			(super handleEvent: event)
		)
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 8 setHotspot: 8 10) ; Do, Do, Exit
	)

	(method (doVerb)
		(gCurRoom setScript: sExitSouth)
	)
)

(instance northFeat of ExitFeature
	(properties
		nsLeft 26
		nsTop 58
		nsRight 77
		nsBottom 93
		approachX 50
		approachY 100
		x 300
		exitDir 1
	)

	(method (handleEvent event)
		(if (not (gUser canControl:))
			(return 1)
		else
			(super handleEvent: event)
		)
	)

	(method (init)
		(super init: &rest)
		(self approachVerbs: 8 setHotspot: 8 10) ; Do, Do, Exit
	)

	(method (doVerb)
		(gCurRoom newRoom: 4050)
	)
)

(instance firecracker of Prop
	(properties
		approachX 105
		approachY 129
		x 98
		y 137
		view 4274
		loop 2
	)

	(method (init)
		(super init:)
		(self
			setHotspot: 8 10 ; Do, Exit
			approachVerbs: 8 10 ; Do, Exit
			ignoreActors:
			setPri: 129
			setCycle: Fwd
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PNearestAccess
					init: 94 125 102 125 102 133 94 133
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom setScript: getFirecracker)
			)
		)
	)
)

(instance soundEffect of Sound
	(properties)
)

(instance soundEffect2 of Sound
	(properties)
)

(instance fireSound of Sound
	(properties
		number 4253
		loop -1
	)
)

(instance potsSound of Sound
	(properties
		number 4257
		loop -1
	)
)

(instance catYowl of Sound
	(properties
		number 4269
	)
)

(instance kidChant of Sound
	(properties
		number 42671
		loop -1
	)
)

