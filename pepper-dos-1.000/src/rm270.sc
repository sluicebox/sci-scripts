;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 270)
(include sci.sh)
(use Main)
(use ExitFeature)
(use smell)
(use BalloonTalker)
(use ADRoom)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	rm270 0
	offScreen 1
	nellieTalker 4
	tattleTalker 5
)

(local
	local0 = 1
	local1 = 1
	local2
	local3
	local4 = 1
)

(instance rm270 of ADRoom
	(properties
		noun 1
		picture 270
		horizon 75
		north 290
		west 230
		vanishingY -60
	)

	(method (doVerb theVerb)
		(= global215 11)
		(super doVerb: theVerb)
	)

	(method (cue)
		(gLongSong number: 260 setLoop: -1 play:)
	)

	(method (init)
		(if (== gAct 0)
			(= gAct 2)
			(proc875_0)
		)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 177 279 177 263 145 252 169 0 167
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 178 319 178 318 189 0 189
					yourself:
				)
		)
		(super init: &rest)
		(<<= local1 $0005)
		(gEgo init: normalize: setScale: 0)
		(= global114 1)
		(switch gPrevRoomNum
			(north
				(gEgo x: 262 y: 164 setHeading: 180)
				(gLongSong number: 260 setLoop: -1 play:)
				(gGame handsOn:)
			)
			(west
				(self style: 12)
				(gLongSong number: 260 setLoop: -1 play:)
				(gEgo x: 13 y: 173)
				(if (and (== gAct 2) (not (IsFlag 137)))
					(gCurRoom setScript: sDoNellieCartoon)
				else
					(gGame handsOn:)
				)
			)
			(291
				(= global114 0)
				(self picture: 0)
				(if (== global195 6)
					(= local3 1)
					(gEgo x: 38 y: 168)
					(nellieWindow init: hide:)
					(nellie init: setLoop: (if (IsFlag 275) 6 else 1))
				else
					(gEgo x: 172 y: 167)
					(= local2 1)
					(tattle init: cel: 5)
				)
				(DrawPic 270 100 1)
				(gCurRoom setScript: sFinishConversation)
			)
			(116
				(= global114 0)
				(= picture 0)
				(DrawPic 270 100 1)
			)
			(else
				(self setScript: sEnterFrom230)
			)
		)
		(if
			(and
				(== global114 1)
				(or
					(not (IsFlag 100))
					(proc875_1 local0 global204)
					(proc875_1 local0 global206)
					(proc875_1 local0 global208)
				)
			)
			(SetFlag 124)
		)
		(if
			(and
				(== global114 1)
				(or
					(not (IsFlag 105))
					(proc875_1 local1 global204)
					(proc875_1 local1 global206)
					(proc875_1 local1 global208)
				)
			)
			(SetFlag 129)
		)
		(if (IsFlag 276)
			(tattleDoor approachVerbs: 7 85 init: setPri: 1 stopUpd:) ; Do, Talk
		)
		(nellieWindow init:)
		(millShop init: setOnMeCheck: 1 1024)
		(millDoor approachVerbs: 7 85 init:) ; Do, Talk
		(millSign init:)
		(millWinB init:)
		(millWinT init: setOnMeCheck: 1 2048)
		(sewDoor approachVerbs: 7 85 init:) ; Do, Talk
		(sewShop init:)
		(sewWinB init: setOnMeCheck: 1 512)
		(sewWinT init:)
		(sky init: setOnMeCheck: 1 256)
		(sproutsShop init: setOnMeCheck: 1 4096)
		(sproutsWinB init: setOnMeCheck: 1 8192)
		(sproutsWinT init: setOnMeCheck: 1 16384)
		(sproutDoor approachVerbs: 7 85 init:) ; Do, Talk
		(sproutSign init:)
		(westEFeature init:)
		(if (OneOf gPrevRoomNum 116 291)
			(self curPic: 270 picture: 270)
		)
	)

	(method (doit)
		(super doit:)
		(cond
			(script)
			((& (gEgo onControl: 1) $0002)
				(gGame handsOff:)
				(gCurRoom newRoom: 290)
			)
			((< (gEgo x:) 9)
				(self setScript: sExitWest)
			)
		)
	)
)

(instance sEnterFrom230 of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gLongSong number: 260 setLoop: -1 play:)
				(gEgo x: -20 y: 173 setMotion: MoveTo 13 173 self)
			)
			(1
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
				(gEgo setMotion: MoveTo -25 (gEgo y:) self)
			)
			(1
				(gLongSong fade:)
				(gCurRoom newRoom: 230)
			)
		)
	)
)

(instance sFinishConversation of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 1)
			)
			(1
				(cond
					((and global115 (== global116 30))
						(= global215 12)
						(gMessager say: global115 85 30 1 self global196)
					)
					((and global115 global116)
						(switch global116
							(14
								(= global215 86)
							)
							(126
								(= global215 57)
							)
							(130
								(= global215 62)
							)
						)
						(+= state 2)
						(gMessager say: global115 85 global116 0 self global196)
					)
					(else
						(+= state 2)
						(= cycles 1)
					)
				)
			)
			(2
				(gMessager say: global115 85 30 2 self global196)
			)
			(3
				(= global215 14)
				(gMessager say: global115 85 30 3 self global196)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sDoNellieCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(SetFlag 137)
				(= cycles 1)
			)
			(1
				(gLongSong2 number: 917 setLoop: 1 play:)
				(gLongSong number: 271 setLoop: -1 play:)
				(nellieWindow hide:)
				(nellie init:)
				(gEgo setMotion: PolyPath 38 168 self)
			)
			(2
				((ScriptID 895 0) setHeading: 0) ; pepper
				(= ticks 20)
			)
			(3
				(= global215 99)
				(gMessager say: 21 0 39 1 self) ; "Who's out there? I hear someone walking out there! Oh, no! An |r||c0|urchin|c||r|!"
			)
			(4
				(gMessager say: 21 0 39 2 self) ; "I beg your pardon, ma'am, but I am NOT a sea creature!"
			)
			(5
				(= global215 86)
				(gMessager say: 21 0 39 3 self) ; "Don't give me any lip, you young |r||c0|scoundrel|c||r|! I know an urchin when I see one! Get off the street, you hear? Go home!"
			)
			(6
				(gMessager say: 21 0 39 4 6 self) ; "I'd really like to, ma'am, but you see, that's my problem! I'm--"
			)
			(7
				(gLongSong2 number: 918 setLoop: 1 play:)
				(gLongSong fade: gCurRoom)
				(nellie dispose:)
				(nellieWindow show:)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGetTattle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(tattle init:)
				(= global215 62)
				(gMessager say: 6 7 1 0 self) ; "Pepper knocks on the |r||c0|millinery shop|c||r| door."
			)
			(1
				((ScriptID 895 0) ; pepper
					view: 803
					setLoop: 1
					setCel: 0
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
				((ScriptID 895 0) normalize:) ; pepper
				(= ticks 60)
			)
			(7
				(cond
					((IsFlag 276)
						(gMessager say: 6 7 38 0 self) ; "There is no answer. Tattle has gone to the rally!"
					)
					((and (IsFlag 274) (IsFlag 124) (not (== gAct 5)))
						(gMessager say: 6 7 37 0 self) ; "There is no answer. Tattle must be busy with a customer."
					)
					(else
						(self cue:)
					)
				)
			)
			(8
				(if
					(or
						(IsFlag 276)
						(and
							(not (OneOf gAct 4 5))
							(IsFlag 274)
							(IsFlag 124)
						)
					)
					(tattle dispose:)
					(gGame handsOn:)
					(self dispose:)
				else
					(self cue:)
				)
			)
			(9
				(if (IsFlag 274)
					(gLongSong number: 272 setLoop: -1 play:)
				else
					(gLongSong number: 270 setLoop: -1 play:)
				)
				(tattle setLoop: 1 setCel: 0 setCycle: CT 5 1 self)
				(gGame points: 269 1)
			)
			(10
				((ScriptID 895 0) setHeading: 0) ; pepper
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance knockSewDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				((ScriptID 895 0) setMotion: PolyPath 38 168 self) ; pepper
			)
			(1
				((ScriptID 895 0) ; pepper
					view: 803
					setLoop: 1
					setCel: 0
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
				((ScriptID 895 0) normalize:) ; pepper
				(= ticks 60)
			)
			(7
				(= global215 78)
				(gMessager say: 11 7 0 0 self) ; "Pepper knocks, but there is no answer. Maybe the |r||c0|proprietor|c||r| is upstairs."
			)
			(8
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTalkTattle of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if
					(and
						(not (IsFlag 100))
						(not (IsFlag 112))
						(proc875_1 local0 global204)
						(proc875_1 local0 global206)
						(proc875_1 local0 global208)
						(proc875_1 local0 global205)
						(proc875_1 local0 global207)
						(proc875_1 local0 global209)
					)
					(SetFlag 124)
				)
				(= cycles 1)
			)
			(1
				(if (IsFlag 124)
					(cond
						((IsFlag 276)
							(gMessager say: 6 7 38 0 self) ; "There is no answer. Tattle has gone to the rally!"
						)
						((IsFlag 274)
							(gMessager say: 18 85 87 0 self) ; "I'll talk to you later, little fellow! I have to go fluff up some wigs!"
						)
						(else
							(gMessager say: 18 85 76 0 self) ; "I'll be happy to talk to you later, little boy, but now I have to go catch up on the latest stories! I wouldn't want to miss anything!"
						)
					)
				else
					(= cycles 1)
				)
			)
			(2
				(cond
					((IsFlag 124)
						(tattle setCycle: End self)
					)
					((not local2)
						(switch gAct
							(2
								(= temp0 97)
							)
							(3
								(= temp0 88)
							)
							(4
								(= temp0 23)
							)
							(5
								(= temp0 36)
							)
						)
						(gMessager say: 21 0 temp0 0 self)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(3
				(if (IsFlag 124)
					(tattle dispose:)
					(self dispose:)
				else
					(switch gAct
						(2
							(gGame points: 270 1)
						)
						(3
							(gGame points: 475 1)
						)
						(4
							(gGame points: 476 1)
						)
						(5
							(gGame points: 477 1)
						)
					)
					(= global195 1)
					(= cycles 1)
				)
			)
			(4
				(gCurRoom newRoom: 291)
				(self dispose:)
			)
		)
	)
)

(instance sGiveProverbTattle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame points: 274 2 handsOff:)
				(= cycles 1)
			)
			(1
				(gLongSong number: 272 setLoop: -1 play:)
				(gMessager say: 18 140 0 0 self) ; "Take a look at this, Ms. Taleteller!"
			)
			(2
				(tattle setCycle: End self)
				(gEgo put: 43) ; Wood_Cutting_b
				(if (and (IsFlag 217) (IsFlag 262))
					(SetFlag 88)
				)
			)
			(3
				(gLongSong fade: gCurRoom)
				(tattle dispose:)
				(= ticks 60)
			)
			(4
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGiveSpEditionTattle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame points: 276 2)
				(gLongSong number: 952 setLoop: -1 play:)
				(= cycles 1)
			)
			(1
				(gMessager say: 18 70 0 0 self) ; "I have something very special I want to give you, Ms. Taleteller!"
			)
			(2
				(tattle view: 270 loop: 4 cel: 0 setCycle: End self)
			)
			(3
				(tattle dispose:)
				(tattleDoor init: addToPic:)
				(gLongSong2 number: 923 setLoop: 1 play:)
				(gLongSong fade:)
				(tattle dispose:)
				(proc875_5)
				(self dispose:)
			)
		)
	)
)

(instance sGetNellie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 1)
			)
			(1
				((ScriptID 895 0) setMotion: PolyPath 38 168 self) ; pepper
			)
			(2
				(gEgo
					view: 273
					loop: 0
					cel: 0
					cycleSpeed: 6
					setCycle: End self
				)
				(gLongSong2 number: 2700 setLoop: 1 play:)
			)
			(3
				(if (not local4)
					(gMessager say: 10 96 74 0 self) ; "Pepper tosses the pebbles, but no one comes to the window."
				else
					(gMessager say: 10 96 73 0 self) ; "The pebbles clatter off the upper story window."
				)
			)
			(4
				(if (not local4)
					(self cue:)
				else
					(gLongSong2
						number: (if (IsFlag 275) 924 else 917)
						setLoop: 1
						play:
					)
					(gLongSong
						number: (if (IsFlag 275) 273 else 271)
						setLoop: -1
						play:
					)
					(nellieWindow hide:)
					(nellie
						view: 273
						setLoop: (if (IsFlag 275) 6 else 1)
						init:
					)
					(= cycles 1)
				)
			)
			(5
				(gEgo normalize: 790 3)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sTalkNellie of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if
					(and
						(not (IsFlag 105))
						(not (IsFlag 117))
						(proc875_1 local1 global204)
						(proc875_1 local1 global206)
						(proc875_1 local1 global208)
						(proc875_1 local1 global205)
						(proc875_1 local1 global207)
						(proc875_1 local1 global209)
					)
					(SetFlag 129)
				)
				(= cycles 1)
			)
			(1
				(if (IsFlag 129)
					(cond
						((IsFlag 277)
							(gMessager say: 6 7 38 0 self) ; "There is no answer. Tattle has gone to the rally!"
						)
						((IsFlag 275)
							(gMessager say: 21 0 51 0 self) ; "I'm sorry, my lad, but I'm too busy to chat right now. See you later!"
						)
						(else
							(gMessager say: 21 0 50 0 self) ; "Go away! I've nothing to say to you, you young scamp!"
						)
					)
				else
					(= cycles 1)
				)
			)
			(2
				(cond
					((IsFlag 129)
						(nellie dispose:)
						(nellieWindow show:)
						(gLongSong fade: gCurRoom)
						(self dispose:)
					)
					((not local3)
						(switch gAct
							(2
								(= temp0 40)
							)
							(3
								(= temp0 49)
							)
							(4
								(= temp0 60)
							)
							(5
								(= temp0 61)
							)
						)
						(gMessager say: 21 0 temp0 0 self)
					)
					(else
						(= cycles 1)
					)
				)
			)
			(3
				(switch gAct
					(2
						(gGame points: 272 1)
					)
					(3
						(gGame points: 472 1)
					)
					(4
						(gGame points: 473 1)
					)
					(5
						(gGame points: 474 1)
					)
				)
				(= global195 6)
				(= cycles 1)
			)
			(4
				(gCurRoom newRoom: 291)
			)
		)
	)
)

(instance sGiveProverbNellie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 275 2)
				(= cycles 1)
			)
			(1
				(gEgo
					view: 273
					loop: 0
					cel: 0
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(2
				(theProverb init: setCycle: End self)
				(gLongSong number: 273 setLoop: -1 play:)
			)
			(3
				(theProverb dispose:)
				(gMessager say: 19 139 0 0 self) ; "Here it comes!"
			)
			(4
				(gLongSong fade: gCurRoom)
				(nellie dispose:)
				(nellieWindow show:)
				((ScriptID 895 0) put: 22 normalize:) ; pepper, Wood_Cutting_a
				(gTheIconBar advanceCurIcon:)
				(if (not (gEgo has: 43)) ; Wood_Cutting_b
					(SetFlag 24)
				)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance sGiveSpEditionNellie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff: points: 277 2)
				(gLongSong number: 952 setLoop: -1 play:)
				(= cycles 1)
			)
			(1
				(gMessager say: 19 70 0 1 self) ; "Catch, Ms. Nettlesome!"
			)
			(2
				(theProverb init: setLoop: 3 setCel: 0 setCycle: End self)
				(gLongSong2 number: 2701 setLoop: 1 play:)
			)
			(3
				(theProverb dispose:)
				(nellie setLoop: 4 setCel: 0 setCycle: End self)
			)
			(4
				(gMessager say: 19 70 0 2 8 self) ; "Whee! That was fun! All right, let's see what we have here."
			)
			(5
				(self setScript: nellieBails self)
			)
			(6
				(gGame handsOn:)
				(proc875_5)
				(self dispose:)
			)
		)
	)
)

(instance nellieBails of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(= cycles 2)
			)
			(1
				(gMessager say: 21 0 13 0 self) ; "Later!"
			)
			(2
				(gLongSong2
					number: (if (IsFlag 275) 925 else 918)
					setLoop: 1
					play:
				)
				(nellie dispose:)
				(nellieWindow show: stopUpd:)
				(= cycles 2)
			)
			(3
				(gLongSong fade: gCurRoom)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance tattleBails of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gGame handsOff:)
				(gMessager say: 21 0 13 0 self) ; "Later!"
			)
			(1
				(tattle setLoop: 1 setCycle: End self)
			)
			(2
				(tattle dispose:)
				(= cycles 5)
			)
			(3
				(gLongSong fade: gCurRoom)
				(gGame handsOn:)
				(self dispose:)
			)
		)
	)
)

(instance nellie of Actor
	(properties
		x 35
		y 87
		z 8
		noun 19
		view 273
		loop 1
	)

	(method (doit)
		(if (and (not (gCurRoom script:)) (> (self distanceTo: gEgo) 90))
			(gCurRoom setScript: nellieBails)
		)
		(super doit: &rest)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (OneOf theVerb 7 6 84) ; Do, Look, Trivia
			(if (IsFlag 274)
				(= temp0 52)
			else
				(= temp0 44)
			)
		)
		(switch theVerb
			(7 ; Do
				(gMessager say: 19 7 temp0)
			)
			(6 ; Look
				(gMessager say: 19 6 temp0)
			)
			(85 ; Talk
				(gCurRoom setScript: sTalkNellie)
			)
			((OneOf theVerb 137 143 141 140 138 135 136) ; ???, ???, ???, ???, ???, ???, ???
				(gMessager say: 19 139 12) ; "Here, Nellie! Catch!"
			)
			(139 ; ???
				(gCurRoom setScript: sGiveProverbNellie)
			)
			(70 ; Special_Edition
				(gCurRoom setScript: sGiveSpEditionNellie)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance tattle of Actor
	(properties
		x 175
		y 127
		noun 18
		view 270
		loop 1
		cel 11
		priority 1
		signal 16
	)

	(method (doit)
		(if
			(and
				(not (gCurRoom script:))
				(> (self distanceTo: (ScriptID 895 0)) 70) ; pepper
			)
			(gCurRoom setScript: tattleBails)
		)
		(super doit: &rest)
	)

	(method (doVerb theVerb &tmp temp0)
		(if (OneOf theVerb 7 6 84) ; Do, Look, Trivia
			(if (IsFlag 274)
				(= temp0 52)
			else
				(= temp0 44)
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
				(if (and (IsFlag 274) (== gAct 3))
					(gMessager say: 18 85 87 0) ; "I'll talk to you later, little fellow! I have to go fluff up some wigs!"
				else
					(gCurRoom setScript: sTalkTattle)
				)
			)
			((OneOf theVerb 137 143 135 141 138 139 136) ; ???, ???, ???, ???, ???, ???, ???
				(gMessager say: 18 140 12) ; "Here, Tattle! Read this!"
			)
			(140 ; ???
				(gCurRoom setScript: sGiveProverbTattle)
			)
			(70 ; Special_Edition
				(gCurRoom setScript: sGiveSpEditionTattle)
			)
			(84 ; Trivia
				(= global215 11)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theProverb of Prop
	(properties
		x 38
		y 128
		view 273
		loop 5
		signal 18432
	)
)

(instance nellieWindow of View
	(properties
		x 17
		y 53
		noun 10
		view 270
		signal 1
	)
)

(instance tattleDoor of View
	(properties
		x 175
		y 127
		noun 6
		approachX 172
		approachY 167
		view 270
		cel 1
		signal 18432
	)

	(method (doVerb theVerb)
		(millDoor doVerb: theVerb)
	)
)

(instance millShop of Feature
	(properties
		y 104
		noun 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(85 ; Talk
				(if (gCast contains: tattle)
					(gMessager say: 3 85 22) ; "The building doesn't have much to say."
				else
					(gMessager say: 3 85 1) ; "Hellooo! Is anybody in there?"
				)
			)
			(7 ; Do
				(= global215 62)
				(gMessager say: 3 7) ; "The building feels just like a |r||c0|millinery|c||r| |r||c0|shop|c||r|."
			)
			(6 ; Look
				(= global215 11)
				(gMessager say: 3 6) ; "This is a small, fancy |r||c0|boutique|c||r|."
			)
			(84 ; Trivia
				(gLongSong2 number: 927 setLoop: 1 play:)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance millDoor of Feature
	(properties
		x 177
		y 126
		noun 6
		nsTop 95
		nsLeft 162
		nsBottom 158
		nsRight 193
		sightAngle 40
		approachX 172
		approachY 167
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(if (gCast contains: tattle)
					(gMessager say: 6 7 43) ; "Pepper doesn't need to knock. Tattle's already here!"
				else
					(gCurRoom setScript: sGetTattle)
				)
			)
			(84 ; Trivia
				(= global215 11)
				(super doVerb: theVerb)
			)
			(6 ; Look
				(= global215 62)
				(super doVerb: theVerb)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance millSign of Feature
	(properties
		x 124
		y 178
		noun 7
		nsTop 74
		nsLeft 86
		nsBottom 83
		nsRight 162
		sightAngle 40
	)

	(method (doVerb theVerb)
		(= global215 62)
		(if (== theVerb 84) ; Trivia
			(gLongSong2 number: 927 setLoop: 1 play:)
			(super doVerb: theVerb)
		else
			(super doVerb: theVerb)
		)
	)
)

(instance millWinB of Feature
	(properties
		x 121
		y 124
		noun 4
		nsTop 99
		nsLeft 89
		nsBottom 150
		nsRight 153
		sightAngle 40
	)
)

(instance millWinT of Feature
	(properties
		y 158
		noun 5
	)
)

(instance sewDoor of Feature
	(properties
		x 24
		y 132
		noun 11
		nsTop 105
		nsLeft 8
		nsBottom 159
		nsRight 40
		sightAngle 40
		approachX 38
		approachY 168
		_approachVerbs -32753
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Do
				(gCurRoom setScript: knockSewDoor)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sewShop of Feature
	(properties
		x 40
		y 84
		noun 8
		nsTop 10
		nsBottom 158
		nsRight 81
		sightAngle 40
	)
)

(instance sewWinB of Feature
	(properties
		y 190
		noun 9
	)

	(method (doVerb theVerb)
		(= global215 11)
		(super doVerb: theVerb)
	)
)

(instance sewWinT of Feature
	(properties
		x 36
		y 86
		noun 10
		nsTop 48
		nsLeft 19
		nsBottom 80
		nsRight 53
		sightAngle 40
		approachX 38
		approachY 168
		_approachVerbs -32753
	)

	(method (doVerb theVerb)
		(= global215 11)
		(switch theVerb
			(96 ; Pebbles
				(gGame points: 271 2)
				(cond
					((and (IsFlag 275) (< gAct 4))
						(= local4 0)
						(gCurRoom setScript: sGetNellie)
					)
					((IsFlag 277)
						(= local4 0)
						(gCurRoom setScript: sGetNellie)
					)
					((gCast contains: nellie)
						(gMessager say: 10 96 73) ; "The pebbles clatter off the upper story window."
					)
					((and (IsFlag 275) (IsFlag 129))
						(gCurRoom setScript: sGetNellie)
					)
					(else
						(gCurRoom setScript: sGetNellie)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sky of Feature
	(properties
		y 2
		noun 2
	)
)

(instance sproutsShop of Feature
	(properties
		y 95
		noun 12
	)
)

(instance sproutsWinB of Feature
	(properties
		y 105
		noun 13
	)
)

(instance sproutsWinT of Feature
	(properties
		y 105
		noun 14
	)

	(method (doVerb theVerb)
		(= global215 11)
		(super doVerb: theVerb)
	)
)

(instance sproutDoor of Feature
	(properties
		x 263
		y 132
		noun 15
		nsTop 100
		nsLeft 244
		nsBottom 164
		nsRight 282
		sightAngle 40
		approachX 255
		approachY 170
	)

	(method (doVerb theVerb)
		(= global215 11)
		(switch theVerb
			(7 ; Do
				(gMessager say: 15 7 10) ; "Pepper knocks on the door frame."
			)
			(85 ; Talk
				(gMessager say: 15 85 10) ; "Hello! Can I come in?"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sproutSign of Feature
	(properties
		x 263
		y 102
		noun 16
		nsTop 86
		nsLeft 209
		nsBottom 98
		nsRight 317
		sightAngle 40
	)
)

(instance westEFeature of ExitFeature
	(properties
		nsTop 136
		nsBottom 189
		nsRight 13
		cursor 911
		exitDir 4
		noun 1
	)
)

(instance offScreen of BalloonTalker
	(properties
		x 160
		y 130
		talkWidth 130
		tailPosn 1
	)
)

(instance nellieTalker of BalloonTalker
	(properties
		x 40
		y 75
		talkWidth 150
		tailPosn 3
	)

	(method (say)
		(nellie stopUpd:)
		(super say: &rest)
	)
)

(instance tattleTalker of BalloonTalker
	(properties
		x 10
		y 105
		talkWidth 150
		tailPosn 1
	)

	(method (say)
		(tattle stopUpd:)
		(super say: &rest)
	)
)

