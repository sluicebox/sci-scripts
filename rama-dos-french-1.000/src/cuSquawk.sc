;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 1201)
(include sci.sh)
(use Main)
(use InvInset)
(use SpinProp)
(use n112)
(use HardStopFwd)
(use Array)
(use Actor)
(use System)

(public
	cuSquawk 0
)

(local
	[local0 16] = [-146 -112 -77 -43 -9 26 59 94 -148 -113 -79 -43 -9 26 62 96]
	[local16 16] = [1 1 -1 1 0 0 0 0 32 31 31 31 30 30 30 33]
	local32
)

(instance cuSquawk of SpinProp
	(properties)

	(method (init &tmp temp0)
		(= cel 14)
		(super init: &rest)
		(self setPri: 200 setHotspot: 2 11)
		(for ((= temp0 0)) (< temp0 16) ((++ temp0))
			(buttonSet
				add:
					((SquawkButton new:)
						view: 20030
						loop: (+ temp0 1)
						cel: 0
						posn:
							(+ (cuSquawk x:) [local0 temp0])
							(+ (cuSquawk y:) [local16 temp0])
						setPri: (+ (cuSquawk priority:) 1)
						squawkSnd: temp0
						init:
						yourself:
					)
			)
		)
		(SquawkMgr
			init:
			newSeq: 6102 8 3 16
			newSeq: 6103 8 3 16
			newSeq: 6105 10 15 8
			newSeq: 6106 10 15 8
		)
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(gTheCursor setTempCursor:)
				(gTheCursor hilite:)
			)
			(2
				(if (!= cel 14)
					(if (> (self cel:) 7)
						(self
							setScript: activateButtons
							setCycle: HardStopFwd 14 activateButtons
						)
					else
						(self
							setScript: activateButtons
							setCycle: HardStopRev 14 activateButtons
						)
					)
				)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)

	(method (setCycle param1)
		(if (and (== cel 14) argc param1)
			(buttonSet eachElementDo: #hide)
			(= local32 1)
		)
		(super setCycle: param1 &rest)
	)

	(method (doit)
		(if (and (not (self cycler:)) (== cel 14) local32)
			(= local32 0)
			(buttonSet eachElementDo: #show)
		)
		(super doit: &rest)
	)

	(method (dispose)
		(buttonSet release:)
		(SquawkMgr dispose:)
		(self deleteHotspot:)
		(super dispose: &rest)
	)
)

(class SquawkButton of View
	(properties
		squawkSnd -1
		isDownOnMe 0
	)

	(method (init)
		(&= signal $efff)
		(super init: &rest)
		(gExtMouseHandler addToFront: self)
	)

	(method (dispose)
		(gExtMouseHandler delete: self)
		(super dispose: &rest)
	)

	(method (handleEvent event)
		(event localize: plane)
		(cond
			((event claimed:)
				(event globalize:)
				(return 1)
			)
			((and (not (event type:)) (not (self onMe: event)) isDownOnMe)
				(= isDownOnMe 0)
				(if cel
					(= cel 0)
				)
				(event globalize:)
				(super handleEvent: event &rest)
			)
			((and (not (event type:)) (self onMe: event))
				(gTheCursor setTempCursor: (ScriptID 0 3) 2) ; ramanFingerCursor
				(event claimed: 1)
				(event globalize:)
				(return 1)
			)
			(
				(and
					(& (event type:) evMOUSEBUTTON)
					(self onMe: event)
					(self isNotHidden:)
				)
				(= cel (= isDownOnMe 1))
				(event claimed: 1)
				(event globalize:)
				(return 1)
			)
			(
				(and
					(& (event type:) evMOUSERELEASE)
					(self onMe: event)
					(self isNotHidden:)
					isDownOnMe
				)
				(= isDownOnMe 0)
				(self cel: 0)
				(UpdateScreenItem self)
				(FrameOut)
				(event claimed: 1)
				(event globalize:)
				(self action:)
				(return 1)
			)
			(else
				(event globalize:)
				(super handleEvent: event &rest)
			)
		)
	)

	(method (action)
		(self squawk:)
		(SquawkMgr checkAll: (self getID:))
	)

	(method (getID)
		(return loop)
	)

	(method (squawk)
		(if (!= squawkSnd -1)
			(proc112_0 squawkSnd)
		)
	)
)

(instance buttonSet of Set
	(properties)
)

(class SquawkMgr of Set
	(properties
		curCheck 0
	)

	(method (init)
		(= curCheck 0)
		(super init: &rest)
	)

	(method (newSeq &tmp temp0)
		(= temp0 (Sequence new:))
		(temp0 init: &rest)
		(self add: temp0)
	)

	(method (checkAll param1)
		(cond
			((self firstTrue: #check param1)
				(= curCheck 0)
				(InvInset dispose:)
				(if gCurRoom
					(gCurRoom notify:)
				)
			)
			((>= (++ curCheck) 3)
				(= curCheck 0)
				(InvInset dispose:)
			)
		)
	)
)

(class Sequence of Obj
	(properties
		seq 0
		keyPosn 0
		myRoomNum -1
	)

	(method (init param1)
		(if argc
			(if seq
				(seq dispose:)
			)
			(= myRoomNum param1)
			(= seq (IntArray with: &rest 0))
		)
	)

	(method (check param1 &tmp temp0)
		(= temp0 0)
		(if (and (== myRoomNum gCurRoomNum) (== param1 (seq at: keyPosn)))
			(++ keyPosn)
			(if (not (seq at: keyPosn))
				(= keyPosn 0)
				(= temp0 1)
			)
		else
			(= keyPosn 0)
		)
		(return temp0)
	)

	(method (dispose)
		(seq dispose:)
		(= seq 0)
		(super dispose: &rest)
	)
)

(instance activateButtons of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0)
			(1
				(= local32 0)
				(buttonSet eachElementDo: #show)
				(= cycles 2)
			)
			(2
				(self dispose:)
			)
		)
	)
)

