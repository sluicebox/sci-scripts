;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 872)
(include sci.sh)
(use Main)
(use n001)
(use n002)
(use HandsOffScript)
(use Interface)
(use Feature)
(use LoadMany)
(use Motion)
(use Game)
(use Actor)

(public
	rm872 0
)

(instance saury1 of Actor
	(properties
		x -10
		y 125
		noun '/centaur,leader'
		description {the Centaur}
		lookStr {Of course the Centaur survived the battle.}
		view 861
		loop 10
		signal 18432
		illegalBits 0
		xStep 1
	)
)

(instance saury2 of Actor
	(properties
		x -20
		y 125
		noun '/saurii'
		description {the caravaner}
		lookStr {At least part of the caravan survived the battle.}
		view 861
		loop 11
		signal 18432
		illegalBits 0
		xStep 1
	)
)

(instance saury3 of Actor
	(properties
		x -30
		y 125
		noun '/beast'
		description {the caravaner on this side}
		lookStr {At least part of the caravan survived the battle.}
		view 861
		loop 11
		signal 18432
		illegalBits 0
		xStep 1
	)
)

(instance nearDude of Actor
	(properties
		x -25
		y 127
		noun '/man'
		description {the caravaner on that side}
		lookStr {This guy survived the battle.}
		view 861
		loop 8
		signal 18432
		illegalBits 0
		xStep 1
	)
)

(instance farDude of Actor
	(properties
		x -5
		y 123
		noun '/man'
		description {the survivor}
		lookStr {This guy survived the battle.}
		view 861
		loop 8
		signal 18432
		illegalBits 0
		xStep 1
	)
)

(instance rm872 of Rm
	(properties
		picture 664
		style 6
	)

	(method (init)
		(LoadMany rsPIC 2 780)
		(LoadMany rsVIEW 13 861 12 780)
		(Load rsPIC 2 780)
		(Load rsSOUND 790)
		(super init:)
		(gCSound number: 790 loop: -1 priority: 0 playBed:)
		(self setScript: truckin)
	)
)

(instance truckin of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= gDay 27)
				(FixTime 9 0)
				(InitFeatures sky hills sand)
				(gEgo
					view: 13
					setLoop: 0
					posn: -12 127
					init:
					xStep: 1
					yStep: 1
					cycleSpeed: 0
					setMotion: MoveTo 300 127
				)
				(saury1 init: setCycle: Walk setMotion: MoveTo 300 125)
				(if (> gHowFast 0)
					(saury2 init: setCycle: Walk setMotion: MoveTo 300 125)
					(farDude init: setCycle: Walk setMotion: MoveTo 300 123)
					(if (> gHowFast 1)
						(saury3 init: setCycle: Walk setMotion: MoveTo 300 125)
						(nearDude
							init:
							setCycle: Walk
							setMotion: MoveTo 300 127
						)
					)
				)
				(= seconds 1)
			)
			(1
				(= seconds 8)
			)
			(2
				(gEgo hide:)
				(saury1 dispose:)
				(if (> gHowFast 0)
					(saury2 dispose:)
					(farDude dispose:)
					(if (> gHowFast 1)
						(saury3 dispose:)
						(nearDude dispose:)
					)
				)
				(sky dispose:)
				(hills dispose:)
				(sand dispose:)
				(gCurRoom drawPic: 2)
				(= seconds 2)
			)
			(3
				(Print 872 0) ; "After a week of travelling, you leave the Caravan when it comes within sight of the city of Raseir."
				(= seconds 1)
			)
			(4
				(Print 872 1) ; "The Caravan Master warns you that Raseir is a dangerous place to be and bids you be wary of all you meet there."
				(= seconds 1)
			)
			(5
				(Print 872 2) ; "He rears up and salutes you, and you watch the Caravan move onward into the desert."
				(= seconds 1)
			)
			(6
				(Print 872 3) ; "You ride alone to the entrance to Raseir, and pass through the barred gates which barely open for you."
				(= seconds 1)
			)
			(7
				(gCurRoom drawPic: 780)
				(FixTime 14 0)
				(InitAddToPics raseir)
				(InitFeatures sky2 sand2 hill2 hill3)
				(gEgo
					view: 12
					setLoop: 3
					setPri: 10
					posn: 148 250
					yStep: 3
					show:
					setMotion: MoveTo 148 138 self
				)
			)
			(8
				(gEgo setPri: 2 setMotion: MoveTo 148 196 self)
			)
			(9
				(gEgo
					view: 13
					loop: 3
					yStep: 1
					posn: 148 166
					setMotion: MoveTo 148 104 self
				)
			)
			(10
				(gEgo setPri: 1 setMotion: MoveTo 148 120 self)
			)
			(11
				(= gDay 27)
				(gCSound fade:)
				(gCurRoom newRoom: 380)
				(self dispose:)
			)
		)
	)
)

(instance raseir of PicView
	(properties
		x 135
		y 90
		description {the city}
		lookStr {Ah, Raseir.}
		view 780
		loop 2
		cel 1
		priority 0
		signal 16400
	)
)

(instance sky of Feature
	(properties
		x 159
		y 24
		noun '/sky'
		nsBottom 49
		nsRight 319
		description {the sky}
		lookStr {It's a clear blue sky out here.}
	)
)

(instance hills of Feature
	(properties
		x 159
		y 74
		noun '/hill'
		nsTop 49
		nsBottom 99
		nsRight 318
		description {hill}
		lookStr {The hills around here are stark and dry, just like Coarsegold.}
	)
)

(instance sand of Feature
	(properties
		x 159
		y 144
		noun '/sand'
		nsTop 99
		nsBottom 189
		nsRight 318
		description {the sand}
		lookStr {Nothing but sand, sand, and more sand.}
	)
)

(instance sky2 of Feature
	(properties
		x 159
		y 23
		noun '/sky'
		nsBottom 46
		nsRight 318
		description {the sky}
		lookStr {Different picture, same sky.}
	)
)

(instance sand2 of Feature
	(properties
		x 166
		y 141
		noun '/sand'
		nsTop 94
		nsLeft 53
		nsBottom 189
		nsRight 275
		description {sand}
		lookStr {Sand, sand and more sand.}
	)
)

(instance hill2 of Feature
	(properties
		x 25
		y 90
		noun '/hill'
		nsTop 46
		nsBottom 135
		nsRight 51
		description {the hill}
		lookStr {The hills are stark barren rock.}
	)
)

(instance hill3 of Feature
	(properties
		x 296
		y 95
		noun '/hill'
		nsTop 45
		nsLeft 275
		nsBottom 146
		nsRight 318
		description {the hill}
		lookStr {The hills are stark barren rock.}
	)
)

