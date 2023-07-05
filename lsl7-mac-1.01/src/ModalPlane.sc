;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64889)
(include sci.sh)
(use Main)
(use TimePauser)
(use DisabledPlanes)
(use Plane)
(use Feature)
(use System)

(class ModalPlane of Plane
	(properties)

	(method (init)
		(proc64888_7)
		(proc64888_2)
		(TimePauser init:)
		((ScriptID 64000 0) disable:) ; oMainMenu
		(super init: &rest)
		(self setPri: (+ (GetHighPlanePri) 1))
		(self addCast: (Cast new:))
		(UpdatePlane self)
	)

	(method (dispose)
		(proc64888_8)
		(TimePauser dispose:)
		((ScriptID 64000 0) enable:) ; oMainMenu
		(super dispose: &rest)
	)
)

(class OpaqueFeature of Feature
	(properties)

	(method (init)
		(super init: &rest)
		(self myPriority: -1)
		(self forceCursor: -1)
	)

	(method (doVerb))

	(method (handleEvent event)
		(event claimed: 1)
		(return 1)
	)
)

(class MoveFeature of Feature
	(properties
		nInitPlaneX 0
		nInitPlaneY 0
		nInitCursorX 0
		nInitCursorY 0
		bImAHog 0
	)

	(method (init)
		(super init: &rest)
		(= bImAHog 0)
		(self forceCursor: (ScriptID 64006 0)) ; oSysCursor
	)

	(method (makeTopBorder param1)
		(if (not plane)
			(PrintDebug
				{attempt to call makeTopBorder on MoveFeature with uninited plane. DJM, modalpl.sc}
			)
			(return)
		)
		(= nsTop (= nsLeft 0))
		(= nsRight (- (plane right:) (plane left:)))
		(= nsBottom param1)
	)

	(method (stopHogging)
		(gOEventHandler unregisterEventHog: self)
		(= bImAHog 0)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(cond
			((== bImAHog 1)
				(event globalize:)
				(= temp0 (- (event x:) nInitCursorX))
				(= temp1 (- (event y:) nInitCursorY))
				(plane moveTo: (+ nInitPlaneX temp0) (+ nInitPlaneY temp1))
				(UpdatePlane plane)
				(if (== (event type:) evMOUSERELEASE)
					(self stopHogging:)
				)
				(event claimed: 1)
				(return 1)
			)
			((and (self onMe: event) (== (event type:) evMOUSEBUTTON))
				(gOEventHandler registerEventHog: self)
				(= bImAHog 1)
				(event globalize:)
				(= nInitCursorX (event x:))
				(= nInitCursorY (event y:))
				(= nInitPlaneX (plane left:))
				(= nInitPlaneY (plane top:))
				(event claimed: 1)
				(return 1)
			)
			(else
				(super handleEvent: event &rest)
				(return)
			)
		)
	)
)

