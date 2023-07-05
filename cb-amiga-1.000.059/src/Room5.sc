;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5)
(include sci.sh)
(use Main)
(use Interface)
(use RFeature)
(use Game)

(public
	Room5 0
)

(synonyms
	(rose blossom)
	(room garden)
)

(instance Room5 of Rm
	(properties
		picture 5
	)

	(method (init)
		(= south 4)
		(super init:)
		(gAddToPics
			add:
				planter1
				planter2
				treerose1
				treerose2
				treerose3
				treerose4
				bench1
				bench2
			eachElementDo: #init
			doit:
		)
		(self
			setFeatures:
				planter1
				planter2
				treerose1
				treerose2
				treerose3
				treerose4
				bench1
				bench2
		)
		(if (and (>= gAct 4) (!= gEthelState 101) (not (& gCorpseFlags $0040))) ; Lillian
			(cond
				((== gEthelCorpseRoomNum 5)
					(self setRegions: 268) ; Dethe
				)
				((not (== gEthelCorpseRoomNum 61))
					(switch (Random 1 2)
						(1
							(self setRegions: 268) ; Dethe
						)
						(2
							(= gEthelCorpseRoomNum 61)
						)
					)
				)
			)
		)
		(if (and (>= gAct 2) (< gAct 4))
			(self setRegions: 202) ; EthelDrunk
		)
		(gEgo view: 0 init:)
	)

	(method (doit)
		(if (IsFirstTimeInRoom)
			(Print 5 0) ; "This is a wonderful little garden. You wonder who planted it; certainly not the Colonel!"
		)
		(super doit:)
	)

	(method (dispose)
		(super dispose:)
	)

	(method (newRoom newRoomNumber)
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
							(Print 5 0) ; "This is a wonderful little garden. You wonder who planted it; certainly not the Colonel!"
						)
						((Said '/arbor[<rose]')
							(Print 5 1) ; "A garden path leads south through a beautiful tunnel of roses."
						)
						((Said '/path,(boulder<stepping)')
							(Print 5 2) ; "From here, the garden path goes south through a lovely rose arbor."
						)
						((Said '/rose,bush,oak,foliage')
							(Print 5 3) ; "Roses surround the little, heart-shaped garden."
						)
						((Said '/fence')
							(Print 5 4) ; "An old, weather-beaten fence partitions off the remaining vestiges of the plantation's once-vast sugar cane fields. Now all that's left are long-ago plowed furrows and old dead stalks."
						)
						((Said '/field')
							(Print 5 5) ; "Behind a weather-beaten fence, you see the old, unused sugar cane fields. The fields look as if they haven't been planted in years."
						)
					)
				)
				((Said 'get/rose,rose,foliage')
					(Print 5 6) ; "You see no need to carry around a rose."
				)
				((Said 'smell/rose')
					(Print 5 7) ; "The roses smell wonderful in the night air."
				)
				((Said 'climb/fence')
					(Print 5 8) ; "The fence is too difficult to climb. Besides, you don't care about those old fields."
				)
			)
		)
	)
)

(instance planter1 of RPicView
	(properties
		y 68
		x 107
		view 105
		priority 5
	)

	(method (handleEvent event)
		(cond
			((Said 'press,move,pull/urn')
				(Print 5 9) ; "Even your bulging muscles couldn't move those heavy urns."
			)
			((Said 'look<below/urn')
				(Print 5 10) ; "There is nothing of interest under the urns."
			)
			((Said 'look<in/urn')
				(if (& (gEgo onControl: 0) $4000)
					(Print 5 11) ; "The urn is empty."
				else
					(NotClose) ; "You're not close enough."
				)
			)
			((Said 'get/urn')
				(Print 5 12) ; "The urns are much too heavy to carry around."
			)
			((or (MousedOn self event 3) (Said 'look/urn,pedestal,base'))
				(event claimed: 1)
				(Print 5 13) ; "Upon two marble pedestals sit matching marble urns."
			)
		)
	)
)

(instance planter2 of RPicView
	(properties
		y 68
		x 212
		view 105
		priority 5
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 5 13) ; "Upon two marble pedestals sit matching marble urns."
		)
	)
)

(instance treerose1 of RPicView
	(properties
		y 119
		x 133
		view 105
		loop 1
	)

	(method (handleEvent event)
		(cond
			((Said 'climb/oak,bush,rose')
				(Print 5 14) ; "There are no trees here to climb."
			)
			((or (MousedOn self event 3) (Said 'look/oak,bush,rose'))
				(event claimed: 1)
				(Print 5 3) ; "Roses surround the little, heart-shaped garden."
			)
		)
	)
)

(instance treerose2 of RPicView
	(properties
		y 118
		x 186
		view 105
		loop 1
		cel 1
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 5 3) ; "Roses surround the little, heart-shaped garden."
		)
	)
)

(instance treerose3 of RPicView
	(properties
		y 105
		x 71
		view 105
		loop 2
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 5 3) ; "Roses surround the little, heart-shaped garden."
		)
	)
)

(instance treerose4 of RPicView
	(properties
		y 102
		x 254
		view 105
		loop 2
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 5 3) ; "Roses surround the little, heart-shaped garden."
		)
	)
)

(instance bench1 of RPicView
	(properties
		y 52
		x 106
		view 105
		loop 3
		priority 1
	)

	(method (handleEvent event)
		(cond
			((Said 'look<below/bench')
				(Print 5 15) ; "There is nothing but grass under the benches."
			)
			((Said 'sit/[<bench]')
				(Print 5 16) ; "You don't feel like sitting around."
			)
			((or (MousedOn self event 3) (Said 'look/bench'))
				(event claimed: 1)
				(Print 5 17) ; "There are two garden benches here."
			)
		)
	)
)

(instance bench2 of RPicView
	(properties
		y 52
		x 216
		view 105
		loop 3
		cel 1
		priority 1
	)

	(method (handleEvent event)
		(if (MousedOn self event 3)
			(event claimed: 1)
			(Print 5 17) ; "There are two garden benches here."
		)
	)
)

