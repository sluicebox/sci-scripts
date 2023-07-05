;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 91)
(include sci.sh)
(use Main)
(use n814)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm91 0
)

(local
	local0
	local1
	[local2 108]
	local110
	local111
	local112 = 30
	local113 = 20
	local114
	local115
	local116
	[local117 28]
	local145
	local146
	local147
	local148 = 1
	local149
	local150
	local151
	local152
)

(procedure (localproc_0 param1 param2 param3 &tmp temp0)
	(= local146 0)
	(= local145 1)
	(if (< (= temp0 (Abs (- param1 param2))) 2)
		(= local145 (if (== temp0 param3) 0 else 2))
	)
	(if (and (< param1 2) (< param2 2) (!= param1 param3))
		(= local146 (if (== param2 0) 2 else -2))
	)
)

(procedure (localproc_1 param1 param2 param3 param4 &tmp [temp0 2])
	(return
		(or
			(localproc_2 param1 param2 param3 param4)
			(localproc_3 param1 param2 param3 param4)
		)
	)
)

(procedure (localproc_2 param1 param2 param3 param4 &tmp temp0 temp1)
	(= temp0
		(localproc_4
			param1
			param2
			(gEgo x:)
			(- (gEgo y:) 35)
			(gEgo x:)
			(- (gEgo y:) 15)
		)
	)
	(= temp1
		(localproc_4
			param3
			param4
			(gEgo x:)
			(- (gEgo y:) 35)
			(gEgo x:)
			(- (gEgo y:) 15)
		)
	)
	(if (== temp0 temp1)
		(return 0)
	)
	(= temp0
		(localproc_4
			(gEgo x:)
			(- (gEgo y:) 35)
			param1
			param2
			param3
			param4
		)
	)
	(= temp1
		(localproc_4
			(gEgo x:)
			(- (gEgo y:) 15)
			param1
			param2
			param3
			param4
		)
	)
	(if (== temp0 temp1)
		(return 0)
	else
		(= local114
			(-
				(/
					(+
						(* param4 (gEgo x:))
						(- (* param4 param1))
						(- (* param2 (gEgo x:)))
						(* param2 param3)
					)
					(- param3 param1)
				)
				(gEgo y:)
			)
		)
		(= local115 (gEgo loop:))
		(if (< (gEgo x:) param1)
			(= local116 1)
		else
			(= local116 0)
		)
		(return 1)
	)
)

(procedure (localproc_3 param1 param2 param3 param4 &tmp temp0 temp1)
	(= temp0
		(localproc_4
			param1
			param2
			(- (gEgo y:) 25)
			(- (gEgo x:) 8)
			(- (gEgo y:) 25)
			(+ (gEgo x:) 8)
		)
	)
	(= temp1
		(localproc_4
			param3
			param4
			(- (gEgo y:) 25)
			(- (gEgo x:) 8)
			(- (gEgo y:) 25)
			(+ (gEgo x:) 8)
		)
	)
	(if (== temp0 temp1)
		(return 0)
	)
	(= temp0
		(localproc_4
			(- (gEgo y:) 25)
			(- (gEgo x:) 8)
			param1
			param2
			param3
			param4
		)
	)
	(= temp1
		(localproc_4
			(- (gEgo y:) 25)
			(+ (gEgo x:) 8)
			param1
			param2
			param3
			param4
		)
	)
	(if (== temp0 temp1)
		(return 0)
	else
		(= local114 (- -15 (Random 0 20)))
		(= local115 (gEgo loop:))
		(return 1)
	)
)

(procedure (localproc_4 param1 param2 param3 param4 param5 param6)
	(if
		(>
			(+
				(* param6 param3)
				(- (* param5 param4))
				(* param1 (- param4 param6))
				(* param2 (- param5 param3))
			)
			0
		)
		(return 1)
	else
		(return 0)
	)
)

(procedure (localproc_5 param1 param2 param3 &tmp temp0 temp1 temp2 temp3)
	(if (< param1 (gEgo x:))
		(= temp1 (+ (- (gEgo x:) param1) (Random 0 35)))
	else
		(= temp1 (- (- (gEgo x:) param1) (Random 0 35)))
	)
	(= temp2 (- (gEgo y:) param2))
	(= temp3 (/ (* temp1 2) 128))
	(/= temp1 8)
	(/= temp2 8)
	(= [local2 param3] param1)
	(= [local2 (+ param3 9)] param2)
	(for ((= temp0 1)) (<= temp0 4) ((++ temp0))
		(= [local2 (+ param3 temp0)] (+ [local2 (+ param3 temp0 -1)] temp1))
		(= [local2 (+ param3 temp0 9)]
			(+ [local2 (+ param3 temp0 8)] (- temp2 temp3))
		)
	)
	(for ((= temp0 5)) (<= temp0 8) ((++ temp0))
		(= [local2 (+ param3 temp0)] (+ [local2 (+ param3 temp0 -1)] temp1))
		(= [local2 (+ param3 temp0 9)]
			(+ [local2 (+ param3 temp0 8)] temp2 temp3)
		)
	)
)

(instance rm91 of Rm
	(properties
		picture 91
		style 8
		horizon 92
		north 93
		east 92
	)

	(method (dispose)
		(SetFlag 81)
		(= global425 0)
		(brigandS stop:)
		(gMouseDownHandler delete: self)
		(super dispose:)
	)

	(method (init)
		(LoadMany rsVIEW 91 90 400)
		(Load rsSOUND 73 2031)
		(gMouseDownHandler add: self)
		(super init:)
		(theLog init: setOnMeCheck: 26505)
		(NormalEgo)
		(gLongSong stop:)
		(brigandS number: 73 init: play:)
		(archer1 init: stopUpd:)
		(archer2 init: stopUpd:)
		(archer3 init: stopUpd:)
		(archer4 init: stopUpd:)
		(archer5 init: stopUpd:)
		(switch gPrevRoomNum
			(93
				(= local149 0)
				(ClearFlag 244)
				(gEgo
					posn: 122 95
					setPri: 7
					setHeading: 270
					init:
					setMotion: MoveTo 127 110 egoEnters
				)
				(|= global425 $0008)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 319 189 0 189 0 0 123 72 84 87 88 121 106 126 121 122 139 116 139 105 132 69 131 0 319 0
							yourself:
						)
				)
			)
			(465 ; brigandArena
				(= local149 0)
				(gEgo
					posn: 122 95
					setPri: 7
					setHeading: 270
					init:
					ignoreActors:
					setMotion: PolyPath 117 90
				)
				(|= global425 $0008)
				(stiff1 init: stopUpd:)
				(stiff2 init: stopUpd:)
				(stiff3 init: stopUpd:)
			)
			(else
				(self setScript: egoEnters)
				(SetFlag 244)
				(= local0 1)
				(= local149 1)
				(spearman4 init: stopUpd:)
				(spearman5 init: stopUpd:)
				(gEgo
					posn: 309 148
					setPri: 11
					init:
					setMotion: PolyPath 264 146 egoEnters
				)
				(|= global425 $0008)
				(gCurRoom
					addObstacle:
						((Polygon new:)
							type: PBarredAccess
							init: 0 0 319 0 319 132 271 133 261 129 239 131 183 125 170 121 155 124 123 124 108 130 97 127 89 132 94 137 241 155 319 155 319 189 0 189
							yourself:
						)
				)
			)
		)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3)
		(= temp0 (gEgo loop:))
		(= temp1 (gEgo priority:))
		(= temp2 (gEgo x:))
		(= temp3 (gEgo y:))
		(for ((= local147 0)) (<= local147 24) ((+= local147 4))
			(if (!= [local117 local147] 0)
				(localproc_0
					[local117 (+ local147 1)]
					temp0
					[local117 (+ local147 2)]
				)
				(if (< [local117 local147] -29)
					(= local150 1)
					(= [local117 local147] -36)
					(if (== local145 0)
						(= local145 3)
					)
					(if (== local145 2)
						(= local145 4)
					)
				)
				([local117 (+ local147 3)]
					setCel: local145
					setPri: (- temp1 1)
					posn: (+ temp2 local146) (+ temp3 [local117 local147])
				)
			)
		)
		(= global103 (gEgo x:))
		(cond
			((and (not local1) (< global103 230))
				(= local1 1)
				(archer1 setScript: shoot1 0 1)
				(archer2 setScript: shoot2 0 2)
				(archer4 setScript: shoot4 0 4)
				(if local149
					(archer3 setScript: shoot3 0 3)
					(archer5 setScript: shoot5 0 5)
				else
					(archer3 stopUpd:)
					(archer5 stopUpd:)
				)
			)
			((and local1 (> global103 270))
				(= local1 0)
				(archer1 setScript: 0)
				(archer2 setScript: 0)
				(archer3 setScript: 0)
				(archer4 setScript: 0)
				(archer5 setScript: 0)
				(gCurRoom setScript: runAway)
			)
		)
		(super doit:)
	)

	(method (doVerb theVerb invItem)
		(if (OneOf theVerb 51 50 77 78 80 81 82 79) ; openSpell, detectMagicSpell, triggerSpell or Pickup Inventory, dazzleSpell, calmSpell, flameDartSpell, fetchSpell, zapSpell
			(gEgo setScript: startSpell)
		else
			(switch theVerb
				(1 ; Look
					(gMessager say: 8 1) ; "The cliffs are rocky and riddled with niches that could conceal things. Brigand archers for instance. There is a pile of logs off to the northwest."
				)
				(else
					(super doVerb: theVerb invItem &rest)
				)
			)
		)
	)
)

(instance arrowFly of Sound
	(properties
		number 2031
	)
)

(instance brigandS of Sound
	(properties
		flags -1
		number 73
		priority 3
		loop -1
	)
)

(instance archer1 of Actor
	(properties
		x 39
		y 126
		noun 1
		view 91
		signal 8192
	)
)

(instance archer2 of Actor
	(properties
		x 157
		y 189
		noun 2
		view 91
		loop 1
		signal 8192
	)
)

(instance archer3 of Actor
	(properties
		x 268
		y 62
		noun 3
		view 91
		loop 2
		signal 8192
	)
)

(instance archer4 of Actor
	(properties
		x 18
		y 102
		noun 4
		view 91
		loop 3
		priority 5
		signal 8208
	)
)

(instance archer5 of Actor
	(properties
		x 207
		y 56
		noun 5
		view 91
		loop 4
		signal 8192
	)
)

(instance spearman4 of Actor
	(properties
		x 141
		y 101
		noun 9
		view 92
		signal 8192
	)
)

(instance spearman5 of Actor
	(properties
		x 94
		y 119
		noun 10
		view 92
		loop 1
		priority 6
		signal 8208
	)
)

(instance stiff1 of View
	(properties
		x 143
		y 87
		noun 11
		view 90
		loop 6
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(EgoDead 143 144) ; "You searched for silver, but all you found was iron. Iron arrowheads, that is."
			)
			(1 ; Look
				(gMessager say: 11 1) ; "You may have killed that brigand, but there are five others pelting you with arrows."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance stiff2 of View
	(properties
		x 86
		y 109
		noun 11
		view 90
		loop 6
		cel 2
	)

	(method (doVerb theVerb)
		(stiff1 doVerb: theVerb)
	)
)

(instance stiff3 of View
	(properties
		x 135
		y 83
		noun 11
		view 90
		loop 6
		cel 1
	)

	(method (doVerb theVerb)
		(stiff1 doVerb: theVerb)
	)
)

(instance theLog of Feature
	(properties
		x 129
		y 110
		noun 12
		nsTop 107
		nsLeft 87
		nsBottom 132
		nsRight 171
		sightAngle 40
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(if (< (gEgo distanceTo: self) 70)
					(gEgo setScript: climbOverLogs)
				else
					(gMessager say: 12 4) ; "You'll have to get closer to the logs, defying withering arrow fire and death, before you can climb over them."
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(class Shooter of Script
	(properties
		arrowPt 0
		arrowID 0
		arrowLoop 0
		addArrowX 0
		addArrowY 0
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(if (not local1)
					(self dispose:)
					(return)
				)
				(= temp0 (gEgo x:))
				(= arrowPt (* register 18))
				(switch register
					(1
						(= addArrowX 15)
						(= addArrowY 10)
						(= arrowLoop 1)
					)
					(2
						(= addArrowX 0)
						(= addArrowY 4)
						(cond
							((< temp0 140)
								(= arrowLoop 2)
							)
							((> temp0 225)
								(= arrowLoop 1)
							)
							(else
								(= arrowLoop 4)
							)
						)
					)
					(3
						(= addArrowX 3)
						(= addArrowY 1)
						(= arrowLoop 2)
					)
					(4
						(= addArrowX 11)
						(= addArrowY 6)
						(= arrowLoop 1)
					)
					(else
						(= addArrowX 11)
						(= addArrowY 5)
						(cond
							((< temp0 177)
								(= arrowLoop 2)
							)
							((> temp0 245)
								(= arrowLoop 1)
							)
							(else
								(= arrowLoop 4)
							)
						)
					)
				)
				(client cel: 4)
				(= cycles (Random 5 15))
			)
			(1
				(localproc_5
					(+ (client x:) addArrowX)
					(+ (client y:) addArrowY)
					arrowPt
				)
				(client setCycle: CT (- (NumCels client) 2) 1 self)
			)
			(2
				(if local149
					((= arrowID (Prop new:))
						view: 90
						setLoop: arrowLoop
						setCel: 0
						setPri: 11
						noun: 6
						ignoreActors:
						posn: [local2 (+ arrowPt 1)] [local2 (+ arrowPt 10)]
						init:
					)
				else
					((= arrowID (Prop new:))
						view: 90
						setLoop: arrowLoop
						setCel: 0
						setPri: 7
						noun: 6
						ignoreActors:
						posn: [local2 (+ arrowPt 1)] [local2 (+ arrowPt 10)]
						init:
					)
				)
				(client setCel: (+ (client cel:) 1))
				(= cycles 1)
			)
			(3
				(arrowFly play:)
				(arrowID
					setCel: 1
					posn: [local2 (+ arrowPt 2)] [local2 (+ arrowPt 11)]
				)
				(= cycles 1)
			)
			(4
				(arrowID
					setCel: 2
					posn: [local2 (+ arrowPt 3)] [local2 (+ arrowPt 12)]
				)
				(= cycles 1)
			)
			(5
				(client setCel: (NumCels client))
				(arrowID posn: [local2 (+ arrowPt 4)] [local2 (+ arrowPt 13)])
				(= cycles 1)
			)
			(6
				(arrowID
					setCel: 3
					posn: [local2 (+ arrowPt 5)] [local2 (+ arrowPt 14)]
				)
				(= cycles 1)
			)
			(7
				(if
					(and
						(== (gEgo script:) 0)
						(localproc_1
							[local2 (+ arrowPt 5)]
							[local2 (+ arrowPt 14)]
							[local2 (+ arrowPt 6)]
							[local2 (+ arrowPt 15)]
						)
					)
					(= local110 arrowID)
					(gEgo setScript: egoHit)
					(self changeState: 0)
				else
					(arrowID
						posn: [local2 (+ arrowPt 6)] [local2 (+ arrowPt 15)]
					)
					(= cycles 1)
				)
			)
			(8
				(if
					(and
						(== (gEgo script:) 0)
						(localproc_1
							[local2 (+ arrowPt 6)]
							[local2 (+ arrowPt 15)]
							[local2 (+ arrowPt 7)]
							[local2 (+ arrowPt 16)]
						)
					)
					(= local110 arrowID)
					(gEgo setScript: egoHit)
					(self changeState: 0)
				else
					(arrowID
						setCel: 4
						posn: [local2 (+ arrowPt 7)] [local2 (+ arrowPt 16)]
					)
					(= cycles 1)
				)
			)
			(9
				(if
					(and
						(== (gEgo script:) 0)
						(localproc_1
							[local2 (+ arrowPt 7)]
							[local2 (+ arrowPt 16)]
							[local2 (+ arrowPt 8)]
							[local2 (+ arrowPt 17)]
						)
					)
					(= local110 arrowID)
					(gEgo setScript: egoHit)
					(self changeState: 0)
				else
					(arrowID
						posn: [local2 (+ arrowPt 8)] [local2 (+ arrowPt 17)]
					)
					(= cycles 1)
				)
			)
			(10
				(++ local111)
				(arrowID dispose:)
				(if (or local151 (not local149))
					(++ local151)
				)
				(if (or (> local151 local112) (> local111 (* 2 local112)))
					(EgoDead 7 8) ; "Congratulations! Thanks to your efforts as a moving target, the Spielburg Bandits are a cinch to win the archery contest in next year's Brigandiad."
				)
				(self changeState: 0)
			)
		)
	)
)

(instance shoot1 of Shooter
	(properties)
)

(instance shoot2 of Shooter
	(properties)
)

(instance shoot3 of Shooter
	(properties)
)

(instance shoot4 of Shooter
	(properties)
)

(instance shoot5 of Shooter
	(properties)
)

(instance egoHit of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(local110 dispose:)
				(cond
					((gEgo has: 3) ; chainMail
						(TakeDamage 10)
					)
					((gEgo has: 4) ; leather
						(TakeDamage 20)
					)
					(else
						(TakeDamage 35)
					)
				)
				(for ((= temp0 0)) (<= temp0 24) ((+= temp0 4))
					(if (not [local117 temp0])
						(= [local117 temp0] local114)
						(= [local117 (+ temp0 1)] local115)
						(= [local117 (+ temp0 2)] local116)
						((= [local117 (+ temp0 3)] (View new:))
							view: 90
							setLoop: 5
							setCel: 1
							noun: 6
							ignoreActors:
							init:
						)
						(break)
					)
				)
				(if (or (<= [gEgoStats 14] 0) local150) ; health
					(= ticks 12)
				else
					(self dispose:)
				)
			)
			(1
				(if local150
					(gMessager say: 8 0 3 1 self) ; "You have a splintering headache that's doing you in."
				else
					(self cue:)
				)
			)
			(2
				(EgoDead 41 42) ; "This was not the ending you had in mind when you read the manual on "How to be a Hero." Either you just aren't ready to take on this situation, or there is a better way to accomplish your mission."
			)
		)
	)
)

(instance egoDies of Script ; UNUSED
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(EgoDead 41 42) ; "This was not the ending you had in mind when you read the manual on "How to be a Hero." Either you just aren't ready to take on this situation, or there is a better way to accomplish your mission."
			)
		)
	)
)

(instance egoEnters of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
			)
			(1
				(if (not (IsFlag 81))
					(gMessager say: 8 0 1) ; "You have a bad feeling about this place."
				)
				(= ticks 1)
			)
			(2
				(archer4 setCycle: CT 6 1)
				(archer3 setCycle: CT 7 1 self)
			)
			(3
				(if local0
					(spearman4 setCycle: End)
				)
				(archer1 setCycle: CT 6 1 self)
			)
			(4
				(archer4 stopUpd:)
				(if local0
					(spearman5 setLoop: 1 cel: 0 setCycle: End)
				)
				(archer2 setCycle: CT 5 1 self)
			)
			(5
				(archer5 stopUpd:)
				(archer1 stopUpd:)
				(archer3 stopUpd:)
				(if (not (IsFlag 81))
					(gMessager say: 8 0 2) ; "You have an even worse feeling about this place."
				)
				(archer5 setCycle: CT 8 1 self)
			)
			(6
				(archer2 stopUpd:)
				(if local0
					(spearman4 stopUpd:)
					(spearman5 stopUpd:)
				)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance climbOverLogs of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if local149
					(gEgo setMotion: PolyPath 139 139 self)
				else
					(gEgo setMotion: PolyPath 141 112 self)
				)
			)
			(1
				(if local149
					(gEgo setMotion: PolyPath 139 129 self)
				else
					(gEgo setMotion: PolyPath 141 122 self)
				)
			)
			(2
				(gEgo view: 400 posn: 141 109 setCel: 0 ignoreActors:)
				(if local149
					(gEgo setLoop: 0 setPri: 9 setCycle: CT 4 1 self)
				else
					(gEgo setLoop: 1 setCycle: CT 4 1 self)
				)
			)
			(3
				(if (gCurRoom obstacles:)
					((gCurRoom obstacles:) dispose:)
					(gCurRoom obstacles: 0)
				)
				(if local149
					(gEgo setPri: 7 setCycle: End self)
				else
					(gEgo setPri: 11 setCycle: End self)
				)
			)
			(4
				(if local149
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init: 319 189 0 189 0 0 123 72 84 87 88 121 106 126 121 122 139 116 139 105 132 69 131 0 319 0
								yourself:
							)
					)
					(if local0
						(gCurRoom newRoom: 465) ; brigandArena
					else
						(= local149 0)
						(gEgo setPri: 7 posn: 139 122)
					)
				else
					(= local149 1)
					(gCurRoom
						addObstacle:
							((Polygon new:)
								type: PBarredAccess
								init: 0 0 319 0 319 132 271 133 261 129 239 131 183 125 170 121 155 124 123 124 108 130 97 127 89 132 94 137 241 155 319 155 319 189 0 189
								yourself:
							)
					)
					(gEgo posn: 139 129)
				)
				(HandsOn)
				(NormalEgo)
				(self cue:)
			)
			(5
				(if local149
					(gEgo setPri: 11)
					(archer3 setScript: shoot3 0 3)
					(archer5 setScript: shoot5 0 5)
				)
				(if (== gPrevRoomNum 465) ; brigandArena
					(gEgo ignoreActors:)
				)
				(if (> (++ local152) 2)
					(EgoDead 108 109) ; "Congratulations! You've just won a gold medal in the log jump. Posthumously."
				)
			)
		)
	)
)

(instance runAway of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gMessager say: 8 0 4) ; "That's one way of collecting arrows. Shame you don't have a bow."
				(gEgo setMotion: PolyPath 335 (gEgo y:) self)
			)
			(1
				(HandsOn)
				(gCurRoom newRoom: 92)
			)
		)
	)
)

(instance startSpell of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(if local1
					(self cue:)
				else
					(= local1 1)
					(archer1 setScript: shoot1 0 1)
					(archer2 setScript: shoot2 0 2)
					(archer4 setScript: shoot4 0 4)
					(if local149
						(archer3 setScript: shoot3 0 3)
						(archer5 setScript: shoot5 0 5)
					else
						(archer3 stopUpd:)
						(archer5 stopUpd:)
					)
					(= ticks 480)
				)
			)
			(1
				(EgoDead 155 156) ; "There must be reasons to stop and let five archers draw beads on you while you attempt to cast a spell, but none come to mind."
			)
		)
	)
)

