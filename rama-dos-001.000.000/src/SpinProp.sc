;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 76)
(include sci.sh)
(use Main)
(use Rev)
(use Motion)
(use Actor)
(use System)

(public
	SpinProp 0
)

(class SpinProp of Prop
	(properties
		cursor 0
		myInvObj 0
		oldCel 0
		controller 0
	)

	(method (setInvObj param1)
		(if (and argc param1)
			(= myInvObj param1)
		else
			(= myInvObj 0)
		)
	)

	(method (setController param1)
		(if (and argc param1)
			(= controller param1)
		else
			(= controller 0)
		)
	)

	(method (setCursor param1)
		(if (and argc param1)
			(= cursor param1)
		else
			(= cursor 0)
		)
	)

	(method (setRotate param1)
		(if param1
			(self setCycle: Fwd)
		else
			(self setCycle: Rev)
		)
	)

	(method (getRotate &tmp temp0)
		(cond
			((and cycler (cycler isMemberOf: Fwd))
				(= temp0 1)
			)
			((and cycler (cycler isMemberOf: Rev))
				(= temp0 0)
			)
			(else
				(= temp0 -1)
			)
		)
		(return temp0)
	)

	(method (isRotate)
		(return (!= (self cycler:) 0))
	)

	(method (stopRotate)
		(self setCycle: 0)
	)

	(method (handleEvent event)
		(event localize: plane)
		(cond
			((event claimed:)
				(return 1)
			)
			(
				(and
					cursor
					(self onMe: event)
					scratch
					(scratch respondsTo: (gTheCursor verb:))
					(not (event type:))
					(not (gTheCursor isInvCursor:))
					(or
						(!= (gTheCursor view:) (cursor view:))
						(!= (gTheCursor loop:) (cursor loop:))
						(!= (gTheCursor cel:) (cursor cel:))
					)
				)
				(gTheCursor
					view: (cursor view:)
					loop: (cursor loop:)
					cel: (cursor cel:)
					init:
				)
				(event globalize:)
				(event claimed: 1)
				(return)
			)
			(
				(and
					(& (event type:) evMOUSERELEASE)
					(self onMe: event)
					controller
					(controller respondsTo: #notify)
				)
				(controller notify:)
				(self setCycle: 0)
				(event globalize:)
				(event claimed: 1)
				(return)
			)
			(else
				(event globalize:)
				(super handleEvent: event)
			)
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(global123
					displayOptionsText:
						(myInvObj modNum:)
						(myInvObj noun:)
						0
						(myInvObj case:)
						1
				)
				(super doVerb: theVerb &rest)
			)
		)
		(super doVerb: theVerb &rest)
	)

	(method (serialize param1)
		(return (and argc param1))
	)
)

(class MultiProp of SpinProp
	(properties
		segList 0
	)

	(method (addSegment param1 &tmp temp0)
		(if (not segList)
			(= segList (Set new:))
		)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(segList add: [param1 temp0])
		)
	)

	(method (dispose)
		(if segList
			(segList release: dispose:)
			(= segList 0)
		)
		(super dispose: &rest)
	)

	(method (setRotate param1)
		(cond
			((and segList param1)
				(self setCycle: MultiFwd segList)
			)
			(segList
				(self setCycle: MultiRev segList)
			)
			(else
				(super setRotate: param1 &rest)
			)
		)
	)

	(method (getRotate)
		(cond
			((and segList cycler (cycler isMemberOf: MultiFwd))
				(return 1)
			)
			((and segList cycler (cycler isMemberOf: MultiRev))
				(return 0)
			)
			(else
				(return (super getRotate:))
			)
		)
	)
)

(class MultiClientCycler of Cycle
	(properties
		slaves 0
		isList 0
	)

	(method (init param1 param2)
		(= isList 0)
		(cond
			((not argc) 0)
			((== argc 1)
				(= client param1)
			)
			((> argc 1)
				(= client param1)
				(if (and param2 (param2 isKindOf: Collect))
					(= isList 1)
				)
				(= slaves param2)
			)
			(else 0)
		)
		(= cycleCnt gGameTime)
		(= completed 0)
		(= clientLastCel (client lastCel:))
	)
)

(class MultiFwd of MultiClientCycler
	(properties)

	(method (doit &tmp temp0)
		(if (!= (client cel:) (= temp0 (self nextCel:)))
			(if (> temp0 clientLastCel)
				(self cycleDone:)
			else
				(client cel: temp0)
				(if isList
					(slaves eachElementDo: #cel temp0)
				else
					(slaves cel: temp0)
				)
			)
		)
	)

	(method (cycleDone)
		(client cel: 0)
		(if isList
			(slaves eachElementDo: #cel 0)
		else
			(slaves cel: 0)
		)
	)
)

(class MultiRev of MultiClientCycler
	(properties
		cycleDir -1
	)

	(method (doit &tmp temp0)
		(if (!= (client cel:) (= temp0 (self nextCel:)))
			(if (< temp0 0)
				(self cycleDone:)
			else
				(client cel: temp0)
				(if isList
					(slaves eachElementDo: #cel temp0)
				else
					(slaves cel: temp0)
				)
			)
		)
	)

	(method (cycleDone)
		(client cel: (client lastCel:))
		(if isList
			(slaves eachElementDo: #cel (client lastCel:))
		else
			(slaves cel: (client lastCel:))
		)
	)
)

