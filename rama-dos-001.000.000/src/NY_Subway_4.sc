;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 5404)
(include sci.sh)
(use Main)
(use Location)
(use ExitFeature)
(use newYorkRegion)
(use n1111)
(use Print)
(use Polygon)
(use Feature)
(use Sound)
(use Actor)
(use System)

(public
	NY_Subway_4 0
)

(local
	[local0 9] = [83 133 183 235 287 339 390 442 495]
	[local9 3] = [165 217 269]
	[local12 3] = [-1 -1 -1]
	local15
	[local16 3]
	local19
)

(procedure (localproc_0 param1 &tmp temp0 temp1)
	(switch param1
		(1
			(= temp1 0)
		)
		(2
			(= temp1 3)
		)
		(3
			(= temp1 6)
		)
	)
	(= temp0 0)
	(while (< temp0 3)
		(= [local12 temp0] [global402 temp1])
		(++ temp0)
		(++ temp1)
	)
)

(procedure (localproc_1 param1 &tmp temp0)
	(switch param1
		(1
			(= temp0 315)
		)
		(2
			(= temp0 135)
		)
		(3
			(= temp0 225)
		)
	)
	(faceRoom heading: (mod temp0 360))
	(facePuzzle heading: (mod (+= temp0 90) 360))
	(faceSubway heading: (mod (+= temp0 90) 360))
	(faceWall heading: (mod (+= temp0 90) 360))
)

(instance NY_Subway_4 of Location
	(properties)

	(method (init &tmp temp0)
		(super init: &rest)
		(= plane global116)
		(if (== gPrevRoomNum 24) ; whereTo
			(= temp0 15)
			(= gPrevRoomNum
				((Print new:)
					addTitle: {Subway Puzzle Rooms}
					mode: 1
					addText: {Which Puzzle Room?} 10 (* 0 temp0)
					addButton: 5405 {Puzzle Room 1} 0 (* 2 temp0)
					addButton: 5408 {Puzzle Room 2} 0 (* 3 temp0)
					addButton: 5411 {Puzzle Room 3} 0 (* 4 temp0)
					init:
				)
			)
		)
		(switch gPrevRoomNum
			(5405 ; NY_Subway_5
				(localproc_0 (= local15 1))
				((ScriptID 201 0) whichSubPuz: local15) ; newYorkRegion
				(localproc_1 local15)
				(self
					addPicObj: faceRoom facePuzzle faceSubway faceWall faceRoom
				)
			)
			(5408 ; NY_Subway_8
				(localproc_0 (= local15 2))
				((ScriptID 201 0) whichSubPuz: local15) ; newYorkRegion
				(localproc_1 local15)
				(self
					addPicObj: faceRoom facePuzzle faceSubway faceWall faceRoom
				)
			)
			(5411 ; NY_Subway_11
				(localproc_0 (= local15 3))
				((ScriptID 201 0) whichSubPuz: local15) ; newYorkRegion
				(localproc_1 local15)
				(self
					addPicObj: faceRoom facePuzzle faceSubway faceWall faceRoom
				)
			)
			(5419 ; puzzleIconCU
				(localproc_0 (= local15 ((ScriptID 201 0) whichSubPuz:))) ; newYorkRegion
				(localproc_1 local15)
				(self
					addPicObj:
						facePuzzle
						faceSubway
						faceWall
						faceRoom
						facePuzzle
				)
			)
			(else
				(localproc_0 (= local15 1))
				((ScriptID 201 0) whichSubPuz: local15) ; newYorkRegion
				(localproc_1 local15)
				(self
					addPicObj:
						faceSubway
						faceWall
						faceRoom
						facePuzzle
						faceSubway
				)
			)
		)
		(SubPuzzleControl init:)
	)

	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 5419) ; puzzleIconCU
			(= local19 1)
		)
		(super newRoom: newRoomNumber &rest)
	)

	(method (serialize param1)
		(if param1
			(super serialize: param1 0)
		else
			(super serialize: param1)
		)
	)

	(method (dispose)
		(SubPuzzleControl dispose:)
		(super dispose: &rest)
	)
)

(instance rowIcons of Set
	(properties)
)

(instance colIcons of Set
	(properties)
)

(class RowIcon of View
	(properties
		noun 22
		view 5403
		index -1
	)

	(method (checkSolved &tmp temp0)
		(return (and cel (== (rowIcons indexOf: self) (- cel 1))))
	)

	(method (checkCel param1)
		(return (== cel param1))
	)

	(method (turnOff &tmp temp0 temp1)
		(= temp0 (rowIcons indexOf: self))
		(= temp1 (+ 247 temp0))
		(if (IsFlag temp1)
			(ClearFlag temp1)
		)
		(switch index
			(0
				((ScriptID 201 0) subPuzCol1: -1) ; newYorkRegion
			)
			(1
				((ScriptID 201 0) subPuzCol2: -1) ; newYorkRegion
			)
			(2
				((ScriptID 201 0) subPuzCol3: -1) ; newYorkRegion
			)
		)
		(self setHotspot: 2 144)
		(= cel 0)
		(= index -1)
	)

	(method (init)
		(&= signal $efff)
		(super init: &rest)
		(if cel
			(self setHotspot: 9 144)
		else
			(self setHotspot: 2 144)
		)
	)

	(method (doVerb theVerb &tmp temp0)
		(switch theVerb
			(1
				(if
					(and
						scratch
						(scratch respondsTo: #name)
						(not (gTheCursor isInvCursor:))
					)
					(gTheCursor setDirCursor: exitCurView)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(2
				(proc201_1 31)
				(= temp0 index)
				(switch (= index (SubPuzzleControl next: index))
					(-1
						(= cel 0)
						(SubPuzzleControl turnOnColMon: temp0)
						(self setHotspot: 2 144)
					)
					(temp0 0)
					(else
						(buttonClick play:)
						(= cel (+ [local12 index] 1))
						(SubPuzzleControl
							turnOnColMon: temp0
							turnOffColMon: index
							checkSolution:
						)
						(switch index
							(0
								((ScriptID 201 0) ; newYorkRegion
									subPuzCol1: (rowIcons indexOf: self)
								)
							)
							(1
								((ScriptID 201 0) ; newYorkRegion
									subPuzCol2: (rowIcons indexOf: self)
								)
							)
							(2
								((ScriptID 201 0) ; newYorkRegion
									subPuzCol3: (rowIcons indexOf: self)
								)
							)
						)
						(self setHotspot: 9 144)
					)
				)
			)
			(9
				((ScriptID 201 0) subPuzCU: (SubPuzzleControl getCU: cel)) ; newYorkRegion
				(gCurRoom newRoom: 5419) ; puzzleIconCU
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(class ColIcon of View
	(properties
		noun 22
		view 5403
		myCU -1
	)

	(method (isOn)
		(return (not loop))
	)

	(method (turnOn)
		(buttonClick play:)
		(= loop 0)
		(self setHotspot: 9 144)
	)

	(method (turnOff)
		(= loop 1)
		(self setHotspot: 2 144)
	)

	(method (checkCel param1)
		(return (== cel param1))
	)

	(method (init)
		(super init: &rest)
		(if loop
			(self setHotspot: 2 144)
		else
			(self setHotspot: 9 144)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(if
					(and
						scratch
						(scratch respondsTo: #name 144)
						(not (gTheCursor isInvCursor:))
					)
					(gTheCursor setDirCursor: exitCurView)
				else
					(super doVerb: theVerb &rest)
				)
			)
			(2
				(proc201_1 31)
				(self turnOn:)
				(SubPuzzleControl turnOffRowMon: cel)
			)
			(9
				((ScriptID 201 0) subPuzCU: myCU) ; newYorkRegion
				(gCurRoom newRoom: 5419) ; puzzleIconCU
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance exitCurView of View
	(properties
		cel 6
		view 600
	)
)

(class SubPuzzleControl of Obj
	(properties
		minIndex 0
		maxIndex 2
		stateSaved 0
	)

	(method (checkSolution &tmp temp0)
		(= temp0 (+ 242 (- local15 1)))
		(if
			(and
				(not (IsFlag temp0))
				((rowIcons at: [local12 0]) checkSolved:)
				((rowIcons at: [local12 1]) checkSolved:)
				((rowIcons at: [local12 2]) checkSolved:)
			)
			(SetFlag temp0)
		)
	)

	(method (next param1 &tmp temp0 temp1 temp2)
		(= temp0 param1)
		(= temp2 (- maxIndex minIndex))
		(if (not (colIcons firstTrue: #isOn))
			(return temp0)
		)
		(for ((= temp1 0)) (<= temp1 temp2) ((++ temp1))
			(cond
				((> (++ temp0) temp2)
					(= temp0 -1)
					(break)
				)
				(((colIcons at: temp0) isOn:)
					(break)
				)
			)
		)
		(return temp0)
	)

	(method (turnOffColMon param1)
		(if (!= param1 -1)
			((colIcons at: param1) turnOff:)
		)
	)

	(method (turnOnColMon param1)
		(if (!= param1 -1)
			((colIcons at: param1) turnOn:)
		)
	)

	(method (turnOffRowMon param1)
		(if (!= param1 -1)
			((rowIcons firstTrue: #checkCel param1) turnOff:)
		)
	)

	(method (getCU param1)
		(if (> param1 0)
			(return (+ 5480 (- param1 1)))
		)
	)

	(method (setUpIcons &tmp temp0 temp1 temp2 temp3 temp4)
		(= stateSaved 0)
		(if (!= (= temp0 ((ScriptID 201 0) subPuzCol1:)) -1) ; newYorkRegion
			((rowIcons at: temp0) cel: (+ [local12 0] 1) index: 0)
			((colIcons at: 0) loop: 1)
		)
		(if (!= (= temp0 ((ScriptID 201 0) subPuzCol2:)) -1) ; newYorkRegion
			((rowIcons at: temp0) cel: (+ [local12 1] 1) index: 1)
			((colIcons at: 1) loop: 1)
		)
		(if (!= (= temp0 ((ScriptID 201 0) subPuzCol3:)) -1) ; newYorkRegion
			((rowIcons at: temp0) cel: (+ [local12 2] 1) index: 2)
			((colIcons at: 2) loop: 1)
		)
		(for ((= temp2 0)) (<= temp2 8) ((++ temp2))
			(= temp3 (rowIcons at: temp2))
			(= temp1 (+ 247 temp2))
			(if (IsFlag temp1)
				(temp3 cel: (+ temp2 1))
				(if (= temp4 (colIcons firstTrue: #checkCel (temp3 cel:)))
					(temp4 loop: 1)
					(temp3 index: (colIcons indexOf: temp4))
				)
			)
		)
	)

	(method (saveIconState &tmp temp0 temp1 temp2)
		(if
			(or
				stateSaved
				(not (rowIcons size:))
				(not global117)
				(not (global117 size:))
			)
			(return)
		)
		((ScriptID 201 0) subPuzCol1: -1) ; newYorkRegion
		((ScriptID 201 0) subPuzCol2: -1) ; newYorkRegion
		((ScriptID 201 0) subPuzCol3: -1) ; newYorkRegion
		(= [local16 0] 1)
		(= [local16 1] 1)
		(= [local16 2] 1)
		(for ((= temp0 0)) (<= temp0 8) ((++ temp0))
			(= temp2 (rowIcons at: temp0))
			(= temp1 (+ 247 temp0))
			(if (temp2 checkSolved:)
				(SetFlag temp1)
			else
				(ClearFlag temp1)
				(if (temp2 cel:)
					(switch (temp2 index:)
						(0
							((ScriptID 201 0) subPuzCol1: temp0) ; newYorkRegion
							(= [local16 0] 0)
						)
						(1
							((ScriptID 201 0) subPuzCol2: temp0) ; newYorkRegion
							(= [local16 1] 0)
						)
						(2
							((ScriptID 201 0) subPuzCol3: temp0) ; newYorkRegion
							(= [local16 2] 0)
						)
					)
				)
			)
		)
		(= stateSaved 1)
	)

	(method (dispose)
		(if (not local19)
			(if (not [local16 0])
				((ScriptID 201 0) subPuzCol1: -1) ; newYorkRegion
			)
			(if (not [local16 1])
				((ScriptID 201 0) subPuzCol2: -1) ; newYorkRegion
			)
			(if (not [local16 2])
				((ScriptID 201 0) subPuzCol3: -1) ; newYorkRegion
			)
		)
		(super dispose: &rest)
		(= local19 0)
	)
)

(instance facePuzzle of CameraAngle
	(properties
		picture 5403
		edgeS 0
		edgeN 0
	)

	(method (init &tmp temp0)
		(monitors init:)
		(for ((= temp0 0)) (< temp0 9) ((++ temp0))
			(rowIcons add: ((RowIcon new:) posn: [local0 temp0] 61 yourself:))
		)
		(for ((= temp0 0)) (< temp0 3) ((++ temp0))
			(colIcons
				add:
					((ColIcon new:)
						posn: 288 [local9 temp0]
						cel: (+ [local12 temp0] 1)
						myCU: (+ 5470 [local12 temp0])
						yourself:
					)
			)
		)
		(SubPuzzleControl setUpIcons:)
		(rowIcons eachElementDo: #init global117)
		(colIcons eachElementDo: #init global117)
		(super init: &rest)
	)

	(method (dispose)
		(SubPuzzleControl saveIconState:)
		(rowIcons release: dispose:)
		(colIcons release: dispose:)
		(super dispose: &rest)
	)
)

(instance faceSubway of CameraAngle
	(properties
		picture 5402
		edgeS 0
		edgeN 0
	)

	(method (init)
		(exitToSubway init:)
		(chair init:)
		(map init:)
		(subMachinery init:)
		(super init: &rest)
	)
)

(instance faceWall of CameraAngle
	(properties
		picture 5407
		edgeS 0
		edgeN 0
	)
)

(instance faceRoom of CameraAngle
	(properties
		picture 5406
		edgeS 0
		edgeN 0
	)

	(method (init)
		(machinery init:)
		(super init: &rest)
	)
)

(instance exitToSubway of ExitFeature
	(properties
		nsBottom 260
		nsLeft 244
		nsRight 336
		nsTop 100
	)

	(method (init)
		(switch local15
			(1
				(= nextRoom 5405)
			)
			(2
				(= nextRoom 5408)
			)
			(3
				(= nextRoom 5411)
			)
		)
		(super init: &rest)
	)
)

(instance buttonClick of Sound
	(properties
		number 5400
		flags 5
	)
)

(instance machinery of Feature
	(properties
		noun 19
		case 11
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 435 105 498 105 499 145 509 145 501 165 435 167
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 438 180 460 174 492 180 559 268 564 291 484 291 472 292 437 265
					yourself:
				)
		)
	)
)

(instance monitors of Feature
	(properties
		noun 22
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 69 23 88 22 93 16 102 16 105 21 140 23 145 15 150 15 156 22 190 22 196 14 202 15 208 24 243 22 247 14 254 15 259 22 293 23 297 16 305 14 311 23 345 23 349 17 357 16 363 24 396 22 400 18 410 16 414 23 447 23 450 17 459 16 463 22 498 22 500 16 511 16 515 23 532 24 544 37 541 68 535 83 519 83 511 90 500 88 492 83 467 83 461 89 444 89 444 82 413 82 407 92 399 89 389 81 360 81 356 86 351 86 347 80 312 77 307 85 298 85 294 77 260 79 256 89 244 87 238 78 208 80 201 86 194 86 190 81 156 80 151 86 142 86 139 8 1 106 81 99 85 93 85 87 77 66 78
					yourself:
				)
				((Polygon new:)
					type: PTotalAccess
					init: 273 126 332 127 331 144 337 149 336 159 331 164 328 248 335 255 334 262 332 266 330 284 273 281 272 265 263 258 263 249 273 243 273 213 270 209 264 209 265 201 272 199 273 162 265 157 266 147 272 140
					yourself:
				)
		)
	)
)

(instance map of Feature
	(properties
		noun 17
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 149 111 175 133 173 162 166 163 126 163 122 159 120 132
					yourself:
				)
		)
	)
)

(instance subMachinery of Feature
	(properties
		noun 19
		case 11
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 79 175 204 173 234 179 236 187 237 254 220 292 -3 292 -1 250 62 179
					yourself:
				)
		)
	)
)

(instance chair of Feature
	(properties
		noun 18
		case 8
	)

	(method (init)
		(super init: &rest)
		(self
			setHotspot: 144
			setPolygon:
				((Polygon new:)
					type: PTotalAccess
					init: 280 124 307 122 304 153 312 156 312 165 305 167 315 194 306 197 305 219 277 219 278 201 267 196 267 192 269 176 275 176 280 166 271 166 272 157 280 155
					yourself:
				)
		)
	)
)

