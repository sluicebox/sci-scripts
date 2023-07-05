;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 975)
(include sci.sh)
(use Interface)

(class DSelector of Item
	(properties
		type 6
		font 0
		x 20
		y 6
		text 0
		cursor 0
		lsTop 0
		mark 0
	)

	(method (indexOf param1 &tmp temp0 temp1)
		(= temp0 text)
		(for ((= temp1 0)) (< temp1 300) ((++ temp1))
			(if (== 0 (StrLen temp0))
				(return -1)
			)
			(if (not (StrCmp param1 temp0))
				(return temp1)
			)
			(+= temp0 x)
		)
	)

	(method (at param1)
		(return (+ text (* x param1)))
	)

	(method (setSize &tmp [temp0 4])
		(TextSize @[temp0 0] {M} font)
		(= nsBottom (+ nsTop 20 (* [temp0 2] y)))
		(= nsRight (+ nsLeft (/ (* [temp0 3] x 3) 4)))
		(= lsTop (= cursor text))
		(= mark 0)
	)

	(method (retreat param1 &tmp temp0)
		(= temp0 0)
		(while param1
			(if (!= cursor text)
				(= temp0 1)
				(-= cursor x)
				(if mark
					(-- mark)
				else
					(-= lsTop x)
				)
			else
				(break)
			)
			(-- param1)
		)
		(if temp0
			(self draw:)
		)
	)

	(method (advance param1 &tmp temp0)
		(= temp0 0)
		(while param1
			(if (StrAt cursor x)
				(= temp0 1)
				(+= cursor x)
				(if (< (+ mark 1) y)
					(++ mark)
				else
					(+= lsTop x)
				)
			else
				(break)
			)
			(-- param1)
		)
		(if temp0
			(self draw:)
		)
	)

	(method (handleEvent event &tmp temp0 [temp1 3] temp4 [temp5 4])
		(if (event claimed:)
			(return 0)
		)
		(if (== $0040 (event type:)) ; direction
			(event type: evKEYBOARD)
			(switch (event message:)
				(JOY_DOWN
					(event message: KEY_DOWN)
				)
				(JOY_UP
					(event message: KEY_UP)
				)
				(else
					(event type: $0040) ; direction
				)
			)
		)
		(= temp0 0)
		(switch (event type:)
			(evKEYBOARD
				(event claimed: 1)
				(switch (event message:)
					(KEY_HOME
						(self retreat: 50)
					)
					(KEY_END
						(self advance: 50)
					)
					($5100 ; PAGEDOWN
						(self advance: (- y 1))
					)
					($4900 ; PAGEUP
						(self retreat: (- y 1))
					)
					(KEY_DOWN
						(self advance: 1)
					)
					(KEY_UP
						(self retreat: 1)
					)
					(else
						(event claimed: 0)
					)
				)
			)
			(evMOUSEBUTTON
				(if (self check: event)
					(event claimed: 1)
					(cond
						((< (event y:) (+ nsTop 10))
							(repeat
								(self retreat: 1)
								(breakif (not (StillDown)))
							)
						)
						((> (event y:) (- nsBottom 10))
							(repeat
								(self advance: 1)
								(breakif (not (StillDown)))
							)
						)
						(else
							(TextSize @[temp5 0] {M} font)
							(if
								(>
									(= temp4
										(/
											(- (event y:) (+ nsTop 10))
											[temp5 2]
										)
									)
									mark
								)
								(self advance: (- temp4 mark))
							else
								(self retreat: (- mark temp4))
							)
						)
					)
				)
			)
		)
		(if (and (event claimed:) (& state $0002)) self else 0)
	)
)

