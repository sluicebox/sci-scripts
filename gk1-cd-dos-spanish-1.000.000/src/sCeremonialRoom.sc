;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 900)
(include sci.sh)
(use Main)
(use GKIconbar)
(use n013)
(use drumInset)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use StopWalk)
(use Grooper)
(use Motion)
(use System)

(public
	sCeremonialRoom 0
	sGabeDies 1
)

(local
	local0
)

(instance sCeremonialRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 800 0) ; Hounfour
					addObstacle:
						((Polygon new:)
							type: PContainedAccess
							init: 0 151 319 151 319 82 289 71 258 62 246 59 221 55 179 51 134 51 91 53 73 58 59 59 29 68 0 81
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 114 72 115 86 94 88 81 84 84 71 98 69
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 36 94 29 101 20 108 6 106 6 92 23 87
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 118 91 192 91 192 106 118 106
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 307 89 315 106 297 109 280 92
							yourself:
						)
						((Polygon new:)
							type: PBarredAccess
							init: 183 79 168 71 184 62 225 64 235 70 225 77 210 80
							yourself:
						)
					curLoc: 900
				)
				((ScriptID 800 2) doit: 900) ; xDrawThePic
				(e1 init: approachVerbs: 13) ; Walk
				(e2 init: approachVerbs: 13) ; Walk
				(e3 init: approachVerbs: 13) ; Walk
				(e4 init: approachVerbs: 13) ; Walk
				(e5 init: approachVerbs: 13) ; Walk
				(e6 init: approachVerbs: 13) ; Walk
				(lDrums init:)
				(rDrums init:)
				(pole init:)
				(table init:)
				(firePit init:)
				(tableTop init:)
				(theRoom init:)
				(gWalkHandler add: e1 e2 e3 e4 e5 e6)
				(switch register
					(12
						(gEgo
							setScaler: Scaler 100 85 81 50
							normalize: 5
							posn: 267 53
							init:
							setMotion: MoveTo 243 60 self
						)
					)
					(13
						(gEgo
							setScaler: Scaler 100 85 81 50
							normalize: 1
							posn: 328 95
							init:
							setMotion: MoveTo 308 95 self
						)
					)
					(14
						(gEgo
							setScaler: Scaler 100 85 81 50
							normalize: 7
							posn: 298 187
							init:
							setMotion: MoveTo 274 142 self
						)
					)
					(15
						(gEgo
							setScaler: Scaler 100 85 81 50
							normalize: 6
							posn: 26 185
							init:
							setMotion: MoveTo 49 150 self
						)
					)
					(16
						(gEgo
							setScaler: Scaler 100 85 81 50
							normalize: 0
							posn: -10 88
							init:
							setMotion: MoveTo 11 88 self
						)
					)
					(else
						(gEgo
							setScaler: Scaler 100 85 81 50
							normalize: 4
							posn: 55 51
							init:
							setMotion: MoveTo 76 63 self
						)
					)
				)
				((ScriptID 800 0) okayToDie: 1) ; Hounfour
				(if (== ((ScriptID 800 1) room:) 900) ; xDJ
					((ScriptID 800 1) ; xDJ
						view: 835
						init:
						setLoop: -1
						setLooper: Grooper
						setCycle: StopWalk -1
						posn: 186 122
					)
					(if (OneOf register 12 13 14)
						((ScriptID 800 1) posn: 118 122) ; xDJ
					)
					(self setScript: sGabeDies2)
					(Face (ScriptID 800 1) gEgo) ; xDJ
					(gGkSound2 stop:)
				)
			)
			(1
				(if (== script sGabeDies2)
					0
				else
					(gGame handsOn:)
				)
			)
			(2
				((ScriptID 800 0) okayToDie: 0) ; Hounfour
				(gGkSound2 stop:)
				(gWalkHandler delete: e1 e2 e3 e4 e5 e6)
				(self dispose:)
			)
		)
	)
)

(instance sReadTable of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 118 110 self)
			)
			(1
				(Face gEgo table self)
			)
			(2
				(= cycles 2)
			)
			(3
				(if (not (IsFlag 446))
					(gMessager say: 1 7 2 1 self 900) ; "These panels seem to tell a story...."
				else
					(= cycles 1)
				)
			)
			(4
				(gMessager say: 1 7 3 1 self 900) ; "Tetelo holding up the talisman...."
			)
			(5
				(gEgo setMotion: PolyPath 170 115 self)
			)
			(6
				(Face gEgo table self)
			)
			(7
				(= cycles 2)
			)
			(8
				(gMessager say: 1 7 3 2 self 900) ; "A ship sailing...."
			)
			(9
				(gEgo setMotion: PolyPath 192 100 self)
			)
			(10
				(Face gEgo table self)
			)
			(11
				(= cycles 2)
			)
			(12
				(gMessager say: 1 7 3 3 self 900) ; "Slaves rising up and killing their owners. Haiti, probably...."
			)
			(13
				(gEgo setMotion: PolyPath 180 86 self)
			)
			(14
				(Face gEgo table self)
			)
			(15
				(= cycles 2)
			)
			(16
				(gMessager say: 1 7 3 4 self 900) ; "Looks like Tetelo's people arriving in New Orleans...."
			)
			(17
				(gEgo setMotion: PolyPath 129 86 self)
			)
			(18
				(Face gEgo table self)
			)
			(19
				(= cycles 2)
			)
			(20
				(gMessager say: 1 7 3 5 self 900) ; "They accumulate great power through Voodoo...."
			)
			(21
				(gEgo setMotion: PolyPath 108 100 self)
			)
			(22
				(Face gEgo table self)
			)
			(23
				(= cycles 2)
			)
			(24
				(gMessager say: 1 7 3 6 self 900) ; "The hounfour is built under Jackson Square."
			)
			(25
				(if (not (IsFlag 446))
					(SetFlag 446)
					(gMessager say: 1 7 2 3 self 900) ; "(SARCASTIC)Heck of a family album."
				else
					(= cycles 1)
				)
			)
			(26
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(switch register
					(12
						(gEgo setMotion: MoveTo 267 53 self)
					)
					(13
						(gEgo setMotion: MoveTo 318 95 self)
					)
					(14
						(gEgo setMotion: MoveTo 298 187 self)
					)
					(15
						(gEgo setMotion: MoveTo 26 185 self)
					)
					(16
						(gEgo setMotion: MoveTo 1 88 self)
					)
					(17
						(gEgo setMotion: MoveTo 55 51 self)
					)
				)
			)
			(1
				(gGame handsOn:)
				((ScriptID 800 0) curLoc: register) ; Hounfour
				(client cue:)
			)
		)
	)
)

(instance sPlayDrums of Script
	(properties)

	(method (cue)
		(if (IsFlag 406)
			(self dispose:)
		else
			(super cue: &rest)
		)
	)

	(method (dispose)
		(ClearFlag 406)
		(ClearFlag 220)
		(gEgo
			setCycle: 0
			normalize:
				(switch register
					(0 6)
					(1 7)
				)
		)
		(DisposeScript 815)
		(cond
			((IsFlag 346)
				(gMessager say: 13 0 9 0 0 900) ; "A door opens in the distance."
				(gEgo getPoints: 186 5)
				((ScriptID 800 0) drumCount: 0) ; Hounfour
				((ScriptID 800 0) doWalk:) ; Hounfour
				(gGame handsOn:)
			)
			((IsFlag 469)
				(gGkMusic1
					number: 550
					setLoop: -1
					stop:
					play:
					setVol: 0
					fade: (gGkMusic1 musicVolume:) 5 10 0
				)
				(gGame handsOn:)
			)
			(else
				(gGkMusic1
					number: 550
					setLoop: -1
					stop:
					play:
					setVol: 0
					fade: (gGkMusic1 musicVolume:) 5 10 0
				)
				(if (< ((ScriptID 800 0) drumCount:) 2) ; Hounfour
					(gMessager say: 13 0 11 0 0 900) ; "(RRCC)Gabriel plays the message, but there doesn't seem to be any response."
					((ScriptID 800 0) ; Hounfour
						drumCount: (+ ((ScriptID 800 0) drumCount:) 1) ; Hounfour
					)
					(gGame handsOn:)
				else
					(gEgo setScript: sGabeDies 0 0)
				)
			)
		)
		(super dispose: &rest)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not (IsFlag 472))
					(SetFlag 472)
					(gMessager say: 5 8 7 0 self 900) ; "Okay. I'll give it a shot, but I'm no musician."
				else
					(= cycles 1)
				)
			)
			(1
				(gCurRoom setInset: (ScriptID 815 0) self gCurRoom) ; drumInset
			)
			(2
				(= cycles 2)
			)
			(3
				(gTheIconBar dispose:)
				(= gTheIconBar GKIconbar)
				(if (gGame keepBar:)
					(gTheIconBar draw:)
				)
				(gGkMusic1 setVol: 0 fade: (gGkMusic1 musicVolume:) 5 10 0)
				(GK setCursor: gWaitCursor)
				(= cycles 1)
			)
			(4
				(gGame handsOff:)
				(Drummer doit:)
				(= cycles 1)
			)
			(5
				(gUser canControl: 0)
				(gEgo
					view: 890
					setSpeed: 6
					setCel: 0
					setLoop: (+ 0 register)
					setCycle: End self
				)
			)
			(6
				(gEgo setCel: 0 setLoop: (+ 2 register) setCycle: Fwd)
				(= cycles (Random 3 18))
			)
			(7
				(gEgo setCel: 0 setLoop: (+ 4 register) setCycle: End self)
			)
			(8
				(gEgo setCel: 0 setLoop: (+ 2 register) setCycle: Fwd)
				(= cycles (Random 3 18))
			)
			(9
				(= state 3)
				(gEgo setCel: 2 setLoop: (+ 4 register) setCycle: Beg self)
			)
			(10
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGabeDies2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(cond
					((gEgo mover:)
						(-- state)
						(= cycles 1)
					)
					((OneOf (sCeremonialRoom register:) 1 2 3)
						(gEgo setMotion: PolyPath 157 123 self)
					)
					(else
						(gEgo setMotion: PolyPath 147 123 self)
					)
				)
			)
			(2
				(gMessager say: 13 0 32 1 self 800) ; "Gabriel Knight! So it was YOU on the drums!"
				(Face (ScriptID 800 1) gEgo) ; xDJ
				(Face gEgo (ScriptID 800 1)) ; xDJ
			)
			(3
				(gMessager say: 13 0 32 2 self 800) ; "Uh...no. Malia invited me down."
			)
			(4
				(gMessager say: 13 0 32 3 self 800) ; "You lie! You will die for that!"
			)
			(5
				(gEgo hide:)
				(if (OneOf (sCeremonialRoom register:) 12 13 14)
					((ScriptID 800 1) ; xDJ
						posn: 152 121
						view: 815
						setSpeed: 8
						setCel: 0
						setLoop: 0 1
						setCycle: End self
					)
				else
					((ScriptID 800 1) ; xDJ
						posn: 152 121
						view: 815
						setSpeed: 8
						setCel: 0
						setLoop: 1 1
						setCycle: End self
					)
				)
			)
			(6
				(if (OneOf (sCeremonialRoom register:) 12 13 14)
					((ScriptID 800 1) ; xDJ
						view: 8151
						setCel: 0
						setLoop: 0 1
						setCycle: End self
					)
				else
					((ScriptID 800 1) ; xDJ
						view: 8151
						setCel: 0
						setLoop: 1 1
						setCycle: End self
					)
				)
			)
			(7
				(Palette 2 0 255 0) ; PalIntensity
				(gEgo show: posn: 0 0)
				(gCurRoom newRoom: 770) ; deathRm
			)
		)
	)
)

(instance sGabeDies of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not (gTalkers size:))
					(gEgo normalize:)
				else
					(-- state)
				)
				(= cycles 2)
			)
			(1
				(LoadMany rsVIEW 812 8121 813 8131 815 8151)
				(gEgo setSpeed: 6 setMotion: PolyPath 154 130 self)
			)
			(2
				(Face gEgo 300 130 0)
				((ScriptID 800 1) ; xDJ
					x: 330
					y: 95
					xStep: 4
					yStep: 3
					view: 835
					init:
					setCel: 0
					setLoop: -1
					setCycle: Walk
					posn: 330 95
					setMotion: MoveTo 308 95 self
				)
				(if register
					(gMessager say: 13 0 10 1 self 900) ; "Gabriel Knight! What are you doing in the hounfour?"
				else
					(gMessager say: 13 0 12 1 self 900) ; "Who is 'playing' with the sacred drums.... YOU!"
				)
			)
			(3 0)
			(4
				(if register
					(gMessager say: 13 0 10 2 self 900) ; "Uh...Malia invited me down."
				else
					(gMessager say: 13 0 12 2 self 900) ; "Just practicing."
				)
			)
			(5
				(if register
					(gMessager say: 13 0 10 3 self 900) ; "You lie! You'll die for that!"
				else
					(gMessager say: 13 0 12 3 self 900) ; "You trespassing bastard!"
				)
				((ScriptID 800 1) setMotion: PolyPath 181 130 self) ; xDJ
			)
			(6 0)
			(7
				((ScriptID 800 1) hide:) ; xDJ
				(gEgo
					view: 812
					setCel: 0
					setLoop: 1 1
					posn: 154 130
					setCycle: CT 3 1 self
				)
				(UpdateScreenItem gEgo)
			)
			(8
				(gGkSound1 setLoop: 1 number: 889 play:)
				(gEgo setCel: 4 setCycle: End self)
			)
			(9
				(gEgo setCel: 0 setCycle: CT 3 1 self)
			)
			(10
				(gGkSound1 setLoop: 1 number: 889 play:)
				(gEgo setCel: 4 setCycle: End self)
			)
			(11
				(gEgo setCel: 0 setLoop: 3 1 setCycle: CT 3 1 self)
			)
			(12
				(gGkSound1 setLoop: 1 number: 888 play:)
				(gEgo setCel: 4 setCycle: End self)
			)
			(13
				(gEgo
					view: 8121
					setCel: 0
					setLoop: 1 1
					setCycle: CT 5 1 self
				)
			)
			(14
				(gGkSound1 setLoop: 1 number: 888 play:)
				(gEgo setCel: 6 setCycle: End self)
			)
			(15
				(gEgo
					view: 813
					posn: 137 130
					setCel: 0
					setLoop: 1 1
					setCycle: CT 2 1 self
				)
			)
			(16
				(gGkSound1 setLoop: 1 number: 888 play:)
				(gEgo setCycle: CT 4 1 self)
			)
			(17
				(gGkSound1 setLoop: 1 number: 888 play:)
				(gEgo setCycle: CT 6 1 self)
			)
			(18
				(gGkSound1 setLoop: 1 number: 888 play:)
				(gEgo setCycle: CT 9 1 self)
			)
			(19
				(gGkSound1 setLoop: 1 number: 888 play:)
				(gEgo setCycle: CT 11 1 self)
			)
			(20
				(gEgo setCycle: End self)
			)
			(21
				(gEgo view: 8131 setLoop: 1 1)
				(= register 3)
				(= cycles 1)
			)
			(22
				(gGkSound1 setLoop: 1 number: 892 play:)
				(gEgo setCel: 0 setCycle: CT 4 1 self)
			)
			(23
				(gGkSound1 setLoop: 1 number: 893 play:)
				(gEgo setCel: 5 setCycle: End self)
				(= seconds 4)
			)
			(24
				(-- register)
				(if register
					(-= state 3)
				)
				(= cycles 1)
			)
			(25
				(gEgo
					view: 8121
					setCel: 0
					setLoop: 1 1
					posn: 155 129
					setCycle: CT 5 1 self
				)
			)
			(26
				(gGkSound1 setLoop: 1 number: 888 play:)
				(gEgo setCel: 6 setCycle: End self)
			)
			(27
				(gEgo
					view: 815
					setCel: 0
					setLoop: 1 1
					setCycle: CT 10 1 self
				)
			)
			(28
				(gGkSound1 setLoop: 1 number: 891 play:)
				(gEgo setCel: 11 setCycle: End self)
			)
			(29
				(gEgo view: 8151 setCel: 0 setLoop: 1 setCycle: End self)
			)
			(30
				(gCurRoom newRoom: 770) ; deathRm
			)
		)
	)
)

(instance e1 of Feature
	(properties
		noun 6
		modNum 900
		nsLeft 243
		nsTop 20
		nsRight 264
		nsBottom 61
		sightAngle 40
		approachX 243
		approachY 60
		x 253
		y 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Walk
				(sCeremonialRoom setScript: sExitRoom sCeremonialRoom 12)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 284 22 284 64 231 52 231 22
					yourself:
				)
		)
		(super init:)
	)
)

(instance e2 of Feature
	(properties
		noun 6
		modNum 900
		nsLeft 315
		nsTop 85
		nsRight 319
		nsBottom 107
		sightAngle 40
		approachX 308
		approachY 95
		x 317
		y 96
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Walk
				(sCeremonialRoom setScript: sExitRoom sCeremonialRoom 13)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance e3 of Feature
	(properties
		noun 6
		modNum 900
		nsLeft 265
		nsTop 134
		nsRight 313
		nsBottom 145
		sightAngle 40
		approachX 274
		approachY 142
		x 289
		y 139
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Walk
				(sCeremonialRoom setScript: sExitRoom sCeremonialRoom 14)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 263 130 298 120 319 131 319 147 290 146
					yourself:
				)
		)
		(super init:)
	)
)

(instance e4 of Feature
	(properties
		noun 6
		modNum 900
		nsLeft 2
		nsTop 132
		nsRight 53
		nsBottom 144
		sightAngle 40
		approachX 49
		approachY 150
		x 47
		y 152
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Walk
				(sCeremonialRoom setScript: sExitRoom sCeremonialRoom 15)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init)
		((Polygon new:)
			type: PTotalAccess
			init: 21 123 57 131 36 146 0 146 0 133
			yourself:
		)
		(super init:)
	)
)

(instance e5 of Feature
	(properties
		noun 6
		modNum 900
		nsTop 78
		nsRight 5
		nsBottom 103
		sightAngle 40
		approachX 11
		approachY 88
		x 2
		y 90
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Walk
				(sCeremonialRoom setScript: sExitRoom sCeremonialRoom 16)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance e6 of Feature
	(properties
		noun 6
		modNum 900
		nsLeft 51
		nsTop 21
		nsRight 74
		nsBottom 59
		sightAngle 40
		approachX 76
		approachY 63
		x 62
		y 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(13 ; Walk
				(sCeremonialRoom setScript: sExitRoom sCeremonialRoom 17)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init)
		((Polygon new:) type: PTotalAccess init: 39 22 87 22 87 52 39 61 yourself:)
		(super init:)
	)
)

(instance theRoom of Feature
	(properties
		noun 15
		modNum 900
		nsTop 21
		nsRight 319
		nsBottom 160
		x 162
		y 1
	)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 8 6 12 10 11 9 7 13)) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
			(gMessager say: noun 0 20 0 0 900) ; "There's no reason to use that here at the moment."
		else
			(gMessager say: noun theVerb 20 0 0 900)
		)
		(return 1)
	)
)

(instance lDrums of Feature
	(properties
		noun 5
		modNum 900
		sightAngle 40
		approachX 42
		approachY 102
		x 18
		y 100
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 6 80 9 73 16 73 17 70 22 69 28 71 29 80 26 99 21 100 19 105 10 105
					yourself:
				)
		)
		(super init:)
		(self approachVerbs: 18 8 130) ; drumBook, Operate, records or bookTribe
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 18 8 130) ; drumBook, Operate, records or bookTribe
			(if (not (IsFlag 346))
				(sCeremonialRoom setScript: sPlayDrums 0 1)
			else
				(gMessager say: 5 8 8 0 0 900) ; "Gabriel doesn't want to call attention to himself by using those drums again."
			)
			(return 1)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance rDrums of Feature
	(properties
		noun 5
		modNum 900
		sightAngle 40
		approachX 278
		approachY 101
		x 295
		y 100
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 282 79 285 74 290 75 290 72 293 69 303 70 306 80 310 83 308 104 302 105 286 94
					yourself:
				)
		)
		(super init:)
		(self approachVerbs: 18 8 130) ; drumBook, Operate, records or bookTribe
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 18 8 130) ; drumBook, Operate, records or bookTribe
			(if (not (IsFlag 346))
				(sCeremonialRoom setScript: sPlayDrums 0 0)
			else
				(gMessager say: 5 8 8 0 0 900) ; "Gabriel doesn't want to call attention to himself by using those drums again."
			)
			(return 1)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance pole of Feature
	(properties
		noun 4
		modNum 900
		sightAngle 40
		x 100
		y 80
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 107 18 108 79 100 82 91 79 92 21
					yourself:
				)
		)
		(super init:)
	)
)

(instance tableTop of Feature
	(properties
		noun 14
		modNum 900
		sightAngle 5
		x 150
		y 101
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 137 73 154 72 172 74 180 79 171 84 135 84 127 80
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(gMessager say: noun theVerb 6 0 0 900) ; "This table has a trough on top just like the snake mound's stone table."
				(return 1)
			)
			(9 ; Move
				(gMessager say: noun theVerb 6 0 0 900) ; "Moving the lid isn't that simple."
				(return 1)
			)
			(6 ; Open
				(gMessager say: noun theVerb 6 0 0 900) ; "Gabriel doesn't want to think about what it would take to open that table!"
				(return 1)
			)
			(8 ; Operate
				(gMessager say: noun theVerb 6 0 0 900) ; "Gabriel doesn't want to think about what it would take to open that table!"
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance table of Feature
	(properties
		noun 1
		modNum 900
		sightAngle 5
		x 150
		y 100
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 127 79 135 74 159 72 180 77 180 96 176 102 162 104 137 103 127 99
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 8 6 12 10 11 9 7 13)) ; Operate, Open, Pickup, Ask, Talk, Move, Look, Walk
			(gMessager say: noun 0 6 0 0 900) ; "Using that on the stone table wouldn't do anything."
			(return 1)
		else
			(switch theVerb
				(7 ; Look
					(sCeremonialRoom setScript: sReadTable)
					(return 1)
				)
				(6 ; Open
					(gMessager say: 14 theVerb 6 0 0 900) ; "Gabriel doesn't want to think about what it would take to open that table!"
					(return 1)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance firePit of Feature
	(properties
		noun 2
		modNum 900
		sightAngle 40
		x 203
		y 69
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 186 66 213 65 226 68 227 71 212 76 187 75 177 72
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(gMessager say: noun theVerb 20 0 0 900) ; "A pit for fire."
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

