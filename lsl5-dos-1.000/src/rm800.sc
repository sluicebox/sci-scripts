;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 800)
(include sci.sh)
(use Main)
(use eRS)
(use Door)
(use Interface)
(use RandCycle)
(use Polygon)
(use Feature)
(use LoadMany)
(use Motion)
(use Actor)
(use System)

(public
	rm800 0
)

(local
	seenMsg
)

(instance rm800 of LLRoom
	(properties
		lookStr {You are outside the studios of `K-Rap Radio.' It appears to be an amazingly small building for a station of such importance.}
		picture 800
		north 820
	)

	(method (init)
		(LoadMany rsVIEW 800 810 571)
		(LoadMany rsSOUND 800 801 802 191 192)
		(super init:)
		(switch gPrevRoomNum
			(820
				(self style: 9)
				(gEgo
					init:
					normalize: 571
					posn: 153 143
					setHeading: 180
					edgeHit: 0
				)
				(gTheMusic setVol: gLastVolume)
				(HandsOn)
			)
			(200
				(gTheMusic stop:)
				(WrapMusic firstSound: 800 lastSound: 802 init:)
				(self style: 7)
				(self setScript: sExitLimo)
			)
			(else
				(gTheMusic stop:)
				(WrapMusic firstSound: 800 lastSound: 802 init:)
				(= gLastVolume (gTheMusic vol:))
				(if (== gNumColors 256)
					(self style: 9)
				else
					(self style: 8)
				)
				(gEgo
					init:
					normalize: 571
					posn: 155 153
					setHeading: 180
					edgeHit: 0
				)
				(HandsOn)
				(self setScript: exitDreamScript)
			)
		)
		(bush1 init:)
		(bush2 init:)
		(bush3 init:)
		(bush4 init:)
		(drumpicture init:)
		(tower init:)
		(tree1 init:)
		(limo init: approachVerbs: 3 4) ; Do, Inventory
		(door init: openScript: sIntoBuilding)
		(neonSign init:)
		(cone1 init:)
		(cone2 init:)
		(gCast eachElementDo: #checkDetail)
		(gCurRoom
			addObstacle:
				((Polygon new:)
					type: PBarredAccess
					init: 0 0 139 0 139 144 5 147 5 153 10 156 78 156 103 153 129 152 143 162 184 162 184 154 200 151 282 149 294 148 314 144 253 143 167 143 167 0 319 0 319 189 0 189
					yourself:
				)
		)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 820)
			(gEgo edgeHit: 1)
		)
		(if gModelessDialog
			(gModelessDialog dispose:)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance limo of Feature
	(properties
		x 62
		y 161
		nsTop 148
		nsBottom 174
		nsRight 125
		description {your limousine}
		approachX 26
		approachY 152
		lookStr {Your limousine awaits your return.}
	)

	(method (doVerb theVerb)
		(switch theVerb
			(3 ; Do
				(rm800 setScript: sEnterLimo)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance neonSign of Prop
	(properties
		x 156
		y 27
		description {the K-RAP sign}
		lookStr {High above your head, K-RAP's neon sign illuminates the Baltimore night.}
		view 800
		cel 8
		detailLevel 3
	)

	(method (init)
		(super init:)
		(self setCycle: Fwd checkDetail:)
	)
)

(instance door of Door
	(properties
		x 153
		y 138
		description {the door}
		approachX 153
		approachY 144
		lookStr {K-RAP's doors are always open.}
		view 800
		loop 1
		priority 9
		signal 16
		entranceTo 820
		moveToX 153
		moveToY 140
		enterType 0
		exitType 0
	)
)

(instance cone1 of Prop
	(properties
		x 71
		y 118
		description {the left speaker}
		lookStr {K-RAP's loudspeakers broadcast the station's current programming.}
		view 800
		loop 2
		detailLevel 5
	)

	(method (init)
		(super init:)
		(self setCycle: RandCycle checkDetail:)
	)
)

(instance cone2 of Prop
	(properties
		x 235
		y 114
		description {the right speaker}
		lookStr {K-RAP's loudspeakers broadcast the station's current programming.}
		view 800
		loop 3
		detailLevel 5
	)

	(method (init)
		(super init:)
		(self setCycle: RandCycle checkDetail:)
	)
)

(instance bush1 of Feature
	(properties
		x 50
		y 136
		nsTop 125
		nsLeft 36
		nsBottom 147
		nsRight 64
		description {the bush}
		sightAngle 40
		lookStr {Someone planted these bushes right in the middle of this busy sidewalk!}
	)
)

(instance bush2 of Feature
	(properties
		x 107
		y 135
		nsTop 123
		nsLeft 89
		nsBottom 148
		nsRight 125
		description {the bush}
		sightAngle 40
		lookStr {Someone planted these bushes right in the middle of this busy sidewalk!}
	)
)

(instance bush3 of Feature
	(properties
		x 210
		y 134
		nsTop 117
		nsLeft 196
		nsBottom 151
		nsRight 224
		description {the bush}
		sightAngle 40
		lookStr {Someone planted these bushes right in the middle of this busy sidewalk!}
	)
)

(instance bush4 of Feature
	(properties
		x 283
		y 123
		nsTop 95
		nsLeft 268
		nsBottom 151
		nsRight 299
		description {the bush}
		sightAngle 40
		lookStr {Someone planted these bushes right in the middle of this busy sidewalk!}
	)
)

(instance drumpicture of Feature
	(properties
		x 161
		y 81
		nsTop 65
		nsLeft 112
		nsBottom 98
		nsRight 210
		description {the mural}
		sightAngle 40
		lookStr {K-RAP radio has a mural of musicians on their wall.}
	)
)

(instance tower of Feature
	(properties
		x 262
		y 36
		nsLeft 225
		nsBottom 90
		nsRight 303
		description {the tower}
		sightAngle 40
		lookStr {The tower holds the antennas that broadcast K-RAP's stereo multiplexed signal to millions of people (some of whom listen!).}
	)
)

(instance tree1 of Feature
	(properties
		x 24
		y 92
		nsTop 44
		nsBottom 141
		nsRight 49
		description {the trees}
		sightAngle 40
		lookStr {A clump of white birch trees grows just outside K-RAP.}
	)
)

(instance logo of Prop
	(properties
		x 164
		y 37
		view 810
		cel 12
		cycleSpeed 12
		detailLevel 3
	)
)

(instance city1 of Prop
	(properties
		x 38
		y 59
		view 810
		loop 2
		cycleSpeed 24
		detailLevel 5
	)
)

(instance city2 of Prop
	(properties
		x 193
		y 53
		view 810
		loop 3
		cycleSpeed 24
		detailLevel 5
	)
)

(instance plane of Actor
	(properties
		x 96
		y 13
		view 810
		loop 1
		moveSpeed 22
	)
)

(instance sIntoBuilding of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(gEgo hide:)
				(HandsOff)
				(gCast eachElementDo: #hide)
				(SetFFRoom 820)
				(if (not (IsFlag 26))
					(rm800 style: 7)
					(gCurRoom drawPic: 810 picture: 810 curPic: 810)
					(logo init: setCycle: Fwd)
					(city1 init: setCycle: Fwd)
					(city2 init: setCycle: Fwd)
					(plane
						init:
						setCycle: Fwd
						setMotion: MoveTo -20 5
						setStep: 1 1
					)
					(gCast eachElementDo: #checkDetail)
					(SetFlag 26)
					(= seconds 5)
				else
					(gCurRoom newRoom: 820)
				)
			)
			(1
				(TPrint 800 0 67 -1 185 70 280 108 self) ; "Although you can't see it, the K-RAP building is quite impressive when viewed from the opposite side."
			)
			(2
				(= ticks 180)
			)
			(3
				(TPrint 800 1 67 -1 185 70 280 108 self) ; "From the tiny top floor you just entered, it stretches hundreds of feet down the hillside, in a series of cascading terraces, gardens, and patios."
			)
			(4
				(= ticks 180)
			)
			(5
				(TPrint 800 2 67 -1 185 70 280 108 self) ; "Obviously, there's more to this place than meets the eye!"
			)
			(6
				(= ticks 180)
			)
			(7
				(gCurRoom newRoom: 820)
			)
		)
	)
)

(instance exitDreamScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds 6)
			)
			(1
				(self dispose:)
				(if
					(Print ; "Now would be an excellent time for you to save your game, Patti."
						800
						3
						#button
						{Save}
						1
						#button
						{Nah, Why Bother?}
						0
						#title
						{AL says}
						#at
						-1
						20
					)
					(gGame save:)
				)
			)
		)
	)
)

(instance sExitLimo of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(= cycles 2)
			)
			(1
				(HandsOff)
				(gTheMusic2 number: 191 setLoop: 1 play:)
				(= ticks 50)
			)
			(2
				(gEgo
					init:
					normalize: 571
					posn: 26 174
					setHeading: 0
					edgeHit: 0
				)
				(= ticks 123)
			)
			(3
				(gTheMusic2 number: 192 setLoop: 1 play:)
				(gEgo setMotion: MoveTo 26 152 self)
			)
			(4
				(HandsOn)
				(gEgo normalize: 571 setLoop: -1 setHeading: 0)
				(self dispose:)
			)
		)
	)
)

(instance sEnterLimo of Script
	(properties)

	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(HandsOff)
				(gEgo setLoop: -1 setHeading: 180 self)
			)
			(1
				(gEgo setMotion: MoveTo 26 174 self)
			)
			(2
				(gTheMusic2 number: 191 setLoop: 1 play:)
				(= ticks 50)
			)
			(3
				(gEgo hide:)
				(gTheMusic2 number: 192 setLoop: 1 play:)
				(= ticks 100)
			)
			(4
				(gTheMusic fade: 0 15 12 1)
				(gCurRoom newRoom: 200)
			)
		)
	)
)

