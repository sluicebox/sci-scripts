;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 923)
(include sci.sh)
(use Main)
(use Actor)
(use System)

(class Inset of Code
	(properties
		picture 0
		anOverlay 0
		style 100
		view 0
		loop 0
		cel 0
		x 0
		y 0
		priority 14
		register 0
		hideTheCast 0
		caller 0
		owner 0
		script 0
		oldCast 0
		oldFeatures 0
		oldATPs 0
		oldMH 0
		oldKH 0
		oldDH 0
		oldWH 0
		oldObstacles 0
		oldStyle 0
		inset 0
		disposeNotOnMe 0
		modNum -1
		noun 0
		insetView 0
	)

	(method (setInset theInset who reg)
		(if inset
			(inset dispose:)
		)
		(if (and argc theInset)
			(theInset
				init:
					(if (>= argc 2) who else 0)
					self
					(if (>= argc 3) reg else 0)
			)
		)
	)

	(method (init whoCares theRoomOrInset reg)
		(= owner theRoomOrInset)
		(owner inset: self)
		(= register reg)
		(= caller whoCares)
		(if hideTheCast
			(self hideCast: 1)
		)
		(= oldCast gCast)
		(= oldFeatures gFeatures)
		(= oldATPs gAddToPics)
		(= oldMH gMouseDownHandler)
		(= oldKH gKeyDownHandler)
		(= oldDH gDirectionHandler)
		(= oldWH gWalkHandler)
		(= oldObstacles (gCurRoom obstacles:))
		(gCurRoom obstacles: ((List new:) add: yourself:))
		((= gCast (EventHandler new:)) name: {newCast} add:)
		((= gFeatures (EventHandler new:)) name: {newFeatures} add: self)
		((= gAddToPics (EventHandler new:)) name: {newATPs} add:)
		((= gMouseDownHandler (EventHandler new:)) name: {newMH} add: self)
		((= gKeyDownHandler (EventHandler new:)) name: {newKH} add: self)
		((= gDirectionHandler (EventHandler new:)) name: {newDH} add: self)
		((= gWalkHandler (EventHandler new:)) name: {newWH} add:)
		(gTheDoits add: self)
		(self drawInset:)
	)

	(method (drawInset)
		(if (> picture 0)
			(if global169
				(DrawPic picture 15 (if anOverlay 0 else 1))
			else
				(DrawPic
					picture
					(if anOverlay 100 else style)
					(if anOverlay 0 else 1)
				)
			)
		)
		(if view
			(= insetView
				((inView new:)
					view: view
					loop: loop
					cel: cel
					x: x
					y: y
					setPri: priority
					ignoreActors: 1
					init:
					yourself:
				)
			)
		)
	)

	(method (restore)
		(self drawInset:)
		(if inset
			((inset oldATPs:) doit:)
			(inset restore:)
		)
	)

	(method (handleEvent event &tmp [temp0 2])
		(cond
			((and inset (inset handleEvent: event)) 0)
			((& (event type:) evVERB)
				(cond
					((self onMe: event)
						(event claimed: 1)
						(self doVerb: (event message:))
					)
					(disposeNotOnMe
						(event claimed: 1)
						(self dispose:)
					)
					(else
						(return 0)
					)
				)
			)
		)
	)

	(method (onMe theObjOrX theY &tmp oX oY)
		(if (IsObject theObjOrX)
			(= oX (theObjOrX x:))
			(= oY (theObjOrX y:))
		else
			(= oX theObjOrX)
			(= oY theY)
		)
		(if view
			(return (insetView onMe: theObjOrX theY))
		else
			(return 1)
		)
	)

	(method (doVerb theVerb)
		(if (== modNum -1)
			(= modNum gCurRoomNum)
		)
		(if (and gMsgType (Message msgGET modNum noun theVerb 0 1))
			(gMessager say: noun theVerb 0 0 0 modNum)
		)
	)

	(method (doit)
		(if script
			(script doit:)
		)
		(if (not hideTheCast)
			(Animate (oldCast elements:) 0)
		)
	)

	(method (refresh)
		(cond
			(view
				(if global169
					(DrawPic (gCurRoom picture:) 15)
				else
					(DrawPic (gCurRoom picture:) 100)
				)
			)
			(global169
				(DrawPic (gCurRoom picture:) 15)
			)
			(else
				(DrawPic (gCurRoom picture:) style)
			)
		)
		(gCurRoom style: oldStyle)
		(if (!= gOverlays -1)
			(if global169
				(DrawPic gOverlays 15 0)
			else
				(DrawPic gOverlays 100 0)
			)
		)
		(if (gCurRoom inset:)
			((gCurRoom inset:) restore:)
		)
	)

	(method (dispose refreshOrNot &tmp whoCares)
		(gFeatures delete: self)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(gDirectionHandler delete: self)
		(gWalkHandler delete: self)
		(gTheDoits delete: self)
		(if inset
			(inset dispose: 0)
		)
		(gCast
			eachElementDo: #dispose
			eachElementDo: #delete
			release:
			dispose:
		)
		(gAddToPics dispose:)
		(gFeatures dispose:)
		(gMouseDownHandler dispose:)
		(gKeyDownHandler dispose:)
		(gDirectionHandler dispose:)
		(gWalkHandler dispose:)
		((gCurRoom obstacles:) dispose:)
		(owner inset: 0)
		(if (or (not argc) refreshOrNot)
			(self refresh:)
		)
		(if (or (not argc) refreshOrNot)
			((= gAddToPics oldATPs) doit:)
		)
		(gCurRoom obstacles: oldObstacles)
		(= gCast oldCast)
		(= gFeatures oldFeatures)
		(= gMouseDownHandler oldMH)
		(= gKeyDownHandler oldKH)
		(= gDirectionHandler oldDH)
		(= gWalkHandler oldWH)
		(if hideTheCast
			(self hideCast: 0)
		)
		(if (and (or (not argc) refreshOrNot) caller)
			(= whoCares caller)
			(= caller 0)
			(whoCares cue:)
		)
	)

	(method (setScript newScript)
		(if (IsObject script)
			(script dispose:)
		)
		(= script (if argc newScript else 0))
		(if script
			(script init: self &rest)
		)
	)

	(method (hideCast hideOrShow &tmp i addValue)
		(= i 0)
		(= addValue (if hideOrShow 1000 else -1000))
		(while (< i (gCast size:))
			((gCast at: i) z: (+ ((gCast at: i) z:) addValue))
			(++ i)
		)
		(Animate (gCast elements:) 0)
	)
)

(instance inView of View
	(properties)

	(method (handleEvent)
		(return 0)
	)
)

