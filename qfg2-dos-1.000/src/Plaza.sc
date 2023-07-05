;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 80)
(include sci.sh)
(use Main)
(use n001)
(use Stage)
(use Feature)
(use LoadMany)
(use Actor)
(use System)

(public
	IsElementalInRoom 0
)

(procedure (IsElementalInRoom theRoom &tmp aRoom)
	(return
		(not
			(and
				(or
					(!= (= aRoom (if argc theRoom else gCurRoomNum)) 300)
					(and (!= gElementalState 1) (!= gDay 4))
				)
				(or (and (!= aRoom 310) (!= aRoom 315)) (!= gElementalState 7))
				(or (!= aRoom 335) (!= gElementalState 3))
			)
		)
	)
)

(class Plaza of Stage
	(properties
		picture 300
		horizon 82
		topFromX 160
		topFromY 80
		topToX 160
		topToY 100
		bottomFromX 160
		bottomFromY 250
		bottomToX 160
		bottomToY 188
		rightFromX 330
		rightFromY 162
		rightToX 310
		rightToY 162
		leftFromX -10
		leftFromY 162
		leftToX 10
		leftToY 162
		merchants 0
		xIn 0
		yIn 0
		xOut 0
		yOut 0
	)

	(method (init)
		(if (and (<= 0 gTimeODay 4) (not (IsElementalInRoom)))
			(LoadMany rsVIEW 357 351 358 352 359 353)
		else
			(= gSpellChecker gAllChecker)
		)
		(gEgo init:)
		((= merchants (List new:)) add:)
		(if (not (IsElementalInRoom))
			(if (<= 0 gTimeODay 4)
				(if (and (>= gHowFast 2) (>= gHowMuchMemory 1))
					((ScriptID 89 1) init:) ; dayPlazaGuard
					((ScriptID 83 0) init:) ; fred
				)
			else
				((ScriptID 89 0) init:) ; nightPlazaGuard
			)
		)
		(super init:)
		(if (== gCurRoomNum 300) ; rmSPlazaGates
			(self overlay: 305)
		else
			(self overlay: gCurRoomNum)
		)
		(InitFeatures topAlleyDoor)
		(if (not west)
			(InitAddToPics leftDoorBlock)
		else
			(InitFeatures leftAlleyDoor)
		)
		(if (not east)
			(InitAddToPics rightDoorBlock)
		else
			(InitFeatures rightAlleyDoor)
		)
	)

	(method (handleEvent event)
		(cond
			((super handleEvent: event))
			(
				(or
					(Said 'search,look,look[<at,around][/room,area][/!*]')
					(Said 'look,look/courtyard')
				)
				(HighPrint 80 0) ; "The well-kept Plazas of Shapeir are octagonal in shape. Windows overlook the daily goings-on, and alleys lead outward toward other parts of the city."
			)
			(else
				(event claimed: 0)
			)
		)
		(event claimed:)
	)

	(method (findUnblockedDoor &tmp door startDoor)
		(= door (= startDoor (Random 1 4)))
		(= xIn 32767)
		(repeat
			(self setDoorPos: door)
			(if
				(and
					(!= xIn 32767)
					(> (GetDistance xIn yIn (gEgo x:) (gEgo y:)) 30)
					(> (GetDistance xOut yOut (gEgo x:) (gEgo y:)) 30)
				)
				(break)
			)
			(= xIn 32767)
			(if (> (++ door) 4)
				(= door 1)
			)
			(if (== door startDoor)
				(return 0)
			)
		)
		(return door)
	)

	(method (setDoorPos door)
		(switch door
			(1
				(if north
					(= xOut topFromX)
					(= yOut (- topFromY 12))
					(= xIn topToX)
					(= yIn (+ topToY 10))
				)
			)
			(2
				(if east
					(= xOut rightFromX)
					(= yOut rightFromY)
					(= xIn (- rightToX 10))
					(= yIn rightToY)
				)
			)
			(3
				(if south
					(= xOut bottomFromX)
					(= yOut bottomFromY)
					(= xIn bottomToX)
					(= yIn (- bottomToY 10))
				)
			)
			(4
				(if west
					(= xOut leftFromX)
					(= yOut leftFromY)
					(= xIn (+ leftToX 10))
					(= yIn leftToY)
				)
			)
		)
	)

	(method (dispose)
		(merchants release: dispose:)
		(super dispose:)
	)
)

(instance leftDoorBlock of PicView
	(properties
		x 4
		y 173
		shiftClick 0
		view 300
		loop 4
		priority 7
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(if (not (<= 0 gTimeODay 4))
			(= palette 2)
		)
	)
)

(instance rightDoorBlock of PicView
	(properties
		x 308
		y 164
		shiftClick 0
		view 300
		loop 3
		priority 7
		signal 16400
	)

	(method (init)
		(super init: &rest)
		(if (not (<= 0 gTimeODay 4))
			(= palette 2)
		)
	)
)

(instance leftAlleyDoor of Feature
	(properties
		x 5
		y 124
		noun '/door,sign,alley[<alley,bearing,street]'
		nsTop 92
		nsBottom 156
		nsRight 13
		description {an alley door}
	)

	(method (init)
		(switch gCurRoomNum
			(310 ; FPN
				(self
					lookStr:
						{You see a dark passage leading West.  The street sign reads "Naufara Darb," which means "Fountain Avenue."}
				)
			)
			(315 ; FPS
				(self
					lookStr:
						{You see a dark passage leading East.  The street sign reads "Sultan Darb," which means "Sultan's Avenue."}
				)
			)
			(335 ; rmSPlazaPalace
				(self
					lookStr:
						{You see a dark passage leading South.  The street sign reads "Tarik of Stars," which means "Street of Stars."  Gosh, that one was a lot easier to translate!}
				)
			)
		)
		(super init: &rest)
	)
)

(instance rightAlleyDoor of Feature
	(properties
		x 312
		y 124
		noun '/door,sign[<alley,bearing,street]'
		nsTop 89
		nsLeft 305
		nsBottom 159
		nsRight 320
		description {an alley door}
	)

	(method (init)
		(switch gCurRoomNum
			(335 ; rmSPlazaPalace
				(self
					lookStr:
						{You see a dark passage leading North.  The street sign reads "Hawa Darb," which means "Air Avenue."}
				)
			)
		)
		(super init: &rest)
	)
)

(instance topAlleyDoor of Feature
	(properties
		x 158
		y 67
		noun '/door,sign[<alley,bearing,street]'
		nsTop 38
		nsLeft 132
		nsBottom 91
		nsRight 185
		description {an alley door}
	)

	(method (init)
		(switch gCurRoomNum
			(300 ; rmSPlazaGates
				(self
					lookStr:
						{You see a dark passage leading North.  The street sign reads "Junub Tarik," which means "South Street."}
				)
			)
			(310 ; FPN
				(self
					lookStr:
						{You see a dark passage leading North.  The street sign reads "Shmali Tarik," which means "North Street."}
				)
			)
			(315 ; FPS
				(self
					lookStr:
						{You see a dark passage leading South.  The street sign reads "Junub Tarik," which means "South Street."}
				)
			)
			(330 ; rmSPlazaFightersE
				(self
					lookStr:
						{You see a dark passage leading East.  The street sign reads "Kital Darb," which means "Battle Avenue."}
				)
			)
			(335 ; rmSPlazaPalace
				(self
					lookStr:
						{You see a dark passage leading West.  The street sign reads "Sultan Darb," which means "Sultan's Avenue."}
				)
			)
		)
		(super init: &rest)
	)
)

