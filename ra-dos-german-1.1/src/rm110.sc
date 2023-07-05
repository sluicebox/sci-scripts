;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 110)
(include sci.sh)
(use Main)
(use eRS)
(use PolyPath)
(use Polygon)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm110 0
)

(instance rm110 of LBRoom
	(properties
		picture 110
		style 10
	)

	(method (init)
		(LoadMany rsVIEW 151 110 111 112 113)
		(LoadMany rsSOUND 110 112)
		(self setRegions: 92) ; intro
		(super init:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 138 90 129 183 175 182 175 189 0 189 0 0 319 0 319 114 238 117 223 63 221 89
					yourself:
				)
		)
		(thedoor init:)
		(mirror init:)
		(badGuy init:)
		(inTrunk init:)
		(lid init:)
		(gGameMusic1 number: 110 flags: 1 loop: -1 play: sCartoon)
		(cond
			((> gHowFast 12) 0)
			((> gHowFast 8)
				(creditTitle setStep: 7 7)
				(creditName setStep: 7 7)
				(badGuy moveSpeed: 4 cycleSpeed: 4)
			)
			(else
				(creditTitle setStep: 15 15)
				(creditName setStep: 15 15)
				(badGuy moveSpeed: 3 cycleSpeed: 3)
			)
		)
		(self setScript: sCartoon)
	)
)

(instance sCartoon of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(thedoor setCycle: End self)
			)
			(2
				(= ticks 120)
			)
			(3
				(thedoor setCycle: Beg self)
			)
			(4
				(badGuy
					setLoop: 0
					setCycle: Walk
					setPri: 15
					setMotion: PolyPath 130 91 self
				)
				(thedoor dispose:)
			)
			(5
				(inTrunk hide:)
				(badGuy
					loop: 1
					cel: 0
					posn: 122 91
					setPri: -1
					setCycle: End self
				)
				(gNarrator x: 20 y: 160 modeless: 1)
			)
			(6
				(gGameMusic1 number: 112 flags: 1 loop: 1 play: sCartoon)
				(gMessager say: 1 0 0 0) ; "Huuurrrkk! Ack!"
				(badGuy setCycle: CT 9 -1 self)
			)
			(7
				(badGuy setCycle: End self)
			)
			(8
				(badGuy setCycle: CT 11 -1)
				(= ticks 30)
			)
			(9
				(badGuy setCycle: End)
				(= ticks 120)
			)
			(10
				(if gModelessDialog
					(gModelessDialog dispose:)
				)
				(gNarrator dispose:)
				(badGuy loop: 2 cel: 0 setCycle: End self)
			)
			(11
				(badGuy
					view: 113
					loop: 0
					cel: 0
					posn: 150 87
					setCycle: End self
				)
			)
			(12
				(badGuy
					view: 112
					loop: 0
					cel: 0
					posn: 150 87
					setCycle: End self
				)
			)
			(13
				(mirror setCycle: End self)
				(badGuy
					loop: 1
					cel: 0
					posn: 151 94
					setCycle: Walk
					setMotion: PolyPath 234 93 self
				)
			)
			(14
				(mirror dispose:)
			)
			(15
				(badGuy loop: 2 cel: 0 posn: 234 91 setCycle: End self)
			)
			(16
				(inTrunk loop: 0 posn: 247 64 setPri: 4 show:)
				(badGuy
					loop: 3
					cel: 0
					posn: 242 93
					setPri: 8
					setCycle: CT 5 1 self
				)
			)
			(17
				(badGuy setCycle: CT 9 1 self)
				(lid setCycle: End)
			)
			(18
				(inTrunk dispose:)
				(badGuy
					loop: 4
					cel: 0
					posn: 227 88
					setPri: 8
					setCycle: End self
				)
			)
			(19
				(badGuy
					loop: 5
					cel: 5
					posn: 219 95
					setCycle: Walk
					setMotion: PolyPath 300 257 self
				)
			)
			(20
				(= seconds 3)
			)
			(21
				(badGuy dispose:)
				(creditTitle init: setMotion: MoveTo 53 124 self)
				(creditName init: setMotion: MoveTo 110 152 self)
			)
			(22 0)
			(23
				(= seconds 4)
			)
			(24
				(creditTitle setMotion: MoveTo 383 124 self)
				(creditName setMotion: MoveTo 383 152 self)
			)
			(25 0)
			(26
				(if (== (gGameMusic1 prevSignal:) -1)
					(= cycles 1)
				)
			)
			(27
				(gCurRoom newRoom: 120)
			)
		)
	)
)

(instance badGuy of Actor
	(properties
		x 300
		y 257
		yStep 3
		view 111
		signal 16384
		xStep 4
	)
)

(instance thedoor of Prop
	(properties
		x 247
		y 188
		view 110
		loop 4
		signal 16384
	)
)

(instance lid of Prop
	(properties
		x 287
		y 91
		view 110
		loop 1
		priority 8
		signal 16400
	)
)

(instance mirror of Prop
	(properties
		x 179
		y 39
		view 110
		loop 3
	)
)

(instance creditTitle of Actor
	(properties
		x 375
		y 124
		view 151
		loop 2
		signal 2048
		moveSpeed 0
	)
)

(instance creditName of Actor
	(properties
		x 432
		y 152
		view 151
		loop 2
		cel 1
		signal 2048
		moveSpeed 0
	)
)

(instance inTrunk of View
	(properties
		x 100
		y 62
		view 110
		loop 2
		priority 6
		signal 16400
	)
)

