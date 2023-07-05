;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64003)
(include sci.sh)
(use Main)
(use TPSound)
(use Str)
(use Actor)
(use System)

(procedure (localproc_0 param1 param2 &tmp temp0)
	(= temp0 (if (== param2 -1) 0 else param2))
	(switch param1
		(0
			(if (!= (scoreOnes loop:) temp0)
				(UpdateScreenItem (scoreOnes loop: temp0 cel: 0 yourself:))
			)
		)
		(1
			(if (!= (scoreTens loop:) temp0)
				(UpdateScreenItem (scoreTens loop: temp0 cel: 0 yourself:))
			)
		)
		(2
			(if (!= (scoreHundreds loop:) temp0)
				(UpdateScreenItem (scoreHundreds loop: temp0 cel: 0 yourself:))
			)
		)
	)
)

(class Indicator of Prop
	(properties
		priority 200
		fixPriority 1
		cycleSpeed 3
		dir 1
		active 0
		caller 0
		lastTicks 0
		ticks 0
	)

	(method (init param1 param2 param3)
		(= x param2)
		(= y param3)
		(= view param1)
		(super init: &rest)
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
				(= cel (self lastCel:))
			)
			(else
				(-- loop)
				(= cel (self lastCel:))
			)
		)
	)

	(method (doit)
		(if (<= (-= ticks (Abs (- gGameTime lastTicks))) 0)
			(= ticks cycleSpeed)
			(cond
				((and (> dir 0) (<= cel (self lastCel:)))
					(self show:)
					(++ cel)
					(if (> cel (self lastCel:))
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

(instance scoreOnes of Indicator
	(properties)
)

(instance scoreTens of Indicator
	(properties)
)

(instance scoreHundreds of Indicator
	(properties)
)

(instance scoreSound of TPSound
	(properties)
)

(class PointGauge of Code
	(properties
		currentValue 0
		running 0
		sound -1
		margin 0
		view 0
		x 0
		y 0
	)

	(method (handleEvent)
		(return 0)
	)

	(method (init &tmp temp0)
		(= temp0 x)
		(scoreHundreds init: view temp0 y &rest)
		(= temp0 (+ (+= temp0 (CelWide view 0 0)) margin))
		(scoreTens init: view temp0 y &rest)
		(= temp0 (+ (+= temp0 (CelWide view 0 0)) margin))
		(scoreOnes init: view temp0 y &rest)
		(if (!= sound -1)
			(scoreSound number: sound)
		)
		(= running 1)
	)

	(method (dispose)
		(scoreOnes dispose:)
		(scoreTens dispose:)
		(scoreHundreds dispose:)
		(scoreSound dispose:)
		(= running 0)
		(super dispose: &rest)
	)

	(method (show)
		(if (not (scoreOnes plane:))
			(self init:)
		)
		(scoreOnes show:)
		(scoreTens show:)
		(scoreHundreds show:)
		(self update:)
		(= running 0)
	)

	(method (hide)
		(= running 1)
		(scoreOnes hide:)
		(scoreTens hide:)
		(scoreHundreds hide:)
	)

	(method (cue &tmp temp0)
		(if (!= (scoreOnes dir:) -1)
			(scoreOnes cue:)
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
		(if (== (scoreOnes loop:) temp0)
			(= temp2 (scoreTens loop:))
			(scoreTens advance: temp1 (and (!= temp1 -1) scoreTens))
			(if (== temp2 temp0)
				(scoreHundreds advance: temp1 (and (!= temp1 -1) scoreHundreds))
			)
		)
		(scoreOnes advance: temp1 self)
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
		(if (scoreOnes active:)
			(scoreOnes doit:)
		)
		(if (scoreTens active:)
			(scoreTens doit:)
		)
		(if (scoreHundreds active:)
			(scoreHundreds doit:)
		)
	)

	(method (update &tmp temp0 temp1 temp2 temp3)
		(scoreOnes active: 0)
		(scoreTens active: 0)
		(scoreHundreds active: 0)
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

	(method (addScore param1)
		(if (and (> param1 0) (!= sound -1))
			(scoreSound playSound:)
		)
		(if (< (+= gScore param1) 0)
			(= gScore 0)
		)
		(if (> gScore 999)
			(= gScore 999)
		)
		(self update:)
	)
)

