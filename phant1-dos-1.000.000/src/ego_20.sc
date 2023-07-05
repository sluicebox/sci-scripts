;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 20)
(include sci.sh)
(use Main)
(use scaryInvInit)
(use Print)
(use Motion)
(use Actor)
(use System)

(public
	ego 0
)

(class ego of Actor
	(properties
		noun 1
		modNum 0
		view 0
		cycleSpeed 4
		moveSpeed 4
		edgeHit 0
		yMod 1
		intensity 100
		fadedY 0
		brightY 0
		fadePalette 28100
	)

	(method (init)
		(super init:)
		(|= signal $3000)
	)

	(method (setHeading param1 param2 param3 &tmp temp0 temp1)
		(gGame handsOff:)
		(= temp1 1)
		(if (>= argc 2)
			(= temp0 param2)
		else
			(= temp0 0)
		)
		(if (and (>= view 610) (<= view 617))
			(-= view 610)
		)
		(cond
			(
				(not
					(OneOf
						view
						0
						1
						2
						3
						4
						5
						6
						7
						610
						611
						612
						613
						614
						615
						616
						617
					)
				)
				(= temp1 0)
			)
			((or (> param1 337) (< param1 23))
				(= heading 0)
				(= view (+ (gCurRoom baseView:) 3 (* view 100)))
			)
			((< 22 param1 68)
				(= heading 45)
				(= view (+ (gCurRoom baseView:) 6 (* view 100)))
			)
			((< 67 param1 113)
				(= heading 90)
				(= view (+ (gCurRoom baseView:) (* view 100)))
			)
			((< 112 param1 158)
				(= heading 135)
				(= view (+ (gCurRoom baseView:) 4 (* view 100)))
			)
			((< 157 param1 203)
				(= heading 180)
				(= view (+ (gCurRoom baseView:) 2 (* view 100)))
			)
			((< 202 param1 248)
				(= heading 225)
				(= view (+ (gCurRoom baseView:) 5 (* view 100)))
			)
			((< 247 param1 293)
				(= heading 270)
				(= view (+ (gCurRoom baseView:) 1 (* view 100)))
			)
			(else
				(= heading 315)
				(= view (+ (gCurRoom baseView:) 7 (* view 100)))
			)
		)
		(cond
			((not temp1)
				(if temp0
					(temp0 cue:)
				)
			)
			((>= argc 3)
				(self cel: 0 setCycle: CT param3 1 temp0)
			)
			(else
				(self cel: 0 setCycle: End temp0)
			)
		)
		(return heading)
	)

	(method (setMotion param1)
		(if (and mover (!= mover -1))
			(mover dispose:)
		)
		(if param1
			(Printf
				{WARNING: Someone is calling ego setMotion!!\nroom: %hu\nroom script: %s}
				gCurRoomNum
				(if (gCurRoom script:)
					((gCurRoom script:) name:)
				else
					{..none..}
				)
			)
			(if (and (>= argc 4) [param1 3])
				([param1 3] cue:)
			)
		else
			(= mover 0)
		)
	)

	(method (setIntensity param1 param2)
		(cond
			((and (> argc 1) param2)
				(if (== param1 intensity)
					(return)
				else
					(= intensity param1)
					(Palette 2 55 135 intensity) ; PalIntensity
				)
			)
			((< param1 intensity)
				(Palette 2 55 135 param1) ; PalIntensity
			)
			(else
				(Palette 2 55 135 intensity) ; PalIntensity
			)
		)
	)

	(method (dispose)
		(= fadedY (= brightY 0))
		(PalVary 3) ; PalVaryKill
		(super dispose:)
	)

	(method (posn)
		(super posn: &rest)
		(self fade:)
	)

	(method (fade))

	(method (facingMe)
		(return 1)
	)

	(method (doit)
		(if robot
			(robot doit:)
		)
		(if script
			(script doit:)
		)
		(if code
			(code doit: self)
		)
		(if (& signal $0001)
			(if cycler
				(cycler doit:)
			)
			(if (& -info- $0008)
				(self fade:)
				(if scaler
					(scaler doit:)
				)
				(if (or (!= xLast x) (!= yLast y))
					(gCurRoom loadEgoViews:)
				)
				(= xLast x)
				(= yLast y)
				(if (self isNotHidden:)
					(UpdateScreenItem self)
				)
				(cond
					((not (& signal $0020)))
					(baseSetter
						(baseSetter doit: self)
					)
					(else
						(BaseSetter self)
					)
				)
			)
		)
	)

	(method (normalize param1 &tmp temp0)
		(cond
			((> argc 0)
				(= temp0 param1)
			)
			(
				(not
					(OneOf
						view
						0
						1
						2
						3
						4
						5
						6
						7
						610
						611
						612
						613
						614
						615
						616
						617
					)
				)
				(= temp0 0)
			)
			(else
				(= temp0 view)
			)
		)
		(switch temp0
			(8
				(= temp0 4)
			)
			(9
				(= temp0 5)
			)
			(10
				(= temp0 4)
			)
			(11
				(= temp0 5)
			)
			(12
				(= temp0 6)
			)
			(13
				(= temp0 7)
			)
			(14
				(= temp0 6)
			)
			(15
				(= temp0 7)
			)
			(8
				(= temp0 4)
			)
			(9
				(= temp0 5)
			)
			(10
				(= temp0 4)
			)
			(11
				(= temp0 5)
			)
			(12
				(= temp0 6)
			)
			(13
				(= temp0 7)
			)
			(14
				(= temp0 6)
			)
			(15
				(= temp0 7)
			)
			(618
				(= temp0 614)
			)
			(619
				(= temp0 615)
			)
			(620
				(= temp0 614)
			)
			(621
				(= temp0 615)
			)
			(622
				(= temp0 616)
			)
			(623
				(= temp0 617)
			)
			(624
				(= temp0 616)
			)
			(625
				(= temp0 617)
			)
		)
		(self
			view: temp0
			setLoop: -1
			loop: 0
			setPri: -1
			setMotion: 0
			setCycle: 0
			setStep: 3 1 0
			setSpeed: global158
			heading: (>> (* [global126 temp0] 45) $0001)
			state: 2
			ignoreActors: 0
		)
		(self cel: (self lastCel:))
	)

	(method (get param1 &tmp temp0 temp1)
		(for ((= temp0 0)) (< temp0 argc) ((++ temp0))
			(proc28_1 (= temp1 (gInventory at: [param1 temp0])))
			(Lock rsVIEW (temp1 view:) 1)
			(Lock rsVIEW (+ (temp1 view:) 1) 1)
		)
	)

	(method (put param1 param2 &tmp temp0)
		(if (self has: param1)
			((= temp0 (gInventory at: param1))
				moveTo: (if (== argc 1) -1 else param2)
			)
			(proc28_3 temp0)
			(Lock rsVIEW (temp0 view:) 0)
			(Lock rsVIEW (+ (temp0 view:) 1) 0)
			(if (== global161 temp0)
				(= global161 (= global118 0))
				(gUser message: (gUser dftMessage:))
				(gCurrentControl select: (gUser dftMessage:) gNormalCursor)
				(= global192 gNormalCursor)
				(if (gUser canInput:)
					(gGame setCursor: gNormalCursor 1)
				)
			)
		)
	)

	(method (has param1 &tmp temp0)
		(if (= temp0 (gInventory at: param1))
			(temp0 ownedBy: -2)
		)
	)

	(method (handleEvent event)
		(if (and script (script handleEvent: event))
		else
			(super handleEvent: event)
		)
		(event claimed:)
	)

	(method (heading2View)
		(self
			view:
				(+
					[global142
						(/ (umod (+ (<< heading $0002) 45) 1440) 90)
					]
					(gCurRoom baseView:)
				)
		)
	)
)

