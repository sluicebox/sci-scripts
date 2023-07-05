;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64923)
(include sci.sh)
(use Main)
(use Plane)
(use Cursor)
(use Actor)
(use System)

(class Inset of Obj
	(properties
		picture -1
		anOverlay 0
		style 14
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
		exitCurs 1
		prevCurs 0
		oldIcon 0
		oldTimers 0
		dontPutBack 0
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

	(method (init param1 param2 param3 &tmp temp0)
		(= client param2)
		(client inset: self)
		(if (== argc 3)
			(= register param3)
		else
			(= register 0)
		)
		(= caller param1)
		(= oldTimers 0)
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
		(if (and (!= picture 9561) (!= modNum 9561))
			(if (& ((gTheIconBar at: 10) signal:) $0004)
				(= dontPutBack 1)
			else
				(= dontPutBack 0)
			)
			(gTheIconBar disable: 10 11)
		)
		(if (gTimers size:)
			(= oldTimers timerSet)
			(for ((= temp0 0)) (< temp0 (gTimers size:)) ((++ temp0))
				(oldTimers add: (gTimers at: temp0))
			)
			(gTimers release:)
		)
		((= plane (Plane new:))
			priority: priority
			init: 0 (gThePlane top:) 319 199
			addCast: (= gCast (Cast new:))
		)
		(self drawInset:)
		(gTheDoits add: self)
	)

	(method (drawInset)
		(if (!= picture -1)
			(plane drawPic: picture 0)
		)
		(if (not (== view -1))
			(inView
				view: view
				loop: loop
				cel: cel
				x: x
				y: y
				setPri: priority
				ignoreActors: 1
			)
			(plane setBitmap: inView 0 setSize:)
		)
		(plane posn: x y priority: (+ (GetHighPlanePri) 1))
		(if (not register)
			(UpdatePlane plane)
			(FrameOut)
		)
	)

	(method (reDrawInset)
		((plane bitmap:) setCel: 1)
		(UpdateScreenItem (plane bitmap:))
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
			(gDoVerbCode doit: theVerb self)
		)
	)

	(method (doit &tmp temp0)
		(if disposeNotOnMe
			(= temp0 (gUser curEvent:))
			(if (not (temp0 type:))
				(temp0 localize: (gCast plane:))
				(cond
					((not (self onMe: temp0))
						(if
							(and
								(!= gTheCursor insetExitCurs)
								(not (& (gTheIconBar state:) $0020))
							)
							(gGame setCursor: insetExitCurs 1)
						)
					)
					(
						(and
							(!= (gTheIconBar curIcon:) (gTheIconBar useIconItem:))
							(!= gTheCursor ((gTheIconBar curIcon:) cursorView:))
						)
						(gGame setCursor: ((gTheIconBar curIcon:) cursorView:) 1)
					)
					(
						(and
							(== (gTheIconBar curIcon:) (gTheIconBar useIconItem:))
							gTheCursor
							(!=
								(gTheCursor view:)
								((gTheIconBar curIcon:) cursorView:)
							)
						)
						(insetCursor
							view: ((gTheIconBar useIconItem:) cursorView:)
							loop: ((gTheIconBar useIconItem:) cursorLoop:)
							cel: ((gTheIconBar useIconItem:) cursorCel:)
						)
						(gGame setCursor: insetCursor 1)
					)
				)
			)
		)
		(if script
			(script doit:)
		)
	)

	(method (dispose refreshOrNot &tmp whoCares i)
		(gFeatures delete: self)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(gDirectionHandler delete: self)
		(gWalkHandler delete: self)
		(gTheDoits delete: self)
		(if oldTimers
			(for ((= i 0)) (< i (oldTimers size:)) ((++ i))
				(gTimers add: (oldTimers at: i))
			)
			(oldTimers release: dispose:)
			(= oldTimers 0)
		)
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
		(if (gGame keepBar:)
			(gTheIconBar draw:)
		)
		(if (and (or (not argc) refreshOrNot) caller)
			(= whoCares caller)
			(= caller 0)
			(whoCares cue:)
		)
		(if (and (!= picture 9561) (!= modNum 15))
			(gTheIconBar enable: 11)
			(if (not dontPutBack)
				(gTheIconBar enable: 10)
			)
		)
		(gGame setCursor: (gTheIconBar getCursor:))
		(= picture -1)
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

(instance timerSet of Set
	(properties)
)

(instance insetCursor of Cursor
	(properties)
)

(instance insetExitCurs of Cursor
	(properties
		view 968
	)
)

