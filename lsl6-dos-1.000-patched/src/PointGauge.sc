;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 88)
(include sci.sh)
(use Main)
(use Actor)
(use System)

(public
	PointGauge 0
)

(procedure (localproc_0 param1 param2 &tmp temp0)
	(= temp0 (if (== param2 -1) 0 else param2))
	(switch param1
		(0
			(indicator1 loop: temp0 cel: 0 show:)
		)
		(1
			(indicator2 loop: temp0 cel: 0 show:)
		)
		(2
			(indicator3 loop: temp0 cel: 0 show:)
		)
	)
)

(class Indicator of Prop
	(properties
		dir 1
		active 0
		caller 0
		lastTicks 0
		ticks 0
	)

	(method (advance param1 param2)
		(= lastTicks gGameTime)
		(= ticks 1)
		(if argc
			(= caller param2)
		)
		(= active 1)
		(if (== (= dir param1) -1)
			(self cue:)
		)
	)

	(method (stop)
		(if active
			(= active 0)
			(self cue:)
		)
	)

	(method (show)
		(SetPort 0)
		(DrawCel view loop cel x y -1)
		(SetPort 0 0 139 320 10 0)
	)

	(method (cue)
		(cond
			((and (== dir 1) (== loop 9))
				(= cel (= loop 0))
			)
			((== dir 1)
				(++ loop)
				(= cel 0)
			)
			((== loop 0)
				(= loop 9)
				(= cel 4)
			)
			(else
				(-- loop)
				(= cel 4)
			)
		)
	)

	(method (doit)
		(if (<= (-= ticks (Abs (- gGameTime lastTicks))) 0)
			(= ticks cycleSpeed)
			(cond
				((and (> dir 0) (<= cel 4))
					(self show:)
					(++ cel)
					(if (> cel 4)
						(if caller
							(caller cue:)
						)
						(= active 0)
					)
				)
				((and (< dir 0) (> cel 0))
					(-- cel)
					(self show:)
				)
				(else
					(if caller
						(caller cue:)
					)
					(= active 0)
				)
			)
		)
		(= lastTicks gGameTime)
	)
)

(instance indicator1 of Indicator
	(properties
		x 270
		y 146
		view 971
	)
)

(instance indicator2 of Indicator
	(properties
		x 260
		y 146
		view 971
	)
)

(instance indicator3 of Indicator
	(properties
		x 250
		y 146
		view 971
	)
)

(class PointGauge of Code
	(properties
		currentValue 0
		running 0
	)

	(method (handleEvent)
		(return 0)
	)

	(method (init)
		(= running 1)
	)

	(method (show)
		(= running 0)
	)

	(method (hide)
		(= running 1)
		(indicator1 stop:)
		(indicator2 stop:)
		(indicator3 stop:)
	)

	(method (cue &tmp temp0)
		(if (!= (indicator1 dir:) -1)
			(indicator1 cue:)
		)
		(= running 0)
	)

	(method (advance param1 &tmp temp0 temp1 temp2)
		(= running 1)
		(if (or (not argc) param1)
			(++ currentValue)
			(= temp0 9)
			(= temp1 1)
		else
			(-- currentValue)
			(= temp0 0)
			(= temp1 -1)
		)
		(if (== (indicator1 loop:) temp0)
			(= temp2 (indicator2 loop:))
			(indicator2 advance: temp1 (and (!= temp1 -1) indicator2))
			(if (== temp2 temp0)
				(indicator3 advance: temp1 (and (!= temp1 -1) indicator3))
			)
		)
		(indicator1 advance: temp1 self)
	)

	(method (doit)
		(if (and (!= gScore currentValue) (not running))
			(cond
				((> gScore currentValue)
					(self advance:)
				)
				((< gScore currentValue)
					(self advance: 0)
				)
			)
		)
		(if (indicator1 active:)
			(indicator1 doit:)
		)
		(if (indicator2 active:)
			(indicator2 doit:)
		)
		(if (indicator3 active:)
			(indicator3 doit:)
		)
	)

	(method (update &tmp [temp0 5] temp5 temp6 temp7)
		(indicator1 active: 0)
		(indicator2 active: 0)
		(indicator3 active: 0)
		(Format @temp0 {%d} gScore)
		(= temp5 (StrLen @temp0))
		(for ((= temp6 0)) (< temp6 temp5) ((++ temp6))
			(= temp7 (- (StrAt @temp0 (- (- temp5 temp6) 1)) 48))
			(localproc_0 temp6 temp7)
		)
		(for ((= temp6 0)) (< temp6 (- 3 (- temp5 1))) ((++ temp6))
			(localproc_0 (- 3 temp6) -1)
		)
		(= currentValue gScore)
	)
)

