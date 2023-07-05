;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 898)
(include sci.sh)
(use Main)
(use Polygon)
(use Feature)
(use Actor)

(public
	xlid_up 0
	xlid_glow 1
	xfire 2
	xdrummer 3
	xc1 4
	xc2 5
	xc3 6
	xc4 7
	xc5 8
	xc6 9
	xc7 10
	xdeadChicks 11
	xsnake_cage 12
	xchicken_cage 13
	xveve 14
	xlDrums 15
	xrDrums 16
	xtable 17
	xfirePit 18
	xpole 19
)

(instance xlid_up of Prop
	(properties
		modNum 900
		x 151
		y 91
		priority 106
		fixPriority 1
		view 8942
		loop 1
		signal 16417
	)
)

(instance xlid_glow of Prop
	(properties
		modNum 900
		x 151
		y 91
		priority 145
		fixPriority 1
		view 8942
		cel 8
	)
)

(instance xfire of Prop
	(properties
		noun 2
		modNum 900
		x 203
		y 68
		view 889
		loop 1
		cel 3
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(gMessager say: noun theVerb 4 0 0 900) ; "A fire blazes in the pit."
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance xdrummer of Prop
	(properties
		noun 12
		modNum 900
		x 317
		y 102
		view 891
	)
)

(instance xc1 of Prop
	(properties
		noun 12
		modNum 900
		x 182
		y 61
		view 8901
		cel 9
		signal 16417
	)
)

(instance xc2 of Prop
	(properties
		noun 12
		modNum 900
		x 275
		y 154
		view 8901
		loop 1
		cel 8
		signal 16417
	)
)

(instance xc3 of Prop
	(properties
		noun 12
		modNum 900
		x 106
		y 162
		view 8901
		loop 2
		cel 4
		signal 16417
		detailLevel 2
	)
)

(instance xc4 of Prop
	(properties
		noun 12
		modNum 900
		x 223
		y 152
		view 8903
		loop 2
		cel 5
		signal 16417
		detailLevel 3
	)
)

(instance xc5 of Prop
	(properties
		noun 12
		modNum 900
		x 279
		y 85
		view 8903
		cel 7
		signal 16417
		detailLevel 3
	)
)

(instance xc6 of Prop
	(properties
		noun 12
		modNum 900
		x 42
		y 82
		view 8903
		loop 1
		cel 4
		signal 16417
		detailLevel 3
	)
)

(instance xc7 of Prop
	(properties
		noun 12
		modNum 900
		x 133
		y 65
		view 8905
		loop 2
		cel 8
		signal 16417
		detailLevel 2
	)
)

(instance xdeadChicks of View
	(properties
		x 250
		y 107
		priority 5
		fixPriority 1
		view 889
		loop 3
	)

	(method (doVerb)
		(return 0)
	)
)

(instance xsnake_cage of View
	(properties
		modNum 900
		x 123
		y 140
		priority 145
		fixPriority 1
		view 889
	)
)

(instance xchicken_cage of View
	(properties
		modNum 900
		x 183
		y 139
		priority 145
		fixPriority 1
		view 889
		cel 1
	)
)

(instance xveve of View
	(properties
		noun 3
		modNum 900
		x 234
		y 102
		fixPriority 1
		view 889
		loop 2
	)
)

(instance xlDrums of Feature
	(properties
		noun 5
		modNum 900
		sightAngle 40
		x 18
		y 100
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 6 80 9 73 16 73 17 70 22 69 28 71 29 80 26 99 21 100 19 105 10 105
					yourself:
				)
		)
		(super init:)
	)
)

(instance xrDrums of Feature
	(properties
		noun 5
		modNum 900
		sightAngle 40
		x 295
		y 100
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 282 79 285 74 290 75 290 72 293 69 303 70 306 80 310 83 308 104 302 105 286 94
					yourself:
				)
		)
		(super init:)
	)
)

(instance xtable of Feature
	(properties
		noun 1
		modNum 900
		sightAngle 40
		x 150
		y 100
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 127 79 135 74 159 72 180 77 180 96 176 102 162 104 137 103 127 99
					yourself:
				)
		)
		(super init:)
	)
)

(instance xfirePit of Feature
	(properties
		noun 2
		modNum 900
		sightAngle 40
		x 203
		y 69
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 186 66 213 65 226 68 227 71 212 76 187 75 177 72
					yourself:
				)
		)
		(super init:)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(7 ; Look
				(gMessager say: noun theVerb 4 0 0 900) ; "A fire blazes in the pit."
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)
)

(instance xpole of Feature
	(properties
		noun 4
		modNum 900
		sightAngle 40
		x 100
		y 80
	)

	(method (init)
		(self
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 107 18 108 79 100 82 91 79 92 21
					yourself:
				)
		)
		(super init:)
	)
)

