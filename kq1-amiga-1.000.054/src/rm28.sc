;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 28)
(include sci.sh)
(use Main)
(use Interface)
(use NewFeature)
(use LoadMany)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	rm28 0
)

(instance rm28 of Rm
	(properties
		picture 28
		horizon 57
		north 37
		east 29
		south 21
		west 27
	)

	(method (init)
		(LoadMany rsVIEW 228 2 45)
		(LoadMany rsSOUND 16 15 83 29)
		(self
			style:
				(switch gPrevRoomNum
					(north 5)
					(west 3)
					(east 2)
					(south 4)
					(else 7)
				)
		)
		(super init:)
		(door setPri: 8 init: stopUpd:)
		(cane setPri: 9 init: stopUpd:)
		(smoke init: setCycle: Fwd)
		(switch gPrevRoomNum
			(north
				(gEgo posn: (proc0_18 262 (gEgo x:) 41) (+ horizon 2))
			)
			(south
				(gEgo posn: (proc0_17 213 (gEgo x:) 1) 188)
			)
			(west
				(gEgo posn: 3 (proc0_17 188 (gEgo y:) (+ horizon 2)))
			)
			(east
				(gEgo posn: 297 (proc0_17 162 (gEgo y:) (+ horizon 2)))
			)
			(else
				(gEgo posn: 137 141 loop: 2)
				(door cel: 4 setScript: closeIt)
			)
		)
		(gEgo init:)
		(proc0_1)
		(if (!= gPrevRoomNum 65)
			(if (> (Random 1 100) 50)
				(SetFlag 16)
			else
				(ClearFlag 16)
			)
		)
		(cond
			((IsFlag 74)
				(ClearFlag 16)
			)
			((== gPrevRoomNum 65) 0)
		)
		(gAddToPics add: cookie1 cookie2 cookie3_a eachElementDo: #init doit:)
		(house5 init:)
		(candy_canes1 init:)
		(candy_canes init:)
		(candy_canes2 init:)
		(candy_canes3 init:)
		(candy_canes5 init:)
		(candy_canes4 init:)
		(chimney init:)
		(tree init:)
		(tree1 init:)
		(tree3 init:)
		(tree2 init:)
		(backwind init:)
		(house init:)
		(house1 init:)
		(house3 init:)
		(house2 init:)
		(house4 init:)
		(house7 init:)
		(house6 init:)
		(house9 init:)
		(house8 init:)
		(house10 init:)
		(steps2 init:)
		(steps init:)
		(roof init:)
		(roof1 init:)
		(roof2 init:)
		(roof3 init:)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((super handleEvent: event)
				(return)
			)
			((or (Said 'look,look/window') (proc0_14 event 172 91 191 112))
				(if (gEgo inRect: 150 120 220 155)
					(Print 28 0) ; "The windows are made from hardened sugar.  You can't see through them very well."
				else
					(Print 28 1) ; "The candy canes on the window block your view."
				)
			)
			((Said 'smell,smell/building,cake')
				(Print 28 2) ; "Mmmmmm! The lovely aroma of baked gingerbread makes your mouth water."
			)
			((Said 'look,look/building')
				(if (gEgo inRect: 34 100 236 190)
					(Print 28 3) ; "This is the sweetest little gingerbread house you've ever seen. The walls are cake, the roof is frosting, the chimney is made from gummy bricks, and the candy path and cookie fence are unbearably tempting!"
				else
					(Print 28 4) ; "You can't see much from here."
				)
			)
			((Said 'look,look>')
				(cond
					((Said '[<at,around][/room]')
						(Print 28 5) ; "You are near a little gingerbread house in a forest clearing."
					)
					((Said '/witch')
						(Print 28 6) ; "You must be getting nervous! There is no witch anywhere to be seen."
					)
					((Said '/path')
						(Print 28 7) ; "The path leads to the door."
					)
					((Said '/candy')
						(Print 28 8) ; "The whole house is made of candy."
					)
					((Said '/fence')
						(Print 28 9) ; "It is made of delicious chocolate chip cookies!"
					)
					((Said '/cake')
						(Print 28 10) ; "The whole HOUSE is made of gingerbread!"
					)
					((Said '/frosting,frosting')
						(Print 28 11) ; "The entire ROOF is made of frosting!"
					)
				)
			)
			((Said 'knock')
				(cond
					((not (gEgo inRect: 114 129 151 138))
						(proc0_4) ; "It's not quite within reach, Sir Graham."
					)
					((IsFlag 1)
						(Print 28 12) ; "Strangely enough, knocking on the door while invisible wouldn't make any sound!"
					)
					(else
						(self setScript: knockDoor)
					)
				)
			)
			((Said 'open,open/door')
				(if (not (gEgo inRect: 114 129 151 138))
					(proc0_4) ; "It's not quite within reach, Sir Graham."
				else
					(door setScript: openIt)
				)
			)
			((Said 'close,close/door')
				(if (not (gEgo inRect: 114 129 151 138))
					(proc0_4) ; "It's not quite within reach, Sir Graham."
				else
					(Print 28 13) ; "The door is already closed."
				)
			)
			((Said 'bend/window')
				(if (gEgo inRect: 150 120 220 155)
					(Print 28 14) ; "The windows are too hard to break."
				else
					(Print 28 15) ; "You would have to get closer to the windows."
				)
			)
			((Said 'bend/door')
				(if (gEgo inRect: 2 106 316 166)
					(Print 28 16) ; "You don't need to do that; opening the door would suffice."
				else
					(Print 28 17) ; "The door is around the corner."
				)
			)
			((Said 'unlock/door,lock')
				(Print 28 18) ; "The door is not locked."
			)
			((Said 'eat,eat>')
				(cond
					((Said '/fence')
						(if (gEgo inRect: 114 146 245 162)
							(Print 28 19) ; "Yummy!"
						else
							(Print 28 20) ; "You will have to move closer to do that."
						)
					)
					(
						(Said
							'/building,cake,frosting,frosting,cake,ceiling,door,window'
						)
						(cond
							((not (& (gEgo onControl: 1) $4000))
								(Print 28 21) ; "The gingerbread house with its frosting looks tempting, but you need to get closer."
							)
							((IsFlag 16)
								(proc0_15 gEgo 110 110)
								(Print 28 22) ; "As you begin to eat the house, a squeaky voice from somewhere says, "Nibble, nibble, little mouse. Who is nibbling at my house?""
								(SetScore 79 2)
							)
							(else
								(Print 28 23) ; "Yum! The house tastes even better than it looks!"
								(SetScore 79 2)
							)
						)
					)
					((Said '/candy')
						(Print 28 24) ; "What candy would you like to eat? The whole house is made of candy."
					)
					((Said '/cookie')
						(Print 28 25) ; "The cookies look delicious, but the house looks even better!"
					)
					((Said '/blossom')
						(Print 28 26) ; "Eat a flower? That seems rather strange."
					)
					(
						(or
							(Said '/cane<candy')
							(Said '/stick<peppermint')
							(Said '/gumdrop')
						)
						(Print 28 27) ; "As good as it looks, you're just a little bit suspicious about where all that candy came from."
					)
					((Said '/chimney')
						(Print 28 28) ; "It looks tempting, but you can't reach it from down here."
					)
					((or (Said '/man,boy[<cake]') (Said '/woman,woman[<cake]'))
						(Print 28 29) ; "You don't know how long they have been standing there. Eating them probably wouldn't be a wise thing to do."
					)
					(else
						(super handleEvent: event)
					)
				)
			)
		)
	)
)

(instance smoke of Prop
	(properties
		x 68
		y 8
		view 228
		loop 3
		priority 10
		signal 16
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((Said 'look,look/smoke')
				(self doVerb: 1)
			)
			(else
				(super handleEvent: event)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 28 30) ; "Something...or someone...must be cooking."
			)
		)
	)
)

(instance cane of View
	(properties
		x 182
		y 112
		description {window}
		view 228
		loop 1
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((Said 'look,look/window')
				(self doVerb: 1)
			)
			(else
				(super handleEvent: event)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(Print 28 0) ; "The windows are made from hardened sugar.  You can't see through them very well."
			)
		)
	)
)

(instance door of Prop
	(properties
		x 111
		y 131
		view 228
		signal 1
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((or (Said 'look,look/door') (MousedOn self event 3))
				(if (> (gEgo y:) 130)
					(Print 28 31) ; "The door is made from candy canes."
				else
					(Print 28 17) ; "The door is around the corner."
				)
				(event claimed: 1)
			)
			(else
				(super handleEvent: event)
			)
		)
	)
)

(instance knockDoor of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo
					view: 45
					loop: 0
					cycleSpeed: (if (>= global101 1) 1 else 0)
					cel: 0
					setMotion: 0
				)
				(= cycles 2)
			)
			(1
				((ScriptID 0 21) number: 29 loop: 2 play: self) ; gameSound
				(gEgo loop: 1 setCycle: Fwd)
			)
			(2
				(gEgo loop: 0 cel: 0 setCycle: 0)
				(= cycles 2)
			)
			(3
				(gEgo view: 2 loop: 3 cel: 0)
				(proc0_1)
				(if (IsFlag 16)
					(Print 28 32) ; "As you knock on the candy cane door, a squeaky voice from inside the house says, "Who is there? I love visitors, especially young, tender ones! Come in, come in!""
				else
					(Print 28 33) ; "There is no answer from inside the house."
				)
				(self cue:)
			)
			(4
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance closeIt of Script
	(properties
		cycles 1
	)

	(method (changeState newState)
		(switch (= state newState)
			(1
				(HandsOff)
				(doorSound number: 16 loop: 1 play:)
				(door cel: 4 cycleSpeed: 0 setCycle: CT 1 -1 self)
			)
			(2
				(doorSound number: 83 play:)
				(door setCycle: Beg self)
			)
			(3
				(door stopUpd:)
				(HandsOn)
				(self dispose:)
			)
		)
	)
)

(instance openIt of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(doorSound number: 15 loop: 1 play:)
				(door cel: 0 cycleSpeed: 2 setCycle: End self)
			)
			(1
				(doorSound stop:)
				(door stopUpd:)
				(HandsOn)
				(gCurRoom newRoom: 65)
			)
		)
	)
)

(instance cookie1 of PicView
	(properties
		x 218
		y 169
		description {cookie}
		view 228
		loop 2
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			(
				(or
					(MousedOn self event)
					(Said 'look,look/cookie,man,woman,boy,woman')
				)
				(Print 28 34) ; "The path to the front door is lined with little gingerbread boys and girls."
				(event claimed: 1)
			)
			(else
				(super handleEvent: event)
			)
		)
	)
)

(instance cookie2 of PicView
	(properties
		x 120
		y 175
		description {cookie}
		view 228
		loop 2
		cel 1
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((or (MousedOn self event) (Said 'look,look/cookie,man'))
				(Print 28 34) ; "The path to the front door is lined with little gingerbread boys and girls."
				(event claimed: 1)
			)
			(else
				(super handleEvent: event)
			)
		)
	)
)

(instance cookie3_a of PicView
	(properties
		name {cookie3}
		x 102
		y 160
		description {cookie}
		view 228
		loop 2
		cel 2
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			((or (MousedOn self event) (Said 'look,look/cookie,man'))
				(Print 28 34) ; "The path to the front door is lined with little gingerbread boys and girls."
				(event claimed: 1)
			)
			(else
				(super handleEvent: event)
			)
		)
	)
)

(instance cookie3_b of NewFeature ; UNUSED
	(properties
		name {cookie3}
		x 218
		y 155
		noun '/cookie,man,boy[<cake]'
		nsTop 142
		nsLeft 212
		nsBottom 169
		nsRight 225
		description {gingerbread boy}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {These little gingerbread boys and girls look almost alive! How do you suppose they got here?}
	)
)

(instance candy_canes of NewFeature
	(properties
		x 84
		y 134
		noun '/cane<candy'
		nsTop 116
		nsLeft 74
		nsBottom 153
		nsRight 94
		description {candy canes}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {The path to the gingerbread house is lined with the biggest, most tempting candy canes you've ever seen.}
	)
)

(instance candy_canes1 of NewFeature
	(properties
		x 120
		y 141
		noun '/cane<candy'
		nsTop 133
		nsLeft 112
		nsBottom 149
		nsRight 128
		description {candy canes}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {The path to the gingerbread house is lined with the biggest, most tempting candy canes you've ever seen.}
	)
)

(instance candy_canes2 of NewFeature
	(properties
		x 134
		y 156
		noun '/cane<candy'
		nsTop 145
		nsLeft 129
		nsBottom 167
		nsRight 140
		description {candy canes}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {The path to the gingerbread house is lined with the biggest, most tempting candy canes you've ever seen.}
	)
)

(instance candy_canes3 of NewFeature
	(properties
		x 186
		y 144
		noun '/cane<candy'
		nsTop 130
		nsLeft 176
		nsBottom 158
		nsRight 197
		description {candy canes}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {The path to the gingerbread house is lined with the biggest, most tempting candy canes you've ever seen.}
	)
)

(instance candy_canes4 of NewFeature
	(properties
		x 201
		y 154
		noun '/cane<candy'
		nsTop 142
		nsLeft 197
		nsBottom 166
		nsRight 206
		description {candy canes}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {The path to the gingerbread house is lined with the biggest, most tempting candy canes you've ever seen.}
	)
)

(instance candy_canes5 of NewFeature
	(properties
		x 219
		y 123
		noun '/cane<candy'
		nsTop 109
		nsLeft 211
		nsBottom 137
		nsRight 228
		description {candy canes}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {The path to the gingerbread house is lined with the biggest, most tempting candy canes you've ever seen.}
	)
)

(instance chimney of NewFeature
	(properties
		x 74
		y 23
		noun '/chimney'
		nsTop 3
		nsLeft 56
		nsBottom 43
		nsRight 93
		description {chimney}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {Even the chimney looks delicious.}
	)
)

(instance tree of NewFeature
	(properties
		x 306
		y 93
		noun '/ceder'
		nsTop -1
		nsLeft 294
		nsBottom 188
		nsRight 319
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {Twisted, malformed trees overhang the gingerbread house. They almost seem to reach out for you.}
	)
)

(instance tree1 of NewFeature
	(properties
		x 219
		y 27
		noun '/ceder'
		nsTop -1
		nsLeft 145
		nsBottom 55
		nsRight 294
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {Twisted, malformed trees overhang the gingerbread house. They almost seem to reach out for you.}
	)
)

(instance tree2 of NewFeature
	(properties
		x 271
		y 179
		noun '/ceder'
		nsTop 171
		nsLeft 249
		nsBottom 188
		nsRight 293
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {Twisted, malformed trees overhang the gingerbread house. They almost seem to reach out for you.}
	)
)

(instance tree3 of NewFeature
	(properties
		x 236
		y 185
		noun '/ceder'
		nsTop 183
		nsLeft 225
		nsBottom 188
		nsRight 248
		description {tree}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {Twisted, malformed trees overhang the gingerbread house. They almost seem to reach out for you.}
	)
)

(instance house of NewFeature
	(properties
		x 104
		y 124
		noun '/building'
		nsTop 116
		nsLeft 95
		nsBottom 132
		nsRight 113
		description {house}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {This is the most marvelous house you've ever seen! It seems like it's made out of a huge gingerbread cupcake, with frosting for a roof. The chimney is made of gummy bricks, the door and fence are made of candy canes, and sourball stones and gumdrops are scattered around the yard.}
	)
)

(instance house1 of NewFeature
	(properties
		x 182
		y 121
		noun '/building'
		nsTop 113
		nsLeft 154
		nsBottom 130
		nsRight 210
		description {house}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {This is the most marvelous house you've ever seen! It seems like it's made out of a huge gingerbread cupcake, with frosting for a roof. The chimney is made of gummy bricks, the door and fence are made of candy canes, and sourball stones and gumdrops are scattered around the yard.}
	)
)

(instance house2 of NewFeature
	(properties
		x 225
		y 92
		noun '/building'
		nsTop 75
		nsLeft 196
		nsBottom 109
		nsRight 254
		description {house}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {This is the most marvelous house you've ever seen! It seems like it's made out of a huge gingerbread cupcake, with frosting for a roof. The chimney is made of gummy bricks, the door and fence are made of candy canes, and sourball stones and gumdrops are scattered around the yard.}
	)
)

(instance house3 of NewFeature
	(properties
		x 167
		y 79
		noun '/building'
		nsTop 75
		nsLeft 139
		nsBottom 83
		nsRight 195
		description {house}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {This is the most marvelous house you've ever seen! It seems like it's made out of a huge gingerbread cupcake, with frosting for a roof. The chimney is made of gummy bricks, the door and fence are made of candy canes, and sourball stones and gumdrops are scattered around the yard.}
	)
)

(instance house4 of NewFeature
	(properties
		x 158
		y 98
		noun '/building'
		nsTop 84
		nsLeft 152
		nsBottom 112
		nsRight 165
		description {house}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {This is the most marvelous house you've ever seen! It seems like it's made out of a huge gingerbread cupcake, with frosting for a roof. The chimney is made of gummy bricks, the door and fence are made of candy canes, and sourball stones and gumdrops are scattered around the yard.}
	)
)

(instance house5 of NewFeature
	(properties
		x 77
		y 98
		noun '/building'
		nsTop 81
		nsLeft 47
		nsBottom 115
		nsRight 108
		description {house}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {This is the most marvelous house you've ever seen! It seems like it's made out of a huge gingerbread cupcake, with frosting for a roof. The chimney is made of gummy bricks, the door and fence are made of candy canes, and sourball stones and gumdrops are scattered around the yard.}
	)
)

(instance house6 of NewFeature
	(properties
		x 100
		y 75
		noun '/building'
		nsTop 70
		nsLeft 62
		nsBottom 80
		nsRight 138
		description {house}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {This is the most marvelous house you've ever seen! It seems like it's made out of a huge gingerbread cupcake, with frosting for a roof. The chimney is made of gummy bricks, the door and fence are made of candy canes, and sourball stones and gumdrops are scattered around the yard.}
	)
)

(instance house7 of NewFeature
	(properties
		x 38
		y 110
		noun '/building'
		nsTop 90
		nsLeft 31
		nsBottom 131
		nsRight 46
		description {house}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {This is the most marvelous house you've ever seen! It seems like it's made out of a huge gingerbread cupcake, with frosting for a roof. The chimney is made of gummy bricks, the door and fence are made of candy canes, and sourball stones and gumdrops are scattered around the yard.}
	)
)

(instance house8 of NewFeature
	(properties
		x 59
		y 131
		noun '/building'
		nsTop 115
		nsLeft 46
		nsBottom 147
		nsRight 73
		description {house}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {This is the most marvelous house you've ever seen! It seems like it's made out of a huge gingerbread cupcake, with frosting for a roof. The chimney is made of gummy bricks, the door and fence are made of candy canes, and sourball stones and gumdrops are scattered around the yard.}
	)
)

(instance house9 of NewFeature
	(properties
		x 104
		y 66
		noun '/building'
		nsTop 64
		nsLeft 87
		nsBottom 69
		nsRight 121
		description {house}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {This is the most marvelous house you've ever seen! It seems like it's made out of a huge gingerbread cupcake, with frosting for a roof. The chimney is made of gummy bricks, the door and fence are made of candy canes, and sourball stones and gumdrops are scattered around the yard.}
	)
)

(instance house10 of NewFeature
	(properties
		x 239
		y 113
		noun '/building'
		nsTop 109
		nsLeft 229
		nsBottom 118
		nsRight 249
		description {house}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {This is the most marvelous house you've ever seen! It seems like it's made out of a huge gingerbread cupcake, with frosting for a roof. The chimney is made of gummy bricks, the door and fence are made of candy canes, and sourball stones and gumdrops are scattered around the yard.}
	)
)

(instance steps of NewFeature
	(properties
		x 150
		y 138
		noun '/stair'
		nsTop 132
		nsLeft 129
		nsBottom 144
		nsRight 172
		description {steps}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {The steps look like they're made out of vanilla fudge, but after years of being stepped on, they've gotten a wee bit filthy.}
	)
)

(instance steps2 of NewFeature
	(properties
		x 157
		y 148
		noun '/stair'
		nsTop 145
		nsLeft 140
		nsBottom 151
		nsRight 175
		description {steps}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {The steps look like they're made out of vanilla fudge, but after years of being stepped on, they've gotten a wee bit filthy.}
	)
)

(instance roof of NewFeature
	(properties
		x 26
		y 78
		noun '/ceiling'
		nsTop 66
		nsLeft 11
		nsBottom 90
		nsRight 41
		description {roof}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {The roof looks like it's made out of rich vanilla buttercream frosting!}
	)
)

(instance roof3 of NewFeature
	(properties
		x 49
		y 52
		noun '/ceiling'
		nsTop 33
		nsLeft 37
		nsBottom 71
		nsRight 62
		description {roof}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {The roof looks like it's made out of rich vanilla buttercream frosting!}
	)
)

(instance roof2 of NewFeature
	(properties
		x 161
		y 58
		noun '/ceiling'
		nsTop 46
		nsLeft 62
		nsBottom 70
		nsRight 260
		description {roof}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {The roof looks like it's made out of rich vanilla buttercream frosting!}
	)
)

(instance roof1 of NewFeature
	(properties
		x 118
		y 33
		noun '/ceiling'
		nsTop 21
		nsLeft 94
		nsBottom 46
		nsRight 142
		description {roof}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		lookStr {The roof looks like it's made out of rich vanilla buttercream frosting!}
	)
)

(instance backwind of NewFeature
	(properties
		x 234
		y 88
		noun '/window<back'
		nsTop 80
		nsLeft 228
		nsBottom 96
		nsRight 241
		description {window}
		sightAngle 360
		getableDist 320
		seeableDist 320
		shiftClick 367
		contClick 369
		lookStr {There's a small window at the back of the cupcake...er, the house.  But you can't see through the sugar-pane glass.}
	)
)

(instance doorSound of Sound
	(properties
		priority 10
	)
)

