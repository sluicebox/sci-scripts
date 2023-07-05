;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 500)
(include sci.sh)
(use Main)
(use KQ6Room)
(use n913)
(use Conversation)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	rm500 0
)

(local
	local0
	local1 = 1
	local2 = 1
	local3
	local4
)

(instance myConv of Conversation
	(properties)
)

(instance partSong of Sound ; UNUSED
	(properties)
)

(instance rm500 of KQ6Room
	(properties
		noun 3
		picture 500
		north 520
	)

	(method (init &tmp temp0)
		(Load rsVIEW 308)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 319 189 245 189 245 162 266 147 228 105 255 94 264 79 319 82
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 0 259 78 251 90 225 102 210 96 149 118 156 145 93 177 37 189
					yourself:
				)
		)
		(water1 setCycle: Fwd init:)
		(water2 setCycle: Fwd init:)
		(water3 setCycle: Fwd init:)
		(water4 setCycle: Fwd init:)
		(water5 setCycle: Fwd init:)
		(plant setCycle: Fwd init:)
		(gGlobalSound number: 915 loop: -1 flags: 1 play:)
		(gGlobalSound2 number: 917 flags: 1 loop: -1 play:)
		(super init: &rest)
		(ocean init:)
		(trees init:)
		(pathway init:)
		(stump init:)
		(rocks init:)
		(branch init:)
		(if (and (IsFlag 61) (not (IsFlag 45)))
			(dangle init: setScript: dangleScript approachVerbs: 5 2 85) ; Do, Talk, sentence
			(gGlobalSound4 number: 500 flags: 1 loop: -1 play:)
		)
		(if (== gPrevRoomNum north)
			(gEgo init: reset: 2 posn: 256 91)
			(gGame handsOn:)
		)
		(gEgo actions: egoDoVerb)
		(if (<= temp0 (Random 1 1000) 500) ; UNINIT
			(deer init: setScript: deerScript)
		else
			(raccoon init: setLoop: 14 setCycle: End raccoon)
		)
	)

	(method (doit)
		(= local4 (gEgo onControl: 1))
		(cond
			(script 0)
			((and (& local4 $0004) local1)
				(if (!= (gEgo view:) 308)
					(gGlobalSound3 number: 922 loop: -1 flags: 1 play:)
					(gEgo
						ignoreActors: 1
						illegalBits: 0
						view: 308
						setPri: 15
						setLoop: 2
						setLoop: -1
					)
				)
			)
			((& local4 $0040)
				(if local2
					(= local1 0)
					(= local2 0)
					(gMessager say: 4 3 4) ; "The ocean is not as calm as it appears. Underwater currents tug at Alexander's legs."
					(gEgo setMotion: 0)
				)
			)
			((& local4 $0002)
				(if local1
					(gEgo setMotion: 0)
					(repeat
						(gEgo posn: (gEgo x:) (- (gEgo y:) 1))
						(breakif (& (gEgo onControl: 1) $0004))
					)
					(gMessager say: 4 3 4) ; "The ocean is not as calm as it appears. Underwater currents tug at Alexander's legs."
					(= local1 0)
				else
					(gGame handsOff:)
					(self setScript: wateryDeathScr)
				)
			)
			((and (not (& local4 $0004)) (== (gEgo view:) 308))
				(gGlobalSound3 fade: 0 10 15 1)
				(gEgo reset: 3)
				(= local1 1)
			)
			((& local4 $4000)
				(gCurRoom newRoom: north)
				(gGlobalSound fade:)
			)
		)
		(super doit: &rest)
	)

	(method (newRoom newRoomNumber)
		(gGlobalSound fade:)
		(gGlobalSound4 fade: 0 50 50 1)
		(super newRoom: newRoomNumber)
	)
)

(instance water1 of Actor
	(properties
		x 293
		y 164
		noun 4
		view 500
		signal 16384
		cycleSpeed 20
		detailLevel 1
	)
)

(instance water2 of Actor
	(properties
		x 262
		y 166
		noun 4
		view 500
		loop 1
		cel 2
		signal 16384
		cycleSpeed 25
		detailLevel 1
	)
)

(instance water3 of Actor
	(properties
		x 116
		y 152
		noun 4
		view 500
		loop 2
		cel 2
		signal 16384
		cycleSpeed 15
		detailLevel 1
	)
)

(instance water4 of Actor
	(properties
		x 57
		y 164
		noun 4
		view 500
		loop 3
		signal 16384
		cycleSpeed 30
		detailLevel 1
	)
)

(instance water5 of Actor
	(properties
		x 150
		y 155
		noun 4
		view 500
		loop 4
		cel 2
		signal 16384
		cycleSpeed 20
		detailLevel 1
	)
)

(instance dangle of Actor
	(properties
		x 182
		y 22
		noun 7
		approachX 189
		approachY 103
		view 479
		priority 6
		signal 24592
	)

	(method (doVerb theVerb)
		(switch theVerb
			(85 ; sentence
				(if (not global162)
					(gMessager say: noun 0 10) ; "Perhaps Alexander ought to find out more about the odd-looking creature before offering it anything."
				else
					(gGame handsOff:)
					(self setScript: getDangPartScript)
				)
			)
			(2 ; Talk
				(gGame handsOff:)
				(self setScript: partKludgeScript 0 2)
			)
			(5 ; Do
				(if (> global162 0)
					(gGame handsOff:)
					(self setScript: partKludgeScript 0 5)
				else
					(gMessager say: 7 5 10 1) ; "Alexander can't reach the little creature on the tree branch. It will have to come down on its own."
				)
			)
			(1 ; Look
				(gMessager say: 7 1 0 1) ; "There's an odd little creature dangling from that tree branch."
			)
			(else
				(if global162
					(gMessager say: 7 0 11 0) ; "Would you be interested in this?"
				else
					(gMessager say: 7 0 10 0) ; "Perhaps Alexander ought to find out more about the odd-looking creature before offering it anything."
				)
			)
		)
	)
)

(instance plant of Prop
	(properties
		x 142
		y 82
		view 500
		loop 5
		cel 2
		cycleSpeed 30
		detailLevel 1
	)
)

(instance deer of Prop
	(properties
		x 20
		y 116
		noun 10
		view 503
		loop 5
		detailLevel 2
	)
)

(instance raccoon of Actor
	(properties
		x 282
		y 114
		noun 11
		view 503
		loop 13
		detailLevel 2
	)

	(method (cue)
		(self dispose:)
	)
)

(instance ocean of Feature
	(properties
		noun 4
		onMeCheck 6
	)
)

(instance trees of Feature
	(properties
		noun 5
		onMeCheck 16
	)
)

(instance pathway of Feature
	(properties
		noun 8
		onMeCheck 8
	)
)

(instance branch of Feature
	(properties
		noun 5
		onMeCheck 32
	)

	(method (doVerb theVerb)
		(trees doVerb: theVerb)
	)
)

(instance stump of Feature
	(properties
		noun 12
		onMeCheck 128
	)
)

(instance rocks of Feature
	(properties
		noun 2
		onMeCheck 256
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 1) ; Look
				(gMessager say: noun theVerb 2 0 0 0) ; "This heavily-forested isle is dotted with rough granite rocks."
			)
			((OneOf theVerb 1 2 5) ; Look, Talk, Do
				(gMessager say: noun theVerb 0 0 0 0)
			)
			(else
				(gMessager say: noun 0 0 0 0 0) ; "There's no reason to use that on the rock."
			)
		)
	)
)

(instance partKludgeScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: 0 setLoop: 0)
				(= cycles 2)
			)
			(1
				(if (== register 2)
					(switch global162
						(0
							(myConv
								add: -1 7 2 12 1 ; "Hello, friend. Aren't you an odd-looking little fellow?"
								add: -1 7 2 12 2 ; "Am not! Odd-looking YOU are!"
								add: -1 7 2 12 3 ; "OH! I'm sorry. I didn't realize you could speak."
								add: -1 7 2 12 4 ; "Speak not? Funny is! Speech I am and nothing BUT!"
								init: self
							)
							(++ global162)
						)
						(1
							(myConv
								add: -1 7 2 13 1 ; "You speak strangely, friend."
								add: -1 7 2 13 2 ; "Strange my speech is not! Eloquence I speak with!"
								add: -1 7 2 13 3 ; "But who are you, and why are you here?"
								add: -1 7 2 13 4 ; "Away I fly, my home from. Lost I am therefore! <sigh>"
								add: -1 7 2 13 5 ; "As my name to--can you guess not? It's what I do this branch with, and the way I speak of."
								init: self
							)
							(++ global162)
						)
						(2
							(myConv
								add: -1 7 2 14 1 ; "If you're lost, perhaps I can take you home."
								add: -1 7 2 14 2 ; "Take me home to? Think NOT I do! Know you I do not."
								init: self
							)
							(++ global162)
						)
						(else
							(gMessager say: 7 2 15 0 self) ; "Are you sure you don't want me to try to find your home?"
						)
					)
				else
					(myConv add: -1 7 5 11 1 add: -1 7 5 11 2 init: self) ; "Won't you come down?", "Come down why for? Know you I do not!"
				)
			)
			(2
				(client setLoop: -1 setScript: dangleScript)
				(gGame handsOn:)
			)
		)
	)
)

(instance getDangPartScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(dangle setLoop: 0 setCycle: 0)
				(= cycles 1)
			)
			(1
				(myConv
					add: -1 7 85 0 1 ; "Alexander holds the sentence out to the creature."
					add: -1 7 85 0 2 ; "This sentence seems in need of an ending. Perhaps you could finish it?"
					add: -1 7 85 0 3 ; "Where are you going.... Where are you going...?!"
					add: -1 7 85 0 4 ; "Know it I DO!! Where are you going TO!!!!"
					add: -1 7 85 0 5 ; "Like you I do! Go I with you!"
					init: self
				)
			)
			(2
				(gEgo hide:)
				(dangle
					view: 479
					setLoop: 4
					posn: 189 102
					cel: 0
					cycleSpeed: 10
					setPri: 14
					ignoreHorizon: 1
					setCycle: End self
				)
			)
			(3
				(dangle
					view: 478
					setLoop: 1
					cel: 0
					posn: (- (dangle x:) 1) (dangle y:)
					setCycle: End self
				)
			)
			(4
				(dangle setLoop: 0 cel: 0 setCycle: End self)
			)
			(5
				(dangle setCycle: End self)
			)
			(6
				(dangle hide:)
				(gEgo put: 50 500 get: 29 reset: 4 show:) ; sentence, participle
				(gGlobalSound4 fade:)
				(gGame givePoints: 2)
				(SetFlag 45)
				(= cycles 2)
			)
			(7
				(gMessager say: 7 85 0 6 self) ; "Well! That was certainly interesting! It looks like Alexander now has a passenger."
			)
			(8
				(gGame handsOn:)
				(client dispose:)
				(self dispose:)
			)
		)
	)
)

(instance wateryDeathScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gMessager say: 4 3 7 0 self) ; "The underwater tow is amazingly strong here. It pulls ferociously at Alexander's legs."
			)
			(1
				(gCurRoom walkOffEdge: 1)
				(gGlobalSound3 stop: number: 921 flags: 1 loop: 1 play:)
				(gEgo
					view: 269
					setLoop: 1
					cel: 0
					normal: 0
					cycleSpeed: 6
					setCycle: End self
					setMotion: PolyPath (gEgo x:) 190 self
				)
			)
			(2 0)
			(3
				(gCurRoom newRoom: 135)
			)
		)
	)
)

(instance dangleScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(dangle setLoop: (Random 1 3) setCycle: End self)
			)
			(2
				(dangle setCycle: End self)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance deerScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds (Random 2 5))
			)
			(1
				(deer setCycle: End self)
			)
			(2
				(deer setCel: 0)
				(= cycles 1)
			)
			(3
				(self init:)
			)
		)
	)
)

(instance egoDoVerb of Actions
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(12 ; map
				(gCurRoom setScript: 130) ; pullOutMapScr
				(return 1)
			)
			(else
				(return 0)
			)
		)
	)
)

