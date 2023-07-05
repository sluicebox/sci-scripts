;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 962)
(include sci.sh)
(use n951)
(use Str)
(use System)

(class Movie of Obj
	(properties
		number 0
		x 0
		y 0
		client 0
		caller 0
		opened 0
		paused 0
		type 1
	)

	(method (play param1 param2 param3 param4 &tmp temp0)
		(if (and (> argc 1) param2)
			(= caller param2)
		)
		(if (and (> argc 2) param3)
			(self posn: param3 param4)
		)
		(if (not opened)
			(self open: param1)
		)
		(= temp0
			(Str
				format:
					(switch type
						(0 {%d.mov})
						(1 {%d.avi})
					)
					number
			)
		)
		(ShowMovie 1 2 (temp0 data:)) ; Put
		(temp0 dispose:)
		(self close: dispose:)
	)

	(method (open param1 param2 param3 &tmp temp0)
		(= number param1)
		(= temp0
			(Str
				format:
					(switch type
						(0 {%d.mov})
						(1 {%d.avi})
					)
					number
			)
		)
		(ShowMovie 1 0 (temp0 data:)) ; Put
		(if (and (> argc 1) param2)
			(self posn: param2 param3)
		)
		(if (IsFlag 38)
			(ShowMovie 1 15 x y) ; Put
		else
			(ShowMovie 1 1 x y) ; Put
		)
		(= opened 1)
		(temp0 dispose:)
	)

	(method (close &tmp temp0)
		(= temp0
			(Str
				format:
					(switch type
						(0 {%d.mov})
						(1 {%d.avi})
					)
					number
			)
		)
		(ShowMovie 1 6 (temp0 data:)) ; Put
		(= opened 0)
		(temp0 dispose:)
	)

	(method (posn param1 param2)
		(= x param1)
		(= y param2)
	)

	(method (put param1 param2)
		(if (and (> argc 1) param1)
			(= x param1)
			(= y param2)
		)
		(ShowMovie 1 1 x y) ; Put
	)

	(method (putDouble param1 param2)
		(if (and (> argc 1) param1)
			(= x param1)
			(= y param2)
		)
		(ShowMovie 1 15 x y) ; Put
	)

	(method (setPal param1 &tmp temp0)
		(= temp0 (Str format: {%d.pal} param1))
		(ShowMovie 1 7 (temp0 data:)) ; Put
		(temp0 dispose:)
	)

	(method (dispose)
		(= y (= x 0))
		(if client
			(client movie: 0)
		)
		(if caller
			(caller cue:)
			(= caller 0)
		)
	)

	(method (pause)
		(if (not paused)
			(ShowMovie 1 4) ; Put
			(= paused 1)
		)
	)

	(method (setWaitEvent param1 param2)
		(if (and (> argc 0) param1)
			(ShowMovie 1 14 param1 (and (> argc 1) param2 param2)) ; Put
		else
			(ShowMovie 1 14) ; Put
		)
	)

	(method (resume)
		(if paused
			(ShowMovie 1 5) ; Put
			(= paused 0)
		)
	)
)

(class VmdMovie of Movie
	(properties
		type 2
		size 0
	)

	(method (open param1 param2 param3 &tmp temp0)
		(= number param1)
		(if (and (> argc 0) param2)
			(= size param2)
			(if (and (> argc 1) param3)
				(= caller param3)
			)
		)
		(= temp0 (Str format: {%d.vmd} number))
		(PlayVMD 0 (temp0 data:) size) ; Open
		(temp0 dispose:)
		(= opened 1)
	)

	(method (put param1 param2 param3 param4)
		(if (not number)
			(return)
		)
		(if (and param1 (> argc 0))
			(self posn: param1 param2)
			(if (and (> argc 1) param3)
				(PlayVMD 1 x y param3 (and (> argc 2) param4 param4)) ; Put
			)
		)
	)

	(method (showCursor)
		(PlayVMD 16 1) ; ShowCursor
	)

	(method (posn)
		(super posn: &rest)
		(PlayVMD 1 x y) ; Put
	)

	(method (setWaitEvent param1 param2)
		(if (and (> argc 0) param1)
			(PlayVMD 14 param1 (and (> argc 1) param2 param2)) ; WaitEvent
		else
			(PlayVMD 14) ; WaitEvent
		)
	)

	(method (putDouble))

	(method (stop param1 &tmp temp0)
		(if (and (> argc 0) param1)
			(= number param1)
		)
		(= temp0 (Str format: {%d.vmd} number))
		(PlayVMD 3 (temp0 data:)) ; Stop
		(temp0 dispose:)
	)

	(method (close)
		(PlayVMD 6) ; Close
		(= opened 0)
	)

	(method (black param1 param2 param3 param4)
		(PlayVMD 21 param1 param2 param3 param4) ; Black
	)

	(method (play param1 param2)
		(if argc
			(PlayVMD 2 param1 param2) ; Play
		else
			(PlayVMD 2) ; Play
		)
	)

	(method (setPal)
		(PlayVMD 7) ; SetPalette
	)

	(method (getStatus)
		(PlayVMD 10) ; GetStatus
	)
)

