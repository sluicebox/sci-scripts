;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 664)
(include sci.sh)
(use Main)
(use PuzzleBar)
(use Str)
(use Print)
(use System)

(public
	spellingPuz 0
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

(procedure (localproc_0)
	(cond
		((or local2 local5 local6 local8)
			(= local1 0)
		)
		((and local11 local12 local13 local7)
			(= local1 1)
			(return 1)
		)
		((and local11 local12 local4)
			(= local13 1)
		)
		((and local11 local9)
			(= local12 1)
		)
		(local3
			(= local11 1)
		)
	)
)

(instance spellingPuz of PuzzleBar
	(properties)

	(method (helpYou &tmp temp0)
		(= temp0 (Str new:))
		(switch local10
			(0
				(= local10 1)
				(Message msgGET 661 1 9 1 1 (temp0 data:)) ; "This must be one of those sliding bookshelves. You need to move the books in some order to make it work."
				(Print addText: (temp0 data:) y: 150 init:)
			)
			(1
				(= local10 2)
				(Message msgGET 661 1 9 2 1 (temp0 data:)) ; "Boyars (like many civil servants) have notoriously bad memories. You probably need to spell some common (and appropriate) word to open the bookshelf."
				(Print addText: (temp0 data:) y: 150 init:)
			)
			(else
				(Message msgGET 661 1 9 3 1 (temp0 data:)) ; "You want to get out of here, right? The bookshelf is the way out, the " _ _ _ _ ." Now you just have to fill in the blanks."
				(Print addText: (temp0 data:) y: 150 init:)
				(return 1)
			)
		)
		(return (temp0 dispose:))
	)

	(method (dispose)
		(super dispose: &rest)
		(if local1
			(return 1)
		else
			(return 0)
		)
	)

	(method (resetPuzzle &tmp temp0)
		(= local2 0)
		(= local3 0)
		(= local4 0)
		(= local5 0)
		(= local6 0)
		(= local7 0)
		(= local8 0)
		(= local9 0)
		(= local0 0)
		(= local1 0)
		(switch global439
			(1
				(self add: AnI AnE AnT AnX)
			)
			(2
				(self add: AnI AnE AnT AnX AnM AnA)
			)
			(3
				(self add: AnI AnE AnT AnX AnM AnA AnU AnO)
			)
		)
		(self eachElementDo: #init self eachElementDo: #show)
	)
)

(instance AnI of TextIcon
	(properties
		view 664
		loop 1
	)

	(method (highlight)
		(if (not value)
			(super highlight: &rest)
		)
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(if (not value)
				(= local4 (= cel 1))
			else
				(= cel 2)
				(= local13 0)
				(= local4 0)
			)
			(^= value $0001)
			(UpdateScreenItem self)
			(localproc_0)
			(return 1)
		else
			(return 0)
		)
	)

	(method (show)
		(switch global439
			(1
				(= x 68)
				(= y 60)
			)
			(2
				(= x 61)
				(= y 60)
			)
			(3
				(= x 49)
				(= y 60)
			)
		)
		(= nsLeft x)
		(= nsRight (+ nsLeft (CelWide view loop 0)))
		(= nsTop y)
		(= nsBottom (+ nsTop (CelHigh view loop 0)))
		(super show: &rest)
	)
)

(instance AnE of TextIcon
	(properties
		view 664
		loop 2
	)

	(method (highlight)
		(if (not value)
			(super highlight: &rest)
		)
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(if (not value)
				(= local3 (= cel 1))
			else
				(= cel 2)
				(= local3 0)
				(= local11 0)
			)
			(^= value $0001)
			(UpdateScreenItem self)
			(localproc_0)
			(return 1)
		else
			(return 0)
		)
	)

	(method (show)
		(switch global439
			(1
				(= x 52)
				(= y 60)
			)
			(2
				(= x 43)
				(= y 60)
			)
			(3
				(= x 34)
				(= y 60)
			)
		)
		(= nsLeft x)
		(= nsRight (+ nsLeft (CelWide view loop 0)))
		(= nsTop y)
		(= nsBottom (+ nsTop (CelHigh view loop 0)))
		(super show: &rest)
	)
)

(instance AnT of TextIcon
	(properties
		view 664
		loop 3
	)

	(method (highlight)
		(if (not value)
			(super highlight: &rest)
		)
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(if (not value)
				(= local7 (= cel 1))
			else
				(= cel 2)
				(= local7 0)
			)
			(^= value $0001)
			(UpdateScreenItem self)
			(if (and (localproc_0) local1)
				(spellingPuz setScript: sShowExit)
			)
			(return 1)
		else
			(return 0)
		)
	)

	(method (show)
		(switch global439
			(1
				(= x 105)
				(= y 60)
			)
			(2
				(= x 106)
				(= y 60)
			)
			(3
				(= x 104)
				(= y 60)
			)
		)
		(= nsLeft x)
		(= nsRight (+ nsLeft (CelWide view loop 0)))
		(= nsTop y)
		(= nsBottom (+ nsTop (CelHigh view loop 0)))
		(super show: &rest)
	)
)

(instance AnX of TextIcon
	(properties
		view 664
		loop 5
	)

	(method (highlight)
		(if (not value)
			(super highlight: &rest)
		)
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(if (not value)
				(= local9 1)
				(= cel 1)
			else
				(= local9 0)
				(= cel 2)
				(= local12 0)
			)
			(^= value $0001)
			(UpdateScreenItem self)
			(localproc_0)
			(return 1)
		else
			(return 0)
		)
	)

	(method (show)
		(switch global439
			(1
				(= x 84)
				(= y 60)
			)
			(2
				(= x 122)
				(= y 60)
			)
			(3
				(= x 134)
				(= y 60)
			)
		)
		(= nsLeft x)
		(= nsRight (+ nsLeft (CelWide view loop 0)))
		(= nsTop y)
		(= nsBottom (+ nsTop (CelHigh view loop 0)))
		(super show: &rest)
	)
)

(instance AnA of TextIcon
	(properties
		view 664
		loop 4
	)

	(method (highlight)
		(if (not value)
			(super highlight: &rest)
		)
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(if (not value)
				(= local2 (= cel 1))
			else
				(= cel 2)
				(= local2 0)
			)
			(^= value $0001)
			(UpdateScreenItem self)
			(localproc_0)
			(return 1)
		else
			(return 0)
		)
	)

	(method (show)
		(switch global439
			(2
				(= x 22)
				(= y 60)
			)
			(3
				(= x 17)
				(= y 60)
			)
		)
		(= nsLeft x)
		(= nsRight (+ nsLeft (CelWide view loop 0)))
		(= nsTop y)
		(= nsBottom (+ nsTop (CelHigh view loop 0)))
		(super show: &rest)
	)
)

(instance AnM of TextIcon
	(properties
		view 664
		loop 6
	)

	(method (highlight)
		(if (not value)
			(super highlight: &rest)
		)
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(if (not value)
				(= local5 (= cel 1))
			else
				(= cel 2)
				(= local5 0)
			)
			(^= value $0001)
			(UpdateScreenItem self)
			(localproc_0)
			(return 1)
		else
			(return 0)
		)
	)

	(method (show)
		(switch global439
			(2
				(= x 83)
				(= y 60)
			)
			(3
				(= x 70)
				(= y 60)
			)
		)
		(= nsLeft x)
		(= nsRight (+ nsLeft (CelWide view loop 0)))
		(= nsTop y)
		(= nsBottom (+ nsTop (CelHigh view loop 0)))
		(super show: &rest)
	)
)

(instance AnO of TextIcon
	(properties
		view 664
	)

	(method (highlight)
		(if (not value)
			(super highlight: &rest)
		)
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(if (not value)
				(= local6 (= cel 1))
			else
				(= cel 2)
				(= local6 0)
			)
			(^= value $0001)
			(UpdateScreenItem self)
			(localproc_0)
			(return 1)
		else
			(return 0)
		)
	)

	(method (show)
		(= x 85)
		(= y 60)
		(= nsLeft x)
		(= nsRight (+ nsLeft (CelWide view loop 0)))
		(= nsTop y)
		(= nsBottom (+ nsTop (CelHigh view loop 0)))
		(super show: &rest)
	)
)

(instance AnU of TextIcon
	(properties
		view 664
		loop 7
	)

	(method (highlight)
		(if (not value)
			(super highlight: &rest)
		)
	)

	(method (select &tmp temp0)
		(if (super select: &rest)
			(if (not value)
				(= local8 (= cel 1))
			else
				(= cel 2)
				(= local8 0)
			)
			(^= value $0001)
			(UpdateScreenItem self)
			(localproc_0)
			(return 1)
		else
			(return 0)
		)
	)

	(method (show)
		(= x 119)
		(= y 60)
		(= nsLeft x)
		(= nsRight (+ nsLeft (CelWide view loop 0)))
		(= nsTop y)
		(= nsBottom (+ nsTop (CelHigh view loop 0)))
		(super show: &rest)
	)
)

(instance sShowExit of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(spellingPuz noHands: 1)
				(AnE loop: 2 cel: 2 show:)
				(= ticks 30)
			)
			(1
				(AnX loop: 5 cel: 2 show:)
				(= ticks 30)
			)
			(2
				(AnI loop: 1 cel: 2 show:)
				(= ticks 30)
			)
			(3
				(AnT loop: 3 cel: 2 show:)
				(= ticks 30)
			)
			(4
				(AnE loop: 2 cel: 0 show:)
				(= ticks 30)
			)
			(5
				(AnX loop: 5 cel: 0 show:)
				(= ticks 30)
			)
			(6
				(AnI loop: 1 cel: 0 show:)
				(= ticks 30)
			)
			(7
				(AnT loop: 3 cel: 0 show:)
				(= ticks 30)
			)
			(8
				(AnE loop: 2 cel: 1 show:)
				(= ticks 30)
			)
			(9
				(AnX loop: 5 cel: 1 show:)
				(= ticks 30)
			)
			(10
				(AnI loop: 1 cel: 1 show:)
				(= ticks 30)
			)
			(11
				(AnT loop: 3 cel: 1 show:)
				(= ticks 60)
			)
			(12
				(spellingPuz state: (& (spellingPuz state:) $ffdf))
				(self dispose:)
			)
		)
	)
)

