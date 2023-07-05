;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 730)
(include sci.sh)
(use Main)
(use LarryRoom)
(use PolyFeature)
(use Polygon)
(use Feature)
(use System)

(public
	rm730 0
)

(instance rm730 of LarryRoom
	(properties
		modNum 720
		noun 1
		picture 730
		autoLoad 0
	)

	(method (init)
		(= global173 0)
		(gNarrator x: 185 y: 10 talkWidth: 115)
		(super init: &rest)
		(lips init:)
		(nose init:)
		(theEyes init:)
		(eyeBrows init:)
		(ear init:)
		(hair init:)
		(gTheIconBar
			curIcon: (ScriptID 0 4) ; icon1
			delete: (ScriptID 0 3) ; icon0
			addToFront: ((ScriptID 0 11) init: message: 720 yourself:) ; iconExit
			show:
		)
		(gGame handsOn:)
	)

	(method (doVerb theVerb)
		(cond
			((not (OneOf theVerb 4 1 2 5 6)) ; Do, Look, Talk, Take, Zipper
				(= global173 theVerb)
				(gCurRoom newRoom: 720)
			)
			((== theVerb 2) ; Talk
				(if (!= global175 0)
					(== global179 0)
					(= global179 1)
				)
				(gGame changeScore: 4 256)
				(gMessager
					say:
						noun
						theVerb
						(switch global179
							(0 2)
							(1 3)
							(2 4)
							(3 5)
							(4 6)
						)
						0
						0
						modNum
				)
				(if (< global179 4)
					(++ global179)
				)
			)
			(else
				(return (super doVerb: theVerb))
			)
		)
		(return 1)
	)

	(method (dispose)
		(gNarrator x: -1 y: -1 talkWidth: 0)
		(gTheIconBar delete: (ScriptID 0 11) addToFront: (ScriptID 0 3)) ; iconExit, icon0
		(super dispose:)
	)
)

(instance lips of Feature
	(properties
		noun 9
		modNum 720
	)

	(method (init)
		(super init: &rest)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 133 103 140 97 153 97 168 101 161 110 140 113
					yourself:
				)
		)
	)
)

(instance nose of Feature
	(properties
		noun 10
		modNum 720
	)

	(method (init)
		(super init: &rest)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 149 45 158 82 155 90 140 91 133 85 141 65 141 49
					yourself:
				)
		)
	)
)

(instance theEyes of PolyFeature
	(properties
		noun 8
		modNum 720
	)

	(method (init)
		(super init: &rest)
		(self
			addPolygon:
				((Polygon new:)
					init: 174 48 184 57 174 70 156 67 153 52
					yourself:
				)
				((Polygon new:)
					init: 137 69 119 68 116 53 135 53 141 59
					yourself:
				)
		)
	)
)

(instance eyeBrows of PolyFeature
	(properties
		noun 7
		modNum 720
	)

	(method (init)
		(super init: &rest)
		(self
			addPolygon:
				((Polygon new:) init: 119 42 139 45 138 52 118 47 yourself:)
				((Polygon new:)
					init: 167 39 185 45 185 49 173 45 154 49 150 44
					yourself:
				)
		)
	)
)

(instance ear of Feature
	(properties
		noun 6
		modNum 720
	)

	(method (init)
		(super init: &rest)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 225 43 233 44 230 77 217 82 212 58
					yourself:
				)
		)
	)
)

(instance hair of Feature
	(properties
		noun 4
		modNum 720
	)

	(method (init)
		(super init: &rest)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					init: 268 31 282 72 287 139 232 138 226 128 218 84 233 71 231 45 222 44 218 56 211 58 179 8 124 12 117 51 119 82 141 131 155 132 157 138 55 138 87 101 96 0 240 -2
					yourself:
				)
		)
	)
)

