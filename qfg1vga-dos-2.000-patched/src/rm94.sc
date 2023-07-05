;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 94)
(include sci.sh)
(use Main)
(use dartScript)
(use n105)
(use n106)
(use Door)
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
	rm94 0
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
	[local10 28]
	local38
	local39
	local40
)

(procedure (localproc_0 param1 param2 param3)
	(= local39 0)
	(if local6
		(= local38 6)
	else
		(switch param1
			(0
				(switch param2
					(0
						(if param3
							(= local38 0)
							(= local39 6)
						else
							(= local38 3)
						)
					)
					(1
						(if param3
							(= local39 -6)
							(= local38 3)
						else
							(= local38 0)
						)
					)
					(else
						(= local38 6)
					)
				)
			)
			(1
				(switch param2
					(0
						(if param3
							(= local38 3)
						else
							(= local39 6)
							(= local38 0)
						)
					)
					(1
						(if param3
							(= local38 0)
						else
							(= local39 -6)
							(= local38 3)
						)
					)
					(else
						(= local38 6)
					)
				)
			)
			(2
				(switch param2
					(2
						(if param3
							(= local38 0)
						else
							(= local38 3)
						)
					)
					(3
						(if param3
							(= local38 3)
						else
							(= local38 0)
						)
					)
					(else
						(= local38 6)
					)
				)
			)
			(else
				(switch param2
					(2
						(if param3
							(= local38 3)
						else
							(= local38 0)
						)
					)
					(3
						(if param3
							(= local38 0)
						else
							(= local38 3)
						)
					)
					(else
						(= local38 6)
					)
				)
			)
		)
	)
)

(procedure (localproc_1 param1 param2 param3 param4 &tmp temp0 temp1)
	(= temp0
		(localproc_2
			param1
			param2
			(gEgo x:)
			(- (gEgo y:) 30)
			(gEgo x:)
			(- (gEgo y:) 15)
		)
	)
	(= temp1
		(localproc_2
			param3
			param4
			(gEgo x:)
			(- (gEgo y:) 30)
			(gEgo x:)
			(- (gEgo y:) 15)
		)
	)
	(if (== temp0 temp1)
		(return 0)
	)
	(= temp0
		(localproc_2
			(gEgo x:)
			(- (gEgo y:) 30)
			param1
			param2
			param3
			param4
		)
	)
	(= temp1
		(localproc_2
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
		(= local7
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
		(= local8 (gEgo loop:))
		(if (< (gEgo x:) param1)
			(= local9 1)
		else
			(= local9 0)
		)
		(return 1)
	)
)

(procedure (localproc_2 param1 param2 param3 param4 param5 param6)
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

(procedure (localproc_3)
	(archer1 setScript: archer1Start)
	(archer2 setScript: archer2Start)
	(archer3 setScript: archer3Start)
	(archer4 setScript: archer4Start)
)

(instance rm94 of Rm
	(properties
		picture 94
		style 8
	)

	(method (dispose)
		(= global451 0)
		(super dispose:)
	)

	(method (notify param1)
		(switch param1
			(0
				(if (== local2 1)
					(= local2 0)
					(localproc_3)
					(return 1)
				else
					(return 0)
				)
			)
			(2
				(archer1Start archerStop: 300)
				(archer2Start archerStop: 300)
				(archer3Start archerStop: 300)
				(archer4Start archerStop: 300)
			)
		)
	)

	(method (init)
		(LoadMany rsVIEW 94 194 590 3 515 536 537)
		(LoadMany rsSOUND 73 35 81 6 4 9 4)
		(gLongSong number: 73 loop: -1 play:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 319 0 319 54 319 189 278 189 220 189 230 183 288 183 312 119 280 94 180 94 166 81 209 72 259 72 259 68 106 68 112 84 104 102 43 102 7 164 16 185 91 185 97 189 0 189
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 36 149 135 129 147 137 145 152 56 174 34 162
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 254 174 167 149 167 137 194 131 287 150
					yourself:
				)
		)
		(super init:)
		(self
			setFeatures:
				onWire1
				onWire2
				onSacks
				onKegs
				onChasm
				onWindow
				lumber1
				lumber2
		)
		(onChasm init:)
		(SolvePuzzle 705 8)
		(NormalEgo)
		(rugTop ignoreActors: 1 init: stopUpd:)
		(rugBottom ignoreActors: 1 init: stopUpd:)
		(unSafeBridge ignoreActors: 1 setPri: 6 init: stopUpd:)
		(safeBridge ignoreActors: 1 setPri: 6 init: addToPic:)
		(JackCycle init: hide:)
		(archer1 init: hide: setPri: 6 stopUpd:)
		(archer2 init: hide: stopUpd:)
		(archer3 init: hide: stopUpd:)
		(archer4 init: hide: stopUpd:)
		(= local2 1)
		(if (or (not (IsFlag 348)) (IsFlag 237))
			(SetFlag 84)
			(= local2 0)
			(localproc_3)
		)
		(switch gPrevRoomNum
			(95
				(backDoor cel: 4 setPri: 1 init:)
				(= local3 1)
				(gEgo posn: 223 76 init: setMotion: MoveTo 190 76)
			)
			(93
				(backDoor setPri: 1 init:)
				(gEgo posn: 157 188 init: setMotion: MoveTo 157 172)
			)
			(else
				(gEgo posn: 152 170 init:)
				(backDoor setPri: 1 init:)
			)
		)
	)

	(method (doit)
		(cond
			((and (not local6) (gEgo inRect: 95 101 121 116))
				(= local6 1)
				(gEgo setScript: fallBridge)
			)
			(
				(and
					(not local6)
					(not (<= 238 (gEgo x:) 256))
					(<= 105 (gEgo y:) 114)
				)
				(= local6 1)
				(gEgo setScript: fallChasm)
			)
			((and (gEgo inRect: 100 80 180 90) (not local4) (not local6))
				(= local6 1)
				(gEgo setScript: egoTripsNorth)
			)
			(
				(and
					(gEgo inRect: 252 147 310 163)
					(not local5)
					(!= (gEgo script:) egoTripsSouth)
					(!= (gEgo script:) fallChasm)
				)
				(gEgo setScript: egoTripsSouth)
			)
			((and (gEgo inRect: 139 138 187 152) (not local6))
				(= local6 1)
				(gEgo setPri: 11 setScript: fallRug)
			)
		)
		(cond
			((and local3 (& (gEgo onControl: 1) $0002))
				(gCurRoom newRoom: 95)
			)
			((and (== (gEgo edgeHit:) 3) (not local6))
				(gCurRoom newRoom: 93)
			)
		)
		(super doit:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(52 ; Sleep
				(EgoDead 147 148) ; "The brigands oblige you by making your pleasant rest permanent."
			)
			(50 ; detectMagicSpell
				(gMessager say: 15 50) ; "No spells are active here."
			)
			(78 ; dazzleSpell
				(if (not (rm94 notify: 0))
					(if (CastDazzle)
						(rm94 notify: 2)
					)
				else
					(CastDazzle)
					(rm94 notify: 0)
					(gMessager say: 15 80) ; "That was a useless gesture."
					(= local2 0)
				)
			)
			(81 ; flameDartSpell
				(if (not local2)
					(gEgo setScript: didDart)
				else
					(rm94 notify: 0)
					(CastDart 0)
					(= local2 0)
				)
			)
			(80 ; calmSpell
				(if (rm94 notify: 0)
					(gMessager say: 15 80) ; "That was a useless gesture."
				else
					(gMessager say: 15 80 1) ; "None of the brigands notices your Calm spell. There is too much negative thought energy here."
				)
			)
			(51 ; openSpell
				(if local1
					(gMessager say: 15 51) ; "That was a useless spell."
				else
					(rm94 notify: 0)
					(rm94 setScript: openMess)
					(= local2 0)
					(= local1 1)
					(if (CastOpen gEgo openMess)
						(JackCycle setScript: jackJumps)
					else
						(openMess changeState: 2)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(class Archer of Script
	(properties
		archerStop 0
		fequencyA 3
		fequencyB 10
		arrowsShot 0
		maxArrows 30
		minArrows 5
		clientP 0
		shootX 0
		shootY 0
		hideX 0
		hideY 0
		arrowV 0
		arrowL 0
		arrowC 0
		arrowP 0
		startX 0
		startY 0
		A1 0
		B1 0
		X1 0
		Y1 0
		A2 0
		B2 0
		X2 0
		Y2 0
		A3 0
		B3 0
		X3 0
		Y3 0
		A4 0
		B4 0
		X4 0
		Y4 0
		A5 0
		B5 0
		X5 0
		Y5 0
		A6 0
		B6 0
		X6 0
		Y6 0
		begX 0
		begY 0
		endX 0
		endY 0
		archDeltaX 0
		archDeltaY 0
	)

	(method (doit)
		(if (and archerStop (not (-- archerStop)))
			(localproc_3)
		)
		(cond
			(
				(and
					(< state 3)
					(or
						(> arrowsShot maxArrows)
						(and archerStop (!= state 10))
						(and
							(< -20 (- startX (gEgo x:)) 20)
							(!= state 10)
							(< -20 (- startY (gEgo y:)) 20)
						)
					)
				)
				(self changeState: 10)
			)
			(
				(and
					(<= arrowsShot maxArrows)
					(not archerStop)
					(not (< -50 (- startX (gEgo x:)) 50))
					(== state 11)
				)
				(self changeState: 0)
			)
		)
		(super doit:)
	)

	(method (archerShoot)
		(cond
			((and (<= 90 (gEgo y:) 100) (< A1 (gEgo x:) B1))
				(= endX (- X1 (Random 2 8)))
				(= endY (- Y1 (Random 4 16)))
				(return 1)
			)
			((and (<= 100 (gEgo y:) 110) (< A2 (gEgo x:) B2))
				(= endX (- X2 (Random 2 8)))
				(= endY (- Y2 (Random 4 16)))
				(return 1)
			)
			((and (<= 110 (gEgo y:) 120) (< A3 (gEgo x:) B3))
				(= endX (- X3 (Random 2 8)))
				(= endY (- Y3 (Random 4 16)))
				(return 1)
			)
			((and (<= 120 (gEgo y:) 130) (< A4 (gEgo x:) B4))
				(= endX (- X4 (Random 2 8)))
				(= endY (- Y4 (Random 4 16)))
				(return 1)
			)
			((and (<= 130 (gEgo y:) 140) (< A5 (gEgo x:) B5))
				(= endX (- X5 (Random 2 8)))
				(= endY (- Y5 (Random 4 16)))
				(return 1)
			)
			((and (<= 140 (gEgo y:) 150) (< A6 (gEgo x:) B6))
				(= endX (- X6 (Random 2 8)))
				(= endY (- Y6 (Random 4 16)))
				(return 1)
			)
			(else
				(return 0)
			)
		)
	)

	(method (arrowPath)
		(= archDeltaX (- endX startX))
		(/= archDeltaX 5)
		(= archDeltaY (- endY startY))
		(/= archDeltaY 5)
		(= endX startX)
		(= endY startY)
		(= begX startX)
		(= begY startY)
	)

	(method (nextPath)
		(= endX (+ (= begX endX) archDeltaX))
		(= endY (+ (= begY endY) archDeltaY))
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(client
					cel: 0
					illegalBits: 0
					setPri: clientP
					ignoreActors:
					show:
					setCycle: CT 3 1 self
				)
			)
			(1
				(= cycles (Random fequencyA fequencyB))
			)
			(2
				(if (self archerShoot:)
					(arrowSound play:)
					(self arrowPath:)
					((= arrowP (Prop new:))
						view: arrowV
						setLoop: arrowL
						setCel: arrowC
						setPri: 15
						ignoreActors:
						hide:
						init:
					)
					(client setCycle: End self)
				else
					(self changeState: 1)
				)
			)
			(3
				(self nextPath:)
				(if
					(and
						(== (gEgo script:) 0)
						(localproc_1 begX begY endX endY)
					)
					(arrowP hide:)
					(gEgo setScript: egoHit 0 arrowP)
					(self changeState: 1)
				else
					(arrowP show: posn: endX endY)
				)
				(= ticks 18)
			)
			(4
				(self nextPath:)
				(if
					(and
						(== (gEgo script:) 0)
						(localproc_1 begX begY endX endY)
					)
					(arrowP hide:)
					(gEgo setScript: egoHit 0 arrowP)
					(self changeState: 1)
				else
					(arrowP posn: endX endY)
					(= ticks 18)
				)
			)
			(5
				(self nextPath:)
				(if
					(and
						(== (gEgo script:) 0)
						(localproc_1 begX begY endX endY)
					)
					(arrowP hide:)
					(gEgo setScript: egoHit 0 arrowP)
					(self changeState: 1)
				else
					(arrowP posn: endX endY)
					(= ticks 18)
				)
			)
			(6
				(self nextPath:)
				(if
					(and
						(== (gEgo script:) 0)
						(localproc_1 begX begY endX endY)
					)
					(arrowP hide:)
					(gEgo setScript: egoHit 0 arrowP)
					(self changeState: 1)
				else
					(arrowP posn: endX endY)
					(= ticks 18)
				)
			)
			(7
				(self nextPath:)
				(if
					(and
						(== (gEgo script:) 0)
						(localproc_1 begX begY endX endY)
					)
					(arrowP hide:)
					(gEgo setScript: egoHit 0 arrowP)
					(self changeState: 1)
				else
					(arrowP posn: endX endY)
					(= ticks 18)
				)
			)
			(8
				(++ arrowsShot)
				(arrowP dispose:)
				(= ticks 180)
			)
			(9
				(self changeState: 1)
			)
			(10
				(client setCycle: Beg self)
			)
			(11
				(client hide:)
			)
		)
	)
)

(instance rugTop of Prop
	(properties
		x 156
		y 142
		noun 16
		view 94
		loop 1
		priority 8
		signal 16
	)
)

(instance rugBottom of Prop
	(properties
		x 156
		y 142
		noun 16
		view 94
		loop 1
		cel 1
		priority 9
		signal 16
	)
)

(instance unSafeBridge of Prop
	(properties
		x 106
		y 115
		noun 18
		view 94
		loop 2
	)
)

(instance safeBridge of Prop
	(properties
		x 247
		y 115
		noun 17
		view 94
		loop 3
		priority 3
		signal 16
	)
)

(instance JackCycle of Prop
	(properties
		x 299
		y 168
		noun 7
		view 94
		loop 5
		priority 15
		signal 16
	)
)

(instance backDoor of Door
	(properties
		x 224
		y 13
		noun 5
		view 94
		loop 4
		priority 1
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(gCurRoom setScript: enterDiningRoom)
			)
			(18 ; thiefKit
				(gMessager say: 5 17) ; "You grin sheepishly; the door has no lock, and swings open at your touch."
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance jack1 of View
	(properties
		x 299
		y 168
		noun 6
		view 94
		loop 5
		priority 15
		signal 16
	)
)

(instance archer1 of Actor
	(properties
		y 116
		noun 1
		view 194
		priority 6
		signal 16
	)

	(method (doit)
		(for ((= local40 0)) (<= local40 24) ((+= local40 4))
			(if (!= [local10 local40] 0)
				(localproc_0
					[local10 (+ local40 1)]
					(gEgo loop:)
					[local10 (+ local40 2)]
				)
				([local10 (+ local40 3)]
					setCel: local38
					setPri: (gEgo priority:)
					posn:
						(+ (gEgo x:) local39)
						(+ (gEgo y:) [local10 local40])
				)
			)
		)
		(super doit:)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(81 ; flameDartSpell
				(gEgo setScript: didDart)
			)
			(16 ; dagger
				(gEgo setScript: didDart)
			)
			(20 ; rock
				(gEgo setScript: didDart)
			)
			(12 ; sword
				(gEgo setScript: didDart)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance archer2 of Actor
	(properties
		x 319
		y 116
		noun 2
		view 194
		loop 1
	)

	(method (doVerb theVerb)
		(archer1 doVerb: theVerb)
	)
)

(instance archer3 of Actor
	(properties
		x 277
		y 83
		noun 3
		view 194
		loop 2
	)

	(method (doVerb theVerb)
		(archer1 doVerb: theVerb)
	)
)

(instance archer4 of Actor
	(properties
		x 43
		y 83
		noun 4
		view 194
		loop 3
	)

	(method (doVerb theVerb)
		(archer1 doVerb: theVerb)
	)
)

(instance antwerp of Actor
	(properties
		view 590
		loop 7
		priority 15
		signal 8208
	)

	(method (init)
		(= global451 1590)
		(PalVary pvCHANGE_TARGET 1590)
		(AssertPalette 590)
		(super init:)
	)
)

(instance onSacks of Feature
	(properties
		x 80
		y 71
		noun 12
		nsTop 53
		nsLeft 54
		nsBottom 89
		nsRight 100
	)
)

(instance onKegs of Feature
	(properties
		x 223
		y 74
		noun 9
		nsTop 58
		nsLeft 179
		nsBottom 90
		nsRight 268
	)
)

(instance onChasm of Feature
	(properties
		x 158
		y 112
		noun 8
	)

	(method (init)
		((= onMeCheck (Polygon new:))
			type: PTotalAccess
			init: 25 101 298 101 308 117 10 117
			yourself:
		)
		(super init:)
	)

	(method (dispose)
		(onMeCheck dispose:)
		(super dispose:)
	)
)

(instance lumber1 of Feature
	(properties
		x 82
		y 115
		z 30
		noun 10
		nsTop 130
		nsLeft 40
		nsBottom 157
		nsRight 125
	)
)

(instance lumber2 of Feature
	(properties
		x 231
		y 141
		noun 11
		nsTop 121
		nsLeft 195
		nsBottom 162
		nsRight 261
	)
)

(instance onWindow of Feature
	(properties
		x 192
		y 28
		nsTop 18
		nsLeft 174
		nsBottom 39
		nsRight 211
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(cond
					((gEgo inRect: 156 65 207 76)
						(gMessager say: 13 1 3) ; "All that can be seen through the window are vague shapes and outlines."
					)
					((not (< 59 (gEgo x:) 240))
						(if (rm94 notify: 0)
							(archer1 setScript: archer1Start)
							(archer2 setScript: archer2Start)
							(archer3 setScript: archer3Start)
							(archer4 setScript: archer4Start)
							(gMessager say: 13 1 2) ; "You see a group of brigands playing cards. One looks back at you in surprise and starts yelling."
						)
					)
					(else
						(gMessager say: 13 1 1) ; "You can't see through the windows from here."
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance onWire1 of Feature
	(properties
		x 286
		y 156
		noun 14
		nsTop 150
		nsLeft 262
		nsBottom 160
		nsRight 307
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(4 ; Do
				(gMessager say: 14 4) ; "You feel a trip wire. Why, those sneaky brigands! Now that you know it's there, you can easily step over it."
				(= local5 1)
			)
			(81 ; flameDartSpell
				(gMessager say: 14 16) ; "Hey! Even the most rudimentary hero knows that the way to deal with a tripwire is to step over it, not cut it. Now that you now it's there, you'll avoid it."
				(= local5 1)
			)
			(16 ; dagger
				(gMessager say: 14 16) ; "Hey! Even the most rudimentary hero knows that the way to deal with a tripwire is to step over it, not cut it. Now that you now it's there, you'll avoid it."
				(= local5 1)
			)
			(12 ; sword
				(gMessager say: 14 16) ; "Hey! Even the most rudimentary hero knows that the way to deal with a tripwire is to step over it, not cut it. Now that you now it's there, you'll avoid it."
				(= local5 1)
			)
			(1 ; Look
				(gMessager say: 14 1) ; "There is a dark rope stretched tautly across the path. Now that you know it's there, you can easily avoid it by stepping over it."
				(= local5 1)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance onWire2 of Feature
	(properties
		x 137
		y 85
		z 7
		nsTop 73
		nsLeft 100
		nsBottom 83
		nsRight 180
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(1 ; Look
				(gMessager say: 14 1) ; "There is a dark rope stretched tautly across the path. Now that you know it's there, you can easily avoid it by stepping over it."
				(= local4 1)
			)
			(81 ; flameDartSpell
				(gMessager say: 14 16) ; "Hey! Even the most rudimentary hero knows that the way to deal with a tripwire is to step over it, not cut it. Now that you now it's there, you'll avoid it."
				(= local4 1)
			)
			(16 ; dagger
				(gMessager say: 14 16) ; "Hey! Even the most rudimentary hero knows that the way to deal with a tripwire is to step over it, not cut it. Now that you now it's there, you'll avoid it."
				(= local4 1)
			)
			(12 ; sword
				(gMessager say: 14 16) ; "Hey! Even the most rudimentary hero knows that the way to deal with a tripwire is to step over it, not cut it. Now that you now it's there, you'll avoid it."
				(= local4 1)
			)
			(4 ; Do
				(gMessager say: 14 4) ; "You feel a trip wire. Why, those sneaky brigands! Now that you know it's there, you can easily step over it."
				(= local4 1)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
	)
)

(instance archer1Start of Archer
	(properties
		fequencyA 5
		fequencyB 15
		clientP 6
		shootX 49
		shootY 78
		hideX 16
		hideY 78
		arrowV 194
		arrowL 6
		arrowC 3
		startX 84
		startY 65
		B1 320
		X1 260
		Y1 84
		B2 320
		X2 276
		Y2 97
		B3 320
		X3 294
		Y3 113
		A4 160
		B4 320
		X4 315
		Y4 133
		A5 240
		B5 320
		X5 321
		Y5 141
		A6 1
	)
)

(instance archer2Start of Archer
	(properties
		fequencyA 5
		fequencyB 15
		clientP 4
		shootX 275
		shootY 80
		hideX 296
		hideY 80
		arrowV 194
		arrowL 6
		startX 250
		startY 67
		B1 320
		X1 67
		Y1 77
		B2 320
		X2 47
		Y2 97
		B3 170
		X3 25
		Y3 116
		B4 150
		X4 9
		Y4 132
		B5 145
		X5 5
		Y5 142
		A6 1
	)
)

(instance archer3Start of Archer
	(properties
		fequencyA 5
		fequencyB 15
		clientP 3
		shootX 10
		shootY 106
		hideX -23
		hideY 106
		arrowV 194
		arrowL 6
		arrowC 3
		startX 35
		startY 93
		A1 200
		B1 320
		X1 262
		Y1 85
		A2 200
		B2 320
		X2 273
		Y2 95
		B3 320
		X3 287
		Y3 105
		B4 320
		X4 296
		Y4 111
		B5 320
		X5 306
		Y5 130
		A6 200
		B6 320
		X6 320
		Y6 142
	)
)

(instance archer4Start of Archer
	(properties
		fequencyA 5
		fequencyB 15
		clientP 3
		shootX 313
		shootY 110
		hideX 343
		hideY 110
		arrowV 194
		arrowL 6
		startX 288
		startY 97
		B1 120
		X1 75
		Y1 67
		B2 140
		X2 68
		Y2 86
		B3 200
		X3 36
		Y3 104
		B4 320
		X4 23
		Y4 120
		B5 320
		X5 16
		Y5 123
		B6 320
		X6 7
		Y6 135
	)
)

(instance arrowSound of Sound
	(properties
		number 31
	)
)

(instance fallSound of Sound
	(properties
		number 9
	)
)

(instance JackSound of Sound
	(properties
		number 81
	)
)

(instance lockSound of Sound
	(properties
		number 35
	)
)

(instance antwerpSound of Sound
	(properties
		number 4
	)
)

(instance egoHit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(register show:)
				(cond
					((gEgo has: 3) ; chainMail
						(TakeDamage 15)
					)
					((gEgo has: 4) ; leather
						(TakeDamage 30)
					)
					(else
						(TakeDamage 45)
					)
				)
				(cond
					((== [local10 0] 0)
						(= [local10 0] local7)
						(= [local10 1] local8)
						(= [local10 2] local9)
						(= [local10 3] register)
					)
					((== [local10 4] 0)
						(= [local10 4] local7)
						(= [local10 5] local8)
						(= [local10 6] local9)
						(= [local10 7] register)
					)
					((== [local10 8] 0)
						(= [local10 8] local7)
						(= [local10 9] local8)
						(= [local10 10] local9)
						(= [local10 11] register)
					)
					((== [local10 12] 0)
						(= [local10 12] local7)
						(= [local10 13] local8)
						(= [local10 14] local9)
						(= [local10 15] register)
					)
					((== [local10 16] 0)
						(= [local10 16] local7)
						(= [local10 17] local8)
						(= [local10 18] local9)
						(= [local10 19] register)
					)
					((== [local10 20] 0)
						(= [local10 20] local7)
						(= [local10 21] local8)
						(= [local10 22] local9)
						(= [local10 23] register)
					)
					((== [local10 24] 0)
						(= [local10 24] local7)
						(= [local10 25] local8)
						(= [local10 26] local9)
						(= [local10 27] register)
					)
					(else
						(register dispose:)
					)
				)
				(if (<= [gEgoStats 14] 0) ; health
					(= cycles 3)
				else
					(self dispose:)
				)
			)
			(1
				(EgoDead 41 42) ; "This was not the ending you had in mind when you read the manual on "How to be a Hero." Either you just aren't ready to take on this situation, or there is a better way to accomplish your mission."
			)
		)
	)
)

(instance didDart of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(archer1 setCycle: End)
				(archer2 setCycle: End)
				(archer3 setCycle: End)
				(archer4 setCycle: End self)
			)
			(1
				(EgoDead 54 55) ; "Four brigand archers, shooting at close range from cover, was too much for even a correspondence-school Hero like you to survive. There are times to fight, and there are times to run. This was one of the latter."
			)
		)
	)
)

(instance openMess of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(gMessager say: 15 0 4) ; "You hear a snick as the hasp on the Jack in the Box is released."
				(lockSound play:)
				(= ticks 60)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance fallBridge of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setLoop: 0)
				(= ticks 6)
			)
			(1
				(lockSound play:)
				(gEgo
					view: 3
					setLoop: 0
					setCel: 0
					illegalBits: 0
					setPri: 8
					setMotion: 0
					setCycle: 0
					posn: 113 110
				)
				(unSafeBridge setCel: 1)
				(= ticks 3)
			)
			(2
				(gEgo setCel: 1 posn: 114 111)
				(= ticks 3)
			)
			(3
				(gEgo setCel: 2 posn: 120 114)
				(= ticks 3)
			)
			(4
				(fallSound play:)
				(gEgo setCel: 3 setPri: 7 posn: 127 118)
				(= ticks 3)
			)
			(5
				(gEgo setCel: 4 posn: 130 120)
				(= ticks 3)
			)
			(6
				(gEgo setCel: 5 posn: 133 120)
				(= ticks 3)
			)
			(7
				(gEgo setCel: 6 posn: 136 120)
				(= ticks 3)
			)
			(8
				(gEgo hide:)
				(unSafeBridge setCel: 0)
				(if (rm94 notify: 0)
					(archer1 setScript: archer1Start)
					(archer2 setScript: archer2Start)
					(archer3 setScript: archer3Start)
					(archer4 setScript: archer4Start)
				)
				(= ticks 120)
			)
			(9
				(EgoDead 70 71) ; "I score that about a 3. Those diving lessons were a complete waste. Maybe you should have taken up bowling."
				(self dispose:)
			)
		)
	)
)

(instance fallChasm of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: 0 setCycle: 0)
				(if (== (gEgo loop:) 3)
					(gEgo setLoop: 1)
				)
				(= ticks 12)
			)
			(1
				(cond
					((< 226 (gEgo x:) 247)
						(gEgo posn: 226 109)
					)
					((< 246 (gEgo x:) 273)
						(gEgo posn: 273 109)
					)
					(else
						(gEgo posn: (gEgo x:) 109)
					)
				)
				(gEgo setLoop: 2)
				(= ticks 12)
			)
			(2
				(gEgo view: 537 setLoop: 0 cel: 0 setPri: 7)
				(= ticks 60)
			)
			(3
				(gEgo setCel: 1)
				(= ticks 60)
			)
			(4
				(gEgo setCel: 0)
				(= ticks 60)
			)
			(5
				(gEgo setCel: 2)
				(= ticks 60)
			)
			(6
				(gEgo setLoop: 0 posn: (gEgo x:) 114)
				(= ticks 2)
			)
			(7
				(gEgo setLoop: 0 posn: (gEgo x:) 120)
				(= ticks 2)
			)
			(8
				(gEgo setLoop: 0 posn: (gEgo x:) 127)
				(= ticks 2)
			)
			(9
				(gEgo setLoop: 0 posn: (gEgo x:) 135)
				(= ticks 2)
			)
			(10
				(gEgo setLoop: 0 posn: (gEgo x:) 144)
				(= ticks 2)
			)
			(11
				(gEgo setLoop: 0 posn: (gEgo x:) 154)
				(= ticks 1)
			)
			(12
				(gEgo setCel: 3)
				(= ticks 1)
			)
			(13
				(gEgo hide:)
				(self cue:)
			)
			(14
				(if (rm94 notify: 0)
					(archer1 setScript: archer1Start)
					(archer2 setScript: archer2Start)
					(archer3 setScript: archer3Start)
					(archer4 setScript: archer4Start)
				)
				(= ticks 120)
			)
			(15
				(EgoDead 72 73) ; "... as you realize those large porcupines down here are really other heroes who collected arrows the hard way."
				(self dispose:)
			)
		)
	)
)

(instance egoTripsNorth of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (doit)
		(super doit: &rest)
		(if (and (>= state 4) (== (antwerp cel:) 0))
			(antwerpSound play:)
		)
	)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(HandsOff)
				(cond
					((> (gEgo x:) 153)
						(= temp0 153)
					)
					((< (gEgo x:) 131)
						(= temp0 131)
					)
					(else
						(= temp0 (gEgo x:))
					)
				)
				(gEgo
					ignoreActors:
					view: 536
					setLoop: 0
					cel: 0
					setPri: 3
					illegalBits: 0
					posn: temp0 80
					setCycle: End
					setMotion: MoveTo temp0 80 self
				)
			)
			(1
				(fallSound play:)
				(antwerp
					setLoop: 0
					setPri: 15
					ignoreActors:
					ignoreHorizon:
					x: -20
					y: -26
					xStep: 12
					yStep: 8
					init:
					setMotion: MoveTo 53 26 self
				)
			)
			(2
				(antwerp
					moveSpeed: 3
					cycleSpeed: 3
					setCycle: Fwd
					setMotion: MoveTo (- (gEgo x:) 30) -40 self
				)
			)
			(3
				(antwerp setMotion: MoveTo (gEgo x:) (gEgo y:) self)
			)
			(4
				(fallSound stop:)
				(antwerp moveSpeed: 5 cycleSpeed: 5)
				(self cue:)
			)
			(5
				(if (rm94 notify: 0)
					(archer1 setScript: archer1Start)
					(archer2 setScript: archer2Start)
					(archer3 setScript: archer3Start)
					(archer4 setScript: archer4Start)
				)
				(= ticks 90)
			)
			(6
				(antwerp moveSpeed: 8 cycleSpeed: 8)
				(= ticks 90)
			)
			(7
				(antwerp moveSpeed: 12 cycleSpeed: 12)
				(= ticks 90)
			)
			(8
				(EgoDead 3 4) ; "Talk about an unpleasant trip to Belgium. Next time avoid antwerp (and the trip rope) altogether."
				(self dispose:)
			)
		)
	)
)

(instance egoTripsSouth of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= local5 1)
				(gEgo
					view: 536
					setLoop: 0
					cel: 0
					posn: 290 151
					illegalBits: 0
					setCycle: End
					setMotion: MoveTo 288 (- (gEgo y:) 12) self
				)
				(if (not local1)
					(JackCycle setScript: jackJumps)
				)
			)
			(1
				(= ticks 60)
			)
			(2
				(gEgo view: 515 setLoop: 1 setCel: 4 setCycle: Beg self)
			)
			(3
				(NormalEgo)
				(gEgo loop: 3)
				(= ticks 18)
			)
			(4
				(NormalEgo)
				(gEgo loop: 1)
				(= ticks 18)
			)
			(5
				(NormalEgo)
				(gEgo loop: 2)
				(= ticks 18)
			)
			(6
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance fallRug of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: 0 setCycle: 0)
				(if (== (gEgo loop:) 3)
					(gEgo setLoop: 1)
				)
				(= ticks 10)
			)
			(1
				(gEgo setLoop: 2)
				(= ticks 12)
			)
			(2
				(gEgo view: 537 setLoop: 0 cel: 0 setPri: 12 posn: 158 147)
				(rugBottom dispose:)
				(rugTop setLoop: 0 setPri: 11)
				(= ticks 60)
			)
			(3
				(gEgo setCel: 1)
				(= ticks 60)
			)
			(4
				(gEgo setCel: 0)
				(= ticks 60)
			)
			(5
				(rugTop setCel: 1)
				(gEgo setCel: 2)
				(= ticks 60)
			)
			(6
				(fallSound play:)
				(gEgo setPri: 8 posn: (gEgo x:) (+ (gEgo y:) 5))
				(rugTop dispose:)
				(= ticks 10)
			)
			(7
				(gEgo posn: (gEgo x:) (+ (gEgo y:) 7))
				(= ticks 5)
			)
			(8
				(gEgo posn: (gEgo x:) (+ (gEgo y:) 10))
				(= ticks 5)
			)
			(9
				(gEgo posn: (gEgo x:) (+ (gEgo y:) 14))
				(= ticks 5)
			)
			(10
				(gEgo posn: (gEgo x:) (+ (gEgo y:) 19))
				(= ticks 5)
			)
			(11
				(if (rm94 notify: 0)
					(archer1 setScript: archer1Start)
					(archer2 setScript: archer2Start)
					(archer3 setScript: archer3Start)
					(archer4 setScript: archer4Start)
				)
				(= ticks 120)
			)
			(12
				(EgoDead 74 75) ; "A small sign reads "Booby Trap." The brigands approach to see the booby they've caught. You think to yourself, "If it looks like a trap, and it feels like a trap, maybe it IS a trap.""
				(self dispose:)
			)
		)
	)
)

(instance jackJumps of Script
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 15)
			)
			(1
				(jack1 init: setPri: 13)
				(= local1 1)
				(= ticks 30)
			)
			(2
				(jack1 dispose:)
				(JackCycle init: show: setCycle: CT 1 1 self)
				(JackSound init: play:)
				(if (rm94 notify: 0)
					(archer1 setScript: archer1Start)
					(archer2 setScript: archer2Start)
					(archer3 setScript: archer3Start)
					(archer4 setScript: archer4Start)
				)
			)
			(3
				(JackCycle setCel: 2 setCycle: End self)
				(JackSound play:)
			)
			(4
				(JackCycle cycleSpeed: 2 setLoop: 6 setCycle: CT 1 1 self)
				(JackSound play:)
			)
			(5
				(JackCycle setCycle: End self)
				(JackSound play:)
			)
			(6
				(JackCycle cycleSpeed: 4 setCycle: CT 1 1 self)
				(JackSound play:)
			)
			(7
				(JackCycle setCycle: End self)
				(JackSound play:)
			)
			(8
				(JackCycle cycleSpeed: 6 setCycle: CT 1 1 self)
				(JackSound play:)
			)
			(9
				(JackCycle setCycle: End self)
				(JackSound play:)
			)
			(10
				(JackCycle cycleSpeed: 9 setCycle: CT 1 1 self)
				(JackSound play:)
			)
			(11
				(JackCycle setCycle: End self)
				(JackSound play:)
			)
			(12
				(JackCycle cycleSpeed: 12 setCycle: CT 1 1 self)
				(JackSound play:)
			)
			(13
				(JackCycle setCycle: End self)
				(JackSound play:)
			)
			(14
				(JackCycle cycleSpeed: 15 setCycle: End self)
				(JackSound play:)
			)
			(15
				(JackSound dispose:)
				(self dispose:)
			)
		)
	)
)

(instance openGate of Script ; UNUSED
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(backDoor cycleSpeed: 2 setCycle: End self)
			)
			(1
				(= local3 1)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance closeGate of Script ; UNUSED
	(properties)

	(method (dispose)
		(super dispose:)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(backDoor cycleSpeed: 2 setCycle: Beg self)
			)
			(1
				(= local3 0)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance enterDiningRoom of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setMotion: PolyPath 234 69 self)
			)
			(1
				(backDoor setCycle: End self)
				(gEgo setMotion: MoveTo 235 61 self)
			)
			(2
				(HandsOn)
				(gCurRoom newRoom: 95)
			)
		)
	)
)

