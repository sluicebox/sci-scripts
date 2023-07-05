;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 333)
(include sci.sh)
(use Main)
(use Teller)
(use n814)
(use Talker)
(use Polygon)
(use Feature)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm333 0
	beggarTalker 1
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	[local7 7] = [0 -3 -10 -16 4 -11 999]
	[local14 4] = [0 5 18 999]
	[local18 3] = [0 12 999]
	[local21 6] = [0 17 -15 9 4 999]
	[local27 5] = [0 8 -13 14 999]
	[local32 3] = [0 6 999]
	[local35 3] = [0 7 999]
	[local38 12]
	[local50 8] = [0 -3 -10 -16 -11 -15 -13 999]
)

(instance rm333 of Rm
	(properties
		noun 6
		picture 333
		style 0
	)

	(method (dispose)
		(SetFlag 100)
		(super dispose:)
	)

	(method (init)
		(= [local38 0] @local7)
		(= [local38 1] @local14)
		(= [local38 2] @local18)
		(= [local38 3] @local21)
		(= [local38 4] @local27)
		(= [local38 5] @local32)
		(= [local38 6] @local35)
		(= [local38 7] 999)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 189 0 0 319 0 319 189 257 189 213 151 177 145 170 137 165 111 143 112 138 119 143 133 148 149 121 179 108 184 85 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 219 177 177 177 172 159 206 158
					yourself:
				)
		)
		(Load rsVIEW 333)
		(super init:)
		(SL enable:)
		(self setRegions: 811) ; Street
		(NormalEgo)
		(gEgo posn: 120 187 init: setMotion: MoveTo 120 180)
		(beggarTeller init: beggar @local7 @local38 @local50)
		(beggar actions: beggarTeller init:)
		(theSky init: setOnMeCheck: 26505)
		(onBricks init: setOnMeCheck: 26505)
		(marksOnWall init: setOnMeCheck: 26505)
		(onTheWalls init: setOnMeCheck: 1 8)
		(onBarrels init: setOnMeCheck: 1 2)
		(onBarrels2 init: setOnMeCheck: 1 2)
		(onHotDogStand init: setOnMeCheck: 1 4)
		(= local0 0)
		(gMessager say: 6 0 29) ; "This grubby place must be an alley. It feels strange here, colder than the rest of town. There are some barrels discarded here. A Beggar holds out a bowl towards you."
		(HandsOn)
	)

	(method (doit)
		(if (and (> (gEgo y:) 187) (not (gEgo script:)))
			(gEgo setScript: goBackToStreet)
		)
		(cond
			((and (not local0) (gEgo inRect: 100 135 215 185))
				(beggar setCycle: End)
				(gMessager say: 2 0 1) ; "Alms? Alms for the poor?"
				(= local0 1)
			)
			((and local0 (not (gEgo inRect: 100 135 215 185)))
				(beggar setCycle: Beg)
				(= local0 0)
			)
		)
		(if (== gNight 1)
			(beggar actions: 0)
		else
			(beggar actions: beggarTeller)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 6 0 29) ; "This grubby place must be an alley. It feels strange here, colder than the rest of town. There are some barrels discarded here. A Beggar holds out a bowl towards you."
			)
			(4 ; Do
				(gMessager say: 6 4 29) ; "Nice place. How does this guy expect to make a living begging in this alley?"
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance onTheWalls of Feature
	(properties
		x 75
		y 80
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 6 1 29) ; "The walls seem pretty normal, but there are some curious marks on the north ends of the buildings."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance theSky of Feature
	(properties
		x 165
		y 110
		z 98
		noun 8
		nsTop 5
		nsLeft 124
		nsBottom 19
		nsRight 207
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(if gNight
				(gMessager say: 8 1 11) ; "The evening is clear and the stars are bright. Dark clouds pass over the moon."
			else
				(gMessager say: 8 1) ; "The sky is a piercing blue with scudding white clouds."
			)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance onBarrels of Feature
	(properties
		x 106
		y 148
		noun 7
		nsTop 133
		nsLeft 90
		nsBottom 164
		nsRight 122
	)
)

(instance onBarrels2 of Feature
	(properties
		x 198
		y 120
		noun 1
		nsTop 104
		nsLeft 184
		nsBottom 136
		nsRight 212
	)
)

(instance onHotDogStand of Feature
	(properties
		x 114
		y 128
		noun 4
		nsTop 104
		nsLeft 105
		nsBottom 153
		nsRight 124
	)

	(method (doVerb theVerb)
		(if (== theVerb 1) ; Look
			(gMessager say: 4 1) ; "An early model of a hot dog stand -- or could it be a hamburger stand?"
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance onBricks of Feature
	(properties
		x 158
		y 74
		noun 3
		nsTop 44
		nsLeft 129
		nsBottom 107
		nsRight 187
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 3 1) ; "The back wall is one of the best examples of a perpendicular wall that you have ever seen. It reminds you of the time when you thought about climbing Mount Everest."
			)
			(4 ; Do
				(cond
					((TrySkill 11 35 0) ; climbing
						(gEgo setScript: toTheCentaur)
					)
					((not [gEgoStats 11]) ; climbing
						(gMessager say: 6 0 28) ; "Leave the climbing to those who know how."
						(++ local5)
					)
					((< 3 local5 10)
						(gMessager say: 6 0 26) ; "You'd better not try to climb the wall any more right now. You've been at this long enough that someone is likely to notice."
						(= local5 10)
					)
					(else
						(gMessager say: 6 0 27) ; "You'll need more practice before you'll be able to climb this wall."
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance marksOnWall of Feature
	(properties
		x 120
		y 103
		noun 5
		nsTop 100
		nsLeft 112
		nsBottom 107
		nsRight 128
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if (<= (gEgo y:) 117)
					(gMessager say: 5 1 25) ; "Some sharp, pointy object appears to have been thrown at these walls several times."
				else
					(gMessager say: 5 1 24) ; "You can't make them out from here."
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance beggar of Prop
	(properties
		x 184
		y 171
		noun 2
		view 333
		signal 16384
	)

	(method (doVerb theVerb)
		(switch theVerb
			(2 ; Talk
				(gMessager say: 2 57 11 1 self) ; "It's getting late and I don't want to talk right now."
			)
			(10 ; silver
				(gMessager say: 2 57 11 1 self) ; "It's getting late and I don't want to talk right now."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance beggarTeller of Teller
	(properties)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(if local1
					(gMessager say: 2 1 20) ; "A thin man with very patched clothing holds out a bowl containing only your kind contribution."
				else
					(gMessager say: 2 1 19) ; "A thin man with very patched clothing holds out an empty bowl. It's the standard Beggar's bowl every beggar is issued when he graduates from an acredited Beggar's School."
				)
				(return 1)
			)
			(2 ; Talk
				(cond
					((not local1)
						(gMessager say: 2 2 20) ; "Silver for the poor, Gold for the poor."
						(return 1)
					)
					((> local3 5)
						(= local4 0)
						(gMessager say: 2 2 23) ; "About time I got back to work. Alms for the poor. Alms!"
						(return 1)
					)
					(else
						(++ local3)
						(SolvePuzzle 732 1)
						(= local4 1)
						(super doVerb: theVerb &rest)
					)
				)
			)
			(4 ; Do
				(gMessager say: 2 4) ; "Stealing from a beggar is not a heroic action."
				(return 1)
			)
			(10 ; silver
				(SolvePuzzle 733 1)
				(if
					(or
						(> ((gInventory at: 0) amount:) 0) ; silver
						(> ((gInventory at: 38) amount:) 0) ; gold
					)
					(= local6 1)
					(gEgo setScript: cueItScript)
					(gMessager say: 2 10) ; "Thanks. You know, it's really tough trying to make a living begging in this town since the brigands started scaring all the trade away."
					(= local1 1)
					(= local2 1)
					(= local3 0)
				else
					(gMessager say: 2 10 21) ; "Looks like you're about as broke as I am!"
				)
				(return 1)
			)
			(32 ; fruit
				(gMessager say: 2 32) ; "Thank-you. I really like apples."
				(= local6 2)
				(gEgo setScript: cueItScript)
			)
			(33 ; vegetables
				(gMessager say: 2 33) ; "Thank-you. Hilde's vegetables are always good."
				(= local6 3)
				(gEgo setScript: cueItScript)
			)
			(16 ; dagger
				(gMessager say: 1 20 0 1 0 811) ; "Despite your intentions, you feel a calmness and a sense of peace descend upon you as you even consider thoughts of violence."
			)
			(12 ; sword
				(gMessager say: 1 20 0 1 0 811) ; "Despite your intentions, you feel a calmness and a sense of peace descend upon you as you even consider thoughts of violence."
			)
			(20 ; rock
				(gMessager say: 1 20 0 1 0 811) ; "Despite your intentions, you feel a calmness and a sense of peace descend upon you as you even consider thoughts of violence."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance toTheCentaur of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 161 112 self)
			)
			(1
				(gEgo
					view: 517
					setLoop: 0
					setCel: 0
					posn: 163 76
					setCycle: Walk
					setMotion: MoveTo 159 62 self
				)
			)
			(2
				(gEgo
					setLoop: 1
					setCel: 0
					posn: 161 44
					setCycle: CT 7 1 self
				)
			)
			(3
				(gCurRoom newRoom: 53)
			)
		)
	)
)

(instance goBackToStreet of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 1)
			)
			(1
				(if (and local1 (not (IsFlag 100)))
					(gMessager say: 2 0 2 1 self) ; "A word of warning to you -- don't drink the Dragon's Breath!"
				else
					(self cue:)
				)
			)
			(2
				(gCurRoom newRoom: 330)
			)
		)
	)
)

(instance cueItScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 60)
			)
			(1
				(switch local6
					(1
						(gEgo use: 0 1) ; silver
					)
					(2
						(gEgo use: 22 1) ; fruit
					)
					(3
						(gEgo use: 23 1) ; vegetables
					)
				)
				(self cue:)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance beggarTalker of Talker
	(properties
		x 5
		y 2
		view 1334
		talkWidth 260
		textX 15
		textY 112
	)

	(method (init)
		(= font gUserFont)
		(super init: beggarBust beggarEye beggarMouth &rest)
	)
)

(instance beggarBust of Prop
	(properties
		view 1334
	)
)

(instance beggarMouth of Prop
	(properties
		nsTop 42
		nsLeft 52
		view 1334
		loop 1
	)
)

(instance beggarEye of Prop
	(properties
		nsTop 26
		nsLeft 79
		view 1334
		loop 2
	)
)

