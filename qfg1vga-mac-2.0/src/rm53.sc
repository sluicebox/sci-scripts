;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 53)
(include sci.sh)
(use Main)
(use Teller)
(use n814)
(use Talker)
(use PolyPath)
(use Polygon)
(use Feature)
(use ForwardCounter)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm53 0
	centaurTalker 1
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	[local7 3]
	local10
	local11
	local12
	[local13 7] = [0 -12 -4 -2 3 1 999]
	[local20 4] = [0 9 -11 999]
	[local24 5] = [0 13 6 5 999]
	[local29 4] = [0 -10 8 999]
	[local33 3] = [0 7 999]
	[local36 10]
	[local46 6] = [0 -12 -4 -2 -11 999]
)

(procedure (localproc_0 param1) ; UNUSED
	(if (!= local4 param1)
		(= local4 param1)
		(centaur cel: param1 forceUpd:)
	)
)

(instance rm53 of Rm
	(properties
		noun 9
		picture 53
		horizon 105
		north 36
	)

	(method (dispose)
		(SetFlag 43)
		(DisposeScript 956)
		(super dispose:)
	)

	(method (init &tmp temp0)
		(= [local36 0] @local13)
		(= [local36 1] @local20)
		(= [local36 2] @local24)
		(= [local36 3] @local29)
		(= [local36 4] @local33)
		(= [local36 5] 999)
		(self
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 138 10 127 97 98 119 0 119 0 0 319 0 319 119 183 119 152 98 144 10
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 128 111 128 138 151 134 171 16 171 16 185 165 185 305 185 305 170 169 170 161 148 188 126 319 126 319 189 0 189
					yourself:
				)
		)
		(if (not gNight)
			(Load rsVIEW 53)
			(Load rsVIEW 54)
			ForwardCounter
		)
		(= style
			(switch gPrevRoomNum
				(52 3)
				(54 2)
				(36 5)
				(else -32764)
			)
		)
		(super init:)
		(vase init: setOnMeCheck: 26505)
		(pots init: setOnMeCheck: 26505)
		(pineTree init: setOnMeCheck: 26505)
		(bush init: setOnMeCheck: 26505)
		(unplantedTree init: setOnMeCheck: 26505)
		(rake init: setOnMeCheck: 26505)
		(shovel init: setOnMeCheck: 26505)
		(frontTree init: setOnMeCheck: 26505)
		(aTree init: setOnMeCheck: 26505)
		(bush2 init: setOnMeCheck: 26505)
		(wall init: setOnMeCheck: 26505)
		(trees1 init: setOnMeCheck: 26505)
		(trees2 init: setOnMeCheck: 26505)
		(= temp0 (if gNight 32 else 25))
		(if (or (== (gLongSong prevSignal:) -1) (!= (gLongSong number:) temp0))
			(gLongSong stop:)
			(gLongSong number: temp0 loop: -1 priority: 0 play:)
		)
		(wall approachVerbs: 4) ; Do
		(if (IsFlag 323)
			(ClearFlag 323)
		else
			(SetFlag 323)
		)
		(if (not gNight)
			(if (IsFlag 323)
				(centaur posn: 250 111)
			else
				(centaur posn: 50 111)
			)
			(centaurTeller init: centaur @local13 @local36 @local46)
			(centaur
				illegalBits: 0
				init:
				actions: centaurTeller
				xStep: 6
				setCycle: Walk
			)
			(tail init: setPri: 7 actions: centaurTeller hide:)
			(head init: setPri: 8 actions: centaurTeller hide:)
		)
		(NormalEgo)
		(gEgo init:)
		(switch gPrevRoomNum
			(36
				(= local11 140)
				(= local12 110)
				(gEgo posn: 140 106 setScript: hereHeComes)
			)
			(52
				(= local11 15)
				(= local12 124)
				(gEgo posn: -10 124 setScript: hereHeComes)
			)
			(54
				(= local11 300)
				(= local12 124)
				(gEgo posn: 340 124 setScript: hereHeComes)
			)
			(else
				(= local11 148)
				(= local12 164)
				(gEgo loop: 3 posn: 148 170 setScript: hereHeComes)
			)
		)
	)

	(method (doit)
		(cond
			((gEgo script:) 0)
			((gCurRoom script:) 0)
			((< (gEgo x:) 12)
				(gCurRoom setScript: sExitLeft)
			)
			((> (gEgo x:) 310)
				(gCurRoom setScript: sExitRight)
			)
			((and (not local6) (< (gEgo y:) 134))
				(= local6 1)
				(gEgo setPri: 8)
			)
			((and local6 (>= (gEgo y:) 134))
				(= local6 0)
				(gEgo setPri: -1)
			)
		)
		(if
			(or
				(and
					(> (centaur x:) 249)
					(not (IsFlag 323))
					(not local0)
					(not gNight)
				)
				(and
					(< (centaur x:) 201)
					(IsFlag 323)
					(not local0)
					(not gNight)
				)
				(and
					(< (gEgo distanceTo: centaur) 50)
					(< 130 (gEgo y:) 150)
					(not local0)
					(not gNight)
				)
			)
			(centaur setScript: standStill)
		)
		(if (== gNight 1)
			(centaur actions: 0)
			(head actions: 0)
		else
			(head actions: centaurTeller)
			(centaur actions: centaurTeller)
		)
		(super doit:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(4 ; Do
				(if gNight
					(gMessager say: 9 4 0 1) ; "The farmer has painstakingly removed all the rocks from his fields."
				else
					(gMessager say: 9 4) ; "The farmer has painstakingly removed all the rocks from his fields."
				)
			)
			(1 ; Look
				(gMessager say: 9 1) ; "The forest surrounds the farmer's small fields and orchard. The crops have yet to be planted. There are only a few weeds and some grasses at the edge of the forest."
			)
			(20 ; rock
				(gMessager say: 9 20) ; "Don't throw things here. The farmer wouldn't appreciate it."
			)
			(81 ; flameDartSpell
				(gMessager say: 9 81) ; "It wouldn't be nice to set the Centaur's crops on fire."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance wall of Feature
	(properties
		x 150
		y 180
		noun 14
		nsTop 172
		nsLeft 1
		nsBottom 188
		nsRight 318
		approachX 152
		approachY 169
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 14 1) ; "You can see the roofs of the town over the fence."
			)
			(4 ; Do
				(if gNight
					(if (TrySkill 11 35 0) ; climbing
						(gEgo setScript: climbTheWall)
					else
						(gMessager say: 14 4 21) ; "Climbing this wall is too difficult for your level of skill. Keep practicing."
					)
				else
					(gMessager say: 14 4) ; "The town gate is wide open during the day. You would look silly climbing the wall."
				)
			)
			(20 ; rock
				(gMessager say: 14 20) ; "Realizing you may hit somebody on the other side of the wall, you put the rock away."
			)
			(81 ; flameDartSpell
				(gMessager say: 9 81) ; "It wouldn't be nice to set the Centaur's crops on fire."
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance trees1 of Feature
	(properties
		x 50
		y 25
		noun 11
		nsTop 1
		nsLeft 1
		nsBottom 51
		nsRight 109
	)

	(method (doVerb theVerb)
		(if (== theVerb 81) ; flameDartSpell
			(gMessager say: 9 81) ; "It wouldn't be nice to set the Centaur's crops on fire."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance trees2 of Feature
	(properties
		x 150
		y 86
		noun 11
		nsTop 1
		nsLeft 173
		nsBottom 51
		nsRight 319
	)

	(method (doVerb theVerb)
		(if (== theVerb 81) ; flameDartSpell
			(gMessager say: 9 81) ; "It wouldn't be nice to set the Centaur's crops on fire."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance rake of Feature
	(properties
		x 241
		y 152
		noun 8
		nsTop 146
		nsLeft 221
		nsBottom 158
		nsRight 264
	)

	(method (doVerb theVerb)
		(if (== theVerb 81) ; flameDartSpell
			(gMessager say: 9 81) ; "It wouldn't be nice to set the Centaur's crops on fire."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance vase of Feature
	(properties
		x 81
		y 136
		noun 13
		nsTop 121
		nsLeft 67
		nsBottom 151
		nsRight 95
	)

	(method (doVerb theVerb)
		(if (== theVerb 81) ; flameDartSpell
			(gMessager say: 9 81) ; "It wouldn't be nice to set the Centaur's crops on fire."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance pots of Feature
	(properties
		x 207
		y 141
		noun 7
		nsTop 135
		nsLeft 187
		nsBottom 148
		nsRight 228
	)

	(method (doVerb theVerb)
		(if (== theVerb 81) ; flameDartSpell
			(gMessager say: 9 81) ; "It wouldn't be nice to set the Centaur's crops on fire."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance pineTree of Feature
	(properties
		x 41
		y 99
		z 36
		noun 6
		nsTop 40
		nsLeft 28
		nsBottom 87
		nsRight 54
	)

	(method (doVerb theVerb)
		(if (== theVerb 81) ; flameDartSpell
			(gMessager say: 9 81) ; "It wouldn't be nice to set the Centaur's crops on fire."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance bush of Feature
	(properties
		x 90
		y 90
		noun 2
		nsTop 81
		nsLeft 78
		nsBottom 99
		nsRight 103
	)

	(method (doVerb theVerb)
		(if (== theVerb 81) ; flameDartSpell
			(gMessager say: 9 81) ; "It wouldn't be nice to set the Centaur's crops on fire."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance unplantedTree of Feature
	(properties
		x 18
		y 130
		noun 12
		nsTop 113
		nsLeft 5
		nsBottom 148
		nsRight 32
	)

	(method (doVerb theVerb)
		(if (== theVerb 81) ; flameDartSpell
			(gMessager say: 9 81) ; "It wouldn't be nice to set the Centaur's crops on fire."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance shovel of Feature
	(properties
		x 46
		y 130
		noun 10
		nsTop 115
		nsLeft 35
		nsBottom 145
		nsRight 58
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1 ; Look
				(gMessager say: 10 1) ; "This is the Centaur's shovel."
			)
			(81 ; flameDartSpell
				(gMessager say: 9 81) ; "It wouldn't be nice to set the Centaur's crops on fire."
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance frontTree of Feature
	(properties
		x 260
		y 114
		noun 3
		nsTop 83
		nsLeft 237
		nsBottom 146
		nsRight 284
	)

	(method (doVerb theVerb)
		(if (== theVerb 81) ; flameDartSpell
			(gMessager say: 9 81) ; "It wouldn't be nice to set the Centaur's crops on fire."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance aTree of Feature
	(properties
		x 192
		y 67
		noun 5
		nsTop 36
		nsLeft 170
		nsBottom 99
		nsRight 214
	)

	(method (doVerb theVerb)
		(if (== theVerb 81) ; flameDartSpell
			(gMessager say: 9 81) ; "It wouldn't be nice to set the Centaur's crops on fire."
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance bush2 of Feature
	(properties
		x 232
		y 77
		noun 1
		nsTop 57
		nsLeft 217
		nsBottom 98
		nsRight 247
	)
)

(instance head of Prop
	(properties
		noun 4
		view 54
	)

	(method (doVerb theVerb)
		(centaur doVerb: theVerb &rest)
	)
)

(instance tail of Prop
	(properties
		noun 4
		view 54
		loop 2
	)

	(method (doVerb theVerb)
		(centaur doVerb: theVerb &rest)
	)
)

(instance centaur of Actor
	(properties
		noun 4
		view 53
		loop 5
	)
)

(instance centaurTeller of Teller
	(properties)

	(method (doChild)
		(if (== query -10)
			(SolvePuzzle 666 3)
			(return 1)
		else
			(super doChild: query)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(10 ; silver
				(if (not local0)
					(= local1 1)
					(centaur setScript: standStill)
				else
					(gMessager say: 4 10) ; "You must go see my daughter, Hilde, who sells our fruits and vegetables on Market Street."
				)
			)
			(12 ; sword
				(gMessager say: 4 12) ; "Looking at the Centaur's muscles, his hoe, and his four gleaming hooves, you get the feeling that it might not be the best of ideas. Besides, he reminds you of your old friend Flicka."
			)
			(20 ; rock
				(gMessager say: 4 12) ; "Looking at the Centaur's muscles, his hoe, and his four gleaming hooves, you get the feeling that it might not be the best of ideas. Besides, he reminds you of your old friend Flicka."
			)
			(1 ; Look
				(if local0
					(gMessager say: 4 1 15 1) ; "The majestic Centaur watches you carefully."
				else
					(gMessager say: 4 1 14) ; "The handsome Centaur has a look of pride and dignity as he rakes his field."
				)
			)
			(2 ; Talk
				(if (not local0)
					(= local1 1)
					(centaur setScript: standStill)
				else
					(SolvePuzzle 665 1)
					(super doVerb: theVerb &rest)
				)
			)
			(81 ; flameDartSpell
				(gMessager say: 9 81) ; "It wouldn't be nice to set the Centaur's crops on fire."
			)
			(else
				(super doVerb: theVerb)
			)
		)
		(return 1)
	)
)

(instance standStill of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local0 1)
				(if (< (centaur cel:) 4)
					(centaur setCycle: End self)
				else
					(self cue:)
				)
			)
			(1
				(tail
					setLoop: (if (IsFlag 323) 3 else 2)
					posn:
						(if (IsFlag 323)
							(+ (centaur x:) 16)
						else
							(- (centaur x:) 16)
						)
						(- (centaur y:) 31)
					show:
				)
				(head
					posn:
						(if (IsFlag 323)
							(- (centaur x:) 13)
						else
							(+ (centaur x:) 13)
						)
						(- (centaur y:) 27)
					setLoop: (if (IsFlag 323) 0 else 1)
					show:
				)
				(centaur
					view: 54
					posn: (centaur x:) (centaur y:)
					setLoop: (if (IsFlag 323) 5 else 4)
					show:
					setMotion: 0
				)
				(self cue:)
			)
			(2
				(tail setCycle: ForwardCounter 2 self)
			)
			(3
				(centaur setCycle: 0)
				(if local1
					(if (not local2)
						(= local2 1)
						(gMessager say: 9 0 16) ; "Noticing that you are addressing him, the Centaur stops and gives you his attention."
					else
						(gMessager say: 9) ; "The Centaur turns toward you."
					)
					(self cue:)
				else
					(if (not local3)
						(= local3 1)
						(gMessager say: 9 0 17) ; "The Centaur stops raking as you approach."
					)
					(self cue:)
				)
			)
			(4
				(tail cycleSpeed: 18 setCycle: Fwd)
				(= ticks 60)
			)
			(5
				(= ticks (Random 30 180))
			)
			(6
				(if (not (centaur cycler:))
					(= local10
						(GetAngle (centaur x:) 111 (gEgo x:) (gEgo y:))
					)
					(cond
						((< (gEgo x:) 10)
							(self changeState: 7)
						)
						((< (gEgo x:) 80)
							(self changeState: 8)
						)
						((< 80 (gEgo x:) 160)
							(self changeState: 9)
						)
						((< (gEgo x:) 240)
							(self changeState: 10)
						)
						(else
							(self changeState: 11)
						)
					)
				)
			)
			(7
				(head cel: (if (== (centaur loop:) 5) 0 else 4))
				(self changeState: 5)
			)
			(8
				(head cel: (if (== (centaur loop:) 5) 1 else 3))
				(self changeState: 5)
			)
			(9
				(head cel: 2)
				(self changeState: 5)
			)
			(10
				(head cel: (if (== (centaur loop:) 5) 3 else 1))
				(self changeState: 5)
			)
			(11
				(head cel: (if (== (centaur loop:) 5) 4 else 0))
				(self changeState: 5)
			)
		)
	)
)

(instance sExitLeft of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo -40 (gEgo y:) self)
			)
			(1
				(gCurRoom newRoom: 52)
			)
		)
	)
)

(instance sExitRight of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: MoveTo 340 (gEgo y:) self)
			)
			(1
				(gCurRoom newRoom: 54)
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
				(gEgo setMotion: PolyPath 152 169 self)
			)
			(1
				(gCurRoom newRoom: 334)
			)
		)
	)
)

(instance hereHeComes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if (not gNight)
					(centaur setMotion: MoveTo 200 111 self)
				else
					(self cue:)
				)
			)
			(1
				(if (not gNight)
					(centaur setScript: standStill)
				)
				(gEgo setMotion: MoveTo local11 local12 self)
			)
			(2
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance talkToYou of Script ; UNUSED
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if local1
					(if (not local2)
						(= local2 1)
						(gMessager say: 9 0 16) ; "Noticing that you are addressing him, the Centaur stops and gives you his attention."
					else
						(gMessager say: 9) ; "The Centaur turns toward you."
					)
					(self cue:)
				else
					(if (and (not local3) (OneOf (gEgo loop:) 0 3 6))
						(= local3 1)
						(gMessager say: 9 0 17) ; "The Centaur stops raking as you approach."
					)
					(self cue:)
				)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance centaurTalker of Talker
	(properties
		x 10
		y 10
		view 1053
		talkWidth 260
		textX 15
		textY 110
	)

	(method (init)
		(= font gUserFont)
		(super init: centaurBust centaurEye centaurMouth &rest)
	)
)

(instance centaurBust of Prop
	(properties
		view 1053
	)
)

(instance centaurMouth of Prop
	(properties
		nsTop 50
		nsLeft 33
		view 1053
		loop 1
	)
)

(instance centaurEye of Prop
	(properties
		nsTop 33
		nsLeft 32
		view 1053
		loop 2
	)
)

