;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 4)
(include sci.sh)
(use Main)
(use Interface)
(use RFeature)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	Room4 0
)

(synonyms
	(rose blossom)
)

(instance Room4 of Rm
	(properties
		picture 4
	)

	(method (init)
		(= west 10)
		(= east 12)
		(= north 5)
		(= south 33)
		(= horizon 118)
		(super init:)
		(Load rsFONT 4)
		(Load rsSOUND 2)
		(gAddToPics add: lBench rBench eachElementDo: #init doit:)
		(self setRegions: 206 setFeatures: Column1 Column2 rBench lBench) ; houseOReg
		(if (== gAct 1)
			(self setRegions: 381) ; walkabout
		)
		(statue setPri: 12 ignoreActors: 1 init: stopUpd:)
		(if gDetailLevel
			(star1 cycleSpeed: 2 setCycle: Fwd init:)
			(star2 init: setScript: twinkle)
			(if (== (Random 1 200) 95)
				(Plane loop: 1 play:)
				(airplane
					setCycle: Fwd
					illegalBits: 0
					setLoop: 3
					ignoreHorizon: 1
					xStep: 10
					setMotion: MoveTo 380 68
					init:
				)
			)
		)
		(if (and (>= gAct 2) (< gAct 4))
			(self setRegions: 202) ; EthelDrunk
		)
		(switch gPrevRoomNum
			(12
				(gEgo posn: 318 158)
			)
			(10
				(gEgo posn: 1 158)
			)
			(5
				(gEgo posn: 158 120)
			)
		)
		(gEgo view: 0 illegalBits: -32768 init:)
	)

	(method (doit)
		(if (IsFirstTimeInRoom)
			(Print 4 0) ; "Out the back door, a garden path encircles a small statue, then continues on through a lovely rose arbor."
		)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
		(if (and (& gCorpseFlags $0008) (!= newRoomNumber 5)) ; Ethel
			(= gEthelState 101)
		)
		(if (== newRoomNumber 33)
			(gConMusic stop:)
		)
		(super newRoom: newRoomNumber)
	)

	(method (handleEvent event &tmp temp0)
		(if (event claimed:)
			(return 1)
		)
		(if (== (event type:) evSAID)
			(cond
				((Said 'look>')
					(cond
						((Said '[<around,at][/room]')
							(Print 4 0) ; "Out the back door, a garden path encircles a small statue, then continues on through a lovely rose arbor."
						)
						((Said '/garden[<rose]')
							(Print 4 1) ; "You see a lovely rose garden in the distance to the north."
						)
						((Said '/gallery')
							(Print 4 2) ; "Grecian columns enclose the small back porch. From here, you can see a lovely rose arbor."
						)
						((Said '/field')
							(Print 4 3) ; "Behind a weather-beaten fence, you see the old, unused sugar cane fields. The fields look as if they haven't been planted in years."
						)
						((Said '/path')
							(Print 4 4) ; "The garden path circles a small statue, then goes through a lovely rose arbor."
						)
						((Said '/door')
							(Print 4 5) ; "Here, you see the back door of the house."
						)
						((Said '/fence')
							(Print 4 6) ; "An old, weather-beaten fence partitions off the remaining vestiges of the plantation's once-vast sugar cane fields. Now all that's left are long-ago plowed furrows and old dead stalks."
						)
						((Said '/archway')
							(Print 4 7) ; "You don't see a gate here."
						)
						((Said '/rose,bush,foliage,arbor')
							(Print 4 8) ; "Beautiful roses grow upon the rose arbor."
						)
					)
				)
				((Said 'get/rose')
					(Print 4 9) ; "You see no need to carry around a rose."
				)
				((Said 'climb/fence')
					(Print 4 10) ; "The fence is too difficult to climb. Besides, you don't care about those old fields."
				)
				((Said 'smell/rose')
					(Print 4 11) ; "The roses smell wonderful in the night air."
				)
			)
		)
	)
)

(instance twinkle of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(star2 setCycle: End self)
			)
			(1
				(if (< (Random 1 100) 35)
					(= state -1)
				else
					(= state 0)
				)
				(= seconds (Random 7 15))
			)
		)
	)
)

(instance lBench of RPicView
	(properties
		y 133
		x 87
		view 104
		loop 1
		cel 1
		priority 9
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 4 12) ; "There are two garden benches here."
		)
	)
)

(instance rBench of RPicView
	(properties
		y 133
		x 233
		view 104
		loop 1
		priority 9
	)

	(method (handleEvent event)
		(cond
			((Said 'look<below/bench')
				(Print 4 13) ; "There is nothing but grass under the benches."
			)
			((Said 'sit/[<bench]')
				(Print 4 14) ; "You don't feel like sitting around."
			)
			((or (MousedOn self event 3) (Said 'look/bench'))
				(event claimed: 1)
				(Print 4 12) ; "There are two garden benches here."
			)
		)
	)
)

(instance statue of Prop
	(properties
		y 148
		x 160
		view 104
	)

	(method (handleEvent event)
		(cond
			((or (MousedOn self event 3) (Said 'look/monument'))
				(event claimed: 1)
				(Print 4 15) ; "This is an exquisite statue of a dancing satyr."
			)
			((Said 'get/monument')
				(Print 4 16) ; "The statue is firmly afixed to its pedestal."
			)
			((Said 'press,pull,rotate,move/monument')
				(Print 4 17) ; "The statue doesn't move."
			)
		)
	)
)

(instance star1 of Prop
	(properties
		y 11
		x 212
		view 107
		loop 1
	)
)

(instance star2 of Prop
	(properties
		y 14
		x 110
		view 107
		loop 2
	)
)

(instance airplane of Act
	(properties
		y 68
		x -120
		view 104
		loop 3
	)
)

(instance Column1 of RFeature
	(properties
		nsTop 23
		nsLeft 43
		nsBottom 182
		nsRight 75
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/column'))
			(event claimed: 1)
			(Print 4 18) ; "Grecian columns support the back porch."
		)
	)
)

(instance Column2 of RFeature
	(properties
		nsTop 21
		nsLeft 247
		nsBottom 181
		nsRight 280
	)

	(method (handleEvent event)
		(if (or (MousedOn self event 3) (Said 'look/column'))
			(event claimed: 1)
			(Print 4 18) ; "Grecian columns support the back porch."
		)
	)
)

(instance Plane of Sound
	(properties
		number 2
	)
)

