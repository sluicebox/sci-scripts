;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 240)
(include sci.sh)
(use Main)
(use ExitFeature)
(use eRS)
(use Climber)
(use Jungle)
(use Print)
(use Talker)
(use Scaler)
(use Osc)
(use Polygon)
(use Feature)
(use LoadMany)
(use Rev)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm240 0
	toucanTalker 1
	boaTalker 2
	caciqueTalker 3
	hyacinthTalker 4
	fredTalker 5
	ethelTalker 6
	lucyTalker 7
	rickyTalker 8
	humBirdTalker 9
)

(local
	local0
	local1
	local2
	local3
	local4 = 4
	[local5 2]
)

(instance rm240 of Eco2Room
	(properties
		noun 13
		picture 240
		style 10
		horizon -1
		west 280
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gMessager say: 1 0 1 0 0 14) ; "That's not a good spot for climbing."
			)
			(3 ; Walk
				(gMessager say: 1 0 1 0 0 14) ; "That's not a good spot for climbing."
			)
			(1 ; Look
				(gMessager say: 13 1 (if local0 3 else 2))
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		((Jungle climbers:) dispose:)
		(Jungle climbers: 0)
		(if
			(and
				(gCurrentRegionFlags test: 5)
				(not (gCurrentRegionFlags test: 6))
				(not (gCurrentRegionFlags test: 7))
			)
			(Jungle notify:)
		)
		(super dispose:)
	)

	(method (init &tmp temp0)
		(LoadMany rsVIEW 0 5 205 2 6 7)
		(gGame handsOn:)
		(switch gPrevRoomNum
			(260
				(= style 13)
				(self setScript: fromTreeTop)
			)
			(280
				(= style 12)
			)
			(else
				(= style 14)
				(self setScript: fromFloor)
			)
		)
		(Jungle climbers: (List new:) nestBurn: (+ (Jungle nestBurn:) 1))
		((Jungle climbers:)
			add: ctrl2 ctrl3 ctrl4 ctrl5 ctrl7 ctrl9 ctrl12 ctrl13 ctrl14
		)
		(sloth init: setScript: eatIt)
		(hyacinth init: setScript: ((ScriptID 299 2) new:)) ; birdMove
		(rickyMac init: setScript: ((ScriptID 299 2) new:)) ; birdMove
		(lucyMac init: setScript: ((ScriptID 299 2) new:)) ; birdMove
		(fredMac init: setScript: ((ScriptID 299 2) new:)) ; birdMove
		(ethelMac init: setScript: ((ScriptID 299 2) new:)) ; birdMove
		(cacique init: setScript: ((ScriptID 299 2) new:)) ; birdMove
		(nest init:)
		(highLimb init:)
		(lowLimb init:)
		(ltBlueFlower init:)
		(pinkFlower init:)
		(purpleFlower init:)
		(redFlower init:)
		(yellowFlower init:)
		(sky init:)
		(gTheDoits
			add: ltBlueFlower pinkFlower purpleFlower redFlower yellowFlower
		)
		(= local2 (gCurrentRegionFlags test: 15))
		(= local1 (gCurrentRegionFlags test: 14))
		(= local0 (gCurrentRegionFlags test: 5))
		(= local3
			(if (gCurrentRegionFlags test: 6)
				(not (gCurrentRegionFlags test: 7))
			)
		)
		(super init: &rest)
		(if (== gPrevRoomNum 280)
			(if (< (gEgo y:) 100)
				(gEgo
					posn: 33 40
					setLoop: 0
					init:
					normalize: 0
					setScale: Scaler 89 79 42 55
					setScript: ctrl9 0 999
				)
			else
				(gEgo
					scaleX: 110
					scaleY: 110
					maxScale: 110
					scaleSignal: 5
					posn: 29 173
					setLoop: 0
					init:
					normalize: 0
					setScript: ctrl3 0 999
				)
			)
		)
		(maBird
			setLoop: (if local0 5 else 2)
			setScript:
				(cond
					(local0
						((ScriptID 299 2) new:) ; birdMove
					)
					((gCurrentRegionFlags test: 18) 0)
					(else maSquawker)
				)
			init:
		)
		(paBird
			setLoop: (if local0 6 else 1)
			setScript:
				(cond
					(local0
						((ScriptID 299 2) new:) ; birdMove
					)
					((gCurrentRegionFlags test: 18) 0)
					(else paSquawker)
				)
			init:
		)
		(egg
			x: (if local0 263 else 254)
			init:
			setScript:
				(cond
					((and local0 (not (gCurrentRegionFlags test: 17))) eggHatch)
					((gCurrentRegionFlags test: 17) chickScript)
					(else eggScript)
				)
		)
		(broBird
			init:
			setScript:
				(if (and (gCurrentRegionFlags test: 4) (not (gCurrentRegionFlags test: 13)))
					allWet
				else
					broScript
				)
		)
		(hummingBird init: setScript: hummingBirdScr)
		(if (not local0)
			(burner
				setLoop:
					(cond
						((<= (Jungle nestBurn:) 2) 0)
						((<= (Jungle nestBurn:) 4) 1)
						(else 2)
					)
				setCycle: Fwd
				init:
			)
		)
		(if (not local2)
			(if local0
				(boaBody init: setLoop: 3 cycleSpeed: 12 noun: 4)
			else
				(boaBody init: noun: (if local1 4 else 24))
				(boa
					init:
					setCel: (if local1 5 else 0)
					noun: (if local1 4 else 24)
				)
			)
		)
		(for ((= temp0 0)) (< temp0 2) ((++ temp0))
			((= [local5 temp0] (Epiphyte new:))
				init:
				x: (if temp0 10 else 305)
				y: (if temp0 120 else 65)
				setOnMeCheck:
					2
					(if temp0
						((Polygon new:)
							type: PTotalAccess
							init: 16 109 15 125 9 129 5 120 7 107
							yourself:
						)
					else
						((Polygon new:)
							type: PTotalAccess
							init: 306 61 313 57 317 70 301 70 297 78 288 76 301 56
							yourself:
						)
					)
			)
			(gTheDoits add: [local5 temp0])
		)
	)
)

(instance nest of Feature
	(properties
		x 259
		y 81
		noun 1
		nsTop 73
		nsLeft 243
		nsBottom 89
		nsRight 275
		approachX 260
		approachY 81
	)

	(method (doVerb theVerb)
		(if (and (not (gCurrentRegionFlags test: 34)) (== theVerb 2) (gCurrentRegionFlags test: 17)) ; Talk
			(gCurrentRegionFlags set: 34)
			(gGame points: 1)
		)
		(cond
			((and (== theVerb 2) local0) ; Talk
				(gCurRoom setScript: chirpScr)
			)
			((OneOf theVerb 1 4 2) ; Look, Do, Talk
				(gMessager say: noun theVerb (if local0 3 else 2))
			)
			((and (== theVerb 53) (not local0)) ; Recycle
				(gMessager say: noun theVerb 2)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance highLimb of Feature
	(properties
		x 81
		y 44
		noun 3
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 0 38 38 37 99 40 133 53 132 72 90 53 77 58 0 44
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance lowLimb of Feature
	(properties
		x 85
		y 148
		noun 2
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 0 167 18 172 66 137 139 137 133 163 62 169 23 189 0 187
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance ltBlueFlower of Feature
	(properties
		x 238
		y 141
		noun 17
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 192 137 210 130 239 131 273 137 272 148 236 158 227 144 204 147
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (doit)
		(if (not (IsEcorderFlag 11))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 11))
			(super doVerb: theVerb)
		)
	)
)

(instance pinkFlower of Feature
	(properties
		x 40
		y 190
		noun 12
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 35 128 49 134 31 158 18 151
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (doit)
		(if (not (IsEcorderFlag 7))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 7))
			(super doVerb: theVerb)
		)
	)
)

(instance purpleFlower of Feature
	(properties
		x 82
		y 45
		noun 15
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 60 20 85 35 95 25 105 29 95 56 89 79 79 68 82 46 57 40 50 27
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (doit)
		(if (not (IsEcorderFlag 11))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 11))
			(super doVerb: theVerb)
		)
	)
)

(instance redFlower of Feature
	(properties
		x 296
		y 10
		noun 18
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 288 0 301 0 303 34 289 25
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (doit)
		(if (not (IsEcorderFlag 7))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 7))
			(super doVerb: theVerb)
		)
	)
)

(instance yellowFlower of Feature
	(properties
		x 95
		y 149
		noun 16
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 88 113 106 132 104 158 126 172 117 180 91 161 95 139 89 135 83 149 74 147 75 126
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (doit)
		(if (not (IsEcorderFlag 11))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 11))
			(super doVerb: theVerb)
		)
	)
)

(instance sky of Feature
	(properties
		x 265
		y 5
		noun 19
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 319 0 319 44 170 39 179 28
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance exitNorth of ExitFeature
	(properties
		nsLeft 127
		nsBottom 18
		nsRight 166
		cursor 13
		exitDir 1
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(gEgo setScript: toTreeTop)
		)
	)
)

(instance exitWestTop of ExitFeature
	(properties
		nsTop 34
		nsBottom 46
		nsRight 5
		cursor 12
		exitDir 4
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(gGame handsOff:)
			(gEgo
				view: 205
				setLoop: -1
				setCycle: Walk
				setMotion: MoveTo 0 38
			)
		)
	)
)

(instance exitWestBottom of ExitFeature
	(properties
		nsTop 165
		nsBottom 189
		nsRight 5
		cursor 12
		exitDir 4
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(gGame handsOff:)
			(gEgo
				view: 205
				setLoop: -1
				setCycle: Walk
				setMotion: MoveTo 0 171
			)
		)
	)
)

(instance exitSouth of ExitFeature
	(properties
		nsTop 180
		nsLeft 128
		nsBottom 189
		nsRight 183
		cursor 10
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(gEgo setScript: toFloor)
		)
	)
)

(instance egg of Prop
	(properties
		x 256
		y 79
		noun 1
		view 241
		loop 3
		signal 16385
		detailLevel 4
	)

	(method (cue)
		(super cue:)
		(Print addText: 1 2 3 2 250 50 240 init:) ; "Chirp!"
	)

	(method (doit)
		(if (not (IsEcorderFlag 24))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb)
		(nest doVerb: &rest)
	)
)

(instance burner of Prop
	(properties
		x 272
		y 60
		noun 1
		view 240
		priority 1
		signal 16
		detailLevel 2
	)

	(method (doVerb theVerb)
		(nest doVerb: theVerb)
	)
)

(instance maBird of Prop
	(properties
		x 251
		y 74
		noun 6
		view 241
		loop 2
		priority 1
		signal 16
		detailLevel 2
	)

	(method (doit)
		(if (not (IsEcorderFlag 24))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 24))
			(cond
				((OneOf theVerb 1 4) ; Look, Do
					(gMessager say: noun theVerb (if local0 3 else 2))
				)
				((== theVerb 2) ; Talk
					(if (not (gCurrentRegionFlags test: 27))
						(gCurrentRegionFlags set: 27)
						(gGame points: 1)
					)
					(gMessager
						say:
							noun
							theVerb
							(cond
								(local3 10)
								(local0 3)
								(else 2)
							)
					)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance paBird of Prop
	(properties
		x 278
		y 77
		noun 5
		view 241
		loop 1
		priority 2
		signal 16
		detailLevel 2
	)

	(method (doit)
		(if (not (IsEcorderFlag 24))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 24))
			(cond
				((OneOf theVerb 1 4) ; Look, Do
					(gMessager say: noun theVerb (if local0 3 else 2))
				)
				((== theVerb 2) ; Talk
					(if (not (gCurrentRegionFlags test: 28))
						(gCurrentRegionFlags set: 28)
						(gGame points: 1)
					)
					(gMessager
						say:
							noun
							theVerb
							(cond
								(local3 10)
								(local0 3)
								(else 2)
							)
					)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance broBird of Prop
	(properties
		x 172
		y 21
		noun 10
		view 241
		loop 5
		cel 2
		priority 2
		signal 16401
		detailLevel 3
	)

	(method (doit)
		(if (not (IsEcorderFlag 24))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 24))
			(cond
				((OneOf theVerb 1 4) ; Look, Do
					(gMessager say: noun theVerb (if local0 3 else 2))
				)
				((== theVerb 2) ; Talk
					(if (not (gCurrentRegionFlags test: 31))
						(gCurrentRegionFlags set: 31)
						(gGame points: 1)
					)
					(gMessager
						say:
							noun
							theVerb
							(cond
								(local3 10)
								(local0 3)
								(else 2)
							)
					)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance hyacinth of Prop
	(properties
		x 238
		y 178
		noun 22
		view 240
		loop 12
		priority 12
		signal 16401
		cycleSpeed 10
		detailLevel 2
	)

	(method (doit)
		(if (not (IsEcorderFlag 19))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 19))
			(if (== theVerb 2) ; Talk
				(if (not (gCurrentRegionFlags test: 22))
					(gCurrentRegionFlags set: 22)
					(gGame points: 1)
				)
				(gMessager
					say:
						noun
						theVerb
						(cond
							(local3 10)
							(local0 3)
							(else 2)
						)
				)
			else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance cacique of Prop
	(properties
		x 216
		y 183
		noun 21
		view 240
		loop 9
		cel 1
		signal 16385
		cycleSpeed 15
		detailLevel 2
	)

	(method (doit)
		(if (not (IsEcorderFlag 26))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 26))
			(if (== theVerb 2) ; Talk
				(if (not (gCurrentRegionFlags test: 30))
					(gCurrentRegionFlags set: 30)
					(gGame points: 1)
				)
				(gMessager
					say:
						noun
						theVerb
						(cond
							(local3 10)
							(local0 3)
							(else 2)
						)
				)
			else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance rickyMac of Prop
	(properties
		x 25
		y 13
		noun 7
		view 240
		loop 15
		signal 16385
		cycleSpeed 12
		detailLevel 4
	)

	(method (doit)
		(if (not (IsEcorderFlag 25))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 25))
			(switch theVerb
				(1 ; Look
					(fredMac doVerb: theVerb)
				)
				(2 ; Talk
					(if (not (gCurrentRegionFlags test: 25))
						(gCurrentRegionFlags set: 25)
						(gGame points: 1)
					)
					(gMessager
						say:
							noun
							theVerb
							(cond
								(local3 10)
								(local0 3)
								(else 2)
							)
					)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance fredMac of Prop
	(properties
		x 47
		y 77
		noun 8
		view 240
		loop 14
		cel 2
		signal 16385
		cycleSpeed 12
		detailLevel 3
	)

	(method (doit)
		(if (not (IsEcorderFlag 25))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 25))
			(if (== theVerb 2) ; Talk
				(if (not (gCurrentRegionFlags test: 23))
					(gCurrentRegionFlags set: 23)
					(gGame points: 1)
				)
				(gMessager
					say:
						noun
						theVerb
						(cond
							(local3 10)
							(local0 3)
							(else 2)
						)
				)
			else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance lucyMac of Prop
	(properties
		x 52
		y 119
		noun 9
		view 240
		loop 5
		signal 16385
		detailLevel 4
	)

	(method (doit)
		(if (not (IsEcorderFlag 25))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 25))
			(switch theVerb
				(4 ; Do
					(gMessager say: noun theVerb (if local0 3 else 2))
				)
				(2 ; Talk
					(if (not (gCurrentRegionFlags test: 26))
						(gCurrentRegionFlags set: 26)
						(gGame points: 1)
					)
					(gMessager
						say:
							noun
							theVerb
							(cond
								(local3 10)
								(local0 3)
								(else 2)
							)
					)
				)
				(else
					(super doVerb: theVerb)
				)
			)
		)
	)
)

(instance ethelMac of Prop
	(properties
		x 80
		y 171
		noun 11
		view 240
		loop 4
		cel 3
		priority 15
		signal 16401
		detailLevel 5
	)

	(method (doit)
		(if (not (IsEcorderFlag 25))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 25))
			(if (== theVerb 2) ; Talk
				(if (not (gCurrentRegionFlags test: 24))
					(gCurrentRegionFlags set: 24)
					(gGame points: 1)
				)
				(gMessager
					say:
						noun
						theVerb
						(cond
							(local3 10)
							(local0 3)
							(else 2)
						)
				)
			else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sloth of Prop
	(properties
		x 253
		y 142
		noun 20
		view 240
		loop 3
		cel 1
		signal 16384
		cycleSpeed 10
		detailLevel 3
	)

	(method (doit)
		(if (not (IsEcorderFlag 23))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(if (not (self perform: gWriteEcorderData theVerb 23))
			(if (== theVerb 2) ; Talk
				(if (not (gCurrentRegionFlags test: 21))
					(gCurrentRegionFlags set: 21)
					(gGame points: 1)
				)
				(gMessager
					say:
						noun
						theVerb
						(cond
							(local3 10)
							(local0 3)
							(else 2)
						)
				)
			else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance boaBody of Prop
	(properties
		x 55
		y 47
		noun 24
		view 250
		signal 16385
	)

	(method (doVerb theVerb)
		(boa doVerb: theVerb)
	)
)

(instance boa of Prop
	(properties
		x 74
		y 45
		noun 24
		view 250
		loop 1
		signal 16385
	)

	(method (doit)
		(if (and (== noun 4) (not (IsEcorderFlag 27)))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(cond
			((and (== theVerb 55) (IsEcorderFlag 27) (not (IsEcorderFlag 11))) ; E-corder
				(Orchid doVerb: theVerb)
			)
			((== noun 4)
				(if (not (self perform: gWriteEcorderData theVerb 27))
					(if
						(and
							(== theVerb 4) ; Do
							(== (gEgo script:) ctrl13)
							(not local2)
						)
						(ctrl13 setScript: ctrl9From1Snake)
					else
						(if (and (== theVerb 2) (not (gCurrentRegionFlags test: 35))) ; Talk
							(gCurrentRegionFlags set: 35)
							(gGame points: 1)
						)
						(super doVerb: theVerb)
					)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sFX of Sound
	(properties)
)

(instance maSquawk of Sound
	(properties)
)

(instance paSquawk of Sound
	(properties)
)

(instance boaGone of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (gCurrentRegionFlags test: 6))
					(Jungle notify:)
					(= local3 1)
				)
				(gCurrentRegionFlags set: 15)
				(= local2 1)
				(= seconds 2)
			)
			(1
				(client setCycle: End self)
			)
			(2
				(client dispose:)
			)
		)
	)
)

(instance toTreeTop of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 0 self)
			)
			(1
				(gEgo view: 7 setLoop: 3 setCel: 0 setCycle: End self)
			)
			(2
				(gEgo
					view: 6
					setCel: 0
					posn: 143 27
					scaleSignal: (| (gEgo scaleSignal:) $0004)
					yStep: 4
					setCycle: Fwd
					setScale: Scaler 89 75 27 0
					setMotion: MoveTo 143 -25 self
				)
			)
			(3
				(gCurRoom newRoom: 260)
				(self dispose:)
			)
		)
	)
)

(instance fromTreeTop of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 6
					setCel: 0
					posn: 143 -4
					yStep: 4
					scaleX: 110
					scaleY: 110
					maxScale: 110
					scaleSignal: 5
					init:
					setScale:
					setCycle: Rev
					setMotion: MoveTo 143 27 self
				)
			)
			(1
				(gEgo
					view: 7
					posn: 143 51
					setLoop: 3
					setCel: 255
					setCycle: Beg self
				)
			)
			(2
				(gEgo
					normalize: 0
					setScale:
					setScript: ctrl13 0 999
					setHeading: 180 self
				)
			)
			(3
				(if (or (broBird loop:) (gCurrentRegionFlags test: 13))
					(gGame handsOn:)
					(self dispose:)
				else
					(= ticks 6)
				)
			)
			(4
				(gCurrentRegionFlags set: 13)
				(gMessager say: 10 0 1 0 self) ; "Hey! What's the big idea getting me all wet!"
			)
			(5
				(gEgo setHeading: 90 self)
			)
			(6
				(= seconds 2)
			)
			(7
				(gEgo
					view: 2
					setLoop: 7
					setCel: 0
					cycleSpeed: 12
					setCycle: CT 2 1 self
				)
			)
			(8
				(= seconds 2)
			)
			(9
				(gEgo setCycle: End self)
			)
			(10
				(gEgo normalize: 0 setHeading: 180 self)
			)
			(11
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance toFloor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 0 self)
			)
			(1
				(gEgo
					view: 7
					setLoop: 7
					setCel: 255
					posn: 146 178
					setCycle: Beg self
				)
			)
			(2
				(gGameSound2 number: 297 loop: 1 play: self)
			)
			(3
				(gMessager say: 13 0 4 1 self) ; "There is a sound of snuffling below."
			)
			(4
				(= ticks 10)
			)
			(5
				(gEgo setCycle: End self)
			)
			(6
				(gEgo
					posn: 132 138
					normalize: 0
					setPri: 12
					setHeading: 180 self
				)
			)
			(7
				(= cycles 2)
			)
			(8
				(gMessager say: 13 0 4 2 self) ; "I don't know what's down there and I don't want to find out!"
			)
			(9
				(gGame handsOn:)
				(gEgo setScript: ctrl14 0 999)
			)
		)
	)
)

(instance fromFloor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 7
					setLoop: 7
					setCel: 0
					posn: 146 178
					scaleX: 110
					scaleY: 110
					maxScale: 110
					scaleSignal: 1
					setScale:
					init:
					setCycle: End self
				)
			)
			(1
				(gEgo
					posn: 132 138
					normalize: 0
					setPri: 12
					setHeading: (if (gCurrentRegionFlags test: 18) 180 else 45) self
				)
			)
			(2
				(= cycles 2)
			)
			(3
				(if (not (gCurrentRegionFlags test: 18))
					(gCurrentRegionFlags set: 18)
					(gMessager say: 13 0 9 0 self) ; "Oh, help, the nest!"
				else
					(self cue:)
				)
			)
			(4
				(gGame handsOn:)
				(gEgo setScript: ctrl14 0 999)
				(self dispose:)
			)
		)
	)
)

(instance ctrl2 of Climber
	(properties
		myColor 4
		from1 4096
		access1 25272
	)

	(method (init)
		(= from1S ctrl2From1)
		(super init: &rest)
	)
)

(instance ctrl2From1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					setScale: Scaler 89 83 81 79
					setMotion: MoveTo 129 82 self
				)
			)
			(1
				(gEgo setMotion: MoveTo 120 84 self)
			)
			(2
				(gEgo setMotion: MoveTo 107 79 self)
			)
			(3
				(gEgo setMotion: MoveTo 92 84 self)
			)
			(4
				(gEgo setMotion: MoveTo 60 81 self)
			)
			(5
				(gEgo normalize: 0)
				(self dispose:)
			)
		)
	)
)

(instance ctrl3 of Climber
	(properties
		myColor 8
		from1 16
		access1 29348
	)

	(method (init)
		(exitWestBottom init:)
		(= from1S ctrl3From1)
		(super init: &rest)
	)

	(method (dispose)
		(exitWestBottom dispose:)
		(super dispose:)
	)
)

(instance ctrl3From1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 29 173 self
				)
			)
			(1
				(gEgo normalize: 0)
				(self dispose:)
			)
		)
	)
)

(instance ctrl4 of Climber
	(properties
		myColor 16
		from1 8
		from2 16384
		access2 12964
	)

	(method (init)
		(= from1S ctrl4From1)
		(= from2S ctrl4From2)
		(super init: &rest)
	)
)

(instance ctrl4From1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 69 140 self
				)
			)
			(1
				(if (== (Jungle climbColor:) (client myColor:))
					(gEgo normalize: 0 setHeading: 180)
				)
				(exitWestBottom dispose:)
				(self dispose:)
			)
		)
	)
)

(instance ctrl4From2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 69 140 self
				)
			)
			(1
				(gEgo normalize: 0)
				(self dispose:)
			)
		)
	)
)

(instance ctrl5 of Climber
	(properties
		myColor 32
		from1 16384
		access1 12956
	)

	(method (init)
		(= from1S ctrl5From1)
		(super init: &rest)
	)
)

(instance ctrl5From1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setHeading: 90)
				(= ticks 18)
			)
			(1
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 169 139 self
				)
			)
			(2
				(gEgo setMotion: MoveTo 216 152 self)
			)
			(3
				(gEgo setPri: 14 setMotion: MoveTo 205 168 self)
			)
			(4
				(gEgo setMotion: MoveTo 228 171 self)
			)
			(5
				(if (== (Jungle climbColor:) (client myColor:))
					(gEgo normalize: 0 setHeading: 180)
				)
				(self dispose:)
			)
		)
	)
)

(instance ctrl7 of Climber
	(properties
		myColor 128
		from1 4096
		from2 8192
		access1 4
		access2 16952
	)

	(method (init)
		(= from1S ctrl7From1)
		(= from2S ctrl7From2)
		(super init: &rest)
	)
)

(instance ctrl7From1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 166 84 self
				)
			)
			(1
				(gEgo setMotion: MoveTo 198 68 self)
			)
			(2
				(if (== (Jungle climbColor:) (client myColor:))
					(gEgo normalize: 0 setHeading: 135)
				)
				(self dispose:)
			)
		)
	)
)

(instance ctrl7From2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Load rsVIEW 0)
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					setPri: 13
					setMotion: MoveTo 178 60 self
				)
			)
			(1
				(gEgo setMotion: MoveTo 198 68 self)
			)
			(2
				(if
					(and
						(!= client gEgo)
						(== (Jungle climbColor:) (client myColor:))
					)
					(gEgo normalize: 0 setPri: 13 setHeading: 135)
				)
				(self dispose:)
			)
		)
	)
)

(instance ctrl9 of Climber
	(properties
		myColor 512
		from1 8192
		access1 20668
	)

	(method (init)
		(= from1S (if local0 ctrl9From1 else ctrl9From1Snake))
		(if (and local0 (not local2))
			(boaBody setScript: boaGone)
		)
		(if local2
			(exitWestTop init:)
		)
		(super init: &rest)
	)
)

(instance ctrl9From1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 125 55 self
				)
			)
			(1
				(gEgo
					setScale: Scaler 89 79 42 55
					setMotion: MoveTo 100 42 self
				)
			)
			(2
				(gEgo setMotion: MoveTo 73 47 self setScale:)
			)
			(3
				(gEgo setMotion: MoveTo 33 40 self)
			)
			(4
				(if (== (Jungle climbColor:) (client myColor:))
					(gEgo normalize: 0 setHeading: 180)
				)
				(self dispose:)
			)
		)
	)
)

(instance ctrl9From1Snake of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 125 55 self
				)
			)
			(1
				(if local1
					(boa setLoop: 2 setCel: 0 setCycle: End self)
				else
					(boa setCycle: End self)
				)
				(gGameSound2 number: 245 loop: 1 play:)
				(if (not local1)
					(gEgo
						view: 2
						setLoop: 5
						setCel: 0
						cycleSpeed: 10
						setCycle: CT 2 1
					)
				)
			)
			(2
				(if (not local1)
					((ScriptID 1009) setupTalker: 4) ; EgoTalker
					(gMessager say: 4 4 0 0 self) ; "Sssssstay back or I will ssssssqueeeeezzzzzze you!"
					((ScriptID 1009) setupTalker:) ; EgoTalker
				else
					(= ticks 48)
				)
			)
			(3
				(if local1
					(boa setCycle: Beg self)
				else
					(gEgo normalize: 0)
					(self cue:)
				)
			)
			(4
				(if (not local1)
					(gCurrentRegionFlags set: 14)
					(= local1 1)
					(boa noun: 4)
					(boaBody noun: 4)
				)
				(boa setLoop: 1 setCel: 255)
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 143 51 self
				)
			)
			(5
				(gEgo normalize: 0 setHeading: 270 self)
			)
			(6
				(self dispose:)
				(gEgo setScript: ctrl13 0 999)
			)
		)
	)
)

(instance ctrl12 of Climber
	(properties
		myColor 4096
		from1 4
		from2 128
		access2 25144
	)

	(method (init)
		(= from1S ctrl12From1)
		(= from2S ctrl12From2)
		(super init: &rest)
	)
)

(instance ctrl12From1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					setPri: 13
					setMotion: MoveTo 92 84 self
				)
			)
			(1
				(gEgo setMotion: MoveTo 107 79 self)
			)
			(2
				(gEgo setMotion: MoveTo 120 84 self)
			)
			(3
				(gEgo setMotion: MoveTo 129 82 self)
			)
			(4
				(gEgo
					setScale: Scaler 89 83 81 79
					setMotion: MoveTo 140 81 self
				)
			)
			(5
				(gEgo normalize: 0 setScale: setPri: 13)
				(self dispose:)
			)
		)
	)
)

(instance ctrl12From2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 166 84 self
				)
			)
			(1
				(gEgo setPri: 13 setMotion: MoveTo 139 81 self)
			)
			(2
				(if (== (Jungle climbColor:) (client myColor:))
					(gEgo normalize: 0 setPri: 13 setHeading: 180)
				)
				(self dispose:)
			)
		)
	)
)

(instance ctrl13 of Climber
	(properties
		myColor 8192
		from1 16384
		from2 128
		from3 512
		access1 56
		access2 4100
	)

	(method (init)
		(exitNorth init:)
		(= from1S ctrl13From1)
		(= from2S ctrl13From2)
		(= from3S ctrl13From3)
		(if (and local0 (not local2) (!= (egg script:) eggHatch))
			(boaBody setScript: boaGone)
		)
		(super init: &rest)
	)

	(method (dispose)
		(exitNorth dispose:)
		(super dispose:)
	)
)

(instance ctrl13From1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 158 140 self
				)
			)
			(1
				(gEgo normalize: 0 setHeading: 0 self)
			)
			(2
				(gEgo
					view: 7
					setLoop: 3
					setCel: 0
					setPri: 12
					setCycle: End self
				)
			)
			(3
				(gEgo
					view: 6
					setCel: 0
					posn: 158 116
					scaleSignal: (| (gEgo scaleSignal:) $0004)
					yStep: 4
					setCycle: Fwd
					setMotion: MoveTo 156 67 self
				)
			)
			(4
				(gEgo
					view: 7
					setLoop: 7
					setCel: 0
					posn: 158 90
					setCycle: End self
				)
			)
			(5
				(gEgo normalize: 0 setPri: 12 posn: 143 51)
				(if (== (Jungle climbColor:) (client myColor:))
					(gEgo setHeading: 180)
				)
				(self dispose:)
			)
		)
	)
)

(instance ctrl13From2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setHeading: 315 self)
			)
			(1
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 178 60 self
				)
			)
			(2
				(gEgo setPri: 13 setMotion: MoveTo 143 51 self)
			)
			(3
				(if (== (Jungle climbColor:) (client myColor:))
					(gEgo normalize: 0 setHeading: 180)
				)
				(self dispose:)
			)
		)
	)
)

(instance ctrl13From3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 100 42 self
				)
			)
			(1
				(gEgo
					setScale: Scaler 89 79 42 55
					setMotion: MoveTo 125 55 self
				)
			)
			(2
				(gEgo setPri: 13 setMotion: MoveTo 143 51 self setScale:)
			)
			(3
				(if (== (Jungle climbColor:) (client myColor:))
					(gEgo normalize: 0 setHeading: 180)
				)
				(self dispose:)
			)
		)
	)
)

(instance ctrl14 of Climber
	(properties
		myColor 16384
		from1 8192
		from2 16
		from3 32
		access1 4740
		access2 8
	)

	(method (init)
		(exitSouth init:)
		(= from1S ctrl14From1)
		(= from2S ctrl14From2)
		(= from3S ctrl14From3)
		(super init: &rest)
	)

	(method (dispose)
		(exitSouth dispose:)
		(super dispose:)
	)
)

(instance ctrl14From1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setHeading: 0 self)
			)
			(1
				(gEgo
					view: 7
					setLoop: 7
					setCel: 255
					setPri: 12
					posn: 158 90
					setCycle: Beg self
				)
			)
			(2
				(gEgo
					view: 6
					setLoop: 3
					posn: 156 67
					setCel: 0
					yStep: 4
					scaleSignal: (| (gEgo scaleSignal:) $0004)
					setCycle: Rev
					setMotion: MoveTo 158 116 self
				)
			)
			(3
				(gEgo
					view: 7
					posn: 158 140
					setLoop: 3
					setCel: 255
					setCycle: Beg self
				)
			)
			(4
				(if (== (Jungle climbColor:) (client myColor:))
					(gEgo
						view: 205
						setLoop: -1
						setCycle: Walk
						setPri: 12
						setMotion: MoveTo 132 138 self
					)
				else
					(self dispose:)
				)
			)
			(5
				(gEgo normalize: 0 setHeading: 180)
				(self dispose:)
			)
		)
	)
)

(instance ctrl14From2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 132 138 self
				)
			)
			(1
				(if (== (Jungle climbColor:) (client myColor:))
					(gEgo normalize: 0 setHeading: 180)
				)
				(self dispose:)
			)
		)
	)
)

(instance ctrl14From3 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					view: 205
					setLoop: -1
					setCycle: Walk
					setMotion: MoveTo 205 168 self
				)
			)
			(1
				(gEgo setMotion: MoveTo 216 152 self)
			)
			(2
				(gEgo setPri: 12 setMotion: MoveTo 169 139 self)
			)
			(3
				(if (== (Jungle climbColor:) (client myColor:))
					(gEgo setMotion: MoveTo 132 138 self)
				else
					(gEgo setMotion: MoveTo 158 140 self)
				)
			)
			(4
				(if (== (Jungle climbColor:) (client myColor:))
					(gEgo normalize: 0 setHeading: 180)
				)
				(self dispose:)
			)
		)
	)
)

(instance eatIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (>= (gGame detailLevel:) (client detailLevel:))
					(client setCycle: End self)
				else
					(-= state 1)
					(= seconds 3)
				)
			)
			(1
				(if (not (-- local4))
					(= local4 (Random 3 6))
					(client setCel: 0)
					(self changeState: 0)
				else
					(client setCel: (if (client cel:) 0 else 255))
					(= cycles (client cycleSpeed:))
				)
			)
			(2
				(-= state 2)
				(self cue:)
			)
		)
	)
)

(instance allWet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client loop: 0 cel: 0 setCycle: Fwd)
				(= seconds 6)
			)
			(1
				(client cycleSpeed: 12)
				(= seconds 3)
			)
			(2
				(client cycleSpeed: 18)
				(= seconds 3)
			)
			(3
				(client setScript: broScript)
			)
		)
	)
)

(instance broScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (>= (gGame detailLevel:) (client detailLevel:))
					(client setLoop: 5 setCel: 0 setCycle: Osc 1 self)
				else
					(self cue:)
				)
			)
			(1
				(client stopUpd:)
				(= seconds (Random 3 8))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance eggHatch of Script
	(properties)

	(method (doit)
		(if (and (not (gCurRoom script:)) (== state 2))
			(gGame handsOff:)
			(self cue:)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gCurrentRegionFlags set: 17)
				(gCurrentRegionFlags clear: 27 28 21 22 23 24 25 26)
				(gCurrentRegionFlags clear: 30 31 19 11 12 29 33)
				(client setCycle: Fwd)
				(= seconds 2)
			)
			(1
				(client cycleSpeed: 3)
				(= seconds 2)
			)
			(2
				(client cycleSpeed: 2)
			)
			(3
				(Load rsVIEW 2)
				(gEgo setScript: ctrl7From2 self)
			)
			(4
				(gGame handsOff:)
				(= ticks 30)
				(sFX number: 246 play:)
			)
			(5
				(gEgo
					view: 2
					setLoop: 0
					setCel: 0
					cycleSpeed: 60
					setCycle: CT 2 1 self
				)
			)
			(6
				(sFX number: 242 play:)
				(client setLoop: 7)
				(= ticks 60)
			)
			(7
				(sFX number: 247 play:)
				(gEgo normalize: 0 setScript: ctrl7 0 999)
				(gGame handsOn: points: 10)
				(client setScript: chickScript)
			)
		)
	)
)

(instance eggScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (>= (gGame detailLevel:) (client detailLevel:))
					(client
						setLoop: 3
						cycleSpeed: 18
						setCycle: (if (Random 0 1) End else Beg) self
					)
				else
					(self cue:)
				)
			)
			(1
				(= seconds (Random 5 10))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance chickScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					setLoop: 4
					cycleSpeed: 8
					setCycle: (if (not (client cel:)) End else Beg) self
				)
				(maSquawk number: 243 play:)
			)
			(1
				(client setLoop: 7)
				(= ticks (Random 10 60))
			)
			(2
				(if (> (++ register) 20)
					(if
						(and
							(not (gCurrentRegionFlags test: 6))
							(not (gCurrentRegionFlags test: 7))
						)
						(Jungle notify:)
						(= local3 1)
					)
					(if (not local2)
						(boaBody setScript: boaGone)
					)
				)
				(self changeState: 0)
			)
		)
	)
)

(instance maSquawker of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 4 8))
			)
			(1
				(if (Random 0 3)
					(client setCycle: Fwd)
					(maSquawk number: 241 loop: 3 play:)
				)
				(= seconds (Random 2 3))
			)
			(2
				(client setCycle: Beg self)
			)
			(3
				(maSquawk stop:)
				(client stopUpd:)
				(self changeState: 0)
			)
		)
	)
)

(instance chirpScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gNarrator x: 215 y: 63 back: 90 color: 0)
				(gMessager say: 1 2 3 0 self) ; "(TO BABY) You're a cute little guy!"
			)
			(1
				(gNarrator x: -1 y: -1 back: 68 color: 57)
				(self dispose:)
			)
		)
	)
)

(instance paSquawker of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 4 6))
			)
			(1
				(if (Random 0 3)
					(client setCycle: Fwd)
					(paSquawk number: 240 loop: 3 play:)
				)
				(= seconds (Random 2 3))
			)
			(2
				(client setCycle: Beg self)
			)
			(3
				(paSquawk stop:)
				(client stopUpd:)
				(self changeState: 0)
			)
		)
	)
)

(instance toucanTalker of Narrator
	(properties
		keepWindow 1
		back 90
	)

	(method (init)
		(self x: 125 y: 40 font: gUserFont)
		(super init:)
	)
)

(instance caciqueTalker of Narrator
	(properties
		keepWindow 1
		back 90
	)

	(method (init)
		(self x: 155 y: 120 font: gUserFont)
		(super init:)
	)
)

(instance boaTalker of Narrator
	(properties
		keepWindow 1
		back 90
	)

	(method (init)
		(self x: 35 y: 60 font: gUserFont)
		(super init:)
	)
)

(instance hyacinthTalker of Narrator
	(properties
		keepWindow 1
		back 90
	)

	(method (init)
		(self x: 155 y: 120 font: gUserFont)
		(super init:)
	)
)

(instance fredTalker of Narrator
	(properties
		keepWindow 1
		back 90
	)

	(method (init)
		(self x: (+ (fredMac x:) 20) y: (- (fredMac y:) 10) font: gUserFont)
		(super init:)
	)
)

(instance ethelTalker of Narrator
	(properties
		keepWindow 1
		back 90
	)

	(method (init)
		(self x: (+ (ethelMac x:) 20) y: (- (ethelMac y:) 10) font: gUserFont)
		(super init:)
	)
)

(instance lucyTalker of Narrator
	(properties
		keepWindow 1
		back 90
	)

	(method (init)
		(self x: (+ (lucyMac x:) 20) y: (- (lucyMac y:) 10) font: gUserFont)
		(super init:)
	)
)

(instance rickyTalker of Narrator
	(properties
		keepWindow 1
		back 90
	)

	(method (init)
		(self x: (+ (rickyMac x:) 20) y: (- (rickyMac y:) 10) font: gUserFont)
		(super init:)
	)
)

(instance hummingBirdScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 10 15))
			)
			(1
				(client
					show:
					posn: (Random 50 120) -10
					setCycle: Fwd
					setMotion:
						MoveTo
						(+ 25 (Random 0 40))
						(+ 120 (Random 0 40))
						self
				)
			)
			(2
				(= ticks 30)
			)
			(3
				(client setMotion: MoveTo -10 (client y:) self)
			)
			(4
				(client hide:)
				(= seconds (Random 10 15))
				(= state -1)
			)
		)
	)
)

(instance hummingBird of Actor
	(properties
		x 75
		y -10
		noun 23
		view 260
		loop 2
		priority 15
		signal 26640
		scaleSignal 1
		scaleX 100
		scaleY 100
		cycleSpeed 0
		moveSpeed 0
	)

	(method (doit)
		(if (not (IsEcorderFlag 28))
			(self perform: gCheckEcorderIcon self)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(cond
			((and (IsEcorderFlag 28) (== theVerb 55)) ; E-corder
				(return 0)
			)
			((not (self perform: gWriteEcorderData theVerb 28))
				(if (and (== theVerb 2) (not (gCurrentRegionFlags test: 19))) ; Talk
					(gCurrentRegionFlags set: 19)
					(gGame points: 1)
				)
				(super doVerb: theVerb)
			)
		)
	)
)

(instance humBirdTalker of Narrator
	(properties
		keepWindow 1
		back 90
	)

	(method (init)
		(self
			x: (+ (hummingBird x:) 20)
			y: (+ (hummingBird y:) 10)
			font: gUserFont
		)
		(super init:)
	)
)

