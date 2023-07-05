;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 762)
(include sci.sh)
(use Main)
(use Actor)
(use System)

(public
	proc762_0 0
	proc762_1 1
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
)

(procedure (proc762_0 param1 param2 param3 param4) ; UNUSED
	(if argc
		(= local3 param1)
		(if (>= argc 2)
			(= local4 param2)
			(if (>= argc 3)
				(= local1 param3)
				(if (>= argc 4)
					(= local6 param4)
				)
			)
		)
	)
	(talkerObject doit:)
)

(procedure (proc762_1 param1 param2 param3) ; UNUSED
	(= local7 1)
	(if argc
		(= local3 param1)
		(= local4 0)
		(if (>= argc 2)
			(= local0 param2)
			(if (>= argc 3)
				(= local6 param3)
			)
		)
	)
	(talkerObject doit:)
)

(class CodeCue of Code
	(properties)

	(method (cue))
)

(instance theBackground
	(properties)

	(method (init)
		(self nsLeft: (WordAt local5 1) nsTop: (WordAt local5 2))
		(super
			init:
				(theBust init: yourself:)
				(theEyes init: yourself:)
				(theMouth init: yourself:)
				local0
				0
				0
				(if local8 0 else 1)
				talkerObject
		)
	)

	(method (doit)
		(if (> (GetTime) (- --UNKNOWN-PROPERTY-- 60))
			(theEyes setCel: 4)
		)
		(super doit: &rest)
	)

	(method (handleEvent event)
		(if (and (== (event type:) evMOUSEBUTTON) (== (event modifiers:) emSHIFT))
			(= local9 1)
		)
		(super handleEvent: event)
	)
)

(instance theBust of Prop
	(properties)

	(method (init)
		(self
			view: (WordAt local5 0)
			nsLeft: (WordAt local5 3)
			nsTop: (WordAt local5 4)
		)
	)
)

(instance theEyes of Prop
	(properties
		loop 2
		cycleSpeed 50
	)

	(method (init)
		(self
			view: (WordAt local5 0)
			nsLeft: (WordAt local5 5)
			nsTop: (WordAt local5 6)
		)
	)
)

(instance theMouth of Prop
	(properties
		loop 1
	)

	(method (init)
		(self
			view: (WordAt local5 0)
			nsLeft: (WordAt local5 7)
			nsTop: (WordAt local5 8)
		)
	)
)

(instance talkerObject of CodeCue
	(properties)

	(method (doit)
		(if (not local10)
			(= local10 (gGame setCursor: gWaitCursor 1))
		)
		(if (not global83)
			(= global83 1)
		)
		(if
			(and
				(== (WordAt local1 local2) (WordAt local1 (+ local2 2)))
				(not local7)
			)
			(= local8 1)
		else
			(= local8 0)
		)
		(if (or (== (WordAt local1 local2) 0) local7)
			(= local5 local3)
		else
			(= local5 local4)
		)
		(if (not local7)
			(= local0 (WordAt local1 (+ local2 1)))
			(+= local2 2)
		)
		(theBackground init:)
	)

	(method (cue)
		(if (or (== (WordAt local1 (+ local2 1)) 0) local7 local9)
			(self dispose:)
		else
			(self doit:)
		)
	)

	(method (dispose &tmp temp0 temp1)
		(if local10
			(= temp1 local10)
		)
		(if (IsObject local6)
			(= temp0 local6)
		else
			(= temp0 0)
		)
		(= local7
			(= local0
				(= local1
					(= local2
						(= local3
							(= local10 (= local4 (= local5 (= local6 0))))
						)
					)
				)
			)
		)
		(gGame setCursor: temp1)
		(if temp0
			(temp0 cue:)
		)
	)
)

