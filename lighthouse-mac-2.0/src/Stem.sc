;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 17)
(include sci.sh)
(use Main)
(use Feature)
(use Actor)
(use System)

(class Stem of List
	(properties
		stemView -1
		stemLoop 0
		stemX 0
		stemY 0
		stemPri -1
		enabled 1
		toggleKey -1
	)

	(method (placeSelf param1 param2)
		(param1
			view: stemView
			loop: stemLoop
			cel: (and (> argc 1) param2)
			posn: stemX stemY
			setPri: stemPri
		)
	)

	(method (add param1 param2 param3 param4 param5)
		(self
			stemView: param1
			stemLoop: param2
			stemX: param3
			stemY: param4
			stemPri: param5
		)
		(super add: &rest)
	)

	(method (keyTest param1)
		(return (== toggleKey param1))
	)
)

(class StemTracker of Feature
	(properties
		stemList -1
		stemView -1
		curStem 0
		curStemIndex 0
		destStem -1
		destCel -1
		keyTracking 0
		autoCenter 1
		useKey 0
		tracking 0
		notifyCode -1
		forcedMove 0
		closestCel -1
		keyMove 0
	)

	(method (init)
		(super init: &rest)
		(gKeyDownHandler add: self)
		(= stemList (Set new:))
		(= stemView (View new:))
	)

	(method (dispose)
		(if (!= stemList -1)
			(stemList release:)
			(stemList dispose:)
			(= stemList -1)
		)
		(if (!= stemView -1)
			(stemView dispose:)
			(= stemView -1)
		)
		(if forcedMove
			(gTheDoits delete: self)
			(= forcedMove 0)
		)
		(if keyTracking
			(= keyTracking 0)
			(gKeyDownHandler delete: self)
		)
		(if tracking
			(self track: 0)
		)
		(= curStem 0)
		(super dispose: &rest)
	)

	(method (enableStem param1 param2 &tmp temp0)
		((= temp0 (stemList at: param1)) enabled: (if (> argc 1) param2 else 1))
	)

	(method (moveTo param1 param2)
		(= destStem (stemList at: param1))
		(= destCel param2)
		(if tracking
			(self track: 0)
		)
		(= forcedMove 1)
		(gTheDoits add: self)
	)

	(method (jumpTo param1 param2)
		((= curStem (stemList at: param1)) placeSelf: stemView param2)
		(= curStemIndex param1)
	)

	(method (addStem param1 param2 param3 param4 param5 param6 &tmp temp0)
		(if (== stemList -1)
			(self init:)
		)
		(= temp0 (Stem new:))
		(temp0 add: param1 param2 param3 param4 param5 &rest)
		(if (!= param6 -1)
			(if (not keyTracking)
				(= keyTracking 1)
				(gKeyDownHandler add: self)
			)
			(temp0 toggleKey: param6)
		)
		(stemList add: temp0)
		(if (not curStem)
			((= curStem temp0) placeSelf: stemView)
			(= curStemIndex 0)
			(stemView init:)
		)
		(return temp0)
	)

	(method (doit)
		(if (and forcedMove (self nextCel:))
			(= forcedMove 0)
			(gTheDoits delete: self)
		)
		(super doit: &rest)
	)

	(method (handleEvent event &tmp temp0)
		(cond
			((and keyTracking (& (event type:) evKEYBOARD) (not keyMove))
				(if (= temp0 (stemList firstTrue: #keyTest (event message:)))
					(= keyMove (temp0 toggleKey:))
					(self moveTo: (stemList indexOf: temp0))
				)
			)
			((and (== keyMove (event message:)) (& (event type:) evKEYUP))
				(= keyMove 0)
				(self moveTo: 0 0)
			)
			(
				(and
					(& (event type:) evMOUSEBUTTON)
					(== (gUser curVerb:) 5)
					(self onMe: event)
					(not tracking)
				)
				(self track: 1)
			)
			((not tracking)
				(return 0)
			)
			((not (& (event type:) evMOUSERELEASE))
				(event localize: (gCast plane:))
				(self findClosestPoint: event)
				(self nextCel:)
			)
			(else
				(self track: 0)
				(self doMouseUp:)
			)
		)
		(event claimed: temp0)
	)

	(method (track param1)
		(if forcedMove
			(= forcedMove 0)
			(gTheDoits delete: self)
		)
		(if (or (= tracking param1) (not argc))
			(global206 add: self)
		else
			(global206 delete: self)
		)
	)

	(method (findClosestPoint param1 &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp4 -1)
		(= temp1 (stemList size:))
		(for ((= temp0 0)) (< temp0 temp1) ((++ temp0))
			(= temp2 (stemList at: temp0))
			(if (temp2 enabled:)
				(= temp3 (self findClosestInStem: temp2 param1))
				(if (or (== temp4 -1) (< temp3 temp4))
					(= temp4 temp3)
					(= destStem temp2)
					(= destCel closestCel)
				)
			)
		)
	)

	(method (findClosestInStem param1 param2 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= temp0 (param1 size:))
		(= temp1 -1)
		(for ((= temp6 0)) (< temp6 temp0) ((+= temp6 2))
			(= temp4 (param1 at: temp6))
			(= temp5 (param1 at: (+ temp6 1)))
			(= temp2
				(Abs
					(GetDistance
						(+ temp4 (param1 stemX:))
						(+ temp5 (param1 stemY:))
						(param2 x:)
						(param2 y:)
					)
				)
			)
			(if (or (== temp1 -1) (< temp2 temp3)) ; UNINIT
				(= temp1 temp6)
				(= temp3 temp2)
			)
		)
		(if temp1
			(/= temp1 2)
		)
		(= closestCel temp1)
		(return temp3)
	)

	(method (nextCel)
		(cond
			((== curStem destStem)
				(cond
					((< (stemView cel:) destCel)
						(stemView cel: (+ (stemView cel:) 1))
					)
					((> (stemView cel:) destCel)
						(stemView cel: (- (stemView cel:) 1))
					)
					(else
						(return 1)
					)
				)
			)
			((stemView cel:)
				(stemView cel: (- (stemView cel:) 1))
			)
			((and useKey curStemIndex)
				((= curStem (stemList at: 0)) placeSelf: stemView)
				(= curStemIndex 0)
			)
			(else
				((= curStem destStem) placeSelf: stemView)
				(= curStemIndex (stemList indexOf: curStem))
			)
		)
		(if (!= notifyCode -1)
			(notifyCode doit: curStemIndex (stemView cel:))
		)
		(self celChange: curStemIndex (stemView cel:))
		(return 0)
	)

	(method (celChange))

	(method (doMouseUp))
)

