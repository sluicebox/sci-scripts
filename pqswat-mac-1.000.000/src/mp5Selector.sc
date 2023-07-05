;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 27)
(include sci.sh)
(use Main)
(use swatInvInit)
(use Inset)
(use Timer)
(use Actor)

(public
	mp5Selector 0
)

(local
	local0 = -1
)

(instance mp5Selector of Inset
	(properties
		picture -2
		view 14
		x 6
		y 158
		disposeNotOnMe 1
	)

	(method (doit)
		(super doit: &rest)
		(gGame setCursor: gNormalCursor)
	)

	(method (init &tmp temp0)
		(if gAutoRobot
			(gAutoRobot pause: 1)
		)
		(if global112
			(global112 pausePath: 1)
		)
		(SetFlag 119)
		(super init: &rest)
		(if (= temp0 (proc19_3 3))
			(safetySwitch cel: ((temp0 data:) weaponSetting:) init:)
		)
		(self drawInset:)
		(gSwatInterface curIcon: 0 curModeType: 0)
		(gSwatInterface setCursor:)
		(selectTimer setReal: selectTimer 5)
	)

	(method (dispose)
		(= global129 0)
		(gSwatInterface curIcon: (gSwatInterface curInvItem:))
		(gSwatInterface setCursor:)
		(if (gTimers contains: selectTimer)
			(selectTimer dispose: delete:)
		)
		(if gAutoRobot
			(gAutoRobot pause: 0)
		)
		(if global112
			(global112 pausePath: 0)
		)
		(ClearFlag 119)
		(super dispose: &rest)
	)

	(method (handleEvent event &tmp [temp0 2] temp2)
		(cond
			((and inset (inset handleEvent: event)) 0)
			((& (event type:) evVERB)
				(= local0 -1)
				(= temp2 (self onMe: event))
				(if (= temp2 (self onMe: event))
					(selectTimer setReal: selectTimer 5)
				)
				(cond
					((and temp2 (!= local0 -1))
						(event claimed: 1)
						(self doVerb: (event message:))
						(return 1)
					)
					(
						(and
							(not temp2)
							disposeNotOnMe
							(or (not gSelectorCloseCode) (gSelectorCloseCode doit:))
						)
						(event claimed: 1)
						(self dispose:)
						(return 1)
					)
					(else
						(return 0)
					)
				)
			)
		)
	)

	(method (onMe param1 &tmp temp0 temp1 temp2)
		(if (= temp0 (super onMe: param1 &rest))
			(= temp1 (param1 x:))
			(= temp2 (param1 y:))
			(cond
				((and (<= 57 temp1 191) (<= 43 temp2 53))
					(= local0 2)
				)
				((and (<= 126 temp1 147) (<= 89 temp2 97))
					(= local0 1)
				)
				((and (<= 95 temp1 116) (<= 107 temp2 116))
					(= local0 0)
				)
			)
		)
		(return temp0)
	)

	(method (doVerb &tmp temp0)
		(= temp0 ((proc19_3 3) data:))
		(temp0 weaponSetting: local0)
		(safetySwitch cel: (temp0 weaponSetting:))
		(UpdateScreenItem safetySwitch)
		(FrameOut)
	)
)

(instance safetySwitch of View
	(properties
		x 66
		y 40
		view 14
		loop 1
	)

	(method (onMe)
		(return 0)
	)
)

(instance selectTimer of Timer
	(properties)

	(method (cue)
		(if (not gSelectorCloseCode)
			(gGame panelObj: mp5Selector panelSelector: 143)
		)
	)
)

