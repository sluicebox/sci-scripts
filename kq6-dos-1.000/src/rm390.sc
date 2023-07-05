;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 390)
(include sci.sh)
(use Main)
(use KQ6Room)
(use n913)
(use Print)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use StopWalk)
(use SmoothLooper)
(use Motion)
(use Actor)
(use System)

(public
	rm390 0
)

(local
	local0
	local1
	[local2 16] = [37 122 85 157 246 157 286 141 276 139 241 151 89 151 45 121]
	[local18 16] = [33 137 75 159 207 149 255 122 233 122 203 141 84 152 48 134]
)

(instance rm390 of KQ6Room
	(properties
		noun 3
		picture 390
		horizon 0
	)

	(method (init)
		(= local0 10)
		(gCurRoom addObstacle: (roomPoly points: @local2 yourself:))
		(Palette palSET_INTENSITY 64 223 60)
		(super init: &rest)
		(LoadMany rsVIEW 3931 390 3903 3904 391 392 393)
		(gFeatures
			add: opening floor westEnd eastEnd mintHole
			eachElementDo: #init
		)
		(gGlobalSound2 number: 390 setLoop: -1 play:)
		(gCurRoom setScript: enterScr)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 3 1 local0 1)
			)
			(5 ; Do
				(if (== local0 10)
					(gMessager say: 3 5 local0 1) ; "Since it's so dark, Alexander can't do much inside the cave."
				else
					(super doVerb: theVerb &rest)
				)
			)
			(2 ; Talk
				(if (== local0 10)
					(self setScript: caveTalkScr)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(20 ; tinderBox
				(if (== local0 10)
					(gCurRoom setScript: lightItUp)
				else
					(gMessager say: 2 20 local0 1)
				)
			)
			(else
				(if (== local0 10)
					(gMessager say: 3 0 local0 1) ; "That won't help Alexander in the dark cave."
				else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)

	(method (doit)
		(Wait 3)
		(super doit: &rest)
	)

	(method (dispose)
		(Palette palSET_INTENSITY 64 223 100)
		(gGlobalSound2 fade: 0 10 10)
		(DisposeScript 968)
		(super dispose:)
	)
)

(instance roomPoly of Polygon
	(properties
		size 8
		type PContainedAccess
	)
)

(instance mySmooper of SmoothLooper
	(properties
		cycleSpeed 6
		vChangeDir 3931
	)
)

(instance floor of Feature
	(properties
		noun 13
		onMeCheck 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (== local0 10)
					(gMessager say: 12 1 10 1) ; "Alexander can't see much of anything in the dark cave."
				else
					(gMessager say: 13 1 11 1) ; "The floor of the cave is covered with a fine, dusty dirt."
				)
			)
			(5 ; Do
				(if (== local0 10)
					(gMessager say: 12 5 10 1) ; "Alexander can't do much of anything in the dark cave."
				else
					(gMessager say: 13 5 11 1) ; "Alexander sees nothing on the floor of the cave except dirt."
				)
			)
			(else
				(gCurRoom doVerb: theVerb)
			)
		)
	)
)

(instance toCave1 of Feature
	(properties
		noun 11
		onMeCheck 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 11 1 local0 1)
			)
			(5 ; Do
				(gCurRoom setScript: crawl2Cave1)
			)
			(2 ; Talk
				(rm390 doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance opening of Feature
	(properties
		noun 11
		onMeCheck 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 11 1 local0 1)
			)
			(5 ; Do
				(gCurRoom setScript: leaveHere)
			)
			(2 ; Talk
				(rm390 doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance mintHole of Feature
	(properties
		noun 12
		onMeCheck 2
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 12 1 local0 1)
			)
			(2 ; Talk
				(rm390 doVerb: theVerb &rest)
			)
			(5 ; Do
				(if (== local0 11)
					(gCurRoom setScript: crawl2Cave2)
				else
					(gMessager say: 12 5 10 1) ; "Alexander can't do much of anything in the dark cave."
				)
			)
			(else
				(if (== local0 11)
					(gMessager say: 12 0 11 1) ; "Alexander doesn't need to use that on the opening in the rock."
				else
					(gMessager say: 3 0 10 1) ; "That won't help Alexander in the dark cave."
				)
			)
		)
	)
)

(instance westEnd of Feature
	(properties
		onMeCheck 32
	)

	(method (init)
		(gWalkHandler add: self)
		(super init:)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 3) ; Walk
			(gMessager say: 1 0 1 1) ; "Dead end! Nothing that way!"
		else
			(rm390 doVerb: theVerb &rest)
		)
	)
)

(instance eastEnd of Feature
	(properties
		onMeCheck 64
	)

	(method (init)
		(gWalkHandler add: self)
		(super init:)
	)

	(method (dispose)
		(gWalkHandler delete: self)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(if (== theVerb 3) ; Walk
			(gMessager say: 1 0 4 1) ; "There's no going that direction!"
		else
			(rm390 doVerb: theVerb &rest)
		)
	)
)

(instance pepperBush of View
	(properties
		x 277
		y 94
		noun 7
		approachX 238
		approachY 127
		view 390
		loop 1
		cel 2
		priority 2
		signal 20496
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (not (gEgo has: 31)) ; peppermint
					(gCurRoom setScript: getLeaf)
				else
					(gMessager say: 7 5 8 1) ; "Alexander already took some peppermint leaves."
				)
			)
			(1 ; Look
				(gMessager say: 7 1 0 1) ; "A plant grows on the grassy ledge. Hmmm. Smells like peppermint!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (init)
		(super init:)
		(self approachVerbs: 1 5) ; Look, Do
	)
)

(instance ledge of View
	(properties
		x 249
		y 103
		noun 14
		view 390
		loop 1
		priority 2
		signal 20496
	)
)

(instance rBlock of View
	(properties
		x 265
		y 103
		noun 3
		onMeCheck 0
		view 390
		priority 1
		signal 16400
	)
)

(instance myHeadingCode of Code
	(properties)

	(method (doit param1 param2)
		(if argc
			(if (> param1 180)
				(= param1 270)
			else
				(= param1 90)
			)
		)
		(if (gEgo looper:)
			((gEgo looper:) doit: gEgo param1 (and (>= argc 2) param2))
		else
			(gEgo heading: param1)
			(DirLoop gEgo param1)
			(if (and (>= argc 2) (IsObject param2))
				(param2 cue: &rest)
			)
		)
		(return param1)
	)
)

(instance caveTalkScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(Print
					font: gUserFont
					posn: -1 15
					addText: 3 2 local0 1
					init: self
				)
			)
			(1
				(gMessager say: 3 2 local0 2 self oneOnly: 0)
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance enterScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gEgo
					init:
					setStep: 5 2
					view: 390
					show:
					setLoop: -1
					setPri: -1
					setSpeed: 6
					normal: 0
					loop: 5
					cel: 4
					posn: 43 123
					setScale: 0
					actions: egoActions
					ignoreActors: 1
				)
				(= cycles 2)
			)
			(2
				(gEgo signal: (| (gEgo signal:) $1000) setCycle: Beg self)
			)
			(3
				(= cycles 2)
			)
			(4
				(gEgo
					view: 3902
					posn: 43 123
					setCycle: StopWalk 3903
					setSpeed: (gEgo currentSpeed:)
					setHeadingCode: myHeadingCode
				)
				(= cycles 2)
			)
			(5
				(gEgo looper: 0)
				(if (not (IsFlag 96))
					(SetFlag 96)
					(gGame givePoints: 1)
				)
				(gMessager say: 1 0 9 1 self) ; "Alexander finds himself in a dark cave."
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance leaveHere of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 55 130 self)
			)
			(1
				(gMessager say: 11 5 13 1 self) ; "Alexander crawls back through the passage to the top of the cliffs."
			)
			(2
				(if (OneOf (gEgo view:) 392 393)
					(gEgo
						view: 391
						loop: 3
						cel: 5
						setSpeed: 6
						setCycle: Beg self
					)
					(Palette palSET_INTENSITY 64 223 60)
				else
					(self cue:)
				)
			)
			(3
				(= cycles 2)
			)
			(4
				(gEgo
					view: 390
					cel: 0
					loop: 6
					normal: 0
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(5
				(gEgo looper: 0 setHeadingCode: 0 hide:)
				(gGame handsOn:)
				(gCurRoom drawPic: 98 -32758)
				(= cycles 6)
			)
			(6
				(gCurRoom newRoom: 340)
				(self dispose:)
			)
		)
	)
)

(instance crawl2Cave2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 253 151 self)
			)
			(1
				(gMessager say: 12 5 11 1 self) ; "Alexander crawls through the opening in the rock."
			)
			(2
				(gEgo
					normal: 0
					view: 391
					loop: 2
					cel: 5
					setSpeed: 6
					looper: 0
					setCycle: Beg self
				)
				(Palette palSET_INTENSITY 64 223 60)
			)
			(3
				(gEgo view: 390 loop: 5 cel: 0 setCycle: End self)
			)
			(4
				(gEgo
					view: 390
					setLoop: 7
					cel: 0
					posn: 247 149
					setCycle: Walk
					setPri: 2
					setMotion: MoveTo 288 135 self
				)
			)
			(5
				(gEgo setLoop: -1 setPri: -1 hide:)
				((gCurRoom obstacles:) delete: roomPoly)
				(gCurRoom drawPic: 98 10)
				(= seconds 2)
			)
			(6
				(= local0 12)
				(gCurRoom
					style: 16394
					drawPic: 390 16394
					addObstacle: (roomPoly points: @local18 yourself:)
				)
				(opening dispose:)
				(mintHole dispose:)
				(pepperBush addToPic:)
				(ledge addToPic:)
				(toCave1 init:)
				(rBlock addToPic:)
				(= cycles 2)
			)
			(7
				(Load rsMESSAGE 390)
				(gEgo
					show:
					posn: 49 138
					view: 3901
					loop: 7
					cel: 4
					setCycle: Beg self
				)
			)
			(8
				(gEgo
					setSpeed: (gEgo currentSpeed:)
					view: 3904
					loop: 0
					posn: 49 138
					setCycle: StopWalk 3905
				)
				(= cycles 10)
			)
			(9
				(gMessager say: 1 0 2 1 self) ; "The lighting in this part of the cave is better. Alexander extinguishes the candle's flame and places it back in his pack."
			)
			(10
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance crawl2Cave1 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: PolyPath 77 149 self)
			)
			(1
				(gMessager say: 11 5 12 1 self) ; "Alexander crawls back into the first room of the cave."
			)
			(2
				(gEgo
					normal: 0
					setSpeed: 6
					view: 3901
					loop: 6
					cel: 0
					posn: 78 147
					setCycle: End self
				)
			)
			(3
				(gEgo
					setLoop: 8
					setCycle: Walk
					setPri: 2
					setMotion: MoveTo 29 133 self
				)
			)
			(4
				((gCurRoom obstacles:) delete: roomPoly)
				(gEgo setPri: -1 setLoop: -1 hide:)
				(rBlock dispose:)
				(toCave1 dispose:)
				(gCurRoom style: 10 drawPic: 98 -32758)
				(= seconds 1)
			)
			(5
				(gCurRoom
					drawPic: 390 100
					addObstacle: (roomPoly points: @local2 yourself:)
				)
				(Palette palSET_INTENSITY 64 223 60)
				(opening init:)
				(mintHole init:)
				(= cycles 2)
			)
			(6
				(gEgo show: view: 390 loop: 6 posn: 270 142 cel: 4)
				(= ticks 15)
			)
			(7
				(gEgo setCycle: Beg self)
			)
			(8
				(= cycles 2)
			)
			(9
				(gEgo
					view: 3902
					loop: 1
					setCycle: StopWalk 3903
					setSpeed: (gEgo currentSpeed:)
				)
				(= cycles 6)
			)
			(10
				(gMessager say: 1 0 3 1 self) ; "Alexander can't see a thing."
			)
			(11
				(gGame handsOn:)
				(= local0 10)
				(self dispose:)
			)
		)
	)
)

(instance lightItUp of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 2 20 10 1 self) ; "Alexander takes the candle from his tinder box and uses the flint in the box to light it."
			)
			(1
				(= local0 11)
				(gGlobalSound4 number: 932 setLoop: 1 play:)
				(gEgo
					view: 391
					loop: (+ (gEgo loop:) 2)
					cel: 0
					cycleSpeed: 21
					setCycle: End self
				)
				(if (IsFlag 48)
					(gEgo setScript: cyclePalette 0 0)
				)
			)
			(2
				(if (not (IsFlag 97))
					(SetFlag 97)
					(gGame givePoints: 2)
				)
				(gEgo
					view: 392
					loop: (- (gEgo loop:) 2)
					setSpeed: (gEgo currentSpeed:)
					looper: mySmooper
					setCycle: StopWalk 393
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance getLeaf of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if (not (SetFlag 138))
					(gGame givePoints: 1)
				)
				(gEgo
					setSpeed: 7
					view: 3901
					loop: 0
					cel: -1
					get: 31 ; peppermint
					setCycle: End self
				)
			)
			(1
				(= cycles 2)
			)
			(2
				(gEgo
					view: 3904
					loop: 0
					setSpeed: (gEgo currentSpeed:)
					setCycle: StopWalk 3905
				)
				(= cycles 2)
			)
			(3
				(= ticks 20)
			)
			(4
				(gMessager say: 7 5 7 1 self) ; "Alexander takes a few leaves from the plant. As he does so, a strong smell of peppermint is released. Ah!"
			)
			(5
				(= cycles 2)
			)
			(6
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance egoActions of Actions
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(return 0)
			)
			(5 ; Do
				(return 0)
			)
			(2 ; Talk
				(return 0)
			)
			(20 ; tinderBox
				(if (== local0 10)
					(gCurRoom setScript: lightItUp)
				else
					(gMessager say: 2 20 local0 1)
				)
				(return 1)
			)
			(else
				(gMessager say: 0 0 134 1 0 899) ; "This cave is too dark! Alexander should wait until he goes outside to try that."
				(return 1)
			)
		)
	)
)

(instance cyclePalette of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(Palette palSET_INTENSITY 64 223 100)
				(= ticks 2)
			)
			(1
				(= local1 0)
				(self dispose:)
			)
		)
	)
)

