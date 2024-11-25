;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 32)
(include sci.sh)
(use Interface)
(use Dialog)
(use System)

(class DColorButton of DButton
	(properties
		mode 0
		nfc 0
		nbc 7
		hfc 15
		hbc 7
		sfc 7
		sbc 7
	)

	(method (setSize param1 &tmp [temp0 4])
		(TextSize @[temp0 0] text font (if argc param1 else 0))
		(+= [temp0 2] 2)
		(+= [temp0 3] 2)
		(= nsBottom (+ nsTop [temp0 2]))
		(= [temp0 3] (* (/ (+ [temp0 3] 15) 16) 16))
		(= nsRight (+ [temp0 3] nsLeft))
	)

	(method (draw &tmp temp0 temp1)
		(if (& state $0008)
			(= temp0 hfc)
			(= temp1 hbc)
		else
			(= temp0 nfc)
			(= temp1 nbc)
		)
		(Display
			text
			dsCOORD
			nsLeft
			nsTop
			dsWIDTH
			(- nsRight nsLeft)
			dsFONT
			font
			dsCOLOR
			temp0
			dsBACKGROUND
			temp1
			dsALIGN
			mode
		)
	)

	(method (track param1 &tmp temp0 temp1 temp2 temp3)
		(if (== 1 (param1 type:))
			(= temp1 0)
			(repeat
				(= param1 (Event new: evPEEK))
				(param1 localize:)
				(if (!= (= temp0 (self check: param1)) temp1)
					(if (& state $0008)
						(= temp2 sfc)
						(= temp3 sbc)
					else
						(= temp2 hfc)
						(= temp3 hbc)
					)
					(Display
						text
						dsCOORD
						nsLeft
						nsTop
						dsWIDTH
						(- nsRight nsLeft)
						dsFONT
						font
						dsCOLOR
						temp2
						dsBACKGROUND
						temp3
						dsALIGN
						mode
					)
					(= temp1 temp0)
				)
				(param1 dispose:)
				(breakif (not (StillDown)))
			)
			(if temp0
				(if (& state $0008)
					(= temp2 sfc)
					(= temp3 sbc)
				else
					(= temp2 hfc)
					(= temp3 hbc)
				)
				(Display
					text
					dsCOORD
					nsLeft
					nsTop
					dsWIDTH
					(- nsRight nsLeft)
					dsFONT
					font
					dsCOLOR
					temp2
					dsBACKGROUND
					temp3
					dsALIGN
					mode
				)
			)
			(return temp0)
		else
			(return self)
		)
	)
)

