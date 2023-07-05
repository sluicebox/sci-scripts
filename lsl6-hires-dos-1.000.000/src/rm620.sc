;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 620)
(include sci.sh)
(use Main)
(use n078)
(use fileScr)
(use LarryRoom)
(use Print)
(use PolyPath)
(use Polygon)
(use Feature)
(use Timer)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm620 0
	phone 1
	bed 3
	upperDoor 4
	sfxL 5
	theCondom 6
)

(local
	local0
	local1
	local2 = 1
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
	local11
	local12
	local13
	local14
	local15
	local16
	local17
	local18
)

(class cObj of Obj
	(properties)
)

(instance rm620 of LarryRoom
	(properties
		noun 7
		picture 620
		horizon 0
		autoLoad 0
	)

	(method (init)
		(if (OneOf gPrevRoomNum 380 280 650 270 260)
			(= style 14)
		)
		(super init: &rest)
		(if global100
			(= local5 2)
			(= local6 2)
			(= local16 2)
		else
			(= local5 4)
			(= local6 4)
			(= local16 4)
		)
		(UpdateScreenItem ((ScriptID 92 3) view: 1900 loop: 1 cel: 0)) ; larryTBust
		(ClearFlag 4)
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 297 170 296 117 291 117 266 98 267 91 255 87 149 87 80 119 53 119 53 133 51 133 50 170
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 171 116 173 114 206 99 233 115 233 134 204 131 181 138 161 129 153 134 123 134 125 116
					yourself:
				)
		)
		(closetDoor init: approachVerbs: 4 2 5 6 setLoop: 6 ignoreActors: 1) ; Do, Talk, Take, Zipper
		(upperDoor init: ignoreActors: 1 setLoop: 0 approachVerbs: 4 2 5 6) ; Do, Talk, Take, Zipper
		(bed init: approachVerbs: 4 2 5 6 setLoop: 0 ignoreActors: 1) ; Do, Talk, Take, Zipper
		(cond
			((== gPrevRoomNum 630)
				(upperDoor view: 624 setLoop: 1 cel: 10)
				(gEgo init: normalize: 900 posn: 281 86 setLoop: 8 cel: 5)
				(self setScript: enterFromBathroomScr)
			)
			((OneOf gPrevRoomNum 380 280 650 270 260)
				(gEgo
					init:
					normalize: 622
					setCycle: 0
					setLoop: 5 1
					cel: 0
					x: 103
					y: 106
					setPri: -1
					cycleSpeed: 8
				)
				(ClearFlag 75)
				(ClearFlag 74)
				(= local8 1)
				(self setScript: fromIrisScr)
			)
			(else
				(gEgo init: normalize: 900 7 x: 301 y: 189 setLoop: 7)
				(self setScript: enterFrom600Scr)
			)
		)
		(if (or (!= (gGlobalSound1 number:) 620) (not (gGlobalSound1 handle:)))
			(gGlobalSound1 number: 620 loop: -1 play:)
		)
		(if (IsFlag 75)
			(bedFx number: 621 loop: -1 play: hold: 1)
			(bed setCycle: Fwd)
		)
		(if (and (IsFlag 240) (IsFlag 68))
			(pillow init: approachVerbs: 4 2 5 6 noun: 21) ; Do, Talk, Take, Zipper
			(bed loop: 1 noun: 21)
			(if (not (IsFlag 241))
				(theCondom
					init:
					approachVerbs: 4 2 5 6 ; Do, Talk, Take, Zipper
					setLoop: 3
					ignoreActors: 1
				)
			)
		else
			(pillow init: approachVerbs: 4 2 5 6) ; Do, Talk, Take, Zipper
		)
		(onOffButton init: approachVerbs: 4 2 5 6 ignoreActors: 1 setLoop: 5) ; Do, Talk, Take, Zipper
		(phone init: approachVerbs: 4 2 5 6 ignoreActors: 1 setLoop: 1) ; Do, Talk, Take, Zipper
		(theFlowers init: approachVerbs: 4 2 5 6 setLoop: 4 ignoreActors: 1) ; Do, Talk, Take, Zipper
		(if (IsFlag 239)
			(theFlowers noun: 24 cel: 1)
		else
			(theFlowers cel: 0)
		)
		(overHang init:)
		(theWindow init: approachVerbs: 4) ; Do
		(ladder init: approachVerbs: 4 2 5 6) ; Do, Talk, Take, Zipper
		(pool init: approachVerbs: 4 2 5 6) ; Do, Talk, Take, Zipper
		(purpleCard init: approachVerbs: 4 1 2 5 6 7) ; Do, Look, Talk, Take, Zipper, roomkey
		(redCard init: approachVerbs: 4 1 2 5 6 7) ; Do, Look, Talk, Take, Zipper, roomkey
		(blueCard init: approachVerbs: 4 1 2 5 6 7) ; Do, Look, Talk, Take, Zipper, roomkey
		(chair init: approachVerbs: 4 2 5 6) ; Do, Talk, Take, Zipper
		(table init: approachVerbs: 4 1 2 5 6 35) ; Do, Look, Talk, Take, Zipper, washcloth
		(carpet init:)
		(bungeeTimer setReal: bungeeTimer 60)
		(disposalTimer setReal: disposalTimer 100)
		(dumbWaiterTimer setReal: dumbWaiterTimer 200)
		(iceMachineTimer setReal: iceMachineTimer 300)
		(stuff init: approachVerbs: 4 2 5 6 ignoreActors: 1 setLoop: 2) ; Do, Talk, Take, Zipper
		(plant1 init:)
		(plant2 init:)
		(plant3 init:)
		(vase init: approachVerbs: 4 2 5 6) ; Do, Talk, Take, Zipper
	)

	(method (doit)
		(if (or (and local8 (IsFlag 75)) (and (== local1 1) (IsFlag 75)))
			(cond
				((and (== local2 2) (== (bed cel:) 1))
					(gEgo y: (+ (gEgo y:) 1))
					(= local2 1)
				)
				((and (== local2 1) (== (bed cel:) 0))
					(gEgo y: (- (gEgo y:) 1))
					(= local2 2)
				)
			)
		)
		(cond
			(script)
			((and (IsFlag 54) (or (< (gEgo x:) 247) (> (gEgo y:) 109)))
				(ClearFlag 101)
				(self setScript: (ScriptID 624 1)) ; finishPlumberScr
			)
			((and (> (gEgo x:) 70) (> (gEgo y:) 139))
				(self setScript: exitSouthScr)
			)
		)
		(super doit: &rest)
	)

	(method (notify param1)
		(cond
			((and ((gCurRoom script:) script:) (or (IsFlag 57) (IsFlag 97)))
				(((gCurRoom script:) script:) register: param1)
			)
			((gCurRoom script:)
				((gCurRoom script:) register: param1)
			)
		)
	)

	(method (dispose)
		(DisposeScript 610)
		(bungeeTimer dispose: delete:)
		(disposalTimer dispose: delete:)
		(iceMachineTimer dispose: delete:)
		(dumbWaiterTimer dispose: delete:)
		(shakeTimer dispose: delete:)
		(super dispose:)
	)

	(method (cue)
		(gGlobalSound1 number: 620 loop: -1 play: setVol: 127 setPri: 50)
	)
)

(instance getFlowersScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 188 104 self)
			)
			(1
				(gEgo setHeading: 180 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(theFlowers noun: 24 cel: 1)
				(gEgo get: 16) ; flowers
				(gGame handsOn: changeScore: 4 239)
				(self dispose:)
			)
		)
	)
)

(instance carpetScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (< (gEgo heading:) 181)
					(gEgo setHeading: 45 self)
				else
					(gEgo setHeading: 270 self)
				)
			)
			(1
				(= cycles 2)
			)
			(2
				(gEgo
					view: 901
					setLoop: (if (== (gEgo heading:) 45) 4 else 5)
					cel: 0
					setCycle: 0
				)
				(= cycles 2)
			)
			(3
				(gEgo setCycle: CT 3 1 self)
			)
			(4
				(= ticks 30)
			)
			(5
				(gMessager say: 6 register 0 0 self)
			)
			(6
				(gEgo setCycle: Beg self)
			)
			(7
				(gEgo normalize: 900)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterFromBathroomScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 30)
			)
			(1
				(gEgo setLoop: 5 setMotion: MoveTo 264 95 self)
			)
			(2
				(gEgo setLoop: -1 setMotion: MoveTo 259 100 self)
			)
			(3
				(= ticks 30)
			)
			(4
				(gEgo setHeading: 45 self)
			)
			(5
				(= cycles 2)
			)
			(6
				(upperDoor setCycle: Beg self)
			)
			(7
				(sfx number: 33 loop: 1 play:)
				(gEgo setHeading: 180 self)
			)
			(8
				(= cycles 2)
			)
			(9
				(upperDoor view: 620 setLoop: 0 cel: 0)
				(gGame handsOn:)
				(sfx number: 0 dispose:)
				(self dispose:)
			)
		)
	)
)

(instance bungeeJumper of Prop
	(properties
		noun 19
		sightAngle 10
		approachX 122
		approachY 101
		x 77
		y 50
		z 50
		priority 30
		fixPriority 1
		view 625
		signal 24609
	)

	(method (doVerb theVerb)
		(if (== theVerb 6) ; Zipper
			(gCurRoom setScript: flashScr)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance upperDoor of Prop
	(properties
		noun 11
		sightAngle 45
		approachX 263
		approachY 99
		x 265
		y 88
		priority 88
		fixPriority 1
		view 620
		signal 16417
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: enterBathroomScr)
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
					init: 267 34 286 37 277 96 265 85
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance theFlowers of View
	(properties
		noun 12
		sightAngle 10
		approachX 203
		approachY 100
		x 203
		y 110
		priority 130
		fixPriority 1
		view 620
		loop 4
		signal 20513
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 194 96 198 91 207 92 197 84 206 80 211 89 215 73 221 76 222 82 215 93 226 90 233 101 228 103 219 98 217 103 215 118 206 117 208 99 202 98 197 101
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((and (OneOf theVerb 15 4 1 5) (IsFlag 239)) ; ???, Do, Look, Take
				(gMessager say: 24 theVerb)
			)
			((== theVerb 5) ; Take
				(gCurRoom setScript: getFlowersScr)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance closetDoor of Prop
	(properties
		noun 9
		sightAngle 45
		approachX 302
		approachY 135
		x 292
		y 113
		priority 113
		fixPriority 1
		view 620
		loop 6
		signal 16417
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: openClosetScr)
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
					init: 295 59 310 62 309 79 314 106 307 121 295 112
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance theCondom of View
	(properties
		noun 10
		sightAngle 10
		approachX 140
		approachY 94
		x 121
		y 76
		z 2
		priority 81
		fixPriority 1
		view 620
		loop 3
	)

	(method (doit)
		(super doit:)
		(cond
			((and (== y 76) (IsFlag 75))
				(= y 75)
			)
			((and (== y 75) (IsFlag 75))
				(= y 76)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Take
				(gCurRoom setScript: handOnCondomScr)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance phone of Prop
	(properties
		noun 15
		sightAngle 10
		approachX 148
		approachY 134
		x 170
		y 115
		priority 130
		fixPriority 1
		view 620
		loop 1
		signal 16417
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 5) ; Do, Take
			(gCurRoom setScript: (ScriptID 622 0)) ; usePhoneScr
		else
			(super doVerb: theVerb)
		)
	)
)

(instance carpet of Feature
	(properties
		noun 6
		approachX 105
		approachY 124
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 67 106 83 108 92 105 97 100 121 90 139 84 140 82 258 79 263 85 265 83 277 94 277 100 286 112 294 112 307 122 301 139 57 139 57 133 63 127 64 116 63 114
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 4 5) ; Do, Take
			(gCurRoom setScript: carpetScr 0 theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance vase of Feature
	(properties
		noun 24
		approachX 203
		approachY 100
		y 10
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 212 94 210 113 199 111 198 93
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (not (IsFlag 239))
			(theFlowers doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance overHang of Feature
	(properties
		sightAngle 10
		x 245
		y 27
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 274 12 310 24 308 33 297 40 274 32 221 45 210 20 251 7
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (and (== theVerb 4) (not (-- local5))) ; Do
			(= local5 1)
			(= global213 gTheCursor)
			(gGame setCursor: gNormalCursor)
			(SetCursor 190 90)
			(while (== (= temp0 (Random 1 61)) 9)
			)
			(DoAudio audPLAY 611 1 4 temp0 1)
			(switch
				(Print
					width: 160
					font: gUserFont
					addTitle: {Carlos, are you cheating again?}
					addText: 1 4 temp0 1 50 1 611
					fore: 67
					addText: {Mark Hood, the plumber should work on what?} 50 17
					fore: 0
					addButton: 1 {sink} 50 30
					addButton: 2 {toilet} 90 30
					addIcon: 1592 1 0 0 0
					init:
				)
				(1
					(SetFlag 79)
					(SetFlag 12)
					(SetFlag 52)
					(SetFlag 80)
					(SetFlag 244)
				)
				(2
					(ClearFlag 12)
					(ClearFlag 79)
					(SetFlag 34)
					(SetFlag 19)
					(SetFlag 244)
					(SetFlag 52)
				)
			)
			(gGame setCursor: global213)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance table of Feature
	(properties
		noun 20
		sightAngle 10
		approachX 207
		approachY 132
		y 1
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 165 114 204 98 220 105 228 126 201 124 180 135
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance chair of Feature
	(properties
		noun 8
		sightAngle 45
		approachX 148
		approachY 134
		x 144
		y 133
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 131 101 146 94 154 95 153 112 166 118 166 122 160 125 160 130 151 135 142 129 139 129 136 123
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sitChairScr)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance pool of Feature
	(properties
		noun 17
		sightAngle 45
		approachX 69
		approachY 119
		x 54
		y 77
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 43 66 60 68 68 72 69 79 52 85 49 83 52 80 46 80 45 72 44 70 46 68
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance theWindow of Feature
	(properties
		noun 23
		sightAngle 10
		approachX 169
		approachY 86
		x 94
		y 35
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 24 0 235 0 239 10 207 21 221 44 250 38 257 58 257 78 139 81 138 76 129 71 117 70 110 73 106 76 90 79 69 86 59 94 56 91 59 91 57 89 64 86 61 83 53 86 51 82 52 80 46 79 44 71 46 68 36 60 45 56 31 54 30 52 38 37 31 25 24 23 24 14 27 14 27 6
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance pillow of Feature
	(properties
		noun 16
		sightAngle 10
		approachX 145
		approachY 91
		x 123
		y 175
		z 100
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 111 75 112 72 129 69 136 77 124 81 111 79
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if (gCast contains: theCondom)
			(theCondom doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance ladder of Feature
	(properties
		noun 13
		sightAngle 10
		approachX 59
		approachY 115
		x 19
		y 21
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:) type: PTotalAccess init: 14 15 23 12 25 25 16 28 yourself:)
		)
		(super init: &rest)
	)
)

(instance bedFx of Sound
	(properties
		flags 5
		loop -1
	)
)

(instance sfxL of Sound
	(properties
		flags 5
		loop -1
	)
)

(instance sfx of Sound
	(properties
		flags 5
	)
)

(instance onOffButton of View
	(properties
		noun 2
		sightAngle 10
		approachX 160
		approachY 89
		x 139
		y 75
		priority 75
		fixPriority 1
		view 620
		loop 5
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: pressButtonScr)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance stuff of View
	(properties
		sightAngle 10
		approachX 194
		approachY 135
		x 189
		y 8
		z -100
		priority 130
		fixPriority 1
		view 620
		loop 2
	)
)

(instance purpleCard of Feature
	(properties
		noun 4
		sightAngle 10
		approachX 192
		approachY 105
		x 192
		y 108
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 199 99 201 107 192 112 186 106
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 6) ; Zipper
				(gMessager say: 4 6) ; "The card is unintimidated by your manhood!"
			)
			((OneOf theVerb 4 1 2 5 6) ; Do, Look, Talk, Take, Zipper
				(= global207 theVerb)
				(gCurRoom setScript: (ScriptID 624 0) 0 1) ; showCardScr
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance redCard of Feature
	(properties
		noun 3
		sightAngle 10
		approachX 208
		approachY 132
		y 10
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 184 107 190 107 194 110 194 117 185 117
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 6) ; Zipper
				(gMessager say: 3 6) ; "Stop it! You're frightening the children!"
			)
			((OneOf theVerb 4 1 2 5 6) ; Do, Look, Talk, Take, Zipper
				(= global207 theVerb)
				(gCurRoom setScript: (ScriptID 624 0) 0 3) ; showCardScr
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance blueCard of Feature
	(properties
		noun 5
		sightAngle 10
		approachX 219
		approachY 132
		y 10
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 194 110 205 110 208 117 192 117
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 6) ; Zipper
				(gMessager say: 5 6) ; "La Costa Lotta doesn't provide INSTANT room service!"
			)
			((OneOf theVerb 4 1 2 5 6) ; Do, Look, Talk, Take, Zipper
				(= global207 theVerb)
				(gCurRoom setScript: (ScriptID 624 0) 0 2) ; showCardScr
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance plant1 of Feature
	(properties
		noun 22
		sightAngle 10
		x 8
		y 10
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 0 23 0 28 4 29 6 24 9 27 11 27 14 21 12 23 15 20 18 15 16 15 22 11 19 8 25 3 20 0 25
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance plant2 of Feature
	(properties
		noun 22
		sightAngle 45
		x 7
		y 140
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 0 62 11 52 29 52 45 70 45 81 52 82 50 84 53 87 60 86 55 92 66 98 62 101 68 110 63 115 64 118 65 121 61 126 61 129 56 138 0 138
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(if
			(and
				(== theVerb 2) ; Talk
				(not (-- local16))
				(DoSound sndGET_AUDIO_CAPABILITY)
				(not local15)
				(< (gEgo x:) 52)
			)
			(= local16 1)
			(gCurRoom setScript: (ScriptID 623 0) neighborCue 0) ; neighborScr
			(return 1)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance plant3 of Feature
	(properties
		noun 22
		sightAngle 10
		x 307
		y 15
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 319 0 319 76 313 65 299 68 303 59 297 59 294 63 289 60 289 46 309 33 304 24 293 30 293 22 286 24 277 13 258 13 249 7 240 10 236 0
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (and (== theVerb 4) (not (-- local6))) ; Do
			(= local6 1)
			(while (== (= temp0 (Random 1 61)) 9)
			)
			(DoAudio audPLAY 611 1 4 temp0 1)
			(= global213 gTheCursor)
			(gGame setCursor: gNormalCursor)
			(SetCursor 190 110)
			(switch
				(Print
					width: 160
					font: gUserFont
					addTitle: {Carlos, are you cheating again?}
					addText: 1 4 temp0 1 50 1 611
					addIcon: 1592 1 0 0 0
					fore: 67
					addText: {Yeah, watta ya want?} 50 17
					fore: 0
					addButton: 1 {bungee jumper} 50 25
					addButton: 2 {disposal machine} 50 40
					addButton: 3 {dumb waiter} 110 25
					addButton: 4 {ice machine} 110 40
					init:
				)
				(1
					(if (> (bungeeTimer seconds:) 3)
						(bungeeTimer seconds: 3)
					)
				)
				(2
					(if (> (disposalTimer seconds:) 3)
						(disposalTimer seconds: 3)
					)
				)
				(3
					(if (> (dumbWaiterTimer seconds:) 3)
						(dumbWaiterTimer seconds: 3)
					)
				)
				(4
					(if (> (iceMachineTimer seconds:) 3)
						(iceMachineTimer seconds: 3)
					)
				)
			)
			(gGame setCursor: global213)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance exitSouthScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gEgo
					setLoop: 4
					setMotion: MoveTo (+ (gEgo x:) 30) 210 self
				)
				(gGlobalSound1 fade: 0 10 10 1)
			)
			(2
				(= ticks 120)
			)
			(3
				(gCurRoom newRoom: 600)
			)
		)
	)
)

(instance neighborCue of cObj
	(properties)

	(method (cue)
		(= local15 0)
	)
)

(instance disposalTimer of Timer
	(properties)

	(method (cue)
		(if (not (proc79_14))
			(gCurRoom setScript: disposalScr)
		else
			(self setReal: self 60)
		)
	)
)

(instance dumbWaiterTimer of Timer
	(properties)

	(method (cue)
		(if (not (proc79_14))
			(gCurRoom setScript: dumbWaiterScr)
		else
			(self setReal: self 60)
		)
	)
)

(instance iceMachineTimer of Timer
	(properties)

	(method (cue)
		(if (not (proc79_14))
			(gCurRoom setScript: iceMachineScr)
		else
			(self setReal: self 60)
		)
	)
)

(instance bed of Prop
	(properties
		noun 1
		sightAngle 10
		approachX 108
		approachY 107
		approachDist 10
		x 58
		y 59
		priority 59
		fixPriority 1
		view 626
		signal 16417
		cycleSpeed 4
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 60 95 67 88 103 77 110 76 112 72 119 69 131 71 138 77 137 85 126 88 100 97 90 105 83 108 69 107 62 100 68 99
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: sitBedScr)
			)
			(1 ; Look
				(if cycler
					(gMessager say: 1 1 3) ; "Your bed is vibrating up and down, and back and forth. Too bad it can't do more."
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

(instance enterFrom600Scr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 249 131 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance pressButtonScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local8 0)
				(= local1 0)
				(gEgo setHeading: 270 self)
			)
			(1
				(= cycles 2)
			)
			(2
				(gEgo
					view: 901
					setLoop: 1
					cycleSpeed: 6
					cel: 0
					setCycle: CT 3 1 self
				)
			)
			(3
				(= ticks 30)
			)
			(4
				(if (bed cycler:)
					(bed setCycle: 0)
					(bedFx stop:)
					(ClearFlag 75)
					(onOffButton cel: 0)
				else
					(onOffButton cel: 1)
					(bedFx number: 621 loop: -1 play: hold: 1)
					(bed setCycle: Fwd)
					(SetFlag 75)
				)
				(= cycles 2)
			)
			(5
				(sfx number: 572 loop: 1 play:)
				(= ticks 60)
			)
			(6
				(gEgo cycleSpeed: 6 setCycle: End self)
			)
			(7
				(gEgo normalize: 900 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sitChairScr of Script
	(properties)

	(method (dispose &tmp temp0)
		(if (gKeyDownHandler size:)
			(gKeyDownHandler delete: self)
			(gMouseDownHandler delete: self)
		)
		(super dispose:)
	)

	(method (handleEvent event)
		(if
			(or
				(and (not (event modifiers:)) (& (event type:) evMOUSEBUTTON))
				(and (& (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
				(& (event type:) evVERB)
			)
			(cond
				((and (> gMouseY 13) (== (gTheIconBar curIcon:) (ScriptID 0 5))) ; icon2
					(OnMeAndLowY init:)
					(gCast eachElementDo: #perform OnMeAndLowY event)
					(gFeatures eachElementDo: #perform OnMeAndLowY event)
					(if (= register (OnMeAndLowY theObj:))
						(= local3 (event x:))
						(= local4 (event y:))
						(= cycles 2)
						(event claimed: 1)
						(return)
					)
				)
				((and (> gMouseY 13) (== (gTheIconBar curIcon:) (ScriptID 0 3))) ; icon0
					(= register 0)
					(= local3 (event x:))
					(= local4 (event y:))
					(= cycles 2)
					(event claimed: 1)
					(return)
				)
				(else
					(gTheIconBar handleEvent: (gUser curEvent:))
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(OnMeAndLowY theObj: 0)
				(= register 0)
				(Load rsVIEW 621)
				(gEgo loop: 8 cel: 4 heading: 125)
				(= cycles 2)
			)
			(1
				(gEgo
					view: 621
					setLoop: 0
					cel: 0
					x: 148
					y: 134
					cycleSpeed: 8
					setCycle: 0
				)
				(= ticks 30)
			)
			(2
				(gEgo setCycle: End self)
			)
			(3
				(SetFlag 76)
				(gKeyDownHandler add: self)
				(gMouseDownHandler add: self)
				(= global166 (ScriptID 0 5)) ; icon2
				(gGame handsOn:)
				(gUser canControl: 0)
				(gTheIconBar
					disableIcon:
						(ScriptID 0 6) ; icon3
						(ScriptID 0 4) ; icon1
						(ScriptID 0 7) ; icon4
						(ScriptID 0 9) ; icon6
					show:
				)
			)
			(4
				(gGame handsOff:)
				(gKeyDownHandler delete: self)
				(gMouseDownHandler delete: self)
				(if (== register phone)
					(= local1 0)
					(gEgo view: 621 setLoop: 1 cel: 0 setCycle: CT 3 1 self)
					(phone hide:)
				else
					(= state 6)
					(= cycles 2)
				)
			)
			(5
				(sfx number: 622 loop: 1 play:)
				(gEgo setCycle: End self)
			)
			(6
				(= next (ScriptID 622 0)) ; usePhoneScr
				(self dispose:)
			)
			(7
				(ClearFlag 76)
				(gEgo setCycle: Beg self)
			)
			(8
				(gEgo normalize: 900 4 x: 148 y: 134)
				(= ticks 10)
			)
			(9
				(UnLoad 128 621)
				(if (not register)
					(gEgo setMotion: PolyPath local3 local4 self)
				else
					(gEgo
						setMotion:
							PolyPath
							(register approachX:)
							(register approachY:)
							self
					)
				)
			)
			(10
				(= global166 (ScriptID 0 3)) ; icon0
				(gGame handsOn:)
				(UnLoad 128 621)
				(self dispose:)
				(if register
					(= global166 (ScriptID 0 5)) ; icon2
					(register doVerb: 4)
				)
			)
		)
	)
)

(instance shakeTimer of Timer
	(properties)

	(method (cue)
		(if (and (not local1) (or local8 local10))
			(= local1 1)
		else
			(= local1 0)
		)
	)
)

(instance fromIrisScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= seconds 3)
			)
			(1
				(switch gPrevRoomNum
					(380
						(gMessager say: 0 0 18 0 self) ; "After a full night of "sparkin'," a little nap feels good!"
					)
					(650
						(gMessager say: 0 0 12 1 self) ; "You awaken from an especially bad nightmare with a start..."
					)
					(else
						(gEgo put: 2 35) ; beaver
						(gMessager say: 0 0 9 0 self) ; "You are exhausted after your all-night naked bungee jumping session with Merrily!"
					)
				)
			)
			(2
				(= ticks 30)
			)
			(3
				(gEgo setLoop: 4 cel: 3)
				(= ticks 60)
			)
			(4
				(gEgo setCycle: Beg self)
			)
			(5
				(= ticks 60)
			)
			(6
				(if (== gPrevRoomNum 650)
					(gMessager sayRange: 0 0 12 2 3 self) ; "NOOOOOOOOOOOOO!"
				else
					(= cycles 2)
				)
			)
			(7
				(if (== gPrevRoomNum 650)
					(gMessager say: 0 0 12 4 self) ; "Oh, really? Then where did you get that dog collar?"
				else
					(= cycles 2)
				)
			)
			(8
				(= cycles 2)
			)
			(9
				(= cycles 2)
				(proc78_0)
			)
			(10
				(= next sitBedScr)
				(self dispose:)
			)
		)
	)
)

(instance openClosetScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 300 138 self)
			)
			(1
				(gEgo setHeading: 0 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gEgo view: 901 setLoop: 7 cel: 0 setCycle: CT 3 1 self)
			)
			(4
				(sfx number: 32 loop: 1 play:)
				(closetDoor
					view: 624
					setLoop: 0
					cel: 0
					cycleSpeed: 4
					setCycle: End self
				)
			)
			(5
				(gEgo
					normalize: 900
					setLoop: 3 1
					setMotion: MoveTo 298 127 self
				)
			)
			(6
				(gEgo setHeading: 45 self)
			)
			(7
				(= cycles 2)
			)
			(8
				(gEgo view: 901 setLoop: 2 cel: 0 setCycle: 0)
				(= cycles 2)
			)
			(9
				(gEgo setCycle: CT 3 1 self)
			)
			(10
				(gMessager say: 9 4 8 0 self) ; "Wow! Tres cool!"
			)
			(11
				(= ticks 30)
			)
			(12
				(gEgo setCycle: Beg self)
			)
			(13
				(gEgo normalize: 900 setHeading: 180 self)
			)
			(14
				(= cycles 2)
			)
			(15
				(gEgo setMotion: MoveTo 300 138 self)
			)
			(16
				(= cycles 2)
			)
			(17
				(gEgo setHeading: 360 self)
			)
			(18
				(= cycles 2)
			)
			(19
				(closetDoor setCycle: Beg self)
			)
			(20
				(sfx number: 33 loop: 1 play:)
				(= ticks 60)
			)
			(21
				(gEgo setMotion: MoveTo 284 129 self)
			)
			(22
				(gEgo setHeading: 180 self)
			)
			(23
				(= cycles 2)
			)
			(24
				(closetDoor view: 620 setLoop: 6 cel: 0)
				(gEgo normalize: 900)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterBathroomScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setHeading: 45 self)
			)
			(1
				(sfx number: 32 loop: 1 play:)
				(upperDoor
					view: 624
					setLoop: 1
					cycleSpeed: 6
					cel: 0
					setCycle: End self
				)
			)
			(2
				(gEgo setLoop: 6 setMotion: MoveTo 282 87 self)
			)
			(3
				(gEgo hide:)
				(= cycles 2)
			)
			(4
				(gCurRoom newRoom: 630)
			)
		)
	)
)

(instance disposalScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(sfx number: 624 setLoop: 1 setVol: 127 play:)
				(if (not local13)
					(= local13 1)
					(gMessager say: 18 0 4 0 self) ; "You hear the obnoxiously loud whine of a compressor emanating from somewhere below you, near the kitchen."
				else
					(= ticks 300)
				)
			)
			(1
				(gGame handsOn:)
				(sfx number: 0 stop:)
				(self dispose:)
				(disposalTimer setReal: disposalTimer (Random 100 300))
			)
		)
	)
)

(instance flashScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo loop: 8 cel: 7 heading: 310)
				(= cycles 2)
			)
			(1
				(gEgo
					view: 908
					setLoop: 1
					cel: 0
					cycleSpeed: 8
					setCycle: CT 3 1 self
				)
			)
			(2
				(sfx number: 35 loop: 1 play:)
				(gEgo setCycle: CT 6 1 self)
			)
			(3
				(if (> (bungeeTimer seconds:) 2)
					(bungeeTimer seconds: 99)
				)
				(gMessager say: 19 6 0 1 self) ; "YO! Bungee babe! Check it out!!"
			)
			(4
				(= local9 1)
				(bungeeTimer cue:)
			)
			(5
				(= ticks 30)
			)
			(6
				(= local9 0)
				(bungeeTimer cue:)
				(gMessager say: 19 6 0 2 self) ; "Hey! It's impolite to laugh!"
			)
			(7
				(gEgo normalize: 900 7)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance iceMachineScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(sfxL number: 605 loop: -1 play:)
				(if (not local11)
					(= local11 1)
					(gMessager say: 18 0 5 0 self) ; "The ice machine outside your room burps out another load of ice cubes."
				else
					(= seconds 4)
				)
			)
			(1
				(sfxL number: 0 stop:)
				(sfx number: 604 loop: 1 play: self)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
				(iceMachineTimer setReal: iceMachineTimer (Random 100 300))
			)
		)
	)
)

(instance bungeeTimer of Timer
	(properties)

	(method (cue)
		(switch (++ local7)
			(1
				(if (and (not local9) (or (< global178 10) (proc79_14)))
					(= local7 0)
					(self setReal: self 10)
				else
					(= global178 999)
					(bungeeJumper
						setLoop: 0
						ignoreActors: 1
						approachVerbs: 4 2 5 6 ; Do, Talk, Take, Zipper
						cel: 0
						setPri: 40
						init:
						show:
						setCycle: CT 4 1 self
					)
				)
			)
			(2
				(if local9
					(bungeeJumper setCycle: 0 setLoop: 1 cel: 0)
					(sfx number: 312 loop: 1 play: (gCurRoom script:))
				else
					(self cue:)
				)
			)
			(3
				(if (gCast contains: bungeeJumper)
					(if (!= (gCurRoom script:) flashScr)
						(sfx number: 235 loop: 1 play:)
					)
					(bungeeJumper setLoop: 0 cel: 4 setCycle: End self)
				else
					(self cue:)
				)
			)
			(4
				(++ local18)
				(if (gCast contains: bungeeJumper)
					(bungeeJumper dispose:)
				)
				(cond
					(
						(and
							(not (or (gTalkers size:) (Print dialog:)))
							(not (proc79_14))
							(not local17)
						)
						(gGame handsOff:)
						(if (!= (gEgo heading:) 310)
							(gEgo setHeading: 310)
						)
						(gMessager say: 19 0 0 0 self) ; "Think of all the trouble that woman went to, just for the chance to look into your room and maybe catch you undressed!"
					)
					(
						(and
							(not (or (gTalkers size:) (Print dialog:)))
							(not (proc79_14))
							(== local18 3)
						)
						(gCurRoom setScript: talk2BungeeJumper 0 0)
					)
					(
						(and
							(not (or (gTalkers size:) (Print dialog:)))
							(not (proc79_14))
							(== local18 5)
						)
						(gCurRoom setScript: talk2BungeeJumper 0 1)
					)
					(else
						(= local7 0)
						(= global178 (Random 30 120))
						(self setReal: self (Random 60 120))
					)
				)
				(= local17 1)
			)
			(5
				(= local7 0)
				(= global178 (Random 30 120))
				(self setReal: self (Random 30 90))
				(gGame handsOn:)
			)
		)
	)
)

(instance talk2BungeeJumper of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (or (!= (gEgo x:) 122) (!= (gEgo y:) 101))
					(gEgo setMotion: PolyPath 122 101 self)
				else
					(self cue:)
				)
			)
			(1
				(if (!= (gEgo heading:) 310)
					(gEgo setHeading: 310 self)
				else
					(self cue:)
				)
			)
			(2
				(= cycles 2)
			)
			(3
				(if (not register)
					(gMessager say: 19 2 0 1 self) ; "HEY! You out there! Stop checking me out!"
				else
					(gMessager say: 19 2 0 2 self) ; "I'm a human being, not just a hunk of beefcake, here for your prurient pleasure!"
				)
			)
			(4
				(= local7 0)
				(bungeeTimer setReal: bungeeTimer (Random 30 90))
				(gEgo normalize: 900 7)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance dumbWaiterScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= register 60)
				(sfxL number: 571 loop: -1 play: setVol: register)
				(= ticks 60)
			)
			(1
				(if (not local12)
					(= local12 1)
					(gMessager say: 18 0 13 0) ; "You hear what sounds like a small elevator going past your room."
				)
				(= ticks 30)
			)
			(2
				(if (<= (+= register 2) 127)
					(-- state)
					(sfxL setVol: register)
				)
				(= cycles 2)
			)
			(3
				(= ticks 60)
			)
			(4
				(if (>= (-= register 2) 60)
					(-- state)
					(sfxL setVol: register)
				)
				(= cycles 2)
			)
			(5
				(gGame handsOn:)
				(sfxL number: 0 stop:)
				(dumbWaiterTimer setReal: dumbWaiterTimer (Random 100 300))
				(self dispose:)
			)
		)
	)
)

(instance sitBedScr of Script
	(properties)

	(method (dispose &tmp temp0)
		(if (gKeyDownHandler size:)
			(gKeyDownHandler delete: self)
			(gMouseDownHandler delete: self)
		)
		(super dispose:)
	)

	(method (handleEvent event)
		(if
			(or
				(and (not (event modifiers:)) (& (event type:) evMOUSEBUTTON))
				(and (& (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
				(& (event type:) evVERB)
			)
			(cond
				((and (> gMouseY 13) (== (gTheIconBar curIcon:) (ScriptID 0 5))) ; icon2
					(OnMeAndLowY init:)
					(gCast eachElementDo: #perform OnMeAndLowY event)
					(gFeatures eachElementDo: #perform OnMeAndLowY event)
					(= register (OnMeAndLowY theObj:))
					(if (and register (!= register bed))
						(= local3 100)
						(= local4 126)
						(= local0 1)
						(= cycles 2)
					)
					(event claimed: 1)
					(return)
				)
				((and (> gMouseY 13) (== (gTheIconBar curIcon:) (ScriptID 0 3))) ; icon0
					(= local3 (event x:))
					(= local4 (event y:))
					(= local0 1)
					(= cycles 2)
					(event claimed: 1)
					(return)
				)
				(else
					(gTheIconBar handleEvent: (gUser curEvent:))
				)
			)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if
					(and
						(not local14)
						(OneOf gPrevRoomNum 270 260 280 650 380)
					)
					(= local14 1)
					(= state 5)
					(= cycles 2)
				else
					(gEgo setMotion: MoveTo 103 106 self)
				)
			)
			(1
				(gEgo setHeading: 180 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gEgo view: 622 setLoop: 2 cel: 0 setCycle: 0 x: 103 y: 106)
				(= ticks 30)
			)
			(4
				(gEgo cycleSpeed: 6 setCycle: End self)
			)
			(5
				(= local8 1)
				(if (bed cycler:)
					(gMessager say: 1 4 3) ; "I-i-it s-s-sure f-f-feels s-s-shaky!"
				)
				(shakeTimer setReal: shakeTimer 5)
				(= cycles 2)
			)
			(6
				(= register 0)
				(OnMeAndLowY theObj: 0)
				(gKeyDownHandler add: self)
				(gMouseDownHandler add: self)
				(if (OneOf gPrevRoomNum 380 650)
					(= global166 (ScriptID 0 3)) ; icon0
				else
					(= global166 (ScriptID 0 5)) ; icon2
				)
				(gGame handsOn:)
				(gUser canControl: 0)
				(gTheIconBar
					disableIcon:
						(ScriptID 0 6) ; icon3
						(ScriptID 0 4) ; icon1
						(ScriptID 0 7) ; icon4
						(ScriptID 0 9) ; icon6
					show:
				)
			)
			(7
				(gKeyDownHandler delete: self)
				(gMouseDownHandler delete: self)
				(gGame handsOff:)
				(cond
					((and local0 local10)
						(gEgo
							view: 622
							setLoop: 4
							cel: 3
							x: 103
							y: 106
							setCycle: Beg self
						)
						(= local0 0)
						(= local10 0)
						(= local8 1)
					)
					((and local10 (== register bed))
						(= state 5)
						(gEgo
							view: 622
							setLoop: 4
							cel: 3
							x: 103
							y: 106
							setCycle: Beg self
						)
						(= local10 0)
						(= local8 1)
					)
					((and (not local10) (== register bed))
						(gEgo
							view: 622
							setLoop: 4
							cel: 0
							cycleSpeed: 8
							x: 103
							y: 106
							setCycle: CT 3 1 self
						)
						(= local10 1)
						(= local8 0)
					)
					(else
						(= cycles 2)
						(= local8 0)
					)
				)
			)
			(8
				(cond
					((and local10 (IsFlag 75))
						(gEgo
							view: 622
							setLoop: 6
							setCycle: Fwd
							x: 89
							y: 95
							cycleSpeed: 4
						)
						(= state 5)
						(= cycles 2)
					)
					((not local10)
						(= cycles 2)
					)
					(else
						(= state 5)
						(= cycles 2)
					)
				)
			)
			(9
				(gEgo
					view: 622
					setLoop: 2
					cel: 9
					cycleSpeed: 6
					x: 103
					y: 106
					setCycle: Beg self
				)
			)
			(10
				(shakeTimer setReal: shakeTimer 6)
				(gEgo
					normalize: 900 4
					setMotion: MoveTo (bed approachX:) (bed approachY:) self
				)
			)
			(11
				(UnLoad 128 622)
				(= local8 0)
				(if (not register)
					(gEgo setMotion: PolyPath local3 local4 self)
				else
					(gEgo
						setMotion:
							PolyPath
							(register approachX:)
							(register approachY:)
							self
					)
				)
			)
			(12
				(= global166 (ScriptID 0 3)) ; icon0
				(gGame handsOn:)
				(UnLoad 128 622)
				(self dispose:)
				(cond
					((== register phone)
						(= local1 0)
						(= global166 (ScriptID 0 5)) ; icon2
						(register doVerb: 4)
					)
					(register
						(= global166 (ScriptID 0 5)) ; icon2
						(register doVerb: 4)
					)
				)
			)
		)
	)
)

(instance handOnCondomScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (!= (gEgo heading:) 270)
					(gEgo setHeading: 270 self)
				else
					(= cycles 2)
				)
			)
			(1
				(= cycles 2)
			)
			(2
				(gEgo setMotion: MoveTo 140 94 self)
			)
			(3
				(gEgo view: 901 setLoop: 1 cel: 0 setCycle: CT 3 1 self)
			)
			(4
				(gEgo get: 8) ; condom
				(gGame changeScore: 4 241)
				(theCondom dispose:)
				(= ticks 60)
			)
			(5
				(gEgo setCycle: End self)
			)
			(6
				(gEgo normalize: 900 1)
				(= cycles 2)
			)
			(7
				(if (and (not (IsFlag 24)) (== ((gInventory at: 17) owner:) 590)) ; gown
					(= register 1)
					(gMessager say: 10 5 6 1 self) ; "(Hey, look! It's getting dark outside! I wonder if that cutie Shablee will really be waiting for me down by the beach like she said!)"
				else
					(= register 0)
					(gMessager say: 10 5 0 0 self) ; "You grab the condom from your pillow."
				)
			)
			(8
				(if (not register)
					(gGame handsOn:)
					(self dispose:)
				else
					(gGame hideControls: setCursor: gWaitCursor 1)
					(gCurRoom drawPic: -1)
					(gCast eachElementDo: #hide)
					(= ticks 30)
				)
			)
			(9
				(Print
					font: gUserFont
					addText: 10 5 6 2 5 1 620 ; "Later That Evening..."
					modeless: 2
					init:
				)
				(= ticks 300)
			)
			(10
				(if (Print dialog:)
					((Print dialog:) dispose:)
				)
				(Print modeless: 0)
				(SetFlag 24)
				(= cycles 2)
			)
			(11
				(gCurRoom newRoom: 860)
			)
		)
	)
)

