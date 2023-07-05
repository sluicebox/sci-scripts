;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 24)
(include sci.sh)
(use Main)
(use InvInitialize)
(use n1111)
(use Interface)
(use Array)
(use Print)
(use Game)

(public
	whereTo 0
)

(procedure (localproc_0 param1)
	(switch param1
		(6000
			(= global413 4)
			(SetFlag 234)
			(SetFlag 246)
		)
		(2015
			(proc70_1 37 1)
			(proc70_1 104 1)
			(proc70_1 47 1)
			(proc70_1 40 1)
			(proc70_1 80 1)
			(SetFlag 61)
		)
		(4000
			(proc70_1 64 1)
			(proc70_1 67 1)
			(proc70_1 70 1)
			(proc70_1 73 1)
			(proc70_1 76 1)
			(proc70_1 49 1)
			(proc70_1 52 1)
			(proc70_1 55 1)
			(proc70_1 58 1)
			(proc70_1 61 1)
			(proc70_1 114 1)
			(= global266 0)
			(= global267 0)
			(= global268 0)
		)
		(4004
			(= global266 0)
			(= global267 0)
			(= global268 0)
			(= global269 1)
			(SetFlag 34)
			(proc70_1 64 1)
			(proc70_1 67 1)
			(proc70_1 70 1)
			(proc70_1 73 1)
			(proc70_1 76 1)
			(proc70_1 49 1)
			(proc70_1 52 1)
			(proc70_1 55 1)
			(proc70_1 58 1)
			(proc70_1 61 1)
			(proc70_1 114 1)
		)
		(4104
			(= global266 0)
			(= global267 0)
			(= global268 0)
			(= global269 2)
			(SetFlag 36)
			(proc70_1 41 1)
			(proc70_1 64 1)
			(proc70_1 67 1)
			(proc70_1 70 1)
			(proc70_1 73 1)
			(proc70_1 76 1)
			(proc70_1 49 1)
			(proc70_1 52 1)
			(proc70_1 55 1)
			(proc70_1 58 1)
			(proc70_1 61 1)
			(proc70_1 114 1)
		)
		(4012
			(= global266 0)
			(= global267 0)
			(= global268 0)
			(= global269 1)
			(SetFlag 39)
			(proc70_1 114 1)
			(proc70_1 41 1)
			(proc70_1 64 1)
			(proc70_1 67 1)
			(proc70_1 70 1)
			(proc70_1 73 1)
			(proc70_1 76 1)
			(proc70_1 49 1)
			(proc70_1 52 1)
			(proc70_1 55 1)
			(proc70_1 58 1)
			(proc70_1 61 1)
		)
		(4112
			(= global266 0)
			(= global267 0)
			(= global268 0)
			(= global269 2)
			(SetFlag 36)
			(SetFlag 40)
			(SetFlag 39)
			(proc70_1 114 1)
			(proc70_1 41 1)
			(proc70_1 42 1)
			(proc70_1 64 1)
			(proc70_1 67 1)
			(proc70_1 70 1)
			(proc70_1 73 1)
			(proc70_1 76 1)
			(proc70_1 49 1)
			(proc70_1 52 1)
			(proc70_1 55 1)
			(proc70_1 58 1)
			(proc70_1 61 1)
		)
		(4212
			(= global269 3)
			(= global266 0)
			(= global267 0)
			(= global268 0)
			(proc70_1 114 1)
			(proc70_1 41 1)
			(proc70_1 42 1)
			(proc70_1 43 1)
			(SetFlag 36)
			(SetFlag 37)
			(SetFlag 41)
			(SetFlag 40)
			(SetFlag 39)
		)
		(7015
			((ScriptID 201 0) setBombTimer:) ; newYorkRegion
			(proc70_1 114 1)
			(proc70_1 33 1)
			(proc70_1 103 1)
			(proc70_1 99 1)
			(proc70_1 97 1)
			(proc70_1 100 1)
		)
		(7800
			((ScriptID 201 0) setBombTimer:) ; newYorkRegion
			(SetFlag 181)
			(SetFlag 185)
			(SetFlag 195)
			(proc70_1 114 1)
			(proc70_1 33 1)
			(proc70_1 101 1)
			(proc70_1 103 1)
			(proc70_1 99 1)
		)
		(7600
			((ScriptID 201 0) setBombTimer:) ; newYorkRegion
			(SetFlag 181)
			(SetFlag 195)
			(proc70_1 114 1)
			(proc70_1 33 1)
			(proc70_1 101 1)
			(proc70_1 103 1)
			(proc70_1 99 1)
		)
		(7900
			((ScriptID 201 0) setBombTimer:) ; newYorkRegion
			(proc70_1 33 1)
			(proc70_1 89 1)
			(proc70_1 114 1)
			(SetFlag 181)
			(SetFlag 184)
			(proc70_1 103 1)
			(proc70_1 99 1)
		)
		(7700
			((ScriptID 201 0) setBombTimer:) ; newYorkRegion
			(SetFlag 181)
			(SetFlag 184)
			(proc70_1 114 1)
			(proc70_1 33 1)
			(proc70_1 103 1)
			(proc70_1 99 1)
		)
		(7909
			(SetFlag 181)
			(SetFlag 184)
			(proc70_10 33 7909)
			(proc70_10 89 7909)
			((ScriptID 201 0) setBombTimer:) ; newYorkRegion
			(proc70_1 103 1)
			(proc70_1 99 1)
		)
		(5006
			(proc70_1 45 1)
			(proc70_1 1 1)
			(proc70_1 47 1)
			(proc70_1 37 1)
			(proc70_1 104 1)
			(proc70_1 39 1)
		)
		(5204
			(proc70_1 45 1)
			(proc70_1 47 1)
			(proc70_1 37 1)
			(proc70_1 104 1)
			(proc70_1 5 1)
			(proc70_1 118 1)
		)
		(5309
			(proc70_1 45 1)
			(proc70_1 47 1)
			(proc70_1 37 1)
			(proc70_1 104 1)
		)
		(8000
			(proc70_1 16 1)
			(proc70_1 39 1)
			(SetFlag 156)
			((ScriptID 201 0) setBombTimer:) ; newYorkRegion
		)
		(8020
			(proc70_1 16 1)
			(proc70_1 39 1)
			(SetFlag 158)
			(SetFlag 155)
			(SetFlag 156)
			((ScriptID 201 0) setBombTimer:) ; newYorkRegion
		)
		(8110
			(SetFlag 155)
			(SetFlag 156)
			(proc70_1 39 1)
			(SetFlag 154)
			((ScriptID 201 0) setBombTimer:) ; newYorkRegion
		)
		(5700
			(proc70_1 45 1)
			(proc70_1 1 1)
			(proc70_1 47 1)
			(proc70_1 37 1)
			(proc70_1 104 1)
			(proc70_1 40 1)
			(proc70_1 39 1)
		)
	)
	(gCurRoom newRoom: param1)
)

(instance whereTo of Room
	(properties)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp3 (IntArray with: 0 0 0 0))
		(super init:)
		(gTheCursor show:)
		(Text 0 (temp3 data:) {A} gUserFont 320)
		(= temp2 (+ (temp3 at: 3) 6))
		(switch
			(= temp0
				((Print new:)
					addTitle: {RAMA Room Choices}
					mode: 1
					addText: {Where To?} 0 (* 0 temp2)
					addButton: 0 {Avian Lair} 0 (* 2 temp2)
					addButton: 4 {Bangkok} 0 (* 4 temp2)
					addButton: 7 {BaseCamp} 0 (* 6 temp2)
					addButton: 5 {Central Plain} 0 (* 8 temp2)
					addButton: 2 {Hub Camp} 0 (* 10 temp2)
					addButton: 12 {Human Lair} 0 (* 12 temp2)
					addButton: 9 {London} 0 (* 14 temp2)
					addButton: 8 {New York} 0 (* 16 temp2)
					addButton: 1 {OctoSpider Lair} 0 (* 18 temp2)
					addButton: 10 {VMD Tester} 0 (* 20 temp2)
					addButton: 11 {Teleport} 0 (* 22 temp2)
					addButton: 6 {Quit} 0 (* 24 temp2)
					init:
				)
			)
			(0
				(localproc_0
					((Print new:)
						mode: 1
						addTitle: {Avian Lair}
						addText: {Where To?} 0 (* 0 temp2)
						addButton: 6404 {BackStage} 0 (* 2 temp2)
						addButton: 6111 {Cistern} 0 (* 3 temp2)
						addButton: 6200 {Great Hall} 0 (* 4 temp2)
						addButton: 6802 {Hatchery} 0 (* 5 temp2)
						addButton: 6611 {Mirmicat Desk} 0 (* 6 temp2)
						addButton: 6510 {Mirmicat Hall} 0 (* 7 temp2)
						addButton: 6901 {Mirmicat Pools} 0 (* 8 temp2)
						addButton: 6002 {Right Hand Shaft} 0 (* 9 temp2)
						addButton: 6001 {Left Hand Shaft} 0 (* 10 temp2)
						addButton: 6101 {Security} 0 (* 11 temp2)
						addButton: 6600 {School} 0 (* 12 temp2)
						addButton: 6000 {Top of Shaft} 0 (* 13 temp2)
						addButton: 6400 {Theatre} 0 (* 14 temp2)
						init:
					)
				)
			)
			(4
				(localproc_0
					((Print new:)
						mode: 1
						addTitle: {Bangkok}
						addText: {Where To?} 10 (* 0 temp2)
						addButton: 4000 {Outside Bangkok Porch} 0 (* 2 temp2)
						addButton: 4004 {Level 1 CountingRoom} 0 (* 4 temp2)
						addButton: 4104 {Level 2 CountingRoom} 0 (* 6 temp2)
						addButton: 4012 {Level 1 Museum} 0 (* 8 temp2)
						addButton: 4112 {Level 2 Museum} 0 (* 10 temp2)
						addButton: 4212 {Level 3 Museum} 0 (* 12 temp2)
						init:
					)
				)
			)
			(5
				(switch
					(= temp1
						((Print new:)
							addTitle: {Central Plain}
							mode: 1
							addText: {Where To?} 10 (* 0 temp2)
							addButton: 2000 {Plains} 0 (* 2 temp2)
							addButton: 2080 {Bangkok Region} 0 (* 3 temp2)
							addButton: 2040 {Beam Region} 0 (* 4 temp2)
							addButton: 2100 {Iceport Region} 0 (* 5 temp2)
							addButton: 2060 {London Region} 0 (* 6 temp2)
							addButton: 2014 {Wheel Region} 0 (* 7 temp2)
							init:
						)
					)
					(2014
						(localproc_0
							((Print new:)
								addTitle: {Wheel Region}
								mode: 1
								addText: {Where To?} 10 (* 0 temp2)
								addButton: 2014 {Entrance} 0 (* 2 temp2)
								addButton: 2015 {Ruined Biot} 0 (* 4 temp2)
								init:
							)
						)
					)
					(else
						(localproc_0 temp1)
					)
				)
			)
			(1
				(localproc_0
					((Print new:)
						mode: 1
						addTitle: {Octospider Lair}
						addText: {Where To?} 0 (* 0 temp2)
						addButton: 7015 {Entrance to Lair} 0 (* 2 temp2)
						addButton: 7000 {Atrium} 0 (* 4 temp2)
						addButton: 7500 {Cistern} 0 (* 6 temp2)
						addButton: 7600 {Museum} 0 (* 8 temp2)
						addButton: 7700 {Pit} 0 (* 10 temp2)
						addButton: 7900 {Subway} 0 (* 12 temp2)
						addButton: 7800 {Teacher's Office} 0 (* 14 temp2)
						addButton: 7909 {Small Subway Car} 0 (* 16 temp2)
						init:
					)
				)
			)
			(2
				(localproc_0
					((Print new:)
						addTitle: {Hub Camp}
						mode: 1
						addText: {Where To?} 10 (* 0 temp2)
						addButton: 1009 {Bomb} 0 (* 2 temp2)
						addButton: 1000 {Camp} 0 (* 3 temp2)
						addButton: 1004 {Computer} 0 (* 4 temp2)
						addButton: 1002 {Locker} 0 (* 5 temp2)
						init:
					)
				)
			)
			(7
				(localproc_0 2004)
			)
			(8
				(localproc_0
					((Print new:)
						addTitle: {New York}
						mode: 1
						addText: {Where To?} 10 (* 0 temp2)
						addButton: 5006 {Avian Plaza} 0 (* 2 temp2)
						addButton: 5204 {Human Plaza} 0 (* 3 temp2)
						addButton: 5700 {New York Gate} 0 (* 4 temp2)
						addButton: 5309 {Octospider Plaza} 0 (* 5 temp2)
						addButton: 5401 {Subway} 0 (* 6 temp2)
						init:
					)
				)
			)
			(9
				(localproc_0 3001)
			)
			(10
				(localproc_0 17)
			)
			(11
				(if (ResCheck rsSCRIPT (= temp4 (GetNumber {Teleport to:})))
					(if gCurRoom
						(gCurRoom newRoom: temp4)
					else
						(gRegions eachElementDo: #newRoom temp4)
						(= gNewRoomNum temp4)
					)
				)
			)
			(12
				(localproc_0
					((Print new:)
						addTitle: {Human Lair}
						mode: 1
						addText: {Where To?} 10 (* 0 temp2)
						addButton: 8000 {Entrance Into Lair} 0 (* 2 temp2)
						addButton: 8020 {Main Hall} 0 (* 3 temp2)
						addButton: 8110 {Bomb} 0 (* 4 temp2)
						init:
					)
				)
			)
			(6
				(= gQuit 1)
			)
		)
	)
)

