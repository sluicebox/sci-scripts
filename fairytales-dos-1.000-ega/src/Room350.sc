;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 350)
(include sci.sh)
(use Main)
(use n010)
(use goGet)
(use Interface)
(use PolyPath)
(use Polygon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	Room350 0
)

(local
	[local0 200]
)

(procedure (localproc_0)
	(sign1 init:)
	(sign2 init:)
	(wall init:)
	(rock1 init:)
	(tree init:)
	(cave init:)
	(road init:)
	(rock2 init:)
)

(instance Room350 of FRoom
	(properties
		lookStr {This is an odd place for signs.}
		picture 350
		style 0
		horizon 63
		north 300
		northX 144
		northY 7
	)

	(method (init)
		(super init:)
		(gTheIconBar enable: show:)
		(localproc_0)
		(if (!= global140 2)
			(if (not (proc10_17 InvFriend))
				(ClearFlag 12)
				(Load rsVIEW 761)
				(gBookEnd
					view: 759
					setLoop: 1
					setCel: 0
					doCode: bookendDo350
					selection: 0
					setPri: 9
					posn: 270 167 30
					init:
					hide:
				)
				(gEgo selection: 0 doCode: egoDo350)
			)
			(door setPri: 10 ignoreActors: 1 init:)
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PBarredAccess
						init: 149 0 319 0 319 173 228 173 154 143 144 133 173 100 173 80 146 63 146 0
						yourself:
					)
					((Polygon new:)
						type: PBarredAccess
						init: 113 70 60 101 62 149 74 169 73 173 0 173 0 0 113 0
						yourself:
					)
			)
		else
			(gCurRoom
				addObstacle:
					((Polygon new:)
						type: PContainedAccess
						init: 155 0 107 0 101 70 69 90 36 98 62 130 62 173 244 173 262 156 287 154 283 146 182 146 144 142 150 121 178 110 197 86 145 60
						yourself:
					)
			)
		)
	)

	(method (doit)
		(super doit:)
		(if (and (== global140 2) (> (gEgo x:) 272))
			(gCurRoom newRoom: 355)
		)
	)

	(method (dispose)
		(if (== (gEgo doCode:) egoDo350)
			(gEgo doCode: 0)
		)
		(gBookEnd setPri: -1 cycleSpeed: 6 z: 0)
		(if (and (== global140 2) (> (gEgo x:) 272) (gGlobalMusic2 handle:))
			(gGlobalMusic2 fade: 0 15 12 1)
		)
		(super dispose:)
	)
)

(instance egoDo350 of Code
	(properties)

	(method (doit param1)
		(if (!= global140 2)
			(switch param1
				(5
					(gEgo setScript: egoDo350Script)
				)
			)
		)
	)
)

(instance egoDo350Script of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (or (!= (gEgo x:) 160) (!= (gEgo y:) 160))
					(gEgo setMotion: PolyPath 160 160 self)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo setHeading: 90)
				(if (not (IsFlag 12))
					(switch (gEgo selection:)
						(0
							(proc10_13
								0
								gEgo
								gBookEnd
								-1
								1
								(Format @local0 350 0 @global110) ; "Hi, I'm %s."
							)
							(Print 350 1 #title {Voice}) ; "I don't care who you are. Leave me alone."
						)
						(1
							(proc10_13 0 gEgo gBookEnd -1 1 350 2)
							(Print 350 3 #title {Voice}) ; "I'm not talking to you. Go away before I get really mad."
						)
						(2
							(proc10_13 2 gEgo gBookEnd -1 1 350 4)
							(Print 350 5 #title {Voice}) ; "I hate books. I really hate books. Go away!"
						)
						(3
							(proc10_13 3 gEgo gBookEnd -1 0 350 6)
							(proc10_13 3 gEgo gBookEnd -1 1 350 7)
							(Print 350 8 #title {Voice}) ; "You're really going to get it now!"
							(SetFlag 12)
							(gEgo selection: -1)
							(door dispose:)
							(gBookEnd
								selection: 0
								lookStr: {You see Bookend}
								show:
								setCycle: Fwd
								cycleSpeed: 16
							)
						)
					)
				else
					(switch (gEgo selection:)
						(0
							(proc10_13 1 gEgo gBookEnd -1 1 350 9)
							(proc10_13 1 gBookEnd gEgo -1 1 350 10)
							(proc10_13 1 gEgo gBookEnd -1 1 350 11)
							(proc10_13 1 gBookEnd gEgo -1 1 350 12)
						)
						(1
							(proc10_13 0 gEgo gBookEnd -1 1 350 13)
							(proc10_13 1 gBookEnd gEgo -1 0 350 14)
							(proc10_13 1 gBookEnd gEgo -1 1 350 15)
						)
						(2
							(proc10_13 2 gEgo gBookEnd -1 1 350 16)
							(proc10_13 1 gBookEnd gEgo -1 0 350 17)
							(proc10_13 1 gBookEnd gEgo -1 0 350 18)
							(proc10_13 1 gBookEnd gEgo -1 1 350 19)
							(proc10_13 0 gEgo gBookEnd -1 0 350 20)
							(proc10_13 0 gEgo gBookEnd -1 1 350 21)
							(proc10_13 1 gBookEnd gEgo -1 0 350 22)
							(proc10_13 1 gBookEnd gEgo -1 1 350 23)
						)
						(3
							(proc10_13 3 gEgo gBookEnd -1 1 350 24)
							(proc10_13 1 gBookEnd gEgo -1 1 350 25)
							(door ignoreActors: 1 init:)
							(gBookEnd lookStr: 0 cel: 0 setCycle: 0)
							(gBookEnd selection: 4)
						)
						(else
							(Print 350 26) ; "No matter what you say, Bookend doesn't say anything back."
						)
					)
				)
				(gEgo incSel:)
				(= cycles 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance bookendDo350 of Code
	(properties)

	(method (doit param1)
		(if (!= global140 2)
			(switch param1
				(5
					(gBookEnd setScript: bookendDo350Script)
				)
			)
		)
	)
)

(instance bookendDo350Script of HandsOffScript
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (or (!= (gEgo x:) 160) (!= (gEgo y:) 160))
					(gEgo setMotion: PolyPath 160 160 self)
				else
					(= cycles 1)
				)
			)
			(1
				(gEgo setHeading: 90)
				(if (not (IsFlag 12))
					(switch (gBookEnd selection:)
						(0
							(Print 350 27) ; "You hear a gruff voice from inside."
							(Print 350 28 #title {Voice}) ; "Go away!"
						)
						(1
							(Print 350 29 #title {Voice}) ; "I said, Go away!"
						)
						(2
							(Print 350 30 #title {Voice}) ; "Go home! You don't belong here. No one wants your help around here."
						)
						(3
							(Print 350 31 #title {Voice}) ; "If you don't stop bothering me, I'll come out and get you."
						)
						(4
							(Print 350 32 #title {Voice}) ; "I'm going to get you!"
							(door dispose:)
							(gBookEnd
								lookStr: {You see Bookend}
								show:
								selection: -1
								setCycle: Fwd
								cycleSpeed: 16
							)
							(proc10_13 1 gBookEnd gEgo -1 1 350 33)
							(gEgo selection: 0)
							(SetFlag 12)
						)
					)
				else
					(switch (gBookEnd selection:)
						(0
							(proc10_13 1 gBookEnd gEgo -1 1 350 34)
						)
						(1
							(proc10_13 1 gBookEnd gEgo -1 1 350 35)
						)
						(2
							(proc10_13 1 gBookEnd gEgo -1 0 350 36)
							(proc10_13 1 gBookEnd gEgo -1 1 350 37)
						)
						(3
							(proc10_13 1 gBookEnd gEgo -1 0 350 38)
							(proc10_13 1 gBookEnd gEgo -1 1 350 39)
							(door ignoreActors: 1 init:)
							(gBookEnd lookStr: 0 cel: 0 setCycle: 0)
							(gEgo selection: 4)
						)
						(else
							(Print 350 40) ; "The door does not open and Bookend doesn't speak to you."
						)
					)
				)
				(gBookEnd incSel:)
				(= cycles 1)
			)
			(2
				(self dispose:)
			)
		)
	)
)

(instance door of Prop
	(properties
		x 244
		y 159
		description {Door}
		lookStr {The door is huge and made of wood.}
		view 350
	)

	(method (doVerb theVerb)
		(switch theVerb
			(5 ; Do
				(if (proc10_17 InvFriend)
					(Print 350 41) ; "The door is locked."
				else
					(gBookEnd doVerb: theVerb &rest)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance sign1 of Feature
	(properties
		x 193
		y 127
		description {Sign}
		sightAngle 90
		onMeCheck 2
		lookStr {This sign warns you to watch for trains, but you don't see train tracks.}
	)
)

(instance sign2 of Feature
	(properties
		x 248
		y 90
		description {Sign}
		sightAngle 90
		onMeCheck 4
		lookStr {This sign warns you not to enter here.}
	)
)

(instance cave of Feature
	(properties
		x 246
		y 143
		description {Cave}
		sightAngle 90
		onMeCheck 8
		lookStr {This cave goes under the mountain.}
	)
)

(instance road of Feature
	(properties
		x 118
		y 97
		description {Road}
		sightAngle 90
		onMeCheck 16
		lookStr {The road heads north from here.}
	)
)

(instance rock1 of Feature
	(properties
		x 239
		y 50
		description {Rock}
		sightAngle 90
		onMeCheck 32
		lookStr {This rock is part of a mountain.}
	)
)

(instance tree of Feature
	(properties
		x 179
		y 46
		description {Tree}
		sightAngle 90
		onMeCheck 64
		lookStr {Trees grow here.}
	)
)

(instance wall of Feature
	(properties
		x 46
		y 50
		description {Wall}
		sightAngle 90
		onMeCheck 128
		lookStr {The wall is too tall to climb.}
	)
)

(instance rock2 of Feature
	(properties
		x 42
		y 137
		description {Rock}
		sightAngle 90
		onMeCheck 256
		lookStr {This rock is gray.}
	)
)

