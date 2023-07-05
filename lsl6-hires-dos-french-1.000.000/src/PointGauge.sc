;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 88)
(include sci.sh)
(use Main)
(use Str)
(use Actor)
(use System)

(public
	PointGauge 0
)

(procedure (localproc_0 param1 param2 &tmp temp0)
	(= temp0 (if (== param2 -1) 0 else param2))
	(switch param1
		(0
			(UpdateScreenItem (indicator1 loop: temp0 cel: 0 yourself:))
		)
		(1
			(UpdateScreenItem (indicator2 loop: temp0 cel: 0 yourself:))
		)
		(2
			(UpdateScreenItem (indicator3 loop: temp0 cel: 0 yourself:))
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
				(= cel 15)
			)
			(else
				(-- loop)
				(= cel 15)
			)
		)
	)

	(method (doit)
		(if (<= (-= ticks (Abs (- gGameTime lastTicks))) 0)
			(= ticks cycleSpeed)
			(cond
				((and (> dir 0) (<= cel 15))
					(self show:)
					(++ cel)
					(if (> cel 15)
						(if caller
							(caller cue:)
						)
						(= active 0)
					)
					(super doit:)
				)
				((and (< dir 0) (> cel 0))
					(-- cel)
					(self show:)
					(super doit:)
				)
				(else
					(if caller
						(caller cue:)
					)
					(= active 0)
					(super doit:)
				)
			)
		)
		(= lastTicks gGameTime)
	)
)

(instance indicator1 of Indicator
	(properties
		x 188
		y 3
		priority 200
		fixPriority 1
		view 9721
		cycleSpeed 3
	)
)

(instance indicator2 of Indicator
	(properties
		x 182
		y 3
		priority 200
		fixPriority 1
		view 9721
		cycleSpeed 3
	)
)

(instance indicator3 of Indicator
	(properties
		x 176
		y 3
		priority 200
		fixPriority 1
		view 9721
		cycleSpeed 3
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

	(method (init &tmp temp0)
		(indicator1 init: (ScriptID 0 1)) ; controlSet
		(indicator2 init: (ScriptID 0 1)) ; controlSet
		(indicator3 init: (ScriptID 0 1)) ; controlSet
		(= running 1)
	)

	(method (dispose)
		(indicator1 dispose:)
		(indicator2 dispose:)
		(indicator3 dispose:)
		(= running 0)
		(super dispose: &rest)
	)

	(method (show)
		(if (not (indicator1 plane:))
			(self init:)
		)
		(indicator1 show:)
		(indicator2 show:)
		(indicator3 show:)
		(self update:)
		(= running 0)
	)

	(method (hide)
		(= running 1)
		(indicator1 hide:)
		(indicator2 hide:)
		(indicator3 hide:)
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
		(if (not (gGame controlsVisible:))
			(return)
		)
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

	(method (update &tmp temp0 temp1 temp2 temp3)
		(indicator1 active: 0)
		(indicator2 active: 0)
		(indicator3 active: 0)
		(= temp0 (Str format: {%d} gScore))
		(= temp1 (temp0 size:))
		(for ((= temp2 0)) (< temp2 temp1) ((++ temp2))
			(= temp3 (- (temp0 at: (- (- temp1 temp2) 1)) 48))
			(localproc_0 temp2 temp3)
		)
		(for ((= temp2 0)) (< temp2 (- 3 (- temp1 1))) ((++ temp2))
			(localproc_0 (- 3 temp2) -1)
		)
		(= currentValue gScore)
		(temp0 dispose:)
	)
)

