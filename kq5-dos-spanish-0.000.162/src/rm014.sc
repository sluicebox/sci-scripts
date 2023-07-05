;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 14)
(include sci.sh)
(use Main)
(use Interface)
(use DLetter)
(use KQ5Room)
(use Polygon)
(use RFeature)
(use Motion)
(use Actor)
(use System)

(public
	rm014 0
)

(local
	local0
	local1
	local2
	[local3 32] = [0 1 32 109 0 6 241 145 1 0 222 113 1 4 67 179 0 1 62 109 0 6 141 145 1 0 122 113 1 4 167 179]
	[local35 8] = [144 178 168 172 194 178 154 180]
	[local43 10] = [108 137 146 135 182 138 187 146 105 146]
	[local53 12] = [146 105 156 111 140 114 56 111 22 106 60 99]
	[local65 8] = [86 178 70 180 47 178 68 172]
	[local73 10] = [243 133 281 137 283 145 207 145 211 136]
	[local83 8] = [234 104 237 112 186 111 191 105]
	[local91 10] = [0 101 65 101 67 106 37 111 0 109]
	[local101 24] = [0 0 319 0 319 125 283 117 239 121 226 115 208 115 181 110 154 114 159 120 82 124 0 123]
)

(procedure (localproc_0 param1 param2 param3)
	(if (< param1 param2 param3)
		(if (< param2 (/ (+ param1 param3) 2))
			(= param2 param1)
		else
			(= param2 param3)
		)
	)
	(return param2)
)

(procedure (localproc_1 param1 param2 param3)
	(if (< param2 param1)
		(= param2 param1)
	)
	(if (> param2 param3)
		(= param2 param3)
	)
	(return param2)
)

(procedure (localproc_2 &tmp temp0)
	(gGame setCursor: gWaitCursor 1)
	(gEgo setMotion: 0 setCycle: 0)
	(RedrawCast)
	(gAddToPics dispose:)
	(gFeatures eachElementDo: #dispose release:)
	(if (IsObject roadRunner)
		(roadRunner dispose:)
	)
	(gCurRoom drawPic: 14)
	(switch local1
		(1
			(gEgo posn: (gEgo x:) 186)
			(-- global315)
		)
		(else
			(gEgo
				posn:
					(localproc_1 70 (localproc_0 183 (gEgo y:) 255) 320)
					109
			)
			(++ global315)
		)
	)
	(hills1 view: 352 loop: 2 cel: 0 x: 122 y: 47 signal: 1)
	(switch global315
		(1
			(gCurRoom west: 212)
			(gCurRoom east: 13)
			(gCurRoom south: 0)
			(= temp0 100)
			(hills1 view: 349 loop: 0 cel: 0 x: 80 y: 122 signal: 16384)
			(hills2 view: 349 loop: 0 cel: 1 x: 232 y: 120 signal: 16384)
			(trees priority: 1 x: 264)
			(gAddToPics add: trees hills1 hills2 doit:)
			(gCurRoom setFeatures: hills1 hills2 thatRoom thisRoom)
			(gCurRoom obstacles: polyList13)
		)
		(2
			(trees priority: 3 x: 234)
			(gCurRoom east: 12)
			(gCurRoom west: 15)
			(gCurRoom south: 0)
			(= temp0 0)
			(gAddToPics add: hills1)
			(gCurRoom setFeatures: hills1 thisRoom)
			(gCurRoom obstacles: polyList12)
		)
		(3
			(trees x: 294)
			(gCurRoom east: 11)
			(gCurRoom west: 15)
			(gCurRoom south: 211)
			(= temp0 16)
			(gCurRoom setFeatures: thisRoom)
			(gCurRoom obstacles: polyList11)
		)
	)
	(if (!= temp0 100)
		(rock1
			loop: [local3 temp0]
			cel: [local3 (+ temp0 1)]
			x: [local3 (+ temp0 2)]
			y: [local3 (+ temp0 3)]
		)
		(rock2
			loop: [local3 (+ temp0 4)]
			cel: [local3 (+ temp0 5)]
			x: [local3 (+ temp0 6)]
			y: [local3 (+ temp0 7)]
		)
		(rock3
			loop: [local3 (+ temp0 8)]
			cel: [local3 (+ temp0 9)]
			x: [local3 (+ temp0 10)]
			y: [local3 (+ temp0 11)]
		)
		(rock4
			loop: [local3 (+ temp0 12)]
			cel: [local3 (+ temp0 13)]
			x: [local3 (+ temp0 14)]
			y: [local3 (+ temp0 15)]
		)
		(gAddToPics add: trees rock1 rock2 rock3 rock4 doit:)
	)
	(gEgo forceUpd:)
	((gEgo head:)
		x: (gEgo x:)
		y: (gEgo y:)
		z: (CelHigh (gEgo view:) (gEgo loop:) (gEgo cel:))
	)
	(= local1 0)
	(gEgo edgeHit: 0)
	(= local0 0)
	(switch local1
		(1
			(gEgo loop: 11 cel: 3)
		)
		(else
			(gEgo loop: 11 cel: 2)
		)
	)
	(gGame setCursor: ((gTheIconBar curIcon:) cursor:) 1)
)

(instance rm014 of KQ5Room
	(properties
		picture 14
		horizon 90
		west 15
	)

	(method (init &tmp temp0)
		(super init:)
		(cond
			(
				(or
					(== gPrevRoomNum 13)
					(and
						(== global315 1)
						(or (== gPrevRoomNum 15) (== gPrevRoomNum 212))
					)
				)
				(= global315 1)
				(= west 212)
				(= east 13)
				(= temp0 100)
				(hills1 view: 349 loop: 0 cel: 0 x: 80 y: 122 signal: 16384)
				(hills2 view: 349 loop: 0 cel: 1 x: 232 y: 120 signal: 16384)
				(trees priority: 1 x: 264 signal: 16384)
				(self setFeatures: hills1 hills2 thatRoom thisRoom)
				(gAddToPics add: trees hills1 hills2 doit:)
				(gCurRoom obstacles: polyList13)
			)
			((or (== gPrevRoomNum 12) (and (== global315 2) (== gPrevRoomNum 15)))
				(= global315 2)
				(= east 12)
				(= temp0 0)
				(gAddToPics add: hills1)
				(gCurRoom obstacles: polyList12)
				(self setFeatures: thisRoom)
			)
			((or (== gPrevRoomNum 11) (and (== global315 3) (== gPrevRoomNum 15)))
				(trees x: 294)
				(= global315 3)
				(= east 11)
				(= south 211)
				(= temp0 16)
				(gCurRoom obstacles: polyList11)
				(self setFeatures: thisRoom)
			)
		)
		(if (!= temp0 100)
			(rock1
				loop: [local3 temp0]
				cel: [local3 (+ temp0 1)]
				x: [local3 (+ temp0 2)]
				y: [local3 (+ temp0 3)]
			)
			(rock2
				loop: [local3 (+ temp0 4)]
				cel: [local3 (+ temp0 5)]
				x: [local3 (+ temp0 6)]
				y: [local3 (+ temp0 7)]
			)
			(rock3
				loop: [local3 (+ temp0 8)]
				cel: [local3 (+ temp0 9)]
				x: [local3 (+ temp0 10)]
				y: [local3 (+ temp0 11)]
			)
			(rock4
				loop: [local3 (+ temp0 12)]
				cel: [local3 (+ temp0 13)]
				x: [local3 (+ temp0 14)]
				y: [local3 (+ temp0 15)]
			)
			(gAddToPics add: trees rock1 rock2 rock3 rock4 doit:)
		)
		(gEgo view: 0 y: 150 setPri: -1 ignoreHorizon: 1 init:)
		(poly1 points: @local35 size: 4)
		(poly2 points: @local43 size: 5)
		(poly3 points: @local53 size: 6)
		(poly4 points: @local65 size: 4)
		(poly5 points: @local73 size: 5)
		(poly6 points: @local83 size: 4)
		(poly7 points: @local91 size: 5)
		(poly8 points: @local101 size: 12)
		(polyList11 add: poly1 poly2 poly3)
		(polyList12 add: poly4 poly5 poly6 poly7)
		(polyList13 add: poly8)
		(gGlobalSound
			number: 24
			loop: -1
			play: (if (< (gEgo x:) 160) 40 else 112)
		)
		(gGlobalSound2
			number: 3
			loop: -1
			play: (if (< (gEgo x:) 160) 112 else 20)
		)
		(gGlobalSound3
			number: 2
			loop: -1
			play: (if (< (gEgo x:) 160) 112 else 20)
		)
	)

	(method (doit)
		(cond
			((< (gEgo x:) 120)
				(gGlobalSound fade: 40 1 1 0)
				(gGlobalSound2 fade: 112 1 1 0)
				(gGlobalSound3 fade: 112 1 1 0)
			)
			((> (gEgo x:) 240)
				(gGlobalSound fade: 112 1 1 0)
				(gGlobalSound2 fade: 20 1 1 0)
				(gGlobalSound3 fade: 20 1 1 0)
			)
			(else
				(gGlobalSound fade: 80 1 1 0)
				(gGlobalSound2 fade: 80 1 1 0)
				(gGlobalSound3 fade: 80 1 1 0)
			)
		)
		(cond
			(script
				(script doit:)
			)
			((and (not local0) (= local1 (gEgo edgeHit:)))
				(if (== gPrevRoomNum east)
					(= global322 0)
				)
				(= local0 1)
				(switch local1
					(1
						(localproc_2)
						(gEgo setCycle: KQ5SyncWalk)
					)
					(3
						(if south
							(gCurRoom newRoom: south)
						else
							(localproc_2)
							(gEgo setCycle: KQ5SyncWalk)
						)
					)
					(2
						(gGlobalSound2 fade:)
						(gGlobalSound3 fade:)
						(gCurRoom newRoom: east)
					)
					(4
						(gGlobalSound fade:)
						(= global314 1)
						(gCurRoom newRoom: west)
					)
				)
			)
			(
				(and
					(== (gCurRoom obstacles:) polyList12)
					(> 250 (gEgo x:) 200)
					(not local2)
					(not (roadRunner script:))
					(not (Random 0 100))
				)
				(= local2 1)
				(run register: (if (< (gEgo y:) 130) 165 else 95))
				(roadRunner init: setScript: run)
			)
		)
	)

	(method (handleEvent event)
		(cond
			((event claimed:)
				(return)
			)
			(script
				(return)
			)
		)
	)

	(method (dispose)
		(polyList11 dispose:)
		(polyList12 dispose:)
		(polyList13 dispose:)
		(super dispose:)
	)
)

(instance run of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(roadRunner
					x: -20
					y: register
					setLoop: 10
					setCycle: Fwd
					cycleSpeed: 0
					setMotion: MoveTo 340 register self
				)
			)
			(1
				(roadRunner dispose:)
				(self dispose:)
			)
		)
	)
)

(instance thisRoom of RFeature
	(properties
		nsBottom 200
		nsRight 320
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 14 0) ; "The scraggly bushes of the brushland taper off to dry, sandy desert as far as the eye can see to the west."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance thatRoom of RFeature
	(properties)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (& (OnControl CONTROL (event x:) (event y:)) $0002))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 14 1) ; "Beyond the large boulders, Graham can see the brushland extending to the north for many miles."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance trees of RPicView
	(properties
		x 234
		y 53
		view 352
		cel 3
		priority 3
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 14 2) ; "The woods meet the desert here in the scrubby brushland."
					(event claimed: 1)
				)
			)
		)
	)
)

(instance hills1 of RPicView
	(properties
		x 122
		y 47
		view 352
		loop 2
		priority 2
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(switch (gCurRoom east:)
						(13
							(PrintDC 14 3) ; "A rocky cliff ending in a string of huge boulders blocks travel to the north from here."
						)
						(12
							(PrintDC 14 4) ; "In the distance to the north, rocky cliffs loom like sentinels across the barren desert."
						)
					)
					(event claimed: 1)
				)
				(3 ; Do
					(if (== (gCurRoom east:) 13)
						(PrintDC 14 5) ; "The cliff is too steep. Graham could never climb it!"
						(event claimed: 1)
					)
				)
			)
		)
	)
)

(instance hills2 of RPicView
	(properties
		x 197
		y 49
		view 352
		loop 2
		cel 1
		priority 2
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
				(& (OnControl CONTROL (event x:) (event y:)) $0002)
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 14 6) ; "A rocky cliff ending in a string of huge boulders blocks travel to the north from here."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 14 5) ; "The cliff is too steep. Graham could never climb it!"
					(event claimed: 1)
				)
			)
		)
	)
)

(instance rock1 of RPicView
	(properties
		x 50
		y 112
		view 352
		signal 16384
	)
)

(instance rock2 of RPicView
	(properties
		x 126
		y 105
		view 352
		cel 1
		signal 16384
	)
)

(instance rock3 of RPicView
	(properties
		x 177
		y 107
		view 352
		loop 1
		signal 16384
	)
)

(instance rock4 of RPicView
	(properties
		x 227
		y 104
		view 352
		loop 1
		cel 6
		signal 16384
	)
)

(instance roadRunner of Actor
	(properties
		view 352
		signal 24576
	)

	(method (handleEvent event)
		(if
			(or
				(event claimed:)
				(not (== (event type:) evVERB))
				(not (MousedOn self event))
			)
			(return)
		else
			(switch (event message:)
				(2 ; Look
					(PrintDC 14 7) ; "It looks like something's after him."
					(event claimed: 1)
				)
				(3 ; Do
					(PrintDC 14 8) ; "Beep! Beep!"
					(event claimed: 1)
				)
			)
		)
	)
)

(instance bush1 of Prop ; UNUSED
	(properties)
)

(instance polyList11 of List
	(properties)
)

(instance polyList12 of List
	(properties)
)

(instance polyList13 of List
	(properties)
)

(instance poly1 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly2 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly3 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly4 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly5 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly6 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly7 of Polygon
	(properties
		type PBarredAccess
	)
)

(instance poly8 of Polygon
	(properties
		type PBarredAccess
	)
)

