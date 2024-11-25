;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 260)
(include sci.sh)
(use Main)
(use ExitFeature)
(use smell)
(use OccasionalCycle)
(use BalloonTalker)
(use ADRoom)
(use Scaler)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm260 0
	offScreenTalker 1
	rolandTalker 2
	pennyTalker 6
	gluttonTalker 7
)

(local
	local0
	local1
	local2 = 1
	local3 = 1
	local4 = 5
	local5
	local6
	local7
	local8
	local9
	local10
)

(instance rm260 of ADRoom
	(properties
		noun 18
		picture 260
		horizon 75
		north 280
		vanishingY -60
	)

	(method (cue)
		(gLongSong number: 260 setLoop: -1 play:)
	)

	(method (init)
		(if (not (IsFlag 284))
			(= local10 1)
		)
		(if (not gAct)
			(= gAct 2)
			(proc875_0)
		)
		(gEgo init: normalize: setScale: Scaler 100 54 124 104)
		(self
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 0 189 170 189 186 168 294 169 319 108 278 109 245 114 161 137 185 144 140 157 106 147 0 171
					yourself:
				)
		)
		(<<= local2 $0001)
		(<<= local3 $0002)
		(= global114 1)
		(if (and (not (IsFlag 273)) (== gAct 3))
			(goat
				approachVerbs: 7 85 97 153 ; Do, Talk, ???, ???
				setPri: -1
				setLoop: 4
				x: 208
				y: 173
				init:
				stopUpd:
			)
		)
		(switch gPrevRoomNum
			(280
				(self setScript: sExitPO)
			)
			(291
				(= global114 0)
				(self picture: 0)
				(if (== global195 3)
					(= local6 1)
					(glutton
						view: (if (IsFlag 263) 263 else 264)
						init:
						setLoop: 1
						cel: 5
						stopUpd:
					)
				else
					(= local5 1)
					(if (IsFlag 262)
						(penny init: view: 262 setLoop: 6 cel: 0 stopUpd:)
					else
						(penny init: view: 260 setLoop: 2 cel: 0 stopUpd:)
					)
				)
				(DrawPic 260 100 1)
				(gCurRoom setScript: sFinishConversation)
			)
			(116
				(= global114 0)
				(= picture 0)
				(DrawPic 260 100 1)
			)
			(else
				(SetFlag 10)
				(gEgo x: -26 y: 227 normalize:)
				(self setScript: sEnterRoom)
			)
		)
		(if
			(and
				(== global114 1)
				(or
					(not (IsFlag 101))
					(proc875_1 local2 global204)
					(proc875_1 local2 global206)
					(proc875_1 local2 global208)
				)
			)
			(SetFlag 125)
		)
		(if
			(and
				(== global114 1)
				(or
					(not (IsFlag 102))
					(proc875_1 local3 global204)
					(proc875_1 local3 global206)
					(proc875_1 local3 global208)
				)
			)
			(SetFlag 126)
		)
		(super init: &rest)
		(if (not (== gPrevRoomNum 291))
			(gLongSong number: 260 setLoop: -1 play:)
		)
		(if (not (IsFlag 267))
			(gambler
				init:
				approachVerbs: 85 7 6 136 ; Talk, Do, Look, ???
				setCycle: OccasionalCycle gambler 1 5 15
			)
		)
		(if (IsFlag 266)
			(glutDoor approachVerbs: 7 init: ignoreActors: 1 addToPic:) ; Do
		)
		(if (IsFlag 265)
			(penDoor approachVerbs: 7 init: ignoreActors: 1 addToPic:) ; Do
		)
		(if
			(and
				(gCast contains: gambler)
				(not (== gPrevRoomNum 291))
				(not (IsFlag 260))
				(not (IsFlag 264))
				(== gAct 2)
			)
			(gambler setScript: randomRoland)
		)
		(if (IsFlag 284)
			(poDoor init: ignoreActors: 1 addToPic:)
		)
		(bench init: setOnMeCheck: 1 1024)
		(carpentryDoor approachVerbs: 7 85 init:) ; Do, Talk
		(carpentryShop init:)
		(carpentrySign init:)
		(carpWindow init: setOnMeCheck: 1 16384)
		(leaves init: setOnMeCheck: 1 8192)
		(postDoor approachVerbs: 7 85 init:) ; Do, Talk
		(postOffice init:)
		(postSign init:)
		(postWindow init: setOnMeCheck: 1 4096)
		(pubDoor approachVerbs: 7 85 init:) ; Do, Talk
		(pubShop init:)
		(pubSign init:)
		(pubWindow init: setOnMeCheck: 1 2048)
		(southEFeature init:)
		(if (OneOf gPrevRoomNum 116 291)
			(self curPic: 260 picture: 260)
		)
	)

	(method (doit)
		(cond
			((gCurRoom script:) 0)
			((and local10 (gEgo inRect: 269 100 274 120))
				(gLongSong fade:)
				(gCurRoom newRoom: 280)
			)
			((and (< (gEgo x:) 70) (> (gEgo y:) 187))
				(gCurRoom setScript: exitSouth)
			)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(if (not local8)
			(gLongSong fade:)
		)
		(super dispose: &rest)
	)

	(method (newRoom newRoomNumber)
		(gambler setCycle: 0)
		(super newRoom: newRoomNumber)
	)
)

(instance exitSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 895 0) ; pepper
					setMotion: MoveTo (- ((ScriptID 895 0) x:) 30) 250 self ; pepper
				)
			)
			(1
				(gCurRoom newRoom: 230)
			)
		)
	)
)

(instance randomRoland of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (gCurRoom script:)
					(++ state)
				)
				(= cycles 2)
			)
			(1
				(if gModelessDialog
					(self init:)
				else
					(switch (= temp0 (Random 1 5))
						(1
							(++ local7)
							(gMessager say: 19 0 73 0 self) ; "Games of CHANCE! Games of SKILL! Come make a bet, I know you WILL!"
						)
						(2
							(++ local7)
							(gMessager say: 19 0 74 0 self) ; "Who will PLAY! Be rich TODAY! Your fortune is just a wager AWAY!"
						)
						(3
							(++ local7)
							(gMessager say: 19 0 75 0 self) ; "Who has the nerves to place a BET! No one's ever lost money YET!"
						)
						(4
							(++ local7)
							(gMessager say: 19 0 76 0 self) ; "Come play MARBLES, JACKS, or HEARTS! I even play OLD MAID and DARTS!"
						)
						(5
							(if (and (not (IsFlag 138)) (> local7 4))
								(gMessager say: 19 0 77 0 self) ; "Okay, I'm, like, totally sick of rhyming. Kid, get your britches over here NOW!!!"
							else
								(self cue:)
							)
						)
					)
				)
			)
			(2
				(= seconds (Random 7 17))
			)
			(3
				(self init:)
			)
		)
	)
)

(instance sTalkPub of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(randomRoland dispose:)
				(if (and (!= (gEgo x:) 92) (!= (gEgo y:) 158))
					(-- state)
					(gEgo setMotion: PolyPath 92 158 self)
				else
					(gEgo setHeading: 310 self)
				)
			)
			(1
				(gambler setCycle: 0 stopUpd:)
				(= cycles 1)
			)
			(2
				(switch register
					(7
						(if (not (gCast contains: glutton))
							(self setScript: knockPubDoor self)
						else
							(self cue:)
						)
					)
					(85
						(gMessager say: 14 85 0 0 self) ; "Hello?"
					)
				)
			)
			(3
				(if (== register 7)
					(self cue:)
				else
					(= register 0)
					(gGame handsOn:)
					(self dispose:)
				)
			)
			(4
				(if (IsFlag 263)
					(glutton view: 263 setLoop: 3 cel: 0 init:)
					(gLongSong number: 262 setLoop: -1 play:)
				else
					(glutton init: cel: 0 stopUpd:)
					(gLongSong number: 261 setLoop: -1 play:)
				)
				(if local1
					(gMessager say: 14 7 1 0 self) ; "Pepper knocks, but there is no answer."
				else
					(self cue:)
				)
			)
			(5
				(glutton setCycle: CT 5 1 self)
			)
			(6
				(if (IsFlag 263)
					(glutton
						view: 263
						setLoop: 1
						setCycle: OccasionalCycle self 1 10 50
					)
				else
					(glutton
						view: 264
						setLoop: 1
						setCycle: OccasionalCycle self 1 10 50
					)
				)
				(gGame handsOn:)
				(gambler cue:)
				(self dispose:)
			)
		)
	)
)

(instance sTalkGoat of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(offScreenTalker x: 45 y: 139)
				(Load rsVIEW 2001)
				(gEgo setHeading: 180 self)
				(randomRoland dispose:)
			)
			(1
				(if (== (goat loop:) 4)
					(goat setCycle: Beg self)
				else
					(= cycles 2)
				)
			)
			(2
				(gEgo stopUpd:)
				(= cycles 2)
			)
			(3
				(if (== (Random 0 5) 4)
					(= local9 1)
					(gMessager say: 21 85 23 0 self) ; "Mr. Goat, do you have any comments on the current situation in Philadelphia?"
				else
					(= local9 0)
					(gMessager say: 21 85 0 1 self) ; "Hello, Mr. Goat. Do you have any comments on the current situation in Philadelphia?"
				)
			)
			(4
				(if local9
					(self cue:)
				else
					(gMessager say: 21 85 0 2 self) ; "Maaaaaaaaaah!"
					(gLongSong2 number: 2308 setLoop: 1 play:)
				)
			)
			(5
				(if (not (IsFlag 264))
					(gambler setScript: randomRoland)
				)
				(gGame handsOn:)
			)
		)
	)
)

(instance sEnterRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo setLoop: 6 setMotion: MoveTo 46 182 self)
			)
			(1
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sExitPO of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gEgo x: 277 y: 111 setMotion: MoveTo 277 126 self)
			)
			(1
				(gGame handsOn:)
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
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(if (== global115 9)
					((ScriptID 2000 3) winX: 50 winY: 111 tailPosn: 4) ; PepperTalker
				)
				(gambler setCycle: 0 stopUpd:)
				(= cycles 2)
			)
			(2
				(cond
					((and global115 (== global116 32))
						(= gDictionaryWord 19)
						(= state 79)
						(gMessager say: global115 85 32 1 2 self global196)
					)
					((and global115 (== global116 26))
						(= gDictionaryWord 29)
						(= state 69)
						(gMessager say: global115 85 26 1 2 self global196)
					)
					((and global115 (== global116 5))
						(= gDictionaryWord 49)
						(= state 59)
						(gMessager say: global115 85 5 1 self global196)
					)
					((and global115 (== global116 26))
						(= gDictionaryWord 22)
						(= state 9)
						(gMessager say: global115 85 26 1 3 self global196)
					)
					((and global115 (== global116 118))
						(= gDictionaryWord 46)
						(= state 49)
						(gMessager say: global115 85 118 1 4 self global196)
					)
					((and global115 (== global116 102))
						(= gDictionaryWord 22)
						(= state 39)
						(gMessager say: global115 85 102 1 3 self global196)
					)
					((and global115 (== global116 66))
						(= gDictionaryWord 84)
						(= state 19)
						(gMessager say: global115 85 66 1 self global196)
					)
					((and global115 (== global116 65))
						(= gDictionaryWord 57)
						(= state 29)
						(gMessager say: global115 85 65 1 4 self global196)
					)
					((and global115 global116)
						(switch global116
							(119
								(= gDictionaryWord 57)
							)
							(113
								(= gDictionaryWord 108)
							)
							(124
								(= gDictionaryWord 57)
							)
						)
						(= state 99)
						(gMessager say: global115 85 global116 0 self global196)
					)
					(else
						(= state 99)
						(= cycles 1)
					)
				)
			)
			(10
				(= state 99)
				(gMessager say: global115 85 26 4 8 self global196)
			)
			(20
				(= gDictionaryWord 98)
				(gMessager say: global115 85 66 2 3 self global196)
			)
			(21
				(= state 99)
				(gMessager say: global115 85 66 4 6 self global196)
			)
			(30
				(= state 99)
				(gMessager say: global115 85 65 5 9 self global196)
			)
			(40
				(= state 99)
				(gMessager say: global115 85 102 4 self global196)
			)
			(50
				(= state 99)
				(gMessager say: global115 85 118 5 6 self global196)
			)
			(60
				(= state 99)
				(gMessager say: global115 85 5 2 self global196)
			)
			(70
				(= state 99)
				(gMessager say: global115 85 26 3 5 self global196)
			)
			(80
				(= state 99)
				(gMessager say: global115 85 32 3 self global196)
			)
			(100
				((ScriptID 2000 3) winX: 0 winY: 0) ; PepperTalker
				(gambler cue:)
				(cond
					((gCast contains: glutton)
						(glutton
							setLoop: 1
							setCycle: OccasionalCycle self 1 10 50
						)
						(= ticks 10)
					)
					((gCast contains: penny)
						(penny view: 260 setLoop: (if (IsFlag 262) 1 else 2))
						(= ticks 10)
					)
					(else
						(self cue:)
					)
				)
			)
			(101
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetPenny of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(randomRoland dispose:)
				(penny view: 260 setLoop: 1 setCel: 7 init: stopUpd:)
				(gambler setCycle: 0 stopUpd:)
				(= cycles 2)
			)
			(1
				(cond
					((and (== gAct 3) (IsFlag 262))
						(self cue:)
					)
					(local0
						(gMessager say: 2 7 1 0 self) ; "Excuse me, child, but I really must polish my coins now. I'd hate to see them get dull!"
					)
					(else
						(self cue:)
					)
				)
			)
			(2
				(gLongSong
					number: (if (IsFlag 262) 266 else 265)
					setLoop: -1
					play:
				)
				(penny setCycle: Beg self)
			)
			(3
				(if (not (IsFlag 262))
					(penny
						view: 260
						setLoop: 2
						setCycle: OccasionalCycle self 1 10 50
					)
				else
					(penny
						view: 262
						setLoop: 6
						setCycle: OccasionalCycle self 1 10 50
					)
				)
				(gGame handsOn:)
				(gambler cue:)
				(self dispose:)
			)
		)
	)
)

(instance sGiveProverbPenny of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gGame points: 262 2)
				(= cycles 1)
			)
			(1
				(gLongSong number: 266 setLoop: -1 play:)
				(gMessager say: 9 138 0 0 self) ; "Here, Mrs. Pyncher! You might be interested in this."
			)
			(2
				(penny setCycle: End self)
				(gEgo put: 44) ; Wood_Cutting_c
				(if (and (not (gEgo has: 43)) (not (gEgo has: 22))) ; Wood_Cutting_b, Wood_Cutting_a
					(SetFlag 88)
				)
			)
			(3
				(gLongSong fade: gCurRoom)
				(penny dispose:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTalkPenny of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if
					(and
						(not (IsFlag 101))
						(not (IsFlag 113))
						(proc875_1 local2 global204)
						(proc875_1 local2 global206)
						(proc875_1 local2 global208)
						(proc875_1 local2 global205)
						(proc875_1 local2 global207)
						(proc875_1 local2 global209)
					)
					(SetFlag 125)
				)
				((ScriptID 2000 3) winX: 50 winY: 108 tailPosn: 4) ; PepperTalker
				(gambler setCycle: 0 stopUpd:)
				(= cycles 2)
			)
			(1
				(if (IsFlag 125)
					(switch gAct
						(2
							(= temp0 63)
						)
						(3
							(= temp0 29)
						)
						(4
							(= temp0 64)
						)
						(5
							(= temp0 30)
						)
					)
					(gMessager say: 19 0 temp0 0 self)
				else
					(= cycles 1)
				)
			)
			(2
				(if (IsFlag 125)
					(self setScript: pennyInside self)
				else
					(self cue:)
				)
			)
			(3
				(cond
					((IsFlag 125)
						(self dispose:)
					)
					((not local5)
						(switch gAct
							(2
								(= temp0 69)
							)
							(3
								(= temp0 70)
							)
							(4
								(= temp0 71)
							)
							(5
								(= temp0 72)
							)
						)
						(gMessager say: 19 0 temp0 0 self)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(4
				(switch gAct
					(2
						(gGame points: 256 1)
					)
					(3
						(gGame points: 466 1)
					)
					(4
						(gGame points: 467 1)
					)
					(5
						(gGame points: 468 1)
					)
				)
				(= global195 2)
				(= cycles 1)
			)
			(5
				(= local8 1)
				(gCurRoom newRoom: 291)
				(self dispose:)
			)
		)
	)
)

(instance sGiveSpEditionPenny of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame points: 265 2 handsOff:)
				(gLongSong number: 952 setLoop: -1 play:)
				(= cycles 1)
			)
			(1
				(gMessager say: 9 70 0 0 self) ; "Penny, Here's something I think you'll really like!"
			)
			(2
				(penny view: 262 loop: 5 cel: 0 setCycle: End self)
			)
			(3
				(gLongSong2 number: 923 setLoop: 1 play: self)
			)
			(4
				(gLongSong fade: gCurRoom)
				(penny dispose:)
				(penDoor approachVerbs: 7 init: ignoreActors: 1 addToPic:) ; Do
				(= ticks 10)
			)
			(5
				(gGame handsOn:)
				(proc875_5)
				(self dispose:)
			)
		)
	)
)

(instance sGiveProverbGlutton of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gambler setCycle: 0 stopUpd:)
				(gGame points: 263 2)
				(= cycles 3)
				((ScriptID 895 0) setHeading: 315) ; pepper
			)
			(1
				(gMessager say: 7 137 0 1 4 self) ; "General Lee, this is for you. You might find it... interesting."
			)
			(2
				(glutton view: 263 setLoop: 0 setCel: 0 setCycle: 0)
				(gLongSong number: 262 setLoop: -1 play:)
				(= ticks 20)
			)
			(3
				(gMessager say: 7 137 0 5 17 self) ; "Moderation, huh? So, why don't you tell me what you ate today?"
			)
			(4
				(glutton setCycle: End self)
			)
			(5
				(glutton setLoop: 3 cel: 5 setCycle: End self)
				(gEgo put: 43) ; Wood_Cutting_b
				(if (and (not (gEgo has: 22)) (not (gEgo has: 44))) ; Wood_Cutting_a, Wood_Cutting_c
					(SetFlag 87)
				)
			)
			(6
				(glutton dispose:)
				(gLongSong fade: gCurRoom)
				(gambler setCycle: OccasionalCycle gambler 1 5 15)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGiveSpEditionGlutton of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 266 2)
				(gLongSong number: 952 setLoop: -1 play:)
				(= cycles 2)
			)
			(1
				(gMessager say: 7 70 0 0 self) ; "Here, General Lee! This is from Ben Franklin to you!"
			)
			(2
				(glutton view: 263 loop: 2 cel: 0 setCycle: End self)
			)
			(3
				(gLongSong2 number: 923 setLoop: 1 play: self)
				(gLongSong fade: gCurRoom)
			)
			(4
				(glutDoor approachVerbs: 7 init: ignoreActors: 1 addToPic:) ; Do
				(glutton dispose:)
				(gGame handsOn:)
				(proc875_5)
				(self dispose:)
			)
		)
	)
)

(instance sGiveProverbGambler of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 264 2)
				(gLongSong number: 263 setLoop: -1 play:)
				(= cycles 2)
			)
			(1
				(gMessager say: 6 136 0 1 6 self) ; "Roland! Hello!  How are you?"
			)
			(2
				((ScriptID 895 0) ; pepper
					view: 805
					setLoop: 5
					setCel: 0
					setCycle: End self
				)
			)
			(3
				(= seconds 2)
			)
			(4
				((ScriptID 895 0) setCycle: Beg self) ; pepper
			)
			(5
				(gLongSong number: 264 setLoop: -1 play:)
				(gMessager say: 6 136 0 7 12 self) ; "Oh, cool, a poem! Let's see:  "Avoid dishonest gain: No price Can recompense the pangs of vice.""
			)
			(6
				((ScriptID 895 0) put: 43 normalize:) ; pepper, Wood_Cutting_b
				(if (not (gEgo has: 22)) ; Wood_Cutting_a
					(SetFlag 24)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGiveSpEditionGambler of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 267 2)
				(gLongSong number: 952 setLoop: -1 play:)
				(= cycles 1)
			)
			(1
				(gMessager say: 6 70 0 1 4 self) ; "Roland! Yo! Whassup?"
			)
			(2
				((ScriptID 895 0) ; pepper
					view: 805
					setLoop: 5
					setCel: 0
					setCycle: End self
				)
			)
			(3
				(= seconds 2)
			)
			(4
				((ScriptID 895 0) setCycle: Beg self) ; pepper
			)
			(5
				(gambler view: 265 setLoop: 4 setCycle: End self)
				(gMessager say: 6 70 0 5 6 self) ; "'Kay, let's see... WHOA! HOLD THE CARRIAGE! Is this TRUE? And I thought I was a dishonest, sneaky street weasel!"
			)
			(6)
			(7
				(gambler stopUpd:)
				(gMessager say: 6 70 0 7 13 self) ; "Right on! (Oh, man, I've been here too long!)"
			)
			(8
				(gambler
					setLoop: 5
					setCycle: Walk
					setMotion: MoveTo 330 143 self
				)
			)
			(9
				(gLongSong fade: gCurRoom)
				(gambler dispose:)
				((ScriptID 895 0) normalize:) ; pepper
				(proc875_5)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGiveGamblerMarbles of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 260 1)
				(randomRoland dispose:)
				(= cycles 1)
			)
			(1
				(gLongSong number: 263 setLoop: -1 play:)
				(cond
					((gCast contains: penny)
						(self setScript: pennyInside self)
					)
					((gCast contains: glutton)
						(self setScript: gluttonInside self)
					)
					(else
						(self cue:)
					)
				)
			)
			(2
				((ScriptID 895 0) setMotion: PolyPath 203 138 self) ; pepper
			)
			(3
				((ScriptID 895 0) setHeading: 225 self) ; pepper
			)
			(4
				(ClearFlag 138)
				(ClearFlag 139)
				(gTheIconBar advanceCurIcon:)
				(gMessager say: 6 123 0 0 self) ; "Hey, Roland, I found this bag of marbles! They may be yours... but they may not be! I don't suppose you'd be interested in buying them?"
			)
			(5
				(gambler view: 265 setCel: 0 setLoop: 3 setCycle: End self)
			)
			(6
				(gGame points: 268 1)
				((ScriptID 895 0) ; pepper
					put: 5 gCurRoomNum ; Bag_of_Marbles
					get: 6 ; A_Shilling
					view: 265
					setLoop: 2
					setCel: 0
					setCycle: End self
				)
			)
			(7
				(gambler view: 267 setLoop: 1 setCel: 11 setCycle: Beg self)
			)
			(8
				((ScriptID 895 0) normalize:) ; pepper
				(gLongSong fade: gCurRoom)
				(gambler stopUpd:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sayGK2 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= gDictionaryWord 84)
				(gMessager say: 19 0 28 1 self) ; "|r||c0|Salutations|c||r| and greetings! <BURP!> Who's there? Oh, it's you, lad. Hello there! Come in and eat something!"
			)
			(1
				(= gDictionaryWord 98)
				(gMessager say: 19 0 28 2 3 self) ; "Thanks, General, but I'm still not hungry. My poor dog is still missing!"
			)
			(2
				(gMessager say: 19 0 28 4 5 self) ; "<Gag!> No thanks. Can I ask you a few more questions, though?"
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sTalkGlutton of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(if
					(and
						(not (IsFlag 102))
						(not (IsFlag 114))
						(proc875_1 local3 global204)
						(proc875_1 local3 global206)
						(proc875_1 local3 global208)
						(proc875_1 local3 global205)
						(proc875_1 local3 global207)
						(proc875_1 local3 global209)
					)
					(SetFlag 126)
				)
				(glutton stopUpd:)
				(gambler setCycle: 0 stopUpd:)
				(switch gAct
					(2
						(gGame points: 258 1)
					)
					(3
						(gGame points: 469 1)
					)
					(4
						(gGame points: 470 1)
					)
					(5
						(gGame points: 471 1)
					)
				)
				(= cycles 3)
			)
			(1
				(if (IsFlag 126)
					(switch gAct
						(2
							(= temp0 60)
						)
						(3
							(= temp0 61)
						)
						(4
							(= temp0 62)
						)
						(5
							(= temp0 31)
						)
					)
					(gMessager say: 19 0 temp0 0 self)
				else
					(self cue:)
				)
			)
			(2
				(if (and (== gAct 3) (IsFlag 263))
					(gMessager say: 19 0 62 0 self) ; "<BUUUUUURP!> Oh dear! Did you hear that? I'm afraid my blasted stomach is getting empty again. This diet is going to kill me, I just know it!"
				else
					(self cue:)
				)
			)
			(3
				(if (not local6)
					(if (and (== gPrevRoomNum 291) (not (IsFlag 126)))
						(switch gAct
							(2
								(= temp0 60)
							)
							(3
								(= temp0 61)
							)
							(4
								(= temp0 62)
							)
							(5
								(= temp0 31)
							)
						)
						(gMessager say: 19 0 temp0 0 self)
					else
						(= cycles 1)
					)
				else
					(self cue:)
				)
			)
			(4
				(cond
					((IsFlag 126)
						(gGame handsOn:)
						(self dispose:)
					)
					((and (< gAct 4) (IsFlag 263))
						(gGame handsOn:)
						(self dispose:)
					)
					((not local6)
						(switch gAct
							(2
								(= temp0 27)
								(gMessager say: 19 0 27 0 self) ; "Yes? <Chomp munch> What can I do for you, lad? <Belch!> Would you perhaps like to groove on a nice leg of lamb? <Urp>"
							)
							(3
								(self setScript: sayGK2 self)
							)
							(4
								(= temp0 67)
								(gMessager say: 19 0 67 0 self) ; "Ooooh, go away, lad. <Gurgle> I don't feel very well. <Murp> My stomach hurts, for some blasted reason."
							)
							(5
								(= temp0 68)
								(gMessager say: 19 0 68 0 self) ; "Hello? Oh, hello, small dude. I'm happy to see you. Ooooh, my stomach!"
							)
						)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(5
				(= global195 3)
				(= local8 1)
				(gCurRoom newRoom: 291)
				(self dispose:)
			)
		)
	)
)

(instance sTalkGambler of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(switch gAct
					(2
						(gGame points: 259 1)
					)
					(3
						(gGame points: 463 1)
					)
					(4
						(gGame points: 464 1)
					)
					(5
						(gGame points: 465 1)
					)
				)
				(gambler setCycle: 0 stopUpd:)
				(gLongSong
					number: (if (IsFlag 264) 264 else 263)
					setLoop: -1
					play:
				)
				(= cycles 3)
			)
			(1
				(switch gAct
					(2
						(if (not (IsFlag 138))
							(SetFlag 138)
							(if (== ((gInventory at: 5) owner:) gCurRoomNum) ; Bag_of_Marbles
								(= temp0 13)
							else
								(= temp0 19)
							)
						else
							(SetFlag 139)
							(if (== ((gInventory at: 5) owner:) gCurRoomNum) ; Bag_of_Marbles
								(= temp0 14)
							else
								(= temp0 20)
							)
						)
					)
					(3
						(if (IsFlag 264)
							(cond
								((not (IsFlag 138))
									(SetFlag 138)
									(= temp0 15)
								)
								((not (IsFlag 139))
									(SetFlag 139)
									(= temp0 16)
								)
								(else
									(SetFlag 139)
									(= temp0 17)
								)
							)
						else
							(= temp0 14)
						)
					)
					(4
						(cond
							((not (IsFlag 138))
								(SetFlag 138)
								(= temp0 7)
							)
							((not (IsFlag 139))
								(SetFlag 139)
								(= temp0 8)
							)
							(else
								(= temp0 9)
							)
						)
					)
					(5
						(cond
							((not (IsFlag 138))
								(SetFlag 138)
								(= temp0 10)
							)
							((not (IsFlag 139))
								(SetFlag 139)
								(= temp0 11)
							)
							(else
								(= temp0 12)
							)
						)
					)
				)
				(gMessager say: 6 85 temp0 0 self)
			)
			(2
				(gambler cue:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGiveCabbage of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if register
					(gGame points: 273 2)
				)
				(gGame handsOff:)
				((ScriptID 895 0) setMotion: PolyPath 150 166 self) ; pepper
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
				(if register
					(gMessager say: 21 52 0 1 self) ; "Here you go, little goat! I'll bet you just LOVE cabbage!"
				else
					(gMessager say: 21 153 0 1 self) ; "Here, goat-dude. I've heard you goat types like to eat trash."
				)
			)
			(3
				(gLongSong2 number: 2305 setLoop: 1 play:)
				(goat view: 814 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(4
				(= seconds 2)
			)
			(5
				(goat setCycle: Beg self)
				((ScriptID 895 0) setCycle: Beg) ; pepper
			)
			(6
				((ScriptID 895 0) ; pepper
					view: 805
					setLoop: 0
					setCel: 0
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(7
				((ScriptID 895 0) setCycle: Beg self) ; pepper
			)
			(8
				(goat view: 816 setLoop: 4 setCel: 0 setCycle: End self)
			)
			(9
				(gLongSong2 number: 2306 setLoop: 1 play:)
				(if register
					(SetFlag 23)
					((gTheIconBar curInvIcon:) cel: 4 message: 49)
					(gMessager say: 21 52 0 2 self) ; "You were pretty hungry, huh. I'm glad you enjoyed it!"
				else
					(gMessager say: 21 153 0 2 self) ; "Hey, I guess it's true! I hope that Doctrine doesn't give you indigestion, little guy."
				)
				(gTheIconBar advanceCurIcon:)
			)
			(10
				(goat setCycle: Beg self)
			)
			(11
				(= register 0)
				((ScriptID 895 0) normalize:) ; pepper
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance pennyInside of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 19 0 24 0 self) ; "See ya!"
			)
			(1
				(penny view: 260 setLoop: 1 setCycle: End self)
			)
			(2
				(if (and (<= gAct 3) (not (IsFlag 260)))
					(gambler setScript: randomRoland)
				)
				(penny dispose:)
				(= ticks 60)
			)
			(3
				(gLongSong fade: gCurRoom)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance gluttonInside of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 19 0 24 0 self) ; "See ya!"
			)
			(1
				(glutton view: 264 setLoop: 0 cel: 5 setCycle: End self)
			)
			(2
				(if
					(and
						(<= gAct 3)
						(not (IsFlag 264))
						(not (IsFlag 260))
					)
					(gambler setScript: randomRoland)
				)
				(gLongSong fade: gCurRoom)
				(glutton dispose:)
				(= ticks 60)
			)
			(3
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance knockPennyDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (gambler script:)
					(randomRoland dispose:)
					(= register 1)
				)
				(gGame handsOff: points: 255 1)
				((ScriptID 895 0) ; pepper
					view: 803
					setLoop: 1
					cel: 0
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(1
				(gLongSong2 number: 921 setLoop: 1 play:)
				((ScriptID 895 0) setCycle: CT 4 -1 self) ; pepper
			)
			(2
				((ScriptID 895 0) setCycle: End self) ; pepper
			)
			(3
				(gLongSong2 number: 921 setLoop: 1 play:)
				((ScriptID 895 0) setCycle: CT 4 -1 self) ; pepper
			)
			(4
				((ScriptID 895 0) setCycle: End self) ; pepper
			)
			(5
				(gLongSong2 number: 921 setLoop: 1 play:)
				((ScriptID 895 0) normalize:) ; pepper
				(cond
					((IsFlag 265)
						(gMessager say: 2 7 25 0 self) ; "Pepper knocks, but no one answers. Penny must have gone to the rally!"
					)
					((gCast contains: penny)
						(gMessager say: 2 7 3 0 self) ; "Penny's already here! Pepper doesn't need to knock on the door again."
					)
					(else
						(self setScript: sGetPenny self)
					)
				)
			)
			(6
				(if register
					(gambler setScript: randomRoland)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance knockPubDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame points: 257 1)
				((ScriptID 895 0) setMotion: PolyPath 97 157 self) ; pepper
			)
			(1
				((ScriptID 895 0) ; pepper
					view: 803
					setLoop: 1
					cel: 0
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(2
				(gLongSong2 number: 921 setLoop: 1 play:)
				((ScriptID 895 0) setCycle: CT 4 -1 self) ; pepper
			)
			(3
				((ScriptID 895 0) setCycle: End self) ; pepper
			)
			(4
				(gLongSong2 number: 921 setLoop: 1 play:)
				((ScriptID 895 0) setCycle: CT 4 -1 self) ; pepper
			)
			(5
				((ScriptID 895 0) setCycle: End self) ; pepper
			)
			(6
				(gLongSong2 number: 921 setLoop: 1 play:)
				(cond
					((IsFlag 266)
						(gMessager say: 14 7 1 0 self) ; "Pepper knocks, but there is no answer."
					)
					((gCast contains: glutton)
						(gMessager say: 14 7 3 0 self) ; "What are you doing, you odd child? I'm right here! Ye gods!"
					)
					(else
						(= cycles 2)
					)
				)
			)
			(7
				((ScriptID 895 0) normalize: setHeading: 315) ; pepper
				(if register
					(gGame handsOn:)
				)
				(self dispose:)
			)
		)
	)
)

(instance lookAtRoland of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				((ScriptID 895 0) view: 1790 setLoop: 8 stopUpd:) ; pepper
				(= cycles 2)
			)
			(1
				(if (IsFlag 264)
					(= temp0 5)
				else
					(= temp0 0)
				)
				(gMessager say: 6 6 temp0 0 self)
			)
			(2
				((ScriptID 895 0) normalize:) ; pepper
				(self dispose:)
			)
		)
	)
)

(instance fadeOut of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLongSong fade: gCurRoom)
				(self dispose:)
			)
		)
	)
)

(instance penny of Prop
	(properties
		x 189
		y 98
		noun 9
		view 260
		loop 1
		cel 8
		signal 16
	)

	(method (doit)
		(if
			(and
				(not (gCurRoom script:))
				(> ((ScriptID 895 0) distanceTo: penny) 43) ; pepper
			)
			(gCurRoom setScript: pennyInside)
		)
		(super doit: &rest)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (OneOf theVerb 7 6 84) ; Do, Look, Trivia
			(if (IsFlag 262)
				(= temp0 5)
			else
				(= temp0 0)
			)
		)
		(switch theVerb
			(6 ; Look
				(gMessager say: 9 6 temp0)
			)
			(7 ; Do
				(gMessager say: 9 7 temp0)
			)
			(85 ; Talk
				(if (and (== gAct 3) (IsFlag 262))
					(gMessager say: 9 85 5 0 self) ; "Don't just stand there, child! Go break your piggy bank and go shopping!"
				else
					(gCurRoom setScript: sTalkPenny)
				)
			)
			((OneOf theVerb 141 143 135 140 137 139 136) ; ???, ???, ???, ???, ???, ???, ???
				(gMessager say: 9 138 38) ; "Here, Mrs. Pyncher. You just might find this interesting!"
			)
			(138 ; ???
				(gCurRoom setScript: sGiveProverbPenny)
			)
			(70 ; Special_Edition
				(gCurRoom setScript: sGiveSpEditionPenny)
			)
			(84 ; Trivia
				(= gDictionaryWord 49)
				(gMessager say: 9 84 temp0)
			)
			(88 ; ???
				(if (IsFlag 262)
					(gMessager say: 9 88 temp0)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance glutton of Prop
	(properties
		x 79
		y 115
		noun 7
		view 264
		cel 5
		signal 26624
	)

	(method (doit)
		(if
			(and
				(not (gCurRoom script:))
				(> ((ScriptID 895 0) distanceTo: glutton) 55) ; pepper
			)
			(gCurRoom setScript: gluttonInside)
		)
		(super doit: &rest)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (IsFlag 266)
			(pubDoor doVerb: theVerb)
		else
			(if (OneOf theVerb 7 6 84) ; Do, Look, Trivia
				(if (IsFlag 263)
					(= temp0 5)
				else
					(= temp0 0)
				)
			)
			(switch theVerb
				(7 ; Do
					(= gDictionaryWord 43)
					(gMessager say: 7 7 temp0)
				)
				(6 ; Look
					(gMessager say: 7 6 temp0 0 gambler)
				)
				(85 ; Talk
					(= gDictionaryWord 57)
					(gCurRoom setScript: sTalkGlutton 0 0)
				)
				((OneOf theVerb 141 143 135 140 138 139 136) ; ???, ???, ???, ???, ???, ???, ???
					(gMessager say: 7 137 38) ; "Here, General Lee, this is for you."
				)
				(137 ; ???
					(gCurRoom setScript: sGiveProverbGlutton)
				)
				(70 ; Special_Edition
					(gCurRoom setScript: sGiveSpEditionGlutton)
				)
				(75 ; Bonbons
					(if (IsFlag 263)
						(gMessager say: 7 88 5) ; "Oh, no thank you. I really can't use that, lad."
					else
						(gMessager say: 7 75 temp0)
					)
				)
				(74 ; Chocolate
					(if (IsFlag 263)
						(gMessager say: 7 88 5) ; "Oh, no thank you. I really can't use that, lad."
					else
						(gMessager say: 7 74 temp0)
					)
				)
				(41 ; Tomato
					(if (IsFlag 263)
						(gMessager say: 7 88 5) ; "Oh, no thank you. I really can't use that, lad."
					else
						(gMessager say: 7 41 temp0)
					)
				)
				(84 ; Trivia
					(gMessager say: 7 84 temp0)
				)
				(88 ; ???
					(if (IsFlag 263)
						(gMessager say: 7 88 5) ; "Oh, no thank you. I really can't use that, lad."
					else
						(gMessager say: 7 88) ; "No thanks, boy. If I can't eat it, it ain't worth it."
					)
				)
				(else
					(super doVerb: theVerb &rest)
				)
			)
		)
	)
)

(instance gambler of Actor
	(properties
		x 155
		y 144
		noun 6
		approachX 187
		approachY 161
		view 266
		signal 26624
	)

	(method (doit)
		(if
			(and
				(OneOf (gLongSong number:) 263 264)
				(not (gCurRoom script:))
				(> (self distanceTo: (ScriptID 895 0)) 70) ; pepper
			)
			(gCurRoom setScript: fadeOut)
		)
		(super doit: &rest)
	)

	(method (cue)
		(super cue:)
		(self view: 266 setLoop: 0 setCycle: OccasionalCycle self 1 5 15)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (OneOf theVerb 7 6 111 84) ; Do, Look, A_Shilling, Trivia
			(if (IsFlag 264)
				(= temp0 5)
			else
				(= temp0 0)
			)
		)
		(switch theVerb
			(6 ; Look
				(gCurRoom setScript: lookAtRoland)
			)
			(7 ; Do
				(gMessager say: 6 7 temp0)
			)
			(85 ; Talk
				(gCurRoom setScript: sTalkGambler)
			)
			((OneOf theVerb 141 143 135 140 138 139 137) ; ???, ???, ???, ???, ???, ???, ???
				(gMessager say: 6 136 38) ; "Hey Roland, check this out?"
			)
			(136 ; ???
				(gCurRoom setScript: sGiveProverbGambler)
			)
			(70 ; Special_Edition
				(gCurRoom setScript: sGiveSpEditionGambler)
			)
			(111 ; A_Shilling
				(gMessager say: 6 111 temp0)
			)
			(84 ; Trivia
				(gMessager say: 6 84 temp0)
			)
			(123 ; Bag_of_Marbles
				(gCurRoom setScript: sGiveGamblerMarbles)
			)
			(88 ; ???
				(if (IsFlag 264)
					(gMessager say: 6 88 temp0)
				else
					(super doVerb: theVerb)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance goat of Prop
	(properties
		x 208
		y 173
		noun 21
		approachX 150
		approachY 166
		approachDist 20
		view 816
		loop 4
		signal 26624
	)

	(method (doit)
		(if (== (Random 1 500) 250)
			(gLongSong2 number: 2308 setLoop: 1 play:)
		)
		(super doit: &rest)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(52 ; Glass_Jar
				(if (IsFlag 23)
					(gMessager say: 21 88) ; "The goat might like to eat that, but Pepper should probably hang onto it, just in case."
				else
					(gCurRoom setScript: sGiveCabbage 0 1)
				)
			)
			(85 ; Talk
				(goat setScript: sTalkGoat)
			)
			(39 ; Doctrine
				(gEgo put: 10) ; Doctrine
				(gCurRoom setScript: sGiveCabbage)
			)
			(999 ; ???
				(gMessager say: 21 88) ; "The goat might like to eat that, but Pepper should probably hang onto it, just in case."
			)
			(84 ; Trivia
				(= gDictionaryWord 16)
				(gMessager say: 21 84) ; "TRUE. People often kept animals such as goats and pigs in the cities in colonial times. Sometimes they would let the animals graze in the Town |r||c0|Commons|c||r|, but this usually got their neighbors mad at them!"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance glutDoor of View
	(properties
		x 79
		y 120
		approachX 87
		approachY 156
		view 263
		loop 2
		cel 5
	)

	(method (doVerb theVerb)
		(pubDoor doVerb: theVerb)
	)
)

(instance penDoor of View
	(properties
		x 189
		y 98
		noun 2
		approachX 214
		approachY 128
		view 260
	)

	(method (doVerb theVerb)
		(carpentryDoor doVerb: theVerb)
	)
)

(instance poDoor of View
	(properties
		x 271
		y 78
		view 260
		cel 1
	)
)

(instance offScreenTalker of BalloonTalker
	(properties
		x 100
		y 65
		talkWidth 150
		tailPosn 1
	)
)

(instance gluttonTalker of BalloonTalker
	(properties
		x 84
		y 94
		talkWidth 196
	)
)

(instance rolandTalker of BalloonTalker
	(properties
		x 147
		y 103
		talkWidth 160
	)

	(method (init)
		(super init: &rest)
	)

	(method (dispose)
		(super dispose: &rest)
	)
)

(instance pennyTalker of BalloonTalker
	(properties
		x 12
		y 78
		talkWidth 165
		tailPosn 1
	)

	(method (say)
		(penny stopUpd:)
		(super say: &rest)
	)
)

(instance bench of Feature
	(properties
		y 133
		noun 1
	)

	(method (doVerb theVerb)
		(= gDictionaryWord 111)
		(super doVerb: theVerb &rest)
	)
)

(instance carpentryDoor of Feature
	(properties
		x 193
		y 96
		noun 2
		nsTop 70
		nsLeft 179
		nsBottom 122
		nsRight 207
		sightAngle 40
		approachX 214
		approachY 128
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(if (not (gCast contains: penny))
					(gCurRoom setScript: knockPennyDoor)
				)
			)
			(85 ; Talk
				(if (gCast contains: penny)
					(gMessager say: 2 85 4) ; "Helloooo! Is anybody in there?"
				else
					(gMessager say: 2 85) ; "Hellooooo! Is anybody in there?"
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance carpentryShop of Feature
	(properties
		x 188
		y 61
		noun 3
		nsLeft 135
		nsBottom 122
		nsRight 241
		sightAngle 40
	)
)

(instance carpentrySign of Feature
	(properties
		x 231
		y 62
		noun 4
		nsTop 51
		nsLeft 221
		nsBottom 72
		nsRight 242
		sightAngle 40
	)
)

(instance carpWindow of Feature
	(properties
		y 70
		noun 5
	)
)

(instance leaves of Feature
	(properties
		y 170
		noun 8
	)
)

(instance postDoor of Feature
	(properties
		x 277
		y 91
		noun 10
		nsTop 73
		nsLeft 268
		nsBottom 109
		nsRight 286
		sightAngle 40
		approachX 267
		approachY 124
	)

	(method (doVerb theVerb)
		(offScreenTalker x: 100 y: 65)
		(switch theVerb
			(7 ; Do
				(if (IsFlag 284)
					(gMessager say: 10 7 56 0 0) ; "Pepper knocks, but there is no answer."
				else
					(gMessager say: 10 7 26 0 0) ; "There's no need to knock. The door is open."
				)
			)
			(85 ; Talk
				(if (IsFlag 284)
					(gMessager say: 10 85 59) ; "Hello!"
				else
					(gMessager say: 10 85 26) ; "Hello!"
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance postOffice of Feature
	(properties
		x 276
		y 54
		noun 11
		nsTop 1
		nsLeft 243
		nsBottom 107
		nsRight 310
		sightAngle 40
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

(instance postSign of Feature
	(properties
		x 256
		y 77
		noun 12
		nsTop 66
		nsLeft 245
		nsBottom 89
		nsRight 267
		sightAngle 40
	)
)

(instance postWindow of Feature
	(properties
		y 66
		noun 13
	)
)

(instance pubDoor of Feature
	(properties
		x 80
		y 109
		noun 14
		nsTop 72
		nsLeft 65
		nsBottom 147
		nsRight 96
		sightAngle 40
		approachX 87
		approachY 156
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(if (not (IsFlag 266))
					(gCurRoom setScript: sTalkPub 0 7)
				else
					(gCurRoom setScript: knockPubDoor 0 1)
				)
			)
			(85 ; Talk
				(if (not (IsFlag 266))
					(gCurRoom setScript: sTalkPub 0 85)
				else
					(gMessager say: 14 85) ; "Hello?"
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance pubShop of Feature
	(properties
		x 70
		y 76
		noun 15
		nsTop 1
		nsLeft 1
		nsBottom 152
		nsRight 140
		sightAngle 40
	)

	(method (doVerb theVerb)
		(= gDictionaryWord 80)
		(super doVerb: theVerb &rest)
	)
)

(instance pubSign of Feature
	(properties
		x 38
		y 101
		noun 16
		nsTop 90
		nsLeft 24
		nsBottom 112
		nsRight 53
		sightAngle 40
	)
)

(instance pubWindow of Feature
	(properties
		y 82
		noun 17
	)
)

(instance southEFeature of ExitFeature
	(properties
		nsTop 173
		nsBottom 189
		nsRight 96
		cursor 910
		exitDir 3
		noun 18
	)
)

