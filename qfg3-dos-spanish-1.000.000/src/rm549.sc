;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 549)
(include sci.sh)
(use Main)
(use Game)
(use Actor)
(use System)

(public
	rm549 0
)

(instance rm549 of Rm
	(properties
		picture 550
	)

	(method (init)
		(super init: &rest)
		(self setScript: sStart)
	)
)

(instance sStart of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= ticks 60)
			)
			(1
				(combatants1 init:)
				(gLongSong2 number: 846 setLoop: 1 play:)
				(= ticks 60)
			)
			(2
				(combatants2 init:)
				(gLongSong2 number: 846 setLoop: 1 play:)
				(= ticks 60)
			)
			(3
				(combatants3 init:)
				(gLongSong2 number: 846 setLoop: 1 play:)
				(= ticks 60)
			)
			(4
				(combatants4 init:)
				(gLongSong2 number: 846 setLoop: 1 play:)
				(= ticks 60)
			)
			(5
				(theMonster view: (if (gEgo has: 1) 844 else 843) init:) ; theSword
				(gLongSong2 number: 846 setLoop: 1 play:)
				(theWarrior
					view:
						(if (gEgo has: 1) ; theSword
							(if ((gInventory at: 1) state:) 25 else 23) ; theSword
						else
							24
						)
					init:
				)
				(= ticks 60)
			)
			(6
				(combatants1 dispose:)
				(= ticks 60)
			)
			(7
				(combatants2 dispose:)
				(= ticks 60)
			)
			(8
				(combatants3 dispose:)
				(= ticks 60)
			)
			(9
				(combatants4 dispose:)
				(= ticks 60)
			)
			(10
				(theMonster dispose:)
				(theWarrior dispose:)
				(= ticks 60)
			)
			(11
				(= global365 860)
				(gCurRoom newRoom: 550) ; combatRm
			)
		)
	)
)

(instance theMonster of View
	(properties
		x 174
		y 136
	)
)

(instance theWarrior of View
	(properties
		x 115
		y 159
	)
)

(instance combatants1 of View
	(properties
		y 10
		view 842
	)
)

(instance combatants2 of View
	(properties
		x 14
		y 117
		view 842
		cel 2
	)
)

(instance combatants3 of View
	(properties
		x 244
		y 14
		view 842
		loop 1
	)
)

(instance combatants4 of View
	(properties
		x 240
		y 128
		view 842
		loop 1
		cel 1
	)
)

