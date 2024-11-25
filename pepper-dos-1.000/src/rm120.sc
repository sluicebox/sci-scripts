;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 120)
(include sci.sh)
(use Main)
(use CycleBet)
(use BalloonTalker)
(use invCode)
(use ADRoom)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Rev)
(use Timer)
(use Motion)
(use Actor)
(use System)

(public
	rm120 0
	specialTalker 1
	proc120_2 2
	flowerBed 3
	softGum 4
	obrienTalker 15
)

(local
	local0
	local1
	local2
	[local3 2] = [0 1]
	local5
	local6 = 1
	local7
	[local8 8]
	[local16 8] = [10 10 20 10 20 20 10 20]
	local24
	local25
	local26
	local27
	[local28 5] = [0 17 18 19 20]
	local33
	local34
	[local35 9] = [163 154 3 3 86 0 0 120 0]
)

(procedure (proc120_2 &tmp temp0 temp1 temp2 temp3)
	(= temp0 (+ ((ScriptID 895 1) x:) 23)) ; lockjaw
	(= temp1 (- ((ScriptID 895 1) x:) 23)) ; lockjaw
	(= temp2 (- ((ScriptID 895 1) y:) 11)) ; lockjaw
	(= temp3 (+ ((ScriptID 895 1) y:) 7)) ; lockjaw
	(= [local8 0] temp0)
	(= [local8 1] temp2)
	(= [local8 2] temp0)
	(= [local8 3] temp3)
	(= [local8 4] temp1)
	(= [local8 5] temp3)
	(= [local8 6] temp1)
	(= [local8 7] temp2)
	(if (not argc)
		(lockjawPoly points: @local8 size: 4)
	else
		(lockjawPoly points: @local16 size: 4)
	)
)

(instance rm120 of ADRoom
	(properties
		noun 22
		picture 120
		north 135
		vanishingY 20
	)

	(method (init)
		(super init: &rest)
		(LoadMany rsVIEW 121 132 807 122)
		(gInventory
			addAfter:
				(gInventory at: 44) ; Wood_Cutting_c
				(Hard_Gum init: yourself:)
				(Soft_Gum init: yourself:)
				(Drain_Pipe init: yourself:)
		)
		(if (IsFlag 4)
			(pipeFeature noun: 5)
			(SetFlag 3)
			(drainPipe
				init:
				cel: 3
				x: 88
				y: 67
				setPri: 5
				noun: 5
				approachX: 64
				approachY: 117
				approachVerbs: 85 7 6 86 30 89 ; Talk, Do, Look, Nose, Paw, Teeth
				addToPic:
			)
		else
			(drainPipe init: approachVerbs: 85 7 6 86 30 89 10 stopUpd:) ; Talk, Do, Look, Nose, Paw, Teeth, Soft_Gum
		)
		(if (IsFlag 6)
			(SetFlag 54)
			(if (not (IsFlag 4))
				(gEgo get: 46)
			)
		else
			(hardGum init:)
		)
		(mrsOWindow init: approachVerbs: 85 7 6 86 30 89) ; Talk, Do, Look, Nose, Paw, Teeth
		(house init:)
		(pipeFeature init: approachVerbs: 7 6 103) ; Do, Look, Drain_Pipe
		(porch init: setOnMeCheck: 1 8192)
		(flowerBed init: approachVerbs: 7 6 86 30 setOnMeCheck: 1 256) ; Do, Look, Nose, Paw
		(lockJawHouse init: approachVerbs: 85 7 6 86 30 89 setOnMeCheck: 1 8) ; Talk, Do, Look, Nose, Paw, Teeth
		(appleTree init: approachVerbs: 85 7 6 86 30 89 setOnMeCheck: 1 2) ; Talk, Do, Look, Nose, Paw, Teeth
		(obrienHouse init: approachVerbs: 7 6) ; Do, Look
		(waterSpicket init: approachVerbs: 7 6 86) ; Do, Look, Nose
		(waterDish init: approachVerbs: 85 7 6 86 30 89 10 9) ; Talk, Do, Look, Nose, Paw, Teeth, Soft_Gum, Hard_Gum
		(fence init: approachVerbs: 7 6 30 89 86 85 setOnMeCheck: 1 128) ; Do, Look, Paw, Teeth, Nose, Talk
		(sideWalk init: approachVerbs: 85 7 6 86 30 89 setOnMeCheck: 1 1024) ; Talk, Do, Look, Nose, Paw, Teeth
		(pepperWindow init: approachVerbs: 85 7 6 86 30 89 setOnMeCheck: 2048) ; Talk, Do, Look, Nose, Paw, Teeth
		(foliage init: setOnMeCheck: 1 256 approachVerbs: 85 7 6 86 30 89) ; Talk, Do, Look, Nose, Paw, Teeth
		(door init: approachVerbs: 7 6 30 86 85) ; Do, Look, Paw, Nose, Talk
		(gLongSong number: 120 flags: 1 setLoop: 1 play: self)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 122 125 155 125 181 141 181 150 139 160 111 160 85 153 85 142
					yourself:
				)
				((Polygon new:)
					type: PContainedAccess
					init: 319 189 319 163 263 163 263 151 319 151 319 132 249 132 249 99 203 99 196 103 196 132 181 132 181 139 154 123 115 123 115 126 64 126 64 117 44 110 0 115 0 189
					yourself:
				)
		)
		(bird init: setScript: sBird approachVerbs: 7 6 85) ; Do, Look, Talk
		(self setScript: initScr)
		(gNarrator y: 25 x: 20)
	)

	(method (cue)
		(gLongSong number: 121 setLoop: -1 play:)
	)

	(method (dispose)
		(gInventory delete: Hard_Gum delete: Soft_Gum delete: Drain_Pipe)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(gNarrator x: -1 y: -1)
		(obrienTimer dispose: delete:)
		(birdTimer dispose: delete:)
		(gLongSong fade:)
		(super newRoom: newRoomNumber)
	)

	(method (doit &tmp temp0)
		(cond
			(script)
			(
				(and
					(not (IsFlag 54))
					(InRect
						212
						139
						222
						151
						((ScriptID 895 0) x:) ; pepper
						((ScriptID 895 0) y:) ; pepper
					)
				)
				(gCurRoom setScript: gumWalkScr 0 0)
			)
		)
		(if (== (gLongSong number:) 121)
			(cond
				(
					(and
						(not local1)
						(== ((ScriptID 895 0) view:) 800) ; pepper
						(== ((ScriptID 895 0) loop:) 8) ; pepper
					)
					(gLongSong send: 5 78 1)
					(= local1 1)
				)
				(
					(and
						local1
						(== ((ScriptID 895 0) view:) 800) ; pepper
						(!= ((ScriptID 895 0) loop:) 8) ; pepper
					)
					(gLongSong send: 5 78 0)
					(= local1 0)
				)
				(
					(and
						(not local2)
						(== ((ScriptID 895 1) view:) 807) ; lockjaw
						(== ((ScriptID 895 1) loop:) 8) ; lockjaw
					)
					(gLongSong send: 4 78 1)
					(= local2 1)
				)
				(
					(and
						local2
						(== ((ScriptID 895 1) view:) 807) ; lockjaw
						(!= ((ScriptID 895 1) loop:) 8) ; lockjaw
					)
					(gLongSong send: 4 78 0)
					(= local2 0)
				)
			)
		)
		(super doit: &rest)
	)
)

(instance lockjawDoVerb of Actions
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(9 ; Hard_Gum
				(gEgo put: 45 gCurRoomNum)
				(gCurRoom setScript: (ScriptID 121 3)) ; lockjawChewGumScr
				(= local0 2)
			)
			(17 ; Dog_Harness
				(gGame points: 200 1)
				(gCurRoom setScript: sFinalClimb)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pepperDoVerb of Actions
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(9 ; Hard_Gum
				(gMessager say: 18 9) ; "There is NO WAY I'm chewing that! Yech!"
			)
			(10 ; Soft_Gum
				(gMessager say: 18 10) ; "Gross! That would stick to me!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance egg of View
	(properties
		view 127
		loop 4
		priority 14
		signal 26640
	)

	(method (doVerb theVerb)
		(if (== theVerb 6) ; Look
			(gMessager say: 2 6 4 2) ; "YIKES! That's the biggest Easter egg I ever saw!"
		else
			(bird doVerb: theVerb)
		)
	)
)

(instance bird of Prop
	(properties
		x 262
		y 161
		z 100
		noun 2
		approachX 260
		approachY 170
		view 127
		loop 2
		priority 14
		signal 26640
	)

	(method (cue)
		(super cue: &rest)
		(if (!= local26 2)
			(self setScript: sBird)
			(= local26 0)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(++ local25)
				(cond
					((== local26 1)
						(gMessager say: 2 6 4 1) ; "The bluejay is really upset! What could be the problem?"
					)
					((> local25 3)
						(gMessager say: 2 6 1 1) ; "The poor bluejay looks exhausted."
					)
					((== local25 3)
						(self setScript: sLayEgg)
					)
					((== local25 2)
						(gMessager say: 2 6 3 1) ; "The bluejay seems to be getting ready for something..."
					)
					(else
						(gMessager say: 2 6 2 1) ; "A sassy bluejay is sitting in her nest in the apple tree."
					)
				)
			)
			(7 ; Do
				(if (== local26 2)
					(gMessager say: 2 7 1) ; "The egg is pretty awesome, but Pepper wouldn't want to upset the bluejay by taking it."
				else
					(gMessager say: 2 7 2) ; "Pepper could never catch the bluejay. She'd fly away if Pepper tried."
				)
			)
			(86 ; Nose
				(gMessager say: 2 86) ; "The bird is too far away to smell, but Lockjaw bets it smells GOOD!"
			)
			(30 ; Paw
				(gMessager say: 2 30) ; "Lockjaw would love to, uh, visit with the bluejay, but he just isn't that good at climbing trees."
			)
			(85 ; Talk
				(if (== local26 2)
					(specialTalker x: 100 y: 45 tailPosn: 4)
					(gMessager say: 2 85 2) ; "Hiya, bird."
				else
					(specialTalker x: 107 y: 66 tailPosn: 4)
					(gMessager say: 2 85 1) ; "Hi there, bird woman."
				)
			)
			(89 ; Teeth
				(if (== local26 2)
					(gMessager say: 2 89 1) ; "That egg looks delicious, but Lockjaw has no way to get it. Bummer!"
				else
					(gMessager say: 2 89 2) ; "Lockjaw is sure that the bluejay would make a lovely snack, but he just can't reach her."
				)
			)
			(9 ; Hard_Gum
				(gMessager say: 2 9) ; "The bird doesn't like chewing gum. It sticks to her beak."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance hardGum of Prop
	(properties
		x 215
		y 145
		noun 9
		approachX 217
		approachY 141
		_approachVerbs 33
		view 120
		cel 1
	)

	(method (init)
		(gumFeature init:)
		(super init: &rest)
		(self stopUpd:)
	)

	(method (cue)
		(gEgo get: 45)
	)

	(method (dispose)
		(gumFeature dispose:)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(gMessager say: 9 6 15) ; "There's a nasty old chewed-up piece of gum on the sidewalk."
			)
			(7 ; Do
				(gCurRoom setScript: gumWalkScr self 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance softGum of View
	(properties
		x 215
		y 145
		noun 24
		approachX 255
		approachY 150
		view 120
		cel 1
		signal 26640
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(gMessager say: 24 6 15) ; "Well, THAT looks appetizing!"
			)
			(7 ; Do
				(cond
					((== local0 3)
						(pipeFeature doVerb: 7)
					)
					((== local0 5)
						(drainPipe doVerb: 7)
					)
					(else
						(gCurRoom setScript: sGetGum)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance drainPipe of Prop
	(properties
		x 97
		y 119
		noun 21
		approachX 96
		approachY 125
		view 120
		cel 2
		signal 26640
	)

	(method (cue)
		(gGame handsOn:)
		((ScriptID 895 1) normal: 1 startUpd:) ; lockjaw
		((ScriptID 895 0) startUpd:) ; pepper
		(super cue: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(gGame points: 443 1)
				(cond
					((not (IsFlag 4))
						(gCurRoom setScript: sGetPipe)
					)
					((and (not (gCast contains: hole)) (not (gEgo has: 0))) ; Dog_Harness
						(gGame points: 204 1)
						(gCurRoom setScript: (ScriptID 121 4)) ; climbPipeScr
					)
					(else
						(gMessager say: 5 7 5) ; "WHIIIIINE!"
					)
				)
			)
			(10 ; Soft_Gum
				(if (& (gInventory state:) $0020)
					(gInventory curIcon: Drain_Pipe)
					(Drain_Pipe noun: 20 cel: 2)
					((ScriptID 894 2) init:) ; inventoryCursor
					(gInventory hide:)
					(= local0 4)
				else
					(softGum
						init:
						approachVerbs: 85 7 6 86 30 89 ; Talk, Do, Look, Nose, Paw, Teeth
						setLoop: 0
						cel: 1
						x: 102
						y: 122
						approachX: 96
						approachY: 125
						setPri: 4
					)
					(= local0 5)
					(gGame points: 442 2)
				)
				(gGame handsOff:)
				((ScriptID 895 1) normal: 0 stopUpd:) ; lockjaw
				((ScriptID 895 0) forceUpd: stopUpd:) ; pepper
				(gEgo put: 46)
				(SetFlag 3)
				(gMessager say: 26 10 0 1 self) ; "Check it out, Lockjaw! It stuck!"
			)
			(6 ; Look
				(if (not (IsFlag 4))
					(gMessager say: (self noun:) theVerb 15 0)
				else
					(gMessager say: 5 6) ; "Well, that doesn't look too bad. Let's just hope it holds up."
				)
			)
			(9 ; Hard_Gum
				(if (& (gInventory state:) $0020)
					(gInventory hide:)
				)
				(gGame handsOff:)
				((ScriptID 895 1) normal: 0 stopUpd:) ; lockjaw
				((ScriptID 895 0) stopUpd:) ; pepper
				(gMessager say: 21 9 0 0 self) ; "Darn, it won't stick. It's just not soft enough."
			)
			(85 ; Talk
				(if (not (IsFlag 3))
					(gMessager say: noun 85) ; "Hmm, the bottom of the drainpipe broke right off! I wonder if I could fix it?"
				else
					(gMessager say: 26 102) ; "Hey, it stuck! Excellent!"
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mrsOBrien of Prop
	(properties
		x 28
		y 20
		noun 13
		approachX 44
		approachY 110
		approachDist 20
		view 123
		loop 5
		priority 10
		signal 16
	)

	(method (cue &tmp [temp0 2])
		(super cue: &rest)
		(switch (++ local24)
			(1
				(obrienTimer setReal: self 7)
			)
			(2
				(if (gCurRoom script:)
					(-- local24)
					(obrienTimer setReal: self 2)
				else
					(= local34 0)
					(self cel: 6 cycleSpeed: 4 setCycle: Beg self)
				)
			)
			(3
				(= local24 0)
				(= cycleSpeed 6)
				(self dispose:)
			)
			(100
				(gGame handsOff:)
				(= local34 0)
				(self cel: 6 cycleSpeed: 4 setCycle: Beg self)
			)
			(101
				(= local24 0)
				(gGame handsOn:)
				(= cycleSpeed 6)
				(self dispose:)
			)
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(85 ; Talk
				(gGame points: 203 1)
				(gCurRoom setScript: sTalkOBrien)
			)
			(6 ; Look
				(gMessager say: 13 6) ; "It's Mrs. O'Brien, Pepper's next-door neighbor. She grows flowers, watches daytime TV, and HATES Lockjaw."
			)
			(7 ; Do
				(gMessager say: 13 7) ; "Pepper doesn't want to touch Mrs. O'Brien. Would you?"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mrsOWindow of Feature
	(properties
		x 38
		y 100
		z 100
		noun 15
		nsTop 10
		nsLeft 8
		nsBottom 73
		nsRight 69
		sightAngle 40
		approachX 44
		approachY 110
		approachDist 220
	)

	(method (doVerb theVerb &tmp [temp0 900])
		(cond
			((gCast contains: mrsOBrien)
				(mrsOBrien doVerb: theVerb)
			)
			((Message msgGET 120 15 theVerb 21 1 @temp0)
				(gMessager say: 15 theVerb 21)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pipeFeature of Feature
	(properties
		x 83
		y 56
		noun 26
		nsLeft 63
		nsBottom 113
		nsRight 103
		sightAngle 40
		approachX 83
		approachY 56
		approachDist 10
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(gGame points: 204 1)
				(if (IsFlag 4)
					(drainPipe doVerb: 7)
				else
					(gMessager say: 26 7) ; "The top part of the pipe feels pretty sturdy, I guess."
				)
			)
			(10 ; Soft_Gum
				(gEgo put: 46)
				(SetFlag 3)
				(softGum
					init:
					view: 120
					cel: 1
					x: 84
					y: 65
					setPri: 4
					approachVerbs: 85 7 6 86 30 89 ; Talk, Do, Look, Nose, Paw, Teeth
				)
				(= local0 3)
				(softGum approachX: 83 approachY: 56)
				(gMessager say: 26 10) ; "Check it out, Lockjaw! It stuck!"
				(gGame points: 442 2)
			)
			(103 ; Drain_Pipe
				(if (not (IsFlag 3))
					(gCurRoom setScript: installPipeScr 0 0)
				else
					(SetFlag 4)
					(= local0 6)
					(gGame points: 198 3)
					(gCurRoom setScript: installPipeScr 0 1)
				)
			)
			(9 ; Hard_Gum
				(gMessager say: 26 9) ; "Bummer! It won't stick! I guess it's too hard."
			)
			(85 ; Talk
				(if (and (== local0 6) (IsFlag 3))
					(gMessager say: 26 102) ; "Hey, it stuck! Excellent!"
				else
					(gMessager say: 26 85) ; "Oh, man! The drainpipe is broken!"
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance house of Feature
	(properties
		x 167
		y 1
		noun 16
		nsLeft 66
		nsBottom 126
		nsRight 268
		sightAngle 40
		approachX 167
		approachY 63
		_approachVerbs 32
	)
)

(instance porch of Feature
	(properties
		x 218
		y 108
		nsTop 93
		nsLeft 182
		nsBottom 124
		nsRight 255
		sightAngle 40
		approachX 201
		approachY 100
		_approachVerbs 33
	)
)

(instance flowerBed of Feature
	(properties
		x 32
		y 90
		noun 6
		nsTop 76
		nsBottom 104
		nsRight 64
		sightAngle 40
		approachDist 30
	)

	(method (doVerb theVerb &tmp temp0)
		(= gDictionaryWord 50)
		(switch theVerb
			(7 ; Do
				(if (== local34 1)
					(gMessager say: 6 7 12) ; "Pepper wouldn't try to pick a flower while Mrs. O'Brien is right there! She wants to live to see her next birthday."
				else
					(gCurRoom setScript: sPickFlowers)
				)
			)
			(30 ; Paw
				(gCurRoom setScript: lockjawDigsScr)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance lockJawHouse of Feature
	(properties
		x 134
		y 125
		noun 3
		approachX 150
		approachY 159
	)

	(method (doVerb theVerb)
		(if (== theVerb 86) ; Nose
			(gCurRoom setScript: (ScriptID 875 4) 0 @local35) ; smell
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance appleTree of Feature
	(properties
		x 252
		y 2
		noun 1
		nsLeft 185
		nsBottom 163
		nsRight 319
		sightAngle 40
		approachX 277
		approachY 163
		approachDist 10
	)
)

(instance waterSpicket of Feature
	(properties
		x 72
		y 86
		noun 28
		nsTop 77
		nsLeft 62
		nsBottom 96
		nsRight 80
		sightAngle 40
		approachX 72
		approachY 86
		approachDist 10
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(gCurRoom setScript: addWaterScr)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance waterDish of Feature
	(properties
		x 67
		y 105
		noun 27
		nsTop 95
		nsLeft 55
		nsBottom 115
		nsRight 80
		sightAngle 40
		approachX 67
		approachY 105
		approachDist 10
	)

	(method (doVerb theVerb)
		(switch theVerb
			(9 ; Hard_Gum
				(if (not local7)
					(gMessager say: 27 9 23) ; "That's an interesting idea, but there's no water in the bowl. Try using the gum somewhere else."
				else
					(gMessager say: 27 9 22) ; "That's an interesting idea, but Lockjaw drank all the water. Maybe you should use the gum somewhere else."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance fence of Feature
	(properties
		x 159
		y 161
		noun 4
		nsTop 133
		nsBottom 189
		nsRight 319
		sightAngle 40
		approachX 136
		approachY 187
	)

	(method (doVerb theVerb &tmp [temp0 50])
		(= gDictionaryWord 9)
		(switch theVerb
			(7 ; Do
				(gMessager say: 4 7) ; "Pepper doesn't want to get a splinter."
			)
			(6 ; Look
				(gMessager say: 4 6) ; "It's the fence."
			)
			(86 ; Nose
				(gMessager say: 4 86) ; "The fence smells like the rest of the yard."
			)
			(30 ; Paw
				(gMessager say: 4 30) ; "Since he's not a cat or a |r||c0|Basenji|c||r|, Lockjaw can't climb the fence."
			)
			(85 ; Talk
				(gMessager say: 4 85) ; "Pepper practices her verbal fencing."
			)
			(89 ; Teeth
				(gMessager say: 4 89) ; "Lockjaw could chew through the fence if he wanted to, but he'd never run away from Pepper."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sideWalk of Feature
	(properties
		x 210
		y 142
		noun 23
		approachX 189
		approachY 170
	)
)

(instance pepperWindow of Feature
	(properties
		x 132
		y 52
		noun 19
		nsTop 14
		nsLeft 97
		nsBottom 90
		nsRight 168
		sightAngle 40
		approachX 130
		approachY 120
		approachDist 10
	)

	(method (doVerb theVerb)
		(if (not (OneOf theVerb 85 7 6 86 30 89)) ; Talk, Do, Look, Nose, Paw, Teeth
			(super doVerb: theVerb &rest)
		else
			(gMessager say: 19 theVerb)
		)
	)
)

(instance foliage of Feature
	(properties
		x 249
		y 157
		noun 7
		nsTop 125
		nsLeft 180
		nsBottom 189
		nsRight 319
		sightAngle 40
		approachX 196
		approachY 174
		_approachVerbs 32
	)

	(method (doVerb theVerb)
		(switch theVerb
			(85 ; Talk
				(if (== (++ local33) 3)
					(specialTalker x: 160 y: 160 tailPosn: 1)
					(gMessager say: 7 85 14) ; "So, what do you plants have to say for yourselves?"
				else
					(gMessager say: 7 85) ; "Pepper says a few kind words to the plants to help them grow."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance door of Feature
	(properties
		x 225
		y 69
		noun 17
		nsTop 40
		nsLeft 194
		nsBottom 99
		nsRight 256
		sightAngle 40
		onMeCheck 4
		approachX 203
		approachY 100
	)

	(method (doVerb theVerb)
		(= gDictionaryWord 102)
		(switch theVerb
			(1 ; ???
				(gCurRoom setScript: sDoor 0 theVerb)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance obrienHouse of Feature
	(properties
		x 36
		y 41
		noun 14
		nsBottom 82
		nsRight 73
		sightAngle 40
		approachX 44
		approachY 110
		approachDist 10
	)

	(method (doVerb theVerb)
		(if (== theVerb 85) ; Talk
			(mrsOWindow doVerb: 85)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance Hard_Gum of TWInvItem
	(properties
		name {Hard Gum}
		cel 3
		message 9
		noun 9
		modNum 120
	)

	(method (doVerb theVerb)
		(switch theVerb
			(103 ; Drain_Pipe
				(drainPipe doVerb: 9)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance Soft_Gum of TWInvItem
	(properties
		name {Soft Gum}
		cel 4
		message 10
		noun 24
		modNum 120
	)

	(method (doVerb theVerb)
		(switch theVerb
			(103 ; Drain_Pipe
				(gGame points: 442 2)
				(drainPipe doVerb: 10)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance Drain_Pipe of TWInvItem
	(properties
		name {Drain Pipe}
		cel 1
		message 103
		noun 21
		modNum 120
	)

	(method (init)
		(if (IsFlag 3)
			(= noun 20)
			(= cel 2)
		)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; Soft_Gum
				(drainPipe doVerb: 10)
				(gGame points: 442 2)
			)
			(9 ; Hard_Gum
				(drainPipe doVerb: 9)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance gumFeature of Feature
	(properties
		x 215
		y 146
		noun 9
		nsTop 141
		nsLeft 208
		nsBottom 152
		nsRight 223
	)

	(method (doVerb theVerb)
		(hardGum doVerb: theVerb)
	)
)

(instance lockjawPoly of Polygon
	(properties
		type PBarredAccess
	)
)

(instance obrienTalker of BalloonTalker
	(properties
		x 41
		y 71
		talkWidth 150
		tailPosn 3
	)

	(method (say)
		((ScriptID 895 1) stopUpd:) ; lockjaw
		((ScriptID 895 0) stopUpd:) ; pepper
		(mrsOBrien setCycle: CycleBet 5 15 1)
		(super say: &rest)
	)

	(method (dispose)
		(mrsOBrien setCycle: 0)
		(super dispose: &rest)
	)
)

(instance specialTalker of BalloonTalker
	(properties
		talkWidth 150
	)
)

(instance obrienTimer of Timer
	(properties)
)

(instance birdTimer of Timer
	(properties)
)

(instance sTalkOBrien of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 895 1) normal: 0 stopUpd:) ; lockjaw
				(if (!= local34 1)
					(if (not (gCast contains: mrsOBrien))
						(mrsOBrien init: approachVerbs: 85 7 6 86 30 89) ; Talk, Do, Look, Nose, Paw, Teeth
					)
					(mrsOBrien setCycle: CT 5 1 self)
				else
					(= cycles 2)
				)
			)
			(1
				(= local34 1)
				((ScriptID 895 0) setHeading: 0 self) ; pepper
			)
			(2
				(= cycles 2)
			)
			(3
				(switch (++ local27)
					(1
						((ScriptID 2000 3) talkWidth: 165) ; PepperTalker
						(gMessager say: 13 85 [local28 local27] 1 3 self)
					)
					(2
						((ScriptID 2000 3) talkWidth: 165) ; PepperTalker
						(obrienTalker talkWidth: 80)
						(= state 99)
						(gMessager say: 13 85 [local28 local27] 0 self)
					)
					(3
						(= state 99)
						(gMessager say: 13 85 [local28 local27] 0 self)
					)
					(else
						(= state 99)
						(gMessager say: 13 85 [local28 4] 0 self)
					)
				)
			)
			(4
				((ScriptID 2000 3) talkWidth: 0) ; PepperTalker
				(= state 99)
				(gMessager say: 13 85 [local28 local27] 4 5 self)
			)
			(100
				((ScriptID 895 1) normal: 1 startUpd:) ; lockjaw
				((ScriptID 2000 3) talkWidth: 0) ; PepperTalker
				(obrienTalker talkWidth: 150)
				(= local24 99)
				(mrsOBrien cue:)
				(self dispose:)
			)
		)
	)
)

(instance sDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 895 1) normal: 0) ; lockjaw
				(if (== register 30)
					(self changeState: 20)
				else
					(gMessager say: 17 7 0 1 self) ; "See ya, fur face. I'm going inside for awhile."
				)
			)
			(1
				((ScriptID 895 1) normalize: loop: 8 cel: 5) ; lockjaw
				(= ticks 30)
			)
			(2
				((ScriptID 895 1) setHeading: 0 self) ; lockjaw
				(gMessager say: 17 7 0 2 self) ; "Whine whine whine! Whiiiiiine?"
			)
			(3)
			(4
				(gEgo setHeading: 180 self)
			)
			(5
				(= cycles 2)
			)
			(6
				((ScriptID 2000 3) talkWidth: 175 winX: 20 winY: 65) ; PepperTalker
				(gMessager say: 17 7 0 3 self) ; "YOU can't come in!"
			)
			(7
				((ScriptID 2000 3) talkWidth: 0 winX: 0 winY: 0) ; PepperTalker
				((ScriptID 895 1) setHeading: 225 self) ; lockjaw
				(gMessager say: 17 7 0 4 6 self) ; "Dad's still mad at you for yanking down the tablecloth and all the breakfast dishes."
			)
			(8)
			(9
				(gGame handsOn:)
				((ScriptID 895 1) normal: 1) ; lockjaw
				(self dispose:)
			)
			(20
				(Face (ScriptID 895 0) (ScriptID 895 1) self) ; pepper, lockjaw
			)
			(21
				(gMessager say: 17 30 0 0 self) ; "Whine! Whine! Yipe yipe yipe!"
			)
			(22
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sLayEgg of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(bird setLoop: 3 cel: 0 cycleSpeed: 12 setCycle: 0)
				(= ticks 30)
			)
			(1
				(gLongSong2 number: 1228 setLoop: 1 play:)
				(bird setCycle: End self)
			)
			(2
				(= seconds 2)
			)
			(3
				(egg x: (bird x:) y: (- (bird y:) 100) init: stopUpd:)
				(= local26 2)
				(= ticks 30)
			)
			(4
				(gMessager say: 2 6 4 2 self) ; "YIKES! That's the biggest Easter egg I ever saw!"
			)
			(5
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sPissOnTree of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 895 1) ; lockjaw
					normalize:
					normal: 0
					setMotion: PolyPath 264 153 self
				)
			)
			(1
				((ScriptID 895 1) setLoop: 8 cel: 5) ; lockjaw
				(= ticks 30)
			)
			(2
				(if (== local26 2)
					(egg setLoop: 4)
					(bird setPri: 15 y: 31 z: 0)
				)
				(bird setScript: 0 setLoop: 0 setCycle: Fwd)
				((ScriptID 895 1) ; lockjaw
					view: 130
					setLoop: 2
					cel: 0
					x: 262
					y: 154
					setCycle: End self
				)
				(gLongSong2 number: 1226 setLoop: 1 play:)
				(= local26 1)
			)
			(3
				(= ticks 60)
			)
			(4
				((ScriptID 895 1) setCycle: Beg self) ; lockjaw
			)
			(5
				((ScriptID 895 1) normalize: loop: 8 cel: 5 x: 264 y: 153) ; lockjaw
				(= ticks 30)
			)
			(6
				((ScriptID 895 1) setMotion: PolyPath 58 150 self) ; lockjaw
			)
			(7
				(birdTimer setReal: bird 5)
				(self dispose:)
			)
		)
	)
)

(instance sGetPipe of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if
					(and
						(!= ((ScriptID 895 0) x:) 83) ; pepper
						(!= ((ScriptID 895 0) y:) 130) ; pepper
					)
					(-- state)
					(gEgo setMotion: PolyPath 83 130 self)
				else
					(gEgo setHeading: 90 self)
				)
			)
			(1
				(gEgo
					view: 839
					setLoop: 0
					cel: 0
					cycleSpeed: 8
					setCycle: CT 3 1 self
				)
			)
			(2
				(= ticks 30)
			)
			(3
				(gEgo get: 47 setCycle: Beg self)
				(if (== local0 5)
					(softGum dispose:)
					(= local0 4)
					(Drain_Pipe noun: 20 cel: 2)
				)
				(drainPipe dispose:)
			)
			(4
				(gEgo normalize: loop: 8 cel: 0)
				(= ticks 30)
			)
			(5
				(gEgo normalize: setHeading: 180 self)
			)
			(6
				(= cycles 2)
			)
			(7
				(gMessager say: 21 7 15 0 self) ; "Hmm. I wonder what I could do with this broken piece of drainpipe."
			)
			(8
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetGum of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if
					(and
						(!= ((ScriptID 895 0) x:) 247) ; pepper
						(!= ((ScriptID 895 0) y:) 156) ; pepper
					)
					(-- state)
					(gEgo setMotion: PolyPath 247 156 self)
				else
					(gEgo setHeading: 90 self)
					(SetFlag 63)
				)
			)
			(1
				(gEgo
					view: 839
					setLoop: 0
					cel: 0
					cycleSpeed: 8
					setCycle: End self
				)
			)
			(2
				(= ticks 30)
			)
			(3
				(softGum dispose:)
				(gEgo setCycle: Beg self)
			)
			(4
				(gGame points: 444 1)
				(gEgo normalize: loop: 8 cel: 0 get: 46)
				(= cycles 2)
			)
			(5
				(gEgo normalize: setHeading: 180 self)
			)
			(6
				(= cycles 2)
			)
			(7
				(gMessager say: 12 104 0 1 self) ; "Yech! Dog spit!"
			)
			(8
				(gGame handsOn:)
				(= local0 1)
				(self dispose:)
			)
		)
	)
)

(instance sBird of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (not gModelessDialog)
					(client setLoop: (Random 1 2) cel: 0 setCycle: End self)
				else
					(client stopUpd:)
					(= cycles 2)
				)
			)
			(1
				(= ticks (Random 20 60))
			)
			(2
				(if (not gModelessDialog)
					(client setCycle: Beg self)
				else
					(client stopUpd:)
					(= cycles 2)
				)
			)
			(3
				(= state -1)
				(= ticks (Random 30 120))
			)
		)
	)
)

(instance initScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					init:
					normalize:
					setScale: 0
					loop: 2
					cel: 0
					posn: 199 117
					ignoreActors: 1
					actions: pepperDoVerb
				)
				((ScriptID 895 1) ; lockjaw
					init:
					normalize:
					setScale: 0
					actions: lockjawDoVerb
					approachVerbs: 6 7 85 ; Look, Do, Talk
					loop: 2
					cel: 4
					posn: 222 116
					noun: 12
					approachX: 201
					approachY: 132
					ignoreActors: 1
				)
				(= cycles 2)
			)
			(1
				(proc120_2)
				(gCurRoom addObstacle: lockjawPoly)
				((ScriptID 895 1) normal: 1) ; lockjaw
				(= cycles 2)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance addWaterScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(proc120_2 1)
				(Face gEgo (ScriptID 895 1) self) ; lockjaw
			)
			(1
				(= cycles 2)
			)
			(2
				(if local7
					(gMessager say: 28 7 24 1 self) ; "Want some more? Here you go, bud."
				else
					(gMessager say: 28 7 0 1 self) ; "How about a drink, bud?"
				)
			)
			(3
				((ScriptID 895 0) ; pepper
					ignoreActors: 1
					illegalBits: 0
					setMotion: PolyPath 49 113 self
				)
			)
			(4
				(Load rsVIEW 130)
				((ScriptID 895 0) loop: 8 cel: 6) ; pepper
				(= ticks 30)
			)
			(5
				((ScriptID 895 0) ; pepper
					view: 130
					x: 52
					cycleSpeed: 8
					setLoop: 0
					cel: 0
					setCycle: CT 2 1 self
				)
				(gGame points: 194 1)
			)
			(6
				(gLongSong2 number: 1226 setLoop: 1 play:)
				((ScriptID 895 0) setCycle: End self) ; pepper
			)
			(7
				(gLongSong2 stop:)
				(= ticks 30)
			)
			(8
				((ScriptID 895 0) normalize: loop: 8 cel: 6 x: 49) ; pepper
				(= ticks 30)
			)
			(9
				((ScriptID 895 1) normal: 0) ; lockjaw
				((ScriptID 895 0) setMotion: PolyPath 13 118 self) ; pepper
			)
			(10
				((ScriptID 895 0) setHeading: 90) ; pepper
				((ScriptID 895 1) ; lockjaw
					normalize:
					ignoreActors: 1
					setMotion: PolyPath 52 104 self
				)
			)
			(11
				(gLongSong2 number: 904 setLoop: -1 play:)
				((ScriptID 895 1) ; lockjaw
					view: 130
					x: 54
					setLoop: 1
					cel: 0
					setPri: 1
					setCycle: Fwd
					cycleSpeed: 6
				)
				(= seconds (Random 4 6))
			)
			(12
				((ScriptID 895 1) normalize: x: 52 loop: 8 cel: 4) ; lockjaw
				(gLongSong2 stop:)
				(= ticks 30)
			)
			(13
				(if (== (++ local7) 2)
					(self setScript: sPissOnTree self)
				else
					((ScriptID 895 1) ; lockjaw
						setLoop: 2
						cycleSpeed: 1
						moveSpeed: 1
						setMotion: MoveTo 58 150 self
					)
				)
			)
			(14
				((ScriptID 895 1) normal: 1 approachX: 59 approachY: 157) ; lockjaw
				(proc120_2)
				((ScriptID 895 0) normalize:) ; pepper
				(= cycles 2)
			)
			(15
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance gumWalkScr of Script
	(properties)

	(method (doit)
		(cond
			(
				(and
					(== ((ScriptID 895 0) view:) 121) ; pepper
					(== ((ScriptID 895 0) loop:) 0) ; pepper
					(not (gLongSong2 handle:))
					(or
						(== ((ScriptID 895 0) cel:) 1) ; pepper
						(== ((ScriptID 895 0) cel:) 8) ; pepper
					)
				)
				(gLongSong2 number: 1201 loop: 1 play:)
			)
			(
				(and
					(== ((ScriptID 895 0) view:) 121) ; pepper
					(== ((ScriptID 895 0) loop:) 1) ; pepper
					(== ((ScriptID 895 0) cel:) 3) ; pepper
					(not (gLongSong2 handle:))
				)
				(gLongSong2 number: 1202 loop: 1 play:)
			)
		)
		(super doit: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 895 1) normal: 0) ; lockjaw
				(if register
					(gGame points: 195 1)
					(SetFlag 54)
				)
				(if (and (!= (gEgo x:) 217) (!= (gEgo y:) 141) register)
					(-- state)
					(gEgo setMotion: PolyPath 217 141 self)
				else
					(= cycles 2)
				)
			)
			(1
				(= cycles 3)
			)
			(2
				((ScriptID 895 0) ; pepper
					view: 121
					posn: 224 147
					setLoop: 0
					cycleSpeed: 10
					setCycle: End self
				)
			)
			(3
				(gMessager say: 9 7 15 1 self) ; "Oh, man, I stepped in it! Yech!"
			)
			(4
				((ScriptID 895 0) setCycle: Beg self) ; pepper
			)
			(5
				(if register
					(gGame points: 195 1)
					(hardGum dispose:)
					((ScriptID 895 0) setLoop: 1 setCycle: End self) ; pepper
				else
					(= cycles 2)
				)
			)
			(6
				((ScriptID 895 0) ; pepper
					normalize:
					loop: 8
					cel: 2
					heading: 180
					x: (- ((ScriptID 895 0) x:) 4) ; pepper
				)
				((ScriptID 2000 3) ; PepperTalker
					talkWidth: 70
					winX: 228
					winY: 109
					tailPosn: 0
					forceWidth: 1
				)
				(gMessager say: 9 7 15 2 self) ; "Nasty!"
			)
			(7
				((ScriptID 2000 3) talkWidth: 0 winX: 0 winY: 0 forceWidth: 0) ; PepperTalker
				(if (not register)
					((ScriptID 895 0) ; pepper
						cycleSpeed: 3
						setMotion:
							PolyPath
							((ScriptID 895 0) x:) ; pepper
							(+ ((ScriptID 895 0) y:) 10) ; pepper
							self
					)
				else
					((ScriptID 895 1) normal: 1) ; lockjaw
					(= cycles 1)
				)
			)
			(8
				(gGame handsOn:)
				(gEgo normalize:)
				(self dispose:)
			)
		)
	)
)

(instance installPipeScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					view: 122
					posn: 83 79
					setLoop: 0
					cel: 0
					cycleSpeed: 5
					put: 47
					setCycle: CT 4 1 self
				)
			)
			(1
				(gLongSong2 number: 1207 loop: 1 play: self)
			)
			(2
				(gEgo cel: 3 setCycle: End self)
			)
			(3
				(gLongSong2 loop: -1)
				(gEgo normalize: loop: 8 cel: 6 x: 68 y: 117 heading: 45)
				(switch register
					(0
						(drainPipe
							init:
							view: 132
							setLoop: 6
							cel: 0
							x: 72
							y: 105
							setPri: 5
							setCycle: CT 4 1 self
						)
					)
					(1
						(drainPipe init: cel: 3 posn: 88 67 setPri: 5 addToPic:)
						(if (gCast contains: softGum)
							(softGum dispose:)
						)
						(= ticks 30)
					)
				)
			)
			(4
				(if (not register)
					(gLongSong2 number: 1214 setLoop: 1 play:)
					(drainPipe setCycle: CT 10 1 self)
				else
					(self cue:)
				)
			)
			(5
				(if (not register)
					(gLongSong2 number: 1214 setLoop: 1 play:)
					(drainPipe setCycle: End self)
				else
					(self cue:)
				)
			)
			(6
				(if (not register)
					(drainPipe
						view: 120
						loop: 0
						cel: 2
						x: 97
						y: 119
						setPri: 4
						forceUpd:
						stopUpd:
					)
				)
				(gEgo setCycle: Rev setMotion: MoveTo 57 121 self)
			)
			(7
				(if (and (OneOf local0 4 3 5) (gCast contains: softGum))
					(softGum dispose:)
				)
				(gEgo normalize: setHeading: 180 self)
			)
			(8
				(= cycles 2)
			)
			(9
				(if register
					(gMessager say: 26 102 0 1 self) ; "Hey, it stuck! Excellent!"
				else
					(gMessager say: 26 103 0 1 self) ; "Geez, that's not gonna work!"
				)
			)
			(10
				(pipeFeature noun: 5)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance hole of View
	(properties
		x 35
		y 102
		noun 11
		approachX 52
		approachY 111
		view 120
		priority 1
		signal 26640
	)

	(method (doVerb theVerb)
		(if (not (gEgo has: 0)) ; Dog_Harness
			(= noun 10)
		else
			(= noun 11)
		)
		(switch theVerb
			(7 ; Do
				(gCurRoom setScript: sGetHarness)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance sGetHarness of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (gEgo has: 0) ; Dog_Harness
					(gMessager say: 11 7 0 0 self) ; "Pepper doesn't want to reach into the hole. Something might grab her!"
				else
					(++ state)
					(gEgo view: 839 setLoop: 1 cel: 0 setCycle: CT 3 1 self)
				)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
			(2
				(hole setLoop: 1 cel: 0)
				(gEgo get: 0 setCycle: Beg self) ; Dog_Harness
				(gMessager say: 10 7 0 0 self) ; "It looks a little dirty, but at least you didn't chew it up, Lockjaw!"
			)
			(3)
			(4
				(gEgo normalize:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance lockjawDigsScr of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame points: 199 2)
				(SetFlag 64)
				((ScriptID 895 0) setHeading: 225) ; pepper
				((ScriptID 895 1) normal: 0 normalize: setScript: 0) ; lockjaw
				(if
					(and
						(!= ((ScriptID 895 1) x:) 17) ; lockjaw
						(!= ((ScriptID 895 1) y:) 116) ; lockjaw
					)
					(-- state)
					((ScriptID 895 1) setMotion: PolyPath 17 116 self) ; lockjaw
				else
					(= ticks 30)
				)
			)
			(1
				((ScriptID 895 1) setLoop: 8 cel: 3) ; lockjaw
				(= ticks 30)
			)
			(2
				(gMessager say: 6 30 13 1 self) ; "Lockjaw suddenly remembers where his harness is!"
			)
			(3
				((ScriptID 895 0) setMotion: MoveTo 52 118 self) ; pepper
			)
			(4
				((ScriptID 895 0) ; pepper
					setPri: -1
					setLoop: 4
					setMotion: MoveTo 73 158 self
				)
			)
			(5
				((ScriptID 895 1) ; lockjaw
					normalize:
					setLoop: 6
					setMotion: MoveTo 36 108 self
				)
				((ScriptID 895 0) setLoop: -1 setHeading: 310 self) ; pepper
			)
			(6)
			(7
				((ScriptID 895 1) setLoop: 8 cel: 7) ; lockjaw
				(= ticks 30)
			)
			(8
				(= register 2)
				((ScriptID 895 1) ; lockjaw
					view: 123
					setLoop: 3
					posn: 31 109
					cel: 0
					cycleSpeed: 8
					setCycle: End self
				)
				(if (not (gLongSong2 handle:))
					(gLongSong2 number: 903 setLoop: -1 play:)
				)
			)
			(9
				((ScriptID 895 1) setCycle: CT 3 -1 self) ; lockjaw
			)
			(10
				((ScriptID 895 1) cel: 3 setCycle: End self) ; lockjaw
			)
			(11
				(if (not (-- register))
					((ScriptID 895 1) ; lockjaw
						setCycle: 0
						normalize:
						loop: 8
						cel: 7
						posn: 36 108
					)
					(hole init: approachVerbs: 85 7 6 86 30 89 stopUpd:) ; Talk, Do, Look, Nose, Paw, Teeth
					(gLongSong2 stop:)
					(mrsOBrien
						init:
						setCycle: CT 5 1 self
						approachVerbs: 85 7 6 86 30 89 ; Talk, Do, Look, Nose, Paw, Teeth
					)
					(= local34 1)
				else
					(-= state 2)
					(= cycles 2)
				)
			)
			(12
				(gMessager say: 6 30 13 2 self) ; "Oh! Oh, NO! Get out of there, you horrid animal! PEPPER!!! STOP YOUR DOG!!!"
			)
			(13
				(mrsOBrien setCycle: 0 stopUpd:)
				(gMessager say: 6 30 13 3 self) ; "Lockjaw, come here!"
			)
			(14
				(mrsOBrien setCycle: 0 stopUpd:)
				((ScriptID 895 0) setHeading: 180) ; pepper
				((ScriptID 895 1) ; lockjaw
					normalize:
					ignoreActors: 1
					illegalBits: 0
					setLoop: 4
					setMotion: MoveTo 52 149 self
				)
			)
			(15
				((ScriptID 895 1) setLoop: 2 setMotion: MoveTo 53 159 self) ; lockjaw
			)
			(16
				((ScriptID 895 1) view: 838 setLoop: 1 cel: 2 setCycle: 0) ; lockjaw
				(= ticks 60)
			)
			(17
				((ScriptID 895 1) hide:) ; lockjaw
				((ScriptID 895 0) view: 124 setLoop: 0 cel: 0 x: 62 y: 158) ; pepper
				(= ticks 30)
			)
			(18
				((ScriptID 895 0) cycleSpeed: 4 setCycle: End self) ; pepper
			)
			(19
				(gMessager say: 6 30 13 4 self) ; "Good boy! Good boy!"
			)
			(20
				((ScriptID 895 0) setCycle: Beg self) ; pepper
			)
			(21
				((ScriptID 895 0) normalize: loop: 8 cel: 2 x: 73 y: 158) ; pepper
				((ScriptID 895 1) view: 838 cel: 2 setLoop: 1 setCycle: 0 show:) ; lockjaw
				(= ticks 30)
			)
			(22
				(gMessager say: 6 30 13 5 6 self) ; "Good? GOOD?!? Pepper Pumpernickel, your dog is the WORST creature I've ever seen!"
			)
			(23
				(= cycles 2)
			)
			(24
				(gMessager say: 6 30 13 7 self) ; "Rruff!"
			)
			(25
				((ScriptID 895 0) ignoreActors: 1 setMotion: MoveTo 91 170 self) ; pepper
			)
			(26
				(proc120_2)
				((ScriptID 895 1) ; lockjaw
					normal: 1
					approachX: 49
					approachY: 169
					setScript: (ScriptID 838 0) ; LockjawStuff
				)
				(= local24 99)
				(mrsOBrien cue:)
				(gGame setEgo: (ScriptID 895 0)) ; pepper
				(self dispose:)
			)
		)
	)
)

(instance sFinalClimb of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 895 1) normal: 0 setScript: 0) ; lockjaw
				((ScriptID 895 0) ; pepper
					ignoreActors: 1
					illegalBits: 0
					setMotion: PolyPath 66 121 self
				)
			)
			(1
				((ScriptID 895 0) setMotion: MoveTo 66 112 self) ; pepper
			)
			(2
				(Face (ScriptID 895 0) (ScriptID 895 1) self) ; pepper, lockjaw
			)
			(3
				(= cycles 2)
			)
			(4
				(gMessager say: 12 107 16 1 4 self) ; "C'mere, Lockjaw! Here, boy! Let's put on your harness!"
			)
			(5
				((ScriptID 895 1) ; lockjaw
					normalize:
					ignoreActors: 1
					illegalBits: 0
					setMotion: PolyPath 32 115 self
				)
			)
			(6
				((ScriptID 895 1) setLoop: 8 cel: 6 setCycle: 0 x: 32 y: 115) ; lockjaw
				(= ticks 30)
			)
			(7
				((ScriptID 895 0) setLoop: 8 cel: 6 setCycle: 0) ; pepper
				(= ticks 30)
			)
			(8
				((ScriptID 895 1) hide:) ; lockjaw
				((ScriptID 895 0) ; pepper
					view: 132
					cycleSpeed: 8
					setLoop: 3
					cel: 0
					x: 17
					y: 115
				)
				(gLongSong fade:)
				(= ticks 30)
			)
			(9
				(gEgo
					setLoop: 5
					cel: 0
					x: 55
					y: 54
					setPri: 6
					cycleSpeed: 12
					setCycle: CT 2 1 self
				)
				(gLongSong number: 122 setLoop: 1 flags: 1 play:)
			)
			(10
				(gGame points: 445 2)
				((ScriptID 2000 3) winX: 67 winY: 93 tailPosn: 3) ; PepperTalker
				((ScriptID 2004 0) winX: 39 winY: 123 tailPosn: 3) ; LockjawTalker
				(gMessager say: 12 107 16 5 7 self) ; "Lockjaw! What are you doing, you weird dog? Let go!"
			)
			(11
				((ScriptID 895 0) setCycle: End self) ; pepper
			)
			(12
				((ScriptID 895 1) setScript: (ScriptID 838 0)) ; lockjaw, LockjawStuff
				(gCurRoom newRoom: (gCurRoom north:))
			)
		)
	)
)

(instance sPickFlowers of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (and (!= (gEgo x:) 39) (!= (gEgo y:) 111))
					(-- state)
					(gEgo setMotion: PolyPath 39 111 self)
				else
					(gGame points: 202 1)
					(gEgo setLoop: 7 setMotion: MoveTo 32 109 self)
				)
			)
			(1
				(gEgo setLoop: 8 cel: 7)
				(= ticks 60)
			)
			(2
				(switch (++ local5)
					(1
						(gMessager say: 6 7 7 1 self) ; "Hey, Lockjaw, I think I'm gonna pick one of Mrs. O'Brien's flowers for mom."
					)
					(2
						(gMessager say: 6 7 8 1 self) ; "Okay, Lockjaw, the coast is clear! I'm gonna try to get a flower again."
					)
					(3
						((ScriptID 2000 3) talkWidth: 160) ; PepperTalker
						(gMessager say: 6 7 9 1 self) ; "Geez, does she have a flower detector or something? I can't help it, Lockjaw, I've gotta try again!"
					)
					(4
						(gMessager say: 6 7 10 1 self) ; "One little flower! That's all I want. That's not so bad, is it, Lockjaw? To heck with it. I'm gonna try again."
					)
					(5
						(gMessager say: 6 7 11 1 self) ; "Pepper just doesn't know when to give up!"
					)
					(else
						(= state 6)
						(= register 1)
						(gMessager say: 6 7 6 1 self) ; "Pepper has better things to do now. She decides to leave Mrs. O'Brien's flowers alone."
					)
				)
			)
			(3
				(mrsOBrien
					init:
					setCycle: CT 5 1 self
					approachVerbs: 85 7 6 86 30 89 ; Talk, Do, Look, Nose, Paw, Teeth
				)
				(= local34 1)
				(gEgo view: 839 setLoop: 1 cel: 0 setCycle: End self)
			)
			(4)
			(5
				(switch local5
					(1
						(gMessager say: 6 7 7 2 self) ; "HEY! I've told you and that mutt to keep away from my flowers, missy! Just LOOK at all the holes he's made in my flowerbed!"
					)
					(2
						(gMessager say: 6 7 8 2 self) ; "Didn't I tell you to stay away from my flowers? What's wrong with you, girl, are you deaf?"
					)
					(3
						(gMessager say: 6 7 9 2 self) ; "Missy, if you come one step closer to those flowers, so help me, I'll call the dog catcher!"
					)
					(4
						(gMessager say: 6 7 10 2 self) ; "Pepper Pumpernickel, if you and that |r||c0|hyena|c||r| in a dog suit touch one more flower petal, I'll come right out this window and tan your hides myself!"
					)
					(5
						(gMessager say: 6 7 11 2 self) ; "You--! You--!! YOU--!!! GET OUT OF THERE!!!"
					)
					(else
						(= cycles 2)
					)
				)
			)
			(6
				(mrsOBrien setCycle: 0 stopUpd:)
				(gEgo setCycle: Beg self)
			)
			(7
				(gEgo normalize: setHeading: 125 self)
			)
			(8
				(gEgo setMotion: MoveTo 39 111 self)
			)
			(9
				(gGame handsOn:)
				(if (== local5 5)
					(= local24 99)
				)
				(if (not register)
					(mrsOBrien cue:)
				)
				(self dispose:)
			)
		)
	)
)

