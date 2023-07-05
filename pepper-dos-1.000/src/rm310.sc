;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 310)
(include sci.sh)
(use Main)
(use ExitFeature)
(use OccasionalCycle)
(use BalloonTalker)
(use TwistyIconItem)
(use ADRoom)
(use Inset)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm310 0
	sallyTalker 1
	benTalker 16
	deborahTalker 17
)

(local
	local0 = 1
	local1
	local2 = 5
	local3
)

(instance rm310 of ADRoom
	(properties
		noun 1
		picture 310
		horizon 75
		vanishingY -60
	)

	(method (init)
		(super init: &rest)
		((ScriptID 895 0) ; pepper
			init:
			normalize:
			setScale: 0
			actions: pepperDoVerb
			ignoreActors:
		)
		((ScriptID 895 0) noun: 35) ; pepper
		(if (== gPrevRoomNum 213)
			(gLongSong number: 311 setLoop: -1 play:)
		else
			(gLongSong number: 310 setLoop: -1 play:)
		)
		(firePlace init: setOnMeCheck: 1 8)
		(kettle init: setOnMeCheck: 1 16)
		(sofa init: setOnMeCheck: 1 32)
		(endTable init: setOnMeCheck: 1 4)
		(window_ init: setOnMeCheck: 1 256)
		(sideBoard init: setOnMeCheck: 1 2048)
		(sideBoardDoor init: setOnMeCheck: 1 1024)
		(stovePipe init: setOnMeCheck: 1 -32768)
		(sideDoor init: approachVerbs: 7 setOnMeCheck: 1 4096) ; Do
		(candleStick init:)
		(candleStick2 init:)
		(plates init:)
		(plate2 init:)
		(picture_ init:)
		(bucket init:)
		(funnel init:)
		(footStool init:)
		(poof init:)
		(flowers init:)
		(chandelier init: setOnMeCheck: 1 128)
		(doorProp setPri: 2 init: stopUpd:)
		(if (not (== gPrevRoomNum 213))
			(doorProp addToPic:)
		)
		(matches init: setPri: 9 approachVerbs: 85 7 6 86 30 89) ; Talk, Do, Look, Nose, Paw, Teeth
		(fireWood init:)
		(if (not (IsFlag 16))
			(sideBoardDoorView init: stopUpd:)
		)
		(if (and (or (== gAct 3) (== gAct 4)) (!= gPrevRoomNum 210))
			(sally init:)
		)
		(if (and (== gAct 4) (!= gPrevRoomNum 210))
			(ben
				view: 314
				cel: 3
				x: 86
				y: 157
				ignoreActors: 0
				init:
				setCycle: OccasionalCycle self 1 20 100
			)
			(self
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 108 189 166 189 166 174 227 174 227 189 255 189 255 177 232 177 207 148 198 139 202 132 214 130 213 118 250 118 249 115 212 115 197 127 197 136 182 136 160 136 160 128 118 128 105 136 95 136 99 123 76 123 78 128 93 141 78 151 118 151 118 160 55 160 34 178 108 178
						yourself:
					)
			)
		else
			(self
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 109 182 109 189 170 189 170 175 221 175 221 189 256 189 256 181 235 181 198 139 202 132 214 130 213 118 250 118 249 115 212 115 197 127 197 136 182 136 160 136 160 128 118 128 105 136 95 136 99 123 76 123 78 128 83 144 78 159 30 182
						yourself:
					)
			)
		)
		(if (and (== gAct 3) (IsFlag 17))
			(fire init: setCycle: Fwd)
		)
		(if (not global220)
			(= global220 1)
		)
		(switch gPrevRoomNum
			(320
				(gEgo posn: 219 116 loop: 8 cel: 2 ignoreActors: 1)
				(gCurRoom setScript: fromWorkRoomScr)
			)
			(340
				(if (and (== gAct 2) (not (IsFlag 85)))
					((ScriptID 895 0) ; pepper
						init:
						view: 790
						loop: 8
						cel: 1
						normalize:
						posn: 173 170
					)
					(gCurRoom setScript: deborahIntroScr)
				else
					(gCurRoom setScript: fromExteriorScr)
				)
			)
			(210
				(gCurRoom setScript: fromWestCommonsScr)
			)
			(213
				(gCurRoom setScript: fromWestCommonsScr)
			)
			(else
				(gEgo posn: 143 160)
			)
		)
		(southEFeature init:)
	)

	(method (newRoom newRoomNumber)
		(gLongSong fade:)
		(switch local1
			(2
				(SetFlag 92)
			)
			(3
				(SetFlag 145)
			)
		)
		(super newRoom: newRoomNumber &rest)
	)

	(method (doit &tmp temp0)
		(cond
			(script 0)
			((& (gEgo onControl: 1) $0002)
				(gCurRoom setScript: goWorkRoomScr 0)
			)
			((& (gEgo onControl: 1) $0200)
				(gCurRoom setScript: nonoScr 0)
			)
			((== (gEgo edgeHit:) 3)
				(gCurRoom setScript: exitToExteriorScr)
			)
		)
		(super doit:)
	)
)

(instance pepperDoVerb of Actions
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(41 ; Tomato
				(if (or (not (IsFlag 147)) (not (IsFlag 99)))
					(gMessager say: 35 41 21) ; "That's an interesting idea, but Pepper has no reason to do it...now."
				else
					(gGame points: 300 3)
					(gCurRoom setScript: tomatoSquishScr)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sGetMatches of Script
	(properties)

	(method (dispose)
		(gGame handsOn:)
		(super dispose: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 99)
				((ScriptID 895 0) loop: 8 cel: 3 heading: 0) ; pepper
				(= ticks 30)
			)
			(1
				(gGame points: 301 1)
				(= cycles 1)
			)
			(2
				(sallyTalker x: 74 y: 99 tailPosn: 1)
				(cond
					((not (IsFlag 147))
						(= register 22)
						((ScriptID 895 0) setHeading: 90 self) ; pepper
					)
					((IsFlag 17)
						(= register 17)
						((ScriptID 895 0) setHeading: 90 self) ; pepper
					)
					(else
						(+= state 2)
						((ScriptID 895 0) stopUpd:) ; pepper
						(= cycles 2)
					)
				)
			)
			(3
				(gMessager say: 29 7 register 1 self)
			)
			(4
				(self dispose:)
			)
			(5
				(gMessager say: 29 7 7 1 self) ; "Hmm, those matches look like they'd be useful. Maybe I'll just borrow a couple..."
			)
			(6
				(gMessager say: 29 7 7 2 self) ; "What is it you need, lad?"
			)
			(7
				((ScriptID 895 0) setHeading: 90 self) ; pepper
			)
			(8
				(= cycles 2)
			)
			(9
				((ScriptID 2000 3) winX: 13 winY: 93 tailPosn: 1) ; PepperTalker
				(gMessager say: 29 7 7 3 7 self) ; "Um, I was just gonna get the matches."
			)
			(10
				((ScriptID 2000 3) winX: 0 winY: 0) ; PepperTalker
				(self dispose:)
			)
		)
	)
)

(instance goWorkRoomScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 219 123 self)
			)
			(1
				(gEgo setLoop: 8 cel: 3 heading: 0)
				(= cycles 2)
			)
			(2
				(gEgo setMotion: MoveTo 219 121 self)
			)
			(3
				(gCurRoom newRoom: 320)
			)
		)
	)
)

(instance nonoScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gMessager say: 5 7 0 1 self) ; "It would be rude of Pepper to go back into the Franklins' private rooms."
			)
			(2
				(gEgo setMotion: PolyPath 90 142 self)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fromWorkRoomScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 895 0) illegalBits: 0 setMotion: MoveTo 219 123 self) ; pepper
			)
			(1
				((ScriptID 895 0) setMotion: MoveTo 204 128 self) ; pepper
			)
			(2
				((ScriptID 895 0) loop: 8 cel: 2 heading: 180 normalize:) ; pepper
				(if (and (IsFlag 17) (not (IsFlag 69)))
					(SetFlag 69)
					(SetFlag 91)
					(= global215 40)
					(gMessager say: 33 0 17 0 self) ; "Ah, there you are, lad! I was worried about you! Are you feeling better?"
				else
					(= cycles 2)
				)
			)
			(3
				(if
					(and
						(gCast contains: ben)
						(== gAct 4)
						(== gPrevRoomNum 320)
						(not (IsFlag 169))
					)
					(SetFlag 169)
					(gMessager say: 33 0 8 0 self) ; "Sally, are you sure your mother didn't say where she was going?"
				else
					(self cue:)
				)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance fromExteriorScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo posn: 137 220)
				(= cycles 6)
			)
			(1
				(gLongSong2 number: 923 setLoop: 1 play:)
				(= cycles 1)
			)
			(2
				((ScriptID 895 0) setCycle: Walk setMotion: MoveTo 137 172 self) ; pepper
			)
			(3
				(if (and (IsFlag 72) (not (IsFlag 75)) (== gAct 5))
					(= next goQuizScr)
					(= cycles 1)
				else
					((ScriptID 895 0) normalize:) ; pepper
					(gGame handsOn:)
					(self dispose:)
				)
			)
			(4
				(gGame handsOn:)
				((ScriptID 895 0) normalize:) ; pepper
				(self dispose:)
			)
		)
	)
)

(instance goQuizScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				(gCurRoom newRoom: 600)
				(self dispose:)
			)
		)
	)
)

(instance deborahIntroScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(deborah init: view: 842 loop: 0 cel: 4 posn: 126 175)
				(= cycles 1)
			)
			(1
				((ScriptID 895 0) ; pepper
					init:
					view: 790
					loop: 8
					cel: 1
					normalize:
					posn: 173 170
				)
				(= cycles 1)
			)
			(2
				(gLongSong2 number: 923 setLoop: 1 play:)
				(= ticks 120)
			)
			(3
				(sallyTalker x: 46 y: 69 tailPosn: 1)
				(deborahTalker x: 137 y: 127 tailPosn: 0)
				(= cycles 5)
			)
			(4
				(gMessager say: 33 0 1 1 2 self) ; "Come on in, lad--by the way, you look familiar. Do you have a sister, by any chance?"
			)
			(5
				(= cycles 10)
			)
			(6
				(sally
					init:
					view: 310
					loop: 2
					cel: 0
					posn: 200 119
					setCycle: End self
				)
			)
			(7
				(gMessager say: 33 0 1 3 10 self) ; "Excuse me, Mama, but Papa would like some more hot water."
			)
			(8
				(sally setCycle: Beg self)
			)
			(9
				(sally dispose:)
				(= cycles 10)
			)
			(10
				(gMessager say: 33 0 1 11 11 self) ; "Well, before I go I'll introduce you to the old carrot--er, old gentleman. Come on."
			)
			(11
				(= cycles 10)
			)
			(12
				(deborah setCycle: Walk setMotion: PolyPath 208 132 self)
			)
			(13
				(deborahTalker x: 51 y: 69 tailPosn: 1)
				(gMessager say: 33 0 1 12 12 self) ; "How I HATE these blasted, silly BEADS!"
			)
			(14
				(= seconds 1)
			)
			(15
				(= local3 self)
				(deborah setCycle: Walk setMotion: PolyPath 211 124 deborah)
			)
			(16
				((ScriptID 895 0) setMotion: PolyPath 206 124 self) ; pepper
			)
			(17
				((ScriptID 895 0) dispose:) ; pepper
				(= cycles 2)
			)
			(18
				(gCurRoom newRoom: 320)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance tomatoSquishScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gLongSong fade:)
				(= cycles 1)
			)
			(1
				((ScriptID 895 0) ; pepper
					setCycle: Walk
					setMotion: PolyPath 120 172 self
				)
			)
			(2
				((ScriptID 895 0) normalize:) ; pepper
				(= cycles 10)
			)
			(3
				(gMessager say: 35 41 0 1 self) ; "An emergency, huh? I'll give her an emergency! Heh heh heh!"
			)
			(4
				(= seconds 1)
			)
			(5
				((ScriptID 895 0) ; pepper
					cycleSpeed: 13
					x: 121
					y: 170
					view: 312
					setLoop: 3
					cel: 0
					setCycle: CT 4 1 self
				)
			)
			(6
				((ScriptID 895 0) setCycle: End self) ; pepper
				(gLongSong2 number: 3101 setLoop: 1 play:)
			)
			(7
				(= cycles 30)
			)
			(8
				(gLongSong2 number: 312 setLoop: -1 play:)
				((ScriptID 895 0) setLoop: 4 cel: 0 setCycle: CT 4 1 self) ; pepper
			)
			(9
				((ScriptID 895 0) setLoop: 5 setCycle: Fwd) ; pepper
				((ScriptID 2000 3) dontUpd: 0) ; PepperTalker
				(gMessager say: 35 41 0 2 self) ; "AAAAH! Help! I cut myself! Ow! Ow! I'm dyin'! I'm dyin'!"
			)
			(10
				((ScriptID 895 0) setLoop: 4 setCycle: End self) ; pepper
			)
			(11
				(sally view: 312 setLoop: 1 cel: 0 setCycle: CT 3 1 self)
			)
			(12
				(sallyTalker winX: 110 winY: 102 tailPosn: 1 talkWidth: 100)
				(gMessager say: 35 41 0 3 self) ; "EEEEEEEK!"
			)
			(13
				(sally setCycle: End self)
			)
			(14
				(sallyTalker winX: 17 winY: 113 tailPosn: 1 talkWidth: 150)
				(gMessager say: 35 41 0 4 6 self) ; "Oh, no! What did you do? How did you do THAT?! Oh, what should I DO?!?"
			)
			(15
				(= next sallyBoilWaterScr)
				((ScriptID 895 0) normalize:) ; pepper
				(self dispose:)
			)
		)
	)
)

(instance sallyBoilWaterScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 17)
				(= cycles 1)
			)
			(1
				(sallyKnitScr cue:)
				(= cycles 1)
			)
			(2
				(matches dispose:)
				(= seconds 1)
			)
			(3
				(sally
					view: 312
					setLoop: 2
					cycleSpeed: 16
					setLoop: 2
					setCycle: End self
				)
			)
			(4
				(fire init: setCycle: Fwd)
				(= cycles 30)
			)
			(5
				(gLongSong2 number: 313 setLoop: 1 play: self)
			)
			(6
				(= seconds 2)
			)
			(7
				(gEgo put: 12) ; Tomato
				(= cycles 1)
			)
			(8
				(if gModelessDialog
					(-- state)
					(= ticks 10)
				else
					(gCurRoom drawPic: 99 6)
					(= ticks 60)
				)
			)
			(9
				(gCurRoom newRoom: 330)
			)
		)
	)
)

(instance wiggleScr of Script ; UNUSED
	(properties)

	(method (doit)
		(if (> (client state:) 5)
			(self dispose:)
		)
		(super doit:)
	)

	(method (dispose)
		((ScriptID 895 0) setLoop: 4 setCycle: End self) ; pepper
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 895 0) setCel: 5) ; pepper
				(= cycles 25)
			)
			(1
				((ScriptID 895 0) setCel: 6) ; pepper
				(= cycles 25)
			)
			(2
				((ScriptID 895 0) setCel: 7) ; pepper
				(= cycles 25)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance fromWestCommonsScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo posn: 137 181)
				(deborah view: 841 loop: 1 cel: 0 posn: 215 157 init: hide:)
				(sally init: view: 821 setLoop: 2 cel: 0 posn: 99 144 stopUpd:)
				(ben view: 817 loop: 0 cel: 0 posn: 178 156 init: hide:)
				(animationActor view: 313 loop: 0 cel: 0 posn: 197 157 init:)
				(= cycles 5)
			)
			(1
				(sallyTalker x: 101 y: 96 tailPosn: 0)
				(benTalker x: 21 y: 101 tailPosn: 1)
				(deborahTalker x: 52 y: 95 tailPosn: 1)
				(= cycles 4)
			)
			(2
				(gMessager say: 33 0 16 1 3 self) ; "...Ben?"
			)
			(3
				(deborahTalker x: 45 y: 93)
				(animationActor cycleSpeed: 10 setCycle: End self)
			)
			(4
				(gMessager say: 33 0 16 4 7 self) ; "Well, husband, I am surprised to find you out of your hot tub!"
			)
			(5
				(deborahTalker x: 52 y: 95 tailPosn: 1)
				(animationActor setCycle: Beg self)
			)
			(6
				(gMessager say: 33 0 16 8 10 self) ; "I'll tell you all about it in a while, my dear, but now I find that I am sorely in need of a bath!"
			)
			(7
				(deborahTalker x: 45 y: 93)
				(animationActor setCycle: End self)
			)
			(8
				(gMessager say: 33 0 16 11 12 self) ; "Come, Sally, help me draw some water."
			)
			(9
				(deborahTalker x: 52 y: 95)
				(animationActor setCycle: Beg self)
			)
			(10
				(= seconds 2)
			)
			(11
				(sally setLoop: 1 setMotion: MoveTo 86 130 self setCycle: Walk)
			)
			(12
				(sally setCycle: 0)
				(gLongSong2 number: 922 setLoop: 1 play:)
				(doorProp setPri: 0 setCycle: End self)
			)
			(13
				(sally setCycle: Walk setPri: 1 setMotion: MoveTo 60 126 self)
			)
			(14
				(sally dispose:)
				(= ticks 30)
			)
			(15
				(animationActor dispose:)
				(ben show:)
				(deborah show:)
				(= cycles 20)
			)
			(16
				(ben
					view: 817
					setLoop: 3
					ignoreActors: 1
					setCycle: Walk
					setMotion: MoveTo 212 126 ben
				)
				(= ticks 180)
			)
			(17
				(= local3 self)
				(deborah
					ignoreActors: 1
					setPri: -1
					setMotion: MoveTo 92 132 self
					setCycle: Walk
				)
			)
			(18
				(deborah setPri: 1 setMotion: MoveTo 65 126 deborah)
			)
			(19
				(= ticks 30)
			)
			(20
				(gLongSong2 number: 923 setLoop: 1 play:)
				(doorProp cycleSpeed: 10 setCycle: Beg self)
			)
			(21
				(= ticks 30)
			)
			(22
				(SetFlag 52)
				(gCurRoom newRoom: 600)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sallyKnitScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(sallyTalker x: 74 y: 99 tailPosn: 1)
				(sally view: 315 setLoop: 0 cel: 0 cycleSpeed: 8 setCycle: Osc)
			)
			(1
				(sally setCycle: 0)
				(self dispose:)
			)
		)
	)
)

(instance exitToExteriorScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 895 0) ; pepper
					setMotion:
						MoveTo
						((ScriptID 895 0) x:) ; pepper
						(+ ((ScriptID 895 0) y:) 9) ; pepper
						self
				)
			)
			(1
				(gCurRoom newRoom: 340)
			)
		)
	)
)

(instance firePlace of Feature
	(properties
		x 143
		y 104
		noun 18
		sightAngle 40
		approachX 142
		approachY 132
		approachDist 55
	)

	(method (doVerb theVerb)
		(switch theVerb
			(84 ; Trivia
				(gLongSong2 number: 927 setLoop: 1 play:)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance stovePipe of Feature
	(properties
		noun 19
	)

	(method (doVerb theVerb)
		(switch theVerb
			(84 ; Trivia
				(gLongSong2 number: 927 setLoop: 1 play:)
				(super doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance kettle of Feature
	(properties
		x 124
		y 77
		noun 23
		sightAngle 40
		approachX 143
		approachY 132
		approachDist 83
	)
)

(instance sofa of Feature
	(properties
		x 255
		y 127
		noun 17
		sightAngle 40
		approachX 217
		approachY 154
		approachDist 113
	)
)

(instance endTable of Feature
	(properties
		x 290
		y 169
		noun 16
		sightAngle 40
		approachX 290
		approachY 169
		approachDist 145
	)
)

(instance window_ of Feature
	(properties
		x 284
		y 69
		noun 3
		sightAngle 40
		approachX 215
		approachY 130
	)
)

(instance sideBoard of Feature
	(properties
		noun 10
		sightAngle 40
		approachX 57
		approachY 153
	)

	(method (doVerb theVerb)
		(= global215 88)
		(switch theVerb
			(7 ; Do
				(gGame points: 302 1)
				(sideBoardDoor doVerb: theVerb)
			)
			(else
				(sideBoardDoor doVerb: theVerb &rest)
			)
		)
	)
)

(instance sideBoardDoor of Feature
	(properties
		x 33
		y 331
		noun 12
		sightAngle 40
		approachX 55
		approachY 157
	)

	(method (doVerb theVerb)
		(= global215 88)
		(switch theVerb
			(7 ; Do
				(gGame points: 302 1)
				(gCurRoom setScript: insetScr)
			)
			(6 ; Look
				(if (IsFlag 302)
					(gMessager say: 12 6 23) ; "It's a pretty cherrywood |r||c0|sideboard|r||c|."
				else
					(gMessager say: 12 6) ; "It's a pretty cherrywood |r||c0|sideboard|r||c|. The door is slightly ajar, and there's some kind of card sticking out."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sideDoor of Feature
	(properties
		x 10
		y 100
		noun 4
		approachX 202
		approachY 135
	)
)

(instance chandelier of Feature
	(properties
		x 10
		y 100
		noun 25
	)
)

(instance sally of Actor
	(properties
		x 208
		y 149
		noun 34
		view 321
	)

	(method (init)
		(super init: &rest)
		(if (and (> gAct 2) (not (== gPrevRoomNum 213)) (< gAct 5))
			(self setScript: sallyKnitScr)
		)
	)

	(method (cue)
		(self dispose:)
	)

	(method (doVerb theVerb &tmp temp0)
		(sallyTalker x: 74 y: 99 tailPosn: 1)
		(switch theVerb
			(85 ; Talk
				(switch gAct
					(3
						(gGame points: 298 1)
					)
					(4
						(gGame points: 299 1)
					)
				)
				(cond
					((and (IsFlag 9) (== gAct 3) (not (IsFlag 17)))
						(= local1 2)
						(switch global220
							(1
								(= temp0 4)
							)
							(2
								(= temp0 3)
							)
							(3
								(= temp0 5)
							)
							(else
								(= temp0 6)
							)
						)
						(++ global220)
						(gMessager say: 34 85 temp0)
					)
					(
						(or
							(and (== gAct 3) (IsFlag 91))
							(and (IsFlag 17) (IsFlag 69) (not (IsFlag 91)))
						)
						(gMessager say: 34 85 18) ; "Forgive me, lad, but since you don't require my medical assistance, I'd best get on with my sewing!"
					)
					((IsFlag 145)
						(gMessager say: 34 85 15) ; "Forgive me, lad, but I am so distracted I keep pricking my fingers with my needle. I'm afraid I'm not much good at conversation right now."
					)
					((== gAct 4)
						(= local1 3)
						(switch global220
							(1
								(= temp0 13)
							)
							(2
								(= temp0 14)
							)
							(else
								(= temp0 15)
							)
						)
						(++ global220)
						(gMessager say: 34 85 temp0)
					)
				)
			)
			(68 ; Carpet_Bag [closed]
				(gMessager say: 34 113) ; "That's my mother's! She'll be wanting it...if she ever comes home! (sob!)"
				(return 1)
			)
			((OneOf theVerb 85 7 6 86 30 89 84) ; Talk, Do, Look, Nose, Paw, Teeth, Trivia
				(= global215 8)
				(super doVerb: theVerb &rest)
			)
			(else
				(gMessager say: 34 19) ; "No, but thank you, lad."
				(return 1)
			)
		)
	)
)

(instance deborah of Actor
	(properties
		x 165
		y 182
		noun 30
		view 841
		loop 1
	)

	(method (cue)
		(switch local3
			(fromWestCommonsScr
				(self dispose:)
				(fromWestCommonsScr cue:)
			)
			(deborahIntroScr
				(self dispose:)
				(deborahIntroScr cue:)
			)
		)
	)
)

(instance ben of Actor
	(properties
		x 200
		y 152
		noun 31
		view 817
		loop 3
		cel 1
	)

	(method (cue)
		(self dispose:)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(6 ; Look
				(= global215 7)
				(super doVerb: theVerb &rest)
			)
			(85 ; Talk
				(= temp0
					(switch local0
						(1 9)
						(2 10)
						(3 11)
						(else 12)
					)
				)
				(++ local0)
				(gMessager say: 31 85 temp0)
			)
			(64 ; King_s_Letter
				(gMessager say: 31 64) ; "Ben, that General Pugh is a real stinker! You wouldn't believe what he's been up to! I got this letter, and--"
				(return 1)
			)
			((OneOf theVerb 85 7 6 86 30 89 84) ; Talk, Do, Look, Nose, Paw, Teeth, Trivia
				(super doVerb: theVerb &rest)
			)
			(else
				(gMessager say: 31 19) ; "Please, child, I can't be bothered now."
				(return 1)
			)
		)
	)
)

(instance southEFeature of ExitFeature
	(properties
		nsTop 185
		nsLeft 102
		nsBottom 195
		nsRight 300
		cursor 910
		exitDir 3
		noun 36
	)
)

(instance recipeCard of Prop
	(properties
		x 105
		y 111
		noun 15
		view 311
		loop 1
		priority 15
		signal 16
	)

	(method (doVerb theVerb)
		(switch theVerb
			(128 ; Exit
				(sideBoardIns dispose:)
				(insetScr cue:)
			)
			(7 ; Do
				(gEgo get: 17) ; Recipe_Card
				(SetFlag 16)
				(gGame points: 303 1)
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sideBoardIns of Inset
	(properties
		view 311
		x 46
		y 50
		hideTheCast 1
		disposeNotOnMe 1
		noun 14
	)

	(method (init)
		(super init: &rest)
		(gTheIconBar disable: 9)
		(proc883_6 1)
	)

	(method (dispose)
		(proc883_6 0)
		(gTheIconBar enable: 9)
		(super dispose: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(128 ; Exit
				(self dispose:)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance insetScr of Script
	(properties)

	(method (init)
		(if (IsFlag 16)
			(= start 4)
		)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 895 0) setMotion: PolyPath 75 152 self) ; pepper
			)
			(1
				((ScriptID 895 0) ; pepper
					view: 311
					setLoop: 2
					cycleSpeed: 6
					cel: 0
					posn: 75 152
					stopUpd:
				)
				(= cycles 2)
			)
			(2
				(gLongSong2 number: 3103 setLoop: 1 play:)
				((ScriptID 895 0) setCycle: End self) ; pepper
			)
			(3
				(sideBoardDoorView dispose:)
				(= cycles 1)
			)
			(4
				(cond
					((IsFlag 16)
						(gMessager say: 12 7 20 0) ; "Pepper doesn't need anything else from the |r||c0|sideboard|c||r|."
						(gGame handsOn:)
						(self dispose:)
					)
					((IsFlag 84)
						(gMessager say: 12 7 19 0 self) ; "Let's just take another look in there..."
					)
					(else
						(gMessager say: 12 7 0 0 self) ; "I wonder what's in here..."
					)
				)
			)
			(5
				(SetFlag 84)
				(= seconds 1)
			)
			(6
				(gGame handsOn:)
				(gCurRoom setInset: sideBoardIns self)
				(if (not (IsFlag 16))
					(recipeCard init: stopUpd:)
				)
			)
			(7
				(gGame handsOff:)
				(= cycles 1)
			)
			(8
				(= seconds 2)
			)
			(9
				(if (IsFlag 16)
					(gMessager say: 15 7 0 0 self) ; "I think I'll just borrow this recipe card..."
				else
					(= cycles 1)
				)
			)
			(10
				(gLongSong2 number: 3103 setLoop: 1 play:)
				((ScriptID 895 0) cel: 5 setCycle: CT 3 -1 self) ; pepper
			)
			(11
				(if (not (IsFlag 16))
					(sideBoardDoorView init: stopUpd:)
				)
				(= cycles 1)
			)
			(12
				((ScriptID 895 0) setCycle: Beg self) ; pepper
			)
			(13
				((ScriptID 895 0) normalize: setMotion: MoveTo 84 167 self) ; pepper
			)
			(14
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance candleStick of Feature
	(properties
		x 20
		y 58
		noun 2
		nsTop 42
		nsLeft 14
		nsBottom 75
		nsRight 26
		sightAngle 40
		approachX 60
		approachY 155
	)
)

(instance candleStick2 of Feature
	(properties
		x 303
		y 131
		noun 2
		nsTop 104
		nsLeft 295
		nsBottom 158
		nsRight 311
		sightAngle 40
		approachX 245
		approachY 181
	)
)

(instance plates of Feature
	(properties
		x 124
		y 62
		noun 20
		nsTop 56
		nsLeft 115
		nsBottom 69
		nsRight 134
		sightAngle 40
		approachX 113
		approachY 140
	)
)

(instance plate2 of Feature
	(properties
		x 165
		y 64
		noun 20
		nsTop 60
		nsLeft 160
		nsBottom 68
		nsRight 171
		sightAngle 40
		approachX 177
		approachY 140
	)
)

(instance picture_ of Feature
	(properties
		x 27
		y 33
		noun 7
		nsTop 6
		nsLeft 4
		nsBottom 60
		nsRight 50
		sightAngle 40
		approachX 78
		approachY 154
	)

	(method (doVerb theVerb)
		(switch theVerb
			(84 ; Trivia
				(= global215 66)
				(super doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bucket of Feature
	(properties
		x 43
		y 69
		noun 6
		nsTop 62
		nsLeft 29
		nsBottom 76
		nsRight 57
		sightAngle 40
		approachX 74
		approachY 144
	)

	(method (doVerb theVerb)
		(= global215 87)
		(super doVerb: theVerb &rest)
	)
)

(instance funnel of Feature
	(properties
		x 96
		y 82
		noun 21
		nsTop 72
		nsLeft 88
		nsBottom 92
		nsRight 105
		sightAngle 40
		approachX 94
		approachY 128
	)
)

(instance poof of Feature
	(properties
		x 198
		y 172
		noun 8
		nsTop 159
		nsLeft 174
		nsBottom 186
		nsRight 223
		sightAngle 40
		approachX 161
		approachY 173
	)
)

(instance footStool of Feature
	(properties
		x 74
		y 172
		noun 9
		nsTop 158
		nsLeft 43
		nsBottom 187
		nsRight 106
		sightAngle 40
		approachX 107
		approachY 170
	)

	(method (doVerb theVerb)
		(if (OneOf theVerb 6 84) ; Look, Trivia
			(= global215 47)
			(super doVerb: theVerb &rest)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance flowers of Feature
	(properties
		x 26
		y 99
		noun 27
		nsTop 89
		nsLeft 2
		nsBottom 109
		nsRight 50
		sightAngle 40
		approachX 60
		approachY -10
	)

	(method (doVerb theVerb)
		(= global215 88)
		(switch theVerb
			(84 ; Trivia
				(super doVerb: theVerb &rest)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance matches of View
	(properties
		x 170
		y 119
		noun 29
		nsTop 63
		nsLeft 91
		nsBottom 68
		nsRight 100
		sightAngle 40
		approachX 173
		approachY 138
		approachDist 5
		view 310
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(7 ; Do
				(gCurRoom setScript: sGetMatches)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sideBoardDoorView of View
	(properties
		x 51
		y 119
		view 310
		cel 2
		priority 11
	)

	(method (init)
		(self setPri: 11)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(sideBoardDoor doVerb: theVerb &rest)
	)
)

(instance fireWood of Feature
	(properties
		x 147
		y 118
		noun 24
		nsTop 111
		nsLeft 129
		nsBottom 126
		nsRight 165
		sightAngle 40
		approachX 146
		approachY 135
	)
)

(instance sallyTalker of BalloonTalker
	(properties
		x 50
		y 80
		talkWidth 150
		tailPosn 1
	)
)

(instance benTalker of BalloonTalker
	(properties
		x 95
		y 100
		talkWidth 150
	)
)

(instance deborahTalker of BalloonTalker
	(properties
		x 123
		y 94
		talkWidth 150
	)
)

(instance fire of Prop
	(properties
		x 138
		y 124
		noun 18
		view 310
		loop 4
	)

	(method (doVerb theVerb)
		(switch theVerb
			(84 ; Trivia
				(gLongSong2 number: 927 setLoop: 1 play:)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance animationActor of Actor
	(properties
		x 197
		y 157
		view 313
	)
)

(instance doorProp of Prop
	(properties
		x 75
		y 120
		noun 5
		view 310
		loop 1
	)

	(method (init)
		(self ignoreActors: 1 setPri: 4)
		(super init: &rest)
	)
)

