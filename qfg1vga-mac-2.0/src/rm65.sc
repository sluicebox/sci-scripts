;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 65)
(include sci.sh)
(use Main)
(use Teller)
(use buy)
(use TargActor)
(use n814)
(use Talker)
(use Polygon)
(use Feature)
(use LoadMany)
(use DPath)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm65 0
	bruno65Talker 1
)

(local
	local0
	local1
	local2
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
	[local17 9] = [0 21 9 10 -20 -19 18 -17 999]
	[local26 9] = [0 13 23 14 24 22 15 -11 999]
	[local35 6] = [0 8 16 25 -12 999]
	[local41 11]
	[local52 4] = [0 -20 -17 999]
)

(procedure (localproc_0)
	(if (gCurRoom obstacles:)
		((gCurRoom obstacles:) dispose:)
		(gCurRoom obstacles: 0)
	)
	(gCurRoom
		addObstacle:
			((Polygon new:)
				type: PBarredAccess
				init: 102 157 102 189 0 189 0 0 319 0 319 108 234 104 262 41 239 41 189 86 123 83 97 96 83 95 27 125
				yourself:
			)
			((Polygon new:)
				type: PBarredAccess
				init: 173 189 203 144 319 134 319 189
				yourself:
			)
	)
)

(instance rm65 of Rm
	(properties
		noun 4
		picture 65
		style 8
	)

	(method (dispose)
		(SetFlag 55)
		(DisposeScript 964)
		(gLongSong dispose:)
		(super dispose:)
	)

	(method (cue)
		(switch local14
			(1
				(if gNight
					(gMessager say: 4 1 43) ; "The full moon portends dangerous times."
				else
					(gMessager say: 4 1 38) ; "What can be seen of the sky through the trees is bright and clear."
				)
			)
		)
	)

	(method (init)
		(= [local41 0] @local17)
		(= [local41 1] @local35)
		(= [local41 2] @local26)
		(= [local41 3] 999)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 30 90 8 98 102 157 102 189 0 189 0 0 319 0 319 108 234 104 262 41 239 41 189 86 123 83 97 96
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 173 189 203 144 319 134 319 189
					yourself:
				)
		)
		(LoadMany rsVIEW 65 165 1074)
		(Load rsSCRIPT 964)
		(super init: &rest)
		(if gNight
			(ClearFlag 293)
			(townGate cel: 0)
			(gAddToPics add: townGate eachElementDo: #init doit:)
		else
			(SetFlag 293)
			(onTownGate init:)
		)
		(rock init: setOnMeCheck: 26505)
		(onTheWall init: setOnMeCheck: 1 2)
		(onTownSign init: setOnMeCheck: 1 8)
		(deadSquare init: setOnMeCheck: 1 16)
		(onTheRoad init: setOnMeCheck: 1 64)
		(onTheWhat init: setOnMeCheck: 1 32)
		(= local5 0)
		(if
			(and
				(IsFlag 199)
				(or (== gTimeOfDay 2) (== gTimeOfDay 3))
				(or (not (IsFlag 161)) (IsFlag 235))
			)
			(Load rsVIEW 516)
			(brunoTeller init: bruno @local17 @local41 @local52)
			(bruno init: actions: brunoTeller setScript: brunoFlippingDagger)
		)
		(NormalEgo)
		(gEgo init:)
		(if (not (IsFlag 293))
			(gEgo illegalBits: $8080)
		)
		(switch gPrevRoomNum
			(74
				(gEgo posn: 160 188 setScript: comeFromSouth)
			)
			(54
				(gEgo posn: 232 64 setMotion: MoveTo 220 83)
				(HandsOn)
			)
			(66
				(gEgo posn: 318 140 setScript: comeFromEast)
			)
			(320
				(gEgo posn: 140 91 setHeading: 100)
			)
			(300
				(if (not (IsFlag 293))
					(HandsOn)
					(gEgo posn: 90 101 setHeading: 100)
				else
					(HandsOff)
					(gEgo posn: 31 91 setHeading: 100)
					(gCurRoom setScript: sExitFromTown)
				)
			)
			(else
				(HandsOn)
				(gEgo posn: 265 140)
			)
		)
	)

	(method (doit)
		(if (> gTimeOfDay 3)
			(localproc_0)
		)
		(cond
			(script)
			((and (< (gEgo y:) 47) (not (gEgo script:)))
				(gCurRoom setScript: goToHealer)
			)
			((and (> (gEgo y:) 187) (not (gEgo script:)))
				(gCurRoom setScript: goSouth)
			)
			((and (> (gEgo x:) 317) (not (gEgo script:)))
				(gCurRoom setScript: goEast)
			)
			((and (& (gEgo onControl: 1) $0004) (IsFlag 293))
				(HandsOff)
				(gCurRoom setScript: goToTown)
			)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(cond
			((== theVerb 1) ; Look
				(= local14 1)
				(gMessager say: 4 1 0 0 gCurRoom) ; "Heavy forest looms to the south. The trees are just ordinary trees."
			)
			((OneOf theVerb 51 50 77 78 80 81 82 79) ; openSpell, detectMagicSpell, triggerSpell or Pickup Inventory, dazzleSpell, calmSpell, flameDartSpell, fetchSpell, zapSpell
				(if (gCast contains: bruno)
					(= local10 1)
					(bruno setScript: knifeEgo)
				else
					(CastArea theVerb)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance rock of Feature
	(properties
		x 181
		y 75
		z 6
		noun 6
		nsTop 64
		nsLeft 167
		nsBottom 75
		nsRight 196
	)
)

(instance onTownGate of Feature
	(properties
		x 51
		y 58
		noun 3
		nsTop 8
		nsLeft 18
		nsBottom 109
		nsRight 84
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (not (IsFlag 293))
					(gMessager say: 3 1 39) ; "The town gates are closed and barred at night."
				else
					(gMessager say: 3 1 38) ; "The town gates are open."
				)
			)
			(4 ; Do
				(gMessager say: 3 4) ; "The gate is kept open during the day."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance onTownSign of Feature
	(properties
		x 278
		y 150
		noun 7
		nsTop 114
		nsLeft 241
		nsBottom 187
		nsRight 316
	)
)

(instance onTheWall of Feature
	(properties
		x 118
		y 12
		noun 9
		nsBottom 75
		nsRight 236
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 9 1) ; "The town wall is made of very sturdy carved rock."
			)
			(4 ; Do
				(if (>= gTimeOfDay 4)
					(gEgo setScript: climbTheWall)
				else
					(gMessager say: 9 4) ; "The town gate is wide open. You would look silly climbing the wall."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance onTheWhat of Feature
	(properties
		x 118
		y 180
		noun 10
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(switch (Random 1 6)
				(1
					(gMessager say: 10 1 47) ; "It's an old, broken down cart."
				)
				(2
					(gMessager say: 10 1 50) ; "This cart has seen better days. Now it's more like a pile of firewood."
				)
				(3
					(gMessager say: 10 1 49) ; "No one seems to care much about keeping the town clean any more."
				)
				(4
					(gMessager say: 10 1 46) ; "Somebody left the cart before the horse. (Maybe the horse wasn't quite as broken down.)"
				)
				(5
					(gMessager say: 10 1 45) ; "It used to be used for wheeling and dealing, but the wheels won't turn anymore."
				)
				(6
					(gMessager say: 10 1 48) ; "Well, it's broke, that seems to be about cart for the horse around here."
				)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance onTheRoad of Feature
	(properties
		x 118
		y 20
		noun 5
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(switch (++ local13)
				(1
					(gMessager say: 5 1 47) ; "The road from town branches here. The north fork leads past the healer's hut to the Baron's castle. You remember having entered the valley along the eastern road, just before a storm closed the pass."
				)
				(2
					(gMessager say: 5 1 50) ; "The eastern fork is the road which brought you into this valley."
				)
				(3
					(gMessager say: 5 1 49) ; "The main road by which you entered this valley winds its way through the dense forest."
				)
				(4
					(gMessager say: 5 1 46) ; "The north road winds its way through the woods."
				)
				(5
					(gMessager say: 5 1 45) ; "It's flat. It's made of dirt. Hey, maybe it's a road!"
				)
				(6
					(gMessager say: 5 1 48) ; "You're on the road again!"
				)
			)
			(if (== local13 7)
				(= local13 0)
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance deadSquare of Feature
	(properties
		x 117
		y 74
		noun 2
	)
)

(instance townGate of View
	(properties
		x 20
		y 114
		noun 8
		view 165
		loop 1
		priority 4
		signal 16401
	)
)

(instance knife1 of Actor
	(properties
		view 65
		loop 6
	)
)

(instance knife2 of Actor
	(properties
		view 65
		loop 7
	)
)

(instance bruno of TargActor
	(properties
		x 99
		y 89
		noun 1
		approachX 94
		approachY 104
		view 65
	)

	(method (doit)
		(cond
			((== script knifeEgo) 0)
			(
				(and
					local4
					(or
						(gEgo inRect: 212 53 256 68)
						(gEgo inRect: 283 107 319 130)
						(gEgo inRect: 123 171 172 188)
					)
				)
				(self setScript: knifeEgo)
			)
		)
		(super doit:)
	)
)

(instance brunoTeller of Teller
	(properties)

	(method (showDialog)
		(super showDialog: -17 local2 -19 local2 -12 local3 -11 local1)
	)

	(method (doChild)
		(if (== query -19)
			(SetFlag 356)
		)
		(if (not (or (== query -19) (== query -11) (== query -12)))
			(super doChild: query)
		else
			(return 1)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (== local12 0)
					(gMessager say: 1 1 29) ; "Next to the town's wall, you notice a man who appears to be waiting for someone. His dagger looks like a particularly deadly weapon, and the thief handles it with great skill."
					(= local12 1)
				else
					(gMessager say: 1 1 30) ; "Bruno looks very adept at throwing daggers, an altogether dangerous man. You suspect he sees a lot through those shifty eyes."
				)
			)
			(2 ; Talk
				(cond
					((not local9)
						(= local7 1)
						(gMessager say: 1 2 33) ; "What's in it for me? If ya give me a silver, I might have a bit of info you can use."
					)
					(local7
						(switch (= local8 (Random 1 2))
							(1
								(gMessager say: 1 2 36) ; "A little silver might loosen my lip."
							)
							(2
								(gMessager say: 1 2 36) ; "A little silver might loosen my lip."
							)
						)
					)
					(else
						(super doVerb: theVerb &rest)
					)
				)
			)
			(4 ; Do
				(cond
					((== local11 0)
						(gMessager say: 1 4 27) ; "Bruno nods and makes the countersign."
						(= local11 1)
					)
					(
						(or
							(gEgo inRect: 212 53 256 68)
							(gEgo inRect: 283 107 319 130)
							(gEgo inRect: 123 171 172 188)
						)
						(bruno setScript: knifeEgo)
					)
					(else
						(if (gEgo inRect: 93 76 125 100)
							(bruno setScript: whiner)
						else
							(gMessager say: 1 4 28) ; "Yeah, right, I already gave ya the sign once. I don't like ta do things twice."
						)
						(= local4 1)
					)
				)
			)
			(16 ; dagger
				(bruno setScript: knifeEgo)
			)
			(10 ; silver
				(gEgo setMotion: MoveTo 92 104)
				((= gList (List new:))
					add:
						((Clone Ware) name: {One Silver} price: {1})
						((Clone Ware) name: {Two Silver} price: {2})
						((Clone Ware) name: {Two Gold} price: {20})
						((Clone Ware) name: {Ten Gold} price: {100})
				)
				(switch ((ScriptID 551 0) doit:) ; buy
					(-1
						(HandsOff)
						(gMessager say: 1 10 31) ; "Don't mess around with Bruno. You don't have enough money."
					)
					(1
						(HandsOff)
						(= local6 1)
						(= local0 1)
						(= local9 1)
						(= local7 0)
						(gMessager say: 1 10 32) ; "For another silver, I can tell ya about where to go to find the Baron, Baba Yaga, or some goblins who have a lot of treasure."
					)
					(2
						(HandsOff)
						(= local9 1)
						(= local7 0)
						(= local6 1)
						(= local0 1)
						(= local1 1)
						(gMessager say: 1 10 9) ; "Okay, whaddaya wanna know."
					)
					(3
						(HandsOff)
						(= local9 1)
						(= local7 0)
						(= local6 1)
						(= local0 1)
						(= local1 1)
						(= local2 1)
						(gMessager say: 1 10 9) ; "Okay, whaddaya wanna know."
					)
					(4
						(HandsOff)
						(= local9 1)
						(= local7 0)
						(= local6 1)
						(= local0 1)
						(= local1 1)
						(= local2 1)
						(= local3 1)
						(gMessager say: 1 10 9) ; "Okay, whaddaya wanna know."
					)
				)
				(HandsOn)
			)
			(else
				(if (== theVerb 81) ; flameDartSpell
					(gCurRoom doVerb: theVerb &rest)
				else
					(super doVerb: theVerb &rest)
				)
			)
		)
		(return 1)
	)
)

(instance brunoFlippingDagger of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bruno setLoop: 4 cel: 0 setCycle: Fwd)
				(= seconds (Random 1 3))
			)
			(1
				(bruno setCycle: End)
				(= seconds (Random 2 6))
			)
			(2
				(self changeState: 0)
			)
		)
	)
)

(instance knifeEgo of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: 0)
				(bruno setLoop: 5 cel: 0 setCycle: CT 3 1 self)
			)
			(1
				(knife1
					setLoop: 7
					illegalBits: 0
					ignoreActors:
					ignoreHorizon:
					xStep: 6
					yStep: 7
					init:
					setCycle: Fwd
					posn: (+ (bruno x:) 41) (- (bruno y:) 24)
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 22)
				)
				(bruno setCycle: CT 5 1 self)
			)
			(2
				(= ticks (Random 30 90))
			)
			(3
				(bruno setCel: 0 setCycle: End self)
			)
			(4
				(knife2
					setLoop: 7
					illegalBits: 0
					ignoreActors:
					ignoreHorizon:
					xStep: 6
					yStep: 7
					init:
					setCycle: Fwd
					posn: (+ (bruno x:) 41) (- (bruno y:) 27)
					setMotion: MoveTo (gEgo x:) (- (gEgo y:) 25) self
				)
			)
			(5
				(knife1 dispose:)
				(knife2 dispose:)
				(gEgo
					view: 516
					posn: (- (gEgo x:) 7) (- (gEgo y:) 7)
					setLoop: 1
					setMotion: 0
					setCycle: End self
				)
			)
			(6
				(= seconds 3)
			)
			(7
				(if local10
					(EgoDead 153 154 2 5 517) ; "He saw you casting a spell, and he already had a dagger in his hand. It doesn't pay to try to fight someone who uses poisoned daggers."
				else
					(EgoDead 104 105 2 5 517) ; "It takes too long to draw your weapon against someone with a dagger in his hand. It doesn't pay to try to fight someone who uses poisoned daggers."
				)
			)
		)
	)
)

(instance whiner of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bruno setCycle: End)
				(= local5 (Random 1 7))
				(self cue:)
			)
			(1
				(if (not (gEgo inRect: 93 76 125 100))
					(self dispose:)
				else
					(self cue:)
				)
			)
			(2
				(switch local5
					(1
						(gMessager say: 1 0 4 1 self) ; "Why don'tcha leave me alone? I ain't done nothin'."
					)
					(2
						(gMessager say: 1 0 7 1 self) ; "Hey, I'm just trying to make a buck. No need to give me a hard time."
					)
					(3
						(gMessager say: 1 0 6 1 self) ; "You look nervous. Why don'tcha take a walk and cool off."
					)
					(4
						(gMessager say: 1 0 3 1 self) ; "Bug off."
					)
					(5
						(gMessager say: 1 0 2 1 self) ; "I think I hear your momma calling you."
					)
					(6
						(gMessager say: 1 0 5 1 self) ; "Your boot's untied."
					)
					(7
						(gMessager say: 1 4 26 1 self) ; "Get outta my face."
					)
				)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance sExitFromTown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (not (IsFlag 191))
					(SetFlag 191)
					(++ state)
					(self cue:)
				else
					(gEgo setMotion: MoveTo 120 114 self)
					(SetFlag 199)
				)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
			(2
				(gLongSong number: 22 loop: 1 priority: 0 play:)
				(SolvePuzzle 684 1)
				(gEgo setMotion: MoveTo 75 114 self)
			)
			(3
				(gMessager say: 4 0 42 1 self) ; "The breeze is cool, but you feel a shiver deeper than just the cold. You are really on your own now in a very dangerous place."
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance climbTheWall of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local15 (gEgo moveSpeed:))
				(= local16 (gEgo cycleSpeed:))
				(gEgo
					moveSpeed: 6
					cycleSpeed: 6
					setMotion: MoveTo 86 92 self
				)
			)
			(1
				(if (TrySkill 11 35 0) ; climbing
					(gEgo setScript: goForIt)
				else
					(gMessager say: 4 0 40) ; "Climbing the wall proves too difficult for your current level of skill, but keep practicing."
				)
				(self cue:)
			)
			(2
				(gEgo moveSpeed: local15 cycleSpeed: local16)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance goForIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 517
					loop: 0
					cel: 0
					posn: 83 62
					signal: (| (gEgo signal:) $2000)
				)
				(gMessager say: 4 0 41 1 self) ; "After making sure nobody is watching, you climb over the town's wall."
			)
			(1
				(gEgo
					setPri: 15
					setLoop: 0
					moveSpeed: local15
					cycleSpeed: local16
					setCycle: Fwd
					setMotion: DPath 82 50 81 47 self
				)
			)
			(2
				(gCurRoom newRoom: 300)
			)
		)
	)
)

(instance goToTown of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if local6
					(SolvePuzzle 685 2)
					(gMessager say: 1 0 1 1 self) ; "If ya want a good time, try the 'Dragon's Breath' at the bar."
				else
					(self cue:)
				)
			)
			(1
				(gCurRoom newRoom: 300)
			)
		)
	)
)

(instance goToHealer of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if local6
					(SolvePuzzle 685 2)
					(gMessager say: 1 0 1 1 self) ; "If ya want a good time, try the 'Dragon's Breath' at the bar."
				else
					(self cue:)
				)
			)
			(1
				(gCurRoom newRoom: 54)
			)
		)
	)
)

(instance goSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if local6
					(SolvePuzzle 685 2)
					(gMessager say: 1 0 1 1 self) ; "If ya want a good time, try the 'Dragon's Breath' at the bar."
				else
					(self cue:)
				)
			)
			(1
				(gEgo setMotion: MoveTo (gEgo x:) 240 self)
			)
			(2
				(gCurRoom newRoom: 74)
			)
		)
	)
)

(instance goEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if local6
					(SolvePuzzle 685 2)
					(gMessager say: 1 0 1 1 self) ; "If ya want a good time, try the 'Dragon's Breath' at the bar."
				else
					(self cue:)
				)
			)
			(1
				(gEgo setMotion: MoveTo 340 (gEgo y:) self)
			)
			(2
				(gCurRoom newRoom: 66)
			)
		)
	)
)

(instance comeFromEast of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 265 140 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance comeFromSouth of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 160 170 self)
			)
			(1
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance bruno65Talker of Talker
	(properties
		x 10
		y 10
		view 1074
		talkWidth 260
		textX 15
		textY 110
	)

	(method (init)
		(= font gUserFont)
		(super init: brunoBust brunoEye brunoMouth &rest)
	)
)

(instance brunoBust of Prop
	(properties
		view 1074
	)
)

(instance brunoMouth of Prop
	(properties
		nsTop 47
		nsLeft 43
		view 1074
		loop 1
	)
)

(instance brunoEye of Prop
	(properties
		nsTop 26
		nsLeft 43
		view 1074
		loop 3
	)
)

