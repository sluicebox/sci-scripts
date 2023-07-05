;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 762)
(include sci.sh)
(use Main)
(use RTRandCycle)
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
	local7 = 1
	local8
	local9
)

(procedure (proc762_0 param1 param2 param3 param4)
	(= local0 param1)
	(= local1 param2)
	(= local2 param3)
	(if (== argc 4)
		(= local8 param4)
	)
	(talkerObject doit:)
)

(procedure (proc762_1 param1 param2 param3)
	(= local0 param1)
	(= local1 0)
	(= local2 param2)
	(if (== argc 3)
		(= local8 param3)
	)
	(= local5 1)
	(talkerObject doit:)
)

(instance cdBackground of Kq5Talker
	(properties
		view 166
	)

	(method (init)
		(if (or (== (WordAt local2 local6) 0) (== local5 1))
			(self nsLeft: (WordAt local0 1) nsTop: (WordAt local0 2))
		else
			(self nsLeft: (WordAt local1 1) nsTop: (WordAt local1 2))
		)
		(super init: cdBust cdEyes cdMouth local4)
	)
)

(instance cdBust of Prop
	(properties)

	(method (init)
		(if (or (== (WordAt local2 local6) 0) (== local5 1))
			(self
				view: (WordAt local0 0)
				nsLeft: (+ (WordAt local0 1) (WordAt local0 3))
				nsTop: (+ (WordAt local0 2) (WordAt local0 4))
			)
		else
			(self
				view: (WordAt local1 0)
				nsLeft: (+ (WordAt local1 1) (WordAt local1 3))
				nsTop: (+ (WordAt local1 2) (WordAt local1 4))
			)
		)
	)
)

(instance cdEyes of Prop
	(properties
		loop 2
		cycleSpeed 30
	)

	(method (init)
		(if (or (== (WordAt local2 local6) 0) (== local5 1))
			(self
				view: (WordAt local0 0)
				nsLeft: (+ (WordAt local0 1) (WordAt local0 5))
				nsTop: (+ (WordAt local0 2) (WordAt local0 6))
			)
		else
			(self
				view: (WordAt local1 0)
				nsLeft: (+ (WordAt local1 1) (WordAt local1 5))
				nsTop: (+ (WordAt local1 2) (WordAt local1 6))
			)
		)
	)
)

(instance cdMouth of Prop
	(properties
		loop 1
	)

	(method (init)
		(if (or (== (WordAt local2 local6) 0) (== local5 1))
			(self
				view: (WordAt local0 0)
				nsLeft: (+ (WordAt local0 1) (WordAt local0 7))
				nsTop: (+ (WordAt local0 2) (WordAt local0 8))
			)
		else
			(self
				view: (WordAt local1 0)
				nsLeft: (+ (WordAt local1 1) (WordAt local1 7))
				nsTop: (+ (WordAt local1 2) (WordAt local1 8))
			)
		)
	)
)

(instance talkerObject of Code
	(properties)

	(method (doit &tmp [temp0 2])
		(cond
			((== local5 1)
				(= local4 local2)
			)
			((and (not (== (WordAt local2 local7) 0)) (!= local5 1))
				(= local4 (WordAt local2 local7))
			)
			(else
				(self dispose:)
			)
		)
		(if (not local9)
			(= local9 (gGame setCursor: 20 1))
		)
		(cdBust init:)
		(cdEyes init:)
		(cdMouth init:)
		(cdBackground init:)
		(if (!= local5 1)
			(+= local7 2)
			(+= local6 2)
		)
		(if (or (== (WordAt local2 local7) 0) (== local5 1) (== global381 1))
			(self dispose:)
		else
			(self doit:)
		)
	)

	(method (dispose)
		(if (IsObject local8)
			(local8 cue:)
		)
		(= global381 0)
		(= local0 0)
		(= local1 0)
		(= local2 0)
		(= local3 0)
		(= local4 0)
		(= local6 0)
		(= local7 1)
		(= local8 0)
		(cdBust dispose:)
		(cdMouth dispose:)
		(cdEyes dispose:)
		(if local5
			(gGame setCursor: local9)
		)
		(= local5 0)
		(= local9 0)
		(super dispose: &rest)
	)
)

