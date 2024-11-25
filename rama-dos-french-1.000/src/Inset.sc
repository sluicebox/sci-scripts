;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64923)
(include sci.sh)
(use Main)
(use Plane)
(use System)

(class Inset of Obj
	(properties
		caller 0
		client 0
		modNum -1
		noun 0
		plane 0
		priority 14
		script 0
		x -1
		y -1
		style 0
		picture -1
		register 0
		inset 0
		disposeNotOnMe 0
		inView 0
		insetCast 0
		oldThePlane 0
		oCast 0
		oRegions 0
		oFeatures 0
		oMDHandler 0
		oKDHandler 0
		oTimers 0
	)

	(method (setInset theInset who reg delay)
		(if inset
			(inset dispose:)
			(= inset 0)
		)
		(if (and argc theInset)
			(theInset
				init:
					(if (>= argc 2) who else 0)
					self
					(if (>= argc 3) reg else 0)
					(if (>= argc 4) delay else 0)
			)
		)
	)

	(method (init whoCares theRoomOrInset reg delayDraw &tmp delay i)
		(if gVMDMovie
			(gVMDMovie mouseDownAction: 1)
			(if (gVMDMovie loop:)
				(self scratch: gVMDMovie)
			)
		)
		(self takeControl:)
		(if (> argc 0)
			(= client theRoomOrInset)
			(= caller whoCares)
			(= register (if (> argc 2) reg else 0))
			(= delay (if (> argc 3) delayDraw))
		)
		(if client
			(client inset: self)
		)
		(if (not plane)
			((= plane (Plane new:))
				picture: picture
				style: style
				setRect: 30 40 624 332
				setInsetRect: 30 40 624 332
			)
		)
		(if (not insetCast)
			(= insetCast (Cast new:))
		)
		(plane priority: priority init: addCast: insetCast addCast: gCast)
		(UpdatePlane plane)
		(if (not delay)
			(self drawInset:)
		)
	)

	(method (drawInset)
		(if (!= picture -1)
			(plane drawPic: picture)
		)
		(plane posn: x y)
		(if inView
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
			((not (event type:))
				(event claimed: 1)
			)
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
		(if inView
			(if (== argc 1)
				(return ((plane bitmap:) onMe: theObjOrX))
			else
				(return ((plane bitmap:) onMe: theObjOrX theY))
			)
		else
			(return 1)
		)
	)

	(method (doit)
		(if script
			(script doit:)
		)
	)

	(method (dispose refreshOrNot &tmp temp0 temp1 temp2)
		(while ((= temp2 (Event new: evMOUSE)) type:)
			(temp2 dispose:)
		)
		(temp2 dispose:)
		(if inset
			(inset dispose: 0)
			(= inset 0)
		)
		(insetCast dispose:)
		(= insetCast 0)
		(self giveControl:)
		(if plane
			(plane dispose:)
		)
		(= plane 0)
		(if client
			(client inset: 0)
		)
		(= gCast oCast)
		(= oCast 0)
		(if (and (or (not argc) refreshOrNot) caller)
			(= temp0 caller)
			(= caller 0)
			(temp0 cue:)
		)
		(if scratch
			(scratch delayPlay:)
			(= scratch 0)
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

	(method (takeControl &tmp temp0)
		(gCurRoom doVerb: 145 self)
		(= oCast gCast)
		(= oFeatures gFeatures)
		(= oMDHandler gMouseDownHandler)
		(= oKDHandler gKeyDownHandler)
		(= oTimers gTimers)
		(= oRegions (List new:))
		(for ((= temp0 0)) (< temp0 (gRegions size:)) ((++ temp0))
			(oRegions add: (gRegions at: temp0))
		)
		((= gTimers (Set new:)) name: {inTimers} add:)
		(= oRegions (List new:))
		(for ((= temp0 0)) (< temp0 (gRegions size:)) ((++ temp0))
			(oRegions add: (gRegions at: temp0))
		)
		(gRegions release:)
		(gRegions add: self)
		(= gCast (Cast new:))
		(gCast add: global112)
		((= gFeatures (EventHandler new:)) name: {inFeatures} add:)
		((= gMouseDownHandler (EventHandler new:)) name: {inMH} add: self)
		((= gKeyDownHandler (EventHandler new:)) name: {inKH} add: self)
	)

	(method (giveControl &tmp temp0)
		(gRegions delete: self)
		(gFeatures delete: self)
		(gMouseDownHandler delete: self)
		(gKeyDownHandler delete: self)
		(gMouseDownHandler dispose:)
		(gKeyDownHandler dispose:)
		(gCast eachElementDo: #dispose)
		(gTimers dispose:)
		(gCast delete: global112 plane: 0 dispose:)
		(gFeatures dispose:)
		(for ((= temp0 0)) (< temp0 (oRegions size:)) ((++ temp0))
			(gRegions add: (oRegions at: temp0))
		)
		(gCurRoom doVerb: 146 self)
		(oRegions release: dispose:)
		(= gFeatures oFeatures)
		(= oFeatures 0)
		(= gMouseDownHandler oMDHandler)
		(= oMDHandler 0)
		(= gKeyDownHandler oKDHandler)
		(= oKDHandler 0)
		(= gTimers oTimers)
		(= oTimers 0)
	)

	(method (serialize param1)
		(return (and argc param1))
	)
)

