;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 355)
(include sci.sh)
(use Main)
(use n010)
(use Tactor)
(use goGet)
(use Osc)
(use PolyPath)
(use Polygon)
(use Feature)
(use LoadMany)
(use StopWalk)
(use Sound)
(use Jump)
(use Motion)
(use Actor)

(public
	Room355 0
)

(local
	local0
	[local1 200]
	local201
	local202 = -1
)

(instance Room355 of FRoom
	(properties
		lookStr {You are now inside Bookend's cave.}
		picture 355
		style 0
		west 350
		westX 195
		westY 172
		defeatEntrance 1
	)

	(method (init)
		(= global140 2)
		(LoadMany rsSOUND 39 40 41 42 43 44 45 46 47 141 142 143 144 108 101)
		(LoadMany
			rsVIEW
			(+ 30 global139)
			751
			754
			755
			756
			760
			762
			763
			764
			765
			766
			767
			747
		)
		(LoadMany rsSCRIPT 991)
		(super init:)
		(if (gGame script:)
			(gGame setScript: 0)
			(gGlobalMusic2 stop:)
		)
		(gGlobalMusic number: 40 setLoop: -1 play:)
		(gTheIconBar enable: show:)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 117 100 121 97 132 95 137 92 168 93 190 95 181 104 168 110 140 111 134 107
					yourself:
				)
				((Polygon new:)
					type: PBarredAccess
					init: 0 -26 318 -26 319 173 0 173 0 150 251 155 227 118 235 99 223 83 214 81 193 79 174 81 163 79 149 76 147 76 132 75 122 76 124 70 123 64 100 64 92 70 93 76 85 83 0 85
					yourself:
				)
		)
		(rocks init:)
		(fire setCycle: Fwd init:)
		(self setScript: endIt)
	)

	(method (enterSpecial)
		(NormalEgo 0 global139)
		(gEgo
			posn: 37 146
			normal: 1
			setCycle: StopWalk
			ignoreActors: 1
			init:
		)
	)

	(method (dispose)
		(LoadMany 0 991)
		(if (gGlobalMusic handle:)
			(gGlobalMusic fade: 0 15 12 1)
		)
		(super dispose: &rest)
	)
)

(instance endIt of HandsOffScript
	(properties)

	(method (doit)
		(super doit: &rest)
		(if (and local201 (== (gGlobalMusic prevSignal:) local202))
			(= local201 0)
			(self cue:)
		)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gBookEnd view: 760 setLoop: 0 setCel: 0 posn: 197 103 init:)
				(bookWave init: setCycle: armOsc)
				(bookArm init: setCycle: armOsc2)
				(bookMouth init: setCycle: mouthOsc)
				(= ticks 360)
			)
			(1
				(proc10_13 0 gBookEnd gBookEnd self 1 355 0)
			)
			(2
				(gEgo ignoreActors: 0 setMotion: PolyPath 67 141 self)
			)
			(3
				(gEgo ignoreActors: 1)
				(Face gEgo gBookEnd self)
			)
			(4
				(proc10_13 0 gEgo gBookEnd self 1 355 1)
			)
			(5
				(proc10_13 1 gBookEnd gEgo self 0 355 2)
			)
			(6
				(proc10_13 1 gBookEnd gEgo self 1 355 3)
			)
			(7
				(gEgo setMotion: PolyPath 94 143 self)
			)
			(8
				(proc10_13 3 gEgo gBookEnd self 0 355 4)
			)
			(9
				(gEgo setMotion: PolyPath 115 137 self)
			)
			(10
				(proc10_13 3 gEgo gBookEnd self 1 355 5)
			)
			(11
				(proc10_13 1 gBookEnd gEgo self 1 355 6)
			)
			(12
				(bookWyrm init: setLoop: 3 setCel: 1 posn: 20 90)
				(gEgo setMotion: PolyPath 143 136 self)
			)
			(13
				(Face gEgo bookWyrm)
				(= ticks 60)
			)
			(14
				(proc10_13 3 gEgo bookWyrm self 1 355 7)
			)
			(15
				(= ticks 120)
			)
			(16
				(gEgo setMotion: PolyPath 200 142 self)
			)
			(17
				(Face gEgo bookWyrm)
				(= ticks 20)
			)
			(18
				(gGlobalMusic number: 41 setLoop: 1 play:)
				(bookWyrm setCycle: Walk setMotion: PolyPath 52 115 self)
			)
			(19
				(proc10_13 2 bookWyrm gBookEnd self 1 355 8)
			)
			(20
				(gGlobalMusic number: 42 setLoop: 1 play:)
				(= ticks 1)
			)
			(21
				(proc10_13 1 gBookEnd bookWyrm self 1 355 9)
			)
			(22
				(bookWyrm setMotion: PolyPath 67 113 self)
			)
			(23
				(gGlobalMusic number: 43 setLoop: 1 play:)
				(= ticks 1)
			)
			(24
				(proc10_13 1 bookWyrm gBookEnd self 1 355 10)
			)
			(25
				(gGlobalMusic number: 44 setLoop: -1 play:)
				(= ticks 1)
			)
			(26
				(proc10_13 1 gBookEnd bookWyrm self 1 355 11)
			)
			(27
				(bookWyrm setMotion: PolyPath 82 111 self)
			)
			(28
				(gGlobalMusic number: 45 setLoop: 1 play:)
				(= ticks 1)
			)
			(29
				(proc10_13 2 bookWyrm gBookEnd self 1 355 12)
			)
			(30
				(gGlobalMusic number: 46 setLoop: 1 play:)
				(= ticks 1)
			)
			(31
				(proc10_13 1 gBookEnd bookWyrm self 1 355 13)
			)
			(32
				(bookWyrm setMotion: PolyPath 96 110 self)
			)
			(33
				(= local202 10)
				(gGlobalMusic number: 47 setLoop: 1 play:)
				(= ticks 1)
			)
			(34
				(proc10_13 1 bookWyrm gBookEnd self 1 355 14)
			)
			(35
				(= local201 1)
			)
			(36
				(bookWave setCycle: 0 setCel: 1)
				(bookArm setCycle: 0 setCel: 1)
				(bookMouth setCycle: 0 setCel: 0)
				(= local202 -1)
				(bookWyrm hide:)
				(dragon init: setLoop: 0 setCycle: End self)
			)
			(37
				(dragon view: 755 setLoop: 0 setCel: 0)
				(dragonHead init: setLoop: 1)
				(dragonEyeMouth init: setLoop: 2 setCel: 0)
				(dragonEye init: setLoop: 3 setCycle: End self)
				(dragonClaw init: setLoop: 4)
			)
			(38
				(dragonGrowl play:)
				(dragonEye hide:)
				(dragonEyeMouth setCycle: End self)
				(dragonClaw setCycle: Fwd)
			)
			(39
				(dragonEyeMouth setCel: 0)
				(dragonEye show: setCel: 0 setCycle: End self)
			)
			(40
				(dragonEye hide:)
				(dragonEyeMouth setCel: 0 setCycle: End self)
			)
			(41
				(dragonBreath play:)
				(dragonHead setCel: 1 setCycle: dragonBreathe 2 self)
				(dragonEyeMouth hide:)
			)
			(42
				(dragonRoar play:)
				(dragonHead setCycle: CT 10 1 self)
				(fire setLoop: 2)
			)
			(43
				(dragonHead setCycle: CT 1 -1 self)
			)
			(44
				(dragonBreath play:)
				(dragonHead setCycle: dragonBreathe 1 self)
			)
			(45
				(fire setLoop: 0)
				(dragonHead setCel: 0)
				(dragonEyeMouth setCel: 0 show:)
				(dragonEye setCel: 0 show: setCycle: End self)
				(dragonClaw setCel: 0 show: setCycle: Fwd)
			)
			(46
				(dragonGrowl play:)
				(dragonEyeMouth setCycle: End)
				(= ticks 20)
			)
			(47
				(dragonClaw setCycle: Beg)
				(dragonEyeMouth setCel: 0)
				(dragonEye setCel: 0 setCycle: End self)
				((= local0 (bookWyrmTalkObj)) view: 747 nsLeft: 108 y: 102)
				((local0 bust:) nsLeft: 37 nsTop: 26 view: 747)
				((local0 eyes:) nsLeft: 38 nsTop: 33 view: 747)
				((local0 mouth:) nsLeft: 28 nsTop: 44 view: 747)
			)
			(48
				(proc10_13
					1
					bookWyrm
					gBookEnd
					self
					1
					(Format @local1 355 15 @global110) ; "Give the book to %s right now!"
				)
			)
			(49
				((= local0 (bookWyrmTalkObj)) view: 749 nsLeft: 108 y: 97)
				((local0 bust:) nsLeft: 45 nsTop: 25 view: 749)
				((local0 eyes:) nsLeft: 46 nsTop: 27 view: 749)
				((local0 mouth:) nsLeft: 43 nsTop: 42 view: 749)
				(= cycles 1)
			)
			(50
				(gGlobalMusic number: 52 setLoop: 1 play:)
				(= ticks 1)
			)
			(51
				(proc10_13 3 gBookEnd bookWyrm self 1 355 16)
			)
			(52
				(bookWave dispose:)
				(bookArm dispose:)
				(bookMouth dispose:)
				(gBookEnd view: 763 setLoop: 0 setCel: 0 setCycle: CT 1 1 self)
			)
			(53
				(book
					view: 355
					setLoop: 3
					setCel: 0
					posn: 158 66
					init:
					setCycle: Fwd
					setMotion: JumpTo 143 117 self
				)
				(gBookEnd setCycle: End)
			)
			(54
				(sfx number: 101 play:)
				(book setLoop: 1 setCel: 0 posn: 141 129 setPri: 5 setCycle: 0)
				(gBookEnd view: 765 setLoop: 0 setCel: 0 setCycle: End self)
			)
			(55
				(gBookEnd view: 766 setLoop: 0 setCel: 0 setCycle: Fwd)
				(= ticks 120)
			)
			(56
				(dragonHead dispose:)
				(dragonEyeMouth dispose:)
				(dragonEye dispose:)
				(dragonClaw dispose:)
				(dragon view: 754 setLoop: 0 setCel: 13 setCycle: Beg self)
			)
			(57
				(dragon dispose:)
				(bookWyrm show: posn: 96 110)
				(= cycles 1)
			)
			(58
				(gGlobalMusic number: 39 setLoop: -1 play:)
				(= ticks 1)
			)
			(59
				(proc10_13 0 bookWyrm gBookEnd self 0 355 17)
			)
			(60
				(proc10_13 0 bookWyrm gBookEnd self 1 355 18)
			)
			(61
				(gBookEnd view: 767 setLoop: 0 cel: 0 setCycle: End self)
			)
			(62
				(proc10_13 3 gEgo gBookEnd -1 1 355 19)
				(proc10_13 3 bookWyrm gBookEnd -1 0 355 20)
				(proc10_13 3 bookWyrm gBookEnd -1 1 355 21)
				(proc10_13 1 gBookEnd bookWyrm -1 1 355 22)
				(proc10_13 3 gEgo gBookEnd -1 0 355 23)
				(proc10_13 3 gEgo gBookEnd -1 0 355 24)
				(proc10_13 3 gEgo gBookEnd -1 1 355 25)
				(proc10_13 3 gBookEnd gEgo -1 1 355 26)
				(proc10_13 2 bookWyrm gBookEnd -1 0 355 27)
				(proc10_13 2 bookWyrm gBookEnd -1 1 355 28)
				(proc10_13 1 gBookEnd bookWyrm -1 1 355 29)
				(proc10_13 2 bookWyrm gBookEnd -1 1 355 30)
				(proc10_13 0 gEgo gBookEnd -1 1 355 31)
				(proc10_13 2 gBookEnd gEgo -1 1 355 32)
				(proc10_13 0 bookWyrm gBookEnd -1 0 355 33)
				(proc10_13 0 bookWyrm gBookEnd self 1 355 34)
			)
			(63
				(bookWyrm setCycle: Walk setMotion: PolyPath 115 113 self)
				(gBookEnd
					view: 762
					setLoop: 1
					setCel: 0
					setCycle: Walk
					setPri: 8
					setMotion: PolyPath 188 113
				)
			)
			(64
				(bookWyrm setCel: 0)
				(= ticks 20)
			)
			(65
				(Face gEgo book)
				(gBookEnd hide:)
				(bookWyrm
					view: 756
					setLoop: 0
					setCel: 0
					posn: 147 113
					setCycle: End self
				)
			)
			(66
				(bookWyrm setCycle: handShake 8 self)
			)
			(67
				(= ticks 60)
			)
			(68
				(bookWyrm
					view: 756
					setLoop: 1
					setCel: 0
					posn: 147 113
					setCycle: End
				)
				(gBookEnd
					show:
					view: 756
					setLoop: 2
					setCel: 0
					posn: 147 113
					setPri: 8
					setCycle: End
				)
				(= ticks 180)
			)
			(69
				(proc10_13
					0
					bookWyrm
					gEgo
					self
					1
					(Format @local1 355 35 @global110) ; "Well, %s, I guess it's time for you to go back to the library."
				)
			)
			(70
				(proc10_13 3 gEgo bookWyrm self 1 355 36)
			)
			(71
				(proc10_13 0 bookWyrm gEgo self 1 355 37)
			)
			(72
				(proc10_13 2 gEgo bookWyrm self 1 355 38)
			)
			(73
				(proc10_13
					0
					bookWyrm
					gEgo
					self
					1
					(Format @local1 355 39 @global110) ; "Of course, %s. Whenever you read my book, you will visit me again."
				)
			)
			(74
				(proc10_13
					0
					gBookEnd
					gEgo
					self
					1
					(Format @local1 355 40 @global110) ; "Good-bye, %s. Thank you for getting Bookwyrm to teach me to read."
				)
			)
			(75
				(proc10_13 0 gEgo gBookEnd self 1 355 41)
			)
			(76
				(proc10_13
					0
					bookWyrm
					gEgo
					self
					1
					(Format @local1 355 42 @global110) ; "Farewell, %s. Have fun reading!"
				)
			)
			(77
				(proc10_13 0 gEgo bookWyrm self 1 355 43)
			)
			(78
				(gEgo setMotion: PolyPath 177 129 self)
			)
			(79
				((gEgo head:) dispose:)
				(gEgo dispose:)
				(egoIntoBook play:)
				(egoLeap
					view: (+ 30 global139)
					posn: 177 129
					setLoop: 1
					setCel: 0
					init:
					setPri: 15
					setCycle: End self
				)
			)
			(80
				(gCurRoom newRoom: 360)
			)
		)
	)
)

(instance book of Actor
	(properties
		view 355
		loop 1
		priority 14
		signal 16400
	)
)

(instance egoLeap of Prop
	(properties
		loop 1
	)
)

(instance fire of Prop
	(properties
		x 158
		y 94
		description {Fire}
		lookStr {The fire burns brightly in this cave.}
		view 355
	)
)

(instance bookWyrm of Tactor
	(properties
		description {Bookwyrm}
		lookStr {Bookwyrm is here.}
		view 764
		talkerID 18
	)

	(method (setUp)
		((= talkerObj bookWyrmTalkObj)
			setUp: bookWyrmBust bookWyrmEyes bookWyrmMouth
		)
	)
)

(instance bookWyrmTalkObj of TalkerObj
	(properties
		x -1
		y 97
		nsTop 10
		nsLeft 108
		view 749
	)
)

(instance bookWyrmBust of View
	(properties
		nsTop 25
		nsLeft 45
		view 749
		loop 6
	)
)

(instance bookWyrmEyes of Prop
	(properties
		nsTop 27
		nsLeft 46
		view 749
		loop 4
		cycleSpeed 60
	)
)

(instance bookWyrmMouth of Prop
	(properties
		nsTop 42
		nsLeft 43
		view 749
		loop 2
		cycleSpeed 12
	)
)

(instance rocks of Feature
	(properties
		x 183
		y 60
		description {Rocks}
		sightAngle 90
		onMeCheck 4
		lookStr {The rocks are cold and wet to the touch.}
	)
)

(instance bookArm of Prop
	(properties
		x 203
		y 103
		z 21
		view 760
		loop 2
	)
)

(instance bookWave of Prop
	(properties
		x 181
		y 103
		z 21
		view 760
		loop 1
	)
)

(instance bookMouth of Prop
	(properties
		x 191
		y 103
		z 19
		view 760
		loop 3
	)
)

(instance dragon of Prop
	(properties
		x 102
		y 110
		view 754
		priority 6
		signal 16
	)
)

(instance dragonHead of Prop
	(properties
		x 84
		y 81
		view 755
		loop 1
		priority 8
		signal 16
		cycleSpeed 12
	)
)

(instance dragonEyeMouth of Prop
	(properties
		x 98
		y 59
		view 755
		loop 2
		priority 9
		signal 16
		cycleSpeed 18
	)
)

(instance dragonEye of Prop
	(properties
		x 99
		y 50
		view 755
		loop 3
		priority 10
		signal 16
		cycleSpeed 12
	)
)

(instance dragonClaw of Prop
	(properties
		x 73
		y 101
		view 755
		loop 4
		priority 9
		signal 16
		cycleSpeed 18
	)
)

(instance handShake of Osc
	(properties)

	(method (doit &tmp temp0)
		(if (or (> (= temp0 (self nextCel:)) 6) (< temp0 4))
			(= cycleDir (- cycleDir))
			(self cycleDone:)
		else
			(client cel: temp0)
		)
	)
)

(instance dragonBreathe of Osc
	(properties)

	(method (doit &tmp temp0)
		(if (or (> (= temp0 (self nextCel:)) 4) (< temp0 1))
			(= cycleDir (- cycleDir))
			(self cycleDone:)
		else
			(client cel: temp0)
		)
	)
)

(instance dragonBreath of Sound
	(properties
		flags 1
		number 141
	)
)

(instance dragonRoar of Sound
	(properties
		flags 1
		number 142
	)
)

(instance dragonFlames of Sound ; UNUSED
	(properties
		flags 1
		number 143
	)
)

(instance dragonGrowl of Sound
	(properties
		flags 1
		number 144
	)
)

(instance egoIntoBook of Sound
	(properties
		flags 1
		number 108
	)
)

(class armOsc of Osc
	(properties)

	(method (init)
		(super init: &rest)
		(client cycleSpeed: (Random 100 200))
		(= cycleCnt (GetTime))
	)

	(method (nextCel &tmp temp0)
		(cond
			((<= (- (= temp0 (GetTime)) cycleCnt) (client cycleSpeed:))
				(return (client cel:))
			)
			((and (== (client cel:) 1) (< cycleDir 0))
				(client cycleSpeed: (Random 100 200))
				(return 0)
			)
			((not (client cel:))
				(client cycleSpeed: 6)
				(return (= cycleDir 1))
			)
			(else
				(= cycleCnt (GetTime))
				(return (+ (client cel:) cycleDir))
			)
		)
	)
)

(instance armOsc2 of armOsc
	(properties)
)

(instance mouthOsc of armOsc
	(properties)
)

(instance sfx of Sound
	(properties
		flags 1
		number 101
	)
)

