;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 85)
(include sci.sh)
(use Main)
(use PuzzleBar)
(use Polygon)
(use Motion)
(use Actor)
(use System)

(public
	tomb 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
)

(instance tomb of PuzzleBar
	(properties)

	(method (init)
		(super init:)
		(stoneDisk init: puzzleCast)
		(stone init: puzzleCast)
	)

	(method (helpYou &tmp temp0)
		(gMessager say: 4 9 0 (++ local3))
		(if (== local3 5)
			(SetFlag 361)
			(= temp0 (gTheIconBar getCursor:))
			(gGlory
				setCursor:
					(temp0 view: local0 loop: local1 cel: local2 yourself:)
			)
			(tomb state: (& (tomb state:) $ffdf))
		)
	)

	(method (setPlane)
		(= usePlane 0)
		(plane
			priority: (+ (GetHighPlanePri) 1)
			init:
			setRect: 0 10 319 199
			addCast: puzzleCast
		)
	)

	(method (addIcons))

	(method (resetPuzzle &tmp temp0)
		(= temp0 (gTheIconBar getCursor:))
		(= local0 (temp0 view:))
		(= local1 (temp0 loop:))
		(= local2 (temp0 cel:))
		(gGlory setCursor: (temp0 view: 999 loop: 0 cel: 0 yourself:))
		(= local4 0)
		(= local5 3)
		(= local6 0)
		(self
			add:
				essenceButton
				bloodButton
				heartButton
				breathButton
				senseButton
				boneButton
				mouthButton
				helpIcon
				exitIcon
			eachElementDo: #init self
			eachElementDo: #show
		)
	)

	(method (dispose)
		(gGlory
			setCursor:
				((gTheIconBar getCursor:)
					view: local0
					loop: local1
					cel: local2
					yourself:
				)
		)
		(super dispose:)
	)
)

(instance turnKnob of Script
	(properties)

	(method (changeState newState &tmp temp0)
		(switch (= state newState)
			(0
				(tomb noHands: 1)
				(if (^= local6 $0001)
					(stoneDisk setCycle: myCycleTo (register value2:) -1 self)
				else
					(stoneDisk setCycle: myCycleTo (register value2:) 1 self)
				)
			)
			(1
				(cond
					((== local4 (register value:))
						(if (> local4 5)
							(SetFlag 361)
							(= temp0 (gTheIconBar getCursor:))
							(gGlory
								setCursor:
									(temp0
										view: local0
										loop: local1
										cel: local2
										yourself:
									)
							)
							(tomb state: (& (tomb state:) $ffdf))
						else
							(++ local4)
							(= ticks 1)
						)
					)
					((not (-- local5))
						(= local5 3)
						(= local4 0)
						(= local6 0)
						(stoneDisk setCycle: myCycleTo 5 1 self)
					)
					(else
						(= ticks 1)
					)
				)
			)
			(2
				(tomb noHands: 0)
				(self dispose:)
			)
		)
	)
)

(instance stone of View
	(properties
		x 61
		y 52
		view 556
	)
)

(instance stoneDisk of Prop
	(properties
		x 164
		y 102
		priority 245
		fixPriority 1
		view 556
		loop 1
		cel 5
		signal 16385
		cycleSpeed 12
	)
)

(instance mouthButton of TextIcon
	(properties
		nsLeft 188
		nsTop 81
		x 188
		y 81
		view 556
		loop 3
		value2 6
	)

	(method (init param1 &tmp temp0)
		(= nsRight (+ nsLeft (CelWide view loop 1)))
		(= nsBottom (+ nsTop (CelHigh view loop 1)))
		(= owner param1)
		(&= signal $fff7)
		((owner puzzleCast:) add: self)
		(= plane (owner plane:))
		(AddScreenItem self)
	)

	(method (select)
		(if (super select: &rest)
			(tomb setScript: turnKnob 0 self)
		)
	)
)

(instance boneButton of TextIcon
	(properties
		nsLeft 192
		nsTop 101
		x 192
		y 101
		view 556
		loop 4
		value 1
		value2 7
	)

	(method (init param1 &tmp temp0)
		(= nsRight (+ nsLeft (CelWide view loop 1)))
		(= nsBottom (+ nsTop (CelHigh view loop 1)))
		(= owner param1)
		(&= signal $fff7)
		((owner puzzleCast:) add: self)
		(= plane (owner plane:))
		(AddScreenItem self)
	)

	(method (select)
		(if (super select: &rest)
			(tomb setScript: turnKnob 0 self)
		)
	)
)

(instance bloodButton of TextIcon
	(properties
		nsLeft 191
		nsTop 127
		x 191
		y 127
		view 556
		loop 5
		value 2
	)

	(method (init param1 &tmp temp0)
		(= nsRight (+ nsLeft (CelWide view loop 1)))
		(= nsBottom (+ nsTop (CelHigh view loop 1)))
		(= owner param1)
		(&= signal $fff7)
		((owner puzzleCast:) add: self)
		(= plane (owner plane:))
		(AddScreenItem self)
	)

	(method (select)
		(if (super select: &rest)
			(tomb setScript: turnKnob 0 self)
		)
	)
)

(instance breathButton of TextIcon
	(properties
		nsLeft 160
		nsTop 136
		x 160
		y 136
		view 556
		loop 6
		value 3
		value2 1
	)

	(method (init param1 &tmp temp0)
		(= nsRight (+ nsLeft (CelWide view loop 1)))
		(= nsBottom (+ nsTop (CelHigh view loop 1)))
		(= owner param1)
		(&= signal $fff7)
		((owner puzzleCast:) add: self)
		(= plane (owner plane:))
		(AddScreenItem self)
	)

	(method (select)
		(if (super select: &rest)
			(tomb setScript: turnKnob 0 self)
		)
	)
)

(instance senseButton of TextIcon
	(properties
		nsLeft 130
		nsTop 123
		x 130
		y 123
		view 556
		loop 7
		value 4
		value2 2
	)

	(method (init param1 &tmp temp0)
		(= nsRight (+ nsLeft (CelWide view loop 1)))
		(= nsBottom (+ nsTop (CelHigh view loop 1)))
		(= owner param1)
		(&= signal $fff7)
		((owner puzzleCast:) add: self)
		(= plane (owner plane:))
		(AddScreenItem self)
	)

	(method (select)
		(if (super select: &rest)
			(tomb setScript: turnKnob 0 self)
		)
	)
)

(instance heartButton of TextIcon
	(properties
		nsLeft 124
		nsTop 106
		x 124
		y 106
		view 556
		loop 8
		value 5
		value2 3
	)

	(method (init param1 &tmp temp0)
		(= nsRight (+ nsLeft (CelWide view loop 1)))
		(= nsBottom (+ nsTop (CelHigh view loop 1)))
		(= owner param1)
		(&= signal $fff7)
		((owner puzzleCast:) add: self)
		(= plane (owner plane:))
		(AddScreenItem self)
	)

	(method (select)
		(if (super select: &rest)
			(tomb setScript: turnKnob 0 self)
		)
	)
)

(instance essenceButton of TextIcon
	(properties
		nsLeft 128
		nsTop 80
		x 128
		y 80
		view 556
		loop 9
		value 6
		value2 4
	)

	(method (init param1 &tmp temp0)
		(= nsRight (+ nsLeft (CelWide view loop 1)))
		(= nsBottom (+ nsTop (CelHigh view loop 1)))
		(= owner param1)
		(&= signal $fff7)
		((owner puzzleCast:) add: self)
		(= plane (owner plane:))
		(AddScreenItem self)
	)

	(method (select)
		(if (super select: &rest)
			(tomb setScript: turnKnob 0 self)
		)
	)
)

(instance exitIcon of TextIcon
	(properties)

	(method (init param1 &tmp temp0)
		(= owner param1)
		((owner puzzleCast:) add: self)
		(exitPoly init:)
	)

	(method (show))

	(method (highlight))

	(method (onMe)
		(if (not (exitPoly onMe: &rest))
			(return 1)
		else
			(return 0)
		)
	)

	(method (select)
		(tomb state: (& (tomb state:) $ffdf))
	)

	(method (dispose)
		(exitPoly dispose:)
		(DisposeClone self)
	)
)

(instance exitPoly of Polygon
	(properties)

	(method (init)
		(super init: 62 52 262 52 262 154 61 153)
	)
)

(instance helpIcon of TextIcon
	(properties)

	(method (init param1 &tmp temp0)
		(= owner param1)
		((owner puzzleCast:) add: self)
	)

	(method (show))

	(method (highlight))

	(method (onMe param1 param2)
		(return
			(or
				(and (< 64 param1 116) (< 55 param2 150))
				(and (< 214 param1 258) (< 55 param2 150))
			)
		)
	)

	(method (select)
		(owner helpYou:)
	)

	(method (dispose)
		(DisposeClone self)
	)
)

(instance myCycleTo of CT
	(properties)

	(method (doit &tmp temp0)
		(= temp0 (client lastCel:))
		(cond
			((and (== cycleDir 1) (== (client cel:) temp0))
				(= cycleCnt gGameTime)
				(client cel: 0)
				(if (== endCel 0)
					(self cycleDone:)
				)
			)
			((and (== cycleDir -1) (== (client cel:) 0))
				(= cycleCnt gGameTime)
				(client cel: temp0)
				(if (== endCel temp0)
					(self cycleDone:)
				)
			)
			(else
				(client cel: (self nextCel:))
			)
		)
		(if (and (== gGameTime cycleCnt) (== endCel (client cel:)))
			(self cycleDone:)
		)
	)
)

