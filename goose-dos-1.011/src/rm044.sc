;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 44)
(include sci.sh)
(use Main)
(use Motion)
(use Game)
(use Actor)

(public
	rm044 0
)

(instance rm044 of Rm
	(properties
		picture 44
		style 0
		horizon 134
		south 21
	)

	(method (init)
		(HandsOn)
		(Load rsVIEW 128)
		(Load rsVIEW 36)
		(Load rsVIEW 244)
		(Load rsVIEW 54)
		(super init:)
		(= global207 1)
		(gEgo loop: 3 x: 269 y: 188 init:)
		(proc0_10 89 153 245 250)
		(if global131
			(stoveWindow setCycle: Fwd cycleSpeed: 3 init:)
			(stovePot setCycle: Fwd cycleSpeed: 3 init:)
			(fruitBowl setPri: 10 init:)
			(flowers setPri: 8 init:)
			(table init:)
		else
			(stoveWindow setCycle: Fwd cycleSpeed: 3 init: addToPic:)
			(stovePot setCycle: Fwd cycleSpeed: 3 init: addToPic:)
			(fruitBowl setPri: 10 init: addToPic:)
			(flowers setPri: 8 init: addToPic:)
			(table init: addToPic:)
		)
		(if [global675 21]
			(mother init: addToPic:)
			(bowl init: addToPic:)
		)
		(gEgo x: (- (gEgo x:) 20))
	)
)

(instance mother of View
	(properties)

	(method (init)
		(super init:)
		(self view: 128 posn: 100 137 setLoop: 2 stopUpd:)
	)
)

(instance table of View
	(properties)

	(method (init)
		(super init:)
		(self view: 36 posn: 90 170 setPri: 10 ignoreActors: 1 stopUpd:)
	)
)

(instance stoveWindow of Prop
	(properties
		y 123
		x 183
		view 128
		loop 5
	)
)

(instance stovePot of Prop
	(properties
		y 111
		x 184
		view 128
		loop 6
	)
)

(instance flowers of View
	(properties
		y 117
		x 139
		view 244
		cel 1
	)
)

(instance fruitBowl of View
	(properties
		y 143
		x 238
		view 244
	)
)

(instance bowl of View
	(properties
		y 141
		x 208
		view 54
	)
)

