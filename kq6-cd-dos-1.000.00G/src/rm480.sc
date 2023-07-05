;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 480)
(include sci.sh)
(use Main)
(use CryBaby)
(use n482)
(use n483)
(use KQ6Room)
(use n913)
(use Print)
(use Conversation)
(use Osc)
(use RandCycle)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Rev)
(use Timer)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm480 0
	hiw 1
	brat1 2
	drinkBottle 3
	myTeaCup 4
	wallFlowerDance 5
	myBottle 6
	gates 7
	rotTomato 8
)

(local
	local0
	local1
	local2
	local3
	local4
)

(instance myConv of Conversation
	(properties)
)

(instance rm480 of KQ6Room
	(properties
		noun 3
		picture 480
		walkOffEdge 1
		autoLoad 0
	)

	(method (init)
		(if (and (== gPrevRoomNum 99) (FileIO fiEXISTS {g})) ; speedRoom
			(SetFlag 77)
			(gEgo get: 14) ; flute
			(gEgo get: 22) ; milk
			((gInventory at: 33) owner: gCurRoomNum) ; potion
			(= gAct 4)
		)
		(gGame handsOn:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 0 319 0 319 189 148 189 216 158 228 144 291 141 297 133 232 136 216 126 214 116 313 86 302 82 178 101 116 101 74 102 63 95 3 91 3 101 38 101 38 109 25 116 2 116 2 135 34 135 34 145 26 158 1 158 1 188 59 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 68 109 40 109 40 101 66 101 72 106
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 186 125 171 138 153 141 110 141 97 136 101 127 64 127 64 116 104 116 106 110 160 110 186 120
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 147 160 84 160 84 144 158 144 163 155
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 16 123 36 112 54 112 62 120 62 130 20 130
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 27 161 37 145 82 145 82 161
					yourself:
				)
		)
		(super init: &rest)
		(gGlobalSound number: 480 setLoop: -1 play:)
		((ScriptID 40 0) lampMsg: 15) ; rWonder
		(gFeatures
			add:
				sourGrapes
				chokers
				greenMaters
				pathway
				table
				lettuce
				chair
				pillars
				wall
			eachElementDo: #init
		)
		(if (== gPrevRoomNum 490)
			(gates cel: 4 signal: 26624 init:)
		else
			(gates cel: 0 signal: 16384 addToPic:)
		)
		(snap init:)
		(flower1 init:)
		(flower2 init:)
		(flower3 init:)
		(flower4 init:)
		(if (== ((gInventory at: 49) owner:) gCurRoomNum) ; tomato
			(rotTomato init:)
		)
		(if (and (== ((gInventory at: 33) owner:) gCurRoomNum) (> gAct 3)) ; potion
			(drinkBottle init:)
		)
		(brat1 init:)
		(brat2 init:)
		(brat3 init:)
		(brat4 init:)
		(if (and (IsFlag 77) (== ((gInventory at: 46) owner:) gCurRoomNum)) ; teaCup
			(myTeaCup init: stopUpd:)
			(glint init: hide:)
			(glintTimer setReal: glint (Random 3 6))
		)
		(gEgo actions: fluteVerb init:)
		(gCurRoom setScript: egoEnters)
		(if (== ((gInventory at: 18) owner:) gCurRoomNum) ; holeInTheWall
			(hiw init:)
		)
		(Load rsMESSAGE 480)
	)

	(method (doit)
		(cond
			((gEgo script:))
			((gCurRoom script:))
			((== (gEgo edgeHit:) 3)
				(gCurRoom setScript: egoExits)
			)
			((gEgo inRect: 207 120 312 152)
				(gEgo setMotion: 0)
				(if (== (gEgo loop:) 3)
					((ScriptID 480 5) register: 1) ; wallFlowerDance
					(gEgo setScript: coverThatButtScr)
				else
					((ScriptID 480 5) register: 1) ; wallFlowerDance
					(gCurRoom setScript: stepOnSnaps)
				)
			)
			(
				(or
					(== (gEgo onControl: 1) 4096)
					(== (gEgo onControl: 1) 8192)
				)
				((ScriptID 480 5) register: 1) ; wallFlowerDance
				(gEgo setScript: hanging 0 3)
			)
			(
				(and
					(gEgo inRect: 194 80 300 100)
					(not ((ScriptID 40 0) flowerDance:)) ; rWonder
				)
				((ScriptID 480 5) register: 1) ; wallFlowerDance
				(gEgo setScript: shyFlowers)
			)
		)
		(super doit:)
	)

	(method (newRoom newRoomNumber)
		(glintTimer dispose: delete:)
		(roomTimer dispose: delete:)
		(super newRoom: newRoomNumber)
	)

	(method (dispose)
		(LoadMany 0 481 482 483 939 969)
		((ScriptID 40 0) bottleSucker: 0) ; rWonder
		(super dispose:)
	)

	(method (cue param1)
		(switch param1
			(3
				(wallFlowerDance cue:)
			)
			(0
				((ScriptID 40 0) flowerDance: 0) ; rWonder
				(flower1 setLoop: 0 setCycle: Beg)
				(flower2 setLoop: 1 setCycle: Beg)
				(flower3 setLoop: 2 setCycle: Beg)
				(flower4 setLoop: 3 setCycle: Beg)
				(snap setCycle: Beg)
			)
			(else
				(flower1 setCycle: Beg)
				(flower2 setCycle: Beg)
				(flower3 setCycle: Beg)
				(flower4 setCycle: Beg flower1)
				(snap setCycle: Beg)
			)
		)
	)

	(method (notify)
		(flower1 view: 4851 stopUpd:)
		(flower2 view: 4851 stopUpd:)
		(flower3 view: 4851 stopUpd:)
		(flower4 view: 4851 stopUpd:)
		(UnLoad 128 4852)
		(snap setCycle: 0 stopUpd:)
	)
)

(instance hiw of Actor
	(properties
		view 482
		signal 26624
		cycleSpeed 12
		illegalBits 0
	)

	(method (cue)
		(self setLoop: 1 cycleSpeed: 12 posn: 238 70 stopUpd:)
	)

	(method (init)
		(if (IsFlag 159)
			(self
				setLoop: 4
				cel: 5
				posn: 274 57
				cycleSpeed: 6
				setCycle: Beg self
			)
			(gGlobalSound4 number: 483 setLoop: 1 play:)
		else
			(self setLoop: 1 posn: 283 46 stopUpd:)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 159)
					(gMessager say: 21 1 7 1) ; "Alexander must have startled the hole-in-the-wall, because it's taken cover behind the wallflowers."
				else
					(wallFlowerDance register: 1)
					(= local4 1)
					(proc482_2)
				)
			)
			(5 ; Do
				(cond
					((== (gCurRoom script:) wallFlowerDance)
						(proc482_1)
					)
					((IsFlag 159)
						((ScriptID 40 0) grabAtHidingHole: 1) ; rWonder
						(gEgo setScript: walkToHoleScr)
					)
					(else
						(SetFlag 159)
						(if (gSounds contains: danceMusic)
							(danceMusic fade: 10 10 0 1)
						)
						(proc482_0)
					)
				)
			)
			(2 ; Talk
				(if (IsFlag 159)
					(gMessager say: 21 2 7 0) ; "Don't be afraid. I won't hurt you."
				else
					(gMessager say: 21 2 8 0) ; "What a curious little black spot!"
				)
			)
			(else
				(gMessager say: 21 0 0 1) ; "Why would Alexander want to use that on the hole in the garden wall?"
			)
		)
	)
)

(instance gates of Prop
	(properties
		x 142
		y 76
		noun 15
		approachX 148
		approachY 106
		view 4801
		cycleSpeed 12
	)

	(method (init)
		(self approachVerbs: 2 0) ; Talk
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gCurRoom setScript: thruGate)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance snap of Prop
	(properties
		x 277
		y 129
		noun 11
		view 4801
		loop 1
		priority 8
		signal 26640
		cycleSpeed 1
	)

	(method (init)
		(self stopUpd:)
		(super init:)
	)

	(method (cue)
		(self setCycle: 0 cel: 0)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(super doVerb: theVerb &rest)
			)
			(5 ; Do
				((ScriptID 480 5) register: 1) ; wallFlowerDance
				(gEgo setScript: snappy 0 5)
			)
			(2 ; Talk
				((ScriptID 480 5) register: 1) ; wallFlowerDance
				(gEgo setScript: talkToSnaps)
			)
			(else
				((ScriptID 480 5) register: 1) ; wallFlowerDance
				(gEgo setScript: snappy 0 0)
			)
		)
	)
)

(instance myBottle of Prop
	(properties
		view 4861
		signal 16400
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(proc481_0)
			)
			(43 ; huntersLamp
				(gMessager say: 9 43 17 1) ; "That baby has nothing to offer Alexander for that hunter's lamp."
			)
			(else
				(brat1 doVerb: theVerb)
			)
		)
	)

	(method (init)
		(self setCycle: RandCycle)
		((ScriptID 40 0) babyFed: 1) ; rWonder
		(super init:)
	)
)

(instance drinkBottle of View
	(properties
		x 240
		y 156
		z 20
		noun 8
		approachX 215
		approachY 155
		view 4811
		loop 4
		priority 12
		signal 26640
	)

	(method (init)
		(self stopUpd: approachVerbs: 0 2 1) ; Talk, Look
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame givePoints: 1)
				(proc483_0 0)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance myTeaCup of View
	(properties
		x 305
		y 86
		z 22
		noun 22
		view 4801
		loop 2
		priority 2
		signal 26640
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(gGame givePoints: 1)
				(proc483_0 1)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rotTomato of View
	(properties
		x 132
		y 152
		noun 6
		approachX 180
		approachY 160
		view 4801
		loop 3
		priority 12
		signal 26640
	)

	(method (init)
		(self approachVerbs: 2 1 0 stopUpd:) ; Talk, Look
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if ((ScriptID 40 0) tomoTalk:) ; rWonder
					(gMessager say: 6 1 12 1) ; "Rotten Tomato is looking awfully grumpy and put out. He doesn't seem to be very happy rotting in the nice, clean garden."
				else
					(myConv
						add: -1 6 1 11 1 ; "Alexander takes a close look at the tomato on the ground. It appears to be darker than those on the vines."
						add: -1 6 1 11 2 ; "Whaddaya starin' at there, boy! Go away, ya rootless thing, ya."
						add: -1 6 1 11 3 ; "Yup. That tomato is definitely rotten!"
						init:
					)
				)
			)
			(2 ; Talk
				(if ((ScriptID 40 0) tomoTalk:) ; rWonder
					(gMessager say: 6 2 28 1) ; "Rotten Tomato is rather put out with Alexander and won't pay attention to anything he says."
				else
					((ScriptID 40 0) tomoTalk: 1) ; rWonder
					(myConv
						add: -1 6 2 27 1 ; "How did you manage to fall off the vine, Mr. Tomato?"
						add: -1 6 2 27 2 ; "(CRANKY, GRUMPY) Whaddya think? I'm old. I'm rotten. Leave me alone!"
						add: -1 6 2 27 3 ; "If you say so."
						add: -1 6 2 27 4 ; "After all, you're just gonna let me sit here and rot on this dry ground like everybody else, aren't ya?"
						add: -1 6 2 27 5 ; "Why, I don't know. I suppose...."
						add: -1 6 2 27 6 ; "Ah, never mind! Just go away!"
						init:
					)
				)
			)
			(5 ; Do
				(gEgo get: 49) ; tomato
				(proc483_2 self)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance lettuce of Feature
	(properties
		noun 10
		onMeCheck 256
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (IsFlag 84)
					(gMessager say: 10 1 29 0) ; "A patch of iceberg lettuce grows in the garden."
				else
					(SetFlag 84)
					(gMessager say: 10 1 30 0) ; "Is that lettuce growing in the garden? It looks a little chilled."
				)
			)
			(5 ; Do
				(cond
					((not (gEgo has: 21)) ; lettuce
						(proc483_3 self)
					)
					((< (- (GetTime 1) global157) 150) ; SysTime12
						(gMessager say: 10 5 32 1) ; "Alexander already has a frozen head of lettuce."
					)
					((< (- (GetTime 1) global157) 300) ; SysTime12
						(proc483_3 self)
					)
					(else
						(proc483_3 self)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance chair of Feature
	(properties
		noun 17
		onMeCheck 16384
	)
)

(instance flower1 of Prop
	(properties
		x 215
		y 91
		noun 5
		approachX 225
		approachY 95
		view 4851
		signal 30720
		cycleSpeed 7
	)

	(method (cue)
		(snap setCycle: 0 stopUpd:)
		(flower1 view: 4852)
		(flower2 view: 4852)
		(flower3 view: 4852)
		(flower4 view: 4852)
	)

	(method (init)
		(self approachVerbs: 5) ; Do
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(31 ; flute
				(if ((ScriptID 40 0) flowerDance:) ; rWonder
					(gMessager say: 5 5 10 1) ; "The dancing wallflowers are oblivious to Alexander."
				else
					(gCurRoom setScript: wallFlowerDance)
				)
			)
			(1 ; Look
				(super doVerb: theVerb &rest)
			)
			(2 ; Talk
				(super doVerb: theVerb &rest)
			)
			(5 ; Do
				(if ((ScriptID 40 0) flowerDance:) ; rWonder
					(gMessager say: 5 5 10 1) ; "The dancing wallflowers are oblivious to Alexander."
				else
					(super doVerb: theVerb &rest)
				)
			)
			(else
				(self setScript: doFlowerInv)
			)
		)
	)
)

(instance doFlowerInv of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 180 106 self)
			)
			(1
				(gEgo setHeading: 90)
				(= cycles 8)
			)
			(2
				(gMessager say: 5 0 0 0 self) ; "Would you ladies be at all interested in this?"
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance flower2 of Prop
	(properties
		x 229
		y 93
		noun 5
		approachX 225
		approachY 95
		view 4851
		loop 1
		signal 30720
		cycleSpeed 7
	)

	(method (init)
		(self approachVerbs: 5) ; Do
		(super init:)
	)

	(method (doVerb theVerb)
		(flower1 doVerb: theVerb &rest)
	)
)

(instance flower3 of Prop
	(properties
		x 252
		y 84
		noun 5
		approachX 225
		approachY 95
		view 4851
		loop 2
		signal 30720
		cycleSpeed 7
	)

	(method (init)
		(self approachVerbs: 5) ; Do
		(super init:)
	)

	(method (doVerb theVerb)
		(flower1 doVerb: theVerb &rest)
	)
)

(instance flower4 of Prop
	(properties
		x 253
		y 85
		noun 5
		approachX 225
		approachY 95
		view 4851
		loop 3
		signal 30720
		cycleSpeed 7
	)

	(method (init)
		(self approachVerbs: 5) ; Do
		(super init:)
	)

	(method (doVerb theVerb)
		(flower1 doVerb: theVerb &rest)
	)
)

(instance table of Feature
	(properties
		x 250
		y 150
		noun 14
		nsTop 133
		nsLeft 231
		nsBottom 147
		nsRight 274
	)
)

(instance chokers of Feature
	(properties
		x 60
		y 90
		noun 13
		onMeCheck 64
		approachX 173
		approachY 109
	)

	(method (init)
		(self approachVerbs: 0)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(proc483_4 5)
			)
			(2 ; Talk
				((ScriptID 480 5) register: 1) ; wallFlowerDance
				(gEgo setScript: talkToVines 0 self)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sourGrapes of Feature
	(properties
		x 16
		y 85
		noun 12
		onMeCheck 32
		approachX 16
		approachY 95
	)

	(method (init)
		(self approachVerbs: 0)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				((ScriptID 480 5) register: 1) ; wallFlowerDance
				(gEgo setScript: talkToVines 0 self)
			)
			(5 ; Do
				(proc483_1 self)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance greenMaters of Feature
	(properties
		x 120
		y 150
		noun 7
		onMeCheck 4224
		approachX 180
		approachY 160
	)

	(method (init)
		(self approachVerbs: 2) ; Talk
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(myConv add: -1 7 2 0 1 add: -1 7 2 0 2 init:) ; "Good day, Tomato Vines.", "(SWEET AND SUNNY) GOOD MORNING!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pathway of Feature
	(properties
		noun 18
		onMeCheck 2
	)
)

(instance pillars of Feature
	(properties
		noun 19
		onMeCheck 8
	)
)

(instance wall of Feature
	(properties
		noun 16
		onMeCheck 4
	)
)

(class Brat of Feature
	(properties
		bottleNum 0
		walkToX 0
		walkToY 0
		stoopX 0
		stoopY 0
	)

	(method (init)
		(self approachVerbs: 2) ; Talk
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(14 ; potion
				(gMessager say: 9 14 0 1 0 480) ; "Alexander shouldn't give that bottle of potion to the baby's tears! Who knows WHAT the potion will do?"
			)
			(5 ; Do
				(cond
					((== ((ScriptID 40 0) bottleSucker:) (self bottleNum:)) ; rWonder
						((ScriptID 480 5) register: 1) ; wallFlowerDance
						(gEgo setScript: (ScriptID 481 2) 0 myBottle) ; takeBottleAway
					)
					((== ((ScriptID 40 0) lampMsg:) 15) ; rWonder
						(gMessager say: 9 5 15 1 0 480) ; "Alexander doesn't want to pick the baby's tears! They may not be done growing!"
					)
					(else
						(gMessager say: 9 5 18 1 0 480) ; "As much as Alexander might wish to comfort the crying babies, he feels a little awkward about picking them up. He's rather new at this."
					)
				)
			)
			(43 ; huntersLamp
				(cond
					((== ((ScriptID 40 0) bottleSucker:) (self bottleNum:)) ; rWonder
						(gMessager say: 9 43 17 1 0 480) ; "That baby has nothing to offer Alexander for that hunter's lamp."
					)
					((not (IsFlag 77))
						(gMessager say: 9 43 21 1 0 480) ; "Alexander has no reason to gather tears in that lamp."
					)
					((or (& global161 $0004) (IsFlag 144))
						(gMessager say: 9 43 20 1 0 480) ; "Alexander has already collected some tears. He doesn't need any more."
					)
					((& global161 $0001)
						(gMessager say: 9 43 13 1 0 480) ; "The hunter's lamp is full to the brim with fountain water. There's not even room enough for a few tears in there!"
					)
					((& global161 $0002)
						(proc481_3 (self bottleNum:))
					)
					((== ((ScriptID 40 0) lampMsg:) 15) ; rWonder
						(gMessager say: 9 43 15 1 0 480) ; "The baby's tears don't have anything to offer Alexander for that hunter's lamp--at least, not at the moment."
					)
					(else
						(proc481_3 (self bottleNum:))
					)
				)
			)
			(1 ; Look
				(if (== ((ScriptID 40 0) lampMsg:) 15) ; rWonder
					(gMessager say: 9 1 ((ScriptID 40 0) lampMsg:) 1 0 480) ; rWonder
				else
					(gMessager say: 9 1 16 1 0 480) ; "One of the babies is sucking happily on a bottle of milk while the others are spilling copious tears over their lack of the same."
				)
			)
			(2 ; Talk
				(if (== ((ScriptID 40 0) lampMsg:) 15) ; rWonder
					(gMessager say: 9 2 ((ScriptID 40 0) lampMsg:) 0 0 480) ; rWonder
				else
					(gMessager say: 9 2 16 0 0 480) ; "Alexander can't make himself heard over the wailing of the baby's tears."
				)
			)
			(62 ; milk
				(gEgo put: 22 480) ; milk
				(proc481_1 (self bottleNum:))
			)
			(44 ; teaCup
				(cond
					((== ((ScriptID 40 0) bottleSucker:) (self bottleNum:)) ; rWonder
						(gMessager say: 9 44 17 1 0 480) ; "That baby has nothing to offer Alexander for that teacup."
					)
					((not (IsFlag 77))
						(gMessager say: 9 44 21 1 0 480) ; "There's no reason to collect the baby's tears' tears in that teacup."
					)
					(else
						(gMessager say: 9 44 22 1 0 480) ; "Why would Alexander want to put tears in a teaCUP?"
					)
				)
			)
			(24 ; sacredWater
				(if (== ((ScriptID 40 0) lampMsg:) 15) ; rWonder
					(gMessager say: 9 24 15 1 0 480) ; "The baby's tears don't want the Oracle's sacred water."
				else
					(gMessager say: 9 24 16 1 0 480) ; "The Oracle's vial is already full and won't hold anything more--not even a few baby's tears."
				)
			)
			(else
				(if (OneOf theVerb 57 58 59 60 96) ; fakeLamp6, fakeLamp4, fakeLamp3, fakeLamp2, fakeLamp1
					(if (== ((ScriptID 40 0) bottleSucker:) (self bottleNum:)) ; rWonder
						(gMessager say: 9 56 17 0 0 480) ; "That baby has nothing to offer Alexander for that lamp."
					else
						(gMessager say: 9 56 ((ScriptID 40 0) lampMsg:) 0 0 480) ; rWonder
					)
				else
					((ScriptID 480 5) register: 1) ; wallFlowerDance
					(gEgo setScript: inventOnBaby 0 self)
				)
			)
		)
	)
)

(instance inventOnBaby of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setMotion:
						PolyPath
						(register walkToX:)
						(register walkToY:)
						self
				)
			)
			(1
				(= temp0
					(GetAngle
						(gEgo x:)
						(gEgo y:)
						(register x:)
						(register y:)
					)
				)
				(gEgo setHeading: temp0 self)
			)
			(2
				(= cycles 6)
			)
			(3
				(if (== ((ScriptID 40 0) lampMsg:) 15) ; rWonder
					(gMessager say: 9 0 ((ScriptID 40 0) lampMsg:) 0 self 480) ; rWonder
				else
					(gMessager say: 9 0 16 0 self 480) ; "Would you babies be interested in this?"
				)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance brat1 of Brat
	(properties
		x 58
		y 152
		noun 9
		onMeCheck 512
		approachX 95
		approachY 159
		bottleNum 1
		walkToX 95
		walkToY 159
		stoopX 83
		stoopY 162
	)
)

(instance brat2 of Brat
	(properties
		x 10
		y 147
		noun 9
		onMeCheck 16
		approachX 55
		approachY 153
		bottleNum 2
		walkToX 55
		walkToY 153
		stoopX 36
		stoopY 157
	)
)

(instance brat3 of Brat
	(properties
		x 39
		y 122
		noun 9
		onMeCheck 1024
		approachX 81
		approachY 131
		bottleNum 3
		walkToX 81
		walkToY 131
		stoopX 63
		stoopY 135
	)
)

(instance brat4 of Brat
	(properties
		x 19
		y 107
		noun 9
		onMeCheck 2048
		approachX 62
		approachY 116
		bottleNum 4
		walkToX 62
		walkToY 116
		stoopX 43
		stoopY 119
	)
)

(instance egoEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== gPrevRoomNum 490)
					(gEgo
						loop: 2
						posn: 139 100
						setMotion: MoveTo 139 107 self
					)
				else
					(gEgo
						setLoop: 6
						posn: 51 245
						setMotion: PolyPath 108 185 self
					)
				)
			)
			(1
				(if (== gPrevRoomNum 490)
					(gates cycleSpeed: 4 setCycle: Beg self)
				else
					(self cue:)
				)
			)
			(2
				(if (== gPrevRoomNum 490)
					(gGlobalSound4 number: 907 setLoop: 1 play:)
					(gates addToPic:)
				)
				(gGame handsOn:)
				(gEgo reset:)
				(self dispose:)
			)
		)
	)
)

(instance egoExits of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo (- (gEgo x:) 55) 240 self)
			)
			(1
				(gGame handsOn:)
				(gCurRoom newRoom: 470)
			)
		)
	)
)

(instance thruGate of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 160 106 self)
			)
			(1
				(gEgo setHeading: 335)
				(= ticks 8)
			)
			(2
				(gEgo
					normal: 0
					view: 481
					cel: 0
					setLoop: 1
					posn: 142 107
					cycleSpeed: 8
					setCycle: CT 1 1 self
				)
				(UnLoad 128 900)
			)
			(3
				(gates dispose:)
				(gCurRoom drawPic: 480 (if global169 15 else 100))
				(if (== ((gInventory at: 49) owner:) gCurRoomNum) ; tomato
					(rotTomato addToPic:)
				)
				(gGlobalSound4 number: 906 setLoop: 1 play:)
				(gEgo setCycle: End self)
				(gates signal: 26624 cycleSpeed: 3 init: setCycle: End)
			)
			(4
				(gCurRoom newRoom: 490)
			)
		)
	)
)

(instance shyFlowers of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: 0)
				(= cycles 10)
			)
			(1
				(gGlobalSound3 number: 484 setLoop: 1 play: self)
				(flower1 view: 4852 cel: 2 setCycle: CT 6 1)
				(flower2 view: 4852 cel: 2 setCycle: CT 6 1)
				(flower3 view: 4852 cel: 2 setCycle: CT 6 1)
				(flower4 view: 4852 cel: 2 setCycle: CT 6 1)
			)
			(2
				(Face gEgo snap)
				(snap setCycle: Fwd)
				(gGlobalSound4 number: 482 setLoop: 2 play: self)
			)
			(3
				(snap setCycle: 0 cel: 0 stopUpd:)
				(= cycles 4)
			)
			(4
				(if (== ((ScriptID 40 0) grabAtHidingHole:) 1) ; rWonder
					((ScriptID 40 0) grabAtHidingHole: 0) ; rWonder
					(gMessager say: 21 5 9 1 self) ; "The wallflowers, overcome with shyness at Alexander's approach, cluster together and cover the hole-in-the-wall. Alexander can't get it."
				else
					(gMessager say: 5 3 0 1 self) ; "Zounds! Those wallflowers sure are shy, and the snapdragons are awfully protective of them! Alexander can't even get close to the wallflowers without causing quite a stir!"
				)
			)
			(5
				(gEgo setMotion: PolyPath 197 116 self)
				(flower1 view: 4851 stopUpd:)
				(flower2 view: 4851 stopUpd:)
				(flower3 view: 4851 stopUpd:)
				(flower4 view: 4851 stopUpd:)
				(UnLoad 128 4852)
				(snap setCycle: Beg)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance hanging of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: 0)
				(= cycles 2)
			)
			(1
				(proc483_4 3)
			)
		)
	)
)

(instance stepOnSnaps of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: 0)
				(Face gEgo snap)
				(= cycles 10)
			)
			(1
				(gGlobalSound4 number: 482 setLoop: 1 play: self)
				(snap setCycle: Fwd)
			)
			(2
				(snap setCycle: 0 cel: 0 stopUpd:)
				(= cycles 4)
			)
			(3
				(gMessager say: 11 3 0 1 self) ; "Those snapdragons don't like Alexander getting so close!"
			)
			(4
				(gEgo
					setLoop: (gEgo cel:)
					setCycle: Rev
					setMotion: PolyPath (- (gEgo x:) 5) (gEgo y:) self
				)
			)
			(5
				(gEgo setCycle: Walk setLoop: -1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance coverThatButtScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: 0)
				(gGlobalSound4 number: 482 setLoop: 1 play: self)
				(snap setCycle: Fwd)
				(= ticks 12)
			)
			(1
				(gEgo
					normal: 0
					setSpeed: 6
					view: 483
					loop: 0
					cel: 0
					posn: (- (gEgo x:) 13) (+ (gEgo y:) 2)
					setCycle: End self
				)
			)
			(2
				(= cycles 2)
			)
			(3
				(gEgo reset: 0 posn: (- (gEgo x:) 13) (- (gEgo y:) 6))
				(= cycles 2)
			)
			(4
				(snap setCycle: 0 cel: 0 stopUpd:)
				(= cycles 4)
			)
			(5
				(gMessager say: 11 3 0 1 self) ; "Those snapdragons don't like Alexander getting so close!"
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance talkToVines of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if
					(or
						(> (gEgo distanceTo: register) 130)
						(> (gEgo y:) 115)
					)
					(gEgo setMotion: PolyPath 173 109 self)
				else
					(self cue:)
				)
			)
			(1
				(Face gEgo register)
				(= cycles 8)
			)
			(2
				(switch register
					(chokers
						(if ((ScriptID 40 0) vineTalk:) ; rWonder
							(gMessager say: 13 2 26 1 self) ; "We don't FEel like talking! We just want a HUG!"
						else
							((ScriptID 40 0) vineTalk: 1) ; rWonder
							(myConv
								add: -1 13 2 25 1 ; "What curious clinging vines are on this wall!"
								add: -1 13 2 25 2 ; "(VERY WHINY) WE know we're fascinating! <whine> But no one ever VIsits us! WE'RE LOnely!"
								add: -1 13 2 25 3 ; "That's too bad."
								add: -1 13 2 25 4 ; "WE just want to be LIKed! WE just want to be HUGged!"
								add: -1 13 2 25 5 ; "WE've been clinging to this WAll! But he's gotten boring!"
								add: -1 13 2 25 6 ; "I see. Perhaps you should find a new place."
								add: -1 13 2 25 7 ; "Don't be STUpid! We're clinging vines! We're NOT particularly MObile!"
								add: -1 13 2 25 8 ; "No, I don't suppose so. Well, good luck."
								init: self
							)
						)
					)
					(else
						(if ((ScriptID 40 0) grapeTalk:) ; rWonder
							(gMessager say: 12 2 24 1 self) ; "The sour grapes seem to be snubbing Alexander now."
						else
							(myConv
								add: -1 12 2 23 1 ; "Alexander addresses the grapes...."
								add: -1 12 2 23 2 ; "Why are you so sour, if you don't mind my asking?"
								add: -1 12 2 23 3 ; "Well! We'll tell you...."
								add: -1 12 2 23 4 ; "How would you like to have the possibility of being made into wine hanging over your head?"
								add: -1 12 2 23 5 ; "And then there's our neighbors, the clinging vines? All they do all day is whine about the ivy league social climbers that never call!"
								add: -1 12 2 23 6 ; "It's really just no fun at all!"
								add: -1 12 2 23 7 ; "Hmmm, that's too bad. I hope things start looking up."
								add: -1 12 2 23 8 ; "Yeah? <Sniff> Thanks a lot!"
								init: self
							)
						)
					)
				)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance snappy of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (== register 5)
					(gMessager say: 11 5 0 1 self) ; "Alexander approaches the snapdragons."
				else
					(self cue:)
				)
			)
			(1
				(gEgo setMotion: PolyPath 220 130 self)
			)
			(2
				(gEgo setHeading: 90)
				(= cycles 6)
			)
			(3
				(if (== register 5)
					(self cue:)
				else
					(gMessager say: 11 0 0 1 self) ; "Would you lovely flowers be interested in this?"
				)
			)
			(4
				(gGlobalSound4 number: 482 setLoop: 1 play: self)
				(snap setCycle: Fwd)
			)
			(5
				(snap setCycle: 0 cel: 0 stopUpd:)
				(= cycles 4)
			)
			(6
				(if (== register 5)
					(gMessager say: 11 5 0 2 self) ; "Those unfriendly snapdragons don't want Alexander anywhere near them."
				else
					(gMessager say: 11 0 0 2 self) ; "Guess not!"
				)
			)
			(7
				(gEgo
					setLoop: (gEgo cel:)
					setCycle: Rev
					setMotion: PolyPath (- (gEgo x:) 15) (gEgo y:) self
				)
			)
			(8
				(gEgo setCycle: Walk setLoop: -1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance danceMusic of Sound
	(properties
		number 486
	)
)

(instance pauseForMusic of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 5)
			)
			(1
				(gGlobalSound number: 480 setLoop: -1 play:)
				(self dispose:)
			)
		)
	)
)

(instance fluteVerb of Actions
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(31 ; flute
				(gCurRoom setScript: wallFlowerDance)
				(return 1)
			)
			(else
				(return 0)
			)
		)
	)
)

(instance glint of Prop
	(properties
		x 303
		y 63
		view 902
		signal 26624
		cycleSpeed 1
	)

	(method (cue)
		(super cue:)
		(switch (++ local2)
			(1
				(if (not (gCast contains: myTeaCup))
					(self dispose:)
				else
					(self show: cel: 0 setLoop: (Random 0 1) setCycle: End self)
				)
			)
			(2
				(self hide:)
				(= local2 0)
				(glintTimer setReal: self (Random 3 6))
			)
		)
	)
)

(instance glintTimer of Timer
	(properties)
)

(instance roomTimer of Timer
	(properties)
)

(instance wallFlowerDance of Script
	(properties)

	(method (init)
		(super init: &rest)
		(= local4 0)
		(if (not (IsFlag 117))
			(SetFlag 117)
			(gGame givePoints: 2)
		)
		(gWalkHandler addToFront: self)
		(gMouseDownHandler addToFront: self)
		(gKeyDownHandler addToFront: self)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(if local3
			(proc481_7)
			(myBottle setCycle: RandCycle)
		)
		(gGlobalSound number: 480 setLoop: -1 play:)
		(danceMusic prevSignal: 0)
		(gCurRoom cue: 0)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (OneOf (event type:) evMOUSEBUTTON evMOUSERELEASE evKEYBOARD evJOYDOWN)
			(cond
				((== state 9)
					(if gModelessDialog
						(gModelessDialog dispose:)
					)
					(self cue:)
					(event localize:)
					(event claimed: 1)
				)
				((and (== state 10) (User controls:) (& (event type:) evMOVE))
					(event claimed: 1)
					(self cue:)
				)
				(else
					(event claimed: 0)
				)
			)
		)
		(event claimed:)
	)

	(method (doit)
		(cond
			((== (gEgo edgeHit:) 3)
				(gCurRoom setScript: egoExits)
			)
			((and register (== state 10))
				(self cue:)
			)
			((and (> state 6) (< state 11) (== (danceMusic prevSignal:) -1))
				(danceMusic prevSignal: 0)
				(= state 10)
				(gGame handsOn:)
				(self cue:)
			)
			((== (danceMusic prevSignal:) 20)
				(self cue:)
				(danceMusic prevSignal: 0)
				(= local1 7)
				(flower1 cycleSpeed: (- (flower1 cycleSpeed:) 1))
				(flower2 cycleSpeed: (- (flower2 cycleSpeed:) 1))
				(flower3 cycleSpeed: (- (flower3 cycleSpeed:) 1))
				(flower4 cycleSpeed: (- (flower4 cycleSpeed:) 1))
				(snap cycleSpeed: (- (snap cycleSpeed:) 1))
			)
			((and (== (danceMusic prevSignal:) 10) (<= state 11) (>= state 6))
				(danceMusic prevSignal: 0)
				(snap setCycle: Osc local1 snap)
			)
		)
		(super doit:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= local1 9)
				(gEgo
					ignoreActors: 1
					illegalBits: 0
					setMotion: PolyPath 190 110 self
				)
			)
			(1
				(if ((ScriptID 40 0) bottleSucker:) ; rWonder
					(proc481_6)
					(myBottle setCycle: 0)
					(= local3 1)
				)
				(gEgo setHeading: 45)
				(= cycles 4)
			)
			(2
				(gMessager say: 5 31 0 1 self) ; "May I have this dance?"
			)
			(3
				(gMessager say: 5 31 0 2 self) ; "Oh, my! Tee, hee!"
			)
			(4
				(= register 0)
				(if
					(and
						(gCast contains: hiw)
						(IsFlag 159)
						(!= (hiw x:) 283)
						(!= (hiw y:) 46)
					)
					(hiw setLoop: 1 setCycle: Walk setMotion: MoveTo 238 70)
				)
				((ScriptID 40 0) flowerDance: 1) ; rWonder
				(flower1 view: 4852 cel: 2 setCycle: Fwd)
				(flower2 view: 4852 cel: 2 setCycle: Fwd)
				(flower3 view: 4852 cel: 6 setCycle: Fwd)
				(flower4 view: 4852 cel: 6 setCycle: Fwd)
				(if
					(and
						(== ((gInventory at: 18) owner:) gCurRoomNum) ; holeInTheWall
						(IsFlag 159)
					)
					(gGlobalSound4 number: 483 setLoop: 1 play:)
					(hiw setLoop: 5 setCycle: Walk setMotion: MoveTo 259 49)
				)
				(= ticks 6)
			)
			(5
				(if (== (hiw loop:) 5)
					(gGlobalSound4 stop:)
					(hiw setLoop: 1)
				)
				(gEgo
					view: 920
					setLoop: 0
					cel: 0
					posn: (gEgo x:) (+ (gEgo y:) 2)
					normal: 0
					cycleSpeed: 6
				)
				(= ticks 6)
			)
			(6
				(gGlobalSound stop:)
				(danceMusic number: 486 setLoop: 1 flags: 0 play:)
				(gEgo setCycle: Fwd)
			)
			(7
				(gEgo setCycle: End self)
			)
			(8
				(gEgo reset: 0 posn: (gEgo x:) (- (gEgo y:) 2))
				(= cycles 6)
			)
			(9
				(danceMusic flags: 1)
				(if (& gMsgType $0002)
					(gMessager say: 5 31 0 3 self) ; "Alexander stops playing the flute, but the wallflowers and snapdragons continue to dance, caught up in the music and oblivious to everything around them."
				else
					(Print
						font: 4
						addText: 5 31 0 3 ; "Alexander stops playing the flute, but the wallflowers and snapdragons continue to dance, caught up in the music and oblivious to everything around them."
						posn: 10 6
						width: 289
						init:
					)
					(= ticks 12)
				)
			)
			(10
				(gGame handsOn:)
			)
			(11
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(danceMusic fade:)
				(= seconds 3)
			)
			(12
				((ScriptID 40 0) flowerDance: 0) ; rWonder
				(if (and (gCast contains: hiw) (IsFlag 159) (not local4))
					(hiw setLoop: 1 setCycle: Walk setMotion: MoveTo 238 70)
				)
				(self dispose:)
				(flower1 view: 4851 stopUpd:)
				(flower2 view: 4851 stopUpd:)
				(flower3 view: 4851 stopUpd:)
				(flower4 view: 4851 stopUpd:)
				(snap cel: 0 stopUpd:)
			)
		)
	)
)

(instance walkToHoleScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (and (!= (hiw x:) 238) (!= (hiw y:) 70))
					(hiw setLoop: 5 setCycle: Walk setMotion: MoveTo 238 70 hiw)
				)
				(gEgo setMotion: PolyPath 242 93 self)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance talkToSnaps of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 198 130 self)
			)
			(1
				(gEgo setHeading: 90)
				(= cycles 8)
			)
			(2
				(gMessager say: 11 2 0 1 self) ; "Good day, Snapdragons."
			)
			(3
				(gGlobalSound4 number: 482 setLoop: 1 play: self)
				(snap setCycle: Fwd)
			)
			(4
				(snap setCycle: 0 cel: 0 stopUpd:)
				(= cycles 3)
			)
			(5
				(gMessager say: 11 2 0 2 self) ; "The snapdragons don't seem inclined to communicate with anyone."
			)
			(6
				(gGame handsOn:)
				(snap setCycle: 0 cel: 0 stopUpd:)
				(self dispose:)
			)
		)
	)
)

