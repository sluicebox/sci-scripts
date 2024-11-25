;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 410)
(include sci.sh)
(use Interface)
(use System)

(public
	stopCh 0
)

(instance stopCh of Controls
	(properties)

	(method (draw &tmp temp0 temp1 temp2)
		(= window -1)
		(= temp2 (NewWindow 65 83 108 188 0 0 -1 0 6))
		(self add: (= temp0 (DPButton new:)))
		(temp0 view: 801 setSize: value: 1 moveTo: 0 1)
		(self add: (= temp0 (DPButton new:)))
		(temp0 view: 18 setSize: value: 0 moveTo: 58 6)
		(super draw:)
		(Graph grUPDATE_BOX 65 83 108 188 1)
		(= temp0 0)
		(while (not temp0)
			((= temp1 (Event new:)) localize:)
			(= temp0 (self handleEvent: temp1))
			(temp1 dispose:)
		)
		(= temp0 (temp0 value:))
		(self dispose:)
		(DisposeWindow temp2)
		(return temp0)
	)
)

(instance DPButton of DIcon
	(properties
		state 3
	)

	(method (track param1 &tmp temp0)
		(repeat
			(= param1 (Event new: evPEEK))
			(param1 localize:)
			(if (and (= temp0 (self check: param1)) (not cel))
				(++ cel)
				(self draw:)
			)
			(if (and (not temp0) cel)
				(-- cel)
				(self draw:)
			)
			(param1 dispose:)
			(breakif (not (StillDown)))
		)
		(= temp0 (if cel self else 0))
		(= cel 0)
		(self draw:)
		(return temp0)
	)
)

