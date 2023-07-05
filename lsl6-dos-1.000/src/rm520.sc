;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 520)
(include sci.sh)
(use Main)
(use n079)
(use LarryRoom)
(use Polygon)
(use Feature)
(use System)

(public
	rm520 0
)

(local
	local0 = -1
)

(instance rm520 of LarryRoom
	(properties
		noun 1
		picture 520
	)

	(method (init)
		(super init: &rest)
		(gNarrator x: 10 y: 75 talkWidth: 295)
		(burgEyes init:)
		(burgMouth init:)
		(burgNose init:)
		(burgTits init:)
		((ScriptID 0 11) init: 510) ; iconExit
		(if global173
			(= global173 0)
			(self setScript: giveBeerScr)
		else
			(gGame handsOn:)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(9 ; beer
				(= global172 28)
				(gMessager say: noun theVerb (if (IsFlag 214) 1 else 0) 0 rm520)
				(return 1)
			)
			(2 ; Talk
				(gMessager
					say:
						noun
						theVerb
						(switch (if (< local0 5) (++ local0) else local0)
							(0
								0
								2
							)
							(1
								1
								3
							)
							(2
								2
								4
							)
							(3
								3
								5
							)
							(4
								4
								(gGame changeScore: 2 213)
								(SetFlag 45)
								6
							)
							(5
								5
								7
							)
						)
				)
				(return 1)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (cue)
		(gCurRoom newRoom: 510)
	)

	(method (dispose)
		(gNarrator x: -1 y: -1 talkWidth: 0)
		(gTheIconBar delete: (ScriptID 0 11) addToFront: (ScriptID 0 3)) ; iconExit, icon0
		(super dispose:)
	)
)

(instance giveBeerScr of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(gCurRoom doVerb: 9)
				(self dispose:)
			)
		)
	)
)

(instance burgEyes of Feature
	(properties
		y 2
		noun 3
	)

	(method (init)
		(super init: &rest)
		(self
			setOnMeCheck:
				2
				((Polygon new:) init: 185 36 185 49 147 49 147 36 yourself:)
		)
	)
)

(instance burgNose of Feature
	(properties
		y 2
		noun 4
	)

	(method (init)
		(super init: &rest)
		(self
			setOnMeCheck:
				2
				((Polygon new:) init: 171 49 173 56 158 56 161 49 yourself:)
		)
	)
)

(instance burgMouth of Feature
	(properties
		y 2
		noun 5
	)

	(method (init)
		(super init: &rest)
		(self
			setOnMeCheck:
				2
				((Polygon new:) init: 180 57 176 64 157 64 155 57 yourself:)
		)
	)
)

(instance burgTits of Feature
	(properties
		y 2
		noun 6
	)

	(method (init)
		(self
			setOnMeCheck:
				2
				((Polygon new:)
					type: PTotalAccess
					init: 191 105 205 118 208 128 200 139 139 139 134 125 136 114 142 105
					yourself:
				)
		)
		(super init: &rest)
	)
)

