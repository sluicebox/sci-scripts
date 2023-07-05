;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 620)
(include sci.sh)
(use Main)
(use n078)
(use n079)
(use LarryRoom)
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
	sfx 2
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
)

(class cObj of Obj
	(properties)
)

(instance rm620 of LarryRoom
	(properties
		noun 7
		picture 620
		style 15
		horizon 0
		autoLoad 0
	)

	(method (init)
		(if (== global100 2)
			(= local5 5)
		)
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
		(closetDoor init: approachVerbs: 4 2 5 6 stopUpd:) ; Do, Talk, Take, Zipper
		(upperDoor init: approachVerbs: 4 2 5 6 stopUpd:) ; Do, Talk, Take, Zipper
		(cond
			((== gPrevRoomNum 630)
				(upperDoor view: 624 setLoop: 1 cel: 10 forceUpd:)
				(gEgo init: normalize: 900 posn: 281 86 setLoop: 8 cel: 5)
				(plumberTrigger init:)
				(self setScript: enterFromBathroomScr)
			)
			((OneOf gPrevRoomNum 380 280 650 270 260)
				(= style 7)
				(gEgo show: init: view: 622 setLoop: 5 cel: 0 x: 103 y: 106)
				(ClearFlag 75)
				(ClearFlag 74)
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
		(super init: &rest)
		(bed init: approachVerbs: 4 2 5 6 stopUpd:) ; Do, Talk, Take, Zipper
		(if (IsFlag 75)
			(bedFx number: 621 loop: -1 play: hold: 1)
			(bed setCycle: Fwd)
		)
		(if (and (IsFlag 240) (IsFlag 68))
			(pillow init: approachVerbs: 4 2 5 6 noun: 21) ; Do, Talk, Take, Zipper
			(bed loop: 1 noun: 21)
			(if (not (IsFlag 241))
				(theCondom init: approachVerbs: 4 2 5 6) ; Do, Talk, Take, Zipper
			)
		else
			(pillow init: approachVerbs: 4 2 5 6) ; Do, Talk, Take, Zipper
		)
		(onOffButton init: approachVerbs: 4 2 5 6 stopUpd:) ; Do, Talk, Take, Zipper
		(phone init: approachVerbs: 4 2 5 6 stopUpd:) ; Do, Talk, Take, Zipper
		(theFlowers init: approachVerbs: 4 2 5 6 stopUpd:) ; Do, Talk, Take, Zipper
		(if (IsFlag 239)
			(theFlowers noun: 24 cel: 1 forceUpd:)
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
		(stuff init: approachVerbs: 4 2 5 6 stopUpd:) ; Do, Talk, Take, Zipper
		(plant1 init:)
		(plant2 init:)
		(plant3 init:)
		(vase init: approachVerbs: 4 2 5 6) ; Do, Talk, Take, Zipper
	)

	(method (doit &tmp [temp0 30])
		(if (or (and local7 (IsFlag 75)) (and (== local1 1) (IsFlag 75)))
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
			(
				(and
					(IsFlag 54)
					(AvoidPath (gEgo x:) (gEgo y:) plumberTrigger)
				)
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

	(method (newRoom newRoomNumber)
		(plumberTrigger dispose:)
		(DisposeScript 610)
		(bungeeTimer dispose: delete:)
		(disposalTimer dispose: delete:)
		(iceMachineTimer dispose: delete:)
		(dumbWaiterTimer dispose: delete:)
		(shakeTimer dispose: delete:)
		(super newRoom: newRoomNumber)
	)

	(method (cue)
		(gGlobalSound1 number: 620 loop: -1 play: 127 setPri: 50)
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
				(theFlowers noun: 24 cel: 1 forceUpd:)
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
				(= ticks 30)
			)
			(3
				(gEgo setHeading: 45 self)
			)
			(4
				(= cycles 2)
			)
			(5
				(upperDoor setCycle: Beg self)
			)
			(6
				(sfx number: 33 loop: 1 play:)
				(gEgo setHeading: 180 self)
			)
			(7
				(= cycles 2)
			)
			(8
				(upperDoor view: 620 setLoop: 0 cel: 0 stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance bungeeJumper of Prop
	(properties
		x 81
		y 46
		z 50
		noun 19
		sightAngle 10
		approachX 122
		approachY 101
		view 625
		priority 1
		signal 26640
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
		x 265
		y 83
		noun 11
		sightAngle 45
		approachX 255
		approachY 87
		view 620
		priority 2
		signal 18448
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
			setOnMeCheck:
				2
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
		x 203
		y 110
		noun 12
		sightAngle 10
		approachX 203
		approachY 100
		view 620
		loop 4
		priority 9
		signal 22544
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 194 96 198 91 207 92 197 84 206 80 211 89 215 73 221 76 222 82 215 93 226 90 233 101 228 103 219 98 217 103 215 118 206 117 208 99 202 98 197 101
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Take
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
		x 292
		y 109
		noun 9
		sightAngle 45
		approachX 302
		approachY 135
		view 620
		loop 6
		priority 6
		signal 18448
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
			setOnMeCheck:
				2
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
		x 121
		y 76
		noun 10
		sightAngle 10
		approachX 140
		approachY 94
		view 620
		loop 3
		priority 3
		signal 18448
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
		x 173
		y 116
		noun 15
		sightAngle 10
		approachX 159
		approachY 133
		view 620
		loop 1
		priority 9
		signal 18448
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
			setOnMeCheck:
				2
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
		y 10
		noun 24
		approachX 203
		approachY 100
	)

	(method (init)
		(self
			setOnMeCheck:
				2
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
		x 245
		y 27
		sightAngle 10
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 274 12 310 24 308 33 297 40 274 32 221 45 210 20 251 7
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if (not (-- local5))
					(SetFlag 34)
					(SetFlag 19)
					(gGame changeScore: 8 244)
					(SetFlag 52)
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

(instance table of Feature
	(properties
		y 1
		noun 20
		sightAngle 10
		approachX 207
		approachY 132
	)

	(method (init)
		(self
			setOnMeCheck:
				2
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
		y 1
		noun 8
		sightAngle 10
		approachX 159
		approachY 133
	)

	(method (init)
		(self
			setOnMeCheck:
				2
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
		x 54
		y 77
		noun 17
		sightAngle 45
		approachX 69
		approachY 119
	)

	(method (init)
		(self
			setOnMeCheck:
				2
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
		x 94
		y 35
		noun 23
		sightAngle 10
		approachX 169
		approachY 86
	)

	(method (init)
		(self
			setOnMeCheck:
				2
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
		x 123
		y 175
		z 100
		noun 16
		sightAngle 10
		approachX 145
		approachY 91
	)

	(method (init)
		(self
			setOnMeCheck:
				2
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
		x 19
		y 21
		noun 13
		sightAngle 10
		approachX 59
		approachY 115
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:) type: PTotalAccess init: 14 15 23 12 25 25 16 28 yourself:)
		)
		(super init: &rest)
	)
)

(instance bedFx of Sound
	(properties
		flags 1
		loop -1
	)
)

(instance sfx of Sound
	(properties
		flags 1
	)
)

(instance sfxL of Sound
	(properties
		flags 1
		loop -1
	)
)

(instance onOffButton of View
	(properties
		x 139
		y 66
		noun 2
		sightAngle 10
		approachX 160
		approachY 89
		view 620
		loop 5
		priority 3
		signal 18448
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
		x 189
		y 8
		z -100
		sightAngle 10
		approachX 194
		approachY 135
		view 620
		loop 2
		priority 8
		signal 18448
	)
)

(instance purpleCard of Feature
	(properties
		x 192
		y 108
		noun 4
		sightAngle 10
		approachX 192
		approachY 105
	)

	(method (init)
		(self
			setOnMeCheck:
				2
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
				(= global189 theVerb)
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
		y 10
		noun 3
		sightAngle 10
		approachX 208
		approachY 132
	)

	(method (init)
		(self
			setOnMeCheck:
				2
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
				(= global189 theVerb)
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
		y 10
		noun 5
		sightAngle 10
		approachX 219
		approachY 132
	)

	(method (init)
		(self
			setOnMeCheck:
				2
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
				(= global189 theVerb)
				(gCurRoom setScript: (ScriptID 624 0) 0 2) ; showCardScr
			)
			(else
				(super doVerb: theVerb)
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
				(= local8 1)
				(bungeeTimer cue:)
			)
			(5
				(= ticks 30)
			)
			(6
				(= local8 0)
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

(instance plant1 of Feature
	(properties
		x 8
		y 10
		noun 22
		sightAngle 10
	)

	(method (init)
		(self
			setOnMeCheck:
				2
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
		x 7
		y 130
		noun 22
		sightAngle 45
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 0 62 11 52 29 52 45 70 45 81 52 82 50 84 53 87 60 86 55 92 66 98 62 101 68 110 63 115 64 118 65 121 61 126 61 129 56 138 0 138
					yourself:
				)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(if
					(and
						(DoSound sndGET_AUDIO_CAPABILITY)
						(not (gCurRoom script:))
						(not (gEgo mover:))
						(not local14)
						(< (gEgo x:) 52)
					)
					(gCurRoom setScript: (ScriptID 623 0) neighborCue 0) ; neighborScr
					(return 1)
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

(instance plant3 of Feature
	(properties
		x 307
		y 15
		noun 22
		sightAngle 10
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 319 0 319 76 313 65 299 68 303 59 297 59 294 63 289 60 289 46 309 33 304 24 293 30 293 22 286 24 277 13 258 13 249 7 240 10 236 0
					yourself:
				)
		)
		(super init: &rest)
	)
)

(instance enterBathroomScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 901
					setLoop: 0
					cel: 0
					cycleSpeed: 8
					setCycle: CT 3 1 self
				)
			)
			(1
				(gEgo setCycle: End self)
			)
			(2
				(= ticks 30)
			)
			(3
				(gEgo normalize: 900 0 setMotion: MoveTo 264 95 self)
			)
			(4
				(gEgo setHeading: 45 self)
			)
			(5
				(sfx number: 32 loop: 1 play:)
				(upperDoor
					view: 624
					setLoop: 1
					cycleSpeed: 6
					cel: 0
					setCycle: End self
				)
			)
			(6
				(gEgo setLoop: 6 setMotion: MoveTo 282 87 self)
			)
			(7
				(gEgo hide:)
				(= cycles 2)
			)
			(8
				(gCurRoom newRoom: 630)
			)
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
				(gGlobalSound1 fade: 0 10 10 1 self)
			)
			(2)
			(3
				(gCurRoom newRoom: 600)
			)
		)
	)
)

(instance neighborCue of cObj
	(properties)

	(method (cue)
		(= local14 0)
	)
)

(instance disposalTimer of Timer
	(properties)

	(method (cue)
		(if (and (not gModelessDialog) (not (gEgo mover:)) (not (gCurRoom script:)))
			(gCurRoom setScript: disposalScr)
		else
			(self setReal: self 60)
		)
	)
)

(instance dumbWaiterTimer of Timer
	(properties)

	(method (cue)
		(if (and (not gModelessDialog) (not (gEgo mover:)) (not (gCurRoom script:)))
			(gCurRoom setScript: dumbWaiterScr)
		else
			(self setReal: self 60)
		)
	)
)

(instance iceMachineTimer of Timer
	(properties)

	(method (cue)
		(if (and (not gModelessDialog) (not (gEgo mover:)) (not (gCurRoom script:)))
			(gCurRoom setScript: iceMachineScr)
		else
			(self setReal: self 60)
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
				(= seconds 4)
			)
			(1
				(sfxL number: 0 stop:)
				(sfx number: 604 loop: 1 play: self)
			)
			(2
				(if (not local10)
					(= local10 1)
					(gMessager say: 18 0 5 0 self) ; "The ice machine outside your room burps out another load of ice cubes."
				else
					(= cycles 2)
				)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
				(iceMachineTimer setReal: iceMachineTimer (Random 100 300))
			)
		)
	)
)

(instance bed of Prop
	(properties
		x 52
		y 110
		noun 1
		sightAngle 10
		approachX 108
		approachY 107
		approachDist 10
		view 626
		priority 2
		signal 18448
		cycleSpeed 4
	)

	(method (init)
		(self
			setOnMeCheck:
				2
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

(instance openClosetScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 302 135 self)
			)
			(1
				(gEgo view: 901 setLoop: 7 cel: 0 setCycle: CT 3 1 self)
			)
			(2
				(sfx number: 32 loop: 1 play:)
				(closetDoor
					view: 624
					setLoop: 0
					cel: 0
					cycleSpeed: 4
					setCycle: End self
				)
			)
			(3
				(gEgo normalize: 900 3 setMotion: MoveTo 297 126 self)
				(= cycles 2)
			)
			(4
				(gEgo setHeading: 45 self)
			)
			(5
				(= cycles 2)
			)
			(6
				(gEgo view: 901 setLoop: 2 cel: 0 setCycle: 0)
				(= cycles 2)
			)
			(7
				(gEgo setCycle: CT 3 1 self)
			)
			(8
				(gMessager say: 9 4 8 0 self) ; "Wow! Tres cool!"
			)
			(9
				(= ticks 30)
			)
			(10
				(gEgo setCycle: Beg self)
			)
			(11
				(gEgo normalize: 900 setHeading: 225 self)
			)
			(12
				(= cycles 2)
			)
			(13
				(gEgo
					setMotion:
						MoveTo
						(closetDoor approachX:)
						(closetDoor approachY:)
						self
				)
			)
			(14
				(gEgo setHeading: 360 self)
			)
			(15
				(= cycles 2)
			)
			(16
				(closetDoor setCycle: Beg self)
			)
			(17
				(sfx number: 33 loop: 1 play:)
				(= ticks 30)
			)
			(18
				(gEgo setMotion: MoveTo 284 129 self)
			)
			(19
				(gEgo setHeading: 180 self)
			)
			(20
				(= cycles 2)
			)
			(21
				(closetDoor view: 620 setLoop: 6 cel: 0 stopUpd:)
				(gEgo normalize: 900)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance bungeeTimer of Timer
	(properties)

	(method (cue)
		(switch (++ local6)
			(1
				(if (and (not local8) (gCurRoom script:))
					(self setReal: self 30)
				else
					(bungeeJumper
						init:
						show:
						approachVerbs: 4 2 5 6 ; Do, Talk, Take, Zipper
						cel: 0
						setCycle: CT 4 1 self
					)
				)
			)
			(2
				(if local8
					(bungeeJumper setCycle: 0 setLoop: 1 cel: 0)
					(sfx number: 312 loop: 1 play: (gCurRoom script:))
				else
					(self cue:)
				)
			)
			(3
				(if (gCast contains: bungeeJumper)
					(sfx number: 235 loop: 1 play:)
					(bungeeJumper setLoop: 0 cel: 4 setCycle: End self)
				else
					(self cue:)
				)
			)
			(4
				(= local6 0)
				(bungeeJumper dispose:)
				(self setReal: self (Random 60 120))
			)
		)
	)
)

(instance plumberTrigger of Polygon
	(properties)

	(method (init)
		(super
			init: 225 93 248 112 292 112 308 124 242 124 212 100 200 80 220 80
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
					(gCast eachElementDo: #dispose)
					(DrawPic 98 6)
					(= seconds 3)
				)
			)
			(9
				(SetFlag 24)
				(gMessager say: 10 5 6 2 self) ; "Later That Evening..."
			)
			(10
				(gCurRoom newRoom: 860)
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

(instance fromIrisScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(ClearFlag 75)
				(= local7 1)
				(= cycles 1)
			)
			(1
				(gEgo view: 622 setLoop: 5 cel: 0 x: 103 y: 106)
				(gNarrator x: 100 y: 25)
				(= seconds 3)
			)
			(2
				(switch gPrevRoomNum
					(380
						(gMessager say: 0 0 18 0 self) ; "After a full night of "sparkin'," a little nap feels good!"
					)
					(650
						(gMessager say: 0 0 12 1 self) ; "You awaken from an especially bad nightmare with a start..."
					)
					(else
						(gEgo put: 2 35 31) ; beaver
						(gMessager say: 0 0 9 0 self) ; "You are exhausted after your all-night naked bungee jumping session with Merrily!"
					)
				)
			)
			(3
				(= ticks 30)
			)
			(4
				(gEgo setLoop: 4 cel: 3)
				(= ticks 60)
			)
			(5
				(gEgo setCycle: Beg self)
			)
			(6
				(= ticks 60)
			)
			(7
				(if (== gPrevRoomNum 650)
					(gMessager say: 0 0 12 2 3 self) ; "NOOOOOOOOOOOOO!"
				else
					(= cycles 2)
				)
			)
			(8
				(if (== gPrevRoomNum 650)
					(gMessager say: 0 0 12 4 self) ; "Oh, really? Then where did you get that dog collar?"
				else
					(= cycles 2)
				)
			)
			(9
				(= cycles 2)
			)
			(10
				(= cycles 2)
				(proc78_0 -1 15)
			)
			(11
				(gNarrator x: -1 y: -1)
				(= next sitBedScr)
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
				(sfxL number: 571 loop: -1 play: 50)
				(= ticks 30)
			)
			(1
				(sfxL fade: 127 10 10 0 self)
			)
			(2
				(if (not local11)
					(= local11 1)
					(gMessager say: 18 0 13 0 self) ; "You hear what sounds like a small elevator going past your room."
				else
					(= ticks 60)
				)
			)
			(3
				(sfxL fade: 0 10 10 1 self)
			)
			(4
				(sfxL number: 0 stop:)
				(gGame handsOn:)
				(self dispose:)
				(dumbWaiterTimer setReal: dumbWaiterTimer (Random 100 300))
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
				(sfx number: 624 loop: 1 play:)
				(= seconds 5)
			)
			(1
				(if (not local12)
					(= local12 1)
					(gMessager say: 18 0 4 0 self) ; "You hear the obnoxiously loud whine of a compressor emanating from somewhere below you, near the kitchen."
				else
					(= cycles 2)
				)
			)
			(2
				(sfx number: 0 stop:)
				(gGame handsOn:)
				(self dispose:)
				(disposalTimer setReal: disposalTimer (Random 100 300))
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
				(= local7 0)
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
					(onOffButton cel: 0 forceUpd:)
				else
					(onOffButton cel: 1 forceUpd:)
					(bedFx number: 621 loop: -1 play: hold: 1)
					(bed setCycle: Fwd)
					(SetFlag 75)
				)
				(sfx number: 572 loop: 1 play:)
				(= ticks 30)
			)
			(5
				(gEgo cycleSpeed: 6 setCycle: End self)
			)
			(6
				(gEgo normalize: 900 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sitChairScr of Script
	(properties)

	(method (handleEvent event &tmp [temp0 21])
		(gInventory handleEvent: event)
		(cond
			((gTheIconBar handleEvent: event))
			((event claimed:)
				(return)
			)
			(
				(or
					(and (not (event modifiers:)) (& (event type:) evMOUSEBUTTON))
					(and (& (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
					(& (event type:) evVERB)
				)
				(if (== (gTheIconBar curIcon:) (ScriptID 0 5)) ; icon2
					(OnMeAndLowY init:)
					(gCast eachElementDo: #perform OnMeAndLowY event)
					(gFeatures eachElementDo: #perform OnMeAndLowY event)
					(= register (OnMeAndLowY theObj:))
				else
					(= local3 (event x:))
					(= local4 (event y:))
				)
				(= cycles 2)
				(event claimed: 1)
				(return)
			)
		)
	)

	(method (changeState newState &tmp [temp0 20])
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
					x: 159
					y: 133
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
				(gGame handsOn:)
				(gUser canControl: 0)
				(gTheIconBar
					disable:
						(ScriptID 0 6) ; icon3
						(ScriptID 0 4) ; icon1
						(ScriptID 0 7) ; icon4
						(ScriptID 0 9) ; icon6
				)
			)
			(4
				(gGame handsOff:)
				(gKeyDownHandler delete: self)
				(gMouseDownHandler delete: self)
				(if (== register phone)
					(= local1 0)
					(gEgo view: 621 setLoop: 1 cel: 0 setCycle: CT 3 1 self)
				else
					(= state 6)
					(= cycles 2)
				)
			)
			(5
				(phone cel: 1 x: 175 y: 119 forceUpd:)
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
				(gEgo normalize: 900 4)
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
				(UnLoad 128 621)
				(gGame handsOn:)
				(self dispose:)
				(if register
					(register doVerb: 4)
				)
			)
		)
	)
)

(instance shakeTimer of Timer
	(properties)

	(method (cue)
		(if (and (not local1) (or local7 local9))
			(= local1 1)
		else
			(= local1 0)
		)
	)
)

(instance sitBedScr of Script
	(properties)

	(method (handleEvent event &tmp [temp0 21])
		(gInventory handleEvent: event)
		(cond
			((gTheIconBar handleEvent: event))
			((event claimed:)
				(return)
			)
			(
				(or
					(and (not (event modifiers:)) (& (event type:) evMOUSEBUTTON))
					(and (& (event type:) evKEYBOARD) (== (event message:) KEY_RETURN))
					(& (event type:) evVERB)
				)
				(if (== (gTheIconBar curIcon:) (ScriptID 0 5)) ; icon2
					(OnMeAndLowY init:)
					(gCast eachElementDo: #perform OnMeAndLowY event)
					(gFeatures eachElementDo: #perform OnMeAndLowY event)
					(= register (OnMeAndLowY theObj:))
				else
					(= local3 (event x:))
					(= local4 (event y:))
				)
				(if
					(or
						(!= (gTheIconBar curIcon:) (ScriptID 0 5)) ; icon2
						(!= register bed)
					)
					(= local0 1)
				)
				(= cycles 2)
				(event claimed: 1)
				(return)
			)
		)
	)

	(method (changeState newState &tmp [temp0 20])
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (and (not local13) (OneOf gPrevRoomNum 650 280 380))
					(= local13 1)
					(= state 5)
					(= cycles 2)
				else
					(gEgo setMotion: MoveTo 108 106 self)
				)
			)
			(1
				(gEgo setHeading: 180 self)
			)
			(2
				(= cycles 2)
			)
			(3
				(gEgo view: 622 setLoop: 2 cel: 0 setCycle: 0)
				(= ticks 30)
			)
			(4
				(gEgo cycleSpeed: 6 setCycle: End self)
			)
			(5
				(= local7 1)
				(if (bed cycler:)
					(gNarrator modeless: 1 x: 150 y: 20)
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
				(gGame handsOn:)
				(gUser canControl: 0)
				(gTheIconBar
					disable:
						(ScriptID 0 6) ; icon3
						(ScriptID 0 4) ; icon1
						(ScriptID 0 7) ; icon4
						(ScriptID 0 9) ; icon6
				)
			)
			(7
				(gKeyDownHandler delete: self)
				(gMouseDownHandler delete: self)
				(gGame handsOff:)
				(cond
					((and local0 local9)
						(gEgo
							view: 622
							setLoop: 4
							cel: 3
							x: 108
							y: 106
							setCycle: Beg self
						)
						(= local0 0)
						(= local9 0)
						(= local7 1)
					)
					((and local9 (== register bed))
						(= state 5)
						(gEgo
							view: 622
							setLoop: 4
							cel: 3
							x: 108
							y: 106
							setCycle: Beg self
						)
						(= local9 0)
						(= local7 1)
					)
					((and (not local9) (== register bed))
						(gEgo
							view: 622
							setLoop: 4
							cel: 0
							cycleSpeed: 8
							x: 108
							y: 106
							setCycle: CT 3 1 self
						)
						(= local9 1)
						(= local7 0)
					)
					(else
						(= cycles 2)
						(= local7 0)
					)
				)
			)
			(8
				(cond
					((and local9 (IsFlag 75))
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
					((not local9)
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
					x: 108
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
				(= local7 0)
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
				(gNarrator x: -1 y: -1)
				(= global166 (ScriptID 0 3)) ; icon0
				(UnLoad 128 622)
				(gGame handsOn:)
				(self dispose:)
				(cond
					((== register phone)
						(= local1 0)
						(register doVerb: 4)
					)
					(register
						(register doVerb: 4)
					)
				)
			)
		)
	)
)

