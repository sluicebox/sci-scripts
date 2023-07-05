;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 285)
(include sci.sh)
(use Main)
(use Teller)
(use Talker)
(use Feature)
(use LoadMany)
(use Game)
(use Actor)
(use System)

(public
	rm285 0
	kreeshaBTalker 1
	rakeeshBTalker 2
)

(local
	local0
	[local1 19] = [0 -1 -2 -3 -4 -7 -54 -55 -56 -59 -9 -48 -61 -78 -67 -79 -69 -70 999]
	[local20 14]
	[local34 14] = [0 -1 -4 -7 -5 -45 -46 -10 -40 -11 -56 -57 -9 999]
	[local48 3] = [0 -57 999]
	[local51 3] = [0 58 999]
	[local54 3] = [0 -5 999]
	[local57 3] = [0 6 999]
	[local60 7] = [0 -45 -40 -10 43 21 999]
	[local67 3] = [0 -46 999]
	[local70 3] = [0 47 999]
	[local73 3] = [0 -11 999]
	[local76 3] = [0 17 999]
	[local79 3] = [0 49 999]
	[local82 4] = [0 44 16 999]
	[local86 3] = [0 18 999]
	[local89 18] = [0 -1 -20 -21 -22 -23 -56 -60 -30 -37 -62 -40 -63 -64 -71 -72 -75 999]
	[local107 9]
	[local116 10] = [0 -1 -20 -24 -50 -48 -52 -62 -72 999]
	[local126 7] = [0 74 73 999 0 65 999]
	[local133 3] = [0 -52 999]
	[local136 4] = [0 -24 -50 999]
	[local140 6] = [0 9 45 7 -48 999]
	[local146 3] = [0 51 999]
	[local149 4] = [0 10 49 999]
	[local153 3] = [0 53 999]
	[local156 14] = [0 -41 -76 1 -30 -77 -33 -34 -35 -36 -37 -42 -80 999]
	[local170 4]
)

(instance rm285 of Rm
	(properties
		noun 5
		picture 285
	)

	(method (init)
		(= [local20 0] @local1)
		(= [local20 1] @local54)
		(= [local20 2] @local86)
		(= [local20 3] @local60)
		(= [local20 4] @local57)
		(= [local20 5] @local67)
		(= [local20 6] @local70)
		(= [local20 7] @local82)
		(= [local20 8] @local73)
		(= [local20 9] @local76)
		(= [local20 10] @local48)
		(= [local20 11] @local51)
		(= [local20 12] @local79)
		(= [local107 0] @local89)
		(= [local107 1] @local136)
		(= [local107 2] @local133)
		(= [local107 3] @local140)
		(= [local107 4] @local146)
		(= [local107 5] @local149)
		(= [local107 6] @local153)
		(= [local107 8] @local126)
		(= [local170 0] @local156)
		(gWalkHandler addToFront: gCurRoom)
		(HandsOn)
		(gTheIconBar disable: 8 7 5 6)
		(super init:)
		(gLongSong number: 285 setLoop: -1 play: 127)
		(pillar init:)
		(kreesha init:)
		(rakeeshFeat init:)
		(gEgo noun: 3)
		(egoDude actions: egoTell init:)
		(egoTell init: gEgo @local156 @local170)
		(kreeshaTell init: kreesha @local89 @local107 @local116)
		(rakeeshTell init: rakeeshFeat @local1 @local20 @local34)
		(cond
			((not (IsFlag 41))
				(= local0 0)
			)
			((not (IsFlag 35))
				(= local0 1)
			)
			((not (IsFlag 156))
				(= local0 2)
				(SetFlag 156)
			)
			(else
				(= local0 3)
			)
		)
		(self setScript: theyConverse)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Walk
				(gCurRoom newRoom: 280)
			)
			(else
				(super doVerb: theVerb)
			)
		)
	)

	(method (dispose)
		((gEgo actions:) dispose:)
		(gEgo actions: 0)
		(LoadMany 0 35 49)
		(gWalkHandler delete: gCurRoom)
		(super dispose:)
	)
)

(instance egoExits of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(HandsOff)
				(= seconds 2)
			)
			(1
				(gCurRoom newRoom: 280)
			)
		)
	)
)

(instance theyConverse of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 2)
			)
			(1
				(switch local0
					(0
						(gMessager say: 1 6 41 0 self) ; "Good day. I trust you are finding your way around Tarna."
					)
					(1
						(gMessager say: 1 6 29 0 self) ; "Hello again, my friend. I am sorry you had to experience Tarna's justice in such a manner. Crime is not common here."
					)
					(2
						(gMessager say: 1 6 39 0 self) ; "Welcome back. I hope you have found your stay with the Simbani to be pleasant."
					)
					(3
						(gMessager say: 1 6 42 0 self) ; "Welcome again, my friend."
					)
					(else
						(self cue:)
					)
				)
			)
			(2 0)
			(3
				(gCurRoom newRoom: 280)
			)
		)
	)
)

(instance kreesha of Feature
	(properties
		x 100
		y 100
		noun 2
		onMeCheck 2
	)
)

(instance rakeeshFeat of Feature
	(properties
		x 100
		y 100
		noun 1
		onMeCheck 4
	)
)

(instance rakeeshArm of Feature ; UNUSED
	(properties
		x 168
		y 83
		noun 1
		nsTop 61
		nsLeft 158
		nsBottom 105
		nsRight 179
		sightAngle 180
	)
)

(instance pillar of Feature
	(properties
		x 44
		y 73
		noun 4
		nsTop 23
		nsLeft 30
		nsBottom 123
		nsRight 59
		sightAngle 180
	)
)

(instance egoDude of Feature
	(properties
		x 100
		y 100
		noun 3
		onMeCheck 8
	)

	(method (doVerb theVerb)
		(gEgo doVerb: theVerb)
	)
)

(instance egoTell of Teller
	(properties)

	(method (showDialog)
		(super
			showDialog:
				-30 ; "Simbani"
				(IsFlag 42)
				-31
				(IsFlag 56)
				-77
				(and (IsFlag 29) (not (IsFlag 38)))
				-33
				(and (IsFlag 38) (not (IsFlag 65)))
				-34
				(and (== global392 4) (not (IsFlag 65)))
				-35
				(and (not (IsFlag 102)) (IsFlag 65))
				-36
				(and (IsFlag 102) (IsFlag 65) (not (IsFlag 37)))
				-37 ; "Village"
				(IsFlag 37)
				-41
				(< local0 3)
				-76
				(< local0 3)
				-42
				(== local0 3)
				-80
				(== local0 3)
		)
	)

	(method (doVerb theVerb)
		(if (== theVerb 3) ; Walk
			(gCurRoom doVerb: 3)
		else
			(super doVerb: theVerb)
		)
	)

	(method (doChild)
		(switch query
			(-76
				(gCurRoom setScript: egoExits)
				(return query)
			)
			(-80
				(gCurRoom setScript: egoExits)
				(return query)
			)
			(-31
				(gEgo solvePuzzle: 239 3 9)
				(return query)
			)
			(-33
				(gEgo solvePuzzle: 240 2)
				(return query)
			)
			(else
				(return query)
			)
		)
	)
)

(instance kreeshaTell of Teller
	(properties)

	(method (doVerb theVerb)
		(if (== theVerb 3) ; Walk
			(gCurRoom doVerb: 3)
		else
			(super doVerb: theVerb)
		)
	)

	(method (showDialog)
		(super
			showDialog:
				-1 ; "Tarna"
				(== local0 0)
				-20 ; "Magic"
				(== local0 0)
				-21 ; "Leopardmen"
				(== local0 0)
				-22 ; "Rakeesh"
				(== local0 0)
				-23 ; "Home"
				(== local0 0)
				-56 ; "Tarna"
				(== local0 1)
				-60 ; "Magic"
				(== local0 1)
				-30 ; "Simbani"
				(== local0 1)
				-37 ; "Village"
				(== local0 1)
				-62 ; "Magic"
				(== local0 2)
				-40 ; "Demons"
				(== local0 2)
				-63 ; "East"
				(== local0 2)
				-64 ; "Kreesha"
				(== local0 2)
				-71 ; "Magic"
				(== local0 3)
				-72 ; "Demons"
				(== local0 3)
				-75 ; "Kreesha"
				(== local0 3)
		)
	)

	(method (doChild)
		(switch query
			(-1 ; "Tarna"
				(super doChild: query)
			)
			(-24 ; "Situation"
				(super doChild: query)
			)
			(-45 ; "Council"
				(super doChild: query)
			)
			(-48 ; "Vengeance"
				(super doChild: query)
			)
			(-50 ; "Danger"
				(super doChild: query)
			)
			(-20 ; "Magic"
				(super doChild: query)
			)
			(-52 ; "Son"
				(super doChild: query)
			)
			(-72 ; "Demons"
				(super doChild: query)
			)
			(else
				(return query)
			)
		)
	)
)

(instance rakeeshTell of Teller
	(properties)

	(method (doVerb theVerb)
		(if (== theVerb 3) ; Walk
			(gCurRoom doVerb: 3)
		else
			(super doVerb: theVerb)
		)
	)

	(method (showDialog)
		(super
			showDialog:
				-1 ; "Tarna"
				(== local0 0)
				-2 ; "Kreesha"
				(== local0 0)
				-3 ; "Liontaurs"
				(== local0 0)
				-4 ; "Honor"
				(== local0 0)
				-7 ; "War"
				(== local0 0)
				-56 ; "Tarna"
				(== local0 1)
				-54 ; "Justice"
				(== local0 1)
				-55 ; "Crime"
				(== local0 1)
				-59 ; "Pledge"
				(== local0 1)
				-9 ; "Rajah"
				(== local0 2)
				-48 ; "Vengeance"
				(== local0 2)
				-61 ; "Spear"
				(== local0 2)
				-78 ; "Rakeesh"
				(== local0 2)
				-67 ; "Paladin"
				(== local0 3)
				-79 ; "Peace"
				(== local0 3)
				-69 ; "Spear"
				(== local0 3)
				-70 ; "Rakeesh"
				(== local0 3)
		)
	)

	(method (doChild)
		(switch query
			(-1 ; "Tarna"
				(super doChild: query)
			)
			(-4 ; "Honor"
				(super doChild: query)
			)
			(-5 ; "Bazaar"
				(super doChild: query)
			)
			(-7 ; "War"
				(super doChild: query)
			)
			(-40 ; "Demons"
				(super doChild: query)
			)
			(-9 ; "Rajah"
				(super doChild: query)
			)
			(-10 ; "Mission"
				(super doChild: query)
			)
			(-7 ; "War"
				(super doChild: query)
			)
			(-45 ; "Council"
				(super doChild: query)
			)
			(-46 ; "King"
				(super doChild: query)
			)
			(-56 ; "Tarna"
				(super doChild: query)
			)
			(-57 ; "Hordes"
				(super doChild: query)
			)
			(else
				(return query)
			)
		)
	)
)

(instance kreeshaBTalker of Talker
	(properties
		x 127
		y 59
		view 285
		talkWidth 260
		color 37
		back 57
		textX -105
		textY 150
	)

	(method (init)
		(super init: 0 0 kreeshaBMouth &rest)
	)
)

(instance kreeshaBMouth of Prop
	(properties
		x 127
		y 59
		view 285
	)
)

(instance rakeeshBTalker of Talker
	(properties
		x 149
		y 50
		view 285
		loop 1
		talkWidth 260
		back 57
		textX -120
		textY 150
	)

	(method (init)
		(super init: 0 0 rakeeshBMouth &rest)
	)
)

(instance rakeeshBMouth of Prop
	(properties
		x 149
		y 50
		view 285
		loop 1
	)
)

