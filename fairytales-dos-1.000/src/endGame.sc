;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 400)
(include sci.sh)
(use Main)
(use n010)
(use Tactor)
(use goGet)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	endGame 0
	wyrmScript 1
)

(local
	[local0 200]
)

(instance endGame of Rgn
	(properties)

	(method (init &tmp temp0 temp1)
		(super init: &rest)
		(switch gCurRoomNum
			(180
				(= temp0 160)
				(= temp1 100)
			)
			(220
				(= temp0 160)
				(= temp1 140)
			)
			(320
				(= temp0 170)
				(= temp1 140)
			)
			(190
				(= temp0 130)
				(= temp1 90)
			)
			(150
				(= temp0 205)
				(= temp1 139)
			)
		)
		(bookWyrm
			view: 753
			loop: 0
			cel: 0
			setCycle: Walk
			ignoreActors: 0
			posn: temp0 temp1
			init:
		)
		(gEgo doCode: egoDoEnd)
	)
)

(instance wyrmScript of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(bookWyrm
					setMotion: MoveTo (+ (bookWyrm x:) 20) (bookWyrm y:) self
				)
			)
			(1
				(bookWyrm loop: 2 cel: 0 setCycle: End self)
			)
			(2
				(bookWyrm loop: 4 cel: 0 setCycle: End self)
			)
			(3
				(proc10_13
					3
					bookWyrm
					gEgo
					self
					1
					(Format @local0 400 0 @global110) ; "Oh, %s, You've got to help me! I can't find it anywhere!"
				)
			)
			(4
				(bookWyrm loop: 6 cel: 0 setCycle: End self)
			)
			(5
				(bookWyrm
					loop: 1
					cel: 0
					setCycle: Walk
					setMotion: MoveTo (- (bookWyrm x:) 20) (bookWyrm y:) self
				)
			)
			(6
				(bookWyrm loop: 3 cel: 0 setCycle: End self)
			)
			(7
				(bookWyrm loop: 5 cel: 0 setCycle: End self)
			)
			(8
				(bookWyrm loop: 3 cel: 2 setCycle: Beg self)
			)
			(9
				(if (> (gEgo x:) (bookWyrm x:))
					(bookWyrm loop: 7 cel: 0 setCycle: End self)
				else
					(= cycles 1)
				)
			)
			(10
				(self dispose:)
			)
		)
	)
)

(instance egoDoEnd of Code
	(properties)

	(method (doit param1)
		(switch param1
			(5
				(switch (gEgo selection:)
					(0
						(proc10_13 2 gEgo bookWyrm -1 1 400 1)
						(proc10_13 3 bookWyrm gEgo -1 0 400 2)
						(proc10_13 0 bookWyrm gEgo -1 0 400 3)
						(proc10_13 3 bookWyrm gEgo -1 1 400 4)
					)
					(1
						(proc10_13 2 gEgo bookWyrm -1 1 400 5)
						(proc10_13 0 bookWyrm gEgo -1 0 400 6)
						(proc10_13 0 bookWyrm gEgo -1 0 400 7)
						(proc10_13 3 bookWyrm gEgo -1 1 400 8)
					)
					(2
						(proc10_13 0 gEgo bookWyrm -1 1 400 9)
						(proc10_13 0 bookWyrm gEgo -1 0 400 10)
						(proc10_13 0 bookWyrm gEgo -1 0 400 11)
						(proc10_13 0 bookWyrm gEgo -1 1 400 12)
					)
					(else
						(proc10_13 0 gEgo bookWyrm -1 1 400 13)
						(proc10_13 3 bookWyrm gEgo -1 0 400 14)
						(proc10_13 3 bookWyrm gEgo -1 1 400 15)
						(proc10_13 0 gEgo bookWyrm -1 1 400 16)
						(proc10_13
							0
							bookWyrm
							gEgo
							-1
							1
							(Format @local0 400 17 @global110) ; "Thank you, %s."
						)
					)
				)
				(gEgo incSel:)
			)
		)
	)
)

(instance bookWyrm of Tactor
	(properties
		description {Bookwyrm}
		lookStr {You see Bookwyrm.}
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
				(switch (bookWyrm selection:)
					(0
						(proc10_13 3 self self -1 1 400 18)
					)
					(1
						(proc10_13 0 self self -1 0 400 19)
						(proc10_13 0 bookWyrm gEgo -1 0 400 20)
						(proc10_13 3 bookWyrm gEgo -1 1 400 21)
					)
					(2
						(proc10_13 3 self self -1 0 400 22)
						(proc10_13 3 bookWyrm gEgo -1 1 400 23)
					)
					(else
						(proc10_13 3 self self -1 0 400 14)
						(proc10_13 3 bookWyrm gEgo -1 1 400 15)
					)
				)
				(self incSel:)
			)
			(else
				(super doVerb: theVerb invItem &rest)
			)
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
		cycleSpeed 42
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

