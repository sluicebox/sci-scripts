;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 71)
(include sci.sh)
(use Main)
(use PQRegion)
(use System)

(public
	crisisRegion 0
)

(class ScenerioRegion of PQRegion
	(properties
		targetRoomNum -1
		usedMirror 0
		warnedOfSuspect 0
		slicedPie 0
		rolledOut 0
		resetData 1
		leftEarly 0
		flashBanged 0
		shotgunBreach 0
		dataNumber 0
		curIdx 0
		criticalRoom 0
		curRoomFrames 0
		maxRoomFrames 0
		curFrameNum 0
		maxFrameCount 0
		ticks 0
		lastTicks 0
		pathPaused 0
		cueVal 0
		cycleSpeed 6
		curColIdx 0
		curRowIdx 0
	)

	(method (init)
		(= lastTicks (= cueVal 0))
		(super init: &rest)
		(if (>= maxRoomFrames 0)
			(self adjustForNewRoom: gNewRoomNum)
		)
	)

	(method (dispose)
		(ClearFlag 12)
		(gSwatInterface closeInvWindow:)
		(super dispose:)
	)

	(method (clearData param1)
		(= targetRoomNum (if (not argc) -1 else param1))
		(= shotgunBreach
			(= leftEarly (= usedMirror (= slicedPie (= rolledOut 0))))
		)
	)

	(method (useMirror param1)
		(if (!= param1 targetRoomNum)
			(self clearData: param1)
		)
		(= usedMirror 1)
	)

	(method (slicePie param1)
		(if (!= param1 targetRoomNum)
			(self clearData: param1)
		)
		(= slicedPie 1)
	)

	(method (rollOut param1)
		(if (!= param1 targetRoomNum)
			(self clearData: param1)
		)
		(= rolledOut 1)
	)

	(method (suspectSpotted param1)
		(if (!= param1 targetRoomNum)
			(self clearData: param1)
		)
		(= warnedOfSuspect 1)
	)

	(method (threwFlash param1)
		(if (!= param1 targetRoomNum)
			(self clearData: param1)
		)
		(= flashBanged 1)
	)

	(method (doVerb))

	(method (startPath param1 param2 &tmp [temp0 2] temp2)
		(= dataNumber param1)
		(= pathPaused (= curFrameNum (= lastTicks 0)))
		(= curColIdx 1)
		(= curRoomFrames (= maxRoomFrames (= curRowIdx 0)))
		(= ticks (= cycleSpeed 6))
		(= maxFrameCount ((ScriptID dataNumber 0) maxFrames:))
		(self getRoomData: 0)
		(if (> argc 1)
			(= temp2 param2)
		else
			(= temp2 gCurRoomNum)
		)
		(if (!= criticalRoom temp2)
			(self adjustForNewRoom: temp2)
		)
	)

	(method (at param1 param2 &tmp temp0)
		(if (not dataNumber)
			(return -1)
		)
		(= temp0 ((ScriptID dataNumber 0) numColumns:))
		(return ((ScriptID dataNumber 0) at: (+ (* param2 temp0) param1)))
	)

	(method (getRoomData param1 &tmp temp0 temp1 temp2 temp3)
		(= temp1 -1)
		(if (< curColIdx ((ScriptID dataNumber) numColumns:))
			(= temp0 curRowIdx)
			(while 1
				(if
					(and
						(!= (self at: 0 temp0) -1)
						(< curColIdx ((ScriptID dataNumber) numColumns:))
					)
					(switch (= temp1 (self at: curColIdx temp0))
						(-1
							(++ temp0)
						)
						(-2
							(++ curColIdx)
						)
						(else
							(break)
						)
					)
				else
					(self stopPath:)
					(break)
				)
				0
			)
			(if (!= temp1 -1)
				(= curRowIdx temp0)
			)
		else
			(self stopPath:)
			(return)
		)
		(if (== temp1 -1)
			(return)
		)
		(= temp3 criticalRoom)
		(if (!= (= criticalRoom (self at: 0 curRowIdx)) -1)
			(= temp2 0)
			(if curRoomFrames
				(= curRoomFrames (self getPercent: 0 temp1))
			)
			(= maxRoomFrames temp1)
		else
			(self stopPath:)
		)
		(if
			(and
				(!= temp3 criticalRoom)
				(== gNewRoomNum gCurRoomNum)
				(or (not argc) param1)
			)
			(gCurRoom criticalAlert:)
		)
	)

	(method (doit &tmp temp0 temp1)
		(super doit: &rest)
		(if (and (not pathPaused) (> maxRoomFrames 0))
			(= temp0 0)
			(if (!= gNewRoomNum gCurRoomNum)
				(= lastTicks gGameTime)
				(return)
			)
			(if (not lastTicks)
				(= lastTicks gGameTime)
			)
			(if
				(or
					(and
						gAutoRobot
						(<= (-= ticks (Abs (- gGameTime lastTicks))) 0)
					)
					(and
						(not gAutoRobot)
						(< (-= cycleSpeed (Abs (- gGameTime lastTicks))) 0)
					)
				)
				(= temp0
					(if gAutoRobot
						(+ 1 (/ (Abs ticks) 6))
					else
						1
					)
				)
				(= cycleSpeed (= ticks 6))
				(= lastTicks gGameTime)
				(if maxFrameCount
					(+= curFrameNum temp0)
				)
				(+= curRoomFrames temp0)
				(cond
					((and maxFrameCount (>= curFrameNum maxFrameCount))
						(self stopPath:)
						(gCurRoom criticalAlert:)
					)
					((>= curRoomFrames maxRoomFrames)
						(self endColumn:)
						(gCurRoom criticalAlert:)
					)
					((and cueVal (>= curRoomFrames cueVal))
						(= cueVal 0)
						(gCurRoom criticalAlert:)
					)
				)
			)
			(= lastTicks gGameTime)
		)
	)

	(method (stopPath)
		(if dataNumber
			(DisposeScript dataNumber)
			(= ticks
				(= lastTicks
					(= pathPaused
						(= curColIdx
							(= curRowIdx
								(= maxRoomFrames
									(= curFrameNum
										(= maxFrameCount
											(= dataNumber
												(= criticalRoom
													(= curRoomFrames 0)
												)
											)
										)
									)
								)
							)
						)
					)
				)
			)
			(= cycleSpeed 6)
		)
	)

	(method (pausePath param1)
		(if (or (not argc) param1)
			(++ pathPaused)
		)
		(if (and argc (not param1) pathPaused)
			(-- pathPaused)
		)
		(= lastTicks 0)
	)

	(method (getPercent param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5)
		(= temp0
			(cond
				((or (not maxRoomFrames) (not curRoomFrames)) 0)
				((> maxRoomFrames 320)
					(= temp3 (/ (* curRoomFrames 10) (/ maxRoomFrames 10)))
					(Min temp3 100)
				)
				(else
					(/ (* curRoomFrames 100) maxRoomFrames)
				)
			)
		)
		(if (not argc)
			(return temp0)
		)
		(if (< argc 2)
			(return [param1 0])
		)
		(if (> (= temp1 (- [param1 1] [param1 0])) 320)
			(= temp4 (/ temp1 10))
			(if (= temp5 (/ temp0 10))
				(= temp2 (* (/ temp4 temp5) 10))
			else
				(= temp2 0)
			)
		else
			(= temp2 (/ (* temp0 temp1) 100))
		)
		(return (+= temp2 [param1 0]))
	)

	(method (setCueVal param1)
		(if (> param1 curRoomFrames)
			(= cueVal param1)
			(return 1)
		)
		(return 0)
	)

	(method (adjustForNewRoom param1 &tmp temp0 temp1 temp2)
		(= temp0 0)
		(= temp1 -1)
		0
		(while 1
			(= temp1 (self at: 0 temp0))
			(if (OneOf temp1 param1 0 -1)
				(break)
			)
			(++ temp0)
		)
		(if (== temp1 -1)
			(self stopPath:)
			(return)
		)
		(switch (= temp2 (self at: curColIdx temp0))
			(-1
				(return)
			)
			(-2
				(++ curColIdx)
				(= curRoomFrames (= maxRoomFrames 0))
				(while (and 1 (< (= temp2 (self at: curColIdx temp0)) 0))
					(++ curColIdx)
				)
			)
		)
		(= curRowIdx temp0)
		(self getRoomData: 0)
	)

	(method (endColumn)
		(= cueVal (= curRoomFrames (= maxRoomFrames 0)))
		(++ curColIdx)
		(self getRoomData: 0)
		(if (!= criticalRoom gCurRoomNum)
			(self adjustForNewRoom: gCurRoomNum)
		)
	)
)

(class CriticalPath of Obj
	(properties
		maxFrames 0
		numColumns 1
	)

	(method (at)
		(return -1)
	)
)

(instance crisisRegion of ScenerioRegion
	(properties)

	(method (init)
		(super init: &rest)
		(= number 71)
		(= initialized 0)
	)

	(method (setKeep)
		(= keep (IsFlag 109))
	)
)

