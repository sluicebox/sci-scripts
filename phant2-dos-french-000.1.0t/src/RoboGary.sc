;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 63017)
(include sci.sh)
(use Main)
(use Array)
(use WriteFeature)
(use System)

(class RoboGary of Obj
	(properties
		seconds 0
		lastSeconds 0
		myVol 100
		theScore -1
		metronome 0
		myCue -1
	)

	(method (cue)
		(if (not (& state $0010))
			(gP2SongPlyr stop:)
			(return 0)
		)
		(= myCue -1)
		(return
			(switch (theScore at: metronome)
				(0
					(self stop:)
				)
				(1
					(self doRest: (theScore at: (+ metronome 1)))
					(+= metronome 2)
				)
				(2
					(self
						doRest:
							(Random
								(theScore at: (+ metronome 1))
								(theScore at: (+ metronome 2))
							)
					)
					(+= metronome 3)
				)
				(3
					(self doLoop:)
				)
				(4
					(self playWav: (theScore at: (+ metronome 1)))
					(+= metronome 2)
				)
				(5
					(self
						playWav:
							(theScore
								at:
									(+
										metronome
										1
										(Random
											1
											(theScore at: (+ metronome 1))
										)
									)
							)
					)
					(+= metronome (+ 2 (theScore at: (+ metronome 1))))
				)
			)
		)
	)

	(method (dispose)
		(if (!= -1 theScore)
			(theScore dispose:)
		)
		(if (!= -1 myCue)
			(myCue dispose:)
		)
		(gCast delete: self)
		(super dispose:)
	)

	(method (doit &tmp temp0)
		(if (and (& state $0010) (!= (= temp0 (GetTime 1)) lastSeconds)) ; SysTime12
			(= lastSeconds temp0)
			(if (<= (-- seconds) 0)
				(gCast delete: self)
				(self setMyCue:)
			)
		)
	)

	(method (doLoop)
		(= metronome 0)
		(self setMyCue:)
	)

	(method (doRest param1)
		(= seconds param1)
		(gCast add: self)
	)

	(method (fadeTo param1 &tmp temp0)
		(= temp0 (Min 100 param1))
		(gP2SongPlyr fadeTo: (= myVol temp0) 6 10)
	)

	(method (isPlaying)
		(return (& state $0010))
	)

	(method (new &tmp temp0)
		((= temp0 (super new:)) theScore: (IntArray with: 0) metronome: 0)
		(return temp0)
	)

	(method (playWav param1 &tmp temp0)
		(= temp0 (Min 100 myVol))
		(gP2SongPlyr fadeIn: param1 temp0 1 1 0 self)
	)

	(method (randomize &tmp temp0 temp1 temp2)
		(self start:)
		(= temp1 0)
		(= temp0 0)
		(while (not (OneOf (theScore at: temp1) 3 0))
			(++ temp0)
			(+=
				temp1
				(switch (theScore at: temp1)
					(4 2)
					(5
						(+ 2 (theScore at: (+ temp1 1)))
					)
					(1 2)
					(2 3)
				)
			)
		)
		(= temp2 (Random 0 temp0))
		(for
			((= temp1 0))
			(<= temp1 temp2)
			(
				(+=
					temp1
					(switch (theScore at: temp1)
						(4 2)
						(5
							(+ 2 (theScore at: (+ temp1 1)))
						)
						(1 2)
						(2 3)
					)
				)
			)
		)
		(= metronome temp1)
	)

	(method (setMyCue)
		(if (!= myCue -1)
			(myCue dispose:)
		)
		(= myCue (Cue new: self))
	)

	(method (setScore)
		(if argc
			(if (== theScore -1)
				(= theScore (IntArray with: 0))
			)
			(theScore at: 0 &rest 3)
		)
	)

	(method (start)
		(if (not (& state $0010))
			(= lastSeconds (= seconds (= metronome 0)))
			(|= state $0010)
			(self setMyCue:)
		)
	)

	(method (stop param1)
		(if (& state $0010)
			(if (!= myCue -1)
				(myCue dispose:)
				(= myCue -1)
			)
			(gCast delete: self)
			(if (and argc param1)
				(gP2SongPlyr fadeOut: 0)
			else
				(gP2SongPlyr stop:)
			)
			(&= state $ffef)
		)
	)
)

