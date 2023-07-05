;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 235)
(include sci.sh)
(use Main)
(use n010)
(use Tactor)
(use goGet)
(use Interface)
(use PolyPath)
(use Polygon)
(use Feature)
(use Sound)
(use Motion)
(use Actor)
(use System)

(public
	Room235 0
)

(local
	[local0 200]
)

(procedure (localproc_0)
	(chair init:)
	(window1 init:)
	(bookstand init:)
	(floor init:)
	(rug init:)
	(table init:)
	(jar init:)
	(lantern init:)
	(wand init:)
	(beanstalk init:)
	(shelf init:)
	(bookSh init:)
	(painting init:)
	(gramophone init:)
	(house init:)
)

(instance Room235 of FRoom
	(properties
		lookStr {The area outside Bookwyrm's house is very lovely.}
		picture 235
		style 0
		south 230
		defeatEntrance 1
	)

	(method (init)
		(if (OneOf gPrevRoomNum 230 360)
			(Load rsSOUND 38)
		)
		(if (gGame script:)
			(gGame setScript: 0)
			(gGlobalMusic2 stop:)
		)
		(super init:)
		(if (or (> global225 0) (== global140 0))
			(gGlobalMusic number: 38 priority: 15 setLoop: -1 play:)
			(= global225 0)
		)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PContainedAccess
					init: 262 130 210 122 189 124 183 116 150 113 74 137 55 133 55 154 267 154
					yourself:
				)
		)
		(gTheIconBar enable: show:)
		(localproc_0)
		(NormalEgo 5 global139)
		(switch global140
			(0
				(gEgo normal: 1 doCode: egoDo120 posn: 137 130 init:)
				(book ignoreActors: 1 stopUpd: init:)
				(bookWyrm ignoreActors: 1 init:)
				(wyrmHead ignoreActors: 1 init:)
				(fArm ignoreActors: 1 init:)
				(nArm ignoreActors: 1 init:)
				(SetFlag 9)
				(if (!= gPrevRoomNum 480) ; Phono
					(self setScript: begGame)
				)
			)
			(1
				(book ignoreActors: 1 stopUpd: init:)
				(if (!= gPrevRoomNum 480) ; Phono
					(gCurRoom setScript: enterRoom)
				else
					(gEgo posn: 137 130 init:)
				)
			)
			(2
				(if (!= gPrevRoomNum 480) ; Phono
					(gCurRoom setScript: enterRoom)
				else
					(gEgo posn: 137 130 init:)
				)
			)
		)
		(fireSound play:)
		(fire setCycle: Fwd init:)
	)

	(method (cue)
		(super cue:)
		(return 0)
	)

	(method (doit &tmp temp0)
		(super doit:)
		(cond
			(script 0)
			((== global140 0)
				(= temp0
					(GetAngle
						(bookWyrm x:)
						(bookWyrm y:)
						(gEgo x:)
						(gEgo y:)
					)
				)
				(cond
					((< 0 temp0 190)
						(wyrmHead cel: 2)
					)
					((< 190 temp0 225)
						(wyrmHead cel: 1)
					)
					((< 225 temp0 350)
						(wyrmHead cel: 0)
					)
				)
			)
		)
		(if (and (> (gEgo y:) 145) (not (gCurRoom script:)))
			(gCurRoom setScript: exitRoom)
		)
	)
)

(instance fireSound of Sound
	(properties
		flags 1
		number 109
		loop -1
	)
)

(instance enterRoom of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo init: posn: 137 160 setMotion: MoveTo 137 130 self)
			)
			(1
				(self dispose:)
			)
		)
	)
)

(instance exitRoom of HandsOffScript
	(properties)

	(method (dispose)
		(if (gGame script:)
			(gGlobalMusic2 mute: 0)
		)
		(super dispose:)
		(DisposeScript 232)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo
					setMotion: MoveTo (gEgo x:) (+ (gEgo y:) 30) self
				)
			)
			(1
				(gCurRoom newRoom: 230)
			)
		)
	)
)

(instance begGame of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(wyrmHead cel: 0)
				(fArm setCycle: End self)
			)
			(1
				(proc10_13 0 bookWyrm gEgo self 1 235 0)
			)
			(2
				(wyrmHead cel: 1)
				(nArm setCycle: End self)
			)
			(3
				(proc10_13 0 bookWyrm gEgo -1 0 235 1)
				(proc10_13 0 bookWyrm gEgo self 1 235 2)
			)
			(4
				(wyrmHead cel: 2)
				(nArm setCycle: End self)
			)
			(5
				(proc10_13 0 bookWyrm gEgo -1 0 235 3)
				(proc10_13 0 bookWyrm gEgo -1 0 235 4)
				(proc10_13 0 bookWyrm gEgo self 1 235 5)
			)
			(6
				(wyrmHead cel: 1)
				(fArm setCycle: End self)
			)
			(7
				(proc10_13 0 bookWyrm gEgo -1 0 235 6)
				(proc10_13 0 bookWyrm gEgo -1 0 235 7)
				(proc10_13 0 bookWyrm gEgo -1 0 235 8)
				(proc10_13 0 bookWyrm gEgo self 1 235 9)
			)
			(8
				(wyrmHead cel: 0)
				(nArm setCycle: End self)
			)
			(9
				(proc10_13 0 bookWyrm gEgo -1 0 235 10)
				(proc10_13 0 bookWyrm gEgo -1 0 235 11)
				(proc10_13 0 bookWyrm gEgo self 1 235 12)
			)
			(10
				(wyrmHead cel: 1)
				(fArm setCycle: End self)
			)
			(11
				(proc10_13 0 bookWyrm gEgo -1 0 235 13)
				(proc10_13 0 bookWyrm gEgo self 1 235 14)
			)
			(12
				(= cycles 1)
			)
			(13
				(= cycles 1)
				(gGame save: 1)
			)
			(14
				(fArm setCycle: Beg self)
				(nArm setCycle: Beg)
			)
			(15
				(fArm stopUpd:)
				(nArm stopUpd:)
				(self dispose:)
			)
		)
	)
)

(instance getCookie of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (and (IsFlag 9) (== global140 0))
					(proc10_13 0 bookWyrm gEgo -1 0 235 15)
					(proc10_13 0 bookWyrm gEgo -1 0 235 16)
					(proc10_13 0 bookWyrm gEgo -1 1 235 17)
					(proc10_13 0 gEgo bookWyrm -1 1 235 18)
					(proc10_13
						0
						bookWyrm
						gEgo
						-1
						1
						(Format @local0 235 19 @global110) ; "You are very welcome, %s."
					)
				)
				(= ticks 1)
			)
			(1
				(gEgo setMotion: PolyPath 178 119 self)
			)
			(2
				(if (IsFlag 9)
					(Print 235 20) ; "The cookie tastes great."
					(ClearFlag 9)
				else
					(Print 235 21) ; "You help yourself to another cookie. It tastes very good."
				)
				(= ticks 1)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance egoDo120 of Code
	(properties)

	(method (doit param1)
		(switch param1
			(5
				(switch (gEgo selection:)
					(0
						(proc10_13 2 gEgo bookWyrm -1 1 235 22)
						(proc10_13 2 bookWyrm gEgo -1 0 235 23)
						(proc10_13 3 bookWyrm gEgo -1 0 235 24)
						(proc10_13 2 bookWyrm gEgo -1 0 235 25)
						(proc10_13 1 bookWyrm gEgo -1 1 235 26)
					)
					(1
						(proc10_13 2 gEgo bookWyrm -1 1 235 27)
						(proc10_13 0 bookWyrm gEgo -1 0 235 28)
						(proc10_13 0 bookWyrm gEgo -1 0 235 29)
						(proc10_13 0 bookWyrm gEgo -1 1 235 30)
					)
					(2
						(proc10_13 3 gEgo bookWyrm -1 1 235 31)
						(proc10_13 0 bookWyrm gEgo -1 0 235 32)
						(proc10_13 0 bookWyrm gEgo -1 0 235 33)
						(proc10_13 0 bookWyrm gEgo -1 1 235 34)
					)
					(else
						(proc10_13 0 gEgo bookWyrm -1 1 235 35)
						(proc10_13 0 bookWyrm gEgo -1 1 235 36)
					)
				)
			)
		)
		(gEgo incSel:)
	)
)

(instance bookWyrm of Tactor
	(properties
		x 224
		y 74
		description {Bookwyrm}
		lookStr {Bookwyrm is happy that you are here.}
		view 750
		talkerID 18
	)

	(method (setUp)
		((= talkerObj bookWyrmTalkObj)
			setUp: bookWyrmBust bookWyrmEyes bookWyrmMouth
		)
	)

	(method (doVerb theVerb invItem)
		(switch theVerb
			(5 ; Do
				(switch (self selection:)
					(0
						(proc10_13 0 self gEgo -1 0 235 37)
						(proc10_13 3 self gEgo -1 1 235 38)
					)
					(1
						(proc10_13 0 self gEgo -1 0 235 39)
						(proc10_13 3 self gEgo -1 0 235 40)
						(proc10_13 3 self gEgo -1 0 235 41)
						(proc10_13 0 self gEgo -1 1 235 42)
					)
					(2
						(proc10_13 0 self gEgo -1 0 235 43)
						(proc10_13 0 self gEgo -1 1 235 44)
					)
					(else
						(proc10_13 0 self gEgo -1 0 235 45)
						(proc10_13 0 self gEgo -1 1 235 46)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
		)
		(self incSel:)
	)
)

(instance bookWyrmTalkObj of TalkerObj
	(properties
		x -1
		y 97
		nsTop 10
		nsLeft 103
		view 751
	)
)

(instance bookWyrmBust of View
	(properties
		nsTop 15
		nsLeft 46
		view 751
		loop 6
	)
)

(instance bookWyrmEyes of Prop
	(properties
		nsTop 19
		nsLeft 49
		view 751
		loop 4
		cycleSpeed 36
	)
)

(instance bookWyrmMouth of Prop
	(properties
		nsTop 36
		nsLeft 46
		view 751
		loop 2
		cycleSpeed 12
	)
)

(instance wyrmHead of Prop
	(properties
		x 224
		y 74
		view 750
		loop 3
		cel 1
		signal 16384
	)

	(method (doVerb theVerb)
		(bookWyrm doVerb: theVerb)
	)
)

(instance fArm of Prop
	(properties
		x 216
		y 74
		view 750
		loop 1
		cel 3
	)

	(method (doVerb theVerb)
		(bookWyrm doVerb: theVerb)
	)
)

(instance nArm of Prop
	(properties
		x 232
		y 76
		view 750
		loop 2
		cel 3
	)

	(method (doVerb theVerb)
		(bookWyrm doVerb: theVerb)
	)
)

(instance fire of Prop
	(properties
		x 88
		y 109
		description {Fireplace}
		lookStr {A fire burns in the fireplace.}
		view 235
		loop 5
	)
)

(instance book of Prop
	(properties
		x 253
		y 103
		description {Book}
		lookStr {This is Bookwyrm's magic book.}
		view 235
		loop 1
	)
)

(instance chair of Feature
	(properties
		x 227
		y 76
		description {Chair}
		onMeCheck 2
		lookStr {This chair is very big.}
	)
)

(instance window1 of Feature
	(properties
		x 227
		y 71
		description {Window}
		onMeCheck 4
		lookStr {You can see a tree through the window.}
	)
)

(instance bookstand of Feature
	(properties
		x 253
		y 123
		description {Bookstand}
		onMeCheck 8
		lookStr {This is a bookstand.}
	)
)

(instance gramophone of Feature
	(properties
		x 256
		y 110
		description {Gramophone}
		onMeCheck 16
		lookStr {This is an old-fashioned record player.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (not (gCurRoom script:))
					(gCurRoom newRoom: 480) ; Phono
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance bookSh of Feature
	(properties
		x 164
		y 63
		description {Book}
		onMeCheck 32
		lookStr {Many books are on these shelves.}
	)
)

(instance shelf of Feature
	(properties
		x 169
		y 75
		description {Shelf}
		onMeCheck 64
		lookStr {The shelf is made of wood.}
	)
)

(instance rug of Feature
	(properties
		x 167
		y 140
		description {Rug}
		onMeCheck 128
		lookStr {On the rug is a picture. It is a picture of a rose.}
	)
)

(instance jar of Feature
	(properties
		x 181
		y 106
		description {Jar}
		onMeCheck 256
		lookStr {This jar is filled with cookies.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (not (gCurRoom script:))
					(gCurRoom setScript: getCookie)
				)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance table of Feature
	(properties
		x 169
		y 117
		description {Table}
		onMeCheck 512
		lookStr {A cookie jar and a gramophone are on the table.}
	)
)

(instance lantern of Feature
	(properties
		x 55
		y 134
		description {Lantern}
		onMeCheck -32768
		lookStr {This lantern is used by dwarves in the mines.}
	)
)

(instance wand of Feature
	(properties
		x 112
		y 110
		description {Wand}
		onMeCheck 2048
		lookStr {This is a fairy godmother's wand.}
	)
)

(instance beanstalk of Feature
	(properties
		x 131
		y 71
		description {Beanstalk}
		onMeCheck 4096
		lookStr {This beanstalk is quite large.}
	)
)

(instance painting of Feature
	(properties
		x 84
		y 65
		description {Picture}
		onMeCheck 8192
		lookStr {This is a picture of the Bremen Town Musicians.}
	)
)

(instance floor of Feature
	(properties
		x 87
		y 145
		description {Floor}
		onMeCheck 1024
		lookStr {The floor is made of wood.}
	)
)

(instance house of Feature
	(properties
		x 158
		y 60
		nsTop 20
		nsLeft 51
		nsBottom 150
		nsRight 268
		description {House}
		lookStr {This is Bookwyrm's house.}
	)
)

