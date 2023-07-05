;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 360)
(include sci.sh)
(use Main)
(use n010)
(use Tactor)
(use goGet)
(use PolyPath)
(use LoadMany)
(use Sound)
(use Motion)
(use Actor)

(public
	Room360 0
)

(local
	[local0 200]
)

(instance Room360 of FRoom
	(properties
		picture 360
		style 0
	)

	(method (init)
		(self defeatEntrance: 1)
		(switch global140
			(0
				(= picture 361)
				(LoadMany rsSOUND 100 101 105 106 108 115 116 117 118)
			)
			(2
				(LoadMany rsSOUND 5 108)
			)
		)
		(super init:)
		(if (== global140 2)
			(gGlobalMusic number: 5 priority: 15 setLoop: -1 play:)
		)
		(gEgo view: global139)
		(LoadMany rsVIEW (+ 30 global139) 720)
		(if (== global140 0)
			(LoadMany rsVIEW 360 751 757)
			(book setPri: 15 init:)
		else
			(page setPri: 15 init:)
		)
	)

	(method (cue)
		(super cue:)
		(switch global140
			(0
				(self setScript: begGame)
			)
			(2
				(self setScript: endGame)
			)
		)
	)

	(method (enterSpecial)
		(if (== global140 0)
			(gEgo normal: 1 hide:)
			(NormalEgo 5 global139)
			(gEgo posn: 161 123 init:)
		)
		(self cue:)
	)
)

(instance begGame of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo setMotion: MoveTo 125 116 self)
			)
			(1
				(teacher setUp:)
				(proc10_13 0 teacher 0 self 1 360 0)
			)
			(2
				(gEgo setMotion: MoveTo 179 116 self)
			)
			(3
				(gEgo heading: 0)
				(president x: 149 y: 64 init: setCycle: CT 4 1 self)
			)
			(4
				(sfx number: 115 play:)
				(president setCel: 5 setCycle: CT 10 1 self)
			)
			(5
				(sfx number: 116 play:)
				(president setCel: 11 setCycle: End self)
			)
			(6
				(president stopUpd:)
				(book setCycle: CT 3 1 self)
			)
			(7
				(sfx number: 100 play:)
				(book setCycle: CT 6 1 self)
			)
			(8
				(sfx number: 101 play:)
				(book setCycle: End self)
			)
			(9
				(gEgo heading: 90 setMotion: MoveTo 201 116 self)
			)
			(10
				(Face gEgo book)
				(gEgo
					normal: 0
					view: (+ 40 global139)
					loop: 0
					cel: 0
					cycleSpeed: 6
					setCycle: End
				)
				(sfx number: 118 play:)
				(bookWyrm
					posn: (+ (book x:) 37) (+ (book y:) 18)
					setLoop: 0
					setCel: 0
					init:
					setCycle: CT 7 1 self
				)
			)
			(11
				(sfx number: 106 play:)
				(bookWyrm setCycle: End self)
			)
			(12
				(gEgo setCycle: Beg self)
			)
			(13
				(proc10_13 2 bookWyrm bookWyrm -1 1 360 1)
				(proc10_13 2 gEgo bookWyrm -1 1 360 2)
				(proc10_13 0 bookWyrm bookWyrm -1 1 360 3)
				(proc10_13
					0
					gEgo
					bookWyrm
					-1
					1
					(Format @local0 360 4 @global110) ; "I am %s."
				)
				(proc10_13
					0
					bookWyrm
					bookWyrm
					-1
					0
					(Format @local0 360 5 @global110) ; "I am glad to meet you, %s."
				)
				(proc10_13 3 bookWyrm bookWyrm -1 0 360 6)
				(proc10_13 3 bookWyrm bookWyrm -1 1 360 7)
				(proc10_13 3 gEgo bookWyrm -1 1 360 8)
				(proc10_13 0 bookWyrm bookWyrm self 1 360 9)
			)
			(14
				(proc10_15)
				(sfx number: 105 play:)
				(bookWyrm setLoop: 0 ignoreActors: 1 setCycle: CT 7 -1 self)
			)
			(15
				(sfx number: 117 play:)
				(bookWyrm setCycle: Beg self)
			)
			(16
				(NormalEgo 5 global139)
				(gEgo
					normal: 1
					setMotion: PolyPath (+ (book x:) 37) (+ (book y:) 18) self
				)
			)
			(17
				(sfx number: 108 play:)
				(gEgo normal: 0 view: (+ 30 global139) setCycle: End self)
			)
			(18
				(bookWyrm dispose:)
				(= cycles 1)
			)
			(19
				(if (gGlobalMusic handle:)
					(gGlobalMusic fade: 0 15 12 1)
				)
				(gCurRoom newRoom: 235)
			)
		)
	)
)

(instance endGame of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo init: normal: 0 hide:)
				((gEgo head:) hide:)
				(book posn: 160 82 cel: 9 init:)
				(egoLeap
					ignoreActors: 1
					view: (+ 30 global139)
					cel: 15
					posn: 197 100
					init:
					setCycle: Beg self
				)
			)
			(1
				(page setCycle: End self)
			)
			(2
				(page stopUpd:)
				(teacher setUp:)
				(proc10_13 2 teacher 0 self 1 (Format @local0 360 10 @global110)) ; "Did you pick out a book, %s?"
			)
			(3
				(egoLeap dispose:)
				(gEgo show: posn: 197 98 setMotion: MoveTo 173 98 self)
			)
			(4
				(gEgo
					normal: 0
					view: (+ 60 global139)
					loop: 0
					cel: 0
					setCycle: CT 3 1 self
				)
			)
			(5
				(book dispose:)
				(gEgo setCycle: End self)
			)
			(6
				(proc10_13 2 gEgo 0 self 1 360 11)
			)
			(7
				(= ticks 120)
			)
			(8
				(everAfter setPri: 15 init:)
				(= ticks 180)
			)
			(9
				(theEnd setPri: 15 init:)
				(= ticks 300)
			)
			(10
				(gCurRoom newRoom: 500)
			)
		)
	)
)

(instance bookWyrm of Tactor
	(properties
		view 757
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

(instance teacher of Tactor
	(properties
		talkerID 20
	)

	(method (setUp)
		((= talkerObj teacherTalkObj)
			setUp: teacherBust teacherEyes teacherMouth
		)
	)
)

(instance teacherTalkObj of TalkerObj
	(properties
		x -1
		y 97
		nsTop 10
		nsLeft 108
		view 720
	)
)

(instance teacherBust of View
	(properties
		nsTop 21
		nsLeft 41
		view 720
		loop 6
	)
)

(instance teacherEyes of Prop
	(properties
		nsTop 27
		nsLeft 44
		view 720
		loop 4
		cycleSpeed 36
	)
)

(instance teacherMouth of Prop
	(properties
		nsTop 32
		nsLeft 40
		view 720
		loop 2
		cycleSpeed 12
	)
)

(instance book of Prop
	(properties
		x 109
		y 100
		view 360
		loop 2
	)
)

(instance page of Prop
	(properties
		x 297
		y 143
		view 360
		loop 1
	)
)

(instance president of Prop
	(properties
		x 200
		y 46
		view 360
	)
)

(instance egoLeap of Prop
	(properties
		view 30
	)
)

(instance everAfter of View
	(properties
		x 45
		y 8
		view 835
	)
)

(instance theEnd of View
	(properties
		x 84
		y 120
		view 835
		loop 1
	)
)

(instance sfx of Sound
	(properties
		flags 1
		number 115
	)
)

