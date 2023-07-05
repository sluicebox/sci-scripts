;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64923)
(include sci.sh)
(use Main)
(use Plane)
(use Actor)
(use System)

(class Inset of Obj
	(properties
		picture -1
		anOverlay 0
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
		oldStyle 0
		inset 0
		disposeNotOnMe 0
		modNum -1
		noun 0
		plane 0
		insetView 0
	)

	(method (setInset param1 param2 param3)
		(if inset
			(inset dispose:)
		)
		(if (and argc param1)
			(param1
				init:
					(if (>= argc 2) param2 else 0)
					self
					(if (>= argc 3) param3 else 0)
			)
		)
	)

	(method (init param1 param2 param3)
		(= client param2)
		(client inset: self)
		(= register param3)
		(= caller param1)
		(= oldFeatures gFeatures)
		(= oldMH gMouseDownHandler)
		(= oldKH gKeyDownHandler)
		(= oldDH gDirectionHandler)
		(= oldWH gWalkHandler)
		(= oldObstacles (gCurRoom obstacles:))
		(gCurRoom obstacles: ((List new:) add: yourself:))
		((= gFeatures (EventHandler new:)) name: {inFeatures} add: self)
		((= gMouseDownHandler (EventHandler new:)) name: {inMH} add: self)
		((= gKeyDownHandler (EventHandler new:)) name: {inKH} add: self)
		((= gDirectionHandler (EventHandler new:)) name: {inDH} add: self)
		((= gWalkHandler (EventHandler new:)) name: {inWH} add:)
		(= plane
			(if (not plane)
				(gThePlane new:)
			else
				(Plane new:)
			)
		)
		(plane
			priority: priority
			picture: picture
			style: style
			init:
			addCast: (= gCast (Cast new:))
		)
		(gTheDoits add: self)
		(self drawInset:)
	)

	(method (drawInset)
		(if (!= picture -1)
			(plane drawPic: picture)
		)
		(if (not (== view -1))
			(inView
				view: view
				loop: loop
				cel: cel
				x: 0
				y: 0
				setPri: priority
				ignoreActors: 1
			)
			(plane setBitmap: inView setSize:)
		)
		(plane posn: x y priority: (+ (GetHighPlanePri) 1))
		(UpdatePlane plane)
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
		)
	)

	(method (doit)
		(if script
			(script doit:)
		)
	)

	(method (dispose refreshOrNot &tmp temp0)
		(gFeatures delete: self)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(gDirectionHandler delete: self)
		(gWalkHandler delete: self)
		(gTheDoits delete: self)
		(if inset
			(inset dispose: 0)
		)
		(plane dispose:)
		(gCast release: plane: 0 dispose:)
		(gFeatures dispose:)
		(gMouseDownHandler dispose:)
		(gKeyDownHandler dispose:)
		(gDirectionHandler dispose:)
		(gWalkHandler dispose:)
		((gCurRoom obstacles:) dispose:)
		(client inset: 0)
		(gCurRoom obstacles: oldObstacles)
		(= gCast (((gCurRoom plane:) casts:) at: 0))
		(= gFeatures oldFeatures)
		(= gMouseDownHandler oldMH)
		(= gKeyDownHandler oldKH)
		(= gDirectionHandler oldDH)
		(= gWalkHandler oldWH)
		(if (and (or (not argc) refreshOrNot) caller)
			(= temp0 caller)
			(= caller 0)
			(temp0 cue:)
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

