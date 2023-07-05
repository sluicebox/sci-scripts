;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 762)
(include sci.sh)
(use Main)
(use Talker)
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
	local11
	local12
	local13
)

(procedure (proc762_0 param1 param2 param3 param4) ; UNUSED
	(localproc_0)
	(DoAudio audSTOP)
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

(procedure (proc762_1 param1 param2 param3 param4)
	(if argc
		(= local3 param1)
		(= local4 0)
		(if (>= argc 2)
			(= local0 param2)
			(if (and (>= argc 3) (< argc 4))
				(= local6 param3)
			)
		)
	)
	(if (< argc 4)
		(localproc_0)
		(= local7 1)
		(talkerObject doit:)
	else
		(gCurRoom
			setScript: (ExitSCdScript register: param3 caller: param4 yourself:)
		)
	)
)

(procedure (localproc_0 &tmp temp0)
	(= temp0 (Event new:))
	(temp0 localize:)
	(= local11 (temp0 x:))
	(= local12 (temp0 y:))
	(temp0 dispose:)
)

(instance ExitSCdScript of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc762_1 local3 local0 self)
			)
			(1
				(= cycles 1)
			)
			(2
				(self dispose:)
				(gCurRoom newRoom: register)
			)
		)
	)
)

(class CodeCue of Code
	(properties)

	(method (cue))
)

(instance theBackground of Talker
	(properties
		view 166
	)

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

	(method (handleEvent event)
		(cond
			((and (& (event type:) evKEYBOARD) (== (event message:) KEY_ESCAPE))
				(= disposeWhenDone (= local9 1))
				(proc0_8 self 4 13)
			)
			((and (== (event type:) evMOUSEBUTTON) (== (event modifiers:) emSHIFT))
				(= disposeWhenDone (= local9 1))
			)
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
		cycleSpeed 40
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
		cel 4
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
			(= local13 (gGame masterVolume:))
			(gGame
				masterVolume:
					(if (< (- local13 4) 0)
						0
					else
						(- local13 4)
					)
			)
			(= local10 (gGame setCursor: gWaitCursor 1))
		)
		(if (not global83)
			(= global83 1)
		)
		(if
			(and
				(== (WordAt local1 local2) (WordAt local1 (+ local2 2)))
				(not local7)
				(!= (WordAt local1 (+ local2 3)) 0)
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
		(gGame
			setCursor:
				gWaitCursor
				1
				(+ (WordAt local5 1) 75)
				(+ (WordAt local5 2) 60)
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

	(method (dispose &tmp temp0 temp1 temp2 temp3)
		(if local10
			(= temp1 local10)
		)
		(if (IsObject local6)
			(= temp0 local6)
		else
			(= temp0 0)
		)
		(= temp2 local11)
		(= temp3 local12)
		(= local11
			(= local12
				(= local7
					(= local0
						(= local1
							(= local2
								(= local3
									(= local10
										(= local4 (= local5 (= local6 0)))
									)
								)
							)
						)
					)
				)
			)
		)
		(gGame setCursor: temp1 1 temp2 temp3)
		(gGame masterVolume: local13)
		(if temp0
			(temp0 cue:)
		)
	)
)

