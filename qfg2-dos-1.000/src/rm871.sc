;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 871)
(include sci.sh)
(use Main)
(use n002)
(use HandsOffScript)
(use Interface)
(use Feature)
(use Save)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm871 0
)

(instance rm871 of Rm
	(properties
		picture 871
		style 6
	)

	(method (init)
		(Load rsVIEW 871)
		(= gDay 23)
		(FixTime 9 0)
		(pile1 init:)
		(pile2 init:)
		(johnny init:)
		(super init:)
		(gCSound number: 795 loop: 0 priority: 0 playBed:)
		(v1 init: setMotion: MoveTo 330 76)
		(self setScript: survey)
		(v1 setScript: birdie)
	)
)

(instance johnny of Prop
	(properties
		x 104
		y 61
		description {the King of the mountain}
		lookStr {King of the mountain!\nking of the mountain!\nking of the mountain!}
		view 871
		loop 1
	)
)

(instance v1 of Actor
	(properties
		x -10
		y 8
		noun '/bird,buzzard'
		description {a vulture}
		lookStr {Look down there, gang.__They must've just opened a new carrion out place.}
		view 871
		loop 4
		signal 18432
		illegalBits 0
	)
)

(instance v2 of Actor
	(properties
		x -10
		y 22
		noun '/bird,buzzard'
		description {a vulture}
		lookStr {Pass the ketchup.}
		view 871
		loop 6
		signal 18432
		illegalBits 0
	)
)

(instance v3 of Actor
	(properties
		x 320
		y 15
		noun '/bird,buzzard'
		description {a vulture}
		lookStr {Look, Dolores.__Bedouin on rye!}
		view 871
		loop 3
		signal 18432
		illegalBits 0
	)
)

(instance survey of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(johnny cycleSpeed: 2 setCycle: End self)
			)
			(2
				(= seconds 2)
			)
			(3
				(johnny loop: 0 cel: 0 cycleSpeed: 2 setCycle: End self)
			)
			(4
				(johnny cycleSpeed: 2 setCycle: Beg self)
			)
			(5
				(johnny cycleSpeed: 2 setCycle: End self)
			)
			(6
				(johnny loop: 2 cel: 0)
				(if (> gHowFast 0)
					(= seconds 2)
				else
					(= cycles 1)
				)
			)
			(7
				(Print 871 0 #width 290 #dispose #at -1 150 #time 8 #window aWin) ; "I love the smell of victory in the morning.   ...... It smells like.....sweat.. no, no   ...oregano ....nooo...like Victory! Yea   Victory!...Yea! Yea! That's the ticket."
				(= seconds 8)
			)
			(8
				(johnny cycleSpeed: 3 setCycle: End self)
			)
			(9
				(= seconds 2)
			)
			(10
				(gCurRoom newRoom: 872)
				(self dispose:)
			)
		)
	)
)

(instance birdie of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 3)
			)
			(1
				(if (> gHowFast 0)
					(v2 init: setMotion: MoveTo 330 44)
					(= seconds (* gHowFast 2))
				else
					(self cue:)
				)
			)
			(2
				(v3 init: setMotion: MoveTo -10 50 self)
			)
			(3
				(self dispose:)
			)
		)
	)
)

(instance pile1 of Feature
	(properties
		x 119
		y 85
		noun 'body,collection'
		nsTop 62
		nsLeft 32
		nsBottom 109
		nsRight 206
		description {mangled mass of bodies}
		lookStr {Vulture fast food.}
	)
)

(instance pile2 of Feature
	(properties
		x 137
		y 5
		noun 'body,collection'
		nsTop 109
		nsBottom 185
		nsRight 284
		description {pile of dead bodies}
		lookStr {All in a day's work.}
	)
)

(instance aWin of SysWindow
	(properties
		color 1
		back 11
	)
)

