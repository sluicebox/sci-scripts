;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 16)
(include sci.sh)
(use Main)
(use KeyMouse)
(use Actor)
(use System)

(class TrackingView of Prop
	(properties
		associatedObj 0
		trackingCode 0
		prevSignal 0
		normalCel 0
		hiCel 1
		offsetX 0
		offsetY 0
	)

	(method (enterKey)
		(self flash:)
		(gSound2 play: 901)
	)

	(method (addKeyMouse)
		((KeyMouse objList:) add: self)
	)

	(method (deleteKeyMouse)
		((KeyMouse objList:) delete: self)
	)

	(method (handleEvent event &tmp temp0)
		(= temp0 0)
		(if
			(and
				(not (event claimed:))
				(not (& (event type:) evMOUSERELEASE))
				(<= nsLeft (event x:) (- nsRight 1))
				(<= nsTop (event y:) (- nsBottom 1))
			)
			(cond
				((proc0_2 event)
					(self enterKey:)
					(= temp0 1)
					(event claimed: 1)
				)
				((& (event type:) evMOUSEBUTTON)
					(if (= temp0 (self track:))
						(gSound2 play: 901)
					)
					(event claimed: 1)
				)
			)
		)
		(return temp0)
	)

	(method (track &tmp temp0 temp1 temp2 temp3 temp4)
		(= temp0 0)
		(self prevSignal: signal)
		(= cel hiCel)
		((= temp2 (List new:)) add: self)
		(if associatedObj
			(if (associatedObj isKindOf: Collect)
				(for ((= temp3 0)) (< temp3 (associatedObj size:)) ((++ temp3))
					(temp2 add: (associatedObj at: temp3))
				)
			else
				(temp2 add: associatedObj)
			)
		)
		(proc0_9 (temp2 elements:) 0)
		(if trackingCode
			(trackingCode init: self)
		)
		(while (!= evMOUSERELEASE ((= temp1 (Event new:)) type:))
			(= gGameTime (+ gTickOffset (GetTime)))
			(= temp4 (self onMe: temp1))
			(if (!= cel temp4)
				(= cel temp4)
				(if (== (temp2 size:) 1)
					(proc0_9 (temp2 elements:) 0)
				)
			)
			(if (> (temp2 size:) 1)
				(proc0_9 (temp2 elements:) 0)
			)
			(if trackingCode
				(trackingCode doit: self)
			)
			(temp1 dispose:)
		)
		(if (== cel hiCel)
			(= temp0 cel)
		)
		(= cel normalCel)
		(proc0_9 (temp2 elements:) 0)
		(if trackingCode
			(trackingCode dispose: self)
		)
		(temp2 release: dispose:)
		(temp1 dispose:)
		(self signal: prevSignal)
		(return temp0)
	)

	(method (flash &tmp temp0 temp1)
		(= cel hiCel)
		((= temp0 (List new:)) add: self)
		(if associatedObj
			(if (associatedObj isKindOf: Collect)
				(for ((= temp1 0)) (< temp1 (associatedObj size:)) ((++ temp1))
					(temp0 add: (associatedObj at: temp1))
				)
			else
				(temp0 add: associatedObj)
			)
		)
		(proc0_9 (temp0 elements:) 0)
		(= cel normalCel)
		(proc0_9 (temp0 elements:) 0)
		(temp0 release: dispose:)
	)
)

(class DragableActor of Actor
	(properties
		cycleSpeed 3
		moveSpeed 3
		hiView -1
		hiLoop -1
		hiCel -1
		prevX 0
		prevY 0
		prevView 0
		prevLoop 0
		prevCel 0
		prevSignal 0
		draggingCode 0
		dragable 1
		associatedObj 0
		owner 0
		offsetX 0
		offsetY 0
	)

	(method (addKeyMouse)
		((KeyMouse objList:) add: self)
	)

	(method (deleteKeyMouse)
		((KeyMouse objList:) delete: self)
	)

	(method (handleEvent event &tmp temp0)
		(= temp0 0)
		(if
			(and
				(not (event claimed:))
				(<= nsLeft (event x:) (- nsRight 1))
				(<= nsTop (event y:) (- nsBottom 1))
			)
			(cond
				((proc0_2 event)
					(event claimed: 1)
					(= temp0 1)
				)
				((& (event type:) evMOUSEBUTTON)
					(event claimed: 1)
					(= temp0 1)
				)
			)
		)
		(return temp0)
	)

	(method (processEvent param1 &tmp temp0)
		(cond
			((& (param1 type:) $0001)
				(if (self respondsTo: #owner)
					(if (owner owner:)
						(gAniList add: (owner owner:))
					)
					(for ((= temp0 0)) (< temp0 (owner size:)) ((++ temp0))
						(gAniList add: (owner at: temp0))
					)
				)
				(return (self track:))
			)
			((proc0_2 param1)
				(return (self flash:))
			)
		)
		(= global189 0)
		(return 0)
	)

	(method (track &tmp temp0 temp1 temp2 [temp3 2] temp5 temp6)
		(if associatedObj
			(if (associatedObj isKindOf: Collect)
				(for ((= temp6 0)) (< temp6 (associatedObj size:)) ((++ temp6))
					(gAniList add: (associatedObj at: temp6))
				)
			else
				(gAniList add: associatedObj)
			)
		)
		(= global291 priority)
		(self setPri: 15)
		(= temp0 (- x (gMouseCursor x:)))
		(= temp1 (- y (gMouseCursor y:)))
		(self saveData: hilite:)
		(= global189 self)
		(gAniList add: self)
		(if (gAbsoluteCast size:)
			(for ((= temp6 0)) (< temp6 (gAbsoluteCast size:)) ((++ temp6))
				(gAniList add: (gAbsoluteCast at: temp6))
			)
		)
		(self prevSignal: signal)
		(proc0_9 (gAniList elements:) 0)
		(if draggingCode
			(draggingCode init: self)
		)
		(= temp5 1)
		(while (!= evMOUSERELEASE ((= temp2 (Event new:)) type:))
			(= gGameTime (+ gTickOffset (GetTime)))
			(= gMouseX (temp2 x:))
			(= gMouseY (temp2 y:))
			(cond
				(dragable
					(self x: (+ (temp2 x:) temp0) y: (+ (temp2 y:) temp1))
				)
				(
					(and
						(<= nsLeft gMouseX (- nsRight 1))
						(<= nsTop gMouseY (- nsBottom 1))
					)
					(= temp5 1)
					(self hilite: 1)
				)
				(else
					(= temp5 0)
					(self dim: 1)
				)
			)
			(if draggingCode
				(draggingCode doit: self)
			)
			(proc0_9 (gAniList elements:) 0)
			(temp2 dispose:)
		)
		(if dragable
			(= gMouseX (temp2 x:))
			(= gMouseY (temp2 y:))
		)
		(if draggingCode
			(draggingCode dispose: self)
		)
		(temp2 dispose:)
		(proc0_9 (gAniList elements:) 0)
		(gAniList release:)
		(return temp5)
	)

	(method (flash)
		(= global189 self)
		(return 2)
	)

	(method (dim param1)
		(if (and (== hiView -1) (== hiLoop -1) (== hiCel -1))
			(return)
		)
		(if
			(or
				(not argc)
				(and param1 (== hiView view) (== hiLoop loop) (== hiCel cel))
			)
			(self view: prevView loop: prevLoop cel: prevCel signal: prevSignal)
		)
	)

	(method (hilite param1)
		(if (and (== hiView -1) (== hiLoop -1) (== hiCel -1))
			(return)
		)
		(if
			(or
				(not argc)
				(and
					param1
					(or (!= hiView view) (!= hiLoop loop) (!= hiCel cel))
				)
			)
			(self saveData:)
			(if (!= hiView -1)
				(self view: hiView)
			)
			(if (!= hiLoop -1)
				(self loop: hiLoop)
			)
			(if (!= hiCel -1)
				(self cel: hiCel)
			)
		)
	)

	(method (saveData)
		(= prevX x)
		(= prevY y)
		(= prevView view)
		(= prevLoop loop)
		(= prevCel cel)
		(= prevSignal signal)
	)
)

