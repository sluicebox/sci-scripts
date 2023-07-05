;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 64003)
(include sci.sh)
(use Main)
(use oInterface)
(use TPSound)
(use Str)
(use Actor)
(use System)

(procedure (ChangeDial number value &tmp theVal)
	(= theVal (if (== value -1) 0 else value))
	(switch number
		(0
			(if (!= (scoreOnes loop:) theVal)
				(UpdateScreenItem (scoreOnes loop: theVal cel: 0 yourself:))
			)
		)
		(1
			(if (!= (scoreTens loop:) theVal)
				(UpdateScreenItem (scoreTens loop: theVal cel: 0 yourself:))
			)
		)
		(2
			(if (!= (scoreHundreds loop:) theVal)
				(UpdateScreenItem (scoreHundreds loop: theVal cel: 0 yourself:))
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

	(method (init lview lx ly)
		(= x lx)
		(= y ly)
		(= view lview)
		(super init: &rest)
	)

	(method (advance d whoCares)
		(= lastTicks gGameTime)
		(= ticks 1)
		(if argc
			(= caller whoCares)
		)
		(= active 1)
		(if (== (= dir d) -1)
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

	(method (init &tmp xpos)
		(= xpos x)
		(scoreHundreds init: view xpos y &rest)
		(= xpos (+ (+= xpos (CelWide view 0 0)) margin))
		(scoreTens init: view xpos y &rest)
		(= xpos (+ (+= xpos (CelWide view 0 0)) margin))
		(scoreOnes init: view xpos y &rest)
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

	(method (advance d &tmp theLoop dir oldLoop2)
		(= running 1)
		(if (or (not argc) d)
			(++ currentValue)
			(= theLoop 9)
			(= dir 1)
		else
			(-- currentValue)
			(= theLoop 0)
			(= dir -1)
		)
		(if (== (scoreOnes loop:) theLoop)
			(= oldLoop2 (scoreTens loop:))
			(scoreTens advance: dir (and (!= dir -1) scoreTens))
			(if (== oldLoop2 theLoop)
				(scoreHundreds advance: dir (and (!= dir -1) scoreHundreds))
			)
		)
		(scoreOnes advance: dir self)
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

	(method (update &tmp scoreStr strLen theLoop theVal)
		(scoreOnes active: 0)
		(scoreTens active: 0)
		(scoreHundreds active: 0)
		(= scoreStr (Str format: {%d} gScore))
		(= strLen (scoreStr size:))
		(for ((= theLoop 0)) (< theLoop strLen) ((++ theLoop))
			(= theVal (- (scoreStr at: (- (- strLen theLoop) 1)) 48))
			(ChangeDial theLoop theVal)
		)
		(for ((= theLoop 0)) (< theLoop (- 3 (- strLen 1))) ((++ theLoop))
			(ChangeDial (- 3 theLoop) -1)
		)
		(= currentValue gScore)
		(scoreStr dispose:)
	)

	(method (addScore value)
		(if (> value 0)
			(if (!= sound -1)
				(scoreSound playSound:)
			)
			(ResetHintTimer)
		)
		(if (< (+= gScore value) 0)
			(= gScore 0)
		)
		(if (> gScore 999)
			(= gScore 999)
		)
		(self update:)
	)
)

