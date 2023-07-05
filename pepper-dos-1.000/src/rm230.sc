;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 230)
(include sci.sh)
(use Main)
(use ExitFeature)
(use CycleBet)
(use smell)
(use OccasionalCycle)
(use BalloonTalker)
(use TwistyIconItem)
(use ADRoom)
(use Inset)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm230 0
	offScreenTalker 1
	reveler2Talker 3
	poorRichardTalker 4
	quibbleTalker 9
	vicarTalker 10
	sentry1Talker 11
	sentry2Talker 12
)

(local
	local0 = 1
	local1
	local2 = 1
	local3
	local4 = 1
	local5
	local6 = 1
	local7
	local8
	local9
	local10
	local11
)

(instance rm230 of ADRoom
	(properties
		noun 21
		picture 230
	)

	(method (doVerb theVerb)
		(= global215 16)
		(super doVerb: theVerb)
	)

	(method (init)
		(if (== gAct 0)
			(= gAct 2)
			(proc875_0)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 112 49 112 232 184 319 184 319 189 0 189
					yourself:
				)
				((Polygon new:) type: PBarredAccess init: 0 72 24 86 0 99 yourself:)
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 166 296 165 279 145 277 139 232 132 209 127 192 142 127 128 83 112 83 101 93 93 114 80 144 70 115 73 83 89 47 89 0 62
					yourself:
				)
		)
		(<<= local2 $0009)
		(<<= local0 $000b)
		(<<= local4 $0003)
		(<<= local6 $0004)
		(= global114 1)
		(if (IsFlag 170)
			(= local5 1)
		)
		(if (IsFlag 171)
			(= local7 1)
		)
		(switch gPrevRoomNum
			(210
				(self style: 12)
				(gEgo normalize: init: x: 15 y: 104 setScale: 0)
				(if (and (< gAct 3) (not (IsFlag 160)))
					(gCurRoom setScript: argue)
				else
					(gGame handsOn:)
				)
			)
			(300
				(gEgo
					normalize:
					ignoreHorizon: 1
					x: 150
					y: 35
					init:
					setScale: Scaler 39 20 55 30
				)
				(self setScript: sEnterFrom300)
			)
			(260
				(gEgo
					init:
					normalize:
					setScale: 0
					x: 0
					y: 77
					setLoop: 4
					setCycle: Walk
				)
				(self setScript: sEnterFrom260)
			)
			(291
				(self picture: 0)
				(= global114 0)
				(gEgo init: normalize:)
				(switch global195
					(12
						(= local1 1)
					)
					(10
						(= local3 1)
					)
					(5
						(= local7 1)
					)
					(4
						(= local5 1)
					)
				)
				(DrawPic 230 100 1)
				(gCurRoom setScript: sFinishConversation)
			)
			(116
				(= global114 0)
				(= picture 0)
				(DrawPic 230 100 1)
				((ScriptID 895 0) init:) ; pepper
				(gGame handsOn:)
			)
			(else
				(self style: 11)
				(gEgo
					init:
					normalize:
					setScale: 0
					x: 304
					y: 175
					loop: 8
					cel: 1
					heading: 270
				)
				(self setScript: sEnterFrom270)
			)
		)
		(gEgo ignoreActors:)
		(super init: &rest)
		(cond
			(
				(and
					(not (gEgo has: 29)) ; Puzzle_Box
					(not (gEgo has: 30)) ; Love_Letters
					(== gAct 4)
					(not (IsFlag 246))
				)
				(stampActPoster
					noun: 23
					approachVerbs: 6 7 ; Look, Do
					init:
					setPri: 8
					setCycle: Fwd
				)
			)
			((< gAct 4)
				(stampActPoster
					approachVerbs: 6 7 ; Look, Do
					init:
					setPri: 8
					ignoreActors: 1
					addToPic:
				)
			)
		)
		(if
			(and
				(== global114 1)
				(not (IsFlag 111))
				(proc875_1 local0 global204)
				(proc875_1 local0 global206)
				(proc875_1 local0 global208)
			)
			(SetFlag 135)
		)
		(if
			(and
				(== global114 1)
				(or
					(not (IsFlag 109))
					(proc875_1 local2 global204)
					(proc875_1 local2 global206)
					(proc875_1 local2 global208)
				)
			)
			(SetFlag 133)
		)
		(if
			(and
				(== global114 1)
				(or
					(not (IsFlag 103))
					(proc875_1 local4 global204)
					(proc875_1 local4 global206)
					(proc875_1 local4 global208)
				)
			)
			(SetFlag 127)
		)
		(if
			(and
				(== global114 1)
				(or
					(not (IsFlag 104))
					(proc875_1 local6 global204)
					(proc875_1 local6 global206)
					(proc875_1 local6 global208)
				)
			)
			(SetFlag 128)
		)
		(cond
			((IsFlag 24)
				(stand
					loop: 1
					cel: 1
					x: 44
					y: 62
					noun: 25
					ignoreActors: 1
					addToPic:
				)
				(if (and (not (gEgo has: 31)) (not (IsFlag 247))) ; Carpet_Bag
					(carpetBag init: setPri: 8 stopUpd:)
				)
			)
			((== gAct 3)
				(poorRichard
					init:
					setPri: 9
					setCycle: OccasionalCycle self 1 10 50
				)
				(stand init: ignoreActors: 1 addToPic:)
			)
		)
		(if (== gAct 4)
			(stand init: ignoreActors: 1 addToPic:)
		)
		(if (and (== gAct 4) (not (IsFlag 231)) (IsFlag 24))
			(carpetBag init: stopUpd:)
		)
		(tree approachVerbs: 6 7 init: setOnMeCheck: 1 8192) ; Look, Do
		(if (and (< gAct 3) (not (IsFlag 223)))
			(bagOfMarbles approachVerbs: 7 setPri: 8 init: stopUpd:) ; Do
		)
		(if (and (not (IsFlag 27)) (== gAct 3))
			(if (or (IsFlag 24) (> gAct 3))
				(keyOnStand x: 159 y: 128 setCel: 0 setLoop: 0 init: setPri: 9)
			else
				(keyOnStand init: setPri: 9 stopUpd:)
			)
		)
		(if (and (> gAct 1) (not (IsFlag 217)))
			(reveler2 approachVerbs: 85 7 141 init: setScript: sThrowFrisbee) ; Talk, Do, ???
			(frisbee init: hide:)
		)
		(cond
			((IsFlag 441)
				(if (== gPrevRoomNum 291)
					(quibblers setLoop: 1 setPri: 10 init: stopUpd:)
				else
					0
				)
			)
			((IsFlag 229)
				(quibblers setLoop: 1 setPri: 10 init: stopUpd:)
			)
			(else
				(quibblers init: setPri: 10 stopUpd:)
			)
		)
		(if (not (IsFlag 441))
			(vicar approachVerbs: 85 94 95 70 init:) ; Talk, ???, Wood_Cutting_a or Wood_Cutting_b or Wood_Cutting_c, Special_Edition
			(quibble approachVerbs: 85 94 95 70 init:) ; Talk, ???, Wood_Cutting_a or Wood_Cutting_b or Wood_Cutting_c, Special_Edition
		)
		(hole init:)
		(bench init:)
		(benHouse init:)
		(buildings init:)
		(hills init: setOnMeCheck: 1 4096)
		(eastEFeature init:)
		(westEFeature init:)
		(if (OneOf gPrevRoomNum 116 291)
			(self curPic: 230 picture: 230)
		)
	)

	(method (doit &tmp temp0)
		(= temp0 (gEgo onControl: 1))
		(if
			(and
				local11
				(gLongSong handle:)
				(> ((ScriptID 895 0) distanceTo: reveler2) 55) ; pepper
				(> ((ScriptID 895 0) distanceTo: quibble) 55) ; pepper
			)
			(gLongSong fade:)
			(= local11 0)
		)
		(cond
			(script)
			((& temp0 $0002)
				(gGame handsOff:)
				(gCurRoom setScript: sExitTo300)
			)
			((& temp0 $0004)
				(gCurRoom setScript: sExitTo260)
			)
			((== (gEgo edgeHit:) 4)
				(self setScript: sExitWest)
			)
			((== (gEgo edgeHit:) 2)
				(self setScript: sExitEast)
			)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(if (not (== gNewRoomNum 291))
			(ClearFlag 170)
			(ClearFlag 171)
		)
		((ScriptID 2000 3) offY: 0) ; PepperTalker
		(super dispose: &rest)
	)
)

(instance getBag of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 223 2)
				((ScriptID 895 0) setMotion: PolyPath 206 111 self) ; pepper
			)
			(1
				((ScriptID 895 0) view: 805 setLoop: 0 setCycle: End self) ; pepper
			)
			(2
				(bagOfMarbles dispose:)
				((ScriptID 895 0) setCycle: Beg self) ; pepper
			)
			(3
				(gMessager say: 20 7 0 0 self) ; "Pepper takes the bag."
			)
			(4
				((ScriptID 895 0) get: 5 normalize:) ; pepper, Bag_of_Marbles
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance doInset of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame points: 232 1)
				(= cycles 2)
			)
			(1
				(gMessager say: 23 7 0 0 self) ; "Hey, there's something under the sign!"
			)
			(2
				(gCurRoom setInset: inBfDr)
				(self dispose:)
			)
		)
	)
)

(instance getProverbs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(poorRichard setLoop: 1 setCel: 0 setCycle: End self)
			)
			(1
				((ScriptID 895 0) ; pepper
					view: 805
					setLoop: 4
					setCel: 0
					setCycle: End self
				)
			)
			(2
				((ScriptID 895 0) setCycle: Beg self) ; pepper
			)
			(3
				(cond
					((IsFlag 226)
						(gGame points: 227 1)
					)
					((IsFlag 225)
						(gGame points: 226 1)
					)
					(else
						(gGame points: 225 1)
					)
				)
				((ScriptID 895 0) get: 22 get: 43 normalize:) ; pepper, Wood_Cutting_a, Wood_Cutting_b
				(if (not (IsFlag 88))
					((ScriptID 895 0) get: 44) ; pepper, Wood_Cutting_c
				)
				(poorRichard setLoop: 0 setCycle: OccasionalCycle 1 10 50)
				(self dispose:)
			)
		)
	)
)

(instance argue of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 160)
				(= seconds 2)
			)
			(1
				(gMessager say: 22 0 85 0 self) ; "...But you have to see my point, don't you? I mean, even someone as pigheaded as you can understand THAT!"
			)
			(2
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitWest of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo -21 104 self)
			)
			(1
				(gCurRoom newRoom: 210)
			)
		)
	)
)

(instance sExitEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setMotion: MoveTo (+ (gEgo x:) 20) (gEgo y:) self
				)
			)
			(1
				(gCurRoom newRoom: 270)
			)
		)
	)
)

(instance sExitTo300 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gEgo
					setLoop: 6
					setPri: -1
					setCycle: Walk
					setMotion: MoveTo 103 83 self
				)
			)
			(2
				(gEgo setMotion: MoveTo 119 75 self)
			)
			(3
				(gEgo setMotion: MoveTo 153 76 self)
			)
			(4
				(gEgo
					setPri: 3
					setScale: Scaler 54 26 74 36
					setMotion: MoveTo 173 86 self
				)
			)
			(5
				(gEgo setLoop: -1 setPri: 3 setMotion: MoveTo 151 72 self)
			)
			(6
				(gEgo setPri: 3 setMotion: MoveTo 177 49 self)
			)
			(7
				(gEgo setPri: 1 setMotion: MoveTo 141 56 self)
			)
			(8
				(gEgo setLoop: 7 setMotion: MoveTo 133 45 self)
			)
			(9
				(gEgo setLoop: 6 setMotion: MoveTo 151 35 self)
			)
			(10
				(gEgo hide:)
				(= seconds 2)
			)
			(11
				(gCurRoom newRoom: 300)
			)
		)
	)
)

(instance sExitTo260 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo
					setCycle: Walk
					setScale: 100 56 86 74
					setLoop: 7
					setMotion: MoveTo 0 77 self
				)
			)
			(1
				(gEgo hide:)
				(= cycles 2)
			)
			(2
				(gCurRoom newRoom: 260)
			)
		)
	)
)

(instance sEnterFrom270 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gGame handsOn:)
				(gEgo normalize:)
				(self dispose:)
			)
		)
	)
)

(instance sEnterFrom260 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setMotion: MoveTo 32 87 self)
			)
			(1
				(gEgo setScale: 0 setMotion: MoveTo 43 96 self)
			)
			(2
				(gGame handsOn:)
				(gEgo normalize:)
				(self dispose:)
			)
		)
	)
)

(instance sFinishConversation of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== global115 18)
					((ScriptID 2000 3) offY: 4) ; PepperTalker
				)
				(= cycles 1)
			)
			(1
				(switch global116
					(2
						(= global215 85)
					)
					(161
						(= global215 108)
					)
					(201
						(= global215 57)
					)
					(203
						(= global215 57)
					)
					(77
						(= global215 32)
					)
					(81
						(= global215 103)
					)
					(78
						(= global215 32)
					)
					(188
						(= global215 108)
					)
					(190
						(= global215 57)
					)
				)
				(cond
					((and global115 (== global116 160))
						(= global215 57)
						(= state 29)
						(gMessager say: global115 85 160 1 2 self global196)
					)
					((and global115 (== global116 100))
						(= global215 28)
						(= state 19)
						(gMessager say: global115 85 100 1 self global196)
					)
					((and global115 (== global116 190))
						(= state 39)
						(gMessager say: global115 85 190 1 2 self)
					)
					((and global115 (== global116 188))
						(= state 49)
						(gMessager say: global115 85 188 1 3 self)
					)
					((and global115 (== global116 81))
						(= state 59)
						(gMessager say: global115 85 81 1 2 self)
					)
					((and global115 global116)
						(= state 99)
						(gMessager say: global115 85 global116 0 self global196)
					)
					(else
						(= state 99)
						(= cycles 2)
					)
				)
			)
			(20
				(= state 99)
				(gMessager say: global115 85 100 2 4 self global196)
			)
			(30
				(= state 99)
				(gMessager say: global115 85 160 3 5 self global196)
			)
			(40
				(= state 99)
				(gMessager say: global115 85 190 3 5 self)
			)
			(50
				(= state 99)
				(gMessager say: global115 85 188 4 self)
			)
			(60
				(= state 99)
				(gMessager say: global115 85 81 3 5 self)
			)
			(100
				(= local11 1)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sThrowFrisbee of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 1 5))
			)
			(1
				(reveler2 loop: 0 cel: 0 setCycle: CT 3 1 self)
			)
			(2
				(gLongSong2 number: 2117 setLoop: 1 play:)
				(frisbee
					show:
					x: 30
					y: 112
					setStep: 17 20
					setMotion: MoveTo -10 100 self
				)
				(reveler2 setCycle: End self)
			)
			(3 0)
			(4
				(frisbee hide:)
				(= cycles 1)
			)
			(5
				(= seconds (Random 1 5))
			)
			(6
				(reveler2 loop: 1 cel: 0 setCycle: CT 5 1 self)
			)
			(7
				(frisbee x: 0 y: 142 show: setMotion: MoveTo 65 142 self)
			)
			(8
				(reveler2 setCycle: End self)
				(frisbee hide:)
			)
			(9
				(reveler2 cel: 0)
				(= state -1)
				(= cycles 1)
			)
		)
	)
)

(instance sEnterFrom300 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				((ScriptID 895 0) ; pepper
					setPri: 3
					setScale: Scaler 39 20 55 30
					setMotion: MoveTo 131 46 self
				)
			)
			(2
				((ScriptID 895 0) setMotion: MoveTo 135 53 self) ; pepper
			)
			(3
				((ScriptID 895 0) setPri: 1 setMotion: MoveTo 179 58 self) ; pepper
			)
			(4
				((ScriptID 895 0) ; pepper
					setLoop: -1
					setLoop: 2
					setMotion: MoveTo 181 48 self
				)
			)
			(5
				((ScriptID 895 0) ; pepper
					setScale: Scaler 54 47 72 46
					setPri: 4
					setMotion: MoveTo 143 73 self
				)
			)
			(6
				((ScriptID 895 0) ; pepper
					setPri: 6
					setScale: Scaler 100 60 90 71
					setMotion: MoveTo 83 103 self
				)
			)
			(7
				(gGame handsOn:)
				(gEgo setPri: -1 setScale: 0 normalize:)
				(self dispose:)
			)
		)
	)
)

(instance sGetKeyOk of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 895 0) setMotion: PolyPath 149 133 self) ; pepper
			)
			(1
				((ScriptID 895 0) ; pepper
					view: 805
					setLoop: 0
					setCel: 0
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(2
				(keyOnStand dispose:)
				((ScriptID 895 0) setCycle: Beg self) ; pepper
			)
			(3
				(gMessager say: 2 7 25 0 self 2012) ; "Pepper picks up the brass key."
			)
			(4
				(gEgo get: 21) ; A_Brass_Key
				(SetFlag 27)
				(= cycles 1)
			)
			(5
				((ScriptID 895 0) normalize:) ; pepper
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetKeyNotYet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 895 0) setMotion: MoveTo 99 122 self) ; pepper
			)
			(1
				((ScriptID 895 0) setHeading: 45 self) ; pepper
			)
			(2
				(if
					(and
						(not (gEgo has: 22)) ; Wood_Cutting_a
						(not (gEgo has: 43)) ; Wood_Cutting_b
						(not (gEgo has: 44)) ; Wood_Cutting_c
					)
					(if (not (IsFlag 87))
						(if local1
							(= local8 1)
							(self setScript: sayBW2 self)
						else
							(gMessager say: 2 7 21 0 self 2012) ; "Pepper decides she had better ask Poor Richard before taking the key."
						)
					else
						(self cue:)
					)
				else
					(= local9 1)
					(= local10 1)
					(gMessager say: 2 7 23 0 self 2012) ; "Now, then, laddie, a deal is a deal! No key for you until all the proverbs are with the right people!"
				)
			)
			(3
				(cond
					((and local9 (IsFlag 88))
						(self cue:)
					)
					((not (IsFlag 87))
						(if
							(and
								(not (gEgo has: 22)) ; Wood_Cutting_a
								(not (gEgo has: 43)) ; Wood_Cutting_b
								(not (gEgo has: 44)) ; Wood_Cutting_c
								local1
							)
							(self setScript: getProverbs self)
						else
							(self cue:)
						)
					)
					((not (IsFlag 88))
						(= local8 1)
						(if (not local10)
							(gMessager say: 2 7 23 0 self 2012) ; "Now, then, laddie, a deal is a deal! No key for you until all the proverbs are with the right people!"
						else
							(= local10 0)
							(self cue:)
						)
					)
					(else
						(= local8 1)
						(if (not local10)
							(gMessager say: 2 7 23 0 self 2012) ; "Now, then, laddie, a deal is a deal! No key for you until all the proverbs are with the right people!"
						else
							(= local10 0)
							(self cue:)
						)
					)
				)
			)
			(4
				(= local9 0)
				((ScriptID 895 0) normalize:) ; pepper
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTakeCarpetBag of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 895 0) setMotion: PolyPath 83 103 self) ; pepper
			)
			(1
				((ScriptID 895 0) ; pepper
					view: 805
					setLoop: 0
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(2
				(carpetBag dispose:)
				((ScriptID 895 0) setCycle: Beg self) ; pepper
			)
			(3
				(gEgo get: 31) ; Carpet_Bag
				(SetFlag 231)
				(gMessager say: 4 7 0 0 self) ; "Pepper decides to take the carpetbag."
			)
			(4
				((ScriptID 895 0) normalize:) ; pepper
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance tPRDone1stSetMenu of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 1 85 11 1 4 self 2012) ; "Hello, Mr. Richard. I finished passing out the first three proverbs!"
			)
			(1
				(self setScript: getProverbs self)
			)
			(2
				(gMessager say: 1 85 11 5 6 self 2012) ; "Mr. Richard, while I'm here could I ask you a few questions?"
			)
			(3
				(= global195 12)
				(proc875_0)
				(gCast eachElementDo: #stopUpd)
				(= cycles 1)
			)
			(4
				(gCurRoom newRoom: 291)
			)
		)
	)
)

(instance sTalkPoorRich of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if
					(and
						(not (IsFlag 111))
						(not (IsFlag 123))
						(proc875_1 local0 global204)
						(proc875_1 local0 global206)
						(proc875_1 local0 global208)
						(proc875_1 local0 global205)
						(proc875_1 local0 global207)
						(proc875_1 local0 global209)
					)
					(SetFlag 135)
				)
				(= cycles 1)
			)
			(1
				(cond
					(
						(and
							(IsFlag 88)
							(or
								((ScriptID 895 0) has: 22) ; pepper, Wood_Cutting_a
								((ScriptID 895 0) has: 43) ; pepper, Wood_Cutting_b
							)
						)
						(gMessager say: 1 85 24 0 self 2012) ; "Hurry, lad, or I fear all will be lost!"
					)
					(
						(and
							(IsFlag 88)
							(not (gEgo has: 22)) ; Wood_Cutting_a
							(not (gEgo has: 43)) ; Wood_Cutting_b
						)
						(gMessager say: 1 85 13 0 self 2012) ; "Hey, Mr. Richard, I'm back for more!"
					)
					(
						(and
							(not local1)
							(IsFlag 228)
							(
								(= local1 1)
								(gCurRoom setScript: sGetKeyNotYet)
							)
						))
					((not local1)
						(= local9 1)
						(gMessager say: 1 85 30 0 self 2012) ; "Hello, sir! You look better than you did the last time I saw you!"
					)
					(
						(and
							(IsFlag 87)
							(not (IsFlag 88))
							(not (gEgo has: 22 has: 43 has: 44)) ; Wood_Cutting_a, Wood_Cutting_b, Wood_Cutting_c
						)
						(gCurRoom setScript: tPRDone1stSetMenu)
					)
					((IsFlag 135)
						(= local9 1)
						(gMessager say: 1 85 1 0 self 2012) ; "If thou would excuse me, lad, I have much to do today."
					)
					(
						(and
							(not (IsFlag 88))
							(IsFlag 135)
							(or
								(gEgo has: 22) ; Wood_Cutting_a
								(gEgo has: 43) ; Wood_Cutting_b
								(gEgo has: 44) ; Wood_Cutting_c
							)
						)
						(gMessager say: 1 85 24 0 self 2012) ; "Hurry, lad, or I fear all will be lost!"
					)
					(else
						(= cycles 1)
					)
				)
			)
			(2
				(cond
					(
						(and
							(IsFlag 88)
							(not (gEgo has: 22)) ; Wood_Cutting_a
							(not (gEgo has: 43)) ; Wood_Cutting_b
						)
						(gGame handsOff:)
						(self setScript: getProverbs self)
					)
					(
						(and
							(IsFlag 88)
							(or
								((ScriptID 895 0) has: 22) ; pepper, Wood_Cutting_a
								((ScriptID 895 0) has: 43) ; pepper, Wood_Cutting_b
							)
						)
						(= local11 1)
						(gGame handsOn:)
						(self dispose:)
					)
					(else
						(self cue:)
					)
				)
			)
			(3
				(cond
					((IsFlag 135)
						(gGame handsOn:)
						(= local11 1)
						(self dispose:)
					)
					((and (not local1) (not (IsFlag 88)) (IsFlag 228))
						(self setScript: sayBW2 self)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(4
				(if
					(and
						(not local9)
						(IsFlag 228)
						(not ((ScriptID 895 0) has: 22)) ; pepper, Wood_Cutting_a
						(not ((ScriptID 895 0) has: 43)) ; pepper, Wood_Cutting_b
						(not ((ScriptID 895 0) has: 44)) ; pepper, Wood_Cutting_c
					)
					(self setScript: getProverbs self)
				else
					(self cue:)
				)
			)
			(5
				(if (and (not local1) (IsFlag 228))
					(gGame handsOn:)
					(= local11 1)
					(= local9 0)
					(self dispose:)
				else
					(gGame points: 224 1)
					(= global195 12)
					(gCast eachElementDo: #stopUpd)
					(= cycles 1)
				)
			)
			(6
				(= local9 0)
				(gCurRoom newRoom: 291)
				(self dispose:)
			)
		)
	)
)

(instance sayBW2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= global215 79)
				(gMessager say: 2 7 22 1 2 self 2012) ; "Uh, Mr. Richard? Is there any way you could let me have that key? I need it for something really, really important!"
			)
			(1
				(gMessager say: 2 7 22 3 10 self 2012) ; "What are proverbs, Mr. Richard?"
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance sTalkRev2 of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if
					(or
						(not (gLongSong handle:))
						(not (== (gLongSong number:) 230))
					)
					(gLongSong number: 230 setLoop: -1 play:)
				)
				(if
					(and
						(not (IsFlag 109))
						(not (IsFlag 121))
						(proc875_1 local2 global204)
						(proc875_1 local2 global206)
						(proc875_1 local2 global208)
						(proc875_1 local2 global205)
						(proc875_1 local2 global207)
						(proc875_1 local2 global209)
					)
					(SetFlag 133)
				)
				(= cycles 1)
			)
			(1
				(if (IsFlag 133)
					(gMessager say: 14 85 93 0 self) ; "'Scuse me, little dude, but my joints are getting stiff. I feel the need to fling!"
				else
					(= cycles 1)
				)
			)
			(2
				(cond
					((IsFlag 133)
						(gGame handsOn:)
						(= local11 1)
						(self dispose:)
					)
					((not local3)
						(switch gAct
							(2
								(= temp0 79)
							)
							(3
								(= temp0 80)
							)
						)
						(= global215 32)
						(gMessager say: 14 85 temp0 0 self)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(3
				(= global195 10)
				(gCast eachElementDo: #stopUpd)
				(= cycles 1)
			)
			(4
				(gCurRoom newRoom: 291)
				(= local11 1)
				(self dispose:)
			)
		)
	)
)

(instance sTalkQuibble of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= global215 28)
				(if
					(or
						(not (gLongSong handle:))
						(not (OneOf (gLongSong number:) 231 232))
					)
					(if (not (IsFlag 229))
						(gLongSong number: 231 setLoop: -1 play:)
					else
						(gLongSong number: 233 setLoop: -1 play:)
					)
				)
				(= cycles 2)
			)
			(1
				(if (and (!= (gEgo x:) 254) (!= (gEgo y:) 154))
					(-- state)
					(gEgo setMotion: PolyPath 254 154 self)
				else
					(gEgo setHeading: 0 self)
				)
			)
			(2
				(if
					(and
						(not (IsFlag 103))
						(not (IsFlag 115))
						(proc875_1 local4 global204)
						(proc875_1 local4 global206)
						(proc875_1 local4 global208)
						(proc875_1 local4 global205)
						(proc875_1 local4 global207)
						(proc875_1 local4 global209)
					)
					(SetFlag 127)
				)
				(= cycles 1)
			)
			(3
				(if (IsFlag 127)
					(cond
						((and (not (IsFlag 229)) (== gAct 3))
							(= temp0 33)
						)
						((and (not (IsFlag 236)) (== gAct 5))
							(= temp0 32)
						)
						((IsFlag 229)
							(= temp0 32)
						)
						(else
							(= temp0 33)
						)
					)
					(gMessager say: 18 85 temp0 0 self)
				else
					(= cycles 1)
				)
			)
			(4
				(cond
					((IsFlag 127)
						(gGame handsOn:)
						(= local11 1)
						(self dispose:)
					)
					((not local5)
						(switch gAct
							(2
								(= temp0 68)
							)
							(3
								(= temp0 12)
							)
							(4
								(= temp0 13)
							)
							(5
								(= temp0 18)
							)
						)
						(gMessager say: 18 85 temp0 0 self)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(5
				(= global195 4)
				(gCast eachElementDo: #stopUpd)
				(= cycles 1)
			)
			(6
				(SetFlag 170)
				(gCurRoom newRoom: 291)
				(= local11 1)
				(self dispose:)
			)
		)
	)
)

(instance sTalkVicar of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if
					(or
						(not (gLongSong handle:))
						(not (OneOf (gLongSong number:) 231 232))
					)
					(if (not (IsFlag 229))
						(gLongSong number: 231 setLoop: -1 play:)
					else
						(gLongSong number: 233 setLoop: -1 play:)
					)
				)
				(gGame points: 220 1)
				(if (and (!= (gEgo x:) 254) (!= (gEgo y:) 154))
					(-- state)
					(gEgo setMotion: PolyPath 254 154 self)
				else
					(gEgo setHeading: 0 self)
				)
			)
			(1
				(= cycles 2)
			)
			(2
				(if
					(and
						(not (IsFlag 104))
						(not (IsFlag 116))
						(proc875_1 local6 global204)
						(proc875_1 local6 global206)
						(proc875_1 local6 global208)
						(proc875_1 local6 global205)
						(proc875_1 local6 global207)
						(proc875_1 local6 global209)
					)
					(SetFlag 128)
				)
				(= cycles 1)
			)
			(3
				(if (IsFlag 128)
					(if (IsFlag 229)
						(= temp0 94)
					else
						(= temp0 95)
					)
					(gMessager say: 29 85 temp0 0 self)
				else
					(= cycles 1)
				)
			)
			(4
				(cond
					((IsFlag 128)
						(gGame handsOn:)
						(= local11 1)
						(self dispose:)
					)
					((not local7)
						(switch gAct
							(2
								(= temp0 120)
							)
							(3
								(= temp0 34)
							)
							(4
								(= temp0 19)
							)
							(5
								(= temp0 30)
							)
						)
						(gMessager say: 29 85 temp0 0 self)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(5
				(= global195 5)
				(gCast eachElementDo: #stopUpd)
				(= cycles 1)
			)
			(6
				(SetFlag 171)
				(gCurRoom newRoom: 291)
				(= local11 1)
				(self dispose:)
			)
		)
	)
)

(instance sGiveRevelerProverb of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local11 0)
				(gGame handsOff: points: 217 2)
				(if (or (not (gLongSong handle:)) (== (gLongSong number:) 230))
					(gLongSong number: 230 setLoop: -1 play:)
				)
				(SetFlag 96)
				(sThrowFrisbee dispose:)
				(frisbee dispose:)
				(gMessager say: 14 141 22 0 self) ; "Mr. Hardy, I think you might find this very interesting."
				(gEgo put: 22) ; Wood_Cutting_a
				(if (and (not (gEgo has: 43)) (not (gEgo has: 44))) ; Wood_Cutting_b, Wood_Cutting_c
					(SetFlag 88)
				)
			)
			(1
				(reveler2
					view: 826
					setLoop: 0
					setCycle: Walk
					setMotion: MoveTo 40 140 self
				)
				((ScriptID 895 0) ; pepper
					setMotion: MoveTo -10 ((ScriptID 895 0) y:) self ; pepper
				)
			)
			(2)
			(3
				(gCurRoom newRoom: 210)
			)
		)
	)
)

(instance sGiveProverbQuibble of Script
	(properties)

	(method (changeState newState &tmp [temp0 52])
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame points: 229 2)
				(= local11 0)
				(if (not (== (gLongSong number:) 231))
					(gLongSong number: 231 setLoop: -1 play:)
				)
				(= cycles 1)
			)
			(1
				((ScriptID 895 0) setMotion: PolyPath 211 144 self) ; pepper
			)
			(2
				((ScriptID 895 0) setHeading: 45) ; pepper
				(gEgo put: 22) ; Wood_Cutting_a
				(if (and (not (gEgo has: 43)) (not (gEgo has: 44))) ; Wood_Cutting_b, Wood_Cutting_c
					(SetFlag 87)
				)
				(gMessager say: 18 135 0 1 4 self) ; "Miss Quabble, I have something for you! I'd appreciate it if you would read it..."
			)
			(3
				(gLongSong number: 234 setLoop: -1 play:)
				(gMessager say: 18 135 0 5 7 self) ; "Well, that's ridiculous! That's stupid! That's...that's true. Oh, dear! <Sob!> Oh, Victor, how could I have been so mean to you?"
			)
			(4
				(quibblers setLoop: 1 cel: 0 setCycle: End self)
			)
			(5
				(gMessager say: 18 135 0 8 11 self) ; "Quibby-wips!"
			)
			(6
				((ScriptID 895 0) setHeading: 180) ; pepper
				(= seconds 2)
			)
			(7
				((ScriptID 895 0) ; pepper
					view: 234
					setLoop: 2
					setCel: 0
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(8
				((ScriptID 895 0) setCycle: CycleBet 1 2 2 self) ; pepper
			)
			(9
				((ScriptID 895 0) setCycle: 0 normalize:) ; pepper
				(quibblers setCycle: Beg self)
			)
			(10
				(gLongSong fade:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance specialEdQuibblers of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong number: 952 setLoop: -1 play:)
				(gGame handsOff:)
				((ScriptID 895 0) setMotion: PolyPath 269 123 self) ; pepper
			)
			(1
				((ScriptID 895 0) setHeading: 315) ; pepper
				(if (IsFlag 441)
					(gMessager say: 18 70 2 0 self) ; "Mmmm...No thanks, little boy. I read it the first time. <giggle!>"
				else
					(gMessager say: 18 70 0 0 self) ; "Miss Quabble, if you'd take your lips off that man for a minute, I have something to show you!"
				)
			)
			(2
				(gTheIconBar advanceCurIcon:)
				(gGame handsOn: points: 441 2)
				(gLongSong fade:)
				(proc875_5)
				(self dispose:)
			)
		)
	)
)

(instance poorRichard of Prop
	(properties
		x 138
		y 94
		noun 1
		modNum 2012
		approachX 99
		approachY 122
		_approachVerbs 15
		view 235
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(gMessager say: 1 7 0 0 0 2012) ; "Don't be cheeky, lad. I'll smack thee in the head."
			)
			(6 ; Look
				(gMessager say: 1 6 0 0 0 2012) ; "Poor Richard is busy carving something. He seems to be very good at it."
			)
			(85 ; Talk
				(cond
					((IsFlag 88)
						(gGame points: 461 1)
					)
					((IsFlag 87)
						(gGame points: 460 1)
					)
				)
				(gCurRoom setScript: sTalkPoorRich)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance stand of View
	(properties
		x 101
		y 42
		noun 26
		view 230
		loop 1
		priority 8
		signal 18449
	)

	(method (doVerb theVerb)
		(switch theVerb
			(84 ; Trivia
				(= global215 16)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance keyOnStand of View
	(properties
		x 120
		y 67
		noun 2
		modNum 2012
		approachX 105
		approachY 121
		_approachVerbs 9
		view 229
		cel 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(if (IsFlag 24)
					(gMessager say: 2 6 25 0 0 2012) ; "Poor Richard's brass key lies among the wreckage."
				else
					(gMessager say: 2 6 31 0 0 2012) ; "A shiny brass key hangs from a peg on the stand."
				)
			)
			(7 ; Do
				(if (IsFlag 24)
					(gGame points: 230 1)
					(gCurRoom setScript: sGetKeyOk)
				else
					(gGame points: 228 1)
					(gCurRoom setScript: sGetKeyNotYet)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance carpetBag of View
	(properties
		x 111
		y 85
		noun 4
		view 229
		cel 2
		signal 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(gGame points: 231 1)
				(gCurRoom setScript: sTakeCarpetBag)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bagOfMarbles of View
	(properties
		x 206
		y 111
		noun 20
		approachX 222
		approachY 130
		view 229
		cel 1
		signal 4096
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(gCurRoom setScript: getBag)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance stampActPoster of Prop
	(properties
		x 222
		y 104
		noun 24
		approachX 233
		approachY 133
		view 261
		cel 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(if (< gAct 4)
					(Load rsVIEW 261)
					(gEgo view: 2000)
					(gCurRoom setInset: taxPoster)
				else
					(gCurRoom setScript: doInset)
				)
			)
			(84 ; Trivia
				(gLongSong2 number: 927 setLoop: 1 play:)
				(gMessager say: 24 84) ; "|c1|FALSE. The REAL Stamp Act forced the colonists to buy stamps in order to purchase legal documents, playing cards, liquor licenses, newspapers, and other paper goods.|c|"
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance quibblers of Prop
	(properties
		x 254
		y 119
		noun 18
		view 232
		cel 7
		signal 1
	)
)

(instance reveler2 of Actor
	(properties
		x 64
		y 153
		noun 14
		approachX 86
		approachY 158
		view 207
	)

	(method (doVerb theVerb)
		(switch theVerb
			(85 ; Talk
				(switch gAct
					(2
						(gGame points: 222 1)
					)
					(3
						(gGame points: 489 1)
					)
				)
				(gCurRoom setScript: sTalkRev2)
			)
			((OneOf theVerb 137 143 135 140 138 139 136) ; ???, ???, ???, ???, ???, ???, ???
				(gMessager say: 14 141 1) ; "Check this out, Throcky!"
			)
			(141 ; ???
				(gCurRoom setScript: sGiveRevelerProverb)
			)
			(7 ; Do
				(= global215 108)
				(super doVerb: theVerb)
			)
			(84 ; Trivia
				(= global215 49)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance frisbee of Actor
	(properties
		x 30
		y 112
		view 208
		loop 2
		priority 12
		signal 16
	)
)

(instance hole of Feature
	(properties
		x 34
		y 199
		noun 31
		nsTop 97
		nsLeft 21
		nsBottom 105
		nsRight 47
		sightAngle 40
	)

	(method (doVerb theVerb)
		(if (== theVerb 84) ; Trivia
			(gLongSong2 number: 927 setLoop: 1 play:)
			(super doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance tree of Feature
	(properties
		noun 28
		approachX 206
		approachY 131
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(cond
					(
						(and
							(== gAct 4)
							(not (gEgo has: 29)) ; Puzzle_Box
							(not (gEgo has: 30)) ; Love_Letters
							(not (IsFlag 246))
						)
						(gGame points: 233 1)
						(gCurRoom setInset: inBfDr)
					)
					((> gAct 3)
						(gCurRoom setInset: inEmpty)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(7 ; Do
				(cond
					(
						(and
							(== gAct 4)
							(not (IsFlag 246))
							(not (gEgo has: 29)) ; Puzzle_Box
							(not (gEgo has: 30)) ; Love_Letters
						)
						(gCurRoom setInset: inBfDr)
					)
					((> gAct 3)
						(gCurRoom setInset: inEmpty)
					)
					(else
						(super doVerb: theVerb)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance boxOfLetters of Feature
	(properties
		x 161
		y 189
		z 100
		noun 7
		nsTop 81
		nsLeft 123
		nsBottom 110
		nsRight 199
	)

	(method (doVerb theVerb)
		(switch theVerb
			(128 ; Exit
				((gCurRoom inset:) dispose:)
			)
			(7 ; Do
				(gEgo get: 29) ; Puzzle_Box
				(gGame points: 235 1)
				(gCurRoom setInset: 0)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance knob of Feature
	(properties
		x 162
		y 189
		z 100
		noun 6
		nsTop 79
		nsLeft 152
		nsBottom 100
		nsRight 172
		sightAngle 40
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(gGame points: 234 2)
				(gCurRoom setInset: inLoveLetters)
				(gLongSong2 number: 2304 setLoop: 1 play:)
				(gMessager say: 6 7) ; "It's a secret door!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bench of Feature
	(properties
		x 258
		y 121
		noun 1
		nsTop 111
		nsLeft 232
		nsBottom 132
		nsRight 285
		sightAngle 40
	)

	(method (doVerb theVerb)
		(= global215 41)
		(super doVerb: theVerb)
	)
)

(instance benHouse of Feature
	(properties
		x 69
		y 15
		noun 2
		nsLeft 43
		nsBottom 31
		nsRight 95
		sightAngle 40
	)
)

(instance buildings of Feature
	(properties
		x 9
		y 50
		noun 3
		nsTop 27
		nsBottom 73
		nsRight 18
		sightAngle 40
	)
)

(instance hills of Feature
	(properties
		noun 11
	)
)

(instance quibble of Feature
	(properties
		x 269
		y 123
		noun 18
		nsTop 91
		nsLeft 259
		nsBottom 135
		nsRight 279
		sightAngle 40
		approachX 246
		approachY 144
		approachDist 50
		_approachVerbs 9
	)

	(method (doVerb theVerb &tmp temp0)
		(if (OneOf theVerb 7 6 84) ; Do, Look, Trivia
			(if (IsFlag 229)
				(= temp0 50)
			else
				(= temp0 129)
			)
		)
		(switch theVerb
			(7 ; Do
				(gMessager say: 18 7 temp0)
			)
			(6 ; Look
				(gMessager say: 18 6 temp0)
			)
			(85 ; Talk
				(if (and (== gAct 3) (IsFlag 229))
					(gMessager say: 18 85 32 0) ; "Quibble is too moonstruck to talk to Pepper."
				else
					(switch gAct
						(2
							(gGame points: 221 1)
						)
						(3
							(gGame points: 455 1)
						)
						(4
							(gGame points: 456 1)
						)
						(5
							(gGame points: 457 1)
						)
					)
					(quibblers stopUpd:)
					(gCurRoom setScript: sTalkQuibble)
				)
			)
			((OneOf theVerb 137 143 141 140 138 139 136) ; ???, ???, ???, ???, ???, ???, ???
				(gMessager say: 18 95 0 0) ; "Miss Quabble, would you take a look at this pretty carving?"
			)
			(135 ; ???
				(gCurRoom setScript: sGiveProverbQuibble)
			)
			(70 ; Special_Edition
				(gCurRoom setScript: specialEdQuibblers)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance vicar of Feature
	(properties
		x 244
		y 122
		noun 29
		nsTop 92
		nsLeft 231
		nsBottom 133
		nsRight 257
		sightAngle 40
		approachX 241
		approachY 144
		approachDist 50
	)

	(method (doVerb theVerb &tmp temp0)
		(if (OneOf theVerb 7 6 84) ; Do, Look, Trivia
			(if (IsFlag 229)
				(= temp0 50)
			else
				(= temp0 129)
			)
		)
		(switch theVerb
			(7 ; Do
				(gMessager say: 29 7 temp0)
			)
			(6 ; Look
				(gMessager say: 29 6 temp0)
			)
			(85 ; Talk
				(if (and (== gAct 3) (IsFlag 229))
					(gMessager say: 29 85 94 0) ; "Vicar Bicker is too bedazzled by Quibble's beauty to talk to Pepper."
				else
					(switch gAct
						(2
							(gGame points: 220 1)
						)
						(3
							(gGame points: 452 1)
						)
						(4
							(gGame points: 453 1)
						)
						(5
							(gGame points: 454 1)
						)
					)
					(quibblers stopUpd:)
					(gCurRoom setScript: sTalkVicar)
				)
			)
			((OneOf theVerb 137 143) ; ???, ???
				(gMessager say: 29 95) ; "Could you take a look at this, Mr. Bicker?"
			)
			(135 ; ???
				(gMessager say: 29 94 92) ; "Mr. Bicker, I think you might find this interesting."
			)
			(70 ; Special_Edition
				(gMessager say: 29 70) ; "Vicar Bicker, I'd like to give you something that could change your WHOLE LIFE!"
			)
			(84 ; Trivia
				(= global215 100)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance taxPoster of Inset
	(properties
		view 238
		x 91
		y 141
		disposeNotOnMe 1
		noun 23
	)

	(method (init)
		(proc883_6 1)
		(gTheIconBar disable: 3 9)
		(super init: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(gMessager say: 24 7) ; "Pepper doesn't want to get arrested for tearing the Stamp Act sign down."
			)
			(6 ; Look
				(= global215 16)
				(gMessager say: 24 6) ; "This appears to be a taxation notice. It says: "Let it be Known that the Crown has passed the Stamp Act, and the Citizens of Philadelphia will be Taxed accordingly.""
			)
			(84 ; Trivia
				(gLongSong2 number: 927 setLoop: 1 play:)
				(gMessager say: 24 84) ; "|c1|FALSE. The REAL Stamp Act forced the colonists to buy stamps in order to purchase legal documents, playing cards, liquor licenses, newspapers, and other paper goods.|c|"
			)
			(128 ; Exit
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(if (== gAct 4)
			(stampActPoster dispose:)
		)
		(gTheIconBar enable: 3 9)
		(proc883_6 0)
		(gEgo normalize:)
		(super dispose:)
	)
)

(instance inEmpty of Inset
	(properties
		view 236
		cel 2
		x 58
		y 151
		disposeNotOnMe 1
	)

	(method (doVerb theVerb)
		(switch theVerb
			(128 ; Exit
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (init)
		(proc883_6 1)
		(gTheIconBar disable: 3 9)
		(super init: &rest)
	)

	(method (dispose)
		(gTheIconBar enable: 3 9)
		(proc883_6 0)
		(super dispose: &rest)
	)
)

(instance inLoveLetters of Inset
	(properties
		view 236
		cel 1
		x 58
		y 151
		disposeNotOnMe 1
		noun 12
	)

	(method (init)
		(proc883_6 1)
		(super init: &rest)
		(if
			(and
				(not (> gAct 4))
				(not (gEgo has: 29)) ; Puzzle_Box
				(not (gEgo has: 30)) ; Love_Letters
				(not (IsFlag 246))
			)
			(boxOfLetters init:)
		)
		(gTheIconBar disable: 3 9)
	)

	(method (dispose)
		(boxOfLetters dispose:)
		(gTheIconBar enable: 3 9)
		(proc883_6 0)
		(super dispose:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(128 ; Exit
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance inBfDr of Inset
	(properties
		view 236
		x 58
		y 151
		disposeNotOnMe 1
		noun 12
	)

	(method (init)
		(proc883_6 1)
		(super init: &rest)
		(knob init:)
		(stampActPoster dispose:)
		(gTheIconBar disable: 3 9)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(6 ; Look
				(gGame points: 233 1)
				(super doVerb: theVerb)
			)
			(128 ; Exit
				(self dispose:)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		(knob dispose:)
		(gTheIconBar enable: 3 9)
		(proc883_6 0)
		(super dispose: &rest)
	)
)

(instance eastEFeature of ExitFeature
	(properties
		nsTop 157
		nsLeft 310
		nsBottom 190
		nsRight 321
		cursor 913
		exitDir 2
		noun 8
	)
)

(instance westEFeature of ExitFeature
	(properties
		nsTop 72
		nsBottom 137
		nsRight 9
		cursor 911
		exitDir 4
		noun 27
	)
)

(instance poorRichardTalker of BalloonTalker
	(properties
		x 132
		y 88
		talkWidth 180
		tailPosn 3
	)

	(method (say)
		(poorRichard stopUpd:)
		(super say: &rest)
	)
)

(instance reveler2Talker of BalloonTalker
	(properties
		x 80
		y 105
		talkWidth 150
	)
)

(instance quibbleTalker of BalloonTalker
	(properties
		x 118
		y 94
		talkWidth 150
		tailPosn 1
	)
)

(instance vicarTalker of BalloonTalker
	(properties
		x 90
		y 90
		talkWidth 150
		tailPosn 1
	)
)

(instance sentry1Talker of BalloonTalker
	(properties
		x 70
		y 107
		talkWidth 160
	)
)

(instance sentry2Talker of BalloonTalker
	(properties
		x 70
		y 107
		talkWidth 160
	)
)

(instance offScreenTalker of BalloonTalker
	(properties
		x 10
		y 80
		talkWidth 160
	)
)

