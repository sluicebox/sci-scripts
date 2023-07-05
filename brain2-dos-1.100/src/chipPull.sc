;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 369)
(include sci.sh)
(use Main)
(use PuzzleIcon)
(use Feature)
(use Motion)
(use Actor)
(use System)

(public
	chipPull 0
)

(local
	local0
	local1
)

(instance chipPull of Script
	(properties)

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= local1 gUseSortedFeatures)
				(= gUseSortedFeatures 1)
				(thePan init:)
				(theEdge init:)
				(= local0 (Graph grSAVE_BOX 5 62 179 259 1))
				(DrawCel 400 0 1 62 5 14)
				(DrawCel 400 0 0 62 80 14)
				(lArrow init: setCycle: Fwd)
				(rArrow init: setCycle: Fwd)
				(danger init: setCycle: fwdPart)
				(dial init: setCycle: randFew)
				(hatch init:)
				(chp init:)
				(if register
					(hatch setCycle: End)
					(dial cycleSpeed: 24 setCycle: End self)
					(chp loop: 10)
				else
					(sparks init: setCycle: Fwd)
					(gTheIconBar disable: 5 6)
					(chipF init:)
				)
			)
			(1
				(danger setCycle: End self)
				(lArrow dispose:)
				(rArrow dispose:)
			)
			(2
				(= ticks 50)
			)
			(3
				(danger dispose:)
				(elec init: setCycle: Fwd)
				(charge init: setCycle: Fwd)
				(= seconds 4)
			)
			(4
				(chp dispose:)
				(elec dispose:)
				(charge dispose:)
				(self dispose:)
			)
		)
	)

	(method (dispose)
		(lArrow dispose:)
		(rArrow dispose:)
		(danger dispose:)
		(dial dispose:)
		(hatch dispose:)
		(thePan dispose:)
		(theEdge dispose:)
		(chipF dispose:)
		(sparks dispose:)
		(Graph grRESTORE_BOX local0)
		(Graph grUPDATE_BOX 5 62 179 259 1)
		(Graph grFILL_BOX 5 62 179 259 2 -1 0 -1)
		(= gUseSortedFeatures local1)
		(gTheIconBar enable: 5 6)
		(super dispose: &rest)
	)

	(method (doit)
		(if (not register)
			(Palette palANIMATE 224 230 4)
		)
		(Palette palANIMATE 230 235 20)
		(super doit:)
	)
)

(instance thePan of Feature
	(properties
		y 180
		noun 21
		nsTop 5
		nsLeft 62
		nsBottom 178
		nsRight 258
	)

	(method (doVerb theVerb)
		(switch theVerb
			(1
				(proc15_0 0 21 1)
				(proc15_0 0 21 1 24)
			)
			(4
				(proc15_0 0 21 4 24)
			)
			(else
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance theEdge of Feature
	(properties
		y 179
		noun -1
		nsBottom 189
		nsRight 319
	)
)

(instance chipF of Feature
	(properties
		y 190
		noun 5
		nsTop 103
		nsLeft 165
		nsBottom 116
		nsRight 198
	)

	(method (doVerb theVerb)
		(if (== theVerb 4)
			(SetCursor (chp view:) (chp loop:) (chp cel:))
			(chp dispose:)
			(chipPull dispose:)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance lArrow of Prop
	(properties
		x 145
		y 45
		view 400
		loop 5
		priority 14
		signal 16
	)
)

(instance rArrow of Prop
	(properties
		x 203
		y 45
		view 400
		loop 6
		cel 2
		priority 14
		signal 16
	)
)

(instance danger of Prop
	(properties
		x 154
		y 14
		view 400
		loop 2
		priority 14
		signal 16
		cycleSpeed 14
	)
)

(instance dial of Prop
	(properties
		x 231
		y 60
		view 400
		loop 3
		priority 14
		signal 16
	)
)

(instance hatch of Prop
	(properties
		x 170
		y 43
		view 400
		loop 4
		priority 14
		signal 16
		cycleSpeed 24
	)
)

(instance elec of Prop
	(properties
		x 123
		y 43
		view 400
		loop 7
		cel 6
		priority 14
		signal 16
	)
)

(instance charge of Prop
	(properties
		x 154
		y 15
		view 400
		loop 8
		priority 14
		signal 16
	)
)

(instance chp of View
	(properties
		x 165
		y 103
		view 400
		loop 1
		priority 14
		signal 272
	)

	(method (onMe)
		(return 0)
	)
)

(instance sparks of Prop
	(properties
		x 181
		y 109
		view 400
		loop 9
		priority 14
		signal 16
	)
)

(instance randFew of Cycle
	(properties
		cycleDir 2
	)

	(method (doit)
		(if (>= (Abs (- gGameTime cycleCnt)) (client cycleSpeed:))
			(= cycleCnt gGameTime)
			(client cel: (Random 0 cycleDir))
		)
	)
)

(instance fwdPart of Cycle
	(properties)

	(method (doit &tmp temp0)
		(if (>= (Abs (- gGameTime cycleCnt)) (client cycleSpeed:))
			(= cycleCnt gGameTime)
			(= temp0 (+ (client cel:) 1))
			(client cel: (if (> temp0 cycleDir) 0 else temp0))
		)
	)
)

