;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4400)
(include sci.sh)
(use Main)
(use ExitButton)
(use aEgoTalker)
(use skipCartoon)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Timer)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm4400 0
	getTheVeilTimer 1
)

(local
	local0
	local1
	local2
)

(instance rm4400 of KQRoom
	(properties
		picture 4400
		horizon 36
		north 4102
		west 4350
		edgeW -10
	)

	(method (dispose)
		((ScriptID 19 2) nsBottom: local2) ; northFeat
		(getTheVeilTimer client: 0 delete: dispose:)
		(super dispose:)
	)

	(method (init &tmp temp0)
		(super init:)
		(if (!= (gKqMusic1 number:) 4400)
			(gKqMusic1 number: 4400 setLoop: -1 play:)
		)
		(Load rsMESSAGE 4400)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: -20 114 0 114 40 111 67 107 109 133 314 134 314 123 237 108 191 120 176 110 119 122 115 116 157 104 214 93 237 90 260 97 263 96 239 88 210 71 194 62 171 53 141 48 139 35 118 35 131 48 122 53 105 55 86 53 71 48 66 53 75 56 82 68 66 75 38 82 21 93 0 98 -20 98
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 97 73 130 55 154 60 188 67 195 75 186 82 150 85 125 85
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 59 92 102 77 120 85 109 90 146 105 115 111 88 101 83 102
					yourself:
				)
		)
		(switch gPrevRoomNum
			(4700
				(self setScript: fromCoffinCartoon)
			)
			(4102
				(if (and (== gChapter 4) (not (IsFlag 278)))
					(SetFlag 278)
					(self setScript: pussyScript)
				)
				(gEgo
					init:
					posn: 122 39
					normalize:
					setMotion: PolyPath 151 53
					setScaler: Scaler 100 36 136 33
				)
			)
			(4350
				(if (and (== gChapter 4) (not (IsFlag 278)))
					(SetFlag 278)
					(self setScript: pussyScript)
				)
				(gEgo
					init:
					posn: 2 107
					normalize:
					setMotion: PolyPath 25 107
					setScaler: Scaler 100 36 136 33
				)
			)
			(else
				(if (IsFlag 557)
					(getTheVeilTimer setReal: getTheVeilTimer 20)
					(if (not (gEgo has: 54)) ; Veil
						(veil init:)
					)
					(gEgo
						x: 129
						y: 97
						init:
						normalize:
						setScaler: Scaler 100 36 136 33
					)
				else
					(gEgo
						init:
						posn: 2 107
						normalize:
						setMotion: MoveTo 25 107
						setScaler: Scaler 100 36 136 33
					)
				)
			)
		)
		(if (not script)
			(gGame handsOn:)
		)
		(emptyGrave init:)
		(newStone init:)
		(grabbyStone init:)
		(grabbyGrave init:)
		(stone1 init:)
		(stone2 init:)
		(stone3 init:)
		(stone4 init:)
		(stone5 init:)
		(stone6 init:)
		(goUp init:)
		(goDown init:)
		(= local2 ((ScriptID 19 2) nsBottom:)) ; northFeat
		((ScriptID 19 2) nsBottom: horizon) ; northFeat
		(= local0 (if (== gValOrRoz -3) 1 else 4)) ; Roz
	)

	(method (doit)
		(super doit:)
		(cond
			(script 0)
			(
				(and
					(> (getTheVeilTimer seconds:) 0)
					(IsFlag 557)
					(or (< (gEgo x:) 30) (< (gEgo y:) 50))
				)
				(getTheVeilTimer seconds: 0)
				(self setScript: boogeyKill)
			)
			((and (grabbyGrave onMe: KQEgo) (not script))
				(self setScript: grabEgo)
			)
			((and (goUp onMe: gEgo) (not (gEgo fixPriority:)))
				(gEgo fixPriority: 1 priority: 160)
			)
			((and (goDown onMe: gEgo) (gEgo fixPriority:))
				(gEgo fixPriority: 0)
			)
			((and (not local1) (< (gEgo x:) 1))
				(= local1 1)
				(gEgo setMotion: MoveTo -30 (gEgo y:))
			)
			((>= (gEgo x:) 1)
				(= local1 0)
			)
		)
	)

	(method (notify)
		(getTheVeilTimer client: 0 delete: dispose:)
		(self setScript: putOnVeil)
	)
)

(instance pussyScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((= register (Prop new:))
					view: 4401
					loop: 0
					cel: 0
					setPri: 90
					x: 72
					y: 105
					init:
					setCycle: CT 22 1 self
				)
			)
			(1
				(if (== gPrevRoomNum 4350)
					(register setPri: (+ (gEgo priority:) 1))
				)
				(register setCycle: End self)
			)
			(2
				(register loop: 1 cel: 0 setCycle: End self)
			)
			(3
				(register dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance boogeyKill of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: 0)
				(gKqSound1 number: 4353 setLoop: 1 play: self)
			)
			(1
				((= register (Actor new:))
					view: 43510
					x: (gEgo x:)
					y: (gEgo y:)
					setPri: (- (gEgo priority:) 1)
					loop: 3
					cel: 0
					init:
				)
				(register setScaler: Scaler 100 36 136 33 setCycle: End self)
			)
			(2
				(gKqSound1 number: 4402 setLoop: 1 play:)
				(gEgo hide:)
				(register view: 43512 loop: 0 cel: 0 setCycle: End self)
			)
			(3
				(EgoDead 19 self)
			)
			(4
				(if (or (< (gEgo x:) 30) (< (gEgo y:) 50))
					(gEgo x: 129 y: 97)
				)
				(getTheVeilTimer setReal: getTheVeilTimer 20)
				(ClearFlag 5)
				(register dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fromCoffinCartoon of Script
	(properties)

	(method (changeState newState)
		(if (not (IsFlag 539))
			(switch (= state newState)
				(0
					(SetFlag 557)
					(SetFlag 192)
					(gGame handsOn:)
					(gGame handsOff: 1)
					(Load rsVIEW 4109)
					(Load rsVIEW 4110)
					(Load rsVIEW 4111)
					(Load rsVIEW 4112)
					(Load rsVIEW 8534)
					(gKqSound1 number: 908 setLoop: 1 play:)
					(= ticks 60)
				)
				(1
					((= register (Prop new:))
						view: 4109
						loop: 0
						cel: 0
						x: 173
						y: 153
						init:
						setCycle: CT 4 1 self
					)
				)
				(2
					(register setCycle: End self)
					(hole init:)
				)
				(3
					(register dispose:)
					(= register 0)
					(toad init: setCycle: End self)
				)
				(4
					(gKqSound1 number: 4407 setLoop: 1 play:)
					(toad loop: 5 cel: 0 setCycle: Blink 40)
					(trollKing setPri: 116 init: setCycle: End self)
				)
				(5
					(gEgo
						view: 4109
						loop: 3
						cel: 0
						x: 191
						y: 128
						setPri: 160
						init:
						setCycle: End self
					)
					(trollKing view: 4110 loop: 3 cel: 0 setCycle: End self)
				)
				(6)
				(7
					(hole setCycle: End)
					(gEgo
						view: 8534
						loop: 0
						cel: 14
						x: 188
						y: 130
						setCycle: Beg self
					)
				)
				(8
					(gEgo view: 4110 loop: 2 cel: 0 setCycle: End self)
				)
				(9
					(gEgo normalize: 1)
					(= cycles 5)
				)
				(10
					(gMessager say: 0 0 2 1 self) ; "Go! Tell Mathilde we are coming! And if Malicia shows her evil face in the Underground, Mathilde must try to stall her for as long as possible!"
				)
				(11
					(toad view: 4110 loop: 0 cel: 0 setCycle: CT 9 1 self)
					(gKqSound1 number: 4407 setLoop: 1 play:)
				)
				(12
					(toad setCycle: End self)
					(gKqSound1 number: 4407 setLoop: 1 play:)
				)
				(13
					(gKqSound1 number: 4407 setLoop: 1 play:)
					(toad dispose:)
					(gMessager sayRange: 0 0 2 2 3 self) ; "(GLEEFUL)We're safe!"
				)
				(14
					(trollKing loop: 4 cel: 0 setCycle: End self)
				)
				(15
					(gMessager say: 0 0 2 4 self) ; "Here, hold this object, just so. Now point it at me--"
					(gEgo
						view: 4110
						loop: 5
						cel: 0
						x: 191
						y: 128
						setCycle: CT 3 1 self
					)
				)
				(16)
				(17
					(trollKing loop: 6 cel: 0)
					(gEgo setCycle: End self)
					(gKqSound1 number: 4408 setLoop: 1 play:)
				)
				(18
					(gKqSound1 number: 4409 setLoop: 1 play:)
					(gEgo view: 4111 loop: 1 cel: 0)
					(trollKing setCycle: End self)
				)
				(19
					(gMessager sayRange: 0 0 2 5 8 self) ; "(HORRIFIED)Your majesty! What have I done?"
				)
				(20
					(trollKing loop: 9 setCycle: End)
					(veil loop: 2 cel: 0 init: setCycle: End veil)
					(sfx number: 833 setLoop: 1 play:)
					(gEgo setCycle: End self)
				)
				(21
					(gEgo
						setScaler: Scaler 100 36 136 33
						normalize: 5
						setMotion: PolyPath 135 133 self
						get: 53 ; Magic_Wand
					)
				)
				(22
					(gEgo view: 8531 loop: 1 cel: 0 setCycle: End self)
				)
				(23
					(trollKing dispose:)
					(gEgo get: 55) ; Scarab
					(= ticks 60)
				)
				(24
					(gEgo setCycle: Beg self)
				)
				(25
					(gEgo normalize: 1)
					(gEgo setPri: 160)
					(getTheVeilTimer setReal: getTheVeilTimer 35)
					(gGame handsOn:)
					(self dispose:)
				)
			)
		else
			(gEgo
				x: 135
				y: 133
				init:
				setScaler: Scaler 100 36 136 33
				normalize: 1
			)
			(gEgo setPri: 160)
			(if register
				(register dispose:)
			)
			(trollKing dispose:)
			(toad dispose:)
			(hole cel: (hole lastCel:))
			(gKqSound1 stop:)
			(gEgo get: 55) ; Scarab
			(gEgo get: 53) ; Magic_Wand
			(getTheVeilTimer setReal: getTheVeilTimer 35)
			(veil init: loop: 0 setCycle: Fwd)
			(gGame handsOn:)
			(ClearFlag 539)
			(self dispose:)
		)
	)
)

(instance putOnVeil of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 151)
				(getTheVeilTimer client: 0 delete: dispose:)
				(gEgo setHeading: 180 self)
			)
			(1
				(gEgo view: 4112 loop: 0 cel: 0 setCycle: End self put: 54) ; Veil
			)
			(2
				(gEgo heading: 135 normalize:)
				(gMessager say: 9 70 0 0 self) ; "(AS A SCARAB)There now. Everyone will think you're the lady Tsepish. You look downright scary, my dear."
			)
			(3
				(ClearFlag 557)
				(ClearFlag 192)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance grabEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 192)
				(gKqSound1 number: 4401 setLoop: 1 play: self)
				(if (== gValOrRoz -3) ; Roz
					(gEgo
						view: (if (IsFlag 151) 44021 else 4402)
						loop: 0
						cel: 0
						setMotion: 0
						setCycle: 0
					)
				else
					(gEgo view: 4405 loop: 0 cel: 0 setMotion: 0 setCycle: 0)
				)
			)
			(1
				(gEgo cycleSpeed: 10 setCycle: End self)
				(gKqSound1 number: 4402 setLoop: 1 play: self)
				(sfx number: 4403 setLoop: 1 play: self)
			)
			(2)
			(3
				(gEgo hide:)
			)
			(4
				(if (== gValOrRoz -3) ; Roz
					(EgoDead 20 self)
				else
					(EgoDead 21 self)
				)
			)
			(5
				(if (not (IsFlag 557))
					(ClearFlag 192)
				)
				(gEgo
					posn: 165 (gEgo y:)
					cycleSpeed: (gEgo moveSpeed:)
					normalize:
					setScaler: Scaler 100 36 136 33
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fallInGrave of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 192)
				(cond
					((ResCheck 140 4405) ; WAVE
						(Load 140 4405) ; WAVE
					)
					((ResCheck rsSOUND 4405)
						(Load rsSOUND 4405)
					)
				)
				(if (== gValOrRoz -3) ; Roz
					(if (IsFlag 151)
						(gEgo
							view: 44031
							loop: 0
							cel: 0
							x: 106
							y: 97
							setCycle: 0
							setScaler:
							setScale: 0
						)
					else
						(gEgo
							view: 4403
							loop: 0
							cel: 0
							x: 106
							y: 97
							setCycle: 0
							setScaler:
							setScale: 0
						)
					)
				else
					(gEgo
						view: 4406
						loop: 0
						cel: 0
						x: 130
						y: 109
						setCycle: 0
						setScaler:
						setScale: 0
					)
				)
				(= ticks 45)
			)
			(1
				(gKqMusic1 number: 4404 setLoop: 1 play:)
				(gEgo setCycle: End self)
			)
			(2
				(gEgo hide:)
				(gKqSound1 number: 4405 setLoop: 1 play: self)
				(= ticks 60)
			)
			(3
				((= register (Prop new:))
					view: (gEgo view:)
					loop: 1
					cel: 0
					setPri: 110
					x: 72
					y: 56
					init:
					setCycle: End (if ticks self else 0)
				)
				(= ticks 0)
			)
			(4
				(if (== gValOrRoz -3) ; Roz
					(EgoDead 22 self)
				else
					(EgoDead 23 self)
				)
			)
			(5
				(register dispose:)
				(gKqMusic1 number: 4400 setLoop: -1 play:)
				(if (not (IsFlag 557))
					(ClearFlag 192)
				)
				(gEgo
					x: 129
					y: 97
					normalize:
					setScaler: Scaler 100 36 136 33
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance toad of Prop
	(properties
		x 196
		y 141
		view 4109
		loop 1
	)
)

(instance trollKing of Actor
	(properties
		x 124
		y 132
		view 4109
		loop 4
	)

	(method (init)
		((ScriptID 7001 0) client: self) ; kingTalker
		(super init:)
	)

	(method (dispose)
		((ScriptID 7001 0) client: 0) ; kingTalker
		(super dispose:)
	)
)

(instance hole of Prop
	(properties
		x 172
		y 132
		priority 115
		fixPriority 1
		view 4110
		loop 1
		signal 16385
	)
)

(instance getVeil of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo view: 8444 loop: 1 cel: 0 setCycle: CT 10 1 self)
			)
			(1
				(gEgo get: 54) ; Veil
				(veil hide:)
				(gEgo setCycle: End self)
			)
			(2
				(gEgo normalize:)
				(gGame handsOn:)
				(client dispose:)
			)
		)
	)
)

(instance veil of Prop
	(properties
		x 58
		y 110
		z 30
		view 4111
	)

	(method (init)
		(super init:)
		(self
			setPri: 125
			approachVerbs: 8 ; Do
			approachX: 63
			approachY: 107
			setHotspot: 8 10 ; Do, Exit
		)
	)

	(method (cue)
		(self loop: 0 cel: 0 setCycle: Fwd)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(self setScript: getVeil)
			)
		)
	)
)

(instance emptyGrave of Feature
	(properties
		approachX 129
		approachY 97
		x 93
		y 73
	)

	(method (init)
		(super init:)
		(self
			approachVerbs: 8 ; Do
			setHotspot: 8 10 ; Do, Exit
			approachX: 129
			approachX: (if (== gValOrRoz -3) 123 else 129) ; Roz
			approachY: (if (== gValOrRoz -3) 95 else 97) ; Roz
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 89 95 119 107 140 102 104 88
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gCurRoom setScript: fallInGrave)
			)
		)
	)
)

(instance newStone of Feature
	(properties
		noun 11
		approachX 129
		approachY 97
		x 93
		y 73
	)

	(method (init)
		(super init:)
		(self
			approachVerbs: 8 ; Do
			setHotspot: 8 10 ; Do, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 95 55 72 61 79 95 87 95 104 87 109 63 105 57
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gMessager say: noun theVerb local0 1)
				(return 1)
			)
		)
	)
)

(instance grabbyStone of Feature
	(properties
		noun 1
		approachX 183
		approachY 123
		x 194
		y 96
	)

	(method (init)
		(super init:)
		(self
			setHotspot: 8 10 ; Do, Exit
			approachVerbs: 8 ; Do
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 184 113 173 105 178 99 177 89 188 74 187 65 188 57 195 47 198 54 201 85 206 92 210 109
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gMessager say: noun theVerb local0 1)
				(return 1)
			)
		)
	)
)

(instance grabbyGrave of Feature
	(properties)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 188 114 232 134 253 130 211 110
					yourself:
				)
		)
	)
)

(instance stone1 of Feature
	(properties
		noun 3
		approachX 86
		approachY 53
		x 86
		y 31
	)

	(method (init)
		(super init:)
		(self
			approachVerbs: 8 ; Do
			setHotspot: 8 10 ; Do, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 71 14 69 20 70 30 78 27 74 20 79 19 87 21 77 31 69 36 73 45 83 46 95 40 89 27 104 25 83 10
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gMessager say: noun theVerb local0 1)
				(return 1)
			)
		)
	)
)

(instance stone2 of Feature
	(properties
		noun 4
		approachX 41
		approachY 76
		x 33
		y 59
	)

	(method (init)
		(super init:)
		(self
			approachVerbs: 8 ; Do
			setHotspot: 8 10 ; Do, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 21 49 20 53 18 63 37 71 43 60 36 47
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gMessager say: noun theVerb local0 1)
				(return 1)
			)
		)
	)
)

(instance stone3 of Feature
	(properties
		noun 5
		approachX 89
		approachY 124
		x 52
		y 104
	)

	(method (init)
		(super init:)
		(self
			approachVerbs: 8 ; Do
			setHotspot: 8 10 ; Do, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 59 64 51 63 45 78 23 95 42 114 60 113 63 74
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gMessager say: noun theVerb local0 1)
				(return 1)
			)
		)
	)
)

(instance stone4 of Feature
	(properties
		noun 6
		approachX 137
		approachY 82
		x 130
		y 58
	)

	(method (init)
		(super init:)
		(self
			approachVerbs: 8 ; Do
			setHotspot: 8 10 ; Do, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 125 13 127 26 118 58 118 65 111 70 124 76 144 65 137 63 134 24
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gMessager say: noun theVerb local0 1)
				(return 1)
			)
		)
	)
)

(instance goDown of Feature
	(properties)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 78 127 131 114 135 117 83 131
					yourself:
				)
		)
	)
)

(instance goUp of Feature
	(properties)

	(method (init)
		(super init:)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 85 131 136 117 139 120 88 134
					yourself:
				)
		)
	)
)

(instance stone5 of Feature
	(properties
		noun 7
		approachX 169
		approachY 48
		x 170
		y 38
	)

	(method (init)
		(super init:)
		(self
			approachVerbs: 8 ; Do
			setHotspot: 8 10 ; Do, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 166 26 163 35 164 42 177 43 173 27
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gMessager say: noun theVerb local0 1)
				(return 1)
			)
		)
	)
)

(instance stone6 of Feature
	(properties
		noun 8
		approachX 263
		approachY 96
		x 291
		y 85
	)

	(method (init)
		(super init:)
		(self
			approachVerbs: 8 ; Do
			setHotspot: 8 10 ; Do, Exit
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 302 78 292 71 287 81 274 92 290 97 290 93 293 90 299 88
					yourself:
				)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(8 ; Do
				(gMessager say: noun theVerb local0 1)
				(return 1)
			)
		)
	)
)

(class Blink of Cycle
	(properties
		waitCount 0
		lastCount 0
		waitMin 0
		waitMax 0
	)

	(method (init param1 param2)
		(if argc
			(= waitMin (/ param2 2))
			(= waitMax (+ param2 waitMin))
			(super init: param1)
		else
			(super init:)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(waitCount
				(if (> (- gGameTime waitCount) 0)
					(= waitCount 0)
					(= cycleCnt gGameTime)
				)
			)
			((!= (= temp0 (self nextCel:)) (client cel:))
				(if (or (> temp0 clientLastCel) (< temp0 0))
					(= cycleDir (- cycleDir))
					(self cycleDone:)
				else
					(client cel: temp0)
				)
			)
		)
	)

	(method (cycleDone)
		(if (== cycleDir -1)
			(= cycleCnt gGameTime)
		else
			(= waitCount (+ (Random waitMin waitMax) gGameTime))
		)
	)
)

(instance sfx of Sound
	(properties)
)

(instance getTheVeilTimer of Timer
	(properties)

	(method (cue)
		(if (gCurRoom script:)
			(self setReal: self 10)
		else
			(gCurRoom setScript: boogeyKill)
		)
	)
)

