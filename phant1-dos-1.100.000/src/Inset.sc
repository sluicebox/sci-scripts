;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64923)
(include sci.sh)
(use Main)
(use Actor)
(use System)

(class Inset of Obj
	(properties
		picture -1
		style 0
		view -1
		loop 0
		cel 0
		x -1
		y -1
		priority 14
		register 0
		caller 0
		client 0
		script 0
		oldFeatures 0
		oldMH 0
		oldKH 0
		oldDH 0
		oldWH 0
		oldObstacles 0
		inset 0
		disposeNotOnMe 0
		modNum -1
		noun 0
		plane 0
		oldTimers 0
		oldHotCast 0
	)

	(method (init whoCares theRoomOrInset reg delayDraw &tmp delay i)
		(= client theRoomOrInset)
		(client inset: self)
		(= register delayDraw)
		(= caller whoCares)
		(= delay (if (> argc 2) reg))
		(= oldFeatures gFeatures)
		(= oldMH gMouseDownHandler)
		(= oldKH gKeyDownHandler)
		(= oldDH gDirectionHandler)
		(= oldWH gWalkHandler)
		(= oldObstacles (gCurRoom obstacles:))
		(= oldTimers gTimers)
		(= oldHotCast global160)
		((= global160 (Cast new:)) name: {inHotCast} add:)
		((= gTimers (Set new:)) name: {inTimers} add:)
		(gCurRoom obstacles: ((List new:) add: yourself:))
		(for ((= i 0)) (< i (gRegions size:)) ((++ i))
			(oldRegions add: (gRegions at: i))
		)
		(gRegions release:)
		(gRegions add: self)
		((= gFeatures (EventHandler new:)) name: {inFeatures} add:)
		((= gMouseDownHandler (EventHandler new:)) name: {inMH} add: self)
		((= gKeyDownHandler (EventHandler new:)) name: {inKH} add: self)
		((= gDirectionHandler (EventHandler new:)) name: {inDH} add: self)
		((= gWalkHandler (EventHandler new:)) name: {inWH} add:)
		(if (not plane)
			(= plane (gThePlane new:))
		)
		(plane
			priority: priority
			picture: picture
			style: style
			init:
			addCast: (= gCast (Cast new:))
		)
		(= gThePlane plane)
		(if (not delay)
			(self drawInset:)
		)
	)

	(method (drawInset)
		(if (!= picture -1)
			(plane drawPic: picture)
		)
		(plane posn: x y priority: (+ (GetHighPlanePri) 1))
		(if (not (== view -1))
			(inView view: view loop: loop cel: cel setPri: 0 ignoreActors: 1)
			(plane setBitmap: inView 0)
		)
		(UpdatePlane plane)
		(FrameOut)
	)

	(method (restore)
		(self drawInset:)
		(if inset
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
						(return 1)
					)
					(disposeNotOnMe
						(event claimed: 1)
						(self dispose:)
						(return 1)
					)
					(else
						(return 0)
					)
				)
			)
		)
	)

	(method (onMe theObjOrX theY &tmp oX oY)
		(if (== argc 1)
			(theObjOrX localize: plane)
			(= oX (theObjOrX x:))
			(= oY (theObjOrX y:))
		else
			(= oX theObjOrX)
			(= oY theY)
		)
		(if (not (== view -1))
			(if (== argc 1)
				(return ((plane bitmap:) onMe: theObjOrX))
			else
				(return ((plane bitmap:) onMe: theObjOrX theY))
			)
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
		else
			(gGame pragmaFail:)
		)
	)

	(method (doit)
		(if script
			(script doit:)
		)
	)

	(method (dispose refreshOrNot &tmp whoCares i)
		(gRegions delete: self)
		(gFeatures delete: self)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(gDirectionHandler delete: self)
		(gWalkHandler delete: self)
		(if inset
			(inset dispose: 0)
			(= inset 0)
		)
		(gMouseDownHandler dispose:)
		(gKeyDownHandler dispose:)
		(gDirectionHandler dispose:)
		(gWalkHandler dispose:)
		(gCast eachElementDo: #dispose)
		(plane dispose:)
		(= plane 0)
		(gTimers dispose:)
		(gCast plane: 0 dispose:)
		(gFeatures dispose:)
		(for ((= i 0)) (< i (oldRegions size:)) ((++ i))
			(gRegions add: (oldRegions at: i))
		)
		(global160 release: dispose:)
		(= global160 oldHotCast)
		(oldRegions release: dispose:)
		((gCurRoom obstacles:) dispose:)
		(client inset: 0)
		(gCurRoom obstacles: oldObstacles)
		(= gCast (((gCurRoom plane:) casts:) at: 0))
		(= gThePlane (gCurRoom plane:))
		(= gFeatures oldFeatures)
		(= gMouseDownHandler oldMH)
		(= gKeyDownHandler oldKH)
		(= gDirectionHandler oldDH)
		(= gWalkHandler oldWH)
		(= gTimers oldTimers)
		(= oldTimers 0)
		(if (and (or (not argc) refreshOrNot) caller)
			(= whoCares caller)
			(= caller 0)
			(whoCares cue:)
		)
	)

	(method (setScript newScript)
		(if script
			(script dispose:)
		)
		(= script (if argc newScript else 0))
		(if script
			(script init: self &rest)
		)
	)
)

(instance inView of View
	(properties)

	(method (handleEvent)
		(return 0)
	)
)

(instance oldRegions of List
	(properties)
)

