;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 865)
(include sci.sh)
(use Main)
(use n001)
(use Feature)
(use Rev)
(use Motion)
(use Game)
(use Actor)

(public
	rm865 0
)

(instance rm865 of Rm
	(properties
		picture 2
		style 6
	)

	(method (init)
		(Load rsVIEW 865)
		(Load rsSCRIPT 969)
		(clickSpot init:)
		(feat1 init:)
		(feat2 init:)
		(feat3 init:)
		(feat4 init:)
		(feat5 init:)
		(star1 init: setCycle: Fwd)
		(star2 init: setCycle: Fwd)
		(star3 init: setCycle: Rev)
		(fiz init: setCycle: Fwd)
		(super init:)
		(gKeyDownHandler add: self)
		(Display 865 0 dsCOORD 94 180 dsFONT 1 dsCOLOR 14 dsBACKGROUND 0) ; "Enter/Return to continue"
		(HandsOff)
		(InitAddToPics inter coke popCorn kernel1 kernel2)
		(gCSound number: 865 loop: -1 playBed:)
	)

	(method (dispose)
		(gKeyDownHandler delete: self)
		(gCSound stop:)
		(super dispose:)
	)

	(method (handleEvent event)
		(if (super handleEvent: event)
			(return 1)
		)
		(switch (event type:)
			(evKEYBOARD
				(switch (event message:)
					(KEY_RETURN
						(event claimed: 1)
						(gCurRoom newRoom: 871)
					)
				)
			)
		)
	)
)

(instance inter of PicView
	(properties
		x 167
		y 144
		sightAngle 180
		closeRangeDist 500
		longRangeDist 500
		shiftClick 0
		contClick 0
		view 865
		loop 5
		priority 14
		signal 16
	)
)

(instance coke of PicView
	(properties
		x 204
		y 142
		description {an ice cold WizFiz}
		lookStr {Ice cold, tasty WizFiz. Made with pure Shapeirian artesian spring water.}
		view 865
		priority 11
		signal 16
	)
)

(instance popCorn of PicView
	(properties
		x 122
		y 145
		description {fresh popcorn}
		lookStr {Fresh popped Wilber Bluendecker\n__Gourmet Popping Corn.}
		view 865
		loop 1
		priority 8
		signal 16
	)
)

(instance kernel1 of PicView
	(properties
		x 50
		y 168
		description {fresh popcorn}
		lookStr {Fresh popped Wilber Bluendecker\n__Gourmet Popping Corn.}
		view 865
		loop 4
		cel 1
		priority 12
		signal 16
	)
)

(instance kernel2 of PicView
	(properties
		x 276
		y 151
		description {fresh popcorn}
		lookStr {Fresh popped Wilber Bluendecker\n__Gourmet Popping Corn.}
		view 865
		loop 4
		priority 15
		signal 16
	)
)

(instance star1 of Prop
	(properties
		x 251
		y 55
		description {a star}
		lookStr {Looky, looky, it's an orb of burning Helium and Hydrogen.}
		view 865
		loop 3
		cel 3
		priority 2
		signal 16
		cycleSpeed 1
	)
)

(instance star2 of Prop
	(properties
		x 161
		y 156
		description {a star}
		lookStr {Looky, looky, it's an orb of burning Helium and Hydrogen.}
		view 865
		loop 3
		cel 3
		priority 11
		signal 16
		cycleSpeed 1
	)
)

(instance star3 of Prop
	(properties
		x 46
		y 102
		description {a star}
		lookStr {Looky, looky, it's an orb of burning Helium and Hydrogen.}
		view 865
		loop 3
		cel 3
		priority 6
		signal 16
		cycleSpeed 1
	)
)

(instance fiz of Prop
	(properties
		x 202
		y 72
		view 865
		loop 2
		priority 14
		signal 16
		cycleSpeed 1
	)
)

(instance feat1 of Feature
	(properties
		x 159
		y 21
		nsTop -1
		nsBottom 43
		nsRight 318
		description {}
		lookStr {Stay tuned at end of game\nfor an intimation of\nQuest for Glory III.}
	)
)

(instance feat2 of Feature
	(properties
		x 282
		y 96
		nsTop 71
		nsLeft 246
		nsBottom 121
		nsRight 318
		description {}
		lookStr {Smoking only in the boys room or third balcony.}
	)
)

(instance feat3 of Feature
	(properties
		x 191
		y 176
		nsTop 164
		nsLeft 64
		nsBottom 188
		nsRight 318
		description {}
		lookStr {Snack stand closes in 10 minutes.}
	)
)

(instance feat4 of Feature
	(properties
		x 12
		y 116
		nsTop 44
		nsBottom 188
		nsRight 25
		description {}
		lookStr {Bathrooms close in 5 minutes.}
	)
)

(instance feat5 of Feature
	(properties
		x 53
		y 66
		nsTop 44
		nsLeft 26
		nsBottom 88
		nsRight 80
		description {}
		lookStr {Bathrooms close in 5 minutes.}
	)
)

(instance clickSpot of Feature
	(properties
		x 161
		y 182
		nsTop 175
		nsLeft 89
		nsBottom 189
		nsRight 233
		description {}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gCurRoom newRoom: 871)
			)
			(7
				(gCurRoom newRoom: 871)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

