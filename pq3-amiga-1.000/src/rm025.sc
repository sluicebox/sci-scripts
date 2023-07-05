;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 25)
(include sci.sh)
(use Main)
(use carStuff)
(use Interface)
(use eRS)
(use Feature)
(use Sound)
(use Motion)
(use User)
(use Actor)
(use System)

(public
	rm025 0
	mainInset 1
	roadInset 2
	changeLanes 3
	proc25_4 4
	streetFrame 5
	theRoom 6
	proc25_7 7
	proc25_8 8
	streetBox 9
	endFreewayScript 10
	proc25_11 11
)

(local
	[local0 176] = [0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 9 1 1 3 0 9 1 1 1 1 1 1 1 1 1 1 0 0 0 2 0 8 0 0 0 0 0 0 0 0 0 0 0 0 0 2 0 8 0 0 0 0 0 0 0 0 0 0 0 0 0 2 0 8 0 0 0 0 0 0 0 0 0 0 0 4 4 2 0 8 0 0 0 0 0 0 0 0 0 0 2 0 0 10 0 8 0 0 0 0 0 0 0 0 0 0 2 0 0 10 0 8 0 0 0 0 0 0 0 0 0 0 2 0 0 10 0 12 4 4 4 4 4 4 4 4 4 4 4 5 5 6 0 5 5 5 5 5 5 5 5 5 5 5 5 0 0 0]
	[local176 5] = [-1 -1 -1 -1 -1]
	[local181 31] = [-1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1]
	[local212 20] = [-1 -1 6 10 6 0 6 1 6 2 6 3 6 4 6 5 6 6 6 7]
	[local232 32] = [-1 -1 6 9 7 0 7 1 7 2 7 3 7 4 7 5 7 6 7 7 7 8 7 9 6 8 7 10 7 11 7 12]
	local264 = -1
	local265
	local266
	[local267 48] = [42 180 5 2 71 180 5 2 72 0 -1 1 100 180 5 2 101 0 -1 1 130 0 -1 1 148 270 -1 3 151 270 -1 4 154 270 -1 5 164 90 5 3 167 90 5 4 170 90 5 5]
	local315
	local316
	local317
	local318
)

(procedure (proc25_7 param1 param2 param3 param4)
	(= [local181 local315]
		((BlockStuff new:)
			name: {bs}
			whatBlock: param1
			whatUnit: param2
			type: param3
			whatSide: param4
			yourself:
		)
	)
	(++ local315)
)

(procedure (proc25_8 param1 &tmp temp0)
	(for ((= temp0 0)) (!= [local181 temp0] -1) ((++ temp0))
		(if (== ([local181 temp0] whatUnit:) param1)
			([local181 temp0] whatUnit: 999)
			(break)
		)
	)
)

(procedure (proc25_4 param1 &tmp temp0)
	(= temp0 (if (and argc param1) 0 else 1000))
	((ScriptID 130 3) setCel: 0) ; gloveBox
	(if (!= local264 -1)
		(gGame setCursor: local264 1)
		(= local264 -1)
	)
	(rCross z: temp0)
	(lCross z: temp0)
	(tCross z: temp0)
	(stopSign z: temp0)
	(stopAhead z: temp0)
	(roadInset z: temp0 forceUpd:)
	(streetFrame z: temp0 forceUpd:)
	(roadLine z: temp0)
	((ScriptID 130 7) z: temp0) ; copCar
	(roadSign z: temp0 forceUpd:)
	(freewaySign z: temp0 forceUpd:)
	(endFreeway z: temp0 forceUpd:)
	(if
		(and
			(== gDay 1)
			(IsFlag 211)
			(not (IsFlag 16))
			(not (IsFlag 68))
		)
		((ScriptID 129 3) z: temp0) ; suspCar
		((ScriptID 129 6) z: temp0) ; genCar0
		((ScriptID 129 7) z: temp0) ; genCar1
		((ScriptID 129 8) z: temp0) ; genCar2
		((ScriptID 129 9) z: temp0) ; genCar3
		((ScriptID 129 10) z: temp0) ; genCar4
	)
	(if ((ScriptID 130 1) cycler:) ; lightBar
		((ScriptID 130 1) z: temp0) ; lightBar
	)
	(aspenSign z: temp0 forceUpd:)
	(streetBox z: temp0 forceUpd:)
	(boxDir z: temp0)
	(boxSt z: temp0)
	(lineCover z: temp0)
	(mainInset engineOn: param1)
	(if (and argc param1)
		(streetBox cue:)
	)
)

(procedure (localproc_0)
	(return
		(switch (mainInset heading:)
			(0 3)
			(90 0)
			(180 2)
			(270 1)
		)
	)
)

(procedure (localproc_1)
	(return
		(switch (mainInset heading:)
			(0 2)
			(90 1)
			(180 3)
			(270 0)
		)
	)
)

(procedure (proc25_11)
	(rCross cue:)
	(lCross cue:)
	(tCross cue:)
	(stopSign cue:)
	(stopAhead cue:)
	(roadSign view: 260 hide: script: 0)
	(freewaySign view: 260 hide: script: 0)
	(endFreeway view: 260 hide: script: 0)
	(aspenSign view: 260 hide: script: 0)
)

(class BlockStuff of Obj
	(properties
		whatBlock 0
		whatSide 0
		whatUnit 0
		type 0
	)
)

(class Inset of Obj
	(properties
		curUnit 0
		maxUnits 0
		unitCnt 0
		cnt 0
		lastX 0
		lastY 0
		heading 0
		mySpeed 0
		maxSpeed 0
		rightBlock 0
		leftBlock 0
		turning 0
		stopFlag 0
		freewayFlag 0
		leftFlag 0
		engineOn 0
		tZone 0
	)

	(method (init)
		(gTheDoits add: self)
	)

	(method (dispose)
		(gTheDoits delete: self)
		(super dispose:)
	)

	(method (calcSpeed param1 &tmp temp0)
		(= mySpeed
			(cond
				((< param1 0) 0)
				((> param1 maxSpeed) maxSpeed)
				(else param1)
			)
		)
		(= cnt (= unitCnt (+ 1 (/ (- maxSpeed mySpeed) 20))))
		((ScriptID 130 9) cue:) ; speedo
	)

	(method (doit &tmp temp0 temp1)
		(cond
			((or turning (not mySpeed))
				(return)
			)
			((not (-- cnt))
				(= cnt unitCnt)
				(cond
					((OneOf heading 90 180)
						(if (> (++ curUnit) maxUnits)
							(= curUnit maxUnits)
						)
					)
					((< (-- curUnit) 0)
						(= curUnit 0)
					)
				)
				(for ((= temp0 0)) (!= [local176 temp0] -1) ((++ temp0))
					(cond
						((!= ([local176 temp0] whatUnit:) curUnit) 0)
						((== ([local176 temp0] type:) 1)
							(if
								(and
									(== gDay 1)
									(IsFlag 211)
									(not (IsFlag 16))
									(not (IsFlag 68))
									(or
										(==
											((ScriptID 129 3) script:) ; suspCar
											(ScriptID 129 12) ; pullOverScript
										)
										tZone
									)
								)
								0
								(break)
							)
							(rCross
								setMotion:
									MoveTo
									(rCross x:)
									(+ (roadInset y:) 59)
									rCross
							)
							(= local318 1)
							(break)
						)
						((== ([local176 temp0] type:) 4)
							(if (!= gDay 1)
								(gCurRoom setScript: endFreewayScript)
								(break)
							)
							(if
								(and
									(IsFlag 211)
									(not (IsFlag 16))
									(not (IsFlag 68))
									(or
										(==
											((ScriptID 129 3) script:) ; suspCar
											(ScriptID 129 12) ; pullOverScript
										)
										(and
											(IsFlag 209)
											((ScriptID 129 3) script:) ; suspCar
											(!=
												((ScriptID 129 3) script:) ; suspCar
												(ScriptID 129 4) ; setUpScript
											)
										)
									)
								)
								0
								(break)
							)
							(gCurRoom setScript: (ScriptID 132 3)) ; endFree1Script
							(break)
						)
						((== ([local176 temp0] type:) 2)
							(stopSign
								setMotion:
									MoveTo
									(stopSign x:)
									(+ (roadInset x:) 8)
									stopSign
							)
							(= stopFlag 1)
							(break)
						)
						((== ([local176 temp0] type:) 3)
							(stopAhead
								setMotion:
									MoveTo
									(stopAhead x:)
									(+ (roadInset x:) 8)
									stopAhead
							)
							(break)
						)
						((== ([local176 temp0] type:) 6)
							(if (== ([local176 temp0] whatBlock:) rightBlock)
								(= temp1 rCross)
							else
								(= temp1 lCross)
							)
							(temp1
								setMotion:
									MoveTo
									(temp1 x:)
									(+ (roadInset y:) 59)
									temp1
							)
							(= local316 ([local176 temp0] whatBlock:))
							(= local318 2)
							(break)
						)
					)
				)
				(if (OneOf curUnit 0 maxUnits)
					(switch heading
						(0
							(-- lastY)
						)
						(90
							(++ lastX)
						)
						(180
							(++ lastY)
						)
						(270
							(-- lastX)
						)
					)
					(self makeATurn: 0 getStuff:)
					(if (not freewayFlag)
						(self drawIntersec:)
					)
				)
				(if (OneOf curUnit 5 (- maxUnits 5))
					(roadSign cue:)
				)
			)
		)
	)

	(method (calcBlocked param1 param2 &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp0 (= temp3 (= temp2 (= temp4 0))))
		(= temp1 [local0 (self at: param1 param2)])
		(switch heading
			(0
				(= temp2 (& temp1 $0002))
				(= temp3 (& temp1 $0008))
				(= temp4 (& temp1 $0001))
			)
			(90
				(= temp2 (& temp1 $0004))
				(= temp3 (& temp1 $0001))
				(= temp4 (& temp1 $0002))
			)
			(180
				(= temp2 (& temp1 $0008))
				(= temp3 (& temp1 $0002))
				(= temp4 (& temp1 $0004))
			)
			(270
				(= temp2 (& temp1 $0001))
				(= temp3 (& temp1 $0004))
				(= temp4 (& temp1 $0008))
			)
		)
		(if temp2
			(|= temp0 $0004)
		)
		(if temp3
			(|= temp0 $0002)
		)
		(if temp4
			(|= temp0 $0001)
		)
		(return temp0)
	)

	(method (drawIntersec &tmp temp0)
		(if (not (& (= temp0 (self calcBlocked: lastX lastY)) $0004))
			(rCross setMotion: MoveTo (rCross x:) (+ (roadInset y:) 59) rCross)
			(= local318 0)
		)
		(if (not (& temp0 $0002))
			(lCross setMotion: MoveTo (lCross x:) (+ (roadInset y:) 59) lCross)
			(= local318 0)
		)
		(if (& temp0 $0001)
			(tCross setMotion: MoveTo (tCross x:) (- (roadInset y:) 34) tCross)
		)
	)

	(method (getStuff &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(for ((= temp0 0)) (< temp0 5) ((++ temp0))
			(= [local176 temp0] -1)
		)
		(= temp0 (= temp2 -1))
		(while (!= [local181 (++ temp0)] -1)
			(if
				(and
					(== ([local181 temp0] whatBlock:) rightBlock)
					(== ([local181 temp0] whatSide:) (localproc_0))
					(OneOf ([local181 temp0] type:) 1 4)
				)
				(= [local176 (++ temp2)] [local181 temp0])
			)
		)
		(= temp0 (= temp2 -1))
		(while (!= [local181 (++ temp0)] -1)
			(if
				(and
					(== ([local181 temp0] type:) 6)
					(or
						(and
							(== ([local181 temp0] whatBlock:) rightBlock)
							(== ([local181 temp0] whatSide:) (localproc_0))
						)
						(and
							(== ([local181 temp0] whatBlock:) leftBlock)
							(== ([local181 temp0] whatSide:) (localproc_1))
						)
					)
				)
				(= [local176 (++ temp2)] [local181 temp0])
			)
		)
		(= temp3 0)
		(switch heading
			(0
				(= temp3 (& [local0 (self at: lastX (- lastY 1))] $0001))
				(= temp4 0)
				(= temp5 20)
			)
			(90
				(= temp3 (& [local0 (self at: (+ lastX 1) lastY)] $0002))
				(= temp4 (mainInset maxUnits:))
				(= temp5 (- (mainInset maxUnits:) 20))
			)
			(180
				(= temp3 (& [local0 (self at: lastX (+ lastY 1))] $0004))
				(= temp4 (mainInset maxUnits:))
				(= temp5 (- (mainInset maxUnits:) 20))
			)
			(270
				(= temp3 (& [local0 (self at: (- lastX 1) lastY)] $0008))
				(= temp4 0)
				(= temp5 20)
			)
		)
		(if temp3
			(= [local176 (++ temp2)]
				(stopAheadStuff type: 3 whatUnit: temp5 yourself:)
			)
			(= [local176 (++ temp2)]
				(stopStuff type: 2 whatUnit: temp4 yourself:)
			)
		)
	)

	(method (at param1 param2)
		(return (+ param1 (* param2 16)))
	)

	(method (makeATurn param1)
		(= turning 1)
		(switch param1
			(rCross
				(if (!= local318 2)
					(+= heading 90)
				)
				(if freewayFlag
					(-= heading 90)
				)
			)
			(lCross
				(if (!= local318 2)
					(-= heading 90)
				)
			)
		)
		(if (== heading 360)
			(= heading 0)
		)
		(if (< heading 0)
			(= heading 270)
		)
		(cond
			((== local318 2) 0)
			((OneOf heading 90 180)
				(= curUnit 0)
			)
			(else
				(= curUnit maxUnits)
			)
		)
		(if param1
			(HandsOff)
			(if (not mySpeed)
				(self calcSpeed: 10)
			)
			(if (== local318 2)
				((ScriptID 130 7) setScript: driveWayScript 0 param1) ; copCar
			else
				((ScriptID 130 7) setScript: turnCarScript 0 param1) ; copCar
			)
		else
			(self whichBlocks: turning: 0)
		)
	)

	(method (whichBlocks)
		(switch heading
			(0
				(= rightBlock (self at: lastX (- lastY 1)))
				(= leftBlock (self at: (- lastX 1) (- lastY 1)))
			)
			(90
				(= rightBlock (self at: lastX lastY))
				(= leftBlock (self at: lastX (- lastY 1)))
			)
			(180
				(= rightBlock (self at: (- lastX 1) lastY))
				(= leftBlock (self at: lastX lastY))
			)
			(270
				(= rightBlock (self at: (- lastX 1) (- lastY 1)))
				(= leftBlock (self at: (- lastX 1) lastY))
			)
		)
	)
)

(instance rm025 of PQRoom
	(properties
		picture 25
	)

	(method (newRoom newRoomNumber)
		(if (rCross mover:)
			(= global160 (rCross y:))
			(= global164 local318)
		else
			(= global160 0)
		)
		(if (lCross mover:)
			(= global161 (lCross y:))
			(= global164 local318)
		else
			(= global161 0)
		)
		(if (tCross mover:)
			(= global162 (tCross y:))
		else
			(= global162 0)
		)
		(if (stopSign mover:)
			(= global163 (stopSign y:))
		else
			(= global163 0)
		)
		(super newRoom: newRoomNumber)
	)

	(method (dispose &tmp temp0)
		(DisposeScript 129)
		(= temp0 -1)
		(while (IsObject [local181 (++ temp0)])
			([local181 temp0] dispose:)
		)
		(= gEatMice local317)
		(mainInset dispose:)
		(super dispose:)
	)

	(method (init &tmp temp0 temp1 temp2 temp3 temp4)
		(Load rsVIEW 263)
		(Load rsVIEW 274)
		(Load rsVIEW (if (== gDay 1) 265 else 264))
		(= local317 gEatMice)
		(= gEatMice 10)
		(super init:)
		(proc130_14)
		(mainInset maxUnits: 20)
		(proc25_7 42 (/ (mainInset maxUnits:) 2) 1 2)
		(proc25_7 71 (/ (mainInset maxUnits:) 2) 1 2)
		(proc25_7 72 (/ (mainInset maxUnits:) 2) 1 3)
		(proc25_7 100 (/ (mainInset maxUnits:) 2) 1 2)
		(proc25_7 101 (/ (mainInset maxUnits:) 2) 1 3)
		(proc25_7 130 (/ (mainInset maxUnits:) 2) 1 3)
		(proc25_7 148 (/ (mainInset maxUnits:) 2) 1 1)
		(proc25_7 151 (/ (mainInset maxUnits:) 2) 1 1)
		(proc25_7 154 (/ (mainInset maxUnits:) 2) 1 1)
		(proc25_7 164 (/ (mainInset maxUnits:) 2) 1 0)
		(proc25_7 167 (/ (mainInset maxUnits:) 2) 1 0)
		(proc25_7 170 (/ (mainInset maxUnits:) 2) 1 0)
		(proc25_7 86 (/ (mainInset maxUnits:) 2) 6 2)
		(proc25_7 106 (/ (mainInset maxUnits:) 2) 6 0)
		(proc25_7 145 1 4 1)
		(proc25_7 171 (- (mainInset maxUnits:) 1) 4 0)
		(if (IsFlag 67)
			(proc25_7 33 55 5 0)
		)
		(if (IsFlag 64)
			(proc25_7 41 47 5 0)
		)
		(if (IsFlag 66)
			(proc25_7 65 51 5 1)
		)
		(if (IsFlag 60)
			(proc25_7 69 33 5 3)
		)
		(if (IsFlag 65)
			(proc25_7 73 49 5 3)
		)
		(if (IsFlag 63)
			(proc25_7 99 45 5 0)
		)
		(if (IsFlag 62)
			(proc25_7 89 42 5 3)
		)
		(proc25_7 106 (if (== gDay 1) 30 else 31) 5 0)
		(if (IsFlag 61)
			(proc25_7 131 41 5 3)
		)
		(if (IsFlag 58)
			(proc25_7 157 27 5 0)
		)
		(if (and global129 global130 (!= gPrevRoomNum 12))
			(= temp0 global129)
			(= temp1 global130)
			(= temp2 global132)
			(= temp4 global131)
			(= temp3 global133)
		else
			(= temp0 7)
			(= temp1 5)
			(= temp2 180)
			(= temp4 0)
			(= temp3 (/ (mainInset maxUnits:) 2))
		)
		(if
			(or
				(and (== gPrevRoomNum 47) (== ((gInventory at: 22) owner:) 47)) ; tracker
				(and (== gPrevRoomNum 27) (== global134 2))
			)
			(= temp2 270)
			(= temp3 (/ (mainInset maxUnits:) 2))
		)
		(mainInset
			init:
			maxSpeed: 100
			calcSpeed: temp4
			lastX: temp0
			lastY: temp1
			heading: temp2
			curUnit: temp3
			whichBlocks:
			getStuff:
		)
		(mainInset freewayFlag: (if (== (mainInset lastY:) 10) 1 else 0))
		(if
			(and
				(== gDay 1)
				(not global135)
				(!= ((gInventory at: 2) owner:) 885) ; handcuff
				(not (gEgo has: 23)) ; license
				(or
					(and
						(<= (mainInset lastX:) 1)
						(== (mainInset heading:) 270)
					)
					(and
						(>= (mainInset lastX:) 12)
						(== (mainInset heading:) 90)
					)
				)
			)
			(gCurRoom setScript: endFree)
		)
		(roadInset cel: 0 init:)
		(rCross init: x: (+ (roadInset x:) 32) y: (- (roadInset y:) 103))
		(lCross init: x: (- (roadInset x:) 31) y: (- (roadInset y:) 103))
		(tCross init: x: (roadInset x:) y: (- (roadInset y:) 160))
		(lineCover init: x: (- (roadInset x:) 2) y: (roadInset y:) z: 1000)
		(stopSign init: x: (+ (roadInset x:) 20) y: (- (roadInset y:) 102))
		(stopAhead init: x: (+ (roadInset x:) 20) y: (- (roadInset y:) 102))
		(= local265
			(/ (CelWide (roadInset view:) (roadInset loop:) (roadInset cel:)) 2)
		)
		(= local266
			(CelHigh (roadInset view:) (roadInset loop:) (roadInset cel:))
		)
		(streetFrame
			x: (+ (roadInset x:) 4)
			y: (+ (roadInset y:) 7)
			cel: 1
			init:
		)
		(streetBox x: (- (streetFrame x:) 4) y: (+ (streetFrame y:) 24) init:)
		(boxDir init: x: (- (streetBox x:) 7) y: (- (streetBox y:) 15))
		(boxSt init: x: (streetBox x:) y: (- (streetBox y:) 6))
		(roadLine
			x: (roadInset x:)
			y: (roadInset y:)
			loop: (+ (mainInset freewayFlag:) 1)
			setCycle: Fwd
			init:
		)
		((ScriptID 130 7) ; copCar
			init:
			view: (if (== gDay 1) 265 else 264)
			x:
				(if (IsFlag 208)
					(- (+ (roadInset x:) 15) 30)
				else
					(+ (roadInset x:) 15)
				)
			y: (- (roadInset y:) 14)
		)
		(if (IsFlag 208)
			(mainInset leftFlag: 1)
		)
		(roadSign init: x: (+ (roadInset x:) 36) y: (- (roadInset y:) 86) hide:)
		(aspenSign
			init:
			x: (+ (roadInset x:) 36)
			y: (- (roadInset y:) 86)
			hide:
		)
		(freewaySign
			init:
			x: (+ (roadInset x:) 36)
			y: (- (roadInset y:) 76)
			hide:
		)
		(endFreeway
			init:
			x: (+ (roadInset x:) 36)
			y: (- (roadInset y:) 76)
			hide:
		)
		(self setRegions: 130) ; carStuff
		(if (== gDay 1)
			(self setRegions: 132) ; carDay1Reg
		else
			(self setRegions: 133) ; carDayXReg
		)
		(if global160
			(= local318 global164)
			(rCross
				y: global160
				setMotion: MoveTo (rCross x:) (+ (roadInset y:) 59) rCross
			)
		)
		(if global161
			(= local318 global164)
			(lCross
				y: global161
				setMotion: MoveTo (lCross x:) (+ (roadInset y:) 59) lCross
			)
		)
		(if global162
			(tCross
				y: global162
				setMotion: MoveTo (tCross x:) (- (roadInset y:) 34) tCross
			)
		)
		(if global163
			(stopSign
				y: global163
				setMotion: MoveTo (stopSign x:) (+ (roadInset x:) 8) stopSign
			)
		)
		(theRoom init:)
	)
)

(instance mainInset of Inset
	(properties)
)

(instance stopStuff of BlockStuff
	(properties)
)

(instance stopAheadStuff of BlockStuff
	(properties)
)

(instance endFree of Script
	(properties)

	(method (doit)
		(if (mainInset mySpeed:)
			(gCurRoom setScript: (ScriptID 132 3)) ; endFree1Script
		)
	)
)

(instance endFreewayScript of Script
	(properties)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3 temp4)
		(switch (= state newState)
			(0
				(if (== (mainInset heading:) 270)
					(= temp0 1)
					(= temp1 9)
					(= temp2 0)
					(= temp3 (- (mainInset maxUnits:) 1))
				else
					(= temp0 12)
					(= temp1 2)
					(= temp2 90)
					(= temp3 1)
				)
				(= temp4 35)
				(roadLine loop: 1)
				(mainInset
					freewayFlag: 0
					engineOn: 1
					curUnit: temp3
					lastX: temp0
					lastY: temp1
					heading: temp2
					calcSpeed: temp4
					whichBlocks:
					getStuff:
				)
				(proc130_14)
				(streetBox cue:)
				(self dispose:)
			)
		)
	)
)

(instance roadSignScript of Script
	(properties)

	(method (init)
		(if client
			(client view: 260 hide: script: 0)
		)
		(super init: &rest)
	)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= seconds register)
			)
			(1
				(client view: 260 hide:)
				(self dispose:)
			)
		)
	)
)

(instance turnCarScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(not state)
				(or
					(and
						(== register rCross)
						(> (rCross y:) (- (roadInset y:) 20))
					)
					(and
						(== register lCross)
						(> (lCross y:) (- (roadInset y:) 2))
					)
				)
			)
			(self cue:)
		)
	)

	(method (changeState newState &tmp temp0 temp1 temp2 temp3)
		(switch (= state newState)
			(0 0)
			(1
				(rCross setMotion: 0)
				(lCross setMotion: 0)
				(tCross setMotion: 0)
				(stopSign setMotion: 0)
				(roadLine setCycle: 0)
				(= temp0 (if (== register lCross) 1 else 0))
				(client setLoop: temp0 cycleSpeed: 3)
				(if (>= (mainInset mySpeed:) 65)
					(self setScript: crashScript)
				else
					(= cycles 1)
				)
			)
			(2
				(if (>= (mainInset mySpeed:) 45)
					(skidSound play:)
				)
				(if (== local318 1)
					(client setCycle: CT 2 1 self)
				else
					(client setCycle: End self)
				)
			)
			(3
				(skidSound stop:)
				(= temp1 (client x:))
				(= temp2 (client y:))
				(switch register
					(rCross
						(if (!= local318 1)
							(+= temp1 15)
						else
							(+= temp1 20)
							(-= temp2 15)
						)
					)
					(lCross
						(if (mainInset leftFlag:)
							(-= temp1 16)
						else
							(-= temp1 45)
						)
					)
				)
				(client
					xStep: (+ (/ (mainInset mySpeed:) 10) 4)
					setMotion: MoveTo temp1 temp2 self
				)
			)
			(4
				(cond
					((!= local318 1) 0)
					((not (mainInset freewayFlag:))
						(mainInset
							freewayFlag: 1
							calcSpeed: 55
							curUnit: 1
							lastY: 10
						)
						(roadLine loop: 2)
					)
					(else
						(= temp2
							(switch (mainInset lastX:)
								(4 7)
								(5 7)
								(7 5)
								(8 5)
								(10 3)
								(11 3)
							)
						)
						(mainInset
							freewayFlag: 0
							calcSpeed: 35
							curUnit: (/ (mainInset maxUnits:) 2)
							lastY: temp2
						)
						(roadLine loop: 1)
						(if
							(and
								(== gDay 1)
								(IsFlag 211)
								(not (IsFlag 16))
								(not (IsFlag 68))
								(gCast contains: (ScriptID 129 3)) ; suspCar
							)
							((ScriptID 129 3) dispose:) ; suspCar
						)
						(if
							(and
								(== gDay 1)
								(IsFlag 69)
								(not (IsFlag 16))
								(not (IsFlag 215))
							)
							(gCurRoom setScript: offFreewayScript)
						)
					)
				)
				(rCross cue:)
				(lCross cue:)
				(tCross cue:)
				(stopSign cue:)
				(roadLine cue:)
				(client
					x: (+ (roadInset x:) 15)
					y: (- (roadInset y:) 14)
					setLoop: 0
					cel: 0
				)
				(mainInset turning: 0 leftFlag: 0 whichBlocks: getStuff:)
				(roadLine setCycle: Fwd)
				(streetBox cue:)
				(proc130_14)
				(self dispose:)
			)
		)
	)
)

(instance driveWayScript of Script
	(properties)

	(method (doit)
		(super doit:)
		(if
			(and
				(not state)
				(or
					(and
						(== register rCross)
						(> (rCross y:) (- (roadInset y:) 20))
					)
					(and
						(== register lCross)
						(> (lCross y:) (- (roadInset y:) 2))
					)
				)
			)
			(self cue:)
		)
	)

	(method (changeState newState &tmp temp0 temp1 temp2)
		(switch (= state newState)
			(0 0)
			(1
				(if (and (not (IsFlag 59)) (== local316 106))
					(Print 25 0) ; "There's no reason to get out here."
					(mainInset turning: 0)
					(proc130_14)
					(self dispose:)
				else
					(rCross setMotion: 0)
					(lCross setMotion: 0)
					(tCross setMotion: 0)
					(stopSign setMotion: 0)
					(roadLine setCycle: 0)
					(= temp2 (if (== register rCross) 0 else 1))
					(client setLoop: temp2 cycleSpeed: 3)
					(if (>= (mainInset mySpeed:) 65)
						(self setScript: crashScript)
					else
						(= cycles 1)
					)
				)
			)
			(2
				(if (>= (mainInset mySpeed:) 45)
					(skidSound play:)
				)
				(client setCycle: End self)
			)
			(3
				(skidSound stop:)
				(= temp0 (client x:))
				(cond
					((== register rCross)
						(+= temp0 15)
					)
					((mainInset leftFlag:)
						(-= temp0 16)
					)
					(else
						(-= temp0 45)
					)
				)
				(client
					xStep: (+ (/ (mainInset mySpeed:) 10) 4)
					setMotion: MoveTo temp0 (client y:) self
				)
			)
			(4
				((ScriptID 130 4) fade: self) ; carSong
			)
			(5
				(switch local316
					(86
						(if (IsFlag 51)
							(Print 25 1) ; "You didn't respond to the crash in a reasonable amount of time."
							(EgoDead 18) ; "Your failure to respond to the highway call resulted in a suspension. An officer who doesn't report to assigned calls puts the public in danger!"
							(= temp1 0)
						else
							(= temp1 10)
						)
					)
					(106
						(= temp1 (if (== gDay 1) 30 else 31))
					)
				)
				(if temp1
					(gCurRoom newRoom: temp1)
				)
			)
		)
	)
)

(instance offFreewayScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(SetFlag 14)
				(SetFlag 12)
				(SetFlag 13)
				(SetFlag 15)
				(= global127 0)
				(= seconds 10)
			)
			(1
				(HandsOff)
				((ScriptID 130 4) fade:) ; carSong
				(= seconds 5)
			)
			(2
				(gCurRoom newRoom: 890) ; dilema
			)
		)
	)
)

(instance crashScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 130 8) dispose:) ; trackInset
				((ScriptID 130 10) dispose:) ; copBlip
				((ScriptID 130 11) dispose:) ; suspBlip
				(mainInset calcSpeed: 0)
				((ScriptID 130 7) setCycle: CT 1 1 self) ; copCar
				(skidSound play:)
			)
			(1
				((ScriptID 130 7) ; copCar
					yStep: 10
					setMotion:
						MoveTo
						((ScriptID 130 7) x:) ; copCar
						(- ((ScriptID 130 7) y:) 90) ; copCar
						self
				)
			)
			(2
				(rCross dispose:)
				(lCross dispose:)
				(tCross dispose:)
				(stopSign dispose:)
				(stopAhead dispose:)
				(roadInset dispose:)
				(streetFrame dispose:)
				(roadLine dispose:)
				(roadSign dispose:)
				(freewaySign dispose:)
				(endFreeway dispose:)
				(if
					(and
						(IsFlag 211)
						(not (IsFlag 16))
						(not (IsFlag 68))
						(== gDay 1)
					)
					((ScriptID 129 3) dispose:) ; suspCar
					((ScriptID 129 6) dispose:) ; genCar0
					((ScriptID 129 7) dispose:) ; genCar1
					((ScriptID 129 8) dispose:) ; genCar2
					((ScriptID 129 9) dispose:) ; genCar3
					((ScriptID 129 10) dispose:) ; genCar4
				)
				((ScriptID 130 1) dispose:) ; lightBar
				(aspenSign dispose:)
				(streetBox dispose:)
				(boxDir dispose:)
				(boxSt dispose:)
				(lineCover dispose:)
				((ScriptID 130 12) stop:) ; siren
				(= cycles 2)
			)
			(3
				(skidSound stop:)
				(crashSound play: self)
			)
			(4
				(EgoDead 0) ; "Taking those curves a bit fast, aren't you?"
			)
		)
	)
)

(instance onCurbScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				((ScriptID 130 8) dispose:) ; trackInset
				((ScriptID 130 10) dispose:) ; copBlip
				((ScriptID 130 11) dispose:) ; suspBlip
				(skidSound play:)
				(mainInset calcSpeed: 0)
				((ScriptID 130 7) ; copCar
					yStep: 10
					setMotion:
						MoveTo
						((ScriptID 130 7) x:) ; copCar
						(- ((ScriptID 130 7) y:) 150) ; copCar
						self
				)
				(rCross setMotion: 0)
				(lCross setMotion: 0)
				(tCross setMotion: 0)
				(stopSign setMotion: 0)
			)
			(1
				(rCross dispose:)
				(lCross dispose:)
				(tCross dispose:)
				(stopSign dispose:)
				(stopAhead dispose:)
				(roadInset dispose:)
				(streetFrame dispose:)
				(roadLine dispose:)
				(roadSign dispose:)
				(freewaySign dispose:)
				(endFreeway dispose:)
				(if
					(and
						(IsFlag 211)
						(not (IsFlag 16))
						(not (IsFlag 68))
						(== gDay 1)
					)
					((ScriptID 129 3) dispose:) ; suspCar
					((ScriptID 129 6) dispose:) ; genCar0
					((ScriptID 129 7) dispose:) ; genCar1
					((ScriptID 129 8) dispose:) ; genCar2
					((ScriptID 129 9) dispose:) ; genCar3
					((ScriptID 129 10) dispose:) ; genCar4
				)
				((ScriptID 130 1) dispose:) ; lightBar
				(aspenSign dispose:)
				(streetBox dispose:)
				(boxDir dispose:)
				(boxSt dispose:)
				(lineCover dispose:)
				((ScriptID 130 12) stop:) ; siren
				(= cycles 2)
			)
			(2
				(skidSound stop:)
				(crashSound play: self)
			)
			(3
				(EgoDead 1) ; "Those curbs just sneak right up on you, don't they?"
				(self dispose:)
			)
		)
	)
)

(instance changeLanes of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(mainInset leftFlag: -1)
				((ScriptID 130 7) ; copCar
					setMotion:
						MoveTo
						(if (== register 1)
							(- (+ (roadInset x:) 15) 30)
						else
							(+ (roadInset x:) 15)
						)
						((ScriptID 130 7) y:) ; copCar
						self
				)
			)
			(1
				(mainInset leftFlag: register)
				(self dispose:)
			)
		)
	)
)

(instance skidSound of Sound
	(properties
		number 910
	)
)

(instance crashSound of Sound
	(properties
		number 286
	)
)

(instance streetBox of Prop
	(properties
		view 273
		cel 3
		priority 12
		signal 16401
	)

	(method (cue &tmp temp0)
		(= temp0 (mainInset heading:))
		(boxDir cel: (/ temp0 90))
		(boxSt
			loop: (if (OneOf temp0 0 180) 2 else 3)
			cel:
				(if (OneOf temp0 0 180)
					(mainInset lastX:)
				else
					(mainInset lastY:)
				)
		)
	)
)

(instance boxDir of View
	(properties
		view 273
		loop 1
		priority 13
		signal 16400
	)
)

(instance boxSt of View
	(properties
		view 273
		loop 2
		priority 13
		signal 16400
	)
)

(instance roadInset of Prop
	(properties
		x 241
		y 112
		view 263
		priority 1
		signal 16401
	)

	(method (doVerb theVerb invItem)
		(cond
			(
				(and
					(== gDay 1)
					(IsFlag 211)
					(not (IsFlag 16))
					(not (IsFlag 68))
					(gCast contains: (ScriptID 129 3)) ; suspCar
					((ScriptID 129 3) doVerb: theVerb invItem) ; suspCar
				)
				(return)
			)
			((== gTheCursor 200)
				(cond
					((IsObject ((ScriptID 130 7) mover:)) ; copCar
						(return)
					)
					((IsObject (lCross mover:))
						(lCross doVerb: 3)
					)
					((not (mainInset mySpeed:))
						(super doVerb: theVerb invItem)
					)
					((== (mainInset leftFlag:) 1)
						(super doVerb: theVerb invItem)
					)
					(else
						(self setScript: changeLanes 0 1)
					)
				)
			)
			((== gTheCursor 201)
				(cond
					((IsObject ((ScriptID 130 7) mover:)) ; copCar
						(return)
					)
					((== (mainInset leftFlag:) 1)
						(if (mainInset mySpeed:)
							(self setScript: changeLanes 0 0)
						else
							(super doVerb: theVerb invItem)
						)
					)
					((IsObject (rCross mover:))
						(rCross doVerb: 3)
					)
					(else
						(super doVerb: theVerb invItem)
					)
				)
			)
			((== gTheCursor 203)
				(mainInset calcSpeed: (+ (mainInset mySpeed:) 5))
			)
			((== gTheCursor 202)
				(mainInset calcSpeed: (- (mainInset mySpeed:) 5))
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)

	(method (doit &tmp temp0 temp1 temp2 temp3)
		(if
			(and
				(mainInset mySpeed:)
				(not ((ScriptID 130 7) cel:)) ; copCar
				(!= (gCurRoom script:) onCurbScript)
			)
			(Palette palANIMATE 251 254 (/ (- 100 (mainInset mySpeed:)) 10))
		)
		(if z
			(return)
		)
		(= temp0 (User curEvent:))
		(= temp1 (temp0 x:))
		(= temp2 (temp0 y:))
		(if (not (& (temp0 type:) $0007)) ; evMOUSEKEYBOARD | evMOUSERELEASE
			(cond
				((not (User canControl:))
					(return)
				)
				(
					(and
						(== gDay 1)
						(IsFlag 211)
						(not (IsFlag 16))
						(not (IsFlag 68))
						(gCast contains: (ScriptID 129 3)) ; suspCar
						(InRect
							((ScriptID 129 3) nsLeft:) ; suspCar
							((ScriptID 129 3) nsTop:) ; suspCar
							((ScriptID 129 3) nsRight:) ; suspCar
							((ScriptID 129 3) nsBottom:) ; suspCar
							temp1
							temp2
						)
					)
					(if (!= local264 -1)
						(gGame setCursor: local264 1)
						(= local264 -1)
					)
				)
				(
					(InRect
						((ScriptID 130 7) nsLeft:) ; copCar
						(- y local266)
						(- ((ScriptID 130 7) nsRight:) 5) ; copCar
						((ScriptID 130 7) nsTop:) ; copCar
						temp1
						temp2
					)
					(if
						(and
							(!= gTheCursor 203)
							(not
								(OneOf
									(= temp3 (gGame setCursor: 203 1))
									200
									201
									203
									202
								)
							)
						)
						(= local264 temp3)
					)
				)
				(
					(InRect
						((ScriptID 130 7) nsLeft:) ; copCar
						((ScriptID 130 7) y:) ; copCar
						(- ((ScriptID 130 7) nsRight:) 5) ; copCar
						y
						temp1
						temp2
					)
					(if
						(and
							(!= gTheCursor 202)
							(not
								(OneOf
									(= temp3 (gGame setCursor: 202 1))
									200
									201
									203
									202
								)
							)
						)
						(= local264 temp3)
					)
				)
				((InRect (- x local265) (- y local266) x y temp1 temp2)
					(if
						(and
							(!= gTheCursor 200)
							(not
								(OneOf
									(= temp3 (gGame setCursor: 200 1))
									200
									201
									203
									202
								)
							)
						)
						(= local264 temp3)
					)
				)
				((InRect x (- y local266) (+ x local265) y temp1 temp2)
					(if
						(and
							(!= gTheCursor 201)
							(not
								(OneOf
									(= temp3 (gGame setCursor: 201 1))
									200
									201
									203
									202
								)
							)
						)
						(= local264 temp3)
					)
				)
				((!= local264 -1)
					(gGame setCursor: local264 1)
					(= local264 -1)
				)
			)
		)
		(super doit:)
	)
)

(instance streetFrame of View
	(properties
		view 263
		cel 2
		priority 7
		signal 16401
	)

	(method (doVerb theVerb invItem)
		(roadInset doVerb: theVerb invItem)
	)
)

(instance roadLine of Prop
	(properties
		view 263
		loop 1
		priority 2
		signal 16400
	)

	(method (doit)
		(if (mainInset mySpeed:)
			(super doit:)
			(if
				(and
					(IsObject cycler)
					(< (= cycleSpeed (/ (- 70 (mainInset mySpeed:)) 5)) 0)
				)
				(= cycleSpeed 0)
			)
			(if (stopSign mover:)
				(self setCycle: 0 y: (+ (stopSign y:) 95))
			)
		)
	)

	(method (cue)
		(= y (roadInset y:))
		(super cue:)
	)
)

(instance lineCover of Prop
	(properties
		view 274
		loop 4
		priority 3
		signal 16400
	)

	(method (doit)
		(if
			(or
				(and
					(== (rCross y:) (- (roadInset y:) 103))
					(== (lCross y:) (- (roadInset y:) 103))
				)
				(mainInset freewayFlag:)
				(roadInset z:)
				(!= (tCross y:) (- (roadInset y:) 160))
			)
			(= z 1000)
			(return)
		)
		(self
			z:
				(-
					(roadInset y:)
					((if (IsObject (rCross mover:)) rCross else lCross) y:)
				)
		)
		(super doit:)
	)
)

(instance roadSign of Prop
	(properties
		view 260
		loop 5
		priority 8
		signal 16401
	)

	(method (cue &tmp temp0 temp1 temp2 temp3 temp4)
		(if (mainInset freewayFlag:)
			(return)
		)
		(= temp1 0)
		(switch (mainInset heading:)
			(0
				(if
					(and
						(== (mainInset curUnit:) 5)
						(not
							(and
								(&
									(= temp0
										(mainInset
											calcBlocked:
												(mainInset lastX:)
												(- (mainInset lastY:) 1)
										)
									)
									$0002
								)
								(& temp0 $0004)
							)
						)
					)
					(= temp1 1)
					(= temp3
						[local212 (= temp2 (* (- (mainInset lastY:) 1) 2))]
					)
					(= temp4 [local212 (+ temp2 1)])
				)
			)
			(90
				(if
					(and
						(== (mainInset curUnit:) (- (mainInset maxUnits:) 5))
						(not
							(and
								(&
									(= temp0
										(mainInset
											calcBlocked:
												(+ (mainInset lastX:) 1)
												(mainInset lastY:)
										)
									)
									$0002
								)
								(& temp0 $0004)
							)
						)
					)
					(= temp1 1)
					(= temp3
						[local232 (= temp2 (* (+ (mainInset lastX:) 1) 2))]
					)
					(= temp4 [local232 (+ temp2 1)])
				)
			)
			(180
				(if
					(and
						(== (mainInset curUnit:) (- (mainInset maxUnits:) 5))
						(not
							(and
								(&
									(= temp0
										(mainInset
											calcBlocked:
												(mainInset lastX:)
												(+ (mainInset lastY:) 1)
										)
									)
									$0002
								)
								(& temp0 $0004)
							)
						)
					)
					(= temp1 1)
					(= temp3
						[local212 (= temp2 (* (+ (mainInset lastY:) 1) 2))]
					)
					(= temp4 [local212 (+ temp2 1)])
				)
			)
			(270
				(if
					(and
						(== (mainInset curUnit:) 5)
						(not
							(and
								(&
									(= temp0
										(mainInset
											calcBlocked:
												(- (mainInset lastX:) 1)
												(mainInset lastY:)
										)
									)
									$0002
								)
								(& temp0 $0004)
							)
						)
					)
					(= temp1 1)
					(= temp3
						[local232 (= temp2 (* (- (mainInset lastX:) 1) 2))]
					)
					(= temp4 [local232 (+ temp2 1)])
				)
			)
		)
		(if temp1
			(self
				view: 274
				loop: temp3
				cel: temp4
				show:
				setScript: roadSignScript 0 3
			)
		)
	)
)

(instance rCross of Actor
	(properties
		view 260
		loop 3
		cel 1
		priority 2
		signal 26640
	)

	(method (doVerb theVerb invItem)
		(if
			(and
				(or
					(<= y (- (roadInset y:) 3))
					(and (not (mainInset mySpeed:)) (IsObject (tCross mover:)))
				)
				(IsObject mover)
			)
			(mainInset makeATurn: self)
		else
			(super doVerb: theVerb invItem)
		)
	)

	(method (doit)
		(if (and (== view 260) mover)
			(self view: 274 loop: 3 cel: 1)
		)
		(return
			(if (and mover (not (mainInset mySpeed:)))
				0
			else
				(if (not (= yStep (/ (mainInset mySpeed:) 5)))
					(= yStep 1)
				)
				(if (IsObject mover)
					(mover init:)
				)
				(super doit:)
			)
		)
	)

	(method (cue)
		(self view: 260 setMotion: 0 y: (- (roadInset y:) 103))
		(= local318 0)
		(super cue:)
	)
)

(instance lCross of Actor
	(properties
		view 260
		loop 3
		priority 2
		signal 26640
	)

	(method (doVerb theVerb invItem)
		(if
			(and
				(or
					(<= y (- (roadInset y:) 3))
					(and (not (mainInset mySpeed:)) (IsObject (tCross mover:)))
				)
				(IsObject mover)
			)
			(mainInset makeATurn: self)
		else
			(super doVerb: theVerb invItem)
		)
	)

	(method (doit)
		(if (and (== view 260) mover)
			(self view: 274 loop: 3 cel: 0)
		)
		(return
			(if (and mover (not (mainInset mySpeed:)))
				0
			else
				(if (not (= yStep (/ (mainInset mySpeed:) 5)))
					(= yStep 1)
				)
				(if (IsObject mover)
					(mover init:)
				)
				(super doit:)
			)
		)
	)

	(method (cue)
		(self view: 260 setMotion: 0 y: (- (roadInset y:) 103))
		(= local318 0)
		(super cue:)
	)
)

(instance tCross of Actor
	(properties
		view 260
		loop 3
		cel 2
		priority 3
		signal 26640
	)

	(method (doit)
		(if (and (== view 260) mover)
			(self view: 274 loop: 3 cel: 2)
		)
		(return
			(if (and mover (not (mainInset mySpeed:)))
				0
			else
				(if (not (= yStep (/ (mainInset mySpeed:) 5)))
					(= yStep 1)
				)
				(if (IsObject mover)
					(mover init:)
				)
				(super doit:)
				(if (and mover (> y (- ((ScriptID 130 7) y:) 23))) ; copCar
					(HandsOff)
					(gCurRoom setScript: onCurbScript)
				)
			)
		)
	)

	(method (cue)
		(self view: 260 setMotion: 0 y: (- (roadInset y:) 160))
		(super cue:)
	)
)

(instance stopSign of Actor
	(properties
		view 260
		loop 3
		cel 4
		priority 3
		signal 26640
	)

	(method (doit)
		(if (and (== view 260) mover)
			(self view: 274 loop: 3 cel: 4)
		)
		(if (and mover (not (mainInset mySpeed:)))
			(mainInset stopFlag: 0)
		else
			(if (not (= yStep (/ (mainInset mySpeed:) 5)))
				(= yStep 1)
			)
			(if (IsObject mover)
				(mover init:)
			)
			(super doit:)
			(if
				(and
					(mainInset stopFlag:)
					(> y (- ((ScriptID 130 7) y:) 10)) ; copCar
					(not ((ScriptID 130 1) cycler:)) ; lightBar
				)
				(Print 25 2) ; "You're supposed to be setting an example with your driving, Bonds. There's no excuse for running stop signs."
				(if (< (-= gScore 5) 0)
					(= gScore 0)
				)
				(if (not (mod (++ global139) 5))
					(Printf 25 3 (* global139 5)) ; "In fact, your flagrant disregard for traffic laws has cost you %d points so far."
				)
				(mainInset stopFlag: 0)
			)
		)
	)

	(method (cue)
		(self view: 260 setMotion: 0 y: (- (roadInset y:) 102))
		(super cue:)
	)
)

(instance stopAhead of Actor
	(properties
		view 260
		loop 3
		cel 3
		priority 3
		signal 26640
	)

	(method (doit)
		(if (and (== view 260) mover)
			(self view: 274 loop: 3 cel: 3)
		)
		(return
			(if (and mover (not (mainInset mySpeed:)))
				0
			else
				(if (not (= yStep (/ (mainInset mySpeed:) 5)))
					(= yStep 1)
				)
				(if (IsObject mover)
					(mover init:)
				)
				(super doit:)
			)
		)
	)

	(method (cue)
		(self view: 260 setMotion: 0 y: (- (roadInset y:) 102))
		(super cue:)
	)
)

(instance endFreeway of Prop
	(properties
		view 260
		loop 5
		cel 6
		priority 8
		signal 16401
	)

	(method (doit)
		(cond
			(script 0)
			(
				(or
					(not (mainInset freewayFlag:))
					(not (OneOf (mainInset rightBlock:) 145 171))
				)
				(return)
			)
			(
				(and
					(== (mainInset curUnit:) (/ (mainInset maxUnits:) 2))
					(or
						(and
							(== (mainInset rightBlock:) 145)
							(== (mainInset heading:) 270)
						)
						(and
							(== (mainInset rightBlock:) 171)
							(== (mainInset heading:) 90)
						)
					)
				)
				(self
					view: 274
					loop: 5
					cel: 6
					show:
					setScript: roadSignScript 0 3
				)
			)
		)
		(super doit:)
	)
)

(instance freewaySign of Prop
	(properties
		view 260
		loop 5
		priority 8
		signal 16401
	)

	(method (init)
		(super init:)
		(= [local267 10]
			(= [local267 18]
				(= [local267 22]
					(= [local267 26]
						(= [local267 30]
							(= [local267 34] (- (mainInset maxUnits:) 5))
						)
					)
				)
			)
		)
	)

	(method (doit &tmp temp0)
		(cond
			(
				(not
					(OneOf
						(mainInset rightBlock:)
						42
						71
						72
						100
						101
						130
						148
						151
						154
						164
						167
						170
					)
				)
				(return)
			)
			(script 0)
			(else
				(for ((= temp0 0)) (< temp0 48) ((+= temp0 4))
					(if
						(and
							(== (mainInset rightBlock:) [local267 temp0])
							(== (mainInset heading:) [local267 (+ temp0 1)])
							(== (mainInset curUnit:) [local267 (+ temp0 2)])
						)
						(self
							view: 274
							loop: 5
							cel: [local267 (+ temp0 3)]
							show:
							setScript: roadSignScript 0 3
						)
					)
				)
			)
		)
		(super doit:)
	)
)

(instance aspenSign of Prop
	(properties
		view 260
		loop 8
		priority 8
		signal 16401
	)

	(method (doit &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= temp4 (mainInset rightBlock:))
		(if
			(or
				(mainInset turning:)
				(mainInset freewayFlag:)
				(not (OneOf temp4 68 69 72 73 86 87 88 89 90 106 141 157))
			)
			(return)
		)
		(if script
			(super doit:)
			(return)
		)
		(= temp1 0)
		(= temp2 (mainInset curUnit:))
		(= temp3 (mainInset maxUnits:))
		(= temp5 (mainInset leftBlock:))
		(= temp6 (mainInset heading:))
		(cond
			(
				(or
					(and (== temp4 86) (== temp5 87))
					(and (== temp4 87) (== temp5 86))
				)
				(if (and (== temp6 0) (== temp2 (- temp3 10)))
					(= temp1 1)
					(= temp0 1)
				)
				(if (and (== temp6 180) (== temp2 10))
					(= temp1 1)
					(= temp0 6)
				)
			)
			(
				(or
					(and (== temp4 141) (== temp5 157))
					(and (== temp4 157) (== temp5 141))
				)
				(if (and (== temp6 90) (== temp2 10))
					(= temp1 1)
					(= temp0 0)
				)
				(if (and (== temp6 270) (== temp2 (- temp3 10)))
					(= temp1 1)
					(= temp0 0)
				)
			)
			(
				(or
					(and (== temp4 69) (== temp5 68))
					(and (== temp4 68) (== temp5 69))
				)
				(if (and (== temp6 0) (== temp2 (- temp3 10)))
					(= temp1 1)
					(= temp0 2)
				)
				(if (and (== temp6 180) (== temp2 10))
					(= temp1 1)
					(= temp0 2)
				)
			)
			(
				(or
					(and (== temp4 106) (== temp5 90))
					(and (== temp4 90) (== temp5 106))
				)
				(if (and (== temp6 270) (== temp2 (- temp3 10)))
					(= temp1 1)
					(= temp0 3)
				)
				(if (and (== temp6 90) (== temp2 10))
					(= temp1 1)
					(= temp0 7)
				)
			)
			(
				(or
					(and (== temp4 89) (== temp5 88))
					(and (== temp4 88) (== temp5 89))
				)
				(if (and (== temp6 0) (== temp2 (- temp3 10)))
					(= temp1 1)
					(= temp0 4)
				)
				(if (and (== temp6 180) (== temp2 10))
					(= temp1 1)
					(= temp0 4)
				)
			)
			(
				(or
					(and (== temp4 73) (== temp5 72))
					(and (== temp4 72) (== temp5 73))
				)
				(if (and (== temp6 0) (== temp2 (- temp3 10)))
					(= temp1 1)
					(= temp0 5)
				)
				(if (and (== temp6 180) (== temp2 10))
					(= temp1 1)
					(= temp0 5)
				)
			)
		)
		(if temp1
			(self
				view: 274
				loop: 8
				cel: temp0
				show:
				setScript: roadSignScript 0 3
			)
		)
		(super doit:)
	)
)

(instance theRoom of Feature
	(properties
		nsBottom 190
		nsRight 320
	)

	(method (doVerb theVerb invItem &tmp temp0 temp1)
		(switch theVerb
			(1 ; Walk
				(cond
					((mainInset mySpeed:)
						(Print 25 4) ; "Jumping from a moving car is only done in the movies, Bonds."
					)
					((or (IsObject (rCross mover:)) (IsObject (lCross mover:)))
						(Print 25 5) ; "You can't leave you car in the middle of an intersection."
					)
					((== gPrevRoomNum 12)
						(gCurRoom newRoom: 12)
					)
					(
						(or
							(and
								(gEgo has: 23) ; license
								(!= ((gInventory at: 23) state:) 4) ; license
							)
							(and
								(== ((gInventory at: 2) owner:) 885) ; handcuff
								(not (IsFlag 16))
							)
							(and
								(mainInset freewayFlag:)
								(== global127 5)
								(IsFlag 14)
								(== gPrevRoomNum 29)
							)
						)
						(gCurRoom newRoom: 29)
					)
					(else
						(= temp0 -1)
						(= temp1 0)
						(while (!= [local181 (++ temp0)] -1)
							(if
								(and
									(== ([local181 temp0] type:) 5)
									(or
										(and
											(==
												([local181 temp0] whatBlock:)
												(mainInset rightBlock:)
											)
											(==
												([local181 temp0] whatSide:)
												(localproc_0)
											)
										)
										(and
											(==
												([local181 temp0] whatBlock:)
												(mainInset leftBlock:)
											)
											(==
												([local181 temp0] whatSide:)
												(localproc_1)
											)
										)
									)
									(!= ([local181 temp0] whatUnit:) 999)
								)
								(= temp1 1)
								(break)
							)
						)
						(cond
							((not temp1)
								(if
									(and
										(> gDay 1)
										(or
											(and
												(== 69 (mainInset rightBlock:))
												(== 3 (localproc_0))
											)
											(and
												(== 68 (mainInset leftBlock:))
												(== 2 (localproc_1))
											)
										)
									)
									(Print 25 6) ; "You decide to wait until after your shift to check in on Marie."
								else
									(Print 25 0) ; "There's no reason to get out here."
								)
							)
							(
								(and
									(OneOf
										([local181 temp0] whatUnit:)
										30
										31
									)
									(not (IsFlag 59))
								)
								(Print 25 0) ; "There's no reason to get out here."
							)
							(else
								(gCurRoom newRoom: ([local181 temp0] whatUnit:))
							)
						)
					)
				)
			)
			(else
				(super doVerb: theVerb invItem)
			)
		)
	)
)

